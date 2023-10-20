var basePath = '/Lab/api/';

$(document).ready(function () {
    init();
});
function init() {
    genTblPlant();
}

function genTblPlant() {
    try{
        var wfId =  $('#wfId').val();
        var data = {
            param_wf_id: wfId
        };
        ShowWaiting();
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'getLtrByWfId',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(response) {
                renderItemSheet(response.result);
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


function renderItemSheet(data) {
    $('#tblForSubmitTask tbody').remove();
    $('#tblForSubmitTask').dataTable({
        "searching" : false,
        "bSort" : false,
        "paging" : false,
        "bFilter" : false,
        "data" : data,
        "destroy": true,
        "info" : false,
        "aaSorting": [],
        "responsive": false,
        "dom": 'lrtip',
        "columns" : [
            { "data": null,"sortable": true,
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.empName;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.analyzeCode+' '+o.analyzeValue;

                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.meterialCode+' '+o.meterialValue;

                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.methodCode+' '+o.methodValue;
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        if(o.space1Code!='') {
                            if (o.analyzeCode == '0016') {
                                var id = 'id_' + o.analyzeCode + '_' + o.meterialCode + '_' + o.methodCode;
                                var strSelect = "<select class='form-control' id='" + id + "' style='width: 100%' name='visualName' readonly='readonly' disabled='disabled'><option value=''>เลือกกลุ่ม</option>";
                                $.each(o.visualDdl, function (index, value) {
                                    strSelect = strSelect + "<option value='" + value.code + "'>" + value.value + "</option>";
                                });
                                strSelect = strSelect + "</select>";
                                $('#'+id).val(o.spaceCode);
                                return strSelect;
                            } else if (o.analyzeCode == '0003') {
                                var id = 'id_' + o.analyzeCode + '_' + o.meterialCode + '_' + o.methodCode;
                                var strSelect = "<select class='form-control' id='" + id + "' style='width: 100%' name='colorName' readonly='readonly' disabled='disabled'><option value=''>เลือกกลุ่ม</option>";
                                $.each(o.colorDdl, function (index, value) {
                                    strSelect = strSelect + "<option value='" + value.code + "'>" + value.value + "</option>";
                                });
                                strSelect = strSelect + "</select>";
                                $('#'+id).val(o.spaceCode);
                                return strSelect;
                            } else {
                                var id = 'id_' + o.analyzeCode + '_' + o.meterialCode + '_' + o.methodCode;
                                if (o.readOnly) {
                                    return '<input type="text" width="80px;" id="' + id + '" readonly="readonly" disabled="disabled" placeholder="' + o.spaceValue + '"/>';
                                } else {
                                    return '<input type="text" width="80px;" id="' + id + '" placeholder="' + o.spaceValue + '"/>';
                                }
                            }
                        }else{
                            return '';
                        }
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : false, render :
                    function(o) {
                        var id = 'descId_' + o.analyzeCode + '_' + o.meterialCode + '_' + o.methodCode;
                        if(o.readOnly) {
                            return '<input type="text" width="130px;" id="' + id + '" value="' +o.spaceValueDesc + '" readonly="readonly" disabled="disabled"/>';
                        }else{
                            if(o.spaceCode =='9999'){
                                return '<input type="text" width="130px;" id="' + id + '" value="' +o.spaceValueDesc + '"/>';
                            }else{
                                return '<input type="text" width="130px;" id="' + id + '" value="' +o.spaceValueDesc + '" readonly="readonly" disabled="disabled"/>';
                            }
                        }
                    }
            },
            {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.unitValue;
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
        ,"initComplete" : function(row, data, index) {}
    });
}

function sendReviseTask() {
    var data = {
        labCode : $('#wfId').val(),
        comment : $('#commentTxt').val()
    };
    $.ajax({
        type: 'POST',
        contentType : "application/json",
        url:basePath+'saveSendReviseTask',
        data : JSON.stringify(data),
        dataType: 'json',
        success : function(response) {
            if(response.result == '200'){
                showMsgSuccess('บันทึกสำเร็จ');
                HideWaiting();
                gotoMain();
            }else{
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }

        },
        error : function(e) {
            showMsgError('เกิดข้อผิดพลาด');
            HideWaiting();
        }
    });
}



function sendApproveTask() {
    var data = {
        labCode : $('#wfId').val(),
        comment : $('#commentTxt').val()
    };
    $.ajax({
        type: 'POST',
        contentType : "application/json",
        url:basePath+'saveSendApproveTask',
        data : JSON.stringify(data),
        dataType: 'json',
        success : function(response) {
            if(response.result == '200'){
                showMsgSuccess('บันทึกสำเร็จ');
                HideWaiting();
                gotoMain();
            }else{
                showMsgError('เกิดข้อผิดพลาด');
                HideWaiting();
            }

        },
        error : function(e) {
            showMsgError('เกิดข้อผิดพลาด');
            HideWaiting();
        }
    });
}


function gotoMain(){
    window.location="/Lab/home";
}
