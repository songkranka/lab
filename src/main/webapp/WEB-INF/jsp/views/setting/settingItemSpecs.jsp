<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath}/assets/select2/select2.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>
<style>
    .tbHeader {
        font-size:  9px;
        background: #3c8dbc;
        color: white;
    }
    .TBODY{
        font-size:  10px;
    }
    .modal{
        width: 1000px;
        margin: auto;
    }
    .modal-body{
        /*top: 90px;*/
        bottom: 70px
    }

</style>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-xs-12">
        <h2>Setting Item Specs</h2>
    </div>
    <div class="col-xs-12"><p></p></div>
    <div class="col-xs-12"><p></p></div>
    <div class="col-xs-12"><p></p></div>
    <div class="col-xs-12">
            <form>
                <div class="form-group">
                    <div class="col-sm-3">
                        <label>ผลิตภัณฑ์</label><br/>
                        <select id="ddlProduct"></select>
                    </div>
                    <div class="col-sm-2">
                        <label>ประเภทตัวอย่าง</label><br/>
                        <select id="ddlSampleType"></select>
                    </div>

                </div>

            </form>
    </div>
    <div class="col-xs-12">
        <form>
            <div class="form-group">
            <div class="col-sm-3">
              <label>จำนวน Item</label><br/>
                    <input   class="custom-text-horizon-rangdate2" style="text-align: right" maxlength="2" id="totalId">
                    </br>
                      </br>
                <button class="btn btn-info"  type="button" onclick="renderItemSpec()"><i class="fa fa-plus"></i>&nbsp;สร้าง</button>
                <button class="btn btn-primary"  type="button" onclick="insertItemSpec()"><i class="fa fa-save"></i>&nbsp;บันทึก</button>
            </div>
                  
            </div>
            <div class="form-group">
              <div class="col-sm-3">

              </div>
            </div>
        </form>
    </div>
</div>

<div class="wrapper wrapper-content animated fadeInRight" id="bodyTemplate">

</div>

