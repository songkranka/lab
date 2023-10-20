<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jqueryblockui/jquery.blockUI.min.js"></script>

<style>
.tbHeader {
	font-size:  10px;
	background: #3c8dbc;
	color: white;
}
</style>
<input type="hidden" value="" id="ltrSpecId"/>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>ตั้งค่า Mobile LTR SPEC</h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight" style="padding-bottom:0px"> 
	<div class="row ibox-content assign-detail">
		<div class="row">
			<div class="col-xs-7 col-md-6">
				<div class="col-xs-12 col-sm-5">
					<h4>ผลิตภัณฑ์</h4>
				</div>
				<div class="col-xs-12 col-sm-5">
					<select class="form-control select5Inp" id="ddlProduct">
					</select>
				</div>
				<div class="col-xs-12 col-sm-2">
					<button type="button" class="btn btn-success center-block "  style="width: 150px;" onclick="searchData()">ค้นหา
	    		</button>
				</div>
			</div>
			<div class="col-xs-5 col-md-6">
			</div>
		</div>
		<div class="col-xs-12"><p></p></div>
		<div class="col-xs-12" id="bodysetting">
			
		</div>
	</div>
</div>

		<div class="col-xs-12">
			<button type="button" class="btn btn-primary center-block "  style="width: 150px;" onclick="saveData()">บันทึกการตั้งค่า</button>

	    	
		</div>
	

<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>

