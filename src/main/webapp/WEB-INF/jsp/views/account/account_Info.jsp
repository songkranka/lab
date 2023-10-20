<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <div class="box box-success box-solid"> -->
<script type='text/javascript'>
    $(document).ready(function () {
       /* $("#BB").click(function(){//กำหนดผู้รับผิดชอบ
            bootbox.confirm("นี่เป็นหน้าต่าง Modal สำหรับทดสอบ ท่านต้องการเปิดหน้าต่างดูใช่หรือไม่", function(ret2) {
                $('#approveModal').modal('show');
            });

        });*/
        
    });
    function openRandomOilPopup(){
 	   $('#popup_user').modal('show');
     }
    function report(){
    	var ctx = "${pageContext.request.contextPath}";
    	var link = ctx+"/reportHome";
    	// 		window.location.href = link;
    			window.open(link, '_blank');
    }
</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>หน้าจอตัวอย่างเพื่อทดสอบโปรเจค Lab</h2>
        <ol class="breadcrumb">
            <li><a href="pt_home.html">หน้าหลัก</a></li>
            <li><a>หน้าจอตัวอย่างเพื่อทดสอบโปรเจคแลป</a></li>
            <li><a href="pt_setup_audit_plan.html">ใช้เพื่อให้สามารถ coppy class ไป ใช้งานในหน้าต่างๆ</a>
            </li>
            <li class="active"><a href="pt_setup_audit_plan_edit.html"><strong>ตัวอย่างอื่นๆ</strong></a>
            </li>
        </ol>
    </div>
    <div class="col-lg-2"></div>
</div>


<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <form name="formHidden" method="post" action="">
                    <input type="hidden" id="msgAlert" name="msgAlert" value="{msg}" />

                    </form>
                    <h5>(Example)ตัวอย่าง form สำหรับกรอกข้อมูลทั่วไป test Connect DB-obj--> = {retFromDB.codEmpId} - {retFromDB.namEmpt}</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link"> <i class="fa fa-chevron-up"></i>
                        </a>

                    </div>
                </div>
                <div class="ibox-content">
                    <form method="get" class="form-horizontal">
                        <div class="row">
                            <div class="form-group col-md-12">
                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">ปี</label>
                                    <div class="col-xs-12 col-md-8">
                                        <input type="text" class="form-control" ng-disabled="true"
                                               ng-model="header.YEAR">
                                    </div>
                                </div>

                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">เดือน</label>
                                    <div class="col-xs-12 col-md-8">
                                        <input type="text" class="form-control" ng-disabled="true"
                                               ng-model="header.MONTHSTR">
                                    </div>
                                </div>
                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">วันที่</label>
                                    <div class="col-xs-12 col-md-8">
                                        <input type="text" class="form-control" ng-disabled="true"
                                               ng-model="header.PERIOD_DATE">
                                    </div>
                                </div>

                            </div>
                            <div class="form-group col-md-12">

                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">Example Code</label>
                                    <div class="col-xs-12 col-md-8">
                                        <input type="text" class="form-control" ng-disabled="true"
                                               ng-model="header.PLNREFCODE">
                                    </div>
                                </div>

                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">หมายเหตุ</label>
                                    <div class="col-xs-12 col-md-8">
                                        <input type="text" class="form-control" ng-disabled="true"
                                               ng-model="header.TMCODE">
                                    </div>
                                </div>
                                <div class="col-md-4 no-padding"></div>

                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>(Example2)ตัวอย่าง form2 สำหรับกรอกข้อมูลทั่วไปแบบที่สอง</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link"> <i class="fa fa-chevron-up"></i>
                        </a>

                    </div>
                </div>
                <div class="ibox-content">
                    <form method="get" class="form-horizontal">
                        <div class="row">
                            <div class="form-group col-md-12">
                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">รหัส</label>
                                    <div class="col-xs-12 col-md-8">
                                        <input type="text" class="form-control" ng-disabled="true"
                                               ng-model="header.BRCODE">
                                    </div>
                                </div>

                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">ชื่อ-สกุล</label>
                                    <div class="col-xs-12 col-md-8">
                                        <input type="text" class="form-control" ng-disabled="true"
                                               ng-model="header.BRNAME">
                                    </div>
                                </div>
                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label"></label>
                                    <div class="col-xs-12 col-md-8">
                                        <button class="btn btn-w-m btn-primary" type="button" id="bottomform2B1"
                                                >กดเพื่อแสดง BootsBox confirm</button>
                                    </div>
                                </div>

                            </div>

                            <div class="form-group col-md-12">

                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">ศาสนา</label>
                                    <div class="col-xs-12 col-md-8">
                                        <input type="text" class="form-control" >
                                    </div>
                                </div>

                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">เพศ</label>
                                    <div class="col-xs-12 col-md-8">
                                        <div class="col-xs-6 col-md-2">
                                            <input type="radio" checked="checked"  name="rdoResult" >
                                            <i></i> ชาย
                                        </div>
                                        <div class="col-xs-6 col-md-4">
                                            <input type="radio" name="rdoResult" > <i></i>
                                            หญิง
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-4 no-padding">
                                    <label class="col-xs-6 col-md-4 control-label">หมายเหตุ</label>
                                    <div class="col-xs-12 col-md-8">
                                        <input type="text" class="form-control" ng-disabled="true"
                                               ng-model="header.NUMBER">
                                    </div>
                                </div>


                            </div>
                            <div class="col-md-12 no-padding">
                                <label class="col-xs-6 col-md-2 control-label">ค่าจาก modal</label>
                                <div class="col-xs-12 col-md-6">
                                    <input type="text" class="form-control"
                                           ng-model="header.PLN_REMARK">
                                </div>
                                <div class="col-xs-12 col-md-2">
                                    <button class="btn btn-w-m btn-primary" type="button" id="bottomform2B2"
                                            >click show modal(open window)</button>
                                </div>

                            </div>
                        </div>
                    </form>
                </div>
            </div>


        </div>

    </div>
    <div class="row">

        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>สมาชิกในทีม PTG LAB</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link"> <i class="fa fa-chevron-up"></i>
                        </a>

                    </div>
                </div>
                <div class="ibox-content">
                    <div class="table-responsive">
                        <table id="tableMember"
                               class="table table-striped table-bordered table-hover dataTables-example">
                            <thead>
                            <tr>
                                <th>รหัสพนักงาน</th>
                                <th>ชื่อ-นามสกุล</th>
                                <th>การลา</th>
                                <th>หมายเหตุอื่นๆ</th>
                                <th>วัน-เวลา แก้ไข</th>
                            </tr>
                            </thead>
                            <tbody>

                            <td>000001</td>
                            <td>testname</td>
                            <td>-</td>
                            <td>อื่นๆ</td>
                            <td>20 กย. - 25 กย. 2561</td>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <button type="button" id="loginbotttom3" onclick="openRandomOilPopup()"
                               >เพิ่มรายชื่อ</div>
                        </div>
                    </div>


                </div>
            </div>


        </div>

    </div>

    <%--<div class="row">--%>
        <%--<div class="col-lg-12">--%>
            <%--<div class="ibox float-e-margins">--%>
                <%--<div class="ibox-title">--%>
                    <%--<h5>บันทึกผลการตรวจสอบ</h5>--%>
                    <%--<div class="ibox-tools">--%>
                        <%--<a class="collapse-link"> <i class="fa fa-chevron-up"></i>--%>
                        <%--</a>--%>

                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="ibox-content">--%>
                    <%--<form method="get" class="form-horizontal">--%>
                        <%--<div class="row">--%>
                            <%--<div class="form-group col-md-12">--%>
                                <%--<div class="col-md-6 no-padding">--%>
                                    <%--<label class="col-xs-6 col-md-4 control-label">สถานะรายการ</label>--%>
                                    <%--<div class="col-xs-12 col-md-8">--%>
                                        <%--<select class="form-control m-b" ng-entity="selectedStatus"--%>
                                                <%--ng-options="item.CAPTION for item in cmbStatus track by item.VALUE">--%>
                                        <%--</select>--%>
                                    <%--</div>--%>

                                <%--</div>--%>

                                <%--<div class="col-md-6">--%>
                                    <%--<label class="col-xs-6 col-md-4 control-label">ประเภทหมายเหตุ</label>--%>
                                    <%--<div class="col-xs-12 col-md-8">--%>
                                        <%--<select class="form-control m-b" ng-entity="selectedRemarkType"--%>
                                                <%--ng-options="item.CAPTION for item in cmbRemarkType track by item.VALUE">--%>
                                        <%--</select>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>


                        <%--</div>--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-md-12 no-padding">--%>
                                <%--<label class="col-xs-6 col-md-2 control-label">บันทึกหมายเหตุ</label>--%>
                                <%--<div class="col-xs-12 col-md-10">--%>
                                    <%--<textarea row="5" class="form-control" ng-entity="header.SAVE_REMARK">{{header.SAVE_REMARK}}</textarea>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="row" style="margin-top: 15px;">--%>
                            <%--<div class="col-md-12 ">--%>
                                <%--<div class="col-md-8 col-xs-12"></div>--%>
                                <%--<div class="col-md-4 col-xs-12">--%>
                                    <%--<div class="col-md-12 col-xs-12">--%>
                                        <%--<button class="btn btn-w-m btn-primary" type="submit" ng-click="Back()"--%>
                                                <%--ng-click="">บันทึก</button>--%>

                                        <%--<button class="btn btn-w-m btn-primary" type="submit" ng-click="Back()"--%>
                                                <%--ng-click="">ยกเลิก</button>--%>
                                    <%--</div>--%>
                                <%--</div>--%>

                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="row"></div>--%>
                <%--</div>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>


    <%--</div>--%>
    <%--<div class="row">--%>
        <%--<div class="col-lg-12">--%>
            <%--<div class="ibox float-e-margins">--%>
                <%--<div class="ibox-title">--%>
                    <%--<h5>ประวัติการแก้ไข</h5>--%>
                    <%--<div class="ibox-tools">--%>
                        <%--<a class="collapse-link"> <i class="fa fa-chevron-up"></i>--%>
                        <%--</a>--%>

                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="ibox-content">--%>
                    <%--<div class="table-responsive">--%>
                        <%--<table id="table"--%>
                               <%--class="table table-striped table-bordered table-hover dataTables-example">--%>
                            <%--<thead>--%>
                            <%--<tr>--%>
                                <%--<th>สถานะ</th>--%>
                                <%--<th>รายการ</th>--%>
                                <%--<th>ดำเนินการโดย</th>--%>
                                <%--<th>รายละเอียด</th>--%>
                                <%--<th>วัน-เวลา</th>--%>
                            <%--</tr>--%>
                            <%--</thead>--%>
                        <%--</table>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>


        <%--</div>--%>

    <%--</div>--%>

<%--</div>--%>

<div id="popup_branch" class="modal fade scale-up center-screen"
     data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog ">
        <div class="modal-content-wrapper">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">ค้นหาสาขา</h4>
                </div>
                <div class="modal-body ptn pbs">
                    <div class="row">
                        <div class="col-xs-12">
                            <form class="form-horizontal">
                                <div class="form-group form-group-default">
                                    <div class="col-xs-12">
                                        <div class="col-sm-6">
                                            <div class="col-sm-4">
                                                <label>รหัสสาขา</label>
                                            </div>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control"
                                                       ng-model="pickerParam.BRCODE">
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="col-sm-4">
                                                <label>ชื่อสาขา</label>
                                            </div>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control"
                                                       ng-model="pickerParam.BRNAME">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="col-sm-6">
                                            <div class="col-sm-4">
                                                <label>เขต</label>
                                            </div>
                                            <div class="col-sm-8">
                                                <select class="form-control m-b" ng-model="selectedCmbDistinct"
                                                        ng-options="item.CAPTION for item in pickerCmbDistinct track by item.VALUE">
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="col-sm-4">
                                                <label>ภาค</label>
                                            </div>
                                            <div class="col-sm-8">
                                                <select class="form-control m-b" ng-model="selectedCmbZone"
                                                        ng-options="item.CAPTION for item in pickerCmbZone track by item.VALUE">
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="col-sm-6">
                                            <div class="col-sm-4">
                                                <label>จังหวัด</label>
                                            </div>
                                            <div class="col-sm-8">
                                                <select class="form-control m-b" ng-model="selectedCmbProvince"
                                                        ng-options="item.CAPTION for item in pickerCmbProvince track by item.VALUE">
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="col-sm-4">
                                                <label>ธุรกิจ</label>
                                            </div>
                                            <div class="col-sm-8">
                                                <select class="form-control m-b" ng-model="selectedCmbBusiness"
                                                        ng-options="item.CAPTION for item in pickerCmbBusiness track by item.VALUE">
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-12">
                                        <div class="col-sm-12">
                                            <div class="col-xs-12 text-right">
                                                <button class="btn btn-primary" ng-click="inquiryClick()">
                                                    <i class="fa fa-search"></i>&nbsp;ค้นหา
                                                </button>

                                            </div>
                                        </div>

                                    </div>

                                </div>

                            </form>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div
                                    class="table-wrapper table-container table-responsive table-scroller">
                                <table id="tb_popup_branch"
                                       class="table table-striped table-bordered table-hover dataTables-example">
                                    <thead>
                                    <tr>
                                        <th class="text-center"></th>
                                        <th class="text-center">ธุรกิจ</th>
                                        <th class="text-center">รหัสสาขา</th>
                                        <th class="text-center">ชื่อสาขา</th>
                                        <th class="text-center">วันที่ตรวจ</th>
                                        <th class="text-center">F</th>
                                        <th class="text-center">C</th>
                                        <th class="text-center">เขต</th>
                                        <th class="text-center">ภาค</th>
                                        <th class="text-center">จังหวัด</th>
                                    </tr>
                                    </thead>
                                    <tbody></tbody>
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
<div id="popup_user" class="modal fade scale-up center-screen" data-keyboard="false" data-backdrop="static">
    <div class="modal-dialog ">
        <div class="modal-content-wrapper">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title">ค้นหาชื่อพนักงาน</h4>
                </div>
                <div class="modal-body ptn pbs">
                    <div class="row">
                        <div class="col-xs-12">
                            <form class="form-horizontal">
                                <div class="form-group form-group-default">
                                    <div class="col-xs-8">
                                        <div class="col-sm-4">
                                            <label>รหัสพนักงาน</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" ng-model="pickerParam.usr_id">
                                        </div>
                                    </div>
                                    <div class="col-xs-4 text-right">
                                        <button class="btn btn-default" ng-click="inquiryClickUser()">
                                            <i class="fa fa-search"></i>&nbsp;ค้นหา
                                        </button>

                                    </div>
                                </div>
                                <div class="form-group form-group-default">
                                    <div class="col-xs-8">
                                        <div class="col-sm-4">
                                            <label >ชื่อ-นามสกุล</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control" ng-model="pickerParam.usr_name">
                                        </div>

                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-wrapper table-container table-responsive table-scroller">
                                <table id="tb_popup_user" class="table table-striped table-bordered table-hover dataTables-example">
                                    <thead>
                                    <tr>
                                        <th class="text-center"></th>
                                        <th class="text-center">รหัสพนักงาน</th>
                                        <th class="text-center">ชื่อ-นามสกุล</th>
                                        <th class="text-center">ตำแหน่ง</th>
                                        <th class="text-center">หน่วยงาน</th>
                                    </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
</div>
    <div class="row">
        <div class="col-xs-3">
            <div >
                <button type="button" id="loginbotttom3" onclick="report()"
                        class="btn btn-success center-block">
                    พิมพ์ใบ &nbsp <i class="fa fa-print" style="font-size:22px;color:white"></i>&nbsp WHT</button>
            </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-3">
            <center><button type="button" id="loginbotttom4"
                            class="btn btn-warning center-block">
                ขออนุมัติ
                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button></center>
        </div>
        <div class="col-xs-3">
            <button type="button"
                    class="btn btn-success center-block"  >บันทึก&nbsp
                <i class="fa fa-save"  style="font-size:22px;color:blue"></i>
            </button>
        </div>
        <div class="col-xs-3">
            <button type="button"
                    class="btn btn-danger center-block"  onclick="loginbottom5()"
            >กลับไปหน้าหลัก&nbsp
                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
            </button>
        </div>
        <!-- /.col -->
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div class="table-wrapper table-container table-responsive table-scroller">
                <table id="tb_popup_user2" class="table table-striped table-bordered table-hover dataTables-example">
                    <thead>
                    <tr>
                        <th class="text-center"></th>
                        <th class="text-center">A</th>
                        <th class="text-center">B</th>
                        <th class="text-center">C</th>
                        <th class="text-center">D</th>
                        <th class="text-center">F</th>

                    </tr>
                    </thead>
                    <tbody>


                    </tbody>
                </table>
            </div>
        </div>
    </div>

<div id="approveModal" class="modal fade bs-example-modal-lg" tabindex="-1"  role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content" id="blockUi_data">
            <div class="modal-header">
                <h4 class="modal-title">หน้าต่างทดสอบ Modal</h4>
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
                                ตำแหน่ง
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
                <br>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="control-label col-md-4">
                                ID :
                            </label>
                            <div class="col-md-5">
                                <input type="text" class="form-control input-sm text-right"
                                       name="working" id="working" value="${working}" readonly></input>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label class="control-label col-md-4">
                                Date Used
                                <span class="font-red">*</span>
                                :
                            </label>
                            <div class="col-md-5">
                                <div class="input-group date date-picker date-modal">
                                    <input type="text" class="form-control form-filter input-sm date-mask"
                                           name="assignDate" id="assignDate" value="${assignDate}"></input>

                                    <%--<span class="input-group-btn">--%>
                                                    <%--<button class="btn btn-sm date" type="button" id="bAssignDate">--%>
                                                        <%--<i class="fa fa-calendar"></i>--%>
                                                    <%--</button></span>--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <div class="d-inline">


                    <button type="button" data-dismiss="modal" class="btn btn-ed exit" id="bExitPop"
                            name="bExitPop">

                        Exit
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

