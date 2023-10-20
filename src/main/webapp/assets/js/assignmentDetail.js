var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var backsettingwork = "/Lab/settingWork";
//Normal AND Normal ID
var count = [];
var usrVal = [],toolsVal = [],methodVal = [],ltrIDVal = [];
var usrValID = [],toolsValID = [],methodValID = [],ltrIDValID = [];
//Y ID
var countY = [];
var usrValYID = [],toolsValYID = [],methodValYID = [],ltrIDValYID = [];
//SET DATA
var dUserTypeID = [];
var dUserTypeName = [];
var dToolID = [];
var dToolName = [];
var dMethodID = [];
var dMethodName = [];
var product_code='';
var sampletype='';
var current_setup='';
var product_name = '';
var sampletype_name ='';
var triggerUser=[];
$(document).ready(function () {
	getLabCode();
	renderTd();
	
	$('#close_error_pop').click(function(){
		window.location=backsettingwork;
	})
	//checkDropDown();
});
var str = location.search;
var checkStatus = "" ;
str = str.split("?");
function getLabCode(){	
	$("#pageTitles").html("รายละเอียดการมอบหมายงาน");
	queryDetail(str[1]);
	//console.log(checkStatus);
	if("05"==checkStatus){
		querySpecLTRAssignment(str[1],"spec");
	}else{
		querySpecLTRAssignment(str[1],"detail");
	}
	//console.log(str[2]);
	if("tblPlantSuccessFul"==str[2] || "tblPlantSuccess"==str[2]){
		$(".save-data-bt").hide();
		$(".back-bt").removeClass();
		$(".back-bt").addClass("col-sm-12 back-bt");
	}
	if(str[3]=="retention"){
		$("#pageTitles").html("รายละเอียดตัวอย่าง Retention");
		$(".assign-detail").hide();
		backloc = "/Lab/randomOilForValidate";
	}
	
}
function checkDropDown(){	
	$.each($("select"),function(i,item){	
		if(1==item.length){
			$("#"+item.id).attr('disabled', 'disabled');
		}
	});
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
				async: false,
				cache: false,
	            success: function (data) {
//					console.log(data);
					product_code=data.list[0].PRODUCT_ID;
					sampletype=data.list[0].SAMPLE_TYPE_CODE;
					product_name=data.list[0].product_name;
					sampletype_name=data.list[0].SAMPLE_TYPE_NAME;
					
	            	checkStatus = data.list[0].status;
	            	$('#ltr_no').append(data.list[0].LAB_CODE);
	            	$('#ltr_prod').append(data.list[0].product_name);
	            	$('#ltr_carno').append(data.list[0].CAR_NO);
	            	$('#ltr_datepo').append(data.list[0].PO_DATE);
	            	$('#ltr_src').append(data.list[0].source_name);
	            	$('#ltr_carslot').append(data.list[0].CAR_SLOT);
	            	$('#ltr_po').append(data.list[0].PO_NO);
	            	if("T" == data.list[0].SAMPLE_TYPE_NAME){
	            		$('#ltr_trans').append(' - ');	
	            	}else{
	            		$('#ltr_trans').append(data.list[0].logis_name);		
	            	}
	            
	            	$('#ltr_boatno').append(data.list[0].BOAT_NO);
	            	$('#ltr_do').append(data.list[0].DO_NO);
	            	$('#ltr_samp').append(data.list[0].SAMPLE_LEVEL_DESC);
	            	$('#ltr_boatname').append(data.list[0].BOAT_NAME);
	            	$('#ltr_ship').append(data.list[0].SHIPMENT_NO);
	            	$('#ltr_daterandom').append(data.list[0].RAN_DATE);
	            	$('#ltr_boatslot').append(data.list[0].BOAT_SLOT);
	            	$('#ltr_grp').append(data.list[0].SAMPLE_REFER);
	            	$('#ltr_dateexp').append(data.list[0].STR_SAMPLE_DATE);
	            	$('#ltr_empname').append(data.list[0].SAMPLE_STAFF_NAME);
	            	$('#ltr_sampleType').append(data.list[0].SAMPLE_TYPE_NAME);
	            	//console.log(data.list[0].LAB_CODE);
	            	$("#ltr_sampleType_desc").append(data.list[0].SAMPLE_TYPEC_DESC);
	            	HideWaiting() ;
					findSetup();
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
function updateLTRHDresult(){
	 try {
     	var data = {}	
	    	data["labCode_No"] = str[1];
     		data["usrDataAss"] = usrData;
	    	
			jQuery.ajax({
				url : 'updateLTRHDresult',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
	            success: function (data) {
	            	showMsgSuccess('สำเร็จ');
	            	
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
function findSetup(){
	 try {
     	var data = {}	
	    	data["productID"] = product_code;
     		data["sampleType"] = sampletype;
	    	
			jQuery.ajax({
				url : 'findCurrentSetup',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
	            success: function (data) {
				var flag = false;
	            	console.log(data);
					for(var i = 0;i<data.length;i++){
						if((data[i].ITEM_ID==null||data[i].ITEM_ID=='')||(data[i].METHOD_ID==null||data[i].METHOD_ID=='')||(data[i].TOOL_ID==null||data[i].TOOL_ID=='')){
							flag=true;
						}
					}
					if(!flag){
						
						current_setup=data;
					}else{
						$("#err_prd").text(product_name);
						$("#err_sample").text(sampletype_name);
						
						$('#myModal').modal({backdrop: 'static', keyboard: false});
						
						
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
function saveData(){
	ShowWaiting();
//	console.log("SaveData");
	//console.log(ltrIDValID);
	var usrData = "";
	var toolsData = "";
	var methodData = "";
	var ltrIDData = "";
	var userArr ;
	var methodArr;
	var toolsArr;
	//user
	$('.setusertype').each(function(i) {
		userArr = this.value.split('#')
		
		if(userArr.length>1){
			 usrData += "'"+userArr[1]+"',"
		}else{
			 usrData += "'"+userArr[0]+"',"
		}
//		  usrData += "'"+this.value+"',"
	});
	//Method
	$('.setmethod').each(function(i) {
//		methodArr = this.value.split('#')
		methodArr = $('option:selected', this).attr('foo').split('#');
		
		if(methodArr.length>1){
			methodData += "'"+methodArr[1]+"',"
		}else{
			methodData += "'"+methodArr[0]+"',"
		}
		  
	});
	//Tools
	$('.settools').each(function(i) {
//		toolsArr = this.value.split('#')
		toolsArr = $('option:selected', this).attr('foo').split('#');
//		console.log(toolsArr);
		if(toolsArr.length>1){
			toolsData += "'"+toolsArr[1]+"',"
		}else{
			toolsData += "'"+toolsArr[0]+"',"
		}
		  
	});	
	for(var x=0;x<ltrIDValID.length;x++){
		ltrIDData += "'"+ltrIDValID[x]+"',"
	}
	usrData = usrData.substring(0,usrData.length-1);
	toolsData = toolsData.substring(0,toolsData.length-1);
	methodData = methodData.substring(0,methodData.length-1);
	ltrIDData = ltrIDData.substring(0,ltrIDData.length-1);
	
	console.log(usrData);
	console.log(toolsData);
	console.log(methodData);
	console.log(ltrIDData);
	 try {
     	var data = {}	
	    	data["labCode_No"] = "'"+str[1]+"'";
     		data["usrDataAss"] = usrData;
     		data["toolsDataAss"] = toolsData;
     		data["methodDataAss"] = methodData;
     		data["ltrDtID"] = ltrIDData;
	    	console.log(JSON.stringify(data));
			jQuery.ajax({
				url : 'saveDataAssignment',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
	            success: function (data) {
	            	showMsgSuccess('สำเร็จ');
	            	//getLabCode();
	            	//setDropdown();
	            	
	            	HideWaiting() ;
	            	gotoMain();
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
function setDropdown(){
	ShowWaiting();
	//Clear Data
	$('#setUsertype'+i+'').val('');
	$('#setUsertype'+i+'').html("");
	$('#setTool'+i+'').val('');
	$('#setTool'+i+'').html("");
	$('#setMethod'+i+'').val('');
	$('#setMethod'+i+'').html("");
	//console.log(toolsValID);
//	console.log(countY);
	for(var i=0;i<countY.length;i++){
		//console.log(countY[i]);	
		$('#setUsertype'+countY[i]+'').select2({dropdownAutoWidth : true,width: 'auto'});
		$('#setTool'+countY[i]+'').select2({dropdownAutoWidth : true,width: 'auto'});
		$('#setMethod'+countY[i]+'').select2({dropdownAutoWidth : true,width: 'auto'});
		//LOOP ADD DATA	
		//updateData = updateData.filter(unique);
		var countResult = 0;

		if(countY[i+1]==null){
			countResult=(((countY[i]+1)-countY[i])+countY[i]);
		}else{
			countResult=(countY[i+1]-countY[i])+countY[i];
		}
//		console.log(countResult+"|"+methodValID[i]+"|"+countY[i]);
		
		for(var i2=countY[i];i2<=countResult;i2++){

			//console.log(methodVal[i2]+"|"+i2);
			console.log(countY[i]+"|"+methodVal[i2].split("|")[1]);
			if(typeof methodVal[i2] !== 'undefined' && typeof usrVal[i2] !== 'undefined'
				&& typeof toolsVal[i2] !== 'undefined' && i2!=countResult){ //& i2!=countY[i]
				//console.log(methodValID[i2]+"|"+countResult+"|"+i2);

				$('#setMethod'+countY[i]+'').append('<option value="' + methodValID[i2] + '">&nbsp;&nbsp;' + methodVal[i2].split("|")[1] + '</option>');
				$('#setUsertype'+countY[i]+'').append('<option value="' + usrValID[i2] + '">&nbsp;&nbsp;' + usrVal[i2].split("|")[1] + '</option>');
				$('#setTool'+countY[i]+'').append('<option value="' + toolsValID[i2] + '">&nbsp;&nbsp;' + toolsVal[i2].split("|")[1] + '</option>');			
			}
			//console.log(countY[i]+"|"+methodVal[i2].split("|")[1]+"|"+toolsVal[i2].split("|")[1]+"|"+usrVal[i2].split("|")[1]);
		}
		//setVal == 'Y'
		//IF check length new val and set value
		
		
		
		removeDup(countY[i]);
		//console.log($('#setMethod'+countY[i]+'').val());
		
	}
	
	//console.log(usrValYID.length);
	if(usrValYID.length!=0){
		//User
		$('.setusertype').each(function(i) {
			  $('#'+this.id+'').val(usrValYID[i]).change();
			  //console.log(usrValYID[i]+"|"+this.id);
			  //console.log(this.value);
		});
		//Method
		$('.setmethod').each(function(i) {
			  $('#'+this.id+'').val(methodValYID[i]).change();
			  //console.log(usrValYID[i]+"|"+this.id);
		});
		//Tools
		$('.settools').each(function(i) {
			  $('#'+this.id+'').val(toolsValYID[i]).change();
			  //console.log(usrValYID[i]+"|"+this.id);
		});
	}else{
		
	}
	HideWaiting();
	
}
function removeDup(x){
	//REMOVE 
	var optionValuesM =[];
	$('#setMethod'+x+' option').each(function(){
	   if($.inArray(this.value, optionValuesM) >-1){
	      $(this).remove();
	   }else{
		   optionValuesM.push(this.value);
	   }
	});
	var optionValuesT =[];
	$('#setTool'+x+' option').each(function(){
	   if($.inArray(this.value, optionValuesT) >-1){
	      $(this).remove();
	   }else{
		   optionValuesT.push(this.value);
	   }
	});
	var optionValuesU =[];
	$('#setUsertype'+x+' option').each(function(){
	   if($.inArray(this.value, optionValuesU) >-1){
	      $(this).remove();
	   }else{
		   optionValuesU.push(this.value);
	   }
	});
	//console.log(optionValuesT);
	//ถ้าอันไหนเป็น อันเดียวให้แสดงเป็น label
	
}
function unique(value, index, self) { 
    return self.indexOf(value) === index;
}


var dataArr ={}
var methodArr={}
var toolArr={}
var userArr={}
function querySpecLTRAssignment(labCode,chMenu){		
	try {
		$('#assiDetialT').DataTable().destroy();
		$('#assiDetial').html("");
	    var data = {}
	    var chk =""
	    data["chkmenu"] = chMenu;
	    ShowWaiting();
	    data["labCode"] = labCode;
	    
	    jQuery.ajax({
	        url: 'querySpecLTRAssignment',
	        type: "Post",
	        contentType: "application/json",
	        data: JSON.stringify(data),
	        dataType: 'json',
	        async: false,
	        cache: false,
	        success: function(data) {
	        	
	        
	        	$.each(data.list,function(index,item){
	        		//console.log(item);
	        		dataArr[item.ITEMMP_ID] = item
	        		methodArr[item.METHOD_ID+item.ITEMMP_ID] = item.METHOD_NAME+'|'+ item.METHOD_ID+'|'+item.ITEMMP_ID
	        		toolArr[item.TOOL_ID+item.ITEMMP_ID] = item.TOOL_NAME+'|'+ item.TOOL_ID+'|'+item.ITEMMP_ID
	        		userArr[item.USER_TYPE_ID+item.ITEMMP_ID]=item.USER_TYPE_DTL+'|'+ item.USER_TYPE_ID+'|'+item.ITEMMP_ID
    		        ltrIDValID.push(item.LTR_DT_ID == null ? "" : item.LTR_DT_ID)
	        	})
	        	
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


function gotoMain(){
    window.location= backloc;;
}
function getDropDownUserType(){
	ShowWaiting() ;
    try {
        jQuery.ajax({
            url: 'getDropdownUserType',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
            	for(var i=0;i<data.list.length;i++){
            		dUserTypeID.push(data.list[i].USER_TYPE_ID);
            		dUserTypeName.push(data.list[i].USER_TYPE_DTL);
            	}
                HideWaiting() ;
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด!');
                HideWaiting() ;
            }
        });

    } catch (ex) {
        showMsgError(ex);
        HideWaiting() ;
    }
}
function getDropDownTool(){
	ShowWaiting() ;
    try {
        
        jQuery.ajax({
            url: 'getDropDownTools',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
            	for(var i=0;i<data.list.length;i++){
            		dToolID.push(data.list[i].TOOL_ID);
            		dToolName.push(data.list[i].TOOL_NAME);
            	}
                HideWaiting() ;
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด!');
                HideWaiting() ;
            }
        });

    } catch (ex) {
        showMsgError(ex);
        HideWaiting() ;
    }
}
function getDropDownMethod(){
	ShowWaiting() ;
	
    try {
        
        jQuery.ajax({
            url: 'getDropDownMethod',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
            	for(var i=0;i<data.list.length;i++){
            		dMethodID.push(data.list[i].METHOD_ID);
            		dMethodName.push(data.list[i].METHOD_NAME);

            	}
                HideWaiting() ;
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด!');
                HideWaiting() ;
            }
        });

    } catch (ex) {
        showMsgError(ex);
        HideWaiting() ;
    }
}


function renderTd(){
	var data = dataArr ;
	var user = userArr;
	var tool = toolArr;
	var method = methodArr
	var newUserArr = {}

	var cuserStr = ""
	var methodStr = ""
	var toolStr = ""
	//console.log(user);
	$.each(data,function(index,item){
		$.each(user,function(a,b){
			if(item.ITEMMP_ID==b.split('|')[2]){
				if(""==cuserStr){
					cuserStr = b.split('|')[1]+"#"+b.split('|')[0]
				}else{
					cuserStr += ','+b.split('|')[1]+"#"+b.split('|')[0]
				}
			}
		})
		Object.assign(item,{user:cuserStr });
		cuserStr=""
	})
	
	$.each(data,function(index,item){
		$.each(method,function(a,b){
			if(item.ITEMMP_ID==b.split('|')[2]){
				if(""==methodStr){
					methodStr = b.split('|')[1]+"#"+b.split('|')[0]
				}else{
					methodStr += ','+b.split('|')[1]+"#"+b.split('|')[0]
				}
			}
		})
		Object.assign(item,{method:methodStr });
		methodStr=""
	})
	
	
	$.each(data,function(index,item){
		$.each(tool,function(a,b){	
			if(item.ITEMMP_ID==b.split('|')[2]){
				if(""==toolStr){
					toolStr = b.split('|')[1]+"#"+b.split('|')[0]
				}else{
					toolStr += ','+b.split('|')[1]+"#"+b.split('|')[0]
				}
			}
		})
		/*if(toolStr.split(",").length==4){
			toolStr = toolStr.split(",")[0]+","+toolStr.split(",")[1]+","+toolStr.split(",")[3]+","+toolStr.split(",")[2];
		}*/
		Object.assign(item,{tool:toolStr });
		toolStr="";
		toolsList = [];
	})
	
	
	
		
	var det=''
	$('#assiDetialT').DataTable().destroy();
	$('#assiDetial').html("");
	triggerUser=[];
	let intdexSetup=0
		$.each(data,function(index,item){
			//console.log(item);
//	       	if(item.DEFAULT_FLG_M =class= 'Y'&& item.DEFAULT_FLG_T == 'Y' &&item.DEFAULT_FLG_U == 'Y' ){		
	       		det += '<tr  ="TBODY">';
	               det += '<td class="text-center" >' + (item.PRODUCT_NAME == null ? "" : item.PRODUCT_NAME) + '</td>';
	               det += '<td class="text-center" >' + (item.SAMPLE_TYPE_NAME == null ? "" : item.SAMPLE_TYPE_NAME) + '</td>';
	               det += '<td class="text-center" >' + (item.ITEM_NAME == null ? "" : item.ITEM_NAME) + '</td>';
             
	               if(item.STATUS_CHK=="Y"){
	            	  /* if("0011"==item.ITEM_ID || "0012"==item.ITEM_ID ){
	            		   det += '<td class="text-center" ><select class="setmethod" id="setMethod'+index+'">';
	            	   }else{
	            		   det += '<td class="text-center" ><select class="setmethod" onchange="changetTool(this)" id="setMethod'+index+'">';
	            	   }*/
	            	   det += '<td class="text-center" ><select class="setmethod" onchange="changetTool(this)" disabled id="setMethod'+index+'">';
	            	   var methodOpton = item.method.split(',')
	            	   var seqMethod = 0;
	            	   if(methodOpton.length>0){
	            		   $.each(methodOpton,function(a,b){
            			   det +='<option value="'+seqMethod+'#'+item.ITEMMP_ID+'"  foo="'+seqMethod+'#' + b.split('#')[0] + '">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
            			   seqMethod++;
	            		   })
	            	   }
	            	   det +='</select></td>'
	   
	            
	            	if("0005"==item.ITEM_ID || "0006"==item.ITEM_ID || "0007"==item.ITEM_ID 
	            			|| "0008"==item.ITEM_ID || "0009"==item.ITEM_ID || "0021"==item.ITEM_ID || "0010"==item.ITEM_ID){
	            		det += '<td class="text-center" ><select class="settools" foo="'+item.ITEM_ID+'"  onchange="changetUsertype(this)" id="setTool'+index+'">';
						
	            	}else if("0011"==item.ITEM_ID || "0012"==item.ITEM_ID ){
	            		if("100000002"==item.PRODUCT_ID || "100000003"==item.PRODUCT_ID ||
	            				"100000005"==item.PRODUCT_ID || "100000008"==item.PRODUCT_ID){
	            			det += '<td class="text-center" ><select class="settools" foo="'+item.ITEM_ID+'"  onchange="changetUsertype(this)" id="setTool'+index+'">';
	            		}else{
	            			//console.log("no add");
	            			det += '<td class="text-center" ><select class="settools" foo="'+item.ITEM_ID+'"  id="setTool'+index+'">';
	            		}
	            		
	            	}else{
	            		det += '<td class="text-center" ><select class="settools" disabled id="setTool'+index+'">';
	            	}
	                console.log();
					
            	    var seqTool = 0;
            	    var toolOption = item.tool.split(',')
            	    if(toolOption.length>0){
            		   $.each(toolOption,function(a,b){
						
        			   det +='<option value="'+seqTool+'#'+item.ITEMMP_ID+'"  foo="'+seqTool+'#' +b.split('#')[0] + '">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
						
						for(var i =0;i<current_setup.length;i++){
							var txt = b.split('#');
							if(current_setup[i].TOOL_ID==txt[0]&&current_setup[i].METHOD_ID==item.METHOD_ID&&current_setup[i].ITEM_ID==item.ITEM_ID){
								triggerUser.push('setTool'+index+'#'+seqTool+'#'+item.ITEMMP_ID);
							}
						}

        			   seqTool++;
            		   })
            		   
            	     }
            	     det +='</select></td>'
	                det += '<td class="text-center" ><select class="setusertype" id="setUsertype'+index+'">';
            	     var userOption = item.user.split(',')
             	    if(userOption.length>0){
						
             		   $.each(userOption,function(a,b){
             			   
						   if(str[2]=='tblPlantSuccess'){
							det +='<option >&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
							}else{
								             			   if("0005"==item.ITEM_ID || "0006"==item.ITEM_ID || "0007"==item.ITEM_ID 
       	            			|| "0008"==item.ITEM_ID || "0009"==item.ITEM_ID || "0021"==item.ITEM_ID){
             				   if("0013"!=b.split('#')[0]){
             					  det +='<option value="' + b.split('#')[0] + '" disabled="disabled">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
             				   }else{
             					  det +='<option value="' + b.split('#')[0] + '">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
             				   }	  
             			   }else if("0011"==item.ITEM_ID || "0012"==item.ITEM_ID ){
             				   if("100000002"==item.PRODUCT_ID || "100000003"==item.PRODUCT_ID ||
          	            				"100000005"==item.PRODUCT_ID || "100000008"==item.PRODUCT_ID){
             					  if("0014"!=b.split('#')[0]){
                 					  det +='<option value="' + b.split('#')[0] + '" disabled="disabled">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
                 				   }else{
                 					  det +='<option value="' + b.split('#')[0] + '">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
                 				   }
             				   }else{
             					  det +='<option value="' + b.split('#')[0] + '">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
             				   }
             				  
             			   }else{
             				  det +='<option value="' + b.split('#')[0] + '">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
             			   }
							}

             			  


             		   })
             	     }
            	     det +='</select></td>'
            	    ++intdexSetup;	 
	               }else{
	            	   
	            	   det += '<td class="text-center" ><select class="setmethod" disabled onchange="changetTool(this)" id="setMethod'+index+'">';
	            	   var methodOpton = item.method.split(',')
	            	   var seqMethod = 0;
	            	   if(methodOpton.length>0){
	            		   $.each(methodOpton,function(a,b){
            			   det +='<option value="'+seqMethod+'#'+item.ITEMMP_ID+'"  foo="'+seqMethod+'#' + b.split('#')[0] + '">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
            			   seqMethod++;
	            		   })
	            	   }
	            	   det +='</select></td>'
	   
	               	               
	            		   det += '<td class="text-center" ><select disabled class="settools" id="setTool'+index+'">';
	            	    var seqTool = 0;
	            	    var toolOption = item.tool.split(',')
	            	    if(toolOption.length>0){
	            		   $.each(toolOption,function(a,b){
	        			   det +='<option value="'+seqTool+'#'+item.ITEMMP_ID+'"  foo="'+seqTool+'#' +b.split('#')[0] + '">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
	        			   seqTool++;
	            		   })
	            		   
	            	     }
	            	     det +='</select></td>'
	                det += '<td class="text-center" ><select class="setusertype" disabled id="setUsertype'+index+'">';
            	     var userOption = item.user.split(',')
             	    if(userOption.length>0){
             		   $.each(userOption,function(a,b){
         			   det +='<option value="' + b.split('#')[0] + '">&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
             		   })
             	     }
            	     det +='</select></td>'
	               }
	               
	               det +='</tr>';
//	       	}         
	       	 
   	       		
		})
		
	   
	   if (det == '') {
           $('#assiDetial').html(det);
           HideWaiting();
       } else {
           $('#assiDetial').html(det);
           HideWaiting();

       }
       table = $('#assiDetialT').DataTable({
           searching: true,
           responsive: true,
           "pageLength": 50,
           "paging":   false
       });     
		if(str[2]!='tblPlantSuccess') { 
      	for(var i=0;i<triggerUser.length;i++){
		var arrData	=	triggerUser[i].split('#');
		var id ='#'+arrData[0];
		var val =arrData[1]+'#'+arrData[2]
		$(id).val(val).change();
		$(id).prop('disabled', 'disabled');
		}}else{
			$('.setusertype').prop('disabled', 'disabled');
			$('.settools').prop('disabled', 'disabled');
		}
	 		
	       HideWaiting();
	       setSelect2ById();
	
}

function setSelect2ById(){
	$('.setusertype').select2({dropdownAutoWidth : true,width: 'auto'});
	$('.settools').select2({dropdownAutoWidth : true,width: 'auto'});
	$('.setmethod').select2({dropdownAutoWidth : true,width: 'auto'});
	
}

function changetTool(item){
	var id = item.value.split('#')[1];
	//console.log($('#setMethod'+id).val());
	if($('#setTool'+id).val()!=$('#setMethod'+id).val() && $('#setTool'+id+' option').length > 1){
		$('#setTool'+id).val(item.value).trigger('change');	
	}
}
//เดี๋ยวว่างๆ จะมาแก้ให้โค้ดมันดีกว่านี้ --เกรท
function changetUsertype(item){
	var id = item.value.split('#')[1];
	if($('#setTool'+id).val()!=$('#setMethod'+id).val() && $('#setMethod'+id+' option').length > 1){
		$('#setMethod'+id).val(item.value).trigger('change');
	}
	
	var itemID = $(item).attr("foo");
	var idUser = item.value.split('#')[1];
	if(itemID != "0010" && itemID!="0021" && itemID!="0011" && itemID!="0012" && "0"==$("#setTool"+idUser).val().split("#")[0]){ //Auto
		$.each($("#setUsertype"+idUser+" option"),function(i,item){
			if("0008"==item.value || "0009"==item.value){
				$(this).attr('disabled','disabled');
			}else{
				$(this).removeAttr('disabled');
			}		
		});
		$("#setUsertype"+idUser).val("0013").change();
		
	}else if(itemID != "0010" && itemID!="0021" && itemID!="0011" && itemID!="0012" && "1"==$("#setTool"+idUser).val().split("#")[0]){ //Manual
		$.each($("#setUsertype"+idUser+" option"),function(i,item){
			if("0013"==item.value){
				$(this).attr('disabled','disabled');
			}else{
				$(this).removeAttr('disabled');
			}
		});
		$("#setUsertype"+idUser).val("0008").change();
	}else if(itemID != "0010" && itemID=="0021" && "0"!=$("#setTool"+idUser).val().split("#")[0]){
		$.each($("#setUsertype"+idUser+" option"),function(i,item){
			if("0013"==item.value){
				$(this).attr('disabled','disabled');
			}else{
				$(this).removeAttr('disabled');
			}
		});
		$("#setUsertype"+idUser).val("0009").change();
	}else if(itemID != "0010" && itemID=="0021" && "0"==$("#setTool"+idUser).val().split("#")[0]){
		$.each($("#setUsertype"+idUser+" option"),function(i,item){
			if("0009"==item.value){
				$(this).attr('disabled','disabled');
			}else{
				$(this).removeAttr('disabled');
			}
		});
		$("#setUsertype"+idUser).val("0013").change();
	}else if(itemID != "0010" && itemID=="0011" && "0"==$("#setTool"+idUser).val().split("#")[0]){
		$.each($("#setUsertype"+idUser+" option"),function(i,item){
			if("0011"==item.value){
				$(this).attr('disabled','disabled');
			}else{
				$(this).removeAttr('disabled');
			}
		});
		$("#setUsertype"+idUser).val("0014").change();
	}else if(itemID != "0010" && itemID=="0011" && "1"==$("#setTool"+idUser).val().split("#")[0]){
		$.each($("#setUsertype"+idUser+" option"),function(i,item){
			if("0014"==item.value){
				$(this).attr('disabled','disabled');
			}else{
				$(this).removeAttr('disabled');
			}
		});
		$("#setUsertype"+idUser).val("0011").change();
	}else if(itemID != "0010" && itemID=="0012" && "0"==$("#setTool"+idUser).val().split("#")[0]){
		$.each($("#setUsertype"+idUser+" option"),function(i,item){
			console.log(this);
			if("0011"==item.value){
				$(this).attr('disabled','disabled');
			}else{
				$(this).removeAttr('disabled');
			}
		});
		$("#setUsertype"+idUser).val("0014").change();
	}else if(itemID != "0010" && itemID=="0012" && "1"==$("#setTool"+idUser).val().split("#")[0]){
		$.each($("#setUsertype"+idUser+" option"),function(i,item){
			if("0014"==item.value){
				$(this).attr('disabled','disabled');
			}else{
				$(this).removeAttr('disabled');
			}
		});
		$("#setUsertype"+idUser).val("0011").change();
	}else{
		
	}
}
function disableEnable(dis,ena,id){
	$.each($(id),function(i,item){
		if(dis==item.value){
			$(this).attr('disabled','disabled');
		}else{
			$(this).removeAttr('disabled');
		}
	});
	$(id).val(ena).change();
}