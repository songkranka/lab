<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" href="<c:url value="/assets/style/report_web.css" />">
<link rel="stylesheet" href="<c:url value="/assets/style/report_mobile.css" />">
<script src="<c:url value="/assets/js/controllers/report/lab.js" />"></script>
<script src="<c:url value="/assets/js/controllers/report/mobile.js" />"></script>
<script src="<c:url value="/assets/js/controllers/report/mobile.js" />"></script>
<script src="<c:url value="/assets/js/jquery.base64.js" />"></script>

<style>
.table-responsive {
    min-height: 0.01%;
    overflow-x: warp;
}
.float_left{
	float:left;
}
.colorRed{
	color:red;
}
.clear{
	clear:both;
}
.boxwork{
	margin-top:10px;
	margin-bottom:10px;
}
</style>

<script type='text/javascript'>
$(function(){
	
	
	inquiryYear();

	$('select[name="yearSel"]').on('change', function(){
	    var selectedNow = $(this).val();
	    var dt = new Date();
	    if(selectedNow != "" && selectedNow != null){
		    if(selectedNow==dt.getFullYear()){
			    //Year current
		    	getMonthOpt("OY");
			}else{
				//Year old
				getMonthOpt("FY");
			}
		}
		
	});
	
	
});

function inquiryYear(){

	ShowWaiting();
	var BoxselectYear = $('#yearSel');
	var BoxselectMonth = $('#monthSel');
	var i = 0;
	BoxselectYear.html("");
	BoxselectYear.append("<option value=' '>===เลือก====</option>");
	BoxselectMonth.html("");
	BoxselectMonth.append("<option value=' '>===เลือก====</option>");

	jQuery.ajax({
		url:"inquiryYear",
		type:"Post",
		async: false, 
		cache: false,
		contentType:'application/json',
		success:function(result){
			HideWaiting();
			if(result.success=='1'){

				if(result.data[0].length>0){
					
					for(i = 0;i<result.data[0].length;i++){
						console.log(result.data[0][i]); 
						BoxselectYear.append('<option value="'+result.data[0][i]['5']+'">'+result.data[0][i]['yearStr']+'</option>');
					}
					
				}

			}
		},error:function(){
			HideWaiting();
			showMsgError('เกิดข้อผิดพลาด');
		}
	}).fail(function(){
		HideWaiting();
	});
	
}

function getMonthOpt(data){

	var dt = new Date();
	var BoxselectMonth = $('#monthSel');
	var i = 0;
	var monthStr = ['มกราคม','กุมภาพันธ์','มีนาคม','เมษายน','พฤษภาคม','มิถุนายน','กรกฎาคม','สิงหาคม','กันยายน','ตุลาคม','พฤศจิกายน','ธันวาคม'];
	var monthVal = ['1','2','3','4','5','6','7','8','9','10','11','12'];
	
	if(data=="FY"){
		BoxselectMonth.html("");
		BoxselectMonth.append("<option value=' '>===เลือก====</option>");
		for(i=0;i<12;i++){

			BoxselectMonth.append('<option value="'+monthVal[i]+'">'+monthStr[i]+'</option>');
			
		}
		
	}else if(data=="OY"){
		BoxselectMonth.html("");
		BoxselectMonth.append("<option value=' '>===เลือก====</option>");
		for(i=0;i<dt.getMonth();i++){

			BoxselectMonth.append('<option value="'+monthVal[i]+'">'+monthStr[i]+'</option>');
			
		}
		
	}
	
}

function getReportPDF(){

	var BoxselectYear = $('select[name=yearSel]').val();
	var BoxselectMonth = $('select[name=monthSel]').val();

	if(BoxselectYear==" " || BoxselectYear==null){

		showMsgError(' : กรุณาเลือกปีที่ต้องการ');

	}else if(BoxselectMonth==" " || BoxselectMonth==null){

		showMsgError(' : กรุณาเลือกเดือนที่ต้องการ');

	}else{
		var paraminter =$.base64.encode(BoxselectYear+':'+BoxselectMonth);
		urlgetReport = window.location+'/reportdumpdf/'+paraminter;
		window.open(urlgetReport,'_blank');
	}
}

function ShowWaiting() {
	waitingDialog.show();
	  
}
function HideWaiting() {
	waitingDialog.hide();
}

</script>

<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>ผลการปฏิบัติงานส่วนประกันคุณภาพประจำปี (Sum)</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>

<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row"> 
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				
				<div class="ibox-title col-xs-12 col-md-12">
					
					<div class="col-xs-12 col-md-6 float_left boxwork">
						<div class="col-xs-12 col-md-3 float_left">ปี  <span class="colorRed">*</span></div>
						<div class="col-xs-12 col-md-9 float_left">
							<select class="form-control" id="yearSel" name="yearSel">
							  <option value="">2562</option>
							  <option value="">2561</option>
							  <option value="">2560</option> 
							</select>
						</div>
						<div class="clear"></div>
					</div>
					
					<div class="col-xs-12 col-md-6 float_left boxwork">
						<div class="col-xs-12 col-md-3 float_left">ถึงเดือน  <span class="colorRed">*</span></div>
						<div class="col-xs-12 col-md-9 float_left">
							<select class="form-control" id="monthSel" name="monthSel">
							  <option value="">ทั้หมด</option>
							</select>
						</div>
						<div class="clear"></div>
					</div>
					
					<div class="clear"></div>
				</div>
				
				<div class="ibox-title col-xs-12 col-md-12 text-right">
					<button type="button" class="btn btn-success" onclick="getReportPDF()">
						<i class="fa fa-bar-chart"></i>
						<span>Get PDF</span>
					</button>
				</div>
				
			</div> 
		</div>
	</div>
</div>

