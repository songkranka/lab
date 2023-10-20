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

<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>ตั้งค่าการมอบหมายงาน</h2>
	</div>
	<div class="col-lg-2"></div>
</div>

<div class="zoneBody">

	<div class="wrapper wrapper-btn text-right">
		<div class="row">
			<div class="col-xs-12 col-md-12 boxGroupCus">
				<div class="col-xs-5 col-md-5 text-right titleSelct">
					<strong> มอบหมายแบบกลุ่ม : </strong>
				</div>
				<div class="col-xs-3 col-md-2 text-left">
					<select class="form-control select5Inp" name="nameCode" id="dataN">
						<option value="Y" >YES</option>
						<option value="N" >NO</option>
					</select>
				</div>
				<div class="col-xs-3 col-md-3 text-left">
					<button type="button" class="btn btn-primary submitSettingAssignment">Save</button>
				</div>
				
			</div>
		</div>
		
	</div>

<div class="wrapper wrapper-btn text-right">
	<div class="row">
	</div>
</div>
	
</div>

 




<script src="<c:url value="/assets/js/settingAssignment.js" /> "type="text/javascript"></script>