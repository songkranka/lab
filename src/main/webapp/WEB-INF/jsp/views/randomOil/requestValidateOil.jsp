<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<!-- Select2 -->
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.29.2/sweetalert2.all.js"></script>
<!-- <div class="box box-success box-solid"> -->
<style type="text/css">
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
.modal fade {
  width: 750px;
  margin: auto;
}
</style>
<script>

   
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>เก็บตัวอย่าง(STORE Officer)</h2>
       
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
		                   	<h5>รายการสุ่มตัวอย่าง<c:out value="${Model.PLANT_NAME}"/></h5> &nbsp;  
	                            <a href="#" onclick="printAll()"><span class="glyphicon glyphicon-print"></span> Print ฉลาก </a>
	                   	</div> 		
	                   	<div class="ibox-title-col-sm-6 text-right">
	                   		<select id="selectType" multiple="multiple"></select>&nbsp;<button class="btn btn-primary" onclick="searchSampleType(this)">ค้นหา</button>
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
																		        
																		        <th style="width:5%" class="text-center">&nbsp;<input id="example-select-all" value="1" name="select_all" type="checkbox" onclick="selectAllNew(this)"></th>
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
	            
	            <div class="text-center"><button type="button" id="loginbotttom4" onclick="sendRequestRandomOil();" 
	                            class="btn btn-primary center-block">
	               สร้างใบคำขอวิเคราะห์  
	                &nbsp;<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button></div>
	                
	        </div>
	       
  </div>
  <div class="row">
                        <div class="col-md-12">&nbsp;
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
	    <div class="modal-dialog vertical-align-center" style="position:absolute;
  																top:40% !important;
  																left:25% !important;
  																margin:auto 5%;
 		 														width:40%;
  																height:40%;">
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
	                		<div class="col-sm-12">
	                        	<div class="col-sm-4">
	                        		<label>สาเหตุ</label>
	                        	</div>
	                        	<div class="col-sm-4 select-Cause">
	                        		<select id="selectCause_cancel" >
	                        		</select>
	                        	</div>
	                        	<div class="col-sm-4 other-select-Cause">
	                        		<input type="text" class="form-control" id="other_Cause_cancel"/>
	                        	</div>
	                        </div>
	               <div class="col-sm-12"><p></p></div>
	               			<div class="col-sm-12">
	                        	<div class="col-sm-4">
	                        		<label>เหตุผล</label>
	                        	</div>
	                        	<div class="col-sm-8">
	                        		<input type="text" class="form-control" id="causeChgStatus_cancel" maxlength="100"/>
	                        	</div>   	
	                        </div>
	                        <div class="col-sm-12"><p></p></div>
	                        <div class="col-sm-12">
	                        	<div class="col-xs-12 text-right">
	                        		<button class="btn btn-primary" onclick="CancelData()">
                                       	 ยกเลิก
                                    </button>
	                        	</div>
	                        </div>
                    </div>

	                </div>
	            </div>
	        </div>
	    </div>
	  </div>
<div class="col-sm-12"></div>

<label id="funcID"></label>
 <label id="delID"></label>
 <label id="labcodeID"></label>
  <label id="sampleRefer"></label>
