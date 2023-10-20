$(document).ready(function(){
	
	//First view
	Getdata('all','default',null);
	
	$('.addSettingRandom').click(function(){
		addSettingRandom();
	});
	
	$('.cancelModal').click(function(){
		cancelModal();
	});
	
	$('.seatchTypeComp').click(function(){
		//var TypeComp = $('[name=nameCode]').val();
		var TypeComp = $('#comp').val();
		
		seatchTypeComp(TypeComp);
	});
	
	$('.savesettingrandom').click(function(){
		Savesettingrandom();
	});
	
});

function Savesettingrandom(){
	var nameCode 			= $('[name=nameCode]').val();
	var nameComp 			= $('[name=nameComp]').val();
	var nameCtr 				= $('[name=nameCtr]').val();
	var seq 				= $('[name=seq]').val();

	if(nameCode==undefined 			|| nameCode==""
		|| nameComp==undefined 		|| nameComp==""
		|| nameCtr==undefined 		|| nameCtr==""
		|| seq==undefined 			|| seq==""){
		$('.addSettingRandomModel').modal('hide');
		Swal.fire({
			  title: 'กรุณากรอกข้อมูลให้ครบถ้วน',
			  text: "",
			  type: 'warning',
			}).then((result) => {
			  if (result.value) {
				  $('.addSettingRandomModel').modal('show');
			  }
		})
	alert('nameCode'+nameCode+'nameComp'+nameComp+'nameCtr'+nameCtr+'seq '+seq) 	
	}else{
		hideaddSettingRandom();
		progressload();
		try {
			 
			  var data = {}
			  data["codcomp"]=nameCode;
			  data["compname"]=nameComp;
			  data["cretiria_name"]=nameCtr;
			  data["seq"]=seq;
			  data["codeEmid"]=window.codeEmid;
			  jQuery.ajax({
				url : 'insertSettingRandomSorting',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {
					progressClose();
					if(data.success==1){
						
						hideaddSettingRandom();
						Swalsuccess();
						
					}else{
						hideaddSettingRandom()
						progressClose()
						showMsgError('เกิดข้อผิดพลาด');
					}
				},
				error : function() {
					hideaddSettingRandom()
					progressClose()
					showMsgError('เกิดข้อผิดพลาด');
				}
			});
				   
		} catch (ex) {
			hideaddSettingRandom()
			progressClose()
			showMsgError(ex);
		}
	}
	
}

function addSettingRandom(){
	$('.addSettingRandomModel').modal('show');
}

function hideaddSettingRandom(){
	$('.addSettingRandomModel').modal('hide');
}

function updateSettingRandom(){
	$('.updateSettingRandomModel').modal('show');
}

function hideupdateSettingRandom(){
	$('.updateSettingRandomModel').modal('hide');
}

function Swalsuccess(){
	Swal.fire({
	  type: 'success',
	  title: 'Save success',
	  text: '',
	  confirmButtonText: 'ตกลง'
	}).then((result) => {
		if (result.value) {
			$('[name=nameCode]').val("");
			$('[name=nameComp]').val("");
			$('[name=nameCtr]').val("");
			$('[name=seq]').val("");
			Getdata('all','default',null);
		}
	})
}


function delSuccess(){
	Swal.fire({
	  type: 'success',
	  title: 'Delete success',
	  text: '',
	  confirmButtonText: 'ตกลง'
	}).then((result) => {
		if (result.value) {
			Getdata('all','default',null);
		}
	})
}

function updateSuccess(){
	Swal.fire({
	  type: 'success',
	  title: 'Update success',
	  text: '',
	  confirmButtonText: 'ตกลง'
	}).then((result) => {
		if (result.value) {
			Getdata('all','default',null);
		}
	})
}

function cancelModal(){
	//Clear data input from modal
}


function seatchTypeComp(TypeComp){
	Getdata(TypeComp,'event',null);
}

function progressload(){
	var URL = 'http://127.0.0.1:8080/Lab/assets/images/gif/logo.gif';
	Swal.fire({
		  imageUrl: URL,
		  imageHeight: 50,
		  text:'โปรดรอสักครู่.......',
		  allowOutsideClick:false,
		  showCancelButton: false,
		  showConfirmButton: false,
		  timer: 60000},function(){
			  swal.close();
	})
}

function progressClose(){
	swal.close();
}

function tagselectComp(data){
	var htmlvar = $('[name=nameCode]').html();
	htmlvar = htmlvar+'<option value="all">ทั้งหมด</option>';
	$.each( data, function( key, value ) {
		htmlvar = htmlvar+'<option value="'+value["COMPNAME"]+'">'+value["COMPNAME"]+'</option>';
	});
	$('[name=nameCode]').html(htmlvar);
}

function dataTable(data){
	
	$('#dteId').html("");
    $('#myTablePlaning').DataTable().destroy();
    
    
    var det = "";
    var stringcode;
		
	 for (var i = 0; i < data.length; i++) {
		 
		 stringcode = "'"+(data[i].CRETIRIA_CODE==null?"":data[i].CRETIRIA_CODE)+"'";
	 	  
		det +='<tr >';
		det +='<td class="text-center" >'+ (i+1)+'</td>'; 
		det +='<td class="text-center" >'+(data[i].CODCOMP==null?"":data[i].CODCOMP)+'</td>';
		det +='<td class="text-center" >'+(data[i].COMPNAME==null?"":data[i].COMPNAME)+'</td>';
		det +='<td class="text-center" >'+(data[i].CRETIRIA_NAME==null?"":data[i].CRETIRIA_NAME)+'</td>';
		det +='<td class="text-center" >'+(data[i].SEQ==null?"":data[i].SEQ)+'</td>';	
		det +='<td class="text-center" ><div onclick="updatedata('+stringcode+')" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;แก้ไข</div></td>';
		det +='<td class="text-center" ><div onclick="deldata   ('+stringcode+')" ><class="btn btn-primary<i class="fa fa-trash"           aria-hidden="true"></i><br>&nbsp;ลบ</div></td>';
		det +='</tr>';
	}
//	 alert('CODCOMP'+CODCOMP+'COMPNAME'+COMPNAME+'CRETIRIA_NAME'+CRETIRIA_NAME+'SEQ '+SEQ);
	if(det==''){
		det += '<tr> ';
		det += '<th colspan="6" class="text-center">--- ไม่พบข้อมูล ---</th> ';
		det += '</tr> ';
		$('#dteId').html(det);
		  
	}else{
	//	alert('#dteId_'+nameStore);
		$('#dteId').html(det);
		table =  $('#myTablePlaning').DataTable( {
			searching: true,
			responsive : true
		});
		
	} 
	
}

function Getdata(Type='all',Option='event',Filter=null){
	//Option = event is click etc... | default is first page

	
	if(Option!=undefined || Option!=""){
		progressload();
		try {
			 
			  var data = {}
			  data["compname"]=Type;
			  jQuery.ajax({
				url : 'inquirySettingRandomSorting',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {
					progressClose();
					if(data.success==1){
						if(Type=="all" && Option=="default"){
							tagselectComp(data.list);
						}
						dataTable(data.list);
						window.settingrandom = data.list;
					}else{
						progressClose()
						showMsgError('เกิดข้อผิดพลาด');
					}
				},
				error : function() {
					progressClose()
					showMsgError('เกิดข้อผิดพลาด');
				}
			});
				   
		} catch (ex) {
			progressClose()
			showMsgError(ex);
		}
	}
	
}

function deldata(code){
	Swal.fire({
	  title: 'คุณต้องการลบข้อมูลนี้หรือไม่ ?',
	  text: "",
	  type: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#d33',
	  cancelButtonColor: '#3085d6',
	  confirmButtonText: 'ตกลง',
	  cancelButtonText: 'ยกเลิก'
	}).then((result) => {
	  if (result.value) {
		  deleteprocess(code);
	  }
	})
}

function deleteprocess(code){
	if(code!=undefined || code!=""){
		progressload();
		try {
			 
			  var data = {}
			  data["cretiria_code"]=code;
			  jQuery.ajax({
				url : 'deleteSettingRandomSorting',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {
					progressClose();
					if(data.success==1){
						delSuccess();
					}else{
						progressClose()
						showMsgError('เกิดข้อผิดพลาด');
					}
				},
				error : function() {
					progressClose()
					showMsgError('เกิดข้อผิดพลาด');
				}
			});
				   
		} catch (ex) {
			progressClose()
			showMsgError(ex);
		}
	}
}

function updatedata(code){
	//Replace data to input box
	updatedataReplacedata(code);
}

function updatedataReplacedata(code){
	if(window.settingrandom!=undefined && window.settingrandom!="" && code!=undefined && code!=""){
		
		for (var i = 0; i < window.settingrandom.length; i++) {
			if(window.settingrandom[i]['CRETIRIA_CODE']==code){
				
				$('[name=updatenameCode]').html(window.settingrandom[i]['CODCOMP']);
				ReplacedataToinput('[name=updatecompname]',window.settingrandom[i]['COMPNAME']);
				ReplacedataToinput('[name=updatecrtname]',window.settingrandom[i]['CRETIRIA_NAME']);
				ReplacedataToinput('[name=updateseq]',window.settingrandom[i]['SEQ']);

				//Add to bottom
				$(".updatescore").attr("onclick","updateprocess('"+window.settingrandom[i]['CRETIRIA_CODE']+"')");
				
				//Open entity updateSettingRandom
				updateSettingRandom();
				break;
			}
		}
	}else{
		showMsgError('เกิดข้อผิดพลาด');
	}
}

function ReplacedataToinput(selector,value){
	if(selector!=undefined && selector!="" && value!=undefined && value!=""){
		$(selector).val(value);
	}
}

function updateprocess(code){
	if(Option!=undefined || Option!=""){
		
		//Get values
		var updateCompname = $('[name=updatecompname]').val();
		var updateCrtname = $('[name=updatecrtname]').val();
		var updateSeq = $('[name=updateseq]').val();

		
			if(updateCompname==undefined             || updateCompname==""
			|| updateCrtname==undefined            || updateCrtname==""
			|| updateSeq==undefined            || updateSeq==""){
			hideupdateSettingRandom();
			Swal.fire({
				  title: 'กรุณากรอกข้อมูลให้ครบถ้วน',
				  text: "",
				  type: 'warning',
				}).then((result) => {
				  if (result.value) {
						ReplacedataToinput('[name=updatecompname]',updateCompname);
						ReplacedataToinput('[name=updatecrtname]',updateCrtname);
						ReplacedataToinput('[name=updateseq]',updateSeq);
						updateSettingRandom();
				  }
			})
			
		}else{
			hideupdateSettingRandom();
			progressload();
			try {
				  var data = {}
				  
				  data["cretiria_code"]=code;
				  data["compname"]=updateCompname;
				  data["cretiria_name"]=updateCrtname;
				  data["seq"]=updateSeq;
				  data["codeEmid"]=window.codeEmid;
				  jQuery.ajax({
					url : 'updateSettingRandomSorting',
					type : "Post", 
					contentType : "application/json",
					data : JSON.stringify(data), 
					dataType : 'json',
					  async: false,
					   cache: false,
					success : function(data) {
						progressClose();
						if(data.success==1){
							
							hideaddSettingRandom();
							updateSuccess();
							
						}else{
							hideaddSettingRandom()
							progressClose()
							showMsgError('เกิดข้อผิดพลาด');
						}
					},
					error : function() {
						hideaddSettingRandom()
						progressClose()
						showMsgError('เกิดข้อผิดพลาด');
					}
				});
					   
			} catch (ex) {
				hideaddSettingRandom()
				progressClose()
				showMsgError(ex);
			}
		}
	}else{
		progressClose()
		showMsgError('เกิดข้อผิดพลาด');
	}
}