var basePath = '/Lab/';
var baseLTR = '/Lab/reportLTR';
var dataExTemplate ;
var arr = [];
var checkType = "";
var $dropdownSampleType;
var $dropdownProduct;
var $dataLTR;
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
  
    SetDropDownSampleType();
    SetDropDownProduct();
 
	$( "#rootcause_m" ).change(function() {
  	if(this.value=='9999'){
		$( "#divother" ).show();
	}else{
		$( "#divother" ).hide();
	}
	});
inittb();


	$("#submit_rootcause").on('click', function (event) {  
		var labcode = $('#labcode_m').val();
		var rtcode=$('#rootcause_m').val();
		var rtdesc;
		if(rtcode=='9999'){
			rtdesc=$('#other_m').val();
		}else{
			rtdesc=$("#rootcause_m option:selected").text();
		}
		   $.ajax({
		      url: 'util-saverootcause?labcode='+labcode+'&rtcode='+rtcode+'&rtdesc='+rtdesc,
		      type: 'post',
		      contentType: false,
		      processData: false,
		      success: function(response){
		        $('#modalcondition').modal('toggle');
				ajaxGetDataReportLTR();
		      }
		    });	
     });
});

function gotoLTR(){
	 window.location= baseLTR;
}
function inittb(){
	
				table = $('#conditiontb').DataTable({
		                    searching: true,
		                    responsive: false,
		                    "pageLength": 10,
		                    "paging":   true
		    });
}



function renderSheet(datalist) {
	var det = "";
			$('#conditiontb').DataTable().destroy();
			$('#conditiondt').html("");
	    	var index=0;
	        for (var i = 0; i < datalist.length; i++) {
			index=index+1;
			det += '<tr  class="TBODY">';
			det += '<td class="text-center">'+index+'</td>'
			det += '<td class="text-center">'+datalist[i].ROOTCAUSE+'</td>'
			det += '<td class="text-center">'+datalist[i].REMARK+'</td>'
			det += '<td class="text-center">'+datalist[i].LAB_CODE+'</td>'
			det += '<td class="text-center">'+datalist[i].REQ_NO+'</td>'
			det += '<td class="text-center">'+datalist[i].REF+'</td>'
			det += '<td class="text-center">'+datalist[i].SAMPLING_DATE+'</td>'
			det += '<td class="text-center">'+datalist[i].RECEIVE_DATE+'</td>'
			det += '<td class="text-center">'+datalist[i].PRODUCT+'</td>'
			det += '<td class="text-center">'+datalist[i].REPORT_NO+'</td>'
			det += '<td class="text-center">'+datalist[i].TO+'</td>'
			det += '<td class="text-center"><button class="btn btn-warning" value="'+datalist[i].LAB_CODE+'|'+datalist[i].REQ_NO+'|'+datalist[i].RECEIVE_DATE+'|'+datalist[i].PRODUCT+'|'+datalist[i].RTCODE+'|'+datalist[i].ROOTCAUSE+'" onclick="editModal(this.value)">แก้ไข</button></td>'

			det +='</tr>';   
			}
	         $('#conditiondt').html(det);   
			table = $('#conditiontb').DataTable({
		                    searching: true,
		                    responsive: false,
		                    "pageLength": 10,
		                    "paging":   true
		    });
	    	

}
    
   function editModal(data){
	let arr_txt = data.split('|');
	$('#labcode_m').val(arr_txt[0]);
	$('#reqno_m').val(arr_txt[1]);
	$('#receivedate_m').val(arr_txt[2]);
	$('#product_m').val(arr_txt[3]);
	getDropdownRootcause(arr_txt[4]);
	if(arr_txt[4]=='9999'){
		$('#other_m').val(arr_txt[5]);
		$( "#divother" ).show();
	}else{
		$( "#divother" ).hide();
		$('#other_m').val('');
	}
	
	$('#modalcondition').modal({
    backdrop: 'static',
    keyboard: false
});
}
   


function ajaxGetDataReportLTR(){

	var obj  ={}
		obj['fromDate']=$('#sdate').val();
		obj['toDate']=$('#edate').val();
		obj['productId']=$('#nonProduct').val();
		obj['sampleType']=$('#nonSampleType').val();

		try {
			console.log(JSON.stringify(obj));
			jQuery.ajax({
				url: 'conditionLTR',
				type: "POST",
				contentType: "application/json",
				dataType: 'json',
				data : JSON.stringify(obj),
				async: false,
				cache: false,
				success: function(data) {
					$dataLTR = data
					console.log(data);
					renderSheet(data)
				},
				error: function() {
					showMsgError('ข้อมูลผิดพลาด');
				}
			});
		} catch (ex) {
			showMsgError(ex);
		}
	

}
function SetDropDownProduct() {
    $('#nonProduct').val("");
    try {
        $('#nonProduct').html("");
        jQuery.ajax({
            url: 'util-getDropdownProduct',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
            	$dropdownProduct = data
            	

                $.each(data, function(i, item) {
//                	console.log(item.PRODUCT_ID + ":" + item.PRODUCT_NAME)
					$('#nonTypeReport').val()
                	if($('#nonTypeReport').val()==='COQ'){
                		if(item.PRODUCT_ID=="100000001"){
                			$('#nonProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
                		}else if(item.PRODUCT_ID=="100000006"){
							$('#nonProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
						}else if(item.PRODUCT_ID=="100000007"){
							$('#nonProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
						}else if(item.PRODUCT_ID=="100000009"){
							$('#nonProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
						}
                	}else{
                		$('#nonProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
                	}
                });
                $('#nonProduct').select2({
                    /*dropdownAutoWidth: true,
                    width: 'auto'*/
                });
            },
            error: function() {
                showMsgError('ข้อมูลผิดพลาด');
            }
        });
    } catch (ex) {
        showMsgError(ex);
    }
}
function SetDropDownSampleType() {
    $('#nonSampleType').val("");
    try {
        $('#nonSampleType').html("");
        dataExTemplate =   jQuery.ajax({
            url: 'util-getDropdownSampleType',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
            	$dropdownSampleType = data
//            	 $('#nonSampleType').append('<option value="ALL" selected="selected">&nbsp;&nbsp;ทั้งหมด</option>');

                $.each(data, function(i, item) {
                    
                 $('#nonSampleType').append('<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
                  arr.push(item.SAMPLE_TYPE_CODE+'#'+item.SAMPLE_TYPE_NAME);
                });
                $('#nonSampleType').select2({
                    /*dropdownAutoWidth: true,
                    width: 'auto'*/
                });
                
            },
            error: function() {
                showMsgError('ข้อมูลผิดพลาด');
            }
        });
    } catch (ex) {
        showMsgError(ex);
    }
    
  
   
}


function getDropdownRootcause(val) {
	ShowWaiting();
    try {
        jQuery.ajax({
            url: 'util-getrootcause',
            type: "Get",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {

			$('#rootcause_m').empty();
			for(var i =0;i<data.length;i++){
     	    $('#rootcause_m').append('<option id=""  value="'+data[i].RTCODE+'">'+data[i].RTNAME+'</option>');
			}
			HideWaiting() ;
			if(val!=''&&val!=null){
				$('#rootcause_m').val(val);
				
			}
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





