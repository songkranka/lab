<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>

</style>

<script type='text/javascript'>
	var timeCount = 0;
	
	$(function(){
		$("#btnImportStationPtc").click(function(){
			
			ShowWaiting();
			/*
			var intTime = setInterval(function(){ ShowWaiting(); timeCount++ }, 1000);
		
			if( intTime==5 ) {
				clearInverval(intTime);
				timeCount = 0;
			}
			*/
			var url = "importPTCStation_csv";
			var file_path = $('#fileUploadPTC');
			var formData = new FormData();
			formData.append('file', file_path[0].files[0]);
			
			if (file_path.val() != "") {

				jQuery.ajax({
					url : url,
					type : 'Post',
					//async: false,
					//cache: false,
					processData : false,
			        contentType : false,
					//contentType : 'application/json',
					data : formData,
					dataType : 'json',
					success : function(result) {
						if(result.status=="S") {
							console.log(JSON.stringify(result));
							showMsgSuccess('อัพโหลดไฟล์สำเร็จ กรุณารอตรวจสอบผลจากอีเมลล์');
						}else{
							showMsgError('เกิดข้อผิดพลาด');
						}
						
						//HideWaiting();
						setTimeout(function(){ HideWaiting(); }, 1000);
					},
					error : function() {
						showMsgError('เกิดข้อผิดพลาด');
						//HideWaiting();
					}
				}).fail(function() {
					//HideWaiting(); 
				});	

			} else {
				showMsgError('ไม่พบไฟล์ที่ต้องการ upload .');
			}
		});
		
	});

</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>Upload ข้อมูลสถานีของ PTC</h2>
    </div>
    <div class="col-lg-2"></div>
</div>

<div class="wrapper wrapper-content animated fadeInRight"> 
	<div class="row"> 
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				
				<div class="ibox-title">
					<h5><label>เลือกไฟล์ </label>	<label class="required">( อัพโหลดเฉพาะไฟล์ CSV เท่านั้น )</label></h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
					</div>
				</div>

				<div class="ibox-content">              
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive form-group">		
								<div class="col-lg-6">
									<div class="col-lg-12" style="height: 15px;"></div>	
									<div class="form-group">
										<input type="file" id="fileUploadPTC" class="form-control input-sm"  accept=".csv" style="padding: 2px 15px; min-height: 30px;">
									</div>
								</div>
								<div class="col-lg-2">
									<div class="col-lg-12" style="height: 15px;"></div>	
									<div class="form-group">
										<button id="btnImportStationPtc" type="button" class="btn btn-sm btn-info"><i class="fa fa-download"></i> Import</button>
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
