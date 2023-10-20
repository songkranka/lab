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
var data_lab='';
var table = "";
var  reqno  = "",namestore="";
var flag="";
$(document).ready(function () {
   	 getProductDescription();
     //initParam();
     $("#labCode").val("").focus();
     
     $('#edit_oil_btn').click(function(){
    
    	 $('#modal_oil_edit').modal();
    	 
     });
    
	
	$( "#input_editoil" ).change(function() {
		if($(this).children(":selected").attr("id")==50){
			$("#other_oil").css("display", "block");
		}else{
			$("#other_oil").css("display", "none");
		}
  		
	});
	$('#input_editoil').trigger("change");
	
   $('#inputOilOther' ).change(function() {
		$('#inputOilOther').css('border-color', '#e5e6e7');
	});
	$( '#inputOilOther' ).keypress(function() {
  $('#inputOilOther').css('border-color', '#e5e6e7');
	});
	
	initTable();
    	
});
    function initTable(){
		table =  $('#myTableDteId').DataTable( {
				"pageLength": 20,
			searching: true,
			responsive : true,
			"columnDefs": [
			    { "orderable": false, "targets": 1 }
			  ]
		});
    }
// 	function initParam(){
// 		var  url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');    		
// 		 var reqno_v = url[0].split('='); 
// 		 reqno  =  reqno_v[1];
// 		 namestore =  reqno_v[2];
// 		 inquiryRandomOil();
// 		 selectAllNew();
// 	}

function getProductDescription(){
	try {   		 
		 var data = {}
		 
		  jQuery.ajax({
			url : 'util-getProductionDescription',
			type : "Get", 
			contentType : "application/json",
			//data : JSON.stringify(data),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {

			var $inputProductDesc = $('#input_editoil');
            $inputProductDesc.empty();
            for (var i = 0; i < data.length; i++) {
                $inputProductDesc.append('<option id=' + data[i].PDDESC_ID + ' value=' + data[i].PDDESC_ID+ '>' + data[i].PDDESC_NAME + '</option>');
            }
			
			
			},
			error : function(ex) {
				showMsgError(ex);
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		 
	}
}
function saveEditoil(){
	ShowWaiting() ;
	var data={};
		var dataSelectDesc='';
		var dataSelectId=$("#input_editoil").val();
		if(dataSelectId=='50'){
			dataSelectDesc=$('#inputOilOther').val();
		}else{
			dataSelectDesc=$("#input_editoil :selected").text();
		}
		 $("input[name='chk']").each(function() {  
				
 	        if($(this).prop('checked')){
 	        	data_lab = $(this).val();
 	        }
	     });
		 if(data_lab==''||data_lab==null){
			 showMsgError("กรุณาเลือกใบงานเพื่อระบุสาเหตุ");
			 HideWaiting() ;
			 return null;
		 }
		data["labCode"] = data_lab;
		data["productID"]=dataSelectId;
		data["product_desc"]=dataSelectDesc;
		console.log(JSON.stringify(data));
		
	  jQuery.ajax({
		url : 'util-saveEditOil',
		type : "Post", 
		contentType : "application/json",
		data : JSON.stringify(data), 
		dataType : 'json',
		  async: false,
		   cache: false,
		   success : function(res) { 
			   showMsgSuccess('บันทึกข้อมูลสำเร็จ');
			   window.location='/Lab/manageAnalysisOilEdit';
			   HideWaiting();
           },
           error : function(e) {
               showMsgError('เกิดข้อผิดพลาด');
               HideWaiting();
           }
       });

} 
function inquiryRandomOil(labcode){
  	  	try {
     		      $('#dteId').html("");
     	  	 
    		       $('#myTableDteId').DataTable().destroy();
     		 
 		    			var data = {}
 		    			data["labCode"] = labcode;
 		    			console.log(JSON.stringify(data));
 		    			ShowWaiting() ;
 					  jQuery.ajax({
 						url : 'util-getOilforEdit',
 						type : "Post", 
 						contentType : "application/json",
 						data : JSON.stringify(data), 
 						dataType : 'json',
 						  async: false,
 						   cache: false,
 						success : function(data) {
 							console.log(data);
 							if(data.length==1) {
 							 var det = "";
 							     tmp_data = data; 
 							     //alert(tmp_data);
 							        //   alert(data.list.length);
 							        var dataT = data;
 										 for (var i = 0; i < data.length; i++) { 
 											det +='<tr  class="TBODY">';
 											det +='<td class="text-center" >'+ (data[i].LAB_CODE==null?"":data[i].LAB_CODE) +'</td>';
 											
 											//det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(data[i].LAB_CODE==null?"":data[i].LAB_CODE)+'" /> </td>';
 											det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(data[i].LAB_CODE==null?"":data[i].LAB_CODE)+'" /> </td>';
 											if(data[i].FLAG_VERIFY == 'Y'){
 		   		   								det += '<td class="text-center" ><i class="glyphicon glyphicon-ok"></i></td>';
 		   		   							}else if(data[i].FLAG_VERIFY == 'I'){
 		   		   								det += '<td class="text-center" ><i class="glyphicon glyphicon-info-sign"></i></td>';
 		   		   							}
 											else{
 		   		   								det += '<td class="text-center" ><i class="glyphicon glyphicon-remove"></i></td>';
 		   		   							}
 											det +='<td class="text-left" >'+ (data[i].SAMPLE_TYPE_NAME==null?"":data[i].SAMPLE_TYPE_NAME)+'</td>';
  											//
 											det +='<td class="text-left" >'+ (data[i].product_name==null?"":data[i].product_name)+'</td>';
  											det +='<td class="text-left" >'+(data[i].source_name==null?"":data[i].source_name)+'</td>'; 
  											
  											if("T" ==data[i].SAMPLE_TYPE_NAME){
  												det +='<td class="text-left" > - </td>';
  											}else{
  												det +='<td class="text-left" >'+(data[i].logis_name==null?"":data[i].logis_name)+'</td>';
  											}
  											
  											
  											det +='<td class="text-leftr" >'+(data[i].SAMPLE_LEVEL_DESC==null?"":data[i].SAMPLE_LEVEL_DESC)+'</td>';
 											//
 											det +='<td class="text-left" >'+ (data[i].SAMPLE_REFER==null?"":data[i].SAMPLE_REFER)+'</td>';
  											det +='<td class="text-left" >'+(data[i].PO_NO==null?"":data[i].PO_NO)+'</td>'; 
  											det +='<td class="text-left" >'+(data[i].STRPO_DATE==null?"":data[i].STRPO_DATE)+'</td>'; 
  											det +='<td class="text-left" >'+(data[i].DO_NO==null?"":data[i].DO_NO)+'</td>'; 
  											det +='<td class="text-left" >'+(data[i].SHIPMENT_NO==null?"":data[i].SHIPMENT_NO)+'</td>';  
  											det +='<td class="text-left" >'+(data[i].SAMPLE_DATA_GROUP==null?"":data[i].SAMPLE_DATA_GROUP)+'</td>'; 
  											det +='<td class="text-left" >'+(data[i].SAMPLE_DATA_SEQ==null?"":data[i].SAMPLE_DATA_SEQ)+'</td>';  
  											det +='<td class="text-left" > '+(data[i].METER_NO==null?"":data[i].METER_NO)+'</td>';
  											det +='<td class="text-left" > '+(data[i].CAR_NO==null?"":data[i].CAR_NO)+'</td>';
  											det +='<td class="text-left" >'+(data[i].CAR_SLOT==null?"":data[i].CAR_SLOT)+'</td>';
  											//det +='<td class="text-left" >'+(data[i].BOAT_NO==null?"":data[i].BOAT_NO)+'</td>';
 											det +='<td class="text-left" >'+(data[i].BOAT_NAME==null?"":data[i].BOAT_NAME)+'</td>';
 											det +='<td class="text-left" >'+(data[i].BOAT_SLOTP==null?"":data[i].BOAT_SLOTP)+'</td>'; 
 											det +='<td class="text-left" >'+(data[i].BOAT_SLOTS==null?"":data[i].BOAT_SLOTS)+'</td>'; 
 											//det +='<td class="text-left" >'+(data[i].ADDITIVE_INV_NO==null?"":data[i].ADDITIVE_INV_NO)+'</td>'; 
 											det +='<td class="text-left" >'+(data[i].ADTV_LOT_NO==null?"":data[i].ADTV_LOT_NO)+'</td>'; 
 											
  											det +='<td class="text-center" >'+(data[i].STR_SAMPLE_DATE==null?"":data[i].STR_SAMPLE_DATE)+'</td>';
  											det +='<td class="text-center" >'+(data[i].STR_SAMPLE_EXPIRE_DATE==null?"":data[i].STR_SAMPLE_EXPIRE_DATE)+'</td>';
  											//
  											
  											//
  											det +='<td class="text-left" >'+(data[i].SAMPLE_STAFF_ID==null?"":data[i].SAMPLE_STAFF_ID)+'</td>';
  											det +='<td class="text-left" >'+(data[i].SAMPLE_STAFF_NAME==null?"":data[i].SAMPLE_STAFF_NAME)+'</td>';
  											//det +='<td class="text-left" >'+(data[i].OTHERLOGISTIC==null?"":data[i].OTHERLOGISTIC)+'</td>';
  											//det +='<td class="text-left" >'+(data[i].SOURCE_OTHER_DESC==null?"":data[i].SOURCE_OTHER_DESC)+'</td>';
  											det +='<td class="text-left" >'+(data[i].SUB_TYPE_NAME==null?"":data[i].SUB_TYPE_NAME)+'</td>';
  											det +='<td class="text-left" >'+(data[i].SAMPLE_TYPEC_DESC==null?"":data[i].SAMPLE_TYPEC_DESC)+'</td>';
  											det +='<td class="text-left" >'+(data[i].TANK_NO==null?"":data[i].TANK_NO)+'</td>';
  											det +='<td class="text-left" >'+(data[i].TYPE_NAME==null?"":data[i].TYPE_NAME)+'</td>';
  											det +='<td class="text-left" >'+(data[i].LOC_NAME==null?"":data[i].LOC_NAME)+'</td>';
  											det +='<td class="text-left" >'+(data[i].SAMPLE_POINT_DESC==null?"":data[i].SAMPLE_POINT_DESC)+'</td>';
  											det +='<td class="text-left" >'+(data[i].RETURNR_DESC==null?"":data[i].RETURNR_DESC)+'</td>';
  											det +='<td class="text-left" >'+(data[i].STATUS_NAME==null?"":data[i].STATUS_NAME)+'</td>';
  											det +='<td class="text-left" >'+(data[i].CANCEL_DESC==null?"":data[i].CANCEL_DESC)+'</td>';
  											det +='<td class="text-left" >'+(data[i].CANCEL_NAME==null?"":data[i].CANCEL_NAME)+'</td>';
  											det +='<td class="text-left" >'+(data[i].REVISE_DESC==null?"":data[i].REVISE_DESC)+'</td>';
  											det +='<td class="text-left" >'+(data[i].REVISE_CODE==null?"":data[i].REVISE_CODE)+'</td>';
  											det +='<td class="text-left" >'+(data[i].PDDESC_ID==null?"":data[i].PDDESC_ID)+'</td>';
  											det +='<td class="text-left" >'+(data[i].PRODUCT_DESC==null?"":data[i].PRODUCT_DESC)+'</td>';
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
 
    function gotoMain(){
    	window.location="manageAnalysisOil?"+namestore; 
    } 
    function submitOnEnter(inputElement, event) {
        if (event.keyCode == 13&&$('#labCode').val().length>=23) {
        	//find labcode
        	inquiryRandomOil($('#labCode').val());
        }
    }
    
    function searchlabcode() {
        if ($('#labCode').val().length>=23) {
        	
        	inquiryRandomOil($('#labCode').val());
        }
    }


 
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>แก้ไขบันทึกรับ</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>


<div class="wrapper wrapper-content animated fadeInRight"> 
     
    
    <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                      <div class="row">
	                        <div class="col-xs-12" style="margin-bottom: 10px;">
	                                 <div class="col-sm-3" >
<!-- 	                                 <div class="input-group"> -->
<!-- 	                                 <input type="text"   class="form-control input-sm"   name="labCode" id="labCode"  onkeypress="submitOnEnter(this,event)"/> -->
<!-- 	                                 <span class="input-group-btn"> -->
<!-- 									<button class="btn btn-primary" type="button" id="check_user"><span class="glyphicon glyphicon-search" aria-hidden="true"> -->
<!-- 									</span> Search!</button> -->
<!-- 									</span> -->
<!-- 	                                 </div> -->
				<label>ค้นหา Labcode </label>
				<div class="input-group">
				
				<input type="text"   class="form-control" maxlength="24"  name="labCode" id="labCode"  onkeypress="submitOnEnter(this,event)"/>
				<span class="input-group-btn">
				<button class="btn btn-primary" type="button" onclick="searchlabcode()"><span class="glyphicon glyphicon-search" aria-hidden="true">
				</span> Search!</button>
				</span>
				
				</div>
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
																		         <th style="width:5%" class="text-center">เลือก</th>
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
									                                        <th class="text-center">ID การปรับปรุง</th>
									                                        <th class="text-center">อธิบาย การปรับปรุง</th>
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
			                    class="btn btn-primary center-block"  style="width: 150px;" id="edit_oil_btn" 
			            >ปรับปรุงใบบันทึกรับ 
			            </button>
	            </div> 
	            
	        </div>
	        <!-- /.col -->
	 </div>
<div class="modal fade" id="modal_oil_edit" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document" style="width: 30%;height: 33%;margin-left: 40%;" id="dialog_getwork">
	<div class="modal-content">
		<div class="modal-header bg-primary">
		

	<h2 class="modal-title" id="modalLabel">สาเหตุของการแก้ไข</h2>
	</div>
	<div class="modal-body" style="text-align: center;" >
		<label class="col-xs-12 h4 text-left">โปรดเลือก สาเหตุของการแก้ไข</label>
	     <div >
			<div class="row ">
			   <div class="col-sm-12 ">
			      <div class="form-group" style="text-align: left">
			         <select class="form-control" id="input_editoil">
			            <option value="01">small</option>
			            <option value="02">medium</option>
			            <option value="99" id="99">large</option>
			         </select>
			      </div>
			      <div style="display: none;" id="other_oil">
			      <label class="col-xs-12 text-left">อื่นๆ โปรดระบุ</label>
			      <div class="row">
			      <div class="col-sm-12">
			      <div class="form-group" style="text-align: left">
			         <input class="form-control " type="text" id="inputOilOther" value="">
			      </div>
			     </div>
			     </div>
			     </div>
			   </div>
			</div>
		</div>

	</div>
	<div class="modal-footer">
	<button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="saveEditoil()"  >บันทึก</button>
	</div>
	</div>
	</div>
</div>
  </div>
 
 
  
 
