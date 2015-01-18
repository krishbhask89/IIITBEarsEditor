/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitbEarsEditor.Controller;

import iiitb.EarsEditor.Model.UbiquitousRequirement;
import iiitbEarsEditor.View.LeftPaneUI;
import iiitbEarsEditor.View.UbiquitousRequirementUI;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Krish
 */
public class Controller {
    
    public void onSave(JPanel panel){
        
        Component reqs[] = panel.getComponents();
        for(int i=0; i <reqs.length; i+=2){
            //System.out.println(((JLabel)(((LeftPaneUI)reqs[i]).getComponent(3))).getText());
            
            String reqType = ((JComboBox)((LeftPaneUI)reqs[i]).getComponent(5)).getSelectedItem().toString();
            switch(reqType){
                
                case "Ubiquitous"   : //UbiquitousRequirementUI urUI = (UbiquitousRequirementUI)reqs[i+1];
                                      UbiquitousRequirement ur = new UbiquitousRequirement(((JLabel)(((LeftPaneUI)reqs[i]).getComponent(3))).getText());                                      
                                      //ur.setReqSysName(reqType);
                case "Event Driven" :
                case "Unwanted"     :
                case "State Driven" :
                case "Optional"     :
                case "Complex"      :    
                    
            }
        }
        
        //for (Component c: reqs){
            //System.out.println(((JPanel)c).getClass());
            
            System.out.println(((JComboBox)((LeftPaneUI)reqs[0]).getComponent(5)).getSelectedItem().toString());
        //}
        
    }
    
}
