package th.co.pt.ptgapp.dao ;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jfree.util.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import th.co.pt.ptgapp.controller.bean.MainMenuObj;
import th.co.pt.ptgapp.controller.bean.MemberAccountObj;
import th.co.pt.ptgapp.controller.bean.MemberObj;
import th.co.pt.ptgapp.utils.WebUtil;

 

@Repository("menuDao")
public class MenuDao   {
	@Autowired
	 //private JdbcTemplate jdbcTemplate;
	private JdbcTemplate jdbcTemplateSQLSERVER;
	private  final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public MemberObj GetUserPermiss(MemberObj result) {
		//MemberObj result = new MemberObj();
		List<MemberObj> listresult = new ArrayList<MemberObj>();
		try {
			//System.out.println(result.getCodempid());
			SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("GETROLE");
				SqlParameterSource in = new MapSqlParameterSource()  
				.addValue("codempid",result.getCodempid(),Types.VARCHAR)
				.addValue("role_id",Types.VARCHAR) ;
				
				Map<String, Object> out = call.execute(in);	
				String role_id =(String)out.get("role_id");
				String plant_id = (String)out.get("plant_id");
				String signature_img = (String)out.get("signature_img");
			 Log.info("role_id"+role_id);
			 result.setRole_id(role_id);
			 result.setPlantId(plant_id); 
			 result.setSignature_img(signature_img);
			//System.out.println(role_id);a
			List<MainMenuObj> main_menu = new ArrayList<MainMenuObj>();
						
			call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("GETMAPPINGMENU") ;
			in = new MapSqlParameterSource().addValue("role_id",role_id,Types.VARCHAR)  ;
		    ArrayList resultList = (ArrayList) call.execute(in).get("#result-set-1");
					
		    //System.out.println(resultList);
			int size = resultList.size();
			for(int i = 0; i < size; i++) {
			Map resultMap = (Map) resultList.get( i );
			MainMenuObj obj = new MainMenuObj();
					    obj.setApp_id((String)resultMap.get("app_id"));
						obj.setApp_desc((String)resultMap.get("app_desc"));
						obj.setApp_path((String)resultMap.get("app_path"));
						obj.setApp_img((String)resultMap.get("app_img")); 
						obj.setApp_order((resultMap.get("app_order")!=null?""+(int)resultMap.get("app_order"):""));
						obj.setApp_parent((String)resultMap.get("app_parent")); 		
						main_menu.add(obj);									
									}	
						MainMenuObj logout_menu = new MainMenuObj();
						MainMenuObj urlhris_menu = new MainMenuObj();
			
			//System.out.println(main_menu.size());
			if (main_menu.size() > 0) {
			String parent = "";
				for (int i = 0; i < main_menu.size(); i++) {
					 if (result.mainmenu == null) {
					 result.mainmenu = new ArrayList<MainMenuObj>();
				}
					// add menu into list
				if(main_menu.get(i).app_id.equals("0099")) {
					logout_menu = main_menu.get(i);
		  }else if(main_menu.get(i).app_id.equals("0098")){
					urlhris_menu = main_menu.get(i);
			 }else {
					result.mainmenu.add(main_menu.get(i));
					}

				if (!WebUtil.IsStringEmpty(main_menu.get(i).app_parent)) {
				if (WebUtil.IsStringEmpty(parent)) {
					parent +=  main_menu.get(i).app_parent;
		   } else {
				    parent +=  ","+main_menu.get(i).app_parent;
									}
								}
							}
		   List<MainMenuObj> parent_menu = new ArrayList<MainMenuObj>();
				//  logger.info("parent:"+parent);
				if (!WebUtil.IsStringEmpty(parent)) {
					String last_app_id = "";
					parent = this.GetParent3(parent, parent);
					last_app_id = parent;
				//	  logger.info("last_app_id:"+last_app_id);
				if (!WebUtil.IsStringEmpty(last_app_id)) {	
					
				List<MainMenuObj> last_menu = new ArrayList<MainMenuObj>();
				call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getParent2") ;
				in = new MapSqlParameterSource().addValue("menu_id",last_app_id,Types.VARCHAR)  ;
				resultList = (ArrayList) call.execute(in).get("#result-set-1");
				size = resultList.size();
			    for(int i = 0; i < size; i++) {
					Map resultMap = (Map) resultList.get( i );					
					MainMenuObj obj = new MainMenuObj();
								obj.setApp_id((String)resultMap.get("app_id"));
								obj.setApp_desc((String)resultMap.get("app_desc"));
								obj.setApp_path((String)resultMap.get("app_path"));
								obj.setApp_img((String)resultMap.get("app_img"));
								obj.setApp_order((resultMap.get("app_order")!=null?""+(int)resultMap.get("app_order"):""));
								obj.setApp_parent((String)resultMap.get("app_parent")); 		
								last_menu.add(obj);
								}
					if (last_menu != null) {
					if (last_menu.size() > 0) {
					//	  logger.info("size last_menu.size():"+last_menu.size());
					for (int i = 0; i < last_menu.size(); i++) {
								result.mainmenu.add(last_menu.get(i));
											}
										}
									}
								}
							}
						}						
		} catch (Exception ex) {
			logger.error(ex.getMessage(),ex);
		}
		return result;
	}
	private String GetParent3(String parent, String curr_parent) {
		Boolean islast = false;
	
		List<MainMenuObj> main_menu = new ArrayList<MainMenuObj>();
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplateSQLSERVER).withProcedureName("getParent3") ;
		SqlParameterSource 	  in = new MapSqlParameterSource()   
			.addValue("menu_id",parent,Types.VARCHAR)  ;
		ArrayList  resultList = (ArrayList) call.execute(in).get("#result-set-1");
		   
		int  size = resultList.size();
//		logger.info("parent3 size:"+size);
		for(int i = 0; i < size; i++) {
			Map resultMap = (Map) resultList.get(i);
			
			MainMenuObj obj = new MainMenuObj();
			obj.setApp_id((String)resultMap.get("app_id"));
			obj.setApp_desc((String)resultMap.get("app_desc"));
			obj.setApp_path((String)resultMap.get("app_path"));
			obj.setApp_img((String)resultMap.get("app_img"));
			obj.setApp_order((resultMap.get("app_order")!=null?""+(int)resultMap.get("app_order"):""));
			obj.setApp_parent((String)resultMap.get("app_parent"));
			main_menu.add(obj);	
		}
		if (main_menu != null) {
			if (main_menu.size() > 0) {
				String child_parent = "";
//				logger.info("parent3 main_menu.size():"+main_menu.size());
				for (int i = 0; i < main_menu.size(); i++) {

					if (!WebUtil.IsStringEmpty(main_menu.get(i).app_parent)) {
						if (WebUtil.IsStringEmpty(child_parent)) {
							child_parent +=  main_menu.get(i).app_parent ;
						} else {
							child_parent +=  ","+main_menu.get(i).app_parent ;
						}
					}
				}
//				logger.info("parent3 child_parent:"+child_parent);
				if (WebUtil.IsStringEmpty(child_parent)) {
					islast = true;

				} else {
					curr_parent += "," + child_parent;
					curr_parent = this.GetParent3(child_parent, curr_parent);

				}
//				logger.info("parent3 curr_parent:"+curr_parent);
			}
		}
		return curr_parent;
	}
}
