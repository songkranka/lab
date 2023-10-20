<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="<c:url value="/assets/js/controllers/randomMeter/RemindTruckSampleController.js" />"></script>
<style>

.tbHeader {
	font-size:  15px;
	background: #3c8dbc;
	color: white;
}
.tbBody {
	font-size:  14px; 
}
div.ibox-title h3 {
    font-size: 20px;
    color: #1ab394;
}
</style>
<script type='text/javascript'>
var txtRemideHeadTopic = "รายการงานที่ต้องเก็บตัวอย่าง Truck";

/***  Declare Initial  ***/
$(function(){
	$("#remidetopic").html(txtRemideHeadTopic);
});

$(function(){
	var divContainer = $("#TruckContainer");
	var divTruckView = new initTruckRemindingView();
	divContainer.append(divTruckView.getView());
});


</script>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><span id="remidetopic"></span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row " id="TruckContainer"></div>
</div>
