<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
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
var table = "",reqno="",reqC="",sTatus="";
var tmp_data = {};
var statusForExport='';
var reqNoForExport='';
    $(document).ready(function () {
        
    	/*$('#poDate').val(getThaiBuddaDate());
    	 
    	 $('#ddlStore').multiselect();
    	 $('#ddlProduct').multiselect();
    	 $('#ddlLogistic').multiselect();
    	 
    	SetDropDownStore();
    	SetDropDownProduct();
    	SetDropDownLogistic();
    	*/
    	initParam();
    	SetDropDownSelectType();
    	//inquirySpareRandomOil();
    });
    function initParam(){
		var  url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');    		
		 var reqno_v = url[0].split('='); 
		 reqno  =  reqno_v[1];
		 var chkReq = reqno_v[2];
		 sTatus = reqno_v[3];
		 
		 if(chkReq == 'edit'){
			 inquiryRandomOilDetail();
		 }else if(chkReq == 'sent'){
			 inquiryRandomOilDetail();
			 $("#loginbotttom4").hide();
			 $("#divBT").removeClass().addClass("col-sm-12");
		 }else{
			 inquiryRandomOilDetail();
		 }
			 
		 $("div#reqAnalyNo h2").append(reqno);
		 reqNoForExport=reqno;
		 selectAllNew();
		 //inquiryRandomOil();
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
		 
			  showMsgError('เกิดข้อผิดพลาด!');
		 
		   });	
		
		return rtnDate
	}
  
     function openRandomOilPopup(){
    	   $('#popup_random').modal('show');
     }
     function news(){
    	 
    	 alert($("#ddlStore").val());
     }
     function sendRequestRandomOil(){
    	 let chkSend = checkSelect("sendRequest");
    	 if(chkSend=="1"){
    		 return;
    	 }
    	 var labcode =  "";
    	 $("input[name='chk']").each(function() { 
	   	     //  alert($(this).prop('checked')+"-"+$(this).val()) ;   
	    	        if($(this).prop('checked')){
	    	        	  //    alert(tmpdata_plan.list.length);
	    	        	     for(var i=0;i<tmp_data.list.length;i++){
	    			 		//	  alert(tmpdata_plan.list[i].COST_CENTER) 
	    			 			  if($(this).val()==tmp_data.list[i].LAB_CODE){   
	    			 				 labcode +=    "'"+$(this).val()+"',";   ;
	    			 			  } 
	    			 		 }	 
	    	        }
		 });
    	 labcode = labcode.substring(0,labcode.length-1);	 
    	try{
    	 	//alert(tmp_data.list.length);
             if(tmp_data!=null&&tmp_data.list.length>0){
			            	 $.confirm({
			            		    title: 'ยืนยันการส่งใบคำขอวิเคราะห์',
			            		    icon: 'fa fa-exclamation-circle',
			                        type: 'blue',
			            		    content: '',
			            		    buttons: {
			            		     'ยืนยัน': function () {
			            		 
					    	 
					    	            var objList = {};
					    		 		 var array_dt = [];
										 var data = {} 
						    			 data["labCode_No"] = labcode;
						    			 data["status"] = "03";
										 ShowWaiting() ;
										  jQuery.ajax({
											url : 'updateStatusSendAnalysis',
											type : "Post", 
											contentType : "application/json",
											data : JSON.stringify(data), 
											dataType : 'json', 
											success : function(data) {
										      
												if(data.success==1){ 
												 	HideWaiting() ;
													showMsgSuccess("ส่งใบคำขอวิเคราะห์สำเร็จ ");
													//inquiryRandomOil();
													gotoMain();
												}else{
													  HideWaiting() ;
													  showMsgError(data.message);
												}
											},
											error : function() {
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
    			showMsgWarning('ไม่พบข้อมูลส่งใบคำขอวิเคราะห์');
    			 HideWaiting() ;
             }
		} catch (ex) {
			 showMsgError(ex);
			  HideWaiting() ;
			 
		}
		 
     } 
     
     
     function EditValue(i,labcode,sample_refer){		 
   	   	 $('#popup_spareRandomOil').modal('show');
   	   	 $("#funcID").val(i);
   	  	 SetDropDowncauseChgStatus();
		 $("#labcodeID").val(labcode);
		 $("#sampleRefer").val(sample_refer);
	 }
	function ShowCancel(i,labcode,del){	 
		 $("#selectCause").select2();
   	   	 $('#popup_spareRandomOil_cancel').modal('show');
   	  	 SetDropDowncauseChgStatus();
   	   	 $("#funcID").val(i);
		 $("#delID").val(del);
		 $("#labcodeID").val(labcode);
	 }
	 function CancelData(){
		 //var i = $("#funcID").val();
    	 //$( "#carNo_"+i ).prop( "disabled", true );
    	 //console.log("CAR NO = "+$( "#carNo_"+i ).val());
    	 try{
 		    	   $.confirm({
 	            		    title: 'ยืนยันการยกเลิก',
 	            		    icon: 'fa fa-exclamation-circle',
	                        type: 'red',
 	            		    content: '',
 	            		    buttons: {
 	            		    'ยืนยัน': function () {         
		 							 var data = {} 
						    			 data["labCode_No"] = $("#labcodeID").val();
						    			 data["status"] = $("#delID").val();
						    			 data["causeChgStatus"] = $("#causeChgStatus_cancel").val();
						    			 data["selectCause"] = $("#selectCause_cancel").val();
						    			 console.log(JSON.stringify(data));
		 							  jQuery.ajax({
		 								url : 'updateCancelStatus',
		 								type : "Post", 
		 								contentType : "application/json",
		 								data : JSON.stringify(data), 
		 								dataType : 'json',
		 								  async: false,
		 								   cache: false,
		 								success : function(data) {
		 							      
		 									if(data.success==1){ 
		 									  HideWaiting() ;		   
		 								         	  showMsgSuccess("ยกเลิกสำเร็จ");
		 								         	sendmailtoAdmin();
		 											  inquiryRandomOil();
		 												
		 									}else{
		 										  HideWaiting() ;
		 										  showMsgError(data.message);
		 									}
		 									$('#popup_spareRandomOil_cancel').modal('hide');
		 								},
		 								error : function() {
		 									 showMsgError(data.message);
		 									  HideWaiting() ;
		 								}
		 							 });
 	            		      },
 	            		     'ยกเลิก': function () {
 						            
 						        } 		 		  
 		    		  }
 		    	  });	
               
 		} catch (ex) {
 			 showMsgError(ex);
 			  HideWaiting() ;
 			 
 		}
     }
	 
	 
		function sendmailtoAdmin(){
			
			var role="'0007','0010','0005','0004'";
			var data ={};
			data["role_id"]=role;
			jQuery.ajax({
			 			url : 'sendmailtoadmin?labcode='+$("#labcodeID").val(),
			 			type : "Post", 
			 			contentType : "application/json",
			 			data : JSON.stringify(data), 
			 			dataType : 'json',
			 			async: false,
			 			cache: false,
			 			success : function(data) {
			 							      
			 			},
			 			error : function() {
			 				 showMsgError(data.message);
			 				 
			 			}
			 	});
		}
     function UpdateDataCarNo(a,PO_NO,DO_NO,SHIPMENT_NO,PLANT_ID,SOURCE_ID,LOGIS_ID,PRODUCT_ID,CAR_NO,SAMPLE_DATA_GROUP,SAMPLE_DATA_SEQ){
    	 //popup_CancelRandomOil
    	 //$( "#carNo_"+i ).prop( "disabled", true );
    	 //console.log("CAR NO = "+$( "#carNo_"+i ).val());
    	 //console.log("Lab Code = "+labcode);
    	 try{
 		    	   $.confirm({
 	            		    title: 'ยืนยันแก้ไขข้อมูล',
 	            		    icon: 'fa fa-exclamation-circle',
	                        type: 'blue',
 	            		    content: '',
 	            		    buttons: {
 	            		    'ยืนยัน': function () {         
		 							 var data = {} 
						    			data["labCode_No"] = $("#labcodeID").val();
		 							 	data["poNo"] = PO_NO;
		 							 	data["doNo"] = DO_NO;
		 							 	data["shipmentNo"] = SHIPMENT_NO;
		 							 	data["plantid"] = PLANT_ID;
		 							 	data["sourceId"] = SOURCE_ID;
		 							 	data["ownerLogistic"] = LOGIS_ID;
		 							 	data["productOil"] = PRODUCT_ID;				 	
		 								data["carNo"] = CAR_NO ;
		 								data["group_seq"] = SAMPLE_DATA_GROUP;
		 								data["seq"] = SAMPLE_DATA_SEQ;
		 								data["causeChgStatus"] = $("#causeChgStatus").val();
						    			data["selectCause"] = $("#selectCause").val();
						    			//data["status"] = del;
						    			console.log(JSON.stringify(data));
		 							  jQuery.ajax({
		 								url : 'updatedataCarNoValue',
		 								type : "Post", 
		 								contentType : "application/json",
		 								data : JSON.stringify(data), 
		 								dataType : 'json',
		 								  async: false,
		 								   cache: false,
		 								success : function(data) {
		 							      
		 									if(data.success==1){ 
		 									  HideWaiting() ;		   
		 								         	  showMsgSuccess("บันทึกสำเร็จ");
		 								         	
		 											  inquiryRandomOil();
		 												
		 									}else{
		 										  HideWaiting() ;
		 										  showMsgError(data.message);
		 									}
		 									 $('#popup_spareRandomOil').modal('hide');
		 								},
		 								error : function() {
		 									 showMsgError(data.message);
		 									  HideWaiting() ;
		 								}
		 							 });
 	            		      },
 	            		     'ยกเลิก': function () {
 						            
 						        } 		 		  
 		    		  }
 		    	  });	
               
 		} catch (ex) {
 			 showMsgError(ex);
 			  HideWaiting() ;
 			 
 		}
     }
     function queryTableFreeCar(){
    	 
    	 try {
    		 	$('#freeCar').html("");
             	$('#myTableFreeCar').DataTable().destroy();
		    	var data = {}	
		    	//data["sampleType"] = $("#ddlSampleType").val();
		    	data["referenceNo"] = $("#sampleRefer").val();
		    	console.log(JSON.stringify(data));
		    	ShowWaiting() ;
				jQuery.ajax({
				url : 'queryDataFreeCar',
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
								 	  
									det +='<tr>';
									det +='<td class="text-left">'+(data.list[i].PO_NO==null?"":data.list[i].PO_NO)+'</td>';
									det +='<td class="text-left" >'+(data.list[i].DO_NO==null?"":data.list[i].DO_NO)+'</td>';
									det +='<td class="text-left" >'+(data.list[i].SHIPMENT_NO==null?"":data.list[i].SHIPMENT_NO)+'</td>'; 
									det +='<td class="text-left" >'+(data.list[i].PLANT_NAME==null?"":data.list[i].PLANT_NAME)+'</td>'; 
									det +='<td class="text-left" >'+(data.list[i].SOURCE_NAME==null?"":data.list[i].SOURCE_NAME)+'</td>'; 
									if("000004" == data.list[i].SAMPLE_TYPE){
										det +='<td class="text-left" > - </td>';
									}else{
										det +='<td class="text-left" >'+(data.list[i].LOGIS_NAME==null?"":data.list[i].LOGIS_NAME)+'</td>';
									}
									  
									det +='<td class="text-left" >'+(data.list[i].PRODUCT_NAME==null?"":data.list[i].PRODUCT_NAME)+'</td>'; 
									det +='<td class="text-left" >'+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)+'</td>';
									det +='<td class="text-left" >'+(data.list[i].RANDOM_FLG==null?"":data.list[i].RANDOM_FLG)+'</td>';
									det +='<td class="text-center" ><a onclick="UpdateDataCarNo(\''
											+ '\',\''+(data.list[i].PO_NO==null?"":data.list[i].PO_NO)
											+ '\',\''+(data.list[i].DO_NO==null?"":data.list[i].DO_NO)
											+ '\',\''+(data.list[i].SHIPMENT_NO==null?"":data.list[i].SHIPMENT_NO)
											+ '\',\''+(data.list[i].PLANT_ID==null?"":data.list[i].PLANT_ID)
											+ '\',\''+(data.list[i].SOURCE_ID==null?"":data.list[i].SOURCE_ID)
											+ '\',\''+(data.list[i].LOGIS_ID==null?"":data.list[i].LOGIS_ID)
											+ '\',\''+(data.list[i].PRODUCT_ID==null?"":data.list[i].PRODUCT_ID)
											+ '\',\''+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)
											+ '\',\''+(data.list[i].SAMPLE_DATA_GROUP==null?"":data.list[i].SAMPLE_DATA_GROUP)
											+ '\',\''+(data.list[i].SAMPLE_DATA_SEQ==null?"":data.list[i].SAMPLE_DATA_SEQ)
											+'\')"><span class="glyphicon glyphicon-wrench"></span>Select</a></td>' ;
									det +='</tr>';
									//console.log(data.list[i].PRODUCT_NAME);
								}
								 if (det == '') {
		                                det += '<tr> ';
		                                det += '<th colspan="18" class="text-center">--- ไม่พบข้อมูล ---</th> ';
		                                det += '</tr> ';
		                                $('#freeCar').html(det);

		                         }else{
		                        	 $('#freeCar').html(det);
		                                table = $('#myTableFreeCar').DataTable({
		                                    searching: true,
		                                    responsive: true
		                             }); 
		                         }
								 HideWaiting() ;
								 
					}else{
						 showMsgError(data.message);
						 HideWaiting() ;
					}
						},
						error : function() {

							 showMsgError('เกิดข้อผิดพลาด');
							 HideWaiting() ;
						}
					});   
		} catch (ex) {

			 showMsgError(ex);
			 HideWaiting() ;
		}
    }
     function openSpareRandomOilPopup(i,labcode,del){	
    	 $("#selectCause").select2({width: '100%'});
   	   	 $('#popup_spareRandomOil').modal('show');
      	 try {
      	
      		 // $("input[name='hidden_namestore']").each(function() { 
 				 // alert($(this).val());
 			 	 var nameStore   = $("#hidden_namestore").val();
 			
      		   	$('#dteIdSpare').html("");
      		    
     		       $('#myTableSpareDteId').DataTable().destroy();
      		 		
    					var data = {}
		    			//data["referenceNo"] = ((referenceNo==null||referenceNo=='')?'none':referenceNo) ; 
		    			//data["nameStore"] = nameStore; 
		    			//data["dataGroup"] = ((dataGroup==null||dataGroup=='')?'none':dataGroup) ;
		    			data["labCode_No"] = labcode;
					  	jQuery.ajax({
						url : 'randomOilDetail',
						type : "Post", 
						contentType : "application/json",
						data : JSON.stringify(data), 
						dataType : 'json',
						async: false,
						cache: false,
  						success : function(data) {

  					    // alert(data.success);
  						if(data.success==1) {
  							 var det = "";
  							    //alert(data.list.length);
  										 for (var i = 0; i < data.list.length; i++) {
  										 	  
  											det +='<tr>';
  										 
  										    det +='<td class="text-left" >'+(data.list[i].SAMPLE_REFER==null?"":data.list[i].SAMPLE_REFER)+'</td>'; 
  											det +='<td class="text-left" >'+(data.list[i].STRPO_DATE==null?"":data.list[i].STRPO_DATE)+'</td>'; 
  											det +='<td class="text-center" >'+(data.list[i].SAMPLE_DATA_GROUP==null?"":data.list[i].SAMPLE_DATA_GROUP)+'</td>';
  											det +='<td class="text-center" >'+ (data.list[i].SAMPLE_DATA_SEQ==null?"":data.list[i].SAMPLE_DATA_SEQ)+'</td>';
  											det +='<td class="text-center" >'+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)+'</td>';
  											det +='<td class="text-center" >'+ (data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
  											det +='<td class="text-left" >'+(data.list[i].source_name==null?"":data.list[i].source_name)+'</td>'; 
  											if("000004" == data.list[i].SAMPLE_TYPE){
  												det +='<td class="text-center" > - </td>';
  											}else{
  												det +='<td class="text-center" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
  											}
  											  
  											
  											det +='<td class="text-center" >'+(data.list[i].STATUS_NAME==null?"":data.list[i].STATUS_NAME)+'</td>';
  											/*det += '<td class="text-center" ><a href="#" onclick="editdata(\''
  												+ labcode
  												+ '\',\''+(data.list[i].SAMPLE_DATA_GROUP==null?"":data.list[i].SAMPLE_DATA_GROUP)
  												+ '\',\''+(data.list[i].SAMPLE_DATA_SEQ==null?"":data.list[i].SAMPLE_DATA_SEQ)
  												+ '\',\''+referenceNo 
  												+ '\')"><span class="glyphicon glyphicon-edit"></span></a></td>';
  								
  										    det +='</tr>';*/
  										  det += '<td class="text-center" ><a href="#" onclick="EditData2()"><span class="glyphicon glyphicon-edit"></span></a></td>';
								
										  det +='</tr>';
  										  
  										  //GET DATA CAR_NO IN EDIT TEXTBOX
  										  
  										$("#CarNo").val(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO);
  										$("#getStatusValue").append('<option value="' + data.list[i].status + '">&nbsp;&nbsp;' + data.list[i].STATUS_NAME + '</option>');
  										}
  										
  										
  											
  										
  										 // alert(det);
  										if(det==''){
  											det += '<tr> ';
  											det += '<th colspan="9" class="text-center">--- ไม่พบข้อมูล ---</th> ';
  											det += '</tr> ';
  											$('#dteIdSpare').html(det);
  											  
  										}else{
  										//	alert('#dteId_'+nameStore);
  											$('#dteIdSpare').html(det);
  										
  											table =  $('#myTableSpareDteId').DataTable( {
  	 											searching: true,
  	 											responsive : true
  	 										});
  										} 
  										
  										
  										
  							} else {
  								 showMsgError(data.message);
  								/* jAlert('error', data.message,'ข้อมูลผิดพลาด');
  								 $.alert({
  				                   title: 'ข้อมูลผิดพลาด',
  				                   icon: 'fa fa-error',
  				                   type: 'red',
  				                   content: data.message,
  				               });*/
  							}
  						},
  						error : function() {
  							
  							/* $.alert({
  			                   title: 'error',
  			                   icon: 'fa fa-error',
  			                   type: 'red',
  			                   content: 'ข้อมูลผิดพลาด',
  			               });*/
  							 showMsgError('ข้อมูลผิดพลาด');
  						}
  					});
      		// });	   
  		} catch (ex) {
  			/* $.alert({
                 title: 'error',
                 icon: 'fa fa-error',
                 type: 'red',
                 content: 'ข้อมูลผิดพลาด',
             });*/
  			 showMsgError('ข้อมูลผิดพลาด');
  		}
      	 
      } 
     function inquiryRandomOil(){
    	 
     	// det = "";
  		
  	 
  		//alert($("#ddlStore").val());
     	 try {
     	
     		 // $("input[name='hidden_namestore']").each(function() { 
				 // alert($(this).val());
				 var nameStore   = $("#hidden_namestore").val();
				 
     		      $('#dteId').html("");
     	  	 
    		       $('#myTableDteId').DataTable().destroy();
     		 
 		    			var data = {}
 		    			data["reqNo"] = reqno;
 		    			data["status"] = sTatus;
 		    			//data["reqNoIsNull"] = "Y" ;
 		    			//data["status"] = "01" ;
 					  jQuery.ajax({
 						url : 'randomOilRequestNoDetail',
 						type : "Post", 
 						contentType : "application/json",
 						data : JSON.stringify(data), 
 						dataType : 'json',
 						  async: false,
 						   cache: false,
 						success : function(data) {
 					    //   alert(data.success);
 							if(data.success==1){
 							 var det = "";
 							     tmp_data = data; 
 							     //alert(tmp_data);
 							        //   alert(data.list.length);
 										 for (var i = 0; i < data.list.length; i++) {
										 	  
   											det +='<tr  class="TBODY">';
   											det +='<td class="text-center" >'+ (data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE) +'</td>';
   											det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'" /> </td>';
   		   		   							
   											if(data.list[i].FLAG_PRINT == 'Y'){
   		   		   								det += '<td class="text-center" ><i class="glyphicon glyphicon-ok"></i></td>';
   		   		   							}else{
   		   		   							det += '<td class="text-center" ><i class="glyphicon glyphicon-remove"></i></td>';
   		   		   							}
   											det +='<td class="text-left" >'+ (data.list[i].SAMPLE_TYPE_NAME==null?"":data.list[i].SAMPLE_TYPE_NAME)+'</td>';
    											det +='<td class="text-left" >'+ (data.list[i].SAMPLE_REFER==null?"":data.list[i].SAMPLE_REFER)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].PO_NO==null?"":data.list[i].PO_NO)+'</td>'; 
    											det +='<td class="text-left" >'+(data.list[i].STRPO_DATE==null?"":data.list[i].STRPO_DATE)+'</td>'; 
    											det +='<td class="text-left" >'+(data.list[i].DO_NO==null?"":data.list[i].DO_NO)+'</td>'; 
    											det +='<td class="text-left" >'+(data.list[i].SHIPMENT_NO==null?"":data.list[i].SHIPMENT_NO)+'</td>';  
    											det +='<td class="text-left" >'+(data.list[i].SAMPLE_DATA_GROUP==null?"":data.list[i].SAMPLE_DATA_GROUP)+'</td>'; 
    											det +='<td class="text-left" >'+(data.list[i].SAMPLE_DATA_SEQ==null?"":data.list[i].SAMPLE_DATA_SEQ)+'</td>'; 
    											det +='<td class="text-left" > '+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].CAR_SLOT==null?"":data.list[i].CAR_SLOT)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].BOAT_NO==null?"":data.list[i].BOAT_NO)+'</td>';
   											det +='<td class="text-left" >'+(data.list[i].BOAT_NAME==null?"":data.list[i].BOAT_NAME)+'</td>';
   											det +='<td class="text-left" >'+(data.list[i].BOAT_SLOTP==null?"":data.list[i].BOAT_SLOTP)+'</td>'; 
   											det +='<td class="text-left" >'+(data.list[i].BOAT_SLOTS==null?"":data.list[i].BOAT_SLOTS)+'</td>'; 
   											det +='<td class="text-left" >'+(data.list[i].ADDITIVE_INV_NO==null?"":data.list[i].ADDITIVE_INV_NO)+'</td>'; 
   											
    											det +='<td class="text-center" >'+(data.list[i].STR_SAMPLE_DATE==null?"":data.list[i].STR_SAMPLE_DATE)+'</td>';
    											det +='<td class="text-center" >'+(data.list[i].STR_SAMPLE_EXPIRE_DATE==null?"":data.list[i].STR_SAMPLE_EXPIRE_DATE)+'</td>';
    											det +='<td class="text-left" >'+ (data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].source_name==null?"":data.list[i].source_name)+'</td>'; 
    											det +='<td class="text-left" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
    											det +='<td class="text-leftr" >'+(data.list[i].SAMPLE_LEVEL_DESC==null?"":data.list[i].SAMPLE_LEVEL_DESC)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_ID==null?"":data.list[i].SAMPLE_STAFF_ID)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_NAME==null?"":data.list[i].SAMPLE_STAFF_NAME)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].OTHERLOGISTIC==null?"":data.list[i].OTHERLOGISTIC)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].SOURCE_OTHER_DESC==null?"":data.list[i].SOURCE_OTHER_DESC)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].SUB_TYPE_NAME==null?"":data.list[i].SUB_TYPE_NAME)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].SAMPLE_TYPEC_DESC==null?"":data.list[i].SAMPLE_TYPEC_DESC)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].TANK_NO==null?"":data.list[i].TANK_NO)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].TYPE_NAME==null?"":data.list[i].TYPE_NAME)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].LOC_NAME==null?"":data.list[i].LOC_NAME)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].SAMPLE_POINT_DESC==null?"":data.list[i].SAMPLE_POINT_DESC)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].RETURNR_DESC==null?"":data.list[i].RETURNR_DESC)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].STATUS_NAME==null?"":data.list[i].STATUS_NAME)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].CANCEL_DESC==null?"":data.list[i].CANCEL_DESC)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].CANCEL_NAME==null?"":data.list[i].CANCEL_NAME)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].REVISE_DESC==null?"":data.list[i].REVISE_DESC)+'</td>';
    											det +='<td class="text-left" >'+(data.list[i].REVISE_CODE==null?"":data.list[i].REVISE_CODE)+'</td>';
    											det +='<td class="text-center" ><a onclick="EditValue(\''
  												+ i
   												+ '\',\''+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)
   												+ '\',\''+(data.list[i].SAMPLE_REFER==null?"":data.list[i].SAMPLE_REFER)
   												+'\')"><span class="glyphicon glyphicon-edit"></span>EDIT CAR NO</a></td>' ;
    											det +='<td class="text-center" ><a onclick="ShowCancel(\''
  												+ i
   												+ '\',\''+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)
   												+ '\',\''+ '11'
   												+'\')"><span class="glyphicon glyphicon-edit"></span>CANCEL</a></td>' ;
    											det +='</tr>';
    											
    											 //$( "#carNo_"+i ).prop( "disabled", true );
   										}
 										 // alert(det);
 										if(det==''){
 											det += '<tr> ';
 											det += '<th colspan="23" class="text-center">--- ไม่พบข้อมูล ---</th> ';
 											det += '</tr> ';
 											$('#dteId').html(det);
 											HideWaiting() ;
 											  
 										}else{
 										//	alert('#dteId_'+nameStore);
 											$('#dteId').html(det);
 											HideWaiting() ;
 											
 										} 
 										table =  $('#myTableDteId').DataTable( {
											searching: true,
											responsive : true
										});
 							}else{
 							 
 								 showMsgError(data.message);
 								// jAlert('error', data.message,'ข้อมูลผิดพลาด');
 								HideWaiting() ;
 							}
 						},
 						error : function() {
 							//swal("error");
 							 showMsgError('ข้อมูลผิดพลาด');
 							// jAlert('error', '','ข้อมูลผิดพลาด');
 							HideWaiting() ;
 						}
 					});
     		// });	   
 		} catch (ex) {
 			//swal(ex);
 			 showMsgError(ex);
 			 //jAlert('error', ex,'ข้อมูลผิดพลาด');
 			HideWaiting() ;
 		}
     	 
     } 
     
     function gotoMain(){
     	window.location="manageReviseRequestNo"; 
     }
    function report(labcode){
    	var ctx = "${pageContext.request.contextPath}";
    	var link = ctx+"/reportHome?labCode_No="+labcode;
    	// 		window.location.href = link;
    			window.open(link, '_blank');
    }
   
    
    function SetDropDownSelectType() {
    	ShowWaiting() ;
    	$('#selectType').val("");
        try {
        	$('#selectType').html("");
            jQuery.ajax({
                url: 'util-getDropdownSampleType',
                type: "Post",
                contentType: "application/json",
                dataType: 'json',
                //  async: false,
                cache: false,
                success: function (data) {
                    var txt = '';

                    $.each(data, function (i, item) {

                        $('#selectType').append('<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
                        txt += item.PID + ',';
						
                    });
                    if (txt.length > 0) {
                        txt = txt.substring(0, txt.length - 1)
                    }
                    $('#selectType').select2({placeholder: "ประเภทตัวอย่าง",dropdownAutoWidth : true,width: '200'});
                    /*
                    $('#selectType').change(
                    	function () {
                 	   		inquiryRandomOil(this.value);
                 	   		console.log(this.value);
                    });
                    */
                    HideWaiting() ;
                },
                error: function () {
                    showMsgError('ข้อมูลผิดพลาด');
                    HideWaiting() ;
                }
            });

        } catch (ex) {
            showMsgError(ex);
            HideWaiting() ;

        }
    }  
function inquiryRandomOilDetail(){		
  	 	
  	 	
  	 	
  	 	//progressload();	
  	  	try {
		  	  	var sampleType =  $("#selectType").val(); 
		  	 	//console.log($("#selectType").val());
		  	 	if(sampleType!=null){
		  	 		var txtsampleType = "";
		  	 		for(var i=0;i<sampleType.length;i++){
		  	 			//console.log(sampleType[i]);
		  	 			txtsampleType += "'"+sampleType[i]+"',";
		  	 		}	
		  	 		txtsampleType = txtsampleType.substring(0,txtsampleType.length-1) ;
		  	 	}
     		 // $("input[name='hidden_namestore']").each(function() { 
				 // alert($(this).val());
				 //var nameStore   = $("#hidden_namestore").val();
     		
     		      $('#dteId').html("");
     	  	 
    		       $('#myTableDteId').DataTable().destroy();
     		 
 		    			var data = {}
 		    			//data["nameStore"] = nameStore;
 		    			//data["reqNoIsNull"] = "Y" ;
 		    			//data["status"] = "01" ;
 		    			if(txtsampleType!=null || txtsampleType!=""){
 		    				data["sampleType"] = txtsampleType;
 		    			}		
 		    			data["reqNo"] = reqno;
 		    			data["status"] = sTatus;
 		    			statusForExport=sTatus;
 		    			console.log(JSON.stringify(data));
 		    			ShowWaiting() ;
 					  jQuery.ajax({
 						url : 'randomOilDetail',
 						type : "Post", 
 						contentType : "application/json",
 						data : JSON.stringify(data), 
 						dataType : 'json',
 						  async: false,
 						   cache: false,
 						success : function(data) {
 					    //   alert(data.success);
 					    //console.log("randomOilDetail >>"+JSON.stringify(data));
 							if(data.success==1) {
 								tmp_data = data;
 	 							dataT = data;
 	 							renderTableData(dataT);
 								HideWaiting() ;
 							}else{
 							 
 								 showMsgError(data.message);
 								// jAlert('error', data.message,'ข้อมูลผิดพลาด');
 								HideWaiting() ;
 							}
 						},
 						error : function() {
 							//swal("error");
 							 showMsgError('ข้อมูลผิดพลาด');
 							HideWaiting() ;
 							// jAlert('error', '','ข้อมูลผิดพลาด');
 						}
 					});
     		// });	   
 		} catch (ex) {
 			//swal(ex);
 			 showMsgError(ex);
 			HideWaiting() ;
 			 //jAlert('error', ex,'ข้อมูลผิดพลาด');
 		}
     	 
     } 
function searchSampleType(item){
	let list = [];
	$('#dteId').html("");
    $('#myTableDteId').DataTable().destroy();
	$.each($("#selectType").val(),function(i,item){
		$.each(tmp_data.list,function(){
			if(this.SAMPLE_TYPE==item){
				list.push(this);
			}
    	});
	});
	tmp_data2={};
	tmp_data2["list"] = list;
	renderTableData(tmp_data2);	
}
function renderTableData(data){
	data_arr=[];
	var json_data={};
	 //console.log(data.list.length);
	 let det = "";
	 for (var i = 0; i < data.list.length; i++) {
	 	  
			//console.log(data.list[i].LAB_CODE+"|"+data.list[i].CAR_SLOT);
			det +='<tr  class="TBODY">';
			det +='<td class="text-center" >'+ (data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE) +'</td>';
			det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'" /> </td>';
				
			if(data.list[i].FLAG_PRINT == 'Y'){
					det += '<td class="text-center" ><i class="glyphicon glyphicon-ok"></i></td>';
				}else{
				det += '<td class="text-center" ><i class="glyphicon glyphicon-remove"></i></td>';
				}
			det +='<td class="text-left" >'+ (data.list[i].SAMPLE_TYPE_NAME==null?"":data.list[i].SAMPLE_TYPE_NAME)+'</td>';
			//
			det +='<td class="text-left" >'+ (data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].source_name==null?"":data.list[i].source_name)+'</td>'; json_data['ref']=(data.list[i].source_name==null?"":data.list[i].source_name);
			if("T" == data.list[i].SAMPLE_TYPE_NAME){
				det +='<td class="text-left" > - </td>';
				
			}else{
				det +='<td class="text-left" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
				
			}
			
			det +='<td class="text-leftr" >'+(data.list[i].SAMPLE_LEVEL_DESC==null?"":data.list[i].SAMPLE_LEVEL_DESC)+'</td>';
			//
			det +='<td class="text-left" >'+ (data.list[i].SAMPLE_REFER==null?"":data.list[i].SAMPLE_REFER)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].PO_NO==null?"":data.list[i].PO_NO)+'</td>'; 
			det +='<td class="text-left" >'+(data.list[i].STRPO_DATE==null?"":data.list[i].STRPO_DATE)+'</td>'; 
			det +='<td class="text-left" >'+(data.list[i].DO_NO==null?"":data.list[i].DO_NO)+'</td>'; 
			det +='<td class="text-left" >'+(data.list[i].SHIPMENT_NO==null?"":data.list[i].SHIPMENT_NO)+'</td>';  
			det +='<td class="text-left" >'+(data.list[i].SAMPLE_DATA_GROUP==null?"":data.list[i].SAMPLE_DATA_GROUP)+'</td>'; 
			det +='<td class="text-left" >'+(data.list[i].SAMPLE_DATA_SEQ==null?"":data.list[i].SAMPLE_DATA_SEQ)+'</td>'; 
			det +='<td class="text-left" > '+(data.list[i].METER_NO==null?"":data.list[i].METER_NO)+'</td>'; 
			det +='<td class="text-left" > '+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)+'</td>'; 
			det +='<td class="text-left" >'+(data.list[i].CAR_SLOT==null?"":data.list[i].CAR_SLOT)+'</td>';
			//det +='<td class="text-left" >'+(data.list[i].BOAT_NO==null?"":data.list[i].BOAT_NO)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].BOAT_NAME==null?"":data.list[i].BOAT_NAME)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].BOAT_SLOTP==null?"":data.list[i].BOAT_SLOTP)+'</td>'; 
			det +='<td class="text-left" >'+(data.list[i].BOAT_SLOTS==null?"":data.list[i].BOAT_SLOTS)+'</td>'; 
			//det +='<td class="text-left" >'+(data.list[i].ADDITIVE_INV_NO==null?"":data.list[i].ADDITIVE_INV_NO)+'</td>'; 
			det +='<td class="text-left" >'+(data.list[i].ADTV_LOT_NO==null?"":data.list[i].ADTV_LOT_NO)+'</td>'; 
			
			det +='<td class="text-center" >'+(data.list[i].STR_SAMPLE_DATE==null?"":data.list[i].STR_SAMPLE_DATE)+'</td>';
			det +='<td class="text-center" >'+(data.list[i].STR_SAMPLE_EXPIRE_DATE==null?"":data.list[i].STR_SAMPLE_EXPIRE_DATE)+'</td>';
			//
			
			det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_ID==null?"":data.list[i].SAMPLE_STAFF_ID)+'</td>';
					det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_NAME==null?"":data.list[i].SAMPLE_STAFF_NAME)+'</td>';
			//var userName,codeEmpID;
			/* if("00001" == data.list[i].SAMPLE_TYPE && "N"== data.list[i].MANUAL_TYPE){
				det +='<td class="text-left" >'+codeEmpID+'</td>';
					det +='<td class="text-left" >'+userName+'</td>';
			}else{
				det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_ID==null?"":data.list[i].SAMPLE_STAFF_ID)+'</td>';
					det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_NAME==null?"":data.list[i].SAMPLE_STAFF_NAME)+'</td>';
			} */
			
			//det +='<td class="text-left" >'+(data.list[i].OTHERLOGISTIC==null?"":data.list[i].OTHERLOGISTIC)+'</td>';
			//det +='<td class="text-left" >'+(data.list[i].SOURCE_OTHER_DESC==null?"":data.list[i].SOURCE_OTHER_DESC)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].SUB_TYPE_NAME==null?"":data.list[i].SUB_TYPE_NAME)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].SAMPLE_TYPEC_DESC==null?"":data.list[i].SAMPLE_TYPEC_DESC)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].TANK_NO==null?"":data.list[i].TANK_NO)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].TYPE_NAME==null?"":data.list[i].TYPE_NAME)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].LOC_NAME==null?"":data.list[i].LOC_NAME)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].SAMPLE_POINT_DESC==null?"":data.list[i].SAMPLE_POINT_DESC)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].RETURNR_DESC==null?"":data.list[i].RETURNR_DESC)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].STATUS_NAME==null?"":data.list[i].STATUS_NAME)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].CANCEL_DESC==null?"":data.list[i].CANCEL_DESC)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].CANCEL_NAME==null?"":data.list[i].CANCEL_NAME)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].REVISE_DESC==null?"":data.list[i].REVISE_DESC)+'</td>';
			det +='<td class="text-left" >'+(data.list[i].REVISE_CODE==null?"":data.list[i].REVISE_CODE)+'</td>';
			det +='<td class="text-center" ><a onclick="EditValue(\''
				+ i
				+ '\',\''+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)
				+ '\',\''+(data.list[i].SAMPLE_REFER==null?"":data.list[i].SAMPLE_REFER)
				+'\')"><span class="glyphicon glyphicon-edit"></span>EDIT CAR NO</a></td>' ;
			det +='<td class="text-center" ><a onclick="ShowCancel(\''
				+ i
				+ '\',\''+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)
				+ '\',\''+ '11'
				+'\')"><span class="glyphicon glyphicon-edit"></span>CANCEL</a></td>' ;
			det +='</tr>';
			
			 //$( "#carNo_"+i ).prop( "disabled", true );
		}
		 // alert(det);
		if(det==''){
			$('#dteId').html(det);
			HideWaiting() ;
			  
		}else{
		//	alert('#dteId_'+nameStore);
			$('#dteId').html(det);
			HideWaiting() ;
			
		} 
		table =  $('#myTableDteId').DataTable( {
			//paging: false,
			"pageLength": 20,
			searching: true,
			responsive : true,
			"columnDefs": [
			    { "orderable": false, "targets": 1 }
			  ]
		});
}
function selectAll(source){
	var items=document.getElementsByName('chk');
	for(var i=0; i<items.length; i++){
		if(items[i].type=='checkbox'){
			//items[i].checked=true;
			if(items[i].checked != source) {
					items[i].checked = source.checked; 
	   	 	}
		}
	}
}

function printAll(){
	checkSelect("print");
}

function exportRequestNo(){

		  var link = '/Lab/exportRequestNo/'+reqNoForExport+'/'+statusForExport;
		  window.open(link, '_blank');
	
}
function checkedPrint(labcode){
		try {
			var data = {}	
			data["labCode"] = labcode;
			console.log(JSON.stringify(data));
			ShowWaiting() ;
			jQuery.ajax({
			url : 'checkedPrint',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
	
				if(data.success==1){
					report(labcode);
					//inquiryRandomOil();
					inquiryRandomOilDetail();
	    			//SetDropDownSelectType();	 
				}else{
					 showMsgError(data.message);
					 HideWaiting() ;
				}
					},
					error : function() {

						 showMsgError('เกิดข้อผิดพลาด');
						 HideWaiting() ;
					}
				});   
		} catch (ex) {

 		showMsgError(ex);
 		HideWaiting() ;
		}
		}
function report(labcode){
		var ctx = "${pageContext.request.contextPath}";
		var link = ctx+"/reportHome?labCode_NoIn="+labcode;
		// 		window.location.href = link;

				window.open(link, '_blank');
		}
function SetDropDownStatus() {
	 $('#getStatusValue').val("");
   try {
   	$('#getStatusValue').html("");
       jQuery.ajax({
           url: 'util-getDropdownStatusStore',
           type: "Post",
           contentType: "application/json",
           dataType: 'json',
           cache: false,
           success: function (data) {

               var txt = '';
               $.each(data, function (i, item) {

                   $('#getStatusValue').append('<option value="' + item.CANCEL_CODE + '">&nbsp;&nbsp;' + item.CANCEL_NAME + '</option>');
                   
                   //    txt   += item.PRODUCT_ID+',';
                   // console.log(item)
               });
               //$('#getStatusValue').select2({dropdownAutoWidth : true,width: 'auto'});
               $('#getStatusValue').select();
           },
           error: function () {
               showMsgError('เกิดข้อผิดพลาด');
           }
       });

   } catch (ex) {
       showMsgError(ex);

   }
}
function SetDropDowncauseChgStatus() {
    ShowWaiting() ;
    	//alert("dddd");
   	 $('#selectCause').val("");
   	$('#selectCause_cancel').val("");
       try {
       	$('#selectCause').html("");
       	$('#selectCause_cancel').html("");
           jQuery.ajax({
               url: 'util-getDropdowncauseChgStatus',
               type: "Post",
               contentType: "application/json",
               dataType: 'json',
               cache: false,
               success: function (data) {
                   var txt = '';
                   $.each(data, function (i, item) {

                       $('#selectCause').append('<option value="' + item.CANCEL_CODE + '">&nbsp;&nbsp;' + item.CANCEL_NAME + '</option>');
                       $('#selectCause_cancel').append('<option value="' + item.CANCEL_CODE + '">&nbsp;&nbsp;' + item.CANCEL_NAME + '</option>');
                   });
                   //$('#getStatusValue').select2({dropdownAutoWidth : true,width: 'auto'});
                   $('#selectCause').select2(
                		   {
                			   dropdownParent: $("#popup_spareRandomOil"),
                			   dropdownAutoWidth : true,
                			   width: 'auto'   
                		   });
                   $('#selectCause_cancel').select2(
                		   {
                			   dropdownParent: $("#popup_spareRandomOil_cancel"),
                			   dropdownAutoWidth : true,
                			   width: 'auto'   
                		   });
                   HideWaiting() ;
               },
               error: function () {
                   showMsgError('เกิดข้อผิดพลาด');
                   HideWaiting() ;
               }
           });

       } catch (ex) {
           showMsgError(ex);
           HideWaiting() ;

       }
   }
function checkSelect(inp){
	 let labcode =  "";
	 $("input[name='chk']").each(function() { 
  	     //  alert($(this).prop('checked')+"-"+$(this).val()) ;   
   	        if($(this).prop('checked')){
   	        	  //    alert(tmpdata_plan.list.length);
   	        	     for(var i=0;i<tmp_data.list.length;i++){
   	        	    	 //console.log($(this).val());
   			 			  if($(this).val()==tmp_data.list[i].LAB_CODE){   
   			 				 labcode +=    "'"+$(this).val()+"',";   ;
   			 			  } 
   			 		 }	 
   	        }
	 });
	 labcode = labcode.substring(0,labcode.length-1);
	 
	let msg = "",re = 0;;
	if(labcode!=''){
		if(inp=="print"){
			
	    	checkedPrint(labcode);
	    	$('#labCodeID').val(labcode);
	    	msg = 'กรุณาเลือกรายการ Print'
		}else if(inp=="se"){
			
		}
	}else{
		if(inp=="print"){
			re = 1; 
			msg = 'กรุณาเลือกรายการ Print'
			showMsgWarning(msg);
		}else if(inp=="sendRequest"){
			re = 1;
			msg = 'กรุณาเลือกใบคำขอวิเคราะห์'
			showMsgWarning(msg);	
		}
	}
	
	return re;
}
function gotoMain(){
	window.location="manageReviseRequestNo"; 
} 
function selectAllNew(){
	 	var table = $('#myTableDteId').DataTable();
		
		    	  $('#example-select-all').on('click', function(){
		    	      // Check/uncheck all checkboxes in the table
		    	      var rows = table.rows({ 'search': 'applied' }).nodes();
		    	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
		    	   });

		    	   // Handle click on checkbox to set state of "Select all" control
		    	   $('#example tbody').on('change', 'input[type="checkbox"]', function(){
		    	      // If checkbox is not checked
		    	      if(!this.checked){
		    	         var el = $('#example-select-all').get(0);
		    	         // If "Select all" control is checked and has 'indeterminate' property
		    	         if(el && el.checked && ('indeterminate' in el)){
		    	            // Set visual state of "Select all" control 
		    	            // as 'indeterminate'
		    	            el.indeterminate = true;
		    	         }
		    	      }
		    	   });
	}
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10" id="reqAnalyNo">
        <h2>เลขที่ใบคำขอวิเคราะห์ : </h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>
 
<div class="wrapper wrapper-content animated fadeInRight"> 
 
     <div class="row">
                        <div class="col-md-12">&nbsp;
                        </div>
     </div>
  
 <div class="row"> 
	        <div class="col-lg-12">
	            <div class="ibox float-e-margins">
	                  <div class="ibox-title">
	                  	<div class="col-sm-6">
		                   	<h5>รายการ<c:out value="${Model.PLANT_NAME}"/></h5> &nbsp;  
	                            <a href="#" onclick="printAll()"><span class="glyphicon glyphicon-print"></span> Print ฉลาก </a>
	                   	</div> 	
	                   	<div class="ibox-title-col-sm-6 text-right">
	                   		<button type="button" class="btn btn-primary"  onclick="exportRequestNo()" style="margin-right: 10px;"><i class="fa fa-print"></i>Export PDF</button><select id="selectType" multiple="multiple"></select>&nbsp;<button class="btn btn-primary" onclick="searchSampleType(this)">ค้นหา</button>
	                   	</div>
		                <input type="hidden" name="hidden_namestore" id="hidden_namestore"  value="${Model.PLANT_ID}"   />
		                 	
	                 </div>
	                 <div class="ibox-content">
	                 
	                       <div class="row">
		                        <div class="col-xs-12" >

		                             <div class="table-responsive"   >
								         <table   id="myTableDteId" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
											<thead  class="tbHeader">
											 
														<tr>
																		
																		        <th style="width:20%" class="text-center">LAB_CODE</th>
																		        
																		        <th style="width:5%" class="text-center">&nbsp;<input id="example-select-all" value="1" name="select_all" type="checkbox" onclick="selectAllNew()"></th>
																		    <th class="text-center">Print</th>
																		    <th class="text-center">ชนิด</th>
																		    
																		     <th class="text-center">ผลิตภัณฑ์</th>
									                                        <th class="text-center">แหล่งที่มา</th>
									                                     <th class="text-center">ระบบขนส่ง</th>
									                                          <th class="text-center">รูปแบบการเก็บ</th>
																		    
																	        <th class="text-center">เลขกลุ่ม<br>การสุ่ม</th> 
																	         <th class="text-center">เลขที่<br>PO</th>
																	         <th class="text-center">วันที่<br>PO</th>
																	        <th class="text-center">เลขที่<br>DO</th> 
																	          <th class="text-center">เลขที่<br>SHIPMENT</th> 
																	        <th   class="text-center">ลำดับ</th>
																		        <th   class="text-center">ลำดับย่อย</th> 
																		         <th   class="text-center">เลขมิเตอร์</th> 
									                                        <th class="text-center">เลขที่รถ</th>
									                                            <th class="text-center">ช่่องรถ</th>
									                                            <!--  <th class="text-center">เลขที่เรือ</th> -->
									                                               <th class="text-center">ชื่อเรือ</th>
									                                            <th class="text-center">ช่่องเรือ P</th>
									                                            <th class="text-center">ช่่องเรือ S</th>
									                                            <th class="text-center">LOT NO.</th>
									                                             <th class="text-center">วันที่<br>การสุ่ม</th>
									                                            <th class="text-center">วันที่<br>หมดอายุ</th>
									                                           
									                                     <th class="text-center">รหัสพนักงาน</th>
									                                        <th class="text-center">ชื่อพนักงาน</th>
									                                       <!--  <th class="text-center">ขนส่งอื่นๆ</th>
									                                        <th class="text-center">แหล่งที่มาอื่นๆ</th> -->
									                                        <th class="text-center">การเข้าเก็บ</th>
									                                        <th class="text-center">รายละเอียดการเข้าเก็บ</th>
									                                        <th class="text-center">หมายเลขถัง</th>
									                                        <th class="text-center">ประเภทสถานี</th>
									                                        <th class="text-center">จุดเก็บ</th>
									                                        <th class="text-center">รายละเอียดจุดเก็บ</th>
									                                        <th class="text-center">เหตุผลในการ Return</th>
									                                        <th class="text-center">สถานะ</th>
									                                        <th class="text-center">เหตุผลในการยกเลิก</th>
									                                        <th class="text-center">สาเหตุในการยกเลิก</th>
									                                        <th class="text-center">เหตุผลในการแก้ไขทะเบียน</th>
									                                        <th class="text-center">สาเหตุในการแก้ไขทะเบียน</th>
									                                        
									                                        <th style="width:5%" class="text-center">&nbsp;</th>
									                                        <th style="width:5%" class="text-center">&nbsp;</th>
																		</tr>
											 </thead>
											<tbody id="dteId" > 
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
	 
	        <div class="col-sm-12">
	             <div id="divBT" class="col-sm-6">
		            <button type="button" id="btBacktoMainPage"
		                    class="btn btn-danger center-block" onclick="gotoMain()" 
		            >กลับไปหน้าหลัก&nbsp;
		                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
		            </button>
		        </div>
		        <div class="col-sm-6">
	                 <center><button type="button" id="loginbotttom4" onclick="sendRequestRandomOil();" 
	                            class="btn btn-primary center-block">
	                                                      ส่งใบคำขอวิเคราะห์  
	                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button></center>
	             </div>  
	        </div>
	       
  </div>
  <div class="row">
                        <div class="col-md-12">&nbsp;
                        </div>
   </div>
     
</div> 
</div> 
   <div id="popup_spareRandomOil" class="modal editdata" >
	 <div class="vertical-alignment-helper">
	    <div class="modal-dialog vertical-align-center" >
	        <div class="modal-content-wrapper">
	            <div class="modal-content">
	                <div class="modal-header">
	               
	                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                    <h4 class="modal-title">แก้ไขทะเบียนรถ</h4>
	                </div>
	                <div class="col-sm-12"><p></p></div>
	                <div class="modal-body">
	                <div class="col-sm-12"><p></p></div>
	                <div class="col-sm-6">
	                        	<div class="col-sm-4">
	                        		<label>สาเหตุ</label>
	                        	</div>
	                        	<div class="col-sm-8">
	                        		<select id="selectCause">
	                        		</select>
	                        	</div>
	                </div>
	               	<div class="col-sm-12"><p></p></div>
	               			<div class="col-sm-6">
	                        	<div class="col-sm-4">
	                        		<label>เหตุผล</label>
	                        	</div>
	                        	<div class="col-sm-8">
	                        		<input type="text" class="form-control" id="causeChgStatus"/>
	                       </div> 
	                       </div>
	                        <div class="col-sm-12">
	                        	<div class="col-xs-12 text-right">
	                        		<button class="btn btn-primary" onclick="queryTableFreeCar()">
                                       	 Browse
                                    </button>
	                        	</div>
	                    </div>   
	                	
	                	<div class="col-sm-12">
                        <div class="show-data-car-no" >
                           	<h4><label>รถที่สามารถใช้งานได้</label></h4>
							 <table   id="myTableFreeCar" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
										<thead  class="tbHeader">
										<tr>
											<th class="text-center">เลขที่ PO</th>
											<th class="text-center">เลขที่  NO</th>
											<th class="text-center">SHIPMENT_NO</th>
											<th class="text-center">คลัง</th>
											<th class="text-center">แหล่งที่มา</th>
											<th class="text-center">ขนส่ง</th>
											<th class="text-center">ผลิตภัณฑ์</th> 
											<th class="text-center">ทะเบียนรถ</th>
											<th class="text-center">สถานะการใช้งาน</th>
											<th style="width:5%" class="text-center">&nbsp;</th>
											</tr>
										 </thead>
										<tbody id="freeCar">
										</tbody>
									</table> 
						</div>	
						</div>
						<div class="col-sm-12"><p></p></div>
                       
                    </div>

	                </div>
	                <div class="modal-footer"></div>
	            </div>
	        </div>
	    </div>
	  </div>

<div id="popup_spareRandomOil_cancel" class="modal cancel" >
	 <div class="vertical-alignment-helper">
	    <div class="modal-dialog vertical-align-center" >
	        <div class="modal-content-wrapper">
	            <div class="modal-content">
	                <div class="modal-header">
	               
	                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                    <h4 class="modal-title">ยกเลิก</h4>
	                </div>
	                <div class="col-sm-12"><p></p></div>
	                <div class="modal-body">
	                         <div class="col-sm-12"><p></p></div>
	                		<div class="col-sm-6">
	                        	<div class="col-sm-4">
	                        		<label>สาเหตุ</label>
	                        	</div>
	                        	<div class="col-sm-8">
	                        		<select id="selectCause_cancel">
	                        		</select>
	                        	</div>
	                        </div>
	               <div class="col-sm-12"><p></p></div>
	               			<div class="col-sm-6">
	                        	<div class="col-sm-4">
	                        		<label>เหตุผล</label>
	                        	</div>
	                        	<div class="col-sm-8">
	                        		<input type="text" class="form-control" id="causeChgStatus_cancel" maxlength="100"/>
	                        	</div>   	
	                        </div>
	                        <div class="col-sm-12"><p></p></div>
	                        <div class="col-sm-6">
	                        	<div class="col-xs-12 text-right">
	                        		<button class="btn btn-primary" onclick="CancelData()">
                                       	 ยกเลิก
                                    </button>
	                        	</div>
	                        </div>
	                    <div class="col-sm-12"><p></p></div>
                    </div>

	                </div>
	                <div class="modal-footer"></div>
	            </div>
	        </div>
	    </div>
	  </div>
<div class="col-sm-12"></div>

<label id="funcID"></label>
 <label id="delID"></label>
 <label id="labcodeID"></label>
  <label id="sampleRefer"></label>
