var basePath = '/Lab/';
var basePath2 = '/Lab/api/';
var dataExTemplate ;
var arr = [];
var checkType = "";
var $dropdownSampleType;
var $dropdownProduct;
var $dataLTR;
var plant_id;
$(document).ready(function () {
    $('#yearpicker').datepicker({
    format: "yyyy",
    viewMode: "years", 
    minViewMode: "years",
	autoclose: true
  
    });

     $('#plant_for_report').select2();

    $('#monthpicker').datepicker({
       format: "mm",
       viewMode: "months", 
       minViewMode: "months",
 	   todayHighlight: true,
	   autoclose: true
    });
	getDropdownPlant();
    checkLevel();
	$("#monthreport").change(function(){
		$("#monthreport").css("border-color", "#e5e6e7");
	});
	
	$("#yearreport").change(function(){
		$("#yearreport").css("border-color", "#e5e6e7");
	});
    monthdropdown();
});

function monthdropdown(){

    try {
		 $('#month_cancel').empty();
     	 $('#month_cancel').append('<option   value="01">มกราคม</option>');
		 $('#month_cancel').append('<option   value="02">กุมภาพันธ์</option>');
		 $('#month_cancel').append('<option   value="03">มีนาคม</option>');
		 $('#month_cancel').append('<option   value="04">เมษายน</option>');
		 $('#month_cancel').append('<option   value="05">พฤษภาคม</option>');
		 $('#month_cancel').append('<option   value="06">มิถุนายน</option>');
		 $('#month_cancel').append('<option   value="07">กรกฎาคม</option>');
		 $('#month_cancel').append('<option   value="08">สิงหาคม</option>');
		 $('#month_cancel').append('<option   value="09">กันยายน</option>'); 
		 $('#month_cancel').append('<option   value="10">ตุลาคม</option>');
		 $('#month_cancel').append('<option   value="11">พฤศจิกายน</option>');
		 $('#month_cancel').append('<option   value="12">ธันวาคม</option>');
    } catch (ex) {
        showMsgError(ex);

    }
}
	

function checkLevel(){
	try{
		var data = {};
		//console.log(JSON.stringify(data));
        ShowWaiting();
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath2+'getLevelHead',
            data : JSON.stringify(data),
            dataType: 'json',
            async: false,
			cache: false,
            success : function(data) {
            	plant_id = data.list[0].PLANT_ID;
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
}




function getReportLTRTruck() {
	
   window.location=basePath+'reportTuck';

}

function exportExcelHeader(){

	let month = $('#month_cancel').val();
	let year =$('#yearreport').val();
	
	
	if(year==null||year==''){
		$("#yearreport").css("border-color", "red");
		return null;
	}
	


	let plant = $('#plant_for_report').val();

	var url= basePath+'reportExcelCancel?year='+year+'&month='+month+'&plant='+plant;
	window.location=url;

}

function exportReportLTR(data,productType){
	var arr ="";
	var product = data.id.split("idTable")[1];//$(productType).attr('foo')
	var check = $('#'+data.id+' tbody tr');
	$.each(check,function(index,items){
		if($(this).find('td:eq(1) input')[0].checked){
			if(arr==""){
				arr+=$(this).find('td:eq(2)').text()
			}else{
				arr+=","+$(this).find('td:eq(2)').text()
			}
		}else{
			
		}
	})

	  var result ={ labCode : arr}
	  var link = '/Lab/exportReportLTR?productType='+product+'&checkType='+$('#nonTypeReport').val()+'&labCode='+arr;
	  window.open(link, '_blank');

}


function getDropdownPlant() {
	ShowWaiting();
    try {
        jQuery.ajax({
            url: 'util-getPlantUser',
            type: "Get",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {

			$('#plant_for_report').empty();
			for(var i =0;i<data.length;i++){
     	    $('#plant_for_report').append('<option id=""  value="'+data[i].CENTER_CODE+'">'+data[i].PLANT_NAME.split('-')[1]+'</option>');
			}
			HideWaiting() ;
            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
				HideWaiting() ;
            }
        });

    } catch (ex) {
        showMsgError(ex);
		HideWaiting() ;

    }
}





