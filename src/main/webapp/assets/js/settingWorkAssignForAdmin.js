var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var backsettingwork = "/Lab/settingWorkForAdmin";
//Normal AND Normal ID
var count = [];
var usrVal = [],toolsVal = [],methodVal = [],ltrIDVal = [];
var usrValID = [],toolsValID = [],methodValID = [],ltrIDValID = [];
//Y ID
var countY = [];
var usrValYID = [],toolsValYID = [],methodValYID = [],ltrIDValYID = [],editdropcheck=[];
//SET DATA
var dUserTypeID = [];
var dUserTypeName = [];
var dToolID = [];
var dToolName = [];
var dMethodID = [];
var dMethodName = [];
var product_code='';
var tmp_data=[];
var itemMpArr;
var unitArray=[];
var uncerArray=[];
var objVisual='';
var objColor='';

//parameter setup
var setupdropdownfortrigger=[];


var objsetupwork='';


//DOCUMENT READY
$(document).ready(function () {
	
	SetDropDownProduct();
	SetDropSampleType();
	selectAllNew ();
	getUnitSpecForUpdate();
	getVisual();
    getColorSetup();
	getSetup();
	initvalue();
	
		//renderTd();
	
	

	
	//checkDropDown();
});


function renderDropdownWithConfig(){
	//itemid
	//method
	//toolid
	//for itemid
	for(var i= 0;i<setupdropdownfortrigger.length;i++){
		if(setupdropdownfortrigger[i].methodid!=''&&setupdropdownfortrigger[i].methodid!=null){
			$('#'+setupdropdownfortrigger[i].methodid).val(setupdropdownfortrigger[i].methodvalue);
			$('#'+setupdropdownfortrigger[i].methodid).trigger('change');
			$('#'+setupdropdownfortrigger[i].toolid).val(setupdropdownfortrigger[i].toolvalue);
			$('#'+setupdropdownfortrigger[i].toolid).trigger('change');
			
		}
		
	}
}


var str = location.search;
var checkStatus = "" ;
str = str.split("?");
function initvalue(){	
	querySpecLTRAssignment($('#ddlProduct').val(), $('#ddlSampleType').val());
}
function checkDropDown(){	
	$.each($("select"),function(i,item){	
		if(1==item.length){
			$("#"+item.id).attr('disabled', 'disabled');
		}
	});
}
function getSetup(){
	objsetupwork='';
	try {
     	var data = {}	
	    	data["productID"]  =$('#ddlProduct').val();
			data["sampleType"]  =$('#ddlSampleType').val();
	    	
			jQuery.ajax({
				url : 'util-getSetupWork',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
	            success: function (data) {
	            	console.log(data);
	            	objsetupwork=data;
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

function checkWorkWait(){
	var res;
    try {
        
        jQuery.ajax({
            url: 'checkWorkWaiting/'+$('#ddlProduct').val()+"/"+ $('#ddlSampleType').val(),
            type: "Get",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
			res=data;
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด!');
            }
        });

    } catch (ex) {
        showMsgError(ex);
      
    }
return res;
}

function saveData(){
	

	var usrData = "";
	var toolsData = "";
	var methodData = "";
	var itemIdData = "";
	var mpidData="";
	var methodArr;
	var toolsArr;
	var mpidArr;
	//service check

	var res_check=checkWorkWait();
	if(res_check.countwork>0){
	$('#warning_setting').modal({
    backdrop: 'static',
    keyboard: false
	});
		$('#message_warn').html("");
		$('#message_warn').append(res_check.message);
		return null;
	}

	ShowWaiting();
	$('.setmethod').each(function(i) {
//		methodArr = this.value.split('#')
		methodArr = $('option:selected', this).attr('foo').split('#');
		
		if(methodArr.length>1){
			methodData += ""+methodArr[1]+","
		}else{
			methodData += ""+methodArr[0]+","
		}
		  
	});
	//Tools 
	$('.settools').each(function(i) {
//		toolsArr = this.value.split('#')
		toolsArr = $('option:selected', this).attr('foo').split('#');
		mpidArr  = $('option:selected', this).attr('mpid').split('#');
		

		if(toolsArr.length>1){
			toolsData += ""+toolsArr[1]+",";
			mpidData += ""+mpidArr[1]+",";
			
		}else{
			toolsData += ""+toolsArr[0]+",";
			mpidData += ""+mpidArr[0]+",";
		
		}
		  
	});	

	toolsData = toolsData.substring(0,toolsData.length-1);
	methodData = methodData.substring(0,methodData.length-1);
	mpidData = mpidData.substring(0,mpidData.length-1);
	itemIdData =itemMpArr.substring(0,itemMpArr.length-1);
	
	console.log(toolsData);
	console.log(methodData);
	console.log(mpidData);
	console.log(itemIdData);
	saveUnit();
	 try {
     	var data = {}	
	   
     		
     		data["toolsDataAss"] = toolsData;
     		data["methodDataAss"] = methodData;
			data["itemIdDataAss"]  = itemIdData;
			data["productID"]  =$('#ddlProduct').val();
			data["sampleType"]  =$('#ddlSampleType').val();
			data["itemMpDataAss"] = mpidData;
     		

	    	//console.log(JSON.stringify(data));

			jQuery.ajax({
				url : 'saveDataSettingAssignment',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
	            success: function (data) {
					
					if(data.result=='00'){
	            	showMsgSuccess('สำเร็จ');
					}
	            	//getLabCode();
	            	//setDropdown();
	            	HideWaiting() ;
	            	//window.location=backsettingwork;
					initvalue();
	            	//gotoMain();
				
					
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


	for(var i=0;i<countY.length;i++){
		
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
			//console.log(countY[i]+"|"+methodVal[i2].split("|")[1]);
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
function querySpecLTRAssignment(prdcode,sampletype){		
	try {
		$('#assiDetialTWork').DataTable().destroy();
		$('#assiDetialWork').html("");
	    var data = {}
	    var chk =""
		    data["productID"] = prdcode;
		    data["sampleType"] = sampletype;
	    ShowWaiting();
	   getUnitSpecForUpdate();
	   getSetup();
	    
	    jQuery.ajax({
	        url: 'util-getConfigWork',
	        type: "Post",
	        contentType: "application/json",
	        data: JSON.stringify(data),
	        dataType: 'json',
	        async: false,
	        cache: false,
	        success: function(data) {
		//console.log(data);
	        	dataArr ={}
				methodArr={}
				toolArr={}
				userArr={}
				tmp_data=[]
	        
	        	$.each(data,function(index,item){
	        		//console.log(item);
					tmp_data.push(item.ITEMMP_ID);
	        		dataArr[item.ITEMMP_ID] = item
	        		methodArr[item.METHOD_ID+item.ITEMMP_ID] = item.METHOD_NAME+'|'+ item.METHOD_ID+'|'+item.ITEMMP_ID
	        		toolArr[item.TOOL_ID+item.ITEMMP_ID] = item.TOOL_NAME+'|'+ item.TOOL_ID+'|'+item.ITEMMP_ID+'|'+item.SPEC_UNCER
	        		userArr[item.USER_TYPE_ID+item.ITEMMP_ID]=item.USER_TYPE_DTL+'|'+ item.USER_TYPE_ID+'|'+item.ITEMMP_ID
    		        ltrIDValID.push(item.LTR_DT_ID == null ? "" : item.LTR_DT_ID)
	        	})
	        	HideWaiting();
	        },
	        error: function() {
	            showMsgError('ข้อมูลผิดพลาด');
	            HideWaiting();
	        },complete: function(data){
	renderTd();
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
function getUnitSpecForUpdate(){
	ShowWaiting() ;
	unitArray=[];
	try {
     	var data = {}	
	    	data["productID"]  =$('#ddlProduct').val();
			data["sampleType"]  =$('#ddlSampleType').val();
	    	
			jQuery.ajax({
				url : 'util-getUnitSpecForUpdate',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
	            success: function (data) {
					for(var i =0;i<data.length;i++){
						unitArray.push(data[i]);
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
	ShowWaiting();
	var data = dataArr ;
	var user = userArr;
	var tool = toolArr;
	var method = methodArr
	setupdropdownfortrigger=[];

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
	$('#assiDetialTWork').DataTable().destroy();
	$('#assiDetialWork').html("");

//function for find
var index_col=1;
var stat ='';
itemMpArr='';
var indextools=0;
var indexcount=0;
var listsetup=[];
var jsondata={};
let colorSet=[];
let colorObj={};
let uncerObj={};
editdropcheck=[];
uncerArray=[];
var shake='',ftir='',gc='',eralitic='';
var conditionEthernal = false;
var seqTool2=0;
$.each(data,function(index,item){
		jsondata={};
		
      		
//	       	if(item.DEFAULT_FLG_M =class= 'Y'&& item.DEFAULT_FLG_T == 'Y' &&item.DEFAULT_FLG_U == 'Y' ){		
	       		det += '<tr  ="TBODY">';
	               det += '<td class="text-center" >' + index_col + '</td>';
	               det += '<td class="text-center" ><input type="checkbox" id="chke" name="chke" value="'+(item.ITEMMP_ID==null?"":item.ITEMMP_ID)+'" /> </td>';



					if(item.PRODUCT_ID=='100000001'||item.PRODUCT_ID=='100000006'||item.PRODUCT_ID=='100000007'||item.PRODUCT_ID=='100000009'){
							var wordingADO = (item.ITEM_NAME == null ? "" : item.ITEM_NAME);
								wordingADO=wordingADO.replace('evap.', 'recov.')
								 det += '<td class="text-left" >' + wordingADO + '</td>';
							}else{
								  det += '<td class="text-left" >' + (item.ITEM_NAME == null ? "" : item.ITEM_NAME) + '</td>';         
							}        	  
	               det += '<td class="text-left" ><select class="setmethod" onchange="changetTool(this)" id="setMethod'+index+'">';
				   itemMpArr = itemMpArr+item.ITEM_ID+",";
				   jsondata['itemid']=item.ITEM_ID;
						
	            	   var methodOpton = item.method.split(',')
	            	   var seqMethod = 0;
 					  jsondata['methodid']='';
					  jsondata['methodvalue']='';
	            	   if(methodOpton.length>0){
	            		   $.each(methodOpton,function(a,b){
						
		              if(b.split('#')[0]==objsetupwork[indexcount].METHOD_ID&&objsetupwork[indexcount].METHOD_ID!=null&&objsetupwork[indexcount].METHOD_ID!=''){
							jsondata['methodid']='setMethod'+index;
							jsondata['methodvalue']=seqMethod+'#'+item.ITEMMP_ID;
						}

            			   det +='<option value="'+seqMethod+'#'+item.ITEMMP_ID+'"  foo="'+seqMethod+'#' + b.split('#')[0] + '"  >&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
            			   seqMethod++;
	            		   })
	            	   }
	            	   det +='</select></td>'
	   
	            	
	            	if("0005"==item.ITEM_ID || "0006"==item.ITEM_ID || "0007"==item.ITEM_ID 
	            			|| "0008"==item.ITEM_ID || "0009"==item.ITEM_ID || "0021"==item.ITEM_ID || "0010"==item.ITEM_ID){
	            		det += '<td class="text-left" ><select class="settools" foo="'+item.ITEM_ID+'"  onchange="changetUsertype(this)" id="setTool'+index+'">';
	            	}else if("0011"==item.ITEM_ID || "0012"==item.ITEM_ID ){
	            		if("100000002"==item.PRODUCT_ID || "100000003"==item.PRODUCT_ID ||
	            				"100000005"==item.PRODUCT_ID || "100000008"==item.PRODUCT_ID){
	            			det += '<td class="text-left" ><select class="settools" foo="'+item.ITEM_ID+'"  onchange="changetUsertype(this)" id="setTool'+index+'">';
	            		}else{
	            			//console.log("no add");
	            			det += '<td class="text-left" ><select class="settools" onchange="changetUsertype(this)" foo="'+item.ITEM_ID+'"  id="setTool'+index+'">';
	            		}
	            		
	            	}else{
	            		det += '<td class="text-left" ><select class="settools" onchange="changetUsertype(this)" id="setTool'+index+'">';
	            	}
	                indextools=0
            	    var seqTool = 0;
            	    var toolOption = item.tool.split(',')
					 jsondata['toolid']='';
					 jsondata['toolvalue']='';
            	    if(toolOption.length>0){
            		   $.each(toolOption,function(a,b){
						uncerObj={};

						if(('100000003'==item.PRODUCT_ID||'100000005'==item.PRODUCT_ID||'100000008'==item.PRODUCT_ID)&&'0021'==item.ITEM_ID){
								conditionEthernal=true;
								if('0014'==b.split('#')[0]){
									shake='<option value="'+0+'#'+item.ITEMMP_ID+'"  foo="'+0+'#' +b.split('#')[0] + '"   mpid="'+0+'#'+item.ITEMMP_ID+'"  item="'+0+'#' +item.ITEM_ID + '" >&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
									if(b.split('#')[0]==objsetupwork[indexcount].TOOL_ID&&objsetupwork[indexcount].TOOL_ID!=null&&objsetupwork[indexcount].TOOL_ID!=''){
									jsondata['toolid']='setTool'+index;
									jsondata['toolvalue']=0+'#'+item.ITEMMP_ID;
									}
							   							   uncerObj['itemmp']=item.ITEMMP_ID;
							   uncerObj['toolid']=b.split('#')[0];
							   uncerObj['col']='setuncer_'+indexcount;
								let toolidsub='';
								let resultsub='';
								let resultArr=[];
								for (var key in toolArr) {
								    if (toolArr.hasOwnProperty(key)) {
									toolidsub= toolArr[key].split('|');
								    if(toolidsub[1]==b.split('#')[0]&&toolidsub[2]==item.ITEMMP_ID){
										resultsub=toolArr[key];
										break;
									}
								    }
								}
								resultArr=resultsub.split('|');
							   
								uncerObj['uncer']=resultArr[3];
							   //uncerObj['uncer']=seqTool2;
							   uncerArray.push(uncerObj);
				
								}else if('0012'==b.split('#')[0]){
									ftir='<option value="'+1+'#'+item.ITEMMP_ID+'"  foo="'+1+'#' +b.split('#')[0] + '"   mpid="'+1+'#'+item.ITEMMP_ID+'"  item="'+1+'#' +item.ITEM_ID + '" >&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
									if(b.split('#')[0]==objsetupwork[indexcount].TOOL_ID&&objsetupwork[indexcount].TOOL_ID!=null&&objsetupwork[indexcount].TOOL_ID!=''){
									jsondata['toolid']='setTool'+index;
									jsondata['toolvalue']=1+'#'+item.ITEMMP_ID;
									}
							   							   uncerObj['itemmp']=item.ITEMMP_ID;
							   uncerObj['toolid']=b.split('#')[0];
							   uncerObj['col']='setuncer_'+indexcount;
								let toolidsub='';
								let resultsub='';
								let resultArr=[];
								for (var key in toolArr) {
								    if (toolArr.hasOwnProperty(key)) {
									toolidsub= toolArr[key].split('|');
								    if(toolidsub[1]==b.split('#')[0]&&toolidsub[2]==item.ITEMMP_ID){
										resultsub=toolArr[key];
										break;
									}
								    }
								}
								resultArr=resultsub.split('|');
							   
								uncerObj['uncer']=resultArr[3];
							   //uncerObj['uncer']=seqTool2;
							   uncerArray.push(uncerObj);
								}else if('0015'==b.split('#')[0]){
									gc='<option value="'+2+'#'+item.ITEMMP_ID+'"  foo="'+2+'#' +b.split('#')[0] + '"   mpid="'+2+'#'+item.ITEMMP_ID+'"  item="'+2+'#' +item.ITEM_ID + '" >&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
									if(b.split('#')[0]==objsetupwork[indexcount].TOOL_ID&&objsetupwork[indexcount].TOOL_ID!=null&&objsetupwork[indexcount].TOOL_ID!=''){
									jsondata['toolid']='setTool'+index;
									jsondata['toolvalue']=2+'#'+item.ITEMMP_ID;
									}
							   							   uncerObj['itemmp']=item.ITEMMP_ID;
							   uncerObj['toolid']=b.split('#')[0];
							   uncerObj['col']='setuncer_'+indexcount;
								let toolidsub='';
								let resultsub='';
								let resultArr=[];
								for (var key in toolArr) {
								    if (toolArr.hasOwnProperty(key)) {
									toolidsub= toolArr[key].split('|');
								    if(toolidsub[1]==b.split('#')[0]&&toolidsub[2]==item.ITEMMP_ID){
										resultsub=toolArr[key];
										break;
									}
								    }
								}
								resultArr=resultsub.split('|');
							   
								uncerObj['uncer']=resultArr[3];
							   //uncerObj['uncer']=seqTool2;
							   uncerArray.push(uncerObj);
								}else if('0011'==b.split('#')[0]){
									if(b.split('#')[0]==objsetupwork[indexcount].TOOL_ID&&objsetupwork[indexcount].TOOL_ID!=null&&objsetupwork[indexcount].TOOL_ID!=''){
									jsondata['toolid']='setTool'+index;
									jsondata['toolvalue']=3+'#'+item.ITEMMP_ID;
									}
							   							   uncerObj['itemmp']=item.ITEMMP_ID;
							   uncerObj['toolid']=b.split('#')[0];
							   uncerObj['col']='setuncer_'+indexcount;
								let toolidsub='';
								let resultsub='';
								let resultArr=[];
								for (var key in toolArr) {
								    if (toolArr.hasOwnProperty(key)) {
									toolidsub= toolArr[key].split('|');
								    if(toolidsub[1]==b.split('#')[0]&&toolidsub[2]==item.ITEMMP_ID){
										resultsub=toolArr[key];
										break;
									}
								    }
								}
								resultArr=resultsub.split('|');
							   
								uncerObj['uncer']=resultArr[3];
							   //uncerObj['uncer']=seqTool2;
							   uncerArray.push(uncerObj);
				
									eralitic='<option value="'+3+'#'+item.ITEMMP_ID+'"  foo="'+3+'#' +b.split('#')[0] + '"   mpid="'+3+'#'+item.ITEMMP_ID+'"  item="'+3+'#' +item.ITEM_ID + '" >&nbsp;&nbsp;' + b.split('#')[1] + '</option>'
								}
							   
				
						}else{
						if(b.split('#')[0]==objsetupwork[indexcount].TOOL_ID&&objsetupwork[indexcount].TOOL_ID!=null&&objsetupwork[indexcount].TOOL_ID!=''){
							jsondata['toolid']='setTool'+index;
							jsondata['toolvalue']=seqTool+'#'+item.ITEMMP_ID;
						}	  
							   uncerObj['itemmp']=item.ITEMMP_ID;
							   uncerObj['toolid']=b.split('#')[0];
							   uncerObj['col']='setuncer_'+indexcount;
								let toolidsub='';
								let resultsub='';
								let resultArr=[];
								for (var key in toolArr) {
								    if (toolArr.hasOwnProperty(key)) {
									toolidsub= toolArr[key].split('|');
								    if(toolidsub[1]==b.split('#')[0]&&toolidsub[2]==item.ITEMMP_ID){
										resultsub=toolArr[key];
										break;
									}
								    }
								}
								resultArr=resultsub.split('|');
							   
								uncerObj['uncer']=resultArr[3];
							   //uncerObj['uncer']=seqTool2;
							   uncerArray.push(uncerObj);
							   det +='<option value="'+seqTool+'#'+item.ITEMMP_ID+'"  foo="'+seqTool+'#' +b.split('#')[0] + '"    mpid="'+seqTool+'#'+item.ITEMMP_ID+'"  item="'+seqTool+'#' +item.ITEM_ID + '" >&nbsp;&nbsp;' + b.split('#')[1] + '</option>'

						}
        			   

					   seqTool++;
					   ++indextools;
		
            		   })
					   if(conditionEthernal){
							det +=shake+ftir+gc+eralitic;
					   }
            		   det += '</select></td>';
            	     }
					
					det += '<td class="text-center" ><input class="min form-control" type="number" maxlength="12"  id="setmin_'+indexcount+'" value="'+unitArray[indexcount].SPEC_MIN+'"></td>';
					det += '<td class="text-center" ><input class="max form-control" type="number" maxlength="12"  id="setmax_'+indexcount+'" value="'+unitArray[indexcount].SPEC_MAX+'"></td>';
					det += '<td class="text-center" ><input class="max form-control" type="text" maxlength="20"  id="setspecbasic_'+indexcount+'" value="'+unitArray[indexcount].SPEC_BASIC_TEXT+'"></td>';
					if(unitArray[indexcount].COLOR==''){
						det += '<td class="text-center" ><input class="color form-control" type="text"  id="setcolor_'+indexcount+'" value="" disabled></td>';
					}else{
						colorObj={};
						colorObj['id']='setcolor_'+indexcount;
						colorObj['value']=unitArray[indexcount].COLOR;
						colorSet.push(colorObj);
						det += '<td class="text-left" ><select class="color form-control" id="setcolor_'+indexcount+'" ">'
						if(unitArray[indexcount].FLG_INPUT_TYPE=='V'){
							for(var i =0;i<objVisual.length;i++){
								det +='<option value="'+objVisual[i].CODE+'">'+objVisual[i].NAME+'</option>'
							}
						}else{
							for(var i =0;i<objColor.length;i++){
								if(unitArray[indexcount].FLG_INPUT_TYPE=='C'){
									if(objColor[i].ID!='05'&&objColor[i].ID!='06'&&objColor[i].ID!='99'){
									det +='<option value="'+objColor[i].ID+'">'+objColor[i].COLOR_NAME+'</option>'
									}
									
								}else{
									det +='<option value="'+objColor[i].ID+'">'+objColor[i].COLOR_NAME+'</option>'
								}
								
							}
						}
						
						
						det += '</select></td>';
					}
					
					det += '<td class="text-center" ><input class="uncer form-control" maxlength="30" type="text" onkeyup="changeUncer(this)" foo="uncer|'+unitArray[indexcount].ITEM_ID+'|'+unitArray[indexcount].ITEMMP_ID+'" id="setuncer_'+indexcount+'" value=""></td>';
            	     //det +='</select></td>'
					if(item.STATUS_CHK=="Y"){
						stat='ใช้งาาน';
					}else{
						stat='ไม่ใช้งาน';
					}
					det += '<td class="text-center" ><input class="unit form-control" maxlength="50" type="text"  id="setunit_'+indexcount+'"  value="'+unitArray[indexcount].ITEM_UNIT+'"></td>';
	                det += '<td class="text-center" >'+stat+'</td>';
					if(indextools>1){
 					det += '<td class="text-center" ><input type="checkbox" class="editdrop" name="editdropdown" id="editbox_'+indexcount+'" /></td>';
					}else{
					det += '<td class="text-center" ><input type="checkbox" class="editdrop" name="editdropdown" id="editbox_'+indexcount+'" disabled="disabled"/></td>';	
					}
					if(unitArray[indexcount].IS_ENABLE_TOOLS=='Y'){
						editdropcheck.push('editbox_'+indexcount);
					}
					
	               
	               det +='</tr>';
//	       	}         
	       	 listsetup.push(jsondata);
			
   	      ++index_col; 		
		 ++indexcount;
	
		conditionEthernal=false;
		shake='';
		ftir='';
		gc='';
		eralitic='';
		})
		
	   
	   if (det == '') {
           $('#assiDetialWork').html(det);
           HideWaiting();
       } else {
           $('#assiDetialWork').html(det);
           HideWaiting();

       }
       table = $('#assiDetialTWork').DataTable({
           searching: true,
           responsive: false,
           "pageLength": 50,
           "paging":   false,
			"columnDefs": [
			{ "width": "10%", "targets": 5 },
			{ "width": "10%", "targets": 6 },
    		{ "width": "10%", "targets": 7 }
  			]

       });                

		   for(var k =0;k<colorSet.length;k++){
			 $('#'+colorSet[k].id).val(colorSet[k].value);
		   }
	       HideWaiting();
	       setSelect2ById();
		   setupdropdownfortrigger=listsetup;
		    renderDropdownWithConfig();
		   renderCheckBoxEdit();
	

	
}
function renderCheckBoxEdit(){
	for(var i=0;i<editdropcheck.length;i++){
		$('#'+editdropcheck[i]).attr('checked',true);
	}
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

function changeUncer(item){
	let colsplit=$(item).attr('textcol').split('#');
	for(var i=0;i<uncerArray.length;i++){
		if(colsplit[0]==uncerArray[i].itemmp&&colsplit[1]==uncerArray[i].toolid){
			uncerArray[i].uncer=item.value;
		}
	
	}
}
//เดี๋ยวว่างๆ จะมาแก้ให้โค้ดมันดีกว่านี้ --เกรท
function changetUsertype(item){
	var id = item.value.split('#')[1];
	if($('#setTool'+id).val()!=$('#setMethod'+id).val() && $('#setMethod'+id+' option').length > 1){
		$('#setMethod'+id).val(item.value).trigger('change');
		
		
	}
	let itemmp = item.value.split('#')[1];
	let toolid = $('#setTool'+id+' option:selected').attr('foo').split('#')[1];
	for(var i=0;i<uncerArray.length;i++){
		if(itemmp==uncerArray[i].itemmp&&toolid==uncerArray[i].toolid){
			$('#'+uncerArray[i].col).val(uncerArray[i].uncer);
			$('#'+uncerArray[i].col).attr('textcol', itemmp+'#'+toolid);
		}
	
	}
	
//	console.log('#setTool'+id);
//	console.log(item.value);
//	console.log($('#setTool'+id+' option:selected').attr('foo'));
	
//	var itemID = $(item).attr("foo");
//	var idUser = item.value.split('#')[1];
//	if(itemID != "0010" && itemID!="0021" && itemID!="0011" && itemID!="0012" && "0"==$("#setTool"+idUser).val().split("#")[0]){ //Auto
//		$.each($("#setUsertype"+idUser+" option"),function(i,item){
//			if("0008"==item.value || "0009"==item.value){
//				$(this).attr('disabled','disabled');
//			}else{
//				$(this).removeAttr('disabled');
//			}		
//		});
//		$("#setUsertype"+idUser).val("0013").change();
//		
//	}else if(itemID != "0010" && itemID!="0021" && itemID!="0011" && itemID!="0012" && "1"==$("#setTool"+idUser).val().split("#")[0]){ //Manual
//		$.each($("#setUsertype"+idUser+" option"),function(i,item){
//			if("0013"==item.value){
//				$(this).attr('disabled','disabled');
//			}else{
//				$(this).removeAttr('disabled');
//			}
//		});
//		$("#setUsertype"+idUser).val("0008").change();
//	}else if(itemID != "0010" && itemID=="0021" && "0"!=$("#setTool"+idUser).val().split("#")[0]){
//		$.each($("#setUsertype"+idUser+" option"),function(i,item){
//			if("0013"==item.value){
//				$(this).attr('disabled','disabled');
//			}else{
//				$(this).removeAttr('disabled');
//			}
//		});
//		$("#setUsertype"+idUser).val("0009").change();
//	}else if(itemID != "0010" && itemID=="0021" && "0"==$("#setTool"+idUser).val().split("#")[0]){
//		$.each($("#setUsertype"+idUser+" option"),function(i,item){
//			if("0009"==item.value){
//				$(this).attr('disabled','disabled');
//			}else{
//				$(this).removeAttr('disabled');
//			}
//		});
//		$("#setUsertype"+idUser).val("0013").change();
//	}else if(itemID != "0010" && itemID=="0011" && "0"==$("#setTool"+idUser).val().split("#")[0]){
//		$.each($("#setUsertype"+idUser+" option"),function(i,item){
//			if("0011"==item.value){
//				$(this).attr('disabled','disabled');
//			}else{
//				$(this).removeAttr('disabled');
//			}
//		});
//		$("#setUsertype"+idUser).val("0014").change();
//	}else if(itemID != "0010" && itemID=="0011" && "1"==$("#setTool"+idUser).val().split("#")[0]){
//		$.each($("#setUsertype"+idUser+" option"),function(i,item){
//			if("0014"==item.value){
//				$(this).attr('disabled','disabled');
//			}else{
//				$(this).removeAttr('disabled');
//			}
//		});
//		$("#setUsertype"+idUser).val("0011").change();
//	}else if(itemID != "0010" && itemID=="0012" && "0"==$("#setTool"+idUser).val().split("#")[0]){
//		$.each($("#setUsertype"+idUser+" option"),function(i,item){
//		
//			if("0011"==item.value){
//				$(this).attr('disabled','disabled');
//			}else{
//				$(this).removeAttr('disabled');
//			}
//		});
//		$("#setUsertype"+idUser).val("0014").change();
//	}else if(itemID != "0010" && itemID=="0012" && "1"==$("#setTool"+idUser).val().split("#")[0]){
//		$.each($("#setUsertype"+idUser+" option"),function(i,item){
//			if("0014"==item.value){
//				$(this).attr('disabled','disabled');
//			}else{
//				$(this).removeAttr('disabled');
//			}
//		});
//		$("#setUsertype"+idUser).val("0011").change();
//	}else{
//		
//	}
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

function SetDropDownProduct() {
    $('#ddlProduct').val("");
    try {
        $('#ddlProduct').html("");
        jQuery.ajax({
            url: 'util-getDropdownProduct',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                var txt = '';
                $.each(data, function(i, item) {
                        $('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
                        txt += item.PRODUCT_ID + ',';
                });
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }
                $('#ddlProduct').select2({
                    dropdownAutoWidth: true,
                    width: 'auto'
                }); 

            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}

function SetDropSampleType() {
    $('#ddlSampleType').val("");
    try {
        $('#ddlSampleType').html("");
        jQuery.ajax({
            url: 'util-getDropdownSampleType',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                var txt = '';
                $.each(data, function(i, item) {
                        $('#ddlSampleType').append('<option value="' + item.SAMPLE_TYPE_CODE + '">&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
                        txt += item.PRODUCT_ID + ',';
                });
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }
                $('#ddlSampleType').select2({
                    dropdownAutoWidth: true,
                    width: 'auto'
                }); 

            },
            error: function() {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}
function selectAllNew(){
	 	var table = $('#assiDetialTWork').DataTable();
		
		    	  $('#example-select-all').on('click', function(){
		    	      // Check/uncheck all checkboxes in the table
		    	      var rows = table.rows({ 'search': 'applied' }).nodes();
		    	      $('input[type="checkbox"]', rows).prop('checked', this.checked);
		    	   });

		    	   // Handle click on checkbox to set state of "Select all" control
		    	   $('#example tbody').on('change', 'input[type="checkbox"]', function(){
		    	      // If checkbox is not checked
		    	      if(!this.checked){
		    	         var el = $('#example-select-all').get(0);
		    	         // If "Select all" control is checked and has 'indeterminate' property
		    	         if(el && el.checked && ('indeterminate' in el)){
		    	            // Set visual state of "Select all" control 
		    	            // as 'indeterminate'
		    	            el.indeterminate = true;
		    	         }
		    	      }
		    	   });
	}
	
function searchData(){
	querySpecLTRAssignment($('#ddlProduct').val(), $('#ddlSampleType').val());
}

Object.size = function(obj) {
  var size = 0,
    key;
  for (key in obj) {
    if (obj.hasOwnProperty(key)) size++;
  }
  return size;
};

function saveDataforuse(status){
	

	var res_check=checkWorkWait();
	if(res_check.countwork>0){
	$('#warning_setting').modal({
    backdrop: 'static',
    keyboard: false
	});
		$('#message_warn').html("");
		$('#message_warn').append(res_check.message);
		return null;
	}
	//console.log(status);
	 var itemmp_id =  "";
	 $("input[name='chke']").each(function() {  
		
    	        if($(this).prop('checked')){
	console.log($(this).val());
    	        	     for(var i=0;i<tmp_data.length;i++){
    			 			  if($(this).val()==tmp_data[i]){   
    			 				 itemmp_id += "'"+$(this).val()+"',";   ;
    			 			  } 
    			 		 }	 
    	        }
	 });
	 itemmp_id = itemmp_id.substring(0,itemmp_id.length-1);		 
	 try {
	    var data = {}
	    data["itemmp_id"] = itemmp_id;
	    data["status"] = status;
	    ShowWaiting();
	    jQuery.ajax({
			url : 'updateMPSpecAssign',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
						showMsgSuccess('สำเร็จ');
						//SetDropDownProduct();
						//querySPITEMforSetting($('#ddlProduct').val(), $('#ddlSampleType').val());
						querySpecLTRAssignment($('#ddlProduct').val(), $('#ddlSampleType').val());
						HideWaiting() ;
			},
			error : function() {
						showMsgError('ข้อมูลผิดพลาด');
						HideWaiting() ;
			}
			});  
	} catch (ex) {
		showMsgError(ex);
		HideWaiting() ;
	}
}
function getListMethod(prdid,sampleid){ 
	var list ='';
	 try {
	    var data = {}
		    data["productID"] = prdid;
		    data["sampleType"] = sampleid;
		   //console.log(JSON.stringify(data));
	    ShowWaiting();
	    jQuery.ajax({
			url : 'util-getlistMethod',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
				list=data;
			},
			error : function() {
						showMsgError('ข้อมูลผิดพลาด');
						HideWaiting() ;
			}
			});  
	} catch (ex) {
		showMsgError(ex);
		HideWaiting() ;
	}
	return list;
}
function saveUnit(){
	saveUncer();
	let specMinarr='';
	let specMaxarr='';
	//let specUncerArr='';
	let specColorArr='';
	let specColorObjArr='';
	let itemidArr='';
	let itemMpIdArr='';
	let unitArr='';
	let editcheckarr='';
	let editSpecBasicArr=''
	
	
		$('.min').each(function(i) {
		 
		  specMinarr+=$('#setmin_'+i).val()+',';
		  specMaxarr+=$('#setmax_'+i).val()+',';
		  specColorArr+=$('#setcolor_'+i).val()+',';
		  //specUncerArr+=$('#setuncer_'+i).val()+',';
		  specColorObjArr+=$( '#setcolor_'+i+' option:selected' ).text()+',';
		  editSpecBasicArr+=$('#setspecbasic_'+i).val()+',';
		  if($('#setunit_'+i).val()!=null&&$('#setunit_'+i).val()!=''&&$('#setunit_'+i).val().trim()=='°C'){
			unitArr+='C,';
		  }else{
			unitArr+=$('#setunit_'+i).val()+',';
		  }
		  

		
		});
		$("input[name='editdropdown']").each(function() {  
		
    	        if($(this).prop('checked')){
					editcheckarr+='Y'+',';
    	        }else{
					editcheckarr+='N'+',';
				}
	    });
		for(var i=0;i<unitArray.length;i++){
			itemidArr+=unitArray[i].ITEM_ID+',';
			itemMpIdArr+=unitArray[i].ITEMMP_ID+',';
		}
		specMinarr=specMinarr.substring(0,specMinarr.length-1);
		specMaxarr=specMaxarr.substring(0,specMaxarr.length-1);
		//specUncerArr=specUncerArr.substring(0,specUncerArr.length-1);
		specColorArr=specColorArr.substring(0,specColorArr.length-1);
		itemidArr=itemidArr.substring(0,itemidArr.length-1);
		itemMpIdArr=itemMpIdArr.substring(0,itemMpIdArr.length-1);
		specColorObjArr=specColorObjArr.substring(0,specColorObjArr.length-1);
		unitArr=unitArr.substring(0,unitArr.length-1);
		editcheckarr=editcheckarr.substring(0,editcheckarr.length-1);
		editSpecBasicArr=editSpecBasicArr.substring(0,editSpecBasicArr.length-1);
		
		
		console.log(itemidArr);
		console.log(itemMpIdArr);
		console.log(specMinarr);
		console.log(specMaxarr);
		//console.log(specUncerArr);
		console.log(specColorArr);
		console.log(specColorObjArr);
		console.log(unitArr);
		console.log(editcheckarr);
		 try {
	    var data = {}
		    data["colorDataAss"] = specColorArr;
		    //data["uncerDataAss"] = specUncerArr;
			data["specMaxDataAss"] = specMaxarr;
			data["specMinDataAss"] = specMinarr;
			data["itemMpDataAss"] = itemMpIdArr;
			data["itemIdDataAss"] = itemidArr;
			data["productID"]  =$('#ddlProduct').val();
			data["sampleType"]  =$('#ddlSampleType').val();
			data["colorObjDataAss"]  =specColorObjArr;
			data["unitDataAss"]  =unitArr;
			data["isEnabled"]  =editcheckarr;
			data["spec"]  =editSpecBasicArr;
			
		  
	
	    jQuery.ajax({
			url : 'util-saveSpecUnit',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(res) {
				
			},
			error : function() {
						showMsgError('ข้อมูลผิดพลาด');
						
			}
			});  
	} catch (ex) {
		showMsgError(ex);
		
	}
		
		

}

function saveUncer(){

	let specUncerArr='';
	let specItemmpArr='';
	let specToolIdArr='';
	
	for(var i=0;i<uncerArray.length;i++){
		//if(uncerArray[i].uncer!=''&&uncerArray[i].uncer!=null){
			specUncerArr+=uncerArray[i].uncer+',';
			specItemmpArr+=uncerArray[i].itemmp+',';
			specToolIdArr+=uncerArray[i].toolid+',';
		//}
	}
		specUncerArr=specUncerArr.substring(0,specUncerArr.length-1);
		specItemmpArr=specItemmpArr.substring(0,specItemmpArr.length-1);
		specToolIdArr=specToolIdArr.substring(0,specToolIdArr.length-1);
		 try {
	    var data = {}

		    data["uncerDataAss"] = specUncerArr;
			data["itemMpDataAss"] = specItemmpArr;
			data["toolsDataAss"] = specToolIdArr;
			data["productID"] = $('#ddlProduct').val();
			data["sampleType"] = $('#ddlSampleType').val();
	    jQuery.ajax({
			url : 'util-saveSpecUncer',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(res) {
				
			},
			error : function() {
						showMsgError('ข้อมูลผิดพลาด');
						
			}
			});  
	} catch (ex) {
		showMsgError(ex);
		
	}
		
		

}

function querySPITEMforSetting(productID,sampleType){
	//console.log(productID);
	var listMethoddata='';
	  	try {

 		      $('#dteIdwork').html("");
				
 	  	      $('#myTableDteIdWork').DataTable().destroy();
 		 
		    			var data = {}
		    			data["productID"] = productID;
		    			data["sampleType"] = sampleType;
		    			//console.log(JSON.stringify(data));
		    			ShowWaiting();
					  jQuery.ajax({
						url : 'querySPITEM',
						type : "Post", 
						contentType : "application/json",
						data : JSON.stringify(data), 
						dataType : 'json',
						async: false,
						cache: false,
						beforeSend: function() {
              				listMethoddata=getListMethod(productID,sampleType);
					
           				 },
						success : function(data) {
							
							var det = '';
							tmp_data = data;
							//console.log(data.list.length);
							if(data.list.length != '0'){
								for (var i = 0; i < data.list.length; i++){	  
									det +='<tr  class="TBODY">';
									det +='<td class="text-center" >'+ (i+1) +'</td>';
									det += '<td class="text-center" ><input type="checkbox" id="chke" name="chke" value="'+(data.list[i].ITEMMP_ID==null?"":data.list[i].ITEMMP_ID)+'" /> </td>';
									det +='<td class="text-center" >'+ (data.list[i].ITEM_NAME==null?"":data.list[i].ITEM_NAME)+'</td>';
									det +='<td class="text-center" ><select class="form-control" style="text-align-last: center;">';
									for(var j =0;j<listMethoddata.length;j++){
									if(data.list[i].ITEM_ID==listMethoddata[j].ITEM_ID){
									det+="<option value='"+listMethoddata[j].ITEM_ID+"' >"+listMethoddata[j].METHOD_NAME+"</option>";	
									}
									}
									
									det +='</select></td>';
									
									det +='<td class="text-center" ><select></select></td>';
									det +='<td class="text-center" >'+ (data.list[i].STATUS_NAME==null?"":data.list[i].STATUS_NAME)+'</td>';
									det += '</tr> ';
								}
								$('#dteIdwork').html(det);
								HideWaiting() ;	
							}else{
								det += '<tr> ';
								det += '<td class="text-center"></td> ';
								det += '<td class="text-center"></td> ';
								det += '<td class="text-center">---ไม่พบข้อมูล--</td> ';
								det += '<td class="text-center"></td> ';
								det += '<td class="text-center"></td> ';
								det += '<td class="text-center"></td> ';
								det += '</tr> ';
								$('#dteIdwork').html(det);
								HideWaiting() ;	
							}
							
							
							
							HideWaiting() ;
						},
						error : function() {
							showMsgError('ข้อมูลผิดพลาด');
							HideWaiting() ;
						},complete: function (data) {
     					$('#myTableDteIdWork').DataTable( {
							paging :   false,
							searching: true,
							responsive : true,
							"columnDefs": [
										{  "targets": 0 }
							]
					});
     				}
					});  
		} catch (ex) {
			 showMsgError(ex);
			HideWaiting() ;
		}
		
 } 
function getVisual(){
	 try {
	    jQuery.ajax({
			url : 'util-getVisual',
			type : "Get", 
			contentType : "application/json",
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
			objVisual=data;

			},
			error : function() {
						showMsgError('ข้อมูลผิดพลาด');
					
			}
			});  
	} catch (ex) {
		showMsgError(ex);
		
	}
}
function getColorSetup(){
	 try {
	    jQuery.ajax({
			url : 'util-getColor',
			type : "Get", 
			contentType : "application/json",
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
			objColor=data;
			},
			error : function() {
						showMsgError('ข้อมูลผิดพลาด');
						HideWaiting() ;
			}
			});  
	} catch (ex) {
		showMsgError(ex);
		HideWaiting() ;
	}
	
}

function ShowWaiting() {
	waitingDialog.show();
	  
}
function HideWaiting() {
	waitingDialog.hide();
}
