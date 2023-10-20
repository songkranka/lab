var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var backtohome = "/Lab/home";


$(document).ready(function () {
	initTable();
	getTaskList();
});


function initTable(){
		table =  $('#waitworksubrole').DataTable( {
			"pageLength": 25,
			"columnDefs": [
			    { "orderable": false, "targets": 1 }
			  ]
		});
}

	

function getTaskList(){
	var data = {};
	data["typeWork"] = 'newWork';
	try{
		$('#waitworksubrole').DataTable().destroy();
		$('#waitworksubroledt').html("");
		console.log(JSON.stringify(data));
        ShowWaiting();
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'getAssignWorkForPrint',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(data) {
					console.log(data);
            		if(data.list.length=='0'){
            			//console.log(data.list.length);
            			//$('#assignHDnew').css('display', 'none');
            			//$('#assignHDsuccess').css('display', 'none');
            		}else{
            			var det = "";
     	                
     	                for (var i = 0; i < data.list.length; i++) {
							if(data.list[i].FLG_PRINT_ASS!='Y'){
							det += '<tr  class="TBODY">';
     			            //det += '<td class="text-center" >' + (data.list[i].LTR_CODE == null ? "" : data.list[i].LTR_CODE) + '</td>';
							det += '<td class="text-center" ><input type="checkbox" name="print" value="'+data.list[i].LTR_CODE+'" /></td>';
     	                	det += '<td class="text-center" >'+data.list[i].LTR_CODE +'</td>';
     	                	det += '<td class="text-center" >' + (data.list[i].LAB_CODE == null ? "" : data.list[i].LAB_CODE) + '</td>';
     	                	det += '<td class="text-center" >' + (data.list[i].PRODUCT_NAME == null ? "" : data.list[i].PRODUCT_NAME) + '</td>';
     			            det += '<td class="text-center" >' + (data.list[i].SAMPLE_TYPE_NAME == null ? "" : data.list[i].SAMPLE_TYPE_NAME) + '</td>';
     			            det += '<td class="text-center" >' + (data.list[i].SAMPLE_TYPEC_DESC == null ? "" : data.list[i].SAMPLE_TYPEC_DESC) + '</td>';
     			            det += '<td class="text-center" >' + ((data.list[i].SAMPLE_DATE != null&&data.list[i].SAMPLE_DATE!='' )? data.list[i].SAMPLE_DATE : data.list[i].CREATE_DATE) + '</td>';
     			            det +='</tr>';
							}
     	                	
     	                		                
     	                }
     	                if (det == '') {
     	                    $('#waitworksubroledt').html(det);
     	                    HideWaiting();
     	                } else {
     	                    $('#waitworksubroledt').html(det);
     	                    HideWaiting();

     	                }
     	                table = $('#waitworksubrole').DataTable({
     	                    searching: true,
     	                    responsive: false,
     	                   "pageLength": 25
     	                });
            		}           		
                    HideWaiting();
                //assiWorkHD
                    
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
function gotoMain(){
	window.location=backtohome;
}
function exportWaitReport(){
		var ltrid='';
		$("input[name='print']").each(function() {  
		
    	        if($(this).prop('checked')){
	            ltrid += ""+$(this).val()+",";   ;

    	        }
		
		});
		console.log(ltrid);
		if(ltrid.length>0){
		ltrid=ltrid.substring(0,ltrid.length-1);
		var link = '/Lab/waitworksubrole?ltrid='+ltrid;
	  	window.open(link, '_blank');

		}else{
			 showMsgError('กรุณาเลือกรายการออกรายงาน');
		}
		setTimeout(function(){ 	getTaskList();}, 3000);
	
		
	//
	
}

function selectAllNew(){
	 	//var table = $('#assiDetialTWork').DataTable();
		
		    	  $('#example-select-all').on('click', function(){
		    	      // Check/uncheck all checkboxes in the table
		    	      var rows = table.rows({ 'search': 'applied' }).nodes();
		    	      $('input[name="print"]', rows).prop('checked', this.checked);
		    	   });

		    	   // Handle click on checkbox to set state of "Select all" control
		    	   $('#example tbody').on('change', 'input[name="print"]', function(){
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
	

