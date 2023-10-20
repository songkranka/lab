<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="<c:url value="/assets/js/controllers/randomMeter/randomMeterController.js" />"></script>
<style>
.checkStyle {
	transform: scale(2.0);
}
.topic-calendar {
	background-color: #1ab394;
	color : #fff;
}
</style>
<script type='text/javascript'>
/**** Declare Constant ****/
var aRandCheck = [];
var maxDayPerWeek = 2;
var txtRandomHeadTopic = "จัดการวันที่ตรวจวัดมิเตอร์";
var txtRandomTopic = "กรุณาเลือกวันที่ต้องการสุ่ม";
var weekHead = ["Sun","Mon","Tue","Wed","Thu","Fri","Sat"];
var MONTH = ["มกราคม","กุมภาพันธ์","มีนาคม","เมษายน","พฤษภาคม","มิถุนายน","กรกฎาคม","สิงหาคม","กันยายน","ตุลาคม","พฤศจิกายน","ธันวาคม"];



/***  Declare Initial  ***/
$(function(){
	$("#randomtopicmeter").html(txtRandomHeadTopic);
	$("#randomtopic").html(txtRandomTopic).css({fontSize : "20px"});
	$("#viewRandomBefDB").hide();
});
function initPlant(elename, element) {
	
	element.id = elename;
	element.addClass("form-control select2").attr({"id":elename});
	
	var url = "util-getDropdownPlant";
	var data = {}
	data["status"] = "randomoil";
	ShowWaiting();
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		data : JSON.stringify(data),
		dataType : 'json',
		success : function(result) {
			//console.log(JSON.stringify(result));
			$.each(result, function (i, item) {
				$("<option>").val(item.PID).html(item.PNAMET).appendTo(element);
			});
			HideWaiting();
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด');
		}
	}).fail(function(){
		HideWaiting();
	});	
	return element;
}
$(function(){
	ShowWaiting();
	var url = "initlistMonth";
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		dataType : 'json',
		success : function(obj) {
			var listYear = obj.listYear;
			var listMonth = obj.listMonth;
			var optYear = initSetOption("yearoption",$("<select>"),listYear,new Date().getFullYear());
			var optMonth = initSetOption("monthoption",$("<select>"),listMonth,new Date().getMonth()+1);
			var optPlant = initPlant("plantoption",$("<select>"));
			
			$("<div>").addClass("row")
			.append($("<div>").addClass("text-middle text-left col-sm-4").append($("<span>").html("เลือกปี")).append(optYear))
			.append($("<div>").addClass("text-middle text-left col-sm-4").append($("<span>").html("เลือกเดือน")).append(optMonth))
			.append($("<div>").addClass("text-middle text-left col-sm-4").append($("<span>").html("เลือกคลัง")).append(optPlant))
			//.append($("<div>").addClass("text-middle col-sm-3").append($("<button>").html("<i class=\"fa fa-search\"></i>&nbsp;ค้นหา").addClass("btn btn-primary").click(function() {setCalenderMonth($("#yearoption").val(), $("#monthoption").val());}))) 
			.appendTo($("#randomCalendarSearch"));
			$("<div>").addClass("row").css({marginTop : "10px"})
			.append($("<div>").addClass("text-middle text-right col-sm-12").append($("<button>").html("<i class=\"fa fa-search\"></i>&nbsp;ค้นหา").addClass("btn btn-primary").click(function() {setCalenderMonth($("#yearoption").val(), $("#monthoption").val());})))
			.appendTo($("#randomCalendarSearch"));
			HideWaiting();
		}
	}).fail(function(){
		HideWaiting();
	});
});
$(function() {
	
	/*
	ShowWaiting();
	var url = "selectCalendarMeter";
	var data = {};
	data["targetYear"] = new Date().getFullYear();
	data["targetMonth"] = new Date().getMonth()+1;
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		data : JSON.stringify(data),
		dataType : 'json',
		success : function(obj) {
			console.log("LOAD : Calendar > " + JSON.stringify(obj));
			
			var calendar = clientCalendarSetup(new Date());
			//console.log("Total Week >> "+ calendar[0]["DAT"].length);
			//var finalData = setupObjectCalendar(calendar);
			console.log("Client Calendar >> " + JSON.stringify(calendar));
			GenerateCalendar(obj);
			HideWaiting();
		}
	}).fail(function(){
		HideWaiting();
	});	
	*/
	///////////////////////////////////////////////////////////////////////////
	var currentDate = new Date();
	var yyyy = currentDate.getFullYear();
	var mm = currentDate.getMonth()+1;
	var appendMM = "00".substr(0,2-mm.toString().length)+mm.toString();
	console.log("load >>["+yyyy+"]["+appendMM+"]");
		//"00".substr(0,2-(currentDate.getMonth()+1).length) + ().toString();
	showRandomMeterPlantView(yyyy+appendMM);
	//GenerateCalendar(clientCalendarSetup(currentDate));
});

function setCalenderMonth(targetYear, targetMonth) {
	/*
	var url = "selectCalendarMeter";
	var data = {};
	data["targetYear"] = targetYear;
	data["targetMonth"] = targetMonth;
	
	ShowWaiting();
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		data : JSON.stringify(data),
		dataType : 'json',
		success : function(obj) {
			console.log("Generate Calendar Object.>"+JSON.stringify(obj));
			GenerateCalendar(obj);
			HideWaiting();
		}
	}).fail(function(){
		HideWaiting();
	});	
	*/
	 $(".viewTblRandomMeter").remove();
	showRandomMeterPlantView(targetYear +"00".substr(0,2-targetMonth.length) +targetMonth) ;
	//GenerateCalendar(clientCalendarSetup(new Date(targetYear,targetMonth-1,1)));
}	
function GenerateCalendar(obj) {
	
	//console.log("Genarate default : calendar >>"+JSON.stringify(obj));
	aRandCheck = [];
	generateHiddenInput(obj);
	var disAble = false;
	var listCal = obj.monthCalendar[0];
	var calender = listCal.DAT;
	var targetMonth = obj.monthName;
	var targetMonNo = obj.monthNo;
	var targetYear = obj.Year;
	var container = $("#randomCalendarContent");
	var table = $("<table>").addClass("table table-striped table-bordered").css({padding: "0px",width:"100%"});
	var thead = $("<thead>");
	var tbody = $("<tbody>");
	var currentDay = new Date();

	//console.log("target  | "+targetYear+" | "+targetMonNo);
	//console.log("current | "+currentDay.getFullYear()+" | "+currentDay.getMonth()+1);
	//console.log("");
	//console.log("");
	//console.log("DisAble status = "+disAble);
	
	if(targetYear < currentDay.getFullYear()){
		disAble = true;
	} else if(targetYear > currentDay.getFullYear()) {
		disAble = false;
	} else {
		var currentMonth = currentDay.getMonth()+1;
		if ( targetMonNo < currentMonth ){
			disAble = true;
		} else {
			disAble = false;
		} 
	}
	for(var i=0; i<calender.length;i++ ){
		aRandCheck[i] = [];
		var tr = $("<tr>");
		if(calender[i]!=null) {
			var wLen = calender[i].length;
			var h = 0;
			for(var j=0;j<wLen;j++) {
				var td = "";
				if(i>0) {
					td = $("<td>").addClass("text-left text-middle");
				} else {
					h = 1;
					td = $("<th>").addClass("text-center text-middle topic-calendar");
				}
				if(calender[i][j]!=null) {
					if(h < 1) {
						
						//console.log("i = "+i+" | j = "+j);
						aRandCheck[i][j] = $("<input>").addClass("checkStyle").attr({"id":"checkedDay"+calender[i][j],"type":"checkbox","name":"randomCheckWeek"+i, "value":i+","+j+","+calender[i][j]})
						.css({transform : "scale(2.0)",background:"none",border:"none",boxShadow:"none"});
						if(j==1){
							aRandCheck[i][j].attr({"checked":"checked"});
						}
						if(j==4){
							aRandCheck[i][j].attr({"checked":"checked"});
						}
						aRandCheck[i][j].change(function() {
							
							var weekVal = this.value.split(",");
							var week_no = weekVal[0];
							var numChecked = $("input[name=randomCheckWeek"+week_no+"]:checked" ).length;
							var weekCheck = $("input[name=randomCheckWeek"+week_no+"]" ).each(function () {
								var eachCheckBoxEle = $("#checkedDay"+this.value.split(",")[2]);
								/*
								if(numChecked == maxDayPerWeek) 
									eachCheckBoxEle.attr("disabled",((this.checked==false)?true:false)); 
								else 
									eachCheckBoxEle.attr("disabled",false);
								*/
							});
						});
						if(disAble){
							aRandCheck[i][j].attr("disabled",true);
						}
						aRandCheck[i][j].appendTo(td);
					}
					td.append($("<span>").css({paddingLeft : "15px",fontSize : "21px",fontWeight : "bold"}).html(calender[i][j]));
				} else {
					td.append($("<span>"));
				}
				
				tr.append(td);
			}
			if ( i > 0 ) tbody.append(tr); else thead.append(tr);
		}
		table.append(thead).append(tbody);
	}
	container.html("");
	container.append($("<div>").addClass("row").append($("<div>").addClass("col-lg-12 text-center text-middle").append($("<span>").css({fontSize : "25px",textDecorationLine : "Underline"}).html(targetMonth + " " + targetYear))).append($("<div>").addClass("col-lg-12 text-right text-middle").append((disAble==false) ? $("<button>").html("<i class=\"fa fa-search\"></i>&nbsp;สุ่ม").addClass("btn btn-primary").click(function(){randomHandle()}):$("<div>"))));
	container.append(table);
}
function clientCalendarSetup(newDate) {
	var calendarObject = {};
	var calendarArray = [];

	calendarArray[0] = {};
	calendarArray[0]["DAT"] = [];
	calendarArray[0]["DAT"].push(weekHead);
	
	var dfirstDay = new Date(newDate.getFullYear(), newDate.getMonth(), 1);
	var dlastDay = new Date(newDate.getFullYear(), newDate.getMonth() + 1, 0);
	var dayFirst = dfirstDay.getDate();
	var dayLast = dlastDay.getDate();
	var dateNumber = newDate.getMonth();
	var weekno = 1;
	calendarArray[0]["DAT"][weekno] = [];
	for( var d = dayFirst; d <= dayLast; d++ ) {
		var pointDate = new Date(newDate.getFullYear(), newDate.getMonth(), d);
		var dayOfWeek = pointDate.getDay() ;
		calendarArray[0]["DAT"][weekno][dayOfWeek] = pointDate.getDate();
		if ( pointDate.getDay()==6 ) {
			weekno++;
			calendarArray[0]["DAT"][weekno] = [];
		}
	}
	//console.log(" =================================================== ");

	calendarObject["totalWeek"] = calendarArray[0]["DAT"].length;
	calendarObject["monthNo"] = newDate.getMonth()+1;
	calendarObject["monthName"] = MONTH[newDate.getMonth()];
	calendarObject["Year"] = newDate.getFullYear();
	calendarObject["defaultPlant"] = null;
	calendarObject["monthCalendar"] = calendarArray;
	
	return calendarObject;
}
function generateHiddenInput(obj) {

	console.log("---- Re Declare Hidden Input ----");
	var totalWeek = obj.totalWeek-1;
	console.log("---- totalWeek = ("+totalWeek+") ----");
	//console.log("Gen hidden : "+JSON.stringify(obj));
	$(".hideinput").remove();
	$("<input>").attr({"type":"hidden","id":"totalweek"}).addClass("hideinput").val(totalWeek).appendTo($("#hiddeninput"));
	$("<input>").attr({"type":"hidden","id":"selectYear"}).addClass("hideinput").val(obj.Year).appendTo($("#hiddeninput"));
	$("<input>").attr({"type":"hidden","id":"selectMonth"}).addClass("hideinput").val(obj.monthNo).appendTo($("#hiddeninput"));
}
function randomHandle() {
	//var listInput =  $("input[name=randomCheckWeek"+1+"]" );
	var totalWeek = $("#totalweek").val();
	//console.log("Total Week = "+totalWeek);
	
	var listDay = setupListDay({
		"totalWeek":totalWeek
	});
	var listPlantMeter = setupListPlant({
		"plantId":$("#plantoption").val()
	});
	//console.log("LIST PLANT ===>> "+JSON.stringify(listPlantMeter));
	var arrayDayRandom = listDay.arrayDay;
	var flagChooseDay = listDay.flagChooseWeekDay;
	
	//console.log("current flag day ===> "+flagChooseDay);
	
	if(flagChooseDay == false) {
		showMsgWarning('กรุณาเลือกวันที่ต้องการจะสุ่ม โดยเลือก 2 วันต่อสัปดาห์ หรือ เลือกอย่างน้อย 1 วัน');
		console.log('กรุณาเลือกวันที่ต้องการจะสุ่ม โดยเลือก 2 วันต่อสัปดาห์ หรือ เลือกอย่างน้อย 1 วัน');
	} else {
		if(arrayDayRandom == null){
			showMsgError('เกิดข้อผิดพลาด ในการจัดเตรียมข้อมูล');
			console.log('เกิดข้อผิดพลาด ในการจัดเตรียมข้อมูล');
		} else {
			var listObj = [];
			var numOfWeek = arrayDayRandom.length;
			var lenOfPlant = listPlantMeter.length;
			//console.log("    daynumOfWeek ["+numOfWeek+"] ");
			//console.log("    lenOfPlant ["+lenOfPlant+"] ");
			$.each(listPlantMeter, function(i,item) {
				//console.log("iTem Plant("+i+") "+JSON.stringify(item)+" ");
				//console.log(Object.keys(item)[0]);
				//console.log("iTem Plant("+i+") " + JSON.stringify(item)+" index_0 = "+JSON.stringify(item[Object.keys(item)[0]]));
				if( item[Object.keys(item)[0]] != null ) {
					var arrayMeter = item[Object.keys(item)[0]];
					//console.log(JSON.stringify(arrayMeter));
					var lenOfMeterPlant = arrayMeter.length;
					if( lenOfMeterPlant > 0 ) {
						$.each(arrayDayRandom,function(w,week){
							var firstRandom = Math.floor(Math.random() * lenOfMeterPlant) ;
							var secoundRandom = null ;
							var index = firstRandom;
							var lenOfWeek = week.length;
							
							var dayCount = 1;
							$.each(week, function(d, day){
								if( dayCount > 1 ) {
									secoundRandom = Math.floor(Math.random() * lenOfMeterPlant) ;
									while( secoundRandom == firstRandom ) {
										secoundRandom = Math.floor(Math.random() * lenOfMeterPlant) ;
										if( secoundRandom != firstRandom ) {
											break;
										}
									}

									index = secoundRandom;
								}
								//console.log("w["+w+"] day["+day+"/"+$('#selectMonth').val()+"/"+$('#selectYear').val()+"] index="+index+"  explan_arrayMeter = "+JSON.stringify(arrayMeter[index]));
								
								listObj.push({
									transId : arrayMeter[index].transId,
									workDtm : day+"/"+$('#selectMonth').val()+"/"+$('#selectYear').val(),
									seq : arrayMeter[index].seq,
									plantId : arrayMeter[index].plantId,
									plantName : arrayMeter[index].plantName,
									meterNo : arrayMeter[index].meterNo,
									productId : arrayMeter[index].productId,
									productName : arrayMeter[index].productName,
									createBy : $("#codempid").val(),
									updateBy : $("#codempid").val()
								});
								dayCount++;
							});
							//////////////////////////////////////////////////////
							/*
							if(lenOfWeek == 1){
								//console.log("    week "+JSON.stringify(week)+" ");
								console.log("plant("+i+")Random 1 wk("+w+") day("+week[0]+"/"+$('#selectMonth').val()+"/"+$('#selectYear').val()+") ||    index = "+firstRandom+"  explan_arrayMeter = "+JSON.stringify(arrayMeter[firstRandom]));
								listObj.push(generateRamdomObject({
									
								}));
							} else if(lenOfWeek == 2) {
								
								console.log("plant("+i+")Random 1 wk("+w+") day("+week[0]+"/"+$('#selectMonth').val()+"/"+$('#selectYear').val()+") ||    index = "+firstRandom+"  explan_arrayMeter = "+JSON.stringify(arrayMeter[firstRandom]));
								
								while( secoundRandom == firstRandom ) {
									secoundRandom = Math.floor(Math.random() * lenOfMeterPlant) ;
									if( secoundRandom != firstRandom ) {
										break;
									}
								}
								console.log("plant("+i+")Random 2 wk("+w+") day("+week[0]+"/"+$('#selectMonth').val()+"/"+$('#selectYear').val()+") ||    index = "+secoundRandom+"  explan_arrayMeter = "+JSON.stringify(arrayMeter[secoundRandom]));
							}
							*/
							//////////////////////////////////////
							
						});
						
					}	//else {
						//console.log(" PLANT ("+arrayMeter+") = null ");
					//}				
				}
				//console.log(" ");
			});
			//console.log(" "+JSON.stringify(listObj));
			generateViewRandom(listObj);
		}
	}
}
function generateRamdomObject(RandObj){
	var res = {};
	
	return res;
}
function setupListDay(obj){
	
	var res={};
	var aDayRandom = [];
	var flgChooseWeekDay = false;
	
	for( var i = 0 ; i < obj.totalWeek ; i++ ) {
		aDayRandom[i] = [];
		var week = i+1;
		var daySeq = 0;
		//console.log("randomCheckWeek"+week);
		$("input[name=randomCheckWeek"+week+"]" ).each(function () {
			var day = this.value.split(",")[2];
			var chkBox = $("#checkedDay" + day);
			var flagCheck = chkBox.is(':checked');
			if(flagCheck == true ) {
				//console.log("  ("+i+","+daySeq+")day ["+day+"] "+flagCheck);
				aDayRandom[i][daySeq++] = day;
				flgChooseWeekDay = true;
			}
		});
	}
	res["arrayDay"] = aDayRandom;
	res["flagChooseWeekDay"] = flgChooseWeekDay;
	return res;
}
function setupListPlant(obj){
	//var listMeterPlant = [];
	var listPlant = [];
	var data={};
	var url = "getMeterPlant";
	if(obj.plantId!="ALL"){
		var arrObj = {};
		arrObj[obj.plantId] = [];	
		
		listPlant.push(arrObj);
	} else {
		$.each(GLOBAL_PLANT_ID, function (i, plant) {
			var arrObj = {};
			arrObj[plant] = [];	
			listPlant.push(arrObj);
		});
	}

	data["listPlant"] = obj.plantId;
	data["flagAll"] = obj.plantId;
	
	jQuery.ajax({
		url : url,
		type : "Post", 
		contentType : "application/json",
		dataType : 'json',
		data : JSON.stringify(data),
		async: false,
		cache: false,
		success : function(result) {
			//console.log("fetch after setup plant meter");
			//console.log(JSON.stringify(result));
			 $.each(result.resultMeter, function (i, item) {
				 ///console.log(i +" ===>> "+JSON.stringify(item));
				 //METER_NO
				 var plant = item.PLANT_ID;
				 //console.log("i("+i +") ===>> "+plant);
				 $.each(listPlant,function (j, item2) {
					 if( listPlant[j][plant] != undefined  ) {
						 	//console.log("  j("+j+") ===>> "+listPlant[j][plant] + " |> item["+JSON.stringify(item.METER_NO)+"]");
						 	var masterMeter = {};
						 	listPlant[j][plant].push({
						 		transId : "",
						 		seq : item.RANDOM_METER_ID,
						 		plantId : item.PLANT_ID,
						 		plantName : item.PLANT_NAME,
						 		meterNo : item.METER_NO,
						 		productId : item.PRODUCT_ID,
						 		productName : item.PRODUCT_NAME
						 	})
						 	//console.log("  j("+j+") ===>> "+JSON.stringify(listPlant[j][plant]) + " |> item["+item2[plant]+"]");
						 	//console.log(j+" ===>> "+JSON.stringify(item2[plant]));
					 }
				 });
				 
		    }); 
			 //console.log(" ===>> "+JSON.stringify(listPlant));
			 
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด!');
		}
	});
	return listPlant;
}
function generateViewRandom(arrayRandomMeter) {
	
	$("#viewRandomBefDB").show();
	$("#viewTableRandomMeter").html("");
	
	console.log("GenerateViewRandom : >> "+JSON.stringify(arrayRandomMeter));

	var table = $("<table>").addClass("table table-striped table-bordered").css({padding: "0px",width:"100%"});
	var thead = $("<thead>");
	var tbody = $("<tbody>");

	$("<tr>")
	.append($("<th>").addClass("text-middle text-center").css({width:"1%"}).html("ลำดับ"))
	.append($("<th>").addClass("text-middle text-left").css({width:"35%"}).html("คลัง"))
	.append($("<th>").addClass("text-middle text-center").css({width:"14%"}).html("วันที่ออกตรวจ"))
	.append($("<th>").addClass("text-middle text-left").css({width:"20%"}).html("เลขมิเตอร์"))
	.append($("<th>").addClass("text-middle text-left").css({width:"30%"}).html("ผลิตภัณฑ์"))
	.appendTo(thead);
	
	$.each(arrayRandomMeter, function(i, meter){
		$("<tr>")
		.append($("<td>").addClass("text-middle text-center").html(i+1))
		.append($("<td>").addClass("text-middle text-left").html(meter.plantId+" -- "+meter.plantName))
		.append($("<td>").addClass("text-middle text-center").html(meter.workDtm))
		.append($("<td>").addClass("text-middle text-left").html(meter.meterNo))
		.append($("<td>").addClass("text-middle text-left").html(meter.productName))
		.appendTo(tbody)
	});

	//console.log("generateViewRandom ===  "+JSON.stringify(arrayRandomMeter));
	
	table
	.append(thead)
	.append(tbody)
	//.DataTable({
	//	searching: true,
	//	responsive : true
	//})
	;

	$("<div>").addClass("row viewTblRandomMeter")
	.append($("<div>").addClass("text-middle text-left col-sm-12").append(table))
	.appendTo($("#viewTableRandomMeter"));
	

	$("<div>").addClass("row viewTblRandomMeter")
	.append($("<div>").addClass("text-middle text-right col-sm-12").append($("<button>").html("<i class=\"fa fa-search\"></i>&nbsp;บันทึก").addClass("btn btn-primary").click(function() {saveRamdomMeter(arrayRandomMeter);})))
	.appendTo($("#viewTableRandomMeter"));
	
}
function saveRamdomMeter(arrRandomMeter) {
	console.log("saveRamdomMeter >>"+JSON.stringify(arrRandomMeter));
	//console.log(JSON.stringify(arrRandomMeter[0]));
	ShowWaiting() ;
	var url = "saveRandomMeter";
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		data : JSON.stringify(arrRandomMeter),
		dataType : 'json',
		success : function(result) {
			//console.log("result : "+JSON.stringify(result));
			if(result.pResult==1){
				showMsgSuccess('บันทึกสำเร็จ');
				showRandomMeterPlantView(arrRandomMeter[0].workDtm.split("/")[2].toString()+("00".substr(0,2-arrRandomMeter[0].workDtm.split("/")[1].length)+arrRandomMeter[0].workDtm.split("/")[1]));
			} else {
				showMsgError('เกิดข้อผิดพลาด '+result.pMessage);
			}
			HideWaiting();
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด '+result.pMessage);
			HideWaiting();
		}
	}).fail(function(){
		showMsgError('เกิดข้อผิดพลาด '+result.pMessage);
		HideWaiting();
	});		
}
function updateRamdomMeter(dataList){
	console.log(JSON.stringify(dataList));
	//console.log(JSON.stringify(arrRandomMeter[0]));
	ShowWaiting() ;
	var url = "updateRandomMeter";
	jQuery.ajax({
		url : url,
		type : 'Post',
		async: false,
		cache: false,
		contentType : 'application/json',
		data : JSON.stringify(dataList),
		dataType : 'json',
		success : function(result) {
			console.log("result : "+JSON.stringify(result));
			if(result.pResult==1){
				showMsgSuccess('บันทึกสำเร็จ');
				//showRandomMeterPlantView(arrRandomMeter[0].workDtm.split("/")[2].toString()+("00".substr(0,2-arrRandomMeter[0].workDtm.split("/")[1].length)+arrRandomMeter[0].workDtm.split("/")[1]));
			} else {
				showMsgError('เกิดข้อผิดพลาด '+result.pMessage);
			}
			HideWaiting();
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด '+result.pMessage);
			HideWaiting();
		}
	}).fail(function(){
		showMsgError('เกิดข้อผิดพลาด '+result.pMessage);
		HideWaiting();
	});			
}
function showRandomMeterPlantView(pointDate) {
	console.log("start show Random view = "+pointDate);
	console.log(" By PLANT ID = "+$("#plantoption").val());
	
	var url = "viewRandomMeter";
	var data = {};
	data["workMonth"] = pointDate;
	data["plantId"] = $("#plantoption").val();

	console.log(url+ " : param>>"+JSON.stringify(data));
	jQuery.ajax({
		url : url,
		type : "Post", 
		contentType : "application/json",
		dataType : 'json',
		data : JSON.stringify(data),
		success : function(result) {
			
			// console.log("response ajax : server >>"+JSON.stringify(result));
		
			var meterPlantList = result.resultList;
			var len = meterPlantList.length;
			//console.log("Len >> "+ len);
			if(len > 0) {
				console.log(">>>"+ JSON.stringify(meterPlantList));
				//$.each(result.resultMeter, function (i, item) {}); 
				manageHistoryMeter(meterPlantList);
			}else{
				console.log("nohave datasource = "+pointDate);
				var targetYear = pointDate.substr(0,4);
				var targetMonth = pointDate.substr(4,2);
				console.log("target calendar : y["+targetYear+"] m["+targetMonth+"]");
				//console.log("target Date > "+new Date(targetYear,targetMonth-1,1));
				GenerateCalendar(clientCalendarSetup(new Date(targetYear,targetMonth-1,1)));
			}
		
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด!');
		}
	});
}
function manageHistoryMeter(dataList){

	console.log("manageHistory : Calendar >>"+JSON.stringify(dataList));
	var info = explandDataList(dataList);
	console.log("print info >>"+JSON.stringify(info));
	generateHiddenInput(info);

	var isAble = false;
	var currentDate = new Date();
	var calender = info.monthCalendar.DAT;
	var targetMonth = info.monthName;
	var targetYear = info.Year;
	var targetMonthNo = info.monthNo;
	var container = $("#randomCalendarContent");
	var table = $("<table>").addClass("table table-striped table-bordered").css({padding: "0px",width:"100%"});
	var thead = $("<thead>");
	var tbody = $("<tbody>");	
	
	//console.log("Manage History >> targetYearMonth["+targetYear+"_"+targetMonthNo+"] | currentYearMonth["+currentDate.getFullYear()+"_"+(currentDate.getMonth()+1)+"]");
	if(parseInt(targetYear) < currentDate.getFullYear()) {
		//console.log("targetYear < currentYear");
		isAble = true;
	} else if(targetYear == currentDate.getFullYear()) {
		//console.log("targetYear == currentYear");
		if(parseInt(targetMonthNo) < (currentDate.getMonth()+1)) {
			//console.log("targetMonth < currentMonth");
			isAble = true;
		} else {
			//console.log("targetMonth >= currentMonth");
			//isAble = false;
			isAble = true;
		}
	} else {
		//console.log("targetYear > currentYear");
		//isAble = false;
		isAble = true;
	}
	//console.log ("IsAble = "+isAble);
	aRandCheck = [];
	for(var i=0; i<calender.length;i++ ) {
		aRandCheck[i] = [];
		var tr = $("<tr>");
		if(calender[i]!=null) {
			var wLen = calender[i].length;
			var h = 0;
			for(var j=0;j<wLen;j++) {
				var td = "";
				if(i>0) {
					td = $("<td>").addClass("text-left text-middle");
				} else {
					h = 1;
					td = $("<th>").addClass("text-center text-middle topic-calendar");
				}
				if(calender[i][j] != null) {
					if(h < 1) {
						aRandCheck[i][j] = $("<input>").addClass("checkStyle").attr({"id":"checkedDay"+calender[i][j][0],"type":"checkbox","name":"randomCheckWeek"+i,"value":i+","+j+","+calender[i][j][0],"checked":(calender[i][j][1]=="Y"?true:false),"disabled":isAble,"valCheck":(h<1?(calender[i][j][0]!=null?calender[i][j][0]:""):"") }).css({transform : "scale(2.0)",background:"none",border:"none",boxShadow:"none"});
						/*
						if(isAble == false){
							aRandCheck[i][j].change(function() {
								var weekVal = this.value.split(",");
								var week_no = weekVal[0];
								var numChecked = $("input[name=randomCheckWeek"+week_no+"]:checked" ).length;
								var weekCheck = $("input[name=randomCheckWeek"+week_no+"]" ).each(function () {
									var eachCheckBoxEle = $("#checkedDay"+this.value.split(",")[2]); 
									if(numChecked == maxDayPerWeek) eachCheckBoxEle.attr("disabled",((this.checked==false)?true:false)); else eachCheckBoxEle.attr("disabled",false);
								});
							});
						}
						*/
						aRandCheck[i][j].appendTo(td);
					}
					
					td.append($("<span>").css({paddingLeft : "15px",fontSize : "21px",fontWeight : "bold"}).html(h>0?calender[i][j]:calender[i][j][0]));
				} else {
					td.append($("<span>"));
				}
				tr.append(td);
			}
			if ( i > 0 ) tbody.append(tr); else thead.append(tr);
		}
		table.append(thead).append(tbody);
	}
	
	container.html("");
	// if(isAble==false)container.append($("<div>").addClass("row").append($("<div>").addClass("col-lg-12 text-center text-middle").append($("<span>").css({fontSize : "25px",textDecorationLine : "Underline"}).html(targetMonth + " " + targetYear))).append($("<div>").addClass("col-lg-12 text-right text-middle").append($("<button>").html("<i class=\"fa fa-search\"></i>&nbsp;สุ่ม").addClass("btn btn-primary").click(function(){randomHandle()}))));
	// else container.append($("<div>").addClass("row").append($("<div>").addClass("col-lg-12 text-center text-middle").append($("<span>").css({fontSize : "25px",textDecorationLine : "Underline"}).html(targetMonth + " " + targetYear))).append($("<div>").addClass("col-lg-12 text-right text-middle")));
			
	container.append($("<div>").addClass("row").append($("<div>").addClass("col-lg-12 text-center text-middle").append($("<span>").css({fontSize : "25px",textDecorationLine : "Underline"}).html(targetMonth + " " + targetYear))).append($("<div>").addClass("col-lg-12 text-right text-middle")));
	container.append(table);
	
	if(isAble==false)
	for(var w = 0; w <= aRandCheck.length; w++){
		if( (aRandCheck[w] != undefined) && (aRandCheck[w] != "") ) {
			var weekLen = aRandCheck[w].length;
			var numChecked = $("input[name=randomCheckWeek"+w+"]:checked" ).length;
			var weekCheck = $("input[name=randomCheckWeek"+w+"]" ).each(function () {
				var eachCheckBoxEle = $("#checkedDay"+this.value.split(",")[2]); 
				if(numChecked == maxDayPerWeek) eachCheckBoxEle.attr("disabled",((this.checked==false)?true:false)); else eachCheckBoxEle.attr("disabled",false);
			});	
		}
	}
	else
	for(var w = 0; w <= aRandCheck.length; w++){
		if( (aRandCheck[w] != undefined) && (aRandCheck[w] != "") ) {
			var weekLen = aRandCheck[w].length;
			var numChecked = $("input[name=randomCheckWeek"+w+"]:checked" ).length;
			var weekCheck = $("input[name=randomCheckWeek"+w+"]" ).each(function () {
				var eachCheckBoxEle = $("#checkedDay"+this.value.split(",")[2]); 
				eachCheckBoxEle.attr("disabled",true); 
			});	
		}
	}
	$("#viewRandomBefDB").show();
	$("#viewTableRandomMeter").html("");
	
	//console.log("GenerateViewRandom from DB : >> "+JSON.stringify(dataList));

	var table = $("<table>").addClass("table table-striped table-bordered").css({padding: "0px",width:"100%"});
	var thead = $("<thead>");
	var tbody = $("<tbody>");

	$("<tr>")
	.append($("<th>").addClass("text-middle text-center").css({width:"1%"}).html("ลำดับ"))
	.append($("<th>").addClass("text-middle text-left").css({width:"35%"}).html("คลัง"))
	.append($("<th>").addClass("text-middle text-center").css({width:"14%"}).html("วันที่ออกตรวจ"))
	.append($("<th>").addClass("text-middle text-left").css({width:"20%"}).html("เลขมิเตอร์"))
	.append($("<th>").addClass("text-middle text-left").css({width:"30%"}).html("ผลิตภัณฑ์"))
	.appendTo(thead);
	
	$.each(dataList, function(i, meter){
		$("<tr>")
		.append($("<td>").addClass("text-middle text-center").html(i+1))
		.append($("<td>").addClass("text-middle text-left").html(meter.PLANT_ID+" -- "+meter.PLANT_NAME))
		.append($("<td>").addClass("text-middle text-center").html(meter.WORK_DTM))
		.append($("<td>").addClass("text-middle text-left").html(meter.METER_NO))
		.append($("<td>").addClass("text-middle text-left").html(meter.PRODUCT_NAME))
		.appendTo(tbody)
	});
	
	table
	.append(thead)
	.append(tbody)
	//.DataTable({
	//	searching: true,
	//	responsive : true
	//})
	;

	$("<div>").addClass("row viewTblRandomMeter")
	.append($("<div>").addClass("text-middle text-left col-sm-12").append(table))
	.appendTo($("#viewTableRandomMeter"));

	if(isAble==false) {
		//$("<div>").addClass("row viewTblRandomMeter")
		//.append($("<div>").addClass("text-middle text-right col-sm-12").append($("<button>").html("<i class=\"fa fa-search\"></i>&nbsp;บันทึก").addClass("btn btn-primary").click(function() {})))
		//.appendTo($("#viewTableRandomMeter"));
	}
	
		
}
function explandDataList(dataList) {
	var result={};
	var thisYear = "";
	var thisMonth = "";
	var arrayDay = [];
	var calendarArray = {};
	calendarArray["DAT"] = [];
	calendarArray["DAT"].push(weekHead);
	
	$.each(dataList,function(i,row){
		var arrayDateWork = row.WORK_DTM.split("/");
		thisYear = arrayDateWork[2];
		thisMonth = arrayDateWork[1];
		
		//console.log("Day >>>> "+parseInt(arrayDateWork[0]));
		//console.log("work_dtm >>>> "+row.WORK_DTM);
		//console.log("work_day >>>> "+thisYear);
		//console.log("work_mon >>>> "+thisMonth);
		
		arrayDay[parseInt(arrayDateWork[0])]=parseInt(arrayDateWork[0]);
	});
	thisMonth = parseInt(thisMonth) - 1;
	console.log("  thisYear : "+thisYear);
	console.log("  thisMonth : "+thisMonth);
	
	var tarDate = new Date(parseInt(thisYear),parseInt(thisMonth),1);
	var lastday = new Date(parseInt(thisYear),parseInt(thisMonth)+1,0);

	console.log("first date : "+tarDate);
	console.log("Last date : "+lastday);

	console.log("  targetYear : "+tarDate.getFullYear());
	console.log("  TargetMonth : "+tarDate.getMonth());
	console.log("  lastYear : "+lastday.getFullYear());
	console.log("  lastMonth : "+lastday.getMonth());

	//console.log("  thisDay : "+JSON.stringify(arrayDay));
	//console.log("  Last Date : "+lastday.getDate());

	var weekno = 1;
	calendarArray["DAT"][weekno] = [];
	for( var d = 1; d <= lastday.getDate(); d++ ) {
		
		var pointDate = new Date(tarDate.getFullYear(), tarDate.getMonth(), d);
		//console.log("   Loop month : "+pointDate);
		var dayOfWeek = pointDate.getDay() ;
		calendarArray["DAT"][weekno][dayOfWeek] = new Array(pointDate.getDate(),(arrayDay[d]==d)?"Y":"N");
		if ( pointDate.getDay()==6 ) {
			weekno++;
			calendarArray["DAT"][weekno] = [];
		}
	}
	result["totalWeek"] = weekno;
	result["monthNo"] = tarDate.getMonth();
	result["monthName"] = MONTH[tarDate.getMonth()];
	result["Year"] = tarDate.getFullYear();
	result["defaultPlant"] = null;
	result["monthCalendar"] = calendarArray;

	return result;
}

</script>
<div id="hiddeninput">
	<input type="hidden" id="codempid" value="${USER_LOGIN}">
	<input type="hidden" id="defplant" value="${PLANT_ID}">
</div>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-12">
        <h2><span id="randomtopicmeter"></span></h2>
    </div>
    <div class="col-lg-2"></div>
</div>
<div class="wrapper wrapper-content animated fadeInRight"> 
	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
		    	<div class="ibox-content"> 
		    		<div id="randomCalendarSearch">

		    		</div>
		    	</div>
		    </div>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5><span id="randomtopic"></span></h5>
					<div class="ibox-tools">
						<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>
					</div>				
				</div>
		    	<div class="ibox-content"> 
		    		<div id="randomCalendarContent">
			    			    		
		    		</div>
		    	</div>
		    </div>
		</div>
	</div>

	<div class="row">
		<div class="col-lg-12">
			<div class="ibox float-e-margins" id="viewRandomBefDB" >
		    	<div class="ibox-content"> 
		    		<div id="viewTableRandomMeter">
			    			    		
		    		</div>
		    	</div>
		    </div>
		</div>
	</div>
</div>
