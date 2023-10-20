var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var backtosetvisual = "/Lab/manageDataVisual";
var backtohome = "/Lab/manageDataMaster";
var arrIndex=[];
$(document).ready(function () {

getVisualDetail();

$('#btn_addvisual').click(function(){
	$('#flag').val('A');
	$('.ch_txt').text('เพิ่ม Visual');
	$('#visualCode').val($('#indexVisualTxt').val());
	
	$('#modalAddVisual').modal({
    backdrop: 'static',
    keyboard: false
});
$('#edit_div').hide();

});
$('#visualName').keypress(function(){
	$('#visualName').css('border-color', '#e5e6e7');
});
$('#cancel_visual').click(function(){
	emptyModal();
});

	$("#submit_visual").on('click', function (event) {  
			if($('#visualName').val()==''||$('#visualName').val()==null){
				$('#visualName').css('border-color', 'red');
				return null;
			}
           event.preventDefault();
		   let subpath='';
			
		   var fd = new FormData($('#add_Tool')[0]);
		   if('A'==$('#flag').val()){
			subpath='ADD';
			}else {
			subpath='EDIT';
			}
 		   fd.set('id',$('#visualCode').val());
		   $.ajax({
		      url: 'util-updateVisual/'+subpath,
		      type: 'post',
		      data: fd,
		      contentType: false,
		      processData: false,
		      success: function(response){
		        $('#modalAddVisual').modal('toggle');
				emptyModal();
				getVisualDetail();
		      }
		    });	
     });
});

function editModal(data){
	$('#flag').val('E');
	let arr_txt = data.split('|');
	$('#visualCode').val(arr_txt[0]);
	$('#visualName').val(arr_txt[1]);
	$('#edit_div').show();
	$('.ch_txt').text('แก้ไข Visual');
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
	
	$('#modalAddVisual').modal({
    backdrop: 'static',
    keyboard: false
});
}

function getVisualDetail(){
	let datalist='';
	var indexvisualstr='';
	arrIndex=[];
	try {
		$('#visualtb').DataTable().destroy();
		$('#visualdt').html("");
	    ShowWaiting();
	    jQuery.ajax({
	        url: 'util-getVisualt',
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
			
			if(datalist[i].CODE!='9999'){
				index=index+1;
				arrIndex.push(datalist[i].CODE);
			
			
			det += '<tr  class="TBODY">';
			det += '<td class="text-center">'+index+'</td>'
			det += '<td class="text-center"><input type="checkbox" id="check" name="check" value="'+datalist[i].CODE+'" /></td>'
			det += '<td class="text-center">'+datalist[i].NAME+'</td>'
			det += '<td class="text-center">'+datalist[i].CODE+'</td>'
			det += '<td class="text-center"><button class="btn btn-warning" value="'+datalist[i].CODE+'|'+datalist[i].NAME+'" onclick="editModal(this.value)">แก้ไข</button></td>'

			det +='</tr>';   }
			}
	         $('#visualdt').html(det);   
    		arrIndex.sort();
			indexvisualstr=arrIndex[arrIndex.length-1];
			$('#indexVisualTxt').val(pad(Number(indexvisualstr)+1,4));
			table = $('#visualtb').DataTable({
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
function deletevisual(){
	let data={};
	var visualid =  "";
	 $("input[name='check']").each(function() {  
		
    	        if($(this).prop('checked')){
	            visualid += ""+$(this).val()+",";   ;

    	        }
	 });
	 visualid = visualid.substring(0,visualid.length-1);		
	ShowWaiting();
	data['id']=visualid;
 
        jQuery.ajax({
            url: 'util-deleteVisual',
            type: "Post",
            contentType: "application/json",
			data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
				 HideWaiting() ;
				getVisualDetail();
            },
            error: function(e) {
                showMsgError('เกิดข้อผิดพลาด');
 				HideWaiting() ;
			console.log(e);
            }
        });


}
function emptyModal(){
	$('#visualName').val('');
	$('#visualCode').val('');
	
}
function gotoMain(){
	window.location=backtohome;
}