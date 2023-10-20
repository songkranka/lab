var tranfer_valueLogi = "";
var tranfer_samplyType = "";
var tranfer_randomId = "";
var tranfer_meterNo = "";
var tranfer_dateWork = "";
var tranfer_plantId = "";
var tranfer_productId = "";
var tranfer_remind_flag = "";
var changeIn = "";
var sampleTypeCodex = "";
var productDropdown ;


var dataGlobalDropDownStore ;
var dataGlobalDropDownTypeStation ;
var dataGlobalDropDownSavePoint ;
var dataGlobalDropDownLogisticBoat ;
var dataGlobalDropDownSource ;
var dataGlobalDropDownProduct ;
var dataGlobalDropDownLogistic ;
var dataGlobalGetSample;
var dataGlobalSampleType;
var dataGlobalSubType;

var ddlSourceStr ;


var plantIDDefult = "";
var basePath = '/Lab/api/';
//check plant
$(function checkLevel(){
	//userTypeSetText = "level";
	try{
		var data = {};
		//console.log(JSON.stringify(data));
        ShowWaiting();
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'getLevelHead',
            data : JSON.stringify(data),
            dataType: 'json',
            async: false,
            cache: false,
            success : function(data) {
            	plantIDDefult = data.list[0].PLANT_ID;
            	
                HideWaiting();                
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });
    }catch (ex) {
        HideWaiting();
        showMsgError(ex);
    }

});
$(function() {
    if (window.location.href.indexOf('?') > 0) {

        var url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
        //console.log("Truck from Reminding >>"+JSON.stringify(url));

        tranfer_remind_flag = "Y";
        tranfer_samplyType = url[0].split("=")[1];
        tranfer_randomId = url[1].split("=")[1];
        tranfer_meterNo = url[2].split("=")[1];
        tranfer_dateWork = url[3].split("=")[1];
        tranfer_plantId = url[4].split("=")[1];
        tranfer_productId = url[5].split("=")[1];

    }
});

var table = "";
$(document).ready(function() {

	SetDropDownGetSample()
	SetDropDownSampleType()
	SetDropDownStore()
	SetDropDownTypeStation()
	SetDropDownSavePoint()
	SetDropDownLogisticBoat()
	SetDropDownSource()
	SetDropDownProduct()
	SetDropDownLogistic()
	SetDropDownSubType()
    renderDropDownSourceT();
    defaultData();

    if (tranfer_remind_flag == "Y") {
        $('#sampleDate').val(tranfer_dateWork);
    }
    $('#ddlSampleType').on('change',function(){
    	clearData()
    	
    })
   
 $(document).on('change','#ddlTsubType',function(){
	
    if($('#ddlTsubType').val()=='001'&&$('#ddlSampleType').val()=='00004'){
	
		$('#ddlTsubTypeDetail').attr("placeholder", "เช่น หลังดันปนเปื้อนน้ำ PTC. บางเลน 5");
		
	}else if($('#ddlTsubType').val()=='003'&&$('#ddlSampleType').val()=='00004'){
		
		$('#ddlTsubTypeDetail').attr("placeholder", "เช่น ตัวอย่างประจำเดือน ก.พ. 64 ครั้งที่1");
		
	}else if($('#ddlTsubType').val()=='005'&&$('#ddlSampleType').val()=='00004'){
		
		$('#ddlTsubTypeDetail').attr("placeholder", "เช่น หลังดัน 3110036561");
	}
	});


	
});

function onchangeSource(param) {
    if('88888888'==param.value){
        $('#otherIdLabel').attr('class','')
        $('#OtherddlSource').attr('class','form-control')
    }else{
        $('#otherIdLabel').attr('class','hide')
        $('#OtherddlSource').attr('class','hide')
    }
}
function onchangeLogis(param) {
	console.log("Logis|"+param.value);
    if('99999999'==param.value){
    	
        $('#otherIdLabelLogis').attr('class','')
        $('#OtherddlLogistic').attr('class','form-control')
    }else{
        $('#otherIdLabelLogis').attr('class','hide')
        $('#OtherddlLogistic').attr('class','hide')
    }
}


function defaultData() {
    progressload();
    sampleChangeAction('00002');
	var myTableTmp = ["myTableDataHistory","myTableDataHistorySent","myTableDataHistoryCancel"];
	var myDataTmp = ["dataHistory","dataHistorySent","dataHistoryCancel"];
	var myStatus = ["01","03","11"];
	$.each(myTableTmp,function(i){
		console.log(i);
		queryDataHistory(myTableTmp[i],myDataTmp[i],myStatus[i]);
	});
    //queryDataHistory(myTable,myData,myStatus);

   
    $(".not-otherLogistic-sample").hide();
    $(".not-otherSource-sample").hide();
    $("#ddlPointSave").select2({
        dropdownAutoWidth: true,
        width: 'auto'
    });
 
    
   
    $("#boatNo").val('');
    $("#boatName").val('');
    $("#boatSlotS").val('');
    $("#boatSlotP").val('');
    
    $("#carNo").val('');
    $("#carSlot").val('');
    $("#staffName").val('');
  
    $(".truck-sample").hide();
    $(".ttruck-sample").hide();
    $(".rtruck-sample").hide();
    $(".t-sample").hide();
    $(".inv-no").hide();

    $("#ddlLogistic").hide();
    $(".sub-Type").hide();
    //SetSelect2();
    if (tranfer_remind_flag == "Y") {
        //redirect
    }
    progressClose();
}

function getThaiBuddaDate(date) {
    var rtnDate = "";
    var data = {}
    data["poDate"] = date;
    jQuery.ajax({
        url: 'getThaiBuddaDate',
        type: 'Post',
        async: false,
        cache: false,
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        success: function(obj) {
            rtnDate = obj.poDate;
        }
    }).fail(function() {
        /*swal('Error...', 'เกิดข้อผิดพลาด!',
            'error');*/
        showMsgError('เกิดข้อผิดพลาด!');
        //ShowErrorMsg('0006', ex);
        //HideWaiting();
    });

    return rtnDate
}

function SetDropDownGetSample() {
    progressload();
    $('#ddlGetSample').val("");
    try {
        $('#ddlGetSample').html("");
        jQuery.ajax({
            url: 'util-getDropdownGetSample',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            // async: false,
            cache: false,
             async : false,
            success: function(data) {
            	 dataGlobalGetSample = data

                 htmlDdlGetSample = '<div class="col-sm-6">'+
                        '<div class="col-sm-4">'+
                             '<label>ลักษณะเก็บตัวอย่าง</label>'+
                        '</div>'+
                      '<div class="col-sm-8">'+
                           '<select id="ddlGetSample" style="width:160px;">'

                var txt = '';
                if (tranfer_remind_flag == "Y" && changeIn == "") {
                     htmlDdlGetSample+='<option value="00001">&nbsp;&nbsp;AL</option>'
                    $('#ddlGetSample').append('<option value="00001">&nbsp;&nbsp;AL</option>');
                    progressClose();
                } else if (changeIn == "C") {
                htmlDdlGetSample+='<option value="00001">&nbsp;&nbsp;AL</option>'
                    $('#ddlGetSample').append('<option value="00001">&nbsp;&nbsp;AL</option>');
                    progressClose();
                } else if (changeIn == "T2") {
                    //$('#ddlGetSample').append('<option value="00005">&nbsp;&nbsp;U, M, L</option>');
                    progressClose();
                } else {
                    $.each(data, function(i, item) {
                    htmlDdlGetSample +='<option value="' + item.SAMPLE_LEVEL_CODE + '">&nbsp;&nbsp;' + item.SAMPLE_LEVEL_DESC + '</option>'
                        $('#ddlGetSample').append('<option value="' + item.SAMPLE_LEVEL_CODE + '">&nbsp;&nbsp;' + item.SAMPLE_LEVEL_DESC + '</option>');
                        //  txt   += item.PID+',';
                        // console.log(item)
                        progressClose();
                    });
                }
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                    progressClose();
                }

                  htmlDdlGetSample+= '</select>'+
                                            '</div>'+
                                     '</div>'
                $('#ddlGetSample').select2({
                    dropdownAutoWidth: true,
                    width: '160px'
                });
                progressClose();
             
            },
            error: function() {
                //swal("error");
                showMsgError('เกิดข้อผิดพลาด!');
                progressClose();
            }
        });

    } catch (ex) {
        //swal(ex);

        showMsgError(ex);
        progressClose();
    }
}

function SetDropDownSampleType() {

    try {
        $('#ddlSampleType').html("");
        jQuery.ajax({
            url: 'util-getDropdownSampleType',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            cache: false,
            async : false,
            success: function(data) {
            	dataGlobalSampleType = data
                var txt = '';
                   htmlDdlSampleType = '<div class="col-sm-6">'+
                                              '<div class="col-sm-4">'+
                                              '<label>ประเภทการเก็บตัวอย่าง</label>'+
                                              '</div>'+
                                              '<div class="col-sm-8">'+
                                              '<select id="ddlSampleType" class="col-sm-8" onchange="sampleChangeAction()" >'

            	var sampleTypeId = "",sampleTypeName="",itemPid="";
                $.each(data, function(i, item) {
//                console.log(item)
                    if (item.SAMPLE_TYPE_CODE == "00001") {
                    	sampleTypeId = item.SAMPLE_TYPE_CODE;
                    	sampleTypeName = item.SAMPLE_TYPE_NAME;
                    	itemPid = item.PID;
                    }else{
                        htmlDdlSampleType +='<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>'
                    	$('#ddlSampleType').append('<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
                        txt += item.PID + ',';
                    }
                    
                    //obj[item.SAMPLE_TYPE_CODE] = item.SAMPLE_TYPE_NAME;
                    // console.log(item)
                });


                htmlDdlSampleType+='<option value="' + sampleTypeId + '" >&nbsp;&nbsp;' + sampleTypeName + '</option>'
                htmlDdlSampleType+='</select>'+
                                             '</div>'+
                                            '</div >';
//                 console.log(htmlDdlSampleType)

            	$('#ddlSampleType').append('<option value="' + sampleTypeId + '" >&nbsp;&nbsp;' + sampleTypeName + '</option>');
                txt += itemPid + ',';
                
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }
                $("#ddlSampleType").change(function() {
                    sampleChangeAction(this.value);
                    sampleTypeCodex = this.value;
                });

            },
            error: function() {
                //swal("error");
                showMsgError('ข้อมูลผิดพลาด');
            }
        });

    } catch (ex) {
        //swal(ex);
        showMsgError(ex);

    }
}
function addCommas(nStr)
{
    nStr += '';
    x = nStr.split('.');
    x1 = x[0];
    x2 = x.length > 1 ? '.' + x[1] : '';
    var rgx = /(\d+)(\d{1})/;
    while (rgx.test(x1)) {
        x1 = x1.replace(rgx, '$1' + ',' + '$2');
    }
    return x1 + x2;
}
function sampleChangeAction(sampleCode) {
    changeIn = "";
    if(sampleCode!='00002'){
     sampleCode = $('#ddlSampleType').val()
    }

    renderDropDownLogistic();
    $("#ddlTruckMeter").hide();
    $(".otherOilStation-class").hide();
    $("#typeOilstation").css("display", "block");
    if (sampleCode == '00001'||sampleCode == '00010') { // C-CAR
     var object = $('#idBodyBox2 .row')
    $('#idSource').empty();
    $('#idSource').append(ddlSourceStr2);
   
   
    //console.log(htmlDdlLogistic2);
     $.each(object,function(index,item){
            if(index > 1){
               $(this).remove();
            }
     })
        $('#idBodyBox2').append(

              '<div class="row" style="margin-top:10px">'+
                     htmlDdlProduct+
                     htmlDdlLogistic+
             '</div>'+
            '<div class="row" style="margin-top:10px">'+
            				'<div class="col-sm-6" id="ddlTruckMeter" style="">'+

                                                    '<div class="col-sm-4">'+
                                                       '<label>เลขทะเบียนรถ</label>'+
                                                    '</div>'+
                                                    '<div class="col-sm-8">'+
                                                       '<input type="text" class="form-control" id="carNo">'+
                                                    '</div>'+
                                                 '</div>'+


                            '<div class="col-sm-6">'+
                                                                     '<div class="col-sm-4">'+
                                                                        '<label>รายละเอียด</label>'+
                                                                     '</div>'+
                                                                     '<div class="col-sm-8">'+
                                                                        '<input type="text" class="form-control" id="ddlTsubTypeDetail" >'+
                                                                    ' </div>'+
                                                                  '</div>'+

            '</div>'+
             '<div class="row" style="margin-top:10px">'+
                        '<div class="col-sm-6 boat-sample">'+
                            '<div class="col-sm-4">'+
                               '<label id="vehicle-name">ช่องรถ</label>'+
                            '</div>'+
                            '<div class="col-sm-8 boat-sample">'+
                               '<input type="text" class="form-control" id="carSlot"/>'+
                            '</div>'+
                        ' </div>'+


     '<div class="col-sm-6">'+
                                                '<div class="col-sm-4">'+
                                                   '<label>วันที่เก็บตัวอย่าง</label>'+
                                                '</div>'+
                                                '<div class="col-sm-8">'+
                                                   '<input type="text" class="custom-text-horizon-rangdate2" maxlength="10" id="sampleDate" data-provide="datepicker">'+
                                               ' </div>'+
                         '</div>'+


                '</div>'+
                   '<div class="row" style="margin-top:10px">'+
                            '<div class="col-sm-6 boat-truck-sample">'+
                            '<div class="col-sm-4">'+
                               '<label id="vehicle-slot">ชื่อเจ้าหน้าที่เก็บตัวอย่าง</label>'+
                            '</div>'+

                            '<div class="col-sm-8 truck-sample" style="display: block;">'+
                               '<input type="text" class="form-control" id="staffName">'+
                            '</div>'+
                         '</div>'+
                  '</div>'+
                 '<div class="row" style="margin-top:10px">'+

                  '</div>'
            );
     	$('#idLogis').empty();
     	$('#idLogis').append(htmlDdlLogistic2);
    	SetSelect2();
                     
        changeIn = "C2";
        $("#ddlSource").append(new Option("other", "88888888"));
    }else if (sampleCode == '00002') { // C BOAT
        //console.log(htmlDdlSampleType);
         $('#idBodyBox2').empty();
        $('#idBodyBox2').append('<div class="row">'+
        htmlDdlStore+
        ddlSourceStr+
        '</div>'+
        '<div class="row" style="margin-top:10px">'+
           htmlDdlSampleType+
           htmlDdlGetSample+
          '</div>'+
          '<div class="row" style="margin-top:10px">'+
                 htmlDdlProduct+
              '<div class="col-sm-6">'+
                  '<div class="col-sm-4">'+
                    '<label>วันที่เก็บตัวอย่าง</label>'+
                 '</div>'+
                 '<div class="col-sm-8">'+
                    '<input type="text" class="custom-text-horizon-rangdate2"'+
                      'maxlength="10" id="sampleDate"'+
                       'data-provide="datepicker"/>'+
                 '</div>'+
            '</div>'+
        '</div>'+
        '<div class="row" style="margin-top:10px">'+
        					'<div class="col-sm-6 boat-truck-sample">'+
                                '<div class="col-sm-4">'+
                                   '<label id="vehicle-no">Shipment No.</label>'+
                                '</div>'+
                                '<div class="col-sm-8 boat-sample">'+
                                   '<input type="text" class="form-control" id="boatNo">'+
                               ' </div>'+
                   '</div>'+
                    ' <div class="col-sm-6 boat-truck-sample">'+
                           '<div class="col-sm-4">'+
                              '<label id="vehicle-slot">จำนวนช่องเรือ</label>'+
                           '</div>'+
                           '<div class="col-sm-8 boat-sample"> '+
                              '<input  type="text" class="form-control col-sm-4" id="boatNewSlot" placeholder="S/P"/>'+
                           '</div>'+

                       ' </div> '+
        '</div>'+
         '<div class="row" style="margin-top:10px">'+
                    '<div class="col-sm-6 boat-sample">'+
                        '<div class="col-sm-4">'+
                           '<label id="vehicle-name">ชื่อเรือ</label>'+
                        '</div>'+
                        '<div class="col-sm-8 boat-sample">'+
                           '<input type="text" class="form-control" id="boatName"/>'+
                        '</div>'+
                    ' </div>'+
            '</div>'
        );


		
        SetSelect2();
        changeIn = "C";
        $('#boatNewSlot').on('input',function(e){
        	//console.log(this.value);
        	
        	var regex=/\d+\.\d+|\.\d+|\d+/g ;
        	var str = this.value.substr(this.value.length - 1);
        	if(str !=' ' && regex.exec(str)){
        		var inputxt = addCommas($("#boatNewSlot").val());	
                $("#boatNewSlot").val(inputxt);
                $("#boatNewSlot").attr("maxlength","9"); 
        	}else{
        		$("#boatNewSlot").val("");
        	}
                      
        });
	
    }else if(sampleCode == '00008'||sampleCode == '00009'){
		   console.log(htmlDdlSampleType);
         $('#idBodyBox2').empty();
        $('#idBodyBox2').append('<div class="row">'+
        htmlDdlStore+
        ddlSourceStr+
        '</div>'+
        '<div class="row" style="margin-top:10px">'+
           htmlDdlSampleType+
           htmlDdlGetSample+
          '</div>'+
          '<div class="row" style="margin-top:10px">'+
                 htmlDdlProduct+
              '<div class="col-sm-6">'+
                  '<div class="col-sm-4">'+
                    '<label>วันที่เก็บตัวอย่าง</label>'+
                 '</div>'+
                 '<div class="col-sm-8">'+
                    '<input type="text" class="custom-text-horizon-rangdate2"'+
                      'maxlength="10" id="sampleDate"'+
                       'data-provide="datepicker"/>'+
                 '</div>'+
            '</div>'+
        '</div>'+
        '<div class="row" style="margin-top:10px">'+
        					'<div class="col-sm-6 boat-truck-sample">'+
                                '<div class="col-sm-4">'+
                                   '<label id="vehicle-no">Shipment No.</label>'+
                                '</div>'+
                                '<div class="col-sm-8 boat-sample">'+
                                   '<input type="text" class="form-control" id="boatNo">'+
                               ' </div>'+
                   '</div>'+
                    ' <div class="col-sm-6 boat-truck-sample">'+
                           '<div class="col-sm-4">'+
                              '<label id="vehicle-slot">จำนวนช่องเรือ</label>'+
                           '</div>'+
                           '<div class="col-sm-8 boat-sample"> '+
                              '<input  type="text" class="form-control col-sm-4" id="boatNewSlot" placeholder="S/P"/>'+
                           '</div>'+

                       ' </div> '+
        '</div>'+
         '<div class="row" style="margin-top:10px">'+
                    '<div class="col-sm-6 boat-sample">'+
                        '<div class="col-sm-4">'+
                           '<label id="vehicle-name">ชื่อเรือ</label>'+
                        '</div>'+
                        '<div class="col-sm-8 boat-sample">'+
                           '<input type="text" class="form-control" id="boatName"/>'+
                        '</div>'+
                    ' </div>'+
            '</div>'
        );


		$('#ddlSampleType').val(sampleCode);

        SetSelect2();
        changeIn = "C";
        $('#boatNewSlot').on('input',function(e){
        	//console.log(this.value);
        	
        	var regex=/\d+\.\d+|\.\d+|\d+/g ;
        	var str = this.value.substr(this.value.length - 1);
        	if(str !=' ' && regex.exec(str)){
        		var inputxt = addCommas($("#boatNewSlot").val());	
                $("#boatNewSlot").val(inputxt);
                $("#boatNewSlot").attr("maxlength","9"); 
        	}else{
        		$("#boatNewSlot").val("");
        	}
                      
        });
	
	} else if (sampleCode == '00003') { // TRUCK
   var object = $('#idBodyBox2 .row')
   $('#idSource').empty();
            $('#idSource').append(ddlSourceStr2)
     $.each(object,function(index,item){
            if(index > 1){
               $(this).remove();
            }
     })

    $('#idBodyBox2').append(

          '<div class="row" style="margin-top:10px">'+
                 htmlDdlProduct+
                 htmlDdlLogistic+

         '</div>'+
        '<div class="row" style="margin-top:10px">'+
        				'<div class="col-sm-6" id="ddlTruckMeter" style="">'+
                                             	'<div class="col-sm-12">'+
                                                	'<p></p>'+
                                             	'</div>'+
                                                '<div class="col-sm-4">'+
                                                   '<label>หมายเลขมิเตอร์</label>'+
                                                '</div>'+
                                                '<div class="col-sm-8">'+
                                                   '<input type="text" class="form-control" id="meterTruckNo" placeholder="เช่น 212-MET-001">'+
                                                '</div>'+
                                             '</div>'+

                 '<div class="col-sm-6">'+
                                         '<div class="col-sm-4">'+
                                            '<label>วันที่เก็บตัวอย่าง</label>'+
                                         '</div>'+
                                         '<div class="col-sm-8">'+
                                         '<input type="text" class="custom-text-horizon-rangdate2"'+
                                         'maxlength="10" id="sampleDate"'+
                                          'data-provide="datepicker"/>'+
                                        ' </div>'+
                                      '</div>'+

        '</div>'+

              '<div class="row" style="margin-top:10px">'+
                         '<div class="col-sm-6 boat-truck-sample">'+
                                 ' <div class="col-sm-4">'+
                                     '<label id="vehicle-no">เลขทะเบียนรถ</label>'+
                                  '</div>'+
                                  '<div class="col-sm-8 boat-sample" style="display: none;">'+
                                     '<input type="text" class="form-control" id="boatNo">'+
                                  '</div>'+
                                  '<div class="col-sm-8 truck-sample" style="display: block;">'+
                                     '<input type="text" class="form-control" id="carNo">'+
                                  '</div>'+
                               '</div>'+
              '</div>'+
               '<div class="row" style="margin-top:10px">'+
                        '<div class="col-sm-6 boat-truck-sample">'+
                        '<div class="col-sm-4">'+
                           '<label id="vehicle-slot">ช่องรถ</label>'+
                        '</div>'+
                        '<div class="col-sm-8 boat-sample" style="display: none;">'+
                           '<input type="text" class="form-control col-sm-4" id="boatNewSlot" placeholder="S/P">'+
                        '</div>'+
                        '<div class="col-sm-8 truck-sample" style="display: block;">'+
                           '<input type="text" class="form-control" id="carSlot">'+
                        '</div>'+
                     '</div>'+
              '</div>'+
             '<div class="row" style="margin-top:10px">'+
 '<div class="col-sm-6 boat-truck-sample">'+
                                     ' <div class="col-sm-4">'+
                                         '<label id="vehicle-no">ชื่อเจ้าหน้าที่เก็บตัวอย่าง</label>'+
                                      '</div>'+
                                      '<div class="col-sm-8 boat-sample" style="display: block;">'+
                                         '<input type="text" class="form-control" id="staffName">'+
                                      '</div>'+
                                   '</div>'+
              '</div>'
        );
        SetSelect2();
        $('#idLogis').empty();
     	$('#idLogis').append(htmlDdlLogistic2);
        changeIn = "C";
    } else if (sampleCode == '00004') { // T
   var object = $('#idBodyBox2 .row')
      $('#idSource').empty();
         $('#idSource').append(htmlDdlSourceT)
     $.each(object,function(index,item){
            if(index > 1){
               $(this).remove();
            }
     })
      $('#idBodyBox2').append(
              '<div class="row" style="margin-top:10px">'+
                     htmlDdlProduct+
                '<div class="col-sm-6">'+
                      '<div class="col-sm-4">'+
                        '<label>รายละเอียดการเข้าเก็บ</label>'+
                     '</div>'+
                 '<div class="col-sm-8">'+
                        '<input type="text" class="form-control" id="ddlTsubTypeDetail" placeholder="เช่น ตัวอย่างประจำเดือน ก.พ. 64 ครั้งที่1">'+
                            ' </div>'+
                  '</div>'+


             '</div>'+
             '<div class="row" style="margin-top:10px">'+
             htmlDdlTsubType+
               '</div>'+
            '<div class="row" style="margin-top:10px">'+
            				'<div class="col-sm-6" id="ddlTruckMeter" style="">'+
                                                    '<div class="col-sm-4">'+
                                                       '<label>หมายเลขถัง</label>'+
                                                    '</div>'+
                                                    '<div class="col-sm-8">'+
                                                       '<input type="text" class="form-control" id="tankNo" placeholder="T-15 หรือ T-11">'+
                                                    '</div>'+
                                                 '</div>'+


            '</div>'+
             '<div class="row" style="margin-top:10px">'+
                        '<div class="col-sm-6 boat-sample">'+
                            '<div class="col-sm-4">'+
                               '<label id="vehicle-name">วันที่เก็บตัวอย่าง</label>'+
                            '</div>'+
                            '<div class="col-sm-8 boat-sample">'+
                            '<input type="text" class="custom-text-horizon-rangdate2"'+
                            'maxlength="10" id="sampleDate"'+
                             'data-provide="datepicker"/>'+
                            '</div>'+
                        ' </div>'+
                '</div>'+
                  '<div class="row" style="margin-top:10px">'+
                             '<div class="col-sm-6 boat-truck-sample">'+
                                     ' <div class="col-sm-4">'+
                                         '<label id="vehicle-no">ชื่อเจ้าหน้าที่เก็บตัวอย่าง</label>'+
                                      '</div>'+
                                      '<div class="col-sm-8 boat-sample" style="display: block;">'+
                                         '<input type="text" class="form-control" id="staffName">'+
                                      '</div>'+
                                   '</div>'+
                  '</div>'

            );
		
        SetSelect2();
        changeIn = "T";
    } else if (sampleCode == '00005') { // R col-sm-6 not-Source-sample

 var object = $('#idBodyBox2 .row')
  $('#idSource').empty();
  $('#idSource').append('<div class="col-sm-4"><label>แหล่งที่มา อื่นๆ</label></div>')
  $('#idSource').append('<div class="col-sm-6"><input type="text" class="form-control" id="OtherddlSource"></div>')


       $.each(object,function(index,item){
              if(index > 1){
                 $(this).remove();
               }

       })
          $('#idBodyBox2').append(
                '<div class="row" style="margin-top:10px">'+
                      htmlDdlProduct+
                       htmlDdlLogistic+
                  '</div>'+
                  '<div class="row" style="margin-top:10px">'+
                         htmlDdlPointSave+



                 '</div>'+

                 '<div class="row" style="margin-top:10px">'+
                            '<div class="col-sm-6 boat-sample">'+
                                '<div class="col-sm-4">'+
                                   '<label id="vehicle-name">รายละเอียดจุดเก็บ</label>'+
                                '</div>'+
                                '<div class="col-sm-8 boat-sample">'+
                                   '<input type="text" class="form-control" id="ddlPointSaveDetail">'+
                                '</div>'+
                            ' </div>'+
                    '</div>'+

                      '<div class="row" style="margin-top:10px">'+
                         htmlDdlTOilstation+
                        '</div>'+
                     '<div class="row" style="margin-top:10px">'+
                          '<div class="col-sm-6">'+
                                                                 '<div class="col-sm-4">'+
                                                                    '<label>วันที่เก็บตัวอย่าง</label>'+
                                                                 '</div>'+
                                                                 '<div class="col-sm-8">'+
                                                                 '<input type="text" class="custom-text-horizon-rangdate2"'+
                                                                 'maxlength="10" id="sampleDate"'+
                                                                  'data-provide="datepicker"/>'+
                                                                ' </div>'+
                                                              '</div>'+

                                '</div>'+

                      '<div class="row" style="margin-top:10px">'+
                                 '<div class="col-sm-6 boat-truck-sample">'+
                                         ' <div class="col-sm-4">'+
                                             '<label id="vehicle-no">ชื่อเจ้าหน้าที่เก็บตัวอย่าง</label>'+
                                          '</div>'+
                                          '<div class="col-sm-8 boat-sample" style="display: block;">'+
                                             '<input type="text" class="form-control" id="staffName">'+
                                          '</div>'+
                                       '</div>'+
                      '</div>'+
                        '<div class="row" style="margin-top:10px">'+
                                                       '<div class="col-sm-6 boat-truck-sample">'+
                                                               ' <div class="col-sm-4">'+
                                                                   '<label id="vehicle-no">สาเหตุ</label>'+
                                                                '</div>'+
                                                                '<div class="col-sm-8 boat-sample" style="display: block;">'+
                                                                   '<input type="text" class="form-control" id="causeReturn" placeholder="เช่น น้ำเข้าหลุม GSH91 PTC.สามพราน1" maxlength="100">'+
                                                                '</div>'+
                                                             '</div>'+
                                            '</div>'


                );
  		SetSelect2();
  		$('#idLogis').empty();
     	$('#idLogis').append(htmlDdlLogistic2);
        $("#ddlSource").append(new Option("other", "88888888"));
        changeIn = "R";
        renderDropDownLogistic()
    } else if (sampleCode == '00006') { //Additive

     var object = $('#idBodyBox2 .row')
     $('#idSource').empty();
              $('#idSource').append(ddlSourceStr2)
          $.each(object,function(index,item){
                 if(index > 1){
                    $(this).remove();
                 }
          })
        $('#idBodyBox2').append(

              '<div class="row" style="margin-top:10px">'+
                     htmlDdlProduct+
                     htmlDdlLogistic+

             '</div>'+
            '<div class="row" style="margin-top:10px">'+

 '<div class="col-sm-6 boat-sample">'+
                            '<div class="col-sm-4">'+
                               '<label id="vehicle-name">LOT NO.</label>'+
                            '</div>'+
                            '<div class="col-sm-8 boat-sample">'+
                               '<input type="text" class="form-control" id="ddlLotNo"/>'+
                            '</div>'+
                        ' </div>'+
                 htmlDdlPointSave+

            '</div>'+
             '<div class="row" style="margin-top:10px">'+

                        '<div class="col-sm-6 boat-truck-sample">'+
                                                            ' <div class="col-sm-4">'+
                                                                '<label id="vehicle-no">PO NO.</label>'+
                                                             '</div>'+
                                                             '<div class="col-sm-8 truck-sample" style="display: block;">'+
                                                                '<input type="text" class="form-control" id="ddlPoNo">'+
                                                             '</div>'+
                                                          '</div>'+

                              '<div class="col-sm-6 not-pointSave-sample" style="display: block;">'+
                                                '<div class="col-sm-4">'+
                                                   '<label>รายละเอียดจุดเก็บ</label>'+
                                                '</div>'+
                                                '<div class="col-sm-8">'+
                                                   '<input type="text" class="form-control" id="ddlPointSaveDetail">'+
                                                '</div>'+
                                             '</div>'+
                '</div>'+

                   '<div class="row" style="margin-top:10px">'+
                            '<div class="col-sm-6 boat-truck-sample">'+
                            '<div class="col-sm-4">'+
                               '<label id="vehicle-slot">วันที่เก็บตัวอย่าง</label>'+
                            '</div>'+
                            '<div class="col-sm-8 truck-sample" style="display: block;">'+
                               '<input type="text" class="custom-text-horizon-rangdate2" maxlength="10" id="sampleDate" data-provide="datepicker">'+
                            '</div>'+
                         '</div>'+
                  '</div>'+
                 '<div class="row" style="margin-top:10px">'+
 '<div class="col-sm-6 boat-truck-sample">'+
                                         ' <div class="col-sm-4">'+
                                             '<label id="vehicle-no">ชื่อเจ้าหน้าที่เก็บตัวอย่าง</label>'+
                                          '</div>'+
                                          '<div class="col-sm-8 boat-sample" style="display: block;">'+
                                             '<input type="text" class="form-control" id="staffName">'+
                                          '</div>'+
                                       '</div>'+
                  '</div>'
            );
        SetSelect2();
        $('#idLogis').empty();
     	$('#idLogis').append(htmlDdlLogistic2);
        changeIn = "NA";

    }else if(sampleCode == '00007' ){ //other
    	//ddlTOilstation
 $('#idSource').empty();
    	 $('#idSource').append('<div class="col-sm-4"><label>แหล่งที่มา อื่นๆ</label></div>')
         $('#idSource').append('<div class="col-sm-6"><input type="text" class="form-control" id="OtherddlSource"></div>')
    	 var object = $('#idBodyBox2 .row')
               $.each(object,function(index,item){
                      if(index > 1 ){
                         $(this).remove();
                      }

               })
                  $('#idBodyBox2').append(

                        '<div class="row" style="margin-top:10px">'+
                                                              htmlDdlProduct+
                                             htmlDdlLogistic+
                                        '</div>'+
                          '<div class="row" style="margin-top:10px">'+
                                 htmlDdlPointSave+


                         '</div>'+

                         '<div class="row" style="margin-top:10px">'+
                                    '<div class="col-sm-6 boat-sample">'+
                                        '<div class="col-sm-4">'+
                                           '<label id="vehicle-name">รายละเอียดจุดเก็บ</label>'+
                                        '</div>'+
                                        '<div class="col-sm-8 boat-sample">'+
                                           '<input type="text" class="form-control" id="ddlPointSaveDetail">'+
                                        '</div>'+
                                    ' </div>'+
                            '</div>'+

                              '<div class="row" style="margin-top:10px">'+
                                 htmlDdlTOilstation+
                                '</div>'+
                             '<div class="row" style="margin-top:10px">'+
                                  '<div class="col-sm-6">'+
                                                                         '<div class="col-sm-4">'+
                                                                            '<label>วันที่เก็บตัวอย่าง</label>'+
                                                                         '</div>'+
                                                                         '<div class="col-sm-8">'+
                                                                            '<input type="text" class="custom-text-horizon-rangdate2" maxlength="10" id="sampleDate" data-provide="datepicker">'+
                                                                        ' </div>'+
                                                                      '</div>'+

                                        '</div>'+

                              '<div class="row" style="margin-top:10px">'+
                                         '<div class="col-sm-6 boat-truck-sample">'+
                                                 ' <div class="col-sm-4">'+
                                                     '<label id="vehicle-no">ชื่อเจ้าหน้าที่เก็บตัวอย่าง</label>'+
                                                  '</div>'+
                                                  '<div class="col-sm-8 boat-sample" style="display: block;">'+
                                                     '<input type="text" class="form-control" id="staffName">'+
                                                  '</div>'+
                                               '</div>'+
                              '</div>'+
                                '<div class="row" style="margin-top:10px">'+
                                                               '<div class="col-sm-6 boat-truck-sample">'+
                                                                       ' <div class="col-sm-4">'+
                                                                           '<label id="vehicle-no">สาเหตุ</label>'+
                                                                        '</div>'+
                                                                        '<div class="col-sm-8 boat-sample" style="display: block;">'+
                                                                           '<input type="text" class="form-control" id="causeReturn" placeholder="เช่น ลูกค้าร้องเรียนน้ำมันมีน้ำ PTC.สอง" maxlength="100">'+
                                                                        '</div>'+
                                                                     '</div>'+
                                                    '</div>'


                        );
    	SetSelect2();
    	$('#idLogis').empty();
     	$('#idLogis').append(htmlDdlLogistic2);
        $("#ddlSource").append(new Option("other", "88888888"));

        changeIn = "O";
    } else {
         renderProductDropDown()
        $(".inv-no").hide();
        $(".not-tr-sample").show();
        $(".boat-truck-sample").hide();
        $(".truck-sample").hide();
        $(".boat-sample").hide();
        $(".ttruck-sample").hide();
        $(".t-sample").hide();
        $(".not-pointSave-sample").hide();
        renderDropDownSource();
        $(".rtruck-sample").hide();
        $(".not-Source-sample").show();
        $(".not-otherSource-sample").hide();
        changeIn = "NA";
        renderDropDownLogistic()
        $(".sub-Type").hide();
    }
    SetSelect2();
    renderDownGetSample();
}
function SetSelect2(){
	$('#sampleDate').val(getThaiBuddaDate());
	$('#ddlStore').select2({dropdownAutoWidth: true,width: 'resolve'});
    $('#ddlSource').select2({dropdownAutoWidth: true,width: 'resolve'});
    //$('#ddlSampleType').select2({width: 'resolve'});
    $('#ddlProduct').select2({dropdownAutoWidth: true,width: 'resolve'});
    $('#ddlLogistic').select2({width: 'resolve'});
    $('#ddlPointSave').select2({dropdownAutoWidth: true,width: 'resolve'});
    $('#ddlTOilstation').select2({width: 'resolve'});
    $('#ddlSampleType').select2({dropdownAutoWidth: true,width: 'resolve'});
    $('#ddlProduct').select2({dropdownAutoWidth: true,width: 'resolve'});
    $("#ddlTsubType").select2({width: 'resolve'});
}
function SetDropDownStore() {
    progressload();
    $('#ddlStore').empty();
    try {
        var data = {};
        data["status"] = "";
        if(plantIDDefult!="NULL"){
        	data["plantid"] = plantIDDefult;
        }else{
        	data["plantid"] = "";
        }
        
        $('#ddlStore').html("");
        jQuery.ajax({
            url: 'util-getDropdownPlant',
            type: "Post",
            data: JSON.stringify(data),
            contentType: "application/json",
            dataType: 'json',
            //  async: false,
            cache: false,
            async : false,
            success: function(data) {
            	dataGlobalDropDownStore = data

           var str = '<div class="col-sm-6">' +
                           '<div class="col-sm-4">' +
                               '<label>คลัง</label>' +
                            '</div>'+
                            '<div class="col-sm-8">'+
                               '<select id="ddlStore">'

           var txt = '';
                $.each(data, function(i, item) {

//                    $('#ddlStore').append('<option value="' + item.PID + '">&nbsp;&nbsp;' + item.PNAMET + '</option>');
                    txt += item.PID + ',';
                    str+='<option value="' + item.PID + '">&nbsp;&nbsp;' + item.PNAMET + '</option>'
                });

              str +=       '</select>'+
                           '</div>'+
                        '</div>'
           htmlDdlStore   =   str;
            $('#ddlStore').append(str);

                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }
                $('#ddlStore').select2({
                    dropdownAutoWidth: true,
                    width: 'auto'
                });
                progressClose();

            },
            error: function() {
                //	swal("error");
                showMsgError('เกิดข้อผิดพลาด');
                progressClose();
            }
        });

    } catch (ex) {
        //swal(ex);

        showMsgError(ex);
        progressClose();
    }
}

function SetDropDownTypeStation() {
    $('#ddlTOilstation').empty();
    var textAppend ='';
    try {
        //alert("5555AAA");
        $('#ddlTOilstation').html("");
        jQuery.ajax({
            url: 'util-getDropdownTypeStation2',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            cache: false,
            async : false,
            success: function(data) {

            	  
                dataGlobalDropDownTypeStation  = data
             
                var txt = '';
                htmlDdlTOilstation = '<div class="col-sm-6" id="typeOilstation" style="display: block;" data-select2-id="typeOilstation">'+

                                                             '<div class="col-sm-4">'+
                                                                '<label>ประเภทปั้ม</label>'+
                                                            ' </div>'+
                                                            ' <div class="col-sm-6" data-select2-id="1240">'+
                                                              ' <select class="col-sm-6" id="ddlTOilstation"  >'

                $.each(data, function(i, item) {

//                    $('#ddlTOilstation').append('<option value="' + item.TYPE_ID + '">&nbsp;&nbsp;' + item.TYPE_NAME + '</option>');
                        textAppend += '<option value="' + item.TYPE_ID + '">&nbsp;&nbsp;' + item.TYPE_NAME + '</option>';
                        htmlDdlTOilstation += '<option value="' + item.TYPE_ID + '">&nbsp;&nbsp;' + item.TYPE_NAME + '</option>';
                    //    txt   += item.PRODUCT_ID+',';
                    // console.log(item)
                });
                 textAppend +='<option value="10000">&nbsp;&nbsp;อื่นๆ</option>';
                 htmlDdlTOilstation +='<option value="10000">&nbsp;&nbsp;อื่นๆ</option>';
//                 console.log(textAppend);
                    htmlDdlTOilstation +='</select>'+
                                                 '</div>'+

                                              '</div>'
                 $('#ddlTOilstation').append(textAppend);
                $('#ddlTOilstation').select2({
                    width: 'resolve'
                });

            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}

function SetDropDownSavePoint() {
    $('#ddlPointSave').val("");
    try {
        $('#ddlPointSave').html("");
        jQuery.ajax({
            url: 'util-getDropdownSavepointlocation',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            cache: false,
            async : false,
            success: function(data) {
            	   dataGlobalDropDownSavePoint  = data
                 
                var txt = '';

              htmlDdlPointSave   =      ' <div class="col-sm-6 not-pointSave-sample">'+
                                        '<div class="col-sm-4">'+
                                           '<label>จุดเก็บ</label>'+
                                        '</div>'+
                                        '<div class="col-sm-8">'+
                                           '<select id="ddlPointSave">'

                $.each(data, function(i, item) {
                    htmlDdlPointSave+='<option value="' + item.loc_id + '">&nbsp;&nbsp;' + item.loc_name + '</option>'
                    $('#ddlPointSave').append('<option value="' + item.loc_id + '">&nbsp;&nbsp;' + item.loc_name + '</option>');

                    //    txt   += item.PRODUCT_ID+',';
                    // console.log(item)
                });
                  htmlDdlPointSave   +=    '</select>'+
                                                       '</div>'+
                                                         '</div>'
                $('#ddlPointSave').select2({
                    dropdownAutoWidth: true,
                    width: 'auto'
                });

            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}

function SetDropDownLogisticBoat() {
    $('#ddlLogistic').val("");
    try {
        //alert("5555AAA");
        $('#ddlLogistic').html("");
        jQuery.ajax({
            url: 'util-getDropdownLogisticBoat',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            cache: false,
            async : false,
            success: function(data) {

                htmlDdlLogisticBoat =    '<div class="col-sm-6 not-tr-sample">'+
                                    '<div class="col-sm-4">'+
                                       '<label>ขนส่ง</label>'+
                                    '</div>'+
                                    '<div class="col-sm-8">'+
                                       '<select id="ddlLogistic">'

            	  dataGlobalDropDownLogisticBoat  = data
                

                var txt = '';
                $.each(data, function(i, item) {

                    $('#ddlLogistic').append('<option value="' + item.LOGIS_ID + '">&nbsp;&nbsp;' + item.LOGIS_NAME + '</option>');
                    htmlDdlLogisticBoat+='<option value="' + item.LOGIS_ID + '">&nbsp;&nbsp;' + item.LOGIS_NAME + '</option>'
                    //    txt   += item.PRODUCT_ID+',';
                    // console.log(item)
                });

                    htmlDdlLogisticBoat +='</select>'+
                                                    '</div>'+
                                                 '</div>'
                $('#ddlLogistic').select2({
                    dropdownAutoWidth: true,
                    width: 'auto'
                });

            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}

function SetDropDownSource() {
    progressload();
    $('#ddlSource').val("");
    try {
        $('#ddlSource').html("");
        jQuery.ajax({
            url: 'util-getDropdownSource',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            //  async: false,
            cache: false,
            async : false,
            success: function(data) {
                var txt = '';
                dataGlobalDropDownSource = data
                ddlSourceStr  =' <div class="col-sm-6 not-Source-sample" id="idSource" >' +
                               '<div class="col-sm-4">'+
                               '<label>แหล่งที่มา</label>'+

                               '</div> <div class="col-sm-8">'+
                                 '<select id="ddlSource" onchange="onchangeSource(this)">'
                ddlSourceStr2 =  '<div class="col-sm-4"> <label>แหล่งที่มา</label><label class="hide" id="otherIdLabel" style="margin-top: 10px;"> อื่นๆ</label></div>'+
                                         '<div class="col-sm-8">'+
                                       '<select id="ddlSource"  onchange="onchangeSource(this)">'
                 
                $.each(data, function(i, item) {
                    ddlSourceStr +='<option value="' + item.SOURCE_ID + '">&nbsp;&nbsp;' + item.SOURCE_NAME + '</option>';
                    ddlSourceStr2 +='<option value="' + item.SOURCE_ID + '">&nbsp;&nbsp;' + item.SOURCE_NAME + '</option>';
                    $('#ddlSource').append('<option value="' + item.SOURCE_ID + '">&nbsp;&nbsp;' + item.SOURCE_NAME + '</option>');

                    //    txt   += item.PRODUCT_ID+',';
                    // console.log(item)
                });
                  ddlSourceStr += '</select> </div> </div>'
                  ddlSourceStr2 += '</select><input style="margin-top: 5px; type="text"  class="form-control hide" id="OtherddlSource"/>  </div> '

                $('#ddlSource').select2({
                    dropdownAutoWidth: true,
                    width: 'auto'
                });
                progressClose();
               
            },
            error: function() {
                //swal("error");
                showMsgError('เกิดข้อผิดพลาด');
                progressClose();
            }
        });

    } catch (ex) {
        //swal(ex);
        showMsgError(ex);
        progressClose();

    }

}

function SetDropDownProduct() {
    $('#ddlProduct').val("");
    try {
        $('#ddlProduct').html("");
          jQuery.ajax({
            url: 'util-getDropdownProduct',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            //  async: false,
            cache: false,
            async : false,
            success: function(data) {
            	productDropdown = data
                var txt = '';

                 htmlDdlProduct ='<div class="col-sm-6">'+
                                        '<div class="col-sm-4">'+
                                           '<label>ผลิตภัณฑ์</label>'+
                                        '</div>'+
                                        '<div class="col-sm-8">'+
                                           '<select id="ddlProduct">'

                $.each(data, function(i, item) {
                    if (sampleTypeCodex == '00006') {
                    	console.log(item.PRODUCT_ID);
                        if (item.PRODUCT_ID == "100000031" || item.PRODUCT_ID == "100000032") {
                            htmlDdlProduct+='<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>'
                            $('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
                            txt += item.PRODUCT_ID + ',';
                        } else {
                            //$('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
                            //txt += item.PRODUCT_ID + ',';
                        }
                    } else {
                    htmlDdlProduct += '<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>'
                        $('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
                        txt += item.PRODUCT_ID + ',';
                    }

                    // console.log(item)
                });
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }

                      htmlDdlProduct +=     '</select>'+
                                                        '</div>'+
                                                 '</div>'
                $('#ddlProduct').select2({
                    dropdownAutoWidth: true,
                    width: 'auto'
                });

            },
            error: function() {
                //swal("error");
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        //swal(ex);
        showMsgError(ex);

    }
}

function SetDropDownLogistic() {
    $('#ddlLogistic').val("");
    try {
        $('#ddlLogistic').html("");
        jQuery.ajax({
            url: 'util-getDropdownLogistics',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async : false,
            //	  async: false,
            cache: false,
            success: function(data) {
            	
                dataGlobalDropDownLogistic = data;
                 htmlDdlLogistic =    '<div class="col-sm-6 not-tr-sample" id="idLogis">'+
                                                    '<div class="col-sm-4">'+
                                                       '<label>ขนส่ง</label>'+

                                                    '</div>'+
                                                    '<div class="col-sm-8">'+
                                                       '<select id="ddlLogistic" onchange="onchangeLogis(this)">'
                                                    
                htmlDdlLogistic2 =  '<div class="col-sm-4" > <label>ขนส่ง</label><br><label class="hide" id="otherIdLabelLogis" style="margin-top: 10px;">ขนส่ง อื่นๆ</label></div>'+
                                                    '<div class="col-sm-8">'+
                                                  '<select id="ddlLogistic"  onchange="onchangeLogis(this)">'

    $.each(data, function(i, item) {
        htmlDdlLogistic +='<option value="' + item.LOGIS_ID + '">&nbsp;&nbsp;' + item.LOGIS_NAME + '</option>';
        htmlDdlLogistic2 +='<option value="' + item.LOGIS_ID + '">&nbsp;&nbsp;' + item.LOGIS_NAME + '</option>';    
    });


                    htmlDdlLogistic +='</select>'+
                                            '</div>'+
                                      '</div>'
                    htmlDdlLogistic2 += '</select><input style="margin-top: 5px; type="text"  class="form-control hide not-otherLogis-sample" id="OtherddlLogistic"/>  </div> '
                   

              $('#ddlLogistic').select2({
                                   dropdownAutoWidth: true,
                                   width: 'auto'
                  });
            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });


    } catch (ex) {
        //swal(ex);
        showMsgError(ex);

    }
}


function openRandomOilPopup() {
    $('#popup_random').modal('show');
}

function news() {

    alert($("#ddlStore").val());
}

function saveRandomOil() {
	
	//clearData();
    try {
        console.log($("#ddlSampleType").val());
        $('#tb-body-import-id').html("");
        $('#myTableSum').DataTable().destroy();
        var ddlStore = $("#ddlStore").val();
        var ddlProduct = $("#ddlProduct").val();
        var ddlLogistic = $("#ddlLogistic").val();
        var ddlSource = $("#ddlSource").val();
        console.log("Source = " + ddlSource + "\nStore = " + ddlStore + "\nProduct = " + ddlProduct + "\nLogistic = " + ddlLogistic + "\nSimple Date = " + $("#sampleDate").val())
        if ( ddlStore == null || ddlProduct == null /*|| ddlLogistic == null*/ || ($("#sampleDate").val() == null || $("#sampleDate").val() == '')) {
            showMsgWarning('กรุณาระบุข้อมูลให้ครบ');
            //bootbox.alert("This is the default alert!");
            return false;
        }
        ShowWaiting();
        //  setTimeout(  function(){
        var data = {}
        data["nameStore"] = $("#ddlStore").val(); 
        data["productOil"] = $("#ddlProduct").val();
        data["ownerLogistic"] = $("#ddlLogistic").val();
        data["sourceId"] = $("#ddlSource").val();
        data["sampleDate"] = $("#sampleDate").val();
        data["sampleType"] = $("#ddlSampleType").val();
        
        if($("#ddlSampleType").val()=='00002'||$("#ddlSampleType").val()=='00008' ||$("#ddlSampleType").val()=='00009'){ //BOAT
        	data["boatNo"] = $("#boatNo").val();   
        	data["boatName"] = $("#boatName").val();
        	data["boatSlot"] = $("#boatNewSlot").val();
        }else if($("#ddlSampleType").val()=='00003'){ //TRUCK
        	 data["carSlot"] = $("#carSlot").val();
             data["licenseCar"] = $("#carNo").val();
             data["staffName"] = $("#staffName").val();
             data["meterNo"] = $("#meterTruckNo").val();
        }else if($("#ddlSampleType").val()=='00004'){ //T
        	data["subTypeT"] = $("#ddlTsubType").val(); 
        	data["tsubTypeDetail"] = $("#ddlTsubTypeDetail").val();
        	data["tankNo"] = $("#tankNo").val();
        	data["staffName"] = $("#staffName").val();
        }else if($("#ddlSampleType").val()=='00005' || $("#ddlSampleType").val()=='00007'){ //RETURN
        	 data["sourceId"] = "";
        	 data["otherddlSource"] = $("#OtherddlSource").val();
        	 data["ddlPointSave"] = $("#ddlPointSave").val();
        	 data["pointSaveDetail"] = $("#ddlPointSaveDetail").val();
        	 data["subTypeR"] = $("#ddlTOilstation").val(); //ประเภทปั้ม
        	 data["causeReturn"] = $("#causeReturn").val();
        	 data["staffName"] = $("#staffName").val();
        }else if($("#ddlSampleType").val()=='00006'){ //Adtitiv
        	//data["invNo"] = $("#ddlInvNo").val();
        	data["ddlLotNo"] = $("#ddlLotNo").val();
        	data["ddlPoNo"] = $("#ddlPoNo").val();
        	data["subTypeR"] = ""; //ประเภทปั้ม
        	data["ddlPointSave"] = $("#ddlPointSave").val();
       	 	data["pointSaveDetail"] = $("#ddlPointSaveDetail").val();
       	 	data["staffName"] = $("#staffName").val();
        }else if($("#ddlSampleType").val()=='00001'||$("#ddlSampleType").val()=='00010'){ //CAR
        	 data["carSlot"] = $("#carSlot").val();
             data["licenseCar"] = $("#carNo").val();
             data["staffName"] = $("#staffName").val();
             data["invNo"] = $("#ddlInvNo").val();
             data["tsubTypeDetail"] = $("#ddlTsubTypeDetail").val();
             data["otherddlSource"] = $("#OtherddlSource").val();
        }
        data["otherLogistic"] = $("#OtherddlLogistic").val();
        data["getSample"] = $("#ddlGetSample").val();
        //data["meterNo"] = tranfer_meterNo;
        data["refRemindFlag"] = tranfer_remind_flag;
        data["refRandomId"] = tranfer_randomId;
        data["otherOilStation"] = $("#otherOilStation").val();
        
        //console.log(" " + JSON.stringify(data));
        jQuery.ajax({
            url: 'saveSampleResult',
            type: "Post",
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {

                if (data.success == 1) {
                    HideWaiting();
                    showMsgSuccess('บันทึกสำเร็จ');
                    defaultData();
                    renderProductDropDown();
                } else {
                    HideWaiting();
                    showMsgError(data.message);
                }
                clearData();
                
                $("#ddlSampleType").change(function(){
                	renderDropDownSampleType(); 	
                });
                $("#ddlSampleType").val("00002").change();
                SetSelect2();
            },
            error: function(ex) {

                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });


    } catch (ex) {

        showMsgError(ex);
        HideWaiting();

    }

}

function queryDataHistory(myTable,myData,myStatus) {

    try {
        $('#'+myData+'').html("");
        $('#'+myTable+'').DataTable().destroy();
        var data = {}
        data["status"] = myStatus;
        //data["sampleType"] = $("#ddlSampleType").val();
        jQuery.ajax({
            url: 'queryDataRandomSimpleResult',
            type: "Post",
            contentType: "application/json",
            data: JSON.stringify(data),
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {

                if (data.success == 1) {
                    var det = "";

                    for (var i = 0; i < data.list.length; i++) {

                        det += '<tr>';
                        det += '<td class="text-left">' + (data.list[i].PLANT_NAME == null ? "" : data.list[i].PLANT_NAME) + '</td>';
                        det += '<td class="text-left" >' + (data.list[i].SOURCE_NAME == null ? "" : data.list[i].SOURCE_NAME) + '</td>';
                        det += '<td class="text-left" >' + (data.list[i].PRODUCT_NAME == null ? "" : data.list[i].PRODUCT_NAME) + '</td>';
                        det += '<td class="text-left" >' + (data.list[i].SAMPLE_LEVEL_DESC == null ? "" : data.list[i].SAMPLE_LEVEL_DESC) + '</td>';
                        det += '<td class="text-left" >' + (data.list[i].SAMPLE_TYPE_NAME == null ? "" : data.list[i].SAMPLE_TYPE_NAME) + '</td>';
                        det += '<td class="text-left" >' + (data.list[i].LOGIS_NAME == null ? "" : data.list[i].LOGIS_NAME) + '</td>';
                        det += '<td class="text-left" >' + (data.list[i].SAMPLE_DATE == null ? "" : data.list[i].SAMPLE_DATE) + '</td>';
                        det += '<td class="text-left" >' + (data.list[i].SAMPLE_POINT_DESC == null ? "" : data.list[i].SAMPLE_POINT_DESC) + '</td>';
                        det += '</tr>';
                        //console.log(data.list[i].PRODUCT_NAME);
                    }
                    if (det == '') {
                        det += '<tr> ';
                        det += '<th colspan="18" class="text-center">--- ไม่พบข้อมูล ---</th> ';
                        det += '</tr> ';
                        $('#'+myData+'').html(det);

                    } else {
                        $('#'+myData+'').html(det);
                        table = $('#'+myTable+'').DataTable({
                            searching: true,
                            responsive: true
                        });
                    }

                } else {
                    showMsgError(data.message);
                }
            },
            error: function() {

                showMsgError('เกิดข้อผิดพลาด');
            }
        });
    } catch (ex) {

        showMsgError(ex);
    }
}

function inquiryRandomOil() {

    try {

        $("input[name='hidden_namestore']").each(function() {
            // alert($(this).val());
            var nameStore = $(this).val();

            $('#dteId_' + nameStore).html("");

            $('#myTableDteId_' + nameStore).DataTable().destroy();

            var data = {}
            //alert($(this).val());
            data["nameStore"] = $(this).val();

            jQuery.ajax({
                url: 'randomOilDetail',
                type: "Post",
                contentType: "application/json",
                data: JSON.stringify(data),
                dataType: 'json',
                async: false,
                cache: false,
                success: function(data) {

                    if (data.success == 1) {
                        var det = "";

                        for (var i = 0; i < data.list.length; i++) {

                            det += '<tr class="TBODY" >';
                            det += '<td class="text-center" >' + (data.list[i].LAB_CODE == null ? "" : data.list[i].LAB_CODE) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].SAMPLE_REFER == null ? "" : data.list[i].SAMPLE_REFER) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].PO_NO == null ? "" : data.list[i].PO_NO) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].STRPO_DATE == null ? "" : data.list[i].STRPO_DATE) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].DO_NO == null ? "" : data.list[i].DO_NO) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].SHIPMENT_NO == null ? "" : data.list[i].SHIPMENT_NO) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].SAMPLE_DATA_GROUP == null ? "" : data.list[i].SAMPLE_DATA_GROUP) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].SAMPLE_DATA_SEQ == null ? "" : data.list[i].SAMPLE_DATA_SEQ) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].CAR_NO == null ? "" : data.list[i].CAR_NO) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].CAR_SLOT == null ? "" : data.list[i].CAR_SLOT) + '</td>';
                            det += '<td class="text-center" >' + (data.list[i].STR_SAMPLE_DATE == null ? "" : data.list[i].STR_SAMPLE_DATE) + '</td>';
                            det += '<td class="text-center" >' + (data.list[i].STR_SAMPLE_EXPIRE_DATE == null ? "" : data.list[i].STR_SAMPLE_EXPIRE_DATE) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].product_name == null ? "" : data.list[i].product_name) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].source_name == null ? "" : data.list[i].source_name) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].logis_name == null ? "" : data.list[i].logis_name) + '</td>';
                            det += '<td class="text-leftr" >' + (data.list[i].SAMPLE_LEVEL_DESC == null ? "" : data.list[i].SAMPLE_LEVEL_DESC) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].SAMPLE_STAFF_ID == null ? "" : data.list[i].SAMPLE_STAFF_ID) + '</td>';
                            det += '<td class="text-left" >' + (data.list[i].SAMPLE_STAFF_NAME == null ? "" : data.list[i].SAMPLE_STAFF_NAME) + '</td>';
                            det += '</tr>';
                        }
                        // alert(det);
                        if (det == '') {
                            det += '<tr> ';
                            det += '<th colspan="18" class="text-center">--- ไม่พบข้อมูล ---</th> ';
                            det += '</tr> ';
                            $('#dteId_' + nameStore).html(det);

                        } else {
                            //	alert('#dteId_'+nameStore);
                            $('#dteId_' + nameStore).html(det);
                            table = $('#myTableDteId_' + nameStore).DataTable({
                                searching: true,
                                responsive: true
                            });

                        }
                    } else {

                        showMsgError(data.message);
                    }
                },
                error: function() {

                    showMsgError('เกิดข้อผิดพลาด');
                }
            });
        });
    } catch (ex) {

        showMsgError(ex);
    }

}

function SetDropDownSubType() {
    //alert("dddd");
    $('#ddlTsubType').val("");
    try {
        $('#ddlTsubType').html("");
        jQuery.ajax({
            url: 'util-getDropdownSubType',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            cache: false,
            async : false,
            success: function(data) {
                var txt = '';
                dataGlobalSubType = data
                htmlDdlTsubType = '<div class="col-sm-6 sub-Type" id="displayTsubType" style="display: block;">'+
                                                           '<div class="col-sm-4 sub-Type-select">'+
                                                              '<label>การเข้าเก็บ</label>'+
                                                           '</div>'+
                                                           '<div class="col-sm-8 sub-Type-select" >'+
                                                              '<select class="col-sm-8" id="ddlTsubType">'

                $.each(data, function(i, item) {

                    $('#ddlTsubType').append('<option value="' + item.SUB_TYPE_CODE + '">&nbsp;&nbsp;' + item.SUB_TYPE_NAME + '</option>');
                    htmlDdlTsubType+='<option value="' + item.SUB_TYPE_CODE + '">&nbsp;&nbsp;' + item.SUB_TYPE_NAME + '</option>'
                });
                 htmlDdlTsubType +=  '</select>'+
                                                                           '</div>'+
                                                                        '</div>'
                $('#ddlTsubType').select2({
                    width: 'resolve'
                });
            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}

function progressload() {
    var URL = '/Lab/assets/images/loadlab.gif';
    Swal.fire({
        imageUrl: URL,
        imageHeight: 200,
        background: 'none',
        text: 'โปรดรอสักครู่.......',
        allowOutsideClick: false,
        showCancelButton: false,
        showConfirmButton: false,
        timer: 60000
    }, function() {
        swal.close();
    })
}

function progressClose() {
    swal.close();
}

function clearData() {
	$('#boatNo').val('');
	$('#boatName').val('');
	$('#boatSlotS').val('');
	$('#boatSlotP').val('');
	$('#carNo').val('');
	$('#carSlot').val('');
	$('#staffName').val('');
	$('#tankNo').val('');
	$('#staffName').val('');
	$('#ddlTsubTypeDetail').val('');
	$('#ddlPointSaveDetail').val('');
	$('#causeReturn').val('');
	$('#ddlInvNo').val('');
	$('#OtherddlSource').val('');
  	
}

function renderDropDownStore() {
    progressload();
    $('#ddlStore').empty("");
        var txt = '';
        $.each(dataGlobalDropDownStore, function(i, item) {

            $('#ddlStore').append('<option value="' + item.PID + '">&nbsp;&nbsp;' + item.PNAMET + '</option>');
            txt += item.PID + ',';
            // console.log(item)
        });
        if (txt.length > 0) {
            txt = txt.substring(0, txt.length - 1)
        }
        $('#ddlStore').select2({
            dropdownAutoWidth: true,
            width: 'auto'
        });
        progressClose();
}
function renderDropDownTypeStation() {
    $('#ddlTOilstation').empty();
    var txt = '';
    $.each(dataGlobalDropDownTypeStation, function(i, item) {
    txt += '<option value="' + item.TYPE_ID + '">&nbsp;&nbsp;' + item.TYPE_NAME + '</option>'

    });
      txt += '<option value="10000">&nbsp;&nbsp;อื่นๆ</option>'
     $('#ddlTOilstation').append(txt);
    $('#ddlTOilstation').select2({
        width: 'resolve'
    });

  
}
function renderDropDownSavePoint() {
   $('#ddlPointSave').empty();
   var txt = '';
    $.each(dataGlobalDropDownSavePoint, function(i, item) {
        $('#ddlPointSave').append('<option value="' + item.loc_id + '">&nbsp;&nbsp;' + item.loc_name + '</option>');
    });
    $('#ddlPointSave').select2({
        dropdownAutoWidth: true,
        width: 'auto'
    });
}

function renderDropDownLogisticBoat() {
    $('#ddlLogistic').empty();

    var txt = '';
    $.each(dataGlobalDropDownLogisticBoat, function(i, item) {
        $('#ddlLogistic').append('<option value="' + item.LOGIS_ID + '">&nbsp;&nbsp;' + item.LOGIS_NAME + '</option>');
    });
    $('#ddlLogistic').select2({
        dropdownAutoWidth: true,
        width: 'auto'
    });

}
function renderDropDownSource() {
    progressload();
    $('#ddlSource').empty();
         $.each(dataGlobalDropDownSource, function(i, item) {
            $('#ddlSource').append('<option value="' + item.SOURCE_ID + '">&nbsp;&nbsp;' + item.SOURCE_NAME + '</option>'); 
            });
            $('#ddlSource').select2({
                dropdownAutoWidth: true,
                width: 'auto'
            });
            progressClose();
            $("#ddlSource").change(function() {
                if (this.value == "88888888") {
                    $(".not-otherSource-sample").show();
                    progressClose();
                } else {
                    $(".not-otherSource-sample").hide();
                    progressClose();
                }
            });

}


function renderDownGetSample() {
    progressload();
    $('#ddlGetSample').empty();
        var txt = '';
        if (tranfer_remind_flag == "Y" && changeIn == "") {
            $('#ddlGetSample').append('<option value="00001">&nbsp;&nbsp;AL</option>');
            progressClose();
        } else if (changeIn == "C") {
            $('#ddlGetSample').append('<option value="00001">&nbsp;&nbsp;AL</option>');
            progressClose();
        } else if (changeIn == "T2") {
            //$('#ddlGetSample').append('<option value="00005">&nbsp;&nbsp;U, M, L</option>');
            progressClose();
        } else {
            $.each(dataGlobalGetSample, function(i, item) {
                $('#ddlGetSample').append('<option value="' + item.SAMPLE_LEVEL_CODE + '">&nbsp;&nbsp;' + item.SAMPLE_LEVEL_DESC + '</option>');
                //  txt   += item.PID+',';
                // console.log(item)
                progressClose();
            });
        }
        if (txt.length > 0) {
            txt = txt.substring(0, txt.length - 1)
            progressClose();
        }
        $('#ddlGetSample').select2({
            dropdownAutoWidth: true,
            width: 'auto'
        });
        progressClose();
}

function renderDropDownSampleType() {
    $('#ddlSampleType').empty();
   
    var txt = '';
            //var obj={};
    $.each(dataGlobalSampleType, function(i, item) {
        if (item.SAMPLE_TYPE_CODE != "00001") {
            $('#ddlSampleType').append('<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
            txt += item.PID + ',';
        }
        //obj[item.SAMPLE_TYPE_CODE] = item.SAMPLE_TYPE_NAME;
        // console.log(item)
    });
    if (txt.length > 0) {
        txt = txt.substring(0, txt.length - 1)
    }
   
    $("#ddlSampleType").change(function() {
        sampleChangeAction(this.value);
        sampleTypeCodex = this.value;
    });
    $('#ddlSampleType').select2({
        //dropdownAutoWidth: true,
        width: 'resolve'
    });

}

function renderDropDownSubType() {
    $('#ddlTsubType').empty();
    var txt = '';
    $.each(dataGlobalSubType, function(i, item) {
        $('#ddlTsubType').append('<option value="' + item.SUB_TYPE_CODE + '">&nbsp;&nbsp;' + item.SUB_TYPE_NAME + '</option>');
    });
    $('#ddlTsubType').select2({
        dropdownAutoWidth: true,
        width: 'auto'
    });
}

function renderProductDropDown(){
	 var txt = '';
	 $('#ddlProduct').empty();
    $.each(productDropdown, function(i, item) {
    	$('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
    	
    });
}
function renderDropDownStore() {
   progressload();
   $('#ddlStore').empty("");
       var txt = '';
       $.each(dataGlobalDropDownStore, function(i, item) {

           $('#ddlStore').append('<option value="' + item.PID + '">&nbsp;&nbsp;' + item.PNAMET + '</option>');
           txt += item.PID + ',';
           // console.log(item)
       });
       if (txt.length > 0) {
           txt = txt.substring(0, txt.length - 1)
       }
       $('#ddlStore').select2({
           dropdownAutoWidth: true,
           width: 'auto'
       });
       progressClose();
}
function renderDropDownTypeStation() {
   $('#ddlTOilstation').empty();
   var txt = '';
   $.each(dataGlobalDropDownTypeStation, function(i, item) {
       txt += '<option value="' + item.TYPE_ID + '">&nbsp;&nbsp;' + item.TYPE_NAME + '</option>'
   });
   txt += '<option value="10000">&nbsp;&nbsp;อื่นๆ</option>'
    $('#ddlTOilstation').append(txt)
   $('#ddlTOilstation').select2({
       width: 'resolve'
   });

 
}
function renderDropDownSavePoint() {
  $('#ddlPointSave').empty();
  var txt = '';
   $.each(dataGlobalDropDownSavePoint, function(i, item) {
       $('#ddlPointSave').append('<option value="' + item.loc_id + '">&nbsp;&nbsp;' + item.loc_name + '</option>');
   });
   $('#ddlPointSave').select2({
       dropdownAutoWidth: true,
       width: 'auto'
   });
}

function renderDropDownLogisticBoat() {
   $('#ddlLogistic').empty();

   var txt = '';
   $.each(dataGlobalDropDownLogisticBoat, function(i, item) {
       $('#ddlLogistic').append('<option value="' + item.LOGIS_ID + '">&nbsp;&nbsp;' + item.LOGIS_NAME + '</option>');
   });
   $('#ddlLogistic').select2({
       dropdownAutoWidth: true,
       width: 'auto'
   });

}
function renderDropDownSource() {
   progressload();
   $('#ddlSource').empty();
        $.each(dataGlobalDropDownSource, function(i, item) {
           $('#ddlSource').append('<option value="' + item.SOURCE_ID + '">&nbsp;&nbsp;' + item.SOURCE_NAME + '</option>'); 
           });
           $('#ddlSource').select2({
               dropdownAutoWidth: true,
               width: 'auto'
           });
           progressClose();
           $("#ddlSource").change(function() {
               if (this.value == "88888888") {
                   $(".not-otherSource-sample").show();
                   progressClose();
               } else {
                   $(".not-otherSource-sample").hide();
                   progressClose();
               }
           });

}

function renderDropDownLogistic() {
   $('#ddlLogistic').empty();
       var txt = '';
       $.each(dataGlobalDropDownLogistic, function(i, item) {
    	   //console.log(i)
           $('#ddlLogistic').append('<option value="' + item.LOGIS_ID + '">&nbsp;&nbsp;' + item.LOGIS_NAME + '</option>');
           txt += item.LOGIS_ID + ',';
          
       });
       if (txt.length > 0) {
           txt = txt.substring(0, txt.length - 1)
       }
       $('#ddlLogistic').select2({
           dropdownAutoWidth: true,
           width: 'auto'
       });
       $("#ddlLogistic").change(function() {
           if (this.value == "99999999") {
               $(".not-otherLogistic-sample").show();
           } else {
               $(".not-otherLogistic-sample").hide();
           }

       });
}


function renderDownGetSample() {
   progressload();
   $('#ddlGetSample').empty();
       var txt = '';
       if (tranfer_remind_flag == "Y" && changeIn == "") {
           $('#ddlGetSample').append('<option value="00001">&nbsp;&nbsp;AL</option>');
           progressClose();
       } else if (changeIn == "C") {
           $('#ddlGetSample').append('<option value="00001">&nbsp;&nbsp;AL</option>');
           progressClose();
       } else if (changeIn == "T2") {
           //$('#ddlGetSample').append('<option value="00005">&nbsp;&nbsp;U, M, L</option>');
           progressClose();
       }else if (changeIn == "C2") {
           $.each(dataGlobalGetSample, function(i, item) {
				if(item.SAMPLE_LEVEL_CODE=='00001'||item.SAMPLE_LEVEL_CODE=='00012'||item.SAMPLE_LEVEL_CODE=='00013'){
               $('#ddlGetSample').append('<option value="' + item.SAMPLE_LEVEL_CODE + '">&nbsp;&nbsp;' + item.SAMPLE_LEVEL_DESC + '</option>');
				}
               //  txt   += item.PID+',';
               // console.log(item)
               progressClose();
           });
       } else {
           $.each(dataGlobalGetSample, function(i, item) {
               $('#ddlGetSample').append('<option value="' + item.SAMPLE_LEVEL_CODE + '">&nbsp;&nbsp;' + item.SAMPLE_LEVEL_DESC + '</option>');
               //  txt   += item.PID+',';
               // console.log(item)
               progressClose();
           });
       }
       if (txt.length > 0) {
           txt = txt.substring(0, txt.length - 1)
           progressClose();
       }
       $('#ddlGetSample').select2({
           dropdownAutoWidth: true,
           width: '160px'
       });
       progressClose();
}

function renderDropDownSampleType() {
   $('#ddlSampleType').empty();
  
   var txt = '';
           //var obj={};
   $.each(dataGlobalSampleType, function(i, item) {
       if (item.SAMPLE_TYPE_CODE != "00001") {
           $('#ddlSampleType').append('<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
           txt += item.PID + ',';
       }
       //obj[item.SAMPLE_TYPE_CODE] = item.SAMPLE_TYPE_NAME;
       // console.log(item)
   });
   if (txt.length > 0) {
       txt = txt.substring(0, txt.length - 1)
   }
   $('#ddlSampleType').select2({
       dropdownAutoWidth: true,
       width: '160px'
   });
   $("#ddlSampleType").change(function() {
       sampleChangeAction(this.value);
       sampleTypeCodex = this.value;
   });

}


function renderDropDownSourceT() {
	   progressload();
	   $('#ddlSource').empty();

	   htmlDdlSourceT = ''


                htmlDdlSourceT =  '<div class="col-sm-4"> <label>แหล่งที่มา</label></div>'+
                                         '<div class="col-sm-8">'+
                                       '<select id="ddlSource">'

	        $.each(dataGlobalDropDownStore, function(i, item) {
	           $('#ddlSource').append('<option value="' + item.PID + '">&nbsp;&nbsp;' + item.PNAMET + '</option>');
	           htmlDdlSourceT +='<option value="' + item.PID + '">&nbsp;&nbsp;' + item.PNAMET + '</option>'
	           });
	           $('#ddlSource').select2({
	               dropdownAutoWidth: true,
	               width: 'auto'
	           });
	           progressClose();

             htmlDdlSourceT += '</select>  </div> '
	           $("#ddlSource").change(function() {
	               if (this.value == "88888888") {
	                   $(".not-otherSource-sample").show();
	                   progressClose();
	               } else {
	                   $(".not-otherSource-sample").hide();
	                   progressClose();
	               }
	           });

	}

function dropdownDdlStoreStr(){
       var str = '<div class="col-sm-6">' +
                    '<div class="col-sm-4">' +
                        '<label>คลัง</label>' +
                     '</div>'+
                     '<div class="col-sm-8">'+
                        '<select id="ddlStore"></select>'+
                    '</div>'+
                 '</div>'
         return str;
}