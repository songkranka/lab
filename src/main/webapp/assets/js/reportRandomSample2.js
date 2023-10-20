var basePath = '/Lab/';
var arr = [];
var checkType = "";
var $dataLTR;
$(document).ready(function () {
    $('#randate1').datepicker({
        orientation: "auto",
        autoclose: true,
        format: 'dd/mm/yyyy',
        todayHighlight: true
    });


    $('#randate3').datepicker({
        orientation: "auto",
        autoclose: true,
        format: 'dd/mm/yyyy',
        todayHighlight: true
    });
  
$('#randate1').datepicker('setDate', 'today');

$('#randate3').datepicker('setDate', 'today');
});

function exportReportBefore(){

	var url= basePath+'reportExcelRandomSampleBefore?from='+$('#sdate1').val()+'&round='+$('#round').val();
	console.log(url);
	 window.location=url;

}

function exportReport(){

	var url= basePath+'reportExcelRandomSample2?from='+$('#sdate3').val();
	console.log(url);
	 window.location=url;

}



