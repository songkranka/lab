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
        <h2><span id="reportTopic">รายงาน Main Lab</span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight"  style="padding-bottom: 0px;">

    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>ระบุสาเหตุรายงาน</h5>
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
                                        <label>ผลิตภัณฑ์</label>
                                      <select class="form-control select5Inp" id="nonProduct" > 
										 
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
                                      <select class="form-control select5Inp" id="nonSampleType" > 
										
										  </select>
                                    </div>
                                </div>
                            </div>
                            <br>
                            
                            <div class="row">
                           		<div class="col-sm-7">
                                    <jsp:text/>
                                </div>
                                 <div class="col-sm-2">
                                    <button type="button" class="btn btn-primary seatchTypeComp" onclick="ajaxGetDataReportLTR()">ค้นหา</button>
                                    
                                </div>
                            </div>
                            
                            <br>
                            <br>
                            <br>
                            <div class="table-responsive"   >
								<table   id="conditiontb" class="table table-striped table-bordered" style="padding: 0px;width: 100%">
							<thead>
								<tr class="tbHeader">
									<th class="text-center">NO</th>
									<th class="text-center">RootCause</th>
									<th class="text-center">Remark</th>
									<th class="text-center">Lab Code.</th>
									<th class="text-center">Req No.</th>
									<th class="text-center">Referance</th>
									<th class="text-center">Sampling Date</th>
									<th class="text-center">Receive Date</th>
									<th class="text-center">Product</th>
									<th class="text-center">Report Date</th>
									<th class="text-center">To</th>
									<th class="text-center">แก้ไข</th>
						</tr>
					</thead>
					<tbody id="conditiondt">
					</tbody>
				</table> 
			</div>
                             
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
		<div class="col-xs-12">
			<button type="button" class="btn btn-danger center-block "  style="width: 150px;" onclick="gotoLTR()">กลับสู่รายงาน LTR<i class="fa fa-reply" style="font-size:22px;color:orange"></i>
	    	</button>		
		</div>	
<div id="modalcondition" class="modal fade" role="dialog">
  <div class="modal-dialog center-modal" style="width: 50%;height: 43%;margin-left: 25%;" id="setup_modal">
    <div class="modal-content">
      <div class="modal-header" style="background-color: #1ab394;">
        <h4 class="modal-title text-white ch_txt">แก้ไขรายงาน</h4>
      </div>
      <div class="modal-body">
      	
       	<div class="row">
       		<div class="col-sm-6"><div class="form-group"><label>LAB CODE</label><input class="form-control " readonly="readonly"  type="text" id="labcode_m"  value="" ></div></div>
			<div class="col-sm-6"><div class="form-group"><label>REQ NO.</label><input class="form-control "  readonly="readonly" type="text" id="reqno_m"  value="" ></div></div>
       		<div class="col-sm-6"><div class="form-group"><label>RECEIVE DATE</label><input class="form-control " readonly="readonly"   type="text" id="receivedate_m" value="" ></div></div>
       		<div class="col-sm-6"><div class="form-group"><label>PRODUCT</label><input class="form-control " readonly="readonly"   type="text" id="product_m"  value="" ></div></div>
       		<div class="col-sm-6"><div class="form-group"><label>ROOTCAUSE</label><select class="form-control"  id="rootcause_m" name="rootcause_m" ></select></div></div>
       		<div class="col-sm-6" style="display: none;" id="divother"><div class="form-group"><label>Other</label><input class="form-control " type="text" id="other_m"  value="" ></div></div>
       	</div>
       	<div class="row">
       		
       		<div class="col-sm-6 text-center" ><input class="btn btn-success" id="submit_rootcause" type="button" value="บันทึก" ></div>
       		<div class="col-sm-6 text-center" ><input class="btn btn-danger" id="cancel_rootcause" type="button" value="ยกเลิก" data-dismiss="modal"></div>
       	</div>
       
      </div>

    </div>

  </div>
</div>

