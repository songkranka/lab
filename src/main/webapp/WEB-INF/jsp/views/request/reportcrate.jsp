<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><span id="reportTopic">การออกใบปะหน้าลัง</span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight"  style="padding-bottom: 0px;">

    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>การออกใบปะหน้าลัง</h5>
                    <div class="ibox-tools">
                        <div class="ibox-content">

                            <div class="row">
                           		<div class="col-sm-3">
                                 
                                </div>
                                 <div class="col-sm-4">
                                    <div class="form-group" style="text-align: left">
                                        <label>ผลิตภัณฑ์</label>
                                        <div class='input-group date' id=''>
                                           <select class="form-control select5Inp" id="ddlProduct" data-live-search="true"> 
									  		<option value="-">-</option>
									  	 </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group" style="text-align: left">
                                        <label>ประเภทตัวอย่าง</label>
                                        <div class='input-group date' id=''>
                                           <select class="form-control select5Inp" id="ddlSampleType" data-live-search="true"> 
									  		<option value="-">-</option>
									  	 </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                           		<div class="col-sm-6">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-2">
                                    <button type="button" class="btn btn-primary seatchTypeComp" onclick="exportReportCrate()">Export</button>
                                    
                                </div>
                            </div>
                             
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</div>
		<div class="col-xs-12">
			<button type="button" class="btn btn-danger center-block "  style="width: 150px;" onclick="gotoMain()()">ย้อนกลับ
	    	</button>		
		</div>	


