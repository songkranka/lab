$(document).ready(function(){
	
	//First view
	Getdata('all','default',null);
	
	$('.addTestscroll').click(function(){
		addTestscroll();
	});
	
	$('.cancelModal').click(function(){
		cancelModal();
	});
	
	$('.seatchTypeComp').click(function(){
		var TypeComp = $('[name=namecomp]').val();
		seatchTypeComp(TypeComp);
	});
	
	$('.savescore').click(function(){
		Savescore();
	});
	
});

function Savescore(){
	var nameComp = $('[name=nameComp]').val();
	var minGK = $('[name=minGK]').val();
	var maxGK = $('[name=maxGK]').val();
	var minAPI = $('[name=minAPI]').val();
	var maxAPI = $('[name=maxAPI]').val();
	var minATN = $('[name=minATN]').val();
	var maxATN = $('[name=maxATN]').val();
	
	if(nameComp==undefined || nameComp==""
		|| minGK==undefined || minGK==""
		|| maxGK==undefined || maxGK==""
		|| minAPI==undefined || minAPI==""
		|| maxAPI==undefined || maxAPI==""
		|| minATN==undefined || minATN==""
		|| maxATN==undefined || maxATN==""){
		$('.addTestScrollModel').modal('hide');
		Swal.fire({
			  title: 'กรุณากรอกข้อมูลให้ครบถ้วน',
			  text: "",
			  type: 'warning',
			}).then((result) => {
			  if (result.value) {
				  $('.addTestScrollModel').modal('show');
			  }
		})
		
	}else{
		hideaddTestscroll();
		progressload();
		try {
			 
			  var data = {}
			  data["lab_check_comp"]=nameComp;
			  data["general_min"]=minGK;
			  data["general_max"]=maxGK;
			  data["api_min"]=minAPI;
			  data["api_max"]=maxAPI;
			  data["ethanol_min"]=minATN;
			  data["ethanol_max"]=maxATN;
			  data["codeEmid"]=window.codeEmid;
			  jQuery.ajax({
				url : 'insertTestscore',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {
					progressClose();
					if(data.success==1){
						
						hideaddTestscroll();
						Swalsuccess();
						
					}else{
						hideaddTestscroll()
						progressClose()
						showMsgError('เกิดข้อผิดพลาด');
					}
				},
				error : function() {
					hideaddTestscroll()
					progressClose()
					showMsgError('เกิดข้อผิดพลาด');
				}
			});
				   
		} catch (ex) {
			hideaddTestscroll()
			progressClose()
			showMsgError(ex);
		}
	}
	
}

function addTestscroll(){
	$('.addTestScrollModel').modal('show');
}

function hideaddTestscroll(){
	$('.addTestScrollModel').modal('hide');
}

function updateTestscroll(){
	$('.updateTestScrollModel').modal('show');
}

function hideupdateTestscroll(){
	$('.updateTestScrollModel').modal('hide');
}

function Swalsuccess(){
	Swal.fire({
	  type: 'success',
	  title: 'Save score space success',
	  text: '',
	  confirmButtonText: 'ตกลง'
	}).then((result) => {
		if (result.value) {
			$('[name=nameComp]').val("");
			$('[name=minGK]').val("");
			$('[name=maxGK]').val("");
			$('[name=minAPI]').val("");
			$('[name=maxAPI]').val("");
			$('[name=minATN]').val("");
			$('[name=maxATN]').val("");
			Getdata('all','default',null);
		}
	})
}


function delSuccess(){
	Swal.fire({
	  type: 'success',
	  title: 'Delete score space success',
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
	  title: 'Update score space success',
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
	var htmlvar = $('[name=namecomp]').html();
	$.each( data, function( key, value ) {
		htmlvar = htmlvar+'<option value="'+value["LAB_CHECK_COMP"]+'">'+value["LAB_CHECK_COMP"]+'</option>';
	});
	$('[name=namecomp]').html(htmlvar);
}

function dataTable(data){
	
	$('#dteId').html("");
    $('#myTablePlaning').DataTable().destroy();
    
    
    var det = "";
    var stringcomp;
		
	 for (var i = 0; i < data.length; i++) {
		 
		stringcomp = "'"+(data[i].LAB_CHECK_COMP==null?"":data[i].LAB_CHECK_COMP)+"'";
	 	  
		det +='<tr >';
		det +='<td class="text-center" >'+ (i+1)+'</td>'; 
		det +='<td class="text-center" >'+(data[i].LAB_CHECK_COMP==null?"":data[i].LAB_CHECK_COMP)+'</td>';
		det +='<td class="text-center" ><table class="table tableCusIn"><tr><td class="text-center" style="border-right: 0px solid #ffffff;border-top: 0px solid #ffffff;width:50%;" >'+(data[i].GENERAL_MIN==null?"":data[i].GENERAL_MIN)+'</td><td class="text-center" style="border-right: 0px solid #ffffff;border-top: 0px solid #ffffff;width:50%;" >'+(data[i].GENERAL_MAX==null?"":data[i].GENERAL_MAX)+'</td></tr></table></td>';
		det +='<td class="text-center" ><table class="table tableCusIn"><tr><td class="text-center" style="border-right: 0px solid #ffffff;border-top: 0px solid #ffffff;width:50%;" >'+(data[i].API_MIN==null?"":data[i].API_MIN)+'</td><td class="text-center" style="border-right: 0px solid #ffffff;border-top: 0px solid #ffffff;width:50%;" >'+(data[i].API_MAX==null?"":data[i].API_MAX)+'</td></tr></table></td>';
		det +='<td class="text-center" ><table class="table tableCusIn"><tr><td class="text-center" style="border-right: 0px solid #ffffff;border-top: 0px solid #ffffff;width:50%;" >'+(data[i].ETHANOL_MIN==null?"":data[i].ETHANOL_MIN)+'</td><td class="text-center" style="border-right: 0px solid #ffffff;border-top: 0px solid #ffffff;width:50%;" >'+(data[i].ETHANOL_MAX==null?"":data[i].ETHANOL_MAX)+'</td></tr></table></td>'
		det +='<td class="text-center" ><div onclick="updatedata('+stringcomp+')" ><i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp;แก้ไข</div><div class="clickType" onclick="deldata('+stringcomp+')" ><i class="fa fa-trash" aria-hidden="true"></i>&nbsp;ลบ</div></td>';
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
			  data["lab_check_comp"]=Type;
			  jQuery.ajax({
				url : 'inquiryTestscore',
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
						window.listscore = data.list;
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

function deldata(comp){
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
		  deleteprocess(comp);
	  }
	})
}

function deleteprocess(comp){
	if(comp!=undefined || comp!=""){
		progressload();
		try {
			 
			  var data = {}
			  data["lab_check_comp"]=comp;
			  jQuery.ajax({
				url : 'deleteTestscore',
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

function updatedata(comp){
	//Replace data to input box
	updatedataReplacedata(comp);
}

function updatedataReplacedata(comp){
	if(window.listscore!=undefined && window.listscore!="" && comp!=undefined && comp!=""){
		
		for (var i = 0; i < window.listscore.length; i++) {
			if(window.listscore[i]['LAB_CHECK_COMP']==comp){
				
				$('[name=updatenameComp]').html(window.listscore[i]['LAB_CHECK_COMP']);
				ReplacedataToinput('[name=updateminGK]',window.listscore[i]['GENERAL_MIN']);
				ReplacedataToinput('[name=updatemaxGK]',window.listscore[i]['GENERAL_MAX']);
				ReplacedataToinput('[name=updateminAPI]',window.listscore[i]['API_MIN']);
				ReplacedataToinput('[name=updatemaxAPI]',window.listscore[i]['API_MAX']);
				ReplacedataToinput('[name=updateminATN]',window.listscore[i]['ETHANOL_MIN']);
				ReplacedataToinput('[name=updatemaxATN]',window.listscore[i]['ETHANOL_MAX']);
				
				//Add to bottom
				$(".updatescore").attr("onclick","updateprocess('"+window.listscore[i]['LAB_CHECK_COMP']+"')");
				
				//Open entity updateTestscroll
				updateTestscroll();
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

function updateprocess(comp){
	if(Option!=undefined || Option!=""){
		
		//Get values
		var updateMinGK = $('[name=updateminGK]').val();
		var updateMaxGK = $('[name=updatemaxGK]').val();
		var updateMinAPI = $('[name=updateminAPI]').val();
		var updateMaxAPI = $('[name=updatemaxAPI]').val();
		var updateMinATN = $('[name=updateminATN]').val();
		var updateMaxATN = $('[name=updatemaxATN]').val();
		
		if(updateMinGK==undefined || updateMinGK==""
			|| updateMaxGK==undefined || updateMaxGK==""
			|| updateMinAPI==undefined || updateMinAPI==""
			|| updateMaxAPI==undefined || updateMaxAPI==""
			|| updateMinATN==undefined || updateMinATN==""
			|| updateMaxATN==undefined || updateMaxATN==""){
			hideupdateTestscroll();
			Swal.fire({
				  title: 'กรุณากรอกข้อมูลให้ครบถ้วน',
				  text: "",
				  type: 'warning',
				}).then((result) => {
				  if (result.value) {
						ReplacedataToinput('[name=updateminGK]',updateMinGK);
						ReplacedataToinput('[name=updatemaxGK]',updateMaxGK);
						ReplacedataToinput('[name=updateminAPI]',updateMinAPI);
						ReplacedataToinput('[name=updatemaxAPI]',updateMaxAPI);
						ReplacedataToinput('[name=updateminATN]',updateMinATN);
						ReplacedataToinput('[name=updatemaxATN]',updateMaxATN);
						updateTestscroll();
				  }
			})
			
		}else{
			hideupdateTestscroll();
			progressload();
			try {
				 
				  var data = {}
				  data["lab_check_comp"]=comp;
				  data["general_min"]=updateMinGK;
				  data["general_max"]=updateMaxGK;
				  data["api_min"]=updateMinAPI;
				  data["api_max"]=updateMaxAPI;
				  data["ethanol_min"]=updateMinATN;
				  data["ethanol_max"]=updateMaxATN;
				  data["codeEmid"]=window.codeEmid;
				  jQuery.ajax({
					url : 'updateTestscore',
					type : "Post", 
					contentType : "application/json",
					data : JSON.stringify(data), 
					dataType : 'json',
					  async: false,
					   cache: false,
					success : function(data) {
						progressClose();
						if(data.success==1){
							
							hideaddTestscroll();
							updateSuccess();
							
						}else{
							hideaddTestscroll()
							progressClose()
							showMsgError('เกิดข้อผิดพลาด');
						}
					},
					error : function() {
						hideaddTestscroll()
						progressClose()
						showMsgError('เกิดข้อผิดพลาด');
					}
				});
					   
			} catch (ex) {
				hideaddTestscroll()
				progressClose()
				showMsgError(ex);
			}
		}
	}else{
		progressClose()
		showMsgError('เกิดข้อผิดพลาด');
	}
}