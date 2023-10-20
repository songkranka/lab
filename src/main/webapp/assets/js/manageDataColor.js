var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var backtosetcolor = "/Lab/manageDataColor";
var backtohome = "/Lab/manageDataMaster";
var arrIndex=[];
$(document).ready(function () {

getColorDetail();

$('#btn_addcolor').click(function(){
	$('#flag').val('A');
	$('.ch_txt').text('เพิ่ม Color');
	$('#colorCode').val($('#indexColorTxt').val());
	
	$('#modalAddColor').modal({
    backdrop: 'static',
    keyboard: false
});
$('#edit_div').hide();

});
$('#colorName').keypress(function(){
	$('#colorName').css('border-color', '#e5e6e7');
});
$('#cancel_color').click(function(){
	emptyModal();
});

	$("#submit_color").on('click', function (event) {  
			if($('#colorName').val()==''||$('#colorName').val()==null){
				$('#colorName').css('border-color', 'red');
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
 		   fd.set('id',$('#colorCode').val());
		   $.ajax({
		      url: 'util-updateColor/'+subpath,
		      type: 'post',
		      data: fd,
		      contentType: false,
		      processData: false,
		      success: function(response){
		        $('#modalAddColor').modal('toggle');
				emptyModal();
				getColorDetail();
		      }
		    });	
     });
});

function editModal(data){
	$('#flag').val('E');
	let arr_txt = data.split('|');
	$('#colorCode').val(arr_txt[0]);
	$('#colorName').val(arr_txt[1]);
	$('#edit_div').show();
	$('.ch_txt').text('แก้ไข Color');

	
	$('#modalAddColor').modal({
    backdrop: 'static',
    keyboard: false
});
}

function getColorDetail(){
	let datalist='';
	var indexcolorstr='';
	arrIndex=[];
	try {
		$('#colortb').DataTable().destroy();
		$('#colordt').html("");
	    ShowWaiting();
	    jQuery.ajax({
	        url: 'util-getColor',
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
			
			
			if(datalist[i].ID!='99'&&datalist[i].ID!='05'&&datalist[i].ID!='06'){
				index=index+1;
				arrIndex.push(datalist[i].ID);
			det += '<tr  class="TBODY">';
			det += '<td class="text-center">'+index+'</td>'
			det += '<td class="text-center"><input type="checkbox" id="check" name="check" value="'+datalist[i].ID+'" /></td>'
			det += '<td class="text-center">'+datalist[i].COLOR_NAME+'</td>'
			det += '<td class="text-center">'+datalist[i].ID+'</td>'
			det += '<td class="text-center"><button class="btn btn-warning" value="'+datalist[i].ID+'|'+datalist[i].COLOR_NAME+'" onclick="editModal(this.value)">แก้ไข</button></td>'

			det +='</tr>';   }
			}
	         $('#colordt').html(det);   
    		arrIndex.sort();
			indexcolorstr=arrIndex[arrIndex.length-1];
			$('#indexColorTxt').val(pad(Number(indexcolorstr)+1,2));
			table = $('#colortb').DataTable({
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
function deletecolor(){
	let data={};
	var colorid =  "";
	 $("input[name='check']").each(function() {  
		
    	        if($(this).prop('checked')){
	            colorid += ""+$(this).val()+",";   ;

    	        }
	 });
	 colorid = colorid.substring(0,colorid.length-1);		
	ShowWaiting();
	data['id']=colorid;
 
        jQuery.ajax({
            url: 'util-deleteColor',
            type: "Post",
            contentType: "application/json",
			data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
				 HideWaiting() ;
				getColorDetail();
            },
            error: function(e) {
                showMsgError('เกิดข้อผิดพลาด');
 				HideWaiting() ;
			console.log(e);
            }
        });


}
function emptyModal(){
	$('#colorName').val('');
	$('#colorCode').val('');
	
}
function gotoMain(){
	window.location=backtohome;
}