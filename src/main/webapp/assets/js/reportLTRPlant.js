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
    checkLevel();
//    selectAllNew()
    $("#nonSampleType").change(function () {                     
    });
    
    $("#nonProduct").change(function () {
        if($(this).val()=="ALL"){
        	//
        	
        }else{
        	$("#nonProduct option[value='ALL']").remove();
    	    $('#nonProduct').prepend('<option value="ALL"  >&nbsp;&nbsp;ทั้งหมด</option>');
        }                           
    });
    
    
    $("#nonTypeReport").change(function (){
    	
    	if(this.value=='COQ'){
    		checkType = "COQ";
    		 $('#nonProduct').empty()
    		renderDropDownProduct($dropdownProduct);
    		//SetDropDownProduct();   		
    		 $("#nonSampleType").empty();
    		 renderDropDownSampleType($dropdownSampleType);
    		  
    		  
    		// SetDropDownSampleType()
    	}else{
    		checkType = "LTR";
    		 $('#nonProduct').empty()
    
    		renderDropDownProduct($dropdownProduct);
    		//SetDropDownProduct();   		
    		 $("#nonSampleType").empty();
    		 renderDropDownSampleType($dropdownSampleType);
    	}
    	$('#bodyTemplate').empty()
    	}		
    );
 
});
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
function checkAll(id){
	var chk = '.'+id.id
	var chkHead ='.'+$(id).attr('class')
	var booleanchk = $(chkHead).is(":checked")
	if(booleanchk==true){
		  $(chk).each(function(){
	            this.checked = true;
        });
	}else if(booleanchk==false){
		
		 $(chk).each(function(){
	            this.checked = false;
        });
	}
}
function checkDetail(id){
	
	var chkHead ='.'+$(id).attr('class')
	var chk = '.chkHead'+$(id).attr('class')
	var booleanchk = true;


		  $(chkHead).each(function(){
			  if(this.checked){
				  
			  }else{
				  booleanchk = false;
			  }
			  
        });
	if(!booleanchk){
		// console.log(chk);
		$(chk).prop('checked',false)
	}else{
		// console.log(chk);
		$(chk).prop('checked',true)
	}

}


function getReportLTRTruck() {
	
   window.location=basePath+'reportTuck';

}

function renderSheet(data) {
	var $body = $('#bodyTemplate')
	var result = {};
	var resultList =[]
	$.each($("#nonSampleType").val(),function(index,item){
		result[item]= item
	})
	$.each(result,function(index,item){
		resultList = []
		
		$.each(data,function(a,b){
			
			if(item==b.sampleCode){
				resultList.push(data[a])
			}			
		})
		result[item] = resultList
	})
	console.log(result)

	$body.empty();
	if($("#nonSampleType").val()!='ALL'){
		$.each($("#nonSampleType").val(),function(index,items){
	    	var labelTemplate = $("#nonSampleType option[value='"+items+"']").text()
			var button = "";
	    	if("LTR"==$('#nonTypeReport').val()){
				if("00006"==items.toString()){
					//button +='<button type="button" class="btn btn-primary col-xs-offset-7 col-xs-2"  onclick="exportExcelHeader(idTable'+items+')" style="margin-right: 10px;"><i class="fa fa-print"></i>  Print Result</button>'
					button += '<button type="button" class="btn btn-primary col-xs-offset-9 col-xs-2" style="width: 181px;" foo='+labelTemplate.trim()+' onclick="exportReportLTR(idTable'+items+',this)"><i class="fa fa-print"></i>  Print LTR </button>'
				}else{
					//button +='<button type="button" class="btn btn-primary col-xs-offset-7 col-xs-2"  onclick="exportExcelHeader(idTable'+items+')" style="margin-right: 10px;"><i class="fa fa-print"></i>  Print Result</button>'
					button += '<button type="button" class="btn btn-primary col-xs-offset-9 col-xs-2" style="width: 181px;" foo='+labelTemplate.trim()+' onclick="exportReportLTR(idTable'+items+',this)"><i class="fa fa-print"></i>  Print LTR </button>'
				}
	    	}else{
				if("00006"==items.toString()){			
					button += '<button type="button" class="btn btn-primary col-xs-offset-9 col-xs-2" style="width: 181px;" foo='+labelTemplate.trim()+' onclick="exportReportLTR(idTable'+items+',this)"><i class="fa fa-print"></i>  Print COQ </button>'
				}else{
					//button +='<button type="button" class="btn btn-primary col-xs-offset-7 col-xs-2"  onclick="exportExcelHeader(idTable'+items+')" style="margin-right: 10px;"><i class="fa fa-print"></i>  Print Result</button>'
					button += '<button type="button" class="btn btn-primary col-xs-offset-9 col-xs-2" style="width: 181px;" foo='+labelTemplate.trim()+' onclick="exportReportLTR(idTable'+items+',this)"><i class="fa fa-print"></i>  Print COQ </button>'
				}
	    	}
		
	    		$body.append('<div class="row">'+
	    		'<div class="col-lg-12">'+
	    		'<div class="ibox float-e-margins">'+
	    		'<div class="ibox-title">'+
	    		'<h5>'+labelTemplate+'</h5>'+
	    		'<div class="ibox-tools">'+
	    		'<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>'+
	    		'</div>'+
	    		'<div class="ibox-content">'+
				'<div class="row">'+
					button+
					
					'<div class="col-xs-12" >'+
						'<div class="table-responsive">'+
						'<table id="idTable'+items+'" class="table table-striped table-bordered" style="padding: 0px;width:100%;">'+
							'<thead  class="tbHeader">'+
								'<tr>'+
									 '<th class="text-left" colspan="10" style="background-color: #fff; padding-left:10px; border-right-color: back;" >'+
										'<span id="title+'+items+'">รายงาน'+labelTemplate+'</span>'+
									 '</th>'+
								'</tr>'+
								'<tr>'+
									'<th class="text-center">NO</th>'+
									'<th class="text-center">'+
									'<div class="select_Lab">Check All </div>'+
									'<input type="checkbox" onclick="checkAll(this)	" id="'+items+'" class="chkHead'+items+'" /></th>'+
									'<th class="text-center">Lab Code</th>'+
									'<th class="text-center">Report No</th>'+
									'<th class="text-center">Sample Type Name</th>'+
									'<th class="text-center">Product Name</th>'+
									'<th class="text-center">Create Date</th>'+
									'<th class="text-center">Create By</th>'+
								'</tr>'+
							'</thead>'+
						'</table>'+
						'</div>'+
					' </div>'+
				' </div>'+
	    		' </div>'+
	    		'</div>'+
	    		'</div>');
	    })
	    
	    $('#idTable tbody').remove();
		console.log(result);
	    $.each(result,function(index,value){
//	    		 console.log(value)
	    		 $('#idTable'+index+'').dataTable({
	    	            "searching" : true,
	    	            "bSort" : true,
	    	            "paging" : true,
	    	            "bFilter" : false,
	    	            "data" : value,
	    	            "destroy": true,
	    	            "info" : false,
	    	            "pageLength": 20,
	    	            "aaSorting": [],
	    	            "responsive": true,
	    	            "dom": 'lfrtip',
	    	            "columns" : [
	    	                { "data": null,"sortable": true,"className" : "text-center",
	    	                    render: function (data, type, row, meta) {
	    	                        return meta.row + meta.settings._iDisplayStart + 1;
	    	                    }
	    	                },
	    	                {"data" : null,"className" : "text-center text-nowrap",orderable : false,"searchable": false, render :
	    	                    function(o) {
//	    	                        if(o.ASSIGN_STATUS == null || o.ASSIGN_STATUS == '' || o.ASSIGN_STATUS == 'null'){
	    	                            return "<input type='checkbox' onclick='checkDetail(this)' class='"+value[0].sampleCode+"' name='labCodes' />";
	    	                }

	    	                },
	    	                {"data" : "labCode","className" : "text-center text-nowrap" ,"value":"labCode", orderable : true},
                            {"data" : "reportNo","className" : "text-center text-nowrap" ,"value":"reportNo", orderable : true},
	    	                {"data" : "sampleTypeName","className" : "text-center text-nowrap", orderable : true},
	    	                // {"data" : "productName","className" : "text-center text-nowrap", orderable : true},
	    	                {"data" : null,"className" : "text-center text-nowrap","id":"productId", orderable : true, render :
							function(o) {
								return "<td class='text-center text-nowrap' id='"+value[0].productId+"' name='productId'>"+o.productName+"</td>";
								}
							},
							// <td class=" text-center text-nowrap">PT Max Diesel B7</td>
	    	                {"data" : "createDate","className" : "text-center text-nowrap", orderable : true},
	    	                {"data" : "createBy","className" : "text-center text-nowrap", orderable : true},
	    	            ],
	    	            "language": {
	    	                "emptyTable": "-- ไม่พบข้อมูลที่ค้นหา --",
	    	                "info": "แสดง _START_ ถึง _END_ จากทั้งหมด _TOTAL_ รายการ",
	    	                "lengthMenu": "แสดง _MENU_ รายการ",
	    	                "paginate" : {
	    	                    "first":      "หน้าแรก",
	    	                    "previous":   "ก่อนหน้า",
	    	                    "next":       "ถัดไป",
	    	                    "last":       "หน้าสุดท้าย"
	    	                }
	    	            },
	    	            "columnDefs" : [{}]
	    	            ,"initComplete" : function(row, data, index) {
	    	        
	    	            }
	    	        });
	    	
	    	
	       
	    })
	    
	    
	}else{
		var result = {};
		var resultList =[]
		$.each($dropdownSampleType,function(index,item){
			console.log(item.SAMPLE_TYPE_CODE)
			result[item.SAMPLE_TYPE_CODE]= item
		})
	console.log(result)
		$.each(result,function(index,item){
			resultList = []
			
//			console.log(item);
		
			$.each($dataLTR,function(a,b){
//				console.log(b)
				if(item.SAMPLE_TYPE_CODE===b.sampleCode){
					resultList.push($dataLTR[a])
				}			
			})
			console.log(resultList)
			result[item.SAMPLE_TYPE_CODE] = resultList
		})
		
//		console.log(result)
//		
		$.each($dropdownSampleType,function(index,items){
			var labelTemplate = $("#nonSampleType option[value='"+items.SAMPLE_TYPE_CODE+"']").text()
			var button = "";
	    	if("LTR"==$('#nonTypeReport').val()){
				if("00006"==items.SAMPLE_TYPE_CODE.toString()){
					//button +='<button type="button" class="btn btn-primary col-xs-offset-7 col-xs-2"  onclick="exportExcelHeader(idTable'+items.SAMPLE_TYPE_CODE+')" style="margin-right: 10px;"><i class="fa fa-print"></i>  Print Result</button>'
					button += '<button type="button" class="btn btn-primary col-xs-offset-9 col-xs-2" style="width: 181px;" foo='+labelTemplate.trim()+' onclick="exportReportLTR(idTable'+items.SAMPLE_TYPE_CODE+',this)"><i class="fa fa-print"></i>  Print LTR </button>'
				}else{
					//button +='<button type="button" class="btn btn-primary col-xs-offset-7 col-xs-2"  onclick="exportExcelHeader(idTable'+items.SAMPLE_TYPE_CODE+')" style="margin-right: 10px;"><i class="fa fa-print"></i>  Print Result</button>'
					button += '<button type="button" class="btn btn-primary col-xs-offset-9 col-xs-2" style="width: 181px;" foo='+labelTemplate.trim()+' onclick="exportReportLTR(idTable'+items.SAMPLE_TYPE_CODE+',this)"><i class="fa fa-print"></i>  Print LTR </button>'
				}
	    	}else{
				if("00006"==items.SAMPLE_TYPE_CODE.toString()){			
					button += '<button type="button" class="btn btn-primary col-xs-offset-9 col-xs-2" style="width: 181px;" foo='+labelTemplate.trim()+' onclick="exportReportLTR(idTable'+items.SAMPLE_TYPE_CODE+',this)"><i class="fa fa-print"></i>  Print COQ </button>'
				}else{
					//button +='<button type="button" class="btn btn-primary col-xs-offset-7 col-xs-2"  onclick="exportExcelHeader(idTable'+items.SAMPLE_TYPE_CODE+')" style="margin-right: 10px;"><i class="fa fa-print"></i>  Print Result</button>'
					button += '<button type="button" class="btn btn-primary col-xs-offset-9 col-xs-2" style="width: 181px;" foo='+labelTemplate.trim()+' onclick="exportReportLTR(idTable'+items.SAMPLE_TYPE_CODE+',this)"><i class="fa fa-print"></i>  Print COQ </button>'
				}
	    	}
		
	    		$body.append('<div class="row">'+
	    		'<div class="col-lg-12">'+
	    		'<div class="ibox float-e-margins">'+
	    		'<div class="ibox-title">'+
	    		'<h5>'+labelTemplate+'</h5>'+
	    		'<div class="ibox-tools">'+
	    		'<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>'+
	    		'</div>'+
	    		'<div class="ibox-content">'+
				'<div class="row">'+
					button+
					
					'<div class="col-xs-12" >'+
						'<div class="table-responsive">'+
						'<table id="idTable'+items.SAMPLE_TYPE_CODE+'" class="table table-striped table-bordered" style="padding: 0px;width:100%;">'+
							'<thead  class="tbHeader">'+
								'<tr>'+
									 '<th class="text-left" colspan="10" style="background-color: #fff; padding-left:10px; border-right-color: back;" >'+
										'<span id="title+'+items.SAMPLE_TYPE_CODE+'">รายงาน'+labelTemplate+'</span>'+
									 '</th>'+
								'</tr>'+
								'<tr>'+
									'<th class="text-center">NO</th>'+
									'<th class="text-center">'+
									'<div class="select_Lab">Check All </div>'+
									'<input type="checkbox" onclick="checkAll(this)	" id="'+items.SAMPLE_TYPE_CODE+'" class="chkHead'+items.SAMPLE_TYPE_CODE+'" /></th>'+
									
//									'<input id="example-select-all" value="1" name="select_all" type="checkbox" foo="idTable'+items.SAMPLE_TYPE_CODE+'" onclick="selectAllNew(this)"></th>'+
									'<th class="text-center">Lab Code</th>'+
									'<th class="text-center">Report No</th>'+
									'<th class="text-center">Sample Type Name</th>'+
									'<th class="text-center">Product Name</th>'+
									'<th class="text-center">Create Date</th>'+
									'<th class="text-center">Create By</th>'+
								'</tr>'+
							'</thead>'+
						'</table>'+
						'</div>'+
					' </div>'+
				' </div>'+
	    		' </div>'+
	    		'</div>'+
	    		'</div>');
		})
		 $('#idTable tbody').remove();
	    $.each(result,function(index,value){
	    		 console.log(value)
	    		 $('#idTable'+index+'').dataTable({
	    	            "searching" : true,
	    	            "bSort" : true,
	    	            "paging" : true,
	    	            "bFilter" : false,
	    	            "data" : value,
	    	            "destroy": true,
	    	            "info" : false,
	    	            "aaSorting": [],
	    	            "pageLength": 20,
	    	            "responsive": true,
	    	            "dom": 'lfrtip',
	    	            "columns" : [
	    	                { "data": null,"sortable": true,"className" : "text-center",
	    	                    render: function (data, type, row, meta) {
	    	                        return meta.row + meta.settings._iDisplayStart + 1;
	    	                    }
	    	                },
	    	                {"data" : null,"className" : "text-center text-nowrap",orderable : false,"searchable": false, render :
	    	                    function(o) {
//	    	                        if(o.ASSIGN_STATUS == null || o.ASSIGN_STATUS == '' || o.ASSIGN_STATUS == 'null'){
	    	                            return "<input type='checkbox' onclick='checkDetail(this)' class='"+value[0].sampleCode+"' name='labCodes' />";
	    	                }

	    	                },
	    	                {"data" : "labCode","className" : "text-center text-nowrap" ,"value":"labCode", orderable : true},
						    {"data" : "reportNo","className" : "text-center text-nowrap" ,"value":"reportNo", orderable : true},
	    	                {"data" : "sampleTypeName","className" : "text-center text-nowrap", orderable : true},
	    	                // {"data" : "productName","className" : "text-center text-nowrap", orderable : true},
	    	                {"data" : null,"className" : "text-center text-nowrap","id":"productId", orderable : true, render :
							function(o) {
								return "<td class='text-center text-nowrap' id='"+value[0].productId+"' name='productId'>"+o.productName+"</td>";
								}
							},
							// <td class=" text-center text-nowrap">PT Max Diesel B7</td>
	    	                {"data" : "createDate","className" : "text-center text-nowrap", orderable : true},
	    	                {"data" : "createBy","className" : "text-center text-nowrap", orderable : true},
	    	            ],
	    	            "language": {
	    	                "emptyTable": "-- ไม่พบข้อมูลที่ค้นหา --",
	    	                "info": "แสดง _START_ ถึง _END_ จากทั้งหมด _TOTAL_ รายการ",
	    	                "lengthMenu": "แสดง _MENU_ รายการ",
	    	                "paginate" : {
	    	                    "first":      "หน้าแรก",
	    	                    "previous":   "ก่อนหน้า",
	    	                    "next":       "ถัดไป",
	    	                    "last":       "หน้าสุดท้าย"
	    	                }
	    	            },
	    	            "columnDefs" : [{}]
	    	            ,"initComplete" : function(row, data, index) {
	    	        
	    	            }
	    	        });
	    	
	    	
	       
	    })
	}
    
   
   
}

function ajaxGetDataReportLTR(){
	var product = "";
	var sampleType = "";
	var chkVal = 0;
		if($('#nonProduct').val()==null){
			chkVal =1;
			showMsgError('กรุณาเลือก ผลิตภัณฑ์');
		}
		if($('#nonSampleType').val()==null){
			chkVal =1;
			showMsgError('กรุณาเลือก ประเภทตัวอย่าง');
		}

	$.each($('#nonProduct').val(),function (index,item) {
		if(""==product){
			product = item
		}else{
			product+='#'+item
		}
	})

	$.each($('#nonSampleType').val(),function (index,item) {
		if(""==sampleType){
			sampleType= item
		}else{
			sampleType+='#'+item
		}
	})
	let dataTypeReportSearch = "";
	if($("#nonTypeReport").val()=="LTR"){
		dataTypeReportSearch = "1";
	}else if($("#nonTypeReport").val()=="COQ"){
		dataTypeReportSearch = "2";
	}else{
		dataTypeReportSearch = "";
	}

	var obj  ={
			startDate : $('#sdate').val(),
			endDate : $('#edate').val(),
			productType :product,
			sampleTypeCode: sampleType,
			plantID : plant_id,
			resultltr: '',
			typeReportSearch : dataTypeReportSearch
		}
	if(chkVal!=1){
		try {
			jQuery.ajax({
				url: 'getDataReportLTR',
				type: "POST",
				contentType: "application/json",
				dataType: 'json',
				data : JSON.stringify(obj),
				async: false,
				cache: false,
				success: function(data) {
					$dataLTR = data
					
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
            	
      	   $('#nonProduct').append('<option value="ALL"  >&nbsp;&nbsp;ทั้งหมด</option>');
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
            	$('#nonSampleType').prepend('<option value="ALL"  >&nbsp;&nbsp;ทั้งหมด</option>');
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



function exportExcelHeader(data){

	var check = $('#'+data.id+' tbody tr');
	var arr ="";
	var arrList = []


	$.each(check,function(index,items){
		arrList.push($(this).find('td:eq(4)').text())

		if($(this).find('td:eq(1) input')[0].checked){

			if(arr==""){
				arr+=$(this).find('td:eq(2)').text()
			}else{
				arr+=","+$(this).find('td:eq(2)').text()
			}
		}
	})
	var result = unique(arrList)
	console.log(result)

	var url= basePath+'reportExcelHeader?labCode='+arr+'&reportType='+$('#nonTypeReport').val();
	 window.location=url;

}

function unique(list) {
	var result = [];
	$.each(list, function(i, e) {
		if ($.inArray(e, result) == -1) result.push(e);
	});
	return result;
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


function renderDropDownProduct(data) {
   
                $.each(data, function(i, item) {
                	console.log(item.PRODUCT_ID + ":" + item.PRODUCT_NAME)
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

}
function renderDropDownSampleType(data) {
   
	 $.each(data, function(i, item) {
		 if($('#nonTypeReport').val()==='COQ'){
			 if('00004'===item.SAMPLE_TYPE_CODE){
				 $('#nonSampleType').append('<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
		          arr.push(item.SAMPLE_TYPE_CODE+'#'+item.SAMPLE_TYPE_NAME);
			 }
			
		 }else{
			 $('#nonSampleType').append('<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
	          arr.push(item.SAMPLE_TYPE_CODE+'#'+item.SAMPLE_TYPE_NAME);
		 }
        
        });
   
        
    
	
   
}
//function selectAllNew(table){
//	
////	var tableName = table.foo
//	console.log(table);
//	 	var table = $('#'+tableName+'').DataTable();
//		
//		    	  $('#example-select-all').on('click', function(){
//		    	      // Check/uncheck all checkboxes in the table
//		    	      var rows = table.rows({ 'search': 'applied' }).nodes();
//		    	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
//		    	   });
//
//		    	   // Handle click on checkbox to set state of "Select all" control
//		    	   $('#example tbody').on('change', 'input[type="checkbox"]', function(){
//		    	      // If checkbox is not checked
//		    	      if(!this.checked){
//		    	         var el = $('#example-select-all').get(0);
//		    	         // If "Select all" control is checked and has 'indeterminate' property
//		    	         if(el && el.checked && ('indeterminate' in el)){
//		    	            // Set visual state of "Select all" control 
//		    	            // as 'indeterminate'
//		    	            el.indeterminate = true;
//		    	         }
//		    	      }
//		    	   });
//	}






