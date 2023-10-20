var table = "";
var tmp_data = {};
var dataT;
var userName="",codeEmpID="";
    $(document).ready(function () {

    	SetDropDowncauseChgStatus();

    	init();
    	
    });
    function init(){
    	checkLevel();
    	inquiryRandomOil();
    	SetDropDownSelectType();
    	selectAllNew();
    	//console.log("ss");
    }
    function getThaiBuddaDate(date){
		var rtnDate = "";
		var data = {}
		data["poDate"] = date; 
		jQuery.ajax({
			url : 'getThaiBuddaDate',
			type : 'Post',
			async: false,
			cache: false,
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(obj) {
				rtnDate  = obj.poDate;
			}
		}).fail(function(){
			/*  $.alert({
                  title: 'error',
                  icon: 'fa fa-error',
                  type: 'red',
                  content: 'เกิดข้อผิดพลาด!',
              });*/
			  showMsgError('เกิดข้อผิดพลาด!');
			/*swal('Error...', 'เกิดข้อผิดพลาด!',
				'error');*/
				//ShowErrorMsg('0006', ex);
				//HideWaiting();
		   });	
		
		return rtnDate
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
                url:'/Lab/api/getLevelHead',
                data : JSON.stringify(data),
                dataType: 'json',
                async: false,
                cache: false,
                success : function(data) {
                	//console.log(data.list[0]);
                	userName = data.list[0].NAMET;
                	codeEmpID = data.list[0].CODEMP_ID;
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
  	function selectAllNew(){
  	 	var table = $('#myTableDteId').DataTable();
  		
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
     function openRandomOilPopup(){
    	   $('#popup_random').modal('show');
    	   
     }
     function news(){
    	 
    	 alert($("#ddlStore").val());
     }
     function sendRequestRandomOil(){
    	 let chkSend = checkSelect("sendRequest");
    	 if(chkSend=="1"){
    		 return;
    	 }
    	 var labcode =  "";
    	 let chPrint = "";
    	 $("input[name='chk']").each(function(i,item) { 
	   	     //  alert($(this).prop('checked')+"-"+$(this).val()) ;   
	    	        if($(this).prop('checked')){
	    	        	console.log(item.value);
	    	        	for(var i=0;i<tmp_data.list.length;i++){
		    	        	if(tmp_data.list[i].LAB_CODE==item.value){
		    	        		if(tmp_data.list[i].FLAG_PRINT=="Y"){
			        	    		 if($(this).val()==tmp_data.list[i].LAB_CODE){   
		    			 				 labcode +=    "'"+$(this).val()+"',";   ;
		    			 			  }  
			        	    		 chPrint = "Y";
			        	    	 }else{
			        	    		 showMsgError("กรุณาปริ้นสติ๊กเกอร์ก่อนส่งใบคำขอวิเคราะห์");
			        	    		 chPrint = "N";
			        	    	 } 	 
		    	        	}
	    	        	} 
	    	        }
		 });
    	 if(chPrint=="N"){
    		 return;
    	 }
    	 labcode = labcode.substring(0,labcode.length-1);	 
    	try{
    	 	//alert(tmp_data.list.length);
             if(tmp_data!=null&&tmp_data.list.length>0){
			            	 $.confirm({
			            		    title: 'ยืนยันการสร้างใบคำขอวิเคราะห์',
			            		    icon: 'fa fa-exclamation-circle',
			                        type: 'blue',
			            		    content: '',
			            		    buttons: {
			            		     'ยืนยัน': function () {
			            		    	 var objList = {};
					    		 		 var array_dt = [];
										 var data = {} 
						    			 data["labCode_No"] = labcode;
						    			 data["status"] = "02";
										 ShowWaiting() ;
										  jQuery.ajax({
											url : 'updateStatusSendAnalysis',
											type : "Post", 
											contentType : "application/json",
											data : JSON.stringify(data), 
											dataType : 'json', 
											success : function(data) {
										      
												if(data.success==1){ 
												  HideWaiting() ;

														  showMsgSuccess("บันทึกสำเร็จ");
														  inquiryRandomOil();
														  window.location = "/Lab/manageReviseRequestNo";

												}else{
													  HideWaiting() ;
													 // jAlert('error', data.message,'ข้อมูลผิดพลาด');
													 /* $.alert({
				 				                          title: 'ข้อมูลผิดพลาด',
				 				                          icon: 'fa fa-error',
				 				                          type: 'red',
				 				                          content: data.message,
				 				                     });*/
													  showMsgError(data.message);
												}
											},
											error : function() {
												//swal("error");
												// jAlert('error', '','ข้อมูลผิดพลาด');
												/* $.alert({
							                          title: 'ข้อมูลผิดพลาด',
							                          icon: 'fa fa-error',
							                          type: 'red',
							                        
							                    });*/
												 showMsgError('ข้อมูลผิดพลาด');
												  HideWaiting() ;
											}
										 });
								       
				       		        },
				       		          'ยกเลิก': function () {
		 						            
		 						       } 	 
				       		    }
				       		});
             }else{
            	
    			//jAlert('warning','ไม่พบข้อมูลส่งใบคำขอวิเคราะห์','');
    			showMsgWarning('ไม่พบข้อมูลสร้างใบคำขอวิเคราะห์');
    			 /*$.alert({
                      title: 'ไม่พบข้อมูลส่งใบคำขอวิเคราะห์',
                      icon: 'fa fa-warning',
                      type: 'orange',
                      content: '' ,
                 });*/
    			 HideWaiting() ;
             }
		} catch (ex) {
			 
			// jAlert('error', ex,'ข้อมูลผิดพลาด');
			/* $.alert({
		 				                          title: 'ข้อมูลผิดพลาด',
		 				                          icon: 'fa fa-error',
		 				                          type: 'red',
		 				                          content: ex,
		 				                    });*/
			 showMsgError(ex);
			  HideWaiting() ;
			 
		}
		 
     } 
	
	 function EditValue(i,labcode,sample_refer){		 
   	   	 $('#popup_spareRandomOil').modal('show');
   	   	 $("#funcID").val(i);
   	  	 SetDropDowncauseChgStatus();
		 $("#labcodeID").val(labcode);
		 $("#sampleRefer").val(sample_refer);
		 queryTableFreeCar(labcode);
	 }
	function ShowCancel(i,labcode,del){	 
		 $("#selectCause").select2();
   	   	 $('#popup_spareRandomOil_cancel').modal('show');
   	  	 SetDropDowncauseChgStatus();
   	   	 $("#funcID").val(i);
		 $("#delID").val(del);
		 $("#labcodeID").val(labcode);
		 $(".other-select-Cause").hide();
		 //$('#selectCause_cancel').append(new Option("อื่น ๆ", "10000"));
		 
		 $("#selectCause_cancel").change(function() {
	        	if(this.value=="10000"){
	        		$(".other-select-Cause").show();
	        	}else{
	        		$(".other-select-Cause").hide();
	        	}
	    	});
	 }
	 function CancelData(){
		 //var i = $("#funcID").val();
    	 //$( "#carNo_"+i ).prop( "disabled", true );
    	 //console.log("CAR NO = "+$( "#carNo_"+i ).val());
		 var strCause="";
		 if($("#causeChgStatus_cancel").val()=="10000"){
			 strCause = $("#other_Cause_cancel").val();
		 }else{
			 strCause = $("#causeChgStatus_cancel").val();
		 }
		 
    	 try{
 		    	   $.confirm({
 	            		    title: 'ยืนยันการยกเลิก',
 	            		    icon: 'fa fa-exclamation-circle',
	                        type: 'red',
 	            		    content: '',
 	            		    buttons: {
 	            		    'ยืนยัน': function () {         
		 							 var data = {} 
						    			 data["labCode_No"] = $("#labcodeID").val();
						    			 data["status"] = $("#delID").val();
						    			 data["causeChgStatus"] = strCause;
						    			 data["selectCause"] = $("#selectCause_cancel").val();
						    			 console.log(JSON.stringify(data));
		 							  jQuery.ajax({
		 								url : 'updateCancelStatus',
		 								type : "Post", 
		 								contentType : "application/json",
		 								data : JSON.stringify(data), 
		 								dataType : 'json',
		 								  async: false,
		 								   cache: false,
		 								success : function(data) {
		 							      
		 									if(data.success==1){ 
		 									  HideWaiting() ;		   
		 								         	  showMsgSuccess("ยกเลิกสำเร็จ");
		 								         	
		 											  inquiryRandomOil();
														  sendmailtoAdmin();
											
		 											
		 									}else{
		 										  HideWaiting() ;
		 										  showMsgError(data.message);
		 									}
		 									$('#popup_spareRandomOil_cancel').modal('hide');
		 								},
		 								error : function() {
		 									 showMsgError(data.message);
		 									  HideWaiting() ;
		 								}
		 							 });
 	            		      },
 	            		     'ยกเลิก': function () {
 						            
 						        } 		 		  
 		    		  }
 		    	  });	
               
 		} catch (ex) {
 			 showMsgError(ex);
 			  HideWaiting() ;
 			 
 		}
     }
	function sendmailtoAdmin(){
		
		var role="'0007','0010','0005','0004'";
		var data ={};
		data["role_id"]=role;
		jQuery.ajax({
		 			url : 'sendmailtoadmin?labcode='+$("#labcodeID").val(),
		 			type : "Post", 
		 			contentType : "application/json",
		 			data : JSON.stringify(data), 
		 			dataType : 'json',
		 			async: false,
		 			cache: false,
		 			success : function(data) {
		 							      
		 			},
		 			error : function() {
		 				 showMsgError(data.message);
		 				 
		 			}
		 	});
	}
     function UpdateDataCarNo(a,PO_NO,DO_NO,SHIPMENT_NO,PLANT_ID,SOURCE_ID,LOGIS_ID,PRODUCT_ID,CAR_NO,SAMPLE_DATA_GROUP,SAMPLE_DATA_SEQ){
    	 //popup_CancelRandomOil
    	 //$( "#carNo_"+i ).prop( "disabled", true );
    	 //console.log("CAR NO = "+$( "#carNo_"+i ).val());
    	 //console.log("Lab Code = "+labcode);
    	 try{
 		    	   $.confirm({
 	            		    title: 'ยืนยันแก้ไขข้อมูล',
 	            		    icon: 'fa fa-exclamation-circle',
	                        type: 'blue',
 	            		    content: '',
 	            		    buttons: {
 	            		    'ยืนยัน': function () {         
		 							 var data = {} 
						    			data["labCode_No"] = $("#labcodeID").val();
		 							 	data["poNo"] = PO_NO;
		 							 	data["doNo"] = DO_NO;
		 							 	data["shipmentNo"] = SHIPMENT_NO;
		 							 	data["plantid"] = PLANT_ID;
		 							 	data["sourceId"] = SOURCE_ID;
		 							 	data["ownerLogistic"] = LOGIS_ID;
		 							 	data["productOil"] = PRODUCT_ID;				 	
		 								data["carNo"] = CAR_NO ;
		 								data["group_seq"] = SAMPLE_DATA_GROUP;
		 								data["seq"] = SAMPLE_DATA_SEQ;
		 								data["causeChgStatus"] = $("#causeChgStatus").val();
						    			data["selectCause"] = $("#selectCause").val();
						    			//data["status"] = del;
						    			console.log(JSON.stringify(data));
		 							  jQuery.ajax({
		 								url : 'updatedataCarNoValue',
		 								type : "Post", 
		 								contentType : "application/json",
		 								data : JSON.stringify(data), 
		 								dataType : 'json',
		 								  async: false,
		 								   cache: false,
		 								success : function(data) {
		 							      
		 									if(data.success==1){ 
		 									  HideWaiting() ;		   
		 								         	  showMsgSuccess("บันทึกสำเร็จ");
		 								         	
		 											  inquiryRandomOil();
		 												
		 									}else{
		 										  HideWaiting() ;
		 										  showMsgError(data.message);
		 									}
		 									 $('#popup_spareRandomOil').modal('hide');
		 								},
		 								error : function() {
		 									 showMsgError(data.message);
		 									  HideWaiting() ;
		 								}
		 							 });
 	            		      },
 	            		     'ยกเลิก': function () {
 						            
 						        } 		 		  
 		    		  }
 		    	  });	
               
 		} catch (ex) {
 			 showMsgError(ex);
 			  HideWaiting() ;
 			 
 		}
     }
     function queryTableFreeCar(labcode){
    	 
    	 try {
    		 	$('#freeCar').html("");
             	$('#myTableFreeCar').DataTable().destroy();
		    	var data = {}	
		    	//data["sampleType"] = $("#ddlSampleType").val();
		    	data["referenceNo"] = $("#sampleRefer").val();
		    	data["labCode"] = labcode;
		    	//console.log(JSON.stringify(data));
		    	ShowWaiting() ;
				jQuery.ajax({
				url : 'queryDataFreeCar',
				type : "Post", 
				contentType : "application/json",
				data : JSON.stringify(data), 
				dataType : 'json',
				async: false,
				cache: false,
				success : function(data) {
				
					if(data.success==1){
					 var det = "";
					
								 for (var i = 0; i < data.list.length; i++) {
								 	  
									det +='<tr>';
									det +='<td class="text-left">'+(data.list[i].PO_NO==null?"":data.list[i].PO_NO)+'</td>';
									det +='<td class="text-left" >'+(data.list[i].DO_NO==null?"":data.list[i].DO_NO)+'</td>';
									det +='<td class="text-left" >'+(data.list[i].SHIPMENT_NO==null?"":data.list[i].SHIPMENT_NO)+'</td>'; 
									det +='<td class="text-left" >'+(data.list[i].PLANT_NAME==null?"":data.list[i].PLANT_NAME)+'</td>'; 
									det +='<td class="text-left" >'+(data.list[i].SOURCE_NAME==null?"":data.list[i].SOURCE_NAME)+'</td>'; 
									if("T" == data.list[i].PLANT_NAME){
										det +='<td class="text-left" > - </td>';
									}else{
										det +='<td class="text-left" >'+(data.list[i].LOGIS_NAME==null?"":data.list[i].LOGIS_NAME)+'</td>';
									}
									  
									det +='<td class="text-left" >'+(data.list[i].PRODUCT_NAME==null?"":data.list[i].PRODUCT_NAME)+'</td>'; 
									det +='<td class="text-left" >'+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)+'</td>';
									det +='<td class="text-left" >'+(data.list[i].RANDOM_FLG==null?"":data.list[i].RANDOM_FLG)+'</td>';
									det +='<td class="text-center" ><a onclick="UpdateDataCarNo(\''
											+ '\',\''+(data.list[i].PO_NO==null?"":data.list[i].PO_NO)
											+ '\',\''+(data.list[i].DO_NO==null?"":data.list[i].DO_NO)
											+ '\',\''+(data.list[i].SHIPMENT_NO==null?"":data.list[i].SHIPMENT_NO)
											+ '\',\''+(data.list[i].PLANT_ID==null?"":data.list[i].PLANT_ID)
											+ '\',\''+(data.list[i].SOURCE_ID==null?"":data.list[i].SOURCE_ID)
											+ '\',\''+(data.list[i].LOGIS_ID==null?"":data.list[i].LOGIS_ID)
											+ '\',\''+(data.list[i].PRODUCT_ID==null?"":data.list[i].PRODUCT_ID)
											+ '\',\''+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)
											+ '\',\''+(data.list[i].SAMPLE_DATA_GROUP==null?"":data.list[i].SAMPLE_DATA_GROUP)
											+ '\',\''+(data.list[i].SAMPLE_DATA_SEQ==null?"":data.list[i].SAMPLE_DATA_SEQ)
											+'\')"><span class="glyphicon glyphicon-wrench"></span>Select</a></td>' ;
									det +='</tr>';
									//console.log(data.list[i].PRODUCT_NAME);
								}
								 if (det == '') {
		                                det += '<tr> ';
		                                det += '<th colspan="18" class="text-center">--- ไม่พบข้อมูล ---</th> ';
		                                det += '</tr> ';
		                                $('#freeCar').html(det);

		                         }else{
		                        	 $('#freeCar').html(det);
		                                table = $('#myTableFreeCar').DataTable({
		                                    searching: true,
		                                    responsive: true
		                             }); 
		                         }
								 HideWaiting() ;
								 
					}else{
						 showMsgError(data.message);
						 HideWaiting() ;
					}
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
     function openSpareRandomOilPopup(i,labcode,del){	
    	 $("#selectCause").select2({width: '100%'});
   	   	 $('#popup_spareRandomOil').modal('show');
      	 try {

 			 	 var nameStore   = $("#hidden_namestore").val();
 			
      		   	$('#dteIdSpare').html("");
      		    
     		       $('#myTableSpareDteId').DataTable().destroy();
      		 		
    					var data = {}
		    			data["labCode_No"] = labcode;
					  	jQuery.ajax({
						url : 'randomOilDetail',
						type : "Post", 
						contentType : "application/json",
						data : JSON.stringify(data), 
						dataType : 'json',
						async: false,
						cache: false,
  						success : function(data) {
  							
  					    // alert(data.success);
  						if(data.success==1) {
  							 var det = "";
  							    //alert(data.list.length);
  										 for (var i = 0; i < data.list.length; i++) {
  										 	  
  											det +='<tr>';
  										 
  										    det +='<td class="text-left" >'+(data.list[i].SAMPLE_REFER==null?"":data.list[i].SAMPLE_REFER)+'</td>'; 
  											det +='<td class="text-left" >'+(data.list[i].STRPO_DATE==null?"":data.list[i].STRPO_DATE)+'</td>'; 
  											det +='<td class="text-center" >'+(data.list[i].SAMPLE_DATA_GROUP==null?"":data.list[i].SAMPLE_DATA_GROUP)+'</td>';
  											det +='<td class="text-center" >'+ (data.list[i].SAMPLE_DATA_SEQ==null?"":data.list[i].SAMPLE_DATA_SEQ)+'</td>';
  											det +='<td class="text-center" >'+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)+'</td>';
  											det +='<td class="text-center" >'+ (data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
  											det +='<td class="text-left" >'+(data.list[i].source_name==null?"":data.list[i].source_name)+'</td>'; 
  											if("00004" == data.list[i].SAMPLE_TYPE){
  												det +='<td class="text-center" > - </td>';
  											}else{
  												det +='<td class="text-center" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
  											}
  											
  											det +='<td class="text-center" >'+(data.list[i].STATUS_NAME==null?"":data.list[i].STATUS_NAME)+'</td>';
 
  										  det += '<td class="text-center" ><a href="#" onclick="EditData2()"><span class="glyphicon glyphicon-edit"></span></a></td>';
								
										  det +='</tr>';
  										  
  										  //GET DATA CAR_NO IN EDIT TEXTBOX
  										  
  										$("#CarNo").val(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO);
  										$("#getStatusValue").append('<option value="' + data.list[i].status + '">&nbsp;&nbsp;' + data.list[i].STATUS_NAME + '</option>');
  										}
  										
  										
  											
  										
  										 // alert(det);
  										if(det==''){
  											det += '<tr> ';
  											det += '<th colspan="9" class="text-center">--- ไม่พบข้อมูล ---</th> ';
  											det += '</tr> ';
  											$('#dteIdSpare').html(det);
  											  
  										}else{
  										//	alert('#dteId_'+nameStore);
  											$('#dteIdSpare').html(det);
  										
  											table =  $('#myTableSpareDteId').DataTable( {
  	 											searching: true,
  	 											responsive : true
  	 										});
  										} 
  										
  										
  										
  							} else {
  								 showMsgError(data.message);
  							}
  						},
  						error : function() {

  							 showMsgError('ข้อมูลผิดพลาด');
  						}
  					});
      		// });	   
  		} catch (ex) {
  			 showMsgError('ข้อมูลผิดพลาด');
  		}
      	 
      } 
     function inquiryRandomOil(){		
  	 	
  	 	var sampleType =  $("#selectType").val(); 
  	 	//console.log($("#selectType").val());
  	 	if(sampleType!=null){
  	 		var txtsampleType = "";
  	 		for(var i=0;i<sampleType.length;i++){
  	 			//console.log(sampleType[i]);
  	 			txtsampleType += "'"+sampleType[i]+"',";
  	 		}	
  	 		txtsampleType = txtsampleType.substring(0,txtsampleType.length-1) ;
  	 	}
  	 	//progressload();	
  	  	try {
     	
     		 // $("input[name='hidden_namestore']").each(function() { 
				 // alert($(this).val());
				 //var nameStore   = $("#hidden_namestore").val();
     		
     		      $('#dteId').html("");
     	  	 
    		       $('#myTableDteId').DataTable().destroy();
     		 
 		    			var data = {}
 		    			data["sampleType"] = txtsampleType;
 		    			data["status"] = "01";
 		    			//console.log(JSON.stringify(data));
 		    			ShowWaiting() ;
 					  jQuery.ajax({
 						url : 'randomOilDetail',
 						type : "Post", 
 						contentType : "application/json",
 						data : JSON.stringify(data), 
 						dataType : 'json',
 						  async: false,
 						   cache: false,
 						success : function(data) {

 							if(data.success==1) {
 							 
 							tmp_data = data;
 							dataT = data;
 							 renderTableData(dataT);
 							HideWaiting() ;
 							}else{
 							 
 								 showMsgError(data.message);
 								// jAlert('error', data.message,'ข้อมูลผิดพลาด');
 								HideWaiting() ;
 							}
 						},
 						error : function() {
 							//swal("error");
 							 showMsgError('ข้อมูลผิดพลาด');
 							HideWaiting() ;
 							// jAlert('error', '','ข้อมูลผิดพลาด');
 						}
 					});
     		// });	   
 		} catch (ex) {
 			//swal(ex);
 			 showMsgError(ex);
 			HideWaiting() ;
 			 //jAlert('error', ex,'ข้อมูลผิดพลาด');
 		}
     	 
     } 
     function renderTableData(data){
    	 //console.log(data.list.length);
    	 let det = "";
    	 for (var i = 0; i < data.list.length; i++) {
		 	  
				//console.log(data.list[i].LAB_CODE+"|"+data.list[i].CAR_SLOT);
				det +='<tr  class="TBODY">';
				det +='<td class="text-center" >'+ (data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE) +'</td>';
				det += '<td class="text-center" ><input type="checkbox" id="chk" name="chk" value="'+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)+'" /> </td>';
					
				if(data.list[i].FLAG_PRINT == 'Y'){
						det += '<td class="text-center" ><i class="glyphicon glyphicon-ok"></i></td>';
					}else{
					det += '<td class="text-center" ><i class="glyphicon glyphicon-remove"></i></td>';
					}
				det +='<td class="text-left" >'+ (data.list[i].SAMPLE_TYPE_NAME==null?"":data.list[i].SAMPLE_TYPE_NAME)+'</td>';
				//
				det +='<td class="text-left" >'+ (data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].source_name==null?"":data.list[i].source_name)+'</td>'; 
				if("T" == data.list[i].SAMPLE_TYPE_NAME){
					det +='<td class="text-left" > - </td>';
				}else{
					det +='<td class="text-left" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
				}
				
				det +='<td class="text-leftr" >'+(data.list[i].SAMPLE_LEVEL_DESC==null?"":data.list[i].SAMPLE_LEVEL_DESC)+'</td>';
				//
				det +='<td class="text-left" >'+ (data.list[i].SAMPLE_REFER==null?"":data.list[i].SAMPLE_REFER)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].PO_NO==null?"":data.list[i].PO_NO)+'</td>'; 
				det +='<td class="text-left" >'+(data.list[i].STRPO_DATE==null?"":data.list[i].STRPO_DATE)+'</td>'; 
				det +='<td class="text-left" >'+(data.list[i].DO_NO==null?"":data.list[i].DO_NO)+'</td>'; 
				det +='<td class="text-left" >'+(data.list[i].SHIPMENT_NO==null?"":data.list[i].SHIPMENT_NO)+'</td>';  
				det +='<td class="text-left" >'+(data.list[i].SAMPLE_DATA_GROUP==null?"":data.list[i].SAMPLE_DATA_GROUP)+'</td>'; 
				det +='<td class="text-left" >'+(data.list[i].SAMPLE_DATA_SEQ==null?"":data.list[i].SAMPLE_DATA_SEQ)+'</td>';  
				det +='<td class="text-left" > '+(data.list[i].METER_NO==null?"":data.list[i].METER_NO)+'</td>';
				det +='<td class="text-left" > '+(data.list[i].CAR_NO==null?"":data.list[i].CAR_NO)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].CAR_SLOT==null?"":data.list[i].CAR_SLOT)+'</td>';
				//det +='<td class="text-left" >'+(data.list[i].BOAT_NO==null?"":data.list[i].BOAT_NO)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].BOAT_NAME==null?"":data.list[i].BOAT_NAME)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].BOAT_SLOTP==null?"":data.list[i].BOAT_SLOTP)+'</td>'; 
				det +='<td class="text-left" >'+(data.list[i].BOAT_SLOTS==null?"":data.list[i].BOAT_SLOTS)+'</td>'; 
				//det +='<td class="text-left" >'+(data.list[i].ADDITIVE_INV_NO==null?"":data.list[i].ADDITIVE_INV_NO)+'</td>'; 
				det +='<td class="text-left" >'+(data.list[i].ADTV_LOT_NO==null?"":data.list[i].ADTV_LOT_NO)+'</td>'; 
				
				det +='<td class="text-center" >'+(data.list[i].STR_SAMPLE_DATE==null?"":data.list[i].STR_SAMPLE_DATE)+'</td>';
				det +='<td class="text-center" >'+(data.list[i].STR_SAMPLE_EXPIRE_DATE==null?"":data.list[i].STR_SAMPLE_EXPIRE_DATE)+'</td>';
				//
				
				//var userName,codeEmpID;
				if(("00001" == data.list[i].SAMPLE_TYPE ||"00010" == data.list[i].SAMPLE_TYPE)&& "N"== data.list[i].MANUAL_TYPE){
					det +='<td class="text-left" >'+codeEmpID+'</td>';
						det +='<td class="text-left" >'+userName+'</td>';
				}else{
					det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_ID==null?"":data.list[i].SAMPLE_STAFF_ID)+'</td>';
						det +='<td class="text-left" >'+(data.list[i].SAMPLE_STAFF_NAME==null?"":data.list[i].SAMPLE_STAFF_NAME)+'</td>';
				}
				
				//det +='<td class="text-left" >'+(data.list[i].OTHERLOGISTIC==null?"":data.list[i].OTHERLOGISTIC)+'</td>';
				//det +='<td class="text-left" >'+(data.list[i].SOURCE_OTHER_DESC==null?"":data.list[i].SOURCE_OTHER_DESC)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].SUB_TYPE_NAME==null?"":data.list[i].SUB_TYPE_NAME)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].SAMPLE_TYPEC_DESC==null?"":data.list[i].SAMPLE_TYPEC_DESC)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].TANK_NO==null?"":data.list[i].TANK_NO)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].TYPE_NAME==null?"":data.list[i].TYPE_NAME)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].LOC_NAME==null?"":data.list[i].LOC_NAME)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].SAMPLE_POINT_DESC==null?"":data.list[i].SAMPLE_POINT_DESC)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].RETURNR_DESC==null?"":data.list[i].RETURNR_DESC)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].STATUS_NAME==null?"":data.list[i].STATUS_NAME)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].CANCEL_DESC==null?"":data.list[i].CANCEL_DESC)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].CANCEL_NAME==null?"":data.list[i].CANCEL_NAME)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].REVISE_DESC==null?"":data.list[i].REVISE_DESC)+'</td>';
				det +='<td class="text-left" >'+(data.list[i].REVISE_CODE==null?"":data.list[i].REVISE_CODE)+'</td>';
				det +='<td class="text-center" ><a onclick="EditValue(\''
					+ i
					+ '\',\''+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)
					+ '\',\''+(data.list[i].SAMPLE_REFER==null?"":data.list[i].SAMPLE_REFER)
					+'\')"><span class="glyphicon glyphicon-edit"></span>EDIT CAR NO</a></td>' ;
				det +='<td class="text-center" ><a onclick="ShowCancel(\''
					+ i
					+ '\',\''+(data.list[i].LAB_CODE==null?"":data.list[i].LAB_CODE)
					+ '\',\''+ '11'
					+'\')"><span class="glyphicon glyphicon-edit"></span>CANCEL</a></td>' ;
				det +='</tr>';
				
				 //$( "#carNo_"+i ).prop( "disabled", true );
			}
			 // alert(det);
			if(det==''){
				$('#dteId').html(det);
				HideWaiting() ;
				  
			}else{
			//	alert('#dteId_'+nameStore);
				$('#dteId').html(det);
				HideWaiting() ;
				
			} 
			table =  $('#myTableDteId').DataTable( {
				//paging: false,
				"pageLength": 20,
				searching: true,
				responsive : true,
				"columnDefs": [
				    { "orderable": false, "targets": 1 }
				  ]
			});
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
//เดี๋ยวว่างๆ มาแก้ใหม่
     function printAll(){
    	 checkSelect("print");
     }
     function checkSelect(inp){
    	 let labcode =  "";
    	 $("input[name='chk']").each(function() { 
	   	     //  alert($(this).prop('checked')+"-"+$(this).val()) ;   
	    	        if($(this).prop('checked')){
	    	        	  //    alert(tmpdata_plan.list.length);
	    	        	     for(var i=0;i<tmp_data.list.length;i++){
	    	        	    	 //console.log($(this).val());
	    			 			  if($(this).val()==tmp_data.list[i].LAB_CODE){   
	    			 				 labcode +=    "'"+$(this).val()+"',";   ;
	    			 			  } 
	    			 		 }	 
	    	        }
		 });
    	 labcode = labcode.substring(0,labcode.length-1);
    	 
    	let msg = "",re = 0;;
    	if(labcode!=''){
    		if(inp=="print"){
    			//report(labcode);
    	    	checkedPrint(labcode);
    	    	$('#labCodeID').val(labcode);
    	    	msg = 'กรุณาเลือกรายการ Print'
    		}else if(inp=="se"){
    			
    		}
    	}else{
    		if(inp=="print"){
    			re = 1; 
    			msg = 'กรุณาเลือกรายการ Print'
    			showMsgWarning(msg);
    		}else if(inp=="sendRequest"){
    			re = 1;
    			msg = 'กรุณาเลือกใบคำขอวิเคราะห์'
    			showMsgWarning(msg);	
    		}
    	}
    	
    	return re;
     }
	function checkedPrint(labcode){
		try {
	    	var data = {}	
	    	data["labCode"] = labcode;
	    	console.log(JSON.stringify(data));
	    	ShowWaiting() ;
			jQuery.ajax({
			url : 'checkedPrint',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(data), 
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
			
				if(data.success==1){
					report(labcode);
					//inquiryRandomOil();
			    	//SetDropDownSelectType();	 
					location.reload();
				}else{
					 showMsgError(data.message);
					 HideWaiting() ;
				}
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
    function report(labcode){
    	var ctx = "${pageContext.request.contextPath}";
    	var link = "/Lab/reportHome?labCode_NoIn="+labcode;
    	// 		window.location.href = link;
    	
    			window.open(link, '_blank');
    }
    function searchSampleType(item){
    	let list = [];
    	$('#dteId').html("");
	    $('#myTableDteId').DataTable().destroy();
    	$.each($("#selectType").val(),function(i,item){
    		$.each(tmp_data.list,function(){
    			if(this.SAMPLE_TYPE==item){
    				list.push(this);
    			}
        	});
    	});
    	tmp_data2={};
    	tmp_data2["list"] = list;
    	renderTableData(tmp_data2);	
    }
 
    	
    
    function SetDropDownStatus() {
    	 $('#getStatusValue').val("");
        try {
        	$('#getStatusValue').html("");
            jQuery.ajax({
                url: 'util-getDropdownStatusStore',
                type: "Post",
                contentType: "application/json",
                dataType: 'json',
                cache: false,
                success: function (data) {

                    var txt = '';
                    
                    $.each(data, function (i, item) {

                        $('#getStatusValue').append('<option value="' + item.CANCEL_CODE + '">&nbsp;&nbsp;' + item.CANCEL_NAME + '</option>');
                        
                        //    txt   += item.PRODUCT_ID+',';
                        // console.log(item)
                    });
                    const p2 = performance.now();
                    console.log(`Time: ${p2 - p1}`);
                    //$('#getStatusValue').select2({dropdownAutoWidth : true,width: 'auto'});
                    $('#getStatusValue').select();
                },
                error: function () {
                    showMsgError('เกิดข้อผิดพลาด');
                }
            });

        } catch (ex) {
            showMsgError(ex);

        }
    }
    function SetDropDownSelectType() {
    	ShowWaiting() ;
    	$('#selectType').val("");
        try {
        	$('#selectType').html("");
            jQuery.ajax({
                url: 'util-getDropdownSampleType',
                type: "Post",
                contentType: "application/json",
                dataType: 'json',
                //  async: false,
                cache: false,
                success: function (data) {
                    var txt = '';

                    $.each(data, function (i, item) {

                        $('#selectType').append('<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
                        txt += item.PID + ',';
						
                    });
                    if (txt.length > 0) {
                        txt = txt.substring(0, txt.length - 1)
                    }
                    $('#selectType').select2({placeholder: "ประเภทตัวอย่าง",dropdownAutoWidth : true,width: '200'});
                    /*
                    $('#selectType').change(
                    	function () {
                 	   		inquiryRandomOil(this.value);
                 	   		console.log(this.value);
                    });
                    */
                    HideWaiting() ;
                },
                error: function () {
                    showMsgError('ข้อมูลผิดพลาด');
                    HideWaiting() ;
                }
            });

        } catch (ex) {
            showMsgError(ex);
            HideWaiting() ;

        }
    }
    function SetDropDowncauseChgStatus() {
    ShowWaiting() ;
    	//alert("dddd");
   	 $('#selectCause').val("");
   	$('#selectCause_cancel').val("");
       try {
       	$('#selectCause').html("");
       	$('#selectCause_cancel').html("");
           jQuery.ajax({
               url: 'util-getDropdowncauseChgStatus',
               type: "Post",
               contentType: "application/json",
               dataType: 'json',
               async:false,
               cache: false,
               success: function (data) {
                   var txt = '';
                   $.each(data, function (i, item) {

                       $('#selectCause').append('<option value="' + item.CANCEL_CODE + '">' + item.CANCEL_NAME + '</option>');
                       $('#selectCause_cancel').append('<option value="' + item.CANCEL_CODE + '">' + item.CANCEL_NAME + '</option>');
                   });
                   //$('#getStatusValue').select2({dropdownAutoWidth : true,width: 'auto'});
                   $('#selectCause').select2(
                		   {
                			   dropdownParent: $("#popup_spareRandomOil"),
                			   dropdownAutoWidth : true,
                			   width: 'auto'   
                		   });
                   $('#selectCause_cancel').select2(
                		   {
                			   dropdownParent: $("#popup_spareRandomOil_cancel"),
                			   dropdownAutoWidth : true,
                			   width: 'auto'   
                		   });
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