package dev.thuan.viewer;

import java.awt.GraphicsDevice;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.InetAddress;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import dev.thuan.ChatJFrame;
import dev.thuan.Commons;
import dev.thuan.HostProperties;
import dev.thuan.Main;
import dev.thuan.rmi.server.RMIServer;
import dev.thuan.server.Server;

/**
 * ViewerGUI.java
 */

public class ViewerGUI extends javax.swing.JFrame {

    private boolean fullScreenMode = false;

    private final Recorder recorder;

    /**
     * Creates new form MainFrame
     */
    public ViewerGUI(Recorder recorder) {
        this.recorder = recorder;
        initComponents();

        jScrollPane1.setViewportView(recorder.screenPlayer);
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                System.out.println("Size Changed" + e.getComponent().getSize());
                recorder.viewerOptions.setCurrentScreenRect(jScrollPane1.getBounds());
            }
        });
        setVisible(true);
        Main.activeConnection++;
        jPopupMenuFileTranfer.setVisible(false);
        jMenuItemSendFilesFromClipbrd.setVisible(false);
        jMenuItemReceiveFilesFromClipbrd.setVisible(false);
        jPopupMenuHelp.setVisible(false);
        jMenuItemConnectInfo.setVisible(false);
        jMenuItemHostProps.setVisible(false);
        jMenuItemAbout.setVisible(false);
//        jToolBar1.setVisible(false);
        jBtnStartStop.setVisible(false);
        jToggleBtnPauseResume.setVisible(false);
//        jBtnViewCtrl.setVisible(false);
//        jSeparator1.setVisible(false);
//        jBtnFullNormal.setVisible(false);
        jBtnPartialComplete.setVisible(false);
        jSeparator9.setVisible(false);
        jSeparator4.setVisible(false);
        jSeparator15.setVisible(false);
        jSeparator11.setVisible(false);
        jLabel1.setVisible(false);
        jComboBoxColorQuality.setVisible(false);
        jSeparator14.setVisible(false);
        jLabel6.setVisible(false);
        jComboBoxRefreshRate.setVisible(false);
        jSeparator5.setVisible(false);
//        jLabel5.setVisible(false);
//        jCheckBoxClipTrans = new javax.swing.JCheckBox();
        jSeparator13.setVisible(false);
        jBtnFileTransfer.setVisible(false);
        jSeparator6.setVisible(false);
        jSeparator12.setVisible(false);
        jBtnClose.setVisible(false);
        jSeparator10.setVisible(false);
//        jScrollPane1.setVisible(false);
    }

    public void Start() {
        jBtnStartStopActionPerformed(null);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuFileTranfer = new javax.swing.JPopupMenu();
        jMenuItemSendFilesFromClipbrd = new javax.swing.JMenuItem();
        jMenuItemReceiveFilesFromClipbrd = new javax.swing.JMenuItem();
        jPopupMenuHelp = new javax.swing.JPopupMenu();
        jMenuItemConnectInfo = new javax.swing.JMenuItem();
        jMenuItemHostProps = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jBtnStartStop = new javax.swing.JButton();
        jToggleBtnPauseResume = new javax.swing.JToggleButton();
        jBtnViewCtrl = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jBtnFullNormal = new javax.swing.JButton();
        jBtnPartialComplete = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxScreenZoom = new javax.swing.JComboBox();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxScreenCompress = new javax.swing.JCheckBox();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jLabel4 = new javax.swing.JLabel();
        jCheckBoxImageQuality = new javax.swing.JCheckBox();
        jComboBoxImageQuality = new javax.swing.JComboBox();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxColorQuality = new javax.swing.JComboBox();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxRefreshRate = new javax.swing.JComboBox();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jLabel5 = new javax.swing.JLabel();
        jCheckBoxClipTrans = new javax.swing.JCheckBox();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jBtnFileTransfer = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jBtnHelp = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jBtnClose = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jLabel7 = new javax.swing.JLabel();
        jCheckBoxDrawOverlay = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();

        jMenuItemSendFilesFromClipbrd.setText("Send files from clipborad");
        jMenuItemSendFilesFromClipbrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSendFilesFromClipbrdActionPerformed(evt);
            }
        });
        jPopupMenuFileTranfer.add(jMenuItemSendFilesFromClipbrd);

        jMenuItemReceiveFilesFromClipbrd.setText("Receive files from clipboard");
        jMenuItemReceiveFilesFromClipbrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemReceiveFilesFromClipbrdActionPerformed(evt);
            }
        });
        jPopupMenuFileTranfer.add(jMenuItemReceiveFilesFromClipbrd);

        jMenuItemConnectInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/info.png"))); // NOI18N
        jMenuItemConnectInfo.setText("Connection infos");
        jMenuItemConnectInfo.setToolTipText("");
        jMenuItemConnectInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConnectInfoActionPerformed(evt);
            }
        });
        jPopupMenuHelp.add(jMenuItemConnectInfo);

        jMenuItemHostProps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/props.png"))); // NOI18N
        jMenuItemHostProps.setText("Remote host properties");
        jMenuItemHostProps.setToolTipText("");
        jMenuItemHostProps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHostPropsActionPerformed(evt);
            }
        });
        jPopupMenuHelp.add(jMenuItemHostProps);

        jMenuItemAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/about.png"))); // NOI18N
        jMenuItemAbout.setText("About dev.thuan");
        jMenuItemAbout.setToolTipText("");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        jPopupMenuHelp.add(jMenuItemAbout);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(" dev.thuan Viewer");
        setIconImage(new ImageIcon(Commons.WAIT_ICON).getImage());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
        });

        jToolBar1.setFocusable(false);
        jToolBar1.setMaximumSize(new java.awt.Dimension(713, 35));

        jBtnStartStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/player_stop.png"))); // NOI18N
        jBtnStartStop.setToolTipText("Start/Stop recording");
        jBtnStartStop.setFocusable(false);
        jBtnStartStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnStartStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnStartStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStartStopActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnStartStop);

        jToggleBtnPauseResume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/player_pause.png"))); // NOI18N
        jToggleBtnPauseResume.setToolTipText("Pause/Resume recording");
        jToggleBtnPauseResume.setFocusable(false);
        jToggleBtnPauseResume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleBtnPauseResumeActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleBtnPauseResume);

        jBtnViewCtrl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/locked_inputs.png"))); // NOI18N
        jBtnViewCtrl.setToolTipText("View only / Full control");
        jBtnViewCtrl.setFocusable(false);
        jBtnViewCtrl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnViewCtrl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnViewCtrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnViewCtrlActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnViewCtrl);
        jToolBar1.add(jSeparator1);

        jBtnFullNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/view_fullscreen.png"))); // NOI18N
        jBtnFullNormal.setToolTipText("Full / Normal screen");
        jBtnFullNormal.setFocusable(false);
        jBtnFullNormal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnFullNormal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnFullNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFullNormalActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnFullNormal);

        jBtnPartialComplete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/custom_screen.png"))); // NOI18N
        jBtnPartialComplete.setToolTipText("Custom / Default screen");
        jBtnPartialComplete.setFocusable(false);
        jBtnPartialComplete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnPartialComplete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnPartialComplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPartialCompleteActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnPartialComplete);
        jToolBar1.add(jSeparator9);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/scale.png"))); // NOI18N
        jLabel2.setText(" ");
        jLabel2.setToolTipText("Screen zoom (%)");
        jLabel2.setFocusable(false);
        jToolBar1.add(jLabel2);

        jComboBoxScreenZoom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "25", "50", "75", "100", "125", "150", "200", "0" }));
        jComboBoxScreenZoom.setToolTipText("Change screen zoom (%)");
        jComboBoxScreenZoom.setFocusable(false);
        jComboBoxScreenZoom.setMaximumSize(new java.awt.Dimension(70, 20));
        jComboBoxScreenZoom.setMinimumSize(new java.awt.Dimension(70, 20));
        jComboBoxScreenZoom.setPreferredSize(new java.awt.Dimension(70, 20));
        jComboBoxScreenZoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxScreenZoomItemStateChanged(evt);
            }
        });
        jToolBar1.add(jComboBoxScreenZoom);
        jToolBar1.add(jSeparator4);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/compress.png"))); // NOI18N
        jLabel3.setToolTipText("Screen Compression");
        jToolBar1.add(jLabel3);

        jCheckBoxScreenCompress.setSelected(true);
        jCheckBoxScreenCompress.setToolTipText("Enable/Disable Screen Compression");
        jCheckBoxScreenCompress.setFocusable(false);
        jCheckBoxScreenCompress.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBoxScreenCompress.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxScreenCompress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxScreenCompressActionPerformed(evt);
            }
        });
        jToolBar1.add(jCheckBoxScreenCompress);
        jToolBar1.add(jSeparator15);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/jpeg.png"))); // NOI18N
        jLabel4.setToolTipText("JPEG image quality");
        jLabel4.setFocusable(false);
        jToolBar1.add(jLabel4);

        jCheckBoxImageQuality.setToolTipText("Enable/Disable JPEG image quality");
        jCheckBoxImageQuality.setFocusable(false);
        jCheckBoxImageQuality.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jCheckBoxImageQuality.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxImageQuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxImageQualityActionPerformed(evt);
            }
        });
        jToolBar1.add(jCheckBoxImageQuality);

        jComboBoxImageQuality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "25", "33", "50", "66", "75", "100" }));
        jComboBoxImageQuality.setSelectedIndex(5);
        jComboBoxImageQuality.setToolTipText("Change image quality (%)");
        jComboBoxImageQuality.setEnabled(false);
        jComboBoxImageQuality.setFocusable(false);
        jComboBoxImageQuality.setMaximumSize(new java.awt.Dimension(65, 20));
        jComboBoxImageQuality.setMinimumSize(new java.awt.Dimension(65, 20));
        jComboBoxImageQuality.setPreferredSize(new java.awt.Dimension(65, 20));
        jComboBoxImageQuality.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxImageQualityItemStateChanged(evt);
            }
        });
        jToolBar1.add(jComboBoxImageQuality);
        jToolBar1.add(jSeparator11);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/colors.png"))); // NOI18N
        jLabel1.setText(" ");
        jLabel1.setToolTipText("Color quality");
        jLabel1.setFocusable(false);
        jToolBar1.add(jLabel1);

        jComboBoxColorQuality.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "High", "Medium", "Low", "Gray" }));
        jComboBoxColorQuality.setToolTipText("Change color quality");
        jComboBoxColorQuality.setFocusable(false);
        jComboBoxColorQuality.setLightWeightPopupEnabled(false);
        jComboBoxColorQuality.setMaximumSize(new java.awt.Dimension(85, 20));
        jComboBoxColorQuality.setMinimumSize(new java.awt.Dimension(85, 20));
        jComboBoxColorQuality.setPreferredSize(new java.awt.Dimension(85, 20));
        jComboBoxColorQuality.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxColorQualityItemStateChanged(evt);
            }
        });
        jToolBar1.add(jComboBoxColorQuality);
        jToolBar1.add(jSeparator14);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/delay.png"))); // NOI18N
        jLabel6.setToolTipText("Refresh rate (ms)");
        jToolBar1.add(jLabel6);

        jComboBoxRefreshRate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "250", "500", "750", "1000", "3000", "6000", "9000" }));
        jComboBoxRefreshRate.setSelectedIndex(2);
        jComboBoxRefreshRate.setToolTipText("Change screen refresh rate");
        jComboBoxRefreshRate.setFocusable(false);
        jComboBoxRefreshRate.setMaximumSize(new java.awt.Dimension(70, 20));
        jComboBoxRefreshRate.setMinimumSize(new java.awt.Dimension(70, 20));
        jComboBoxRefreshRate.setPreferredSize(new java.awt.Dimension(70, 20));
        jComboBoxRefreshRate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxRefreshRateItemStateChanged(evt);
            }
        });
        jToolBar1.add(jComboBoxRefreshRate);
        jToolBar1.add(jSeparator5);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/clip_trans.png"))); // NOI18N
        jLabel5.setToolTipText("Clipboard tranfer");
        jLabel5.setFocusable(false);
        jToolBar1.add(jLabel5);

        jCheckBoxClipTrans.setSelected(true);
        jCheckBoxClipTrans.setToolTipText("Enable/Disable Clipboard transfer");
        jCheckBoxClipTrans.setFocusable(false);
        jCheckBoxClipTrans.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jCheckBoxClipTrans.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxClipTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxClipTransActionPerformed(evt);
            }
        });
        jToolBar1.add(jCheckBoxClipTrans);
        jToolBar1.add(jSeparator13);

        jBtnFileTransfer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/file_trans.png"))); // NOI18N
        jBtnFileTransfer.setToolTipText("File transfer");
        jBtnFileTransfer.setFocusable(false);
        jBtnFileTransfer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnFileTransfer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnFileTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFileTransferActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnFileTransfer);
        jToolBar1.add(jSeparator6);

        jBtnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/help.png"))); // NOI18N
        jBtnHelp.setToolTipText("Help");
        jBtnHelp.setFocusable(false);
        jBtnHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnHelp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnHelpActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnHelp);
        jToolBar1.add(jSeparator12);

        jBtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/exit.png"))); // NOI18N
        jBtnClose.setToolTipText("Exit viewer");
        jBtnClose.setFocusable(false);
        jBtnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCloseActionPerformed(evt);
            }
        });
        jToolBar1.add(jBtnClose);
        jToolBar1.add(jSeparator10);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/background.png"))); // NOI18N
        jLabel7.setToolTipText("Draw over screen");
        jToolBar1.add(jLabel7);

        jCheckBoxDrawOverlay.setFocusable(false);
        jCheckBoxDrawOverlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jCheckBoxDrawOverlay.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jCheckBoxDrawOverlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDrawOverlayActionPerformed(evt);
            }
        });
        jToolBar1.add(jCheckBoxDrawOverlay);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
            .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(828, 450));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnStartStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStartStopActionPerformed
        if (recorder.isRecording())
            recorder.Stop();
        else
            recorder.Start();

        if (recorder.isRecording()) {
            setIconImage(new ImageIcon(Commons.ALIVE_ICON).getImage());
            jBtnStartStop.setIcon(new ImageIcon(Commons.STOP_ICON));
            setTitle("noRoom2013 Viewer [" + recorder.config.server_address + "]");
        } else {
            setTitle("noRoom2013 Viewer");
            setIconImage(new ImageIcon(Commons.WAIT_ICON).getImage());
            jBtnStartStop.setIcon(new ImageIcon(Commons.START_ICON));
            jToggleBtnPauseResume.setSelected(false);
            jBtnViewCtrl.setIcon(new ImageIcon(Commons.LOCKED_INPUTS_ICON));
            jBtnFullNormal.setIcon(new ImageIcon(Commons.FULL_SCREEN_ICON));
            jBtnPartialComplete.setIcon(new ImageIcon(Commons.CUSTOM_SCREEN_ICON));
        }
    }//GEN-LAST:event_jBtnStartStopActionPerformed

    private void jBtnViewCtrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnViewCtrlActionPerformed
        recorder.setViewOnly(!recorder.isViewOnly());
        if (recorder.isViewOnly())
            jBtnViewCtrl.setIcon(new ImageIcon(Commons.INPUTS_ICON));
        else
            jBtnViewCtrl.setIcon(new ImageIcon(Commons.LOCKED_INPUTS_ICON));
    }//GEN-LAST:event_jBtnViewCtrlActionPerformed

    private void jBtnFullNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFullNormalActionPerformed
        changeFullScreenMode();
    }//GEN-LAST:event_jBtnFullNormalActionPerformed

    private void jBtnPartialCompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPartialCompleteActionPerformed
        if (recorder.isRecording()) {
            if (recorder.screenPlayer.isPartialScreenMode()) {
                jBtnPartialComplete.setIcon(new ImageIcon(Commons.CUSTOM_SCREEN_ICON));
                recorder.screenPlayer.stopSelectingMode();
            } else
                recorder.screenPlayer.startSelectingMode();
        }
    }//GEN-LAST:event_jBtnPartialCompleteActionPerformed

    private void jCheckBoxImageQualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxImageQualityActionPerformed
        jComboBoxImageQuality.setEnabled(jCheckBoxImageQuality.isSelected());
        if (!jCheckBoxImageQuality.isSelected())
            recorder.viewerOptions.setImageQuality(-1);
        else
            recorder.viewerOptions.setImageQuality(
                    Float.valueOf(jComboBoxImageQuality.getSelectedItem().toString()) / 100.0f);
        if (recorder.isRecording()) {
            if (recorder.config.reverseConnection)
                recorder.viewerOptions.setChanged(true);
            else
                recorder.viewer.setOption(Commons.IMAGE_OPTION);
        }
    }//GEN-LAST:event_jCheckBoxImageQualityActionPerformed

    private void jComboBoxColorQualityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxColorQualityItemStateChanged
        setColorQuality(jComboBoxColorQuality.getSelectedIndex());
    }//GEN-LAST:event_jComboBoxColorQualityItemStateChanged

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (evt.getID() == WindowEvent.WINDOW_CLOSING)
            jBtnCloseActionPerformed(null);
        else
            super.processWindowEvent(evt);
    }//GEN-LAST:event_formWindowClosing

    private void jCheckBoxClipTransActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxClipTransActionPerformed
        setClipboardTransfer(jCheckBoxClipTrans.isSelected());
    }//GEN-LAST:event_jCheckBoxClipTransActionPerformed

    private void jBtnFileTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFileTransferActionPerformed
        jPopupMenuFileTranfer.show(jBtnFileTransfer, 15, 15);
    }//GEN-LAST:event_jBtnFileTransferActionPerformed

    private void jMenuItemSendFilesFromClipbrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSendFilesFromClipbrdActionPerformed
        if (!recorder.isRecording()) return;
        File[] files = recorder.clipbrdUtility.getFiles();
        if (files.length == 0) { // no files in clipboard, return
            JOptionPane.showMessageDialog(ViewerGUI.this, "No file in clipboard !!",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        recorder.fileManager.setFiles(files);
        recorder.viewer.SendFiles();
    }//GEN-LAST:event_jMenuItemSendFilesFromClipbrdActionPerformed

    private void jMenuItemReceiveFilesFromClipbrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemReceiveFilesFromClipbrdActionPerformed
        if (!recorder.isRecording()) return;
        recorder.viewer.ReceiveFiles();
    }//GEN-LAST:event_jMenuItemReceiveFilesFromClipbrdActionPerformed

    private void jToggleBtnPauseResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleBtnPauseResumeActionPerformed
        if (recorder.isRecording()) {
            recorder.setPause(!recorder.isPaused());
            jToggleBtnPauseResume.setSelected(recorder.isPaused());
        }
    }//GEN-LAST:event_jToggleBtnPauseResumeActionPerformed

    private void jBtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCloseActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Exit Viewer ?", "Confirm Dialog",
                JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            recorder.terminate();
            dispose();
            Main.activeConnection--;
            Main.displayTab(0);
        }
    }//GEN-LAST:event_jBtnCloseActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO: 11/18/2023
//        if (recorder.viewerOptions.getClipboardTransfer())
//            recorder.clipbrdUtility.addFlavorListener();
        if (recorder.isRecording() && !recorder.isPaused() && !recorder.isViewOnly())
            recorder.eventsListener.addAdapters();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // TODO: 11/18/2023
//        if (recorder.viewerOptions.getClipboardTransfer())
//            recorder.clipbrdUtility.removeFlavorListener();
        recorder.eventsListener.removeAdapters();
    }//GEN-LAST:event_formWindowDeactivated

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        if (recorder.isRecording())
            recorder.setHold(true);
    }//GEN-LAST:event_formWindowIconified

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
        if (recorder.isRecording())
            recorder.setHold(false);
        recorder.Notify();
    }//GEN-LAST:event_formWindowDeiconified

    private void jCheckBoxScreenCompressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxScreenCompressActionPerformed
        recorder.viewerOptions.setScreenCompression(jCheckBoxScreenCompress.isSelected());
    }//GEN-LAST:event_jCheckBoxScreenCompressActionPerformed

    private void jComboBoxRefreshRateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxRefreshRateItemStateChanged
        recorder.viewerOptions.setRefreshRate(
                Integer.valueOf(jComboBoxRefreshRate.getSelectedItem().toString()));
    }//GEN-LAST:event_jComboBoxRefreshRateItemStateChanged

    private void jComboBoxImageQualityItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxImageQualityItemStateChanged
        recorder.viewerOptions.setImageQuality(
                Float.valueOf(jComboBoxImageQuality.getSelectedItem().toString()) / 100.0f);
        if (recorder.isRecording()) {
            if (recorder.config.reverseConnection)
                recorder.viewerOptions.setChanged(true);
            else
                recorder.viewer.setOption(Commons.IMAGE_OPTION);
        }
    }//GEN-LAST:event_jComboBoxImageQualityItemStateChanged

    private void jComboBoxScreenZoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxScreenZoomItemStateChanged
        recorder.viewerOptions.setScreenScale(
                Float.valueOf(jComboBoxScreenZoom.getSelectedItem().toString()) / 100.0f);
    }//GEN-LAST:event_jComboBoxScreenZoomItemStateChanged

    private void jBtnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnHelpActionPerformed
//        jPopupMenuHelp.show(jBtnHelp, 15, 15);
        ChatJFrame chatJPanel = new ChatJFrame(recorder);
        System.out.println("ChatJPanel created");
        chatJPanel.setVisible(true);
    }//GEN-LAST:event_jBtnHelpActionPerformed

    private void jMenuItemConnectInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConnectInfoActionPerformed
        if (!recorder.isRecording()) return;
        if (recorder.config.reverseConnection)
            recorder.viewerOptions.connectionInfos.display();
        else
            recorder.viewer.getConnectionInfos();
    }//GEN-LAST:event_jMenuItemConnectInfoActionPerformed

    private void jMenuItemHostPropsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHostPropsActionPerformed
        if (!recorder.isRecording()) return;
        if (recorder.config.reverseConnection)
            HostProperties.display(recorder.viewerOptions.getProperties());
        else
            recorder.viewer.getHostProperties();
    }//GEN-LAST:event_jMenuItemHostPropsActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
        Main.displayTab(4);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jCheckBoxDrawOverlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDrawOverlayActionPerformed
        setDrawOverlay(jCheckBoxDrawOverlay.isSelected());
    }//GEN-LAST:event_jCheckBoxDrawOverlayActionPerformed

    public boolean isFullScreenMode() {
        return fullScreenMode;
    }

    public void changeFullScreenMode() {
        GraphicsDevice device = getGraphicsConfiguration().getDevice();
        if (!device.isFullScreenSupported()) return;

        fullScreenMode = !fullScreenMode;

        dispose();
        if (fullScreenMode) {  // Full screen mode
            setUndecorated(true);
            device.setFullScreenWindow(this);
            jBtnFullNormal.setIcon(new ImageIcon(Commons.NORMAL_SCREEN_ICON));
        } else {     // Normal screen mode
            setUndecorated(false);
            device.setFullScreenWindow(null);
            jBtnFullNormal.setIcon(new ImageIcon(Commons.FULL_SCREEN_ICON));
        }
        setVisible(true);
    }

    public void setColorQuality(int index) {
        byte colorQuality = Commons.defaultColorQuality;
        switch (index) {
            case 0:
                colorQuality = Commons.cqFull;
                break;
            case 1:
                colorQuality = Commons.cq16Bit;
                break;
            case 2:
                colorQuality = Commons.cq256;
                break;
            case 3:
                colorQuality = Commons.cqGray;
                break;
        }
        recorder.viewerOptions.setColorQuality(colorQuality);
//        if (recorder.isRecording()) {
//            if (recorder.config.reverseConnection)
//                recorder.viewerOptions.setChanged(true);
//            else
//                recorder.viewer.setOption(Commons.COLOR_OPTION);
//        }
    }

    public void setClipboardTransfer(boolean bool) {
        recorder.viewerOptions.setClipboardTransfer(bool);
        // TODO: 11/18/2023
//        if (bool)
//            recorder.clipbrdUtility.addFlavorListener();
//        else
//            recorder.clipbrdUtility.removeFlavorListener();
//        if (recorder.isRecording()) {
//            if (recorder.config.reverseConnection)
//                recorder.viewerOptions.setChanged(true);
//            else
//                recorder.viewer.setOption(Commons.CLIPBOARD_OPTION);
//        }
    }


    public void setDrawOverlay(boolean bool) {
        recorder.screenPlayer.setDrawOverlay(bool);
        recorder.viewerOptions.setDrawOverlay(bool);
//        if (recorder.isRecording()) {
//            if (recorder.config.reverseConnection)
//                recorder.viewerOptions.setChanged(true);
//            else
//                recorder.viewer.setOption(Commons.OVERLAY_OPTION);
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnClose;
    private javax.swing.JButton jBtnFileTransfer;
    private javax.swing.JButton jBtnFullNormal;
    private javax.swing.JButton jBtnHelp;
    public javax.swing.JButton jBtnPartialComplete;
    private javax.swing.JButton jBtnStartStop;
    private javax.swing.JButton jBtnViewCtrl;
    private javax.swing.JCheckBox jCheckBoxClipTrans;
    private javax.swing.JCheckBox jCheckBoxDrawOverlay;
    private javax.swing.JCheckBox jCheckBoxImageQuality;
    private javax.swing.JCheckBox jCheckBoxScreenCompress;
    private javax.swing.JComboBox jComboBoxColorQuality;
    private javax.swing.JComboBox jComboBoxImageQuality;
    private javax.swing.JComboBox jComboBoxRefreshRate;
    private javax.swing.JComboBox jComboBoxScreenZoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemConnectInfo;
    private javax.swing.JMenuItem jMenuItemHostProps;
    private javax.swing.JMenuItem jMenuItemReceiveFilesFromClipbrd;
    private javax.swing.JMenuItem jMenuItemSendFilesFromClipbrd;
    private javax.swing.JPopupMenu jPopupMenuFileTranfer;
    private javax.swing.JPopupMenu jPopupMenuHelp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToggleButton jToggleBtnPauseResume;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

}
