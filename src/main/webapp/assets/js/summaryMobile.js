var basePath = '/Lab/api/';

$(document).ready(function () {


    init();
});
function init() {
    initDdlTrip();
	SetDropDownTypeStation();
}
    function SetDropDownTypeStation(){
    	try {
    		 
	
				
			  jQuery.ajax({
				url : 'util-getDropdownTypeStation',
				type : "Post", 
				contentType : "application/json",
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {
			 
				$.each(data, function (i, item) {
                    $('#company').append('<option value="' + item.TYPE_STATION + '">&nbsp;&nbsp;&nbsp;&nbsp;' + item.TYPE_STATION + '&nbsp;&nbsp;&nbsp;&nbsp;</option>');
                });    
					
			 
			 
				},
				error : function() {
					//swal("error");
					showMsgError('เกิดข้อผิดพลาด!');
				}
			});

		} catch (ex) {
			//swal(ex);
			showMsgError(ex); 
			 
		}
    }

function initDdlTrip() {
    var data = {};
    try {
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'report/trips',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(response) {
                $.each(response, function (i, item) {
                    $('#ddlTrip').append('<option value="' + item.tripId + '">&nbsp;&nbsp;&nbsp;&nbsp;' + item.tripName + '&nbsp;&nbsp;&nbsp;&nbsp;</option>');
                });
//                $('#ddlTrip').multiselect('rebuild');
//                $("#ddlTrip").multiselect('updateButtonText');
//                $('#ddlTrip').trigger('change');
//                $("#ddlTrip").multiselect("refresh");
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);
    }
}


function exportPdf() {
//window.location=basePath+'report/mobSumReport?trips='+$('#ddlTrip').val()+'&company='+$('#company').val();
window.location=basePath+'report/getmobilereportonepage?trips='+$('#ddlTrip').val()+'&company='+$('#company').val();
}