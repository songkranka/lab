<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="<c:url value="/assets/style/report_mobile.css" />">
<script src="<c:url value="/assets/js/controllers/report/mobile.js" />"></script>

<style>

</style>

<script type='text/javascript'>
	/***  Declare Variable  ***/
	var txtReportHeadTopic = "รายงานข้อมูลสถานีบริการ";
	
	/***  Declare Initial  ***/
	$(function(){
		$("#reportTopic").html(txtReportHeadTopic);
	});
	/***  Create Report Container  ***/
	$(function(){
		var divContainer = $("#ReportContainer");
		var reportCriterea = [];
		reportCriterea[0] = {"text":"Trip","type":"ddl","id":"ddlTrip","url":"rpt-getDropdownTrip"};
		
		var reportInfo = {};
			reportInfo["reportID"] = $("#reportID").val();
			reportInfo["reportCategory"] = $("#reportCategory").val();
			reportInfo["reportNo"] = $("#reportNo").val();
			reportInfo["reportName"] = $("#reportName").val();
			reportInfo["reportCriterea"] = reportCriterea;
		
		var divReportCriteria = new ReportCriteriaForm(reportInfo);
		divContainer.append(divReportCriteria.getForm());
	});
	
</script>
<div class="data-hidden">
	<input type="hidden" id="reportCategory" value="${reportInfo.reportCategory}" >
	<input type="hidden" id="reportNo" value="${reportInfo.reportNo}" >
	<input type="hidden" id="reportName" value="${reportInfo.reportName}" >
	<input type="hidden" id="reportID" value="${reportInfo.reportID}" >
</div>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><span id="reportTopic"></span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row " id="ReportContainer"></div>
</div>


