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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import th.co.pt.ptgapp.controller.bean.workflow.GetMasterEntity;
import th.co.pt.ptgapp.controller.bean.workflow.MasterListEntity;
import th.co.pt.ptgapp.utils.WFAgentUtil;
import th.co.pt.ptgapp.utils.WebUtil;

@Service
public class WFGetMasterAgent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public WFGetMasterAgent() {}
	
	public Map<String, Object> requestMasterAgent(GetMasterEntity entity) {
		
		Map<String, Object> result = new HashMap<String, Object>();

		String StatusApp = "";

		String SOAP_ACTION = "" ;
		String APP_METHOD ="POST";
		int  status = 0;
		
		try {
			
			URL url = new URL(WebUtil.GetPropertyMessage("workflow", "url_getMaster"));
			URLConnection urlConn = url.openConnection();
			HttpURLConnection connection = (HttpURLConnection) urlConn;
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(APP_METHOD);
			
			connection.setRequestProperty("SOAPAction", SOAP_ACTION);
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			connection.setRequestProperty("Content-Type", "text/xml;charset="+WFAgentUtil.CHARSET_UTF8);
			connection.setRequestProperty("Encoding", WFAgentUtil.ENCODE_UTF8);
			connection.setRequestProperty("Content-Length", "278");
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
			xmlOutput = xmlOutput + "<urn:Table>"+entity.getTable()+"</urn:Table>";
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

				logger.error("Error Exception Agent Get Master 'Get Response Code' ",e);
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
			
			NodeList nList = doc.getElementsByTagName("Request_GetMasterReturn");
			
			System.out.println("----------------------------");
			
			Node nNode = nList.item(0);

			logger.info("Current Element :" + nNode.getNodeName());
			logger.info("nNode.getNodeType() :" + nNode.getNodeType());
			logger.info("nNode.getAttributes() :" + nNode.getAttributes());
			logger.info("nNode.getTextContent() :" + nNode.getTextContent());
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							
				Element eElement = (Element) nNode;
				
				String jsonString = eElement.getTextContent();
				logger.info("Request_GetMasterReturn node : ");
				logger.info(jsonString);
				
				JsonParser jsonParser = new JsonParser();
				JsonObject objectFromString = jsonParser.parse(jsonString).getAsJsonObject();
				logger.info("objectFromString : "+objectFromString.toString());
				
				GetMasterEntity outputEntity = new GetMasterEntity();
				outputEntity.setSystem(objectFromString.get("SystemT").getAsString());
				outputEntity.setTable(objectFromString.get("Table").getAsString());
				outputEntity.setErrorCode(objectFromString.get("ErrorCode").getAsString());
				outputEntity.setErrorMsg(objectFromString.get("ErrorMsg").getAsString());
				outputEntity.setRemark(objectFromString.get("Remark").getAsString());
				
				JsonElement TblDetail = objectFromString.get(outputEntity.getTable());
				JsonArray arrayTableValue = TblDetail.getAsJsonArray();
				
				List<MasterListEntity> list = new ArrayList<MasterListEntity>();
				
				for ( int i=0; i < arrayTableValue.size(); i++ ) {
					
					MasterListEntity obj = new MasterListEntity();
					JsonObject jsonObj = arrayTableValue.get(i).getAsJsonObject();

					obj.setCode(jsonObj.get("Code").getAsString());
					obj.setValue1(jsonObj.get("Value1").getAsString());
					obj.setValue2(jsonObj.get("Value2").getAsString());
					
					logger.info("Code = "+obj.getCode().toString());
					logger.info("Value1 = "+obj.getValue1().toString());
					logger.info("Value2 = "+obj.getValue2().toString());

					list.add(obj);
				}
				outputEntity.setListMasterValue(list);

				result.put("status", "S");
				result.put("result", outputEntity);
			} else {
				logger.info("ELEMENT NODE is not equal 1 ");
				result.put("status", "E");
			}
			
		} catch(Exception e) {
			StatusApp = e.getMessage();
			result.put("status", "E");
			result.put("appStatus", StatusApp);
			
			logger.error("AgentRequstMasterTable : Request SOAP Exception ",e);			
		}
		return result;
		
	}
}
