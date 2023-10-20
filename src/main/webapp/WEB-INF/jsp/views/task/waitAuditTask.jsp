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
                    <input type="hidden" id="wfId" value="${task.LAB_CODE}">
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

                                <table  id="tblForSubmitTask" class="table table-striped table-bordered" style="width: 100%;" role="grid" aria-describedby="tableApproverTask_info">
                                    <thead>
                                    <tr class="tbHeader" style="font-size: 14px;">
                                        <th class="text-center" style="width: 5%;" >No</th>
                                        <th class="text-center" style="width: 15%;" >ผู้ปฏิบัติงาน</th>
                                        <th class="text-center" style="width: 10%;" >รายการวิเคราะห์</th>
                                        <th class="text-center" style="width: 10%;" >เครื่องมือวิเคราะห์</th>
                                        <th class="text-center" style="width: 10%;" >Method</th>
                                        <th class="text-center" style="width: 15%;" >ผมการวิเคราะห์</th>
                                        <th class="text-center" style="width: 20%;" >รายละเอียด</th>
                                        <th class="text-center" style="width: 10%;" >หน่วย</th>
                                    </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-6">&nbsp;</div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="commentTxt">Comment</label>
                <textarea cols="5" rows="4" class="form-control" id="commentTxt" name="commentTxt"></textarea>
                <small class="form-text text-muted">ระบุเหตุผลที่ต้องการแจ้งไห้ผู้ที่เกี่ยวข้องทราบ</small>
            </div>
        </div>
        <div class="col-sm-6">
            <button type="button" class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()">กลับไปหน้าหลัก
                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
            </button>
        </div>
        <div class="col-sm-1">&nbsp;</div>
        <div class="col-sm-2">
            <button type="button" id="btnSendRevise" style="width: 160px;" onclick="sendReviseTask()" class="btn btn-warning center-block">ส่งกลับแก้ไข <i class="fa fa-save" style="font-size:22px;color:yellow"></i></button>
        </div>
        <div class="col-sm-1">
            <button type="button" id="btnSendApprove" style="width: 160px;" onclick="sendApproveTask()" class="btn btn-primary center-block">ส่งอนุมัติ <i class="fa fa-save" style="font-size:22px;color:yellow"></i></button>
        </div>
        <div class="col-sm-2">&nbsp;</div>
    </div>
</div>




