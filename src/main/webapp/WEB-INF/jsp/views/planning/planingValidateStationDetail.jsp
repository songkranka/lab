<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.tbHeader {
	background: #3c8dbc;
	color: white;
}
.TBODY{
	font-size:  10px; 
}
.dtr-details{
	font-size:  10px; 
}
.border-bottomDiv{
    	border-bottom:    solid black;
 	}
#myTablePlaningDetailId td input.form-control-gridplan {
	
}
</style>
<!-- <div class="box box-success box-solid"> -->
<script type='text/javascript'>
var table = "";
var  tripId  = "";
var count = 0;
var countPlan = 0;
var no = 0;
var noPlan = 0;
var next = 0;
var amtPerMile = 0;
var amtPerHotel = 0;
var tmpdata_plan = [] ,listCodeStationA=[],listCodeStationB=[],resultA=[],resultB=[];
    $(document).ready(function () {
    	
        $('#datetimepicker1').datepicker({
            orientation: "auto",
            autoclose: true,
            format: 'dd/mm/yyyy',
            todayHighlight: true
            
        });
        $('#datetimepicker2').datepicker({
            orientation: "auto",
            autoclose: true,
            format: 'dd/mm/yyyy',
            todayHighlight: true
        });
    	
		//SetDropDownRole();
    	// SetDropDownRegion();
        getSetupRandom();
        SetDropDownTypeStation();
        initParam();
        
        
        $('body').on('show.bs.modal', function () { $(this).removeAttr("style"); }); 
        $('body').on('hidden.bs.modal', function () { $(this).removeAttr("style"); })
        
        
        
        //case A
        $('#addA').click(function() {
        	   var codestation=$('#station_selectedA').val();
        	   var listvalue = $('#textboxA').val();
        	   var listoption = $("#mb_productA option:selected").text();
        	   var codeproduct = $("#mb_productA").val();
        	   var data={};
        	   data["TRIP_ID"]=$('#tripId').val();
        	   data["PRODUCT_ID"]=codeproduct;
        	   data["COST_CENTER"]=codestation;
        	   data["PRODUCT_NAME"]=listoption;
        	   data["CAUSE"]=listvalue;

        	   if(!validatedataA(codestation,codeproduct)){
        	   //service add	   
        	   resultA.push(data);
        	   saveProductA();
        	   }
        	   //check station code
        	    $("#textboxA").val("");

        	  
        	   
        	 });


        	
        //case B	
        	
        	 $('#addB').click(function() {
        	   var codestation=$('#station_selectedB').val();
          	   var listvalue = $('#textboxB').val();
          	   var listoption = $("#mb_productB option:selected").text();
          	   var codeproduct = $("#mb_productB").val();
          	   var ncr = $("#ncr_no").val();
          	   
        	   var data={};
        	   data["TRIP_ID"]=$('#tripId').val();
        	   data["PRODUCT_ID"]=codeproduct;
        	   data["COST_CENTER"]=codestation;
        	   data["PRODUCT_NAME"]=listoption;
        	   data["CAUSE"]=listvalue;
        	   data["NCR_NO"]=ncr;
        	   
        	   if(!validatedataB(codestation,codeproduct)){
        	   resultB.push(data);
        	   saveProductB();
        	   }
          	   $("#textboxB").val("");

          	 });

        	
    });
    
    function validatedataA(stationcode,productcode){
    	var result = false;
    	for(var i=0;i<listCodeStationA.length;i++){
    		if(listCodeStationA[i].COST_CENTER==stationcode&&listCodeStationA[i].PRODUCT_ID==productcode){
    			result=true;
    			break;
    		}
    	}
    	return result;
    	
    }
    
    function removeProductA(stationcode,productcode){
    	var tripId = $('#tripId').val();

    	if(tripId==''){
    		return null;
    	}
    	try {
    		 
			  jQuery.ajax({
				url : 'api/report/deleteMBListReceive/'+tripId+'/'+stationcode+'/'+productcode,
				type : "Get", 
				contentType : "application/json",
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {   
					getMBListReceiveOil(stationcode);
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
    function removeProductB(stationcode,productcode){
    	var tripId = $('#tripId').val();
    	if(tripId==''){
    		return null;
    	}
    	try {
    		 
			  jQuery.ajax({
				url : 'api/report/deleteMBListSchedule/'+tripId+'/'+stationcode+'/'+productcode,
				type : "Get", 
				contentType : "application/json",
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {   
					getMBListScheduleOil(stationcode);
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
    function validatedataB(stationcode,productcode){
    	var result = false;
    	for(var i=0;i<listCodeStationB.length;i++){
    		if(listCodeStationB[i].COST_CENTER==stationcode&&listCodeStationB[i].PRODUCT_ID==productcode){
    			result=true;
    			break;
    		}
    	}
    	return result;
    }

 
    function getSetupRandom(){
    	try {
    		 
    		var data = {}

			jQuery.ajax({
				url : 'util-getSetupRandom',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
				success : function(data) {
			 
					for (var i = 0; i < data.length; i++) {
						amtPerMile = data[i].AMT_PERKILO;
						amtPerHotel = data[i].AMT_PERNIGHTHOTEL;
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
    function SetDropDownRole(){
    	try {
    		 
    		var data = {}
			//data["status"] = name;
    		
			  jQuery.ajax({
				url : 'util-getDropdownMBRole',
				type : "Post", 
				contentType : "application/json",
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) {
			 
				   $('#ddlRole').find('option').remove().end();
				//   var opt = name.substring(1, name.length)
				      var select = document.getElementById('ddlRole');
					var opt = document.createElement('option');
					opt.value = "";
					opt.innerHTML = "==เลือก==";
					select.appendChild(opt);
				     
					/* $.each(data, function (i, item) {
					      
				         $(name).append('<option value="' + item.ROLE_ID + '">&nbsp;&nbsp;'+item.ROLE_NAME+'</option>');
				     
				    });
				    
					    $(name).multiselect('rebuild');
					    
					    $(name).multiselect('updateButtonText');
					    $(name).trigger('change');
					  */
					    // $(name).val('');    
					   // $(name).multiselect("refresh");
				
					   // alert(txt);
					  //  $('#ddlStore').val(txt.split(","));    
					  //  $("#ddlStore").multiselect("refresh");
					 var	opt = "" ;
					// alert(data.length);
					for (var i = 0; i < data.length; i++) {
					 	var opt = document.createElement('option');
						opt.value = data[i].ROLE_ID;
						opt.innerHTML = data[i].ROLE_NAME;
						select.appendChild(opt); 
						            
					
				//	opt +=   '<option value="'+data[i].PID+'">'+data[i].PNAMET+'</option>' ;
					       
					}
				 
				//	$("#ddlStore").multiselect('updateOptions', opt);
				//	  $('#ddlStore').select2(); 
			 
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
    function SetDropDownRegion(typeStation){
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
			  
			  SetDropDownProvince("");
					
    		
    		var data = {}
			data["region"] = region;
    		data["typeStation"] = $('#ddlTypeStation').val();
    		
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
					//return false;
				}	
					
        		var data = {}
    			data["area"] = area;
        		data["region"] = $("#ddlRegion").val();
        		data["typeStation"] = $('#ddlTypeStation').val();
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
    	$('#content_edit').hide();
     	$('#th_edit').hide();
     	$('#statuscheck').val('Y');
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
   		    		data["startDate"] = $("#datetimepicker1").val(); 
   		    		data["endDate"] = $("#datetimepicker2").val(); 
   		    		data["typeStation"] = $("#ddlTypeStation").val(); 
   		    		
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
   										  	det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(data.list[i].COST_CENTER==null?"":data.list[i].COST_CENTER)+'" /> </td>';
   		   								
   											det +='<td class="text-left" >'+(data.list[i].PLACE==null?"":data.list[i].PLACE)+'</td>'; 
   										
   											det +='<td class="text-left" >'+ (data.list[i].CENTER_NAME==null?"":data.list[i].CENTER_NAME)+'</td>';
   											det +='<td class="text-left" >'+(data.list[i].ADDR_TUMBON==null?"":data.list[i].ADDR_TUMBON)+'</td>';
   											det +='<td class="text-left" >'+ (data.list[i].ADDR_AMPHUR==null?"":data.list[i].ADDR_AMPHUR)+'</td>';
   											det +='<td class="text-left" >'+(data.list[i].ADDR_PROVINCE==null?"":data.list[i].ADDR_PROVINCE)+'</td>'; 
   											det +='<td class="text-center" >'+(data.list[i].MODEL==null?"":data.list[i].MODEL)+'</td>'; 
   										  
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
   	 											fixedHeader: true,
   	 											order: [[ 8, "asc" ],[ 7, "asc" ],[ 6, "asc" ],[ 5, "asc" ]]
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
    function editdata(){
    	
   	    try{
   	              var array_dt = []
   	            //  alert("editdata") ;     
	   	     	 
		   	      $("input[name='chk']").each(function() { 
		   	     //  alert($(this).prop('checked')+"-"+$(this).val()) ;   
		    	        if($(this).prop('checked')){
		    	        	  //    alert(tmpdata_plan.list.length);
		    	        	     for(var i=0;i<tmpdata_plan.list.length;i++){
		    			 		//	  alert(tmpdata_plan.list[i].COST_CENTER)
		    	        	    	  var valueChk = $(this).val();
		    			 			  if($(this).val()==tmpdata_plan.list[i].COST_CENTER){   
		    			 				   var cntDup = 0;
		    			 				   $("input[name='costCenter']").each(function() { 
		    			 				         if($(this).val().trim()==valueChk){
		    			 				        	cntDup++;
		    			 				         }
				    			 		   });  
		    			 				   if(cntDup==0){
				    			 			      addPlanList(); 
				    			 			       //  alert(tmpdata_plan.list[i].ADDR_AMPHUR);
				    			 			       $('#costCenter'+countPlan).val((tmpdata_plan.list[i].COST_CENTER==null?"":tmpdata_plan.list[i].COST_CENTER));
												    $('#nameCenter'+countPlan).val((tmpdata_plan.list[i].CENTER_NAME==null?"":tmpdata_plan.list[i].CENTER_NAME));
												    $('#addr_tumbon'+countPlan).val((tmpdata_plan.list[i].ADDR_TUMBON==null?"":tmpdata_plan.list[i].ADDR_TUMBON));
												   $('#addr_aumphur'+countPlan).val((tmpdata_plan.list[i].ADDR_AMPHUR==null?"":tmpdata_plan.list[i].ADDR_AMPHUR));
												   $('#addr_province'+countPlan).val((tmpdata_plan.list[i].ADDR_PROVINCE==null?"":tmpdata_plan.list[i].ADDR_PROVINCE));
		    			 				   }
		    			 			  }
		    			 			
		    			 		 }	
		 		    			 
		    	        }
				  });
		   	  										 
		 		  $('#popup_spareRandomOil').modal('hide');
		 		recalSummary();
		 		calTotalWorkDay(noPlan);
		 		calHotelCount();
		 		
		} catch (ex) {
			 
			 
			 showMsgError(ex);
			  HideWaiting() ;
			 
		}
		$('input[type="checkbox"]').prop('checked' , false);
    }
     function updateStatus(status){
    	 
    	 
    	 try {
	    		 $.confirm({
	        		    title: 'ยืนยันยกเลิก',
	        		  icon: 'fa fa-exclamation-circle',
	                type: 'blue',
	                content: '', 
	        		    buttons: {
	        		   'ยืนยัน': function () {   
			 	    
				    					var data = {}
						    			data["status"] = status;
						    			data["trip_id"] = $('#tripId').val(); 
			    		 
										  jQuery.ajax({
											url : 'updateStatusActionPlan',
											type : "Post", 
											contentType : "application/json",
											data : JSON.stringify(data), 
											dataType : 'json',
											  async: false,
											   cache: false,
											success : function(data) {
										 
												if(data.success==1){
												
													              showMsgSuccess('บันทึกสำเร็จ');
																	gotoMain();
																
															 
													 
												}else{
												 
													  showMsgError(data.message);
												}
											},
											error : function() {
												 showMsgError('ข้อมูลผิดพลาด');
											 
											}
										});
						  
	        		   },
	      			  'ยกเลิก': function () {
	      			            
	      			 		 
	      				  
	      			  }
	            		 }
	      	      });
       
		} catch (ex) {
			 
			 showMsgError(ex);
			 
		}
    	 
     } 
	function initParam(){
		var  url = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');    		
		var tripId_v = url[0].split('='); 
		tripId  =  tripId_v[1];
	    if(tripId!=null&&tripId!=''){
	    	$('#tripId').val(tripId);
	    	$('#btnDel').attr('disabled',false);
		  	inquiryRequestAnalysisOilDetail();
	    }else{
	        addStaffList() ;
	    }
	}
	function removePlan(sender) {
		var divId = $(sender).parent().parent().parent() ;
// 		alert(divId.attr('id'));
		$(divId).remove();
		//count--;
		noPlan --;
		
		calTotalWorkDay(noPlan);
		calHotelCount();
		recalSummary();
	}
 
	function removeStaff(sender) {
		var divId = $(sender).parent().parent().parent() ;
// 		alert(divId.attr('id'));
		$(divId).remove();
		//count--;
		no--;
		
		resetNoStaff();
		calTotalWorkDay(noPlan);
		calHotelCount();
		recalSummary();
	}
	function resetNoStaff(){
		var i=1;
		  $("div[name='no']").each(function() { 
       	        $(this).html(i++) ;
		  });
	}
	function inquiryRequestAnalysisOilDetail() {
		try {
			$('#dteId').html('');
			$('#statuscheck').val('N');
			//$('#myTablePlaningDetailId').DataTable().destroy();
			$('#dtePlaningStaff').html('');
			$('#myTablePlaningStaff').DataTable().destroy();

			var data = {}
			data["trip_id"] = tripId; 
			

			jQuery.ajax({
				url : 'inquiryPlaningDetail',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
				success : function(data) {

					if(data.success==1) {
						var det = "";
						for (var i = 0; i < data.list.length; i++) {
							$('#tripName').val((data.list[i].TRIP_NAME==null?"":data.list[i].TRIP_NAME));
							$('#cnt_station').val((data.list[i].CNT_STATION==null?"":data.list[i].CNT_STATION));
							$('#cnt_station_perday').val((data.list[i].CNT_STATION_PERDAY==null?"":data.list[i].CNT_STATION_PERDAY));
							$('#total_day').val((data.list[i].TOTAL_DAY==null?"":data.list[i].TOTAL_DAY));
							$('#allowce_amt_total').val(setNumberFormatTWOFactionAndSeparator(data.list[i].ALLOWCE_AMT_TOTAL==null?"":data.list[i].ALLOWCE_AMT_TOTAL));
							$('#hotel_cnt_night').val((data.list[i].HOTEL_CNT_NIGHT==null?"":data.list[i].HOTEL_CNT_NIGHT));
							$('#hotel_cnt_room').val((data.list[i].HOTEL_CNT_ROOM==null?"":data.list[i].HOTEL_CNT_ROOM));
							$('#hotel_amt_total').val(setNumberFormatTWOFactionAndSeparator(data.list[i].HOTEL_AMT_TOTAL==null?"":data.list[i].HOTEL_AMT_TOTAL));
							$('#total_mile_station').val((data.list[i].TOTAL_MILE_STATION==null?"":data.list[i].TOTAL_MILE_STATION));
							$('#car_amt').val(setNumberFormatTWOFactionAndSeparator(data.list[i].CAR_AMT==null?"":data.list[i].CAR_AMT));
							$('#amt_other').val(setNumberFormatTWOFactionAndSeparator(data.list[i].AMT_OTHER==null?"":data.list[i].AMT_OTHER));
							$('#expense_perstation').val(setNumberFormatTWOFactionAndSeparator(data.list[i].EXPENSE_PERSTATION==null?"":data.list[i].EXPENSE_PERSTATION)); 
							$('#total_amount').val(setNumberFormatTWOFactionAndSeparator(data.list[i].TOTAL_AMOUNT==null?"":data.list[i].TOTAL_AMOUNT));

							for (var j = 0; j < data.list[i].data_station.length; j++) {

								addPlanList(); 
								
								if(data.list[i].data_station[j].TYPE_STATION!='PTF'){
									$('#addP1_'+countPlan).hide();
								}
								$('#planDate'+countPlan).val((data.list[i].data_station[j].PLAN_DATE==null?"":data.list[i].data_station[j].PLAN_DATE.trim()));
								//$('#planDesc'+countPlan).val((data.list[i].data_station[j].PLAN_DESC==null?"":data.list[i].data_station[j].PLAN_DESC));
// 								$('#reviceOil'+countPlan).val((data.list[i].data_station[j].RECEIVEOIL==null?"":data.list[i].data_station[j].RECEIVEOIL));
								$('#planBegin'+countPlan).val((data.list[i].data_station[j].PLACE_BEGIN==null?"":data.list[i].data_station[j].PLACE_BEGIN));
								$('#planEnd'+countPlan).val((data.list[i].data_station[j].PLACE_DESTINATION==null?"":data.list[i].data_station[j].PLACE_DESTINATION));
								$('#miletotal'+countPlan).val((data.list[i].data_station[j].MILE_TOTAL==null?"":setNumberFormatTWOFactionAndSeparator(data.list[i].data_station[j].MILE_TOTAL)));
								$('#seq'+countPlan).val((data.list[i].data_station[j].SEQ==null?"":data.list[i].data_station[j].SEQ));
								$('#costCenter'+countPlan).val((data.list[i].data_station[j].COST_CENTER==null?"":data.list[i].data_station[j].COST_CENTER));
								$('#nameCenter'+countPlan).val((data.list[i].data_station[j].ORG_NAME==null?"":data.list[i].data_station[j].ORG_NAME));
								$('#addr_tumbon'+countPlan).val((data.list[i].data_station[j].ADDR_TUMBON==null?"":data.list[i].data_station[j].ADDR_TUMBON));
								$('#addr_aumphur'+countPlan).val((data.list[i].data_station[j].ADDR_AUMPHUR==null?"":data.list[i].data_station[j].ADDR_AUMPHUR));
								$('#addr_province'+countPlan).val((data.list[i].data_station[j].ADDR_PROVINCE==null?"":data.list[i].data_station[j].ADDR_PROVINCE));

// 								if(data.list[i].data_station[j].RECEIVEOIL=='1'){
// 									$('#reviceOil'+countPlan).prop("checked",true);
// 								}else{
// 									$('#reviceOil'+countPlan).prop("checked",false);
// 								}
								
								
								/*    det +='<tr>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].PLAN_DATE==null?"":data.list[i].data_station[j].PLAN_DATE)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].PLAN_DESC==null?"":data.list[i].data_station[j].PLAN_DESC)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].PLACE_BEGIN==null?"":data.list[i].data_station[j].PLACE_BEGIN)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].PLACE_DESTINATION==null?"":data.list[i].data_station[j].PLACE_DESTINATION)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].MILE_TOTAL==null?"":data.list[i].data_station[j].MILE_TOTAL)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].SEQ==null?"":data.list[i].data_station[j].SEQ)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].COST_CENTER==null?"":data.list[i].data_station[j].COST_CENTER)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].ORG_NAME==null?"":data.list[i].data_station[j].ORG_NAME)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].ADDR_TUMBON==null?"":data.list[i].data_station[j].ADDR_TUMBON)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].ADDR_AUMPHUR==null?"":data.list[i].data_station[j].ADDR_AUMPHUR)+'" /> </td>';

								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid"   class="form-control"   ';
								det += ' value="'+(data.list[i].data_station[j].ADDR_PROVINCE==null?"":data.list[i].data_station[j].ADDR_PROVINCE)+'" /> </td>';


								det +='<td class="text-right" ><div class="col-sm-1" style="padding-left: 0px; color: red;"> <i class="fa  fa-remove (alias)  btnRemove" ' ;
								det +=	' onclick="removePlan(this);"   ';
								det	+=	'	style="font-size: large;"></i><br> ' ;
								det +=	'     </div> </td> '; 


								det +='</tr>';*/
							}
							if(data.list[i].data_station.length==0){
								addPlanList(); 
							}

							/*table =  $('#myTablePlaningDetailId').DataTable( {
								searching: true,
								responsive : true
							});
							if(det==''){
								det += '<tr> ';
								det += '<th colspan="12" class="text-center">--- ไม่พบข้อมูล ---</th> ';
								det += '</tr> ';
								$('#dteId').html(det);
							}else{
								$('#dteId').html(det);
							}*/ 

							det = "";
							for (var j = 0; j < data.list[i].data_officer.length; j++) {
								addStaffList();
								
								getPosition('#codempid'+count,'#ddlRole'+count);
								$('#codempid'+count).val((data.list[i].data_officer[j].CODEMPID==null?"":data.list[i].data_officer[j].CODEMPID));
								$('#codempname'+count).val((data.list[i].data_officer[j].NAMEMPT==null?"":data.list[i].data_officer[j].NAMEMPT));
								//$('#ddlRole'+count).val((data.list[i].data_officer[j].ROLE_ID==null?"":data.list[i].data_officer[j].ROLE_ID));
								$('#ddlRole'+count).val((data.list[i].data_officer[j].NAMEPOST==null?"":data.list[i].data_officer[j].NAMEPOST));
								// $('#ddlRole'+count).multiselect("refresh");
								/*count++;
								no++;
								det +='<tr id="formDefault'+count+'" >';

								det +='<td class="text-center" id="txtNo" >'+ count+'</td>';
								det +='<td class="text-center" ><input type="text" id="codempid" name="codempid" onkeypress="getEmpname(\'#codempid\')"  class="form-control" style="width: 100%;"  ';
								det +='value="'+(data.list[i].data_officer[j].CODEMPID==null?"":data.list[i].data_officer[j].CODEMPID)+'" /> </td>';
								det +='<td class="text-center" ><input type="text" id="codempname" name="codempname"    class="form-control" style="width: 100%;"  ';
								det +='value="'+(data.list[i].data_officer[j].NAMEMPT==null?"":data.list[i].data_officer[j].NAMEMPT)+'" /> </td>';
								det +='<td class="text-right" >	<select id="ddlRole'+count+'" name="ddlRole" class="form-control" style="width: 100%;"   > </select></td>';
								det +='<td class="text-left" ><div class="col-sm-1" style="padding-left: 0px; color: red;"> <i class="fa  fa-remove (alias)  btnRemove" ' ;
								det +='onclick="removeStaff(this);"   ';
								det +='style="font-size: large;"></i><br> ' ;
								det +='</div> </td> ';  
								det +='</tr>';
								SetDropDownRole('#ddlRole'+count);
								$('#ddlRole'+count).val((data.list[i].data_officer[j].ROLE_ID==null?"":data.list[i].data_officer[j].ROLE_ID));
								$('#ddlRole'+count).multiselect("refresh");*/
							}
							if(data.list[i].data_officer.length==0) {
								//det += '<tr> ';
								//det += '<th colspan="4" class="text-center">--- ไม่พบข้อมูล ---</th> ';
								//det += '</tr> ';
								//	$('#dtePlaningStaff').html(det);
								addStaffList() ;

							}

							//$('#myTablePlaningStaff').DataTable( { 
							//responsive : true
							//});

							/*else{
								$('#dtePlaningStaff').html(det);
							}*/ 
						}
						//recalSummary();

					}else{
						showMsgError(data.message);
					}
				},
				error : function() {
					showMsgError('บันทึกข้อมูลผิดพลาด');
				}
			});

		} catch (ex) {
			showMsgError(ex);

		}

	} 
 	function addStaffList() {
 		count++;
 		no++;
		before = count - 1;
		var div = $("#formDefault");
		var cl = div.clone().attr('id', 'formDefault' + count);

		// 		alert(cl.find('[id="divCenterCode"]').attr('id'));
		//cl.find('[id="divCenterCode"]').attr('id', 'divCenterCode' + count);
// 		alert(cl.find('[id="divCenterCode' + count + '"]').attr('id'));
         cl.find('[id="no"]').attr('id', "no" + count);
		cl.find('[id="ddlRole"]').attr('id', "ddlRole" + count);
		cl.find('[id="codempname"]').attr('id', "codempname" + count);
		cl.find('[id="codempid"]').attr('id', "codempid" + count);
		
		cl.find('[id="codempid'+count+'"]').attr("onkeypress","getEmpname('#codempid"+ count+"','#ddlRole"+ count+"','#codempname"+ count+"',event)");
		cl.find('[id="indexStaff"]').attr('id', "indexStaff" + count);
		cl.find('[name="indexStaffTmp"]').attr('name', "indexStaff");
		//cl.find("span").remove();
		//cl.find("select").select2();
		cl.show();
		//alert(no);
		//if (no <= 1) {
			cl.insertBefore($("#dtePlaningStaff"));
			$('#indexStaff'+count).val(count);
		//} else {
		//	cl.insertAfter($("#formDefault" + before));
		//}
		 //  $('#ddlRole'+ count).multiselect("refresh");
		   
		 $('#no'+count).html(no);
		 
		//	recalSummary();
    	//SetDropDownRole('#ddlRole'+count);
    	// $('#ddlRole'+count).val('');
		
	}//EndBtnAddCaList
	function addPlanList() {
 		countPlan++;
 		noPlan++;
		before = countPlan - 1;
		var div = $("#formDefaultPlan");
		var cl = div.clone().attr('id', 'formDefaultPlan' + countPlan);
	 	var stdate = $('#sdate').val();
	 	var endate = $('#edate').val();
	 	var datest=new Date(stdate.split('/')[2], parseInt(stdate.split('/')[1])-1,stdate.split('/')[0]);
	 	var dateen=new Date(endate.split('/')[2], parseInt(endate.split('/')[1])-1,endate.split('/')[0]);
	 	
        cl.find('[id="planDate"]').attr('id', "planDate" + countPlan);
		//cl.find('[id="planDesc"]').attr('id', "planDesc" + countPlan);
// 		cl.find('[id="reviceOil"]').attr('id', "reviceOil" + countPlan);
		cl.find('[id="planBegin"]').attr('id', "planBegin" + countPlan);
		cl.find('[id="planEnd"]').attr('id', "planEnd" + countPlan);
		
		cl.find('[id="miletotal"]').attr('id', "miletotal" + countPlan);
		cl.find('[id="seq"]').attr('id', "seq" + countPlan);
		cl.find('[id="costCenter"]').attr('id', "costCenter" + countPlan);
		cl.find('[id="nameCenter"]').attr('id', "nameCenter" + countPlan);
		
		cl.find('[id="addr_tumbon"]').attr('id', "addr_tumbon" + countPlan);
		cl.find('[id="addr_aumphur"]').attr('id', "addr_aumphur" + countPlan);
		cl.find('[id="addr_province"]').attr('id', "addr_province" + countPlan);
		cl.find('[id="gps"]').attr('id', "gps" + countPlan);
		cl.find('[id="indexPlan"]').attr('id', "indexPlan" + countPlan);
		cl.find('[name="indexPlanTmp"]').attr('name', "indexPlan");
		cl.find('[id="addP1"]').attr('id', "addP1_"+countPlan);
		cl.find('[id="addP2"]').attr('id', "addP2_"+countPlan);
		
		
		
		//cl.find('[id="codempid'+count+'"]').attr("onkeypress","getEmpname('#codempid"+ count+"','#codempname"+ count+"',event)");
		
		 
		cl.show();
		 
		
		//if (noPlan <= 1) {
			cl.insertBefore($("#dteId"));
			$('#indexPlan'+countPlan).val(countPlan);
			// $('#planDate'+countPlan).datepicker({ autoclose: true});
			 $.fn.datepicker.defaults.format = "dd/mm/yyyy";
			 
			 	if('Y'==$('#statuscheck').val()){
				    $('[data-provide="datepicker"]').datepicker({
						autoclose : true ,
	 		            startDate:datest ,
	 		            endDate:dateen
					});
			 	}else{
				    $('[data-provide="datepicker"]').datepicker({
						autoclose : true 
					});
			 	}

			  
		//} else {
		//	cl.insertAfter($("#formDefaultPlan" + before));
		//}
		  
		 //$('#no'+countPlan).html(no);
		 
		 
		//	recalSummary();
		
	}
    function gotoMain(){
    	window.location="initPlaning"; 
    }
	function getEmpname(sndName,posName,recName,e){
		//alert(e.keyCode);
		 if (e.keyCode == 13) {
			  getEmpNameProfile(sndName,posName,recName)
			  recalSummary();
		 }
		
	}
	function enterRecal(e) {
		if (e.keyCode == 13) {
			recalSummary();
		}
	}
   function getEmpNameProfile(sndName,posName,recName){

    	 try {
                //  alert($(sndName).val());
 				var data = {}
   				data["codempid"] = $(sndName).val(); 
		 
			  	jQuery.ajax({
				url : 'util-getmemberprofile',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
					async: false,
					cache: false,
					success : function(data) {
			       		//console.log(JSON.stringify(data));
			        	 if(data.codempid!=null&&data.codempid!='') {
							$(recName).val(data.namempt) ;
							$(posName).val(data.nampost) ;
							console.log(posName+'.val() = '+data.nampost);
						 } else {
							showMsgWarning('ไม่พบข้อมูลพนักงาน');
						 }
			          
				},
				error : function() {
					 showMsgError('ข้อมูลผิดพลาด');
				 
				}
			});
 
        	 
       
		} catch (ex) {
			 showMsgError(ex);
			 
			 
		}
    	 
     } 
	   function getPosition(sndName,posName) {
	
	  	 try {
	              //  alert($(sndName).val());
					var data = {}
	 				data["codempid"] = $(sndName).val(); 
			 
				  	jQuery.ajax({
					url : 'util-getmemberprofile',
					type : "Post", 
					contentType : "application/json",
					data : JSON.stringify(data), 
					dataType : 'json',
						async: false,
						cache: false,
						success : function(data) {
				       		//console.log(JSON.stringify(data));
				        	 if(data.codempid!=null&&data.codempid!='') {
								$(posName).val(data.nampost) ;
								//console.log(posName+'.val() = '+data.nampost);
							 } else {
								showMsgWarning('ไม่พบข้อมูลพนักงาน');
							 }
					},
					error : function() {
						 showMsgError('ข้อมูลผิดพลาด');
					}
				});
			} catch (ex) {
				 showMsgError(ex);
			}
	  	 
	   	}
	  function validateSave(){
		   var flag = true;
		   if($('#tripName').val().trim()==''){
			   showMsgWarning('โปรดระบุTRIP NAME');
		    	  return false;
		   }
		   if(noPlan==0){
			   showMsgWarning('โปรดระบุแผนเดินทาง');
		    	  return false;
		   }
		 
		   if(no==0){
			   showMsgWarning('โปรดระบุพนักงานร่วมเดินทาง');
		    	  return false;
		   }
		   var cnt =0 ;
		   $("input[name='planDate']").each(function() { 
			 
			      if($(this).val().trim()!=''){
			    	  cnt++;
			    	 
			      }
		   });
		   if(cnt!=noPlan){
			   showMsgWarning('โปรดระบุวันที่เดินทางให้ครบ');
		    	  return false;
		   }
// 		   var cnt =0 ;
// 		   $("input[name='planDesc']").each(function() { 
// 			      if($(this).val().trim()!=''){
// 			    	  cnt++;
// 			      }
// 		   });
// 		   if(cnt!=noPlan){
// 			   showMsgWarning('โปรดระบุข้อมูลแผนรายละเอียดให้ครบ');
// 		    	  return false;
// 		   }
		   var cnt =0 ;
		   $("input[name='planBegin']").each(function() { 
			      if($(this).val().trim()!=''){
			    	  cnt++;
			      }
		   });
		   if(cnt!=noPlan){
			   showMsgWarning('โปรดระบุข้อมูลแผนเริ่มต้นให้ครบ');
		    	  return false;
		   }
		   var cnt =0 ;
		   $("input[name='planEnd']").each(function() { 
			      if($(this).val().trim()!=''){
			    	  cnt++;
			      }
		   });	
		   if(cnt!=noPlan){
			   showMsgWarning('โปรดระบุข้อมูลแผนสิ้นสุดให้ครบ');
		    	  return false;
		   }
		   var cnt =0 ;
		   $("input[name='miletotal']").each(function() { 
			      if(setNumberFormatTWOFactionAndNoSeparator($(this).val())!=''&&parseFloat(setNumberFormatTWOFactionAndNoSeparator($(this).val()))>0){
			    	  cnt++;
			      }
		   });
		   if(cnt!=noPlan){
			   showMsgWarning('โปรดระบุข้อมูลแผนระยะทางให้ครบ');
		    	  return false;
		   }
		   var cnt =0 ;
		   $("input[name='seq']").each(function() { 
			      if($(this).val().trim()!=''){
			    	  cnt++;
			      }
		   });	
		   if(cnt!=noPlan){
			   showMsgWarning('โปรดระบุข้อมูลแผนลำดับให้ครบ');
		    	  return false;
		   }    
		   var cnt =0 ;
		   $("input[name='codempname']").each(function() { 
			      if($(this).val().trim()!=''){
			    	  cnt++;
			      }
		   });
		   if(cnt!=no){
			   showMsgWarning('โปรดระบุข้อมูลพนักงานให้ครบ');
		    	  return false;
		   }
		   var cnt =0 ;
		   $("select[name='ddlRole']").each(function() { 
			  // alert($(this).val());
			      if($(this).val().trim()!=''){
			    	  cnt++;
			      }
		   });	
		  // alert(cnt+'-'+no);
// 		   if(cnt!=no){
// 			   showMsgWarning('โปรดระบุข้อมูลroleพนักงานให้ครบ');
// 		    	  return false;
// 		   }
// 		   if($('#total_day').val().trim()==''){
// 			   showMsgWarning('โปรดระบุจำนวนวันทำงานจำนวนวันทำงาน');
// 		    	  return false;
// 		   }
		   if($('#hotel_cnt_night').val().trim()==''){
			   showMsgWarning('โปรดระบุจำนวนคืนพักโรงแรม');
		    	  return false;
		   }
		   if($('#hotel_cnt_room').val().trim()==''){
			   showMsgWarning('โปรดระบุจำนวนห้องพัก');
		    	  return false;
		   }
		   return flag ; 
	   }
	   function saveActionPlan(){
	 	  
	   	 try {       
	   	 	
	   		  if(validateSave()){
	   				 var url = '';
	   		 
			   		 $.confirm({
			    		    title: 'ยืนยันวางแผนงาน',
			    		    icon: 'fa fa-exclamation-circle',
			                type: 'blue',
			    		    content: '',
			    		    buttons: {
			    		     'ยืนยัน': function () {
			    		    	 
			    		    	 ShowWaiting() ;
			   		                 var objList = {} 
			   		                  var array_officer = []
					 		    	  var array_dt = []
				   		              $("input[name='indexStaff']").each(function() { 
			 		                	    var  index  = $(this).val() ;
			 		                	 
				     						   
				     						   
					     		                   var data = {}
					     		                 
					     		                  	data["codempid"] =  $("#codempid"+index).val(); 
							 		    			data["namempt"] =  $("#codempname"+index).val(); 
							 		    			data["roleId"] = $("#ddlRole"+index).val();
							 		    			data["roleIdToo"] = $("#ddlRoleCode"+index).val();
							 		    		  
							 		    			array_officer.push(data);
				     						   
							 		    		     
			  						 });
					 		    		 objList["data_officer"] = array_officer;
			   		                 
			   		                   $("input[name='indexPlan']").each(function() { 
			   		                	    var  index  = $(this).val() ;
			   		                	  
					     		                   var data = {}
							 		    		//	alert(index+'_'+  $("#planDate"+index).val());
							 		    			data["plandate"] =  $("#planDate"+index).val(); 
							 		    			data["plan_desc"] =  $("#planDesc"+index).val(); 
							 		    			data["place_begin"] =    $("#planBegin"+index).val(); 
							 		    			data["place_destination"] =    $("#planEnd"+index).val(); 
							 		    		  
							 		    			data["mile_total"] =  setNumberFormatTWOFactionAndNoSeparator($("#miletotal"+index).val()); 
							 		    			data["seq"] =  $("#seq"+index).val(); 
							 		    			data["cost_center"] =    $("#costCenter"+index).val(); 
							 		    			data["orgName"] =    $("#nameCenter"+index).val(); 
							 		    			data["addr_tumbon"] =  $("#addr_tumbon"+index).val(); 
							 		    			data["addr_aumphur"] =  $("#addr_aumphur"+index).val(); 
							 		    			data["addr_province"] =    $("#addr_province"+index).val();  
							 		    			
// 							 		    			if($("#reviceOil"+index+":checked").val()!=undefined){
// 							 		    				data["reviceOil"] = '1';
// 							 		    			}else{
// 							 		    				data["reviceOil"] = '2';
// 							 		    			}
							 		    			
							 		    			array_dt.push(data);
							 		    			
							 		    		   
			    						 });
					 		    		 objList["data_station"] = array_dt;
					 		    		 
					 		    		 objList["tripName"] =   $('#tripName').val();
					 		    		 if($('#tripId').val()!=null&&$('#tripId').val()!=''){
					 			   			url ='updateActionPlan';
					 			   		     objList["trip_id"] = $('#tripId').val();
					 			   		     objList["complete_flg"] = 'Y';
					 			   		 
					 			   		 }else{
					 			   			 url ='insertActionPlan';
					 			   		 }
					 		    		objList["cnt_station"] = setNumberFormatTWOFactionAndNoSeparator($('#cnt_station').val());
					 		    		objList["cnt_station_perday"] = setNumberFormatTWOFactionAndNoSeparator($('#cnt_station_perday').val());
					 		    		objList["total_day"] = setNumberFormatTWOFactionAndNoSeparator($('#total_day').val());
					 		    		objList["allowce_amt_total"] = setNumberFormatTWOFactionAndNoSeparator($('#allowce_amt_total').val());
					 		    		objList["hotel_cnt_night"] = setNumberFormatTWOFactionAndNoSeparator($('#hotel_cnt_night').val());
					 		    		objList["hotel_cnt_room"] = setNumberFormatTWOFactionAndNoSeparator($('#hotel_cnt_room').val());
					 		    		objList["hotel_amt_total"] = setNumberFormatTWOFactionAndNoSeparator($('#hotel_amt_total').val());
					 		    		objList["total_mile_station"] = setNumberFormatTWOFactionAndNoSeparator($('#total_mile_station').val());
					 		    		objList["car_amt"] = setNumberFormatTWOFactionAndNoSeparator($('#car_amt').val());
					 		    		objList["amt_other"] = setNumberFormatTWOFactionAndNoSeparator($('#amt_other').val());
					 		    		objList["expense_perstation"] = setNumberFormatTWOFactionAndNoSeparator($('#expense_perstation').val());
					 		    		objList["total_amount"] = setNumberFormatTWOFactionAndNoSeparator($('#total_amount').val()); 
					 		    		objList["startDate"] = $('#sdate').val(); 
					 		    		objList["endDate"] = $('#edate').val(); 
					 		    		 
					 		    		 //save productA
					 		    		 //saveProductA();
					 		    		 //saveProductB();
					 					  jQuery.ajax({
					 						url : url,
					 						type : "Post", 
					 						contentType : "application/json",
					 						data : JSON.stringify(objList), 
					 						dataType : 'json',
					 						  async: false,
					 						   cache: false,
					 						success : function(data) {
					 							HideWaiting() ;
					 					// alert(data.success);
					 							if(data.success==1){
					 								      var msgTripId ='';
					 								      if(data.trip_no!=null&&data.trip_no!=''){
					 								    	 msgTripId = 'TRIP_NO :'+data.trip_no;
					 								      }
												         	 showMsgSuccess('บันทึกสำเร็จ'+msgTripId);
					 									 
					 											//	 $("#labCode").val('');
					 											gotoMain();
					 											  
					 							}else{
					 							  
					 								 showMsgError(data.message);
					 								 
					 							}
					 						},
					 						error : function() {
					 							HideWaiting() ;
					 							 showMsgError('ข้อมูลผิดพลาด');
					 						}
					 				     });
					      	        },
					  		          'ยกเลิก': function () {
								            
								       } 	 
					  		    }
					  		});			  
	   		   }
			} catch (ex) {
				HideWaiting() ;
				 showMsgError(ex);
			}
	   	       
			   	 
	  } 
	   function nextSummary(){
		   $('#tab2').show();
		   $('#barButtonStep2').show();
		   $('#barButtonStep1').hide();
		   $('#tab1').hide();
		   $('#condition').show();
	   }
	   function gotoPlaning(){
		   $('#tab2').hide();
		   $('#barButtonStep2').hide();
		   $('#barButtonStep1').show();
		   $('#tab1').show();
		   
	   }
	   function recalSummary(){
		    
		  // alert(noPlan);
			$('#cnt_station').val(noPlan);
			//calTotalWorkDay(noPlan);
			//calHotelCount();
			calCntStationPerday();///expense_perstation
			calAllowceAmt();
			calHotelAmt();
	    	calSumMileTotal();
	    	 calTotalAmount();
	    	//$('#total_day').val((data.list[i].TOTAL_DAY==null?"":data.list[i].TOTAL_DAY));
	    	//$('#allowce_amt_total').val((data.list[i].ALLOWCE_AMT_TOTAL==null?"":data.list[i].ALLOWCE_AMT_TOTAL)); 
	    	//$('#hotel_cnt_night').val((data.list[i].HOTEL_CNT_NIGHT==null?"":data.list[i].HOTEL_CNT_NIGHT));
	    	//$('#hotel_cnt_room').val((data.list[i].HOTEL_CNT_ROOM==null?"":data.list[i].HOTEL_CNT_ROOM));
	    	//$('#hotel_amt_total').val((data.list[i].HOTEL_AMT_TOTAL==null?"":data.list[i].HOTEL_AMT_TOTAL)); 
	    	//$('#total_mile_station').val((data.list[i].TOTAL_MILE_STATION==null?"":data.list[i].TOTAL_MILE_STATION));
	    	//$('#car_amt').val((data.list[i].CAR_AMT==null?"":data.list[i].CAR_AMT));
	    	//$('#amt_other').val((data.list[i].AMT_OTHER==null?"":data.list[i].AMT_OTHER));
	        //$('#expense_perstation').val((data.list[i].EXPENSE_PERSTATION==null?"":data.list[i].EXPENSE_PERSTATION)); 
	    	//$('#total_amount').val((data.list[i].TOTAL_AMOUNT==null?"":data.list[i].TOTAL_AMOUNT));
	        
	   }
	   function calTotalWorkDay(totStation){
		   if(totStation < 4.5){
			   $("#total_day").val(1);
		   } else {
			 var res = totStation/4.5 ;
			 $("#total_day").val(res.toFixed());
		   }
		   
	   }
	   function calHotelCount(){
		   var dayWork = $("#total_day").val();
		   if(dayWork > 1){
			   $("#hotel_cnt_night").val(dayWork-1);
		   } else {
			   $("#hotel_cnt_night").val(0);   
		   }
		   
	   }
	   function calAllowceAmt(){
			try {
				var codcomp ='' ,numlvl='',cnt_allowceAmt=0;
				$("input[name='indexStaff']").each(function() {
					var  index  = $(this).val() ; 
					if($("#codempid"+index).val()!=null&& $("#codempid"+index).val()!=''){
						var data = {}
							data["codempid"] = $("#codempid"+index).val(); 

						jQuery.ajax({
							url : 'util-getmemberprofile',
							type : "Post", 
							contentType : "application/json",
							data : JSON.stringify(data), 
							dataType : 'json',
							async: false,
							cache: false,
							success : function(data) {

							if(data.codempid!=null&&data.codempid!=''){
								codcomp = data.codcomp;
								numlvl = data.numlvl;
							}
							/*else{
								showMsgWarning('ไม่พบข้อมูลพนักงาน');
							}*/

							},
							error : function() {
								showMsgError('ข้อมูลผิดพลาด');
							}
						});

						// alert(codcomp);
						// alert(numlvl);
						var data = {}
							data["codcomp"] = codcomp ; 
							data["placeFG"] = '1'; 
							data["numlvl"] =  numlvl  ; 
						
						jQuery.ajax({
							url : 'util-allowanceExpense',
							type : "Post", 
							contentType : "application/json",
							data : JSON.stringify(data), 
							dataType : 'json',
							async: false,
							cache: false,
							success : function(data) {
								//  alert(data.pDay);
								if(data.success!='0'){
									cnt_allowceAmt=    parseFloat(cnt_allowceAmt)+ parseFloat(setNumberFormatTWOFactionAndNoSeparator($('#total_day').val()))*parseFloat(data.pDay) ;
								}else{
									showMsgWarning(data.message);
								}

							},
							error : function() {
								showMsgError('ข้อมูลผิดพลาด');
							}
						}); 
					}
				});	  
				$('#allowce_amt_total').val(setNumberFormatTWOFactionAndSeparator(cnt_allowceAmt));

			} catch (ex) {
				showMsgError(ex);
			}
		}
		function addconditionA(val) {
		

			
	    getMBProduct('A');
	    
		var divId = $(val).parent().parent().parent() ;
		var split = val.id.split('_');
		//get list receive
		getMBListReceiveOil($('#costCenter'+split[1]).val());
		
		//setLiProductA($('#costCenter'+split[1]).val());
		$('#station_selectedA').val($('#costCenter'+split[1]).val());
		$('#popup_editA').modal('show');
		
		}
		
		function getMBProduct(val){
			var data='';
			
			jQuery.ajax({
				url : 'util-getDropdownProductMobile',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
				success : function(data) {
					$('#mb_product'+val).empty();
	                $.each(data, function (i, item) {
	                    $('#mb_product'+val).append('<option value="' + item.PRODUCT_ID + '">' + item.PRODUCT_NAME + '</option>');
	                });
					//mb_product
				},
				error : function() {
					showMsgError('ข้อมูลผิดพลาด');
				}
			});
		}
		
		function addconditionB(val) {
	    getMBProduct('B');
	   
		var divId = $(val).parent().parent().parent() ;
		var split = val.id.split('_');
		//setLiProductB($('#costCenter'+split[1]).val());
		
		getMBListScheduleOil($('#costCenter'+split[1]).val());
		$('#station_selectedB').val($('#costCenter'+split[1]).val());
		$('#popup_editB').modal('show');
		
			}
       function calHotelAmt(){
        	 try {
        		 if($('#hotel_cnt_night').val()!=null&&$('#hotel_cnt_night').val()!=''){
        			 if($('#hotel_cnt_room').val()!=null&&$('#hotel_cnt_room').val()!=''){
        				  
		        		 var cnt_HotelAmt=    parseFloat(setNumberFormatTWOFactionAndNoSeparator($('#hotel_cnt_night').val()))*parseFloat(setNumberFormatTWOFactionAndNoSeparator($('#hotel_cnt_room').val()))*parseFloat(amtPerHotel)  
						 
		     	    	 $('#hotel_amt_total').val(setNumberFormatTWOFactionAndSeparator(cnt_HotelAmt));
        			 }
        		 } 
        		 
			               //  alert($(sndName).val());
						/*var data = {}
						data["codempid"] = $(sndName).val(); 
			
						  jQuery.ajax({
							url : 'util-getmemberprofile',
							type : "Post", 
							contentType : "application/json",
							data : JSON.stringify(data), 
							dataType : 'json',
							  async: false,
							   cache: false,
							success : function(data) {
						       
						        	 if(data.codempid!=null&&data.codempid!=''){
										 
											
											$(recName).val(data.namempt) 
											 
									 }else{
										 
											  showMsgWarning('ไม่พบข้อมูลพนักงาน');
									 }
						          
							},
							error : function() {
								 showMsgError('ข้อมูลผิดพลาด');
							 
							}
						});*/
			 
			} catch (ex) {
			    showMsgError(ex);
			
			
			}
	   }
	   function calCntStationPerday(){
		  if($('#total_day').val()!=null&&$('#total_day').val()!=''){
		     var cnt_perday = parseFloat(setNumberFormatTWOFactionAndNoSeparator($('#cnt_station').val()))/parseFloat(setNumberFormatTWOFactionAndNoSeparator($('#total_day').val())); 
				 
	    	  $('#cnt_station_perday').val(Math.ceil(cnt_perday));
		  }	
	   }
	   function calSumMileTotal(){
		   //if($('#miletotal').val()!=null&&$('#miletotal').val()!=''){
			     var cnt_MileTotal=  0; 
				   $("input[name='indexPlan']").each(function() { 
	   		            var  index  = $(this).val() ; 
	   		          cnt_MileTotal =  parseFloat(cnt_MileTotal)+parseFloat(setNumberFormatTWOFactionAndNoSeparator($("#miletotal"+index).val())); 
					 		      		   
	    		  });
		    	$('#total_mile_station').val(setNumberFormatTWOFactionAndSeparator(cnt_MileTotal));
		    	$('#car_amt').val(setNumberFormatTWOFactionAndSeparator(parseFloat(cnt_MileTotal*parseFloat(amtPerMile))));
		  // }
	   }
	   function calTotalAmount(){
			  
		     var totalAmount=  0; 
		 
		     totalAmount =  parseFloat(setNumberFormatTWOFactionAndNoSeparator($("#allowce_amt_total").val()))+parseFloat(setNumberFormatTWOFactionAndNoSeparator($("#hotel_amt_total").val()))+parseFloat(setNumberFormatTWOFactionAndNoSeparator($("#car_amt").val()))+parseFloat(setNumberFormatTWOFactionAndNoSeparator($("#amt_other").val())); 
				 		   
	    	$('#total_amount').val(setNumberFormatTWOFactionAndSeparator(totalAmount));
	    	$('#expense_perstation').val(setNumberFormatTWOFactionAndSeparator(parseFloat(totalAmount/setNumberFormatTWOFactionAndNoSeparator($('#cnt_station').val())))); 
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
	   
	   
	    function getMBListReceiveOil(val){
	    	var tripId = $('#tripId').val();
	    	var stationId=val;
	    	if(tripId==''){
	    		return null;
	    	}
	    	try {
	    		 
				  jQuery.ajax({
					url : 'api/report/getMBListReceive/'+tripId+'/'+stationId,
					type : "Get", 
					contentType : "application/json",
					dataType : 'json',
					  async: false,
					   cache: false,
					success : function(data) { 
						$('#list_productA').empty();
						listCodeStationA=[];
						if(data.length>0){
							for(var i=0;i<data.length;i++){
								//data[i]["STATUS"]="OLD"
								listCodeStationA.push(data[i]);
								$('#list_productA').append('<li class="list-group-item"> ผลิตภัณฑ์ : ' + data[i].PRODUCT_NAME +' สาเหตุ : '+data[i].CAUSE+'  <button  class="btn btn-danger" onclick="removeProductA('+data[i].COST_CENTER+','+data[i].PRODUCT_ID+')" >remove</button> </li>');
							}
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
	    
	    function saveProductA(){
	    
	    	var productArr="";
	    	var causeArr="";
	    	var tripidArr="";
	    	var costcenterArr="";
	    	var statusArr="";
	    	var data={};
	    	var index=0;
	    	for(var i=0;i<resultA.length;i++){
	    	
	    			productArr+=resultA[i].PRODUCT_ID +','
	    			causeArr+=resultA[i].CAUSE +','
	    			tripidArr+=resultA[i].TRIP_ID +','
	    			costcenterArr+=resultA[i].COST_CENTER +','
	    			statusArr+=resultA[i].STATUS +','
	    			
	    			//result.push[listCodeStationA[i]];
	    			index++;
	    		
	    	}
	    	if(index==0){
	    		return null;
	    	}
	    	productArr=productArr.substring(0,productArr.length-1);
	    	causeArr=causeArr.substring(0,causeArr.length-1);
	    	tripidArr=tripidArr.substring(0,tripidArr.length-1);
	    	costcenterArr=costcenterArr.substring(0,costcenterArr.length-1);
	    	statusArr=statusArr.substring(0,statusArr.length-1);
	    	
	    	data["productArr"]=productArr
	    	data["causeArr"]=causeArr
	    	data["tripidArr"]=tripidArr
	    	data["costcenterArr"]=costcenterArr
	    	data["statusArr"]=statusArr
	    	console.log(data);
	    	jQuery.ajax({
				url : 'api/report/saveListReceive',
				type : "Post", 
				data : JSON.stringify(data), 
				contentType : "application/json",
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) { 
					getMBListReceiveOil(resultA[0].COST_CENTER);
					resultA=[];
					
				},
				error : function() {
					//swal("error");
					showMsgError('เกิดข้อผิดพลาด!');
				}
			});
	    }
	    function saveProductB(){
	    	var productArr="";
	    	var causeArr="";
	    	var tripidArr="";
	    	var costcenterArr="";
	    	var statusArr="";
	    	var ncrArr="";
	    	var data={};
	    	var index=0;
	    	for(var i=0;i<resultB.length;i++){
	    
	    			productArr+=resultB[i].PRODUCT_ID +','
	    			causeArr+=resultB[i].CAUSE +','
	    			tripidArr+=resultB[i].TRIP_ID +','
	    			costcenterArr+=resultB[i].COST_CENTER +','
	    			statusArr+=resultB[i].STATUS +','
	    			ncrArr+=resultB[i].NCR_NO +','
	    			//result.push[listCodeStationA[i]];
	    			index++;
	    		
	    	}
	    	if(index==0){
	    		return null;
	    	}
	    	productArr=productArr.substring(0,productArr.length-1);
	    	causeArr=causeArr.substring(0,causeArr.length-1);
	    	tripidArr=tripidArr.substring(0,tripidArr.length-1);
	    	costcenterArr=costcenterArr.substring(0,costcenterArr.length-1);
	    	statusArr=statusArr.substring(0,statusArr.length-1);
	    	ncrArr=ncrArr.substring(0,ncrArr.length-1);
	    	
	    	data["productArr"]=productArr
	    	data["causeArr"]=causeArr
	    	data["tripidArr"]=tripidArr
	    	data["costcenterArr"]=costcenterArr
	    	data["statusArr"]=statusArr
	    	data["ncrArr"]=ncrArr
	    	
	    	jQuery.ajax({
				url : 'api/report/saveListSchedule',
				type : "Post", 
				data : JSON.stringify(data), 
				contentType : "application/json",
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) { 
					getMBListScheduleOil(resultB[0].COST_CENTER);
					resultB=[];
				},
				error : function() {
					//swal("error");
					showMsgError('เกิดข้อผิดพลาด!');
				}
			});
	    }
	    
	    function getMBListScheduleOil(val){
	    	var tripId = $('#tripId').val();
	    	var station=val;
	    	if(tripId==''){
	    		return null;
	    	}
	    	try {
	    		 
				  jQuery.ajax({
					url : 'api/report/getMBListSchedule/'+tripId+'/'+station,
					type : "Get", 
					contentType : "application/json",
					dataType : 'json',
					  async: false,
					   cache: false,
					success : function(data) {  
						listCodeStationB=[];
						$('#list_productB').empty();
						if(data.length>0){
							
							for(var i=0;i<data.length;i++){
								listCodeStationB.push(data[i]);
								$('#list_productB').append('<li class="list-group-item"> <b>เลข NCR :</b> '+data[i].NCR_NO+' <b>ผลิตภัณฑ์ : </b> ' + data[i].PRODUCT_NAME +' <b>สาเหตุ :</b> '+data[i].CAUSE+'  <button  class="btn btn-danger" onclick="removeProductB('+data[i].COST_CENTER+','+data[i].PRODUCT_ID+')" >remove</button> </li>');
								
								
							}
							$('#ncr_no').val(data[0].NCR_NO);
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
	    function updateNCRNo(){
	    	var data={};
	    	data["tripidArr"]=$('#tripId').val();
	    	data["costcenterArr"]=$('#station_selectedB').val();
	    	data["ncrArr"]=$('#ncr_no').val();
	    
	    	jQuery.ajax({
				url : 'api/report/updateNCRNo',
				type : "Post", 
				data : JSON.stringify(data), 
				contentType : "application/json",
				dataType : 'json',
				  async: false,
				   cache: false,
				success : function(data) { 
					getMBListScheduleOil($('#station_selectedB').val());
					
				},
				error : function() {
					//swal("error");
					showMsgError('เกิดข้อผิดพลาด!');
				}
			});
	    }
</script>
<input type="hidden" id="station_selectedA" value=""/>
<input type="hidden" id="station_selectedB" value=""/>
<input type="hidden" id="statuscheck" value=""/>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>วางแผนการลงตรวจ</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>
 
<div class="wrapper wrapper-content animated fadeInRight"> 
     <div id="condition" class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                         <div class="row"> 
                                  <div class="col-xs-12">
							            <div class="col-sm-6">
						                  <label>TRIP NO :</label><input type="text" id="tripId" style="width: 150px;" readOnly  class="form-control" name="tripId" />
						              
			                            </div> 
	                                     <div class="col-sm-6"><label>TRIP NAME :</label><input type="text" id="tripName" style="width: 100%;"    class="form-control" name="tripName" />
	                                        </div>
	                              </div>
	                    </div>                    
			    </div>
                <div class="ibox-content"> 
                        <div class="row">
                              
                                
                                  <div class="col-xs-12">
                                            <div class="col-sm-6">
                                                   <div class="col-sm-4">
	                                                    <label>ประเภทสถานี<span style="color:#F00;float: right;">*</span></label>
		                                            </div>
		                                            <div class="col-sm-8">
		                                              <select id="ddlTypeStation" name="ddlTypeStation"   onchange="SetDropDownRegion(this.value)"   class="form-control" style="width: 100%;float: left;"   >
		                                                  <option value="">==เลือก==</option>
									                   </select> 
	                                                </div>
	                                        </div>
	                                        <div class="col-sm-6">
	                                            <div class="col-sm-4">
	                                                <label>ภาค<span style="color:#F00;float: right;">*</span></label>
	                                            </div>
	                                            <div class="col-sm-8">
	                                            	<select id="ddlRegion" name="ddlRegion" onchange="SetDropDownArea(this.value)" class="form-control"  style="width: 100%;float: left;" >
								                    <option value="">==เลือก==</option>
								                   </select> 
	                                            </div>
	                                        </div>
	                                      
	                             </div>
	                          
                        </div>
                       <div class="row"> 
                                  <div class="col-xs-12">
	                                        <div class="col-sm-6">
	                                             <div class="col-sm-4">
	                                                <label>เขต</label>
	                                            </div>
	                                            <div class="col-sm-8">
	                                            <select id="ddlArea" name="ddlArea" onchange="SetDropDownProvince(this.value)"  class="form-control" style="width: 100%;"   >
	                                                  <option value="">==เลือก==</option>
								                   </select>
	                                            </div>
	                                           
	                                          
	                                        </div>
	                                        <div class="col-sm-6">
	                                          <div class="col-sm-4">
	                                                <label>จังหวัด</label>
	                                            </div>
	                                            <div class="col-sm-8">
	                                            	<select id="ddlProvince" name="ddlProvince" class="form-control" style="width: 100%;"   >
	                                            	 <option value="">==เลือก==</option>
								                   </select>
	                                            </div>
	                                            
	                                        </div>
	                             </div> 
                        </div>
                         <div class="row"> 
                                  <div class="col-xs-12">
	                                        <div class="col-sm-6">
	                                             <div class="col-sm-4">
	                                                <label>วันที่เริ่มต้น</label>
	                                            </div>
	                                            <div class="col-sm-8">
										<div class='input-group date' id='datetimepicker1'>
                                            <input type='text' id="sdate" class="form-control" />
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                        </div>
	                                            </div>
	                                           
	                                          
	                                        </div>
	                                        <div class="col-sm-6">
	                                          <div class="col-sm-4">
	                                                <label>วันที่สิ้นสุด</label>
	                                            </div>
	                                            <div class="col-sm-8">
			                                        <div class='input-group date' id='datetimepicker2'>
			                                            <input type='text' id="edate" class="form-control" />
			                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
			                                        </div>
	                                            </div>
	                                            
	                                        </div>
	                             </div> 
                        </div>
                        <div class="row"> 
                                  <div class="col-xs-12">
	                                        <div class="col-sm-6">
	                                            <div class="col-sm-12">
	                                                 &nbsp;
	                                            </div>
	                                           
	                                        </div>
	                                        <div class="col-sm-6">
		                                         
		                                            <div class="col-sm-12" style="text-align:right;">
		                                                     <button class="btn btn-primary" onclick="inquiryMBStationMaster()">
			                                                    <i class="fa fa-search"></i>&nbsp;เลือกสาขา
			                                                </button>
		                                            </div>
	                                           
	                                        </div>
	                             </div> 
                        </div>
                </div>
            </div>
        </div>
    </div>
     
   	<div class="row" > 
              
        <div id='tab1'>
               <div class="col-lg-12">
               <div class="ibox float-e-margins">
                       <div class="ibox-content">
                    <div class="row">
                      <div class="col-xs-12">
                             <div class="table-responsive">
				         <table   id="myTablePlaningDetailId" class="table  table-striped table-bordered"   style="width: 100%;" role="grid" aria-describedby="tableApproverTask_info">
						 <!-- <table   id="myTablePlaningDetailId"> -->
							<thead>
								<tr class="tbHeader">
									<!-- 
									<th class="text-center" style="width: 7%;">วันที่เดินทาง</th>
									<th class="text-center" style="width: 20%;">รายละเอียด</th>
									<th class="text-center" style="width: 10%;">เริ่มต้น</th>
									<th class="text-center" style="width: 10%;">สิ้นสุด</th>
									<th class="text-center" style="width: 5%;">ระยะทาง</th>
									<th class="text-center" style="width: 3%;">ลำดับ</th>
									<th class="text-center" style="width: 10%;">รหัสสถานีบริการ</th>
									<th class="text-center" style="width: 8%;">ชื่อสถานีบริการ</th> 
									<th class="text-center" style="width: 8%;">ตำบล</th>
									<th class="text-center" style="width: 8%;">อำเภอ</th> 
									<th class="text-center" style="width: 8%;">จังหวัด</th> 
									<th class="text-center"  style="width: 3%;">&nbsp;</th> 
									-->
									<th class="text-center" style="width: 110px;">วันที่เดินทาง</th>
<!-- 									<th class="text-center" style="width: 100px;">ไม่รับน้ำมัน</th> -->
									<th class="text-center" style="width: 100px;">เริ่มต้น</th>
									<th class="text-center" style="width: 100px;">สิ้นสุด</th>
									<th class="text-center" style="width: 75px;">ระยะทาง</th>
									<th class="text-center" style="width: 50px;">ลำดับ</th>
									<th class="text-center" style="width: 100px;">รหัสสถานีบริการ</th>
									<th class="text-center" style="width: 100px;">ชื่อสถานีบริการ</th> 
									<th class="text-center" style="width: 160px;">ตำบล</th>
									<th class="text-center" style="width: 160px;">อำเภอ</th> 
									<th class="text-center" style="width: 160px;">จังหวัด</th> 
									<th class="text-center" style="width: 30px;">&nbsp;</th> 
									<th class="text-center" style="width: 250px;" id="th_edit">สาเหตุ</th> 
								</tr>
							 </thead>
							<tbody id="dteId">
							</tbody>
						</table> 
                           </div>
                  </div>
                 </div>
              </div>   
          </div>
      </div>       
       <div class="row">
                       <div class="col-xs-12"> 
                       </div>
     </div>
     <div class="col-lg-12">
                  <div class="ibox float-e-margins"> 
            <div class="ibox-content"> 
                 <div class="row">
                        <div class="col-xs-3" style="text-align:left;"> 
				                   <button type="button"   
										class="btn btn-primary center-block" id="btnaddStaffList"
										onclick="addStaffList();">เพิ่มรายการ</button>
						  </div>
						    <div class="col-xs-9"> &nbsp; 
						    </div>
                  </div>
                     <div class="row">
                        <div class="col-xs-12">
                              <div class="table-responsive">
						         <table   id="myTablePlaningStaff" class="table  table-striped table-bordered"  style="width: 100%;" role="grid" aria-describedby="tableApproverTask_info">
								 
									   <thead>
																<tr class="tbHeader">
																        <th class="text-center" style="width: 10%;"> </th>
																        <th class="text-center"  style="width: 20%;">รหัสพนักงาน</th>
																        <th class="text-center"  style="width: 40%;">ชื่อ</th>
								                                        <th class="text-center"  style="width: 20%;">role</th>
								                                       <th class="text-center"  style="width: 10%;"></th> 
																</tr>
									    </thead>
									   <tbody id="dtePlaningStaff">
									           
									   </tbody>
								  </table> 
		                       </div>
		                  </div>
                    </div>
          </div>
              </div>   
          </div>
       </div>   
        <div id='tab2'>
	           <div class="col-lg-12">
	                    <div class="ibox float-e-margins"> 
	               <div class="ibox-content">
	               
	                  		<div style="border: 1px solid #a7a2a2; border-radius: 15px;  margin-bottom: 20px;" >
	                  		               <div class="row">
									                        <div class="col-xs-12"> &nbsp;
									                        </div>
									      </div>
			                             <div class="row"   >
			                           
			                                   <div class="col-xs-12">
				                                        <div class="col-sm-6">
					                                            <div class="col-sm-6">
					                                                <label class="control-label">จำนวนสถานีทั้งหมด</label> <label class="control-label">(สถานี)</label>
					                                            </div>
					                                            <div class="col-sm-2">&nbsp; </div> 
							                                    <div class="col-sm-4">
					                                            	<input type="text" id="cnt_station" style="width: 100%; text-align:right;"  class="form-control" readonly="readonly"  name="cnt_station" />  
																</div>
				                                        </div>
				                                        <div class="col-sm-6">
					                                          <div class="col-sm-6"> &nbsp; </div>
			                                                  <div class="col-sm-2"> &nbsp; </div> 
					                                          <div class="col-sm-4"> &nbsp; </div>
				                                        </div>
				                                </div>
				                                <div class="col-xs-12">
				                                        <div class="col-sm-6">
				                                            <div class="col-sm-6">
				                                                <label>จำนวนวันทำงาน</label> <label>(วัน)</label>
				                                            </div>
				                                            <div class="col-sm-2"> &nbsp; </div> 
						                                    <div class="col-sm-4">
				                                                <input type="text" id="total_day" style="width: 100%; text-align:right;" onchange="recalSummary()"  class="form-control" onkeypress="enterRecal(event); return isNumber(event)"   name="total_day" />  
															</div>
				                                        </div>
				                                        <div class="col-sm-6">
				                                               <div class="col-sm-6">
							                                                <label>จำนวนเงินเบี้ยเลี้ยงพนักงาน</label> <label>(บาท)</label> 
							                                     </div>
							                                   <div class="col-sm-2">&nbsp; </div> 
							                                  <div class="col-sm-4">
							                                             <input type="text" id="allowce_amt_total" style="width: 100%; text-align:right;"  class="form-control"  readonly="readonly"    name="allowce_amt_total" />  
															</div>
				                                        </div>
				                                 </div>
				                                     
				                                 <div class="col-xs-12">
					                                      <div class="col-sm-6">
					                                            <div class="col-sm-6">
					                                                <label>จำนวนคืนพักโรงแรม</label> <label>  (คืน)</label> 
					                                            </div>
					                                            <div class="col-sm-2"> &nbsp; </div> 
							                                    <div class="col-sm-4">
					                                            	<input type="text" id="hotel_cnt_night" style="width: 100%; text-align:right;"  class="form-control" onchange="recalSummary()" onkeypress="enterRecal(event); return isNumber(event)"   name="hotel_cnt_night" />  
																</div>
					                                        </div>
					                                       <div class="col-sm-6">
			                                                    <div class="col-sm-6">
						                                        	<label>จำนวนเงินค่าที่พัก</label> <label>   (บาท)</label> 
						                                        </div>
						                                        <div class="col-sm-2">&nbsp;</div> 
						                                        <div class="col-sm-4">
						                                        	<input type="text" id="hotel_amt_total" style="width: 100%; text-align:right;"  class="form-control"  readonly="readonly"    name="hotel_amt_total" />  
																</div>
				                                        </div>
				                                   </div> 
				                                        
				                                 <div class="col-xs-12">
					                                      <div class="col-sm-6">
					                                      	<div class="col-sm-6">
					                                                <label>จำนวนห้องพัก</label> <label>  (ห้อง)</label> 
					                                            </div>
					                                             <div class="col-sm-2">&nbsp;</div> 
							                                      <div class="col-sm-4">
					                                                     <input type="text" id="hotel_cnt_room" style="width: 100%; text-align:right;"  class="form-control" onchange="recalSummary()" onkeypress="enterRecal(event); return isNumber(event)"   name="hotel_cnt_room" />  
					                                            </div>
					                                        </div>
					                                       <div class="col-sm-6">
			                                                    <div class="col-sm-6">&nbsp;</div>
						                                        <div class="col-sm-2">&nbsp;</div> 
						                                        <div class="col-sm-4">&nbsp;</div>
				                                           </div>
				                                   </div> 
				                                    <div class="col-xs-12">
					                                      <div class="col-sm-6">
					                                            <div class="col-sm-6">
					                                                <label>ระยะทางรวม</label> <label> (กม.)</label>  
					                                            </div>
					                                             <div class="col-sm-2">&nbsp;</div> 
							                                    <div class="col-sm-4">
				                                                     <input type="text" id="total_mile_station" style="width: 100%; text-align:right;"   class="form-control" readonly="readonly"    name="total_mile_station" />  
					                                            </div>
					                                        </div>
					                                       <div class="col-sm-6">
				                                                    <div class="col-sm-6">
							                                             <label>        จำนวนเงินค่าน้ำมัน</label>  <label> (บาท)</label> 
							                                            </div>
							                                          <div class="col-sm-2">
							                                               &nbsp
							                                               </div> 
							                                          <div class="col-sm-4">
							                                                     <input type="text" id="car_amt" style="width: 100%; text-align:right;"  class="form-control"  readonly="readonly"    name="car_amt" />  
																	
							                                       
				                                                       </div>
				                                           </div>
				                                   </div> 
				                                   <div class="col-xs-12">
					                                      <div class="col-sm-6">
					                                            <div class="col-sm-6">
					                                                <label>จำนวนสถานี/วัน</label>
					                                            </div>
					                                                     <div class="col-sm-2">
							                                               &nbsp
							                                               </div> 
							                                          <div class="col-sm-4">
					                                                       <input type="text" id="cnt_station_perday" style="width: 100%; text-align:right;"  class="form-control"  readonly="readonly"    name="cnt_station_perday" />  
																	
					                                            </div>
					                                        </div>
					                                       <div class="col-sm-6">
				                                                    <div class="col-sm-6">
							                                               <label>   จำนวนเงินค่าอื่นๆ</label> <label> (บาท)</label> 
							                                            </div>
							                                                     <div class="col-sm-2">
							                                               &nbsp
							                                               </div> 
							                                          <div class="col-sm-4">
							                                               <input type="text" id="amt_other" style="width: 100%; text-align:right;"  class="form-control" onkeypress="return isNumber(event)"  onchange="recalSummary();return setCommaById(this);"    name="amt_other" />  
																	
							                                                   
				                                                       </div>
				                                           </div>
				                                   </div> 
				                                   <div class="col-xs-12">
					                                      <div class="col-sm-6">
					                                            <div class="col-sm-6">
					                                                <label>ค่าใช้จ่าย  (บาท/สถานี)</label> <label>     (บาท)</label> 
					                                            </div>
					                                                     <div class="col-sm-2">
							                                               &nbsp
							                                               </div> 
							                                          <div class="col-sm-4">
					                                                  <input type="text" id="expense_perstation" style="width: 100%; text-align:right;"  class="form-control"  readonly="readonly"    name="expense_perstation" />  
																	
																	  
					                                            </div>
					                                        </div>
					                                       <div class="col-sm-6">
				                                                    <div class="col-sm-6">
							                                              <label>   รวมงบประมาณ</label>  <label class="control-label">(บาท)</label>
							                                          </div>
							                                               <div class="col-sm-2">
							                                               &nbsp
							                                               </div> 
							                                          <div class="col-sm-4">
							                                          <input type="text" id="total_amount" style="width: 100%; text-align:right;"  class="form-control"  readonly="readonly"    name="total_amount" /> 
							                                        
				                                                       </div>
				                                           </div>
				                                   </div> 
				                         </div>     
				                          <div class="row">
									                        <div class="col-xs-12"> &nbsp;
									                        </div>
									      </div>     
	                        </div> 
	                </div>                 
	          </div>   
	          </div>
	         </div>    
          
     </div> 
          <div class="form-group" id="barButtonStep1">
	      
		        <div class="col-sm-4">
		            <button type="button"
		                    class="btn btn-danger center-block" disabled="disabled" id='btnDel' style="width: 150px;" onclick="updateStatus('0')" 
		            >ยกเลิก&nbsp;
		                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
		            </button>
		        </div>
		        <div class="col-sm-4">
		            <button type="button"
		                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()" 
		            >กลับไปหน้าหลัก&nbsp
		                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
		            </button>
		        </div>
		        
		        <div class="col-sm-4">
		                 <center><button type="button" id="loginbotttom4"  style="width: 150px;" onclick="saveActionPlan();" 
		                            class="btn btn-primary center-block">
		                                                 ยืนยัน 
		                &nbsp<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button></center>
	             </div>
		        <!-- /.col -->
		 </div>
	  <div class="form-group" id="barButtonStep2" style="display: none;">
	      
	      <div class="col-sm-4">
	            <button type="button"
	                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoPlaning()" 
	            >ย้อนกลับหน้าวางแผน&nbsp;
	                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
	            </button>
	        </div>
	        <div class="col-sm-4">
	            <button type="button"
	                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()" 
	            >กลับไปหน้าหลัก&nbsp;
	                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
	            </button>
	        </div>
	        <div class="col-sm-4">
	                 <center><button type="button" id="loginbotttom4"  style="width: 150px;" onclick="confirmPlan();" 
	                            class="btn btn-primary center-block">
	                                                   ยืนยัน 
	                &nbsp;<i class="fa fa-send" style="font-size:22px;color:yellow"></i></button></center>
             </div>
	        <!-- /.col -->
	 </div>
</div>
     <table style="display: none;">
    	<tr id="formDefault"  data-expanded="true"> 
         
						   <td class="text-center" >
									<div id="no" name="no"></div>
 							</td>
						    <td class="text-left" >  
								<input type="text" id="codempid" name="codempid" onkeypress="getEmpname('#codempid','#ddlRole','#codempname',event)"   class="form-control" style="width: 75%;"  />
 							</td>
							 <td class="text-center" >
						    <input type="hidden" id="indexStaff" name="indexStaffTmp"     />
								 	<input type="text" id="codempname" name="codempname" readOnly  class="form-control" style="width: 100%;"  />
							</td>
							<td class="text-right" >
								<!-- <select id="ddlRole" name="ddlRole" class="form-control" style="width: 100%;"   ></select> -->
								<input type="text" id="ddlRole" name="ddlRole" readOnly  class="form-control" style="width: 100%;"  />
							</td>
							
							<td class="text-left">
							     <div class="col-sm-1" style="padding-left: 0px; color: red;">
								  <i class="fa  fa-remove (alias)  btnRemove"
									onclick="removeStaff(this);" id="remove"
									style="font-size: large;"></i><br></div> 
							</td>
						  
	 </tr>
	 </table>
	  <table style="display: none;">
       <tr id="formDefaultPlan" > 
         
						   <td class="text-center" >
									   <input type="text" style="text-align:center;width: 110px;" class="custom-text-horizon-rangdate2"
											 maxlength="10" id="planDate"  name="planDate"
												 data-provide="datepicker"  >
 							</td>
						    <!-- <td class="text-left" >  --> 
								<!-- <input type="text" id="planDesc" name="planDesc"    class="form-control"    /> -->
 							<!-- </td> -->
<!--  							<td class="text-center" > -->
 							
<!-- 						          <input type="checkbox" id="reviceOil" name="reviceOil" style="width: 100px;" /> -->
								 	 
<!-- 							</td> -->
							 <td class="text-center" >
						          <input type="text" id="planBegin" name="planBegin"    class="form-control"  style="width: 100px;" />
								 	 
							</td>
							<td class="text-right" >
								   <input type="text" id="planEnd" name="planEnd"    class="form-control"  style="width: 100px;" />
							</td>
							  <td class="text-left" >  
								<input type="text" id="miletotal" name="miletotal" onkeypress="return isNumber(event)"  onchange="recalSummary();return setCommaById(this);"  class="form-control" style="width:75px"   />
 							</td>
							 <td class="text-center" >
						          <input type="text" id="seq" name="seq" onkeypress="return isNumber(event)"    class="form-control"  style="width:50px"    />
								 	 
							</td>
							<td class="text-right" >
								   <input type="text" id="costCenter" readonly="readonly" name="costCenter"    class="form-control"  style="width:100px;"  />
							</td>
							<td class="text-right" >
								   <input type="text" id="nameCenter" readonly="readonly" name="nameCenter"    class="form-control"  style="width:100px;"  />
							</td>
							 <td class="text-center" >
						          <input type="text" id="addr_tumbon" readonly="readonly" name="addr_tumbon"    class="form-control" style="width:160px;"    /> 
							</td>
							<td class="text-right" >
								  <input type="text" id="addr_aumphur" readonly="readonly" name="addr_aumphur"    class="form-control" style="width:160px;"    />
							</td>
							<td class="text-right" >
								   <input type="text" id="addr_province" name="addr_province"  readonly="readonly"  class="form-control" style="width:160px;"  />
								    <input type="hidden" id="gps" name="gps"    class="form-control"    />
								      <input type="hidden" id="indexPlan" name="indexPlanTmp"     />
							</td>
							<td class="text-center">
							     <!-- <div class="col-sm-1" style="padding-left: 0px; color: red;"> -->
							     <div style="color: red;"><i class="fa  fa-remove (alias)  btnRemove" onclick="removePlan(this);" id="remove" style="font-size: large;"></i><br></div> 
							</td>
							<td class="text-center" id="content_edit" >
							     <!-- <div class="col-sm-1" style="padding-left: 0px; color: red;"> -->
							     <div><button class="btn btn-primary" onclick="addconditionA(this);" id="addP1">ไม่รับน้ำมัน</button>&nbsp<button class="btn btn-primary" onclick="addconditionB(this);" id="addP2">ไม่ผ่านข้อกำหนด</button></div> 
							</td>
						  
	 </tr>
	 </table>
                  
    
 <div id="popup_spareRandomOil" class="modal in" tabindex="-1" data-backdrop="static" data-keyboard="false">
	    <div class="modal-dialog" >
	        <div class="modal-content-wrapper">
	            <div class="modal-content">
	                <div class="modal-header">
	               
	                      <button type="button" class="close" data-dismiss="modal"   aria-label="Close">
	                        <span aria-hidden="true">&times;</span>
	                    </button>
	                    <h4 class="modal-title"> สถานีบริการ   <button class="btn btn-primary" onclick="editdata()">
	                                                                                                  ตกลง   </button></h4>  
	                </div>
	                <div class="modal-body ptn pbs" style="top:70px">
	                    <div class="row">
	                        <div class="col-xs-12">
	                             <div class="table-responsive"   >
							         <table   id="myTableSpareDteId" class="table table-striped table-bordered" style="padding: 0px;">
										<thead>
											<tr class="tbHeader">
											     
			                                   <th style="width:15%"   class="text-center">cost center</th>
										       <th style="width:10%" class="text-center">ภาค</th>
										       <th style="width:10%" class="text-center" ><input id="tigAll" type="checkbox" onclick="selectAll(this)"></th> 
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
	    </div>
 </div> 
 
 
<div class="modal fade centered-modal" tabindex="-1" role="dialog" id="popup_editA" style="margin-left: 20%;    height: 90%;width: 60%;margin-top: 5%;">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
         <h4 class="modal-title">สาเหตุที่ประเมินไม่รับน้ำมันบริษัท</h4>
       
      </div>
      <div class="modal-body">
      								

      							<div class="form-group">
      							<label>เลือกผลิตภัณฑ์</label>
      							 <select id="mb_productA" class="form-control">
								  
								</select>
      							</div>
       	                        <div class="form-group">
      							<label>ระบุสาเหตุ</label>
								<input id="textboxA" class="form-control">
      							</div>
	                             
								 <button id="addA" class="btn btn-primary">เพิ่มสาเหตุ</button>
	                             <ul id="list_productA" class="list-group">

    							 </ul>
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-warning" data-dismiss="modal" >Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal fade centered-modal" tabindex="-1" role="dialog" id="popup_editB" style="margin-left: 20%;    height: 90%;width: 60%;margin-top: 5%;">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
       
       <h4 class="modal-title">สาเหตุที่ผลิตภัณฑ์ไม่เป็นไปตามที่กำหนด</h4>
      </div>
      <div class="modal-body">	<div class="row">
      
      						    <div class="col-xs-6">
      							<label>ระบุเลข NCR</label>
      							 <input type="text" id="ncr_no" class="form-control">
      							</div>
      							<div class="col-xs-6">
      							
      							 <button onclick="updateNCRNo()" class="btn btn-primary" style="margin-top: 22px"'>Update เลข NCR</button>
      							</div>
      							</div>

      							<div class="form-group">
      							<label>เลือกผลิตภัณฑ์</label>
      							 <select id="mb_productB" class="form-control">
								  
								</select>
      							</div>
       	                        <div class="form-group">
      							<label>ระบุสาเหตุ</label>
								<input id="textboxB" class="form-control">
      							</div>
	                             
								 <button id="addB" class="btn btn-primary">เพิ่มสาเหตุ</button>
	                             <ul id="list_productB" class="list-group">

    							 </ul>
      </div>
      <div class="modal-footer">
      
        <button type="button" class="btn btn-warning" data-dismiss="modal" >Close</button>
      </div>
    </div>
  </div>
</div>
  
 
