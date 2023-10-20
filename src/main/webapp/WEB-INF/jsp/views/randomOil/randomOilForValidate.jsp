<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>สุ่มตัวอย่างเพื่อตรวจ(LAB Officer)</h2>
	</div>
	<div class="col-lg-2"></div>
</div>

<div id="wrapperOilValidate" class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title" style="text-align:right">  จำนวนรอสุ่มเพื่อตรวจ : <span id="cntRandomSample"></span> รายการ
				</div>
				
				<div class="ibox-content"> 
					<div class="row">
						<div class="col-xs-12">
							<div class="col-xs-3">
								<input type="text" style="width: 100%;"  class="form-control input-sm"   name="labCode" id="labCode"  />
							</div>
							<div class="col-xs-6">
								<button type="button" class="btn btn-danger" style="width: 100px;text-align:center;" onclick="updateStatus('11')">ยกเลิก</button>
							</div> 	
							<div class="col-xs-3 text-right">
									<button class="btn btn-primary" onclick="saveRandomOil()">
										<i class="fa fa-search"></i>&nbsp;สุ่มตัวอย่างเพื่อตรวจ
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

	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				  <div class="ibox-title">
				  		<h5>ตัวอย่าง Retention</h5>  	
				 </div>
				 <div class="ibox-content">
				 		<div class="row">
				 		<div class="col-lg-7"></div>
				 		<div class="col-lg-3">
					  	 <select class="form-control col-lg-3" id="ddlPodate" ></select>
					   </div>
					   <div class="col-lg-2 text-right">
					  	 <button class="btn btn-primary" onclick="updateStatus('P')"><i class="fa fa-group"></i> เลือก</button>	 	
					   </div>
				 	</div>
				 	<div class="row"><p></p></div>
					   <div class="row">
					   		<!-- <div class="col-lg-3 text-center">
					   		
					   		</div> -->

							<div class="col-xs-12" >
				  					
								 <div class="table-responsive"   >
								 
									 <table id="tblReten" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
										<thead  class="tbHeader">		
									<tr>
										<th style="width: 20%;" class="text-center">LAB_CODE</th>
                                        <th style="width:5%" class="text-center">&nbsp;<input 
                                        id="example-select-all" value="" name="select_all" type="checkbox" onclick="selectAllNew(this)"></th>
                                        <th class="text-center">ชนิด</th>
                                        <th class="text-center">ผลิตภัณฑ์</th>
                                        <th class="text-center">แหล่งที่มา</th>
                                        <th class="text-center">ระบบขนส่ง</th>
                                        <th class="text-center">รูปแบบการเก็บ</th>
                                        <th class="text-center">เลขกลุ่ม<br/>การสุ่ม</th>
                                        <th class="text-center"> เลขที่<br />PO</th>
                                        <th class="text-center">วันที่<br />PO</th>
                                        <th class="text-center">เลขที่<br />DO</th>
                                        <th class="text-center"> เลขที่<br />SHIPMENT</th>
                                        <th class="text-center">ลำดับ</th>
                                        <th class="text-center">ลำดับย่อย</th>
                                        <th class="text-center">เลขมิเตอร์</th>
                                        <th class="text-center">เลขที่รถ</th>
                                        <th class="text-center">ช่่องรถ</th>
                                        <th class="text-center">ชื่อเรือ</th>
                                        <th class="text-center">ช่่องเรือ P</th>
                                        <th class="text-center">ช่่องเรือ S</th>
                                        <th class="text-center">LOT NO.</th>
                                        <th class="text-center">วันที่<br />การสุ่ม</th>
                                        <th class="text-center"> วันที่<br />หมดอายุ</th>
                                        <th class="text-center">รหัสพนักงาน</th>
                                        <th class="text-center">ชื่อพนักงาน</th>
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
										<tbody id="tbodyReten"></tbody>
									</table>
								 </div>
							</div>
						</div>
				</div>				    
			</div>
		</div>
	</div>

 
  <div id="popup_random" class="modal in" tabindex="-1" data-backdrop="static" data-keyboard="false">
	    <div class="modal-dialog" style="width:800px;">
	        <div class="modal-content-wrapper">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <button type="button" class="close"  data-dismiss="modal" aria-label="Close"  >
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                    <h4 class="modal-title">สรุปรายการสุ่มรอบที่ 2</h4>
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
													<th class="text-center">SOURCE </th>
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
 
