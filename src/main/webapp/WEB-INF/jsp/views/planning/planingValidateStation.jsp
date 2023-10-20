<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
    .tbHeader {
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

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>วางแผนตรวจสถานี</h2>
    </div>
    <div class="col-lg-2"></div>
</div>

<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <div class="row">


                        <div class="col-xs-12">
                            <div class="col-sm-12">
                                <div class="col-xs-12 text-right">
                                    <button class="btn btn-primary" onclick="createPlaning()">
                                        เพิ่มรายการ
                                    </button>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <table id="myTablePlaning" class="table table-striped table-bordered"
                                       style="width: 100%;" role="grid" aria-describedby="tableApproverTask_info">
                                    <thead>
                                    <tr class="tbHeader">
                                        <th class="text-center" style="width: 35px">ลำดับ</th>
                                        <th class="text-center" style="width: 90px;">เลขที่ทริป</th>
                                        <th class="text-center" style="width: 350px;">ชื่อทริป</th>
                                        <th class="text-center" style="width: 90px;">สภานะ</th>
                                        <th class="text-center" style="width: 50px">จำนวนสถานี</th>
                                        <th class="text-center" style="width: 200px;">คนทำรายการ</th>
                                        <th class="text-center" style="width: 68px">วันที่ทำรายการ</th>
                                    </tr>
                                    </thead>
                                    <tbody id=dteId></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
 
 
  
 
