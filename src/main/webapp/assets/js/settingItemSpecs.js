var basePath = '/Lab/';
var dataExTemplate ;
var arr = [];
var arrItemName = [];
var dataItemSpec;
var dataMethodMaster;
var dataToolsMaster;
var dataGroup;
var arrMethodGlobal =  []
var dataLength;
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
  
    SetDropDownSampleType();
    SetDropDownProduct();
    ajaxGetItemSpec();
    ajaxGetMethodMaster()
    ajaxGetToolsMaster()
    ajaxGetGroup()


});

function checkAll(id){
	var chk = '.'+id.id
	var chkHead ='.'+$(id).attr('class')
	var booleanchk = $(chkHead).is(":checked")
	if(booleanchk==true){
		  $(chk).each(function(){
	            this.checked = true;
        });
	}else if(booleanchk==false){
		 $(chk).each(function(){
	            this.checked = false;
        });
	}
}
function checkDetail(id){
	var chkHead ='.'+$(id).attr('class')
	var chk = '.chkHead'+$(id).attr('class')
	var booleanchk = true;
		  $(chkHead).each(function(){
			  if(this.checked){
				  
			  }else{
				  booleanchk = false;
			  }
//	            this.checked = true;
        });
	if(!booleanchk){
		// console.log(chk);
		$(chk).prop('checked',false)
	}else{
		// console.log(chk);
		$(chk).prop('checked',true)
	}
}

function SetDropDownProduct() {
    $('#ddlProduct').val("");
    try {
        $('#ddlProduct').html("");
        jQuery.ajax({
            url: 'util-getDropdownProduct',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            //  async: false,
            cache: false,
            success: function(data) {
                $.each(data, function(i, item) {
                    $('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">' + item.PRODUCT_NAME + '</option>');
                });
                $('#ddlProduct').select2({
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
function SetDropDownSampleType() {
    $('#ddlSampleType').val("");
    try {
        $('#ddlSampleType').html("");
        dataExTemplate =   jQuery.ajax({
            url: 'util-getDropdownSampleType',
            type: "Post",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
//            	 $('#nonSampleType').append('<option value="ALL" selected="selected">&nbsp;&nbsp;ทั้งหมด</option>');
                $.each(data, function(i, item) {
                    
                 $('#ddlSampleType').append('<option value="' + item.SAMPLE_TYPE_CODE + '" >&nbsp;&nbsp;' + item.SAMPLE_TYPE_NAME + '</option>');
                  arr.push(item.SAMPLE_TYPE_CODE+'#'+item.SAMPLE_TYPE_NAME);
                });
                $('#ddlSampleType').select2({
                    dropdownAutoWidth: true,
                    width: 'auto'
                });
                
            },
            error: function() {
                showMsgError('ข้อมูลผิดพลาด');
            }
        });
    } catch (ex) {
        showMsgError(ex);
    }
}


function renderItemSpec(){
    var lengthRender = parseInt($('#totalId').val());
    var $body = $('#bodyTemplate')
    var pdn = document.getElementById("ddlProduct");
    var productName = pdn.options[pdn.selectedIndex].text;
    var spn = document.getElementById("ddlSampleType");
    var sampleTypeName = spn.options[spn.selectedIndex].text;
    dataLength = lengthRender;
    $body.empty();
    var sequent =1;
    var idTable =1;
    var detailMethod;
    var detailTools;
    var detailGroup ;
    var idTbMethodStr = 'tbodyMethodId';
    var idTbToolsStr = 'tbodyToolsId';
    var idTbGroupStr = 'tbodyGroupId';



    for(var i = 0 ;i < lengthRender ; i++){
        detailMethod = appendTbodyMethod(sequent);
        detailTools = appendTbodyTools(sequent);
        detailGroup = appendTbodyGroup(sequent);
        $body.append('<div class="row">'+
            '<div class="col-lg-12">'+
            '<div class="ibox float-e-margins">'+
            '<div class="ibox-title">'+
            '<h5>ผลิตภัณฑ์ : '+productName+' ประเภทตัวอย่าง : '+sampleTypeName+' No. '+sequent+'</h5>'+
            '<div class="ibox-tools">'+
            '<a class="collapse-link"> <i class="fa fa-chevron-up"></i></a>'+
            '</div>'+
            '<div class="ibox-content">'+
            '<div class="row" id="specTabId'+sequent+'">'+
                '<div class="col-xs-12" >'+
                    '<form>'+
                         '<div class="form-group">'+
                             '<div class="col-sm-4">'+
                                 '<label>Item Name</label><br/>'+
                                 '<select onchange="addUnit('+i+')" id="itemNameId'+sequent+'"></select>'+
                             '</div>'+
                             '<div class="col-sm-3">'+
                                '<label>Unit</label><br/>'+
                                '<input type="text" class="custom-text-horizon-rangdate2" style="text-align: right" maxlength="10" id="unitInput'+sequent+'">\n'+
                             '</div>'+
                        '</div>'+
                    '</form>'+
                ' </div>'+

            '<div class="col-xs-12">'+
                '<form>'+
                    '<div class="form-group">'+
                        '<div class="col-sm-3">'+
                            '<label>Spec Range</label><br/>'+
                            '<select id="specRangeId'+sequent+'">'+
                                '<option value="Y">Y</option>'+
                                '<option value="N">N</option>'+
                            '</select>'+
                        '</div>'+

                    '</div>'+
                '</form>'+
            '</div>'+
        '<div class="col-xs-12">'+
            '<form>'+
                '<div class="form-group">'+
                    '<div class="col-sm-3">'+
                        '<label>Min</label><br/>'+
                         '<input type="text" class="custom-text-horizon-rangdate2" style="text-align: right" maxlength="6" id="inputMin'+sequent+'">\n'+
                    '</div>'+
                    '<div class="col-sm-3">'+
                        '<label>Max</label><br/>'+
                    '<input type="text" class="custom-text-horizon-rangdate2" style="text-align: right" maxlength="6" id="inputMax'+sequent+'">\n'+

            '</div>'+
                '</div>'+
            '</form>'+
        '</div>'+

        '<div class="col-xs-12">'+
        '<form>'+
        '<div class="form-group">'+
        '<div class="col-sm-3">'+
        '<label>Text</label><br/>'+
            '<input type="text" class="custom-text-horizon-rangdate2" style="text-align: right" maxlength="6" id="inputText'+sequent+'">\n'+

            '</div>'+
        '<div class="col-sm-3">'+
        '<label>Input Type</label><br/>'+
            '<input type="text" class="custom-text-horizon-rangdate2" style="text-align: right" maxlength="6" id="inputType'+sequent+'">\n'+

            '</div>'+
        '</div>'+
        '</form>'+
        '</div>'+
                '<div class="col-xs-12" >'+
                    '<form>'+
                        '<div class="form-group">'+
                            '<div class="col-sm-6" style="padding-left: 0px;">'+
                                '<div class="col-sm-3" style="padding-right: 0px;width: 65px;" align="left">'+
                                     '<label>Method</label><br/>'+
                                '</div>'+
                                '<div class="col-sm-3" style="padding-left: 0px;">'+
                                    '<button type="button" class="btn btn-danger" onclick="showModalMethod('+i+')" style="padding-left: 5px;padding-right: 5px;padding-bottom: 0px;padding-top: 0px;">'+
                                    'เพิ่ม &nbsp;<i class="fa fa-plus-circle"></i>'+
                                    '</button>'+
                                '</div>'+
                    '</div>'+
                    '</form>'+
                ' </div>'+
                ' </div>'+

            '<div class="col-xs-6 " >'+

            '<div class="form-group">'+
            '<div class="col-sm-3" style="padding-right: 0px;width: 65px;" align="left" id="dataSelectMethodID'+sequent+'">'+
            '</div>'+

            ' </div>'+
            ' </div>'+



            '<div class="col-xs-12" >'+
            '<form>'+
                '<div class="form-group">'+
                '<div class="col-sm-6" style="padding-left: 0px;">'+
                    '<div class="col-sm-3" style="padding-right: 0px;width: 65px;" align="left">'+
                    '<label>Tools</label><br/>'+
                    '</div>'+
                    '<div class="col-sm-3" style="padding-left: 0px;">'+
                    '<button type="button" class="btn btn-danger" onclick="showModalTools('+i+')" style="padding-left: 5px;padding-right: 5px;padding-bottom: 0px;padding-top: 0px;">'+
                    'เพิ่ม &nbsp;<i class="fa fa-plus-circle"></i>'+
                    '</button>'+
                    '</div>'+
                '</div>'+
                '</div>'+
            '</form>'+
            ' </div>'+
            '<div class="col-xs-6 " >'+
            '<form>'+
            '<div class="form-group">'+
            '<div class="col-sm-3" style="padding-right: 0px;width: 65px;" align="left" id="dataSelectToolsID'+sequent+'">'+
            '</div>'+
            '</form>'+
            ' </div>'+
            ' </div>'+



            '<div class="col-xs-12" >'+
            '<form>'+
                '<div class="form-group">'+
                    '<div class="col-sm-6" style="padding-left: 0px;">'+
                    '<div class="col-sm-3" style="padding-right: 0px;width: 65px;" align="left">'+
                          '<label>Group</label><br/>'+
                    '</div>'+
                    '<div class="col-sm-3" style="padding-left: 0px;">'+
                         '<button type="button" class="btn btn-danger" onclick="showModalGroup('+i+')"  style="padding-left: 5px;padding-right: 5px;padding-bottom: 0px;padding-top: 0px;">'+
                    'เพิ่ม &nbsp;<i class="fa fa-plus-circle"></i>'+
                    '</button>'+
                    '</div>'+
                    '</div>'+
                '</div>'+
            '</form>'+
            ' </div>'+
            '<div class="col-xs-6 " >'+
            '<form>'+
            '<div class="form-group">'+
            '<div class="col-sm-3" style="padding-right: 0px;width: 65px;" align="left" id="dataSelectGroupID'+sequent+'">'+
            '</div>'+
            '</form>'+
            ' </div>'+
            ' </div>'+


            ' </div>'+
            ' </div>'+
            '</div>'+
            '</div>'+

            //modal Method
            '<div class="modal" tabindex="-1" id="modalMethod'+sequent+'" >'+
            '<div class="modal-dialog">'+
            '<div class="modal-content">'+
            '<div class="modal-header">'+
            '<h3 class="modal-title">Method</h3>'+
            '</div>'+
            '<div class="modal-body">'+
            '<div class="table-responsive"   >'+
            '<table class="table table-striped table-bordered" style="width:100%;">'+
            '<thead  class="tbHeader" id="theadMethodId'+sequent+'">'+
            '<tr>'+
            '<th class="text-center">Method Id</th>'+
            '<th class="text-center">Method Name</th>'+
            '<th class="text-center">Active / Inactive <input type="checkbox" onclick="checkAllMethod('+sequent+',this)" class="center" name="methodChkAll"/></th>'+
            '<th class="text-center">Default</th>'+
            '</tr>'+
            '</thead>'+
            '<tbody id="tbodyMethodId'+sequent+'">'+
              detailMethod+
            '</tbody>'+
            '</table>'+
            '</div>'+
            '</div>'+
            ' <div class="modal-footer">'+
            '<button type="button" class="btn btn-danger" data-dismiss="modal">ปิด</button>'+
            '<button type="button" class="btn btn-success" onclick="selectedItemsMethod('+sequent+')" >เลือก</button>'+
            '</div>'+
            '</div>'+
            '</div>'+
            '</div>'+
//modal tools
        '<div class="modal" tabindex="-1" id="modalTools'+sequent+'" >'+
        '<div class="modal-dialog">'+
        '<div class="modal-content">'+
        '<div class="modal-header">'+
        '<h3 class="modal-title">Tools</h3>'+
        '</div>'+
        '<div class="modal-body">'+
        '<div class="table-responsive"   >'+
        '<table class="table table-striped table-bordered" style="width:100%;">'+
        '<thead  class="tbHeader" id="theadToolsId'+sequent+'">'+

        '<tr>'+
        '<th class="text-center">Method Id</th>'+
        '<th class="text-center">Method Name</th>'+
        '<th class="text-center">Active / Inactive  <input type="checkbox" onclick="checkAllTools('+sequent+',this)" class="center" name="toolChkAll"/></th>'+
        '<th class="text-center">Default</th>'+
        '</tr>'+
        '</thead>'+
        '<tbody id="tbodyToolsId'+sequent+'">'+
            detailTools+
        '</tbody>'+
        '</table>'+
        '</div>'+
        '</div>'+
        ' <div class="modal-footer">'+
            '<button type="button" class="btn btn-danger" data-dismiss="modal">ปิด</button>'+
            '<button type="button" class="btn btn-success" onclick="selectedItemsTools('+sequent+')">เลือก</button>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '</div>'+
            //modal Group
        '<div class="modal" tabindex="-1" id="modalGroup'+sequent+'" >'+
        '<div class="modal-dialog">'+
        '<div class="modal-content">'+
        '<div class="modal-header">'+
        '<h3 class="modal-title">Group</h3>'+
        '</div>'+
        '<div class="modal-body">'+
        '<div class="table-responsive"   >'+
        '<table class="table table-striped table-bordered" style="width:100%;">'+
        '<thead  class="tbHeader" id="theadGroupId'+sequent+'">'+
        '<tr>'+
        '<th class="text-center">Method Id</th>'+
        '<th class="text-center">Method Name</th>'+
        '<th class="text-center">Active / Inactive <input type="checkbox" onclick="checkAllGroup('+sequent+',this)" class="center" name="groupChkAll"/></th>'+
        '<th class="text-center">Default</th>'+
        '</tr>'+
        '</thead>'+
        '<tbody id="tbodyGroupId'+sequent+'">'+
            detailGroup+
        '</tbody>'+
        '</table>'+
        '</div>'+
        '</div>'+
        ' <div class="modal-footer">'+
            '<button type="button" class="btn btn-danger" data-dismiss="modal">ปิด</button>'+
            '<button type="button" class="btn btn-success" onclick="selectedItemsGroup('+sequent+')" >เลือก</button>'+
        '</div>'+
        '</div>'+
        '</div>'+
        '</div>'
        );
        setSelectItemName('itemNameId'+sequent)
        sequent++;
    }
}

function ajaxGetItemSpec() {
    try {
        jQuery.ajax({
            url: 'getItemName',
            type: "POST",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                dataItemSpec = data
            },
            error: function() {
                showMsgError('ข้อมูลผิดพลาด');
            }
        });
    } catch (ex) {
        showMsgError(ex);
    }
}

function setSelectItemName(id) {
    // alert(id);
    var idTab = '#'+id;
    var idUnitInput = '#unitInput'+id
    $(idTab).html("");
    $.each(dataItemSpec, function(i, item) {
        // console.log(dataItemSpec[0])
        $(idTab).append('<option foo="'+item.ITEM_UNIT+'" value="' + item.ITEM_ID + '" >&nbsp;&nbsp;' + item.ITEM_NAME + '</option>');
        $(idUnitInput).val(dataItemSpec[0].ITEM_UNIT)
        arrItemName.push(item.ITEM_ID+'#'+item.ITEM_NAME);
    });
    $(idTab).select2({
        dropdownAutoWidth: true,
        width: 'auto'
    });
}

function addUnit(id){
    var a = id+1;
    var idUnit = '#unitInput'+a;
    var idSelectItem = 'itemNameId'+a;
    var e = document.getElementById(idSelectItem+'');
    var unit = e.options[e.selectedIndex];
    // console.log($(idUnit))
    // console.log($(unit).attr('foo'))
    $(idUnit).val('');
    $(idUnit).val($(unit).attr('foo') =='null' ? "" : $(unit).attr('foo'));
}

function ajaxGetMethodMaster() {
    try {
        jQuery.ajax({
            url: 'getMethodMaster',
            type: "POST",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                dataMethodMaster = data
            },
            error: function() {
                showMsgError('ข้อมูลผิดพลาด');
            }
        });
    } catch (ex) {
        showMsgError(ex);
    }
}

function ajaxGetToolsMaster() {
    try {
        jQuery.ajax({
            url: 'getToolsMaster',
            type: "POST",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                dataToolsMaster = data
            },
            error: function() {
                showMsgError('ข้อมูลผิดพลาด');
            }
        });
    } catch (ex) {
        showMsgError(ex);
    }
}

function ajaxGetGroup() {
    try {
        jQuery.ajax({
            url: 'getGroup',
            type: "POST",
            contentType: "application/json",
            dataType: 'json',
            async: false,
            cache: false,
            success: function(data) {
                dataGroup = data
            },
            error: function() {
                showMsgError('ข้อมูลผิดพลาด');
            }
        });
    } catch (ex) {
        showMsgError(ex);
    }
}


function  showModalMethod(id){
    var a = id+1;
    var idModal = '#modalMethod'+a;
    $(idModal).modal('show')
}
function  showModalTools(id){
    var a = id+1;
    var idModal = '#modalTools'+a;
    $(idModal).modal('show')
}
function  showModalGroup(id){
    var a = id+1;
    var idModal = '#modalGroup'+a;
    $(idModal).modal('show')
}


function appendTbodyMethod(id){
    var ret = ''
    $.each(dataMethodMaster,function (index,value){
        ret+='<tr>' +
             '<td>'+value.METHOD_ID+'</td>'+
             '<td>'+value.METHOD_NAME+'</td>'+
             '<td align="center"><input type="checkbox" onclick="checkDetailMethod('+id+')" class="center" name="methodChk"/></td>'+
             '<td align="center"><input type="radio" onclick="" class="center" name="methodRadio"/></td>'+
             '</tr>'
    })

    return ret;
}
function appendTbodyTools(id){
    var ret = ''
    $.each(dataToolsMaster,function (index,value){
        ret+='<tr>' +
            '<td>'+value.TOOL_ID+'</td>'+
            '<td>'+value.TOOL_NAME+'</td>'+
            '<td align="center"><input type="checkbox" onclick="checkDetailTools('+id+')" class="center" name="toolChk"/></td>'+
            '<td align="center"><input type="radio" onclick="" class="center" name="toolRadio"/></td>'+
            '</tr>'
    })
    return ret;
}
function appendTbodyGroup(id){
    var ret = ''
    $.each(dataGroup,function (index,value){
        ret+='<tr>' +
            '<td>'+value.USER_TYPE_ID+'</td>'+
            '<td>'+value.USER_TYPE_DTL+'</td>'+
            '<td align="center"><input type="checkbox" onclick="checkDetailGroup('+id+')"class="center" name="groupChk"/></td>'+
            '<td align="center"><input type="radio" onclick="" class="center" name="groupRadio"/></td>'+
            '</tr>'
    })
    return ret;
}


function checkAllMethod(data,head){
    var checkAll = $(head).is(':checked')
    var checkDetail = $('#tbodyMethodId'+data+' tr').find('td:eq(2) input');
    var arr ="";
    var arrListIdMethod = []
    var arrListNameMethod = []
    var defaultMethod ;
    if(checkAll==true){
        $(checkDetail).each(function(){
            this.checked = true;
        });
    }else if(checkAll==false){

        $(checkDetail).each(function(){
            this.checked = false;
        });
    }

}



function checkAllTools(data,head){
    var checkAll = $(head).is(':checked')
    var checkDetail = $('#tbodyToolsId'+data+' tr').find('td:eq(2) input');
    var arr ="";
    var arrListIdMethod = []
    var arrListNameMethod = []
    var defaultMethod ;
    if(checkAll==true){
        $(checkDetail).each(function(){
            this.checked = true;
        });
    }else if(checkAll==false){

        $(checkDetail).each(function(){
            this.checked = false;
        });
    }
}

function checkAllGroup(data,head){
    var checkAll = $(head).is(':checked')
    var checkDetail = $('#tbodyGroupId'+data+' tr').find('td:eq(2) input');
    var arr ="";
    var arrListIdMethod = []
    var arrListNameMethod = []
    var defaultMethod ;
    if(checkAll==true){
        $(checkDetail).each(function(){
            this.checked = true;
        });
    }else if(checkAll==false){

        $(checkDetail).each(function(){
            this.checked = false;
        });
    }
}

function checkDetailMethod(id){
    var chkHead =$('#theadMethodId'+id+' tr').find('th:eq(2) [name=methodChkAll]')
    var checkDetail = $('#tbodyMethodId'+id+' tr').find('td:eq(2) input');
    var booleanchk = true;
    $(checkDetail).each(function(){
        this.checked ? booleanchk : booleanchk = false;
    });
    !booleanchk ?  $(chkHead).prop('checked',false) :  $(chkHead).prop('checked',true)
}
function checkDetailTools(id){
    var chkHead =$('#theadToolsId'+id+' tr').find('th:eq(2) [name=toolChkAll]')
    var checkDetail = $('#tbodyToolsId'+id+' tr').find('td:eq(2) input');
    var booleanchk = true;
    $(checkDetail).each(function(){
        this.checked ? booleanchk : booleanchk = false;
    });
    !booleanchk ?  $(chkHead).prop('checked',false) :  $(chkHead).prop('checked',true)
}

function checkDetailGroup(id){
    var chkHead =$('#theadGroupId'+id+' tr').find('th:eq(2) [name=groupChkAll]')
    var checkDetail = $('#tbodyGroupId'+id+' tr').find('td:eq(2) input');
    var booleanchk = true;
    $(checkDetail).each(function(){
        this.checked ? booleanchk : booleanchk = false;
    });
    !booleanchk ?  $(chkHead).prop('checked',false) :  $(chkHead).prop('checked',true)

}


function selectedItemsMethod(id){
    $('#modalMethod'+id).modal('hide')
    var $tbody = $('#tbodyMethodId'+id).find('tr')
    var $dataSelectMethodID = $('#dataSelectMethodID'+id);
    $dataSelectMethodID.empty();
    // $.each($tbody,function (index,items){
    //     console.log(items);
    // })
    var arrListIdMethod = []
    var arrNameMethod = {}
    var arrNameMethodLise = []
    var defaultMethod ;
    $.each($tbody,function(index,items){
        if($(this).find('td:eq(2) input')[0].checked){
        arrListIdMethod.push($(this).find('td:eq(0)').text())
        // arrListNameMethod.push($(this).find('td:eq(1)').text())
            arrNameMethod[$(this).find('td:eq(0)').text()] = $(this).find('td:eq(1)').text();
            arrMethodGlobal.push($(this).find('td:eq(0)').text())
        }
        if($(this).find('td:eq(3) input')[0].checked){
            defaultMethod = $(this).find('td:eq(0)').text()
        }
    })
    var firstNo = 0;
    var sequent =1;

    $.each(arrNameMethod,function (key,value){
        if(key == defaultMethod){
            $dataSelectMethodID.append('<form  id="labelMethod_'+parseInt(key)+'">' +
                '<div class="form-group" >'+
                '<div class="col-sm-3" style="width: 150px;">' +
                '<lable style="color: red;" id="methodLabel_'+id+'_'+sequent+'" foo="Y" value="'+key+'">'+value+'</lable></span>'+
                '</div>'+
                '<div class="col-sm-2" style="bottom: 20px;left: 200px;">' +
                '<button class="btn btn-danger" type="button" onclick="unSelectedMethod('+parseInt(key)+')" style="padding: 2px;"><span class="fa fa-trash"></button>'+
                '</div>'+
                '</div>'+
                '</div>'
            );
        }else{
            $dataSelectMethodID.append('<form  id="labelMethod_'+parseInt(key)+'">' +
                '<div class="form-group" >'+
                '<div class="col-sm-3" style="width: 150px;">' +
                '<lable style="color: red;" id="methodLabel_'+id+'_'+sequent+'" foo="N" value="'+key+'">'+value+'</lable></span>'+
                '</div>'+
                '<div class="col-sm-2" style="bottom: 20px;left: 200px;">' +
                '<button class="btn btn-danger" type="button" onclick="unSelectedMethod('+parseInt(key)+')" style="padding: 2px;"><span class="fa fa-trash"></button>'+
                '</div>'+
                '</div>'+
                '</div>'
            );
        }

        sequent++
    })
    console.log(arrListIdMethod)
    console.log(defaultMethod)

}
function selectedItemsTools(id){
    $('#modalTools'+id).modal('hide')
    var $tbody = $('#tbodyToolsId'+id).find('tr')
    var $dataSelectToolsID = $('#dataSelectToolsID'+id);
    $dataSelectToolsID.empty();
    var arrListIdTools = []
    var arrNameTools = {}
    var defaultTools ;

    $.each($tbody,function(index,items){
        if($(this).find('td:eq(2) input')[0].checked){
            arrListIdTools.push($(this).find('td:eq(0)').text())
            // arrListNameMethod.push($(this).find('td:eq(1)').text())
            arrNameTools[$(this).find('td:eq(0)').text()] = $(this).find('td:eq(1)').text();
        }
        if($(this).find('td:eq(3) input')[0].checked){
            defaultTools = $(this).find('td:eq(0)').text()
        }
    })
    var sequent =1;
    $.each(arrNameTools,function (key,value){
        if(key==defaultTools){
            $dataSelectToolsID.append('<form id="labelTools_'+parseInt(key)+'">' +
                '<div class="form-group" >'+
                '<div class="col-sm-3" style="width: 150px;">' +
                '<lable style="color: red;" id="toolsLabel_'+id+'_'+sequent+'" foo="Y" value="'+key+'">'+value+'</lable></span>'+
                '</div>'+
                '<div class="col-sm-2" style="bottom: 20px;left: 200px;">' +
                '<button class="btn btn-danger"  type="button" onclick="unSelectedTools('+parseInt(key)+')" style="padding: 2px;"><span class="fa fa-trash"></button>'+
                '</div>'+
                '</div>'+
                '</div>'
            );
        }else{
            $dataSelectToolsID.append('<form id="labelTools_'+parseInt(key)+'">' +
                '<div class="form-group" >'+
                '<div class="col-sm-3" style="width: 150px;">' +
                '<lable style="color: red;" id="toolsLabel_'+id+'_'+sequent+'" foo="N" value="'+key+'">'+value+'</lable></span>'+
                '</div>'+
                '<div class="col-sm-2" style="bottom: 20px;left: 200px;">' +
                '<button class="btn btn-danger"  type="button" onclick="unSelectedTools('+parseInt(key)+')" style="padding: 2px;"><span class="fa fa-trash"></button>'+
                '</div>'+
                '</div>'+
                '</div>'
            );
        }

        sequent++;

    })
}
function selectedItemsGroup(id){
    $('#modalGroup'+id).modal('hide')
    var $tbody = $('#tbodyGroupId'+id).find('tr')
    var $dataSelectGroupID = $('#dataSelectGroupID'+id);
    $dataSelectGroupID.empty();

    var arrNameGroup = {}
    var defaultGroup ;

    $.each($tbody,function(index,items){
        if($(this).find('td:eq(2) input')[0].checked){
            arrNameGroup[$(this).find('td:eq(0)').text()] = $(this).find('td:eq(1)').text();
        }
        if($(this).find('td:eq(3) input')[0].checked){
            defaultGroup = $(this).find('td:eq(0)').text()
        }
    })
    var sequent =1;
    $.each(arrNameGroup,function (key,value){
        if(key ==defaultGroup){
            $dataSelectGroupID.append('<form id="labelGroup_'+parseInt(key)+'" >' +
                '<div class="form-group" >'+
                '<div class="col-sm-3" style="width: 150px;">' +
                '<lable style="color: red;"  id="groupLabel_'+id+'_'+sequent+'" foo="Y" value="'+key+'">'+value+'</lable></span>'+
                '</div>'+
                '<div class="col-sm-2" style="bottom: 20px;left: 200px;">' +
                '<button class="btn btn-danger"  type="button" onclick="unSelectedGroup('+parseInt(key)+')" style="padding: 2px;"><span class="fa fa-trash"></button>'+
                '</div>'+
                '</div>'+
                '</div>'

            );
        }else{
            $dataSelectGroupID.append('<form id="labelGroup_'+parseInt(key)+'" >' +
                '<div class="form-group" >'+
                '<div class="col-sm-3" style="width: 150px;">' +
                '<lable style="color: red;"  id="groupLabel_'+id+'_'+sequent+'" foo="N"  value="'+key+'">'+value+'</lable></span>'+
                '</div>'+
                '<div class="col-sm-2" style="bottom: 20px;left: 200px;">' +
                '<button class="btn btn-danger"  type="button" onclick="unSelectedGroup('+parseInt(key)+')" style="padding: 2px;"><span class="fa fa-trash"></button>'+
                '</div>'+
                '</div>'+
                '</div>'

            );
        }

        sequent++
    })
}


    function unSelectedMethod(id){
    $('#labelMethod_'+id)[0].remove();
}
function unSelectedTools(id){
    $('#labelTools_'+id)[0].remove();
}
function unSelectedGroup(id){
    $('#labelGroup_'+id)[0].remove();
}


function insertItemSpec(){
    var pdn = document.getElementById("ddlProduct");
    var productName = pdn.options[pdn.selectedIndex].value;
    var spn = document.getElementById("ddlSampleType");
    var sampleTypeName = spn.options[spn.selectedIndex].value;
    var arrUnit ={}
    var arrMethod ={}
    var arrMethodList =[]
    var arrTools={}
    var arrToolsList =[]

    var arrUserGroup={}
    var arrUserGroupList=[]
    var arrSpecRange={}
    var arrMin={}
    var arrMax={}
    var arrSpecText = {}
    var arrInputType = {}
    var json ={}
    json.productIDStr  = productName
    json.sampleTypeStr  = sampleTypeName

    var unitStr = ""
    var itemIdStr = ""
    var specRangStr = ""
    var minStr = ""
    var maxStr = ""
    var specTextStr = ""
    var specInputTypeStr = ""
    var methodStr = ""
    var toolsStr = ""
    var groupStr = ""
    var methodStrList = ""
    var toolsStrList = ""
    var groupStrList = ""

    for(var i = 1; i<=  dataLength;i++){

        var it = document.getElementById("itemNameId"+i);
        var $itemNameId = it.options[it.selectedIndex].value;
        console.log($itemNameId);
        var indexMethod=1;
        var indexTools=1;
        var indexGroup=1;
        methodStr = "";
        toolsStr = "";
        groupStr = "";
        specRangStr +=specRangStr=== "" ? $('#specRangeId'+i).val() : ','+ $('#specRangeId'+i).val()
        unitStr +=unitStr=== "" ? "'"+$('#unitInput'+i).val()+"'" : ','+"'"+$('#unitInput'+i).val()+"'"
        itemIdStr +=itemIdStr === "" ? $itemNameId : ','+$itemNameId
        minStr +=minStr=== "" ? $('#inputMin'+i).val() : ','+ $('#inputMin'+i).val()
        maxStr +=maxStr==="" ? $('#inputMax'+i).val() : ','+ $('#inputMax'+i).val()
        specTextStr +=specTextStr=== "" ? $('#inputText'+i).val() : ','+ $('#inputText'+i).val()
        specInputTypeStr +=specInputTypeStr==="" ? $('#inputType'+i).val() : ','+ $('#inputType'+i).val()
        arrMethod = {}
        arrTools = {}
        arrUserGroup = {}
      $.each($('#dataSelectMethodID'+i+' form .form-group '),function (key,value){
          methodStr  += methodStr==""? "''"+$('#methodLabel_'+i+'_'+indexMethod).attr('value') +':'+ $('#methodLabel_'+i+'_'+indexMethod).attr('foo')+"''" : '|'+"''"+$('#methodLabel_'+i+'_'+indexMethod).attr('value')+':'+ $('#methodLabel_'+i+'_'+indexMethod).attr('foo')+"''"
          indexMethod++;
      })

        $.each($('#dataSelectToolsID'+i+' form .form-group '),function (key,value){
            toolsStr += toolsStr == "" ? "''"+$('#toolsLabel_'+i+'_'+indexTools).attr('value')+':'+ $('#toolsLabel_'+i+'_'+indexTools).attr('foo')+"''" : '|'+"''"+$('#toolsLabel_'+i+'_'+indexTools).attr('value')+':'+ $('#toolsLabel_'+i+'_'+indexTools).attr('foo')+"''"
            indexTools++;
        })
        $.each($('#dataSelectGroupID'+i+' form .form-group '),function (key,value){
          groupStr  +=groupStr =="" ? "''"+ $('#groupLabel_'+i+'_'+indexGroup).attr('value')+':'+ $('#groupLabel_'+i+'_'+indexGroup).attr('foo')+"''" : '|'+"''"+ $('#groupLabel_'+i+'_'+indexGroup).attr('value')+':'+ $('#groupLabel_'+i+'_'+indexGroup).attr('foo')+"''"
            indexGroup++;
        })

        methodStrList+=methodStrList =="" ? methodStr : ','+ methodStr
        toolsStrList+=toolsStrList =="" ? toolsStr : ','+ toolsStr
        groupStrList+=groupStrList =="" ? groupStr : ','+ groupStr
    }
    json.unitStr = unitStr
    json.itemIdStr = itemIdStr
    json.minStr = minStr
    json.maxStr = maxStr
    json.specTextStr = specTextStr
    json.inputTypeStr = specInputTypeStr
    json.specRangStr = specRangStr
    json.methodStr = methodStrList
    json.toolsStr = toolsStrList
    json.userGroupStr = groupStrList
    console.log(json);
    ajaxInsertSpec(json)
}


function ajaxInsertSpec(data){
    jQuery.ajax({
        url: 'insertItemSpecAssign',
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(data),
        dataType: 'json',
        async: false,
        cache: false,
        success: function(data) {
            showMsgSuccess('บันทึกสำเร็จ');
        },
        error: function() {
            showMsgError('ข้อมูลผิดพลาด');
        }
    });
}





