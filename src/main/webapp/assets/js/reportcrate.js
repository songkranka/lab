var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";


$(document).ready(function () {
	
	SetDropDownProduct();
	SetDropSampleType();

});

function gotoMain(){
    window.location= backloc;;
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
            async: false,
            cache: false,
            success: function(data) {
                var txt = '';
                $.each(data, function(i, item) {
                        $('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
                        txt += item.PRODUCT_ID + ',';
                });
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }
                $('#ddlProduct').select2({
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

function SetDropSampleType() {
    $('#ddlSampleType').val("");
    try {
        $('#ddlSampleType').html("");
        jQuery.ajax({
            url: 'util-getDropdownSampleType',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                var txt = '';
                $.each(data, function(i, item) {
                        $('#ddlSampleType').append('<option value="' + item.SAMPLE_TYPE_CODE + '">&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
                        txt += item.PRODUCT_ID + ',';
                });
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }
                $('#ddlSampleType').select2({
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
function exportReportCrate(){
	  var link = '/Lab/reportcrate/'+$('#ddlProduct').val()+'/'+$('#ddlSampleType').val();
	  window.open(link, '_blank');
}
	



