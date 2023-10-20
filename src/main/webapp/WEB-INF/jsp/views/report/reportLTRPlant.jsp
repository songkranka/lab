<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><span id="reportTopic">รายงาน Main Lab</span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight"  style="padding-bottom: 0px;">

    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>รายงาน LTR</h5>
                    <div class="ibox-tools">
                        <div class="ibox-content">

                            <div class="row">
                           		<div class="col-sm-3">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-3">
                                    <div class="form-group" style="text-align: left">
                                        <label>วันที่</label>
                                        <div class='input-group date' id='datetimepicker1'>
                                            <input type='text' id="sdate" class="form-control" />
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group" style="text-align: left">
                                        <label>ถึง</label>
                                        <div class='input-group date' id='datetimepicker2'>
                                            <input type='text' id="edate" class="form-control" />
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                           		<div class="col-sm-3">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-6">
                                    <div class="form-group" style="text-align: left">
                                        <label>ประเภทรายงาน</label>
                                      <select class="form-control select5Inp" id="nonTypeReport" > 
									  	<option value="LTR">LTR</option>
									  	<option value="COQ">COQ</option>
									  </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                           		<div class="col-sm-3">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-6">
                                    <div class="form-group" style="text-align: left">
                                        <label>ผลิตภัณฑ์</label>
                                      <select class="form-control select5Inp" id="nonProduct" multiple="multiple"> 
										 
										  </select>
                                    </div>
                                </div>
                            </div>
							<div class="row">
                           		<div class="col-sm-3">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-6">
                                    <div class="form-group" style="text-align: left">
                                        <label>ประเภทตัวอย่าง</label>
                                      <select class="form-control select5Inp" id="nonSampleType" multiple="multiple"> 
										
										  </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                           		<div class="col-sm-7">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-2">
                                    <button type="button" class="btn btn-primary seatchTypeComp" onclick="ajaxGetDataReportLTR()">ค้นหา</button>
                                    
                                </div>
                            </div>
                             
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="wrapper wrapper-content animated fadeInRight" id="bodyTemplate">

</div>

<div id="approveModal" class="modal fade" tabindex="-1" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content" id="blockUi_data">
            <div class="modal-header">
                <h4 class="modal-title">บันทึกผู้รับผิดชอบ</h4>
            </div>
            <div class="modal-body">
                <div class="alert alert-danger display-hide alert-modal">
                    <button class="close" data-close="alert"></button>

                    <span id="alarm_error_modal"></span>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="control-label col-md-4">
                                ผู้รับผิดชอบ
                                <span class="font-red">*</span>
                                :
                            </label>
                            <div class="col-md-5">
                                <select class="form-control input-sm selectModal" name="assignUserIdPop"
                                        id="assignUserIdPop">
                                    <option value="" >กรุณาเลือก</option>

                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="control-label col-md-4">
                                งานที่กำลังดำเนินการอยู่ :
                            </label>
                            <div class="col-md-5">
                                <input type="text" class="form-control input-sm text-right"
                                       name="working" id="working" value="${working}" readonly></input>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="control-label col-md-4">
                                วันที่มอบหมายงาน
                                <span class="font-red">*</span>
                                :
                            </label>
                            <div class="col-md-5">
                                <div class="input-group date date-picker date-modal">
                                    <input type="text" class="form-control form-filter input-sm date-mask"
                                           name="assignDate" id="assignDate" value="${assignDate}"></input>

                                    <span class="input-group-btn">
                                                    <button class="btn btn-sm date" type="button" id="bAssignDate">
                                                        <i class="fa fa-calendar"></i>
                                                    </button></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="text-center">
                    <button type="button" class="btn btn-ed save" id="bSave" name="bSave">
                        <i class="fa fa-save"></i>
                        บันทึก
                    </button>

                    <button type="button" class="btn btn-ed clear" id="bClearPop" name="bClearPop">
                        <i class="fa fa-refresh"></i>
                        ล้างข้อมูล
                    </button>

                    <button type="button" data-dismiss="modal" class="btn btn-ed exit" id="bExitPop"
                            name="bExitPop">
                        <i class="fa fa-close"></i>
                        จบการทำงาน
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>


