package th.co.pt.ptgapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import th.co.pt.ptgapp.controller.bean.*;
import th.co.pt.ptgapp.dao.UtilDao;
import th.co.pt.ptgapp.utils.CGlobal;
import th.co.pt.ptgapp.utils.WebUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

 

@Repository("menuService")
public class MenuServiceImpl implements MenuService {
	// private List<WorkTimeObj> resultApproveEditTime = null;
	// private List<WorkTimeObj> resultApproveLeave = null;
	// private List<WorkTimeObj> resultApproveWorkOut = null;
	// private List<WorkTimeObj> resultApproveOT = null;
	private int approveSummary = 0;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RandomMeterSetupService meterService;
	@Autowired
	private UtilDao utilDao;
	
	public UserMenuObj GetMenu(String strPage, HttpSession session,HttpServletRequest httpRequest) {

		UserMenuObj result = new UserMenuObj();
		logger.debug("UserMenuObj");
		logger.debug("CGlobal.getC_UserInfo(session)>>"				+ CGlobal.getC_UserInfo(session));
		logger.debug("CGlobal.getC_UserInfo(session).mainmenu>>"		+ CGlobal.getC_UserInfo(session).mainmenu);
		logger.debug("CGlobal.getC_UserInfo(session).mainmenu>>"		+ CGlobal.getC_UserInfo(session).mainmenu);
		logger.debug("strPage==>" + strPage);
		// Permiss Page validation
		int check = 0;
		boolean chooseMenu = false;
		if (CGlobal.getC_UserInfo(session).mainmenu != null) {
				result.role = CGlobal.getC_UserInfo(session).role_id;
				this.approveSummary = 0;
	
				MemberObj member_info = CGlobal.getC_UserInfo(session);
				//System.out.println(member_info);
				result.codempid = member_info.codempid;
				result.lang = member_info.lang;
				// Language thai
	//			if (WebUtil.IsStringEmpty(member_info.lang)) {
	//				member_info.lang = "th";
	//			}
				String strLoc ;
				if(CGlobal.getC_UserInfo(session).role_id.equals("0001") || CGlobal.getC_UserInfo(session).role_id.equals("0003")) {
					strLoc = CGlobal.getC_UserInfo(session).locationt;	
				}else {
					strLoc = "ส่วนประกันคุณภาพ";
				}
				//System.out.println(CGlobal.getC_UserInfo(session).locationt);
			 
					result.name = member_info.namempt;
					result.nameright = member_info.namempt;
					result.nameposition = member_info.namempt + " - "	+ member_info.nampost;
				 
					String gen_div = "";
					String app_id = "";
					String site_map = "";
					String site_child = "";
					member_info.sitemap = new ArrayList<MainMenuObj>();
					//System.out.println(CGlobal.getC_UserInfo(session));
					ArrayList<MainMenuObj> subMenu = new ArrayList<MainMenuObj>();
					member_info.sitemap = new ArrayList<MainMenuObj>();
					
					gen_div = "<nav class='navbar-default navbar-static-side' role='navigation'>"
    
							 +" <div class='sidebar-collapse'>"
					 +" <ul class='nav metismenu' id='side-menu'><li class='nav-header'>"
		                    +"<div class='dropdown profile-element'>"
		                    +"<div style='padding-top:15px;' class='row text-center'>"
		                    +"<div class='col-md-12'> "
		                   +"<img id='hlogo' alt='image' class='img-circle' src='"+httpRequest.getContextPath()+"/assets/images/logo2.jpg' />"
		                  +"</div>"
		                    +"</div>"
		                    +"<div style='padding-top:15px;'  class='dropdown-toggle' href='#'>"
		                     +"<ul class='list-group'>"
		                            +"<li class='list-group-item' style='padding: 3px 10px;' ><span class='text-muted text-xs block'> User ID :"+CGlobal.getC_UserInfo(session).codempid+" </span> </li>"
		                            +"<li class='list-group-item' style='padding: 3px 10px;'> <span class='text-muted text-xs block'>name :"+CGlobal.getC_UserInfo(session).namempt+" </span></li>"
		                            +"<li class='list-group-item' style='padding: 3px 10px;'> <span class='text-muted text-xs block'>ส่วนงาน :"+strLoc+" </span></li>"
		                       +"</ul>"
		                    +"</div> "
		                +"</div>"
		                +"<div class='logo-element'>"
		                    +"PT+"
		                +"</div>"
		            +"</li>" ;
					/*
					 * Integer tmp = Integer.parseInt(member_info.mainmenu.get(0)
					 * .getApp_order());
					 */
					 
					 /* for(int i=0;i<member_info.mainmenu.size();i++){
	                	  if(!WebUtil.IsStringEmpty(member_info.mainmenu.get(i).app_path)){
	                		  if(member_info.mainmenu.get(i).app_path.equals(strPage)){
		                		  app_id = member_info.mainmenu.get(i).app_parent;
		                		  //site_map = "<section class='content-header'><h1>" + CGlobal.C_UserInfo.mainmenu.get(i).app_desc + "<small>" + CGlobal.C_UserInfo.mainmenu.get(i).app_head_desc + "</small></h1>";
		                		  site_map = "<section class='content-header'><h1>" + member_info.mainmenu.get(i).app_desc +"</h1>";
		                          site_child = "<li class='active'>" + member_info.mainmenu.get(i).app_desc + "</li>";
		                          member_info.sitemap.add(member_info.mainmenu.get(i));
		                          member_info.title = "Pcca | " + member_info.mainmenu.get(i).app_desc;
		                          result.title ="Pcca | " + member_info.mainmenu.get(i).app_desc;
		                          check++;
		                          i=member_info.mainmenu.size();
	                		  }
	                	  }
	                  }
	                  */
					
	                 /* if (!WebUtil.IsStringEmpty(site_map)){
	                      site_map += "<ol class='breadcrumb'><li><a href='home'><i class='fa fa-dashboard'></i></a></li>";

	                      Boolean b_site = true;
	                      while (b_site){
	                    	  for(int i=0;i<member_info.mainmenu.size();i++){	  
	                    		  b_site = false;
	                    		  if(!WebUtil.IsStringEmpty(member_info.mainmenu.get(i).app_id)){
	                    			  if(member_info.mainmenu.get(i).app_id.equals(app_id) ){
		                    			  app_id = member_info.mainmenu.get(i).app_parent;
		                                  site_child = "<li>" + member_info.mainmenu.get(i).app_desc + "</li>" + site_child;
		                                  member_info.sitemap.add(member_info.mainmenu.get(i));
		                                  b_site = true;  
	                    			  }
	                    		  }
	                    	  }
	                          
	                      }
	                      site_map += site_child + "</ol></section>";


	                      result.sitemap = site_map;
	                  }*/
 
                      
	                //  gen_div = gen_div+ "<ul class='sidebar-menu'><li class='header text-center'> Menu</li>";
	                  for (int i = 0; i < member_info.mainmenu.size(); i++){
	                	  
	                	  if(WebUtil.IsStringEmpty(member_info.mainmenu.get(i).app_parent)){
	                		  String img = "list";
	                          if (!WebUtil.IsStringEmpty(member_info.mainmenu.get(i).app_img)){
	                              img = member_info.mainmenu.get(i).app_img;
	                          }

	                          String li_child = "";
	                          //set Data Back
	                          CGlobal.setC_UserInfo(member_info, session);
	                         if (!WebUtil.IsStringEmpty(member_info.mainmenu.get(i).app_id)){
	                        	 gen_div += "<li >";
	                        		  li_child = this.GetChild(member_info.mainmenu.get(i).app_id,session);
	                        		  if (!WebUtil.IsStringEmpty(li_child)){
	                        			  if (this.IsActive(member_info.mainmenu.get(i),session)){
	                        				  gen_div += " <a href='#'> ";   
	                                          gen_div += "<i class='fa fa-th-list'></i> <span class='nav-label'>" ;
	                                          gen_div += "" + member_info.mainmenu.get(i).app_desc + " " ;
	                                          gen_div += "</span> <span class='fa arrow'></span></a> ";
	                                      
	                                          gen_div += "<ul class='nav nav-second-level collapse'>";
	                                          gen_div += li_child;
	                                          gen_div += " </ul>";
	                                      }else{
	                                    	  gen_div += " <a href='#'> "; 
	                                          gen_div += "  "; 
	                                        
	                                          //gen_div += " <i class='glyphicon glyphicon-" + img + "'></i> " ;
	                                          gen_div += "<i class='fa fa-th-list'></i><span class='nav-label'> " ;
	                                          gen_div += "" + member_info.mainmenu.get(i).app_desc + " " ;
	                                          gen_div += "</span> <span class='fa arrow'></span></a> ";
	                                         
	                                          gen_div += "<ul class='nav nav-second-level collapse'>";
	                                          gen_div += li_child;
	                                          gen_div += " </ul> ";
	                                      }
	                                  }else{
	                                	  gen_div += " <a href='" + member_info.mainmenu.get(i).app_path + "'> "; 
                                          gen_div += ""; 
                                        
                                          gen_div += " <i class='glyphicon glyphicon-" + img + "'></i> " ;
                                         // gen_div += "<i class='fa fa-th-list'></i>   " ;
                                          gen_div += "" + member_info.mainmenu.get(i).app_desc + " " ;
                                          gen_div += "   </a> ";
                                     
                                         
	                                  }
//	                        		  else{
//	                                      if (this.IsActive(member_info.mainmenu.get(i),session)){
//	                                    	  img = member_info.mainmenu.get(i).app_img;
//	                                          gen_div += " <li class='active'> <a href='" + member_info.mainmenu.get(i).app_path + "'> " ;
//	                                          gen_div += " <i class='glyphicon glyphicon-"+img+"'></i><span>" + member_info.mainmenu.get(i).app_desc + "</span> " ;
//	                                          gen_div += "  <span class='pull-right-container'> ";
//	                                          gen_div += " </span> ";
//	                                          gen_div += " </a> ";
//	                                          gen_div += "</li> ";
//	                                      }else{
//	                                    	  img = member_info.mainmenu.get(i).app_img;
//	                                          gen_div += " <li> <a href='" + member_info.mainmenu.get(i).app_path + "'> " ;
//	                                          gen_div += " <i class='glyphicon glyphicon-"+img+"'></i><span>" + member_info.mainmenu.get(i).app_desc + "</span> " ;
//	                                          gen_div += " <span class='pull-right-container'> ";
//	                                          gen_div += " </span> ";
//	                                          gen_div += " </a> ";
//	                                          gen_div += " </li>";
//	                                      }
//	                                  }
	                        	  gen_div += "</li>";
	                             }
	                          }
	                	  
	                   } 
	                  gen_div += "   </ul>"
            +"</div>"
        +" </nav>";
	                  
	              
	                  result.menu = gen_div;
	                  result.success = 1;
		  

			CGlobal.setC_UserInfo(member_info, session);
		}
		return result;
	}

	private String GetChild(String appid, HttpSession session) // edit here
	{
		String li = "";
		MemberObj member_info = CGlobal.getC_UserInfo(session);
		//if (member_info.lang.equals("th")) {
			
			for (int i = 0; i < member_info.mainmenu.size(); i++) {
				if (!WebUtil .IsStringEmpty(member_info.mainmenu.get(i).app_parent)) {
					if (member_info.mainmenu.get(i).app_parent.equals(appid)) {
						String img = "list";
						if (!WebUtil
								.IsStringEmpty(member_info.mainmenu.get(i).app_img)) {
							img = member_info.mainmenu.get(i).app_img;
						}
						String li_child = this.GetChild(
								member_info.mainmenu.get(i).app_id, session);
						
						if (!WebUtil.IsStringEmpty(li_child)) {
 
							if (this.IsActive(member_info.mainmenu.get(i), session)) {
								li += " <li> ";
								li += " <a href='" + member_info.mainmenu.get(i).app_path + "'> ";
								li += " <i class='glyphicon glyphicon-chevron-right'></i><span class='nav-label'> ";
								li += "  "
										+ member_info.mainmenu.get(i).app_desc;
								//		+ "</a>";
								//li += "<i class='glyphicon glyphicon-chevron-right'></i> " ;
								//li += "" + member_info.mainmenu.get(i).app_desc + " " ;
								li += "</span> <span class='fa arrow'></span></a> ";
                                
								li += "<ul class='nav nav-three-level collapse'>";
								li += li_child;
								li += " </ul> ";
								li += "</li>"; 
							} else {
								 li += " <li> ";
									li += " <a href='" + member_info.mainmenu.get(i).app_path + "'> ";
									li += " <i class='glyphicon glyphicon-chevron-right'></i> <span class='nav-label'>";
									li += "  "
											+ member_info.mainmenu.get(i).app_desc;
									//		+ "</a>"; 
									
								//	li += "<i class='glyphicon glyphicon-chevron-right'></i><span class='nav-label'> " ;
								//	li += "" + member_info.mainmenu.get(i).app_desc + " " ;
									li += " </span> <span class='fa arrow'></span></a> ";
	                                
									li += "<ul class='nav nav-three-level collapse'>";
									li += li_child;
									li += " </ul> ";
									
									li += "</li>"; 
//								li += " <li> ";
//								li += " <a href='" + member_info.mainmenu.get(i).app_path + "'> ";
//								li += " <i class='glyphicon glyphicon-chevron-right'></i> ";
//								li += " <span>"
//										+ member_info.mainmenu.get(i).app_desc
//										+ "</span> ";
//								li += "  <span class='pull-right-container'> ";
//								li += "  <i class='fa fa-angle-left pull-right'></i> ";
//								li += " </span></a> ";
//								li += "<ul class='treeview-menu'>";
//								li += li_child;
//
//								li += " </ul></li>";
							} 
						}else {
						/* * 
							// String id =
							// member_info.mainmenu.get(i).app_path.replaceAll("-",
							// "");
							String path = member_info.mainmenu.get(i).app_path;
							// int number = this.getNumber(path);
							if (this.IsActive(member_info.mainmenu.get(i),
									session)) {
								li += " <li class='active'> <a href='"
										+ member_info.mainmenu.get(i).app_path
										+ "'> ";
								li += " <i class='glyphicon glyphicon-chevron-right'></i><span class='custom-font-label-medium'>"
										+ member_info.mainmenu.get(i).app_desc
										+ "</span></a></li>";

								// if(number<100)li +=
								// "&nbsp;<span class='label custom-label-primary' style='display:"+(number==0
								// ?
								// "none":"inline")+";'>"+number+"</span></a></li>";
								// else li +=
								// "&nbsp;<span class='label custom-label-primary padding-3' style='display:block;'>99+</span></a></li>";
							} else {
								li += " <li> <a href='"
										+ member_info.mainmenu.get(i).app_path
										+ "'> ";
								li += " <i class='glyphicon glyphicon-chevron-right'></i><span class='custom-font-label-medium'>"
										+ member_info.mainmenu.get(i).app_desc
										+ "</span></a></li>";

								// if(number<100) li +=
								// "&nbsp;<span class='label custom-label-primary' style='display:"+(number==0
								// ?
								// "none":"inline")+";'>"+number+"</span></a></li>";
								// else li +=
								// "&nbsp;<span class='label custom-label-primary padding-3' style='display:block;'>99+</span></a></li>";
							}*/
							 li += " <li> ";
								li += " <a href='" + member_info.mainmenu.get(i).app_path + "'> ";
								li += " <i class='fa fa-angle-double-right'></i> ";
								li += "  "
										+ member_info.mainmenu.get(i).app_desc
										+ getCountMenu(member_info.mainmenu.get(i).app_id,session)
										+ "</a>"; 
								li += "</li>"; 
								//logger.info("member_info>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
								//logger.info(member_info.mainmenu.get(i).toString());
						 }

					}
				}

			}

			
//		} 
//		else {
//			String li = "";
//			for (int i = 0; i < member_info.mainmenu.size(); i++) {
//				if (!WebUtil
//						.IsStringEmpty(member_info.mainmenu.get(i).app_parent)) {
//					if (member_info.mainmenu.get(i).app_parent.equals(appid)) {
//						String img = "list";
//						if (!WebUtil
//								.IsStringEmpty(member_info.mainmenu.get(i).app_img)) {
//							img = member_info.mainmenu.get(i).app_img;
//						}
//						String li_child = this.GetChild(
//								member_info.mainmenu.get(i).app_id, session);
//
//						if (!WebUtil.IsStringEmpty(li_child)) {
//
//							if (this.IsActive(member_info.mainmenu.get(i),
//									session)) {
//								li += " <li class='active'> ";
//								li += " <a href='" + member_info.mainmenu.get(i).app_path + "'> ";
//								li += " <i class='glyphicon glyphicon-chevron-right'></i> ";
//								li += " <span>"
//										+ member_info.mainmenu.get(i).app_desc_en
//										+ "</span> ";
//								li += " <span class='pull-right-container'> ";
//								li += " <i class='fa fa-angle-left pull-right'></i> ";
//								li += " </span></a> ";
//								li += " <ul class='treeview-menu'>";
//								li += li_child;
//
//								li += " </ul></li>";
//							} else {
//								li += " <li> ";
//								li += " <a href='" + member_info.mainmenu.get(i).app_path + "'> ";
//								li += " <i class='glyphicon glyphicon-chevron-right'></i> "; // fa
//																								// fa-circle-o
//								li += " <span>"
//										+ member_info.mainmenu.get(i).app_desc_en
//										+ "</span> ";
//								li += "  <span class='pull-right-container'> ";
//								li += "  <i class='fa fa-angle-left pull-right'></i> ";
//								li += " </span></a> ";
//								li += "<ul class='treeview-menu'>";
//								li += li_child;
//
//								li += " </ul></li>";
//							}
//						} else {
//							String path = member_info.mainmenu.get(i).app_path;
//							// int number = this.getNumber(path);
//							if (this.IsActive(member_info.mainmenu.get(i),
//									session)) {
//								li += " <li class='active'> <a href='"
//										+ member_info.mainmenu.get(i).app_path
//										+ "'> ";
//								li += " <i class='glyphicon glyphicon-chevron-right'></i><span class='custom-font-label-medium'>"
//										+ member_info.mainmenu.get(i).app_desc_en
//										+ "</span></a></li>";
//
//								// if(number<100) li +=
//								// "&nbsp;<span class='label custom-label-primary' style='display:"+(number==0
//								// ?
//								// "none":"block")+"'>"+number+"</span></a></li>";
//								// else li +=
//								// "&nbsp;<span class='label custom-label-primary padding-3' style='display:block'>99+</span></a></li>";
//							} else {
//								li += " <li> <a href='"
//										+ member_info.mainmenu.get(i).app_path
//										+ "'> ";
//								li += " <i class='glyphicon glyphicon-chevron-right'></i><span class='custom-font-label-medium'>"
//										+ member_info.mainmenu.get(i).app_desc_en
//										+ "</span></a></li>";
//
//								// if(number<100) li +=
//								// "&nbsp;<span class='label custom-label-primary' style='display:"+(number==0
//								// ?
//								// "none":"block")+"'>"+number+"</span></a></li>";
//								// else li +=
//								// "&nbsp;<span class='label custom-label-primary padding-3' style='display:block'>99+</span></a></li>";
//							}
//						}
//
//					}
//				}
//
//			}

//			return li;
//		}
		return li;
	}
	
	private String getCountMenu(String app_id, HttpSession session) {
		String output = "";
		MemberObj member_info = CGlobal.getC_UserInfo(session);
		
		if(app_id.equals("0005")) {
			try {

				Date date = new Date();
				DateFormat df = new SimpleDateFormat("yyyyMMdd");

				RandomPlantMeterEntity entity = new RandomPlantMeterEntity();
				entity.setPlantId(member_info.getPlantId());
				entity.setCreateBy(member_info.getCodempid());
				entity.setWorkDtm(df.format(date).toString());
				entity.setWorkMonth(df.format(date).toString().substring(0, 6));
								
				Map<String,Object>  ActiveCount = meterService.getCountActivateList(entity);
				int countMenu005List = Integer.parseInt(ActiveCount.get("COUNT_LIST").toString());
				output = "  <label style='color: #F00;'>("+new DecimalFormat("###,###,###").format(countMenu005List)+")</label>";
			} catch (Exception e) {
				logger.error("Error get count Menu '0005' ",e);
			} 
		} else {
			//
		}
		return output;
	}
	private Boolean IsActive(MainMenuObj main_menu, HttpSession session) {
		MemberObj member_info = CGlobal.getC_UserInfo(session);
		Boolean ref_check = false;
		for (int i = 0; i < member_info.sitemap.size(); i++) {
			if (!WebUtil.IsStringEmpty(member_info.sitemap.get(i).app_id)) {
				if (member_info.sitemap.get(i).app_id.equals(main_menu.app_id)) {
					i = member_info.sitemap.size();
					member_info.addp = main_menu.addp;
					member_info.savep = main_menu.savep;
					member_info.deletep = main_menu.deletep;
					member_info.approve_flg = main_menu.approve_flg;
					member_info.editp = main_menu.editp;
					member_info.head_flg = main_menu.head_flg;
					ref_check = true;
					CGlobal.setC_UserInfo(member_info, session);
				}
			}
		}

		return ref_check;
	}

	// private int getNumber(String id) {
	// int number = 0;
	// if(id.equals("member-approve-edittime")) {
	// number = this.resultApproveEditTime.size();
	// } else if(id.equals("member-approve-leave")) {
	// number = this.resultApproveLeave.size();
	// } else if(id.equals("member-approve-workout")) {
	// number = this.resultApproveWorkOut.size();
	// } else if(id.equals("member-approve-ot")) {
	// number = this.resultApproveOT.size();
	// }
	//
	// return number;
	// }

	@Override
	public Map<String, Object> getMPUserInfo(CaClreqtObj obj) throws Exception {
		return utilDao.getMpUserInfo(obj);
	}
}
