package th.co.pt.ptgapp.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import th.co.pt.ptgapp.controller.bean.workflow.GetWorkSelfEntity;
import th.co.pt.ptgapp.utils.WFAgentUtil;
import th.co.pt.ptgapp.utils.WebUtil;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@Service
public class GetWorkSelfAgent {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Map<String, Object> requestWorkSelf(GetWorkSelfEntity entity) {

		Map<String, Object> result = new HashMap<String, Object>();

		String StatusApp = "";
		String SOAP_ACTION = "" ;
		String APP_METHOD ="POST";
		int  status = 0;

		try {
			
			URL url = new URL(WebUtil.GetPropertyMessage("workflow", "url_getworkSelf"));
			URLConnection urlConn = url.openConnection();
			HttpURLConnection connection = (HttpURLConnection) urlConn;
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(APP_METHOD);
			
			connection.setRequestProperty("SOAPAction", SOAP_ACTION);
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			connection.setRequestProperty("Content-Type", "text/xml;charset="+WFAgentUtil.CHARSET_UTF8);
			connection.setRequestProperty("Encoding", WFAgentUtil.ENCODE_UTF8);
			connection.setRequestProperty("Content-Length", "324");
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
			xmlOutput = xmlOutput + "<urn:EmployeeID>"+entity.getEmployee()+"</urn:EmployeeID>";
			xmlOutput = xmlOutput + "<urn:WFStatus>"+entity.getWfStatus()+"</urn:WFStatus>";
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

				logger.error("Error Exception Agent Get Workself 'Get Response Code' ",e);
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

			NodeList nList = doc.getElementsByTagName("Request_GetMyWorkReturn"); // <<-------- Re-check
			Node nNode = nList.item(0);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) nNode;
				
				String jsonString = eElement.getTextContent();
				logger.info(jsonString);
				
				result.put("status", "S");
				result.put("result", jsonString);
				
			} else {
				logger.info("ELEMENT NODE is not equal 1 ");
				result.put("status", "E");
			}
		} catch (Exception e) {
			StatusApp = e.getMessage();
			result.put("status", "E");
			result.put("appStatus", StatusApp);
			
			logger.error("GetWorkSelfAgent : Request SOAP Exception ",e);
		}
		return result;
	}
}
