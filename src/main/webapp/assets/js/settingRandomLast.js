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
	
	var minSimple 				= $('[name=minSimple]').val();
	var maxSimple 				= $('[name=maxSimple]').val();
	var cntGreen 				= $('[name=cntGreen]').val();
	var cntYellow 				= $('[name=cntYellow]').val();
	var cntRed					= $('[name=cntRed]').val();
	var passYellow 				= $('[name=passYellow]').val();
	var passRed 				= $('[name=passRed]').val();
//	alert('minSimple'+minSimple+'maxSimple'+maxSimple+'cntGreen'+cntGreen+'cntYellow '+cntYellow+'cntRed'+cntRed+'passYellow'+passYellow+'passRed'+passRed);
	
	if(minSimple==undefined 		|| minSimple==""
		|| maxSimple==undefined 	|| maxSimple==""
		|| cntGreen==undefined 		|| cntGreen==""
		|| cntYellow==undefined 	|| cntYellow==""
		|| cntRed==undefined 		|| cntRed==""
		|| passYellow==undefined 	|| passYellow==""
		|| passRed==undefined 		|| passRed==""	){
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
			  data["simple_min"]=minSimple; 
			  data["simple_max"]=maxSimple;
			  data["green_cnt"]=cntGreen;
			  data["yellow_cnt"]=cntYellow;
			  data["red_cnt"]=cntRed;
			  data["yellow_pass"]=passYellow;
			  data["red_pass"]=passRed;
			  jQuery.ajax({
				url : 'insertSettingRandomLast',
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
			$('[name=minSimple]').val("");
			$('[name=maxSimple]').val("");
			$('[name=cntGreen]').val("");
			$('[name=cntYellow]').val("");
			$('[name=cntRed]').val("");
			$('[name=passYellow]').val("");
			$('[name=passRed]').val("");
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
		det +='<td class="text-center" >'+(data[i].SAMPLE_MIN==null?"":data[i].SAMPLE_MIN)+('-')+(data[i].SAMPLE_MAX==null?"":data[i].SAMPLE_MAX)+'</td>'; //
		det +='<td class="text-center" >'+(data[i].GREEN_CNT==null?"":data[i].GREEN_CNT)+'</td>';
		det +='<td class="text-center" >'+(data[i].YELLOW_CNT==null?"":data[i].YELLOW_CNT)+'</td>';
		det +='<td class="text-center" >'+(data[i].RED_CNT==null?"":data[i].RED_CNT)+'</td>';
		det +='<td class="text-center" >'+(data[i].YELLOW_PASS==null?"":data[i].YELLOW_PASS)+'</td>';
		det +='<td class="text-center" >'+(data[i].RED_PASS==null?"":data[i].RED_PASS)+'</td>';		
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
			  data["code"]=Type;
			  jQuery.ajax({
				url : 'inquirySettingRandomLast',
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
				url : 'deleteSettingRandomLast',
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
				
//				$('[name=updatenameCode]').html(window.settingrandom[i]['CODCOMP']);
				ReplacedataToinput('[name=updatesimplemin]',window.settingrandom[i]['SAMPLE_MIN']);
				ReplacedataToinput('[name=updatesimplemax]',window.settingrandom[i]['SAMPLE_MAX']);
				ReplacedataToinput('[name=updategreencnt]',window.settingrandom[i]['GREEN_CNT']);
				ReplacedataToinput('[name=updateyellowcnt]',window.settingrandom[i]['YELLOW_CNT']);
				ReplacedataToinput('[name=updateredcnt]',window.settingrandom[i]['RED_CNT']);
				ReplacedataToinput('[name=updateyellowpass]',window.settingrandom[i]['YELLOW_PASS']);
				ReplacedataToinput('[name=updateredpass]',window.settingrandom[i]['RED_PASS']);
				
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
		var updateSimplemin = $('[name=updatesimplemin]').val();
		var updateSimplemax = $('[name=updatesimplemax]').val();
		var updateGreencnt = $('[name=updategreencnt]').val();
		var updateYellowcnt = $('[name=updateyellowcnt]').val();
		var updateRedcnt = $('[name=updateredcnt]').val();
		var updateYellowpass = $('[name=updateyellowpass]').val();
		var updateRedpass = $('[name=updateredpass]').val();
		
		
		if(updateSimplemin==undefined           || updateSimplemin==""
			|| updateSimplemax==undefined       || updateSimplemax==""
			|| updateGreencnt==undefined        || updateGreencnt==""
			|| updateYellowcnt==undefined       || updateYellowcnt==""
			|| updateRedcnt==undefined 			|| updateRedcnt==""
			|| updateYellowpass==undefined      || updateYellowpass==""
			|| updateRedpass==undefined 		|| updateRedpass==""){
			hideupdateSettingRandom();
			Swal.fire({
				  title: 'กรุณากรอกข้อมูลให้ครบถ้วน',
				  text: "",
				  type: 'warning',
				}).then((result) => {
				  if (result.value) {
					  	ReplacedataToinput('[name=updatesimplemin]',updateSimplemin);
						ReplacedataToinput('[name=updatesimplemax]',updateSimplemax);
						ReplacedataToinput('[name=updategreencnt]',updateGreencnt);
						ReplacedataToinput('[name=updateyellowcnt]',updateYellowcnt);
						ReplacedataToinput('[name=updateredcnt]',updateRedcnt);
						ReplacedataToinput('[name=updateyellowpass]',updateYellowpass);
						ReplacedataToinput('[name=updateredpass]',updateRedpass);
						
						updateSettingRandom();
				  }
			})
			
		}else{
			hideupdateSettingRandom();
			progressload();
			try {
				  var data = {}
				  
				  data["code"]=code;
				  data["simple_min"]=updateSimplemin;
				  data["simple_max"]=updateSimplemax;
				  data["green_cnt"]=updateGreencnt;
				  data["yellow_cnt"]=updateYellowcnt;
				  data["red_cnt"]=updateRedcnt;
				  data["yellow_pass"]=updateYellowpass;
				  data["red_pass"]=updateRedpass;
				
				  jQuery.ajax({
					url : 'updateSettingRandomLast',
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