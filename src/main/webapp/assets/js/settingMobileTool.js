var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var backtosettool = "/Lab/settingMobileTool";
var arrIndex=[];
$(document).ready(function () {

getToolDetail();

$('#btn_addtool').click(function(){
	getDropdownStatus();
	$('#modalAddTool').modal({
    backdrop: 'static',
    keyboard: false
});
$('#edit_div').hide();

});
$('#toolsName').keypress(function(){
	$('#toolsName').css('border-color', '#e5e6e7');
});
$('#cancel_tool').click(function(){
	emptyModal();
});

	$("#submit_tool").on('click', function (event) {  
			if($('#toolsName').val()==''||$('#toolsName').val()==null){
				$('#toolsName').css('border-color', 'red');
				return null;
			}
           event.preventDefault();
		   let subpath='ADD';
		   var fd = new FormData($('#add_Tool')[0]);
		   let code_temp ='';
		   if($('#code_temp_tool').val()!=''&&$('#code_temp_tool').val()!=null){
		   let code_temp=$('#code_temp_tool').val();
 		   fd.set('toolsCode',code_temp);
		   subpath='EDIT';
		   }else{
			 fd.set('toolsCode',$('#indexTool').val());
		   }
		   $.ajax({
		      url: 'util-updateMobileTool/'+subpath,
		      type: 'post',
		      data: fd,
		      contentType: false,
		      processData: false,
		      success: function(response){
		        $('#modalAddTool').modal('toggle');
				emptyModal();
				window.location=backtosettool;
		      }
		    });	
     });
});

function getDropdownStatus(data) {
    try {
		  $('#status').empty();
     	  $('#status').append('<option id=""  value="1">1</option>');
		  $('#status').append('<option id=""  value="2">2</option>');
		  if(data!=''&&data!=null){
				$('#status').val(data);
		   }
    } catch (ex) {
        showMsgError(ex);

    }
}
function editModal(data){
	let arr_txt = data.split('|');
	getDropdownStatus(arr_txt[2]);
	$('#code_temp_tool').val(arr_txt[0]);
	$('#toolsName').val(arr_txt[1]);
	$('#edit_div').show();
	$('.ch_txt').text('แก้ไข เครื่องมือ');
//	
//	if(arr_txt.length==6&&arr_txt[5]!=null&&arr_txt[5]!=''&&arr_txt[5]!='null'){
//		path=arr_txt[5];
//		$("#setup_modal").height("48%");
//		$('#body_img').append('<img src="'+path+'" style="width: 25%;height: 20%;"/>')
//		$("#div_img").show();
//	}else{
//		$("#div_img").hide();
//		$("#setup_modal").css("height: 35%;");
//	}
	
	$('#modalAddTool').modal({
    backdrop: 'static',
    keyboard: false
});
}

function getToolDetail(){
	let datalist='';
	var indexToolstr='';
	arrIndex=[];
	try {
		$('#toolmobiletb').DataTable().destroy();
		$('#toolmobiledt').html("");
	    ShowWaiting();
	    jQuery.ajax({
	        url: 'util-getMobileTool',
	        type: "Get",
	        contentType: "application/json",
	        dataType: 'json',
	        async: false,
	        cache: false,
	        success: function(data) {
			console.log(data);
			datalist=data;
			var det = "";
			var index=0;
	        for (var i = 0; i < datalist.length; i++) {
			index=index+1;
			arrIndex.push(datalist[i].TOOLS_CODE);
			det += '<tr  class="TBODY">';
			det += '<td class="text-center">'+index+'</td>'
			det += '<td class="text-center"><input type="checkbox" id="check" name="check" value="'+datalist[i].TOOLS_CODE+'" /></td>'
			det += '<td class="text-center">'+datalist[i].TOOLS_NAME+'</td>'
			det += '<td class="text-center">'+datalist[i].STATUS+'</td>'
			det += '<td class="text-center"><button class="btn btn-warning" value="'+datalist[i].TOOLS_CODE+'|'+datalist[i].TOOLS_NAME+'|'+datalist[i].STATUS+'" onclick="editModal(this.value)">แก้ไข</button></td>'

			det +='</tr>';   
			}
	         $('#toolmobiledt').html(det);   
    		arrIndex.sort();
			indexToolstr=arrIndex[arrIndex.length-1];
			$('#indexTool').val(pad(Number(indexToolstr)+1,3));
			table = $('#toolmobiletb').DataTable({
		                    searching: true,
		                    responsive: true,
		                    "pageLength": 25,
		                    "paging":   true
		    });
			
	       HideWaiting();


	        },
	        error: function() {
	            showMsgError('ข้อมูลผิดพลาด');
	            HideWaiting();
	        }
	    });
	} catch (ex) {
	    showMsgError(ex);
	    HideWaiting();
	}
}


function pad(num, size) {
    var s = "000000000" + num;
    return s.substr(s.length-size);
}
function deletetool(){
	let data={};
	var toolsid =  "";
	 $("input[name='check']").each(function() {  
		
    	        if($(this).prop('checked')){
	            toolsid += ""+$(this).val()+",";   ;

    	        }
	 });
	 toolsid = toolsid.substring(0,toolsid.length-1);		
	ShowWaiting();
	console.log(toolsid);
	data['toolsCode']=toolsid;
    try {
	
        jQuery.ajax({
            url: 'util-deleteMobileTool',
            type: "Post",
            contentType: "application/json",
			data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
				console.log(data);
				
				
				 HideWaiting() ;
				 window.location=backtosettool;
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
function emptyModal(){
	getDropdownStatus(1)
	$('#toolsName').val('');
	$('#code_temp_tool').val('');
	
}