<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="<c:url value="/assets/css/settingTestScroll.css" />" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>

<script type="text/javascript"> 

$(document).ready(function () {
	
    SetDropDownTypeStation();
    $('#myTableSpareDteId').DataTable( {
		searching: true,
		responsive : true,
		paging: false,
		fixedHeader: true
	});
    
});

function SetDropDownRegion(typeStation){
	try {	 
		
		  $('#ddlArea').find('option').remove().end(); 
		    var select = document.getElementById('ddlArea');
			var opt = document.createElement('option');
			opt.value = "";
			opt.style ='';
			opt.innerHTML = "==เลือก==";
			select.appendChild(opt); 
			
		  $('#ddlRegion').find('option').remove().end(); 
			    var select = document.getElementById('ddlRegion');
				var opt = document.createElement('option');
				opt.value = "";
				opt.style ='';
				opt.innerHTML = "==เลือก==";
				select.appendChild(opt); 
    		  
		  
		var data = {}
		data["typeStation"] = typeStation;
		// alert(data);
		  jQuery.ajax({
			url : 'util-getDropdownRegion',
			type : "Post", 
			contentType : "application/json",
			data :  JSON.stringify(data),  
			dataType : 'json',
			  async: false,
			   cache: false,
			success : function(data) {
				
				console.log(data);
		 
				 $('#ddlRegion').find('option').remove().end(); 
				    var select = document.getElementById('ddlRegion');
					var opt = document.createElement('option');
					opt.value = "";
					opt.style ='';
					opt.innerHTML = "==เลือก==";
					select.appendChild(opt); 
				 var	opt = "" ;
				// alert(data.length);
				for (var i = 0; i < data.length; i++) {
				 	var opt = document.createElement('option');
					opt.value = data[i].PART;
					opt.innerHTML = data[i].PART;
					select.appendChild(opt); 
				}          
			},
			error : function() {
				//swal("error");
				showMsgError('เกิดข้อผิดพลาด!');
			}
		});

	} catch (ex) {
		//swal(ex);
		showMsgError(ex); 
		 
	}
}

function SetDropDownTypeStation(){
	try {
		 
	 $('#ddlRegion').find('option').remove().end(); 
		    var select = document.getElementById('ddlRegion');
			var opt = document.createElement('option');
			opt.value = "";
			opt.style ='';
			opt.innerHTML = "==เลือก==";
			select.appendChild(opt); 
	 
			
	 $('#ddlArea').find('option').remove().end(); 
		    var select = document.getElementById('ddlArea');
			var opt = document.createElement('option');
			opt.value = "";
			opt.style ='';
			opt.innerHTML = "==เลือก==";
			select.appendChild(opt); 
	
			
	  $('#ddlProvince').find('option').remove().end(); 
		    var select = document.getElementById('ddlProvince');
			var opt = document.createElement('option');
			opt.value = "";
			opt.style ='';
			opt.innerHTML = "==เลือก==";
			select.appendChild(opt); 		
			
		  jQuery.ajax({
			url : 'util-getDropdownTypeStation',
			type : "Post", 
			contentType : "application/json",
			dataType : 'json',
			  async: false,
			   cache: false,
			success : function(data) {
		 
			      $('#ddlTypeStation').find('option').remove().end();
	 
			    var select = document.getElementById('ddlTypeStation');
				var opt = document.createElement('option');
				opt.value = "";
				opt.style ='';
				opt.innerHTML = "==เลือก==";
				select.appendChild(opt);
				 
			 
				 var	opt = "" ;
				// alert(data.length);
				for (var i = 0; i < data.length; i++) {
				 	var opt = document.createElement('option');
					opt.value = data[i].TYPE_STATION;
					opt.innerHTML = data[i].TYPE_STATION;
					select.appendChild(opt); 
				}            
				
		 
		 
			},
			error : function() {
				//swal("error");
				showMsgError('เกิดข้อผิดพลาด!');
			}
		});

	} catch (ex) {
		//swal(ex);
		showMsgError(ex); 
		 
	}
}

function SetDropDownArea(region){
	try {
		 
		 
			
		 $('#ddlArea').find('option').remove().end(); 
		    var select = document.getElementById('ddlArea');
			var opt = document.createElement('option');
			opt.value = "";
			opt.style ='';
			opt.innerHTML = "==เลือก==";
			select.appendChild(opt); 
			
		  $('#ddlProvince').find('option').remove().end(); 
			    var select = document.getElementById('ddlProvince');
				var opt = document.createElement('option');
				opt.value = "";
				opt.style ='';
				opt.innerHTML = "==เลือก==";
				select.appendChild(opt); 
	    		  	
		  if(region==""){
			  return false;
		  }	
				
		
		var data = {}
		data["region"] = region;
		
		  jQuery.ajax({
			url : 'util-getDropdownArea',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			  async: false,
			   cache: false,
			success : function(data) {
		 
			   $('#ddlArea').find('option').remove().end();
			 
			 var select = document.getElementById('ddlArea');
				var opt = document.createElement('option');
				opt.value = ""; 
				opt.innerHTML = "==เลือก==";
				select.appendChild(opt);
				 
			 
				 var	opt = "" ;
				// alert(data.length);
				for (var i = 0; i < data.length; i++) {
				 	var opt = document.createElement('option');
					opt.value = data[i].PLACE;
					opt.innerHTML = data[i].PLACE;
					select.appendChild(opt); 
					            
				}
		 
			},
			error : function() {
				//swal("error");
				showMsgError('เกิดข้อผิดพลาด!');
			}
		});

	} catch (ex) {
		//swal(ex);
		showMsgError(ex); 
		 
	}
}


function SetDropDownProvince(area){
	try {
		 
		  $('#ddlProvince').find('option').remove().end(); 
		    var select = document.getElementById('ddlProvince');
			var opt = document.createElement('option');
			opt.value = "";
			opt.style ='';
			opt.innerHTML = "==เลือก==";
			select.appendChild(opt); 
		
		if(area==""){
			return false;
		}	
			
		var data = {}
		data["area"] = area;
		data["region"] = $("#ddlRegion").val();
		
		  jQuery.ajax({
			url : 'util-getDropdownProvince',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			  async: false,
			   cache: false,
			success : function(data) {
		 
			   $('#ddlProvince').find('option').remove().end();
			 
			 var select = document.getElementById('ddlProvince');
				var opt = document.createElement('option');
				opt.value = ""; 
				opt.innerHTML = "==เลือก==";
				select.appendChild(opt);
				 
			 
				 var	opt = "" ;
				// alert(data.length);
				for (var i = 0; i < data.length; i++) {
				 	var opt = document.createElement('option');
					opt.value = data[i].ADDR_PROVINCE;
					opt.innerHTML = data[i].ADDR_PROVINCE;
					select.appendChild(opt); 
					            
				}
		 
			},
			error : function() {
				//swal("error");
				showMsgError('เกิดข้อผิดพลาด!');
			}
		});

	} catch (ex) {
		//swal(ex);
		showMsgError(ex); 
		 
	}
}


function inquiryMBStationMaster(){

  	 try {
  		 if( $("#ddlTypeStation").val()!="" && $("#ddlRegion").val()!="") {
  		 
  		ShowWaiting();
		
  		 // $("input[name='hidden_namestore']").each(function() { 
				 // alert($(this).val());
			 	var nameStore   = $("#hidden_namestore").val();
  		    $('#dteIdSpare').html("");
  	  		 
 		    $('#myTableSpareDteId').DataTable().destroy();
 		    $('#popup_spareRandomOil').modal('show');
		    	var data = {}
		    		data["area"] = $("#ddlArea").val() ; 
		    		data["region"] = $("#ddlRegion").val(); 
		    		data["province"] = $("#ddlProvince").val(); 
					
		    	jQuery.ajax({
						url : 'inquiryMBStationMaster',
						type : "Post", 
						contentType : "application/json",
						data : JSON.stringify(data), 
						dataType : 'json', 
						success : function(data) {
					    // alert(data.success);
							if(data.success==1){
							 var det = "";
							    //alert(data.list.length);
							              tmpdata_plan = data
										 for (var i = 0; i < data.list.length; i++) {

											det +='<tr>';
											det +='<td class="text-center" >'+(data.list[i].COST_CENTER==null?"":data.list[i].COST_CENTER)+'</td>';
										    det +='<td class="text-left" >'+(data.list[i].PART==null?"":data.list[i].PART)+'</td>';
		   								
											det +='<td class="text-left" >'+(data.list[i].PLACE==null?"":data.list[i].PLACE)+'</td>'; 
										
											det +='<td class="text-left" >'+ (data.list[i].CENTER_NAME==null?"":data.list[i].CENTER_NAME)+'</td>';
											det +='<td class="text-left" >'+(data.list[i].ADDR_TUMBON==null?"":data.list[i].ADDR_TUMBON)+'</td>';
											det +='<td class="text-left" >'+ (data.list[i].ADDR_AMPHUR==null?"":data.list[i].ADDR_AMPHUR)+'</td>';
											det +='<td class="text-left" >'+(data.list[i].ADDR_PROVINCE==null?"":data.list[i].ADDR_PROVINCE)+'</td>'; 
											//det +='<td class="text-center" >'+(data.list[i].MODEL==null?"":data.list[i].MODEL)+'</td>'; 
											det +='<td class="text-center" >'; 
											det +='<select onchange="SaveModel('+data.list[i].COST_CENTER+',this.value)">'; 
											det +='<option '+(data.list[i].MODEL==null?"selected":"")+' value="">เลือกเกรด</option>'; 
											det +='<option '+(data.list[i].MODEL=="A+"?"selected":"")+' value="A+">A+</option>'; 
											det +='<option '+(data.list[i].MODEL=="A"?"selected":"")+' value="A">A</option>';
											det +='<option '+(data.list[i].MODEL=="B+"?"selected":"")+' value="B+">B+</option>';
											det +='<option '+(data.list[i].MODEL=="B"?"selected":"")+' value="B">B</option>'; 
											det +='<option '+(data.list[i].MODEL=="C+"?"selected":"")+' value="C+">C+</option>'; 
											det +='<option '+(data.list[i].MODEL=="C"?"selected":"")+' value="C">C</option>';
											det +='<option '+(data.list[i].MODEL=="D+"?"selected":"")+' value="D+">D+</option>';
											det +='<option '+(data.list[i].MODEL=="D"?"selected":"")+' value="D">D</option>'; 
											det +='</select>';
											det +='<span class="resuleUpdateModel'+(data.list[i].COST_CENTER==null?"":data.list[i].COST_CENTER)+'"></span>'; 
											det +='</td>'; 
										  
										    det +='</tr>';
										}
										 // alert(det);
										if(det==''){
											det += '<tr> ';
											det += '<th colspan="8" class="text-center">--- ไม่พบข้อมูล ---</th> ';
											det += '</tr> ';
											$('#dteIdSpare').html(det);
											  
										}else{
										//	alert('#dteId_'+nameStore);
											$('#dteIdSpare').html(det);
										
											table =  $('#myTableSpareDteId').DataTable( {
	 											searching: true,
	 											responsive : true,
	 											paging: false,
	 											fixedHeader: true
	 										});
										} 
									 
							}else{
							 
								 showMsgError(data.message);
								/* jAlert('error', data.message,'ข้อมูลผิดพลาด');
								 $.alert({
				                   title: 'ข้อมูลผิดพลาด',
				                   icon: 'fa fa-error',
				                   type: 'red',
				                   content: data.message,
				               });*/
							}
							
							setTimeout(function(){ HideWaiting(); }, 1000);
						},
						error : function() {
							/* $.alert({
			                   title: 'error',
			                   icon: 'fa fa-error',
			                   type: 'red',
			                   content: 'ข้อมูลผิดพลาด',
			               	});*/
							showMsgError('ข้อมูลผิดพลาด');
						}
				});
  		// });	 
  		 } else {
  			showMsgWarning('โปรดระบุข้อมูล สถานี และ ภาค ');
  		 }
		} catch (ex) {
		 HideWaiting() ;
			/* $.alert({
             title: 'error',
             icon: 'fa fa-error',
             type: 'red',
             content: 'ข้อมูลผิดพลาด',
         });*/
			 showMsgError('ข้อมูลผิดพลาด');
		}
  	 
} 


function SaveModel(costcenter,grad){
	
	if(costcenter!=undefined && costcenter!="" || grad!=undefined && grad!=""){
		var data = {}
		data["costcenter"] = costcenter;
		data["grad"] = grad;
		data["createBy"] = $('.text-muted').html().trim().replace("User ID :", "");
		// alert(data);
		  jQuery.ajax({
			url : 'update_Model',
			type : "Post", 
			contentType : "application/json",
			data :  JSON.stringify(data),  
			dataType : 'json',
			  async: false,
			   cache: false,
			success : function(data) {
				//console.log(data.success);
				if(data.success==1){
					$('.resuleUpdateModel'+costcenter).css('font-size','10px');
					$('.resuleUpdateModel'+costcenter).css('color','#5ab201');
					$('.resuleUpdateModel'+costcenter).html('ปรับเปลี่ยนสำเร็จ');
				}else{
					$('.resuleUpdateModel'+costcenter).css('font-size','10px');
					$('.resuleUpdateModel'+costcenter).css('color','red');
					$('.resuleUpdateModel'+costcenter).html('เกิดข้อผิดพลาด!');
				}
			},
			error : function() {
				//swal("error");
				$('.resuleUpdateModel'+costcenter).css('font-size','10px');
				$('.resuleUpdateModel'+costcenter).css('color','red');
				$('.resuleUpdateModel'+costcenter).html('เกิดข้อผิดพลาด!');
			}
		});
	}
	
}


</script>


<div class="modal progressModel" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      
      <div class="modal-body modal-bodycus">
      
      	โปรดรอ......
      
      </div>
      
    </div>
  </div>
</div>

<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
	    <h2>ตั้งค่าเกรด</h2>
	</div>
	<div class="col-lg-2"></div>
</div>

<div class="zoneBody">

	<div class="wrapper wrapper-btn text-right">
		<div class="row">
			<div class="col-xs-12 col-md-12 boxGroupCus">
			
				<div class="col-xs-12 col-md-6">
				
					<div class="col-xs-12 col-md-12 text-left titleSelct" style="text-indent:10px;"><strong> บริษัท <span style="color:#F00;float: right;">*</span> </strong></div>
			      	<div class="col-xs-12 col-md-12 text-left">
						<select class="form-control select5Inp" onchange="SetDropDownRegion(this.value)" name="ddlTypeStation" id="ddlTypeStation"> 
						  <option value="all">ทั้งหมด</option>
						</select>
			      	</div>
				
				</div>
				
				<div class="col-xs-12 col-md-6">
				
					<div class="col-xs-12 col-md-12 text-left titleSelct" style="text-indent:10px;"><strong> ภาค  <span style="color:#F00;float: right;">*</span></strong></div>
			      	<div class="col-xs-12 col-md-12 text-left">
						<select class="form-control select5Inp" onchange="SetDropDownArea(this.value)" name="ddlRegion" id="ddlRegion"> 
						  <option value="all">ทั้งหมด</option>
						</select>
			      	</div>
				
				</div>
				
				<div class="col-xs-12 col-md-6">
				
					<div class="col-xs-12 col-md-12 text-left titleSelct" style="text-indent:10px;"><strong> เขต <span style="color:#F00;float: right;">*</span></strong></div>
			      	<div class="col-xs-12 col-md-12 text-left">
						<select class="form-control select5Inp" onchange="SetDropDownProvince(this.value)" name="ddlArea" id="ddlArea"> 
						  <option value="all">ทั้งหมด</option>
						</select>
			      	</div>
				
				</div>
				
				<div class="col-xs-12 col-md-6">
				
					<div class="col-xs-12 col-md-12 text-left titleSelct" style="text-indent:10px;"><strong> จังหวัด </strong></div>
			      	<div class="col-xs-12 col-md-12 text-left">
						<select class="form-control select5Inp" name="ddlProvince" id="ddlProvince"> 
						  <option value="all">ทั้งหมด</option>
						</select>
			      	</div>
				
				</div>
		      	
		      	<div class="col-xs-12 col-md-12 text-right" style="margin-top:10px;">
		      		<button type="button" class="btn btn-primary " onclick="inquiryMBStationMaster()">Search</button>
		      	</div>
		      </div>
		</div>
	</div>
	
	
	<div class="zoneBody">
		<div class="wrapper wrapper-btn" style="top:70px">
			<div class="row">
				<div class="col-xs-12">
					<div class="table-responsive"   >
						<table   id="myTableSpareDteId" class="table table-striped table-bordered" style="padding: 0px;">
							<thead>
								<tr class="tbHeader">
									     
									<th style="width:15%"   class="text-center">cost center</th>
									<th style="width:10%" class="text-center">ภาค</th>
									<th style="width:5%" class="text-center">เขต</th>
									
									<th style="width:20%"   class="text-center">ชื่อสถานี</th>
									<th style="width:15%" class="text-center">แขวง</th>
									<th style="width:15%" class="text-center">อำเภอ</th>
									<th style="width:15%" class="text-center">จังหวัด</th>
									<th style="width:15%" class="text-center">เกรด</th>
									
								</tr>
							</thead>
							<tbody id="dteIdSpare" > </tbody>
						</table> 
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
	

</div>

<script src="<c:url value="/assets/js/settingTestscore.js" />" type="text/javascript"></script>