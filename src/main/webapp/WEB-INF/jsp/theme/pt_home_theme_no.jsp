<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList"  %>
<%@ page import="java.io.File"  %>
<%@ page import="java.net.URL" %>
  
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
  	<script src="../../assets/plugins/jquery/jquery-2.2.3.min.js"/></script>
    <link rel="icon" href="assets/images/labIcon.ico" > 
    

      <!-- Styles -->
     <link rel="stylesheet" href="../../assets/plugins/font-awesome/css/font-awesome.min.css">
      <link rel="stylesheet" href="../../assets/plugins/bootstrap/css/bootstrap.min.css">
 
    <!-- Javascripts -->
   
	<script src="../../assets/plugins/jquery-ui/jquery-ui.min.js"/></script>
	<script src="../../assets/plugins/bootstrap/js/bootstrap.min.js"/></script>
	
   </head>
 <style>
 
 @media (max-width: @screen-xs-min) {
  .modal-xs { width: @modal-sm; }
}
 </style>
<body class="md-skin mini-navbar">
<div ng-controller="<tiles:getAsString name="ngcontroller" />">
    <div id="wrapper ">
         <tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
        <div id="page-wrapper" class="gray-bg">
            <div class="row border-bottom">
                
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
 

</body>