var tmp_data = "";
$(document).ready(function(){
	SetDropDownProduct();
	SetDropSampleType();
    selectAllNew();
    searchData();
});
function searchData(){
	
	querySPITEM($('#ddlProduct').val(), $('#ddlSampleType').val());
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
function selectAllNew(){
	 	var table = $('#myTableDteId').DataTable();
		
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

function saveData(status){
	//console.log(status);
	 var itemmp_id =  "";
	 $("input[name='chk']").each(function() {  
    	        if($(this).prop('checked')){
    	        	     for(var i=0;i<tmp_data.list.length;i++){
    			 			  if($(this).val()==tmp_data.list[i].ITEMMP_ID){   
    			 				 itemmp_id += "'"+$(this).val()+"',";   ;
    			 			  } 
    			 		 }	 
    	        }
	 });
	 itemmp_id = itemmp_id.substring(0,itemmp_id.length-1);		 
	 try {
	    var data = {}
	    data["itemmp_id"] = itemmp_id;
	    data["status"] = status;
	    ShowWaiting();
	    jQuery.ajax({
			url : 'updateMPSpecAssign',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
						showMsgSuccess('สำเร็จ');
						//SetDropDownProduct();
						querySPITEM();
						HideWaiting() ;
			},
			error : function() {
						showMsgError('ข้อมูลผิดพลาด');
						HideWaiting() ;
			}
			});  
	} catch (ex) {
		showMsgError(ex);
		HideWaiting() ;
	}
}
function querySPITEM(productID,sampleType){
	//console.log(productID);
	  	try {

 		      $('#dteId').html("");
 	  	      $('#myTableDteId').DataTable().destroy();
 		 
		    			var data = {}
		    			data["productID"] = productID;
		    			data["sampleType"] = sampleType;
		    			console.log(JSON.stringify(data));
		    			ShowWaiting();
					  jQuery.ajax({
						url : 'querySPITEM',
						type : "Post", 
						contentType : "application/json",
						data : JSON.stringify(data), 
						dataType : 'json',
						async: false,
						cache: false,
						success : function(data) {
							var det = '';
							tmp_data = data;
							//console.log(data.list.length);
							if(data.list.length != '0'){
								for (var i = 0; i < data.list.length; i++){	  
									det +='<tr  class="TBODY">';
									det +='<td class="text-center" >'+ (i+1) +'</td>';
									det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(data.list[i].ITEMMP_ID==null?"":data.list[i].ITEMMP_ID)+'" /> </td>';
									det +='<td class="text-center" >'+ (data.list[i].ITEM_NAME==null?"":data.list[i].ITEM_NAME)+'</td>';
									det +='<td class="text-center" >'+ (data.list[i].STATUS_NAME==null?"":data.list[i].STATUS_NAME)+'</td>';
									det += '</tr> ';
								}
								$('#dteId').html(det);
								HideWaiting() ;	
							}else{
								det += '<tr> ';
								det += '<td class="text-center"></td> ';
								det += '<td class="text-center"></td> ';
								det += '<td class="text-center">---ไม่พบข้อมูล--</td> ';
								det += '<td class="text-center"></td> ';
								det += '</tr> ';
								$('#dteId').html(det);
								HideWaiting() ;	
							}
							
							$('#myTableDteId').DataTable( {
							paging :   false,
							searching: true,
							responsive : true,
							"columnDefs": [
										{ "orderable": false, "targets": 1 }
										 ]
										});
							
							HideWaiting() ;
						},
						error : function() {
							showMsgError('ข้อมูลผิดพลาด');
							HideWaiting() ;
						}
					});  
		} catch (ex) {
			 showMsgError(ex);
			HideWaiting() ;
		}
		
 } 

function ShowWaiting() {
	waitingDialog.show('Custom message');
	  
}
function HideWaiting() {
	waitingDialog.hide();
}
