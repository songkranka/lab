<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- <div class="box box-success box-solid"> -->
<script type='text/javascript'>
    $(document).ready(function () {
        $("#BB").click(function(){//กำหนดผู้รับผิดชอบ
            bootbox.confirm("นี่เป็นหน้าต่าง Modal สำหรับทดสอบ ท่านต้องการเปิดหน้าต่างดูใช่หรือไม่", function(ret2) {
                $('#approveModal').modal('show');
            });

        });
    });
</script>
    <div class="page-content">
                                <div class="container">

	                       <ul class="page-breadcrumb breadcrumb">
                                        <li>
                                            <a href="welcome">Home</a>
                                            <i class="fa fa-circle"></i>
                                        </li>
                                        <li>
                                            <span>Modul1</span>
                                        </li>
                                    </ul>
	<div class="page-content-inner">
    	<div class="mt-content-body">
			<h6> HOME PAGE  ${user.user}</h6>

		</div>
        <button type="button"  id="BB" name="BB">

            Call modal
        </button>
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
	</div>
