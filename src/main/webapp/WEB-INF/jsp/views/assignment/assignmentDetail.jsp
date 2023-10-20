<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>

<style>
.tbHeader {
	font-size:  10px;
	background: #3c8dbc;
	color: white;
}
</style>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2><span id="pageTitles"></span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight" style="padding-bottom:0px"> 
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-content">
					<div class="row">
						<div class="col-lg-4"><span><label>หมายเลข LTR </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_no"></span></div>
						<div class="col-lg-4"><span><label>ผลิตภัณฑ์ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_prod"></span></div>
						<div class="col-lg-4"><span><label>เลขที่รถ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_carno"></span></div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>วันที่ PO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_datepo"></span> </div>
						<div class="col-lg-4"><span><label>แหล่งที่มา </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_src"></span> </div>
						<div class="col-lg-4"><span><label>ช่องรถ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_carslot"></span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ PO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_po"></span> </div>
						<div class="col-lg-4"><span><label>ระบบขนส่ง </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_trans"></span> </div>
						<div class="col-lg-4"><span><label>เลขที่เรือ  </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatno"></span></div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ DO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_do"></span></div>
						<div class="col-lg-4"><span><label>รูปแบบการเก็บ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_samp"></span> </div>
						<div class="col-lg-4"><span><label>ชื่อเรือ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatname"></span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ SHIPMENT </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_ship"></span> </div>
						<div class="col-lg-4"><span><label>วันที่สุ่ม </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_daterandom"></span></div>
						<div class="col-lg-4"><span><label>ช่องเรือ</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatslot"></span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>รหัสกลุ่ม </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_grp"></span> </div>
						<div class="col-lg-4"><span><label>วันที่หมดอายุ</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_dateexp"></span> </div>
						<div class="col-lg-4"><span><label>ชื่อพนักงาน</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_empname"></span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>ประเภทตัวอย่าง</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_sampleType"></span> </div>
						<div class="col-lg-4"><span><label>รายละเอียดตัวอย่าง</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_sampleType_desc"></span> </div>
					</div>
				</div>
				
				
			</div>
		</div>
	</div>
	<div class="row ibox-content assign-detail">
		<div class="col-xs-12">
			<div class="table-responsive"   >
				<table   id="assiDetialT" class="table table-striped table-bordered" style="padding: 0px;">
					<thead>
						<tr class="tbHeader">
							<th class="text-center">PRODUCT</th> 
							<th class="text-center">TYPE</th> 
							<th class="text-center">รายการวิเคราะห์</th>						
							<th class="text-center">METHOD</th>
							<th class="text-center">เครื่องมือวิเคราะห์</th>
							<th class="text-center">กลุ่มงาน </th>
						</tr>
					</thead>
					<tbody id="assiDetial">
					</tbody>
				</table> 
			</div>
		</div>
	</div>
</div>
<div class="row col-sm-12">
	<div class="col-sm-6 back-bt">
		<button type="button" class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()">
			กลับไปหน้าหลัก<i class="fa fa-reply" style="font-size:22px;color:orange"></i>
	    </button>
	</div>
	<div class="col-sm-6 save-data-bt">
		<button type="button" class="btn btn-success center-block"  style="width: 150px;" onclick="saveData()">บันทึกข้อมูล
	    </button>
	
	</div>
	                       
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document" style="width: 30%;height: 30%;margin-left: 40%;">
	<div class="modal-content">
		<div class="modal-header bg-primary">
		

	<h2 class="modal-title" id="modalLabel">การแจ้งเตือน</h2>
	</div>
	<div class="modal-body h3" style="text-align: center;    margin-top: 5%;" id="error-body">
		<div class="row text-left "style="margin-left: 3px;"><label>กรุณาตั้งค่าผลิตภัณฑ์ และบันทึกผล</label></div>
        <div class="row text-center"><label>ชื่อผลิตภัณฑ์ :</label><span id="err_prd"></span></div>
		<div class="row text-center"><label>ชื่อตัวอย่าง  :</label><span id="err_sample"></span></div>
	</div>
	<div class="modal-footer">
	<button type="button" class="btn btn-secondary" id="close_error_pop" data-dismiss="modal">OK</button>
	</div>
	</div>
	</div>
</div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>

