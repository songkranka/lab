<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="<c:url value="/assets/css/settingTestScroll.css" />"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
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
<!-- <div class="box box-success box-solid"> -->
<script type='text/javascript'>

var table = "";
var  reqno  = "",namestore="";
var sampletypetxt='';
var flag="";
    $(document).ready(function () {
       
     initParam();
     $("#labCode").val("").focus();	
    	
    	
    });
    
	function initParam(){
		var  url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');    		
		 var reqno_v = url[0].split('='); 
		 reqno  =  reqno_v[1];
		 namestore =  reqno_v[2];
		 inquiryRandomOil();
		 selectAllNew();
	}
function inquiryRandomOil(){
  	  	try {
     		      $('#dteId').html("");
     	  	 
    		       $('#myTableDteId').DataTable().destroy();
     		 
 		    			var data = {}
 		    			data["reqNo"] = reqno;
 		    			data["status"] = "'03'";
 		    			data["nameStore"] = namestore;
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
 							console.log(data);
 							if(data.success==1) {
 							 var det = "";
 							     tmp_data = data; 
 							     //alert(tmp_data);
 							        //   alert(data.list.length);
 							        var dataT = data;
 										 for (var i = 0; i < data.list.length; i++) { 
 											det +='<tr  class="TBODY">';
 											det +='<td class="text-center" >'+ (data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE) +'</td>';
 											//det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'" /> </td>';
 											det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'" /> </td>';
 											if(data.list[i].FLAG_VERIFY == 'Y'){
 		   		   								det += '<td class="text-center" ><i class="glyphicon glyphicon-ok"></i></td>';
 		   		   							}else if(data.list[i].FLAG_VERIFY == 'I'){
 		   		   								det += '<td class="text-center" ><i class="glyphicon glyphicon-info-sign"></i></td>';
 		   		   							}
 											else{
 		   		   								det += '<td class="text-center" ><i class="glyphicon glyphicon-remove"></i></td>';
 		   		   							}
 											det +='<td class="text-left" >'+ (data.list[i].SAMPLE_TYPE_NAME==null?"":data.list[i].SAMPLE_TYPE_NAME)+'</td>';
  											//
 											det +='<td class="text-left" >'+ (data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
  											det +='<td class="text-left" >'+(data.list[i].source_name==null?"":data.list[i].source_name)+'</td>'; 
  											
  											if("T" ==data.list[i].SAMPLE_TYPE_NAME){
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
  											
  											//
  											det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_ID==null?"":data.list[i].SAMPLE_STAFF_ID)+'</td>';
  											det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_NAME==null?"":data.list[i].SAMPLE_STAFF_NAME)+'</td>';
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
 											"pageLength": 20,
											searching: true,
											responsive : true,
											"columnDefs": [
											    { "orderable": false, "targets": 1 }
											  ]
										});
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
     
     function updateStatusReceiveFlag(labcodeNo){
     	 try {
  		 		    			var data = {}
  		 		    			data["receiveFlg"] = 'Y';
  		 		    			data["labCode_No"] = labcodeNo; 
  		 		    		 
  		 					  jQuery.ajax({
  		 						url : 'updateReceiveFlgRandomOilDte',
  		 						type : "Post", 
  		 						contentType : "application/json",
  		 						data : JSON.stringify(data), 
  		 						dataType : 'json',
  		 						  async: false,
  		 						   cache: false,
  		 						success : function(data) {
  		 					 
  		 							if(data.success==1){
  		 								         //jAlert('success', 'บันทึกสำเร็จ');
  		 								        
  									         	  /*$.alert({
  			 				                          title: 'บันทึกสำเร็จ',
  			 				                          icon: 'fa fa-check',
  			 				                          type: 'green',
  			 				                          content: '',
  			 				                      });*/
  									         	showMsgSuccess('บันทึกสำเร็จ');
  		 									 
  									         	 inquiryRequestAnalysisOilDetail(); 
  		 								
  		 								 
  		 							}else{
  		 							      
  		 							     /*$.alert({
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
  		 							  /*$.alert({
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
                    content: ex,
                });*/
   			 showMsgError(ex);
   		}
     }
     function updateStatus(flag){ 
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
    	 if(labcode==''){
    		 console.log($("#labCode").val());
    		 labcode = "'"+$("#labCode").val()+"'";
    	 }
    	
    	 try{
 			var data = {} 
 			data["labCode_No"] = labcode;
 			data["flagVerify"] = flag;
 			data["status"] = "04";
 			//console.log(JSON.stringify(data));
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
 						showMsgSuccess("บันทึกสำเร็จ");
 						
 						inquiryRandomOil();
 						$("#labCode").val("").focus();	
 					}else{
 						  HideWaiting() ;
 						  showMsgError(data.message);
 					}
 				}
 			});		       
		} catch (ex) {
			 showMsgError(ex);
			  HideWaiting() ;
			 
		}
		 
     } 
 
    function rejectReqNo(){
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
		if(labcode==''){
			msg = 'กรุณาเลือกรายการส่งใบคำขอวิเคราะห์'
    		showMsgWarning(msg);
			return;
		}
    	try {
     		
       	  
			  
 	   	   $.confirm({
       		    title: 'ยืนยันส่งกลับแก้ไข',
       		  icon: 'fa fa-exclamation-circle',
               type: 'blue',
               content: '', 
       		    buttons: {
       		   'ยืนยัน': function () {   
       			   
       			       
 		 		    			var data = {}
 		 		    			data["labCode_No"] = labcode;
 		 		    			data["status"] = "10";
 		 		    			data["reqNo"] =  reqno; 
 		 		    			console.log(JSON.stringify(data));
 		 					  jQuery.ajax({
 		 						url : 'updateStatusSendAnalysis',
 		 						type : "Post", 
 		 						contentType : "application/json",
 		 						data : JSON.stringify(data), 
 		 						dataType : 'json',
 		 						  async: false,
 		 						   cache: false,
 		 						success : function(data) {
 		 					 
 		 							if(data.success==1){
 		 								     
 									         	 showMsgSuccess('บันทึกสำเร็จ');
 		 										 
 		 										// $("#labCode").val('');
 		 										// inquiryRequestAnalysisOilDetail(); 
 									       	 gotoMain();  
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
  			 
  			  showMsgError('ข้อมูลผิดพลาด');
  		}
    	
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
    function report(){
    	var ctx = "${pageContext.request.contextPath}";
    	var link = ctx+"/reportHome";
    	// 		window.location.href = link;
    			window.open(link, '_blank');
    }
    function gotoMain(){
    	window.location="manageAnalysisOil?"+namestore; 
    } 
    function submitOnEnter(inputElement, event) {
        if (event.keyCode == 13) {
        	updateStatus('Y');
        }
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
    function cancelSave(){
    	Swal.fire({
    	  title: 'คุณต้องการยกเลิกหรือไม่ ?',
    	  text: "",
    	  type: 'warning',
    	  showCancelButton: true,
    	  confirmButtonColor: '#d33',
    	  cancelButtonColor: '#3085d6',
    	  confirmButtonText: 'ตกลง',
    	  cancelButtonText: 'ยกเลิก'
    	}).then((result) => {
    		  if (result.value) {
    			  updateStatus("N");
    		  }
    	})
	}
 
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>บันทึกรับ</h2>
       
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
	                                 <div class="col-sm-3">
                                    	<input type="text" style="width: 250px;"  class="form-control input-sm"   name="labCode" id="labCode"  onkeypress="submitOnEnter(this,event)"/>
                                    </div>
	                                <div class="col-sm-9">
                                             <button type="button"
 											    class="btn btn-success"
 											    style="width: 100px;text-align:center;" onclick="updateStatus('Y')" >บันทึกรับ</button>
	                                       <!-- <button type="button"
 											    class="btn btn-danger"
 											    style="width: 150px;text-align:center;" onclick="cancelSave()">ยกเลิก การบันทึกรับ</button> -->
 									</div> 		    
 						    </div>
	                    </div>					    
	                       <div class="row">
		                        <div class="col-xs-12" >

		                             <div class="table-responsive"   >
								         <table   id="myTableDteId" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
											<thead  class="tbHeader">
											 
																		<tr>
																		
																		        <th style="width:20%" class="text-center">LAB_CODE</th>
																		         <th style="width:5%" class="text-center">&nbsp;<input id="example-select-all" value="1" name="select_all" type="checkbox" onclick="selectAllNew()"></th>
																		    <th class="text-center">VERIFY</th>
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
	            <div class="col-sm-6">
		            <button type="button"
		                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()" 
		            >กลับไปหน้าหลัก&nbsp;
		                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
		            </button>
		       </div>
		       <div class="col-sm-6">   
			              <button type="button"
			                    class="btn btn-danger center-block"  style="width: 150px;" onclick="rejectReqNo()" 
			            >ส่งกลับแก้ไข 
			            </button>
	            </div> 
	            
	        </div>
	        <!-- /.col -->
	 </div>
  </div>
 
 
  
 
