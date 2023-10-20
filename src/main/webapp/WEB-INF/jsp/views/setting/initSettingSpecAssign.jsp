<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="<c:url value="/assets/css/settingTestScroll.css" />"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="assets/plugins/datepicker/bootstrap-datepicker.js"></script>
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-waitingfor/1.2.8/bootstrap-waitingfor.min.js"></script>

<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>ตั้งค่าสเปคมอบหมายงาน</h2>
	</div>
	<div class="col-lg-2"></div>
</div>

<div class="zoneBody">
	<div class="row ibox-content">

		<div class="row">
			<div class="col-xs-5">
				<div class="col-xs-4">
					<h4>ผลิตภัณฑ์</h4>
				</div>
				<div class="col-xs-6">
					<select class="form-control select5Inp" id="ddlProduct">
					</select>
				</div>
			</div>
			<div class="col-xs-5">
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
		</div>
		<div class="col-xs-12"><p></p></div>

	
		<div class="col-xs-12">
			<div class="table-responsive"   >
				<table   id="myTableDteId" class="table table-striped table-bordered" style="padding: 0px;">
					<thead>
						<tr class="tbHeader">
							<th class="text-center">No</th> 
							<th class="text-center">&nbsp;<input id="example-select-all" value="1" name="select_all" type="checkbox" onclick="selectAllNew()"></th>
							<th class="text-center">ITEM NAME</th> 
							<th class="text-center">STATUS</th> 
						</tr>
					</thead>
					<tbody id="dteId">
					</tbody>
				</table> 
			</div>
		</div>
		
		<div class="col-xs-6">
			<button type="button" class="btn btn-danger center-block "  style="width: 150px;" onclick="saveData('N')">ยกเลิกการใช้งาน
	    	</button>		
		</div>	
		<div class="col-xs-6">
			<button type="button" class="btn btn-success center-block "  style="width: 150px;" onclick="saveData('Y')">ใช้งาน
	    	</button>
		</div>
	</div>
</div>

 




<script src="<c:url value="/assets/js/settingSPECAssign.js" /> "type="text/javascript"></script>