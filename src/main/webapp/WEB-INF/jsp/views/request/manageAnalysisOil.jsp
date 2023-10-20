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
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
<script type='text/javascript'>

var table = "";
var dataTemp;
    $(document).ready(function () {

SetDropDownPlant()
 renderDataToTable()
var  url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
//console.log(url[0]);
	$.each(url,function(i,item){
		//console.log(item);
		$.each($("#ddlPlant option"),function(i2,item2){
			if(item==item2.value.split("#")[1]){
				$('#ddlPlant').val(item2.value).change();
			}
 		});	
		
	})
    	inquiryRequestAnalysis();
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
     function news(){

    	 alert($("#ddlStore").val());
     }

     function inquiryRequestAnalysis(){

     	// det = "";


  		//alert($("#ddlStore").val());
     	 try {
     		var nameStore = "";
     		$.each($("#ddlPlant option"),function(i,item){
     			nameStore += "'"+item.value.split("#")[1]+"',"
     		});	 
     		 nameStore= nameStore.substring(0,nameStore.length-1);
     		      $('#dteId_').html("");
    		       $('#myTableDteId_').DataTable().destroy();

 		    			var data = {}
					    //data["nameStore"] = nameStore;
 		    			data["status"] = "345";
 		    			console.log(JSON.stringify(data));
 					  jQuery.ajax({
 						//url : 'randomOilDetail',
 						url : 'inquiryRequestAnalysisOil',
 						type : "Post",
 						contentType : "application/json",
 						data : JSON.stringify(data),
 						dataType : 'json',
 						  async: false,
 						   cache: false,
 						success : function(data) {
 							console.log(data);
 							//alert(data.list[0].STATUS_NAME);
 							if(data.success==1){
 							 var det = "";
 							 console.log(data);
							 	dataTemp = data;
								renderDataToTable()
 							}else{
 									showMsgError(data.message);
 							}
 						},
 						error : function() {					
 						showMsgError('เกิดข้อผิดพลาด!');
 						}
 					});
     		 // });
 		} catch (ex) {
 		showMsgError(ex);
 		}

     }

		 function SetDropDownPlant() {
				$('#ddlPlant').val("");
				 var data = {};
					 data["status"] = "randomoil";
				try {
						$('#ddlPlant').html("");
						jQuery.ajax({
								url: 'util-getDropdownPlant',
								type: "Post",
								contentType: "application/json",
								data: JSON.stringify(data),
								async: false,
								cache: false,
								success: function(data) {
										$.each(data, function(i, item) {

												$('#ddlPlant').append('<option value="' + item.CENTER_CODE + '#'+item.PID+'">' + item.PNAMET + '</option>');
										});
										$('#ddlPlant').select2({
												dropdownAutoWidth: true,
												width: 'auto'
										});
								},
								error: function() {
										showMsgError('เกิดข้อผิดพลาด');
								}
						});

				} catch (ex) {
						showMsgError(ex);

				}
		}
		function renderDataToTable(){
				 var det = "";
				 var data ;
				 $('#dteId_').html("");
				 $('#myTableDteId_').DataTable().destroy();
			if(dataTemp!=undefined){
				//console.log(dataTemp);
				//console.log($('#ddlPlant').val());
				data = dataTemp;
				for (var i = 0; i < data.list.length; i++) {
					//console.log($('#ddlPlant').val());
					//console.log(data.list[i].PLANT_ID);
					if(data.list[i].CENTER_CODE==$('#ddlPlant').val().split("#")[0]){
						//console.log(data.list[i]);
						det +='<tr class="TBODY">';
						det +='<td class="text-center" ><a href="manageAnalysisOilDetail?reqNo='+(data.list[i].SEND_REQT_ID==null?"":data.list[i].SEND_REQT_ID)+'='+$('#ddlPlant').val().split("#")[1]+'">'+(data.list[i].SEND_REQT_ID==null?"":data.list[i].SEND_REQT_ID)+'</a></td>';
						det +='<td class="text-center" >'+(data.list[i].CREATE_BY==null?"":data.list[i].CREATE_BY)+'</td>';
						//det +='<td class="text-center" >'+(data.list[i].NAMECREATES==null?"":data.list[i].NAMECREATES)+'</td>';
						//det +='<td class="text-center" >'+(data.list[i].SAMPLE_STAFF_NAME==null?"":data.list[i].SAMPLE_STAFF_NAME)+'</td>';
						det +='<td class="text-center" >'+(data.list[i].CREATE_BY==null?"":data.list[i].CREATE_BY)+'</td>';
						det +='<td class="text-center" >'+(data.list[i].strCREATE_DATE==null?"":data.list[i].strCREATE_DATE)+'</td>';
						det +='<td class="text-center" >'+ (data.list[i].STATUS_NAME==null?"":data.list[i].STATUS_NAME)+'</td>';
						det +='<td class="text-center" >'+ (data.list[i].COUNT_SEND_REQT_ID==null?"":data.list[i].COUNT_SEND_REQT_ID)+'</td>';
						det +='</tr>';
					}

			 }

			   $('#dteId_').html("");
			 if(det==''){
				 det += '<tr> ';
				 det += '<th colspan="6" class="text-center">--- ไม่พบข้อมูล ---</th> ';
				 det += '</tr> ';
				 $('#dteId_').html(det);

			 }else{

				 $('#dteId_').html(det);
				  $('#myTableDteId_').DataTable().destroy();
				 // table =
				 $('#myTableDteId_').DataTable( {
				  searching: true,
				  responsive : true
				});

			 }
			}
		}

</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>บันทึกรับ(LAB Officer)</h2>

    </div>
    <div class="col-lg-2"></div>
</div>

<div class="wrapper wrapper-content animated fadeInRight">

     <%-- <c:forEach var="teamMember" items="${Model}"> --%>
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                  <div class="ibox-title">
	                    <%-- <h5>ใบคำขอวิเคราะห์&nbsp;<c:out value="${teamMember.PLANT_NAME}"/></h5> --%>
											  <h5>ใบคำขอวิเคราะห์&nbsp;</h5>
	                   <input type="hidden" name="hidden_namestore" id="hidden_namestore"  value="${teamMember.PLANT_ID}"   />
						<div class="col-xs-2">
						 <select id="ddlPlant" onchange="renderDataToTable()"></select>
						</div>
						<div class="col-xs-2 text-right" style="float: right;" >
						<form action="/Lab/manageAnalysisOilEdit"><input class="btn-primary" style="border-radius: 3px;" id="edit_oil" type="submit" value="แก้ไขลักษณะตัวอย่าง"></form>
						</div>
	                      <div class="ibox-tools">

<!--                         </a> -->
					

                    </div>
                 </div>
                 <div class="ibox-content">


                       <div class="row">
	                        <div class="col-xs-12" >
	                             <div class="table-responsive"   >
							         <%-- <table   id="myTableDteId_<c:out value="${teamMember.PLANT_ID}"/>" class="table table-striped table-bordered" style="padding: 0px;width:100%;"> --%>
											 <table   id="myTableDteId_" class="table table-striped table-bordered" style="padding: 0px;width:100%;">

								    		<thead  class="tbHeader">

																	<tr>
																	     <th class="text-center">REQ_NO.</th>
																	        <th class="text-center">CREATE_BY</th>
																	        <th class="text-center">NAME</th>
																	        <th class="text-center">CREATE_DATE</th>
																	       <th class="text-center">STATUS</th>
																	       <th class="text-center">COUNT</th>

																	</tr>
										 </thead>
										<%-- <tbody id="dteId_<c:out value="${teamMember.PLANT_ID}"/>"> --%>
										<tbody id="dteId_">

										</tbody>
									</table>
								 </div>
	                        </div>
	                    </div>

                </div>
            </div>
        </div>
    </div>
	 <%-- </c:forEach> --%>
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
