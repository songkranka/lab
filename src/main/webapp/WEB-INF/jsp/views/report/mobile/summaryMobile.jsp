<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><span id="reportTopic"></span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">

    <div class="row">
<!--         <div class="col-lg-12"> -->
<!--             <div class="ibox float-e-margins"> -->
<!--                 <div class="ibox-title"> -->
<!--                     <h5>งานที่บันทึกผล</h5> -->
<!--                     <div class="ibox-tools"> -->
<!--                         <div class="ibox-content"> -->

<!--                             <div class="row"> -->
<!--                                 <div class="col-sm-2"> -->
<!--                                     <div class="form-group" style="text-align: left"> -->
<!--                                         <label> เลือก Trip </label> -->
<!--                                         <div class='input-group' id='tipId'> -->
<!--                                             <select id="ddlTrip" style="width: 80%;"> -->
<!--                                                 <option value="0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<!--                                                     ทั้งหมด &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option> -->
<!--                                             </select> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                                 <div class="col-sm-3"> -->
<!--                                     <div class="form-group" style="text-align: left"> -->
<!--                                         <label>วันที่</label> -->
<!--                                         <div class='input-group date' id='datetimepicker1'> -->
<!--                                             <input type='text' id="sdate" class="form-control" /> -->
<!--                                             <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                                 <div class="col-sm-3"> -->
<!--                                     <div class="form-group" style="text-align: left"> -->
<!--                                         <label>ถึง</label> -->
<!--                                         <div class='input-group date' id='datetimepicker2'> -->
<!--                                             <input type='text' id="edate" class="form-control" /> -->
<!--                                             <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                                 <div class="col-sm-3"> -->
<!--                                     <div class="form-group" style="text-align: left;"> -->
<!--                                         <label>&nbsp;</label> -->
<!--                                         <div class='input-group'> -->
<!--                                             <button type="button" class="btn btn-primary" onclick="exportPdf()">พิมพ์รายงาน</button> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </div> -->

<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>งานที่บันทึกผล</h5>
                    <div class="ibox-tools">
                        <div class="ibox-content">

                            <div class="row">
                                <div class="col-sm-2">
                                    <div class="form-group" style="text-align: left">
                                        <label> เลือก Trip </label>
                                        <div >
                                            <select id="ddlTrip" style="width: 80%;overflow: scroll !important;" class="form-control">
                                                
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group" style="text-align: left">
                                        <label>บริษัท</label>
                                        <div  class="form-group">
                                          	<select class="form-control" id="company">
                                          		
                                          	</select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3">

                                </div>
                                <div class="col-sm-3">

                                </div>

                                <div class="col-sm-1">
                                    <div class="form-group" style="text-align: left;">
                                        <label>&nbsp;</label>
                                        <div class='input-group'>
                                            <button type="button" class="btn btn-primary" onclick="exportPdf()">พิมพ์รายงาน</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


