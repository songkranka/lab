<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="<c:url value="/assets/js/controllers/home.js" />"></script>

<script type='text/javascript'>

var REC_VIEW = {};	
$(document).ready(function () {
	var utype = $("#utype").val();
	var subUType = utype.substring(0,2);
	console.log("substr = " + subUType);
	
	if(subUType == "20" ) {
		window.location="remindingTruckSample";
	} else if(subUType == "NF" ) {
		window.location="home?p=nf";
	}
});
$(document).ready(function () {
	var url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
	console.log("url ===> " + url );
});	
$(document).ready(function () {
	
	ShowWaiting();
	var listStatusOwnerWorking = $("#statusList").val().split(",");
	$.each(listStatusOwnerWorking,function(i, list) {
		requestTaskSelf({
			"bound" : list.toLowerCase().replace(' ',''),
			"wfStatus" : list
		});
	});
	HideWaiting();

});
$(document).ready(function () {
	ShowWaiting();
	var listStatusOwnerWorking = $("#statusList").val().split(",");
	var dataTableTimeout = 10000 ;
	$.each(listStatusOwnerWorking,function(a, list) {
		$.each(REC_VIEW[list.toLowerCase().replace(' ','')],function(i, list) {
			jQuery.ajax({
				url : 'inquiryRandomLastResult',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(list), 
				dataType : 'json',
				//async: false,
				//cache: false,
				success : function(data) {
					if( data.success==1 ) { 
						var res = data.list[0];
						console.log(JSON.stringify(res));
						var raw_id = "#vBody_"+data.passParam.bound+"_"+data.passParam.seq+"_";
						$(raw_id+"reqno").html("<a href = 'assignmentTaskLastResult?labCode_No=1,"+res.PLANT_ID+","+a+""+i+"," + res.LAB_CODE + "," + res.PRODUCT_CODE + "," + res.SAMPLE_TYPE_NAME + ",save'>" + res.LAB_CODE + "</a>");
						$(raw_id+"plant").html(res.plant_name);
						$(raw_id+"samp").html(res.SAMPLE_TYPE_NAME);
						$(raw_id+"prd").html(res.product_name);
						$(raw_id+"sampdate").html(res.STR_SAMPLE_DATE);
						$(raw_id+"exprdate").html(res.STR_SAMPLE_EXPIRE_DATE);
					} else {
						showMsgError(data.message);
					}
				},error : function() {showMsgError('เกิดข้อผิดพลาด');}
			});
		});
		setTimeout(function(){ $("#tbl_"+list.toLowerCase().replace(' ','')).DataTable({searching: true, responsive : true}); }, dataTableTimeout);
		dataTableTimeout += 10000 ;
	});
	setTimeout(function(){ HideWaiting(); }, 8000);
});
function requestTaskSelf(pmObj) {
	var url = "reqOwnerTask";
	jQuery.ajax({
		url : url,
		type : 'Post',
		contentType : 'application/json',
		data : JSON.stringify(pmObj),
		dataType : 'json',
		async: false,
		cache: false,
		success : function(res) {
			if(res.status == "S") {
				$("#taskOwner").append(vw(res));
				
			} else {
				showMsgError('เกิดข้อผิดพลาด');
			}
		},error : function() {
			showMsgError('เกิดข้อผิดพลาด');
		}
	}).fail(function(){
		showMsgError('เกิดข้อผิดพลาด');
	});	
}
function setThead() {
	return $("<thead>").append(
		$("<tr>")
		.append($("<th>").addClass("text-center").css({"width":"135px"}).html("เลขที่ใบงาน"))
		.append($("<th>").addClass("text-center").css({"width":"250px"}).html("ชื่อคลัง"))
		.append($("<th>").addClass("text-center").css({"width":"80px"}).html("ประเภทตัวอย่าง"))
		.append($("<th>").addClass("text-center").css({"width":"150px"}).html("ผลิตภัณฑ์"))
		.append($("<th>").addClass("text-center").css({"width":"90px"}).html("วันที่เก็บตัวอย่าง"))
		.append($("<th>").addClass("text-center").css({"width":"90px"}).html("วันที่หมดอายุ"))
	)
	;
}
				
function vw(result) {
	var wfResult = JSON.parse(result.result);
	var bount = result.param["bound"];
	var empid = result.param["employee"];
	var TaskName = (bount == "new") ? "งานใหม่"
			 	 : (bount == "onprocess") ? "งานที่บันทึกผล"
				 : (bount == "complete") ? "งานที่ทำเสร็จแล้ว"
				 : "" ;

//	console.log("empid : " + empid);
	/******			DEMO		*******/
	
	empid = "470251";
	
	
	/******			DEMO		*******/
//	console.log(JSON.stringify(wfResult[empid]));
	REC_VIEW[bount] = [];
	
	var tbdy = $("<tbody>").attr({"id":"tbody_"+bount});
	$.each(wfResult[empid],function(i, task) {
		//console.log(task.RequestID);
		REC_VIEW[bount][i] = {
			"bound":bount,
			"seq":i,
			"labCode_No" : task.RequestID,
			"nameStore" : ""
		};
		
		$("<tr>")
		.append($("<td>").attr({"id":"vBody_"+bount+"_"+i+"_reqno"}).addClass("text-center").html(task.RequestID) )
		.append($("<td>").attr({"id":"vBody_"+bount+"_"+i+"_plant"}).addClass("text-left").html("") )
		.append($("<td>").attr({"id":"vBody_"+bount+"_"+i+"_samp"}).addClass("text-left").html("") )
		.append($("<td>").attr({"id":"vBody_"+bount+"_"+i+"_prd"}).addClass("text-left").html("") )
		.append($("<td>").attr({"id":"vBody_"+bount+"_"+i+"_sampdate"}).addClass("text-left").html("") )
		.append($("<td>").attr({"id":"vBody_"+bount+"_"+i+"_exprdate"}).addClass("text-left").html("") )
		.appendTo(tbdy)
	});
//	console.log(" ");
//	console.log("create RECORD_VIEW : "+JSON.stringify(REC_VIEW));
	return $("<div>").addClass("row")
		.append(
			$("<div>").addClass("col-lg-12").append(
				$("<div>").addClass("ibox float-e-margins")
				.append(
					$("<div>").addClass("ibox-title")
					.append(
						$("<h5>").append($("<span>").html(TaskName))
					)
					.append(
						$("<div>").addClass("ibox-tools")
					)
				)
				.append(
					$("<div>").addClass("ibox-content").append(
						$("<div>").addClass(bount).attr({"id":bount}).append(
							$("<table>")
							.addClass("table table-striped table-bordered")
							.attr({"id":"tbl_"+bount,"role":"grid"})
							.css({"width":"100%"})
							.append(setThead())
							.append(tbdy)
						)
					)
				)
			)
		)
		
		;
	
}
</script>
<input id="utype" type="hidden" value="${mpmember.USER_TYPE_ID}">
<input id="statusList" type="hidden" value="${statusList}">
<div class="page-content">
	<div class="container">                    
		<div class="page-content-inner">
			
		</div>
	</div>
</div>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><span id="taskTopicPage"> Dashboard Task </span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div id="taskOwner" class="wrapper wrapper-content animated fadeInRight"></div>


