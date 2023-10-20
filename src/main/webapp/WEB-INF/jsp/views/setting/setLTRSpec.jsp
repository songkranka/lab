<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link
	href="${pageContext.request.contextPath}/assets/select2/select2.css"
	rel="stylesheet" />
<script
	src="${pageContext.request.contextPath}/assets/select2/select2.min.js"></script>

<style>
.btnWidth {
	width: 200px
}
</style>

<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>ตั้งค่า Spec mobile lab</h2>
	</div>
	<div class="col-lg-2"></div>
</div>

<div class="wrapper wrapper-content animated fadeInRight"
	style="padding-bottom: 0px">
	<div class="row ibox-content assign-detail">

		<div class="row" style="padding-bottom: 30px">

			<div class="col-md-3">
				<div class="">
					<button type="button" class="btn btn-success btn-lg btnWidth"
						 value="100000001" name="product_id"
						onclick="btnSpecClick(this.value)">PT Max Diesel</button>
				</div>
			</div>

			<div class="col-md-3">
				<div class="">
					<button type="button" class="btn btn-success btn-lg btnWidth"
						 value="100000002" name="product_id"
						onclick="btnSpecClick(this.value)">PT Max ULG 95</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="">
					<button type="button" class="btn btn-success btn-lg btnWidth"
						 value="100000003" name="product_id"
						onclick="btnSpecClick(this.value)">PT Max Gasohol 95</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="">
					<button type="button" class="btn btn-success btn-lg btnWidth"
						 value="100000004" name="product_id"
						onclick="btnSpecClick(this.value)">PT Max Gasohol 91</button>
				</div>
			</div>

		</div>

		<div class="row">

			<div class="col-md-3">
				<div class="">
					<button type="button" class="btn btn-success btn-lg btnWidth"
						 value="100000005" name="product_id"
						onclick="btnSpecClick(this.value)">PT Max Gasohol E20</button>
				</div>
			</div>

			<div class="col-md-3">
				<div class="">
					<button type="button" class="btn btn-success btn-lg btnWidth"
						 value="100000006" name="product_id"
						onclick="btnSpecClick(this.value)">PT Max Gasohol E85</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="">
					<button type="button" class="btn btn-success btn-lg btnWidth"
						 value="100000007" name="product_id"
						onclick="btnSpecClick(this.value)">PT Max Diesel B20</button>
				</div>
			</div>
			<div class="col-md-3">
				<div class="">
					<button type="button" class="btn btn-success btn-lg btnWidth"
						 value="100000008" name="product_id"
						onclick="btnSpecClick(this.value)">PT Max Diesel B10</button>
				</div>
			</div>
		</div>

	</div>

</div>