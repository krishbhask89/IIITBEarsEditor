/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitbEarsEditor.View;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sun.nio.fs.GnomeFileTypeDetector;

/**
 *
 * @author michael
 */
public class TabUI extends JTable{
    
    public LeftPaneUI lp;
    public TabUI(){
        
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][] {{  } }, new Object[] {"","" });
        this.setModel(dm);
        
        lp = new LeftPaneUI();
        this.getColumnModel().getColumn(0).setCellRenderer( lp );
        this.getColumnModel().getColumn(0).setCellEditor(lp);
        this.setRowHeight( 95 );
        this.getColumnModel().getColumn(0).setPreferredWidth(160);
        this.getColumnModel().getColumn(1).setPreferredWidth(405);
    }
    public void setRequirementTemplate(int type)
    {
        System.out.println("comes here also");
        switch(type)
        {
            case 1: GenericRequirementUI gr = new GenericRequirementUI();
                    System.out.println("executed");
                    this.getColumnModel().getColumn(1).setCellRenderer(gr);
                    this.getColumnModel().getColumn(1).setCellEditor(gr);
                break;
            case 2: 
        }
    }
}
