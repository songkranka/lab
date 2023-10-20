<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet" /> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script> -->

<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><span id="reportTopic">รายงานการสุ่ม</span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight"  style="padding-bottom: 0px;">

    <div class="row">
            <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                   <div class="row">
                        <div class="col-xs-6"><h5>รายงานการสุ่มรอบ 1</h5></div>
            
                    </div>
                    <div class="ibox-tools">
                        <div class="ibox-content">

                            <div class="row">
                           		<div class="col-sm-3">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-3">
                                    <div class="form-group" style="text-align: left">
                                        <label>วันที่</label>
                                        <div class='input-group date' id='randate1'>
                                            <input type='text' id="sdate1" class="form-control" />
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3">
								<div class="form-group" style="text-align: left">
                                        <label>รอบ</label>
                                            <div  class="form-group">
                                          	<select class="form-control" id="round">
                                          	<option value="M">รอบเช้า</option>
                                          	<option value="A">รอบบ่าย</option>
                                          	</select>
                                        </div>
                                
                                    </div>
                                </div>
                            </div>                         
                            <div class="row">
                           		<div class="col-sm-7">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-2">
                                    <button type="button" class="btn btn-primary seatchTypeComp" onclick="exportReportBefore()">Export</button>
                                    
                                </div>
                            </div>
                             
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                   <div class="row">
                        <div class="col-xs-6"><h5>รายงานการสุ่มรอบ 2</h5></div>
            
                    </div>
                    <div class="ibox-tools">
                        <div class="ibox-content">

                            <div class="row">
                           		<div class="col-sm-3">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-3">
                                    <div class="form-group" style="text-align: left">
                                        <label>วันที่</label>
                                        <div class='input-group date' id='randate3'>
                                            <input type='text' id="sdate3" class="form-control" />
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3">

                                </div>
                            </div>                         
                            <div class="row">
                           		<div class="col-sm-7">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-2">
                                    <button type="button" class="btn btn-primary seatchTypeComp" onclick="exportReport()">Export</button>
                                    
                                </div>
                            </div>
                             
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
