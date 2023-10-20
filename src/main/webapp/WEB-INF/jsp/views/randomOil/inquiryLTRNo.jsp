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
var table = "";
    $(document).ready(function () {
     
    	 
    	 
    	inquiryLTRNo();
   
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
     	
     		
     		      $('#dteId').html("");
     	  	 
    		       $('#myTableDteId').DataTable().destroy();
     		 
 		    			var data = {}
 		    			//alert($(this).val());
 		    			 data["role_id"] = roleId;
 		    			data["status"] = '01,05';
 					  jQuery.ajax({
 						url : 'inquiryLTRNO',
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
 										 	  
 											det +='<tr >';
 											det +='<td class="text-left" >'+ (i+1)+'</td>'; 
 										 	det +='<td class="text-center" >'+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'</td>'; 
 										 	det +='<td class="text-center" ><a href="initInquirySaveResult?ltrNo='+(data.list[i].LTR_NO==null?"":data.list[i].LTR_NO)+'&labcode='+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'&modeView=">'+(data.list[i].LTR_NO==null?"":data.list[i].LTR_NO)+'</a></td>';
 											 
 										 	det +='<td class="text-left" >'+ (data.list[i].CREATE_BY==null?"":data.list[i].CREATE_BY)+'</td>'; 
 										 	det +='<td class="text-left" >'+(data.list[i].STR_CREATE_DATE==null?"":data.list[i].STR_CREATE_DATE)+'</td>'; 
 										 			
 											det +='</tr>';
 										}
 										// alert(det);
 										if(det==''){
 											det += '<tr> ';
 											det += '<th colspan="5" class="text-center">--- ไม่พบข้อมูล ---</th> ';
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
    
     
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>บันทึกผลการทดสอบ(LAB Officer)</h2>
       
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
																	      <th class="text-center">LABCODE</th>
																	      <th class="text-center">LTRNO</th> 
																	      <th class="text-center">CREATE BY</th>
																	      <th class="text-center">CREATE DATE</th>
																	     	 
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
	
  </div>
 
 
 
