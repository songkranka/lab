<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <div class="box box-success box-solid"> -->
<style>
.tbHeader {
	font-size:  9px;
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
var table = "";
    $(document).ready(function () {
     
    	/*$('#poDate').val(getThaiBuddaDate());
    	 
    $('#ddlStore').multiselect({
    
    	        includeSelectAllOption: true 
    	    });
    	
    	 $('#ddlProduct').multiselect({
    	
    	        includeSelectAllOption: true 
    	    });
    	  
    	 $('#ddlLogistic').multiselect({
    		
    	        includeSelectAllOption: true 
    	    }); 
    	 
    	SetDropDownStore();
    	SetDropDownProduct();
    	SetDropDownLogistic();
    	*/
    	 cntWaitingRandomLastResult();
    	inquiryRandomOil();
   
    	/*
    	$(".select_Lab").click(function() {
    		
    		var checkBoxName = this.id.split("_")[1];
    		var boxName = "lab"+checkBoxName;
    		//alert(checkBoxName + " \n " + boxName);
    		
    		
    	});
    	*/
    	
    });
    function getThaiBuddaDate(date) {
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
    function cntWaitingRandomLastResult(){
		var rtnDate = "";
		var data = {}
		 
		jQuery.ajax({
			url : 'cntWaitingRandomLastResult',
			type : 'Post',
			async: false,
			   cache: false,
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(obj) {
				$('#cntRandomSample').html(obj.cnt);
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
     function saveRandomOil(){
    	try{
    
    	// det = "";
 		$('#tb-body-import-id').html("");
 		 $('#myTableSum').DataTable().destroy();
 	 
 		  
    		 		 ShowWaiting() ;
    			 
		    			var data = {}
		    		 
					  jQuery.ajax({
						url : 'insertRandomLastResult',
						type : "Post", 
						contentType : "application/json",
						data : JSON.stringify(data), 
						dataType : 'json',
						 // async: false,
						//   cache: false,
						success : function(data) {
					      
							if(data.success==1){ 
							  HideWaiting() ;
									 
										 		   $('#popup_random').modal('show');
											 
										var det = "";
										for (var i = 0; i < data.list.length; i++) {
										 	 
										 
											det +='<tr  >'; 
											 
											det +='<td class="text-left" >'+(data.list[i].plant_name==null?"":data.list[i].plant_name)+'</td>';
											
											det +='<td class="text-center" >'+(data.list[i].strPO_DATE==null?"":data.list[i].strPO_DATE)+'</td>'; 
											det +='<td class="text-right" >'+(data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
											det +='<td class="text-left" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
										//	det +='<td class="text-right" >'+(data.list[i].OWNER_PRODUCT_OIL==null?"":data.list[i].OWNER_PRODUCT_OIL)+'</td>';
										//	det +='<td class="text-center" >'+(data.list[i].OWNER_LOGISTIC==null?"":data.list[i].OWNER_LOGISTIC)+'</td>';
											det +='<td class="text-center" >'+(data.list[i].CNT_SUBSET==null?"":data.list[i].CNT_SUBSET)+'</td>';
										 
										
											  
											det +='</tr>';
										}
									
										if(det==''){
											det += '<tr> ';
											det += '<th colspan="5" class="text-center">--- ไม่พบข้อมูล ---</th> ';
											det += '</tr> ';
											$('#tb-body-import-id').html(det);
											  
										}else{
											  
											$('#tb-body-import-id').html(det);
											 table =  $('#myTableSum').DataTable( {
												searching: true,
												responsive : true
											}); 
											
										}
										 cntWaitingRandomLastResult();
										/*  $.alert({
	 				                          title: 'เรียบร้อยเเล้ว',
	 				                          icon: 'fa fa-check',
	 				                          type: 'green',
	 				                          content: "" ,
	 				                     });*/
												 inquiryRandomOil();
										
							}else if(data.success==2){ 
								  HideWaiting() ;
								  var  msg  = getMsg("MSG1");
							 
								 
								 /*$.alert({
			                          title: 'warning',
			                          icon: 'fa fa-warning',
			                          type: 'orange',
			                          content: msg,
			                      });*/
								 showMsgWarning(msg);
							}else{
								 
								  HideWaiting() ;
								  /*$.alert({
			                          title: 'เกิดข้อผิดพลาด',
			                          icon: 'fa fa-error',
			                          type: 'red',
			                          content: data.message,
			                      });*/
								  showMsgError(data.message);
								
							}
						},
						error : function(ex) {
							 
							 
							/*  $.alert({
		                          title: 'เกิดข้อผิดพลาด',
		                          icon: 'fa fa-error',
		                          type: 'red',
		                          content: ex,
		                      });*/
							  showMsgError('เกิดข้อผิดพลาด');
							  HideWaiting() ;
						}
					});
			 

		} catch (ex) {
			 /*$.alert({
                 title: 'เกิดข้อผิดพลาด',
                 icon: 'fa fa-error',
                 type: 'red',
                 content: ex,
             });*/
			 
			 showMsgError('เกิดข้อผิดพลาด');
			  HideWaiting() ;
			 
		}
		 
     } 
     function inquiryRandomOil(){
    	 
     	// det = "";
  		
  	 
  		//alert($("#ddlStore").val());
     	 try {
     	
     		  $("input[name='hidden_namestore']").each(function() { 
				 // alert($(this).val());
				 var nameStore   =  $(this).val();
				 
     		      $('#dteId_'+nameStore).html("");
     	  	 
    		       $('#myTableDteId_'+nameStore).DataTable().destroy();
     		 
 		    			var data = {}
 		    			//alert($(this).val());
 		    			data["nameStore"] = $(this).val();
 		    			
 					  jQuery.ajax({
 						url : 'inquiryRandomLastResult',
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
 										 	  //console.log("data["+i+"] = "+JSON.stringify(data.list[i]));
 										 	  //console.log(" ");
 										 	  //console.log(" ");
											var delim = "|";
 										 	var paramMethodGet = ""
 	 											+ (data.list[i].PLANT_ID==null?"":data.list[i].PLANT_ID)+delim
 	 											+ i +delim
 	 											+ (data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+delim
 	 											+ (data.list[i].PRODUCT_CODE==null?"":data.list[i].PRODUCT_CODE)+delim
 	 											+ (data.list[i].SAMPLE_TYPE_NAME==null?"":data.list[i].SAMPLE_TYPE_NAME)
 	 											;
 										 	
											//var paramMethodGet = ""
											//+ (data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)
											//;
 											det +='<tr class="TBODY" >';
 											det +='<td class="text-left" >'+ (i+1)+'</td>';
 											
 											if(data.list[i].ASSIGN_STATUS==null || data.list[i].ASSIGN_STATUS=="") {
 												det +='<td class="text-center"> <input id="eachChk'+nameStore+'_'+i+'" type="checkbox" name="lab'+nameStore+'"  class="chk'+nameStore+'" value = "'+paramMethodGet+'" > </td>';	
 												//det +='<td class="text-center"> <input id="eachChk'+nameStore+'_'+i+'" type="checkbox" name="lab'+nameStore+'"  class="chk'+nameStore+'" value = "'+nameStore+'|'+i+'|'+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'|'+(data.list[i].PRODUCT_CODE==null?"":data.list[i].PRODUCT_CODE)+'|'+(data.list[i].SAMPLE_TYPE_NAME==null?"":data.list[i].SAMPLE_TYPE_NAME)+'" > </td>';	
 	 										} else if (data.list[i].ASSIGN_STATUS == "1"){
 												det +='<td class="text-center"> <span class="glyphicon glyphicon-ok" style="color:blue"></span> </td>';
 											}
 											
											delim = ",";
 										 	paramMethodGet = ""
 	 											+ (data.list[i].PLANT_ID==null?"":data.list[i].PLANT_ID)+delim
 	 											+ i +delim
 	 											+ (data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+delim
 	 											+ (data.list[i].PRODUCT_CODE==null?"":data.list[i].PRODUCT_CODE)+delim
 	 											+ (data.list[i].SAMPLE_TYPE_NAME==null?"":data.list[i].SAMPLE_TYPE_NAME)
 	 											;
												
 										 	det +='<td class="text-center" > <a href="assignmentTaskLastResult?labCode_No='+paramMethodGet+' ">'+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'</a></td>';
 										 	det +='<td class="text-left" >'+ (data.list[i].SAMPLE_REFER==null?"":data.list[i].SAMPLE_REFER)+'</td>';
 										 	det +='<td class="text-left" >'+ (data.list[i].STATUS_DESC==null?"":data.list[i].STATUS_DESC)+'</td>';
 											
 										 	det +='<td class="text-left" >'+(data.list[i].PO_NO==null?"":data.list[i].PO_NO)+'</td>'; 
 											det +='<td class="text-left" >'+(data.list[i].STRPO_DATE==null?"":data.list[i].STRPO_DATE)+'</td>'; 
 											det +='<td class="text-left" >'+(data.list[i].DO_NO==null?"":data.list[i].DO_NO)+'</td>'; 
 											det +='<td class="text-left" >'+(data.list[i].SHIPMENT_NO==null?"":data.list[i].SHIPMENT_NO)+'</td>';  
 											det +='<td class="text-left" >'+(data.list[i].SAMPLE_DATA_GROUP==null?"":data.list[i].SAMPLE_DATA_GROUP)+'</td>'; 
 											det +='<td class="text-left" >'+(data.list[i].SAMPLE_DATA_SEQ==null?"":data.list[i].SAMPLE_DATA_SEQ)+'</td>'; 
 											
 											var color = (data.list[i].COLOR_FLAG==null?"green":data.list[i].COLOR_FLAG) ;
 											 
 											det +='<td class="text-left" ><span class="glyphicon glyphicon-oil" style="color:'+color+'"></span></td>'; 
 											
 											det +='<td class="text-left" >'+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)+'</td>';
 											det +='<td class="text-left" >'+(data.list[i].CAR_SLOT==null?"":data.list[i].CAR_SLOT)+'</td>';
 											
 											det +='<td class="text-center" >&nbsp;</td>';
 											det +='<td class="text-center" >&nbsp;</td>';
 											det +='<td class="text-center" >&nbsp;</td>';
 											
 											
 											det +='<td class="text-center" >'+(data.list[i].STR_SAMPLE_DATE==null?"":data.list[i].STR_SAMPLE_DATE)+'</td>';
 											det +='<td class="text-center" >'+(data.list[i].STR_SAMPLE_EXPIRE_DATE==null?"":data.list[i].STR_SAMPLE_EXPIRE_DATE)+'</td>';
 											det +='<td class="text-left" >'+ (data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
 											det +='<td class="text-left" >'+(data.list[i].source_name==null?"":data.list[i].source_name)+'</td>'; 
 											det +='<td class="text-left" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
 											det +='<td class="text-leftr" >'+(data.list[i].SAMPLE_LEVEL_DESC==null?"":data.list[i].SAMPLE_LEVEL_DESC)+'</td>';
 											det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_ID==null?"":data.list[i].SAMPLE_STAFF_ID)+'</td>';
 											det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_NAME==null?"":data.list[i].SAMPLE_STAFF_NAME)+'</td>';
 											det +='</tr>';
 											det +='</tr>';
 										}
 										// alert(det);
 										if(det=='') {
 											det += '<tr> ';
 											det += '<th colspan="25" class="text-center">--- ไม่พบข้อมูล ---</th> ';
 											det += '</tr> ';
 											$('#dteId_'+nameStore).html(det);
 											 											
 										}else{
 										//	alert('#dteId_'+nameStore);
 											$('#dteId_'+nameStore).html(det);
 											table =  $('#myTableDteId_'+nameStore).DataTable( {
 												searching: true,
 												responsive : true
 											});
											/*
 											$(".chkHead").click(function() {
 									    		//alert(this.id);
 									    		var checkid = this.id;
 									    		var plant = checkid.split("_")[1];
 									    		var checkLen = $("input[name=head"+plant+"]:checked" ).length;
 									    		
 									    		$("input[name=lab"+plant+"]" ).each(function () {
 									    			var val = this.value;
 									    			var eachIdBox = "eachChk"+val.split("|")[0]+"_"+val.split("|")[1];
 									    			//alert(checkLen+"|"+eachIdBox);
 									    			if( checkLen==0 ) {
 									    				var elm = $("#"+eachIdBox).attr("checked");
 									    				if(typeof elm != 'undefined') {
 									    					$("#"+eachIdBox).removeAttr("checked");
 									    				}
 									    			} else if( checkLen==1 ) {
 									    				//alert("checkLen = "+checkLen);
 									    				$("#"+eachIdBox).attr("checked",true);
 									    			}
 									        		
 												});
 									    		
 									    	});
 											*/
 											$("#head_").click(function() {
 									    		//alert(this.id);
 									    		var checkid = this.id;
 									    		var plant = checkid.split("_")[1];
 									    		var checkLen = $("input[name=head"+plant+"]:checked" ).length;
 									    		
 									    		$("input[name=lab"+plant+"]" ).each(function () {
 									    			var val = this.value;
 									    			var eachIdBox = "eachChk"+val.split("|")[0]+"_"+val.split("|")[1];
 									    			//alert(checkLen+"|"+eachIdBox);
 									    			if( checkLen==0 ) {
 									    				var elm = $("#"+eachIdBox).attr("checked");
 									    				if(typeof elm != 'undefined') {
 									    					$("#"+eachIdBox).removeAttr("checked");
 									    				}
 									    			} else if( checkLen==1 ) {
 									    				//alert("checkLen = "+checkLen);
 									    				$("#"+eachIdBox).attr("checked",true);
 									    			}
 									        		
 												});
 									    		
 									    	});
 											
 										} 
 							}else{
 							 
 								 /* $.alert({
			                          title: 'เกิดข้อผิดพลาด',
			                          icon: 'fa fa-error',
			                          type: 'red',
			                          content: data.message,
			                      });*/
 								 showMsgError(data.message);
 							}
 						},
 						error : function() {
 						//	swal("error");
 							/*  $.alert({
		                          title: 'เกิดข้อผิดพลาด',
		                          icon: 'fa fa-error',
		                          type: 'red',
		                          content: '',
		                      });*/
 							 showMsgError('เกิดข้อผิดพลาด');
 						}
 					});
     		 });	   
 		} catch (ex) {
 			//swal(ex);
 			  /*$.alert({
                  title: 'เกิดข้อผิดพลาด',
                  icon: 'fa fa-error',
                  type: 'red',
                  content: ex,
              });*/
 			 showMsgError(ex);
 		}
     	 
     } 
 function updateStatus(status){
    	 
     	 
     	 try {
    			var data = {}
    			data["status"] = status;
    			data["labCode_No"] =  $("#labCode").val(); 
    		 
			  jQuery.ajax({
				url : 'updateStatusRandomOilDTE',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {
			 
					if(data.success==1){
						         //jAlert('success', 'บันทึกสำเร็จ');
						        
				         	 /* $.alert({
			                          title: 'บันทึกสำเร็จ',
			                          icon: 'fa fa-check',
			                          type: 'green',
			                          content: '',
			                      });*/
				         	 showMsgSuccess('บันทึกสำเร็จ');
								/* swal({
									  title: "บันทึกสำเร็จ",
									  type: "success", 
									  confirmButtonColor: "#5cb85c", 
									  confirmButtonText: "ตกลง" 
									},
									function(){*/
										 $("#labCode").val('');
									inquiryRandomOil(); 
									//});
						 
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
	 function report(){
	 	var ctx = "${pageContext.request.contextPath}";
	 	var link = ctx+"/reportHome";
	 	// 		window.location.href = link;
	 			window.open(link, '_blank');
	 } 
	 function reload(){
	 	var ctx = "${pageContext.request.contextPath}";
	 	var link = ctx+"/randomOilForValidate";
	 	 		window.location.href = link;
	 			//window.open(link, '_blank');
	 }
	 function labAssignment_bm(plant){
		ShowWaiting();
		var obj = {};
		obj["plantid"] = plant;
		
		//console.log("param before labAssign : "+JSON.stringify(obj));
		var url = "getAllTask";
		ShowWaiting();
		jQuery.ajax({
			url : url,
			type : 'Post',
			async: false,
			cache: false,
			contentType : 'application/json',
			data : JSON.stringify(obj),
			dataType : 'json',
			success : function(result) {
				//console.log(JSON.stringify(result.dataList));
				setTimeout(function(){ HideWaiting(); }, 2000);

				//setTimeout(function(){ShowWaiting(); }, 1000);
				$.each(result.dataList,function(i, samping) {
					wfAssignmentItemList(samping);
/////					//console.log("["+i+"] = "+JSON.stringify(samping));
/////					//{"PLANT_ID":"1101","LAB_CODE":"01-0-3-00212-0-19-00024","SAMPLE_TYPE_NAME":"C-CAR","PRODUCT_CODE":"ADO"}
/////					var pmObj = {};
/////						pmObj["plant"] = samping.PLANT_ID;
/////						//pmObj["seq"] = samping;
/////						pmObj["labCode"] = samping.LAB_CODE;
/////						pmObj["product"] = samping.PRODUCT_CODE;
/////						pmObj["typeOfSample"] = samping.SAMPLE_TYPE_NAME;
/////	
/////						//console.log("["+i+"] => "+JSON.stringify(pmObj));
/////
/////						var url = "reqItemList";
/////						jQuery.ajax({
/////							url : url,
/////							type : 'Post',
/////							async: false,
/////							cache: false,
/////							contentType : 'application/json',
/////							data : JSON.stringify(pmObj),
/////							dataType : 'json',	
/////							success : function(res) {	
/////								if(res.status == "S") {
/////									//console.log("  >>" + JSON.stringify(res));
/////		
/////									var responseResult = JSON.parse(res.result);
/////									var detailLen = 0;
/////									var allSeq = "";
/////									var allItem = "";
/////									var allTool = "";
/////									var allMethod = "";
/////									var allSpec   = "";
/////									var allUnit   = "";
/////									
/////									var arrayWorker = [];
/////									var arrayRoleGroup = [];
/////									var defaultRoleGroup = "";
/////									
/////									var member = "";
/////									var roleGrp = "";
/////									
/////									var assignmentData = {};
/////										assignmentData["systemName"] = responseResult["SystemT"];
/////										assignmentData["dummy01"]  = responseResult["Dummy01"];
/////										assignmentData["dummy02"]  = responseResult["Dummy02"];
/////										assignmentData["plant"] = pmObj["plant"];
/////										assignmentData["order"] = pmObj["seq"];
/////										assignmentData["labCode"] = pmObj["labCode"];
/////										assignmentData["product"] = pmObj["product"];
/////										assignmentData["sampleType"] = pmObj["typeOfSample"];
/////										assignmentData["process"]  = "";
/////										assignmentData["requestID"]  = ""; 
/////										assignmentData["requesterID"]  = "";
/////										assignmentData["roleGroup"]  = "";	
/////									
/////									var resCode = responseResult["Errorcode"];
/////									if(resCode == "900") {
/////										var detail = responseResult["Detail"];
/////										detailLen = detail.length;
/////										assignmentData["totalrecord"]  = detailLen;
/////										$.each(detail,function(d, det) {
/////											defaultRoleGroup = "";
/////											arrayWorker[d] = {};
/////
/////											var dtlNo = d;
/////											var itemC = det["TestItemcode"];
/////											var itemD = det["TestItem"];
/////											var specC = det["TestSpeccode"];
/////											var spec1 = det["TestSpec"];
/////											var spec2 = det["TestSpec2"];
/////											var unitC = det["TestUnitcode"];
/////											var unitD = det["TestUnit"];
/////											var methodC = det["Testmathodcode"];
/////											var methodD = det["Testmathod"];
/////											var toolC   = det["Testtoolcode"];
/////											var toolD   = det["Testtool"];
/////											
/////											allSeq		+=(dtlNo+1)+"|"; 
/////											allItem 	+= itemC+"|";
/////											allTool 	+= toolC+"|";
/////											allMethod 	+= methodC+"|";
/////											allSpec     += specC+"|";
/////											allUnit     += unitC+"|";
/////										
/////											var workgroup = det["workgroup"];
/////											var groupLen = workgroup.length;
/////											
/////											if (groupLen > 0 ) {
/////												$.each(workgroup,function(g, group) {
/////													var role = group["RoleGroup"];
/////													var flagDefault = group["RoleDef"];
/////													var mlist = "";
/////													roleGrp += role + "|";
/////													
/////													arrayWorker[d][role] = [];
/////													
/////													if (flagDefault == "Y" ) defaultRoleGroup = flagDefault;
/////													arrayRoleGroup[g] = [role,flagDefault];
/////													
/////													$.each(group["MemberList"],function(i, mem)  {
/////														var mid = mem["MemberID"];
/////														var mname = mem["MemberName"];
/////														
/////														arrayWorker[d][role][i] = [mid,mname];
/////														mlist += mid+",";
/////													});
/////													member += mlist.substring(0,mlist.length-1) + "|";
/////												});
/////											}
/////										});
/////									}
/////									
/////									assignmentData["seq"]  = allSeq.substring(0,allSeq.length-1);
/////									assignmentData["testItemCode"]  = allItem.substring(0,allItem.length-1);
/////									assignmentData["testtoolCode"]  = allTool.substring(0,allTool.length-1);
/////									assignmentData["testMethodCode"]  = allMethod.substring(0,allMethod.length-1);
/////									assignmentData["testSpecCode"]  = allSpec.substring(0,allSpec.length-1);
/////									assignmentData["testUnitCode"]  = allUnit.substring(0,allUnit.length-1);
/////
/////									//console.log("res from item : "+JSON.stringify(assignmentData));
/////									
/////									assignmentData["roleGroup"]  = roleGrp.substring(0,roleGrp.length-1);
/////									assignmentData["memberlist"]  = member.substring(0,member.length-1);
/////									
/////									ShowWaiting();
/////									var urlr = "submitAssignment";
/////									jQuery.ajax({
/////										url : urlr,
/////										type : 'Post',
/////										async: false,
/////										cache: false,
/////										contentType : 'application/json',
/////										data : JSON.stringify(assignmentData),
/////										dataType : 'json',
/////										success : function(ress) {
/////											if(ress.status == "S") {
/////												console.log(JSON.stringify(ress));
/////												
/////												var responseResult = JSON.parse(ress.result);
/////												console.log("response from web service ");
/////												console.log(responseResult);
/////												
/////												var saveObj = {};
/////												var resCode = responseResult["Errorcode"];
/////												if (resCode == "900") {
/////													//
/////												}
/////											}
/////										},
/////										error : function() {
/////											showMsgError('เกิดข้อผิดพลาด');
/////										}
/////									}).fail(function(){
/////										showMsgError('เกิดข้อผิดพลาด');
/////									});	
/////									
/////									setTimeout(function(){ HideWaiting(); }, 1000);
/////	
/////								}
/////							},
/////							error : function() {
/////								showMsgError('เกิดข้อผิดพลาด');
/////							}							
/////						}).fail(function(){
/////							showMsgError('เกิดข้อผิดพลาด');
/////						});						
				});
				gotoMain();
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด');
				setTimeout(function(){ HideWaiting(); }, 1000);
			}
		}).fail(function(){
			showMsgError('เกิดข้อผิดพลาด');
			setTimeout(function(){ HideWaiting(); }, 1000);
		});
	 }
	function gotoMain(){
		window.location="randomOilForValidate"; 
	}		 
    function labAssignment(plant) {
    	
    	
    	ShowWaiting();
    	var chkBoxName = "lab"+plant;
    	//console.log(chkBoxName);
    	
    	$( "input[name=" + chkBoxName + "]:checked" ).each( function() {
    		//console.log("val = "+this.value);
			var obj = this.value.split("|");
			var samping = {};
				samping["PLANT_ID"] = obj[0];
				samping["SEQ"] = obj[1];
				samping["LAB_CODE"] = obj[2];
				samping["PRODUCT_CODE"] = obj[3];
				samping["SAMPLE_TYPE_NAME"] = obj[4];			
			wfAssignmentItemList(samping);
    		
			/*
    		var obj = {};
    		var val = this.value.split("|");
    		
    		obj["plant"] = val[0];
    		obj["seq"] = val[1];
    		obj["labCode"] = val[2];
    		obj["product"] = val[3];
    		obj["typeOfSample"] = val[4];
    		
        	var url = "reqItemList";
        	ShowWaiting();
        	jQuery.ajax({
        		url : url,
        		type : 'Post',
        		async: false,
        		cache: false,
        		contentType : 'application/json',
        		data : JSON.stringify(obj),
        		dataType : 'json',
        		success : function(result) {
        		console.log(JSON.stringify(result));
        		
        			//setTimeout(function(){ HideWaiting(); }, 1000);
        		},
        		error : function() {
        			showMsgError('เกิดข้อผิดพลาด');
        		}
        	}).fail(function(){
        		//setTimeout(function(){ HideWaiting(); }, 1000);
        	});
        	*/
    	});
    	//setTimeout(function() { HideWaiting(); }, 1000);
    	gotoMain();
    }
    function wfAssignmentItemList (samping){
		//console.log("SAMPING :::::   "+JSON.stringify(samping));
		var pmObj = {};
			pmObj["plant"] = samping.PLANT_ID;
			//pmObj["seq"] = samping;
			pmObj["labCode"] = samping.LAB_CODE;
			pmObj["product"] = samping.PRODUCT_CODE;
			pmObj["typeOfSample"] = samping.SAMPLE_TYPE_NAME;

			//console.log("["+i+"] => "+JSON.stringify(pmObj));

		var url = "reqItemList";
		jQuery.ajax({
			url : url,
			type : 'Post',
			async: false,
			cache: false,
			contentType : 'application/json',
			data : JSON.stringify(pmObj),
			dataType : 'json',	
			success : function(res) {	
				if(res.status == "S") {
					//console.log("  >>" + JSON.stringify(res));

					var responseResult = JSON.parse(res.result);
					var detailLen = 0;
					var allSeq = "";
					var allItem = "";
					var allTool = "";
					var allMethod = "";
					var allSpec   = "";
					var allUnit   = "";
					
					var arrayWorker = [];
					var arrayRoleGroup = [];
					var defaultRoleGroup = "";
					
					var member = "";
					var roleGrp = "";
					
					var assignmentData = {};
						assignmentData["systemName"] = responseResult["SystemT"];
						assignmentData["dummy01"]  = responseResult["Dummy01"];
						assignmentData["dummy02"]  = responseResult["Dummy02"];
						assignmentData["plant"] = pmObj["plant"];
						assignmentData["order"] = pmObj["seq"];
						assignmentData["labCode"] = pmObj["labCode"];
						assignmentData["product"] = pmObj["product"];
						assignmentData["sampleType"] = pmObj["typeOfSample"];
						assignmentData["process"]  = "";
						assignmentData["requestID"]  = ""; 
						assignmentData["requesterID"]  = "";
						assignmentData["roleGroup"]  = "";	
					
					var resCode = responseResult["Errorcode"];
					if(resCode == "900") {
						var detail = responseResult["Detail"];
						detailLen = detail.length;
						assignmentData["totalrecord"]  = detailLen;
						$.each(detail,function(d, det) {
							defaultRoleGroup = "";
							arrayWorker[d] = {};

							var dtlNo = d;
							var itemC = det["TestItemcode"];
							var itemD = det["TestItem"];
							var specC = det["TestSpeccode"];
							var spec1 = det["TestSpec"];
							var spec2 = det["TestSpec2"];
							var unitC = det["TestUnitcode"];
							var unitD = det["TestUnit"];
							var methodC = det["Testmathodcode"];
							var methodD = det["Testmathod"];
							var toolC   = det["Testtoolcode"];
							var toolD   = det["Testtool"];
							
							allSeq		+=(dtlNo+1)+"|"; 
							allItem 	+= itemC+"|";
							allTool 	+= toolC+"|";
							allMethod 	+= methodC+"|";
							allSpec     += specC+"|";
							allUnit     += unitC+"|";
						
							var workgroup = det["workgroup"];
							var groupLen = workgroup.length;
							
							if (groupLen > 0 ) {
								$.each(workgroup,function(g, group) {
									var role = group["RoleGroup"];
									var flagDefault = group["RoleDef"];
									var mlist = "";
									roleGrp += role + "|";
									
									arrayWorker[d][role] = [];
									
									if (flagDefault == "Y" ) defaultRoleGroup = flagDefault;
									arrayRoleGroup[g] = [role,flagDefault];
									
									$.each(group["MemberList"],function(i, mem)  {
										var mid = mem["MemberID"];
										var mname = mem["MemberName"];
										
										arrayWorker[d][role][i] = [mid,mname];
										mlist += mid+",";
									});
									member += mlist.substring(0,mlist.length-1) + "|";
								});
							}
						});
					}
					
					assignmentData["seq"]  = allSeq.substring(0,allSeq.length-1);
					assignmentData["testItemCode"]  = allItem.substring(0,allItem.length-1);
					assignmentData["testtoolCode"]  = allTool.substring(0,allTool.length-1);
					assignmentData["testMethodCode"]  = allMethod.substring(0,allMethod.length-1);
					assignmentData["testSpecCode"]  = allSpec.substring(0,allSpec.length-1);
					assignmentData["testUnitCode"]  = allUnit.substring(0,allUnit.length-1);

					//console.log("res from item : "+JSON.stringify(assignmentData));
					
					assignmentData["roleGroup"]  = roleGrp.substring(0,roleGrp.length-1);
					assignmentData["memberlist"]  = member.substring(0,member.length-1);
					
					ShowWaiting();
					var urlr = "submitAssignment";
					jQuery.ajax({
						url : urlr,
						type : 'Post',
						async: false,
						cache: false,
						contentType : 'application/json',
						data : JSON.stringify(assignmentData),
						dataType : 'json',
						success : function(ress) {
							if(ress.status == "S") {
								//console.log(JSON.stringify(ress));
								
								var responseResult = JSON.parse(ress.result);
								//console.log("response from web service ");
								//console.log(responseResult);
								
								var saveObj = {};
								var resCode = responseResult["Errorcode"];
								if (resCode == "900") {
									//
								}
							}
						},
						error : function() {
							showMsgError('เกิดข้อผิดพลาด');
						}
					}).fail(function(){
						showMsgError('เกิดข้อผิดพลาด');
					});	
					
					setTimeout(function(){ HideWaiting(); }, 1000);

				}
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด');
			}							
		}).fail(function(){
			showMsgError('เกิดข้อผิดพลาด');
		});						

	}
	function checkPlantAll(elementPlantId) {
		
		var elemPlant = document.getElementsByName('lab'+elementPlantId);
		var elementLent = elemPlant.length;
		var headElem = $("#head_"+elementPlantId);
		if(headElem.attr("checked") == undefined){
			headElem.attr("checked",true);
			for( var i=0; i<elementLent; i++ ){
				if(elemPlant[i].type = "checkbox") {
					elemPlant[i].checked = true;	
				}
			}
		} else {
			if(headElem.attr("checked")=='checked') {
				headElem.attr("checked",false);
				for( var i=0; i<elementLent; i++ ){
					if(elemPlant[i].type = "checkbox") {
						elemPlant[i].checked = false;	
					}
				}
			} else {
				headElem.attr("checked",true);
				for( var i=0; i<elementLent; i++ ){
					if(elemPlant[i].type = "checkbox") {
						elemPlant[i].checked = true;	
					}
				}
			}
		}
		
	}    
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>สุ่มตัวอย่างเพื่อตรวจ(LAB Officer)</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>
 
<div class="wrapper wrapper-content animated fadeInRight"> 
      
        <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title" style="text-align:right">  จำนวนรอสุ่มเพื่อตรวจ :
	                              <span id="cntRandomSample"></span> รายการ
                     <!--  button type="button" id="loginbotttom3" onclick="saveRandomOil() "
	                        class="btn btn-success left-block">เพิ่มรายสุ่ม</button> -->  
                </div>
                <div class="ibox-content"> 
                      <div class="row">
	                        <div class="col-xs-12">
	                                 <div class="col-sm-3">
                                    <input type="text" style="width: 250px;"  class="form-control input-sm"   name="labCode" id="labCode"  />
                                    </div>
	                                <div class="col-sm-9">
                                         
	                                       <button type="button"
 											    class="btn btn-danger"
 											    style="width: 100px;text-align:center;"   onclick="updateStatus('04')">ยกเลิก</button>
 									</div> 		    
 						    </div>
	                    </div>
                        <div class="row">                               
                             <div class="col-xs-12">
                                 <div class="col-sm-12">
                                     <div class="col-xs-12 text-right">
                                         <button class="btn btn-primary" onclick="saveRandomOil()">
                                             <i class="fa fa-search"></i>&nbsp;สุ่ม
                                         </button>

                                     </div>
                                 </div> 
                             </div> 
                        </div>
                </div>
            </div>
        </div>
    </div>
     <div class="row">
           <div class="col-md-12">&nbsp;</div>
     </div>
     <c:forEach var="teamMember" items="${Model}">
    <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                  <div class="ibox-title">
	                    <h5>รายการสุ่มตัวอย่างเพื่อตรวจ<c:out value="${teamMember.PLANT_NAME}"/></h5>
	                   <input type="hidden" name="hidden_namestore" id="hidden_namestore"  value="${teamMember.PLANT_ID}"   />
	                      <div class="ibox-tools">
                        <a class="collapse-link"> <i class="fa fa-chevron-up"></i>
                        </a>

                    </div>
                 </div>
                 <div class="ibox-content">
                       <div class="row">
	                        <div class="col-xs-12" >
	                             <div class="table-responsive"   >
							         <table   id="myTableDteId_<c:out value="${teamMember.PLANT_ID}"/>" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
										<thead  class="tbHeader">
											<tr> 
												<!-- <th class="text-center" style="background-color: #fff;" >&nbsp;</th> -->
												<!-- <th class="text-center" style="margin:0; padding:0px; vertical-align: middle; text-align: center;" ><input id="head_${teamMember.PLANT_ID}" type="checkbox" class="chkHead" name="head${teamMember.PLANT_ID}" style="margin-left: 0px;    text-align: left;" ></th> -->
												<th class="text-right" colspan="25" style="background-color: #fff; padding-left:10px; text-align: right;" >
												
													<button type="button" class="btn btn-primary" onclick="labAssignment(${teamMember.PLANT_ID})"><i class='fa fa-group'></i>  มอบหมายงาน</button>

												</th>
											</tr>
											<tr>  <th class="text-center">NO</th>
											      <th class="text-center">
											      		<div id="select_${teamMember.PLANT_ID}" class="select_Lab">Check All </div>
											      		<input id="head_${teamMember.PLANT_ID}" type="checkbox" class="chkHead" name="head${teamMember.PLANT_ID}" value="head${teamMember.PLANT_ID}" style="margin-left: 0px; text-align: left;" onclick="checkPlantAll('${teamMember.PLANT_ID}')" >
											      </th>
											      <th class="text-center">LAB_CODE</th>
											      <th class="text-center">เลขกลุ่ม<br>การสุ่ม</th>
											      <th class="text-center">สถานะ</th>
											      <th class="text-center">เลขที่<br>PO</th>
											      <th class="text-center">วันที่<br>PO</th>
											      <th class="text-center">เลขที่<br>DO</th> 
											      <th class="text-center">เลขที่<br>SHIPMENT</th> 
											      <th class="text-center">ลำดับ</th>
												  <th class="text-center">ลำดับย่อย</th>
												  <th class="text-center">สี</th>
			                                      <th class="text-center">เลขที่<br>รถ</th>
			                                      <th class="text-center">ช่่อง<br>รถ</th>
			                                      <th class="text-center">เลขที่<br>เรือ</th>
			                                      <th class="text-center">ชื่อเรือ</th>
			                                      <th class="text-center">ช่่อง<br>เรือ</th>
			                                      <th class="text-center">วันที่<br>การสุ่ม</th>
			                                      <th class="text-center">วันที่<br>หมดอายุ</th>
			                                      <th class="text-center">ผลิตภัณฑ์</th>
			                                      <th class="text-center">แหล่งที่มา</th>
			                                      <th class="text-center">ระบบขนส่ง</th>
			                                      <th class="text-center">รูปแบบการเก็บ</th>
			                                      <th class="text-center">รหัสพนักงาน</th>
			                                      <th class="text-center">ชื่อพนักงาน</th>
											</tr>
										 </thead>
										<tbody id="dteId_<c:out value="${teamMember.PLANT_ID}"/>">
										</tbody>
									</table> 
								 </div>
	                        </div>
	                    </div>
                     
                </div>
            </div> 
        </div>
    </div> 
	 </c:forEach>
  </div>
 
  <div id="popup_random" class="modal in" tabindex="-1" data-backdrop="static" data-keyboard="false">
	    <div class="modal-dialog" style="width:500"   >
	        <div class="modal-content-wrapper">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <button type="button" class="close"  data-dismiss="modal" aria-label="Close"  >
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                    <h4 class="modal-title">สรุปรายการสุ่ม</h4>
	                </div>
	                <div class="modal-body ptn pbs">
	                    <div class="row">
	                        <div class="col-xs-12">
	                             <div class="table-responsive"   >
							         <table   id="myTableSum" class="table table-striped table-bordered" style="padding: 0px;">
										<thead>
																	<tr class="tbHeader">
																	  <th class="text-center">PLANT</th> 
																	         <th class="text-center">PO_DATE</th> 
									                                        <th class="text-center">PRODUCT</th>
									                                        <th class="text-center">LOGISTIC </th>
									                                   <th class="text-center">SUM</th>
																	</tr>
										 </thead>
										<tbody id="tb-body-import-id">
										</tbody>
									</table> 
								 </div>
	                        
	 
	                        </div>
	                    </div>
	 
	                </div>
	                <div class="modal-footer"></div>
	            </div>
	        </div>
	    </div>
 </div> 
 
