package dev.thuan;

import dev.thuan.server.Server;
import dev.thuan.viewer.ConnectionDialog;
import dev.thuan.viewer.Viewer;

import javax.swing.*;
import java.awt.*;

/**
 * main.java
 */

public class Main {

    public static Config serverConfig, viewerConfig;
    public static int activeConnection = 0;

    public static void main(String[] args) {
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = g.getScreenDevices();

        for (int i = 0; i < devices.length; i++) {
            System.out.println("Width:" + devices[i].getDisplayMode().getWidth());
            System.out.println("Height:" + devices[i].getDisplayMode().getHeight());
        }

        Commons.init();
//        if (!analyseCMDArgs(args)) ;
        Settings.loadConfig();
        Settings.applyConfig(true);
    }

    public static void startServer() {
        if (serverConfig.reverseConnection)
            Viewer._Start(serverConfig);
        else
            Server.Start(serverConfig);
    }

    public static void startViewer() {
        if (viewerConfig.reverseConnection)
            new Server(viewerConfig)._Start();
        else
            new Viewer(viewerConfig).Start();
    }

    public static void updateStatus() {
        mainFrame.updateStatus();
    }

    public static void displayTab(int index) {
        mainFrame.displayTab(index);
    }

    public static void exit() {
        if (Settings.exitDisabled) {
            if (activeConnection > 0) {
                JOptionPane.showMessageDialog(null,
                        "Please close all active connections first !!",
                        "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        if (serverConfig != null && serverConfig.reverseConnection) {
            if (Viewer.isRunning())
                Viewer._Stop();
        } else {
            if (Server.isRunning())
                Server.Stop();
        }
        SystemProperties.clear();
        if (Settings.exitDisabled)
            close();
        else
            System.exit(0);
    }

    public static void close() {
        mainFrame.close();
        ConnectionDialog.close();
        DirDialog.close();
        SysTray.close();
    }

    public static void quit() {
        if (JOptionPane.showConfirmDialog(null, "Exit application ?", "Confirm Dialog",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION)
            Main.exit();
    }
}