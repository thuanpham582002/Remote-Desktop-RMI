/*
 * SettingsJPanel.java
 */

package dev.thuan;

import java.io.File;
import javax.swing.JOptionPane;

import dev.thuan.utilities.FileUtility;
import dev.thuan.utilities.LookAndFeelUtility;

/**
 *
 */
public class SettingsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SettingsJPanel
     */
    public SettingsJPanel() {
        initComponents();
        jComboBoxLAF.setSelectedItem(Settings.lookAndFeel);
        jPanel2.setVisible(false);
        jPanel1.setVisible(false);
        jButtonClear.setVisible(false);
    }

    public static void setDownloadDir(String path) {
        jTextFieldDownloadDir.setText(path);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonClear = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jCheckBoxWindow = new javax.swing.JCheckBox();
        jCheckBoxTrayicon = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxLAF = new javax.swing.JComboBox(LookAndFeelUtility.getLAFs());
        jCheckBoxSysExit = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jCheckBoxProxy = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldProxyServer = new javax.swing.JTextField();
        jTextFieldProxyPort = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldDownloadDir = new javax.swing.JTextField();
        jButtonBrowse = new javax.swing.JButton();

        jButtonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/history_clear.png"))); // NOI18N
        jButtonClear.setText("Clear configuration files");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Display"));

        jCheckBoxWindow.setSelected(dev.thuan.Settings.guiDisabled);
        jCheckBoxWindow.setText("Hide Main windows.");

        jCheckBoxTrayicon.setSelected(dev.thuan.Settings.systrayDisabled);
        jCheckBoxTrayicon.setText("Hide System tray icon.");

        jLabel3.setText("Theme");

        jComboBoxLAF.setSelectedItem(Settings.lookAndFeel);

        jCheckBoxSysExit.setSelected(dev.thuan.Settings.exitDisabled);
        jCheckBoxSysExit.setText("Disable system exit.");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jCheckBoxTrayicon)
                                                        .add(jCheckBoxWindow)
                                                        .add(jPanel1Layout.createSequentialGroup()
                                                                .add(jLabel3)
                                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                                .add(jComboBoxLAF, 0, 90, Short.MAX_VALUE)))
                                                .addContainerGap(21, Short.MAX_VALUE))
                                        .add(jPanel1Layout.createSequentialGroup()
                                                .add(jCheckBoxSysExit)
                                                .addContainerGap(34, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel1Layout.createSequentialGroup()
                                .add(jCheckBoxWindow)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jCheckBoxTrayicon)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jCheckBoxSysExit)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jComboBoxLAF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jLabel3))
                                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Proxy"));

        jCheckBoxProxy.setText("Manual configuration");
        jCheckBoxProxy.setSelected(dev.thuan.Settings.proxyManual);
        jCheckBoxProxy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxProxyActionPerformed(evt);
            }
        });

        jLabel1.setText("Server");

        jTextFieldProxyServer.setText(Settings.proxyServer);
        jTextFieldProxyServer.setEnabled(Settings.proxyManual);

        jTextFieldProxyPort.setText(String.valueOf(Settings.proxyPort));
        jTextFieldProxyPort.setEnabled(Settings.proxyManual);

        jLabel2.setText("Port");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jCheckBoxProxy)
                                        .add(jPanel2Layout.createSequentialGroup()
                                                .add(4, 4, 4)
                                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jLabel1)
                                                        .add(jLabel2))
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                        .add(jTextFieldProxyServer, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                                        .add(jTextFieldProxyPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel2Layout.createSequentialGroup()
                                .add(jCheckBoxProxy)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel1)
                                        .add(jTextFieldProxyServer, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel2)
                                        .add(jTextFieldProxyPort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/ok.png"))); // NOI18N
        jButtonOK.setText("Apply");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Downloads location"));

        jTextFieldDownloadDir.setText(Settings.downloadsDir);
        jTextFieldDownloadDir.setMaximumSize(new java.awt.Dimension(69, 20));
        jTextFieldDownloadDir.setMinimumSize(new java.awt.Dimension(69, 20));
        jTextFieldDownloadDir.setPreferredSize(new java.awt.Dimension(69, 20));

        jButtonBrowse.setText("...");
        jButtonBrowse.setMaximumSize(new java.awt.Dimension(21, 28));
        jButtonBrowse.setMinimumSize(new java.awt.Dimension(21, 28));
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jTextFieldDownloadDir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 272, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButtonBrowse, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jPanel3Layout.createSequentialGroup()
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jTextFieldDownloadDir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(jButtonBrowse, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(layout.createSequentialGroup()
                                                .add(jButtonClear)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(jButtonOK))
                                        .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(layout.createSequentialGroup()
                                                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jButtonClear)
                                        .add(jButtonOK))
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        String[] files = FileUtility.getConfigFiles();
        if (files.length == 0) return;

        if (JOptionPane.showConfirmDialog(this, "Delete configuration files ?",
                "Confirm Dialog", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.CANCEL_OPTION) return;

        for (int i = 0; i < files.length; i++)
            new File(Settings.home + files[i]).delete();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jCheckBoxProxyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxProxyActionPerformed
        jTextFieldProxyServer.setEnabled(jCheckBoxProxy.isSelected());
        jTextFieldProxyPort.setEnabled(jCheckBoxProxy.isSelected());
    }//GEN-LAST:event_jCheckBoxProxyActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        Settings.setConfig(
                jCheckBoxWindow.isSelected(),
                jCheckBoxTrayicon.isSelected(),
                jCheckBoxSysExit.isSelected(),
                jCheckBoxProxy.isSelected(),
                jTextFieldProxyServer.getText(),
                Integer.valueOf(jTextFieldProxyPort.getText()),
                jTextFieldDownloadDir.getText(),
                jComboBoxLAF.getSelectedItem().toString());
        Settings.applyConfig(false);
        Main.displayTab(0);
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        DirDialog.main(null);
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JCheckBox jCheckBoxProxy;
    private javax.swing.JCheckBox jCheckBoxSysExit;
    private javax.swing.JCheckBox jCheckBoxTrayicon;
    private javax.swing.JCheckBox jCheckBoxWindow;
    private javax.swing.JComboBox jComboBoxLAF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JTextField jTextFieldDownloadDir;
    private javax.swing.JTextField jTextFieldProxyPort;
    private javax.swing.JTextField jTextFieldProxyServer;
    // End of variables declaration//GEN-END:variables

}
