<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <div class="box box-success box-solid"> -->
<style>
.tbHeader {
	font-size:  9px;
	background: #3c8dbc;
	color: white;
}
.TBODY{
	font-size:  10px; 
}
.dtr-details{
	font-size:  10px; 
}
</style>
<script type='text/javascript'>
$(function() {
	cntWaitingRandomLastResult();
	initGridView();
});
var view = [];

function initGridView() {
	ShowWaiting();
	var listPlant = $("#lstPlant").val().split("|");
	$.each(listPlant, function (i, item) {
		var plant = item.split(",");
		view[plant[0]] = new OilGridView(plant[0], plant[1]);
	});
	HideWaiting();
}
class OilGridView {
	constructor(pid, pname){
		this.pid = pid;
		this.pname = pname;
		this.init();
	} init() {
		var data = {};
		data["nameStore"] = this.pid;
		jQuery.ajax({
			url : 'inquiryRandomLastResult',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			success : function(data) {
				if(data.success==1) {
					var plantid = "";
					$.each(data.list, function (i, ls) {
						plantid = ls.PLANT_ID;
						var paramMethodGet  = "0|" + ( ls.PLANT_ID==null ? "" : ls.PLANT_ID) + "|" + i + "|" + ( ls.LAB_CODE==null ? "" : ls.LAB_CODE) + "|" + ( ls.PRODUCT_CODE==null ? "" : ls.PRODUCT_CODE) + "|" + ( ls.SAMPLE_TYPE_NAME==null ? "" : ls.SAMPLE_TYPE_NAME) ;
						var paramMethodGet2 = "0," + ( ls.PLANT_ID==null ? "" : ls.PLANT_ID) + "," + i + "," + ( ls.LAB_CODE==null ? "" : ls.LAB_CODE) + "," + ( ls.PRODUCT_CODE==null ? "" : ls.PRODUCT_CODE) + "," + ( ls.SAMPLE_TYPE_NAME==null ? "" : ls.SAMPLE_TYPE_NAME);

						this.tr = $("<tr>").addClass("TBODY")
						.append($("<td>").addClass("text-center").html(i+1))
						.append($("<td>").addClass("text-center").append((data.list[i].ASSIGN_STATUS==null || data.list[i].ASSIGN_STATUS=="") ? $("<input>").attr({"id":"eachChk"+ls.PLANT_ID, "type":"checkbox", "name":"lab"+ls.PLANT_ID, "value":paramMethodGet}).addClass("chk"+ls.PLANT_ID) : $("<span>").addClass("glyphicon glyphicon-ok").css({"color":"blue"})))
						.append($("<td>").addClass("text-center").append($("<a>").attr({"href":"assignmentTaskLastResult?labCode_No="+paramMethodGet2}).html(ls.LAB_CODE))) 
						.append($("<td>").addClass("text-center").html(ls.SAMPLE_REFER))
						.append($("<td>").addClass("text-left").html(ls.STATUS_DESC))
						.append($("<td>").addClass("text-left").html(ls.PO_NO))
						.append($("<td>").addClass("text-left").html(ls.STRPO_DATE))
						.append($("<td>").addClass("text-left").html(ls.DO_NO))
						.append($("<td>").addClass("text-left").html(ls.SHIPMENT_NO))
						.append($("<td>").addClass("text-left").html(ls.product_name))
						.append($("<td>").addClass("text-left").html(ls.source_name))
						.append($("<td>").addClass("text-left").html(ls.logis_name))
						.append($("<td>").addClass("text-left").html(ls.SAMPLE_LEVEL_DESC))
						.append($("<td>").addClass("text-center").append($("<span>").addClass("glyphicon glyphicon-oil").css({"color":((ls.COLOR_FLAG != null) ? ls.COLOR_FLAG : "green")})))
						.append($("<td>").addClass("text-left").html(ls.CAR_NO))
						.append($("<td>").addClass("text-left").html(ls.CAR_SLOT))
						.append($("<td>").addClass("text-left").html(ls.BOAT_NO))
						.append($("<td>").addClass("text-left").html(ls.BOAT_NAME))
						.append($("<td>").addClass("text-left").html(ls.BOAT_SLOT))
						.append($("<td>").addClass("text-left").html(ls.STR_SAMPLE_DATE))
						.append($("<td>").addClass("text-left").html(ls.STR_SAMPLE_EXPIRE_DATE))
						.append($("<td>").addClass("text-left").html(ls.SAMPLE_DATA_GROUP))
						.append($("<td>").addClass("text-left").html(ls.SAMPLE_DATA_SEQ))
						.append($("<td>").addClass("text-left").html(ls.SAMPLE_STAFF_ID))
						.append($("<td>").addClass("text-left").html(ls.SAMPLE_STAFF_NAME)).appendTo($("#dteId_" + ls.PLANT_ID));
					});
					$("#myTableDteId_"+plantid).DataTable({searching: true, responsive : true});
				} else {
					showMsgError(data.message);
				}
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด');
			}
		});	
	}

}

	function checkPlantAll(elementPlantId) {
		
		var elemPlant = document.getElementsByName('lab'+elementPlantId);
		var elementLent = elemPlant.length;
		var headElem = $("#head_"+elementPlantId);
		if ( headElem.attr("checked") == undefined ) {
			headElem.attr("checked",true);
			for( var i=0; i<elementLent; i++){
				if(elemPlant[i].type = "checkbox") {
					elemPlant[i].checked = true;	
				}
			}
		} else {
			if(headElem.attr("checked")=='checked') {
				headElem.attr("checked",false);
				for( var i=0; i<elementLent; i++){
					if(elemPlant[i].type = "checkbox") {
						elemPlant[i].checked = false;	
					}
				}
			} else {
				headElem.attr("checked",true);
				for( var i=0; i<elementLent; i++){
					if(elemPlant[i].type = "checkbox") {
						elemPlant[i].checked = true;	
					}
				}
			}
		}
		
	} 
    function cntWaitingRandomLastResult() {
		var rtnDate = "";
		var data = {}
		jQuery.ajax({
			url : 'cntWaitingRandomLastResult',
			type : 'Post',
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(obj) {
				$('#cntRandomSample').html(obj.cnt);
			}
		}).fail(function(){
			showMsgError('ข้อมูลผิดพลาด');
		});	
		
		return rtnDate
	}
	function updateStatus(status) {
     	try {
			var data = {}
			data["status"] = status;
			data["labCode_No"] =  $("#labCode").val(); 
			jQuery.ajax({
				url : 'updateStatusRandomOilDTE',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
				success : function(data) {
					if (data.success==1) {
						showMsgSuccess('บันทึกสำเร็จ');
						$("#labCode").val('');
						gotoMain();
					} else {
						showMsgError(data.message);
					}
				}, error : function() {
					showMsgError('ข้อมูลผิดพลาด');
				}
			});
 		} catch (ex) {
 			 showMsgError(ex);
 		}
     	 
    } 
	function saveRandomOil(){
		try{
			$('#tb-body-import-id').html("");
			$('#myTableSum').DataTable().destroy();
			ShowWaiting() ;
			var data = {}
			jQuery.ajax({
				url : 'insertRandomLastResult',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				success : function(data) {
					if(data.success==1){
						HideWaiting() ;
						$('#popup_random').modal('show');
						var det = "";
						for (var i = 0; i < data.list.length; i++) {
							det +='<tr  >'; 
							det +='<td class="text-left" >'+(data.list[i].plant_name==null?"":data.list[i].plant_name)+'</td>';
							det +='<td class="text-center" >'+(data.list[i].strPO_DATE==null?"":data.list[i].strPO_DATE)+'</td>'; 
							det +='<td class="text-right" >'+(data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
							det +='<td class="text-left" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
							det +='<td class="text-center" >'+(data.list[i].CNT_SUBSET==null?"":data.list[i].CNT_SUBSET)+'</td>';
							det +='</tr>';
						}
						if(det==''){
							det += '<tr> ';
							det += '<th colspan="5" class="text-center">--- ไม่พบข้อมูล ---</th> ';
							det += '</tr> ';
							$('#tb-body-import-id').html(det);
						}else{
							$('#tb-body-import-id').html(det);
							table =  $('#myTableSum').DataTable( {
								searching: true,
								responsive : true
							}); 
						}
						gotoMain();

					}else if(data.success==2){
						HideWaiting() ;
						var  msg  = getMsg("MSG1");

						showMsgWarning(msg);
					}else{

						HideWaiting() ;
						showMsgError(data.message);

					}
				},
				error : function(ex) {
					showMsgError('เกิดข้อผิดพลาด');
					HideWaiting() ;
				}
			});
		} catch (ex) {
			showMsgError('เกิดข้อผิดพลาด');
			HideWaiting() ;
		}

	}  	
    function labAssignment(plant) {
    	ShowWaiting();
    	var chkBoxName = "lab"+plant;
    	$( "input[name=" + chkBoxName + "]:checked" ).each( function() {
			var obj = this.value.split("|");
			var samping = {};
				samping["PLANT_ID"] = obj[1];
				samping["SEQ"] = obj[2];
				samping["LAB_CODE"] = obj[3];
				samping["PRODUCT_CODE"] = obj[4];
				samping["SAMPLE_TYPE_NAME"] = obj[5];			
			wfAssignmentItemList(samping);
    	});
    	setTimeout(function() { HideWaiting(); }, 1000);
    	gotoMain();
    }
	function wfAssignmentItemList (samping){
		var pmObj = {};
			pmObj["plant"] = samping.PLANT_ID;
			pmObj["seq"] = samping.SEQ;
			pmObj["labCode"] = samping.LAB_CODE;
			pmObj["product"] = samping.PRODUCT_CODE;
			pmObj["typeOfSample"] = samping.SAMPLE_TYPE_NAME;

			//console.log("["+i+"] => "+JSON.stringify(pmObj));

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
				if(res.status == "S") {
					console.log("  >>" + JSON.stringify(res));

					var responseResult = JSON.parse(res.result);
					var detailLen = 0;
					var allSeq = "";
					var allItem = "";
					var allTool = "";
					var allMethod = "";
					var allSpec   = "";
					var allUnit   = "";
					
					var arrayWorker = [];
					var arrayRoleGroup = [];
					var defaultRoleGroup = "";
					
					var member = "";
					var roleGrp = "";
					
					var assignmentData = {};
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
						var detail = responseResult["Detail"];
						detailLen = detail.length;
						assignmentData["totalrecord"]  = detailLen;
						$.each(detail,function(d, det) {
							defaultRoleGroup = "";
							arrayWorker[d] = {};

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
							
							if (groupLen > 0 ) {
								$.each(workgroup,function(g, group) {
									var role = group["RoleGroup"];
									var flagDefault = group["RoleDef"];
									var mlist = "";
									roleGrp += role + "|";
									
									arrayWorker[d][role] = [];
									
									if (flagDefault == "Y" ) defaultRoleGroup = flagDefault;
									arrayRoleGroup[g] = [role,flagDefault];
									
									$.each(group["MemberList"],function(i, mem)  {
										var mid = mem["MemberID"];
										var mname = mem["MemberName"];
										
										arrayWorker[d][role][i] = [mid,mname];
										mlist += mid+",";
									});
									member += mlist.substring(0,mlist.length-1) + "|";
								});
							}
						});
					}
					
					assignmentData["seq"]  = allSeq.substring(0,allSeq.length-1);
					assignmentData["testItemCode"]  = allItem.substring(0,allItem.length-1);
					assignmentData["testtoolCode"]  = allTool.substring(0,allTool.length-1);
					assignmentData["testMethodCode"]  = allMethod.substring(0,allMethod.length-1);
					assignmentData["testSpecCode"]  = allSpec.substring(0,allSpec.length-1);
					assignmentData["testUnitCode"]  = allUnit.substring(0,allUnit.length-1);

					//console.log("res from item : "+JSON.stringify(assignmentData));
					
					assignmentData["roleGroup"]  = roleGrp.substring(0,roleGrp.length-1);
					assignmentData["memberlist"]  = member.substring(0,member.length-1);
					
					ShowWaiting();
					var urlr = "submitAssignment";
					jQuery.ajax({
						url : urlr,
						type : 'Post',
						async: false,
						cache: false,
						contentType : 'application/json',
						data : JSON.stringify(assignmentData),
						dataType : 'json',
						success : function(ress) {
							if(ress.status == "S") {
								//console.log(JSON.stringify(ress));
								
								var responseResult = JSON.parse(ress.result);
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
					
					setTimeout(function(){ HideWaiting(); }, 1000);

				}
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด');
			}							
		}).fail(function(){
			showMsgError('เกิดข้อผิดพลาด');
		});						

	}	
	function gotoMain(){
		window.location="randomOilForValidate"; 
	}
	function report(){
	 	var ctx = "${pageContext.request.contextPath}";
	 	var link = ctx+"/reportHome";
	 	window.open(link, '_blank');
	 } 
	 function reload(){
	 	var ctx = "${pageContext.request.contextPath}";
	 	var link = ctx+"/randomOilForValidate";
	 	window.location.href = link;
	 }	
</script>
<input id="lstPlant" type="hidden" value="${listPlant}" >

<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>สุ่มตัวอย่างเพื่อตรวจ(LAB Officer)</h2>
	</div>
	<div class="col-lg-2"></div>
</div>

<div id="wrapperOilValidate" class="wrapper wrapper-content animated fadeInRight"> 
      
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title" style="text-align:right">  จำนวนรอสุ่มเพื่อตรวจ : <span id="cntRandomSample"></span> รายการ
					 <!--  button type="button" id="loginbotttom3" onclick="saveRandomOil() " class="btn btn-success left-block">เพิ่มรายสุ่ม</button> -->  
				</div>
				
				<div class="ibox-content"> 
					<div class="row">
						<div class="col-xs-12">
							<div class="col-sm-3">
								<input type="text" style="width: 250px;"  class="form-control input-sm"   name="labCode" id="labCode"  />
							</div>
							<div class="col-sm-9">
								<button type="button" class="btn btn-danger" style="width: 100px;text-align:center;" onclick="updateStatus('04')">ยกเลิก</button>
							</div> 		    
						</div>
					</div>
					<div class="row">                               
						<div class="col-xs-12">
							<div class="col-sm-12">
								<div class="col-xs-12 text-right">
									<button class="btn btn-primary" onclick="saveRandomOil()">
										<i class="fa fa-search"></i>&nbsp;สุ่ม
									</button>
								</div>
							</div> 
						</div> 
					</div>
				</div>
			</div>
		</div>
    </div>
	
	<div class="row">
		<div class="col-md-12">&nbsp;</div>
	</div>
</div>
 
	<c:forEach var="teamMember" items="${Model}">
    <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                  <div class="ibox-title">
	                    <h5>รายการสุ่มตัวอย่างเพื่อตรวจ<c:out value="${teamMember.PLANT_NAME}"/></h5>
	                   <input type="hidden" name="hidden_namestore" id="hidden_namestore"  value="${teamMember.PLANT_ID}"   />
	                      <div class="ibox-tools">
                        <a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>

                    </div>
                 </div>
                 <div class="ibox-content">
                       <div class="row">
	                        <div class="col-xs-12" >
	                             <div class="table-responsive"   >
							         <table   id="myTableDteId_<c:out value="${teamMember.PLANT_ID}"/>" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
										<thead  class="tbHeader">
											<tr> 
												<!-- <th class="text-center" style="background-color: #fff;" >&nbsp;</th> -->
												<!-- <th class="text-center" style="margin:0; padding:0px; vertical-align: middle; text-align: center;" ><input id="head_${teamMember.PLANT_ID}" type="checkbox" class="chkHead" name="head${teamMember.PLANT_ID}" style="margin-left: 0px;    text-align: left;" ></th> -->
												<th class="text-right" colspan="25" style="background-color: #fff; padding-left:10px; text-align: right;" >
												
													<button type="button" class="btn btn-primary" onclick="labAssignment(${teamMember.PLANT_ID})"><i class='fa fa-group'></i>  มอบหมายงาน</button>

												</th>
											</tr>
											<tr>  <th class="text-center">NO</th>
											      <th class="text-center">
											      		<div id="select_${teamMember.PLANT_ID}" class="select_Lab">Check All </div>
											      		<input id="head_${teamMember.PLANT_ID}" type="checkbox" class="chkHead" name="head${teamMember.PLANT_ID}" value="head${teamMember.PLANT_ID}" style="margin-left: 0px; text-align: left;" onclick="checkPlantAll('${teamMember.PLANT_ID}')" >
											      </th>
											      <th class="text-center">LAB_CODE</th>
											      <th class="text-center">เลขกลุ่ม<br>การสุ่ม</th>
											      <th class="text-center">สถานะ</th>
											      <th class="text-center">เลขที่<br>PO</th>
											      <th class="text-center">วันที่<br>PO</th>
											      <th class="text-center">เลขที่<br>DO</th> 
											      <th class="text-center">เลขที่<br>SHIPMENT</th> 
			                                      <th class="text-center">ผลิตภัณฑ์</th>
			                                      <th class="text-center">แหล่งที่มา</th>
			                                      <th class="text-center">ระบบขนส่ง</th>
			                                      <th class="text-center">รูปแบบการเก็บ</th>
												  <th class="text-center">สี</th>
			                                      <th class="text-center">เลขที่<br>รถ</th>
			                                      <th class="text-center">ช่่อง<br>รถ</th>
			                                      <th class="text-center">เลขที่<br>เรือ</th>
			                                      <th class="text-center">ชื่อเรือ</th>
			                                      <th class="text-center">ช่่อง<br>เรือ</th>
			                                      <th class="text-center">วันที่<br>การสุ่ม</th>
			                                      <th class="text-center">วันที่<br>หมดอายุ</th>
											      <th class="text-center">ลำดับ</th>
												  <th class="text-center">ลำดับย่อย</th>
			                                      <th class="text-center">รหัสพนักงาน</th>
			                                      <th class="text-center">ชื่อพนักงาน</th>
											</tr>
										 </thead>
										<tbody id="dteId_<c:out value="${teamMember.PLANT_ID}"/>"></tbody>
									</table> 
								 </div>
	                        </div>
	                    </div>
                     
                </div>
            </div> 
        </div>
    </div> 
	 </c:forEach>
  </div>
 
 
  <div id="popup_random" class="modal in" tabindex="-1" data-backdrop="static" data-keyboard="false">
	    <div class="modal-dialog" style="width:500"   >
	        <div class="modal-content-wrapper">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <button type="button" class="close"  data-dismiss="modal" aria-label="Close"  >
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                    <h4 class="modal-title">สรุปรายการสุ่ม</h4>
	                </div>
	                <div class="modal-body ptn pbs">
	                    <div class="row">
	                        <div class="col-xs-12">
	                             <div class="table-responsive"   >
							         <table   id="myTableSum" class="table table-striped table-bordered" style="padding: 0px;">
										<thead>
											<tr class="tbHeader">
											  <th class="text-center">PLANT</th> 
													<th class="text-center">PO_DATE</th> 
													<th class="text-center">PRODUCT</th>
													<th class="text-center">LOGISTIC </th>
											   <th class="text-center">SUM</th>
											</tr>
										 </thead>
										<tbody id="tb-body-import-id">
										</tbody>
									</table> 
								 </div>
	                        
	 
	                        </div>
	                    </div>
	 
	                </div>
	                <div class="modal-footer"></div>
	            </div>
	        </div>
	    </div>
 </div> 
 
