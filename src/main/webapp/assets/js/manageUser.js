var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var backmanageUser = "/Lab/manageUser";
var pathImgSignuture='';
$(document).ready(function () {
	

showorhideManageUser(false);
getUserDetail();

$('#check_user').click(function(){
	$('check_user').attr('disabled','disabled');
	getCheckUser();
});
$('#btn_adduser').click(function(){
	getDropdownStatus();
	getDropdownPlant();
	 getDropdownRole();
	$('#modalAddUser').modal({
    backdrop: 'static',
    keyboard: false
});
$('#edit_div').hide();
$('#add_div').show();

showorhideManageUser(true);

});

$('#role_dropdown').change(function(){

	if('0001'==$('#role_dropdown').val()||'0003'==$('#role_dropdown').val()){
		 $("#plat_dropdown").prop("disabled", false);
	}else{
		$("#plat_dropdown").prop("disabled", true);
	}
});
$('#cancel_user').click(function(){
	emptyModal();
});

	$("#submit_user").on('click', function (event) {  
           event.preventDefault();
		   let subpath='add';
		   var fd = new FormData($('#add_User')[0]);
		   let code_temp ='';
		   if($('#code_empid_txt').val()!=''&&$('#code_empid_txt').val()!=null){
		   let code_temp=$('#code_empid_txt').val();
 		   fd.set('code_empid',code_temp);
		   subpath='edit';
		   }
		  
		   $.ajax({
		      url: 'util-saveuser/'+subpath,
		      type: 'post',
		      data: fd,
		      contentType: false,
		      processData: false,
		      success: function(response){
		        $('#modalAddUser').modal('toggle');
				emptyModal();
				window.location=backmanageUser;
		      }
		    });
		   

			
     });

	$('#submit_user_detail').on('click', function (event) {  
		 event.preventDefault();
		   let subpath='edit';
		   var fd = new FormData($('#user_edit')[0]);
		   let code_usr = $('#code_empid_usr').val();
		   fd.set('code_empid',code_usr);
		   $.ajax({
		      url: 'util-saveuser/'+subpath,
		      type: 'post',
		      data: fd,
		      contentType: false,
		      processData: false,
		      success: function(response){
		       
				window.location=backmanageUser;
		      }
		    });
		   

	});

});
function editModal(data){
	let arr_txt = data.split('|');
	let path ='';
	

	showorhideManageUser(false);
	getDropdownStatus(arr_txt[2]);
	getDropdownPlant(arr_txt[4]);
	getDropdownRole(arr_txt[3]);
	$('#code_empid_txt').val(arr_txt[0]);
	$('#name_emp').val(arr_txt[1]);
	$('#add_div').hide();
	$('#edit_div').show();
	$('.ch_txt').text('แก้ไข User');
	
	if(arr_txt.length==6&&arr_txt[5]!=null&&arr_txt[5]!=''&&arr_txt[5]!='null'){
		path
		path=arr_txt[5];
		$('#body_img').html("");
		$('#body_img').append('<img src="'+path+'" style="width: 25%;height: 20%;"/>')
		$("#div_img").show();
	}else{
		$("#div_img").hide();
		
	}
	
	
	$('#modalAddUser').modal({
    backdrop: 'static',
    keyboard: false
});
}
function test(){
	
}
function getUserDetail(){
	let enabled='';
	let plantName='';
	let roleName='';
	let datalist='';
	try {
		$('#usertable').DataTable().destroy();
		$('#usertabledtail').html("");
	    ShowWaiting();
	    jQuery.ajax({
	        url: 'util-getuserdetail',
	        type: "Get",
	        contentType: "application/json",
	        dataType: 'json',
	        async: false,
	        cache: false,
	        success: function(data) {
			if(data.userdetail.ROLE_ID=='0007'||data.userdetail.ROLE_ID=='0010'||data.userdetail.ROLE_ID=='0005'||data.userdetail.ROLE_ID=='0004'){
			datalist=data.userlist;
			var det = "";
			var index=0;
	        for (var i = 0; i < datalist.length; i++) {
			index=index+1;
			plantName=datalist[i].USER_TYPE_DTL==null?'':datalist[i].USER_TYPE_DTL;
	        roleName=datalist[i].PLANT_NAME==null?'':datalist[i].PLANT_NAME;
			enabled=datalist[i].IS_ACTIVE=='Y'?'ใช้งาน':'ยกเลิกการใช้งาน'
			
			det += '<tr  class="TBODY">';
			det += '<td class="text-center">'+index+'</td>'
			det += '<td class="text-center"><input type="checkbox" id="check" name="check" value="'+datalist[i].CODEMP_ID+'" /></td>'
			det += '<td class="text-center">'+datalist[i].CODEMP_ID+'</td>'
			det += '<td class="text-center">'+datalist[i].NAMET+'</td>'
			det += '<td class="text-center">'+plantName+'</td>'
			det += '<td class="text-center">'+roleName+'</td>'
			det += '<td class="text-center">'+enabled+'</td>'
			det += '<td class="text-center"><button class="btn btn-warning" value="'+datalist[i].CODEMP_ID+'|'+datalist[i].NAMET+'|'+datalist[i].IS_ACTIVE+'|'+datalist[i].ROLE_ID+'|'+datalist[i].PLANT_ID+'|'+datalist[i].SIGNATURE_IMG+'" onclick="editModal(this.value)">แก้ไข</button></td>'

			det +='</tr>';   
			}
	         $('#usertabledtail').html(det);   
    	
			table = $('#usertable').DataTable({
		                    searching: true,
		                    responsive: true,
		                    "pageLength": 25,
		                    "paging":   true
		    });
			}else{
				
			$('#role_admin').hide();   	
				 
			$('#code_empid_usr').val(data.userdetail.CODEMP_ID);
			$('#name_emp_usr').val(data.userdetail.NAMET);
			getDropdownPlantUsr(data.userdetail.PLANT_ID);
			getDropdownRoleUsr(data.userdetail.ROLE_ID);
			getDropdownStatusUsr(data.userdetail.IS_ACTIVE)
			$('#role_user').show();  
			
			if(data.userdetail.SIGNATURE_IMG!='null'&&data.userdetail.SIGNATURE_IMG!=''&&data.userdetail.SIGNATURE_IMG!=null){
				$('#sig_usr').append('<img src="'+data.userdetail.SIGNATURE_IMG+'" style="width: 25%;height: 20%;"/>')
				$('#div_img_usr').show();
			} 
				
			}
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


function getDropdownRole(val) {
    try {
        jQuery.ajax({
            url: 'util-getRoleUser',
            type: "Get",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {

			$('#role_dropdown').empty();
			for(var i =0;i<data.length;i++){
     	    $('#role_dropdown').append('<option id=""  value="'+data[i].USER_TYPE_ID+'">'+data[i].USER_TYPE_DTL+'</option>');
			}
			
			if(val!=''&&val!=null){
				$('#role_dropdown').val(val);
				$('#role_dropdown').trigger('change');
			}

            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}


function getDropdownRoleUsr(val) {
    try {
        jQuery.ajax({
            url: 'util-getRoleUser',
            type: "Get",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {

			$('#role_dropdown_usr').empty();
			for(var i =0;i<data.length;i++){
     	    $('#role_dropdown_usr').append('<option id=""  value="'+data[i].USER_TYPE_ID+'">'+data[i].USER_TYPE_DTL+'</option>');
			}
			
			if(val!=''&&val!=null){
				$('#role_dropdown_usr').val(val);
				$('#role_dropdown_usr').trigger('change');
			}

            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}
function getDropdownPlant(val) {
	ShowWaiting();
    try {
        jQuery.ajax({
            url: 'util-getPlantUser',
            type: "Get",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {

			$('#plat_dropdown').empty();
			for(var i =0;i<data.length;i++){
     	    $('#plat_dropdown').append('<option id=""  value="'+data[i].PLANT_ID+'">'+data[i].PLANT_NAME+'</option>');
			}
			HideWaiting() ;
			if(val!=''&&val!=null){
				$('#plat_dropdown').val(val);
				$('#plat_dropdown').trigger('change');
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
function getDropdownPlantUsr(val) {
	ShowWaiting();
    try {
        jQuery.ajax({
            url: 'util-getPlantUser',
            type: "Get",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {

			$('#plat_dropdown_usr').empty();
			for(var i =0;i<data.length;i++){
     	    $('#plat_dropdown_usr').append('<option id=""  value="'+data[i].PLANT_ID+'">'+data[i].PLANT_NAME+'</option>');
			}
			HideWaiting() ;
			if(val!=''&&val!=null){
				$('#plat_dropdown_usr').val(val);
				$('#plat_dropdown_usr').trigger('change');
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
function getDropdownStatus(data) {
    try {
		  $('#status_dropdown').empty();
     	  $('#status_dropdown').append('<option id=""  value="Y">ใช้งาน</option>');
		  $('#status_dropdown').append('<option id=""  value="N">ยกเลิกการใช้งาน</option>');
		  if(data!=''&&data!=null){
				$('#status_dropdown').val(data);
				$('#status_dropdown').trigger('change');
		   }
    } catch (ex) {
        showMsgError(ex);

    }
}

function getDropdownStatusUsr(data) {
    try {
		  $('#status_dropdown_usr').empty();
     	  $('#status_dropdown_usr').append('<option id=""  value="Y">ใช้งาน</option>');
		  $('#status_dropdown_usr').append('<option id=""  value="N">ยกเลิกการใช้งาน</option>');
		  if(data!=''&&data!=null){
				$('#status_dropdown_usr').val(data);
				$('#status_dropdown_usr').trigger('change');
		   }
    } catch (ex) {
        showMsgError(ex);

    }
}


function getCheckUser() {
	$('#text_error').hide();
	let data={};
	ShowWaiting();
	data['codempid']=$('#code_empid').val();
    try {
        jQuery.ajax({
            url: 'util-checkProfile',
            type: "Post",
            contentType: "application/json",
			data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
				console.log(data);
				if(data.resultCode=='00'){
					$('#name_emp').val(data.data.namempt).change();
					showorhideManageUser(false);
					
				}else{
					showorhideManageUser(true);
					$('#text_error').text(data.messageError);
					$('#text_error').show();
					
				}
				
				 HideWaiting() ;
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

function showorhideManageUser(value){
					$( '#name_emp').prop( "disabled", value );
					$( "#role_dropdown" ).prop( "disabled", value );
					$( "#plat_dropdown" ).prop( "disabled", value );
					$( "#status_dropdown" ).prop( "disabled", value );
					$( "#submit_user" ).prop( "disabled", value );
					if(value==true){
						$('#name_emp').val('');
					}
					$( "#upload_signature" ).prop( "disabled", value );
}

function deleteuser(){
	let data={};
	var itemmp_id =  "";
	 $("input[name='check']").each(function() {  
		
    	        if($(this).prop('checked')){
	            itemmp_id += ""+$(this).val()+",";   ;

    	        }
	 });
	 itemmp_id = itemmp_id.substring(0,itemmp_id.length-1);		
	ShowWaiting();
	console.log(itemmp_id);
	data['usrDataAss']=itemmp_id;
    try {
        jQuery.ajax({
            url: 'util-deleteUser',
            type: "Post",
            contentType: "application/json",
			data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
				console.log(data);
				
				
				 HideWaiting() ;
				 window.location=backmanageUser;
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
	$('#code_empid').val('');
	$('#name_emp').val('');
	$('#role_dropdown').val('0001').trigger('change');
	$('#plat_dropdown').val('1101').trigger('change');
	$('#status_dropdown').val('Y').trigger('change');
	$('#upload_signature').val('');
	$('#code_empid_txt').val('');
	
}