<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="<c:url value="/assets/js/controllers/randomMeter/randomMeterController.js" />"></script>
<style>
	.title-topic-ibox {
	    background-color: #1ab394;
    	color: #fff;
	}
	.th-topic {
		background-color: #c1e8ff;
	}
</style>
<script type='text/javascript'>
/**** Declare Constant ****/

var txtRandomHeadTopic = "ตั้งค่ามิเตอร์";
var txtRandomTopic = "กรุณาเลือกเงื่อนไข";
var txtCriMeterTopic = "เลขที่มิเตอร์";
var txtCriProductTopic = "ผลิตภัณฑ์";
var txtCriPlantTopic = "คลัง";
var txtHeadTblPlant = "ข้อมูลรายการคลัง";

/***  Declare Initial  ***/
$(function() {
	$("#randomtopicmeter").html(txtRandomHeadTopic);
	$("#randomtopic").html(txtRandomTopic).css({fontSize : "20px"});
});
/***  Declare Initial hidden  ***/
$(function(){
	//$("<input>").attr({"type":"hidden","id":"defplant"}).val(${PLANT_ID}).appendTo($("#hiddeninput"));
});
/*** Initial Criteria Area ***/
$(function(){
	$("#setupMeterCriteria")
	.append($("<div>").addClass("row")
		.append($("<div>").addClass("col-lg-4 text-left text-middle form-group").append($("<span>").addClass("text-left text-middle").css({paddingRight:"15px"}).html(txtCriMeterTopic).appendTo($("<div>").addClass("col-lg-6"))).append($("<input>").addClass("custom-text-horizon-rangdate2").attr({"type":"text","id":"meterNo"}).css({width:"100%"}).appendTo($("<div>").addClass("col-lg-6"))))
		.append($("<div>").addClass("col-lg-4 text-left text-middle form-group").append($("<span>").addClass("text-left text-middle").css({paddingRight:"15px"}).html(txtCriProductTopic).appendTo($("<div>").addClass("col-lg-6"))).append(initProduct("productId",$("<select>")).appendTo($("<div>").addClass("col-lg-6"))))
		.append($("<div>").addClass("col-lg-4 text-left text-middle form-group").append($("<span>").addClass("text-left text-middle").css({paddingRight:"15px"}).html(txtCriPlantTopic).appendTo($("<div>").addClass("col-lg-6"))).append(initPlant("plantoption",$("<select>")).appendTo($("<div>").addClass("col-lg-6")) ))
		)
	.append($("<div>").addClass("row")
		.append($("<div>").addClass("col-lg-12 text-right text-middle").append($("<button>").html("<i class=\"fa fa-cloud-upload\"></i>&nbsp;บันทึก").addClass("btn btn-info save-new-meter").click(function(){saveMeter()}))))
	;
});
/***  View Result Table  ***/
$(function(){
	viewMeter();
});
function initProduct(elename, element) {
	
	element.id = elename;
	element.addClass("form-control select2").attr({"id":elename});

	var url = "util-getDropdownProduct";
	ShowWaiting();
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		//data : JSON.stringify(data),
		dataType : 'json',
		success : function(result) {
			//console.log(JSON.stringify(result));
			$.each(result, function (i, item) {
				$("<option>").val(item.PRODUCT_ID).html(item.PRODUCT_NAME).appendTo(element);
			});
			HideWaiting();
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด');
		}
	}).fail(function(){
		HideWaiting();
	});	
	return element;
}
function initPlant(elename, element) {
	
	element.id = elename;
	element.addClass("form-control select2").attr({"id":elename});
	
	var url = "util-getDropdownPlant";
	var data = {}
	data["status"] = "randomoil";
	ShowWaiting();
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		data : JSON.stringify(data),
		dataType : 'json',
		success : function(result) {
			//console.log(JSON.stringify(result));
			$.each(result, function (i, item) {
				$("<option>").val(item.PID).html(item.PNAMET).appendTo(element);
			});
			HideWaiting();
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด');
		}
	}).fail(function(){
		HideWaiting();
	});	
	return element;
}
function validCheck(){
	var res = false;
	if($("#meterNo").val() != "") {
		if($("#plantoption").val()!="ALL") {
			res = true;
		}
	}
	return res;
}
function saveMeter(){
	if(validCheck()==true){
		//ShowWaiting();
		
		var data = {};
		data["defaultPlant"] = $("#defplant").val();
		data["plantId"] = $("#plantoption").val();
		data["meterNo"] = $("#meterNo").val();
		data["productId"] = $("#productId").val();

		//console.log("defplant = "+data["defaultPlant"]);
		//console.log("meterNo = "+data["meterNo"]);
		//console.log("productId = "+data["productId"]);
		$(".save-new-meter").attr("disabled","disabled");
		var url = "saveMeter";
		jQuery.ajax({
			url : url,
			type : 'Post',
			async: false,
			cache: false,
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(result) {
				if(result.pResult==1){

					viewMeter();
					showMsgSuccess('บันทึกสำเร็จ');
					
					$(".save-new-meter").removeAttr("disabled");
					$("#meterNo").val("");
					$("#plantoption").val("ALL");
					$("#meterNo").focus();
				} else {
					showMsgError('เกิดข้อผิดพลาด '+result.pMessage);
				}
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด '+result.pMessage);
			}
		}).fail(function(){
			showMsgError('เกิดข้อผิดพลาด '+result.pMessage);
		});		
	} else {
		showMsgWarning('กรุณาตรวจสอบการกรอกข้อมูลของท่านอีกครั้ง กรุณากรอก หรือ เลือกรายการให้ครบทุกช่อง');
	}
}
function initData(result) {
	var atable=[];
	$.each(result.resultMeter, function (i, item) {
		atable[item.PLANT_ID]=item.PLANT_NAME;
	});
	return atable;
}
function viewMeter() {
	
	ShowWaiting();
	
	$(".warp-container-meter").html("");
	var data = {}
	data["status"] = "randomoil";
	jQuery.ajax({
		url : 'util-getDropdownPlant',
		type : "Post", 
		contentType : "application/json",
		data : JSON.stringify(data),
		dataType : 'json',
		async: false,
		cache: false,
		success : function(data){
			$.each(data, function (i, item) {
				
				$("<div>").addClass("row").append($("<div>").addClass("col-lg-12").append($("<div>").addClass("ibox float-e-margins").append($("<div>").addClass("ibox-title title-topic-ibox").append($("<h5>").append($("<span>").html(txtHeadTblPlant+" "+item.PNAMET))).append($("<div>").addClass("ibox-tools")/*.append($("<a>").addClass("collapse-link").append($("<i>").addClass("fa fa-chevron-up")))*/)).append($("<div>").addClass("ibox-content").append($("<div>").addClass("PlantFromdb").attr("id",item.PID))))).appendTo($(".warp-container-meter"));
				var data = {};
				data["defaultPlant"] = item.PID;
				var url = "viewMeter";
		
				jQuery.ajax({
					url : url,
					type : 'Post',
					//async: false,
					//cache: false,
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						$("#"+item.PID).html("");

						var table =  $("<table>").addClass("table table-striped table-bordered").css({padding: "0px",width:"100%"});
						$("<thead>").append(
							$("<tr>")
							.append($("<th>").addClass("text-center text-middle").css({backgroundColor: "#c1e8ff"}).html("ลำดับ"))
							.append($("<th>").addClass("text-center text-middle").css({backgroundColor: "#c1e8ff"}).html("เลขมิเตอร์"))
							.append($("<th>").addClass("text-center text-middle").css({backgroundColor: "#c1e8ff"}).html("รหัสผลิตภัณฑ์"))
							.append($("<th>").addClass("text-center text-middle").css({backgroundColor: "#c1e8ff"}).html("ชื่อผลิตภัณฑ์"))
							.append($("<th>").addClass("text-center text-middle").css({backgroundColor: "#c1e8ff"}).html("ชื่อคลัง"))
							//.append($("<th>").addClass("text-center text-middle").css({backgroundColor: "#c1e8ff"}).html("ผู้ดำเนินการล่าสุด"))
							.append($("<th>").addClass("text-center text-middle").css({backgroundColor: "#c1e8ff"}).html("วันที่แก้ไขล่าสุด"))
						).appendTo(table);
						var tbody = $("<tbody>");
						$.each(result.resultMeter, function (i, item) {
							$("<tr>")
							.append($("<td>").addClass("text-center text-middle").html(i+1))
							.append($("<td>").addClass("text-center text-middle").html(item.METER_NO))
							.append($("<td>").addClass("text-center text-middle").html(item.PRODUCT_ID))
							.append($("<td>").addClass("text-left text-middle").html(item.PRODUCT_NAME))
							.append($("<td>").addClass("text-left text-middle").html(item.PLANT_NAME))
							//.append($("<td>").addClass("text-center text-middle").html(item.UPDATE_BY))
							.append($("<td>").addClass("text-center text-middle").html(item.UPDATE_DATE))
							.appendTo(tbody);
						});
						table.append(tbody);
						table.appendTo($("#"+item.PID));
						table.DataTable( {
							searching: true,
							responsive : true
						});
						
						HideWaiting();
					},
					error : function() {
						showMsgError('เกิดข้อผิดพลาด');
						HideWaiting();
					}
				}).fail(function(){
					showMsgError('เกิดข้อผิดพลาด');
					HideWaiting();
				});					
		    });
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด!');
		}
	});	
	$("#meterNo").focus();
}
</script>
<div id="hiddeninput"></div>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><span id="randomtopicmeter"></span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight"> 

	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5><span id="randomtopic"></span></h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
					</div>			
				</div>
		    	<div class="ibox-content"> 
		    		<div id="setupMeterCriteria"></div>
		    	</div>
		    </div>
		</div>
	</div>
	<div class="row warp-container-meter"></div>
</div>