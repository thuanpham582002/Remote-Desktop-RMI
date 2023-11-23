package dev.thuan;

import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;

import dev.thuan.server.ActiveConnectionsJPanel;
import dev.thuan.server.ConfigJPanel;
import dev.thuan.server.Server;

/**
 * mainFrame.java
 */
public class mainFrame extends javax.swing.JFrame {

    private static mainFrame frame;
    private static boolean visible = false;

    private static HomeJPanel hjp;
    private static ConfigJPanel cjp;
    private static ActiveConnectionsJPanel acjp;
    private static SettingsJPanel sjp;
    private static AboutJPanel ajp;

    /**
     * Creates new form ServerGUI
     */
    public mainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Home - noRoom2013 " + Commons.noRoom2013_version);
        setIconImage(new ImageIcon(Commons.IDLE_ICON).getImage());
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        hjp = new HomeJPanel();
        cjp = new ConfigJPanel();
        acjp = new ActiveConnectionsJPanel();
        sjp = new SettingsJPanel();
        ajp = new AboutJPanel();

        jTabbedPane.addTab("Home", new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/gohome.png")), hjp);
        jTabbedPane.addTab("Config", new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/configure.png")), cjp);
        jTabbedPane.addTab("Connections", new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/connect_established.png")), acjp);
        jTabbedPane.addTab("Settings", new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/settings.png")), sjp);
//        jTabbedPane.addTab("About", new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/about.png")), ajp);

        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jTabbedPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 530) / 2, (screenSize.height - 344) / 2, 530, 344);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (evt.getID() == WindowEvent.WINDOW_CLOSING) {
            if (!Server.isRunning() && (!SysTray.isEnabled() || !SysTray.isSupported()))
                Main.quit();
            else
                close();
        } else
            super.processWindowEvent(evt);
    }//GEN-LAST:event_formWindowClosing

    private void jTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneStateChanged
        switch (jTabbedPane.getSelectedIndex()) {
            case 0:
                hjp.updateStatus();
                break;
            case 2:
                acjp.updateList();
                break;
        }

        frame.setTitle(jTabbedPane.getTitleAt(jTabbedPane.getSelectedIndex()) +
                " - noRoom2013 " + Commons.noRoom2013_version);
    }//GEN-LAST:event_jTabbedPaneStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (Settings.displayMode == Commons.DISPLAY_MODE_APPLET) return;
        if (visible) return;

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame = new mainFrame();
                mainFrame.displayTab(0);
            }
        });
    }

    public static void displayTab(int index) {
        visible = true;
        frame.setVisible(true);
        frame.jTabbedPane.setSelectedIndex(index);
        frame.toFront();
    }

    public static void close() {
        visible = false;
        frame.dispose();
    }

    public static void updateStatus() {
        if (!visible) return;
        hjp.updateStatus();
    }

    public static boolean isDisplayed() {
        return visible;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane;
    // End of variables declaration//GEN-END:variables
}
