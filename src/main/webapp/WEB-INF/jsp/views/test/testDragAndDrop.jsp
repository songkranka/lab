<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="<c:url value="/assets/css/settingTestScroll.css" />"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="assets/plugins/datepicker/bootstrap-datepicker.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Sortable/1.6.0/Sortable.js"></script>
<style>
	#A1, #B1 {
    border: 2px solid #3b2121;
    width: 100%;
    min-height: 75px;
    list-style-type: none;
    margin: 0;
    padding: 5px;
  	}
  	.center {
  	text-align: center;
  	margin: auto;
    }
  	#A1 :first-child{
  		padding-left: 5px;
  	}
  	#B1 :first-child{
  		padding-left: 5px;
  	}
  	#A1 li:nth-child(3){
  		padding-left: 60px;
  	}
  	#B1 :nth-child(3){
  		padding-left: 60px;
  	} 	
  	#A1 li, #B1 li {
    font-size: 1.2em;
    width: 100%;
    text-align: center;
    padding-left: 30px;

  }
    #A2, #B2 , #C2{
    border: 2px solid #3b2121;
    width: 100%;
    min-height: 75px;
    list-style-type: none;
    margin: 0px;
    padding: 5px;  
  }
  #A2.connectedSortable li, #B2.connectedSortable li , #C2.connectedSortable li {
 	margin-top: 5px;
    padding: 5px;
    font-size: 1.2em;
    width: 100%;
    text-align: center !important;
  }
  
  #A2 {background: DarkOliveGreen !important;}
  #B2 {background: DarkMagenta !important;}
  #C2 {background: DarkGoldenRod !important;}
  .ui-state-highlight-u1 { background: DarkGray !important; cursor: default; }
  .ui-state-highlight-u2 { background: DarkGray !important; cursor: default; }
  .ui-state-highlight-u3 { background: DarkGray !important; cursor: default; }
</style>
<script type="text/javascript">
$(document).ready(function(){

	checkGroup();
	
	$( "#A2, #B2 , #C2 , #A1, #B1 " ).sortable({
	      connectWith: ".connectedSortable"
	}).disableSelection();
	
	$( "#A1, #B1" ).sortable({
	      connectWith: ".connectedSortable"
	}).disableSelection();
	$( "#A1, #B1" ).sortable({
	      connectWith: ".connectedGroupSortable"
	}).disableSelection();
	
	//$("#A2").remove();
	//$("#A1").append($("#A2"));
	//$("#A1").append($("#BBB"));
	
	//$( "#sortable1" ).draggable();
	//$( "#sortable2" ).draggable();
	
	//$( "#sortable1" ).draggable({ handle: "p" });
	//$( "div, p" ).disableSelection();
});
function checkGroup(){
    try {  	
    	var data = {};
    	data["typeValueDAD"] = "checkGroup";
        jQuery.ajax({
            url: 'testDragAndDrop',
            type: "Post",
            contentType: "application/json",
            data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
            	$.each(data, function (i, item) {
            		console.log(item.HEAD_GROUP+"|"+item.GROUP_ID+"|"+item.LEVEL_GH);
            		if(item.HEAD_GROUP == "A1"){
            			if(item.GROUP_ID == "A2" ){
  							$("#A1").append($("#AAA"));
            			}
            			else if(item.GROUP_ID == "B2"){
            				$("#A1").append($("#BBB"));
            			}
            			else{
  							$("#A1").append($("#CCC"));

            			}               		
            		}
            		else if(item.HEAD_GROUP == "B1"){
            			if(item.GROUP_ID == "A2" ){
  							$("#B1").append($("#AAA"));
            			}
            			else if(item.GROUP_ID == "B2"){
            				$("#B1").append($("#BBB"));
            			}
            			else{
  							$("#B1").append($("#CCC"));

            			}               		
            		}
            		else{
                		console.log(item.HEAD_GROUP+"|"+item.GROUP_ID);
                	}    
            		SetGroupA();
            		SetGroupB();	
            		SetGroupC();
                });
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}
function SetGroupA() {
	$('#A2').val("");
    try {
    	$('#A2').html("");

    	var data = {};
    	data["typeValueDAD"] = "A2";
        jQuery.ajax({
            url: 'testDragAndDrop',
            type: "Post",
            contentType: "application/json",
            data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
                $.each(data, function (i, item) {
                	$('#A2').append('<li class="ui-state-highlight-u1" id="'+item.EMP_ID+'" name="' + item.NAME_EMP + '">' + item.NAME_EMP + '</li>');             	
                });
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}
function SetGroupB() {
	$('#B2').val("");
    try {
    	$('#B2').html("");
    	var data = {};
    	data["typeValueDAD"] = "B2";
        jQuery.ajax({
            url: 'testDragAndDrop',
            type: "Post",
            contentType: "application/json",
            data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
                $.each(data, function (i, item) {
                   	$('#B2').append('<li class="ui-state-highlight-u2" id="'+item.EMP_ID+'" name="' + item.NAME_EMP + '">' + item.NAME_EMP + '</li>');                      
                });
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}
function SetGroupC() {
	$('#C2').val("");
    try {
    	$('#C2').html("");
    	var data = {};
    	data["typeValueDAD"] = "C2";
        jQuery.ajax({
            url: 'testDragAndDrop',
            type: "Post",
            contentType: "application/json",
            data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
                $.each(data, function (i, item) {
                   	$('#C2').append('<li class="ui-state-highlight-u3" id="'+item.EMP_ID+'" name="' + item.NAME_EMP + '">' + item.NAME_EMP + '</li>');                      
                });
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}
function clearData(){
	console.log("Clear Data !!");
	checkGroup();
}

function updateLevelGroup(groupDAD,headGroupDAD,typeValue,idDAD) {
    try {
    	var data = {};
    	data["typeValueDAD"] = typeValue;
    	data["groupDAD"] = groupDAD;
    	data["headGroupDAD"] = headGroupDAD;
    	data["idDAD"] = idDAD;
    	console.log(JSON.stringify(data));
        jQuery.ajax({
            url: 'testDragAndDrop',
            type: "Post",
            contentType: "application/json",
            data : JSON.stringify(data), 
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
            	showMsgSuccess('บันทึกข้อมูลเรียบร้อย');
            },
            error: function () {
                showMsgError('เกิดข้อผิดพลาด');
            }
        });

    } catch (ex) {
        showMsgError(ex);

    }
}
function save(){
	saveData();
	saveDataGroup();
}
function saveData(){
	console.log("Save Data !!");
	//IN GROUP
	var dataResult = [];
	dataResult = getData();
	//console.log(JSON.stringify(dataResult));
	var idB2 = "",idA2 = "",idC2="";
	for (var i = 0; i<dataResult.length;i++ ){
		if(dataResult[i].group == 'B2'){
			for(j in dataResult[i].emp){
				var result = dataResult[i].emp[j];
				idB2 += "'"+result.id+"',";
			}
		}
		else if(dataResult[i].group == 'A2'){
			for(j in dataResult[i].emp){
				var result = dataResult[i].emp[j];
				idA2 += "'"+result.id+"',";
			}
		}
		else if(dataResult[i].group == 'C2'){
			for(j in dataResult[i].emp){
				var result = dataResult[i].emp[j];
				idC2 += "'"+result.id+"',";
			}
		}
	}
	idB2 = idB2.substring(0, idB2.length - 1);
	idA2 = idA2.substring(0, idA2.length - 1);
	idC2 = idC2.substring(0, idC2.length - 1);
	//updateData(idB2,"","B2");
	//updateData(idA2,"","A2");
	//updateLevelGroup(groupDAD,headGroupDAD,typeValue,idDAD)
	updateLevelGroup("'A2','B2','C2'","","updateData",idA2+"|"+idB2+"|"+idC2);
}
function saveDataGroup(){
	//GROUP
	var dataResultGroup = [];
	dataResultGroup = getDataGroup();
	//console.log(JSON.stringify(dataResultGroup));
	var idB1G = "",idA1G = "",idC1G = "";
	for (var iG = 0; iG<dataResultGroup.length;iG++ ){
		//console.log(dataResultGroup[iG].group);
		if(dataResultGroup[iG].group == 'A1'){
			for(jG in dataResultGroup[iG].emp){
				var result = dataResultGroup[iG].emp[jG];
				if(result.id == "AAA"){
					idA1G += "'A2',";
				}
				else if(result.id == "BBB"){
					idA1G += "'B2',";
				}
				else if(result.id == "CCC"){
					idA1G += "'C2',";
				}
				//console.log(result.id+"|A1");
			}
		}
		else if(dataResultGroup[iG].group == 'B1'){
			for(jG in dataResultGroup[iG].emp){
				var result = dataResultGroup[iG].emp[jG];
				if(result.id == "AAA"){
					idB1G += "'A2',";
				}
				else if(result.id == "BBB"){
					idB1G += "'B2',";
				}
				else if(result.id == "CCC"){
					idB1G += "'C2',";
				}
				//console.log(result.id+"|B1");
			}
		}
		//updateData(idDAD,nameDAD,groupDAD)
	}
	idA1G = idA1G.substring(0, idA1G.length - 1);
	idB1G = idB1G.substring(0, idB1G.length - 1);
	idC1G = idC1G.substring(0, idC1G.length - 1);
	//updateLevelGroup(groupDAD,headGroupDAD,typeValue,idDAD)
	updateLevelGroup(idA1G+"|"+idB1G+"|"+idC1G,"'A1','B1'","updateDataGroup");
	updateLevelGroup(idA1G+"|"+idB1G+"|"+idC1G,"'A1','B1'","updateLevelGroup");
}
function showData(){
	var dataResult = [];
	var dataResultGroup = [];
	dataResult = getData();
	dataResultGroup = getDataGroup();
	//LOOP READ VALUES JSON
	for (i in dataResult){
		for(j in dataResult[i].emp){
			var result = dataResult[i].emp[j];
			console.log(result.id+"|"+result.name);
		}
	}
	for (i in dataResultGroup){
		for(j in dataResultGroup[i].emp){
			var result = dataResultGroup[i].emp[j];
			console.log(result.id+"|"+result.name);
		}
	}
	console.log(JSON.stringify(dataResult));
	console.log(JSON.stringify(dataResultGroup));
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
			var obj = {
					id : this.id,
					name : $(this).attr('name')
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
function getDataGroup(){
	var dataResultGroup = [];
	$(".connectedGroupSortable").each(function(i){
		var nameGroup = "";	
		i++;
		nameGroup = this.id;
		//console.log(nameGroup);
		var data = [];
		$('#'+this.id+' > li').each(function(){
			var obj = {
					id : this.id,
					name : $(this).attr('name')
			};
	        data.push(obj);
	    });
		nameGroup = { 
				"group": nameGroup,
		      	"emp" : data
		};
		dataResultGroup.push(nameGroup);
	});
	return dataResultGroup;
}

</script>
<div class="testSortable">
		<div class="row">
			<span class="col-sm-4 center">
				<label>Table 1</label>
			</span>
			<span class="col-sm-4 center">
				<label>Table 2</label>
			</span>
		</div>
		<div class="row">
			<div class="col-sm-4" >	
			<ul id="A1" class="connectedGroupSortable center">
				<li id="AAA" name="GROUP A" class="connectedSortable center">
					<ul id="A2" class="connectedSortable center">			
					</ul>
				</li>
				<li id="CCC" name="GROUP C" class="connectedSortable center">
					<ul id="C2" class="connectedSortable center">			
					</ul>
				</li>
			</ul>	
				
			</div>
			<div class="col-sm-4">
				<ul id="B1" class="connectedGroupSortable center">
				<li id="BBB" name="GROUP B" class="connectedSortable center">
					<ul id="B2" class="connectedSortable center">
					</ul>
				</li>
			</ul>
			</div>							
		</div>
</div>
<div><p></p></div>
<div>
			<button onclick="showData()">Show JSON</button>
			<button onclick="clearData()">Refresh</button>
			<button onclick="save()">Save</button>
</div>

