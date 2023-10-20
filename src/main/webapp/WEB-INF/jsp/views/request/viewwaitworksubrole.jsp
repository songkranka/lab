<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="<c:url value="/assets/css/settingTestScroll.css" />" rel="stylesheet">

<style>
.tbHeader {
	font-size:  9px;
	background: #3c8dbc;
	color: white;
}
.TBODY{
	font-size:  13px; 
}
.dtr-details{
	font-size:  10px; 
}
</style>
<!-- <div class="box box-success box-solid"> -->

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>Print ใบมอบหมายงาน</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>


<div class="wrapper wrapper-content animated fadeInRight"> 
     
    
    <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">				    
	                       <div class="row">
		                        <div class="col-xs-12" >

		                             <div class="table-responsive"   >
								         <table   id="waitworksubrole" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
											<thead  class="tbHeader">
																		<tr>
																		    <th  class="text-center"><input id="example-select-all" value="1" name="select_all" type="checkbox" onclick="selectAllNew()">&nbsp;PRINT</th>
																		    <th  class="text-center">เลขที่ใบงาน</th>
																		    <th class="text-center">LAB CODE</th>
																		    <th class="text-center">ผลิตภัณฑ์</th>
																		    <th class="text-center">ประเภทตัวอย่าง</th>
									                                        <th class="text-center">รายละเอียดตัวอย่าง</th>
									                                     <th class="text-center">วันที่เก็บตัวอย่าง</th>
																		</tr>
											 </thead>
											<tbody id="waitworksubroledt" > 
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
	      
	        <div class="col-sm-12">
	            <div class="col-sm-6">
		            <button type="button"
		                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()" 
		            >กลับไปหน้าหลัก&nbsp;
		                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
		            </button>
		       </div>
		       
		       <div class="col-sm-6">
		            <button type="button"
		                    class="btn btn-primary center-block"  style="width: 150px;" data-toggle="modal" data-target="#warning_waitwork"><i class="fa fa-print"></i>Export Report
		            </button>
		       </div>
	        </div>
	        <!-- /.col -->
	 </div>

  </div>
  <div class="modal fade" id="warning_waitwork" role="dialog">
    <div class="modal-dialog" style="width: 35%;height: 25%;margin-left: 35%;">
    
      <!-- Modal content-->
      <div class="modal-content" style="font-size: 20px">
        <div class="modal-header bg-primary" >
          <h3 class="modal-title ">แจ้งเตือน</h3>
        </div>
        <div class="modal-body text-center">
          <p style="margin-top: 10px">หลังจากกดยืนยันแล้วจะไม่สามารถออกรายการซ้ำได้ <br> ยืนยันการทำรายการหรือไม่?</p>
        </div>
        <div class="modal-footer">
         <button type="button" class="btn btn-primary" onclick="exportWaitReport()" data-dismiss="modal">ยืนยัน</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">ยกเลิก</button>
        </div>
      </div>
      
    </div>
  </div>

 
 
  
 
