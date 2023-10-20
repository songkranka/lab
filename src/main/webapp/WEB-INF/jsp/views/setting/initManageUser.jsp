<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>

<style>
.tbHeader {
	font-size:  10px;
	background: #3c8dbc;
	color: white;
	
.center-modal {
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
}
</style>

<div class="row wrapper border-bottom white-bg page-heading" >
    <div class="col-lg-10">
        <h2>Manage User</h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div id="role_admin" style="display: block;">
<div class="wrapper wrapper-content animated fadeInRight" style="padding-bottom:0px"> 
	<div class="row ibox-content assign-detail">
		<div class="row">
			<div class="col-xs-6 col-md-8">

			</div>
			<div class="col-xs-3 col-md-2">
				<button type="button" class="btn btn-success center-block "  style="width: 150px;" id="btn_adduser">เพิ่ม
	    		</button>
			</div>
			<div class="col-xs-3 col-md-2">
				<button type="button" class="btn btn-danger center-block "  style="width: 150px;" onclick="deleteuser()">ลบ
	    		</button>
			</div>
		</div>
		<div class="col-xs-12"><p></p></div>
		<div class="col-xs-12">
			<div class="table-responsive"   >
				<table   id="usertable" class="table table-striped table-bordered" style="padding: 0px;width: 100%">
					<thead>
						<tr class="tbHeader">
						    <th class="text-center">No</th> 
							<th class="text-center">ลบ</th>
							<th class="text-center">รหัสพนักงาน</th> 
							<th class="text-center">ชื่อ-นามสกลุล</th> 
							<th class="text-center">กลุ่มงาน</th> 
							<th class="text-center">plant</th> 
							<th class="text-center">สถานะ</th> 
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

<div id="modalAddUser" class="modal fade" role="dialog">
  <div class="modal-dialog center-modal" style="width: 50%;height: 54%;margin-left: 25%;" id="setup_modal">
    <div class="modal-content">
      <div class="modal-header" style="background-color: #1ab394;">
        <h4 class="modal-title text-white ch_txt">เพิ่ม User </h4>
      </div>
      <div class="modal-body">
      	 <form method='post' id='add_User' action='' enctype="multipart/form-data">
       	<div class="row">
       		<div class="col-sm-6"  id="add_div"><div class="form-group"><label>รหัสพนักงาน</label>
				<div class="input-group">
				<input type="search" class="form-control" maxlength="60" id="code_empid" name="code_empid">
				<span class="input-group-btn">
				<button class="btn btn-primary" type="button" id="check_user"><span class="glyphicon glyphicon-search" aria-hidden="true">
				</span> Search!</button>
				</span>
				
				</div>
       		</div><span id="text_error" style="display: none;color: red"></span></div>
       		<div class="col-sm-6" style="display: none;" id="edit_div"><div class="form-group"><label>รหัสพนักงาน</label>
			<input type="text" class="form-control" maxlength="60" id="code_empid_txt" name="code_empid_txt" disabled="disabled">
       		</div></div>
       		<div class="col-sm-6"><div class="form-group"><label>ชื่อ-นามสกุลพนักงาน</label><input class="form-control " type="text" id="name_emp" name="name_emp" value="" disabled="disabled"></div></div>
       	</div>
       	<div class="row">
       		<div class="col-sm-6"><div class="form-group"><label>กลุ่มงาน</label><select class="form-control"  id="role_dropdown" name="role_dropdown" disabled="disabled"></select></div></div>
       		<div class="col-sm-6"><div class="form-group"><label>Plant</label><select class="form-control" id="plat_dropdown"  name="plat_dropdown"  disabled="disabled"></select></div></div>
       	</div>
       	<div class="row">
       		<div class="col-sm-6"><div class="form-group"><label>สถานะการใช้งาน</label><select class="form-control" id="status_dropdown"  name="status_dropdown"  disabled="disabled"></select></div></div>
       		<div class="col-sm-6"><div class="form-group"><label>การอัพโหลดลายเซ็นต์</label><input class="form-control" id="upload_signature" name="upload_signature" type="file"></div></div>
       	</div>
       	<div id="div_img" style="display: block;">
       	<label>รูปแบบ Signature</label>
       		<div id="body_img" class="text-center">
       			
       		</div>
       	</div>
       	<div class="row">
       		
       		<div class="col-sm-6 text-center" ><input class="btn btn-success" id="submit_user" type="button" value="บันทึก" disabled="disabled"></div>
       		<div class="col-sm-6 text-center" ><input class="btn btn-danger" id="cancel_user" type="button" value="ยกเลิก" data-dismiss="modal"></div>
       	</div>
       	</form>
      </div>

    </div>

  </div>
</div>
</div>		
<div id="role_user" class="wrapper wrapper-content animated fadeInRight" style="padding-bottom:0px;display: none;">
	<div class="row ibox-content assign-detail">
      	 <form method='post' id='user_edit' action='' enctype="multipart/form-data">
       	<div class="row">
       		<div class="col-sm-6" ><div class="form-group"><label>รหัสพนักงาน</label>
			<input type="text" class="form-control" maxlength="60" id="code_empid_usr" name="code_empid" disabled="disabled">
       		</div></div>
       		<div class="col-sm-6"><div class="form-group"><label>ชื่อ-นามสกุลพนักงาน</label><input class="form-control " type="text" id="name_emp_usr" name="name_emp" value="" ></div></div>
       	</div>
       	<div class="row">
       		<div class="col-sm-6"><div class="form-group"><label>กลุ่มงาน</label><select class="form-control"  id="role_dropdown_usr" name="role_dropdown" disabled="disabled"></select></div></div>
       		<div class="col-sm-6"><div class="form-group"><label>Plant</label><select class="form-control" id="plat_dropdown_usr"  name="plat_dropdown" disabled="disabled"></select></div></div>
       	</div>
       	<div class="row">
       		<div class="col-sm-6"><div class="form-group"><label>สถานะการใช้งาน</label><select class="form-control" id="status_dropdown_usr"  name="status_dropdown" disabled="disabled"></select></div></div>
       		<div class="col-sm-6"><div class="form-group"><label>การอัพโหลดลายเซ็นต์</label><input class="form-control" id="upload_signature_usr" name="upload_signature" type="file"></div></div>
       	</div>
       	<div id="div_img_usr" style="display: none;margin-bottom: 10px">
       	<label>รูปแบบ Signature</label>
       		<div id="sig_usr" class="text-center">
       			
       		</div>
       	</div>
       	<div class="row">
       		
       		<div class="col-sm-12 text-center" ><input class="btn btn-success " id="submit_user_detail" type="button" value="บันทึก" ></div>
       		
       	</div>
       	</form>
      </div>
</div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
