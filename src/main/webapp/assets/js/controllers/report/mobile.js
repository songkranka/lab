var ReportCriteriaForm = function(reportInfo) {
	//alert(JSON.stringify(reportInfo));
	this.info = reportInfo;
	this.form = $("<div>").addClass("col-lg-12");
	
	this.setupHeadTap = function() {
		return $("<div>").addClass("ibox-title").append($("<h5>").append($("<span>").html(this.info.reportName))).append($("<div>").addClass("ibox-tools").append($("<a>").addClass("collapse-link").append($("<i>").addClass("fa fa-chevron-up"))));
	}
	this.setupFormTap = function(){
		return $("<div>").addClass("ibox-content").append($("<div>").attr({"id":""}).append($("<div>").addClass("row").append(this.generateForm())).append($("<div>").addClass("row").append(this.btnSubmitReport())));
	}
	this.generateForm=function(){
		var critereaFrm = $("<div>").addClass("col-lg-12 text-middle");
		
		$.each(this.info.reportCriterea,function(i, crit){
			var txtInput = "";
			if(crit.type=="txt"){
				txtInput = "<input type='text' id='"+crit.id+"' class='form-control input-sm' >";
			} else if(crit.type=="ddl"){
				
				txtInput = "<select id='"+crit.id+"' class='form-control select2' >";
				txtInput += "</select >";
				
				if(crit.url != "") {

					jQuery.ajax({
						url : crit.url,
						type : "Post",
						contentType : "application/json",
						dataType : 'json',
						//async: false,
						//cache: false,
						//data : JSON.stringify(data),
						success : function(result) {
							$.each(result.rptddl,function(t, trip){
								//console.log(JSON.stringify(trip));
								$("#"+crit.id).append($("<option>").attr({"value":trip.CTID}).html(trip.CTNAME));
							});
						},
						error : function() {
							//showMsgError('เกิดข้อผิดพลาด!');
						}
					});
				} else {
					$.each(crit.source,function(s, src){
						var val = src.val.toString();
						var txt = src.txt.toString();

						$("#"+crit.id).append($("<option>").attr({"value":""}).html(txt));
						
					});
				}
				
			} 
			$("<div>")
			.addClass("col-lg-4")
			.append(
				$("<div>").addClass("col-lg-12")
				.append($("<div>").addClass("col-lg-12").append($("<span>").addClass("text-left text-middle").html(crit.text)))
				.append($("<div>").addClass("col-lg-12 form-group").html(txtInput))
			)
			.appendTo(critereaFrm);
		});
		return critereaFrm;
	}
	this.btnSubmitReport=function(){
		return $("<div>").addClass("col-lg-12 text-right text-middle")
		.append(
				$("<button>")
				.addClass("btn btn-warning")
				.attr({"id":"btnSubmitReportPdf","reportID":this.info.reportID,"reportNo":this.info.reportNo,"reportType":"1"})
				.css({margin : "2px"})
				.append($("<i>").addClass("fa fa-bar-chart"))
				.append($("<span>").html("Get PDF"))
				.click(
						function(){
							submitReport(this)
						}
					)
		)
		.append(
				$("<button>")
				.addClass("btn btn-primary")
				.attr({"id":"btnSubmitReportExcel","reportID":this.info.reportID,"reportNo":this.info.reportNo,"reportType":"2"})
				.css({margin : "2px"})
				.append($("<i>").addClass("fa fa-bar-chart"))
				.append($("<span>").html("Get Excel"))
				.click(
						function(){
							submitReport(this)
						}
				)
		)
		;
		
	}
	this.setForm=function(){
		this.form.append($("<div>").addClass("ibox float-e-margins").append(this.setupHeadTap()).append(this.setupFormTap()));
	}
	this.getForm=function(){
		this.setForm();
		return this.form;
	}
};

function submitReport(btn){
	//var reportNo = $("#"+btn.id).attr("reportNo");
	//var reportType = $("#"+btn.id).attr("reportType");
	var objReport = {
			reportID : $("#"+btn.id).attr("reportID"),
			reportNo : $("#"+btn.id).attr("reportNo") ,
			reportType : $("#"+btn.id).attr("reportType")
	};
	if (objReport.reportNo == 'M0001') {
		reportMbServiceStation(objReport);
	}

}

function reportMbServiceStation(objectReport) {
	var link = "reportMobile?t="+$("#ddlTrip").val()+"&rn="+objectReport.reportNo+"&rt="+objectReport.reportType+"&ri="+objectReport.reportID;
	window.open(link, '_blank');
}
//function reportMbServiceStation(objectReport) {
//	//ShowWaiting();
//	var url = "get-rptMbServiceStation";
//	/*
//	var data = {
//			"reportNo" : objectReport.reportNo,
//			"reportType" : objectReport.reportType,
//			"mb_trip_id" : $("#ddlTrip").val()
//	};
//	*/
//	var data = {};
//	data["reportNo"] = objectReport.reportNo;
//	data["reportType"] = objectReport.reportType;
//	data["mb_trip_id"] = $("#ddlTrip").val();
//	
//	//alert(JSON.stringify(data));
///*
//	jQuery.ajax({
//		url : url,
//		type : "Post", 
//		contentType : "application/json",
//		dataType : 'json',
//		data : JSON.stringify(data),
//		async: false,
//		cache: false,
//		success : function(result) {
//			HideWaiting();
//			showMsgSuccess('Report Success');
//		},
//		error : function() {
//			HideWaiting();
//			showMsgError('เกิดข้อผิดพลาด!');
//		}
//	}).fail(function(){
//		showMsgError('เกิดข้อผิดพลาด ในการเชื่อมต่อ!');
//		HideWaiting();
//	});	
//*/	
//	var iv_count=0;
//	var iv = setInterval(function(){ ShowWaiting();iv_count++; console.log("count["+iv_count+"]"); if(iv_count==3){clearInterval(iv);HideWaiting();} }, 1000);
//	$.ajax({
//		url : url,
//		type : "Post", 
//		contentType : "application/json",
//		dataType : 'json',
//		data : JSON.stringify(data),
//		async: false,
//		cache: false
//	})	
//	.done(function(result) {
//		showMsgSuccess('ดำเนินการสำเร็จ');
//		HideWaiting();
//	  })
//	  .fail(function() {
//		showMsgError('เกิดข้อผิดพลาด!');
//		HideWaiting();
//	  })
//	  .always(function() {
//		  //showMsgWarning('กำลังเชื่อมต่อ');
//			HideWaiting();
//	  });
//}