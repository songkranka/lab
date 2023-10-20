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
        <h2>จัดการข้อมูล Master</h2>
       
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
									<div class="col-xs-3">
										<form action="/Lab/manageDataVisual">
										<button type="submit" class="btn btn-primary center-block"  >จัดการข้อมูล Visual</button>
										</form>
									</div>
									<div class="col-xs-3">
										<form action="/Lab/manageDataColor">
										<button type="submit" class="btn btn-primary center-block"  >จัดการข้อมูล Color</button>
										</form>
									</div>
									<div class="col-xs-3">
									
									</div>
									<div class="col-xs-3">
									
									</div>
		                        </div>
		                    </div>
               </div>
            </div> 
        </div>
    </div> 
	  <div class="form-group">
	      
	        <div class="col-sm-12">
	            <div class="col-sm-12">
		            <button type="button"
		                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()" 
		            >กลับไปหน้าหลัก&nbsp;
		                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
		            </button>
		       </div>
	        </div>
	        <!-- /.col -->
	 </div>

  </div>
  

 
 
  
 
