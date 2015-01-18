package iiitbEarsEditor.Controller;

import iiitb.EarsEditor.Model.EARSRequirement;
import iiitb.EarsEditor.Model.EventDrivenRequirement;
import iiitb.EarsEditor.Model.GenericRequirement;
import iiitb.EarsEditor.Model.OptionalFeatures;
import iiitb.EarsEditor.Model.StateDrivenReq;
import iiitb.EarsEditor.Model.UbiquitousRequirement;
import iiitb.EarsEditor.Model.UnwantedBehaviour;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlParser {
        public static void CreateXML(ArrayList<EARSRequirement> reqsList, String _fileName) {

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
                reqDetails.appendChild(req_type);
                
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
                else
                { Element sRequirement = doc.createElement("sReq");
                  EARSReq.appendChild(sRequirement);
                   
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
                        Element system = doc.createElement("system");
                        sRequirement.appendChild(system);
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

}
