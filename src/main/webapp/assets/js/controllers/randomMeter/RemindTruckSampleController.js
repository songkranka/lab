var txtTabStatus01 = "รายการเตือน การเก็บตัวอย่าง";
var txtTabStatus02 = "ส่งตัวอย่างแล้ว";
var txtTabStatus03 = "ส่งใบคำขอวิเคราะห์";
var txtTabStatus04 = "แลปตีกลับตัวอย่าง";
var txtTabStatus05 = "บันทึกรับเรียบร้อย";
var txtTopicListView = "รายการเก็บตัวอย่างประจำเดือน";
var MONTH = ["มกราคม","กุมภาพันธ์","มีนาคม","เมษายน","พฤษภาคม","มิถุนายน","กรกฎาคม","สิงหาคม","กันยายน","ตุลาคม","พฤศจิกายน","ธันวาคม"];
class initTruckRemindingView {
	
	constructor() {
		this.container = $("<div>").addClass("row").attr({"id":"listTruckContainer"});
		this.createViewRemindJob();
	}
	createViewRemindJob(){
		//console.log("createViewRemindJob.............................");
		console.log("this.currentMonth = "+this.currentMonth);
		var url = "getListViewRemindJob";
		jQuery.ajax({
			url : url,
			type : "Post", 
			contentType : "application/json",
			dataType : 'json',
			//data : JSON.stringify(data),
			//async: false,
			//cache: false,
			success : function(result){
				//console.log(JSON.stringify(result));
				var dataList = result.resultList;
				var containerView = $("#listTruckContainer");
				
				if (dataList.length > 0) {
					/*
					var tabStatus = [];
					$.each(dataList, function(i, meter){
						//console.log("STATUS_RANDOM i["+i+"] = "+meter.STATUS_RANDOM+" >>convert to int >>"+parseInt(meter.STATUS_RANDOM));
						var statusId = parseInt(meter.STATUS_RANDOM);
						if(tabStatus[statusId] == undefined) {
							tabStatus[statusId] = {
									title : (statusId==1)?txtTabStatus01
											:(statusId==2)?txtTabStatus02
											:(statusId==3)?txtTabStatus03
											:(statusId==4)?txtTabStatus04
											:"",
									status : meter.STATUS_RANDOM
							};
						}
					});
					*/
					//console.log("list data = "+JSON.stringify(tabStatus));
					//$.each(tabStatus,function(j,status) {
					
						//if(status != null) {
							//$("#listTruckContainer .row .col-lg-12 .ibox")
							//.append($("<div>").addClass("ibox-title").html("333"));
							//$("<div>").addClass("ibox-title").html(status.title).insertBefore(".ibox-content");
							var table =  $("<table>").addClass("table table-striped table-bordered").css({padding: "0px",width:"100%"});
							
							$("<thead>").addClass("tbHeader")
							.append(
								$("<tr>")
								.append($("<th>").addClass("text-center text-middle").html("วันที่"))
								.append($("<th>").addClass("text-center text-middle").html("เลขมิเตอร์"))
								.append($("<th>").addClass("text-center text-middle").html("ผลิตภัณฑ์"))
								.append($("<th>").addClass("text-center text-middle").html("สถานะ"))
							)
							.appendTo(table);
							var tbody = $("<tbody>");
							$.each(dataList, function(i, meter){
								//console.log("["+JSON.stringify(status.status)+"]run data list >>>>>"+JSON.stringify(meter.STATUS_RANDOM));
								//if(status.status == meter.STATUS_RANDOM){
									$("<tr>").addClass("tbBody")
									.append(
										$("<td>").addClass("text-center text-middle")
											.append(
												(meter.STATUS_RANDOM!="01" && meter.STATUS_RANDOM!="04")?$("<div>").html(meter.WORK_DTM):$("<a>").attr({"href":"#"}).html("<strong>"+meter.WORK_DTM+"</strong>").click(function(){saveSampleTruck(meter)})
											)
										)
									.append($("<td>").addClass("text-center text-middle").html(meter.METER_NO))
									.append($("<td>").addClass("text-left text-middle").html(meter.PRODUCT_NAME))
									.append($("<td>").addClass("text-left text-middle").html(
											(meter.STATUS_RANDOM=="01")?txtTabStatus01:
												(meter.STATUS_RANDOM=="02")?txtTabStatus02:
													(meter.STATUS_RANDOM=="03")?txtTabStatus03:
														(meter.STATUS_RANDOM=="04")?txtTabStatus04:
															(meter.STATUS_RANDOM=="05")?txtTabStatus05:""	
										))
									.appendTo(tbody)	
								//}
							});
							table.append(tbody);
							table.appendTo(
							$("<div>").addClass("table-responsive").appendTo(
								$("<div>").addClass("col-xs-12").appendTo(
									$("<div>").addClass("row").appendTo(
										$("<div>").addClass("ibox-content").appendTo(
												
											$("<div>").addClass("ibox float-e-margins")
											.append(
												$("<div>").addClass("ibox-title").append(
														$("<h3>").append($("<span>").html(txtTopicListView + " " + MONTH[new Date().getMonth()] + " " + new Date().getFullYear() ))
												)
												
											)
											.appendTo(
												$("<div>").addClass("col-lg-12").appendTo(
													$("<div>").addClass("row").appendTo(
														containerView
													)
												)
											)
											
										)
									)
								)
							)
							);

							table.DataTable({
								searching: true,
								responsive : true
							});
						//}
					//});
				}
				
			},
			error : function() {
				showMsgError('เกิดข้อผิดพลาด!');
			}
		});	
	}
	getView() {
		return this.container;
	}
	
}

function saveSampleTruck(RowMeter) {
	console.log("to SaveTruck >>> "+JSON.stringify(RowMeter));
	var link = "initSampleResult?sampleType=00003"
		+"&randommeterno="+RowMeter.RANDOM_METER_ID
		+"&meterno="+RowMeter.METER_NO
		+"&datework="+RowMeter.WORK_DTM
		+"&plantid="+RowMeter.PLANT_ID
		+"&productid="+RowMeter.PRODUCT_ID
		+"";
	window.location = link;
}
