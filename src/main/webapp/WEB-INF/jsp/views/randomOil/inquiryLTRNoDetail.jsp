<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <div class="box box-success box-solid"> -->
<style>
.tbHeader {
	background: #3c8dbc;
	color: white;
}
.TBODY{
	font-size:  10px; 
}
.dtr-details{
	font-size:  10px; 
}
</style>
<script type='text/javascript'>
var roleId = '${sessionScope.C_UserInfo.role_id}';
var table = "",ltrNo = "",labCode="",status="",modeView="";
var dropdown_color = [] ;
var spec = [] ;
    $(document).ready(function () {
     
    	var  url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');    		
		 var ltrNo_v = url[0].split('='); 
		 ltrNo  =  ltrNo_v[1];
    	 
		 var labCode_v = url[1].split('='); 
		 labCode  =  labCode_v[1];
		 
		 var tmp_v = url[2].split('='); 
		 modeView  =  tmp_v[1];
		 
		 inquiryLTRNo(); 
		 
		 setBtn();
    	inquiryLTRNoDetail();
    	if(status=='01'||status=='05'){
			 if((roleId=='A4') || (roleId=='HL') ){
			    inquiryAnalyzeSpec();
			    recalValidatespec();
		     }
		 }
    	
    	//setDropDownSetupColor();
    });
    
    function setBtn(){
    	
    	//alert(status);
    	
      if(modeView!=null&&modeView!=""){
    	   $('#btnSave').hide();
    	   $('#btnSaveSendApproved').hide();
           $('#btnSendBackEdit').hide();
           $('#btnApproved').hide();
           if(roleId=='HL'&& status=='03'){
               $('#btnSendEditApproved').show();
           }else{
        	   $('#btnSendEditApproved').hide();
           }
           $('#btnEditApproved').hide();
           $('#btnUnApproved').hide();
    	  
      }else if(status=='01'||status=='05'){
    	   if((roleId=='A4') || (roleId=='HL')){
     		  
        	   $('#btnSave').hide();
        	   $('#btnSaveSendApproved').show();
    	   }else{
    		   $('#btnSave').show();
        	   $('#btnSaveSendApproved').hide();
    	   }
           $('#btnSendBackEdit').hide();
           $('#btnApproved').hide();
           $('#btnSendEditApproved').hide();
           $('#btnEditApproved').hide();
           $('#btnUnApproved').hide();
       }else if(status=='02'){
    	   $('#btnSave').hide();
    	   $('#btnSaveSendApproved').hide();
           $('#btnSendBackEdit').show();
           $('#btnApproved').show();
           $('#btnSendEditApproved').hide();
           $('#btnEditApproved').hide();
           $('#btnUnApproved').hide();
       }else if(status=='03'){
    	   $('#btnSave').hide();
    	   $('#btnSaveSendApproved').hide();
           $('#btnSendBackEdit').hide();
           $('#btnApproved').hide();
           if(roleId=='HL'){
               $('#btnSendEditApproved').show();
           }else{
        	   $('#btnSendEditApproved').hide();
           }
           $('#btnEditApproved').hide();
           $('#btnUnApproved').hide();
       }else if(status=='04'){
    	   $('#btnSave').hide();
    	   $('#btnSaveSendApproved').hide();
           $('#btnSendBackEdit').hide();
           $('#btnApproved').hide();
           $('#btnSendEditApproved').hide();
           if(roleId=='ML'){
               $('#btnEditApproved').show();
               $('#btnUnApproved').show();
           }else{
        	   $('#btnEditApproved').hide();
        	   $('#btnUnApproved').hide();
           }
          
       }
 
    }
    function getThaiBuddaDate(date){
		var rtnDate = "";
		var data = {}
		data["poDate"] = date; 
		jQuery.ajax({
			url : 'getThaiBuddaDate',
			type : 'Post',
			async: false,
			   cache: false,
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(obj) {
				rtnDate  = obj.poDate;
			}
		}).fail(function(){
			/*swal('Error...', 'เกิดข้อผิดพลาด!',
				'error');*/
			showMsgError('ข้อมูลผิดพลาด');
				//ShowErrorMsg('0006', ex);
				//HideWaiting();
		   });	
		
		return rtnDate
	}
    function inquiryLTRNo(){
    	try {
     		//alert("1"+ltrNo);
     		
     		    
     		       //alert(ltrNo);
 		    			var data = {}
 		    		 
 		    			 data["ltrNo"] = ltrNo
 					  jQuery.ajax({
 						url : 'inquiryLTRByLTRNO',
 						type : "Post", 
 						contentType : "application/json",
 						data : JSON.stringify(data), 
 						dataType : 'json',
 						  async: false,
 						   cache: false,
 						success : function(data) {
 							
 							for(var i = 0; i < data.list.length; i++) {
 								///alert(data.list[i].RESULT_STATUS);
 							   status=data.list[i].RESULT_STATUS;
 							   var ltrResult=data.list[i].RESULT_LTR;
 							   if(ltrResult!=null&&ltrResult!=''){
	 							  	if(ltrResult=='N'){
	 					        		$("#ltrResult").val(ltrResult);
	 					        		$("#ltrResultDesc").html("ไม่ผ่านการทดสอบ");
	 					        		$("#ltrResultDesc").css('color','red');
	 					        	}else{	
	 						        	 
	 						        			  $("#ltrResult").val('Y');
	 						              		  $("#ltrResultDesc").html("ผ่านการทดสอบ");
	 						              		$("#ltrResultDesc").css('color','green');
	 						         }
 							   }
 							}
 						},
 						error : function() {
 						
 							 showMsgError('เกิดข้อผิดพลาด');
 						}
 					});
     			   
 		} catch (ex) {
 		
 			 showMsgError(ex);
 		}
    }
    function inquiryAnalyzeSpec(){
    	try {
     		//alert("1"+ltrNo);
     		 
     		      // alert(labCode);
 		    			var data = {}
 		    		 
 		    			 data["labCode_No"] = labCode
 					  jQuery.ajax({
 						url : 'inquiryAnalyzeSpec',
 						type : "Post", 
 						contentType : "application/json",
 						data : JSON.stringify(data), 
 						dataType : 'json',
 						  async: false,
 						   cache: false,
 						success : function(data) {
 							
 							spec =   data.list ;
 						 
 						},
 						error : function() {
 						
 							 showMsgError('เกิดข้อผิดพลาด');
 						}
 					});
     			   
 		} catch (ex) {
 		
 			 showMsgError(ex);
 		}
    }
    function setEventBtn(id){
    	if($('#ltrResult_'+id).val()!=''){
    	     $('#desc_'+id).val('');
    	}
    }
    function recalValidatespec(){
    	var cntValue = 0,cntItem=0,cntPassTrue=0 ,ltrResult = "";
        	$("input[name='ltrDteNo']").each(function() { 
     	          var  ltrDteNo  = $(this).val() ;
     	         
     	          var id_material = $('#id_material_'+ltrDteNo).val();
     	          var result = $('#ltrResult_'+ltrDteNo).val();
     	          cntItem++;
     	        //  alert(id_material+','+result);
     	          if(result!=''){
	     	        	 cntValue++;
		     	         if(validateResult(id_material,result)=='N'){
		     	        	ltrResult = "N" ;
		     	        	 return false;
		        	     }else{
		        	    	 cntPassTrue++;
		        	     }
     	          }
     	           
    	    });
        	//alert(ltrResult);
        	if(ltrResult=='N'){
        		$("#ltrResult").val(ltrResult);
        		$("#ltrResultDesc").html("ไม่ผ่านการทดสอบ");
        		$("#ltrResultDesc").css('color','red');
        	}else{	
	        	if(cntItem==cntValue){
	        		  if(cntValue==cntPassTrue){
	        			  $("#ltrResult").val('Y');
	              		  $("#ltrResultDesc").html("ผ่านการทดสอบ");
	              		$("#ltrResultDesc").css('color','green');
	        		  }else{
	        			  $("#ltrResult").val('');
	              		  $("#ltrResultDesc").html('');
	        		  }
	        	}else{
      			  $("#ltrResult").val('');
          		  $("#ltrResultDesc").html('');
    		    }
        	}
    }
    function validateResult(id_material,result){
    	    var rtnValue = "N";
    	  // alert(spec.length);
           for(var i=0;i<spec.length;i++){
        	    // alert(spec[i].ID_MATERIAL+','+id_material);
        	     if(spec[i].ID_MATERIAL==id_material){
        	    	  if(id_material=='00001'||id_material=='00002'){
        	    		//     alert(spec[i].COLOR);
        	    	//	     alert(result);
        	    		  if(result==spec[i].COLOR){
        	    			  rtnValue = 'Y'
        	    		  }else{
        	    			  rtnValue = 'N'
        	    		  }
        	    		  
        	    	  }else{
        	    		//   alert(spec[i].MIN+'>.<'+spec[i].MAX);
      	    		   // alert(result);
        	    		  if(result>=spec[i].MIN&&result<=spec[i].MAX){
        	    			  rtnValue = 'Y'
        	    		  }else{
        	    			  rtnValue = 'N'
        	    		  }
        	    		  
        	    	  }
        	    	  break;
        	     }
           }	
    	
           return rtnValue;
    } 
    function inquiryLTRNoDetail(){
    	
     	 try {
     		//alert("1"+ltrNo);
     		
     		      $('#dteId').html("");
     		   //  alert("2"+ltrNo);
    		       $('#myTableDteId').DataTable().destroy();
     		    //   alert(ltrNo);
 		    			var data = {}
 		    		 
 		    			 data["ltrNo"] = ltrNo
 					  jQuery.ajax({
 						url : 'inquirySaveResultAnalysisOil',
 						type : "Post", 
 						contentType : "application/json",
 						data : JSON.stringify(data), 
 						dataType : 'json',
 						  async: false,
 						   cache: false,
 						success : function(data) {
 					    
 							if(data.success==1){
 							 var det = "";
 							              dropdown_color = [];
 										 for(var i = 0; i < data.list.length; i++) {
 										     var disabled = "";	  
 										  //   alert(modeView);
 										    if(modeView!=null&&modeView!=""){
 										    	
 										    	     disabled = "disabled";
 	 											 
 										    }else{
	 											 if(roleId!=(data.list[i].ROLE==null?"":data.list[i].ROLE)){
	 												disabled = "disabled";
	 											 }
	 											 if(roleId=='A4'){//A4 edit all record
	 												disabled = "";	 
	 											 }
 										    }
 											det +='<tr >';
 											det +='<td class="text-left" >'+ (i+1)+'</td>'; 
 										 	det +='<td class="text-center" >'+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'</td>'; 
 										 	det +='<td class="text-left" >'+ (data.list[i].LTR_NO==null?"":data.list[i].LTR_NO)+'</td>';
 										 	det +='<td class="text-left" >'+ (data.list[i].DESC_ANALYZE==null?"":data.list[i].DESC_ANALYZE)+'</td>'; 
 										 	det +='<td class="text-left" >'+(data.list[i].MATERIAL_ANALYZE==null?"":data.list[i].MATERIAL_ANALYZE)+'</td>'; 
 											det +='<td class="text-left" >'+(data.list[i].METHOD==null?"":data.list[i].METHOD)+'</td>'; 
 										    var ltrDteNo = (data.list[i].LTR_NO_DTE==null?"":data.list[i].LTR_NO_DTE);
 										   var color = (data.list[i].COLOR==null?"":data.list[i].COLOR);
 										   var id_material = (data.list[i].ID_MATERIAL==null?"":data.list[i].ID_MATERIAL);
 										    var result = (data.list[i].RESULT==null?"":data.list[i].RESULT); 
 										   // alert(result);
 											det +='<td class="text-left" ><input type="hidden" name="ltrDteNo" id="ltrDteNo" value="'+ltrDteNo+'" />    ';
 											det +='<input type="hidden" name="id_material" id="id_material_'+ltrDteNo+'" value="'+id_material+'" />     ' ;
 											if(id_material!='00001'&&id_material!='00002'){
 											   det +='<input type="text" '+disabled+' onkeypress="return isNumber(event)"  onchange="recalValidatespec();return setCommaById(this);"    name="ltrResult" id="ltrResult_'+ltrDteNo+'" value="'+result+'" />'; 
 											}else{
 											   det += ' <select '+disabled+'  name="ltrResult" id="ltrResult_'+ltrDteNo+'"  onchange="recalValidatespec();setEventBtn('+ltrDteNo+');"   class="form-control" style="width: 100%;"   > <option value="">==เลือก==</option>  </select>';
 												//setDropDownSetupColor('spec_'+ltrDteNo) ;
 												//$('#spec_'+ltrDteNo ).val(spec);
 												 var dataDte = {} 
 												dataDte["result"] = color;
 												dataDte["id"] = 'ltrResult_'+ltrDteNo;
 											     dropdown_color.push(dataDte);
 											}
 											det +=' </td> '; 
 											det +=' <td class="text-left" >'; 
 											if(id_material=='00001'||id_material=='00002'){
 										    det +='<input type="text" '+disabled+' name="desc" id="desc_'+ltrDteNo+'" value="'+(data.list[i].COLOR_DESC==null?"":data.list[i].COLOR_DESC)+'" />';
 											}
 										   det +='</td>';  
 										  
 											 
 											/*det +='<td class="text-left" ><input type="button" value="ยืนยัน" onclick="editdata(\''
  												+ (data.list[i].LTR_NO==null?"":data.list[i].LTR_NO)
  												+ '\',\''+ltrDteNo 
  												+ '\')" ></td>';
 									 */
 											det +='</tr>';
 										}
 										// alert(det);
 										if(det==''){
 											det += '<tr> ';
 											det += '<th colspan="8" class="text-center">--- ไม่พบข้อมูล ---</th> ';
 											det += '</tr> ';
 											$('#dteId').html(det);
 											  
 										}else{
 										//	alert('#dteId_'+nameStore);
 											$('#dteId').html(det);
 											table =  $('#myTableDteId').DataTable( {
 												searching: true,
 												responsive : true
 											});
 											
 										} 
 										
 										for(var i=0 ;i<dropdown_color.length;i++){
 											
 											 setDropDownSetupColor(dropdown_color[i].id);
 											// alert(dropdown_color[i].result);
 											 $('#'+dropdown_color[i].id).val(dropdown_color[i].result);
  										}
 							}else{
 							 
 								
 								 showMsgError(data.message);
 							}
 						},
 						error : function() {
 						
 							 showMsgError('เกิดข้อผิดพลาด');
 						}
 					});
     			   
 		} catch (ex) {
 		
 			 showMsgError(ex);
 		}
     	 
     } 
     function setDropDownSetupColor(id){
    	 try {
    		 
    		 
    		 
    		 var data = {}
			  jQuery.ajax({
				url : 'util-getDropDownSetupColor',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {
					//alert("success");
				     $('#'+id).find('option').remove().end();
		 
				    var select = document.getElementById(id);
					var opt = document.createElement('option');
					opt.value = "";
					opt.style ='';
					opt.innerHTML = "==เลือก==";
					select.appendChild(opt);
					 
				 
					 var	opt = "" ;
					// alert(data.length);
					for (var i = 0; i < data.length; i++) {
					//	alert(data[i].ID);
					 	var opt = document.createElement('option');
						opt.value = data[i].ID;
						opt.innerHTML = data[i].COLOR_NAME;
						select.appendChild(opt); 
					}            
					
			 
			 
				},
				error : function(ex) {
					//swal("error");
					showMsgError(ex);
				}
			});

		} catch (ex) {
			//swal(ex);
			showMsgError(ex); 
			 
		}
     }
     
    function editdata(status){
    	  
     	 try {   
     		 var err = false;
     		 if(roleId=='A4'||roleId=='a4'){
	     			$("input[name='ltrDteNo']").each(function() { 
	       	          var  ltrDteNo  = $(this).val() ;
	       	          
	       	          var result = $('#ltrResult_'+ltrDteNo).val();
				     		 if(result==''||result==0){
				     			err = true;
				     			return false;
				     		 }
	     			}); 	
	     			if(err){
	     				
	     				 showMsgWarning('กรุณาระบุผลการทดสอบให้ครบ');
	     				return false;
	        		 }
     		 }
     		 
     		 
     		 $.confirm({
      		    title: 'ยืนยันบันทึกงาน',
      		    icon: 'fa fa-exclamation-circle',
                  type: 'blue',
      		    content: '',
      		    buttons: {
      		     'ยืนยัน': function () {
     		                 var objList = {} 
     		                  var array_dt = []
		 		    		
     		                  $("input[name='ltrDteNo']").each(function() { 
     		                	    var  ltrDteNo  = $(this).val() ;
     		                	  //  alert(ltrDteNo);  
	     		                	var isdisabled   = $("#ltrResult_"+ltrDteNo).is(':disabled') ;
	     		                	//alert(isdisabled); 
	     						    if(!isdisabled){
	     						   
	     						   
		     		                   var data = {}
				 		    		//	alert( $("#ltrResult_"+ltrDteNo).val());
				 		    			data["ltrResult"] =  $("#ltrResult_"+ltrDteNo).val(); 
		     		                  	data["id_material"] =   $("#id_material_"+ltrDteNo).val(); 
				 		    			data["desc"] =  $("#desc_"+ltrDteNo).val(); 
				 		    			data["ltrNo"] =  ltrNo; 
				 		    			data["ltrDteNo"] =  ltrDteNo; 
				 		    		  
				 		    			array_dt.push(data);
	     						    } 	 
				 		    		     
      						 });
     		                 
     		                 
     		                objList["ltrNo"] = ltrNo ;
     		                  objList["status"] = status ;
     		                 objList["result"] =  $("#ltrResult").val() ;
		 		    		 objList["listRandomOil"] = array_dt;
		 		    			
		 					  jQuery.ajax({
		 						url : 'updateLtrDTE',
		 						type : "Post", 
		 						contentType : "application/json",
		 						data : JSON.stringify(objList), 
		 						dataType : 'json',
		 						  async: false,
		 						   cache: false,
		 						success : function(data) {
		 					// alert(data.success);
		 							if(data.success==1){
		 								      
									         	 showMsgSuccess('บันทึกสำเร็จ');
		 									 
		 											//	 $("#labCode").val('');
		 											/*if(status=='02'){
		 												gotoMain();
		 											}else{
		 											 	inquiryLTRNoDetail(); 
		 											} */
									         	history.back();
		 							}else{
		 							  
		 								 showMsgError(data.message);
		 								 
		 							}
		 						},
		 						error : function() {
		 							 
		 							 showMsgError('ข้อมูลผิดพลาด');
		 						}
		 				     });
		      	        },
		  		          'ยกเลิก': function () {
					            
					       } 	 
		  		    }
		  		});			  
     	 
 		} catch (ex) {
 			 
 			 showMsgError(ex);
 		}
     	 
    } 
    function updateStatus(status){
   	 
    	 
    	 try {
    		
    	  
    			  
	  		   
		 		    			var data = {}
		 		    			data["status"] = status;
		 		    			data["ltrNo"] =  ltrNo; 
		 		    		 
		 					  jQuery.ajax({
		 						url : 'updateStatusLTRNO',
		 						type : "Post", 
		 						contentType : "application/json",
		 						data : JSON.stringify(data), 
		 						dataType : 'json',
		 						  async: false,
		 						   cache: false,
		 						success : function(data) {
		 					 
		 							if(data.success==1){
		 								        
									         	 showMsgSuccess('บันทึกสำเร็จ');
		 									 
									         	//gotoMain();
									         	history.back();
		 								 
		 							}else{
		 							     // jAlert('error',  data.message,'บันทึกข้อมูลผิดพลาด');
		 							    /* $.alert({
					                          title: 'ข้อมูลผิดพลาด',
					                          icon: 'fa fa-error',
					                          type: 'red',
					                          content: data.message,
					                      });*/
		 								 showMsgError(data.message);
		 								 /*swal({
		 									  title: "บันทึกข้อมูลผิดพลาด",
		 									  type: "error",
		 									  text:data.message,
		 									  showCancelButton: false,
		 									  confirmButtonColor: "#DD6B55",
		 									  confirmButtonText: "ตกลง",
		 									  closeOnConfirm: false
		 									});*/
		 							}
		 						},
		 						error : function() {
		 							//swal("error");
		 							 /* $.alert({
		 				                   title: 'error',
		 				                   icon: 'fa fa-error',
		 				                   type: 'red',
		 				                   content: 'ข้อมูลผิดพลาด',
		 				               });*/
		 							 showMsgError('ข้อมูลผิดพลาด');
		 						}
		 				     });
    	 
		} catch (ex) {
			//swal(ex);
			 
			 /* $.alert({
                 title: 'error',
                 icon: 'fa fa-error',
                 type: 'red',
                 content: 'ข้อมูลผิดพลาด',
             });*/
			 showMsgError(ex);
		}
    	 
   } 
    function gotoMain(){
     	window.location="initInquiryLTRNo"; 
     }
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>ผลการทดสอบ(LAB Officer)</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>
 
<div class="wrapper wrapper-content animated fadeInRight"> 
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">   ผลการทดสอบ :
	                              <span id="ltrResultDesc"></span> 
                                           <input type="hidden" name="ltrResult" id="ltrResult" value="" /> 
                </div>
                
            </div>
        </div>
    </div>
   

    <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                  <div class="ibox-title">
	                   
	                        <div class="ibox-tools">
	                               
		                              <a class="collapse-link"> <i class="fa fa-chevron-up"></i>
		                              </a>
                            </div>
                 </div>
                 <div class="ibox-content">
                
                    
                       <div class="row">
	                        <div class="col-xs-12" >
	                             <div class="table-responsive"   >
							         <table   id="myTableDteId" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
										<thead  class="tbHeader">
										 
																	<tr>  <th class="text-center">NO</th>
																	      <th class="text-center">LAB_CODE</th>
																	           <th class="text-center">LTR_NO</th>
																	         
																	        <th class="text-center">รายการวิเคราะห์</th>
																	        <th class="text-center">เครื่องมือวิเคราะห์</th>
																	     	  <th class="text-center">Method</th>
																	          <th class="text-center">Result</th>
																	        <th class="text-center">รายละเอียด</th> 
														 
																	</tr>
										 </thead>
										<tbody id="dteId" >
										</tbody>
									</table> 
								 </div>
	                        </div>
	                    </div>
                       <div class="row">
	                         <div class="col-sm-12">
	                                 <div class="col-sm-8">&nbsp;
	                                 </div>
	                                  <div class="col-sm-4">
                                         
	                                 </div>
	                          </div>
	                    </div>
                </div>
            </div> 
        </div>
    </div> 
	<div class="form-group">
	 
	        <div class="col-sm-12">
	             <div class="col-sm-4">
		            <button type="button"
		                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()" 
		            >กลับไปหน้าหลัก&nbsp;
		                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
		            </button>
		        </div>
		        <div class="col-sm-4">
	                 <center>
	                        <div id="btnSave">
				                 <button type="button"   style="width: 150px;" onclick="editdata('01');" 
				                            class="btn btn-primary center-block">
				                                                       ยืนยันข้อมูล
				                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button>
			                </div> 
			                <div id="btnSaveSendApproved">
				                 <button type="button"    style="width: 150px;" onclick="editdata('02');" 
				                            class="btn btn-primary center-block">
				                                                             ส่งอนุมัติ                                     
				                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button>
			                </div> 
			                 <div id="btnSendBackEdit">
			                
				                <button type="button"    style="width: 150px;" onclick="updateStatus('05');" 
				                            class="btn btn-primary center-block">
				                                                             ส่งกลับแก้ไข                                     
				                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button>
			                </div> 
			                 <div id="btnUnApproved">
				                 <button type="button"   style="width: 150px;" onclick="updateStatus('03');" 
				                            class="btn btn-primary center-block">
				                                                            ไม่อนุมัติ                                     
				                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button>
			                </div> 
			         </center>
			     </div>   
			       
	             <div class="col-sm-4">               
			              
			                <div id="btnApproved">
				                 <button type="button"   style="width: 150px;" onclick="updateStatus('03');" 
				                            class="btn btn-primary center-block">
				                                                            อนุมัติ                                     
				                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button>
			                </div> 
			                 <div id="btnEditApproved">
				                 <button type="button"   style="width: 150px;" onclick="updateStatus('07');" 
				                            class="btn btn-primary center-block">
				                                                            อนุมัติงานแก้ไข                                     
				                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button>
			                </div> 
			                <div id="btnSendEditApproved">
				                 <button type="button"   style="width: 150px;" onclick="updateStatus('04');" 
				                            class="btn btn-primary center-block">
				                                                            ส่งอนุมัติแก้ไข                                     
				                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button>
			                </div> 
	                
	             </div>  
	        </div> 
    </div>
	
	
  </div>
 
 
 
