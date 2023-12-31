package dev.thuan.rmi.client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.swing.JOptionPane;

import dev.thuan.Commons;
import dev.thuan.rmi.server.ServerInterface;
import dev.thuan.utilities.FileUtility;
import dev.thuan.Config;
import dev.thuan.Settings;
import dev.thuan.SystemProperties;
import dev.thuan.utilities.InetAdrUtility;
import dev.thuan.utilities.PasswordUtility;

/**
 * RMIClient.java
 */

public class RMIClient {

    public Config clientConfig;
    private Registry registry;
    public ServerInterface rmiServer;

    private int index = -1;
    private boolean connected = false;

    public RMIClient(Config config) {
        clientConfig = config;
        if (clientConfig.ssl_enabled) {
            FileUtility.extractFile(Settings.keyStore);
            FileUtility.extractFile(Settings.trustStore);
            SystemProperties.setSSLProps();
        } else
            SystemProperties.clearSSLProps();
    }

    public boolean isConnected() {
        return connected;
    }

    public void Start() {
        connect();
        if (!connected)
            disconnect();
    }

    public int connect() {
        connected = false;

        try {
            registry = LocateRegistry.getRegistry(clientConfig.server_address,
                    clientConfig.server_port);

            rmiServer = (ServerInterface) registry.lookup(Commons.rmiBindingName);

           /* rmiServer = (ServerInterface) Naming.lookup(
                    "rmi://" + clientConfig.server_address + ":" +
                   clientConfig.server_port + "/noRoom2013");*/

            index = rmiServer.startViewer(InetAdrUtility.getLocalHost(),
                    clientConfig.username,
                    PasswordUtility.encodeString(clientConfig.password),
                    clientConfig.reverseConnection);

            switch (index) {
                case -1:
                    JOptionPane.showMessageDialog(null, "Authentication failed !!",
                            "Error !!", JOptionPane.ERROR_MESSAGE);
                    return -1;
                case -2:
                    JOptionPane.showMessageDialog(null, "Reverse connection failed !!",
                            "Error !!", JOptionPane.ERROR_MESSAGE);
                    return -1;
            }

            displayStatus();
            connected = true;
            return index;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error !!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    public void disconnect() {
        connected = false;
        try {
            if (rmiServer != null && index > -1) {
                rmiServer.stopViewer(index);
                //UnicastRemoteObject.unexportObject(rmiServer, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        rmiServer = null;
        registry = null;
    }

    public void displayStatus() {
        boolean auth = (clientConfig.username.length() != 0) ||
                (clientConfig.password.length() != 0);
        System.out.println("Viewer connected to " + rmiServer +
                "\n\tauthentication: " + (auth ? "enabled" : "desabled") +
                "\n\tencryption: " + (clientConfig.ssl_enabled ? "enabled" : "desabled") +
                "\n\treverse connection: " +
                (clientConfig.reverseConnection ? "enabled" : "disabled"));
    }
}
