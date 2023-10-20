<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList"  %>
<%@ page import="java.io.File"  %>
<%@ page import="java.net.URL" %>
<tiles:importAttribute name="javascripts"/>
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><tiles:getAsString name="title" /></title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport"> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/> 
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="" />
  <script src="assets/plugins/jquery/jquery-2.2.3.min.js"></script>
    <link rel="icon" href="assets/images/labIcon.ico" > 
    

      <!-- Styles -->
     <link rel="stylesheet" href="assets/plugins/font-awesome/css/font-awesome.min.css">
      <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">
   
     <link rel="stylesheet" href="assets/plugins/datatables/css/datatables.min.css">
       
        <link rel="stylesheet" href="assets/plugins/theme/css/style.css">
     
<!-- Select2 -->
	 
		<link rel="stylesheet" href="assets/plugins/bootstrap-datepicker/css/datepicker3.css"> 
	<link rel="stylesheet" href="assets/plugins/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" href="assets/plugins/colorpicker/bootstrap-colorpicker.min.css"> 
	<link rel="stylesheet" href="assets/plugins/timepicker/bootstrap-timepicker.min.css">
	<link rel="stylesheet" href="assets/plugins/Style/CustomStyle.css">
	
	
   <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap-multiselect.css"  >
   <link rel="stylesheet" href="assets/plugins/datatables/css/dataTables.bootstrap.min.css">



 
   <link rel="stylesheet" href="assets/plugins/datatables/css/responsive.dataTables.min.css">
 
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 
    <!-- Javascripts -->
   

	<script src="assets/plugins/jquery-ui/jquery-ui.min.js"></script>
	
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
	
<!-- Flot
 <script src="assets/plugins/flot/jquery.flot.js"/></script>
    <script src="assets/plugins/flot/jquery.flot.tooltip.min.js"/></script>
    <script src="assets/plugins/flot/jquery.flot.spline.js"/></script>
    <script src="assets/plugins/flot/jquery.flot.resize.js"/></script>
    <script src="assets/plugins/flot/jquery.flot.pie.js"/></script>
    <script src="assets/plugins/flot/jquery.flot.symbol.js"/></script>
    <script src="assets/plugins/flot/jquery.flot.time.js"/></script>
    <script src="assets/plugins/validate/jquery.validate.min.js"/></script>
    <script src="assets/plugins/cropper/cropper.min.js"/></script>-->
<!-- Peity -->
<!--<script src="assets/plugins/peity/jquery.peity.min.js"/></script>-->
 
<!-- Jvectormap -->
<!--<script src="assets/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"/></script>
    <script src="assets/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/></script>-->
   <!-- EayPIE -->
  <!--  <script src="assets/plugins/easypiechart/jquery.easypiechart.js"/></script>-->

    <!-- Sparkline -->
   <!-- <script src="assets/plugins/sparkline/jquery.sparkline.min.js"/></script> -->
	
	<!-- datatable -->
	 
	<script src="assets/plugins/datatables/js/datatables.min.js"></script>
    <script src="assets/plugins/datatables/js/dataTables.responsive.min.js"></script>

	<script src="assets/plugins/theme/js/inspinia.js"></script>
    <script src="assets/plugins/pace/pace.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.4/jquery-confirm.min.js"></script>


<script src="assets/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="assets/plugins/daterangepicker/daterangepicker.js?"></script>
 <script src="assets/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>


	<script src="assets/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<script src="assets/plugins/lodash/lodash.min.js"></script>
  
<script src="assets/plugins/input-mask/jquery.inputmask.js"></script>
	<script src="assets/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script  src="assets/plugins/input-mask/jquery.inputmask.extensions.js"></script>	
<script src="assets/plugins/moment/moment.min.js"></script>
<script src="assets/plugins/iCheck/icheck.min.js"></script>
<script src="assets/Msg_Code/MsgCode.js"></script>
 <script  src="assets/plugins/bootstrap/js/bootstrap-multiselect.js"></script> 
  <script src="assets/plugins/autoNumeric/NumberFormat154.js"></script>
 <link rel="stylesheet"   type="text/css"   href="assets/plugins/jquery/jquery-confirm.css"/>
    <script src="assets/plugins/jquery/jquery-confirm.js" type="text/javascript"></script>    
     
   </head>
 <style>
 
 @media (max-width: @screen-xs-min) {
  .modal-xs { width: @modal-sm; }
}
ul #side-menu{
	display: block;
}
 </style>
 <script type='text/javascript'>
		$(document).ready(function() {
			InitMenuMain();
			 
		});

		function InitMenuMain() {
			var pathname = window.location.pathname;
			pathname = pathname.substring(5, pathname.length);
			var data = {}
			data["strPage"] = pathname;

			jQuery.ajax({
				url : 'getmenu',
				type : "Post",
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(obj) {
				//Global
				window.codeEmid = obj['codempid'];
					if (obj.success == "1") {
						
						//$('#role_id').val(obj.role);
						/*if(obj.role == '0020'){
							$('#dis1').hide();
							$('#disQueuq').hide();
							$('#home_btnorder').hide();
							$('#orderNow').hide();							
						}
						else{
							$('#dis1').show();
							$('#disQueuq').show();
							$('#home_btnorder').show();
							$('#orderNow').show();
						}*/
						
						//$( "#dis1" ).show();
						
					 //alert(obj.menu);
						
					  	 $('#sideNavMenu').html(obj.menu);
					  	jQuery('#side-menu').metisMenu();
					  	
						$.fn.datepicker.defaults.format = "dd/mm/yyyy";
						 
					    $('[data-provide="datepicker"]').datepicker({
							autoclose : true
						});
					    
					    var d = new Date(new Date().getFullYear(), 0, 1);
					    
					    $('#datetimepicker1').datepicker('setDate', d);
					    $('#datetimepicker2').datepicker('setDate', 'today');

					  	
						//  $("#sideNav").sideNav();
						
					 /*	 $('.collapsible').collapsible({
							  accordion : true
							});
						
						$('#divSiteMap').html(obj.sitemap);
						$('#lblProfile').html(obj.profile);
						$('#lblSignOut').html(obj.signout);
						$('#lblUser').html(obj.name);
						$('#lblUserRight').html(obj.nameright);
						if (obj.nameposition != null && obj.nameposition != ''
								&& obj.nameposition != 'null') {
							var str = obj.nameposition.split('-');
							var name = str[0];
							var position = str[1];
							//$('#lblNamePosition').html(obj.nameposition); 
							$('#lblNameMain').html(name);
							$('#lblPositionMain').html(position);
						} else {
							var v_null = '';
							//$('#lblNamePosition').html(v_null);
							$('#lblNameMain').html(v_null);
							$('#lblPositionMain').html(v_null);
						}*/
						//$('#lblEmpIDMain').html(obj.codempid);
						//document.title = obj.title;
						//var lang = obj.lang;
						//var member = obj.memberno;
						
						//Defalut Datepicker language
						/* $.fn.datepicker.defaults.language = "th";
						$.fn.datepicker.defaults.format = "dd/mm/yyyy";
						$('#txtLangMain').val(lang);
					    $('[data-provide="datepicker"]').datepicker({
							autoclose : true
						});  */

					} else {
						window.location = "welcome";
					}
				},
				error : function() {

					// 			alert("error login");
					window.location = "welcome";

				}
			});

		}
		function showMsgError(msg){
			
			$('#divInfo').html('');
			
			var html = '<div class="alert alert-danger" role="alert">'+
	        '   <strong>เกิดข้อผิดพลาด ' +msg+ '</strong>'+ 
	        '       <button class="close" type="button" data-dismiss="alert" aria-label="Close">'+
	        '           <span aria-hidden="true">×</span>'+
	        '       </button>'
	        '   </div>';

	       $('#divInfo').append(html);
	       $(window).scrollTop(0);
	       fadeOut();
	       /*$.toaster({
	   			 
				  message : msg,
				 
				 title : '',
				 
				  priority : 'danger'
				 
				});*/
		}
		function showMsgSuccess(msg){
			
			$('#divInfo').html('');
			
			var html = '<div class="alert alert-success" role="alert">'+
	        '   <strong>' +msg+ '</strong>'+ 
	        '       <button class="close" type="button" data-dismiss="alert" aria-label="Close">'+
	        '           <span aria-hidden="true">×</span>'+
	        '       </button>'
	        '   </div>';

	       $('#divInfo').append(html);
	       $(window).scrollTop(0);
	       fadeOut();
	       /*$.toaster({
			 
				  message : msg,
				 
				 title : '',
				 
				  priority : 'success'
				 
				});*/

		}
        function showMsgWarning(msg){
			
			$('#divInfo').html('');
			
			var html = '<div class="alert alert-warning" role="alert">'+
	        '   <strong>' +msg+ '</strong>'+ 
	        '       <button class="close" type="button" data-dismiss="alert" aria-label="Close">'+
	        '           <span aria-hidden="true">×</span>'+
	        '       </button>'
	        '   </div>';

	       $('#divInfo').append(html);
	       $(window).scrollTop(0);
	       fadeOut();
	       /*$.toaster({
   			 
				  message : msg,
				 
				 title : '',
				 
				  priority : 'warning'
				 
				});*/
		}
        function fadeOut(){
        	 setTimeout(function() {
        		 $('#divInfo').html('');
        	    }, 6000);	
        }
		function ShowErrorConnectMessage() {
			var res = '0007 : ไม่สามารถเชื่อต่อ service ได้';
			$("#spnError").text(res);
			$("#dlgErrorMain").modal();
			//     	swal({
			//     		  title : "ERROR!",
			// 		      text : res,
			// 	          type : "error",
			// 	          showCancelButton : false,
			// 	          closeOnConfirm : false
			//       	});
		}
		function GetLangMain() {
			return $('#txtLangMain').val();
		}
		function ValidateSpecialChar(x) {
			var re = /"|'|--|[\/*]{2}/g;
			var str = x;
			var result = re.test(str);
			return result;

		}
		
		
		///function 
	function setNumberFormatTWOFactionAndSeparator(valueStringNumber){
        var nf = new NumberFormat(valueStringNumber);
        nf.setPlaces(2);
        nf.setSeparators(true);
        return nf.toFormatted();
    }
	function setNumberFormatTWOFactionAndNoSeparator(valueStringNumber){
        var nf = new NumberFormat(valueStringNumber);
        nf.setPlaces(2);
        nf.setSeparators(false);
        
        return nf.toFormatted();
   }
	function setCommaById(id){
		id.value  = setNumberFormatTWOFactionAndSeparator(id.value);
	}
	function isNumber(evt) {
		evt = (evt) ? evt : window.event;
		var charCode = (evt.which) ? evt.which : evt.keyCode;

		if (charCode >= 48 && charCode <= 57 || charCode == 46) {
			return true;
		}
		return false;
	}
	function getMsg(template_id) {
		var  txt =  "";
		var data = {}
		data["message_id"] = template_id;
		jQuery.ajax({
			url : 'util-getmsg',
			type : "Post",
			 async: false,
			   cache: false,
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(obj) {
				  txt = obj.message_desc;
			  
			},
			error : function() {

				ShowErrorConnectMessage();
			}
		});
		
		return txt  
	}
	function ShowWaiting() {
		waitingDialog.show();
		  
	}
	function HideWaiting() {
		waitingDialog.hide();
	}
 
		var waitingDialog = waitingDialog
				|| (function($) {
					'use strict';

					// Creating modal dialog's DOM
					var $dialog = $('<div class="modal in" data-backdrop="static" data-keyboard="false" tabindex="-1" data-backdrop="static" role="dialog" aria-hidden="true" style="padding-top:20%; overflow-y:visible;">'
							+ '<div>'
							+ '<div>'
							+ '<center><div>'
							+ '<div style="color:white;"><img width="300px" height="250px" src="assets/images/loadlab.gif"></img></div>'
							+ '</div></center>' + '</div></div></div>');

					return {
						/**
						 * Opens our dialog
						 * @param message Custom message
						 * @param options Custom options:
						 * 				  options.dialogSize - bootstrap postfix for dialog size, e.g. "sm", "m";
						 * 				  options.progressType - bootstrap postfix for progress bar type, e.g. "success", "warning".
						 */
						show : function(message, options) {
							// Assigning defaults
							if (typeof options === 'undefined') {
								options = {};
							}
							if (typeof message === 'undefined') {
								message = 'Loading';
							}
							var settings = $.extend({
								dialogSize : 'm',
								progressType : '',
								onHide : null
							// This callback runs after the dialog was hidden
							}, options);

							// Configuring dialog
							$dialog.find('.modal-dialog').attr('class',
									'modal-dialog').addClass(
									'modal-' + settings.dialogSize);
							$dialog.find('.progress-bar').attr('class',
									'progress-bar');
							if (settings.progressType) {
								$dialog
										.find('.progress-bar')
										.addClass(
												'progress-bar-'
														+ settings.progressType);
							}
							$dialog.find('h3').text(message);
							// Adding callbacks
							if (typeof settings.onHide === 'function') {
								$dialog.off('hidden.bs.modal').on(
										'hidden.bs.modal', function(e) {
											settings.onHide.call($dialog);
										});
							}
							// Opening dialog
							$dialog.modal();
						},
						/**
						 * Closes dialog
						 */
						hide : function() {
							$dialog.modal('hide');
						}
					};

				})(jQuery);
 </script>
<body class="md-skin"> 
<div ng-controller="<tiles:getAsString name="ngcontroller" />">
    <div id="wrapper ">
         <tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
        <div id="page-wrapper" class="gray-bg">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header">
                        <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>

                    </div>
                    <div class="navbar-header">
                        <ul class="nav navbar-top-links navbar-left">
                            <li class="dropdown">
                                <!--  <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                    <i class="fa fa-gears"></i>  <span>ตั้งค่าส่วนกลาง</span>
                                </a>
                                <ul class="dropdown-menu dropdown-alerts">
                                    <li class="active">
                                        <a href="#"><i class="fa fa-th-list"></i> <span class="nav-label">ตั่งค่าผู้เข้าใช้งานระบบ</span> <span class="fa arrow"></span></a>
                                        <ul class="nav">
                                            <li><a href="http://localhost:8888/iams-app/user/manage"><i class="fa fa-angle-double-right"></i>ตั่งค่าผู้เข้าใช้งานระบบ</a></li>
                                            <li><a href="http://localhost:8888/iams-app/audit/team"><i class="fa fa-angle-double-right"></i>กำหนดข้อมูลทีมตรวจสอบสาขา</a></li>
                                        </ul>
                                    </li>
                                    <li class="active">
                                        <a href="#"><i class="fa fa-th-list"></i> <span class="nav-label">วางแผนการตรวจสอบ</span> <span class="fa arrow"></span></a>
                                        <ul class="nav">
                                            <li><a href="http://localhost:8888/iams-app/audit/plan"><i class="fa fa-angle-double-right"></i>วางแผนการตรวจสอบสาขา</a></li>
                                        </ul>
                                    </li>
                                    <li class="active">
                                        <a href="#"><i class="fa fa-th-list"></i> <span class="nav-label">ข้อมูลทั่วไป</span> <span class="fa arrow"></span></a>
                                        <ul class="nav">
                                            <li><a href="#"><i class="fa fa-angle-double-right"></i>ประเภทธุรกิจ</a></li>
                                            <li><a href="#"><i class="fa fa-angle-double-right"></i>หัวข้อรายการตรวจสอบ</a></li>
                                            <li><a href="#"><i class="fa fa-angle-double-right"></i>รายชื่อสาขา</a></li>
                                            <li><a href="#"><i class="fa fa-angle-double-right"></i>ประเภทและรายการสินค้า</a></li>
                                            <li><a href="#"><i class="fa fa-angle-double-right"></i>รายการข้อมูลอื่นๆ</a></li>
                                        </ul>
                                    </li>

                                </ul>-->
                            </li>

                        </ul>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">

                       <!--   <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-handshake-o"></i>  <span>ช่วยเหลือ</span>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-gear"></i>  <span>System Setting</span>
                            </a>

                        </li>-->


                        <li>
                            <a href="account-logout">
                                <i class="fa fa-sign-out"></i> Log out
                            </a>
                        </li>
                    </ul>

                </nav>
            </div>
            
            <div class="main">
                 <div  id="divInfo" ></div>
                 <tiles:insertAttribute name="body" />
            </div>
            <!-- <div class="footer">
                <div class="pull-right">

                </div>
                <div>
                    <strong>Copyright @ PTG Energy Public Company Limited</strong>
                </div>
            </div> -->
        </div>

    </div>
</div>


<!-- scripts-->
<c:forEach var="script" items="${javascripts}">
    <script src="<c:url value="${script}"/>"></script>
</c:forEach>

<!-- %@ include file="/WEB-INF/jsp/views/ajaxLoading.jsp" %-->
</body>