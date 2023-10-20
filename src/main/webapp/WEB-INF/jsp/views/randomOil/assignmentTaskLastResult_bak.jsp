<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.tbHeader {
	font-size:  10px;
	background: #3c8dbc;
	color: white;
}
</style>
<script type='text/javascript'>

var assignmentData = {};
var tmp_data = {};
var labCode_No;
var defaultRoleGroup = "";
var defaultWorker = [];
var arrayRoleGroup = [];
var arrayWorker = [];
var pageId = "";

$(document).ready(function () {
	initParam();
});
function initParam() {
	var url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');  
	var labCode_v = url[0].split('='); 
	var labContent = labCode_v[1].split(',');
	var param = {};
	labCode_No = labContent[3];
	pageId = labContent[0] ;
	if ( pageId == "0" ) {
		
		$("#pageTitles").html("มอบหมายงาน");
		$("#btnAssignmentLab").show();
		$("#btnSaveResultLab").hide();
		$(".save_result").hide();
		
		param["plant"] = labContent[1];
		param["seq"] = labContent[2];
		param["labCode"] = labContent[3];
		param["product"] = labContent[4];
		param["typeOfSample"] = labContent[5];
		
		
		inquiryRandomOilByLabCode(param);
		labSubmitRequest(param);
	} else if ( pageId == "1" ) {
		
		$("#pageTitles").html("บันทึกผล");
		$("#btnAssignmentLab").hide();
		$("#btnSaveResultLab").show();
		$(".save_result").show();
		
		param["plant"] = labContent[1];
		param["seq"] = labContent[2];
		param["labCode"] = labContent[3];
		param["product"] = labContent[4];
		param["typeOfSample"] = labContent[5];
		
		inquiryRandomOilByLabCode(param);
		loadItemResult(param);
	}
}
function labSubmitRequest(pmObj) {
	defaultRoleGroup = "";
	ShowWaiting();
	var url = "reqItemList";
	
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		data : JSON.stringify(pmObj),
		dataType : 'json',
		success : function(res) {
			if(res.status == "S"){
				
				var detailLen = 0;
				var html = "";
				var allSeq = "";
				var allItem = "";
				var allTool = "";
				var allMethod = "";
				var allSpec   = "";
				var allUnit   = "";
				
				var responseResult = JSON.parse(res.result);
				//console.log(responseResult);
				//console.log("return flag assignmen : " + res.asgnflg);
				assignmentData["systemName"] = responseResult["SystemT"];
				assignmentData["dummy01"]  = responseResult["Dummy01"];
				assignmentData["dummy02"]  = responseResult["Dummy02"];
				assignmentData["plant"] = pmObj["plant"];
				assignmentData["order"] = pmObj["seq"];
				assignmentData["labCode"] = pmObj["labCode"];
				assignmentData["product"] = pmObj["product"];
				assignmentData["sampleType"] = pmObj["typeOfSample"];
				assignmentData["process"]  = "";
				assignmentData["requestID"]  = ""; 
				assignmentData["requesterID"]  = "";
				assignmentData["roleGroup"]  = "";

				var resCode = responseResult["Errorcode"];
				
				if(resCode == "900") {
					//showMsgSuccess('ดาวน์โหลดงานสำเร็จ');
					var detail = responseResult["Detail"];
					//console.log("Len of Detail :: " + detail.length);
					detailLen = detail.length;
					assignmentData["totalrecord"]  = detailLen;
					$.each(detail,function(d, det) {
						defaultRoleGroup = "";
						arrayWorker[d] = {};
						
						//console.log("  No["+d+"] :: ");
						//console.log("   "+det);
						
						html += "<tr>"; 
						var dtlNo = d;
						var itemC = det["TestItemcode"];
						var itemD = det["TestItem"];
						var specC = det["TestSpeccode"];
						var spec1 = det["TestSpec"];
						var spec2 = det["TestSpec2"];
						var unitC = det["TestUnitcode"];
						var unitD = det["TestUnit"];
						var methodC = det["Testmathodcode"];
						var methodD = det["Testmathod"];
						var toolC   = det["Testtoolcode"];
						var toolD   = det["Testtool"];
						
						allSeq		+=(dtlNo+1)+"|"; 
						allItem 	+= itemC+"|";
						allTool 	+= toolC+"|";
						allMethod 	+= methodC+"|";
						allSpec     += specC+"|";
						allUnit     += unitC+"|";
						
						var workgroup = det["workgroup"];
						var groupLen = workgroup.length;
						if(groupLen > 0 ) {
							$.each(workgroup,function(g, group) {
								var role = group["RoleGroup"];
								var flagDefault = group["RoleDef"];
								
								arrayWorker[d][role] = [];
				
								if (flagDefault == "Y" ) defaultRoleGroup = flagDefault;
								arrayRoleGroup[g] = [role,flagDefault];
								
								$.each(group["MemberList"],function(i, mem) {
									var mid = mem["MemberID"];
									var mname = mem["MemberName"];
									arrayWorker[d][role][i] = [mid,mname];
								});
								
								$.each(group["ManagerList"],function(i, manager) {
									var maid = manager["ManagerID"];
									var maname = manager["Manager"];
								});
								
								$.each(group["SubstitueList"],function(i, substitue) {
									var sid = substitue["SubstitueID"];
									var sname = substitue["SubstitueName"];
								});
							});
						}
						var roleOptRes = initRoleGroup(arrayRoleGroup,dtlNo).split("|");
						
						html += "<td class='text-center' >" + (d+1) + "</td>"; 
						html += "<td class='text-center' ><select class='form-control select2' name='roleGrp' id='assignRole_"+dtlNo+"' onchange='fetchWorkerByRole(this.value,"+dtlNo+")' "+((res.asgnflg == "T") ? " disabled " : "")+" >"+roleOptRes[2]+"</select></td>";
						html += "<td class='text-left' ><select class='form-control select2 workerName multiselect' name='workerName' id='roleUnder_"+dtlNo+"' multiple='multiple' "+((res.asgnflg == "T") ? " disabled " : "")+" >"+initWorker(roleOptRes[0],roleOptRes[1])+"</select></td></td>";
						html += "<td class='text-left' >"+itemD+"</td>"; 
						html += "<td class='text-left' >"+toolD+"</td>";
						html += "<td class='text-left' >"+methodD+"</td>";						
						html += "</tr>"; 								
					});
				} else {
					showMsgError(responseResult["Errorcode"] + " : " + responseResult["ErrorMsg"]);
				}
				//console.log(responseResult);
				//console.log("Assign Flag == "+res.asgnflg);
				if (res.asgnflg == "F") {
					$("#btnAssignmentLab").show();
				} else {
					$("#btnAssignmentLab").hide();	
				}
				
				
				assignmentData["seq"]  = allSeq.substring(0,allSeq.length-1);
				assignmentData["testItemCode"]  = allItem.substring(0,allItem.length-1);
				assignmentData["testtoolCode"]  = allTool.substring(0,allTool.length-1);
				assignmentData["testMethodCode"]  = allMethod.substring(0,allMethod.length-1);
				assignmentData["testSpecCode"]  = allSpec.substring(0,allSpec.length-1);
				assignmentData["testUnitCode"]  = allUnit.substring(0,allUnit.length-1);
				
				if (html=="") {
					html += '<tr> ';
					html += '<th colspan="5" class="text-center">--- ไม่พบข้อมูล ---</th> ';
					html += '</tr> ';
					$('#dteId').html(html);
				} else {
					$('#randomOilDetailId').html(html);
					var i=0;
					while ( i < detailLen ) {
						
						if ( defaultWorker[i].length > 0 ) {
							defaultWorker[i] =  'all,'+defaultWorker[i].substring(0,defaultWorker[i].length-1);
						}
						$("#roleUnder_"+i).multiselect({
							selectAllValue: 'all',
							includeSelectAllOption: true 
						});
						$("#roleUnder_"+i).multiselect('rebuild');
						$("#roleUnder_"+i).multiselect('updateButtonText');
						$("#roleUnder_"+i).trigger('change');
						$("#roleUnder_"+i).val(defaultWorker[i].split(","));
						$("#roleUnder_"+i).multiselect("refresh");						
						
						i++;
					}
				}
			}
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด');
		}
	}).fail(function(){
		showMsgError('เกิดข้อผิดพลาด');
	});
			
	setTimeout(function() { HideWaiting(); }, 1000);
}

function loadItemResult(pmObj) {
	
	ShowWaiting();
	var url = "loadOwnerJob";
	jQuery.ajax({
		url : url,
		type : 'Post',
		//async: false,
		//cache: false,
		contentType : 'application/json',
		data : JSON.stringify(pmObj),
		dataType : 'json',
		success : function(res) {
			if(res.status == "S") {
				
			} else {
				showMsgError('เกิดข้อผิดพลาด');
			}
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด');
		}	
	}).fail(function(){
		showMsgError('เกิดข้อผิดพลาด');
	});
	
	setTimeout(function() { HideWaiting(); }, 1000);
}
function saveResult(pmObj) {
	
}

function initRoleGroup(roleGroup,seq) {
	var opt = "";
	var defaultRole = "";
	if(roleGroup.length > 0){
		$.each(roleGroup,
			function(i, rol) {
				opt += "<option "
				+ ((rol[1] == "Y")?"selected":"")
				+ " value='"+rol[0]+"'> "
				+ rol[0] 
				+ " </option>";
				if(rol[1] == "Y") {
					defaultRole = rol[0]+"|"+seq;
				}
			}
		);
	}else{
		opt = "<option>---- ไม่พบข้อมูล ----</option>";
	}
	return defaultRole+"|"+opt;
}
function initWorker(roleName,seq){
	var txtOpt = "";
	var defWorker = "";
	$.each(arrayWorker[seq][roleName],function(i, emp) {
		if(emp != undefined ) {
			txtOpt+="<option value='"+ emp[0] +"' >" + emp[1] + " </option>";
			defWorker+=emp[0]+",";
		}
	});
	defaultWorker[seq] = defWorker;
	return txtOpt;
}
function fetchWorkerByRole(val,seq){

	var empVal = "";
	$("#roleUnder_"+seq).empty();
	$.each(arrayWorker[seq][val],function(i, emp) {
		$("#roleUnder_"+seq).append("<option value='"+emp[0]+"'>&nbsp;&nbsp;"+emp[1]+"</option>");
		empVal += emp[0]+",";
	});
	if(empVal.length>0){
		empVal =  'all,'+empVal.substring(0,empVal.length-1)
	}
	$("#roleUnder_"+seq).multiselect({
		selectAllValue: 'all',
		includeSelectAllOption: true 
	}); 
	$("#roleUnder_"+seq).multiselect('rebuild');
	$("#roleUnder_"+seq).multiselect('updateButtonText');
	$("#roleUnder_"+seq).trigger('change');  
	$("#roleUnder_"+seq).val(empVal.split(","));  
	$("#roleUnder_"+seq).multiselect("refresh");  
	
}
function sendRequestAssignRandomOil() {
	var member = "";
	var roleGrp = "";
	
	for(var i = 0; i < assignmentData["totalrecord"]; i++){
		var role = $("#assignRole_"+i).val().toString();
			roleGrp += role + "|";
		var workerRole = $("#roleUnder_"+i).val().toString();
		var memberList = workerRole.replace("all,","");
			member += memberList + "|";
	};
	
	assignmentData["roleGroup"]  = roleGrp.substring(0,roleGrp.length-1);
	assignmentData["memberlist"]  = member.substring(0,member.length-1);

	ShowWaiting();
	var url = "submitAssignment";
	jQuery.ajax({
		url : url,
		type : 'Post',
		contentType : 'application/json',
		data : JSON.stringify(assignmentData),
		dataType : 'json',
		success : function(res) {
			if(res.status == "S") {
				var responseResult = JSON.parse(res.result);
				var saveObj = {};
					saveObj["system"] = responseResult.System;
					saveObj["errorMsg"] = responseResult.ErrorMsg;
					saveObj["errorcode"] = responseResult.Errorcode;
					saveObj["process"] = responseResult.System;
					saveObj["requestID"] = responseResult.RequestID;
					saveObj["remark"] = responseResult.Remark;
					saveObj["product"] = assignmentData["dummy01"] ;
					saveObj["sampleType"] = assignmentData["dummy02"] ;
					saveObj["detail"] = [];
				$.each(responseResult.Detail,function(i, dtl) {
					var Detail = {};
						Detail["testItemCode"]   = dtl.TestItemCode ;
						Detail["testItem"]       = dtl.TestItem ;
						Detail["seqNo"]          = dtl.SeqNo ;
						Detail["testToolCode"]   = dtl.TestToolCode ;
						Detail["testTool"]       = dtl.TestTool ;
						Detail["testMethodCode"] = dtl.TestMethodCode ;
						Detail["testMethod"]     = dtl.TestMethod ;
						Detail["testSpecCode"]   = dtl.TestSpecCode ;
						Detail["testSpec"]       = dtl.TestSpec ;
						Detail["testSpec2"]      = dtl.TestSpec2 ;
						Detail["testUnitCode"]   = dtl.TestUnitCode ;
						Detail["testUnit"]       = dtl.TestUnit ;
						Detail["member"]         = [];
						$.each(dtl.Member,function(j, mmb) {
							var Members = {};
								Members["memberID"] = mmb.MemberID ;
								Members["membersName"] = mmb.MembersName ;
								Detail["member"].push(Members);
 						});
						saveObj["detail"].push(Detail);
				});
				//ShowWaiting();
				var resCode = responseResult["Errorcode"];
				if (resCode == "900") {
					jQuery.ajax({
						url : "saveAssignment",
						type : 'Post',
						contentType : 'application/json',
						data : JSON.stringify(saveObj),
						dataType : 'json',
						success : function(saveRes) {
							if(saveRes.status == "S") {
								console.log(JSON.stringify(saveRes));
								gotoMain();
							}
						},
						error : function() {
							showMsgError('เกิดข้อผิดพลาด');
						}
					}).fail(function(){
						showMsgError('เกิดข้อผิดพลาด');
					});	
						
				}
			}
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด');
		}
	}).fail(function(){
		showMsgError('เกิดข้อผิดพลาด');
	});	
	
	//setTimeout(function(){ HideWaiting(); }, 1000);
}

function inquiryRandomOilByLabCode(param){
	console.log("param res = "+JSON.stringify(param));
	 try {
		var data = {}
		data["nameStore"] = param["plant"];
		data["labCode_No"] = param["labCode"];
		jQuery.ajax({
			url : 'inquiryRandomLastResult',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
				if(data.success==1){
					var dataList = data.list[0];	
						console.log("save res = "+JSON.stringify(dataList));
					$("#ltr_no").html(dataList.LAB_CODE)  ;
					$("#ltr_po").html(dataList.PO_NO)  ;
					$("#ltr_datepo").html(dataList.PO_DATE)  ;
					$("#ltr_do").html(dataList.DO_NO)  ;
					$("#ltr_ship").html(dataList.SHIPMENT_NO)  ;
					$("#ltr_grp").html(dataList.SAMPLE_REFER)  ;
					$("#ltr_prod").html(dataList.PRODUCT_CODE)  ;
					//$("#ltr_prod").html("("+dataList.PRODUCT_CODE + ") " + dataList.product_name)  ;
					$("#ltr_src").html(dataList.source_name)  ;
					$("#ltr_trans").html(dataList.logis_name)  ;
					$("#ltr_carno").html(dataList.CAR_NO)  ;
					$("#ltr_carslot").html(dataList.CAR_SLOT)  ;
					$("#ltr_samp").html(dataList.SAMPLE_LEVEL_DESC)  ;
					$("#ltr_boatno").html(dataList.BOAT_NO)  ;
					$("#ltr_boatname").html(dataList.BOAT_NAME)  ;
					$("#ltr_boatslot").html(dataList.BOAT_SLOT)  ;
					$("#ltr_daterandom").html(dataList.STR_SAMPLE_EXPIRE_DATE)  ;
					$("#ltr_dateexp").html(dataList.STR_SAMPLE_DATE)  ;
					$("#ltr_empname").html((dataList.SAMPLE_STAFF_NAME!=null)?dataList.SAMPLE_STAFF_NAME:"")  ;
				} else {
					showMsgError(data.message);
				}
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด');
			}
		});
	} catch (ex) {
		 showMsgError(ex);
	}
	 
} 
function _labSubmitRequest_20190409(labCode) {

	ShowWaiting();
	
	var obj = {};
	
	obj["labCode"] = labCode;

	//var url = "submitAssignment";
	var url = "getLastSampleData";
	ShowWaiting();
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		data : JSON.stringify(obj),
		dataType : 'json',
		success : function(result) {
			//console.log(JSON.stringify(result));
			if(result.success == 1){
				var datalist = result.dataList;
				//console.log("dataList  ::  "+JSON.stringify(datalist));
				var len = datalist.length;
				if(len>0){
					var det = "";
					for (var i = 0; i < len; i++) {
						tmp_data = datalist;
						
						var reqId = (datalist[i].REQ_ITEM_ID==null?"":datalist[i].REQ_ITEM_ID);
						var prodCode = (datalist[i].PRODUCT_CODE==null?"":datalist[i].PRODUCT_CODE);
						var sampleType = (datalist[i].SAMPLE_TYPE==null?"":datalist[i].SAMPLE_TYPE);
						var labCode = (datalist[i].lab_code==null?"":datalist[i].lab_code);
						var dtlNo = (datalist[i].REQ_DTL_NO==null?"":datalist[i].REQ_DTL_NO);
						var analyzC = (datalist[i].ANALYZE_CODE==null?"":datalist[i].ANALYZE_CODE);
						var analyzV = (datalist[i].ANALYZE_VALUE==null?"":datalist[i].ANALYZE_VALUE);
						var matC = (datalist[i].MATERIAL_CODE==null?"":datalist[i].MATERIAL_CODE);
						var matV = (datalist[i].MATERIAL_VALUE==null?"":datalist[i].MATERIAL_VALUE);
						var metC = (datalist[i].METHOD_CODE==null?"":datalist[i].METHOD_CODE);
						var metV = (datalist[i].METHOD_VALUE==null?"":datalist[i].METHOD_VALUE);
						var specC = (datalist[i].SPEC_CODE==null?"":datalist[i].SPEC_CODE);
						var specV1 = (datalist[i].SPEC_VALUE==null?"":datalist[i].SPEC_VALUE);
						var specV2 = (datalist[i].SPEC2_VALUE==null?"":datalist[i].SPEC2_VALUE);
						var unitC = (datalist[i].UNIT_CODE==null?"":datalist[i].UNIT_CODE);
						var unitV = (datalist[i].UNIT_VALUE==null?"":datalist[i].UNIT_VALUE);
						
						var data={};
						data["dtlNo"] = dtlNo;
						data["level"] = "R";
						data["memberType"] = "1";
						
						jQuery.ajax({
							url : "getWorkgroupMember",
							type : 'Post',
							async: false,
							cache: false,
							contentType : 'application/json',
							data : JSON.stringify(data),
							dataType : 'json',
							success : function(wgresult) {
								//console.log(JSON.stringify(wgresult));
								var txtRole;
								var roleName="";
								if(wgresult.success == 1) {
									for(var r=0; r<wgresult.dataList.length;r++){
										txtRole+='<option value="'+dtlNo+'|'+wgresult.dataList[r].WORK_GROUP+'" >'+wgresult.dataList[r].WORK_GROUP+'</option>';
										if(roleName==""){
											roleName=wgresult.dataList[r].WORK_GROUP;
										}
									}
								}
								det +='<tr>'; 
								
								det +='<td class="text-center" >' + (i+1) + '</td>'; 
								det +='<td class="text-center" ><select class="form-control select2" name="role" id="assignRole_'+dtlNo+'" onchange="getMemberRole(this.value)" ><option>---</option>'+txtRole+'</select></td>';
								det +='<td class="text-left" ><select class="form-control select2 roleUnder" name="roleUnder" id="roleUnder_'+dtlNo+'"><option>---</option></select></td></td>';
								det +='<td class="text-left" >'+analyzV+'</td>'; 
								det +='<td class="text-left" >'+matV+'</td>';
								det +='<td class="text-left" >'+metV+'</td>';
								 
								det +='</tr>'; 
										
							},error : function() {
								showMsgError('เกิดข้อผิดพลาด');
							}
						}).fail(function(){
							//setTimeout(function(){ HideWaiting(); }, 1000);
						});
						
					}
					if (det=='') {
						det += '<tr> ';
						det += '<th colspan="5" class="text-center">--- ไม่พบข้อมูล ---</th> ';
						det += '</tr> ';
						$('#dteId').html(det);
					} else {
						$('#randomOilDetailId').html(det);
					} 
				} 
			} else {
				showMsgError('เกิดข้อผิดพลาด ในการเชื่อมต่อฐานข้อมูล');
			}
			
			setTimeout(function(){ HideWaiting(); }, 1000);
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด');
		}
	}).fail(function(){
		setTimeout(function(){ HideWaiting(); }, 1000);
	});
	
}
function getMemberRole(me){
	
	var val = me.split("|");
	var data = {};
	data["dtlNo"] = val[0];
	data["level"] = "M";
	data["memberType"] = "1";
	data["roleName"] = val[1];
	
	var id = "roleUnder_"+data["dtlNo"];
	
	//alert(val);
	jQuery.ajax({
		url : "getWorkgroupMember",
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		data : JSON.stringify(data),
		dataType : 'json',
		success : function(wgresult) {
			//console.log(JSON.stringify(wgresult));
			$("#"+id).html("");
			var txtMember;
			if(wgresult.success == 1) {
				for(var r=0; r<wgresult.dataList.length;r++){
					txtMember+='<option value="'+wgresult.dataList[r].EMP_ID+'" >'+wgresult.dataList[r].EMP_ID+' '+ wgresult.dataList[r].EMP_NAME +'</option>';
					
					$("#"+id).html(txtMember);
				}
				
			}
			
		
		},error : function() {
			showMsgError('เกิดข้อผิดพลาด');
		}
	}).fail(function(){
		//setTimeout(function(){ HideWaiting(); }, 1000);
	});
	
}
function gotoMain(){
	//if ( pageId == "0" ) window.location="randomOilForValidate"; 
	//else if ( pageId == "1" ) window.location="home"; 
	//else window.location="randomOilForValidate"; 
	window.location="randomOilForValidate"; 
}

</script>


<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2><span id="pageTitles"></span></h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight" style="padding-bottom:0px"> 
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-content">
					<div class="row">
						<div class="col-lg-4"><span><label>หมายเลข LTR </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_no"> &nbsp; </span></div>
						<div class="col-lg-4"><span><label>ผลิตภัณฑ์ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_prod"> &nbsp; </span></div>
						<div class="col-lg-4"><span><label>เลขที่รถ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_carno"> &nbsp; </span></div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>วันที่ PO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_datepo"> &nbsp; </span> </div>
						<div class="col-lg-4"><span><label>แหล่งที่มา </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_src"> &nbsp; </span> </div>
						<div class="col-lg-4"><span><label>ช่องรถ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_carslot"> &nbsp; </span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ PO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_po"> &nbsp; </span> </div>
						<div class="col-lg-4"><span><label>ระบบขนส่ง </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_trans"> &nbsp; </span> </div>
						<div class="col-lg-4"><span><label>เลขที่เรือ  </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatno"> &nbsp; </span></div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ DO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_do"> &nbsp; </span></div>
						<div class="col-lg-4"><span><label>รูปแบบการเก็บ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_samp"> &nbsp; </span> </div>
						<div class="col-lg-4"><span><label>ชื่อเรือ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatname"> &nbsp; </span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ SHIPMENT </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_ship"> &nbsp; </span> </div>
						<div class="col-lg-4"><span><label>วันที่สุ่ม </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_daterandom"> &nbsp; </span></div>
						<div class="col-lg-4"><span><label>ช่องเรือ</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatslot"> &nbsp; </span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>รหัสกลุ่ม </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_grp"> &nbsp; </span> </div>
						<div class="col-lg-4"><span><label>วันที่หมดอายุ</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_dateexp"> &nbsp; </span> </div>
						<div class="col-lg-4"><span><label>ชื่อพนักงาน</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_empname"> &nbsp; </span> </div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="wrapper wrapper-content animated fadeInRight" style="padding-top:0px"> 
     
    
    <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                   
                       <div class="row">
	                        <div class="col-xs-12">
	                             <div class="table-responsive"  >
							         <table   id="myTableRandomOilDetailId" class="table table-striped table-bordered" style="width: 100%;" role="grid" aria-describedby="tableApproverTask_info">
									 
										<thead>
											<tr class="tbHeader">
										       <th class="text-center" style="width: 5%;" >NO</th>  
										       <th class="text-center" style="width: 10%;" >กลุ่มงาน</th> 
										       <th class="text-center" style="width: 25%;" >ผู้ปฏบัติงาน</th>  
			                                   <th class="text-center" style="width: 15%;" >รายการวิเคราะห์</th>
			                                   <th class="text-center" style="width: 15%;" >เครื่องมือวิเคราะห์</th> 
			                                   <th class="text-center" style="width: 15%;" >method</th> 
			                                   <th class="text-center save_result" style="width: 15%;" hidden >ผลการวิเคราะห์</th> 
											</tr>
										 </thead>
										<tbody id="randomOilDetailId">
										</tbody>
									</table> 
	                        </div>
	                    </div>
                    </div>
               </div>
            </div> 
        </div>
    </div> 
	  <div class="form-group">
	         <div class="col-sm-6">
	                    <button type="button"
	                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()">กลับไปหน้าหลัก
	                      <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
	                    </button>             
	        </div>
	        <div class="col-sm-6"> 
                 <center>
					<button type="button" id="btnAssignmentLab" hidden style="width: 150px;" onclick="sendRequestAssignRandomOil();" class="btn btn-primary center-block">มอบหมายงาน <i class="fa fa-send" style="font-size:22px;color:yellow"></i></button>
					<button type="button" id="btnSaveResultLab" hidden style="width: 150px;" onclick="sendRequestAssignRandomOil();" class="btn btn-primary center-block">บันทึกผล <i class="fa fa-save" style="font-size:22px;color:yellow"></i></button>
                 </center> 
	        </div>
	 </div>
</div>




