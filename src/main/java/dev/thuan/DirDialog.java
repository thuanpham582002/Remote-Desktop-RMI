/*
 * DirDialog.java
 *
 * Created on May 22, 2009, 10:03 AM
 */
package dev.thuan;

import java.io.File;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 */
public class DirDialog extends javax.swing.JDialog {

    private static boolean visible;
    private static DirDialog dialog;

    private DefaultMutableTreeNode parentNode = null;
    private String selectedFolder;

    /**
     * Creates new form DirDialog
     */
    public DirDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFolder = new javax.swing.JTextField();
        jButtonCancel = new javax.swing.JButton();
        jButtonOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Browse For Folder");
        setResizable(false);

        jLabel1.setText("Select a folder where you want to store downloaded files:");

        jTree.setAutoscrolls(true);
        jTree.addTreeWillExpandListener(new javax.swing.event.TreeWillExpandListener() {
            public void treeWillExpand(javax.swing.event.TreeExpansionEvent evt) throws javax.swing.tree.ExpandVetoException {
                jTreeTreeWillExpand(evt);
            }

            public void treeWillCollapse(javax.swing.event.TreeExpansionEvent evt) throws javax.swing.tree.ExpandVetoException {
            }
        });
        jTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree);

        jLabel2.setText("Folder:");

        jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/no.png"))); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jButtonOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/thuan/images/ok.png"))); // NOI18N
        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                .add(jButtonCancel)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jButtonOK))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                                .add(jLabel2)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jTextFieldFolder, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 238, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel2)
                                        .add(jTextFieldFolder, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jButtonOK)
                                        .add(jButtonCancel))
                                .addContainerGap(22, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 435) / 2, (screenSize.height - 382) / 2, 435, 382);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        if (!new File(jTextFieldFolder.getText()).isDirectory()) {
            JOptionPane.showMessageDialog(this, "Path does not exists or not a directory !!");
            return;
        }

        if (!new File(jTextFieldFolder.getText()).canWrite()) {
            JOptionPane.showMessageDialog(this, "Can't write to the specific location !!");
            return;
        }

        SettingsJPanel.setDownloadDir(jTextFieldFolder.getText());
        dispose();
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTreeValueChanged
        selectedFolder = getPath(evt.getPath().getPath());
        jTextFieldFolder.setText(selectedFolder);
    }//GEN-LAST:event_jTreeValueChanged

    private void jTreeTreeWillExpand(javax.swing.event.TreeExpansionEvent evt) throws javax.swing.tree.ExpandVetoException {//GEN-FIRST:event_jTreeTreeWillExpand

        /* DefaultMutableTreeNode parentNode = null;
          TreePath parentPath = jTree.getSelectionPath();
         if (parentPath == null)
                parentNode = nodeRoots;
        */
        parentNode = (DefaultMutableTreeNode) evt.getPath().getLastPathComponent();

        selectedFolder = getPath(evt.getPath().getPath());

        // parentNode.removeAllChildren();

        expandNode();
    }//GEN-LAST:event_jTreeTreeWillExpand

    public void init() {
        DefaultMutableTreeNode nodeRoots =
                new DefaultMutableTreeNode("My Computer");
        DefaultTreeModel modelRoots = new DefaultTreeModel(nodeRoots, true);

        File[] drives = File.listRoots();
        DefaultMutableTreeNode[] nodeDrives =
                new DefaultMutableTreeNode[drives.length];

        for (int i = 0; i < drives.length; ++i) {
            nodeDrives[i] = new DefaultMutableTreeNode(drives[i]);
            nodeRoots.add(nodeDrives[i]);
        }
        jTree.setModel(modelRoots);
    }

    private void expandNode() {
        File[] childFiles = new File(selectedFolder).listFiles();

        if (childFiles == null) return;
        Arrays.sort(childFiles);

        for (int i = 0; i < childFiles.length; ++i)
            if (childFiles[i].isDirectory())
                parentNode.add(
                        new DefaultMutableTreeNode(childFiles[i].getName()));
    }

    public String getPath(Object[] path) {
        String fullPath = "";
        for (int i = 1; i < path.length; i++) {
            fullPath += path[i].toString();
            if (!fullPath.endsWith(File.separator)) {
                fullPath += File.separator;
            }
        }
        return fullPath;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                dialog = new DirDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        close();
                    }
                });
                dialog.setVisible(true);
                visible = true;
            }
        });
    }

    public static void close() {
        if (visible) {
            dialog.dispose();
            visible = false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldFolder;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables
}
