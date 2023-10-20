<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link
	href="${pageContext.request.contextPath}/assets/select2/select2.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>

<style>
.tbHeader {
	font-size: 10px;
	background: #3c8dbc;
	color: white;
}
</style>

<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>ตั้งค่าข้อมูลแหล่งที่มา</h2>
	</div>
	<div class="col-lg-2"></div>
</div>
<div id="role_admin" style="display: block;">
	<div class="wrapper wrapper-content animated fadeInRight"
		style="padding-bottom: 0px">
		<div class="row ibox-content assign-detail">
			<div class="row">
				<div class="col-xs-6 col-md-8"></div>
				<div class="col-xs-3 col-md-2">
					<button type="button" class="btn btn-success center-block "
						style="width: 150px;" id="btn_adduser" onclick="btnAddClick()">เพิ่ม
					</button>
				</div>
				<div class="col-xs-3 col-md-2">
					<button type="button" class="btn btn-danger center-block "
						style="width: 150px;" onclick="deletesource()">ลบ</button>
				</div>
			</div>
			<div class="col-xs-12">
				<p></p>
			</div>
			<div class="col-xs-12">
				<div class="table-responsive">
					<table id="usertable" class="table table-striped table-bordered"
						style="padding: 0px; width: 100%">
						<thead>
							<tr class="tbHeader">
								<th class="text-center">No</th>
								<th class="text-center">ลบ</th>
								<th class="text-center">รหัสแหล่งที่มา</th>
								<th class="text-center">ชื่อแหล่งที่มา</th>
								<th class="text-center">Company Code</th>
								<th class="text-center">แก้ไข</th>
							</tr>
						</thead>
						<tbody id="usertabledtail">
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<div id="modalAdd" class="modal fade" role="dialog">
		<div class="modal-dialog center-modal"
			style="width: 50%; height: 54%; margin-left: 25%;" id="setup_modal">
			<div class="modal-content">
				<div class="modal-header" style="background-color: #1ab394;">
					<!-- 					<h4 class="modal-title text-white ch_txt">เพิ่มแหล่งที่มา</h4> -->
					<label class="h4 modal-title text-white ch_txt" id="headertext4">Text</label>
				</div>
				<div class="modal-body">
					<form method='post' id='add_source' action=''
						enctype="multipart/form-data">
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<label>รหัสแหล่งที่มา</label> <input type="text"
										class="form-control" maxlength="10" id="source_id"
										name="source_id" onkeypress="return onlyNumberKey(event)" required>
								</div>
								<span id="text_error" style="display: none; color: red">
								</span>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label>ชื่อแหล่งที่มา</label> <input type="text"
										class="form-control" maxlength="60" id="source_name"
										name="source_name" required>
								</div>
								<span id="text_error2" style="display: none; color: red">
								</span>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<label>Company Code</label> <input class="form-control "
										type="text" id="codecomp" name="codcomp" value="">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-2 ">
								<input class="btn btn-success" id="submit_source" type="button"
									value="บันทึก" onclick="saveSource('add')"> <input
									class="btn btn-success" id=editSource type="button"
									value="บันทึก" onclick="saveSource('edit')">
							</div>
							<div class="col-md-2">
								<input class="btn btn-danger" id="cancel_source" type="button"
									value="ยกเลิก" data-dismiss="modal" onclick="emptyModal()">
							</div>
						</div>
					</form>
				</div>

			</div>

		</div>
	</div>
</div>
<div class="col-sm-12">
	<p></p>
</div>
<div class="col-sm-12">
	<p></p>
</div>
<div class="col-sm-12">
	<p></p>
</div>
<div class="col-sm-12">
	<p></p>
</div>