package th.co.pt.ptgapp.agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
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

import th.co.pt.ptgapp.controller.bean.workflow.GetItemListEntity;
import th.co.pt.ptgapp.controller.bean.workflow.SubmitRequestEntity;
import th.co.pt.ptgapp.utils.WebUtil;

@Service
public class LotusNotesWebServiceAgent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String ENCODE_UTF8 = "UTF-8";
    private final String CHARSET_UTF8 = "UTF-8";
    
	public LotusNotesWebServiceAgent() {
		// TODO Auto-generated constructor stub
	}
	
	public Map<String, Object> AgentRequstItem(GetItemListEntity entity) {
		
		Map<String, Object> result = new HashMap<String, Object>();

		String StatusApp = "";

		String SOAP_ACTION = "" ;
		String APP_METHOD ="POST";
		int  status = 0;

		try {
			URL url = new URL(WebUtil.GetPropertyMessage("workflow", "url_getItemList"));
			URLConnection urlConn = url.openConnection();
			HttpURLConnection connection = (HttpURLConnection) urlConn;
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(APP_METHOD);
			
			connection.setRequestProperty("SOAPAction", SOAP_ACTION);
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			connection.setRequestProperty("Content-Type", "text/xml;charset="+CHARSET_UTF8);
			connection.setRequestProperty("Encoding", ENCODE_UTF8);
			connection.setRequestProperty("Content-Length", "1552");
			connection.setRequestProperty("Host", WebUtil.GetPropertyMessage("workflow", "url_reqHost"));
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");

			OutputStream out = connection.getOutputStream();
			//logger.info("OutputStream : "+out.toString());
			Writer wout = new OutputStreamWriter(out);
			//logger.info("Writer : "+wout.toString());

			String xmlOutput = "<?xml version='1.0' encoding='UTF-8'?>";
			xmlOutput = xmlOutput + "<soapenv:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:urn='urn:DefaultNamespace'>";
			xmlOutput = xmlOutput + "<soapenv:Header/>";
			xmlOutput = xmlOutput + "<soapenv:Body>";
			xmlOutput = xmlOutput + "<urn:GetItemList soapenv:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
			xmlOutput = xmlOutput + "<SystemT xsi:type='xsd:string'>"+entity.getSystem()+"</SystemT>";
			xmlOutput = xmlOutput + "<Dummy01 xsi:type='xsd:string'>"+entity.getDummy01()+"</Dummy01>";
			xmlOutput = xmlOutput + "<Dummy02 xsi:type='xsd:string'>"+entity.getDummy02()+"</Dummy02>";
			xmlOutput = xmlOutput + "<Dummy03 xsi:type='xsd:string'>"+entity.getDummy03()+"</Dummy03>";
			xmlOutput = xmlOutput + "<Dummy04 xsi:type='xsd:string'>"+entity.getDummy04()+"</Dummy04>";
			xmlOutput = xmlOutput + "<Dummy05 xsi:type='xsd:string'>"+entity.getDummy05()+"</Dummy05>";
			xmlOutput = xmlOutput + "<Dummy06 xsi:type='xsd:string'>"+entity.getDummy06()+"</Dummy06>";
			xmlOutput = xmlOutput + "<Dummy07 xsi:type='xsd:string'>"+entity.getDummy07()+"</Dummy07>";
			xmlOutput = xmlOutput + "<Dummy08 xsi:type='xsd:string'>"+entity.getDummy08()+"</Dummy08>";
			xmlOutput = xmlOutput + "<Dummy09 xsi:type='xsd:string'>"+entity.getDummy09()+"</Dummy09>";
			xmlOutput = xmlOutput + "<Dummy10 xsi:type='xsd:string'>"+entity.getDummy10()+"</Dummy10>";
			xmlOutput = xmlOutput + "<Dummy11 xsi:type='xsd:string'>"+entity.getDummy11()+"</Dummy11>";
			xmlOutput = xmlOutput + "<Dummy12 xsi:type='xsd:string'>"+entity.getDummy12()+"</Dummy12>";
			xmlOutput = xmlOutput + "<Dummy13 xsi:type='xsd:string'>"+entity.getDummy13()+"</Dummy13>";
			xmlOutput = xmlOutput + "<Dummy14 xsi:type='xsd:string'>"+entity.getDummy14()+"</Dummy14>";
			xmlOutput = xmlOutput + "<Dummy15 xsi:type='xsd:string'>"+entity.getDummy15()+"</Dummy15>";
			xmlOutput = xmlOutput + "<Dummy16 xsi:type='xsd:string'>"+entity.getDummy16()+"</Dummy16>";
			xmlOutput = xmlOutput + "<Dummy17 xsi:type='xsd:string'>"+entity.getDummy17()+"</Dummy17>";
			xmlOutput = xmlOutput + "<Dummy18 xsi:type='xsd:string'>"+entity.getDummy18()+"</Dummy18>";
			xmlOutput = xmlOutput + "<Dummy19 xsi:type='xsd:string'>"+entity.getDummy19()+"</Dummy19>";
			xmlOutput = xmlOutput + "<Dummy20 xsi:type='xsd:string'>"+entity.getDummy20()+"</Dummy20>";
			xmlOutput = xmlOutput + "</urn:GetItemList>";
			xmlOutput = xmlOutput + "</soapenv:Body>";
			xmlOutput = xmlOutput + "</soapenv:Envelope>";
			
			wout.write(xmlOutput);
			wout.flush();
			wout.close();
			try {
				status = connection.getResponseCode();
				StatusApp = Integer.toString(status) ;		
				result.put("appStatus", StatusApp);
			} catch (Exception e) {
				StatusApp = e.getMessage();
				result.put("status", "E");
				result.put("appStatus", StatusApp);
			}
			
			InputStream in = connection.getInputStream();
			String res = getStringFromInputStream(in);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new StringReader(res)));
			
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("ns1:GetItemListResponse");
			Node nNode = nList.item(0);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) nNode;
				
				String jsonString = eElement.getElementsByTagName("GetItemListReturn").item(0).getTextContent();
				
				result.put("status", "S");
				result.put("result", jsonString);
				
			}
		} catch (Exception e) {
			StatusApp = e.getMessage();
			result.put("status", "E");
			result.put("appStatus", StatusApp);
			
			logger.error("AgentRequstItem : Request SOAP Exception ",e);
		}
		return result;
	}


	private static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String FILE_ENCODE = "UTF-8";
		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is, Charset.forName(FILE_ENCODE)));
			while ((line = br.readLine()) != null) {
				//System.out.println("  response from BufferedReader >>> "+line);
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}

	public Map<String, Object> AgentSubmitAssignment(SubmitRequestEntity entity) {
		Map<String, Object> result = new HashMap<String, Object>();

		String StatusApp = "";

		String SOAP_ACTION = "" ;
		String APP_METHOD ="POST";
		int  status = 0;
		
		try {
			
			URL url = new URL(WebUtil.GetPropertyMessage("workflow", "url_submitReq"));
			URLConnection urlConn = url.openConnection();
			HttpURLConnection connection = (HttpURLConnection) urlConn;
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod(APP_METHOD);
			
			connection.setRequestProperty("SOAPAction", SOAP_ACTION);
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			connection.setRequestProperty("Content-Type", "text/xml;charset="+CHARSET_UTF8);
			connection.setRequestProperty("Encoding", ENCODE_UTF8);
			connection.setRequestProperty("Content-Length", "1474");
			connection.setRequestProperty("Host", WebUtil.GetPropertyMessage("workflow", "url_reqHost"));
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("User-Agent", "Apache-HttpClient/4.1.1 (java 1.5)");
			
			OutputStream out = connection.getOutputStream();
			//logger.info("OutputStream : "+out.toString());
			Writer wout = new OutputStreamWriter(out);
			//logger.info("Writer : "+wout.toString());
			
			String xmlOutput = "<?xml version='1.0' encoding='UTF-8'?>";
			xmlOutput = xmlOutput + "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:urn='urn:DefaultNamespace'>";
			xmlOutput = xmlOutput + "<soapenv:Header/>";
			xmlOutput = xmlOutput + "<soapenv:Body>";
			xmlOutput = xmlOutput + "<urn:SystemName>"+entity.getSystemName()+"</urn:SystemName>";
			xmlOutput = xmlOutput + "<urn:Process>"+entity.getProcess()+"</urn:Process>";
			xmlOutput = xmlOutput + "<urn:RequestID>"+entity.getRequestID()+"</urn:RequestID>";
			xmlOutput = xmlOutput + "<urn:RequesterID>"+entity.getRequesterID()+"</urn:RequesterID>";
			xmlOutput = xmlOutput + "<urn:Totalrecord>"+entity.getTotalrecord()+"</urn:Totalrecord>";
			xmlOutput = xmlOutput + "<urn:Dummy01>"+entity.getDummy01()+"</urn:Dummy01>";
			xmlOutput = xmlOutput + "<urn:Dummy02>"+entity.getDummy02()+"</urn:Dummy02>";
			xmlOutput = xmlOutput + "<urn:Dummy03>"+entity.getDummy03()+"</urn:Dummy03>";
			xmlOutput = xmlOutput + "<urn:Dummy04>"+entity.getDummy04()+"</urn:Dummy04>";
			xmlOutput = xmlOutput + "<urn:Dummy05>"+entity.getDummy05()+"</urn:Dummy05>";
			xmlOutput = xmlOutput + "<urn:Dummy06>"+entity.getDummy06()+"</urn:Dummy06>";
			xmlOutput = xmlOutput + "<urn:Dummy07>"+entity.getDummy07()+"</urn:Dummy07>";
			xmlOutput = xmlOutput + "<urn:Dummy08>"+entity.getDummy08()+"</urn:Dummy08>";
			xmlOutput = xmlOutput + "<urn:Dummy09>"+entity.getDummy09()+"</urn:Dummy09>";
			xmlOutput = xmlOutput + "<urn:Dummy10>"+entity.getDummy10()+"</urn:Dummy10>";
			xmlOutput = xmlOutput + "<urn:Dummy11>"+entity.getDummy11()+"</urn:Dummy11>";
			xmlOutput = xmlOutput + "<urn:Dummy12>"+entity.getDummy12()+"</urn:Dummy12>";
			xmlOutput = xmlOutput + "<urn:Dummy13>"+entity.getDummy13()+"</urn:Dummy13>";
			xmlOutput = xmlOutput + "<urn:Dummy14>"+entity.getDummy14()+"</urn:Dummy14>";
			xmlOutput = xmlOutput + "<urn:Dummy15>"+entity.getDummy15()+"</urn:Dummy15>";
			xmlOutput = xmlOutput + "<urn:Dummy16>"+entity.getDummy16()+"</urn:Dummy16>";
			xmlOutput = xmlOutput + "<urn:Dummy17>"+entity.getDummy17()+"</urn:Dummy17>";
			xmlOutput = xmlOutput + "<urn:Dummy18>"+entity.getDummy18()+"</urn:Dummy18>";
			xmlOutput = xmlOutput + "<urn:Dummy19>"+entity.getDummy19()+"</urn:Dummy19>";
			xmlOutput = xmlOutput + "<urn:Dummy20>"+entity.getDummy20()+"</urn:Dummy20>";
			xmlOutput = xmlOutput + "<urn:Seq>"+entity.getSeq()+"</urn:Seq>";
			xmlOutput = xmlOutput + "<urn:TestItemCode>"+entity.getTestItemCode()+"</urn:TestItemCode>";
			xmlOutput = xmlOutput + "<urn:TesttoolCode>"+entity.getTesttoolCode()+"</urn:TesttoolCode>";
			xmlOutput = xmlOutput + "<urn:TestMethodCode>"+entity.getTestMethodCode()+"</urn:TestMethodCode>";
			xmlOutput = xmlOutput + "<urn:TestSpecCode>"+entity.getTestSpecCode()+"</urn:TestSpecCode>";
			xmlOutput = xmlOutput + "<urn:TestUnitCode>"+entity.getTestUnitCode()+"</urn:TestUnitCode>";
			xmlOutput = xmlOutput + "<urn:Memberlist>"+entity.getMemberlist()+"</urn:Memberlist>";
			xmlOutput = xmlOutput + "</soapenv:Body>";
			xmlOutput = xmlOutput + "</soapenv:Envelope>";
	
			wout.write(xmlOutput);
			wout.flush();
			wout.close();
			try {
				status = connection.getResponseCode();
				
				StatusApp = Integer.toString(status) ;		
				result.put("appStatus", StatusApp);
			} catch (Exception e) {
				logger.error("Error Exception AgentSubmitAssignment 'Get Response Code' ",e);
				StatusApp = e.getMessage();
				result.put("status", "E");
				result.put("appStatus", StatusApp);
			}
			
			InputStream in = connection.getInputStream();
			String res = getStringFromInputStream(in);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new StringReader(res)));
			
			doc.getDocumentElement().normalize();
				
			NodeList nList = doc.getElementsByTagName("GetRequest_DetailReturn");

			Node nNode = nList.item(0);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				
				Element eElement = (Element) nNode;
				String jsonString = eElement.getTextContent();
				result.put("result", jsonString);
				result.put("status", "S");

			} else {
				logger.info("ELEMENT NODE is not equal 1 ");
				result.put("status", "E");
			}
			
		} catch (Exception e) {

			StatusApp = e.getMessage();
			result.put("status", "E");
			result.put("appStatus", StatusApp);
			
			logger.error("AgentSubmitAssignment : Request SOAP Exception ",e);
			
		}
		
		return result;
	}
	
}








 
