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
<input type="hidden" value="" id="indexColorTxt"/>
<input type="hidden" value="" id="flag"/>
<div class="row wrapper border-bottom white-bg page-heading" >
    <div class="col-lg-10">
        <h2>จัดการ Color</h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div id="role_admin" style="display: block;">
<div class="wrapper wrapper-content animated fadeInRight" style="padding-bottom:0px"> 
	<div class="row ibox-content assign-detail">
		<div class="row">
			<div class="col-xs-0 col-md-8">

			</div>
			<div class="col-xs-6 col-md-2">
				<button type="button" class="btn btn-success center-block "  style="width: 150px;" id="btn_addcolor">เพิ่ม
	    		</button>
			</div>
			<div class="col-xs-6 col-md-2">
				<button type="button" class="btn btn-danger center-block "  style="width: 150px;" onclick="deletecolor()">ลบ
	    		</button>
			</div>
		</div>
		<div class="col-xs-12"><p></p></div>
		<div class="col-xs-12">
			<div class="table-responsive"   >
				<table   id="colortb" class="table table-striped table-bordered" style="padding: 0px;width: 100%">
					<thead>
						<tr class="tbHeader">
							<th class="text-center">NO.</th> 
							<th class="text-center">ลบ</th>
							<th class="text-center">Color NAME</th> 
							<th class="text-center">Color CODE</th> 
							<th class="text-center">แก้ไข</th> 
						</tr>
					</thead>
					<tbody id="colordt">
					</tbody>
				</table> 
			</div>
		</div>
			  <div class="form-group">
	      
	        <div class="col-sm-12">
	            <div class="col-sm-12">
		            <button type="button"
		                    class="btn btn-danger center-block"   onclick="gotoMain()" 
		            >กลับไปหน้าจัดการข้อมูล Master&nbsp;
		                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
		            </button>
		       </div>
	        </div>
	        <!-- /.col -->
	 </div>
	</div>
	
	
</div>

<div id="modalAddColor" class="modal fade" role="dialog">
  <div class="modal-dialog center-modal" style="width: 40%;height: 25%;margin-left: 30%;" id="setup_modal">
    <div class="modal-content">
      <div class="modal-header" style="background-color: #1ab394;">
        <h4 class="modal-title text-white ch_txt">เพิ่ม Color</h4>
      </div>
      <div class="modal-body">
      	 <form method='post' id='add_Tool' action='' enctype="multipart/form-data">
       	<div class="row">
       		<div class="col-sm-6"  id=""><div class="form-group"><label>รหัส Color</label>
			<input type="text" class="form-control" maxlength="60" id="colorCode" name="colorCode" disabled="disabled">
       		</div></div>
       		<div class="col-sm-6"><div class="form-group"><label>ชื่อ Color</label><input class="form-control "  maxlength="100"  type="text" id="colorName" name="colorName" value="" ></div></div>
       	</div>
       	<div class="row">
       		
       		<div class="col-sm-6 text-center" ><input class="btn btn-success" id="submit_color" type="button" value="บันทึก" ></div>
       		<div class="col-sm-6 text-center" ><input class="btn btn-danger" id="cancel_color" type="button" value="ยกเลิก" data-dismiss="modal"></div>
       	</div>
       	</form>
      </div>

    </div>

  </div>
</div>
</div>		
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
