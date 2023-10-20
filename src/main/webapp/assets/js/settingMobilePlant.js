var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var backmanageUser = "/Lab/manageUser";
var backmanagePlant = "/Lab/settingMobilePlant";
var pathImgSignuture='';
var arrIndex=[];
$(document).ready(function () {

getPlantDetail();

$('#btn_addplant').click(function(){
	
	$('#plantReceiveNameTH').keypress(function(){
	$('#plantReceiveNameTH').css('border-color', '#e5e6e7');
	});
	
	$('#plantReceiveNameEN').keypress(function(){
	$('#plantReceiveNameEN').css('border-color', '#e5e6e7');
	});
	
	$('#modalAddPlant').modal({
    backdrop: 'static',
    keyboard: false
});
$('#edit_div').hide();

});
$('#cancel_plant').click(function(){
	emptyModal();
});

	$("#submit_plant").on('click', function (event) {  
          	if($('#plantReceiveNameTH').val()==''||$('#plantReceiveNameTH').val()==null){
				$('#plantReceiveNameTH').css('border-color', 'red');
				return null;
			}
			if($('#plantReceiveNameEN').val()==''||$('#plantReceiveNameEN').val()==null){
				$('#plantReceiveNameEN').css('border-color', 'red');
				return null;
			}
           event.preventDefault();
		   let subpath='ADD';
		   var fd = new FormData($('#add_Plant')[0]);
		   let code_temp ='';
		   if($('#code_temp_plant').val()!=''&&$('#code_temp_plant').val()!=null){
		   let code_temp=$('#code_temp_plant').val();
 		   fd.set('plantReceiveCode',code_temp);
		   subpath='EDIT';
		   }else{
			 fd.set('plantReceiveCode',$('#indexPlant').val());
		   }
		   $.ajax({
		      url: 'util-updateMobilePlant/'+subpath,
		      type: 'post',
		      data: fd,
		      contentType: false,
		      processData: false,
		      success: function(response){
		        $('#modalAddPlant').modal('toggle');
				emptyModal();
				window.location=backmanagePlant;
		      }
		    });	
		   

			
     });


});
function editModal(data){
	let arr_txt = data.split('|');
	$('#code_temp_plant').val(arr_txt[0]);
	$('#plantReceiveNameTH').val(arr_txt[1]);
	$('#plantReceiveNameEN').val(arr_txt[2]);
	$('#edit_div').show();
	$('.ch_txt').text('แก้ไข คลัง');
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
	
	$('#modalAddPlant').modal({
    backdrop: 'static',
    keyboard: false
});
}

function getPlantDetail(){
	let datalist='';
	var indexPlantstr='';
	arrIndex=[];
	try {
		$('#plantmobiletb').DataTable().destroy();
		$('#plantmobiledt').html("");
	    ShowWaiting();
	    jQuery.ajax({
	        url: 'util-getMobilePlant',
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
			arrIndex.push(Number(datalist[i].PLANT_RECEIVE_CODE));
			det += '<tr  class="TBODY">';
			det += '<td class="text-center">'+index+'</td>'
			det += '<td class="text-center"><input type="checkbox" id="check" name="check" value="'+datalist[i].PLANT_RECEIVE_CODE+'" /></td>'
			det += '<td class="text-center">'+datalist[i].PLANT_RECEIVE_NAMETH+'</td>'
			det += '<td class="text-center">'+datalist[i].PLANT_RECEIVE_NAMEEN+'</td>'
			det += '<td class="text-center"><button class="btn btn-warning" value="'+datalist[i].PLANT_RECEIVE_CODE+'|'+datalist[i].PLANT_RECEIVE_NAMETH+'|'+datalist[i].PLANT_RECEIVE_NAMEEN+'" onclick="editModal(this.value)">แก้ไข</button></td>'

			det +='</tr>';   
			}
	         $('#plantmobiledt').html(det);   
    		arrIndex.sort(function(a, b) {
  			return a - b;
			});
			indexPlantstr=arrIndex[arrIndex.length-1];
			$('#indexPlant').val(Number(indexPlantstr)+1);
			table = $('#plantmobiletb').DataTable({
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



function deleteplant(){
	let data={};
	var item_id =  "";
	 $("input[name='check']").each(function() {  
		
    	        if($(this).prop('checked')){
	            item_id += ""+$(this).val()+",";   ;

    	        }
	 });
	 item_id = item_id.substring(0,item_id.length-1);		
	ShowWaiting();
	console.log(item_id);
	data['plantReceiveCode']=item_id;
    try {
        jQuery.ajax({
            url: 'util-deleteMobilePlant',
            type: "Post",
            contentType: "application/json",
			data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
				console.log(data);
				
				
				 HideWaiting() ;
				 window.location=backmanagePlant;
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
	$('#name_plant').val('');
	$('#code_temp_plant').val('');
	
}