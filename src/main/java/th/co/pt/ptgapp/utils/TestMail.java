package th.co.pt.ptgapp.utils;
import com.sendgrid.*;
import java.io.IOException;
public class TestMail {
	public static void main(String[] args) throws IOException {
	    Email from = new Email("no-reply@pt.co.th");
	    String subject = "Sending with SendGrid is Fun";
	    Email to = new Email("zomads17@gmail.com");
	    Content content = new Content("text/html", ""
	    		+ "<h3>แจ้งรายการยกเลิก</h3>"
	    		+ "<table border='1' style='border-collapse:collapse'>"
	    		+ "<tr><th>Lab Code</th><th>PRODUCT NAME</th><th>LOGIS NAME</th><th>SOURCE NAME</th><th>PO DATE</th><th>CAR NO</th><th>CAR SLOT</th><th>PLANT NAME</th><th>CANCEL DESC</th></tr></table>");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid("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");
	    Request request = new Request();
	    try {
	      request.setMethod(Method.POST);
	      request.setEndpoint("mail/send");
	      request.setBody(mail.build());
	      Response response = sg.api(request);
	      System.out.println(response.getStatusCode());
	      System.out.println(response.getBody());
	      System.out.println(response.getHeaders());
	    } catch (IOException ex) {
	      throw ex;
	    }
	    }
}
