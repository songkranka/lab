var basePath = '/Lab/api/';

$(document).ready(function () {
	$('#pageTitles').text('บันทึกผล');
	getLabCode();
	
	$( "#inputProductDesc" ).change(function() {
		if($(this).children(":selected").attr("id")==50){
			
			$("#other_input").css("display", "block");
			
		}else{
			
			$("#other_input").css("display", "none");
		}
  		
	});
	$('#inputProductDesc').trigger("change");
	$( "#input_revise" ).change(function() {
		if($(this).children(":selected").attr("id")==99){
			$("#other_revise").css("display", "block");
			$("#dialog_getwork").height("30%");
		}else{
			$("#dialog_getwork").height("24%");
			$("#other_revise").css("display", "none");
		}
  		
	});
	$('#input_revise').trigger("change");
	
   $('#inputReviseOther' ).change(function() {
		$('#inputReviseOther').css('border-color', '#e5e6e7');
	});
	$( '#inputReviseOther' ).keypress(function() {
  $('#inputReviseOther').css('border-color', '#e5e6e7');
	});
	

});
//COMMENT VAR
var com_name = [],com_detail=[],com_seq=[],com_group =[],com_date=[];

//ID LEVEL 
var idLevelType = [];
var prod_desc = "";
var pddesc_id="";
var userTypeSetText = "";
var labCode = "";
var tmp_data = {};
var colorID = [],colorName = [],count=[],visualID = [],visualName=[],colorASTMID = [],colorASTMName = [],dataStore=[],tx_append=[],defalutFlagTool=[],userdynamictool=[],getCheckUncer=[],defalutFlagMethod=[];
var str = location.search;
var biodiesel=false;
var product_id='';
var sampletype_id='';
var statusIRPC=''
var wf_status='';
var teamleadFlagTemp='';

str = str.split("?");
function getLabCode(){	
	
	checkLevel();
	setDropDownSetupColor();
	setDropDownSetupColorASTM();
	setDropDownVisual();
	getTaskListDetail(str[1],str[2]);
	setDropDown();
	
	queryDetail(labCode);
	
	//console.log($(chkUser).first());
	//checkInsertData();
	//console.log(userTypeSetText);
	getCommentHistory();
	getProductDescription();
	getUserCreateHistory();
	//setComment();
	responsPage();
	getReviseDescription();
	getLocalStorage();
	if(defalutFlagTool.length>0){
	initDropdownToolId();
	}
}
function sendToEdit(){
	var id_check=$('#input_revise').val();
	var text_check=$("#inputReviseOther").val();

	if(id_check==99&&text_check==""){
		$('#inputReviseOther').css('border-color', 'red');
	}

	else{
	$('#reason_modal').modal('toggle');
	saveDataWF('10');	
	}
	
}
function sendToCancel(){
	var ltr_sub_id = "";
	$("input[name='chk']").each(function() { 
		if($(this).prop('checked')){
			//console.log($(this));
   	        for(var i=0;i<tmp_data.list.length;i++){      	
   			 	if($(this).val()==tmp_data.list[i].LTR_DT_SUB_ID){   
   			 		ltr_sub_id += "'"+$(this).val()+"',"; 
   			 	} 
   			 }	 
   	     }
	 });
	ltr_sub_id = ltr_sub_id.substring(0,ltr_sub_id.length-1);
	//console.log(ltr_sub_id);
	if(userTypeSetText=='7' && ltr_sub_id=="" || ltr_sub_id==null ){
		 showMsgError('กรุณาเลือกรายการ');
		 return;
	}else if(userTypeSetText=='6' && ltr_sub_id=="" || ltr_sub_id==null){
		showMsgError('กรุณาเลือกรายการ');
		 return;
	}else{	
		returnSubmitWorkToUser(ltr_sub_id,"");
		saveDataWF('09');
	}
	
}

function checkSave(){
	
	if(userTypeSetText=='7'){ //A4
		if(checkUncerBeforeSave()){
			$('#uncer_check').modal();
			$('#text_uncer').html("กรุณาระบุค่า Uncertainty ทุกช่องที่ ไม่ผ่าน,ผ่านแบบมีเงื่อนไข");
			return null;
		}
		
		saveDataWF('07');
		updateLTRHDresult();
		biodiesel=true;
		saveData("COQX");
	}else if( userTypeSetText=='6'){ //LAB TEAM LEAD	
		if(str[2]=="editWork"){
			updateLTRHDresult();
			saveData("COQX");
			updateHeader();
			saveDataWF('08');

		}else if(str[2]=="newWork"){
		if(checkUncerBeforeSave()){
			$('#uncer_check').modal();
			$('#text_uncer').html("กรุณาระบุค่า Uncertainty ทุกช่องที่ ไม่ผ่าน,ผ่านแบบมีเงื่อนไข");
			return null;
		}
		
		if(teamleadFlagTemp=='Y'){
			saveData("COQX");
		}
		saveDataWF('08');
		}
	}else if(userTypeSetText=='5'){ //LAB MANAGER
		/*var ltr_sub_id = "";
		$("input[name='chk']").each(function() { 
			if($(this).prop('checked')){
				//console.log($(this));
	   	        for(var i=0;i<tmp_data.list.length;i++){      	
	   			 	if($(this).val()==tmp_data.list[i].LTR_DT_SUB_ID){   
	   			 		ltr_sub_id += "'"+$(this).val()+"',"; 
	   			 	} 
	   			 }	 
	   	     }
		 });
		ltr_sub_id = ltr_sub_id.substring(0,ltr_sub_id.length-1);
		returnSubmitWorkToUser(ltr_sub_id,"");*/
		saveDataWF('12');
	}else{
		if(defalutFlagTool.length>0){
		updateDynamicToolId();
		}
		removeLocalStorage();
		var chkUML='0';
		$.each(count,function(i,v){
			//console.log(v.split("|")[5]);
			if("0011"==v.split("|")[5] || "0012"==v.split("|")[5]){
				chkUML = '1';
			}
		
		});
	
		if(checkEmptyValue(chkUML)){
			showMsgError('กรุณากรอกข้อมูลให้ครบทุกช่อง');
			return null;
		}

		if("1"==chkUML){
			setDataUML();
			saveData("NO COQ");
		}else{
			saveData("NO COQ");
		}	

	}
}

function checkEmptyValue(uml){
	var check=false;
		for(var c=0;c<count.length;c++){
				if(
					document.getElementById('resultTxT'+c+'')!=''
					&&document.getElementById('resultTxT'+c+'')!=null
					&&($('#resultTxT'+c+'').val()==''||$('#resultTxT'+c+'').val()==null))
				{
					check=true;
				}
		
		}
	if("1"==uml){
				$.each(idLevelType,function(i,v){	
				
				if($("#"+v.split("|")[0]+"").val()==''||$("#"+v.split("|")[0]+"").val()==null){
					check=true;
				}
				});
	}
	return check;
}

function checkLevel(){	
	try{
		var data = {};
		//console.log(JSON.stringify(data));
        ShowWaiting();
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'getLevelHead',
            data : JSON.stringify(data),
            dataType: 'json',
            async: false,
			cache: false,
            success : function(data) {         	
            	userTypeSetText = data.list[0].LEVEL_HEAD;
            	//data.list[0].USER_TYPE_ID
            	//$("#userTypeSetText").val(userTypeSetText);
            	//console.log($("#userTypeSetText").val());
            	$("#sendEdit").hide();
            	$(".comment-class").hide();
                HideWaiting();                
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });
    }catch (ex) {
        HideWaiting();
        showMsgError(ex);
    }
}


function checkIRPC(labcode){	
	try{
		if(userTypeSetText!='7'&&userTypeSetText!='6'){
			return null;
		}
		var data = {};
		data['labCode'] = labcode;
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:'util-checkIRPC',
            data : JSON.stringify(data),
            dataType: 'json',
            async: false,
			cache: false,
            success : function(data) {         	
             statusIRPC=data[0].status;
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });
    }catch (ex) {
        HideWaiting();
        showMsgError(ex);
    }
}
function responsPage(){
//	$("#inputProductDesc").val("");

	$("#lab_prddesc").val("");
	if(userTypeSetText=='7'){ //A4
		//$("#sendBack").removeClass( "col-sm-6" ).addClass( "col-sm-6" );
		//$("#sendSave").removeClass( "col-sm-6" ).addClass( "col-sm-6" );
		$(".comment-class").show();
		$("#sendBack").show();
		$("#sendSave").show();
		$("#inputProductDesc").val(prod_desc);
		$(".product-desc").show();
		if(str[2]=="newWork"){
			
			$("#inputProductDesc").attr('readonly',false);
			if(pddesc_id==null||pddesc_id==''||pddesc_id==50){
				$( "#inputProductDesc" ).val(50);
				
				if(prod_desc!=null&&prod_desc!=''){
					$("#inputProductDescOther").val(prod_desc);
				}
			}else{
				$("#inputProductDesc").val(pddesc_id);
			}
			$("#result_silver").select2({dropdownAutoWidth: true,width: 'auto'});
			//$(".product-desc").show();
			//console.log($("#result_silver").val()+"|"+str[1]);
			$("#pageTitles").html("รายการที่ต้องตรวจสอบ");
			$("#sendCancel").show();
			$("#sendBack").hide();
			$("#sendSave").show();
			$("#sendSaveButton").html("อนุมัติ");
			$("#sendCancel").removeClass( "col-sm-6" ).addClass( "col-sm-6" );  
			$("#describe_for_tool_block").show();
		}else if(str[2]=="editWork"){
			if(pddesc_id!=''&&pddesc_id!=''){
				if(pddesc_id==50){
					$( "#inputProductDesc" ).val(50);
					$("#inputProductDescOther").val(prod_desc);
					$('#inputProductDescOther').prop('disabled', 'disabled');
				    $('#inputProductDesc').prop('disabled', 'disabled');
				}else{
					$( "#inputProductDesc" ).val(pddesc_id);
					$('#inputProductDesc').prop('disabled', 'disabled');
				}
			}

			$(".comment-class").show();
			$("#pageTitles").html("รายการที่ส่งแก้ไข");
			$("#sendBack").show();
    		$("#sendSave").hide();
    		$("#sendBack").removeClass( "col-sm-6" ).addClass( "col-sm-12" );
			$("#describe_for_tool_block").show();
		}
		else{
			
			//$(".product-desc").show();
			$("#inputProductDesc").attr('readonly',true);
			$("#label_read_prddesc").show();
			$("#lab_prddesc").val(prod_desc);
			$("#inputProductDesc").hide();
			$(".comment-class").hide();
			$(".history-a4").show();
			$("#pageTitles").html("รายการที่ตรวจสอบแล้ว");
			$("#sendBack").show();
    		$("#sendSave").hide();
    		$("#sendBack").removeClass( "col-sm-6" ).addClass( "col-sm-12" );
			$("#describe_for_tool_block").show();
			$('#remark_a4').attr('readonly', true);
		}
			pageTitles
		//$("#userTypeSetText").val(userTypeSetText);
	}else if(userTypeSetText=='6'){ //LAB TEAM LEAD
		if(wf_status=='00'&&str[2]=='doneWork'){
			$("#sendEdit").show();
		}else if(wf_status=='00'){
			$("#sendBack").removeClass( "col-sm-6" ).addClass( "col-sm-12" );
		}else{
			$("#sendEdit").show();
		}
		
		$("#sendCancel").show();
		$("#sendSave").show();
		$("#sendSave").show();
		
		
		$("#sendSaveButton").html("อนุมัติ");
		$("#sendCancel").removeClass( "col-sm-6" ).addClass( "col-sm-4" );
		$("#sendEdit").removeClass( "col-sm-6" ).addClass( "col-sm-4" );
		$("#sendSave").removeClass( "col-sm-6" ).addClass( "col-sm-4" );
		$("#sendRemove").removeClass( "col-sm-6" ).addClass( "col-sm-4" );
		$(".comment-class").show();
//		$("#inputProductDesc").val(prod_desc);

		
		if(str[2]=="newWork"&&teamleadFlagTemp!='Y'){
			$("#sendRemove").show();
			$("#lab_prddesc").val(prod_desc);
		    $(".product-desc").show();
			$("#describe_for_tool_block").show();
			$("#remark_a4").attr('readonly',true);
			
			$("#inputProductDesc").attr('readonly',true);
			$("#label_read_prddesc").show();
			$("#inputProductDesc").hide();
			$("#pageTitles").html("รายการที่ต้องตรวจสอบ");
			$("#sendEdit").hide();
			//$("#sendSave").removeClass().addClass( "col-sm-6");
			//$("#sendCancel").removeClass().addClass( "col-sm-6");
			
			if(pddesc_id!=''&&pddesc_id!=''){
				$("#label_read_prddesc").val(prod_desc);

			}
		}else if(str[2]=="newWork"&&teamleadFlagTemp=='Y'){
			$("#sendRemove").show();
			$("#lab_prddesc").val(prod_desc);
		    $(".product-desc").show();
			$("#describe_for_tool_block").show();
			$("#remark_a4").attr('readonly',false);
			
			$("#label_read_prddesc").hide();
			$("#inputProductDesc").show();
			//$("#inputProductDesc").attr('readonly',true);
			//$("#label_read_prddesc").show();
			if(pddesc_id=='50'){
				$("#inputProductDesc").val(pddesc_id);
				$("#inputProductDescOther").val(prod_desc);
				
			}else{
				$("#inputProductDesc").val(pddesc_id);
			}
			//$("#inputProductDesc").hide();
			$("#pageTitles").html("รายการที่ต้องตรวจสอบ");
			$("#sendEdit").hide();
			//$("#sendSave").removeClass().addClass( "col-sm-6");
			//$("#sendCancel").removeClass().addClass( "col-sm-6");
			
//			if(pddesc_id!=''&&pddesc_id!=''){
//				$("#label_read_prddesc").val(prod_desc);
//
//			}
		}else if(str[2]=="editWork"){
			//$("#lab_prddesc").val(prod_desc);
		    $(".product-desc").show();
			$("#lab_prddesc").hide();
			$("#describe_for_tool_block").show();
			$("#remark_a4").attr('readonly',false);
			$("#label_read_prddesc").hide();
			if(pddesc_id!=''&&pddesc_id!=''){
				$("#label_read_prddesc").val(prod_desc);
			}
			
			$("#inputProductDesc").show();
			if(pddesc_id=='50'){
				$("#inputProductDesc").val(pddesc_id);
				$("#inputProductDescOther").val(prod_desc);
				
			}else{
				$("#inputProductDesc").val(pddesc_id);
			}
			
			$("#pageTitles").html("รายการที่ต้องแก้ไข");
			$("#sendBack").show();
			$("#editDataAndSave").show();
			$("#sendCancel").hide();
			//$("#sendSave").hide();
			$("#sendEdit").hide();
			
			//$("#sendBack").removeClass( "col-sm-6" ).addClass( "col-sm-6");
		}else if(str[2]=="tempWork"){
			$("#lab_prddesc").val(prod_desc);
		    $(".product-desc").show();
			$("#inputProductDesc").attr('readonly',true);
			$("#label_read_prddesc").show();
			$("#inputProductDesc").hide();
			$('#block_select_getwork').hide();
			$('#label_read_prddesc').show();
			$("#pageTitles").html("รายการที่อนุมัติ");
			$("#sendBack").show();
			$("#sendCancel").hide();
			$("#sendEdit").hide();
			//$("#sendEdit").hide();
			$("#sendSave").hide();
			$("#sendBack").removeClass().addClass( "col-sm-12");
			//$(".comment-class").hide();
			//$("#sendBack").removeClass( "col-sm-6" ).addClass( "col-sm-12");
		}else{
			$("#lab_prddesc").val(prod_desc);
		    $(".product-desc").show();
			$("#inputProductDesc").attr('readonly',true);
			$("#label_read_prddesc").show();
			$("#inputProductDesc").hide();
			$('#block_select_getwork').hide();
			$('#label_read_prddesc').show();
			$("#pageTitles").html("รายการที่อนุมัติ");
			$("#sendBack").show();
			$("#sendCancel").hide();
			
			//$("#sendEdit").hide();
			$("#sendSave").hide();
			//$(".comment-class").hide();
			//$("#sendBack").removeClass( "col-sm-6" ).addClass( "col-sm-12");
		}
	}else if(userTypeSetText=='5'){ //LAB MANAGER
		$("#sendCancel").show();
		$("#sendSave").show();
		$("#sendSaveButton").html("อนุมัติ");
		$(".comment-class").show();
		$("#inputProductDesc").val(prod_desc);
		$(".product-desc").show();
		
		if(str[2]=="newWork"){
			$("#inputProductDesc").attr('readonly',true);
		    $("#label_read_prddesc").show();
			$("#inputProductDesc").hide();
			$("#pageTitles").html("รายการที่ต้องอนุมัติ");
		}else{
			$("#inputProductDesc").attr('readonly',true);
			$("#label_read_prddesc").show();
			$("#inputProductDesc").hide();
			$("#pageTitles").html("รายการที่อนุมัติแล้ว");
			$("#sendCancel").hide();
    		$("#sendSave").hide();
			$("#sendBack").show();
			$("#sendBack").removeClass( "col-sm-6" ).addClass( "col-sm-12" );
		}
		$("#lab_prddesc").val(prod_desc);
	}else{
		$("#label_read_prddesc").val(prod_desc);
		if(str[2]=="doneWork"){
			$("#pageTitles").html("รายการบันทึกผล");
			$("#sendBack").removeClass( "col-sm-6" ).addClass( "col-sm-12" );
			$("#sendSave").hide();
			$("#sendBack").show();
		}else if(str[2]=="editWork"){
			$("#pageTitles").html("รายการที่ต้องแก้ไข");
			$(".comment-class").show();
			$("#sendBack").show();
    		$("#sendSave").show();
		}else{
			
			$("#edit_plan_div").show();
			$("#sendBack").show();
    		$("#sendSave").show();

			$( "#sendBack" ).removeClass( "col-sm-6" ).addClass( "col-sm-4" );
			$( "#sendSave" ).removeClass( "col-sm-6" ).addClass( "col-sm-4" );
		}         		
	}


}

function sendToRemove(){

    let labCodes = [];
    labCodes.push($('#ltr_no').text());

    
    let labCode = "";
    for(var i=0;i<labCodes.length;i++){

    	labCode += "'"+labCodes[i]+"',"
    }
    labCode = labCode.substring(0,labCode.length-1);

    
	try {
	    	var data = {}	
	    	data["labCode"] = labCode;
	    	console.log(JSON.stringify(data));
	    	ShowWaiting() ;
			jQuery.ajax({
			url : 'cancelLTRAssignment',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
						showMsgSuccess('ยกเลิกสำเร็จ');
						HideWaiting() ;
						location.href = "/Lab/home";
						
					},
					error : function() {
						 showMsgError('เกิดข้อผิดพลาด');
						 HideWaiting() ;
					}
				});   
	} catch (ex) {

		 showMsgError(ex);
		 HideWaiting() ;
	}
	
	

}
function updateLTRHDresult(){
	//$("#result_silver").select2();
	//console.log($("#result_silver").val()+"|"+str[1]);
	ShowWaiting();
	try{
		var data = {};
		data["ltrhd"] = str[1];
		data["statusLTR"] = $("#result_silver").val();
		if(
		  userTypeSetText=='7'&&(str[2] == "newWork"||str[2] == "editWork")
		||userTypeSetText=='6'&&str[2] == "editWork"
		||(userTypeSetText=='6'&&str[2] == "newWork"&&'Y'==teamleadFlagTemp)
		){
			if($("#remark_a4").val().length>0){
				data["remark"] = $("#remark_a4").val();
			}
		}
	   
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url: 'updateLTRHDresult',
            data : JSON.stringify(data),
            dataType: 'json',
            async: false,
			cache: false,
            success : function(data) {    
            	showMsgSuccess('ดำเนินการสำเร็จ');
            	
                HideWaiting();         
                gotoMain();
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });
    }catch (ex) {
        HideWaiting();
        showMsgError(ex);
    }
}
function updateResultUncer(ltrdt,resultUncen){
	//resultUncer
	ShowWaiting();
	try{
		var data = {};
		data["ltrhd"] = str[1];
		data["ltrdt"] = ltrdt;
		data["resultUncer"] = resultUncen;
	     
		
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url: 'updateResultUncertainty',
            data : JSON.stringify(data),
            dataType: 'json',
            async: false,
			cache: false,
            success : function(data) {    
            	showMsgSuccess('ดำเนินการสำเร็จ');
            	//console.log("success");
                HideWaiting();         
                //gotoMain();
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });
    }catch (ex) {
        HideWaiting();
        showMsgError(ex);
    }
}

function saveDataWF(status){
	ShowWaiting();
	var descPrd='';
	var descPrdId=$('#inputProductDesc option:selected').attr('id');
	var descRevise='';
	var codeRevise='';
	//$( "#inputProductDesc" ).val();


	
	if(status=='10'||(str[2]=="newWork"&&userTypeSetText=='7')||(str[2]=="newWork"&&userTypeSetText=='6')||(str[2]=="editWork"&&userTypeSetText=='6')){
		
		if(str[2]=="newWork"&&userTypeSetText=='7'||(str[2]=="editWork"&&userTypeSetText=='6')||(str[2]=="newWork"&&userTypeSetText=='6')){
		if(descPrdId=='50'){
		descPrd=$( "#inputProductDescOther" ).val();
		}else{
		descPrd=$( "#inputProductDesc option:selected" ).text();
		}
		}else{
			descPrdId='';
			descPrd='';
		}

		codeRevise=$('#input_revise option:selected').attr('id');
	
	if(codeRevise=='99'){
		descRevise=$( "#inputReviseOther").val();
	}else{
		descRevise=$( "#input_revise option:selected" ).text();
	}
	}

	try{
		var data = {};
		data["comment"] = $("#commentTextarea").val();
		data["ltrhd"] = str[1];
		data["status"] = status;
		data["labCode"] = labCode;
		data["product_desc"] = descPrd; 
		data["productID"] = descPrdId; 
		//code and des
		if(status=='10'){
		data["reviseCode"] = codeRevise; 
		data["reviseDes"] = descRevise; 
		}
		data["url_wf"] = window.location.href;
		//console.log(JSON.stringify(data));
        
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url: 'insertWFLTR',
            data : JSON.stringify(data),
            dataType: 'json',
            async: false,
			cache: false,
            success : function(data) {    
            	showMsgSuccess('ดำเนินการสำเร็จ');
            	//console.log("success");
                HideWaiting();         
                gotoMain();
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });
    }catch (ex) {
        HideWaiting();
        showMsgError(ex);
    }
}
function returnSubmitWorkToUser(ltr_sub_id,chk){
	ShowWaiting();
	try{
		var data = {};
		data["ltrsubID"] = ltr_sub_id;
		//console.log(JSON.stringify(data));
        
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url: 'returnSubmitWorkToUser',
            data : JSON.stringify(data),
            dataType: 'json',
            async: false,
			cache: false,
            success : function(data) {    
            	showMsgSuccess('ดำเนินการสำเร็จ');
            	//console.log("success");
                HideWaiting();    
                if(chk=="mian"){
                	gotoMain();
                }
                
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });
    }catch (ex) {
        HideWaiting();
        showMsgError(ex);
    }
}
function queryDetail(labCode){
    try {
    	var data = {}	
    	data["labCode_No"] = labCode;
    	ShowWaiting() ;
		jQuery.ajax({
			url : 'QueryAssignmentDetail',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			//async: false,
			//cache: false,
            success: function (data) {
				console.log(data);
            	$('#ltr_no').append(data.list[0].LAB_CODE);
            	$('#ltr_prod').append(data.list[0].product_name);
            	$('#ltr_carno').append(data.list[0].CAR_NO);
            	$('#ltr_datepo').append(data.list[0].PO_DATE);
            	$('#ltr_src').append(data.list[0].source_name);
            	$('#ltr_carslot').append(data.list[0].CAR_SLOT);
            	$('#ltr_po').append(data.list[0].PO_NO);
            	if("T" == data.list[0].SAMPLE_TYPE_NAME){
            		$('#ltr_trans').append(" - ");
            	}else{
            		$('#ltr_trans').append(data.list[0].logis_name);
            	}
            		
            	$('#ltr_boatno').append(data.list[0].BOAT_NO);
            	$('#ltr_do').append(data.list[0].DO_NO);
            	$('#ltr_samp').append(data.list[0].SAMPLE_LEVEL_DESC);
            	$('#ltr_boatname').append(data.list[0].BOAT_NAME);
            	$('#ltr_ship').append(data.list[0].SHIPMENT_NO);
				if('N'==data.list[0].MANUAL_TYPE){
					$('#ltr_daterandom').append(data.list[0].RAN_DATE_TIME.split(" ")[0]+' /'+data.list[0].RAN_DATE_TIME.split(" ")[1]);
				}else{
					$('#ltr_daterandom').append(data.list[0].RAN_DATE_TIME.split(" ")[0]+' /'+data.list[0].RAN_DATE_TIME.split(" ")[1]);
				}
            	
            	$('#ltr_boatslot').append(data.list[0].BOAT_SLOT);
            	$('#ltr_grp').append(data.list[0].SAMPLE_REFER);
            	$('#ltr_dateexp').append(data.list[0].STR_SAMPLE_DATE);
            	$('#ltr_empname').append(data.list[0].SAMPLE_STAFF_NAME);
            	$('#ltr_sampleType').append(data.list[0].SAMPLE_TYPE_NAME);
            	$("#ltr_sampleType_desc").append(data.list[0].SAMPLE_TYPEC_DESC);
            	//console.log(data.list[0].LAB_CODE);
				//Use for edit head detail
				$('#assiHeadT').DataTable().destroy();
				$('#assiHead').html("");
				var detail_head_edit = '';
				// Assuming the original date string is in the "dd/mm/yyyy" format
				var dateStr = data.list[0].SAMPLE_DATE.trim();
				var dateParts = dateStr.split('/');
				var formattedDate = dateParts[1] + '/' + dateParts[0] + '/' + dateParts[2];
				var checkDisabled;
				if(userTypeSetText=="6" && (str[2] == "newWork" || str[2] == "editWork")){
					checkDisabled = '';
				}
				else {
					checkDisabled = 'disabled="disabled"';
				}
					//ลักษณะเก็บตัวอย่าง
					detail_head_edit += SetDropDownGetSample(data.list[0].SAMPLE_TYPE_NAME, data.list[0].SAMPLE_LEVEL_DESC, checkDisabled);
					detail_head_edit += '<tr><td>วันที่เก็บตัวอย่าง</td><td class="text-center"><input type="text"  class="form-control" maxlength="10" id="input-sample-date" data-provide="datepicker"'+checkDisabled+'></tr>';
					detail_head_edit += "<script>$(document).ready(function(){" +
									    "$('#input-sample-date').datepicker({" +
									    "format: 'dd/mm/yyyy'," +
									    "autoclose: true" +
									    "});" +
									    "var defaultDate = new Date('" + formattedDate + "');" +
									    "$('#input-sample-date').datepicker('setDate', defaultDate);" +
									    "});</script>";
					if(data.list[0].SAMPLE_TYPE_CODE =='00010' || data.list[0].SAMPLE_TYPE_CODE =='00001'){
						detail_head_edit += '<tr><td>รายละเอียดตัวอย่าง</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-sample-typec-desc" value="'+(data.list[0].SAMPLE_TYPEC_DESC == null ? "" : data.list[0].SAMPLE_TYPEC_DESC) + '"' +  checkDisabled + ' style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00004'){
						detail_head_edit += '<tr><td>รายละเอียดการเข้าเก็บ</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-sample-typec-desc" value="'+(data.list[0].SAMPLE_TYPEC_DESC == null ? "" : data.list[0].SAMPLE_TYPEC_DESC) + '"' +  checkDisabled + ' style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00004'){
						detail_head_edit += '<tr><td>หมายเลขถัง</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-tank-no" value="'+(data.list[0].TANK_NO == null ? "" : data.list[0].TANK_NO)+ '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00005' || data.list[0].SAMPLE_TYPE_CODE =='00007'){
						detail_head_edit += '<tr><td>รายละเอียดจุดเก็บ</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-sample-point-desc" value="'+(data.list[0].SAMPLE_POINT_DESC == null ? "" : data.list[0].SAMPLE_POINT_DESC)+ '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00005' || data.list[0].SAMPLE_TYPE_CODE =='00007'){
						//ประเภทปั้ม
						detail_head_edit += SetDropDownTypeStation(data.list[0].TYPE_STATION_ID, checkDisabled);
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00006'){
						//จุดเก็บ 
						detail_head_edit += SetDropDownSavePoint(data.list[0].LOC_ID, checkDisabled);
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00006'){
						detail_head_edit += '<tr><td>LOT NO.</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-adtv-lot-no" value="'+(data.list[0].ADTV_LOT_NO == null ? "" : data.list[0].ADTV_LOT_NO)+ '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00006'){
						detail_head_edit += '<tr><td>PO NO.</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-po-no" value="'+(data.list[0].PO_NO == null ? "" : data.list[0].PO_NO)+ '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00002' || data.list[0].SAMPLE_TYPE_CODE =='00008' || data.list[0].SAMPLE_TYPE_CODE =='00009'){
						detail_head_edit += '<tr><td>Shipment No.</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-shipment-no" value="'+(data.list[0].SHIPMENT_NO == null ? "" : data.list[0].SHIPMENT_NO)+ '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00002' || data.list[0].SAMPLE_TYPE_CODE =='00008' || data.list[0].SAMPLE_TYPE_CODE =='00009'){
						detail_head_edit += '<tr><td>จำนวนช่องเรือ</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-boat-slot" value="'+(data.list[0].BOAT_SLOT == null ? "" : data.list[0].BOAT_SLOT)+ '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00002' || data.list[0].SAMPLE_TYPE_CODE =='00008' || data.list[0].SAMPLE_TYPE_CODE =='00009'){
						detail_head_edit += '<tr><td>ชื่อเรือ</td><td class="text-center" ><input type="text" class="form-control" id="input-ltr-boat-name" value="'+(data.list[0].BOAT_NAME == null ? "" : data.list[0].BOAT_NAME)+ '"' + checkDisabled + '" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00010' || data.list[0].SAMPLE_TYPE_CODE =='00001' || data.list[0].SAMPLE_TYPE_CODE =='00003'){
						detail_head_edit += '<tr><td>เลขทะเบียนรถ</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-car-no" value="'+(data.list[0].CAR_NO == null ? "" : data.list[0].CAR_NO) + '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00010' || data.list[0].SAMPLE_TYPE_CODE =='00001' || data.list[0].SAMPLE_TYPE_CODE =='00003'){
						detail_head_edit += '<tr><td>ช่องรถ</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-car-slot" value="'+(data.list[0].CAR_SLOT == null ? "" : data.list[0].CAR_SLOT)+ '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00003'){
						detail_head_edit += '<tr><td>หมายเลขมิเตอร์</td><td class="text-center" ><input type="text" class="form-control" id="input-ltr-meter-no" value="'+(data.list[0].METER_NO == null ? "" : data.list[0].METER_NO)+ '"' + checkDisabled + '" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00010' || data.list[0].SAMPLE_TYPE_CODE =='00001' || data.list[0].SAMPLE_TYPE_CODE =='00003' || data.list[0].SAMPLE_TYPE_CODE =='00005' || data.list[0].SAMPLE_TYPE_CODE =='00004' || data.list[0].SAMPLE_TYPE_CODE =='00006' || data.list[0].SAMPLE_TYPE_CODE =='00007'){
						detail_head_edit += '<tr><td>ชื่อเจ้าหน้าที่เก็บตัวอย่าง</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-sample-staff-name" value="'+(data.list[0].SAMPLE_STAFF_NAME == null ? "" : data.list[0].SAMPLE_STAFF_NAME)+ '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}
					if(data.list[0].SAMPLE_TYPE_CODE =='00005' || data.list[0].SAMPLE_TYPE_CODE =='00007'){
						detail_head_edit += '<tr><td>สาเหตุ</td><td class="text-center"><input type="text" class="form-control" id="input-ltr-returnr-desc" value="'+(data.list[0].RETURNR_DESC == null ? "" : data.list[0].RETURNR_DESC)+ '"' + checkDisabled +'" style="cursor: default;"></tr>';
					}

				


					$("#sendSaveButtonHeader").html("อนุมัติ");
					$('#assiHead').html(detail_head_edit);
				if(data.list[0].PRODUCT_DESC!=''&&data.list[0].PRODUCT_DESC!=null){
				if(data.list[0].PDDESC_ID!='50'){
					$('#inputProductDesc').val(data.list[0].PDDESC_ID);
					$('#other_input').hide();
					$('#inputProductDesc').prop('disabled', 'disabled');
				}else {
					$('#inputProductDesc').val(data.list[0].PDDESC_ID);
					$('#inputProductDescOther').val(data.list[0].PRODUCT_DESC);
					$('#inputProductDesc').prop('disabled', 'disabled');
					$('#inputProductDescOther').prop('disabled', 'disabled');
				}
				}
				
           
            	HideWaiting() ;
            },
            error: function () {
                    showMsgError('เกิดข้อผิดพลาด');
                    HideWaiting() ;
            }
        });

    } catch (ex) {
        showMsgError(ex);
        HideWaiting() ;

    }
}
function setDataUML(){

	var ltrDtIdUML = "";
	var nameUML = "";
	var valueUML = "";
	var levelCodeUML = "";
	$.each(idLevelType,function(i,v){	
		//console.log(i+"|"+v);	
		ltrDtIdUML += "'"+v.split("|")[1]+"',";
		nameUML += "'"+v.split("|")[0].split("_")[1]+"',";
		valueUML += "'"+$("#"+v.split("|")[0]+"").val()+"',";
		levelCodeUML += "'"+v.split("|")[2]+"',";
	});
	ltrDtIdUML = ltrDtIdUML.substring(0,ltrDtIdUML.length-1);
	nameUML = nameUML.substring(0,nameUML.length-1);
	valueUML = valueUML.substring(0,valueUML.length-1);
	levelCodeUML = levelCodeUML.substring(0,levelCodeUML.length-1);

//	console.log(ltrDtIdUML);
//	console.log(nameUML);
//	console.log(valueUML);
//	console.log(levelCodeUML);
	
	//INSERT 
	saveInputDataUML(ltrDtIdUML,nameUML,valueUML,levelCodeUML);
}
function saveInputDataUML(ltrDtIdUML,nameUML,valueUML,levelCodeUML){
	 try {   
		 ShowWaiting();
		 var data = {}
		 data["ltrDtIdUML"] = ltrDtIdUML;
		 data["nameUML"] = nameUML;
		 data["valueUML"] = valueUML;
		 data["levelCodeUML"] = levelCodeUML; 
		 //console.log(JSON.stringify(data));
		  jQuery.ajax({
			url : 'insertLtrLevelCode',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
				//console.log(data.success);
				if(data.success=='1'){
					showMsgSuccess('บันทึกข้อมูลสำเร็จ');
					HideWaiting();
					//gotoMain();
				}else{
					showMsgError("เกิดข้อผิดพลาด");
					HideWaiting();
				}			
			},
			error : function(ex) {
				showMsgError(ex);
				HideWaiting();
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		HideWaiting();
		 
	}
}
function saveDataCOQ(chk){
	let dataTxUncer = [];
	for(var c=0;c<count.length;c++){
		//console.log(count[c]);
			if(count[c].split("|")[1]=="Color" || count[c].split("|")[1]=="Visual" || count[c].split("|")[1]=="Color  ASTM"){				
				if("COQ"==chk){
					dataTxUncer.push(""+"|"+count[c].split("|")[3]+"|"+count[c].split("|")[1]);
				}else{
					dataTxUncer.push($('#resultSelect'+c+'').val()+"|"+count[c].split("|")[3]+"|"+count[c].split("|")[1]);
				}
			}else{
				if("COQ"==chk){
					//console.log($('#resultUncer'+c+'').val());
					dataTxUncer.push($('#uncerTxT'+c+'').val()+"|"+count[c].split("|")[3]+"|"+count[c].split("|")[1]);
				}else{
					dataTxUncer.push($('#resultTxT'+c+'').val()+"|"+count[c].split("|")[3]+"|"+count[c].split("|")[1]);
				}
			}

	}
	return dataTxUncer;
}

function updateHeader(){
	var data = {}
	data["labCode"] = labCode;
	const getElementValue = (id) => {
	  const element = document.getElementById(id);
	  return element ? element.value : null;
	};
	data["carSlot"] = getElementValue("input-ltr-car-slot");
	data["carNo"] = getElementValue("input-ltr-car-no");
	data["sampleTypecDesc"] = getElementValue("input-ltr-sample-typec-desc");
	data["boatName"] = getElementValue("input-ltr-boat-name");
	data["boatSlot"] = getElementValue("input-ltr-boat-slot");
	data["shipmentNo"] = getElementValue("input-ltr-shipment-no");
	data["tankNo"] = getElementValue("input-ltr-tank-no");
	data["sampleStaffName"] = getElementValue("input-ltr-sample-staff-name");
	data["poNo"] = getElementValue("input-ltr-po-no");
	data["meterNo"] = getElementValue("input-ltr-meter-no");
	data["samplePointDesc"] = getElementValue("input-ltr-sample-point-desc");
	data["adtvLotNo"] = getElementValue("input-ltr-adtv-lot-no");
	data["pointSave"] = getElementValue("input-ltr-point-save");
	data["typeSationId"] = getElementValue("input-ltr-type-station-id");
	data["returnrDesc"] = getElementValue("input-ltr-returnr-desc");
	data["sampleLevelCode"] = getElementValue("input-ltr-sample-level-code");
	// Get the input element value in "DD/MM/YYYY" format
	var inputSampleDate = document.getElementById("input-sample-date").value;
	// Split the input date into day, month, and year parts
	var dateParts = inputSampleDate.split('/');
	var day = dateParts[0];
	var month = dateParts[1];
	var year = dateParts[2];

	// Create a new date string in "YYYY-MM-DD" format
	var convertedSampleDate = year + '-' + month + '-' + day;
	data["sampleDate"] = convertedSampleDate;

	console.log(data);

	try{
		jQuery.ajax({
			url : 'updateHeader',
			type : "Post",
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
				if(data.success=='1'){
					showMsgSuccess('บันทึกข้อมูลสำเร็จ');
				}else{
					showMsgError("เกิดข้อผิดพลาด");
					HideWaiting();
				}
			},
			error : function(ex) {
				showMsgError(ex);
				HideWaiting();
			}
		});

	} catch (ex) {
		showMsgError(ex);
		HideWaiting();
	}
}

function saveData(chk){
	//console.log("Save Data");
	//console.log(chk);
	var dataTx = [];
	for(var c=0;c<count.length;c++){
		//console.log(count[c]);
			if(count[c].split("|")[1]=="Color" || count[c].split("|")[1]=="Visual" || count[c].split("|")[1]=="Color  ASTM"){				
				if("COQ"==chk){
					dataTx.push(""+"|"+count[c].split("|")[3]+"|"+count[c].split("|")[1]);
				}else{
					dataTx.push($('#resultSelect'+c+'').val()+"|"+count[c].split("|")[3]+"|"+count[c].split("|")[1]);
				}
			}else{
				if("COQ"==chk){
					//console.log($('#resultUncer'+c+'').val());
					dataTx.push($('#uncerTxT'+c+'').val()+"|"+count[c].split("|")[3]+"|"+count[c].split("|")[1]);
				}else{
					dataTx.push($('#resultTxT'+c+'').val()+"|"+count[c].split("|")[3]+"|"+count[c].split("|")[1]);
				}
				
				//console.log($('#resultTxT'+c+'').val()+"|"+count[c].split("|")[3]);
			}

	}

	let dataTxUncer = saveDataCOQ("COQ");
	//RESULT
	var dataLTRdt = "",dataValue = "",dataType = "";
	for(var d=0;d<dataTx.length;d++){		
		if(biodiesel){
			if(dataTx[d].split("|")[0].indexOf(">")>-1){
				var biotext =dataTx[d].split("|")[0];
				
				biotext=Number(biotext.replace('>',''))+1
				dataValue += "'"+biotext+"',";
				
			}else if(dataTx[d].split("|")[0].indexOf("<")>-1){
				var dieseltext =dataTx[d].split("|")[0];
				dieseltext=Number(dieseltext.replace('<',''))-1
				dataValue += "'"+dieseltext+"',";
			}else{
				dataValue += "'"+dataTx[d].split("|")[0]+"',";
			}
			
		}else{
			dataValue += "'"+dataTx[d].split("|")[0]+"',";
		}
		
		dataLTRdt += "'"+dataTx[d].split("|")[1]+"',";
		dataType  += "'"+dataTx[d].split("|")[2]+"',";
	}
	
	dataValue = dataValue.substring(0,dataValue.length-1);
	dataLTRdt = dataLTRdt.substring(0,dataLTRdt.length-1);
	dataType = dataType.substring(0,dataType.length-1);
	//RESULT UNCER
	var dataLTRdtUN = "",dataValueUN = "",dataTypeUN = "";
	for(var d=0;d<dataTxUncer.length;d++){		
		dataValueUN += "'"+dataTxUncer[d].split("|")[0]+"',";
		dataLTRdtUN += "'"+dataTxUncer[d].split("|")[1]+"',";
		dataTypeUN  += "'"+dataTxUncer[d].split("|")[2]+"',";
	}

	dataValueUN = dataValueUN.substring(0,dataValueUN.length-1);
	dataLTRdtUN = dataLTRdtUN.substring(0,dataLTRdtUN.length-1);
	dataTypeUN = dataTypeUN.substring(0,dataTypeUN.length-1);



	if("COQ"==chk){
		updateResultUncer(dataLTRdtUN,dataValueUN);
		gotoMain();
	}else if("COQX"==chk){
		
		updateResultUncer(dataLTRdtUN,dataValueUN);
		if(userTypeSetText!='7'){
		saveInputData(dataValue,dataLTRdt,dataType);
		}
	}else{
		saveInputData(dataValue,dataLTRdt,dataType);
	}
	
	
}
function saveInputData(dataValue,dataLTRdt,dataType){
	 try {   
		 ShowWaiting();
		 var data = {}
		 //console.log(dataValue);
		 data["ltrResult"] = dataValue;
		 data["ltrdt"] = dataLTRdt;
		 data["dataType"] = dataType;
		 data["labCode"] = labCode;
		 data["ltrhd"] = str[1];
		 if(userTypeSetText!='7'){
		 data["comment"] = $("#commentTextarea").val();
		 }
		 data["url_wf"] = window.location.href;
		 //console.log(JSON.stringify(data));

		jQuery.ajax({
			url : 'insertLTRDTSub',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {

				if(userTypeSetText=='6'&&str[2]=="editWork"||userTypeSetText=='6'&&str[2]=="newWork"){
					updateLTRHDresult();
				}
				if(data.success=='1'){
					showMsgSuccess('บันทึกข้อมูลสำเร็จ');
					HideWaiting();
					gotoMain();
				}else{
					showMsgError("เกิดข้อผิดพลาด");
					HideWaiting();
				}			
			},
			error : function(ex) {
				showMsgError(ex);
				HideWaiting();
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		HideWaiting();
		 
	}
}
function setDropDownVisual(){
	 try {   		 
		 var data = {}
		  jQuery.ajax({
			url : 'util-getDropDownVisual',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : 'json',
			  async: false,
			  cache: false,
			success : function(data) {
				//console.log(data.length);
				for (var i = 0; i < data.length; i++) {	
					//console.log();
					visualID.push(data[i].CODE);
					visualName.push(data[i].NAME);
				}
			},
			error : function(ex) {
				showMsgError(ex);
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		 
	}
}
function setDropDownSetupColor(){
	 try {   		 
		 var data = {}
		  jQuery.ajax({
			url : 'util-getDropDownSetupColor',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : 'json',
			  async: false,
			   cache: false,
			success : function(data) {
				//console.log(data.length);
				for (var i = 0; i < data.length; i++) {	
					//console.log(data[i].ID);
					colorID.push(data[i].ID);
					colorName.push(data[i].COLOR_NAME);
				}
			},
			error : function(ex) {
				showMsgError(ex);
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		 
	}
}
function unique(value, index, self) { 
    return self.indexOf(value) === index;
}
function setDropDownSetupColorASTM(){
	 try {   		 
		 var data = {}
		  jQuery.ajax({
			url : 'util-getDropDownSetupColorASTM',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
				for (var i = 0; i < data.length; i++) {	
					//console.log(data[i].SPCR_ASTM_ID);
					colorASTMID.push(data[i].SPCR_ASTM_ID);
					colorASTMName.push(data[i].SPEC_TEXT);
					//console.log(data[i].SPEC_TEXT);
					/*if(!isNaN(parseInt(data[i].SPEC_TEXT))){
						colorASTMName.push(parseInt(data[i].SPEC_TEXT).toFixed(1));
					}else{
						colorASTMName.push(data[i].SPEC_TEXT);
					}
					console.log(colorASTMName);*/
					
				}

			},
			error : function(ex) {
				showMsgError(ex);
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		 
	}
}
function setDropDown(){
	for(var c=0;c<count.length;c++){
		//console.log(count[c]);
		if(count[c].split("|")[1]=="Color"){
			for(var ic=0;ic<colorID.length;ic++){
				//console.log(colorID[ic]+"|"+colorName[ic]);
				if(colorID[ic]!="99"&&colorID[ic]!="05"&&colorID[ic]!="06"){
					$('#resultSelect'+c+'').append('<option value="' + colorID[ic] + '">&nbsp;&nbsp;' + colorName[ic] + '</option>');
					$('#resultSelect'+c+'').select2({dropdownAutoWidth: true,width: 'auto'});
					if(count[c].split("|")[4]==colorName[ic]){
						$('#resultSelect'+c+'').val(colorID[ic]).change();
					}
				}
			}
		}
		if(count[c].split("|")[1]=="Color  ASTM"){
			for(var ics=0;ics<colorASTMID.length;ics++){
				//console.log(colorASTMID[ics]+"|"+colorASTMName[ics]);
				$('#resultSelect'+c+'').append('<option value="' + colorASTMID[ics] + '">&nbsp;&nbsp;' + colorASTMName[ics] + '</option>');
				$('#resultSelect'+c+'').select2({dropdownAutoWidth: true,width: 'auto'});
				if(count[c].split("|")[4]==colorASTMName[ics]){
					$('#resultSelect'+c+'').val(colorASTMID[ics]).change();
				}
			}
		}
		if(count[c].split("|")[1]=="Visual"){
			for(var iv=0;iv<visualID.length;iv++){
				//console.log(visualID[iv]+"|"+visualName[iv]);
				$('#resultSelect'+c+'').append('<option value="' + visualID[iv] + '">&nbsp;&nbsp;' + visualName[iv] + '</option>');
				$('#resultSelect'+c+'').select2({dropdownAutoWidth: true,width: 'auto'});
				if(count[c].split("|")[4]==visualName[iv]){
					$('#resultSelect'+c+'').val(visualID[iv]).change();
				}
			}
			
		}
	}
}
function getTaskListDetail(ltrcode,workType){
	//console.log(ltrcode+"|"+workType);
    biodiesel=false;
	defalutFlagTool =[]; 
	defalutFlagMethod =[];
	userdynamictool=[];
	getCheckUncer=[]
	var indexdynamic=0;
	var wordforremark='';
	var arr_method_cond=[];
	var arr_method_cond_obj;
	teamleadFlagTemp='';
	try {
		$('#assiDetialT').DataTable().destroy();
		$('#assiDetial').html("");
	    var data = {}
		var text_range='';
		var convert_str='';
		var getDynamicDropt=[];
		dataStore=[];
	    ShowWaiting();
	    data["ltrdt"]=ltrcode;
	    data["typeWork"] = workType;
	    jQuery.ajax({
	        url: 'getAssignWorkDetail',
	        type: "Post",
	        contentType: "application/json",
	        data: JSON.stringify(data),
	        dataType: 'json',
	        async: false,
	        cache: false,
	        success: function(data) {
					checkIRPC(data.list[0].LAB_CODE);
					if(userTypeSetText=='6' &&data.list[0].WF_STATUS=='09'){
						wf_status='00';
					}
	        		//ว่างๆ เดี๋ยวมาแก้โค้ดให้ --เกรท
	                var det = "";
	                tmp_data = data;
	                //console.log(data);
	                //labCode = data.list[0].LAB_CODE;
	                if(data.list != null){
						prod_desc = data.list[0].PRODUCT_DESC;
						    try {
							  pddesc_id=data.list[0].PDDESC_ID;
							}
							catch (exception_var) {
							  
							}
	                	
						
	                	for (var i = 0; i < data.list.length; i++) {
	                		arr_method_cond=[];
	                		labCode = data.list[i].LAB_CODE;
	                		det += '<tr  class="TBODY">';
	                		$(".select-Item").hide();
							text_range='';
	                		//console.log(data.list[i].LTR_DT_SUB_ID);
							if(i==0){
								wordforremark=data.list[i].REMARK==null?"":data.list[i].REMARK;
								$('#remark_a4').val(wordforremark);
							}
	                		if(teamleadFlagTemp==''&&data.list[i].FLG_TEMP=='Y'){
								teamleadFlagTemp=data.list[i].FLG_TEMP;
							}
	                		if(userTypeSetText == "7"&&str[2]=='newWork'|| userTypeSetText == "7"&&str[2]=='editWork' || userTypeSetText == "6"&&str[2]=='newWork'|| userTypeSetText == "6"&&str[2]=='editWork'){
							//if(false){	
							    tx_append.push(data.list[i].SPECBASICTEXT);
								det += '<td class="text-center r1" >' + text_range + '</td>';
	                			$(".select-Item").show();
	                			det += '<td class="text-center" ><input type="checkbox" name="chk" value="'+(data.list[i].LTR_DT_SUB_ID == null ? "" : data.list[i].LTR_DT_SUB_ID)+'"></td>';	

	                		}else if(userTypeSetText == "6"&&str[2]=='tempWork'){
							det += '<td class="text-center r1" >' + data.list[i].SPECBASICTEXT + '</td>';
							//det += '<td class="text-center r1" ></td>';
							}else if(userTypeSetText == "6"&&str[2]=='doneWork'){
							tx_append.push(data.list[i].SPECBASICTEXT);
								det += '<td class="text-center r1" >' + text_range + '</td>';
	                			//$(".select-Item").show();
							}else{
							det += '<td class="text-center" >' + (data.list[i].LTR_CODE == null ? "" : data.list[i].LTR_CODE) + '</td>';
							}
	                		
			                //det += '<td class="text-center" >' + (data.list[i].LTR_DT_ID == null ? "" : data.list[i].LTR_DT_ID) + '</td>';
							if(data.list[0].PRODUCT_ID=='100000001'||data.list[0].PRODUCT_ID=='100000006'||data.list[0].PRODUCT_ID=='100000007'||data.list[0].PRODUCT_ID=='100000009'){
								var wordingADO = (data.list[i].ITEM_NAME == null ? "" : data.list[i].ITEM_NAME);
								wordingADO=wordingADO.replace('evap.', 'recov.')
								 det += '<td class="text-center" >' + wordingADO + '</td>';
							}else{
								 det += '<td class="text-center" >' + (data.list[i].ITEM_NAME == null ? "" : data.list[i].ITEM_NAME) + '</td>';
							}
							
			               
							if(product_id==''){
						    product_id=data.list[i].PRODUCT_ID;
							sampletype_id=data.list[i].SAMPLE_LEVEL_CODE;
							}
			               
			               
			               
			                count.push(i+"|"+data.list[i].ITEM_NAME+"|"+data.list[i].IS_SPEC_RANGE+"|"+data.list[i].LTR_DT_ID+"|"+data.list[i].RESULT_TEXT+"|"+data.list[i].ITEM_ID);		 
			                //console.log(data.list[i].ITEM_NAME+"|"+data.list[i].ITEM_ID);
			                /*if(data.list[i].ITEM_ID=='0015'){
			                	
			                }*/
			                //console.log(data.list[i].FLG_INPUT_TYPE);
			                if(userTypeSetText !="7" && userTypeSetText !="6" && userTypeSetText !="5" && str[2] == "newWork"){
			                	//Enable
			                	if(data.list[i].FLG_INPUT_TYPE == "C" || data.list[i].FLG_INPUT_TYPE == "V" || data.list[i].FLG_INPUT_TYPE == "M"){
								    dataStore.push(data.list[i].LTR_CODE+"|resultSelect"+i+"|"+data.list[i].LTR_DT_ID);
				
			                		det += '<td class="text-center" ><select id="resultSelect'+i+'" ></select></td>';			                		
			                	}else if((data.list[i].FLG_INPUT_TYPE == "R" || data.list[i].FLG_INPUT_TYPE=='P' || data.list[i].FLG_INPUT_TYPE == "E")
										&&!("0011"==data.list[i].ITEM_ID || "0012"==data.list[i].ITEM_ID)
										){
										dataStore.push(data.list[i].LTR_CODE+"|resultTxT"+i+"|"+data.list[i].LTR_DT_ID);
										console.log(data.list[i]);
			                			det += '<td class="text-center" ><input type="text" class="form-control" id="resultTxT'+i+'" placeholder="'+
			                			(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].SPEC_BASIC_TEXT)+'"/></td>';

			                	}else if(data.list[i].FLG_INPUT_TYPE == "E" && "100000001"!=data.list[i].PRODUCT_ID 
			                			&& "100000006"!=data.list[i].PRODUCT_ID && "100000007"!=data.list[i].PRODUCT_ID && "100000009"!=data.list[i].PRODUCT_ID){
			                		det += '<td class="text-center" ><input type="text" class="form-control" id="resultTxT'+i+'" value="-" readonly="readonly"/></td>';
								dataStore.push(data.list[i].LTR_CODE+"|resultTxT"+i+"|"+data.list[i].LTR_DT_ID);
								console.log(data.list[i]);
			                	}else if(data.list[i].FLG_INPUT_TYPE == "Z"){
			                		det += '<td class="text-center" ><input type="text" class="form-control" id="resultTxT'+i+'" value="รอคำนวน" readonly="readonly"/></td>';
			                	}else{
			                		/*det += '<td class="text-center" ><input type="number" step=0.1 class="form-control" id="resultTxT'+i+'" placeholder="'+
			                		(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].SPEC_BASIC_TEXT)+'"/></td>';*/
			                		
			                		//เดี๋ยวมาทำต่อ ขอนอนก่อน วันอาทิตย์เจอกัน
			                		
			                		if("0011"==data.list[i].ITEM_ID || "0012"==data.list[i].ITEM_ID){
			                			var strLeveDesc = myTrim(data.list[i].SAMPLE_LEVEL_DESC);
			                			console.log(strLeveDesc);
			                			var sLevelDesc = '';
			                			//console.log(data.list[i]);
			                			//$(".umlType_0").append("AAA");
			                			/*$(".umlType_0").append('<input type="number" step=0.1 class="form-control" id="resultTxT'+i+'" placeholder="'+
				                		(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].SPEC_BASIC_TEXT)+'"/>');*/
			                			if("1"==strLeveDesc.split(",").length){
											dataStore.push(data.list[i].LTR_CODE+"|resultTxT"+i+"|"+data.list[i].LTR_DT_ID);
			                				sLevelDesc = '<input type="number" step=0.1 class="form-control" id="resultTxT'+i+'" placeholder="'+
					                		(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].SPEC_BASIC_TEXT)+'"/>';
										console.log(data.list[i]);
			                			}else{
			                				for(var ide=0;ide<strLeveDesc.split(",").length;ide++){
												
				                				//console.log(myTrim(strLeveDesc.split(",")[ide]));
				                				var lastLevelD = myTrim(strLeveDesc.split(",")[ide]);
				                				sLevelDesc += '<input type="number" step=0.1 class="form-control" id="resultTxT'+i+'_'+lastLevelD+'" placeholder="'+lastLevelD+'	'+
							                	'"/>';
				                				idLevelType.push('resultTxT'+i+'_'+lastLevelD+"|"+data.list[i].LTR_DT_ID+"|"+data.list[i].SAMPLE_LEVEL_CODE);
												dataStore.push(data.list[i].LTR_CODE+"|resultTxT"+i+"_"+lastLevelD+"|"+data.list[i].LTR_DT_ID);
				                			}
			                				sLevelDesc += '<input type="number" step=0.1 class="form-control" id="resultTxT'+i+'" placeholder="MIX"/>';
											dataStore.push(data.list[i].LTR_CODE+"|resultTxT"+i+"|"+data.list[i].LTR_DT_ID);
			                			}
			                			
			                			
			                			det +=  '<td class="text-center umlType_'+i+'" >'+sLevelDesc+'</td>';
			                			//sconsole.log(sLevelDesc);
			                			//det += '<td class="text-center" >'+sLevelDesc+'</td>';
			                			
			                		}else{
										if((data.list[i].ITEM_ID=='0010'||data.list[i].ITEM_ID=='0022')&&data.list[i].PRODUCT_ID=='100000041'
										||data.list[i].PRODUCT_CODE.indexOf('ADO')>-1
										||data.list[i].PRODUCT_CODE.indexOf('B20')>-1
										){
										biodiesel=true;
										 det += '<td class="text-center" ><input type="text"  class="form-control" id="resultTxT'+i+'" placeholder="'+
				                		(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].SPEC_BASIC_TEXT)+'"/></td>';
										}else{
			                			det += '<td class="text-center" ><input type="number" step=0.1 class="form-control" id="resultTxT'+i+'" placeholder="'+
				                		(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].SPEC_BASIC_TEXT)+'"/></td>';
										}

										dataStore.push(data.list[i].LTR_CODE+"|resultTxT"+i+"|"+data.list[i].LTR_DT_ID);
			                		}
			                		
			                		
			                	}
			                	
			                }else if(userTypeSetText !="7" && userTypeSetText !="5" && userTypeSetText !="6" && str[2] == "editWork"){
			                	
			                	if(data.list[i].FLG_INPUT_TYPE == "C" || data.list[i].FLG_INPUT_TYPE == "V" || data.list[i].FLG_INPUT_TYPE == "M"){
			                		det += '<td class="text-center" ><select id="resultSelect'+i+'" readonly="readonly"></select></td>';
			                	}else if(data.list[i].FLG_INPUT_TYPE == "R" || data.list[i].FLG_INPUT_TYPE=='P'){
			                		if("0016"==data.list[i].ITEM_ID){
			                			if(isNaN(data.list[i].RESULT_TEXT)){
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" /></td>';
			                			}else{
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_TEXT == null ? "" : (Math.round((data.list[i].RESULT_TEXT) * 100) / 100).toFixed(1))+'"  /></td>';
			                			}
		                				
		                			}else{
		                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
				                		(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" /></td>';
		                			}
			                	}else{
			                		console.log("bbb");
			                		//console.log(data.list[i].RESULT_TEXT);
			                		if(data.list[i].RESULT_TEXT == null || data.list[i].RESULT_TEXT == ''){
			                			//console.log("aaa");
			                			//ต้องแก้จุดทศนิยม
			                			if("0012"==data.list[i].ITEM_ID ){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100000) / 100000).toFixed(4))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                			}else if("0023"==data.list[i].ITEM_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100000) / 100000).toFixed(4))+'" /></td>';
			                			}else if("0013"==data.list[i].ITEM_ID || "0017"==data.list[i].ITEM_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 1000) / 1000).toFixed(3))+'"  /></td>';
			                			}else if("0016"==data.list[i].ITEM_ID || "0014"==data.list[i].TOOL_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM) +'"  /></td>';
			                			}else if("0014"==data.list[i].ITEM_ID){
											det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 1000) / 1000).toFixed(1)) +'"  /></td>';
										}else if("0018"==data.list[i].ITEM_ID){

											if(data.list[i].RESULT_NUM==7&&data.list[i].PRODUCT_ID=='100000009'){
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM).toFixed(1) +'"  /></td>';
			                				}else if(data.list[i].RESULT_NUM==7){
												det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM) +'"  /></td>';
											}else{
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                				}
			                			}else{
											if(("0010"==data.list[i].ITEM_ID||"0022"==data.list[i].ITEM_ID)&&data.list[i].PRODUCT_ID=='100000041'||data.list[i].PRODUCT_CODE.indexOf('ADO')>-1&&data.list[i].PRODUCT_ID=='100000041'
											||data.list[i].PRODUCT_CODE.indexOf('ADO')>-1
											||data.list[i].PRODUCT_CODE.indexOf('B20')>-1
											){
										    biodiesel=true;		
										    det += '<td class="text-center" ><input type="text"  class="form-control text-center" id="resultTxT'+i+'" value="'+(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'"  /></td>';
											}else{
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                			}
										}
			                		}else{   
			                			//console.log("cccc");
			                			if(data.list[i].FLG_INPUT_TYPE == "E" || data.list[i].FLG_INPUT_TYPE == "Z"){
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
				                			(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" readonly="readonly"/></td>';
			                			}else{
			                				//console.log("ssss");
			                				/*det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
				                			(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" /></td>';*/
			                				if("0011"==data.list[i].ITEM_ID || "0012"==data.list[i].ITEM_ID){
					                			var strLeveDesc = myTrim(data.list[i].SAMPLE_LEVEL_DESC);
					                			console.log(strLeveDesc);
					                			var sLevelDesc = '';
					                			//console.log(data.list[i]);
					                			//$(".umlType_0").append("AAA");
					                			/*$(".umlType_0").append('<input type="number" step=0.1 class="form-control" id="resultTxT'+i+'" placeholder="'+
						                		(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].SPEC_BASIC_TEXT)+'"/>');*/
					                			if("1"==strLeveDesc.split(",").length){
					                				sLevelDesc = '<input type="number" step=0.1 class="form-control" id="resultTxT'+i+'" placeholder="'+
							                		(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].SPEC_BASIC_TEXT)+'"/>';
					                			}else{
					                				for(var ide=0;ide<strLeveDesc.split(",").length;ide++){
						                				//console.log(myTrim(strLeveDesc.split(",")[ide]));
						                				var lastLevelD = myTrim(strLeveDesc.split(",")[ide]);
						                				sLevelDesc += '<input type="number" step=0.1 class="form-control" id="resultTxT'+i+'_'+lastLevelD+'" placeholder="'+lastLevelD+'	'+
									                	'"/>';
						                				idLevelType.push('resultTxT'+i+'_'+lastLevelD+"|"+data.list[i].LTR_DT_ID+"|"+data.list[i].SAMPLE_LEVEL_CODE);
						                			}
					                				sLevelDesc += '<input type="number" step=0.1 class="form-control" id="resultTxT'+i+'" placeholder="MIX"/>';
					                			}
					                			
					                			
					                			det +=  '<td class="text-center umlType_'+i+'" >'+sLevelDesc+'</td>';
					                			//sconsole.log(sLevelDesc);
					                			//det += '<td class="text-center" >'+sLevelDesc+'</td>';
					                			
					                		}else{
												var txtresult = (data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT);
												if((data.list[i].ITEM_ID=='0010'||data.list[i].ITEM_ID=='0022')&&'100000041'==data.list[i].PRODUCT_ID){
													biodiesel=true;
						                       det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+txtresult+'" /></td>';
												}else{
												det += '<td class="text-center" ><input type="number" step=0.1 class="form-control" id="resultTxT'+i+'" placeholder="'+
						                		(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].SPEC_BASIC_TEXT)+'"/></td>';
												}
					                			
					                		}
			                							
			                			}
			                			
			                		}        		
			                	}	
			                }else if(userTypeSetText =="6" && str[2] == "editWork"){
			                	
			                	if(data.list[i].FLG_INPUT_TYPE == "C" || data.list[i].FLG_INPUT_TYPE == "V" || data.list[i].FLG_INPUT_TYPE == "M"){
			                		det += '<td class="text-center" ><select id="resultSelect'+i+'" readonly="readonly"></select></td>';
			                	}else if(data.list[i].FLG_INPUT_TYPE == "R" || data.list[i].FLG_INPUT_TYPE=='P'){
			                		if("0016"==data.list[i].ITEM_ID){
			                			if(isNaN(data.list[i].RESULT_TEXT)){
				
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" /></td>';
			                			}else{
											var txtResult ='';
											if(data.list[i].RESULT_TEXT.length>0&&data.list[i].RESULT_TEXT.indexOf('.')>-1){
												txtResult=(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT.split('.')[0])
											}else{
												txtResult=(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)
											}
//			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
//					                		(data.list[i].RESULT_TEXT == null ? "" : (Math.round((data.list[i].RESULT_TEXT) * 100) / 100).toFixed(1))+'"  /></td>';
										     det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		txtResult+'" /></td>';
			                			}
		                				
		                			}else{
		                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
				                		(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" /></td>';
		                			}
			                	}else{
			                		console.log("bbb");
			                		//console.log(data.list[i].RESULT_TEXT);
			                		if(data.list[i].RESULT_TEXT == null || data.list[i].RESULT_TEXT == ''){
			                			//console.log("aaa");
			                			//ต้องแก้จุดทศนิยม
			                			if("0012"==data.list[i].ITEM_ID ){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100000) / 100000).toFixed(4))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                			}else if("0023"==data.list[i].ITEM_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100000) / 100000).toFixed(4))+'" /></td>';
			                			}else if("0013"==data.list[i].ITEM_ID || "0017"==data.list[i].ITEM_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 1000) / 1000).toFixed(3))+'"  /></td>';
			                			}else if( "0016"==data.list[i].ITEM_ID || "0014"==data.list[i].TOOL_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM) +'"  /></td>';
			                			}else if("0014"==data.list[i].ITEM_ID ){
											det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 1000) / 1000).toFixed(1)) +'"  /></td>';
										}else if("0018"==data.list[i].ITEM_ID){
											if(data.list[i].RESULT_NUM==7&&data.list[i].PRODUCT_ID=='100000009'){
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM).toFixed(1) +'"  /></td>';
			                				}else if(data.list[i].RESULT_NUM==7){
												det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM) +'"  /></td>';
											}else{
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                				}
			                			}else if(("0010"==data.list[i].ITEM_ID||"0022"==data.list[i].ITEM_ID)&&data.list[i].PRODUCT_ID=='100000041'
										||data.list[i].PRODUCT_CODE.indexOf('ADO')>-1&&"0010"==data.list[i].ITEM_ID
										||data.list[i].PRODUCT_CODE.indexOf('B20')>-1
										){
			                			biodiesel=true;		

											// if check index
											var resultN ='';
											if(data.list[i].RESULT_TEXT != null &&data.list[i].RESULT_TEXT != ''&&(data.list[i].RESULT_TEXT.indexOf('>')>-1||data.list[i].RESULT_TEXT.indexOf('<')>-1)){
												resultN=data.list[i].RESULT_TEXT;
											}else{
												resultN=(Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1);
											}
											
										    det += '<td class="text-center" ><input type="text"  class="form-control text-center" id="resultTxT'+i+'" value="'+resultN+'"  /></td>';
			                			}else{
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                			}
			                		}else{   
			                			//console.log("cccc");
			                			if(data.list[i].FLG_INPUT_TYPE == "E" || data.list[i].FLG_INPUT_TYPE == "Z"){
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
				                			(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" readonly="readonly"/></td>';
			                			}else if(("0010"==data.list[i].ITEM_ID||"0022"==data.list[i].ITEM_ID)&&data.list[i].PRODUCT_ID=='100000041'
										||data.list[i].PRODUCT_CODE.indexOf('ADO')>-1&&"0010"==data.list[i].ITEM_ID
										||data.list[i].PRODUCT_CODE.indexOf('B20')>-1
										){
			                			biodiesel=true;		
										det += '<td class="text-center" ><input type="text"  class="form-control text-center" id="resultTxT'+i+'" value="'+(data.list[i].RESULT_TEXT == null ||data.list[i].RESULT_TEXT == ''  ? data.list[i].RESULT_NUM : data.list[i].RESULT_TEXT)+'"  /></td>';
			                			}else{
											
											det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].SPEC_BASIC_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'"/></td>';	
			                							
			                			}		                			
			                		}        		
			                	}	
			                }else{
								//edit 23122021
								if(userTypeSetText =="6" && str[2] == "newWork"&&data.list[i].FLG_TEMP=='Y'){
										if(data.list[i].FLG_INPUT_TYPE == "C" || data.list[i].FLG_INPUT_TYPE == "V" || data.list[i].FLG_INPUT_TYPE == "M"){
			                		det += '<td class="text-center" ><select id="resultSelect'+i+'" ></select></td>';			                		
			                	}else if(data.list[i].FLG_INPUT_TYPE == "R" || data.list[i].FLG_INPUT_TYPE=='P'){
			                		if("0016"==data.list[i].ITEM_ID){
			                			if(isNaN(data.list[i].RESULT_TEXT)){
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" /></td>';
			                			}else{
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_TEXT == null ? "" : (Math.round((data.list[i].RESULT_TEXT) * 1) / 1).toFixed(0))+'"  /></td>';
			                			}
		                				
		                			}else{
										if((data.list[i].PRODUCT_ID=='100000002'||data.list[i].PRODUCT_ID=='100000003'||data.list[i].PRODUCT_ID=='100000005'||data.list[i].PRODUCT_ID=='100000008')&&data.list[i].SAMPLE_TYPE=='00004'&&data.list[i].ITEM_ID=='0012'){
 												det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		    (data.list[i].RESULT_NUM == null ? "" : (parseFloat(data.list[i].RESULT_TEXT)).toFixed(4))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
										}else{					
//										det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
//				                		(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" readonly="readonly"/></td>';

											var txt = (data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT);  
											var txtresult = '';  
											if(txt.indexOf('.')>-1&&'0022'==data.list[i].ITEM_ID){
												txtresult=txt.split('.')[0];
											} else{
												txtresult=(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT);
											}          				
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+txtresult
				                			+'" /></td>';
										
										}
		                				

		                			}
			                		
			                	}else{
			                		//console.log(data.list[i].RESULT_TEXT);
			                		if(data.list[i].RESULT_TEXT == null || data.list[i].RESULT_TEXT == ''){
			                			console.log(data.list[i])
			                			//ต้องแก้จุดทศนิยม
			                			if("0012"==data.list[i].ITEM_ID){
			                				//console.log(data.list[i].RESULT_NUM);
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100000) / 100000).toFixed(4))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                			}else if("0023"==data.list[i].ITEM_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100000) / 100000).toFixed(4))+'" /></td>';
			                			}else if("0013"==data.list[i].ITEM_ID || "0017"==data.list[i].ITEM_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 1000) / 1000).toFixed(3))+'"  /></td>';
			                			}else if("0016"==data.list[i].ITEM_ID || "0014"==data.list[i].TOOL_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
			                				(data.list[i].RESULT_NUM == null ? "" :  (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(0))+'"  /></td>';
			                			}else if("0014"==data.list[i].ITEM_ID ){
											det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
			                				(data.list[i].RESULT_NUM == null ? "" :  (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'"  /></td>';
										}else if("0018"==data.list[i].ITEM_ID){
			                				if(data.list[i].RESULT_NUM==7&&data.list[i].PRODUCT_ID=='100000009'){
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM).toFixed(1) +'" readonly="readonly" /></td>';
			                				}else if(data.list[i].RESULT_NUM==7){
												det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM) +'"  /></td>';
											}else{
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                				}
			                			}else if("0010"==data.list[i].ITEM_ID){
			                				if(data.list[i].RESULT_NUM==9||data.list[i].RESULT_NUM==39){
			                					det += '<td class="text-center" ><input type="text"  class="form-control text-center" id="resultTxT'+i+'" value="<'+(data.list[i].RESULT_NUM+1)+'.0"  /></td>';
			                				}else{
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                				}
			                			}else{
			                				    det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		    (data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'"  /><label>'+data.list[i].resultUML+'</label></td>';
			                			}			                			
			                		}else{      
			                			
			                			if(data.list[i].FLG_INPUT_TYPE == "E" ){
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
				                			(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" /></td>';
			                			}else{	
											//var txt = (data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT);  
											var txtresult = '';  
//											if(txt.indexOf('.')>-1&&'0022'==data.list[i].ITEM_ID){
//												txtresult=txt.split('.')[0];
//											}  else{
												txtresult=(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT);
//											}          				
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+txtresult
				                			+'" /></td>';
			            		            
			                				
			                			}
			                			
			                		}        		
			                	}
								}else{
									
								
			                	//Disable
			                	//console.log(data.list[i].RESULT_TEXT);
		                		if(data.list[i].FLG_INPUT_TYPE == "C" || data.list[i].FLG_INPUT_TYPE == "V" || data.list[i].FLG_INPUT_TYPE == "M"){
			                		det += '<td class="text-center" ><select id="resultSelect'+i+'" disabled></select></td>';			                		
			                	}else if(data.list[i].FLG_INPUT_TYPE == "R" || data.list[i].FLG_INPUT_TYPE=='P'){
			                		if("0016"==data.list[i].ITEM_ID){
			                			if(isNaN(data.list[i].RESULT_TEXT)){
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" readonly="readonly"/></td>';
			                			}else{
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_TEXT == null ? "" : (Math.round((data.list[i].RESULT_TEXT) * 1) / 1).toFixed(0))+'" readonly="readonly" /></td>';
			                			}
		                				
		                			}else{
										if((data.list[i].PRODUCT_ID=='100000002'||data.list[i].PRODUCT_ID=='100000003'||data.list[i].PRODUCT_ID=='100000005'||data.list[i].PRODUCT_ID=='100000008')&&data.list[i].SAMPLE_TYPE=='00004'&&data.list[i].ITEM_ID=='0012'){
 												det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		    (data.list[i].RESULT_NUM == null ? "" : (parseFloat(data.list[i].RESULT_TEXT)).toFixed(4))+'" readonly="readonly" /><label>'+data.list[i].resultUML+'</label></td>';
										}else{					
//										det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
//				                		(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" readonly="readonly"/></td>';

											var txt = (data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT);  
											var txtresult = '';  
											if(txt.indexOf('.')>-1&&'0022'==data.list[i].ITEM_ID){
												txtresult=txt.split('.')[0];
											} else{
												txtresult=(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT);
											}          				
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+txtresult
				                			+'" readonly="readonly"/></td>';
										
										}
		                				

		                			}
			                		
			                	}else{
			                		//console.log(data.list[i].RESULT_TEXT);
			                		if(data.list[i].RESULT_TEXT == null || data.list[i].RESULT_TEXT == ''){
			                			console.log(data.list[i])
			                			//ต้องแก้จุดทศนิยม
			                			if("0012"==data.list[i].ITEM_ID){
			                				//console.log(data.list[i].RESULT_NUM);
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100000) / 100000).toFixed(4))+'" readonly="readonly" /><label>'+data.list[i].resultUML+'</label></td>';
			                			}else if("0023"==data.list[i].ITEM_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100000) / 100000).toFixed(4))+'" readonly="readonly" /></td>';
			                			}else if("0013"==data.list[i].ITEM_ID || "0017"==data.list[i].ITEM_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 1000) / 1000).toFixed(3))+'" readonly="readonly" /></td>';
			                			}else if("0016"==data.list[i].ITEM_ID || "0014"==data.list[i].TOOL_ID){
			                				det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
			                				(data.list[i].RESULT_NUM == null ? "" :  (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(0))+'" readonly="readonly" /></td>';
			                			}else if("0014"==data.list[i].ITEM_ID ){
											det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
			                				(data.list[i].RESULT_NUM == null ? "" :  (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'" readonly="readonly" /></td>';
										}else if("0018"==data.list[i].ITEM_ID){
			                				if(data.list[i].RESULT_NUM==7&&data.list[i].PRODUCT_ID=='100000009'){
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM).toFixed(1) +'" readonly="readonly" /></td>';
			                				}else if(data.list[i].RESULT_NUM==7){
												det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : data.list[i].RESULT_NUM) +'" readonly="readonly" /></td>';
											}else{
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'" readonly="readonly" /><label>'+data.list[i].resultUML+'</label></td>';
			                				}
			                			}else if("0010"==data.list[i].ITEM_ID){
			                				if(data.list[i].RESULT_NUM==9||data.list[i].RESULT_NUM==39){
			                					det += '<td class="text-center" ><input type="text"  class="form-control text-center" id="resultTxT'+i+'" value="<'+(data.list[i].RESULT_NUM+1)+'.0" readonly="readonly" /></td>';
			                				}else{
			                					det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
						                		(data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'" readonly="readonly" /><label>'+data.list[i].resultUML+'</label></td>';
			                				}
			                			}else{
			                				    det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="resultTxT'+i+'" value="'+
					                		    (data.list[i].RESULT_NUM == null ? "" : (Math.round((data.list[i].RESULT_NUM) * 100) / 100).toFixed(1))+'" readonly="readonly" /><label>'+data.list[i].resultUML+'</label></td>';
			                			}			                			
			                		}else{      
			                			
			                			if(data.list[i].FLG_INPUT_TYPE == "E" ){
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+
				                			(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT)+'" readonly="readonly"/></td>';
			                			}else{	
											//var txt = (data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT);  
											var txtresult = '';  
//											if(txt.indexOf('.')>-1&&'0022'==data.list[i].ITEM_ID){
//												txtresult=txt.split('.')[0];
//											}  else{
												txtresult=(data.list[i].RESULT_TEXT == null ? "" : data.list[i].RESULT_TEXT);
//											}          				
			                				det += '<td class="text-center" ><input type="text" class="form-control text-center" id="resultTxT'+i+'" value="'+txtresult
				                			+'" readonly="readonly"/></td>';
			            		            
			                				
			                			}
			                			
			                		}        		
			                	}}//end else		                	
			                }
			                if(userTypeSetText > 7 && str[2] == "newWork"){
								if(statusIRPC=='00'){
								var res_flag=''
								var res_flag_uncer=''
								if('00003'==data.list[i].SAMPLE_TYPE
								||(data.list[i].ITEM_ID!='0010'&&data.list[i].ITEM_ID!='0013'
								&&((data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG)=='ผ่านแบบมีเงื่อนไข'||(data.list[i].RESULT_FLAG_UNCER == null ? "" : data.list[i].RESULT_FLAG_UNCER)=='ผ่านแบบมีเงื่อนไข'))
								){
									res_flag=(data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG)
									res_flag_uncer=(data.list[i].RESULT_FLAG_UNCER == null ? "-" : data.list[i].RESULT_FLAG_UNCER)
									res_flag=res_flag=='ผ่านแบบมีเงื่อนไข'?'ผ่าน':res_flag
									res_flag_uncer=res_flag_uncer=='ผ่านแบบมีเงื่อนไข'?'ผ่าน':res_flag_uncer
								}else{
									res_flag=(data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG)
									res_flag_uncer=(data.list[i].RESULT_FLAG_UNCER == null ? "-" : data.list[i].RESULT_FLAG_UNCER)
								}
			                	det += '<td class="text-center" >' + res_flag + '</td>';
			                	det += '<td class="text-center" >'+res_flag_uncer+'</td>';
								}else{
								det += '<td class="text-center" >' + (data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG) + '</td>';
			                	det += '<td class="text-center" >'+(data.list[i].RESULT_FLAG_UNCER == null ? "-" : data.list[i].RESULT_FLAG_UNCER)+'</td>';	
								}

			                	det += '<td class="text-center" ><input id="switchRandom" type="checkbox" data-toggle="toggle" data-size="small" disabled="disabled"></td>';
			                	det += '<td class="text-center" ><input type="number" step=0.1 class="form-control" readonly="readonly" value="'+(data.list[i].RESULT_UNCER2 == null ? "" : data.list[i].RESULT_UNCER2)+'" /></td>';
			                }else if(userTypeSetText=="7" && str[2] == "newWork" || str[2] == "editWork"||(userTypeSetText=="6" && str[2] == "newWork"&&data.list[i].FLG_TEMP=='Y')){
								
								if(statusIRPC=='00'){
								var res_flag=''
								var res_flag_uncer=''
								if('00003'==data.list[i].SAMPLE_TYPE
								||(data.list[i].ITEM_ID!='0010'&&data.list[i].ITEM_ID!='0013'
								&&((data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG)=='ผ่านแบบมีเงื่อนไข'||(data.list[i].RESULT_FLAG_UNCER == null ? "" : data.list[i].RESULT_FLAG_UNCER)=='ผ่านแบบมีเงื่อนไข'))
								){
									res_flag=(data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG)
									res_flag_uncer=(data.list[i].RESULT_FLAG_UNCER == null ? "" : data.list[i].RESULT_FLAG_UNCER)
									res_flag=res_flag=='ผ่านแบบมีเงื่อนไข'?'ผ่าน':res_flag
									res_flag_uncer=res_flag_uncer=='ผ่านแบบมีเงื่อนไข'?'ผ่าน':res_flag_uncer
								}else{
									res_flag=(data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG)
									res_flag_uncer=(data.list[i].RESULT_FLAG_UNCER == null ? "" : data.list[i].RESULT_FLAG_UNCER)
								}
			                	det += '<td class="text-center" >' + res_flag + '</td>';
			                	det += '<td class="text-center" >'+res_flag_uncer+'</td>';
								}else{
								det += '<td class="text-center" >' + (data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG) + '</td>';
			                	det += '<td class="text-center" >'+(data.list[i].RESULT_FLAG_UNCER == null ? "" : data.list[i].RESULT_FLAG_UNCER)+'</td>';	
								}

								det += '<td class="text-center" ><input id="switchUncer'+i+'" type="checkbox" onchange="switchUncer(this)" data-toggle="toggle" data-size="small" ></td>';
			                	

								//แก้จุดนี้
								if(statusIRPC=='00'){
								if((data.list[i].FLAG_UNCER_STATUS == 'U')
								&&(data.list[i].ITEM_ID=='0010'
								||data.list[i].ITEM_ID=='0013')
								&&'100000041'!=data.list[i].PRODUCT_ID
								&&'100000031'!=data.list[i].PRODUCT_ID
								&&'100000032'!=data.list[i].PRODUCT_ID
								&&'00003'!=data.list[i].SAMPLE_TYPE
								){
									
								getCheckUncer.push("uncerTxT"+i);

									det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="uncerTxT'+i+'" value="'+(data.list[i].SPEC_UNCER2 == null ? "" : data.list[i].SPEC_UNCER2)+'" disabled="disabled"/></td>';
								
								
								}else{
								det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="uncerTxT'+i+'" disabled="disabled"/></td>';	
								}	
								}
								else{
									
									
								if((data.list[i].FLAG_UNCER_STATUS == 'N' || data.list[i].FLAG_UNCER_STATUS == 'U')
								&&data.list[i].ITEM_ID!='0001'
								&&data.list[i].ITEM_ID!='0002'
								&&data.list[i].ITEM_ID!='0003'
								&&data.list[i].ITEM_ID!='0004'
								&&data.list[i].ITEM_ID!='0015'
								&&data.list[i].ITEM_ID!='0020'
								&&data.list[i].ITEM_ID!='0009'
								&&'100000041'!=data.list[i].PRODUCT_ID
								){
										getCheckUncer.push("uncerTxT"+i);

										det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="uncerTxT'+i+'" value="'+(data.list[i].SPEC_UNCER2 == null ? "" : data.list[i].SPEC_UNCER2)+'" disabled="disabled"/></td>';
										
										
								}else{
										det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" id="uncerTxT'+i+'" disabled="disabled"/></td>';	
								}
							}

			                }else{
								if(statusIRPC=='00'){
								var res_flag=''
								var res_flag_uncer=''
								if('00003'==data.list[i].SAMPLE_TYPE
								||(data.list[i].ITEM_ID!='0010'&&data.list[i].ITEM_ID!='0013'
								&&((data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG)=='ผ่านแบบมีเงื่อนไข'||(data.list[i].RESULT_FLAG_UNCER == null ? "" : data.list[i].RESULT_FLAG_UNCER)=='ผ่านแบบมีเงื่อนไข'))
								){
									res_flag=(data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG)
									res_flag_uncer=(data.list[i].RESULT_FLAG_UNCER == null ? "" : data.list[i].RESULT_FLAG_UNCER)
									res_flag=res_flag=='ผ่านแบบมีเงื่อนไข'?'ผ่าน':res_flag
									res_flag_uncer=res_flag_uncer=='ผ่านแบบมีเงื่อนไข'?'ผ่าน':res_flag_uncer
								}
								else{
									res_flag=(data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG)
									res_flag_uncer=(data.list[i].RESULT_FLAG_UNCER == null ? "" : data.list[i].RESULT_FLAG_UNCER)
								}
			                	det += '<td class="text-center" >' + res_flag + '</td>';
			                	det += '<td class="text-center" >'+res_flag_uncer+'</td>';
								}else{
								det += '<td class="text-center" >' + (data.list[i].RESULT_FLAG == null || data.list[i].RESULT_FLAG == "" ? "-" : data.list[i].RESULT_FLAG) + '</td>';
			                	det += '<td class="text-center" >'+(data.list[i].RESULT_FLAG_UNCER == null ? "" : data.list[i].RESULT_FLAG_UNCER)+'</td>';	
								}
								
								det += '<td class="text-center" ><input id="switchUncer'+i+'" type="checkbox" onchange="switchUncer(this)" data-toggle="toggle" data-size="small" disabled="disabled"></td>';
								if(userTypeSetText == "6"&&str[2]=='tempWork'){
									det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" readonly="readonly" value="'+(data.list[i].RESULT_UNCER == null ? '' : data.list[i].RESULT_UNCER)+'" /></td>';
								}else{
									det += '<td class="text-center" ><input type="number" step=0.1 class="form-control text-center" readonly="readonly" value="'+(data.list[i].RESULT_UNCER == null ? data.list[i].SPEC_UNCER2 : data.list[i].RESULT_UNCER)+'" /></td>';
								}
			                	
			                }
			                
			               // det += '<td class="text-center" >' + (data.list[i].METHOD_NAME == null ? "" : data.list[i].METHOD_NAME) + '</td>';
							if(data.list[i].IS_ENABLE_TOOLS=='Y'&&userTypeSetText=='8'){
								
								arr_method_cond_obj=getSpecToolFromItemmp(data.list[i].ITEMMP_ID);
								//METHOD 
								
								 det += '<td class="text-center" >';
								 det += '<select class="form-control" id="dynamicmethod_'+indexdynamic+'" >';
								 for(var l=0;l<arr_method_cond_obj.length;l++){
									if(arr_method_cond_obj[l].METHOD_NAME==data.list[i].METHOD_NAME){
										defalutFlagMethod.push(arr_method_cond_obj[l].METHOD_ID);
									}
										det += '<option value="'+arr_method_cond_obj[l].METHOD_ID+'">'+arr_method_cond_obj[l].METHOD_NAME+'</option>';
									}
								 det += '</select >';	
								 det += '</td>';
								
								getDynamicDropt=getDynamicToolId(data.list[i].ITEMMP_ID)
								
								
								
								//TOOL
								 det += '<td class="text-center" >';
								 det += '<select class="form-control" id="dynamictool_'+indexdynamic+'" >';
					
								
								
//							 	for(var j=0;j<arr_method_cond_obj.length;j++){
//								arr_method_cond.push(arr_method_cond_obj[j].METHOD_ID);
//								}

								     for(var l=0;l<getDynamicDropt.length;l++){
		 								     if(getDynamicDropt[l].TOOL_NAME==data.list[i].TOOL_NAME){
												defalutFlagTool.push(getDynamicDropt[l].TOOL_ID);
											 }
									det += '<option value="'+getDynamicDropt[l].TOOL_ID+'">'+getDynamicDropt[l].TOOL_NAME+'</option>';
									}
															
									
								userdynamictool.push(data.list[i].LTR_DT_ID);
								 det += '</select >';	
								 det += '</td>';
							++indexdynamic;
							}else{
								 det += '<td class="text-center" >' + (data.list[i].METHOD_NAME == null ? "" : data.list[i].METHOD_NAME) + '</td>';
								 det += '<td class="text-center" >' + (data.list[i].TOOL_NAME == null ? "" : data.list[i].TOOL_NAME) + '</td>';
							}
			              
			                det += '<td class="text-center" >' + (data.list[i].PRODUCT_NAME == null ? "" : data.list[i].PRODUCT_NAME) + '</td>';
			                det += '<td class="text-center" >' + (data.list[i].USER_TYPE_DTL == null ? "" : data.list[i].USER_TYPE_DTL) + '</td>';
			                
			                det +='</tr>';   
			                //$("#switchUncer"+i).bootstrapToggle('off');
	                	}
	                }else{
	                	det = '';
	                }

					if(userTypeSetText == "7" || userTypeSetText == "6" ){
	                			
								$('#num_assiDetialT').text('Spec');
								$("#div_for_lead").show();
								$('#ltr_num_forlead').text((data.list[0].LTR_CODE == null ? "" : data.list[0].LTR_CODE));
	                }
	                
	                if (det == '') {
	                    det += '<tr> ';
	                    det += '<th colspan="23" class="text-center">--- ไม่พบข้อมูล ---</th> ';
	                    det += '</tr> ';
	                    $('#assiDetial').html(det);
	                    HideWaiting();
	                } else {
	                    $('#assiDetial').html(det);
	                    HideWaiting();

	                }	
             
					if(userTypeSetText == "6"&&str[2]=='doneWork'){
							var list = document.getElementsByClassName('r1');
							var n;
							for (n = 0; n < list.length; ++n) {
				    		list[n].textContent =tx_append[n];
							}		
					}

	                if(str[2]=='editWork' || str[2]=='newWork'){
	                	table = $('#assiDetialT').DataTable({
		                    searching: true,
		                    //responsive: true,
						
          					"orderable": false,
		                    "pageLength": 50,
		                    "paging":   false
		                });
	                }else{
	                	table = $('#assiDetialT').DataTable({
		                    searching: true,
							"orderable": false,
		                    //responsive: true,
		                });
	                }

					if(userTypeSetText == "7"&&str[2]=='newWork'|| userTypeSetText == "7"&&str[2]=='editWork' || userTypeSetText == "6"&&str[2]=='newWork'|| userTypeSetText == "6"&&str[2]=='editWork'   ){
							var list = document.getElementsByClassName('r1');
							var n;
							for (n = 0; n < list.length; ++n) {
				    		list[n].textContent =tx_append[n];
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
function getSpecToolFromItemmp(val){
	var res;
	var json ={};
			json['methodDataAss']=val;
			  jQuery.ajax({
			url : 'util-getmethodcondition',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(json),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
				res=data;
			
			},
			error : function(ex) {
				showMsgError(ex);
			}
	});
	return res;
}
function initDropdownToolId(){
			
			for(var r =0;r<defalutFlagTool.length;r++){
				$('#dynamictool_'+r).val(defalutFlagTool[r]);
				$('#dynamictool_'+r).trigger('change');
			}
			for(var r =0;r<defalutFlagMethod.length;r++){
				$('#dynamicmethod_'+r).val(defalutFlagMethod[r]);
				$('#dynamicmethod_'+r).trigger('change');
			}
		
}
function updateDynamicToolId(){
	
	var itemmparr=''; 
	var ltrdtarr='';
	var methodDataAss='';
	var subtxt ;
	var subtxt2 ;
	for(var r =0;r<defalutFlagTool.length;r++){
			subtxt=$('#dynamictool_'+r).val();
			subtxt2=$('#dynamicmethod_'+r).val();
			itemmparr+=subtxt+',';
			methodDataAss+=subtxt2 +',';
			ltrdtarr+=userdynamictool[r]+','
			
	}

	itemmparr=itemmparr.substring(0,itemmparr.length-1);
	ltrdtarr=ltrdtarr.substring(0,ltrdtarr.length-1);
	methodDataAss=methodDataAss.substring(0,methodDataAss.length-1);
	var json = {};

		  json['itemMpDataAss']=itemmparr;
		  json['methodDataAss']=methodDataAss;
		  json['ltrdt']=str[1];
		  json['ltrDtID']=ltrdtarr;
		  json['productID']=product_id;
		  json['sampleType']=sampletype_id;
		  jQuery.ajax({
			url : 'util-updateDynamicToolId',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(json),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
			
			},
			error : function(ex) {
				showMsgError(ex);
			}
	});
}

function getDynamicToolId(data){
	var res=[];
		var json = {};
		  json['itemmp_id']=data;
		  jQuery.ajax({
			url : 'util-geteditdropdown',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(json),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
			res=data;
			},
			error : function(ex) {
				showMsgError(ex);
			}
		});
		return res;
}
function switchUncer(item){
	var id = item.id.split("switchUncer")[1];
	if($(item).prop("checked") == true){ 
        $("#uncerTxT"+id).removeAttr('disabled');
    }else if($(item).prop("checked") == false){
    	$("#uncerTxT"+id).attr('disabled','disabled');
    }

}
function myTrim(x) {
	  return x.replace(/^\s+|\s+$/gm,'');
	}
function selectAll(source){
	var items=document.getElementsByName('chk');
	for(var i=0; i<items.length; i++){
		if(items[i].type=='checkbox'){
			//items[i].checked=true;
			if(items[i].checked != source) {
					items[i].checked = source.checked; 
	   	 	}
		}
	}
}
//COMMENT HISTORY
/*function setComment(){
	console.log(com_seq);
	for(var x=0;x<com_seq.length;x++){
		//$("#labelC"+com_seq[x]+"").text(com_group[x]+":<br>"+com_detail[x]);
		$("#labelC"+com_seq[x]+"").text(com_group[x]+"\t:\t\n"+com_detail[x]);
	}
	
}*/
function getCommentHistory(){
	try {   		 
		 var data = {}
		 data["ltrhd"] = str[1];
		  jQuery.ajax({
			url : 'util-getCommentHistory',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
				//console.log(data);
				for (var i = 0; i < data.length; i++) {	
					//not show first row comment
					//console.log(data[i].SEQ);
					if(data[i].SEQ != '0'){
						/*com_seq.push(data[i].SEQ);
						com_name.push(data[i].NAMET);
						com_detail.push(data[i].COMMENT);
						com_group.push(data[i].USER_TYPE_DTL);
						com_date.push(data[i].CHAT_DATE);*/
						//$('.comment-history').append('<label class="col-xs-12 bg-chat left" id="labelC'+data[i].SEQ+'">');
						//setcolor
						var colorPic = "";
						if(data[i].USER_TYPE_IDS == '0010'){ //A4
							colorPic = "2200ff"; //น้ำเงิน
						}else if(data[i].USER_TYPE_IDS == '0004'){ //LAB MANAGET
							colorPic = "ff0004"; //แดง
						}else if(data[i].USER_TYPE_IDS == '0005'){ //LAB TEAM LEAD
							colorPic = "00ff40"; //เขียว
						}else{ //GROUP 
							colorPic = "e3e317"; //เหลือง
						}
						$('.comment-history').append('<li class="col-xs-12 left clearfix chat"><span class="chat-img pull-left">'+
	                            '<img src="https://via.placeholder.com/50/'+colorPic+'/fff&text='+data[i].USER_TYPE_DTL+'" alt="User Avatar" class="img-circle" />'+
	                                '</span>'+
	                                    '<div class="chat-body clearfix">'+
	                                        '<div class="header">'+
	                                            '<strong class="primary-font">'+data[i].NAMET+'</strong> <small class="pull-right text-muted">'+
	                                                '<span class="glyphicon glyphicon-time"></span>'+data[i].CHAT_DATE+'</small>'+
	                                        '</div>'+
	                                        '<p>'+data[i].COMMENT+'</p>'+
	                                    '</div>'+
	                                '</li>');
					}
					$('.c-header').show();	
				}
			},
			error : function(ex) {
				showMsgError(ex);
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		 
	}
}
function getUserCreateHistory(){
	try {   		 
		 var data = {}
		 data["ltrhd"] = str[1];
		  jQuery.ajax({
			url : 'util-getUserCreateHistory',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
				console.log(data);
				for (var i = 0; i < data.length; i++) {	
					//not show first row comment
					//console.log(data[i].SEQ);
					if(data[i].SEQ != '0'){
						/*com_seq.push(data[i].SEQ);
						com_name.push(data[i].NAMET);
						com_detail.push(data[i].COMMENT);
						com_group.push(data[i].USER_TYPE_DTL);
						com_date.push(data[i].CHAT_DATE);*/
						//$('.comment-history').append('<label class="col-xs-12 bg-chat left" id="labelC'+data[i].SEQ+'">');
						//setcolor
						var colorPic = "";
						if(data[i].USER_TYPE_IDS == '0010'){ //A4
							colorPic = "2200ff"; //น้ำเงิน
						}else if(data[i].USER_TYPE_IDS == '0004'){ //LAB MANAGET
							colorPic = "ff0004"; //แดง
						}else if(data[i].USER_TYPE_IDS == '0005'){ //LAB TEAM LEAD
							colorPic = "00ff40"; //เขียว
						}else{ //GROUP 
							colorPic = "e3e317"; //เหลือง
						}
						
						$('.usercreate-history').append('<li class="col-xs-12 left clearfix chat"><span class="chat-img pull-left">'+
	                            '<img src="https://via.placeholder.com/50/'+colorPic+'/fff&text='+data[i].USER_TYPE_DTL+'" alt="User Avatar" class="img-circle" />'+
	                                '</span>'+
	                                    '<div class="chat-body clearfix">'+
	                                        '<div class="header">'+
	                                            '<strong class="primary-font">'+data[i].NAMET+'</strong> <small class="pull-right text-muted">'+
	                                                '<span class="glyphicon glyphicon-time"></span>'+data[i].UPDATE_DATE+'</small>'+
	                                        '</div>'+
	             
	                                    '</div>'+
	                                '</li>');
					$('.c-header2').show();	
					
					
					}
				}
			},
			error : function(ex) {
				showMsgError(ex);
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		 
	}
}

function getProductDescription(){
	try {   		 
		 var data = {}
		 
		  jQuery.ajax({
			url : 'util-getProductionDescription',
			type : "Get", 
			contentType : "application/json",
			//data : JSON.stringify(data),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {

			var $inputProductDesc = $('#inputProductDesc');
            $inputProductDesc.empty();
            for (var i = 0; i < data.length; i++) {
                $inputProductDesc.append('<option id=' + data[i].PDDESC_ID + ' value=' + data[i].PDDESC_ID+ '>' + data[i].PDDESC_NAME + '</option>');
            }
			
			
			},
			error : function(ex) {
				showMsgError(ex);
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		 
	}
}

function getReviseDescription(){
	try {   		 
		 var data = {}
		 
		  jQuery.ajax({
			url : 'util-getReasonRevise',
			type : "Get", 
			contentType : "application/json",
			//data : JSON.stringify(data),
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
				
			var $input_revise = $('#input_revise');
            $input_revise.empty();
            for (var i = 0; i < data.length; i++) {
                $input_revise.append('<option id=' + data[i].REVISE_CODE + ' value=' + data[i].REVISE_CODE+ '>' + data[i].REVISE_DESC + '</option>');
            }
				 
			
			},
			error : function(ex) {
				showMsgError(ex);
			}
		});

	} catch (ex) {
		showMsgError(ex); 
		 
	}
}
function gotoMain(){
    window.location="/Lab/home";
}

function setLocalStorage(){
	removeLocalStorage();
	var store_value='';
	var store_id_arr='';
	for(var i =0;i<dataStore.length;i++){
			store_id_arr=dataStore[i].split('|');
			store_value=$('#'+store_id_arr[1]).val();
			localStorage.setItem(dataStore[i], store_value);
		
		
	}
	showMsgSuccess('บันทึกร่างเรียบร้อย');

	
}
function getLocalStorage(){
	var store_id_arr='';
	var data_value = '';
	var flag =false;
	for (var key in localStorage){
	    if(key.search(str[1])!=-1){
		
			for(var j=0;j<count.length;j++){
				if(count[j].split('|')[3]==key.split('|')[2]){
					flag=true;
				}
			}
			if(flag){
				store_id_arr=key.split('|');
			    data_value = localStorage.getItem(key);
				$('#'+store_id_arr[1]).val(data_value);
				$('#'+store_id_arr[1]).trigger("change");
				flag=false;
			}
		}
	
	}
}
function removeLocalStorage(){
	var flag =false;
	for (var key in localStorage){
	    if(key.search(str[1])!=-1){
			for(var j=0;j<count.length;j++){
				if(count[j].split('|')[3]==key.split('|')[2]){
					flag=true;
				}
			}
			if(flag){
				localStorage.removeItem(key);
				flag=false;
			}
		}
	}
}
function checkUncerBeforeSave(){
	let checkresult=false;
	if(getCheckUncer.length>0){
		for(var k=0;k<getCheckUncer.length;k++){
			let result=$('#'+getCheckUncer[k]).val();
			if(result==null||result==''){
				checkresult=true;
				console.log(getCheckUncer[k]);
			}
		}
	}
	return checkresult;
}



function SetDropDownGetSample(sampleTypeName, selectedSampleLevelDesc, checkDisabled) {
    var htmlDdlGetSample = '';

    try {
        jQuery.ajax({
            url: 'util-getDropdownGetSample',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                console.log(data);
                htmlDdlGetSample = '<tr><td>รูปแบบการเก็บ</td><td class="text-center"><select id="input-ltr-sample-level-code" class="form-control" '+checkDisabled+' style="cursor: default;">';

                // Assuming you have a variable named sampleTypeName that determines the condition
                if (sampleTypeName === "C") {
                    // If sampleTypeName is "C", add only the option with SAMPLE_LEVEL_CODE "00001"
                    htmlDdlGetSample += '<option value="00001">AL</option>';
                } else {
                    // For other sampleTypeNames, add all options
                    var optionsHtml = '';
                    for (var i = 0; i < data.length; i++) {
                        var optionValue = data[i].SAMPLE_LEVEL_CODE;
                        var optionDesc = data[i].SAMPLE_LEVEL_DESC;
                        var selectedAttr = optionDesc === selectedSampleLevelDesc ? 'selected' : ''; // Add 'selected' attribute if optionDesc matches selectedSampleLevelDesc
                        optionsHtml += '<option value="' + optionValue + '" ' + selectedAttr + '>' + optionDesc + '</option>';
                    }
                    htmlDdlGetSample += optionsHtml;
                }
            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด!');
            }
        });

    } catch (ex) {
        showMsgError(ex);
    }

    htmlDdlGetSample += '</select></tr>';
    return htmlDdlGetSample;
}


function SetDropDownSavePoint(selectedLocId, checkDisabled) {
    var htmlDdlGetSample = '';

    try {
        jQuery.ajax({
            url: 'util-getDropdownSavepointlocation',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                console.log(data);
                htmlDdlGetSample = '<tr><td>จุดเก็บ</td><td class="text-center"><select id="input-ltr-point-save" class="form-control" '+checkDisabled+' style="cursor: default;">';
                    // For other sampleTypeNames, add all options
                    var optionsHtml = '';
                    for (var i = 0; i < data.length; i++) {
                        var optionValue = data[i].loc_id;
                        var optionDesc = data[i].loc_name;
                        var selectedAttr = optionValue === selectedLocId ? 'selected' : ''; // Add 'selected' attribute if optionDesc matches selectedSampleLevelDesc
                        optionsHtml += '<option value="' + optionValue + '" ' + selectedAttr + '>' + optionDesc + '</option>';
                    }
                    htmlDdlGetSample += optionsHtml;
            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด!');
            }
        });

    } catch (ex) {
        showMsgError(ex);
    }

    htmlDdlGetSample += '</select></tr>';
    return htmlDdlGetSample;
}

function SetDropDownTypeStation(selectedTypeStationId, checkDisabled) {
    var htmlDdlGetSample = '';

    try {
        jQuery.ajax({
            url: 'util-getDropdownTypeStation2',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                console.log(data);
                htmlDdlGetSample = '<tr><td>ประเภทปั้ม</td><td class="text-center"><select id="input-ltr-type-station-id" class="form-control" '+checkDisabled+' style="cursor: default;">';
                    // For other sampleTypeNames, add all options
                    var optionsHtml = '';
                    for (var i = 0; i < data.length; i++) {
                        var optionValue = data[i].TYPE_ID;
                        var optionDesc = data[i].TYPE_NAME;
                        var selectedAttr = optionValue === selectedTypeStationId ? 'selected' : ''; // Add 'selected' attribute if optionDesc matches selectedSampleLevelDesc
                        optionsHtml += '<option value="' + optionValue + '" ' + selectedAttr + '>' + optionDesc + '</option>';
                    }
                    htmlDdlGetSample += optionsHtml;
            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด!');
            }
        });

    } catch (ex) {
        showMsgError(ex);
    }

    htmlDdlGetSample += '</select></tr>';
    return htmlDdlGetSample;
}