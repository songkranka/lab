<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="<c:url value="/assets/css/settingTestScroll.css" />"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>


<div class="modal progressModel" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">

			<div class="modal-body modal-bodycus">โปรดรอ......</div>

		</div>
	</div>
</div>

<div class="modal addSettingRandomModel" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title modal-titlecus">เพิ่มการสุ่มตัวอย่างเพื่อตรวจ</h5>
				<button type="button" class="close closecus" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="clear"></div>
			</div>
			<div class="modal-body modal-bodycus">



				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนตัวอย่างต่ำสุด
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="minSimple" placeholder="0"
								min="0" maxlength="3"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนตัวอย่างสุดสุด
						</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="maxSimple" placeholder="0"
								min="0" maxlength="3"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนสุ่มแบบผ่อนคลาย(เขียว)
						</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="cntGreen" placeholder="0"
								min="0" maxlength="3"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนสุ่มแบบปกติ(เหลือง)
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="cntYellow" placeholder="0"
								min="0" maxlength="5"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>
				
				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนสุ่มแบบเคร่งคลัด(แดง)
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="cntRed" placeholder="0"
								min="0" maxlength="5"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>
				
				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">แบบปกติ(ผ่าน)
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="passYellow" placeholder="0"
								min="0" maxlength="5"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>
				
				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">แบบเคร่งครัด(ผ่าน)
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="passRed" placeholder="0"
								min="0" maxlength="5"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>
				


			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary savesettingrandom">Save</button>
				<button type="button" class="btn btn-secondary cancelModal"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<div class="modal updateSettingRandomModel" tabindex="-1" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title modal-titlecus">แก้ไขการสุ่ม</h5>
				<button type="button" class="close closecus" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="clear"></div>
			</div>
			<div class="modal-body modal-bodycus">


				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนตัวอย่างต่ำสุด
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="updatesimplemin" placeholder="0"
								min="0" maxlength="3"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนตัวอย่างสูงสุด
						</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="updatesimplemax" placeholder="0"
								min="0" maxlength="3"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนสุ่มแบบผ่อนคลาย(เขียว)
						</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="updategreencnt" placeholder="0"
								min="0" maxlength="3"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนสุ่มแบบปกติ(เหลือง)
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="updateyellowcnt" placeholder="0"
								min="0" maxlength="5"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>
				
				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">จำนวนสุ่มแบบเคร่งคลัด(แดง)
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="updateredcnt" placeholder="0"
								min="0" maxlength="5"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>
				
				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">แบบปกติ(ผ่าน)
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="updateyellowpass" placeholder="0"
								min="0" maxlength="5"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>
				
				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">แบบเคร่งครัด(ผ่าน)
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="updateredpass" placeholder="0"
								min="0" maxlength="5"
								oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
						</div>
					</div>
				</div>


			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary updatescore">Update</button>
				<button type="button" class="btn btn-secondary cancelModal"
					data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>

<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
		<h2>ตั้งค่าการสุ่มตัวอย่างเพื่อตรวจ</h2>
	</div>
	<div class="col-lg-2"></div>
</div>

<!-- <div class="zoneBody"> -->

<!-- 	<div class="wrapper wrapper-btn text-right"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-xs-12 col-md-12 boxGroupCus"> -->
<!-- 				<div class="col-xs-5 col-md-5 text-right titleSelct"> -->
<!-- 					<strong> บริษัท : </strong> -->
<!-- 				</div> -->
<!-- 				<div class="col-xs-3 col-md-3 text-left"> -->
<!-- 					<select class="form-control select5Inp" name="nameCode" id="comp"> -->
<!-- 						<option value="all">ทั้งหมด</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
<!-- 				<div class="col-xs-3 col-md-3 text-left"> -->
<!-- 					<button type="button" class="btn btns-primary seatchTypeComp">Search</button> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->

	<div class="wrapper wrapper-btn text-right">
		<div class="row">
			<div class="col-xs-12">
				<button type="button" class="btn btn-primary addSettingRandom">Create
				</button>
			</div>
		</div>
	</div>


	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-xs-12">
				<div class="table-responsive">
					<table id="myTablePlaning"
						class="table table-striped table-bordered" style="width: 100%;"
						role="grid" aria-describedby="tableApproverTask_info">

						<thead>
							<tr class="tbHeader" >
						
								<th class="text-center vertical_align_inherit">ลำดับ</th>
								<th class="text-center vertical_align_inherit">จำนวนตัวอย่าง</th>
								<th class="text-center vertical_align_inherit">จำนวนสุ่มแบบผ่อนคลาย(เขียว)</th>
								<th class="text-center vertical_align_inherit">จำนวนจำนวนสุ่มแบบปกติ(เหลือง)</th>
								<th class="text-center vertical_align_inherit">จำนวนจำนวนสุ่มแบบเคร่งครัด(แดง)</th>
								 
								<th class="text-center vertical_align_inherit">เหลือง(ผ่าน)</th>
								<th class="text-center vertical_align_inherit">แดง(ผ่าน)</th>
								
								<th class="text-center vertical_align_inherit"></th>
								<th class="text-center vertical_align_inherit"></th>
						
							</tr>
						</thead>
						<tbody id=dteId>

						</tbody>

					</table>
				</div>
			</div>
		</div>
	</div>

</div>

<script src="<c:url value="/assets/js/settingRandomLast.js" /> "type="text/javascript"></script>