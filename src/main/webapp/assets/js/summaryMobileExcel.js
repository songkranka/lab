var basePath = '/Lab/api/';

$(document).ready(function () {
    $('#datetimepicker1').datepicker({
        orientation: "auto",
        autoclose: true,
        format: 'dd/mm/yyyy',
        todayHighlight: true
    });
    $('#datetimepicker2').datepicker({
        orientation: "auto",
        autoclose: true,
        format: 'dd/mm/yyyy',
        todayHighlight: true
    });
    init();
    $("#ddlReport").change(function () {
  		if(this.value == "0"){
  			$("#ddlProduct").prop( "disabled", true );
  		}	
  		else{
  			$("#ddlProduct").prop( "disabled", false );
  		}
  			
  	});
});
function init() {
    SetDropDownProduct();
    SetDropDownTrip();
    $("#ddlProduct").select2({dropdownAutoWidth : true,width: 'auto'});
    $("#ddlReport").select2({dropdownAutoWidth : true,width: 'auto'});
    $("#ddlProduct").prop( "disabled", true );
    
}

function SetDropDownTrip() {
	$('#ddlTrip').val("");
    try {
    	$('#ddlTrip').html("");
        jQuery.ajax({
            url: 'util-getDropdownTrip',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
                var txt = '';
                $.each(data, function (i, item) {
                    $('#ddlTrip').append('<option value="' + item.TID + '">' + item.TNAME + '</option>');
                    txt += item.PRODUCT_ID + ',';
                    // console.log(item)
                });
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }
                $('#ddlTrip').select2({dropdownAutoWidth : true,width: 'auto'});
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}
function SetDropDownProduct() {
	$('#ddlProduct').val("");
    try {
    	$('#ddlProduct').html("");
        jQuery.ajax({
            url: 'util-getDropdownProductMobile',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
                var txt = '';
                $.each(data, function (i, item) {
                    $('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">' + item.PRODUCT_NAME + '</option>');
                    txt += item.PRODUCT_ID + ',';
                    // console.log(item)
                });
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }
                $('#ddlProduct').select2({dropdownAutoWidth : true,width: 'auto'});
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}

function exportExcel() {
	//console.log($("#ddlReport option:selected").val());
	var typeReport = "";
	if($("#ddlReport option:selected").val()=="0"){
		typeReport = "summaryReport";
	}else if($("#ddlReport option:selected").val()=="1"){
		typeReport = "groupReport";
	}else{
		typeReport = "null";
	}
	var url = '/Lab/api/report/reportExcelTrip/'+$("#ddlTrip").val()+'/'+$("#ddlProduct").val()+'/'+$("#ddlTrip option:selected").text()+'/'+$("#ddlProduct option:selected").text()+'/'+typeReport;
	$(location).prop('href', url);
//    try {
//    	var data = {};
//   	 	data["tripID"] = $("#ddlTrip").val();
//        data["productID"] = $("#ddlProduct").val();
//        data["tripName"] = $("#ddlTrip option:selected").text();
//        data["productName"] = $("#ddlProduct option:selected").text();
//        data["typeReport"] = typeReport;
//        console.log(JSON.stringify(data));
//        $.ajax({
//            type: 'POST',
//            contentType : "application/json",
//            url:basePath+'report/reportExcelTrip',
//            data : JSON.stringify(data),
//            dataType: 'json'
//            ,
//            success : function(response) {
//            	showMsgSuccess('สำเร็จ');
//            },
//            error : function(e) {
//                showMsgError('เกิดข้อผิดพลาด');
//            }
//        });
//
//    } catch (ex) {
//        showMsgError(ex);
//    }
}