var basePath = '/Lab/api/';
var userTypeSetText = "";
var roleUser ='';
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
            	for(var i=0;i<data.list.length;i++){
            		userTypeSetText = data.list[0].LEVEL_HEAD;
            	}
				roleUser=data.role;
            	console.log(userTypeSetText);
            	
            	if(userTypeSetText=='7'){ //A4
            		$("#taskTopicPage").html("A4")
            		$("#workNewText").html("งานที่ต้องตรวจสอบ");
            		$("#workEditText").html("งานที่ส่งแก้ไข");
            		$("#workDoneText").html("งานที่ตรวจสอบแล้ว");
					$("#block_wait_work").css("display", "block");

            		//$("#assignHDedit").hide();
            	}else if(userTypeSetText=='6'){ //Team Lead
            		$("#workNewText").html("รออนุมัติ");
            		$("#workEditText").html("งานที่ต้องแก้ไข");
            		$("#workDoneText").html("งานที่อนุมัติแล้ว");
            		$("#taskTopicPage").html("Lab Team Lead")
					$("#assignHDTemp").show();
					$("#workTempText").html("Temporary");
            	}else if(userTypeSetText=='5'){ //Lab Manager
            		$("#workNewText").html("รออนุมัติ");	
            		$("#workDoneText").html("งานที่อนุมัติแล้ว");
            		$("#taskTopicPage").html("Lab Manager")
            		$("#assignHDedit").hide();
            	}else if(userTypeSetText=='1'){ //Lab Operation
            		$("#taskTopicPage").html("Lab Operation")
            		$("#assignHDnew").hide();
            		$("#assignHDedit").hide();
            		$("#assignHDsuccess").hide();
            	}else if(userTypeSetText=='2'){ //ส่วนคัลงน้ำมัน
            		$("#taskTopicPage").html("ส่วนคลังน้ำมัน")
            		$("#assignHDnew").hide();
            		$("#assignHDedit").hide();
            		$("#assignHDsuccess").hide();
            	}else if(userTypeSetText=='3'){ //ผู้จัดการคลัง
					window.location.replace("/Lab/reportLTRPlant");
            		$("#taskTopicPage").html("ผู้จัดการคลัง")
            		$("#assignHDnew").hide();
            		$("#assignHDedit").hide();
            		$("#assignHDsuccess").hide();
            	}else{
            		$("#taskTopicPage").html("Home")
            		$("#workNewText").html("งานใหม่");
            		$("#workEditText").html("งานที่ต้องแก้ไข");
            		$("#workDoneText").html("งานที่บันทึกแล้ว");
					if( roleUser=='0008'|| roleUser=='0009'||roleUser=='0011'|| roleUser=='0012'|| roleUser=='0013' || roleUser=='0014'){
					$("#block_wait_work_subrole").css("display", "block");
					}
            	}
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
$(document).ready(function () {
	//checkLevel();
    init();
});

function init() {
    //initGenTblPlant();
	
	$('#assignHDnew').css('display', 'block');
	$('#assignHDsuccess').css('display', 'block');
	$('#assignHDedit').css('display', 'block');
	//getTaskList();
	sendRequest();
	checkLevel();
	if(userTypeSetText=='6'){
		$('#sendtotemp_block').show();
	}
	
}
function checkVisualTask(){
	//getDropdownUserType
}
function sendRequest(){
//	if(userTypeSetText=='6'){
	var idTable = ["newAssiWorkHDT","doneAssiWorkHDT","editAssiWorkHDT","tempAssiWorkHDT"];
	var idDataTable = ["newAssiWorkHD","doneAssiWorkHD","editAssiWorkHD","tempAssiWorkHD"];
	var workType = ["newWork","doneWork","editWork","tempWork"];	
//	}else{
//	var idTable = ["newAssiWorkHDT","doneAssiWorkHDT","editAssiWorkHDT"];
//	var idDataTable = ["newAssiWorkHD","doneAssiWorkHD","editAssiWorkHD"];
//	var workType = ["newWork","doneWork","editWork"];
//	}

	for(var i=0;i<idTable.length;i++){
		getTaskList(idTable[i],idDataTable[i],workType[i]);
		//console.log(idTable[i],idDataTable[i],workType[i]);
	}
	
	
}

function getTaskList(idTable,idDataTable,workType){
	var data = {};
	data["typeWork"] = workType;
	try{
		$('#'+idTable+'').DataTable().destroy();
		$('#'+idDataTable+'').html("");
		console.log(JSON.stringify(data));
        ShowWaiting();
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'getAssignWork',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(data) {
            	
            		
            		if(data.list.length=='0'){
            			//console.log(data.list.length);
            			//$('#assignHDnew').css('display', 'none');
            			//$('#assignHDsuccess').css('display', 'none');
            		}else{
            			var det = "";
     	                
     	                for (var i = 0; i < data.list.length; i++) {
     	                	det += '<tr  class="TBODY">';
     			            //det += '<td class="text-center" >' + (data.list[i].LTR_CODE == null ? "" : data.list[i].LTR_CODE) + '</td>';
							if((workType=='newWork'||workType=='tempWork')){	
							det += '<td class="text-center" ><input type="checkbox" class="check_totemp" value="'+data.list[i].LTR_CODE+'"/></td>';
							}
     	                	det += '<td class="text-center" ><a href="getAssignWorkDetail?'+data.list[i].LTR_CODE+'?'+workType+'">'+data.list[i].LTR_CODE +'</a></td>';
     	                	det += '<td class="text-center" >' + (data.list[i].LAB_CODE == null ? "" : data.list[i].LAB_CODE) + '</td>';
     	                	det += '<td class="text-center" >' + (data.list[i].PRODUCT_NAME == null ? "" : data.list[i].PRODUCT_NAME) + '</td>';
     			            det += '<td class="text-center" >' + (data.list[i].SAMPLE_TYPE_NAME == null ? "" : data.list[i].SAMPLE_TYPE_NAME) + '</td>';
     			            det += '<td class="text-center" >' + (data.list[i].SAMPLE_TYPEC_DESC == null ? "" : data.list[i].SAMPLE_TYPEC_DESC) + '</td>';
     			            det += '<td class="text-center" >' + ((data.list[i].SAMPLE_DATE != null &&data.list[i].SAMPLE_DATE != '')? data.list[i].SAMPLE_DATE : data.list[i].CREATE_DATE) + '</td>';
     			            det +='</tr>';
     	                		                
     	                }
     	                if (det == '') {
     	                    $('#'+idDataTable+'').html(det);
     	                    HideWaiting();
     	                } else {
     	                    $('#'+idDataTable+'').html(det);
     	                    HideWaiting();

     	                }


						
						if(workType=='newWork'&&userTypeSetText!='6'){
							table = $('#'+idTable+'').DataTable({
     	                    searching: true,
     	                    responsive: true,
     	                   "pageLength": 10,
							"columnDefs": [
							            {
							                "targets": [ 0 ],
							                "visible": false,
							                "searchable": false
							            }]
 						});
						}else{
							
						table = $('#'+idTable+'').DataTable({
     	                    searching: true,
     	                    responsive: true,
     	                   "pageLength": 10
							
     	                });
						}
						
     	                
//					if ('6'!=userTypeSetText) {
//					$('#ctemp').hide();
//					}
            		}           		
                    HideWaiting();
                //assiWorkHD
                    
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
function assigntotempfunc(){
	let data={};
	
	let ltrcode = [];
    $("input:checkbox:checked").each(function () {
        ltrcode.push($(this).val());
    });
    
    let ltrcodeArr = "";
    for(var i=0;i<ltrcode.length;i++){

    	ltrcodeArr += "'"+ltrcode[i]+"',"
    }
    ltrcodeArr = ltrcodeArr.substring(0,ltrcodeArr.length-1);
	console.log(ltrcodeArr);
	data["ltrNo"]=ltrcodeArr;
	        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:'/Lab/util-assignToTemp',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(response) {
				window.location='/Lab/home';
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });
}

function returnfromtempfunc(){
	let data={};
	
	let ltrcode = [];
    $("input:checkbox:checked").each(function () {
        ltrcode.push($(this).val());
    });
    
    let ltrcodeArr = "";
    for(var i=0;i<ltrcode.length;i++){

    	ltrcodeArr += "'"+ltrcode[i]+"',"
    }
    ltrcodeArr = ltrcodeArr.substring(0,ltrcodeArr.length-1);
	console.log(ltrcodeArr);
	data["ltrNo"]=ltrcodeArr;
	        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:'/Lab/util-returnFromTemp',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(response) {
				window.location='/Lab/home';
            },
            error : function(e) {
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }
        });
}
function initGenTblPlant() {
    var data = {};
    try{
        ShowWaiting();
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'getMyTaskList',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(response) {
                if(response.userType == "20" ) {
                    window.location="remindingTruckSample";
                } else if(response.userType == "NF" ) {
                    window.location="home?p=nf";
                }else {
                    newTaskSheet(response.newList);
                    submitTaskSheet(response.submitList);
                    completeTaskSheet(response.completeList);
                    waitAuditTaskSheet(response.waitAuditList);
                    waitApprovedTaskSheet(response.waitApprovedList);
                    reviseTaskSheet(response.reviseList);
                    $('#newTaskId').css('display', 'none');
                    $('#submitTaskId').css('display', 'none');
                    $('#completeTaskId').css('display', 'none');
                    $('#waitAuditTaskId').css('display', 'none');
                    $('#waitApprovedTaskId').css('display', 'none');
                    $('#reviseTaskId').css('display', 'none');
                    if(response.urole == 'ML'){
                        $('#completeTaskId').css('display', 'block');
                    }else if(response.urole == 'HL'){
                        $('#waitApprovedTaskId').css('display', 'block');
                        $('#completeTaskId').css('display', 'block');
                    }else if(response.urole == 'A4'){
                        $('#waitAuditTaskId').css('display', 'block');
                    }else{
                        $('#newTaskId').css('display', 'block');
                        $('#submitTaskId').css('display', 'block');
                        $('#completeTaskId').css('display', 'block');
                        $('#reviseTaskId').css('display', 'block');
                    }
                    HideWaiting();
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

function newTaskSheet(data) {
    $('#newTaskTbl tbody').remove();
    $('#newTaskTbl').dataTable({
        "searching" : false,
        "bSort" : true,
        "paging" : false,
        "bFilter" : false,
        "data" : data,
        "destroy": true,
        "info" : false,
        "aaSorting": [],
        "responsive": true,
        "dom": 'lrtip',
        "columns" : [
            { "data": null,"sortable": true,
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return '<a href="#" name="sendToAssign" style="color: #337ab7;">'+o.reqNo +'</a>';
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.plant;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.samp;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.prd;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.sampdate;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.exprdate;
                    }
            }
        ],
        "language": {
            "emptyTable": "-- ไม่พบข้อมูลที่ค้นหา --",
            "info": "แสดง _START_ ถึง _END_ จากทั้งหมด _TOTAL_ รายการ",
            "lengthMenu": "แสดง _MENU_ รายการ",
            "paginate" : {
                "first":      "หน้าแรก",
                "previous":   "ก่อนหน้า",
                "next":       "ถัดไป",
                "last":       "หน้าสุดท้าย"
            }
        },
        "columnDefs" : [{}]
        ,"initComplete" : function(row, data, index) {
            $('#newTaskTbl tbody').on('click', 'a[name=sendToAssign]', function() {
                var dataIdx = $(this).parent().parent()[0]._DT_RowIndex;
                var dataTable = $('#newTaskTbl').DataTable().data();
                var dataRow = dataTable[dataIdx];
                /*window.location='/Lab/assignmentTaskLastResult?labCodeNo='+dataRow.reqNo+'&plantId='+dataRow.plantId+'&assignFlag=null';*/
                window.location='/Lab/submitTask?labCodeNo='+dataRow.reqNo+'&plantId='+dataRow.plantId;
            });

        }
    });
}

function submitTaskSheet(data) {
    $('#submitTaskTbl tbody').remove();
    $('#submitTaskTbl').dataTable({
        "searching" : false,
        "bSort" : true,
        "paging" : false,
        "bFilter" : false,
        "data" : data,
        "destroy": true,
        "info" : false,
        "aaSorting": [],
        "responsive": true,
        "dom": 'lrtip',
        "columns" : [
            { "data": null,"sortable": true,
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return '<a href="#" name="sendToApproved" style="color: #337ab7;">'+o.reqNo +'</a>';
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.plant;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.samp;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.prd;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.sampdate;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.exprdate;
                    }
            }
        ],
        "language": {
            "emptyTable": "-- ไม่พบข้อมูลที่ค้นหา --",
            "info": "แสดง _START_ ถึง _END_ จากทั้งหมด _TOTAL_ รายการ",
            "lengthMenu": "แสดง _MENU_ รายการ",
            "paginate" : {
                "first":      "หน้าแรก",
                "previous":   "ก่อนหน้า",
                "next":       "ถัดไป",
                "last":       "หน้าสุดท้าย"
            }
        },
        "columnDefs" : [{}]
        ,"initComplete" : function(row, data, index) {
            $('#submitTaskTbl tbody').on('click', 'a[name=sendToApproved]', function() {
                var dataIdx = $(this).parent().parent()[0]._DT_RowIndex;
                var dataTable = $('#submitTaskTbl').DataTable().data();
                var dataRow = dataTable[dataIdx];
                window.location = '/Lab/submitTask?labCodeNo=' + dataRow.reqNo + '&plantId=' + dataRow.plantId;


                // if (dataRow.wfStatus == 'Waiting for Checker') {
                //     window.location = '/Lab/submitTask?labCodeNo=' + dataRow.reqNo + '&plantId=' + dataRow.plantId;
                // } else{
                //     window.location = '/Lab/approvTask?labCodeNo=' + dataRow.reqNo + '&plantId=' + dataRow.plantId;
                // }

            });
        }
    });
}

function completeTaskSheet(data) {
    $('#completeTaskTbl tbody').remove();
    $('#completeTaskTbl').dataTable({
        "searching" : false,
        "bSort" : true,
        "paging" : false,
        "bFilter" : false,
        "data" : data,
        "destroy": true,
        "info" : false,
        "aaSorting": [],
        "responsive": true,
        "dom": 'lrtip',
        "columns" : [
            { "data": null,"sortable": true,
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.reqNo;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.plant;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.samp;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.prd;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.sampdate;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.exprdate;
                    }
            }
        ],
        "language": {
            "emptyTable": "-- ไม่พบข้อมูลที่ค้นหา --",
            "info": "แสดง _START_ ถึง _END_ จากทั้งหมด _TOTAL_ รายการ",
            "lengthMenu": "แสดง _MENU_ รายการ",
            "paginate" : {
                "first":      "หน้าแรก",
                "previous":   "ก่อนหน้า",
                "next":       "ถัดไป",
                "last":       "หน้าสุดท้าย"
            }
        },
        "columnDefs" : [{}]
        ,"initComplete" : function(row, data, index) {
            $('#completeTaskTbl tbody').on('click', 'a[name=sendToApproved]', function() {
                var dataIdx = $(this).parent().parent()[0]._DT_RowIndex;
                var dataTable = $('#completeTaskTbl').DataTable().data();
                var dataRow = dataTable[dataIdx];
                window.location = '/Lab/completeTask?labCodeNo=' + dataRow.reqNo + '&plantId=' + dataRow.plantId;

            });

        }
    });
}


function waitAuditTaskSheet(data) {
    $('#waitAuditTaskTbl tbody').remove();
    $('#waitAuditTaskTbl').dataTable({
        "searching" : false,
        "bSort" : true,
        "paging" : false,
        "bFilter" : false,
        "data" : data,
        "destroy": true,
        "info" : false,
        "aaSorting": [],
        "responsive": true,
        "dom": 'lrtip',
        "columns" : [
            { "data": null,"sortable": true,
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return '<a href="#" name="sendToAudit" style="color: #337ab7;">'+o.reqNo +'</a>';
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.plant;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.samp;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.prd;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.sampdate;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.exprdate;
                    }
            }
        ],
        "language": {
            "emptyTable": "-- ไม่พบข้อมูลที่ค้นหา --",
            "info": "แสดง _START_ ถึง _END_ จากทั้งหมด _TOTAL_ รายการ",
            "lengthMenu": "แสดง _MENU_ รายการ",
            "paginate" : {
                "first":      "หน้าแรก",
                "previous":   "ก่อนหน้า",
                "next":       "ถัดไป",
                "last":       "หน้าสุดท้าย"
            }
        },
        "columnDefs" : [{}]
        ,"initComplete" : function(row, data, index) {
            $('#waitAuditTaskTbl tbody').on('click', 'a[name=sendToAudit]', function() {
                var dataIdx = $(this).parent().parent()[0]._DT_RowIndex;
                var dataTable = $('#waitAuditTaskTbl').DataTable().data();
                var dataRow = dataTable[dataIdx];
                window.location = '/Lab/waitAuditTask?labCodeNo=' + dataRow.reqNo + '&plantId=' + dataRow.plantId;

            });

        }
    });
}


function waitApprovedTaskSheet(data) {
    $('#waitApprovedTaskTbl tbody').remove();
    $('#waitApprovedTaskTbl').dataTable({
        "searching" : false,
        "bSort" : true,
        "paging" : false,
        "bFilter" : false,
        "data" : data,
        "destroy": true,
        "info" : false,
        "aaSorting": [],
        "responsive": true,
        "dom": 'lrtip',
        "columns" : [
            { "data": null,"sortable": true,
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.reqNo;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.plant;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.samp;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.prd;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.sampdate;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.exprdate;
                    }
            }
        ],
        "language": {
            "emptyTable": "-- ไม่พบข้อมูลที่ค้นหา --",
            "info": "แสดง _START_ ถึง _END_ จากทั้งหมด _TOTAL_ รายการ",
            "lengthMenu": "แสดง _MENU_ รายการ",
            "paginate" : {
                "first":      "หน้าแรก",
                "previous":   "ก่อนหน้า",
                "next":       "ถัดไป",
                "last":       "หน้าสุดท้าย"
            }
        },
        "columnDefs" : [{}]
        ,"initComplete" : function(row, data, index) {
            $('#waitApprovedTaskTbl tbody').on('click', 'a[name=sendToApproved]', function() {
                var dataIdx = $(this).parent().parent()[0]._DT_RowIndex;
                var dataTable = $('#waitApprovedTaskTbl').DataTable().data();
                var dataRow = dataTable[dataIdx];
                window.location = '/Lab/waitApprovedTask?labCodeNo=' + dataRow.reqNo + '&plantId=' + dataRow.plantId;
            });

        }
    });
}


function reviseTaskSheet(data) {
    $('#reviseTaskTbl tbody').remove();
    $('#reviseTaskTbl').dataTable({
        "searching" : false,
        "bSort" : true,
        "paging" : false,
        "bFilter" : false,
        "data" : data,
        "destroy": true,
        "info" : false,
        "aaSorting": [],
        "responsive": true,
        "dom": 'lrtip',
        "columns" : [
            { "data": null,"sortable": true,
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.reqNo;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.plant;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.samp;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.prd;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.sampdate;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        return o.exprdate;
                    }
            }
        ],
        "language": {
            "emptyTable": "-- ไม่พบข้อมูลที่ค้นหา --",
            "info": "แสดง _START_ ถึง _END_ จากทั้งหมด _TOTAL_ รายการ",
            "lengthMenu": "แสดง _MENU_ รายการ",
            "paginate" : {
                "first":      "หน้าแรก",
                "previous":   "ก่อนหน้า",
                "next":       "ถัดไป",
                "last":       "หน้าสุดท้าย"
            }
        },
        "columnDefs" : [{}]
        ,"initComplete" : function(row, data, index) {

            $('#reviseTaskTbl tbody').on('click', 'a[name=sendToApproved]', function() {
                var dataIdx = $(this).parent().parent()[0]._DT_RowIndex;
                var dataTable = $('#reviseTaskTbl').DataTable().data();
                var dataRow = dataTable[dataIdx];
                window.location = '/Lab/reviseTask?labCodeNo=' + dataRow.reqNo + '&plantId=' + dataRow.plantId;

            });
        }
    });
}