$(document).ready(function(){
	init();
});
var basePath = '/Lab/api/';
//User Type
var userTypeSetText = "";

var dataGroup = [];
var dataInGroup = [];
var dataGroupUserTypeDTL = [];

//Get Data from Database
var dataUserTypeID = [];
var dataUserTypeDTL = [];
var dataNameT = [];
var dataCodempID = [];

//Update Data
var updateData = [];
function init(){
	checkLevel();
	addGroup();
	addUser();
	connectSortable();
	//SET DATA
	for(var i=0;i<dataGroup.length;i++){
		$('#group'+dataGroup[i]).append('<div class="ibox float-e-margins set-padding datagroup'+i+'" >');
		$('.datagroup'+i).append('<div class="ibox-title'+i+'">').append('<div class="ibox-content inside-data ibcondatagroup'+i+' collapse" id="colls'+i+'">');
		$('.ibox-title'+i).append('<div class="ibox-tools'+i+'">');
		$('.ibox-tools'+i).append('<label>'+dataGroupUserTypeDTL[i]+'</label><a data-toggle="collapse" data-target="#colls'+
				i+'" style="float:right"><i class="glyphicon glyphicon-menu-down"></i></a>');
		$('.ibcondatagroup'+i).append('<ul class="connectedSortable center" id="inGroup'+dataGroup[i]+'"></ul>');	
		for(var u=0;u<dataUserTypeID.length;u++){
			if(dataGroup[i]==dataUserTypeID[u]){
				$('#inGroup'+dataGroup[i]).append('<li class="connectedSortableUser" id="'+dataCodempID[u]+'">'+dataNameT[u]+'</li>');
				
				
			}
		}
	}	
	connectSortable();
	console.log(userTypeSetText);
//	if(userTypeSetText=='0007'){
//		$("#tableSetup").removeClass("connectedGroupSortableCC");
//	}	
	//console.log(dataUserTypeID);
	//console.log(dataUserTypeDTL);
	//console.log(dataNameT);
	//console.log(dataCodempID);	
}
function checkLevel(){
	//userTypeSetText = "level";
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
            	console.log(data);
            	for(var i=0;i<data.list.length;i++){
            		userTypeSetText = data.list[0].USER_TYPE_ID;
            	}
            	console.log(userTypeSetText);
            	
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
function connectSortable(){
	//console.log(dataGroup.length);
	var setConnnet = "";
	for(var i=0;i<dataGroup.length;i++){
		setConnnet += "#inGroup"+dataGroup[i]+',';
	}
	setConnnet = setConnnet.substring(0,setConnnet.length-1);
	//console.log(setConnnet);
	//ConnectSortable
	$( "#tableSetup, #tableTmp" ).sortable({
	      connectWith: ".connectedSortableG",
	      beforeStop : function( event, ui ) {
	    		  setSortLevel();
	    	  },
	    	  change : function( event, ui ) {
	    		  setSortLevel();
	    	  }
	}).disableSelection();
	$( "#tableSetup, #tableTmp" ).sortable({
	      connectWith: ".connectedGroupSortable"
	}).disableSelection();
	
	$(setConnnet).sortable({
	      connectWith: ".connectedSortable"	    	  
	}).disableSelection();
	//SET VALUE
	$(setConnnet).sortable({
        update: function(event, ui) {     
            //alert(ui.item.attr('id'));
        	updateData.push(ui.item.attr('id'));
        }	
	});
	
}
/*function setSortLevel(){
	//background-color: coral;
	$("#tableSetup :first-child").css({"padding-left" : "0px"});
	$("#tableSetup :nth-child(2)").css({"padding-left" : "20px"});
	$("#tableSetup :nth-child(3)").css({"padding-left" : "40px"});
	$("#tableSetup :nth-child(4)").css({"padding-left" : "60px"});
	$("#tableSetup :nth-child(5)").css({"padding-left" : "80px","color":"red"});
	$("#tableSetup :nth-child(6)").css({"padding-left" : "100px","color":"red"});
	$("#tableSetup :nth-child(7)").css({"padding-left" : "120px","color":"red"});
	$("#tableSetup :nth-child(8)").css({"padding-left" : "140px"});
	$("#tableSetup :nth-child(9)").css({"padding-left" : "140px"});
	$("#tableSetup :nth-child(10)").css({"padding-left" : "140px"});
	$("#tableSetup :nth-child(11)").css({"padding-left" : "140px"});
	$("#tableSetup :nth-child(12)").css({"padding-left" : "140px"});
	$("#tableSetup :nth-child(13)").css({"padding-left" : "140px"});
	$("#tableSetup :nth-child(14)").css({"padding-left" : "140px"});
	//$("#tableSetup").css({"padding-left" : "100px"});
	
	for(var i = 0 ; i < $("#tableSetup ul").length; i++){
		if(i>7){
			$("#tableSetup :nth-child("+i+")").css({"padding-left" : "120px"});
		}	
	}
	
	//console.log($("#tableSetup ul").length);
	
}*/
function addGroup(){
	$("#tableSetup").val("");
	$("#tableTmp").val("");
	    try {
	    	$("#tableSetup").html("");
	    	$("#tableTmp").html("");
	    	var data = {};
	        jQuery.ajax({
	            url: 'getGroupUserTypeID',
	            type: "Post",
	            contentType: "application/json",
	            data : JSON.stringify(data), 
	            dataType: 'json',
	            async: false,
	            cache: false,
	            success: function (data) {
	               for(var i=0;i<data.list.length;i++){
	            	   //console.log(data.list[i].USER_TYPE_ID);
	            	   //$("#tableSetup").append('<li class="connectedSortableG center list-group-item-primary" id="group'+data.list[i].USER_TYPE_ID+'"></li>');
        	
	            	   //ADD TO 2 Table
//	            	   if(userTypeSetText == '0007'){
//	            		   if(data.list[i].USER_TYPE_ID == "0007" || data.list[i].USER_TYPE_ID == "0008" ||
//		            	   			data.list[i].USER_TYPE_ID == "0009" || data.list[i].USER_TYPE_ID == "0010" || //A4
//		            	   			data.list[i].USER_TYPE_ID == "0011" ||data.list[i].USER_TYPE_ID == "0012" ||
//		            	   			data.list[i].USER_TYPE_ID == "0013" ||data.list[i].USER_TYPE_ID == "0014" ||
//		            	   			data.list[i].USER_TYPE_ID == "0002"	){            	   		
//		            	   		$("#tableSetup").append('<li class="connectedSortableG center" id="group'+data.list[i].USER_TYPE_ID+'"></li>');
//		            	   	}
//	            	   }else{
	            		   $("#tableSetup").append('<li class="connectedSortableG center" id="group'+data.list[i].USER_TYPE_ID+'"></li>');
//	            	   }
	                	/*if(usertype=='A1'){
	                		if(data.list[i].USER_TYPE_ID == "0007" || data.list[i].USER_TYPE_ID == "0008" ||
		            	   			data.list[i].USER_TYPE_ID == "0009" || data.list[i].USER_TYPE_ID == "0010" ||
		            	   			data.list[i].USER_TYPE_ID == "0011" ||data.list[i].USER_TYPE_ID == "0012" ||
		            	   			data.list[i].USER_TYPE_ID == "0013" ||data.list[i].USER_TYPE_ID == "0014" ){            	   		
		            	   		$("#tableSetup").append('<li class="connectedSortableG center" id="group'+data.list[i].USER_TYPE_ID+'"></li>');
		            	   	}
	                	}else{
	                		$("#tableSetup").append('<li class="connectedSortableG center list-group-item-primary" id="group'+data.list[i].USER_TYPE_ID+'"></li>');	
	                	}	*/
	                	dataGroup.push(data.list[i].USER_TYPE_ID);
	                	dataGroupUserTypeDTL.push(data.list[i].USER_TYPE_DTL);
	               }
	               console.log()
	               //setSortLevel();
	               //console.log(dataGroup);
	            },
	            error: function () {
	                showMsgError('เกิดข้อผิดพลาด');
	            }
	        });

	    } catch (ex) {
	        showMsgError(ex);

	    }	
}
function addUser(){	
    try {
    	var data = {};
        jQuery.ajax({
            url: 'getUserMapping',
            type: "Post",
            contentType: "application/json",
            data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
               for(var i=0;i<data.list.length;i++){  
            	   dataUserTypeID.push(data.list[i].USER_TYPE_ID);
            	   dataUserTypeDTL.push(data.list[i].USER_TYPE_DTL);
            	   dataNameT.push(data.list[i].NAMET);
            	   dataCodempID.push(data.list[i].CODEMP_ID);
               }
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }   
}
function getData(){
	var dataResult = [];	
	//In Group
	$(".connectedSortable").each(function(i){
		var nameGroup = "";	
		i++;
		nameGroup = this.id;
		//console.log(nameGroup);
		var data = [];
		$('#'+this.id+' > li').each(function(){
			//console.log(this);
			var obj = {
					id : this.id,
					name : $(this).text()
			};
	        data.push(obj);
	    });
		nameGroup = { 
				"group": nameGroup,
		      	"emp" : data
		};
		dataResult.push(nameGroup);
	});
	return dataResult;
}
function saveData(){
	var arr= $('#tableSetup ul').toArray();
	var sendGroupID ="";
	for(var ar=0;ar<arr.length;ar++){
		//console.log(arr[ar].id);
		sendGroupID += "'"+arr[ar].id.split("p")[1]+"',"
	}
	sendGroupID = sendGroupID.substring(0,sendGroupID.length-1);
	console.log(sendGroupID);
	
	var dataResultS = [];
	var userID = "";
	var userGroup = "";
	dataResultS = getData();
	//SET VALUE UPDATE
	updateData = updateData.filter(unique);
	for (i in dataResultS){
		for(j in dataResultS[i].emp){
			var result = dataResultS[i].emp[j];
			//console.log(result.id+"|"+result.name);
			for(var t=0;t<updateData.length;t++){
				if(result.id==updateData[t]){
					userID += "'"+result.id+"',";
					userGroup += "'"+dataResultS[i].group.substring(7,11)+"',"
					console.log(dataResultS[i].group.substring(7,11));
				}
			}
			
		}
	}
	userID = userID.substring(0,userID.length-1);
	userGroup = userGroup.substring(0,userGroup.length-1);
	//console.log(userID+"|"+userGroup)
	 try {
	    	var data = {};
	    	data["userID"] = userID; 
	    	data["groupID"] = userGroup;
	    	data["sendGroupMap"] = sendGroupID;
	    	
	    	console.log(JSON.stringify(data));
	        jQuery.ajax({
	            url: 'updateUserGroupWorkFlow',
	            type: "Post",
	            contentType: "application/json",
	            data : JSON.stringify(data), 
	            dataType: 'json',
	            async: false,
	            cache: false,
	            success: function (data) {
	            	showMsgSuccess('สำเร็จ');
	            },
	            error: function () {
	                showMsgError('เกิดข้อผิดพลาด');
	            }
	        });

	    } catch (ex) {
	        showMsgError(ex);

	    }   
}
function unique(value, index, self) { 
    return self.indexOf(value) === index;
}
function gotoMain(){
    window.location="/Lab/home";
}
function showData(){
	//updateData = updateData.substring(0,updateData.length-1);
	//console.log(updateData);
	updateData = updateData.filter(unique);
	var strUpdateData = "";
	for(var d=0;d<updateData.length;d++){
		strUpdateData += "'"+updateData[d]+"',";
	}
	strUpdateData = strUpdateData.substring(0,strUpdateData.length-1);
	
	console.log(strUpdateData);
	var dataResult = [];
	//var dataResultGroup = [];
	dataResult = getData();
	//dataResultGroup = getDataGroup();
	//LOOP READ VALUES JSON
	for (i in dataResult){
		for(j in dataResult[i].emp){
			var result = dataResult[i].emp[j];
			//console.log(result.id+"|"+result.name);
			for(var t=0;t<updateData.length;t++){
				if(result.id==updateData[t]){
					console.log(result.id+'|'+dataResult[i].group.substring(7,11));
					//userID += "'"+result.id+"',";
					//userGroup += "'"+dataResultS[i].group.substring(7,11)+"',"
				}
			}
		}
	}

	
}