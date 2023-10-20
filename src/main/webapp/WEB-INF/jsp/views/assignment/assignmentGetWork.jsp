<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>

<link href="<c:url value="/assets/css/chat.css" />" rel="stylesheet">

<style>
.tbHeader {
	font-size:  10px;
	background: #3c8dbc;
	color: white;
}
</style>
<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>	
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
						<div class="col-lg-4"><span><label>หมายเลข LTR </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_no"></span></div>
						<div class="col-lg-4"><span><label>ผลิตภัณฑ์ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_prod"></span></div>
						<div class="col-lg-4"><span><label>เลขที่รถ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_carno"></span></div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>วันที่ PO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_datepo"></span> </div>
						<div class="col-lg-4"><span><label>แหล่งที่มา </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_src"></span> </div>
						<div class="col-lg-4"><span><label>ช่องรถ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_carslot"></span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ PO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_po"></span> </div>
						<div class="col-lg-4"><span><label>ระบบขนส่ง </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_trans"></span> </div>
						<div class="col-lg-4"><span><label>เลขที่เรือ  </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatno"></span></div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ DO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_do"></span></div>
						<div class="col-lg-4"><span><label>รูปแบบการเก็บ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_samp"></span> </div>
						<div class="col-lg-4"><span><label>ชื่อเรือ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatname"></span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ SHIPMENT </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_ship"></span> </div>
						<div class="col-lg-4"><span><label>วันที่สุ่ม </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_daterandom"></span></div>
						<div class="col-lg-4"><span><label>ช่องเรือ</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatslot"></span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>รหัสกลุ่ม </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_grp"></span> </div>
						<div class="col-lg-4"><span><label>วันที่หมดอายุ</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_dateexp"></span> </div>
						<div class="col-lg-4"><span><label>ชื่อพนักงาน</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_empname"></span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>ประเภทตัวอย่าง</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_sampleType"></span> </div>
						<div class="col-lg-4"><span><label>รายละเอียดตัวอย่าง</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_sampleType_desc"></span> </div>
					</div>
				</div>

				
			</div>
		</div>
	</div>
</div>


<div class="wrapper wrapper-content animated fadeInRight" style="padding-bottom:0px"> 
	<div class="row ibox-content">
		<div class="col-xs-12 result-silver" style="display:none"> <!-- style="display:none" -->
			<label class="col-xs-2">ค่าการกัดกร่อนแผ่นเงิน</label>
			<select class="col-xs-2" id="result_silver">
				<option value="Y">ผ่าน</option>
				<option value="N">ไม่ผ่าน</option>
			</select>
		</div>
		<div class="col-xs-12 product-desc" style="display:none;"> <!-- style="display:none" -->
		
			<label class="col-xs-12">Product Description</label>
<!-- 			<input class="col-xs-6 form-control " type="text" id="inputProductDesc"> -->
		<div id="block_select_getwork">
			<div class="row">
			   <div class="col-sm-6">
			      <div class="form-group" style="text-align: left">
			         <select class="form-control" id="inputProductDesc">
			            <option>small</option>
			            <option>medium</option>
			            <option>large</option>
			         </select>
			      </div>
			   </div>
			</div>
		</div>
		<div style="display:none;margin-top: 10px" id="other_input">
			<label class="col-xs-12">อื่นๆ โปรดระบุ</label>
			
			<div class="row">
			   <div class="col-sm-6">
			      <div class="form-group" style="text-align: left">
			         <input class="col-xs-6 form-control " type="text" id="inputProductDescOther">
			      </div>
			   </div>
			</div>
		</div>
		<div style="display:none;" id="label_read_prddesc">
		<div class="row">
			   <div class="col-sm-6">
			      <div class="form-group" style="text-align: left">
			         <input class="col-xs-6 form-control " type="text" id="lab_prddesc" disabled="disabled">
			      </div>
			   </div>
			</div>
			
		</div>
		</div>
		<div class="col-xs-12 h3" id="div_for_lead" style="display: none;"><span>เลขที่ใบงาน : </span><span id="ltr_num_forlead"></span></div>
				<div class="col-xs-12">
			<div class="table-responsive"   >
				<table   id="assiHeadT" class="table table-striped table-bordered" style="padding: 0 10%;">
					<thead>
						<tr class="tbHeader">
							<th class="text-center">รายละเอียด</th>
							<th class="text-center">ค่า</th>
						</tr>
					</thead>
					<tbody id="assiHead">
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-xs-12">
			<div class="table-responsive"   >
				<table   id="assiDetialT" class="table table-striped table-bordered" style="padding: 0px;">
					<thead>
						<tr class="tbHeader">
							<th class="text-center" id="num_assiDetialT">เลขที่ใบงาน</th> 
							<th class="text-center select-Item" ><input id="tigAll" type="checkbox" onclick="selectAll(this)"></th>
							
							<!-- <th class="text-center">ITEM ID</th>  -->
							<th class="text-center">รายการวิเคราะห์</th> 
							<th class="text-center">ค่าที่วิเคราะห์</th>
							<th class="text-center">ผลการวิเคราะห์ (LTR)</th>
							<th class="text-center">ผลการวิเคราะห์ (COQ)</th>
							<th class="text-center">Y/N</th>
							<th class="text-center">Uncertainty</th>
							<th class="text-center">Test Method</th>						
							<th class="text-center">เครื่องมือวิเคราะห์</th>
							<th class="text-center">ผลิตภัณฑ์</th>
							<th class="text-center">กลุ่มงาน</th>
							
						</tr>
					</thead>
					<tbody id="assiDetial">
					</tbody>
				</table> 
			</div>
		</div>
			<div class="col-xs-12" style="margin-top: 5px;margin-bottom: 5px;display: none;" id="describe_for_tool_block">
			<div class="col-xs-1">หมายเหตุ : </div>
			<div class="col-xs-11"><input type="text" class="form-control col-xs-5" id="remark_a4" maxlength="1000"/></div>
			
			
			</div>
			<div class="comment-class col-xs-12" style="display:none">

			<div class="panel-group" id="accordion">
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
			          History Comment
			        </a>
			      </h4>
			    </div>
			    <div id="collapseOne" class="panel-collapse collapse in">
			      <div class="panel-body">
			      	<div class="comment col-xs-12">
						<h4>History Comment</h4>
					</div>
					<div class="c-header" style="display:none"> 
						<ul class="comment-history" id="commnetHistoryID"></ul>
					</div>
					<div class="comment col-xs-12">
						<label>Comment</label>
					</div>
					<div class="commentBox col-xs-12">
						<textarea class="form-control" id="commentTextarea" rows="3"></textarea>
					</div>		
				   </div>
				</div>
			  </div>
			  <div class="panel panel-default">
			    <div class="panel-heading">
			      <h4 class="panel-title">
			        <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
			          History Create
			        </a>
			      </h4>
			    </div>
			    <div id="collapseTwo" class="panel-collapse collapse">
			      <div class="panel-body">
			     	<div class="comment col-xs-12">
						<h4>History UserCreate</h4>
					</div>
					<div class="c-header2" style="display:none"> 
						<ul class="usercreate-history" id=""></ul>
					</div>
			      </div>
			    </div>
			  </div>
			</div>
			
		</div>
		

			<div class="history-a4 col-xs-12" style="display:none;margin-top: 20px;">
			<div class="" id="accordion">
			  <div class="">
			    <div id="collapseOne" class="panel-collapse collapse in">
			      <div class="">
			      	<div class="comment col-xs-12">
						<h4>History UserCreate</h4>
					</div>
					<div class="c-header2" style="display:none"> 
						<ul class="usercreate-history" id=""></ul>
					</div>
						
				   </div>
				</div>
			  </div>
			</div>	
			</div>
		
		</div>


	
		
</div>


<div class="row col-sm-12">
	<div class="col-sm-6" id="sendBack" style="display:none">
		<button id="sendBackButton" type="button" class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()">
			กลับไปหน้าหลัก
	    </button>
	</div>
	<div class="col-sm-6" id="sendCancel" style="display:none">
		<button id="sendCancelButton" type="button" class="btn btn-danger center-block"  style="width: 150px;" onclick="sendToCancel()">ไม่อนุมัติ
	    </button>	
	</div>
	<div class="col-sm-6" id="sendRemove" style="display:none">
		<button id="sendRemoveButton" type="button" class="btn btn-warning center-block"  style="width: 150px;" onclick="sendToRemove()">ยกเลิกตัวอย่าง
	    </button>	
	</div>
<!-- default -->
<!-- 	<div class="col-sm-6" id="sendEdit" style="display:none"> -->
<!-- 		<button id="sendEditButton" type="button" class="btn btn-info center-block"  style="width: 150px;" onclick="sendToEdit()">ขอแก้ไข -->
<!-- 	    </button>	 -->
<!-- 	</div> -->
	<div class="col-sm-6" id="sendEdit" style="display:none">
		<button  type="button" class="btn btn-info center-block" data-toggle="modal" data-target="#reason_modal"  style="width: 150px;" id="request_edit">ขอแก้ไข
	    </button>	
	</div>
	<div class="col-sm-4" id="edit_plan_div" style="display:none">
		<button id="edit_model_plan" type="button" class="btn btn-primary center-block"  style="width: 150px;" onclick="setLocalStorage()">บันทึกร่าง
	    </button>	
	</div>
	<div class="col-sm-6" id="sendSave" style="display:none">
		<button id="sendSaveButton" type="button" class="btn btn-success center-block"  style="width: 150px;" onclick="checkSave()">บันทึกและส่งข้อมูล
	    </button>	
	</div>
	                       
</div>
<div class="modal fade" id="reason_modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document" style="width: 30%;height: 20%;margin-left: 40%;" id="dialog_getwork">
	<div class="modal-content">
		<div class="modal-header bg-primary">
		

	<h2 class="modal-title" id="modalLabel">สาเหตุของการแก้ไข</h2>
	</div>
	<div class="modal-body" style="text-align: center;" >
		<label class="col-xs-12 h4 text-left">โปรดเลือก สาเหตุของการแก้ไข</label>
	     <div >
			<div class="row ">
			   <div class="col-sm-12 ">
			      <div class="form-group" style="text-align: left">
			         <select class="form-control" id="input_revise">
			            <option value="01">small</option>
			            <option value="02">medium</option>
			            <option value="99" id="99">large</option>
			         </select>
			      </div>
			      <div style="display: none;" id="other_revise">
			      <label class="col-xs-12 text-left">อื่นๆ โปรดระบุ</label>
			      <div class="row">
			      <div class="col-sm-12">
			      <div class="form-group" style="text-align: left">
			         <input class="form-control " type="text" id="inputReviseOther" value="">
			      </div>
			     </div>
			     </div>
			     </div>
			   </div>
			</div>
		</div>

	</div>
	<div class="modal-footer">
	<button type="button" class="btn btn-secondary"  onclick="sendToEdit()"  >OK</button>
	</div>
	</div>
	</div>
</div>

<div class="modal fade" id="uncer_check" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document" style="width: 30%;height: 24%;margin-left: 40%;" >
	<div class="modal-content">
		<div class="modal-header bg-primary">
		

	<h2 class="modal-title" id="modalLabel">การแจ้งเตือน</h2>
	</div>
	<div class="modal-body" style="text-align: center;" >
	     <div >
			<div class="row ">
			  <div style="margin-top: 8%;">
			  <h3 id="text_uncer"></h3>
			  </div>
			</div>
		</div>

	</div>
	<div class="modal-footer">
	<button type="button" class="btn btn-secondary" data-dismiss="modal"  >OK</button>
	</div>
	</div>
	</div>
</div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
<div class="col-sm-12"><p></p></div>
