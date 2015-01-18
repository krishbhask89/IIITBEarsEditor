/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitbEarsEditor.Controller;

import iiitb.EarsEditor.Model.*;
import iiitbEarsEditor.View.*;
import java.awt.Component;
import java.awt.GridLayout;
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
    public static void onSave(JPanel panel, String fileName) {

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
                case "Unwanted Behaviour":
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
                case "Optional Features":
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
        XmlParser.CreateXML(reqSet, fileName);
    }

    public static JPanel onOpen(File curFile) {

        ArrayList<EARSRequirement> reqList = XmlParser.ReadXML(curFile.getPath());

        JPanel panel = new JPanel((new GridLayout(0, 2)));

        for (EARSRequirement req : reqList) {

            JPanel leftPane = new LeftPaneUI();

            //panel.add(new LeftPaneUI());
            switch (req.getReqType()) {

                case "Ubiquitous":
                    ((JComboBox) (leftPane.getComponent(5))).setSelectedIndex(1);
                    ((JComboBox) (leftPane.getComponent(5))).setEnabled(false);
                    panel.add(leftPane);
                    UbiquitousRequirementUI ubUI = new UbiquitousRequirementUI();
                    UbiquitousRequirement ub = (UbiquitousRequirement) req;
                    ubUI.getSys_name().setText(ub.getReqSysName());
                    ubUI.getSys_response().setText(ub.getReqSysResponse());
                    panel.add(ubUI);
                    break;
                case "Event Driven":
                    ((JComboBox) (leftPane.getComponent(5))).setSelectedIndex(2);
                    ((JComboBox) (leftPane.getComponent(5))).setEnabled(false);
                    panel.add(leftPane);
                    EventDrivenRequirementUI edrUI = new EventDrivenRequirementUI();
                    EventDrivenRequirement ed = (EventDrivenRequirement) req;
                    edrUI.getOpt_conditions().setText(ed.getReqOptionalPreCond());
                    edrUI.getTrigger().setText(ed.getReqTrigger());
                    edrUI.getSys_name().setText(ed.getReqSysName());
                    edrUI.getSys_response().setText(ed.getReqSysResponse());
                    panel.add(edrUI);
                    break;
                case "Unwanted Behaviour":
                    ((JComboBox) (leftPane.getComponent(5))).setSelectedIndex(3);
                    ((JComboBox) (leftPane.getComponent(5))).setEnabled(false);
                    panel.add(leftPane);
                    UnwantedBehaviourRequirementUI unUI = new UnwantedBehaviourRequirementUI();
                    UnwantedBehaviour ubr = (UnwantedBehaviour) req;
                    unUI.getOpt_conditions().setText(ubr.getReqOptionalPreCond());
                    unUI.getTrigger().setText(ubr.getReqTrigger());
                    unUI.getSys_name().setText(ubr.getReqSysName());
                    unUI.getSys_response().setText(ubr.getReqSysResponse());
                    panel.add(unUI);
                    break;
                case "State Driven":
                    ((JComboBox) (leftPane.getComponent(5))).setSelectedIndex(4);
                    ((JComboBox) (leftPane.getComponent(5))).setEnabled(false);
                    panel.add(leftPane);
                    StateDrivenRequirementUI stdUI = new StateDrivenRequirementUI();
                    StateDrivenReq sdr = (StateDrivenReq) req;
                    stdUI.getSpecific_state().setText(sdr.getReqSpecificState());
                    stdUI.getSys_name().setText(sdr.getReqSysName());
                    stdUI.getSys_response().setText(sdr.getReqSysResponse());
                    panel.add(stdUI);
                    break;
                case "Optional Features":
                    ((JComboBox) (leftPane.getComponent(5))).setSelectedIndex(5);
                    ((JComboBox) (leftPane.getComponent(5))).setEnabled(false);
                    panel.add(leftPane);
                    OptionalFeaturesRequirementUI opUI = new OptionalFeaturesRequirementUI();
                    OptionalFeatures op = (OptionalFeatures) req;
                    opUI.getFeature_included().setText(op.getReqFeatureIncluded());
                    opUI.getSys_name().setText(op.getReqSysName());
                    opUI.getSys_response().setText(op.getReqSysResponse());
                    panel.add(opUI);
                    break;
                case "Complex": //Complex 
                    ((JComboBox) (leftPane.getComponent(5))).setSelectedIndex(6);
                    ((JComboBox) (leftPane.getComponent(5))).setEnabled(false);
                    panel.add(leftPane);
                    //to do
                    break;

            }

        }

        return panel;
    }
}
