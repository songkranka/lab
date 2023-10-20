<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
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
.right{
	 text-align: right;
}
</style>
<script type='text/javascript'>


</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>สุ่มการเก็บตัวอย่าง(LAB Officer)</h2>

    </div>
    <div class="col-lg-2"></div>
</div>

<div class="wrapper wrapper-content animated fadeInRight">

        <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title"><h5>เงื่อนไขการสุ่ม</h5>
                     <!--  button type="button" id="loginbotttom3" onclick="saveRandomOil() "
	                        class="btn btn-success left-block">เพิ่มรายสุ่ม</button> -->
                </div>
                <div class="ibox-content">
                        <div class="row">
                        <div class="col-sm-12 right">
                        	<input id="switchRandom" type="checkbox" data-toggle="toggle" data-size="small">
                        </div>
                                <div class="col-xs-12">
	                                        <div class="col-sm-6">
	                                            <div class="col-sm-4">
	                                                <label>คลัง</label>
	                                            </div>
	                                            <div class="col-sm-8">
	                                                <select class="multiselect"      multiple="multiple"  id="ddlStore" >
	                                                </select>
	                                            </div>
	                                        </div>
	                                        <div class="col-sm-6">
	                                            <div class="col-sm-4">
	                                                <label>ผลิตภัณฑ์</label>
	                                            </div>
	                                            <div class="col-sm-8">
	                                                  <select class="multiselect" multiple="multiple"  id="ddlProduct" >
	                                                </select>
	                                            </div>

	                                        </div>
	                             </div>
	                              <div class="col-xs-12">
	                                        <div class="col-sm-6">
	                                            <div class="col-sm-4">
	                                                <label>ขนส่ง</label>
	                                            </div>
	                                            <div class="col-sm-8">
	                                                <select class="multiselect" multiple="multiple"   id="ddlLogistic" >
	                                                </select>
	                                            </div>
	                                        </div>
	                                        <div class="col-sm-6">
	                                            <div class="col-sm-4">
				                                                <label>แหล่งที่มา</label>
				                                            </div>
				                                            <div class="col-sm-8">

														 <select   class="multiselect" multiple="multiple"  id="ddlSource" >
			                                                </select>

	                                            </div>
	                                        </div>
	                                    </div>

	                                    	<div class="col-xs-12">
		                                      <div class="col-sm-6">
		                                            <div class="col-sm-4">
		                                                <label>วันที่ PO</label>
		                                            </div>
		                                            <div class="col-sm-8">

															   <input type="text" class="custom-text-horizon-rangdate2"
																maxlength="10" id="poDate"
																 data-provide="datepicker">
		                                            </div>
		                                        </div>
		                                        <div class="col-sm-6">
		                                            <div class="col-sm-4">
		                                                <label>Random Percen</label>
		                                            </div>
		                                            <div class="col-sm-8">
														<input type="number" name="percenRan" class="custom-text-horizon-rangdate2" id="percenRan"/>
		                                            </div>
		                                        </div>
		                                    </div>
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
                        <div class="col-md-12">&nbsp;
                        </div>
     </div>
     <%-- <c:forEach var="teamMember" items="${Model}"> --%>
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                  <div class="ibox-title">
	                    <h5>รายการสุ่มตัวอย่าง</h5>
	                     <%-- <h5>รายการสุ่มตัวอย่าง <c:out value="${teamMember.PLANT_NAME}"/></h5> --%>
	                  <%--  <input type="hidden" name="hidden_namestore" id="hidden_namestore"  value="${teamMember.PLANT_ID}"   /> --%>

										<div class="col-xs-2">
												<select id="ddlPlant" onchange="renderDataToTable()"></select>
										</div>
										 <input type="hidden" name="hidden_namestore" id="hidden_namestore"  value=""   />
	               <!--        <div class="ibox-tools">
                          <a class="collapse-link"> <i class="fa fa-chevron-up"></i>
                        </a>

                    </div> -->
                 </div>
                 <div class="ibox-content">


                       <div class="row">
	                        <div class="col-xs-12" >
	                             <div class="table-responsive"   >
							         <%-- <table   id="myTableDteId_<c:out value="${teamMember.PLANT_ID}"/>" class="table table-striped table-bordered" style="padding: 0px;width:100%;"> --%>
							          <table   id="myTableDteId_" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
										<thead  class="tbHeader">
									<tr>
											<th class="text-center" style="width:100px">STATUS</th>
																		     <th class="text-center">LAB_CODE</th>
																	        <th class="text-center">เลขกลุ่ม<br>การสุ่ม</th>
																	         <th class="text-center">เลขที่<br>PO</th>
																	          <th class="text-center">วันที่<br>PO</th>
																	        <th class="text-center">เลขที่<br>DO</th>
																	          <th class="text-center">เลขที่<br>SHIPMENT</th>
																	        <th   class="text-center">ลำดับ</th>
																		        <th   class="text-center">ลำดับย่อย</th>
									                                        <th class="text-center">เลขที่<br>รถ</th>
									                                            <th class="text-center">ช่่อง<br>รถ</th>
									                                             <th class="text-center">เลขที่<br>เรือ</th>
									                                               <th class="text-center">ชื่อเรือ</th>
									                                            <th class="text-center">ช่่อง<br>เรือ</th>
									                                             <th class="text-center">วันที่<br>การสุ่ม</th>
									                                            <th class="text-center">วันที่<br>หมดอายุ</th>
									                                            <th class="text-center">ผลิตภัณฑ์</th>
									                                        <th class="text-center">แหล่งที่มา</th>
									                                     <th class="text-center">ระบบขนส่ง</th>
									                                          <th class="text-center">รูปแบบการเก็บ</th>
									                                     <th class="text-center">รหัสพนักงาน</th>
									                                        <th class="text-center">ชื่อพนักงาน</th>
																	</tr>
										 </thead>
										<%-- <tbody id="dteId_<c:out value="${teamMember.PLANT_ID}"/>"> --%>
										<tbody id="dteId_">
										</tbody>
									</table>
								 </div>
	                        </div>
	                    </div>

                </div>
            </div>
        </div>
    </div>
	<%--  </c:forEach> --%>
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
									                                         <th class="text-center">SOURCE </th>
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
