package iiitbEarsEditor.View;

import iiitbEarsEditor.Controller.Controller;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import test.JButtonTableExample;

/**
 * /**
 *
 * @author michael
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     */
    //used to keep track of the number of tabs
    public int countPanel = 1;
    public String filename = new String();
    public static String dirPath; 
    public MainUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        new_req = new javax.swing.JButton();
        del_req = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        file_menu = new javax.swing.JMenu();
        new_FileMenu = new javax.swing.JMenuItem();
        open_FileMenu = new javax.swing.JMenuItem();
        save_FileMenu = new javax.swing.JMenuItem();
        saveAs_FileMenu = new javax.swing.JMenuItem();
        close_FileMenu = new javax.swing.JMenuItem();
        exit_FileMenu = new javax.swing.JMenuItem();
        edit_menu = new javax.swing.JMenu();
        tools_menu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar2.setRollover(true);

        new_req.setText("New Requirement");
        new_req.setFocusable(false);
        new_req.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        new_req.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        new_req.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_reqActionPerformed(evt);
            }
        });
        jToolBar2.add(new_req);

        del_req.setText("Delete Requirement");
        del_req.setFocusable(false);
        del_req.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        del_req.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        del_req.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_reqActionPerformed(evt);
            }
        });
        jToolBar2.add(del_req);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Navigation", "Next Red requirement", "Prev Red requirement", "Next Green requirement", "Prev Green requirement", " " }));
        jToolBar2.add(jComboBox1);

        jPanel1.setLayout(new java.awt.GridLayout(0, 2));
        jTabbedPane1.addTab("File 1", jPanel1);

        jScrollPane1.setViewportView(jTabbedPane1);

        file_menu.setText("File");

        new_FileMenu.setText("New");
        new_FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_FileMenuActionPerformed(evt);
            }
        });
        file_menu.add(new_FileMenu);

        open_FileMenu.setText("Open");
        open_FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_FileMenuActionPerformed(evt);
            }
        });
        file_menu.add(open_FileMenu);

        save_FileMenu.setText("Save");
        save_FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_FileMenuActionPerformed(evt);
            }
        });
        file_menu.add(save_FileMenu);

        saveAs_FileMenu.setText("Save As");
        saveAs_FileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAs_FileMenuActionPerformed(evt);
            }
        });
        file_menu.add(saveAs_FileMenu);

        close_FileMenu.setText("Close");
        file_menu.add(close_FileMenu);

        exit_FileMenu.setText("Exit");
        file_menu.add(exit_FileMenu);

        jMenuBar1.add(file_menu);

        edit_menu.setText("Edit");
        jMenuBar1.add(edit_menu);

        tools_menu.setText("Tools");
        jMenuBar1.add(tools_menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void new_FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_FileMenuActionPerformed

        //creating a new file to add requirements in
        if (countPanel == 1) {
            jPanel1.add(new LeftPaneUI());
            countPanel++;

        } else {

            filename = "File" + (countPanel++);
            jTabbedPane1.addTab(filename, new JPanel(new GridLayout(0, 2)));
            jTabbedPane1.setSelectedIndex(countPanel - 2);
            JPanel c = (JPanel) jTabbedPane1.getComponentAt(jTabbedPane1.getSelectedIndex());
            c.add(new LeftPaneUI());

        }


    }//GEN-LAST:event_new_FileMenuActionPerformed

    private void new_reqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_reqActionPerformed
        // adding a new requirement in the currently selected tab
        JPanel p = (JPanel) jTabbedPane1.getComponentAt(jTabbedPane1.getSelectedIndex());
        p.add(new LeftPaneUI());
    }//GEN-LAST:event_new_reqActionPerformed

    private void del_reqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_reqActionPerformed
    }//GEN-LAST:event_del_reqActionPerformed

    private void save_FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_FileMenuActionPerformed
        
        JPanel d = (JPanel) jTabbedPane1.getComponentAt(jTabbedPane1.getSelectedIndex());        
        Controller.onSave(d,jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()));
        if(d.getName() == null){
            String fileName = JOptionPane.showInputDialog(this,"Save as.." );
            Controller.onSave(d,dirPath+fileName);  
            jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), fileName);
                      
        }
    }//GEN-LAST:event_save_FileMenuActionPerformed

    private void open_FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_FileMenuActionPerformed
        try {
            
            //dispplay dialog box to get filename from user
            JFileChooser chooser = new JFileChooser();
            File f = new File(new File("filename.txt").getCanonicalPath());
            chooser.setSelectedFile(f);
            chooser.showOpenDialog(null);
            File curFile = chooser.getSelectedFile();
            
            //calls onOpne function to read Xml file and takes a panel
           JPanel openFileTab = Controller.onOpen(curFile);
           
            //adding new tab which displays the opened xml file
            jTabbedPane1.addTab(curFile.getName(), openFileTab);
            jTabbedPane1.setSelectedIndex(countPanel - 2);
            
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_open_FileMenuActionPerformed

    private void saveAs_FileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAs_FileMenuActionPerformed
        
        String fileName = JOptionPane.showInputDialog(this,"Save as.." );
        JPanel d = (JPanel) jTabbedPane1.getComponentAt(jTabbedPane1.getSelectedIndex());        
       
        Controller.onSave(d,dirPath+fileName);  
        jTabbedPane1.setTitleAt(jTabbedPane1.getSelectedIndex(), fileName);
    }//GEN-LAST:event_saveAs_FileMenuActionPerformed

    public static void addElements(int type) {
        //adding the requirement based on the type, by creating that particular object

        JPanel d = (JPanel) jTabbedPane1.getComponentAt(jTabbedPane1.getSelectedIndex());
       
        switch (type) {
            
            case 1:
                UbiquitousRequirementUI ub = new UbiquitousRequirementUI();
                d.add(ub);
                break;
            case 2:
                EventDrivenRequirementUI edr = new EventDrivenRequirementUI();
                d.add(edr);
                break;
            case 3:
                UnwantedBehaviourRequirementUI un = new UnwantedBehaviourRequirementUI();
                d.add(un);
                break;
            case 4:
                StateDrivenRequirementUI std = new StateDrivenRequirementUI();
                d.add(std);
                break;
            case 5:
                OptionalFeaturesRequirementUI op = new OptionalFeaturesRequirementUI();
                d.add(op);
                break;
            case 6: //Complex //to do
                break;

        }

        ((JComboBox) ((LeftPaneUI) d.getComponent(d.getComponentCount() - 2)).getComponent(5)).setEnabled(false);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             dirPath = JOptionPane.showInputDialog("Workspace directory is..");
             new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem close_FileMenu;
    private javax.swing.JButton del_req;
    private javax.swing.JMenu edit_menu;
    private javax.swing.JMenuItem exit_FileMenu;
    private javax.swing.JMenu file_menu;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem new_FileMenu;
    private javax.swing.JButton new_req;
    private javax.swing.JMenuItem open_FileMenu;
    private javax.swing.JMenuItem saveAs_FileMenu;
    private javax.swing.JMenuItem save_FileMenu;
    private javax.swing.JMenu tools_menu;
    // End of variables declaration//GEN-END:variables
}
