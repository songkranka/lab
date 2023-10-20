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
        <h2>ตั้งค่าสเปคมอบหมายงาน</h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight" style="padding-bottom:0px"> 
	<div class="row ibox-content assign-detail">
		<div class="row">
			<div class="col-xs-4">
				<div class="col-xs-4">
					<h4>ผลิตภัณฑ์</h4>
				</div>
				<div class="col-xs-6">
					<select class="form-control select5Inp" id="ddlProduct">
					</select>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="col-xs-4">
					<h4>ชนิดตัวอย่าง</h4>
				</div>
				<div class="col-xs-6">
					<select class="form-control select5Inp" id="ddlSampleType">
					</select>
				</div>
			</div>
			<div class="col-xs-2">
				<button type="button" class="btn btn-success center-block "  style="width: 150px;" onclick="searchData()">ค้นหา
	    		</button>
			</div>
			<div class="col-xs-2">
			<form action="/Lab/manageDataMaster">
			<button type="submit" class="btn btn-primary"  ><i class="fa fa-info-circle"></i>&nbsp; จัดการข้อมูล Master</button>
			</form>

			</div>
		</div>
		<div class="col-xs-12"><p></p></div>
		<div class="col-xs-12">
			<div class="table-responsive"   >
				<table   id="assiDetialTWork" class="table table-striped table-bordered" style="padding: 0px;width: 100%">
					<thead>
						<tr class="tbHeader">
							<th class="text-center">NO</th> 
							<th class="text-center">&nbsp;<input id="example-select-all" value="1" name="select_all" type="checkbox" onclick="selectAllNew()"></th> 
							<th class="text-center">รายการวิเคราะห์</th>						
							<th class="text-center">METHOD</th>
							<th class="text-center">เครื่องมือวิเคราะห์</th>
							<th class="text-center" >Spec MIN</th>
							<th class="text-center" >Spec MAX</th>
							<th class="text-center" >Spec Basic Text</th>
							<th class="text-center" >Spec Color</th>
							<th class="text-center" >Uncertainty</th>
							<th class="text-center" style="width: 90px !important;">Unit</th>
							<th class="text-center">STATUS</th>
							<th class="text-center">แก้ไชเครื่องมือ</th>
							
						</tr>
					</thead>
					<tbody id="assiDetialWork">
					</tbody>
				</table> 
			</div>
		</div>
	</div>
</div>
		<div class="col-xs-4">
			<button type="button" class="btn btn-danger center-block "  style="width: 150px;" onclick="saveDataforuse('N')">ยกเลิกการใช้งาน
	    	</button>		
		</div>	
		<div class="col-xs-4">
			<button type="button" class="btn btn-success center-block "  style="width: 150px;" onclick="saveDataforuse('Y')">ใช้งาน
	    	</button>
		</div>
		<div class="col-xs-4">
			<button type="button" class="btn btn-primary center-block "  style="width: 150px;" onclick="saveData()">บันทึกการตั้งค่า</button>

	    	
		</div>
	
<div class="modal fade" id="myModalwait" data-backdrop="static" data-keyboard="false" tabindex="-1" role="dialog" aria-hidden="true" style="padding-top: 20%; overflow-y: visible; padding-right: 19px;">
   <div>
      <div>
         <center>
            <div>
               <div style="color:white;"><img width="300px" height="250px" src="assets/images/loadlab.gif"></div>
            </div>
         </center>
      </div>
   </div>
</div>
<div class="modal fade" id="warning_setting" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document" style="width: 30%;height: 24%;margin-left: 40%;" id="">
	<div class="modal-content">
	<div class="modal-header bg-primary">
	<h2 class="modal-title" id="modalLabel">แจ้งเตือน</h2>
	</div>
	
	<div class="modal-body" style="text-align: center;" >
	    
			<div class="row " style="margin-top: 0%;">
			   <div class="col-sm-12 h3" id="message_warn">
			     
			   </div>
			</div>
	</div>
	<div class="modal-footer">
	<button type="button" class="btn btn-primary" data-dismiss="modal"  >OK</button>
	</div>
	</div>
	</div>
</div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>

