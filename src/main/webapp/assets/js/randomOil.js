var table = "";
var nameStoreTmp = [];
var nameStoreTmpString = "";
var dataTmp  ;

	$(document).ready(function () {


		$('#poDate').val(getThaiBuddaDate());

		$('#ddlStore').multiselect({
			selectAllValue: 'all',
			includeSelectAllOption: true
		});

		$('#ddlProduct').multiselect({
			selectAllValue: 'all',
			includeSelectAllOption: true
		});

		$('#ddlLogistic').multiselect({
			selectAllValue: 'all',
			includeSelectAllOption: true
		});

		$('#ddlSource').multiselect({
			selectAllValue: 'all',
			includeSelectAllOption: true
		});

		SetDropDownStore();
		SetDropDownProduct();
		SetDropDownLogistic();
		SetDropDownSource();
		SetDropDownPlant()
		inquiryRandomOil();
		showFlgRandom();
		$('#percenRan').on('input',function(e){
			if($('#percenRan').val()>100 || $('#percenRan').val()<0 ){
				$("#percenRan").val("");
			}
		});



	});

	function showFlgRandom(){
		var flg = getAutoRandomFlg();
		//console.log(flg);
		//get Data
		if("Y"==flg.split("|")[0]){
			$("#switchRandom").bootstrapToggle('on')
		}else{
			$("#switchRandom").bootstrapToggle('off')
		}
		//update
		$("#switchRandom").change(function(){
			if($(".toggle").hasClass("off")){
				updateAutoRandomFlg('N',flg.split("|")[1]);
			}else{
				updateAutoRandomFlg('Y',flg.split("|")[1]);
			}
		});
	}
	function updateAutoRandomFlg(flg,flgCode){
		try {
			var data = {};
			data["flgRan"] = flg;
			data["flgCode"] = flgCode;
			console.log(JSON.stringify(data));
			jQuery.ajax({
				url : 'updateFlgRandom',
				type : "Post",
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : 'json',
				//async: false,
				cache: false,
				success : function(data) {
					showMsgSuccess('สำเร็จ');
				},
				error : function() {
					showMsgError('เกิดข้อผิดพลาด');
				}
			});

		} catch (ex) {
			showMsgError(ex);
		}
	}
	function getAutoRandomFlg(){
		var flgR = "";
		try {
			var data = {}
			jQuery.ajax({
				url : 'util-getAutoRandomFlg',
				type : "Post",
				contentType : "application/json",
				dataType : 'json',
				async: false,
				cache: false,
				success : function(data) {

					$.each(data,function(i,item){
						if("001"==item.CODE){
							flgR = item.FLG_RANDOM+"|"+item.CODE;
							//console.log(item.FLG_RANDOM);
						}
					});

				},
				error : function() {
					showMsgError('เกิดข้อผิดพลาด');
				}
			});

		} catch (ex) {
			showMsgError(ex);
		}
		return flgR;
	}
	function getThaiBuddaDate(date){
		var rtnDate = "";
		var data = {}
		data["poDate"] = date;
		jQuery.ajax({
			url : 'getThaiBuddaDate',
			type : 'Post',
			//async: false,
			cache: false,
			contentType : 'application/json',
			data : JSON.stringify(data),
			dataType : 'json',
			success : function(obj) {
				rtnDate  = obj.poDate;
			}
		}).fail(function(){
			/*swal('Error...', 'เกิดข้อผิดพลาด!',
			'error');
			//ShowErrorMsg('0006', ex);
			//HideWaiting();
			});*/
			showMsgError('เกิดข้อผิดพลาด!');
		});
		return rtnDate
	}

	function SetDropDownSource(){
		try {

			jQuery.ajax({
				url : 'util-getDropdownSource',
				type : "Post",
				contentType : "application/json",
				dataType : 'json',
				//  async: false,
				cache: false,
				success : function(data) {

					// $('#ddlStore').find('option').remove().end();
					/*var select = document.getElementById('ddlStore');
					var opt = document.createElement('option');
					opt.value = "";
					opt.style =
					opt.innerHTML = "ทั้งหมด";
					select.appendChild(opt);
					*/
					var txt   = '';
					$.each(data, function (i, item) {
						$('#ddlSource').append('<option value="' + item.SOURCE_ID + '">&nbsp;&nbsp;'+item.SOURCE_NAME+'</option>');
						txt   += item.SOURCE_ID+',';
						// console.log(item)
					});
					if(txt.length>0){
						txt =  'all,'+txt.substring(0,txt.length-1)
					}

					$('#ddlSource').multiselect('rebuild');

					$("#ddlSource").multiselect('updateButtonText');
					$('#ddlSource').trigger('change');

					$('#ddlSource').val(txt.split(","));
					// alert(txt);
					$("#ddlSource").multiselect("refresh");

				},
				error : function() {
					//swal("error");
					showMsgError('เกิดข้อผิดพลาด');
				}
			});

		} catch (ex) {
			//swal(ex);
			showMsgError(ex);
		}
	}

	function SetDropDownStore(){
		try {
			var data = {};
			data["status"] = "randomoil";
			jQuery.ajax({
				url : 'util-getDropdownPlant',
				type : "Post",
				data : JSON.stringify(data),
				contentType : "application/json",
				dataType : 'json',
				//  async: false,
				cache: false,
				success : function(data) {
					// $('#ddlStore').find('option').remove().end();
					/*var select = document.getElementById('ddlStore');
					var opt = document.createElement('option');
					opt.value = "";
					opt.style =
					opt.innerHTML = "ทั้งหมด";
					select.appendChild(opt);
					*/
					var txt   = '';
					$.each(data, function (i, item) {

						$('#ddlStore').append('<option value="' + item.PID + '">&nbsp;&nbsp;'+item.PNAMET+'</option>');
						txt   += item.PID+',';
						// console.log(item)
					});
					if(txt.length>0){
						txt =  'all,'+txt.substring(0,txt.length-1);
					}

					$('#ddlStore').multiselect('rebuild');

					$("#ddlStore").multiselect('updateButtonText');
					$('#ddlStore').trigger('change');

					// alert(txt);
					$('#ddlStore').val(txt.split(","));
					$("#ddlStore").multiselect("refresh");
					/*var	opt = "" ;
					for (var i = 0; i < data.length; i++) {
					/*	var opt = document.createElement('option');
					opt.value = data[i].PID;
					opt.innerHTML = data[i].PNAMET;
					select.appendChild(opt);


					opt +=   '<option value="'+data[i].PID+'">'+data[i].PNAMET+'</option>' ;

					}
					$("#ddlStore").multiselect('updateOptions', opt);*/
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

	function SetDropDownProduct(){
		try {

			jQuery.ajax({
				url : 'util-getDropdownProduct',
				type : "Post",
				contentType : "application/json",
				dataType : 'json',
				//  async: false,
				cache: false,
				success : function(data) {

				// $('#ddlStore').find('option').remove().end();
				/*var select = document.getElementById('ddlStore');
				var opt = document.createElement('option');
				opt.value = "";
				opt.style =
				opt.innerHTML = "ทั้งหมด";
				select.appendChild(opt);
				*/
				var txt   = '';
				$.each(data, function (i, item) {
					$('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;'+item.PRODUCT_NAME+'</option>');
					txt   += item.PRODUCT_ID+',';
					// console.log(item)
				});
				if(txt.length>0){
					txt =  'all,'+txt.substring(0,txt.length-1)
				}

				$('#ddlProduct').multiselect('rebuild');

				$("#ddlProduct").multiselect('updateButtonText');
				$('#ddlProduct').trigger('change');


				// alert(txt);
				$('#ddlProduct').val(txt.split(","));
				$("#ddlProduct").multiselect("refresh");

				},
				error : function() {
					//swal("error");
					showMsgError('เกิดข้อผิดพลาด');
				}
			});
		} catch (ex) {
			//swal(ex);
			showMsgError(ex);
		}
	}
	function SetDropDownLogistic(){
		try {

			jQuery.ajax({
				url : 'util-getDropdownLogistics',
				type : "Post",
				contentType : "application/json",
				dataType : 'json',
				//  async: false,
				cache: false,
				success : function(data) {
					// $('#ddlStore').find('option').remove().end();
					/*var select = document.getElementById('ddlStore');
					var opt = document.createElement('option');
					opt.value = "";
					opt.style =
					opt.innerHTML = "ทั้งหมด";
					select.appendChild(opt);
					*/
					var txt   = '';
					$.each(data, function (i, item) {

						$('#ddlLogistic').append('<option value="' + item.LOGIS_ID + '">&nbsp;&nbsp;'+item.LOGIS_NAME+'</option>');
						txt   += item.LOGIS_ID+',';
						// console.log(item)
					});
					if(txt.length>0){
						txt =  'all,'+txt.substring(0,txt.length-1)
					}

					$('#ddlLogistic').multiselect('rebuild');

					$("#ddlLogistic").multiselect('updateButtonText');
					$('#ddlLogistic').trigger('change');

					// alert(txt);
					$('#ddlLogistic').val(txt.split(","));
					$("#ddlLogistic").multiselect("refresh");
				},
				error : function() {
					//swal("error");
					showMsgError('เกิดข้อผิดพลาด');
				}
			});
		} catch (ex) {
			//swal(ex);
			showMsgError(ex);

		}
	}

     function openRandomOilPopup(){
    	   $('#popup_random').modal('show');
     }
     function news(){

    	 alert($("#ddlStore").val());
     }
     function saveRandomOil(){
    	try{

    	// det = "";
 		$('#tb-body-import-id').html("");
 		 $('#myTableSum').DataTable().destroy();

 		//alert($("#ddlStore").val());
 			 var  ddlStore =  $("#ddlStore").val() ;
 			 var ddlProduct =  $("#ddlProduct").val() ;
 			 var ddlLogistic = $("#ddlLogistic").val();
 			 var ddlSource = $("#ddlSource").val();
             if(ddlSource==null ||ddlProduct==null||ddlLogistic==null||($("#poDate").val()==null||$("#poDate").val()=='')){
            	/* swal({
					  title: 'กรุณาระบุเงื่อนไขการสุ่ม',
					  type: "warning",
					  showCancelButton: false,
					  confirmButtonColor: "#5cb85c",
					  confirmButtonText: "ตกลง",
					  closeOnConfirm: false
					});*/
            	  // alert("กรุณาระบุเงื่อนไขการสุ่ม");
					// jAlert('warning', 'กรุณาระบุเงื่อนไขการสุ่ม');
					/*  $.alert({
                          title: 'warning',
                          icon: 'fa fa-warning',
                          type: 'orange',
                          content: 'กรุณาระบุเงื่อนไขการสุ่ม',
                      });*/
					  showMsgWarning('กรุณาระบุเงื่อนไขการสุ่ม');
					//bootbox.alert("This is the default alert!");
            	 return false ;
             }

    		 var txtddlStore = "";
    		 if(ddlStore!=null){
	    		 for(var i=0;i<ddlStore.length;i++){
	    			 txtddlStore += "'"+ddlStore[i]+"',";
	             }
	    		 txtddlStore = txtddlStore.substring(0,txtddlStore.length-1) ;
    		 }
    		 // alert(ddlStore+"-"+txtddlStore);

    		 var txtddlProduct = "";
    		 if(ddlProduct!=null){
	    		 for(var i=0;i<ddlProduct.length;i++){
	    			 txtddlProduct += "'"+ddlProduct[i]+"',";
	             }
	    		 txtddlProduct = txtddlProduct.substring(0,txtddlProduct.length-1) ;
    		 }
    		//  alert(ddlProduct);

    		 var txtddlLogistic = "";
    		 if(ddlLogistic!=null){
	    		 for(var i=0;i<ddlLogistic.length;i++){
	    			 txtddlLogistic += "'"+ddlLogistic[i]+"',";
	             }
	    		 txtddlLogistic = txtddlLogistic.substring(0,txtddlLogistic.length-1) ;
    		 }
    		 var txtsourceId = "";
    		 if(ddlSource!=null){
	    		 for(var i=0;i<ddlSource.length;i++){
	    			 txtsourceId += "'"+ddlSource[i]+"',";
	             }
	    		 txtsourceId = txtsourceId.substring(0,txtsourceId.length-1) ;

    		 }
    		 // alert(ddlLogistic);

    		/*  swal({
    				title: "ยืนยันการสุ่ม",
    				type: "warning",
    		        showCancelButton: true,
    		        closeOnConfirm: false,
    		        confirmButtonColor: "#5cb85c",
    		        showLoaderOnConfirm: true,
    		        confirmButtonText: "ตกลง",
    		  	    cancelButtonText: "ยกเลิก"

    		 	},
    		 	   function(){
    		 */
    		 		 ShowWaiting() ;
    				//  setTimeout(  function(){
		    			var data = {}
		    			data["nameStore"] =  txtddlStore ;
		    			data["productOil"] =  txtddlProduct ;
		    			data["ownerLogistic"] =   txtddlLogistic ;
		    			data["sourceId"] =   txtsourceId ;
		    			data["poDate"] = $("#poDate").val();
		    			data["percenRan"] = $("#percenRan").val();
					  jQuery.ajax({
						url : 'saveRandomOil',
						type : "Post",
						contentType : "application/json",
						data : JSON.stringify(data),
						dataType : 'json',
						 // async: false,
						   cache: false,
						success : function(data) {

							if(data.success==1){
							  HideWaiting() ;
										/* swal({
											  title: "บันทึกสำเร็จ",
											  text:"เลขอ้างอิง "+data.hd_no,
											  type: "success",
											  confirmButtonColor: "#5cb85c",
											  confirmButtonText: "ตกลง"
											},
											function(){*/
												   $('#popup_random').modal('show');
												   //$('#popup_random').modal('hide');
												//  $('#tb-body-import-id').html("");
  		                                       //  $('#myTableSum').DataTable().destroy();
											//});
										var det = "";
										for (var i = 0; i < data.list.length; i++) {


											det +='<tr  >';
											det +='<td class="text-left" >'+(data.list[i].plant_name==null?"":data.list[i].plant_name)+'</td>';

											det +='<td class="text-center" >'+(data.list[i].strPO_DATE==null?"":data.list[i].strPO_DATE)+'</td>';
											det +='<td class="text-right" >'+(data.list[i].product_name==null?"":data.list[i].product_name)+'</td>';
											det +='<td class="text-left" >'+(data.list[i].logis_name==null?"":data.list[i].logis_name)+'</td>';
											det +='<td class="text-left" >'+(data.list[i].source_name==null?"":data.list[i].source_name)+'</td>';
										//	det +='<td class="text-right" >'+(data.list[i].OWNER_PRODUCT_OIL==null?"":data.list[i].OWNER_PRODUCT_OIL)+'</td>';
										//	det +='<td class="text-center" >'+(data.list[i].OWNER_LOGISTIC==null?"":data.list[i].OWNER_LOGISTIC)+'</td>';
											det +='<td class="text-center" >'+(data.list[i].CNT_SUBSET==null?"":data.list[i].CNT_SUBSET)+'</td>';



											det +='</tr>';
										}

										if(det==''){
											det += '<tr> ';
											det += '<th colspan="5" class="text-center">--- ไม่พบข้อมูล ---</th> ';
											det += '</tr> ';
											$('#tb-body-import-id').html(det);

										}else{

											$('#tb-body-import-id').html(det);
											 table =  $('#myTableSum').DataTable( {
												searching: true,
												responsive : true
											});

										}
										$('#divInfo').html('');
												 inquiryRandomOil();

							}else if(data.success==2){
								  HideWaiting() ;
								  var  msg  = getMsg("MSG1");

								// jAlert('warning',msg);
								/* $.alert({
			                          title: 'warning',
			                          icon: 'fa fa-warning',
			                          type: 'orange',
			                          content: msg,
			                      });*/
								 showMsgWarning(msg);
							}else{
								//alert(data.message);
								  HideWaiting() ;
								 /* $.alert({
			                          title: 'เกิดข้อผิดพลาด',
			                          icon: 'fa fa-error',
			                          type: 'red',
			                          content: data.message,
			                      });*/
			                      showMsgError(data.message);
								// jAlert('error',data.message);

							}
						},
						error : function(ex) {

							// jAlert('error','เกิดข้อผิดพลาด');
							 /* $.alert({
		                          title: 'เกิดข้อผิดพลาด',
		                          icon: 'fa fa-error',
		                          type: 'red',
		                          content: ex,
		                      });*/
							  showMsgError('เกิดข้อผิดพลาด');
							  HideWaiting() ;
						}
					});

    			//	  }  , 500);
    		 // });

		} catch (ex) {
			 /*$.alert({
                 title: 'เกิดข้อผิดพลาด',
                 icon: 'fa fa-error',
                 type: 'red',
                 content: ex,
             });*/
			 showMsgError('เกิดข้อผิดพลาด');
			  HideWaiting() ;

		}

     }

     function inquiryRandomOil(){
     	 try {
     		  $("input[name='hidden_namestore']").each(function() {
				//console.log(this.value);
				var nameStore = $(this).val();
			    //$('#dteId_'+nameStore).html("");
			    //$('#myTableDteId_'+nameStore).DataTable().destroy();
			    nameStoreTmp.push(nameStore);
     		 });
 		} catch (ex) {
 			 showMsgError(ex);
 		}


 		$.each(nameStoreTmp,function(i,item){
 			nameStoreTmpString += "'"+item+"',"
 		});
 		nameStoreTmpString = nameStoreTmpString.substring(0,nameStoreTmpString.length-1);
 		setDataRandom(nameStoreTmpString);
     }
     function wirteDatainTable(nameStore,data){
    	 var det='';

			console.log(data);
			if(data==null){
					 det +='<tr class="TBODY" >';
				det += '<tr> ';
				det += '<th colspan="21" class="text-center">--- ไม่พบข้อมูล ---</th> ';
				det += '</tr> ';
	    		$('#dteId_').html(det);
	    	 }else{
					 det +='<tr class="TBODY" >';
					 det +='<td class="text-center" style="width:100px">'+ (data.STATUS_NAME==null?"":data.STATUS_NAME)+'</td>';
					det +='<td class="text-center" >'+ (data.LAB_CODE==null?"":data.LAB_CODE)+'</td>';
					det +='<td class="text-left" >'+ (data.SAMPLE_REFER==null?"":data.SAMPLE_REFER)+'</td>';
					det +='<td class="text-left" >'+(data.PO_NO==null?"":data.PO_NO)+'</td>';
					det +='<td class="text-left" >'+(data.STRPO_DATE==null?"":data.STRPO_DATE)+'</td>';
					det +='<td class="text-left" >'+(data.DO_NO==null?"":data.DO_NO)+'</td>';
					det +='<td class="text-left" >'+(data.SHIPMENT_NO==null?"":data.SHIPMENT_NO)+'</td>';
					det +='<td class="text-left" >'+(data.SAMPLE_DATA_GROUP==null?"":data.SAMPLE_DATA_GROUP)+'</td>';
					det +='<td class="text-left" >'+(data.SAMPLE_DATA_SEQ==null?"":data.SAMPLE_DATA_SEQ)+'</td>';
					det +='<td class="text-left" >'+(data.CAR_NO==null?"":data.CAR_NO)+'</td>';
					det +='<td class="text-left" >'+(data.CAR_SLOT==null?"":data.CAR_SLOT)+'</td>';
					det +='<td class="text-left" >'+(data.BOAT_NO==null?"":data.BOAT_NO)+'</td>';
					det +='<td class="text-left" >'+(data.BOAT_NAME==null?"":data.BOAT_NAME)+'</td>';
					det +='<td class="text-left" >'+(data.BOAT_SLOT==null?"":data.BOAT_SLOT)+'</td>';
					det +='<td class="text-center" >'+(data.STR_SAMPLE_DATE==null?"":data.STR_SAMPLE_DATE)+'</td>';
					det +='<td class="text-center" >'+(data.STR_SAMPLE_EXPIRE_DATE==null?"":data.STR_SAMPLE_EXPIRE_DATE)+'</td>';
					det +='<td class="text-left" >'+ (data.product_name==null?"":data.product_name)+'</td>';
					det +='<td class="text-left" >'+(data.source_name==null?"":data.source_name)+'</td>';
					det +='<td class="text-left" >'+(data.logis_name==null?"":data.logis_name)+'</td>';
					det +='<td class="text-leftr" >'+(data.SAMPLE_LEVEL_DESC==null?"":data.SAMPLE_LEVEL_DESC)+'</td>';
					det +='<td class="text-left" >'+(data.SAMPLE_STAFF_ID==null?"":data.SAMPLE_STAFF_ID)+'</td>';
					det +='<td class="text-left" >'+(data.SAMPLE_STAFF_NAME==null?"":data.SAMPLE_STAFF_NAME)+'</td>';
					det +='</tr>';
	    		$('#dteId_').append(det);
	 		 	  table =  $('#myTableDteId_').DataTable( {
	 				searching: true,
	 				responsive : true
	 			});
	    	 }
     }
     function setDataRandom(nameStore){
	 $('#dteId_').html("");
	 var dataDetail= []
	 var index =1;
	 	 ShowWaiting() ;
    	 var data = {}
    			data["status"] = "";
    			data["nameStore"] = "'1111','1101','1102','1103','1104','1105','1106','1107','1108','1109','1110','1113','1201','1401','1501','1901'";
    			data["manualType"] = 'N';

    			console.log(JSON.stringify(data));
			  jQuery.ajax({
				url : 'randomOilDetail',
				type : "Post",
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : 'json',
				//async: false,
				  //cache: false,
				success : function(data) {
		  	dataTmp = data
					if(data.success==1){
						for(i=0;i<data.list.length;i++){

				    			 if(data.list[i].PLANT_ID==$('#ddlPlant').val()){

				    				 // $('#myTableDteId_').DataTable().destroy();
				    			  	 // wirteDatainTable($('#ddlPlant').val(),data.list[i]);
											 dataDetail[index++] = dataTmp.list[i]
				    			 }else{
										 	// wirteDatainTable(null,null);
									 }


				    	 }
							 $('#myTableDteId_').DataTable().destroy();
							wirteDatainTableNew(dataDetail)
					}else{
						 showMsgError(data.message);
					}
				},
				error : function() {
					 showMsgError('เกิดข้อผิดพลาด');
				}
			});
			HideWaiting();
     }



		 function SetDropDownPlant() {
		     $('#ddlPlant').val("");
				 	var data = {};
						data["status"] = "randomoil";
		     try {
		         $('#ddlPlant').html("");
		         jQuery.ajax({
		             url: 'util-getDropdownPlant',
		             type: "Post",
		             contentType: "application/json",
		             data: JSON.stringify(data),
		             async: false,
		             cache: false,
		             success: function(data) {
		                 $.each(data, function(i, item) {

		                     $('#ddlPlant').append('<option value="' + item.PID + '">' + item.PNAMET + '</option>');
		                 });
		                 $('#ddlPlant').select2({
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

		 function renderDataToTable(){
			 nameStoreTmp=[]
			 var dataDetail = []
			 	var nameStore ;
				var index =1;
			 $.each($('#ddlPlant')[0],function(i,a){
				 nameStore = $(this).val();
				 nameStoreTmp.push(nameStore);
			 })
			 if(dataTmp!=null){
				 $('#dteId_').empty();
				 // console.log(dataTmp.length)
				 for(i=0;i<dataTmp.list.length;i++){
					 //console.log(data.list[i].PLANT_ID)
								if(dataTmp.list[i].PLANT_ID==$('#ddlPlant').val()){
									// console.log(dataTmp.list[i].PLANT_ID+' : '+$('#ddlPlant').val());

									// wirteDatainTable($('#ddlPlant').val(),dataTmp.list[i]);
										 dataDetail[index++] = dataTmp.list[i]
								}else{
										// wirteDatainTable(null,null);
								}


						}
	         $('#myTableDteId_').DataTable().destroy();
						wirteDatainTableNew(dataDetail)
			 }else{

			 }
		 }
		 function wirteDatainTableNew(datas){
			 var det='';

 		 $('#dteId_').html('')
			 if(datas==null){
			 		det +='<tr class="TBODY" >';
			   det += '<tr> ';
			   det += '<th colspan="21" class="text-center">--- ไม่พบข้อมูล ---</th> ';
			   det += '</tr> ';
			 	 $('#dteId_').html(det);
			 	}else{

					$.each(datas,function(index,data){
						console.log(index);
					if(data!=undefined){
						det +='<tr class="TBODY" >';
					det +='<td class="text-center" style="width:100px">'+ (data.STATUS_NAME==null?"":data.STATUS_NAME)+'</td>';
				 det +='<td class="text-center" >'+ (data.LAB_CODE==null?"":data.LAB_CODE)+'</td>';
				 det +='<td class="text-left" >'+ (data.SAMPLE_REFER==null?"":data.SAMPLE_REFER)+'</td>';
				 det +='<td class="text-left" >'+(data.PO_NO==null?"":data.PO_NO)+'</td>';
				 det +='<td class="text-left" >'+(data.STRPO_DATE==null?"":data.STRPO_DATE)+'</td>';
				 det +='<td class="text-left" >'+(data.DO_NO==null?"":data.DO_NO)+'</td>';
				 det +='<td class="text-left" >'+(data.SHIPMENT_NO==null?"":data.SHIPMENT_NO)+'</td>';
				 det +='<td class="text-left" >'+(data.SAMPLE_DATA_GROUP==null?"":data.SAMPLE_DATA_GROUP)+'</td>';
				 det +='<td class="text-left" >'+(data.SAMPLE_DATA_SEQ==null?"":data.SAMPLE_DATA_SEQ)+'</td>';
				 det +='<td class="text-left" >'+(data.CAR_NO==null?"":data.CAR_NO)+'</td>';
				 det +='<td class="text-left" >'+(data.CAR_SLOT==null?"":data.CAR_SLOT)+'</td>';
				 det +='<td class="text-left" >'+(data.BOAT_NO==null?"":data.BOAT_NO)+'</td>';
				 det +='<td class="text-left" >'+(data.BOAT_NAME==null?"":data.BOAT_NAME)+'</td>';
				 det +='<td class="text-left" >'+(data.BOAT_SLOT==null?"":data.BOAT_SLOT)+'</td>';
				 det +='<td class="text-center" >'+(data.STR_SAMPLE_DATE==null?"":data.STR_SAMPLE_DATE)+'</td>';
				 det +='<td class="text-center" >'+(data.STR_SAMPLE_EXPIRE_DATE==null?"":data.STR_SAMPLE_EXPIRE_DATE)+'</td>';
				 det +='<td class="text-left" >'+ (data.product_name==null?"":data.product_name)+'</td>';
				 det +='<td class="text-left" >'+(data.source_name==null?"":data.source_name)+'</td>';
				 det +='<td class="text-left" >'+(data.logis_name==null?"":data.logis_name)+'</td>';
				 det +='<td class="text-leftr" >'+(data.SAMPLE_LEVEL_DESC==null?"":data.SAMPLE_LEVEL_DESC)+'</td>';
				 det +='<td class="text-left" >'+(data.SAMPLE_STAFF_ID==null?"":data.SAMPLE_STAFF_ID)+'</td>';
				 det +='<td class="text-left" >'+(data.SAMPLE_STAFF_NAME==null?"":data.SAMPLE_STAFF_NAME)+'</td>';
				 det +='</tr>';
					}
					})
			 	 $('#dteId_').append(det);
			 	 table =  $('#myTableDteId_').DataTable( {
			 	 searching: true,
			 	 responsive : true
			  });
			 	}
		 }
