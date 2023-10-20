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
   
    	 
    	showData();
    });
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
			/* $.alert({
                 title: 'error',
                 icon: 'fa fa-error',
                 type: 'red',
                 content: 'เกิดข้อผิดพลาด!',
             });*/
			 showMsgError('เกิดข้อผิดพลาด!');
				//ShowErrorMsg('0006', ex);
				//HideWaiting();
		   });	
		
		return rtnDate
	}
    
     function openRandomOilPopup(){
    	   $('#popup_random').modal('show');
     }
    
     
     function showData(){
    	var dataT = ["dteId","dteId_edit","dteId_sent"];
		var tableT = ["myTableDteId","myTableDteId_edit","myTableDteId_sent"];
    	
		console.log(dataT.length);
		for(var i=0;i<dataT.length;i++){
			inquiryRequestAnalysis(tableT[i],dataT[i]);
		} 
     }
     function inquiryRequestAnalysis(ta,da){
     	
    	 try {
     	
     		  $("input[name='hidden_namestore']").each(function() { 
				 var nameStore   =  $(this).val();
				 let chksTatus;
     		      $('#'+da+'').html("");  	  	 
    		       $('#'+ta+'').DataTable().destroy();		 
 		    			var data = {}
 		    			data["nameStore"] = $(this).val();
 		    			if(da=="dteId"){
 		    				chksTatus = "02";
 		    			}else if(da=="dteId_edit"){
 		    				chksTatus = "10";
 		    			}else if(da=="dteId_sent"){
 		    				chksTatus = "03";
 		    			}else{
 		    				chksTatus = "";
 		    			}
 		    			
 		    			data["status"] = chksTatus;
 					  jQuery.ajax({
 						url : 'inquiryRequestAnalysisOil',
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
 										 	  
 											det +='<tr class="TBODY">';
 											if(da=="dteId_edit"){
 												det +='<td class="text-center" ><a href="redirectRequestNoDetail?reqNo='+(data.list[i].SEND_REQT_ID==null?"":data.list[i].SEND_REQT_ID)
 														+'=edit='+(data.list[i].STATUS_CODE==null?"":data.list[i].STATUS_CODE)+'">'+(data.list[i].SEND_REQT_ID==null?"":data.list[i].SEND_REQT_ID)+'</a></td>';
 											}else if(da=="dteId_sent"){
 												det +='<td class="text-center" ><a href="redirectRequestNoDetail?reqNo='+(data.list[i].SEND_REQT_ID==null?"":data.list[i].SEND_REQT_ID)
													+'=sent='+(data.list[i].STATUS_CODE==null?"":data.list[i].STATUS_CODE)+'">'+(data.list[i].SEND_REQT_ID==null?"":data.list[i].SEND_REQT_ID)+'</a></td>';
 											}else{
 												det +='<td class="text-center" ><a href="redirectRequestNoDetail?reqNo='+(data.list[i].SEND_REQT_ID==null?"":data.list[i].SEND_REQT_ID)+'=new='
 														+(data.list[i].STATUS_CODE==null?"":data.list[i].STATUS_CODE)+'">'+(data.list[i].SEND_REQT_ID==null?"":data.list[i].SEND_REQT_ID)+'</a></td>';
 											}
 											
 											det +='<td class="text-center" >'+(data.list[i].CREATE_BY==null?"":data.list[i].CREATE_BY)+'</td>';
 											det +='<td class="text-center" >'+(data.list[i].strCREATE_DATE==null?"":data.list[i].strCREATE_DATE)+'</td>';
 											det +='<td class="text-center" >'+(data.list[i].COUNT_SEND_REQT_ID==null?"":data.list[i].COUNT_SEND_REQT_ID)+'</td>';
 											//det +='<td class="text-center" >'+ (data.list[i].STATUS_NAME==null?"":data.list[i].STATUS_NAME)+'</td>';
 									
 											 
 											det +='</tr>';
 										}
 										if(det==''){
 											det += '<tr> ';
 											det += '<th colspan="4" class="text-center">--- ไม่พบข้อมูล ---</th> ';
 											det += '</tr> ';
 											$('#'+da+'').html(det);
 											  
 										}else{
 											$('#'+da+'').html(det);
 											table =  $('#'+ta+'').DataTable( {
 												searching: true,
 												responsive : true
 											});
 											
 										} 
 							}else{
 									 showMsgError(data.message);

 							}
 						},
 						error : function() {

 						showMsgError('เกิดข้อผิดพลาด!');

 						}
 					});
     		 });	   
 		} catch (ex) {

 		showMsgError(ex);

 		}
     	 
     } 
     
   
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>ใบคำขอวิเคราะห์</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>
 
<div class="wrapper wrapper-content animated fadeInRight"> 
     
  
    <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                  <div class="ibox-title">
	                    <h5>ใบคำขอวิเคราะห์</h5>
	                   <input type="hidden" name="hidden_namestore" id="hidden_namestore"  value="${Model.PLANT_ID}"   />
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
										 
																	<tr>
																	     <th class="text-center">REQ_NO</th>
																	        <th class="text-center">CREATE_BY</th>
																	        <th class="text-center">CREATE_DATE</th>
																	        <th class="text-center">COUNT</th>
																	        <!--<th   class="text-center">STATUS</th>  -->
																		  
																	</tr>
										 </thead>
										<tbody id="dteId">
										</tbody>
									</table> 
								 </div>
	                        </div>
	                    </div>
                </div>
            </div> 
        </div>
    </div> 
    
        <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                  <div class="ibox-title">
	                    <h5>รายการที่ต้องแก้ไข</h5>
	                   <input type="hidden" name="hidden_namestore" id="hidden_namestore"  value="${Model.PLANT_ID}"   />
	                      <div class="ibox-tools">
                        <a class="collapse-link"> <i class="fa fa-chevron-up"></i>
                        </a>

                    </div>
                 </div>
                 <div class="ibox-content">
                
                    
                       <div class="row">
	                        <div class="col-xs-12" >
	                             <div class="table-responsive"   >
							         <table   id="myTableDteId_edit" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
										<thead  class="tbHeader">
										 
																	<tr>
																	     <th class="text-center">REQ_NO</th>
																	        <th class="text-center">CREATE_BY</th>
																	        <th class="text-center">CREATE_DATE</th>
																	        <th class="text-center">COUNT</th>
																	        <!--<th   class="text-center">STATUS</th>  -->
																		  
																	</tr>
										 </thead>
										<tbody id="dteId_edit">
										</tbody>
									</table> 
								 </div>
	                        </div>
	                    </div>
                </div>
            </div> 
        </div>
    </div> 
    
            <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                  <div class="ibox-title">
	                    <h5>รายการที่ส่ง</h5>
	                   <input type="hidden" name="hidden_namestore" id="hidden_namestore"  value="${Model.PLANT_ID}"   />
	                      <div class="ibox-tools">
                        <a class="collapse-link"> <i class="fa fa-chevron-up"></i>
                        </a>

                    </div>
                 </div>
                 <div class="ibox-content">
                
                    
                       <div class="row">
	                        <div class="col-xs-12" >
	                             <div class="table-responsive"   >
							         <table   id="myTableDteId_sent" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
										<thead  class="tbHeader">
										 
																	<tr>
																	     <th class="text-center">REQ_NO</th>
																	        <th class="text-center">CREATE_BY</th>
																	        <th class="text-center">CREATE_DATE</th>
																	        <th class="text-center">COUNT</th>
																	        <!--<th   class="text-center">STATUS</th>  -->
																		  
																	</tr>
										 </thead>
										<tbody id="dteId_sent">
										</tbody>
									</table> 
								 </div>
	                        </div>
	                    </div>
                </div>
            </div> 
        </div>
    </div> 
	 
  </div>
 
  <div id="popup_random" class="modal in" tabindex="-1" data-backdrop="static" data-keyboard="false">
	    <div class="modal-dialog" style="width:500"   >
	        <div class="modal-content-wrapper">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <button type="button" class="close"   onclick=""  >
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
 
