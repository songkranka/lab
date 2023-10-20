<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-12">
		<h2>
			<span id="taskTopicPage"></span>
		</h2>
	</div>
	<div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row" id="assignHDnew" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">

				<div class="col-xs-12 text-right"
					style="margin-bottom: 10px; display: none;" id="block_wait_work">
					<form action="/Lab/viewwaitwork">
						<input class=" btn btn-primary"
							style="border-radius: 3px; margin-top: 10px;" id="work_wait"
							type="submit" value="ทบทวนปริมาณงาน">
					</form>
				</div>
				<div class="col-xs-12 text-right"
					style="margin-bottom: 10px; display: none;"
					id="block_wait_work_subrole">
					<form action="/Lab/viewwaitworksubrole">
						<input class=" btn btn-primary"
							style="border-radius: 3px; margin-top: 10px;" id="work_wait_role"
							type="submit" value="Print ใบมอบหมายงาน">
					</form>
				</div>
				<div style="width: 50%;float: right;display: none;" id="sendtotemp_block">
				<button class="btn btn-primary" style="float: right;" onclick="assigntotempfunc()">Assign to temp
				</button>
				</div>
				<div class="ibox-title">

					<h5 id="workNewText"></h5>

					<div class="ibox-tools" style="margin-top: 10px">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="newAssiWorkHDT"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">
											<th class="text-center" style="width: 10%;" id="ctemp" >Temp</th>
											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 10%;">LAB CODE</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 10%;">รายละเอียดตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
										</tr>
									</thead>
									<tbody id="newAssiWorkHD">

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row" id="assignHDedit" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
				<div style="width: 100%">
				<div style="width: 50%;float: left;"><h5 id="workEditText"></h5></div>
				
				</div>
					
					<div class="ibox-tools" style="margin-top: 40px">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="editAssiWorkHDT"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">
											
											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 10%;">LAB CODE</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 10%;">รายละเอียดตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
										</tr>
									</thead>
									<tbody id="editAssiWorkHD">

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row" id="assignHDsuccess" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5 id="workDoneText"></h5>
					<div class="ibox-tools">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="doneAssiWorkHDT"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">

											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 10%;">LAB CODE</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 10%;">รายละเอียดตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
										</tr>
									</thead>
									<tbody id="doneAssiWorkHD">

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row" id="assignHDTemp" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
				<div style="width: 100%">
				<div style="width: 50%;float: left;"><h5 id="workTempText"></h5></div>
				<div style="width: 50%;float: right;"><button class="btn btn-primary" style="float: right;" onclick="returnfromtempfunc()">Return</button></div>
				</div>
					<div class="ibox-tools" style="margin-top: 40px">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="tempAssiWorkHDT"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">
											<th class="text-center" style="width: 10%;">Return</th>
											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 10%;">LAB CODE</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 10%;">รายละเอียดตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
										</tr>
									</thead>
									<tbody id="tempAssiWorkHD">

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row" id="newTaskId" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>งานใหม่</h5>
					<div class="ibox-tools">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="newTaskTbl"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">
											<th class="text-center" style="width: 5%;">#</th>
											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 15%;">ชื่อคลัง</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่หมดอายุ</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row" id="reviseTaskId" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>งานที่ต้องแก้ไข</h5>
					<div class="ibox-tools">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="reviseTaskTbl"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">
											<th class="text-center" style="width: 5%;">#</th>
											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 15%;">ชื่อคลัง</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่หมดอายุ</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row" id="submitTaskId" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>งานที่บันทึกผล</h5>
					<div class="ibox-tools">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="submitTaskTbl"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">
											<th class="text-center" style="width: 5%;">#</th>
											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 15%;">ชื่อคลัง</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่หมดอายุ</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row" id="completeTaskId" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>งานที่ทำเสร็จแล้ว</h5>
					<div class="ibox-tools">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="completeTaskTbl"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">
											<th class="text-center" style="width: 5%;">#</th>
											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 15%;">ชื่อคลัง</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่หมดอายุ</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="row" id="waitAuditTaskId" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>งานที่ตรวจสอบ</h5>
					<div class="ibox-tools">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="waitAuditTaskTbl"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">
											<th class="text-center" style="width: 5%;">#</th>
											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 15%;">ชื่อคลัง</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่หมดอายุ</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row" id="waitApprovedTaskId" style="display: none;">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>งานที่รออนุมัติ</h5>
					<div class="ibox-tools">
						<div class="ibox-content">
							<div class="table-responsive">
								<table id="waitApprovedTaskTbl"
									class="table table-striped table-bordered" style="width: 100%;">
									<thead>
										<tr class="tbHeader">
											<th class="text-center" style="width: 5%;">#</th>
											<th class="text-center" style="width: 10%;">เลขที่ใบงาน</th>
											<th class="text-center" style="width: 15%;">ชื่อคลัง</th>
											<th class="text-center" style="width: 10%;">ประเภทตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">ผลิตภัณฑ์</th>
											<th class="text-center" style="width: 15%;">วันที่เก็บตัวอย่าง</th>
											<th class="text-center" style="width: 15%;">วันที่หมดอายุ</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>


