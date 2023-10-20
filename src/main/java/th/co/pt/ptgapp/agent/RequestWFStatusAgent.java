package th.co.pt.ptgapp.agent;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import th.co.pt.ptgapp.controller.bean.workflow.GetWFStatusEntity;
import th.co.pt.ptgapp.controller.bean.workflow.StatusWFHistoryEntity;
import th.co.pt.ptgapp.utils.WFAgentUtil;
import th.co.pt.ptgapp.utils.WebUtil;

@Service
public class RequestWFStatusAgent {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public Map<String, Object> reqtWorkflowStatus(GetWFStatusEntity entity) {

    	Map<String, Object> result = new HashMap<String, Object>();

		String StatusApp = "";

		String SOAP_ACTION = "" ;
		String APP_METHOD ="POST";
		int  status = 0;
		    	
    	try {
    		URL url = new URL(WebUtil.GetPropertyMessage("workflow", "url_getStatus"));
			URLConnection urlConn = url.openConnection();
			HttpURLConnection connection = (HttpURLConnection) urlConn;
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(APP_METHOD);
			
			connection.setRequestProperty("SOAPAction", SOAP_ACTION);
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			connection.setRequestProperty("Content-Type", "text/xml;charset="+WFAgentUtil.CHARSET_UTF8);
			connection.setRequestProperty("Encoding", WFAgentUtil.ENCODE_UTF8);
			connection.setRequestProperty("Content-Length", "332");
			connection.setRequestProperty("Host", WebUtil.GetPropertyMessage("workflow", "url_reqHost"));
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");
			
			OutputStream out = connection.getOutputStream();
			logger.info("OutputStream : "+out.toString());
			Writer wout = new OutputStreamWriter(out);
			logger.info("Writer : "+wout.toString());

			String xmlOutput = "<?xml version='1.0' encoding='UTF-8'?>";
			xmlOutput = xmlOutput + "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:urn='urn:DefaultNamespace'>";
			xmlOutput = xmlOutput + "<soapenv:Header/>";
			xmlOutput = xmlOutput + "<soapenv:Body>";
			xmlOutput = xmlOutput + "<urn:SystemT>"+entity.getSystem()+"</urn:SystemT>";
			xmlOutput = xmlOutput + "<urn:Process>"+entity.getProcess()+"</urn:Process>";
			xmlOutput = xmlOutput + "<urn:RequestID>"+entity.getRequestID()+"</urn:RequestID>";
			xmlOutput = xmlOutput + "</soapenv:Body>";
			xmlOutput = xmlOutput + "</soapenv:Envelope>";
			
			wout.write(xmlOutput);
			wout.flush();
			wout.close();
	
			try {

				status = connection.getResponseCode();
				logger.info(connection.getResponseMessage());
				
				StatusApp = Integer.toString(status) ;		
				result.put("appStatus", StatusApp);
				
			} catch (Exception e) {

				logger.error("Error Exception Agent Get Status 'Get Response Code' ",e);
				StatusApp = e.getMessage();
				result.put("status", "E");
				result.put("appStatus", StatusApp);
				
			}

			InputStream in = connection.getInputStream();
			String res = WFAgentUtil.getStringFromInputStream(in);

			logger.info("get response from workflow : ");
			logger.info(res);
			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new StringReader(res)));
			
			doc.getDocumentElement().normalize();
			
			logger.info("Root element :" + doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("Request_GetStatusReturn");
			
			System.out.println("----------------------------");
			
			Node nNode = nList.item(0);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) nNode;
				
				String jsonString = eElement.getTextContent();
				logger.info("Request_GetStatusReturn node : ");
				logger.info(jsonString);
				
				JsonParser jsonParser = new JsonParser();
				JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();
				logger.info("objectFromString : "+objectFromString.toString());
				
				GetWFStatusEntity outputEntity = new GetWFStatusEntity();
				outputEntity.setSystem(objectFromString.get("SystemT").getAsString());
				outputEntity.setProcess(objectFromString.get("Process").getAsString());
				outputEntity.setErrorMsg(objectFromString.get("ErrorMsg").getAsString());
				outputEntity.setErrorCode(objectFromString.get("ErrorCode").getAsString());
				outputEntity.setRequestID(objectFromString.get("RequestID").getAsString());
				outputEntity.setRemark(objectFromString.get("Remark").getAsString());
				outputEntity.setCodempid(objectFromString.get("EmployeeID").getAsString());
				outputEntity.setFullEmpName(objectFromString.get("EmployeeName").getAsString());
				outputEntity.setWfStep(objectFromString.get("WFStep").getAsString());
				outputEntity.setWfStatus(objectFromString.get("WFStatus").getAsString());
				
				//JsonElement HistoryList = objectFromString.get("History");
				JsonArray arrayHistory = objectFromString.get("History").getAsJsonArray();
				
				List<StatusWFHistoryEntity> list = new ArrayList<StatusWFHistoryEntity>();
				
				for ( int i = 0; i < arrayHistory.size(); i++) {
					
					StatusWFHistoryEntity obj = new StatusWFHistoryEntity();
					JsonObject jsonObj = arrayHistory.get(i).getAsJsonObject();
					
					obj.setWfStepHistory(jsonObj.get("History_WFStep").getAsString());
					obj.setOperatorName(jsonObj.get("History_Name").getAsString());
					obj.setDecision(jsonObj.get("History_Decision").getAsString());
					
					String historyDtm[] = jsonObj.get("History_DateTime").getAsString().split(" ");
					obj.setDate(historyDtm[0]);
					obj.setTime(historyDtm[1]);
					obj.setComment(jsonObj.get("History_Comment").getAsString());
					
					list.add(obj);
					
				}
				
				outputEntity.setHistoryStatus(list);

				result.put("status", "S");
				result.put("result", outputEntity);
				
			} else {
				logger.info("ELEMENT NODE is not equal 1 ");
				result.put("status", "E");
			}
			
    	} catch (Exception e) {
			StatusApp = e.getMessage();
			result.put("status", "E");
			result.put("appStatus", StatusApp);
			
			logger.error("AgentRequstMasterTable : Request SOAP Exception ",e);
    	}
    	return result;
    }
}
