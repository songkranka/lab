var basePath = '/Lab/api/';
var poDateunique = [];
var tableName = ["tblReten"];
var tableBoby = ["tbodyReten"];
var renderData ;

$(document).ready(function () {
    init();
});
function init() {
    cntWaitingRandomLastResult();
    genTblRetention();
    selectAllNew();
    setTimeout(function(){
        initDdlStore();
    },100);
}
function selectAllNew(){
	//console.log(table.id);
 	var table = $('#tblReten').DataTable();
	
	    	  $('#example-select-all').on('click', function(){
	    	      // Check/uncheck all checkboxes in the table
	    	      var rows = table.rows({ 'search': 'applied' }).nodes();
	    	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
	    	   });

	    	   // Handle click on checkbox to set state of "Select all" control
	    	   $('#example tbody').on('change', 'input[type="checkbox"]', function(){
	    	      // If checkbox is not checked
	    	      if(!this.checked){
	    	         var el = $('#example-select-all').get(0);
	    	         // If "Select all" control is checked and has 'indeterminate' property
	    	         if(el && el.checked && ('indeterminate' in el)){
	    	            // Set visual state of "Select all" control 
	    	            // as 'indeterminate'
	    	            el.indeterminate = true;
	    	         }
	    	      }
	    	   });
}
function onlyUnique(value, index, self) {
	  return self.indexOf(value) === index;
	}	
function genTblRetention() {
    try{
        var data={};
        data["status"] = "14"; //14
        data["manualType"] = "N";
        ShowWaiting();
        console.log(JSON.stringify(data));
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url: 'randomOilDetail',
            data : JSON.stringify(data),
            async: false,
            cache: false,
            dataType: 'json',
            success : function(data) {
            	//console.log(data.list);
            	if(data.list.length!=0){
            		renderData = data.list;
                	//console.log(renderData);
                	$.each(renderData,function(i,item){
                		poDateunique.push(item.PO_DATE);
                	});
                	poDateunique = poDateunique.filter(onlyUnique);
                	renderDropDown(poDateunique);
                    renderSheet(renderData,tableName[0],tableBoby[0],renderData[0].PO_DATE);
            	}else{
            		 renderSheet(renderData,tableName[0],tableBoby[0],null)
            	}
            	       
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
function renderDropDown(item){
	try{
		/*$('#ddlPodate').select2({
            dropdownAutoWidth: true,
            width: 'auto'
        });*/
		$.each(item,function(i,data){
			$("#ddlPodate").append('<option class="form-control" value="'+data+'">'+data+'</option>');
		});	
		$("#ddlPodate").on('change', function() {
			ShowWaiting();
			renderSheet(renderData,tableName[0],tableBoby[0],this.value);
			HideWaiting();
		});
	}catch(ex){
		showMsgError(ex);
	}
}
function renderSheet(render,table,body,poDate){		
  	try {
		   $('#'+body+'').html("");
	       $('#'+table+'').DataTable().destroy();
	       var det = "";
									 for (var i = 0; i < render.length; i++) {
										 if(poDate==render[i].PO_DATE){
											//console.log(render[i].LAB_CODE);
											 	det +='<tr  class="TBODY">';
												det +='<td class="text-center" ><a href="assignmentDetail?'+ (render[i].LAB_CODE==null?"":render[i].LAB_CODE) +'?tblPlantSuccess?retention">'+ (render[i].LAB_CODE==null?"":render[i].LAB_CODE) +'</a></td>';
												det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(render[i].LAB_CODE==null?"":render[i].LAB_CODE)+'" /> </td>';
												det +='<td class="text-left" >'+ (render[i].SAMPLE_TYPE_NAME==null?"":render[i].SAMPLE_TYPE_NAME)+'</td>';
												//
												det +='<td class="text-left" >'+ (render[i].product_name==null?"":render[i].product_name)+'</td>';
												det +='<td class="text-left" >'+(render[i].source_name==null?"":render[i].source_name)+'</td>'; 
												if(render[i].SAMPLE_TYPE =="00004"){
													det +='<td class="text-left" > - </td>';
												}else{
													det +='<td class="text-left" >'+(render[i].logis_name==null?"":render[i].logis_name)+'</td>';
												}
											
												det +='<td class="text-leftr" >'+(render[i].SAMPLE_LEVEL_DESC==null?"":render[i].SAMPLE_LEVEL_DESC)+'</td>';
												//
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
												//det +='<td class="text-left" >'+(render[i].BOAT_NO==null?"":render[i].BOAT_NO)+'</td>';
												det +='<td class="text-left" >'+(render[i].BOAT_NAME==null?"":render[i].BOAT_NAME)+'</td>';
												det +='<td class="text-left" >'+(render[i].BOAT_SLOTP==null?"":render[i].BOAT_SLOTP)+'</td>'; 
												det +='<td class="text-left" >'+(render[i].BOAT_SLOTS==null?"":render[i].BOAT_SLOTS)+'</td>'; 
												//det +='<td class="text-left" >'+(render[i].ADDITIVE_INV_NO==null?"":render[i].ADDITIVE_INV_NO)+'</td>'; 
												det +='<td class="text-left" >'+(render[i].ADTV_LOT_NO==null?"":render[i].ADTV_LOT_NO)+'</td>'; 
												det +='<td class="text-center" >'+(render[i].STR_SAMPLE_DATE==null?"":render[i].STR_SAMPLE_DATE)+'</td>';
												det +='<td class="text-center" >'+(render[i].STR_SAMPLE_EXPIRE_DATE==null?"":render[i].STR_SAMPLE_EXPIRE_DATE)+'</td>';
												det +='<td class="text-left" >'+(render[i].SAMPLE_STAFF_ID==null?"":render[i].SAMPLE_STAFF_ID)+'</td>';
												det +='<td class="text-left" >'+(render[i].SAMPLE_STAFF_NAME==null?"":render[i].SAMPLE_STAFF_NAME)+'</td>';
												//det +='<td class="text-left" >'+(render[i].OTHERLOGISTIC==null?"":render[i].OTHERLOGISTIC)+'</td>';
												//det +='<td class="text-left" >'+(render[i].SOURCE_OTHER_DESC==null?"":render[i].SOURCE_OTHER_DESC)+'</td>';
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
								 	  
									 }
									 //console.log(det);
									 //console.log(body);
									if(det==''){
										det += '<tr> ';
										det += '<th colspan="35" class="text-center">--- ไม่พบข้อมูล ---</th> ';
										det += '</tr> ';
										$('#'+body+'').html(det);
										HideWaiting() ;
										
									}else{
									//	alert('#dteId_'+nameStore);
										$('#'+body+'').html(det);
										HideWaiting() ;
										
									} 
									table =  $('#'+table+'').DataTable( {
									searching: true,
									responsive : true
								});
									HideWaiting() ;

	} catch (ex) {
//		showMsgError(ex);
		HideWaiting() ;
	}
	 
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

function assigWork(){

    var labCodes = [];
    $("input:checkbox:checked").each(function () {
        labCodes.push($(this).val());
    });

    try{
        var data = {
            param_lab_codes : labCodes
        };
        ShowWaiting();
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'assignjob',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(response) {
                if(response.status == 200){
                    setTimeout(function(){
                        var plantId =  $('#ddlStore').val();
                        var data = {
                            param_store_id: plantId
                        };
                        $.ajax({
                            type: 'POST',
                            contentType : "application/json",
                            url:basePath+'plants',
                            data : JSON.stringify(data),
                            dataType: 'json',
                            success : function(resultPlant) {
                                $('#plantTitle').text("คลังสาขา "+resultPlant.plant +'  พบข้อมูล '+resultPlant.result.length+ ' รายการ');
                                renderSheet(resultPlant.result);
                            }
                        });
                        showMsgSuccess(response.result);
                    },500);
                }else {
                    showMsgError(response.result);
                }
                HideWaiting();
                gotoMain();
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


/*old functions*/
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
            	console.log(data);
                if(data.success==1){
                    HideWaiting() ;
                    updateStatus("Y");
                    $('#popup_random').modal('show');
                    var det = "";
                    for (var i = 0; i < data.list.length; i++) {
                        det +='<tr  >';
                        det +='<td class="text-left" >'+(data.list[i].plant_name==null?"":data.list[i].plant_name)+'</td>';
                        det +='<td class="text-center" >'+(data.list[i].strPO_DATE==null?"":data.list[i].strPO_DATE)+'</td>';
                        det +='<td class="text-right" >'+(data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
                        det +='<td class="text-left" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
                        det +='<td class="text-left" >'+(data.list[i].source_name==null?"":data.list[i].source_name)+'</td>';
                        det +='<td class="text-center" >'+(data.list[i].CNT_SUBSET==null?"":data.list[i].CNT_SUBSET)+'</td>';
                        det +='</tr>';
                    }
                    if(det==''){
                        det += '<tr> ';
                        det += '<th colspan="6" class="text-center">--- ไม่พบข้อมูล ---</th> ';
                        det += '</tr> ';
                        $('#tb-body-import-id').html(det);
                    }else{
                        $('#tb-body-import-id').html(det);
                        table =  $('#myTableSum').DataTable( {
                            searching: true,
                            responsive : true
                        });
                    }
                    //gotoMain();
                    cntWaitingRandomLastResult();
                    genTblRetention();

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
function updateStatus(chk){ 
	let data = {} 
	let sta ;
	let msg ;
	var labCodes = [];
    $("input:checkbox:checked").each(function () {
        labCodes.push($(this).val());
    });
    
    var labCode = "";
    for(var i=0;i<labCodes.length;i++){
    	console.log(labCodes[i]);
    	labCode += "'"+labCodes[i]+"',"
    }
    labCode = labCode.substring(0,labCode.length-1);
    
	if(chk=="Y"){ //random
		sta = "042";
		msg = "สุ่มสำเร็จสำเร็จ";
	}else if("P"){ //pass
		sta = "043";
		data["labCode_No"] = labCode;
		msg = "สำเร็จ";
	}else if("N"){
		sta = "11";
	}
	
	 try{
		data["status"] = sta;
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
				 	init();
					showMsgSuccess(msg);
							
				}else{
					  HideWaiting() ;
					  //showMsgError(data.message);
				}
			}
		});		       
	} catch (ex) {
		 //showMsgError(ex);
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

