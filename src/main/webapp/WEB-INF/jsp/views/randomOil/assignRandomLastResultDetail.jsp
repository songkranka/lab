<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.tbHeader {
	font-size:  10px;
	background: #3c8dbc;
	color: white;
}
</style>
<!-- <div class="box box-success box-solid"> -->
<script type='text/javascript'>
var table = "";
var tmp_data = {};
var  labCode_No  = "",product_id="";
    $(document).ready(function () {
    	// alert("89");
     initParam();
    	
    	
    	
    });
     
	function initParam(){
		var  url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');    		
		 var labCode_v = url[0].split('='); 
		 labCode_No  =  labCode_v[1];
	 
		// var productid_v  =  url[1].split('='); 
		// product_id =  productid_v[1];
		 //alert(labCode_No+"-"+labCode_No);
		 
		inquiryRequestAnalysisOilDetail();
	}
     function inquiryRequestAnalysisOilDetail(){
    	try {
    	   
    		  $('#myTableRandomOilDetailId').DataTable().destroy();
    	 
    		
 		    			var data = {}
 		    			data["labCode_No"] = labCode_No;  
 					  jQuery.ajax({
 						url : 'assignRandomLastResultDetail',
 						type : "Post", 
 						contentType : "application/json",
 						data : JSON.stringify(data), 
 						dataType : 'json',
 						  async: false,
 						   cache: false,
 						success : function(data) {
 					 
 							if(data.success==1){
 							 var det = "";
 										 for (var i = 0; i < data.list.length; i++) {
 											 
 											  tmp_data = data;  
 											 
 											var  role = (data.list[i].role==null?"":data.list[i].role)  
 											det +='<tr>'; 
 											det +='<td class="text-center" >'+(i+1)+'</td>'; 
 											det +='<td class="text-center" >'
 											det +='<select name="role" id="role">'
 											det +='<option value="A1_'+(data.list[i].id==null?"":data.list[i].id)+'"  '+(role=='A1'?'selected':'')+'>A1</option>'
											det +='<option value="A2_'+(data.list[i].id==null?"":data.list[i].id)+'"  '+(role=='A2'?'selected':'')+'>A2</option>'
											det +='<option value="A3_'+(data.list[i].id==null?"":data.list[i].id)+'" '+(role=='A3'?'selected':'')+'>A3</option>'
										    det +='<option value="B1_'+(data.list[i].id==null?"":data.list[i].id)+'" '+(role=='B1'?'selected':'')+'>B1</option>'
											det +='<option value="B2_'+(data.list[i].id==null?"":data.list[i].id)+'" '+(role=='B2'?'selected':'')+'>B2</option>'
											det +='<option value="B3_'+(data.list[i].id==null?"":data.list[i].id)+'" '+(role=='B1'?'selected':'')+'>B3</option>'
 											det +='</select></td>';
 											
 											det +='<td class="text-left" >'+(data.list[i].desc_analyze==null?"":data.list[i].desc_analyze)+'</td>'; 
 									  
 											det +='<td class="text-left" >'+(data.list[i].material_analyze==null?"":data.list[i].material_analyze)+'</td>';
 											 
 											det +='<td class="text-left" >'+(data.list[i].method==null?"":data.list[i].method)+'</td>';
 										 
 											det +='</tr>';
 											/*var status  = (data.list[i].status==null?"1":data.list[i].status);
 											var receive_flg  = (data.list[i].receive_flg==null?"":data.list[i].receive_flg);
 											det +='<td class="text-right" >';
 											if(status=='1'){
	 											if(receive_flg==""||receive_flg=='N'){
	 												det +="<input type=\"checkbox\" onclick=\"updateStatusReceiveFlag('"+(data.list[i].LABCODE_NO==null?"":data.list[i].LABCODE_NO)+"')\" />"
	 											}else{
	 												det +='<span class="glyphicon glyphicon-ok" style="color:blue"></span>';
	 											}
 											}else{
 												det +='<span class="glyphicon glyphicon-remove" style="color:red"></span>';
 											}
                                            det += '</td>';
 											
 											det +='<td class="text-right" >';
 											if(status=='1'){
 											   det +="<div class=\"col-sm-2 col-xs-6 Br-inp-10\"><button type=\"button\" ";
 											   det +="class=\"btn btn-danger\"";
 											   det +="style=\"width: 100px;text-align:center;\"   onclick=\"updateStatus('"+(data.list[i].LABCODE_NO==null?"":data.list[i].LABCODE_NO)+"','0')\">ยกเลิก</button></div>"
 											}else{
 												det +=  '&nbsp;';
 											}
 											 det += '</td>';*/
 										 
 										}
 									
 										if(det==''){
 											det += '<tr> ';
 											det += '<th colspan="5" class="text-center">--- ไม่พบข้อมูล ---</th> ';
 											det += '</tr> ';
 											$('#dteId').html(det);
 											  
 										}else{
 											  
 											$('#randomOilDetailId').html(det);
 											/*table =  $('#myTableRandomOilDetailId').DataTable( {
 												searching: true,
 												responsive : true
 											});*/
 											
 										} 
 							}else{
 							 
 								/* swal({
 									  title: "บันทึกข้อมูลผิดพลาด",
 									  type: "error",
 									  text:data.message,
 									  showCancelButton: false,
 									  confirmButtonColor: "#DD6B55",
 									  confirmButtonText: "ตกลง",
 									  closeOnConfirm: false
 									});*/
 								  /*$.alert({
 					                    title: 'ข้อมูลผิดพลาด',
 					                    icon: 'fa fa-error',
 					                    type: 'red',
 					                    content: data.message,
 					                });*/
 									showMsgError(data.message)
 							}
 						},
 						error : function() {
 							 
 							 
 							 /* $.alert({
				                    title: 'ข้อมูลผิดพลาด',
				                    icon: 'fa fa-error',
				                    type: 'red', 
				                });*/
 								showMsgError('ข้อมูลผิดพลาด');
 						}
 					});
 					   
 		} catch (ex) {
 			  /*$.alert({
                  title: 'error',
                  icon: 'fa fa-error',
                  type: 'red',
                  content: ex,
              });*/
 				showMsgError(ex);
 		}
     	 
     } 
     function sendRequestAssignRandomOil(){
     	try{
     	 	//alert(tmp_data.list.length);
              if(tmp_data!=null&&tmp_data.list.length>0){
 			            	 $.confirm({
 			            		    title: 'ยืนยันส่งมอบหมายงาน',
 			            		    icon: 'fa fa-exclamation-circle',
 			                        type: 'blue',
 			            		    content: '',
 			            		    buttons: {
 			            		     'ยืนยัน': function () {
 			            		   
 					    		  
 					    		 		 var objList = {} 
 			     		                  var array_dt = []
 									  //  alert($(this).val());
 					    				 var role_id_comma = '';
 					    				 var item_comma = '';
 					    				$("select[name='role']").each(function() { 
 					    						 // alert($(this).val());
 					    						 var role_id   =  $(this).val(); //'A1-00001'
	 					    					 var item_split  =  role_id.split("_");
	 							    			   
	 					    					//role_id_comma += item_split[0]+",";
	 					    					//item_comma += item_split[1]+",";
	 					    					  var data = {}
	 					    					
		 					    				//alert(role_id_comma.substring(0,(role_id_comma.length-1)));
		 					    				data["role_id"] = item_split[0] ; 
		 					    				data["role_mapping_id"] = item_split[1]  ; 
		 					    				array_dt.push(data);
 					    				 });
 					    				objList["labCode_No"] =labCode_No ; 
 					    				objList["listRandomOil"] = array_dt;
 					    				
 										 ShowWaiting() ;
 										  jQuery.ajax({
 											url : 'sendRequestAssignRandomOil',
 											type : "Post", 
 											contentType : "application/json",
 											data : JSON.stringify(objList), 
 											dataType : 'json', 
 											success : function(data) {
 										      
 												if(data.success==1){ 
 												  HideWaiting() ;
 														   
 														//  jAlert('success', "ReqNo "+data.hd_no,'บันทึกสำเร็จ'); 
 														 /* $.alert({
 					 				                          title: 'บันทึกสำเร็จ',
 					 				                          icon: 'fa fa-check',
 					 				                          type: 'green',
 					 				                          content: '' ,
 					 				                     });*/
 														 showMsgSuccess('บันทึกสำเร็จ');
 														 gotoMain() ;
 															
 												}else{
 													  HideWaiting() ;
 													 // jAlert('error', data.message,'ข้อมูลผิดพลาด');
 													 /* $.alert({
 				 				                          title: 'ข้อมูลผิดพลาด',
 				 				                          icon: 'fa fa-error',
 				 				                          type: 'red',
 				 				                          content: data.message,
 				 				                     });*/
 													 showMsgError(data.message);
 												}
 											},
 											error : function() {
 												//swal("error");
 												// jAlert('error', '','ข้อมูลผิดพลาด');
 												/* $.alert({
 							                          title: 'ข้อมูลผิดพลาด',
 							                          icon: 'fa fa-error',
 							                          type: 'red',
 							                         content: '',
 							                    });*/
 												 showMsgError('ข้อมูลผิดพลาด');
 												  HideWaiting() ;
 											}
 										 });
 								       
 				       		        },
 				       		          'ยกเลิก': function () {
 		 						            
 		 						       } 	 
 				       		    }
 				       		});
              }else{
             	
     			//jAlert('warning','ไม่พบข้อมูลส่งใบคำขอวิเคราะห์','');
     			/* $.alert({
                       title: 'ไม่พบข้อมูลส่งมอบหมายงาน',
                       icon: 'fa fa-warning',
                       type: 'orange',
                       content: '' ,
                  });*/
     			showMsgWarning('ไม่พบข้อมูลส่งมอบหมายงาน')
     			 HideWaiting() ;
              }
 		} catch (ex) {
 			 
 			// jAlert('error', ex,'ข้อมูลผิดพลาด');
 			/* $.alert({
 		 				                          title: 'ข้อมูลผิดพลาด',
 		 				                          icon: 'fa fa-error',
 		 				                          type: 'red',
 		 				                          content: ex,
 		 				                    });*/
 			 showMsgError('ข้อมูลผิดพลาด');
 			  HideWaiting() ;
 			 
 		}
 		 
      } 
    function gotoMain(){
    	window.location="randomOilForValidate"; 
    }
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>มอบหมายงาน</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>


<div class="wrapper wrapper-content animated fadeInRight"> 
     
    
    <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                   
                       <div class="row">
	                        <div class="col-xs-12">
	                             <div class="table-responsive"  >
							         <table   id="myTableRandomOilDetailId" class="table table-striped table-bordered" style="width: 100%;" role="grid" aria-describedby="tableApproverTask_info">
									 
										<thead>
																	<tr class="tbHeader">
																       <th class="text-center">NO</th>  
																          <th class="text-center">กลุ่มงาน</th>  
									                                    <th class="text-center">รายการวิเคราะห์</th>
									                                
									                                     <th class="text-center">เครื่องมือวิเคราะห์</th> 
									                                       <th class="text-center">method</th> 
																	</tr>
										 </thead>
										<tbody id="randomOilDetailId">
										</tbody>
									</table> 
	                        </div>
	                    </div>
                    </div>
               </div>
            </div> 
        </div>
    </div> 
	  <div class="form-group">
	         <div class="col-sm-6">
	                    <button type="button"
	                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()"   >กลับไปหน้าหลัก
	                      <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
	                    </button>             
	        </div>
	        <div class="col-sm-6"> 
	                     <center><button type="button" id="loginbotttom4"  style="width: 150px;" onclick="sendRequestAssignRandomOil();" 
	                            class="btn btn-primary center-block"> 
	                                                                  มอบหมายงาน <i class="fa fa-send" style="font-size:22px;color:yellow"></i></button></center>   
	         
	        </div>
	        <!-- /.col -->
	 </div>
  </div>
 
 
  
 
