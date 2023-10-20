package th.co.pt.ptgapp.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import th.co.pt.ptgapp.service.report.ReportLTRService;

@Component
public class JobTrigger {
	private final Logger logger = LoggerFactory.getLogger(JobTrigger.class);
	@Autowired
	ReportLTRService reportLTRService;
	
	@Scheduled(cron = "0 0 9 * * *")
	public void shcedulerTaskCompleteLtr() {
		logger.info("=========shcedulerTaskCompleteLtr=========");
		reportLTRService.sendmailCompleteLtr();
	}
	
}
