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
            url:basePath+'getItemByWfId',
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
            /*{"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        return o.workGroup;
                    }
            },*/
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
                                var strSelect = "<select class='form-control' id='" + id + "' style='width: 100%' name='visualName'><option value=''>เลือกกลุ่ม</option>";
                                $.each(o.visualDdl, function (index, value) {
                                    strSelect = strSelect + "<option value='" + value.code + "'>" + value.value + "</option>";
                                });
                                strSelect = strSelect + "</select>";
                                $('#'+id).val(o.spaceCode);
                                return strSelect;
                            } else if (o.analyzeCode == '0003') {
                                var id = 'id_' + o.analyzeCode + '_' + o.meterialCode + '_' + o.methodCode;
                                var strSelect = "<select class='form-control' id='" + id + "' style='width: 100%' name='colorName'><option value=''>เลือกกลุ่ม</option>";
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
            /* {"data" : null,"className" : "text-left text-nowrap",orderable : true, render :
                    function(o) {
                        if(o.space2Value!=''){
                            if(o.analyzeCode=='0016'){
                                var id = 'analiCode0016'+o.analyzeCode + '_' + o.meterialCode + '_' + o.methodCode;
                                var strSelect =  "<select class='form-control' id='"+id+"' style='width: 100%'><option value=''>เลือกกลุ่ม</option>";
                                $.each(o.visualDdl,function (index, value) {
                                    strSelect = strSelect+"<option value='"+value.code+"'>"+value.value+"</option>";
                                });
                                strSelect = strSelect+"</select>";
                                $('#'+id).val(o.space2Code);
                                return strSelect;
                            }else if(o.analyzeCode=='0003'){
                                var id = 'analiCode0003'+o.analyzeCode + '_' + o.meterialCode + '_' + o.methodCode;
                                var strSelect =  "<select class='form-control' id='"+id+"' style='width: 100%'><option value=''>เลือกกลุ่ม</option>";
                                $.each(o.colorDdl,function (index, value) {
                                    strSelect = strSelect+"<option value='"+value.code+"'>"+value.value+"</option>";
                                });
                                strSelect = strSelect+"</select>";
                                $('#'+id).val(o.space2Code);
                                return strSelect;
                            }else{
                                var id = 'id_' + o.analyzeCode + '_' + o.meterialCode + '_' + o.methodCode;
                                if(o.readOnly){
                                    return '<input type="text" width="80px;" id="'+id+'" readonly="readonly" disabled="disabled" placeholder="'+o.space2Value+'"/>';
                                }else{
                                    return '<input type="text" width="80px;" id="'+id+'" placeholder="'+o.space2Value+'"/>';
                                }
                            }
                        }else{
                            return '';
                        }
                    }
            }, */
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
        ,"initComplete" : function(row, data, index) {
            $('#tblForSubmitTask tbody').on('change', 'select[name=visualName]', function() {
                var dataIdx = $(this).parent().parent()[0]._DT_RowIndex;
                var dataTable = $('#tblForSubmitTask').DataTable().data();
                var dataRow = dataTable[dataIdx];
                var idDdl = '#id_' + dataRow.analyzeCode + '_' + dataRow.meterialCode + '_' + dataRow.methodCode;
                var id = '#descId_' + dataRow.analyzeCode + '_' + dataRow.meterialCode + '_' + dataRow.methodCode;
                if($(idDdl).val() == '9999'){
                    $(id).prop('readonly',false);
                    $(id).prop('disabled',false);
                }else{
                    $(id).prop('readonly',true);
                    $(id).prop('disabled',true);
                }
            });


            $('#tblForSubmitTask tbody').on('change', 'select[name=colorName]', function() {
                var dataIdx = $(this).parent().parent()[0]._DT_RowIndex;
                var dataTable = $('#tblForSubmitTask').DataTable().data();
                var dataRow = dataTable[dataIdx];
                var idDdl = '#id_' + dataRow.analyzeCode + '_' + dataRow.meterialCode + '_' + dataRow.methodCode;
                var id = '#descId_' + dataRow.analyzeCode + '_' + dataRow.meterialCode + '_' + dataRow.methodCode;
                if($(idDdl).val() == '9999'){
                    $(id).prop('readonly',false);
                    $(id).prop('disabled',false);
                }else{
                    $(id).prop('readonly',true);
                    $(id).prop('disabled',true);
                }
            });

        }
    });
}

function submitJob() {
    var tblTask = $('#tblForSubmitTask').DataTable().rows().data();
    var dataTbl = [];
    $.each(tblTask,function (index, value) {
        var id = '#id_' + value.analyzeCode + '_' + value.meterialCode + '_' + value.methodCode;
        var descId = '#descId_' + value.analyzeCode + '_' + value.meterialCode + '_' + value.methodCode;
        dataTbl.push({
            analyzeCode:  value.analyzeCode,
            meterialCode: value.meterialCode,
            workGroup:  value.workGroup,
            methodCode:  value.methodCode,
            spaceValueOld: value.spaceCode,
            spaceValue: $(id).val(),
            space2Value: value.space2Code,
            spaceValueDesc: $(descId).val(),
            readOnly: value.readOnly
        });
    });
    var data = {
        data_table: dataTbl,
        labCode : $('#wfId').val()
    };
    $.ajax({
        type: 'POST',
        contentType : "application/json",
        url:basePath+'saveDataOfTask',
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
