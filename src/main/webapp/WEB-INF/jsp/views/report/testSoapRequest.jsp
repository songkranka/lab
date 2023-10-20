<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="<c:url value="/assets/style/report_web.css" />">
<link rel="stylesheet" href="<c:url value="/assets/style/report_mobile.css" />">
<script src="<c:url value="/assets/js/controllers/report/lab.js" />"></script>
<script src="<c:url value="/assets/js/controllers/report/mobile.js" />"></script>

<style>
.table-responsive {
    min-height: 0.01%;
    overflow-x: warp;
}
</style>

<script type='text/javascript'>
$(function(){
	$("#btnGetItemReqt").click(function(){
		var data = {};
		
		data["system"]  = "Lab Assignment" ;
		data["dummy01"] = "Product#ADO" ; 
		data["dummy02"] = "Type#C CAR" ;
		//data["dummy01"] = "Product#GSL" ; 
		//data["dummy02"] = "Type#C Car" ;
		data["dummy03"] = "#" ;
		data["dummy04"] = "#" ;
		data["dummy05"] = "#" ;
		data["dummy06"] = "#" ;
		data["dummy07"] = "#" ;
		data["dummy08"] = "#" ;
		data["dummy09"] = "#" ;
		data["dummy10"] = "#" ;
		data["dummy11"] = "#" ;
		data["dummy12"] = "#" ;
		data["dummy13"] = "#" ;
		data["dummy14"] = "#" ;
		data["dummy15"] = "#" ;
		data["dummy16"] = "#" ;
		data["dummy17"] = "#" ;
		data["dummy18"] = "#" ;
		data["dummy19"] = "#" ;
		data["dummy20"] = "#" ;
		
		jQuery.ajax({
			url : "reqItemList",
			type : 'Post',
			async: false,
			cache: false,
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				if(result.status=="S") {
					var response =  result.result;
					var obj = JSON.parse(response);
					//var detail = obj.Detail;
					//console.log(JSON.stringify(detail));
					$("#resGetItemReqt").css({"overflowWrap" : "break-word"});
					$("#resGetItemReqt").html("<div style='color:#019201'>Success</div><br>");
					//$("#resGetItemReqt").html($("#resGetItemReqt").html()+JSON.stringify(result));
					showMsgSuccess('Request Item List');
				}
				
				HideWaiting();
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด');
			}
		}).fail(function(){
			HideWaiting();
		});	
	});	
	
	$("#btnGetMaster").click( function() {
		//alert("btnGetMaster");
		var data = {};
		data["system"] = "Lab Assignment";
		data["table"] = "Product";
		
		jQuery.ajax({
			
			url : "reqTblMaster",
			type : 'Post',
			async: false,
			cache: false,
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				if(result.status=="S") {
					console.log(JSON.stringify(result));
					showMsgSuccess('Request Table Master');
				}
				HideWaiting();
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด');
			}
		}).fail(function() {
			HideWaiting(); 
		});	
		
	});
	
	$("#btnGetStatus").click(function(){

		var data = {};
		data["system"] = "Lab Assignment";
		data["process"] = "Product";
		data["requestID"] = "KSOT-B9D9PA";
		
		jQuery.ajax({
			
			url : "reqWorkflowStatus",
			type : 'Post',
			async: false,
			cache: false,
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				if(result.status=="S") {
					console.log(JSON.stringify(result));
					showMsgSuccess('Request Work Flow Status');
				}
				HideWaiting();
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด');
			}
		}).fail(function() {
			HideWaiting(); 
		});	
		
	});
	
});
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>ทดสอบ การยิง SOAP - Lotus Note</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>

<div class="wrapper wrapper-content animated fadeInRight"> 
	<div class="row"> 
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				
				<div class="ibox-title">
					<h5>1. GetItemList : Request</h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
					</div>
				</div>

				<div class="ibox-content">              
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive form-group">
								<div class="row">
									<div class="col-lg-4"><button id="btnGetItemReqt">Send</button></div>
								</div>
								<div class="row" id="resGetItemReqt"></div>
							</div>
						</div>
					</div>   
				</div>
				
			</div> 
		</div>
	</div>
</div>


<div class="wrapper wrapper-content animated fadeInRight"> 
	<div class="row"> 
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				
				<div class="ibox-title">
					<h5>2. SubmitRequest : Request</h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
					</div>
				</div>

				<div class="ibox-content">              
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive form-group">
								<div class="row">
									<div class="col-lg-4"><button id="btnSubmitReqt">Send</button></div>
								</div>
								<div class="row" id="resSubmitReqt"></div>
							</div>
						</div>
					</div>   
				</div>
				
			</div> 
		</div>
	</div>
</div>


<div class="wrapper wrapper-content animated fadeInRight"> 
	<div class="row"> 
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				
				<div class="ibox-title">
					<h5>7. GetStatus : Request</h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
					</div>
				</div>

				<div class="ibox-content">              
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive form-group">
								<div class="row">
									<div class="col-lg-4"><button id="btnGetStatus">Send</button></div>
								</div>
								<div class="row" id="resGetMaster"></div>
							</div>
						</div>
					</div>   
				</div>
				
			</div> 
		</div>
	</div>
</div>


<div class="wrapper wrapper-content animated fadeInRight"> 
	<div class="row"> 
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				
				<div class="ibox-title">
					<h5>10. GetMaster : Request</h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
					</div>
				</div>

				<div class="ibox-content">              
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive form-group">
								<div class="row">
									<div class="col-lg-4"><button id="btnGetMaster">Send</button></div>
								</div>
								<div class="row" id="resGetMaster"></div>
							</div>
						</div>
					</div>   
				</div>
				
			</div> 
		</div>
	</div>
</div>
