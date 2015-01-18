//Contributor : Sai Bhaskar Krishna
//The XMLParser iterates through the requirement List to create a XML document to be stored in the backend in CreateXML
//The XMLParser parses through the XML file and populates the requirement list in the ReadXML
package iiitbEarsEditor.Controller;

import iiitb.EarsEditor.Model.EARSRequirement;
import iiitb.EarsEditor.Model.EventDrivenRequirement;
import iiitb.EarsEditor.Model.OptionalFeatures;
import iiitb.EarsEditor.Model.StateDrivenReq;
import iiitb.EarsEditor.Model.UbiquitousRequirement;
import iiitb.EarsEditor.Model.UnwantedBehaviour;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {
        public static void CreateXML(ArrayList<EARSRequirement> reqsList, String _fileName) {
        int reqFlag = 0; 
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("ReqSet");
            doc.appendChild(rootElement);

            for (EARSRequirement req : reqsList) {
                Element EARSReq = doc.createElement("req");
                rootElement.appendChild(EARSReq);

                Element reqDetails = doc.createElement("details");
                EARSReq.appendChild(reqDetails);
                Element index = doc.createElement("rId");
                index.appendChild(doc.createTextNode(req.getReqId()));
                reqDetails.appendChild(index);
                Element req_type = doc.createElement("req_type");
                req_type.appendChild(doc.createTextNode(req.getReqType()));
                reqDetails.appendChild(req_type);
                Element ccode = doc.createElement("colour_code");
                ccode.appendChild(doc.createTextNode(req.getReqColorCode()));
                reqDetails.appendChild(ccode);
                
                if( req.getReqType() == "Ubiquitous"){
                    Element uRequirement = doc.createElement("uReq");
                    EARSReq.appendChild(uRequirement);            
                    UbiquitousRequirement ur = (UbiquitousRequirement) req;
                    Element u_sysName = doc.createElement("system_name");
                    u_sysName.appendChild(doc.createTextNode(ur.getReqSysName()));
                    uRequirement.appendChild(u_sysName);
                    Element u_sysResp = doc.createElement("system_response");
                    u_sysResp.appendChild(doc.createTextNode(ur.getReqSysResponse()));
                    uRequirement.appendChild(u_sysResp);    
                }
                else if(! (req.getReqType().equalsIgnoreCase("Complex")))
                { Element sRequirement = doc.createElement("sReq");
                  EARSReq.appendChild(sRequirement);
                  Element system = doc.createElement("system");
                  sRequirement.appendChild(system);
                         
                  switch (req.getReqType()) {
                    case "Event Driven":
                        Element edRequirement = doc.createElement("when");
                        sRequirement.appendChild(edRequirement);
                        EventDrivenRequirement edr = (EventDrivenRequirement) req;
                        Element ed_pCond = doc.createElement("precondition");
                        ed_pCond.appendChild(doc.createTextNode(edr.getReqOptionalPreCond()));
                        edRequirement.appendChild(ed_pCond);
                        Element ed_trigger = doc.createElement("trigger");
                        ed_trigger.appendChild(doc.createTextNode(edr.getReqTrigger()));
                        edRequirement.appendChild(ed_trigger);
                        Element ed_sysName = doc.createElement("system_name");
                        ed_sysName.appendChild(doc.createTextNode(edr.getReqSysName()));
                        system.appendChild(ed_sysName);
                        Element ed_sysResp = doc.createElement("system_response");
                        ed_sysResp.appendChild(doc.createTextNode(edr.getReqSysResponse()));
                        system.appendChild(ed_sysResp);
                        break;
                    case "Unwanted Behaviour":
                        Element ubRequirement = doc.createElement("if");
                        sRequirement.appendChild(ubRequirement);
                        UnwantedBehaviour ubr = (UnwantedBehaviour) req;
                        Element ub_pCond = doc.createElement("precondition");
                        ub_pCond.appendChild(doc.createTextNode(ubr.getReqOptionalPreCond()));
                        ubRequirement.appendChild(ub_pCond);
                        Element ub_trigger = doc.createElement("trigger");
                        ub_trigger.appendChild(doc.createTextNode(ubr.getReqTrigger()));
                        ubRequirement.appendChild(ub_trigger);
                        Element ub_sysName = doc.createElement("system_name");
                        ub_sysName.appendChild(doc.createTextNode(ubr.getReqSysName()));
                        system.appendChild(ub_sysName);
                        Element ub_sysResp = doc.createElement("system_response");
                        ub_sysResp.appendChild(doc.createTextNode(ubr.getReqSysResponse()));
                        system.appendChild(ub_sysResp);
                        break;
                    case "State Driven":
                        Element sdReq = doc.createElement("while");
                        sRequirement.appendChild(sdReq);
                        StateDrivenReq sdr = (StateDrivenReq) req;
                        Element sd_spState = doc.createElement("specific_state");
                        sd_spState.appendChild(doc.createTextNode(sdr.getReqSpecificState()));
                        sdReq.appendChild(sd_spState);
                        Element sd_sysName = doc.createElement("system_name");
                        sd_sysName.appendChild(doc.createTextNode(sdr.getReqSysName()));
                        system.appendChild(sd_sysName);
                        Element sd_sysResp = doc.createElement("system_response");
                        sd_sysResp.appendChild(doc.createTextNode(sdr.getReqSysResponse()));
                        system.appendChild(sd_sysResp);
                        break;
                    case "Optional Features":
                        Element opFtr = doc.createElement("where");
                        sRequirement.appendChild(opFtr);
                        OptionalFeatures opF = (OptionalFeatures) req;
                        Element opF_featIncluded = doc.createElement("feature_included");
                        opF_featIncluded.appendChild(doc.createTextNode(opF.getReqFeatureIncluded()));
                        opFtr.appendChild(opF_featIncluded);
                        Element of_sysName = doc.createElement("system_name");
                        of_sysName.appendChild(doc.createTextNode(opF.getReqSysName()));
                        system.appendChild(of_sysName);
                        Element of_sysResp = doc.createElement("system_response");
                        of_sysResp.appendChild(doc.createTextNode(opF.getReqSysResponse()));
                        system.appendChild(of_sysResp);
                        break;
                }
              }
            }
            TransformerFactory transF = TransformerFactory.newInstance();
            Transformer transformer = transF.newTransformer();
            DOMSource dSrc = new DOMSource(doc);
            StreamResult strRes = new StreamResult(new File("C:\\Users\\Krish\\Desktop\\EARSWorkSpace\\"+_fileName+".xml"));
            transformer.transform(dSrc, strRes);
        } catch (ParserConfigurationException | TransformerException e) {}
    }
        
        public static ArrayList<EARSRequirement> ReadXML(String _fileName) {
        ArrayList<EARSRequirement> reqsList = new ArrayList();
        String opCond, opTrig, sName, sResp, specState, featIncl;
        String reqType, reqCCode, reqIndex;

        try 
        {
         // if(XmlValidate.validate(_fileName))
          //{  
            File xmlRead = new File(_fileName);

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(xmlRead);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("req");

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            for (int reqNum = 0; reqNum < nodeList.getLength(); reqNum++) {
                Node node = nodeList.item(reqNum);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element EARSReq = (Element) node;
                    reqType = EARSReq.getElementsByTagName("req_type").item(0).getTextContent();
                    switch (reqType) {
                        case "Ubiquitous":
                            sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                            sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                            reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                            reqIndex = EARSReq.getElementsByTagName("rId").item(0).getTextContent();
                            UbiquitousRequirement ur = new UbiquitousRequirement(sName, sResp, reqCCode, reqIndex);
                            reqsList.add(ur);
                            break;
                        case "Event Driven":
                            opCond = EARSReq.getElementsByTagName("precondition").item(0).getTextContent();
                            opTrig = EARSReq.getElementsByTagName("trigger").item(0).getTextContent();
                            sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                            sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                            reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                            reqIndex = EARSReq.getElementsByTagName("rId").item(0).getTextContent();
                            EventDrivenRequirement edr = new EventDrivenRequirement(opCond, opTrig, sName, sResp, reqCCode, reqIndex);
                            reqsList.add(edr);
                            break;
                        case "Unwanted Behaviour":
                            opCond = EARSReq.getElementsByTagName("precondition").item(0).getTextContent();
                            opTrig = EARSReq.getElementsByTagName("trigger").item(0).getTextContent();
                            sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                            sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                            reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                            reqIndex = EARSReq.getElementsByTagName("rId").item(0).getTextContent();
                            UnwantedBehaviour ubr = new UnwantedBehaviour(opCond, opTrig, sName, sResp, reqCCode, reqIndex);
                            reqsList.add(ubr);
                            break;
                        case "State Driven":
                            specState = EARSReq.getElementsByTagName("specific_state").item(0).getTextContent();
                            sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                            sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                            reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                            reqIndex = EARSReq.getElementsByTagName("rId").item(0).getTextContent();
                            StateDrivenReq sdr = new StateDrivenReq(specState, sName, sResp, reqCCode, reqIndex);
                            reqsList.add(sdr);
                            break;
                        case "Optional Features":
                            featIncl = EARSReq.getElementsByTagName("feature_included").item(0).getTextContent();
                            sName = EARSReq.getElementsByTagName("system_name").item(0).getTextContent();
                            sResp = EARSReq.getElementsByTagName("system_response").item(0).getTextContent();
                            reqCCode = EARSReq.getElementsByTagName("colour_code").item(0).getTextContent();
                            reqIndex = EARSReq.getElementsByTagName("rId").item(0).getTextContent();
                            OptionalFeatures opF = new OptionalFeatures(featIncl, sName, sResp, reqCCode, reqIndex);
                            reqsList.add(opF);
                            break;
                    }
                }
            }
            for(EARSRequirement req : reqsList){
                System.out.println(req.getReqType());
            }
          //}   
        } catch (ParserConfigurationException | SAXException | IOException | DOMException ex) {}
        return reqsList;
    }
    
}
