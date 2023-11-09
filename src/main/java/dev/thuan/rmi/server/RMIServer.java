package dev.thuan.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JOptionPane;

import dev.thuan.Commons;
import dev.thuan.SystemProperties;
import dev.thuan.Config;

/**
 * RMIServer.java
 */

public class RMIServer {

    private static Registry registry;
    private static ServerImpl serverImpl;
    public static Config serverConfig = new Config(Commons.serverSide, "");

    public static boolean Start(Config config) {
        serverConfig = config;
        return Start();
    }

    public static boolean Start() {
        SystemProperties.clearSSLProps();

        if (serverConfig.default_address)
            SystemProperties.setDefaultAdr(serverConfig.server_address);
        else
            SystemProperties.clearDefaultAdr();

        try {
            registry = LocateRegistry.createRegistry(serverConfig.server_port);

            serverImpl = new ServerImpl(serverConfig.server_port);

            System.out.println(serverImpl);

            registry.rebind(Commons.rmiBindingName, serverImpl);
            
          /* Naming.rebind("rmi://" + serverConfig.server_address + ":" +
                   serverConfig.server_port + "/noRoom2013", (ServerInterface) serverImpl);*/
            // }  catch (ExportException ee) {
            // registry already exists, we'll just use it.
        } catch (Exception e) {
            Stop();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error !!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        System.out.println(getStatus());
        return true;
    }

    public static void Stop() {
        try {
            if (registry != null) {
                UnicastRemoteObject.unexportObject(registry, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        registry = null;
        serverImpl = null;
    }

    public static String getStatus() {
        boolean auth = (serverConfig.username.length() != 0) ||
                (serverConfig.password.length() != 0);
        String status = "Running ..." +
                "\nat: " + serverConfig.server_address + ":" + serverConfig.server_port
//                +
//                "\nauthentication: " + (auth ? "enabled" : "disabled")
//                +
//                "\nencryption: " +
//                (serverConfig.ssl_enabled ? "enabled" : "disabled") +
//                "\nmultihomed: " +
//                (serverConfig.multihomed_enabled ? "enabled" : "disabled") +
//                "\nreverse connection: " +
//                (serverConfig.reverseConnection ? "enabled" : "disabled")
                ;
        return status;
    }
}
