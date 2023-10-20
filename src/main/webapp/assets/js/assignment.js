var basePath = '/Lab/api/';
var tableName = ["tblPlantNew","tblPlantSuccess","tblPlantSuccessFul"];
var tableBoby = ["tblPlantNewBody","tblPlantSuccessBody","tblPlantSuccessFulBody"];
var idCheckBox = ["example-select-all_tblPlantNew","example-select-all_tblPlantSuccess","example-select-all_tblPlantSuccessFul",]
var lastResult ;
var renderW = [],renderS =[],renderSF=[] ;
$(document).ready(function () {
    init();

});
function init() {
    // cntWaitingRandomLastResult();
    genTblPlant();
    SetDropDownProduct();
    $.each(idCheckBox,function(i,item){
    	$.each($('#'+item),function(i,item){
    		selectAllNew(item);
    	});
    });
    setTimeout(function(){
        initDdlStore();
    },100);
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
            // async: false,
            cache: false,
            success: function(data) {
            	$('#ddlProduct').append('<option value="all">ทั้งหมด</option>');  
                $.each(data, function(i, item) {
                    $('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">' + item.PRODUCT_NAME + '</option>');                   
                });
               /*
				 * $('#ddlProduct').select2({ dropdownAutoWidth: true, width:
				 * 'auto' });
				 */
            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}
function genTblPlant() {
    try{
    	var plantId =  $('#ddlStore').val();
        var data={};
        data["status"] = "'05','06','08'";
        ShowWaiting();
        // console.log(JSON.stringify(data));
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url: 'randomOilDetail',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(data) {
            	lastResult = data.list;
            	searchForProduct("all");
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

function exportAssigmentWork(){
	  var link = '/Lab/exportAssigmentWork/05';
	  window.open(link, '_blank');
}
function searchForProduct(data){
	renderW = [];
	renderS = [];
	renderSF= [];
	for(var dw=0;dw<lastResult.length;dw++){
		
		if($("#"+data.id).val()=="all" || data=="all"){
			if("05"==lastResult[dw].status){
				renderW.push(lastResult[dw]);
			}else if("06"==lastResult[dw].status){
				renderS.push(lastResult[dw]);
			}else if("08"==lastResult[dw].status){
				renderSF.push(lastResult[dw]);
			}
		}else{
			if(lastResult[dw].PRODUCT_ID==$("#"+data.id).val()){
				// console.log(lastResult[dw].PRODUCT_ID+"|"+$("#"+data.id).val());
				// console.log(lastResult[dw]);
				if("05"==lastResult[dw].status){
					renderW.push(lastResult[dw]);
				}else if("06"==lastResult[dw].status){
					renderS.push(lastResult[dw]);
				}else if("08"==lastResult[dw].status){
					renderSF.push(lastResult[dw]);
				}
			}
		}	
	}
	//console.log(renderW.length,renderS.length,renderSF.length);
	renderSheet(renderW,tableName[0],tableBoby[0]);
    renderSheet(renderS,tableName[1],tableBoby[1]);
    renderSheet(renderSF,tableName[2],tableBoby[2]);
}
function renderSheet(render,table,body){	
	//console.log(render.length,table,body);
	  	try {
	  		// ShowWaiting();
 		     
	  		$('#'+body+'').html("");
	  		$('#'+table+'').DataTable().destroy();
		       let det = "";
										 for (var i = 0; i < render.length; i++) {
									 	  //console.log(render[i].LAB_CODE);
											 	det +='<tr  class="TBODY">';
												det +='<td class="text-center" ><a href="assignmentDetail?'+ (render[i].LAB_CODE==null?"":render[i].LAB_CODE) +'?'+table+'">'+ (render[i].LAB_CODE==null?"":render[i].LAB_CODE) +'</a></td>';
												if(table=="tblPlantNew"){
													det += '<td class="text-center" ><input type="checkbox" class="chk_'+table+'" value="'+(render[i].LAB_CODE==null?"":render[i].LAB_CODE)+'" /> </td>';
												}else{
													det += '<td class="text-center" ><input type="checkbox" disabled class="chk_'+table+'" value="'+(render[i].LAB_CODE==null?"":render[i].LAB_CODE)+'" /> </td>';
												}
												det +='<td class="text-left" >'+ (render[i].SAMPLE_TYPE_NAME==null?"":render[i].SAMPLE_TYPE_NAME)+'</td>';
												det +='<td class="text-left" >'+ (render[i].product_name==null?"":render[i].product_name)+'</td>';
												det +='<td class="text-left" >'+(render[i].source_name==null?"":render[i].source_name)+'</td>'; 
												if(render[i].SAMPLE_TYPE =="00004"){
													det +='<td class="text-left" > - </td>';
												}else{
													det +='<td class="text-left" >'+(render[i].logis_name==null?"":render[i].logis_name)+'</td>';
												}
												det +='<td class="text-leftr" >'+(render[i].SAMPLE_LEVEL_DESC==null?"":render[i].SAMPLE_LEVEL_DESC)+'</td>';
												det +='<td class="text-left" >'+ (render[i].SAMPLE_REFER==null?"":render[i].SAMPLE_REFER)+'</td>';
												det +='<td class="text-left" >'+(render[i].PO_NO==null?"":render[i].PO_NO)+'</td>'; 
												det +='<td class="text-left" >'+(render[i].STRPO_DATE==null?"":render[i].STRPO_DATE)+'</td>'; 
												det +='<td class="text-left" >'+(render[i].DO_NO==null?"":render[i].DO_NO)+'</td>'; 
												det +='<td class="text-left" >'+(render[i].SHIPMENT_NO==null?"":render[i].SHIPMENT_NO)+'</td>';  
												det +='<td class="text-left" >'+(render[i].SAMPLE_DATA_GROUP==null?"":render[i].SAMPLE_DATA_GROUP)+'</td>'; 
												det +='<td class="text-left" >'+(render[i].SAMPLE_DATA_SEQ==null?"":render[i].SAMPLE_DATA_SEQ)+'</td>';  
												det +='<td class="text-left" > '+(render[i].METER_NO==null?"":render[i].METER_NO)+'</td>';
												det +='<td class="text-left" > '+(render[i].CAR_NO==null?"":render[i].CAR_NO)+'</td>';
												det +='<td class="text-left" >'+(render[i].CAR_SLOT==null?"":render[i].CAR_SLOT)+'</td>';
												det +='<td class="text-left" >'+(render[i].BOAT_NAME==null?"":render[i].BOAT_NAME)+'</td>';
												det +='<td class="text-left" >'+(render[i].BOAT_SLOTP==null?"":render[i].BOAT_SLOTP)+'</td>'; 
												det +='<td class="text-left" >'+(render[i].BOAT_SLOTS==null?"":render[i].BOAT_SLOTS)+'</td>'; 
												det +='<td class="text-left" >'+(render[i].ADTV_LOT_NO==null?"":render[i].ADTV_LOT_NO)+'</td>'; 
												det +='<td class="text-center" >'+(render[i].STR_SAMPLE_DATE==null?"":render[i].STR_SAMPLE_DATE)+'</td>';
												det +='<td class="text-center" >'+(render[i].STR_SAMPLE_EXPIRE_DATE==null?"":render[i].STR_SAMPLE_EXPIRE_DATE)+'</td>';
												det +='<td class="text-left" >'+(render[i].SAMPLE_STAFF_ID==null?"":render[i].SAMPLE_STAFF_ID)+'</td>';
												det +='<td class="text-left" >'+(render[i].SAMPLE_STAFF_NAME==null?"":render[i].SAMPLE_STAFF_NAME)+'</td>';
												det +='<td class="text-left" >'+(render[i].SUB_TYPE_NAME==null?"":render[i].SUB_TYPE_NAME)+'</td>';
												det +='<td class="text-left" >'+(render[i].SAMPLE_TYPEC_DESC==null?"":render[i].SAMPLE_TYPEC_DESC)+'</td>';
												det +='<td class="text-left" >'+(render[i].TANK_NO==null?"":render[i].TANK_NO)+'</td>';
												det +='<td class="text-left" >'+(render[i].TYPE_NAME==null?"":render[i].TYPE_NAME)+'</td>';
												det +='<td class="text-left" >'+(render[i].LOC_NAME==null?"":render[i].LOC_NAME)+'</td>';
												det +='<td class="text-left" >'+(render[i].SAMPLE_POINT_DESC==null?"":render[i].SAMPLE_POINT_DESC)+'</td>';
												det +='<td class="text-left" >'+(render[i].RETURNR_DESC==null?"":render[i].RETURNR_DESC)+'</td>';
												det +='<td class="text-left" >'+(render[i].STATUS_NAME==null?"":render[i].STATUS_NAME)+'</td>';
												det +='<td class="text-left" >'+(render[i].CANCEL_DESC==null?"":render[i].CANCEL_DESC)+'</td>';
												det +='<td class="text-left" >'+(render[i].CANCEL_NAME==null?"":render[i].CANCEL_NAME)+'</td>';
												det +='<td class="text-left" >'+(render[i].REVISE_DESC==null?"":render[i].REVISE_DESC)+'</td>';
												det +='<td class="text-left" >'+(render[i].REVISE_CODE==null?"":render[i].REVISE_CODE)+'</td>';
												det +='</tr>';
										 }
										 //console.log(det);
										 // console.log(body);
										if(det==''){
											$('#'+body+'').html(det);
											HideWaiting() ;
											
										}else{
										// alert('#dteId_'+nameStore);
											$('#'+body+'').html(det);
											HideWaiting() ;
											
										} 
										$('#'+table+'').DataTable( {
											searching: true,
											responsive : true
										});
										HideWaiting() ;

		} catch (ex) {
			console.log(ex);
			HideWaiting() ;
		}
 	 
 } 
function selectAllNew(data){
	// console.log(data);
	$("#"+data.id).click(function(){
		console.log(data.value);
	    $('.chk_'+data.value).not(this).prop('checked', this.checked);
	});
}

function initDdlStore() {
    var data = {};
    try {
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'stores',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(response) {
                $.each(response.store, function (i, item) {
                    $('#ddlStore').append('<option value="' + item.PLANT_ID + '">&nbsp;&nbsp;&nbsp;&nbsp;' + item.PLANT_NAME + '&nbsp;&nbsp;&nbsp;&nbsp;</option>');
                });
                $('#ddlStore').multiselect('rebuild');
                $("#ddlStore").multiselect('updateButtonText');
                $('#ddlStore').trigger('change');
                $("#ddlStore").multiselect("refresh");
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);
    }
}

$('#selAllLabCode').on('click',function(){
    if(this.checked){
        $('.labCodes').each(function(){
            this.checked = true;
        });
    }else{
        $('.labCodes').each(function(){
            this.checked = false;
        });
    }
});

$('.labCodes').on('click',function(){
    if($('.labCodes:checked').length == $('.labCodes').length){
        $('#selAllLabCode').prop('checked',true);
    }else{
        $('#selAllLabCode').prop('checked',false);
    }
});

function assigWorkForA1(){

    var labCodes = [];
    $("input:checkbox:checked").each(function () {
        labCodes.push($(this).val());
    });
    
    var labCode = "";
    for(var i=0;i<labCodes.length;i++){

    	labCode += "'"+labCodes[i]+"',"
    }
    labCode = labCode.substring(0,labCode.length-1);
    // console.log(labCode);
    
	try {
	    	var data = {}	
	    	data["labCode"] = labCode;
	    	console.log(JSON.stringify(data));
	    	ShowWaiting() ;
			jQuery.ajax({
			url : 'insertLTRAssignment',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
						showMsgSuccess('มอบหมายงานสำเร็จ');
						HideWaiting() ;
						genTblPlant();
					},
					error : function() {
						 showMsgError('เกิดข้อผิดพลาด');
						 HideWaiting() ;
					}
				});   
	} catch (ex) {

		 showMsgError(ex);
		 HideWaiting() ;
	}
	
	

}
function cancelWork(){

    let labCodes = [];
    $("input:checkbox:checked").each(function () {
        labCodes.push($(this).val());
    });
    
    let labCode = "";
    for(var i=0;i<labCodes.length;i++){

    	labCode += "'"+labCodes[i]+"',"
    }
    labCode = labCode.substring(0,labCode.length-1);

    
	try {
	    	var data = {}	
	    	data["labCode"] = labCode;
	    	console.log(JSON.stringify(data));
	    	ShowWaiting() ;
			jQuery.ajax({
			url : 'cancelLTRAssignment',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
						showMsgSuccess('ยกเลิกสำเร็จ');
						HideWaiting() ;
						genTblPlant();
					},
					error : function() {
						 showMsgError('เกิดข้อผิดพลาด');
						 HideWaiting() ;
					}
				});   
	} catch (ex) {

		 showMsgError(ex);
		 HideWaiting() ;
	}
	
	

}

/* old functions */
function cntWaitingRandomLastResult() {
    var rtnDate = "";
    var data = {}
    jQuery.ajax({
        url : '/Lab/cntWaitingRandomLastResult',
        type : 'Post',
        contentType : 'application/json',
        data : JSON.stringify(data),
        dataType : 'json',
        success : function(obj) {
            $('#cntRandomSample').html(obj.cnt);
        }
    }).fail(function(){
        showMsgError('ข้อมูลผิดพลาด');
    });

    return rtnDate
}

function saveRandomOil(){
    try{
        $('#tb-body-import-id').html("");
        $('#myTableSum').DataTable().destroy();
        ShowWaiting() ;
        var data = {}
        jQuery.ajax({
            url : '/Lab/insertRandomLastResult',
            type : "Post",
            contentType : "application/json",
            data : JSON.stringify(data),
            dataType : 'json',
            success : function(data) {
                if(data.success==1){
                    HideWaiting() ;
                    updateStatus();
                    $('#popup_random').modal('show');
                    var det = "";
                    for (var i = 0; i < data.list.length; i++) {
                        det +='<tr  >';
                        det +='<td class="text-left" >'+(data.list[i].plant_name==null?"":data.list[i].plant_name)+'</td>';
                        det +='<td class="text-center" >'+(data.list[i].strPO_DATE==null?"":data.list[i].strPO_DATE)+'</td>';
                        det +='<td class="text-right" >'+(data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
                        det +='<td class="text-left" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
                        det +='<td class="text-center" >'+(data.list[i].CNT_SUBSET==null?"":data.list[i].CNT_SUBSET)+'</td>';
                        det +='</tr>';
                    }
                    if(det==''){
                        det += '<tr> ';
                        det += '<th colspan="5" class="text-center">--- ไม่พบข้อมูล ---</th> ';
                        det += '</tr> ';
                        $('#tb-body-import-id').html(det);
                    }else{
                        $('#tb-body-import-id').html(det);
                        table =  $('#myTableSum').DataTable( {
                            searching: true,
                            responsive : true
                        });
                    }
                    // gotoMain();
                    cntWaitingRandomLastResult();
                    

                }else if(data.success==2){
                    HideWaiting() ;
                    var  msg  = getMsg("MSG1");

                    showMsgWarning(msg);
                }else{

                    HideWaiting() ;
                    showMsgError(data.message);

                }
            },
            error : function(ex) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting() ;
            }
        });
    } catch (ex) {
        showMsgError('เกิดข้อผิดพลาด');
        HideWaiting() ;
    }

}
function updateStatus(){ 
	// alert('455555');
	 try{
		var data = {} 
		// data["labCode_No"] = "'"+$("#labCode").val()+"'";
		data["status"] = "042";
		console.log(JSON.stringify(data));
		ShowWaiting() ;
		 jQuery.ajax({
			url : 'updateStatusSendAnalysis',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json', 
			success : function(data) {
		     
				if(data.success==1){ 
				 	HideWaiting() ;
					showMsgSuccess("สุ่มสำเร็จสำเร็จ");
							
				}else{
					  HideWaiting() ;
					  // showMsgError(data.message);
				}
			}
		});		       
	} catch (ex) {
		 // showMsgError(ex);
		  HideWaiting() ;
		 
	}
	 
} 
function cancelSave(){
	Swal.fire({
	  title: 'คุณต้องการยกเลิกหรือไม่ ?',
	  text: "",
	  type: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#d33',
	  cancelButtonColor: '#3085d6',
	  confirmButtonText: 'ตกลง',
	  cancelButtonText: 'ยกเลิก'
	}).then((result) => {
		  if (result.value) {
			  updateStatus("N");
		  }
	})
}

