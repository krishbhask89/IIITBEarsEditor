/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitbEarsEditor.Controller;

import iiitb.EarsEditor.Model.*;
import iiitbEarsEditor.View.*;
import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Krish
 */
public class Controller {

    //reads text from UI and creates requirements list and calls XML Parser
    public static void onSave(JPanel panel) {

        //contains all components on the panel (left panel + requirement panel)
        Component reqs[] = panel.getComponents();
        
        //requirement list
        ArrayList<EARSRequirement> reqSet = new ArrayList<EARSRequirement>();

        //access left panel and requirement panel n reads text
        for (int i = 0; i < reqs.length; i += 2) {

            //reading reqType from left panel
            String reqType = ((JComboBox) ((LeftPaneUI) reqs[i]).getComponent(5)).getSelectedItem().toString();
            
            //creates requirement object(with reqID fetched from left panel) according to the reqType 
            //UI objects for reading from requirement panel
            switch (reqType) {

                case "Ubiquitous":  
                    UbiquitousRequirementUI urUI = (UbiquitousRequirementUI) reqs[i + 1];
                    UbiquitousRequirement ur = new UbiquitousRequirement(((JLabel) (((LeftPaneUI) reqs[i]).getComponent(3))).getText());
                    ur.setReqSysName(urUI.getSys_name().getText());
                    ur.setReqSysResponse(urUI.getSys_response().getText());
                    reqSet.add(ur);                    
                    break;

                case "Event Driven":
                    EventDrivenRequirementUI edUI = (EventDrivenRequirementUI) reqs[i + 1];
                    EventDrivenRequirement ed = new EventDrivenRequirement(((JLabel) (((LeftPaneUI) reqs[i]).getComponent(3))).getText());
                    ed.setReqOptionalPreCond(edUI.getOpt_conditions().getText());
                    ed.setReqTrigger(edUI.getTrigger().getText());
                    ed.setReqSysName(edUI.getSys_name().getText());
                    ed.setReqSysResponse(edUI.getSys_response().getText());
                    reqSet.add(ed);                    
                    break;
                case "Unwanted":
                    UnwantedBehaviourRequirementUI ubUI = (UnwantedBehaviourRequirementUI) reqs[i + 1];
                    UnwantedBehaviour ub = new UnwantedBehaviour(((JLabel) (((LeftPaneUI) reqs[i]).getComponent(3))).getText());
                    ub.setReqOptionalPreCond(ubUI.getOpt_conditions().getText());
                    ub.setReqTrigger(ubUI.getTrigger().getText());
                    ub.setReqSysName(ubUI.getSys_name().getText());
                    ub.setReqSysResponse(ubUI.getSys_response().getText());
                    reqSet.add(ub);
                    break;
                case "State Driven":
                    StateDrivenRequirementUI sdUI = (StateDrivenRequirementUI) reqs[i + 1];
                    StateDrivenReq sd = new StateDrivenReq(((JLabel) (((LeftPaneUI) reqs[i]).getComponent(3))).getText());
                    sd.setReqSpecificState(sdUI.getSpecific_state().getText());
                    sd.setReqSysName(sdUI.getSys_name().getText());
                    sd.setReqSysResponse(sdUI.getSys_response().getText());
                    reqSet.add(sd);
                    break;
                case "Optional":
                    OptionalFeaturesRequirementUI ofUI = (OptionalFeaturesRequirementUI) reqs[i + 1];
                    OptionalFeatures of = new OptionalFeatures(((JLabel) (((LeftPaneUI) reqs[i]).getComponent(3))).getText());
                    of.setReqFeatureIncluded(ofUI.getFeature_included().getText());
                    of.setReqSysName(ofUI.getSys_name().getText());
                    of.setReqSysResponse(ofUI.getSys_response().getText());
                    reqSet.add(of);
                    break;
                case "Complex": //to do

            }
        }
        
        //Calling XML Parser with requirement list and the filename
        XmlParser.CreateXML(reqSet, "test");
    }
    
    public static void onOpen(File curFile){
        
        XmlParser.ReadXML(curFile.getPath());
    }
}
