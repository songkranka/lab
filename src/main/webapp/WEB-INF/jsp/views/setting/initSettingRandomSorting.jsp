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
				<h5 class="modal-title modal-titlecus">เพิ่มการสุ่ม</h5>
				<button type="button" class="close closecus" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="clear"></div>
			</div>
			<div class="modal-body modal-bodycus">


				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">บริษัท
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="nameCode"
								placeholder="บริษัท">
						</div>
					</div>
				</div>


				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">ชื่อบริษัท
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="nameComp"
								placeholder="ชื่อบริษัท">
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">ชื่อชุดข้อมูล
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="nameCtr" placeholder="ชื่อชุดข้อมูล">
								
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">เรียงลำดับชุดข้อมูล
						</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label>&nbsp;</label> <input type="text"
								class="form-control inputCus" name="seq" placeholder="0"
								min="0" maxlength="3"
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
					<div class="col-xs-12 col-md-3  text-right  titleInputModel">บริษัท</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<dev> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</dev>
							<label class="col-xs-12 col-md-3 titleInputModel"
								name="updatenameCode"></label>
						</div>
					</div>
				</div>

			
				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">ชื่อบริษัท
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label></label> <input type="text" class="form-control inputCus"
								name="updatecompname" placeholder="ชื่อบริษัท" >
						</div>
					</div>
				</div>


				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">ชื่อชุดข้อมูล
					</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label></label> <input type="text" class="form-control inputCus"
								name="updatecrtname" placeholder="ชื่อชุดข้อมูล" >
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-md-12 boxGroupCus">
					<div class="col-xs-12 col-md-3 text-right titleInputModel">เรียงลำดับชุดข้อมูล
						</div>
					<div class="col-xs-12 col-md-4 text-left form-inline">
						<div class="form-group">
							<label></label> <input type="text" class="form-control inputCus"
								name="updateseq" placeholder="0" min="0" maxlength="3"
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
		<h2>ตั้งค่าการจัดชุดข้อมูลการสุ่ม</h2>
	</div>
	<div class="col-lg-2"></div>
</div>

<div class="zoneBody">

	<div class="wrapper wrapper-btn text-center">
		<div class="row">
			<div class="col-xs-12 col-md-12 boxGroupCus">
				<div class="col-xs-5 col-md-5 text-right titleSelct">
					<strong> บริษัท : </strong>
				</div>
				<div class="col-xs-3 col-md-3 text-left">
					<select class="form-control select5Inp" name="nameCode" id="comp">
						<option value="all">ทั้งหมด</option>
					</select>
				</div>
				<div class="col-xs-3 col-md-3 text-left">
					<button type="button" class="btn btn-primary seatchTypeComp">Search</button>
				</div>
			</div>
		</div>
	</div>

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
							<tr class="tbHeader">
								<th class="text-center vertical_align_inherit">ลำดับ</th>
								<th class="text-center vertical_align_inherit">บริษัท</th>
								<th class="text-center vertical_align_inherit">ชื่อบริษัท</th>
								<th class="text-center vertical_align_inherit">ชื่อชุดข้อมูล</th>
								<th class="text-center vertical_align_inherit">เรียงลำดับชุดข้อมูล</th>
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

<script src="<c:url value="/assets/js/settingRandomSorting.js" /> "type="text/javascript"></script>