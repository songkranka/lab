var basePath = '/Lab/api/';
$(document).ready(function () {
	getLabCode();
});
var str = location.search;
str = str.split("?");
function getLabCode(){	
	queryDetail(str[1]);
}
function queryDetail(labCode){
        try {
        	var data = {}	
	    	data["labCode_No"] = labCode;
	    	ShowWaiting() ;
			jQuery.ajax({
				url : 'QueryAssignmentDetail',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
	            success: function (data) {
	            	$('#ltr_no').append(data.list[0].LAB_CODE);
	            	$('#ltr_prod').append(data.list[0].product_name);
	            	$('#ltr_carno').append(data.list[0].CAR_NO);
	            	$('#ltr_datepo').append(data.list[0].PO_DATE);
	            	$('#ltr_src').append(data.list[0].source_name);
	            	$('#ltr_carslot').append(data.list[0].CAR_SLOT);
	            	$('#ltr_po').append(data.list[0].PO_NO);
	            	$('#ltr_trans').append(data.list[0].logis_name);
	            	$('#ltr_boatno').append(data.list[0].BOAT_NO);
	            	$('#ltr_do').append(data.list[0].DO_NO);
	            	$('#ltr_samp').append(data.list[0].SAMPLE_LEVEL_DESC);
	            	$('#ltr_boatname').append(data.list[0].BOAT_NAME);
	            	$('#ltr_ship').append(data.list[0].SHIPMENT_NO);
	            	$('#ltr_daterandom').append(data.list[0].PO_DATE);
	            	$('#ltr_boatslot').append(data.list[0].BOAT_SLOT);
	            	$('#ltr_grp').append(data.list[0].SAMPLE_REFER);
	            	$('#ltr_dateexp').append(data.list[0].STR_SAMPLE_DATE);
	            	$('#ltr_empname').append(data.list[0].SAMPLE_STAFF_NAME);
	            	//console.log(data.list[0].LAB_CODE);
	           
	            	HideWaiting() ;
	            },
	            error: function () {
	                    showMsgError('เกิดข้อผิดพลาด');
	                    HideWaiting() ;
	            }
            });

        } catch (ex) {
            showMsgError(ex);
            HideWaiting() ;

        }
}
function gotoMain(){
    window.location="/Lab/randomOilForValidate";
}