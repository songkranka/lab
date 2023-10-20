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
.rowpaddingbot {
	padding-bottom: 10px
}
</style>

<form method='post' id='frmltrspec' enctype="multipart/form-data">

	<div class="row wrapper border-bottom white-bg page-heading">
		<div class="col-lg-10">
			<label class="h2" id="lblproduct">Spec ${product_name}</label> <input
				type="hidden" name="ltr_spec_id" class="form-control"
				value="${ltr_spec_id}">
		</div>
		<div class="col-lg-2"></div>
	</div>

	<div class="wrapper wrapper-content animated fadeInRight"
		style="padding-bottom: 0px">
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>ลักษณะที่ปรากฎ</label> <input type="hidden" id="txtFeature"
						class="form-control" value="${feature}"> <select
						id="ddlFeature" name="feature" class="form-control"
						style="width: 100%; float: left;">
					</select>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>สี</label> <input type="hidden" id="txtColor"
						class="form-control" value="${color}"> <select
						id="ddlColor" name="color" class="form-control"
						style="width: 100%; float: left;">
					</select>
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>เอพีไอที่อุณหภูมิวัด ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" name="temp_min"
						class="form-control" value="${temp_min}">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>เอพีไอที่อุณหภูมิวัด สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" name="temp_max"
						class="form-control" value="${temp_max}">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>เอพีไอที่ 60 ฟ ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${api_60_min}"
						name="api_60_min" class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>เอพีไอที่ 60 ฟ สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${api_60_max}"
						name="api_60_max" class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>การกลั่น , ซ ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${distill_min}"
						name="distill_min" class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>การกลั่น , ซ สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${distill_max}"
						name="distill_max" class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>การระเหยในอัตรา 10 % ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)"
						value="${evaporation_10_min}" name="evaporation_10_min"
						class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>การระเหยในอัตรา 10 % สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)"
						value="${evaporation_10_max}" name="evaporation_10_max"
						class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>การระเหยในอัตรา 50 % ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)"
						value="${evaporation_50_min}" name="evaporation_50_min"
						class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>การระเหยในอัตรา 50 % สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)"
						value="${evaporation_50_max}" name="evaporation_50_max"
						class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>การระเหยในอัตรา 90 % ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)"
						value="${evaporation_90_min}" name="evaporation_90_min"
						class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>การระเหยในอัตรา 90 % สูงสุด</label> <input type="text"
						value="${evaporation_90_max}" name="evaporation_90_max"
						onkeypress="return validateInput(event)" class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>จุดเดือดสุดท้าย ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${boil_min}"
						name="boil_min" class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>จุดเดือดสุดท้าย สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${boil_max}"
						name="boil_max" class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>กากน้ำมัน ต่ำสุด</label> <input type="text" name="waste_min"
						onkeypress="return validateInput(event)" value="${waste_min}"
						class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>กากน้ำมัน สูงสุด</label> <input type="text" name="waste_max"
						onkeypress="return validateInput(event)" value="${waste_max}"
						class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>ปริมาณเอทานอล, %vol ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${ethanol_min}"
						name="ethanol_min" class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>ปริมาณเอทานอล, %vol สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${ethanol_max}"
						name="ethanol_max" class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>จุดวาบไฟ, ซ ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" name="flash_point_min"
						value="${flash_point_min}" class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>จุดวาบไฟ, ซ สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" name="flash_point_max"
						value="${flash_point_max}" class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>ปริมาณไบโอดีเซล, %vol ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${biodiesel_min}"
						name="biodiesel_min" class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>ปริมาณไบโอดีเซล, %vol สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${biodiesel_max}"
						name="biodiesel_max" class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>ดัชนีซีเทน ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" name="cetane_min"
						value="${cetane_min}" class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>ดัชนีซีเทน สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" name="cetane_max"
						value="${cetane_max}" class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>ค่าออกเทน (RON) ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${ron_min}"
						name="ron_min" class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>ค่าออกเทน (RON) สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${ron_max}"
						name="ron_max" class="form-control">
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-5">
				<div>
					<label>ค่าออกเทน (MON) ต่ำสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${mon_min}"
						name="mon_min" class="form-control">
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-6">
				<div>
					<label>ค่าออกเทน (MON) สูงสุด</label> <input type="text"
						onkeypress="return validateInput(event)" value="${mon_max}"
						name="mon_max" class="form-control">
				</div>
			</div>
		</div>

		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-12">
				<div>
					<label>แก้ไขล่าสุด : ${update_date}</label>
				</div>
			</div>
		</div>
		<div class="row ibox-content rowpaddingbot">
			<div class="col-md-12">
				<div>
					<label>แก้ไขโดย : ${update_by} ${update_by_name}</label>
				</div>
			</div>
		</div>
	</div>


	<div class="row ibox-content rowpaddingbot">
		<button class="btn btn-success" type="button" onclick="btnSaveClick()">Save</button>
		<button class="btn btn-danger" type="button" onclick="btnBackClick()">Back</button>
	</div>

	</div>
</form>