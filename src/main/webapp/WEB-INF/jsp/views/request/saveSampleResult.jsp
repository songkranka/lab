<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Select2 -->
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.29.2/sweetalert2.all.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/autonumeric/4.1.0/autoNumeric.min.js"></script>

<!-- <div class="box box-success box-solid"> -->
<style>
    .tbHeader {
        font-size: 9px;
        background: #3c8dbc;
        color: white;
    }
    .TBODY {
        font-size: 10px;
    }
    .dtr-details {
        font-size: 10px;
    }
</style>
<script >
/***  Declare Initial Received from 'Reminding Page'  ***/


</script>

<div class="row wrapper border-bottom white-bg page-heading">
   <div class="col-lg-10">
      <h2>บันทึกข้อมูลตัวอย่าง</h2>
   </div>
   <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
   <div class="row">
      <div class="col-lg-12">
         <div class="ibox float-e-margins">
            <div class="ibox-content">
               <div class="row" id="idBodyBox">
                     <div class="col-sm-12" id="idBodyBox2">

                     </div>
               </div>
               <div class="row">
                  <div class="col-md-12">&nbsp;
                  </div>
               </div>
               <div class="col-xs-12">
                  <div class="col-sm-12">
                    
                     <div class="col-sm-12 text-right">
                        <button class="btn btn-primary" onclick="saveRandomOil()">
                        ยืนยัน
                        </button>
                     </div>
                  </div>
               </div>
                          
               <div class="row">
                  <div class="col-md-12">&nbsp;
                  </div>
                  <div class="show-c-car" >
                     <h4><label>รายการที่บันทึก</label></h4>
                     <table   id="myTableDataHistory" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
                        <thead  class="tbHeader">
                           <tr>
                              <th class="text-center">คลัง</th>
                              <th class="text-center">แหล่งที่มา</th>
                              <th class="text-center">ผลิตภัณฑ์</th>
                              <th class="text-center">ลักษณะเก็บตัวอย่าง</th>
                              <th class="text-center">ประเภทการเก็บตัวอย่าง</th>
                              <th class="text-center">ขนส่ง</th>
                              <th class="text-center">วันที่เก็บตัวอย่าง</th>
                              <th class="text-center">รายละเอียดการเข้าเก็บ</th>
                           </tr>
                        </thead>
                        <tbody id="dataHistory">
                        </tbody>
                     </table>
                  </div>
                  <div class="col-sm-12">
                     <p></p>
                      <div class="col-sm-12 text-right">
                        <button class="btn btn-primary" onclick="window.location.href='/Lab/requestValidate'" >
                        สร้างใบคำขอวิเคราะห์
                        </button>
                     </div>
                  </div>
               </div>
               
               <div class="row">
                  <div class="col-md-12">&nbsp;
                  </div>
                  <div class="show-c-car" >
                     <h4><label>รายการที่ส่งใบคำขอวิเคราะห์แล้ว</label></h4>
                     <table   id="myTableDataHistorySent" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
                        <thead  class="tbHeader">
                           <tr>
                              <th class="text-center">คลัง</th>
                              <th class="text-center">แหล่งที่มา</th>
                              <th class="text-center">ผลิตภัณฑ์</th>
                              <th class="text-center">ลักษณะเก็บตัวอย่าง</th>
                              <th class="text-center">ประเภทการเก็บตัวอย่าง</th>
                              <th class="text-center">ขนส่ง</th>
                              <th class="text-center">วันที่เก็บตัวอย่าง</th>
                              <th class="text-center">รายละเอียดการเข้าเก็บ</th>
                           </tr>
                        </thead>
                        <tbody id="dataHistorySent">
                        </tbody>
                     </table>
                  </div>
                  <div class="col-sm-12">
                     <p></p>
                  </div>
               </div>
               
                <div class="row">
                  <div class="col-md-12">&nbsp;
                  </div>
                  <div class="show-c-car" >
                     <h4><label>รายการที่ยกเลิก</label></h4>
                     <table   id="myTableDataHistoryCancel" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
                        <thead  class="tbHeader">
                           <tr>
                              <th class="text-center">คลัง</th>
                              <th class="text-center">แหล่งที่มา</th>
                              <th class="text-center">ผลิตภัณฑ์</th>
                              <th class="text-center">ลักษณะเก็บตัวอย่าง</th>
                              <th class="text-center">ประเภทการเก็บตัวอย่าง</th>
                              <th class="text-center">ขนส่ง</th>
                              <th class="text-center">วันที่เก็บตัวอย่าง</th>
                              <th class="text-center">รายละเอียดการเข้าเก็บ</th>
                           </tr>
                        </thead>
                        <tbody id="dataHistoryCancel">
                        </tbody>
                     </table>
                  </div>
                  <div class="col-sm-12">
                     <p></p>
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


 
  
 
