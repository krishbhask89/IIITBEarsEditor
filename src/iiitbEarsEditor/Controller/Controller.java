/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitbEarsEditor.Controller;

import iiitb.EarsEditor.Model.*;
import iiitbEarsEditor.View.*;
import java.awt.Component;
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

    public void onSave(JPanel panel) {

        Component reqs[] = panel.getComponents();
        ArrayList<EARSRequirement> reqSet = new ArrayList<EARSRequirement>();

        for (int i = 0; i < reqs.length; i += 2) {

            String reqType = ((JComboBox) ((LeftPaneUI) reqs[i]).getComponent(5)).getSelectedItem().toString();
            switch (reqType) {

                case "Ubiquitous":
                    UbiquitousRequirementUI urUI = (UbiquitousRequirementUI) reqs[i + 1];
                    UbiquitousRequirement ur = new UbiquitousRequirement(((JLabel) (((LeftPaneUI) reqs[i]).getComponent(3))).getText());
                    ur.setReqSysName(urUI.getSys_name().getText());
                    ur.setReqSysResponse(urUI.getSys_response().getText());
                    reqSet.add(ur);
                    //System.out.println(ur.getReqType() + " " + ur.getReqSysName() + " " + ur.getReqSysResponse());
                    break;

                case "Event Driven":
                    EventDrivenRequirementUI edUI = (EventDrivenRequirementUI) reqs[i + 1];
                    EventDrivenRequirement ed = new EventDrivenRequirement(((JLabel) (((LeftPaneUI) reqs[i]).getComponent(3))).getText());
                    ed.setReqOptionalPreCond(edUI.getOpt_conditions().getText());
                    ed.setReqTrigger(edUI.getTrigger().getText());
                    ed.setReqSysName(edUI.getSys_name().getText());
                    ed.setReqSysResponse(edUI.getSys_response().getText());
                    reqSet.add(ed);
                    //System.out.println(ed.getReqType() + " " + ed.getReqSysName() + " " + ed.getReqSysResponse());
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
        
        DomParser.CreateXML(reqSet, "test");

    }

}
