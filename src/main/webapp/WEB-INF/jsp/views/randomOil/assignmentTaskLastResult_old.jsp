<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.tbHeader {
	font-size:  10px;
	background: #3c8dbc;
	color: white;
}
</style>

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
					<input type="hidden" id="productCodeId" value="${task.PRODUCT_CODE}">
					<input type="hidden" id="sampleTypeNameId" value="${task.SAMPLE_TYPE_NAME}">
					<input type="hidden" id="detailLength" value="${fn:length(details)}"/>
					<input type="hidden" id="genKey" value="${genKey}"/>
					<div class="row">
						<div class="col-lg-4"><span><label>หมายเลข LTR </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_no">${task.LAB_CODE}&nbsp; </span></div>
						<div class="col-lg-4"><span><label>ผลิตภัณฑ์ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_prod"> <c:out value="${task.PRODUCT_CODE}" />&nbsp; </span></div>
						<div class="col-lg-4"><span><label>เลขที่รถ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_carno"> <c:out value="${task.CAR_NO}" />&nbsp; </span></div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>วันที่ PO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_datepo"> <c:out value="${task.PO_DATE}" />&nbsp; </span> </div>
						<div class="col-lg-4"><span><label>แหล่งที่มา </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_src"> <c:out value="${task.source_name}" />&nbsp; </span> </div>
						<div class="col-lg-4"><span><label>ช่องรถ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_carslot"><c:out value="${task.CAR_SLOT}" /> &nbsp; </span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ PO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_po"> <c:out value="${task.PO_NO}" />&nbsp; </span> </div>
						<div class="col-lg-4"><span><label>ระบบขนส่ง </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_trans"> <c:out value="${task.logis_name}" />&nbsp; </span> </div>
						<div class="col-lg-4"><span><label>เลขที่เรือ  </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatno"> <c:out value="${task.BOAT_NO}" />&nbsp; </span></div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ DO </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_do"> <c:out value="${task.DO_NO}" />&nbsp; </span></div>
						<div class="col-lg-4"><span><label>รูปแบบการเก็บ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_samp"> <c:out value="${task.SAMPLE_LEVEL_DESC}" />&nbsp; </span> </div>
						<div class="col-lg-4"><span><label>ชื่อเรือ </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatname"> <c:out value="${task.BOAT_NAME}" />&nbsp; </span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>เลขที่ SHIPMENT </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_ship"> <c:out value="${task.SHIPMENT_NO}" />&nbsp; </span> </div>
						<div class="col-lg-4"><span><label>วันที่สุ่ม </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_daterandom"> <c:out value="${task.STR_SAMPLE_EXPIRE_DATE}" />&nbsp; </span></div>
						<div class="col-lg-4"><span><label>ช่องเรือ</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_boatslot"> <c:out value="${task.BOAT_SLOT}" />&nbsp; </span> </div>
					</div>
					<div class="row">
						<div class="col-lg-4"><span><label>รหัสกลุ่ม </label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_grp"> <c:out value="${task.SAMPLE_REFER}" />&nbsp; </span> </div>
						<div class="col-lg-4"><span><label>วันที่หมดอายุ</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_dateexp"> <c:out value="${task.STR_SAMPLE_DATE}" />&nbsp; </span> </div>
						<div class="col-lg-4"><span><label>ชื่อพนักงาน</label></span>&nbsp;&nbsp;:&nbsp;&nbsp;<span id="ltr_empname"> <c:out value="${task.SAMPLE_STAFF_NAME}" />&nbsp; </span> </div>
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
	                             <div class="table-responsive">

							         <table   id="myTableRandomOilDetailId_" class="table table-striped table-bordered" style="width: 100%;" role="grid" aria-describedby="tableApproverTask_info">
									 
										<thead>
											<tr class="tbHeader" style="font-size: 14px;">
										       <th class="text-center" style="width: 5%;" >No</th>
										       <th class="text-center" style="width: 10%;" >กลุ่มงาน</th> 
										       <th class="text-center" style="width: 20%;" >ผู้ปฏิบัติงาน</th>
			                                   <th class="text-center" style="width: 15%;" >รายการวิเคราะห์</th>
			                                   <th class="text-center" style="width: 15%;" >เครื่องมือวิเคราะห์</th> 
			                                   <th class="text-center" style="width: 15%;" >Method</th>
											</tr>
										 </thead>
										<tbody id="randomOilDetailId">
										<c:forEach items="${details}" var="detail" varStatus="myIndex">
										<tr>
											<td class="text-center" style="width: 5%;" >${myIndex.index+1}</td>
											<td style="width: 10%;">
												<c:if test="${assignFlag == 'N'}">
													<c:forEach items="${detail.workgroup}" var="workgroup">
														<div>
															<input type="checkbox" id="w_${workgroup.roleGroup}_${detail.testItemcode}"
																   name="w_${workgroup.roleGroup}_${detail.testItemcode}"
																   value="${workgroup.roleGroup}" />
															<label for="w_${workgroup.roleGroup}_${detail.testItemcode}" style="font-weight: normal; margin-left: 5px;font-size:13px;">${workgroup.roleGroup}</label>
														</div>
													</c:forEach>
												</c:if>
												<c:if test="${assignFlag == 'Y'}">
													<c:forEach items="${detail.workgroup}" var="workgroup">
														<div>
															<input type="checkbox" checked="checked" disabled="disabled"
																   id="w_${workgroup.roleGroup}_${detail.testItemcode}" name="w_${workgroup.roleGroup}_${detail.testItemcode}"
																   value="${workgroup.roleGroup}" />
															<label for="w_${workgroup.roleGroup}_${detail.testItemcode}" style="font-weight: normal; margin-left: 5px;font-size:13px;">${workgroup.roleGroup}</label>
														</div>
													</c:forEach>
												</c:if>
											</td>
											<td style="width: 20%;">
												<c:forEach items="${detail.workgroup}" var="workgroup">
													<div style="padding-left: 10px;">${workgroup.roleGroup}</div>
													<c:if test="${assignFlag == 'N'}">
														<c:forEach items="${workgroup.memberList}" var="member">
															<div>
																<input type="checkbox"
																	   id="m_${detail.testItemcode}_${detail.testtoolcode}_${detail.testmathodcode}_${detail.testSpeccode}_${detail.testUnitcode}_${workgroup.roleGroup}_${member.memberID}"
																	   name="m_${detail.testItemcode}_${detail.testtoolcode}_${detail.testmathodcode}_${detail.testSpeccode}_${detail.testUnitcode}_${workgroup.roleGroup}_${member.memberID}"
																	   value="m_${detail.testItemcode}_${detail.testtoolcode}_${detail.testmathodcode}_${detail.testSpeccode}_${detail.testUnitcode}_${workgroup.roleGroup}_${member.memberID}" />
																<label for="m_${detail.testItemcode}_${detail.testtoolcode}_${detail.testmathodcode}_${detail.testSpeccode}_${detail.testUnitcode}_${workgroup.roleGroup}_${member.memberID}" style="font-weight: normal;margin-left:5px;font-size:12px;">${member.memberName}</label>
															</div>
														</c:forEach>
													</c:if>
													<c:if test="${assignFlag == 'Y'}">
														<c:forEach items="${workgroup.memberList}" var="member">
															<div>
																<input type="checkbox" disabled="disabled" checked="checked"
																	   id="m_${detail.testItemcode}_${detail.testtoolcode}_${detail.testmathodcode}_${detail.testSpeccode}_${detail.testUnitcode}_${workgroup.roleGroup}_${member.memberID}"
																	   name="m_${detail.testItemcode}_${detail.testtoolcode}_${detail.testmathodcode}_${detail.testSpeccode}_${detail.testUnitcode}_${workgroup.roleGroup}_${member.memberID}"
																	   value="m_${detail.testItemcode}_${detail.testtoolcode}_${detail.testmathodcode}_${detail.testSpeccode}_${detail.testUnitcode}_${workgroup.roleGroup}_${member.memberID}" />
																<label for="m_${detail.testItemcode}_${detail.testtoolcode}_${detail.testmathodcode}_${detail.testSpeccode}_${detail.testUnitcode}_${workgroup.roleGroup}_${member.memberID}" style="font-weight: normal;margin-left:5px;font-size:12px;">${member.memberName}</label>
															</div>
														</c:forEach>
													</c:if>

												</c:forEach>
											</td>
											<td style="width: 15%;">
													<c:if test="${not empty detail.testItemcode}">
														${detail.testItemcode} / ${detail.testItem}
													</c:if>
											</td>
											<td style="width: 15%;">
													<c:if test="${not empty detail.testtoolcode}">
														${detail.testtoolcode} / ${detail.testtool}
													</c:if>
											</td>
											<td style="width: 15%;">
													<c:if test="${not empty detail.testmathodcode}">
														${detail.testmathodcode} / ${detail.testmathod}
													</c:if>
											</td>
										</tr>
										</c:forEach>
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
					 <c:if test="${assignFlag == 'N'}">
						 <button type="button" id="btnAssignmentLab" style="width: 150px;" onclick="assignJob();" class="btn btn-primary center-block">มอบหมายงาน <i class="fa fa-send" style="font-size:22px;color:yellow"></i></button>
					 </c:if>
					 <c:if test="${assignFlag == 'Y'}">
						 <button type="button" id="btnSaveResultLab" style="width: 150px;" onclick="sendRequestAssignRandomOil();" class="btn btn-primary center-block">บันทึกผล <i class="fa fa-save" style="font-size:22px;color:yellow"></i></button>
					 </c:if>
                 </center> 
	        </div>
	 </div>
</div>




