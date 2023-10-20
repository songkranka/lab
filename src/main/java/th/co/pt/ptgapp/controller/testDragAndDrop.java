package th.co.pt.ptgapp.controller;

import java.awt.image.BufferedImage;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.controller.bean.RandomOil;
import th.co.pt.ptgapp.controller.bean.ResultObj;
import th.co.pt.ptgapp.service.RandomService;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.ReportUtils;

@Controller
public class testDragAndDrop {
	@Autowired
	private RandomService randomService;
	
	@Autowired
    private JdbcTemplate jdbcTemplateSQLSERVER;
	
	@RequestMapping("/testDragAndDrop")
	public ModelAndView settingAssign(HttpServletRequest req,HttpSession session)throws  Exception{
		return new ModelAndView("testDragAndDrop");	
	}
	@RequestMapping(value = "/testDragAndDrop", method = RequestMethod.POST)
    public @ResponseBody  List<Map<String,Object>> getData(@RequestBody RandomOil objReq, HttpServletRequest req,HttpSession session) {   	
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		try {
			//System.out.println(objReq.getTypeValueDAD());
			if(objReq.getTypeValueDAD().equals("updateLevelGroup")) {
				String[] groupH  = objReq.getHeadGroupDAD().toString().split(",");
				//System.out.println(groupH[0]+"|"+groupH[1]);
				String[] level = objReq.getGroupDAD().toString().split("\\|");
				//System.out.println(level[0]+"|"+level[1]+"|"+level[0].length());
					String[] levelA  = level[0].split(",");
					int icA = 1;	
					for(int i=0;i<levelA.length;i++) {
						//System.out.println("IA = "+icA+"|"+levelG[i]);	
						objReq.setHeadGroupDAD(groupH[0]);
						objReq.setGroupDAD(levelA[i]);
						objReq.setLevelDAD(Integer.toString(icA));
						result = callStore(objReq);
						icA++;
					}
					String[] levelB  = level[1].split(",");
					int icB = 1;
					for(int i=0;i<levelB.length;i++) {
						//System.out.println("IB = "+icB+"|"+levelG[i]);
						objReq.setHeadGroupDAD(groupH[1]);
						objReq.setGroupDAD(levelB[i]);
						objReq.setLevelDAD(Integer.toString(icB));
						result = callStore(objReq);
						//System.out.println(levelB[i]+"|"+icB);
						icB++;
					}
					String[] levelC  = level[2].split(",");
					int icC = 1;
					for(int i=0;i<levelC.length;i++) {
						//System.out.println("IB = "+icB+"|"+levelG[i]);
						objReq.setHeadGroupDAD(groupH[1]);
						objReq.setGroupDAD(levelC[i]);
						objReq.setLevelDAD(Integer.toString(icC));
						result = callStore(objReq);
						//System.out.println(levelC[i]+"|"+icC);
						icC++;
					}		
			}
			else if(objReq.getTypeValueDAD().equals("updateDataGroup"))
			{	
				String[] groupH  = objReq.getHeadGroupDAD().toString().split(",");
				String[] level = objReq.getGroupDAD().toString().split("\\|");
					//A
					objReq.setHeadGroupDAD(groupH[0]);
					objReq.setGroupDAD(level[0]);
					result = callStore(objReq);
					
					//B
					objReq.setHeadGroupDAD(groupH[1]);
					objReq.setGroupDAD(level[1]);
					result = callStore(objReq);
					//System.out.println(result);
					//System.out.println(groupH[1]+"|"+level[1]);

			}else if(objReq.getTypeValueDAD().equals("updateData")) {
				String[] idDAD = objReq.getIdDAD().toString().split("\\|");
				String[] groupDAD = objReq.getGroupDAD().toString().split(",");
				
				//System.out.println(objReq.getGroupDAD());
				//System.out.println(objReq.getIdDAD());
				
				//A2
				objReq.setGroupDAD(groupDAD[0]);
				objReq.setIdDAD(idDAD[0]);
				result = callStore(objReq);
				
				//B2
				objReq.setGroupDAD(groupDAD[1]);
				objReq.setIdDAD(idDAD[1]);
				result = callStore(objReq);
				
				//C2
				objReq.setGroupDAD(groupDAD[2]);
				objReq.setIdDAD(idDAD[2]);
				result = callStore(objReq);
				//System.out.println(groupDAD[2]+"|"+idDAD[2]);
				//System.out.println(result);
			}
			else{
				result = callStore(objReq);
			}
		}catch(Exception ex) {
			//System.out.println(ex);
		}
		
		return result;
    }
	@SuppressWarnings("unchecked")
	public List<Map<String,Object>> callStore(@RequestBody RandomOil objReq) {
		List<Map<String, Object>>  result = new ArrayList<Map<String, Object>>();
		try {
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("Test_DAD") ;
				SqlParameterSource in = new MapSqlParameterSource()
				.addValue("typeValueDAD",objReq.getTypeValueDAD(),Types.VARCHAR)
				.addValue("nameDAD",objReq.getNameDAD(),Types.VARCHAR)
				.addValue("groupDAD",objReq.getGroupDAD(),Types.VARCHAR)
				.addValue("headGroupDAD",objReq.getHeadGroupDAD(),Types.VARCHAR)
				.addValue("levelDAD",objReq.getLevelDAD(),Types.VARCHAR)
				.addValue("idDAD", objReq.getIdDAD(),Types.VARCHAR);
				result = (List<Map<String, Object>>) call.execute(in).get("#result-set-1");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

}
