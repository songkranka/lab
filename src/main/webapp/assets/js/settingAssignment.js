$(document).ready(function(){
	
	//First view
	Getdata();
	$('.submitSettingAssignment').click(function(){	
		//var TypeAssign = $('#dataN').val();
		updateprocess();
	});

});
function Getdata(){
		try {
			  var data = {}
			  jQuery.ajax({
				url : 'getDropdownSettingAssign',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {
					if(data.success==1){
						window.assign = data.list;
						$('#dataN').val(data.list[0]['ASM_STATUS']);
					}else{
						showMsgError('เกิดข้อผิดพลาด');
					}
				},
				error : function() {
					showMsgError('เกิดข้อผิดพลาด');
				}
			});
				   
		} catch (ex) {
			showMsgError(ex);
		}
	
}
function updateprocess(){
	var updateID = window.assign[0]['ASM_ID'];
	var updateStatus = $('#dataN').val();
	try {
		var data = {}
		data["asm_id"]=updateID;
		data["asm_status"]=updateStatus;
		jQuery.ajax({
		url : 'updateSettingAssign',
		type : "Post", 
		contentType : "application/json",
		data : JSON.stringify(data), 
		dataType : 'json',
		async: false,
		cache: false,
		success : function(data) {		
		if(data.success==1){
			updateSuccess();	
		}else{
			showMsgError('เกิดข้อผิดพลาด');
			}
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด');
			}
		});
					   
		} catch (ex) {

				showMsgError(ex);
		}
}

function updateSuccess(){
	Swal.fire({
	  type: 'success',
	  title: 'Save success',
	  text: '',
	  confirmButtonText: 'ตกลง'
	}).then((result) => {
		if (result.value) {
			//Getdata();
		}
	})
}

