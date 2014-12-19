/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiitbEarsEditor.Controller;

/**
 * ** @author Krish
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import iiitb.EarsEditor.Model.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParser {

    /*public static void CreateXML(ArrayList<EARSRequirement> reqsList, String _fileName) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Requirements");
            doc.appendChild(rootElement);

            for (EARSRequirement req : reqsList) {
                Element EARSReq = doc.createElement("EARSReq");
                rootElement.appendChild(EARSReq);

                Element reqDetails = doc.createElement("reqDetails");
                EARSReq.appendChild(reqDetails);
                Element index = doc.createElement("index");
                index.appendChild(doc.createTextNode(req.getReqId()));
                reqDetails.appendChild(index);
                Element req_type = doc.createElement("req_type");
                req_type.appendChild(doc.createTextNode(req.getReqType()));
                reqDetails.appendChild(req_type);
                Element ccode = doc.createElement("colour_code");
                ccode.appendChild(doc.createTextNode(req.getReqColorCode()));
                reqDetails.appendChild(req_type);

                Element requirement = doc.createElement("requirement");
                EARSReq.appendChild(requirement);
                
                switch (req.getReqType()) {
                    case "Generic":
                        GenericRequirement gr = (GenericRequirement) req;
                        Element pCond = doc.createElement("precondition");
                        pCond.appendChild(doc.createTextNode(gr.getReqOptionalPreCond()));
                        requirement.appendChild(pCond);
                        Element trigger = doc.createElement("trigger");
                        trigger.appendChild(doc.createTextNode(gr.getReqOptionalTrigger()));
                        requirement.appendChild(trigger);
                        Element sysName = doc.createElement("system_name");
                        sysName.appendChild(doc.createTextNode(gr.getReqSysName()));
                        requirement.appendChild(sysName);
                        Element sysResp = doc.createElement("system_response");
                        sysResp.appendChild(doc.createTextNode(gr.getReqSysResponse()));
                        requirement.appendChild(sysResp);
                        break;
                    case "Ubiquitous":
                        UbiquitousRequirement ur = (UbiquitousRequirement) req;
                        Element u_sysName = doc.createElement("system_name");
                        u_sysName.appendChild(doc.createTextNode(ur.getReqSysName()));
                        requirement.appendChild(u_sysName);
                        Element u_sysResp = doc.createElement("system_response");
                        u_sysResp.appendChild(doc.createTextNode(ur.getReqSysResponse()));
                        requirement.appendChild(u_sysResp);
                        break;
                    case "Event Driven":
                        EventDrivenRequirement edr = (EventDrivenRequirement) req;
                        Element ed_pCond = doc.createElement("precondition");
                        ed_pCond.appendChild(doc.createTextNode(edr.getReqOptionalPreCond()));
                        requirement.appendChild(ed_pCond);
                        Element ed_trigger = doc.createElement("trigger");
                        ed_trigger.appendChild(doc.createTextNode(edr.getReqTrigger()));
                        requirement.appendChild(ed_trigger);
                        Element ed_sysName = doc.createElement("system_name");
                        ed_sysName.appendChild(doc.createTextNode(edr.getReqSysName()));
                        requirement.appendChild(ed_sysName);
                        Element ed_sysResp = doc.createElement("system_response");
                        ed_sysResp.appendChild(doc.createTextNode(edr.getReqSysResponse()));
                        requirement.appendChild(ed_sysResp);
                        break;
                    case "Unwanted Behaviour":
                        UnwantedBehaviour ubr = (UnwantedBehaviour) req;
                        Element ub_pCond = doc.createElement("precondition");
                        ub_pCond.appendChild(doc.createTextNode(ubr.getReqOptionalPreCond()));
                        requirement.appendChild(ub_pCond);
                        Element ub_trigger = doc.createElement("trigger");
                        ub_trigger.appendChild(doc.createTextNode(ubr.getReqTrigger()));
                        requirement.appendChild(ub_trigger);
                        Element ub_sysName = doc.createElement("system_name");
                        ub_sysName.appendChild(doc.createTextNode(ubr.getReqSysName()));
                        requirement.appendChild(ub_sysName);
                        Element ub_sysResp = doc.createElement("system_response");
                        ub_sysResp.appendChild(doc.createTextNode(ubr.getReqSysResponse()));
                        requirement.appendChild(ub_sysResp);
                        break;
                    case "State Driven":
                        StateDrivenReq sdr = (StateDrivenReq) req;
                        Element sd_spState = doc.createElement("specific_state");
                        sd_spState.appendChild(doc.createTextNode(sdr.getReqSpecificState()));
                        requirement.appendChild(sd_spState);
                        Element sd_sysName = doc.createElement("system_name");
                        sd_sysName.appendChild(doc.createTextNode(sdr.getReqSysName()));
                        requirement.appendChild(sd_sysName);
                        Element sd_sysResp = doc.createElement("system_response");
                        sd_sysResp.appendChild(doc.createTextNode(sdr.getReqSysResponse()));
                        requirement.appendChild(sd_sysResp);
                        break;
                    case "Optional Features":
                        OptionalFeatures opF = (OptionalFeatures) req;
                        Element opF_featIncluded = doc.createElement("feature_included");
                        opF_featIncluded.appendChild(doc.createTextNode(opF.getReqFeatureIncluded()));
                        requirement.appendChild(opF_featIncluded);
                        Element opF_sysName = doc.createElement("system_name");
                        opF_sysName.appendChild(doc.createTextNode(opF.getReqSysName()));
                        requirement.appendChild(opF_sysName);
                        Element opF_sysResp = doc.createElement("system_response");
                        opF_sysResp.appendChild(doc.createTextNode(opF.getReqSysResponse()));
                        requirement.appendChild(opF_sysResp);
                        break;
                }
            }
            TransformerFactory transF = TransformerFactory.newInstance();
            Transformer transformer = transF.newTransformer();
            DOMSource dSrc = new DOMSource(doc);
            StreamResult strRes = new StreamResult(new File("C:\\Users\\Krish\\Desktop\\EARSWorkSpace"+_fileName+".xml"));
            transformer.transform(dSrc, strRes);
        } catch (ParserConfigurationException | TransformerException e) {
        }

    }

    
    public static ArrayList<EARSRequirement> ReadXML(String _fileName){
        ArrayList<EARSRequirement> reqsList = new ArrayList();
        String opCond,opTrig,sName,sResp,specState,featIncl;
        String reqType,reqCCode,reqIndex;
        
        try{
            File xmlRead = new File(_fileName);
            
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();  
   	    DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();  
	    Document doc = documentBuilder.parse(xmlRead);
            doc.getDocumentElement().normalize();  
	    NodeList nodeList = doc.getElementsByTagName("EARSReq");
            
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                        
            for(int reqNum=0; reqNum < nodeList.getLength(); reqNum++){
              Node node = nodeList.item(reqNum);
              if(node.getNodeType() == Node.ELEMENT_NODE)
               { Element EARSReq = (Element) node;
                  reqType = EARSReq.getElementsByTagName("req_type").item(0).getTextContent();
                  switch(reqType)
                  {    case "Generic":
                        opCond = EARSReq.getElementsByTagName("precondition").item(0).getTextContent();
                        opTrig = EARSReq.getElementsByTagName("trigger").item(0).getTextContent();
                        sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                        sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                        reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                        reqIndex = EARSReq.getElementsByTagName("index").item(0).getTextContent();
                        GenericRequirement gr = new GenericRequirement(opCond, opTrig, sName, sResp,reqCCode,reqIndex);
                        reqsList.add(gr);
                        break;
                    case "Ubiquitous":
                        sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                        sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                        reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                        reqIndex = EARSReq.getElementsByTagName("index").item(0).getTextContent();
                        UbiquitousRequirement ur = new UbiquitousRequirement(sName, sResp,reqCCode,reqIndex);
                        reqsList.add(ur);
                        break;
                    case "Event Driven":
                        opCond = EARSReq.getElementsByTagName("precondition").item(0).getTextContent();
                        opTrig = EARSReq.getElementsByTagName("trigger").item(0).getTextContent();
                        sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                        sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                        reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                        reqIndex = EARSReq.getElementsByTagName("index").item(0).getTextContent();
                        EventDrivenRequirement edr = new EventDrivenRequirement(opCond, opTrig, sName, sResp,reqCCode,reqIndex);
                        reqsList.add(edr);
                        break;
                    case "Unwanted Behaviour":
                        opCond = EARSReq.getElementsByTagName("precondition").item(0).getTextContent();
                        opTrig = EARSReq.getElementsByTagName("trigger").item(0).getTextContent();
                        sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                        sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                        reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                        reqIndex = EARSReq.getElementsByTagName("index").item(0).getTextContent();
                        UnwantedBehaviour ubr = new UnwantedBehaviour(opCond, opTrig, sName, sResp,reqCCode,reqIndex);
                        reqsList.add(ubr);
                        break;
                    case "State Driven":
                        specState = EARSReq.getElementsByTagName("specific_state").item(0).getTextContent();
                        sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                        sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                        reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                        reqIndex = EARSReq.getElementsByTagName("index").item(0).getTextContent();
                        StateDrivenReq sdr = new StateDrivenReq(specState, sName, sResp,reqCCode,reqIndex);
                        reqsList.add(sdr);
                        break;
                    case "Optional Features":
                        featIncl = EARSReq.getElementsByTagName("feature_included").item(0).getTextContent();
                        sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                        sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                        reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                        reqIndex = EARSReq.getElementsByTagName("index").item(0).getTextContent();
                        OptionalFeatures opF = new OptionalFeatures(featIncl, sName, sResp,reqCCode,reqIndex);
                        reqsList.add(opF);
                        break;
                  }    
                }
            }
        }catch(ParserConfigurationException | SAXException | IOException | DOMException ex){
        }
      return reqsList;
    } */
}