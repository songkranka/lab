<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="<c:url value="/assets/css/settingTestScroll.css" />" rel="stylesheet">
<link href="<c:url value="/assets/css/workFlow.css" />" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="assets/plugins/datepicker/bootstrap-datepicker.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Sortable/1.6.0/Sortable.js"></script>
<style>

  
</style>
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-12">	
     	<h2>Work Flow</h2>
     </div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
   <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">

                <div class="ibox-content">
			    <div class="testSortable">
					<div class="row">
						<div class="col-sm-6" >	
							<ul id="tableSetup" class="connectedGroupSortable connectedGroupSortableCC center list-group">
							</ul>			        						
						</div>
						<!-- <div class="col-sm-6">
							<ul id="tableTmp" class="connectedGroupSortable connectedGroupSortableCC center list-group"></ul>
						</div> -->							
					</div>					
				</div>
			<div class="row"><p> </p></div>
			<div class="col-sm-6">
				<button type="button" class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()">
					กลับไปหน้าหลัก<i class="fa fa-reply" style="font-size:22px;color:orange"></i>
	    		</button>
			</div>
			<div class="sol-sm-6">
				<button type="button" class="btn btn-success center-block"  style="width: 150px;" onclick="saveData()">บันทึกข้อมูล
	   	 		</button>
			</div>
			<!-- <div>
						<button onclick="showData()">Show JSON</button>
						<button onclick="saveData()">Save</button>
			</div>   -->              
          	</div>
          </div>
     </div>
     
    
</div>
</div>
 <a href="#" class="list-group-item list-group-item-action"></a>

