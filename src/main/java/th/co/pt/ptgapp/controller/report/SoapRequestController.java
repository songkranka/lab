package th.co.pt.ptgapp.controller.report;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import th.co.pt.ptgapp.controller.bean.ReportInfoEntity;

@Controller
public class SoapRequestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("soap-test-request")
	public ModelAndView soapRequest(HttpServletRequest request, HttpServletResponse response, HttpSession session ,Model model) throws Exception { 
		ModelAndView view = new ModelAndView("soap-test-request");

		return view;
	}
}
