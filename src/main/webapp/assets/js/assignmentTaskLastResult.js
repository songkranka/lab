var basePath = '/Lab/api/';

$(document).ready(function () {
    $('.multiselect').multiselect({
        selectAllValue: 'all',
        includeSelectAllOption: true
    });

});


$('select[name="wgN"]').change(function(){
    alert($(this).val());
});

function assignJob() {

    var data = {
        param_product_code:$('#productCodeId').val(),
        param_sample_type_name:$('#sampleTypeNameId').val()
    };
    $.ajax({
        type: 'POST',
        contentType : "application/json",
        url:basePath+'getkeyforsample',
        data : JSON.stringify(data),
        dataType: 'json',
        success : function(response) {
            var wgmStr = "";
            $.each(response.data, function (index, value) {
                if($('#'+value).is(":checked")){
                    wgmStr = wgmStr+"|"+$('#'+value).val();
                }

            });
            var data = {
                workGroupMember : wgmStr,
                productCodeId : $('#productCodeId').val(),
                sampleTypeNameId : $('#sampleTypeNameId').val(),
                detailLength : $('#detailLength').val()
            };
            console.log(JSON.stringify(data));
            assignOneTask(data);
        },
        error : function(e) {
        }
    });
}

function assignOneTask(data) {
    $.ajax({
        type: 'POST',
        contentType : "application/json",
        url:basePath+'assignTaskByProductCode',
        data : JSON.stringify(data),
        dataType: 'json',
        success : function(response) {
            if(response.status="200"){
                showMsgSuccess(response.msg);
            }else {
                showMsgError(response.msg);
            }
        },
        error : function(e) {
        }
    });
}

function genTblPlant() {
    try{
        var productCodeId =  $('#productCodeId').val();
        var sampleTypeNameId =  $('#sampleTypeNameId').val();
        var data = {
            param_product_code: productCodeId,
            param_sample_type_name:sampleTypeNameId
        };
        ShowWaiting();
        $.ajax({
            type: 'POST',
            contentType : "application/json",
            url:basePath+'getitems',
            data : JSON.stringify(data),
            dataType: 'json',
            success : function(response) {
                renderSheet(response.result);
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

function gotoMain(){
    window.location="/Lab/randomOilForValidate";
}
