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
	var cntSP 				= $('[name=cntSP]').val();
	var perRD 				= $('[name=perRD]').val();
	var kiloAMT				= $('[name=kiloAMT]').val();
	var hotelAMT 			= $('[name=hotelAMT]').val();

	if(nameCode==undefined 			|| nameCode==""
		|| nameComp==undefined 		|| nameComp==""
		|| cntSP==undefined 		|| cntSP==""
		|| perRD==undefined 		|| perRD==""
		|| kiloAMT==undefined 		|| kiloAMT==""
		|| hotelAMT==undefined 		|| hotelAMT==""){
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
		
	}else{
		hideaddSettingRandom();
		progressload();
		try {
			 
			  var data = {}
			  data["codcomp"]=nameCode;
			  data["compname"]=nameComp;
			  data["sample_cnt"]=cntSP;
			  data["random_percent"]=perRD;
			  data["amt_perkilo"]=kiloAMT;
			  data["amt_pernighthotel"]=hotelAMT;
			  data["codeEmid"]=window.codeEmid;
			  jQuery.ajax({
				url : 'insertSettingRandom',
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
			$('[name=cntSP]').val("");
			$('[name=perRD]').val("");
			$('[name=kiloAMT]').val("");
			$('[name=hotelAMT]').val("");
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
		 
		 stringcode = "'"+(data[i].CODE==null?"":data[i].CODE)+"'";
	 	  
		det +='<tr >';
		det +='<td class="text-center" >'+ (i+1)+'</td>'; 
		det +='<td class="text-center" >'+(data[i].CODCOMP==null?"":data[i].CODCOMP)+'</td>';
		det +='<td class="text-center" >'+(data[i].COMPNAME==null?"":data[i].COMPNAME)+'</td>';
		det +='<td class="text-center" >'+(data[i].SAMPLE_CNT==null?"":data[i].SAMPLE_CNT)+'</td>';
		det +='<td class="text-center" >'+(data[i].RANDOM_PERCENT==null?"":data[i].RANDOM_PERCENT)+'</td>';
		det +='<td class="text-center" >'+(data[i].AMT_PERKILO==null?"":data[i].AMT_PERKILO)+'</td>';
		det +='<td class="text-center" >'+(data[i].AMT_PERNIGHTHOTEL==null?"":data[i].AMT_PERNIGHTHOTEL)+'</td>';		
		det +='<td class="text-center" ><div onclick="updatedata('+stringcode+')" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;แก้ไข</div></td>';
		det +='<td class="text-center" ><div onclick="deldata   ('+stringcode+')" ><class="btn btn-primary<i class="fa fa-trash"           aria-hidden="true"></i><br>&nbsp;ลบ</div></td>';
		det +='</tr>';
	}
	 
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
				url : 'inquirySettingRandom',
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
			  data["code"]=code;
			  jQuery.ajax({
				url : 'deleteSettingRandom',
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
			if(window.settingrandom[i]['CODE']==code){
				
				$('[name=updatenameCode]').html(window.settingrandom[i]['CODCOMP']);
				ReplacedataToinput('[name=updatecompname]',window.settingrandom[i]['COMPNAME']);
				ReplacedataToinput('[name=updatecntSP]',window.settingrandom[i]['SAMPLE_CNT']);
				ReplacedataToinput('[name=updateperRD]',window.settingrandom[i]['RANDOM_PERCENT']);
				ReplacedataToinput('[name=updateamtperkilo]',window.settingrandom[i]['AMT_PERKILO']);
				ReplacedataToinput('[name=updateamtpernighthotel]',window.settingrandom[i]['AMT_PERNIGHTHOTEL']);
				//Add to bottom
				$(".updatescore").attr("onclick","updateprocess('"+window.settingrandom[i]['CODE']+"')");
				
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
		var updateCntSP = $('[name=updatecntSP]').val();
		var updatePerRD = $('[name=updateperRD]').val();
		var updateAmtperkilo = $('[name=updateamtperkilo]').val();
		var updateAmtpernighthotel = $('[name=updateamtpernighthotel]').val();
		
		if(updateCompname==undefined             || updateCompname==""
			|| updateCntSP==undefined            || updateCntSP==""
			|| updatePerRD==undefined            || updatePerRD==""
			|| updateAmtperkilo==undefined       || updateAmtperkilo==""
			|| updateAmtpernighthotel==undefined || updateAmtpernighthotel==""){
			hideupdateSettingRandom();
			Swal.fire({
				  title: 'กรุณากรอกข้อมูลให้ครบถ้วน',
				  text: "",
				  type: 'warning',
				}).then((result) => {
				  if (result.value) {
					  	ReplacedataToinput('[name=updatecompname]',updateCompname);
						ReplacedataToinput('[name=updatecntSP]',updateCntSP);
						ReplacedataToinput('[name=updateperRD]',updatePerRD);
						ReplacedataToinput('[name=updateamtperkilo]',updateAmtperkilo);
						ReplacedataToinput('[name=updateamtpernighthotel]',updateAmtpernighthotel);
						updateSettingRandom();
				  }
			})
			
		}else{
			hideupdateSettingRandom();
			progressload();
			try {
				  var data = {}
				  
				  data["code"]=code;
				  data["compname"]=updateCompname;
				  data["sample_cnt"]=updateCntSP;
				  data["random_percent"]=updatePerRD;
				  data["amt_perkilo"]=updateAmtperkilo;
				  data["amt_pernighthotel"]=updateAmtpernighthotel;
				  data["codeEmid"]=window.codeEmid;
				  jQuery.ajax({
					url : 'updateSettingRandom',
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