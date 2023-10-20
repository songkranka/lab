var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var pathsettingMobileLtrSpec = "/Lab/settingMobileLtrSpec";
var backsettingwork = "/Lab/settingWork";
//Normal AND Normal ID

//Y ID
//SET DATA
var product_code='';

//parameter setup
var setupdropdownfortrigger=[];


var objsetupwork='';


//DOCUMENT READY
$(document).ready(function () {
	
	SetDropDownProduct();
	initvalue();
	getColorSetup();
});

var str = location.search;
var checkStatus = "" ;
str = str.split("?");
function initvalue(){	
	querySpecLTRAssignment($('#ddlProduct').val());
}

function querySpecLTRAssignment(prdcode){	
var txtbody='';
var listcolor = '';
var resultcolor='';
	try {
	
		$("#bodysetting").empty();
	    var data = {}
		    data["productID"] = prdcode;
	    
	    jQuery.ajax({
	        url: 'util-getSpecMobileLtr',
	        type: "Post",
	        contentType: "application/json",
	        data: JSON.stringify(data),
	        dataType: 'json',
	        async: false,
	        cache: false,
	        success: function(data) {

			if(data.length>0){
				$('#ltrSpecId').val(data[0].LTR_SPEC_ID);
			    txtbody='<div class="row"><div class="col-xs-12">';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>DISPENSER :</label><input type="text" class="form-control" maxlength="100" id="dispenser" value="'+(data[0].DISPENSER==null?'':data[0].DISPENSER)+'"  placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>SN        :</label><input type="text" class="form-control" maxlength="20" id="sn" value="'+(data[0].SN==null?'':data[0].SN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>SLOT NUMBER:</label><input type="number" class="form-control" id="slotNumber" value="'+(data[0].SLOT_NUMBER==null?'':data[0].SLOT_NUMBER)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>METER TOTAL:</label><input type="number" class="form-control" id="meterTotal" value="'+(data[0].METER_TOTAL==null?'':data[0].METER_TOTAL)+'" placeholder=""/></div>';
				txtbody+='</div></div><br>';
				
				txtbody+='<div class="row"><div class="col-xs-12">';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>FEATURE :</label><input type="text" maxlength="30" class="form-control" id="feature" value="'+(data[0].FEATURE==null?'':data[0].FEATURE)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>COLOR  :</label><select  class="form-control" id="color"  >';
				listcolor = getColorSetup();
				for(var i =0;i<listcolor.length;i++){
					if(listcolor[i].ID !='05'&&listcolor[i].ID !='06'&&listcolor[i].ID !='99'){
					txtbody+='<option value="'+listcolor[i].ID+'">'+listcolor[i].COLOR_NAME+'</option>';
					}
				}
				resultcolor=data[0].COLOR;
				txtbody+='</select></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>API MIN:</label><input type="number" class="form-control" id="apiMin" value="'+(data[0].API_MAX==null?'':data[0].API_MAX)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>API MAX:</label><input type="number" class="form-control" id="apiMax" value="'+(data[0].API_MIN==null?'':data[0].API_MIN)+'" placeholder=""/></div>';
				txtbody+='</div></div><br>';
				
				txtbody+='<div class="row"><div class="col-xs-12">';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>TEMP MIN :</label><input type="number" class="form-control" id="tempmin" value="'+(data[0].TEMP_MIN==null?'':data[0].TEMP_MIN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>TEMP MAX :</label><input type="number" class="form-control" id="tempmax" value="'+(data[0].TEMP_MAX==null?'':data[0].TEMP_MAX)+'" placeholder=""  /></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>API 60 MIN:</label><input type="number" class="form-control" id="api60Min" value="'+(data[0].API_60_MIN==null?'':data[0].API_60_MIN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>API 60 MAX:</label><input type="number" class="form-control" id="api60Max" value="'+(data[0].API_60_MAX==null?'':data[0].API_60_MAX)+'"  placeholder=""/></div>';
				txtbody+='</div></div><br>';
				
				txtbody+='<div class="row"><div class="col-xs-12">';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>DISTILL MIN:</label><input type="number" class="form-control" id="distillmin" value="'+(data[0].DISTILL_MIN==null?'':data[0].DISTILL_MIN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>DISTILL MAX:</label><input type="number" class="form-control" id="distillmax" value="'+(data[0].DISTILL_MAX==null?'':data[0].DISTILL_MAX)+'" placeholder="" /></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>EVAPORATION 10 MIN:</label><input number="number" class="form-control" id="evaporation10min" value="'+(data[0].EVAPORATION_10_MIN==null?'':data[0].EVAPORATION_10_MIN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>EVAPORATION 10 MAX:</label><input number="number" class="form-control" id="evaporation10max" value="'+(data[0].EVAPORATION_10_MAX==null?'':data[0].EVAPORATION_10_MAX)+'" placeholder=""/></div>';
				txtbody+='</div></div><br>';
				
				txtbody+='<div class="row"><div class="col-xs-12">';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>EVAPORATION 50 MIN:</label><input type="number" class="form-control" id="evaporation50min" value="'+(data[0].EVAPORATION_50_MIN==null?'':data[0].EVAPORATION_50_MIN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>EVAPORATION 50 MAX:</label><input type="number" class="form-control" id="evaporation50max" value="'+(data[0].EVAPORATION_50_MAX==null?'':data[0].EVAPORATION_50_MAX)+'"   placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>EVAPORATION 90 MIN:</label><input type="number" class="form-control" id="evaporation90min" value="'+(data[0].EVAPORATION_90_MIN==null?'':data[0].EVAPORATION_90_MIN)+'"  placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>EVAPORATION 90 MAX:</label><input type="number" class="form-control" id="evaporation90max" value="'+(data[0].EVAPORATION_90_MAX==null?'':data[0].EVAPORATION_90_MAX)+'"  placeholder=""/></div>';
				txtbody+='</div></div><br>';
				
				txtbody+='<div class="row"><div class="col-xs-12">';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>BOIL MIN:</label><input type="number" class="form-control" id="boilmin"  value="'+(data[0].BOIL_MIN==null?'':data[0].BOIL_MIN)+'"  placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>BOIL MAX:</label><input type="number" class="form-control" id="boilmax"  value="'+(data[0].BOIL_MAX==null?'':data[0].BOIL_MAX)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>WASTE MIN:</label><input type="number" class="form-control" id="wastemin" value="'+(data[0].WASTE_MIN==null?'':data[0].WASTE_MIN)+'"  placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>WASTE MAX:</label><input type="number" class="form-control" id="wastemax" value="'+(data[0].WASTE_MAX==null?'':data[0].WASTE_MAX)+'"  placeholder=""/></div>';
				txtbody+='</div></div><br>';
				
				txtbody+='<div class="row"><div class="col-xs-12">';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>ETHANOL MIN:</label><input type="number" class="form-control" id="ethanolmin" value="'+(data[0].EVAPORATION_50_MIN==null?'':data[0].EVAPORATION_50_MIN)+'"  placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>ETHANOL MAX:</label><input type="number" class="form-control" id="ethanolmax"  value="'+(data[0].EVAPORATION_50_MIN==null?'':data[0].EVAPORATION_50_MIN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>FLASH POINT MIN:</label><input type="number" class="form-control" id="flashpointmin" value="'+(data[0].EVAPORATION_50_MIN==null?'':data[0].EVAPORATION_50_MIN)+'"  placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>FLASH POINT MAX:</label><input type="number" class="form-control" id="flashpointmax" value="'+(data[0].EVAPORATION_50_MIN==null?'':data[0].EVAPORATION_50_MIN)+'"  placeholder=""/></div>';
				txtbody+='</div></div><br>';
				
				txtbody+='<div class="row"><div class="col-xs-12">';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>BIODIESEL MIN:</label><input type="number" class="form-control" id="biodieselmin" value="'+(data[0].BIODIESEL_MIN==null?'':data[0].BIODIESEL_MIN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>BIODIESEL MAX:</label><input type="number" class="form-control" id="biodieselmax" value="'+(data[0].BIODIESEL_MAX==null?'':data[0].BIODIESEL_MAX)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>CETANE MIN:</label><input type="number" class="form-control" id="cetanemin" value="'+(data[0].CETANE_MIN==null?'':data[0].CETANE_MIN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>CETANE MAX:</label><input type="number" class="form-control" id="cetanemax"  value="'+(data[0].CETANE_MAX==null?'':data[0].CETANE_MAX)+'"placeholder=""/></div>';
				txtbody+='</div></div><br>';
				
				txtbody+='<div class="row"><div class="col-xs-12">';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>RON MIN:</label><input type="number" class="form-control" id="ronmin" value="'+(data[0].RON_MIN==null?'':data[0].RON_MIN)+'"  placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>RON MAX:</label><input type="number" class="form-control" id="ronmax" value="'+(data[0].RON_MAX==null?'':data[0].RON_MAX)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>MON MIN:</label><input type="number" class="form-control" id="monmin" value="'+(data[0].MON_MIN==null?'':data[0].MON_MIN)+'" placeholder=""/></div>';
				txtbody+='<div class="col-md-3 col-sm-6 col-xs-12"><label>MON MAX:</label><input type="number" class="form-control" id="monmax" value="'+(data[0].MON_MAX==null?'':data[0].MON_MAX)+'" placeholder=""/></div>';
				txtbody+='</div></div><br>';
				
			

				
				$('#bodysetting').append(txtbody);
	        }else{
			var txtbody='<div class="row text-center"><div class="col-xs-12 h4">';
				txtbody+='ไม่พบข้อมูล';
				txtbody+='</div></div>';
				
				$('#bodysetting').append(txtbody);
			}
			$('#color').val(resultcolor);
	        },
	        error: function() {
	            showMsgError('ข้อมูลผิดพลาด');
	            HideWaiting();
	        },complete: function(data){
	//renderTd();
			}
	    });
	} catch (ex) {
	    showMsgError(ex);
	    HideWaiting();
	}
 	 
 } 


function gotoMain(){
    window.location= backloc;;
}
function getColorSetup(){
	var colortxt='';
	 try {
	    jQuery.ajax({
			url : 'util-getColor',
			type : "Get", 
			contentType : "application/json",
			dataType : 'json',
			async: false,
			cache: false,
			success : function(data) {
			colortxt=data;
			},
			error : function() {
						showMsgError('ข้อมูลผิดพลาด');
						HideWaiting() ;
			}
			});  
	} catch (ex) {
		showMsgError(ex);
		HideWaiting() ;
	}
	return colortxt;
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
            async: false,
            cache: false,
            success: function(data) {
                var txt = '';
                $.each(data, function(i, item) {
	
						if(Number(item.PRODUCT_ID.substring(item.PRODUCT_ID.length-2,item.PRODUCT_ID.length)<=8)){
						$('#ddlProduct').append('<option value="' + item.PRODUCT_ID + '">&nbsp;&nbsp;' + item.PRODUCT_NAME + '</option>');
                        txt += item.PRODUCT_ID + ',';
						}

                });
                if (txt.length > 0) {
                    txt = txt.substring(0, txt.length - 1)
                }
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
	
function searchData(){
	querySpecLTRAssignment($('#ddlProduct').val());
}

Object.size = function(obj) {
  var size = 0,
    key;
  for (key in obj) {
    if (obj.hasOwnProperty(key)) size++;
  }
  return size;
};

function saveData(){

	var json =getDataForSave();
		    jQuery.ajax({
			 url: 'util-saveMobileLtrSpec',
	        type: "Post",
	        contentType: "application/json",
	        data: JSON.stringify(json),
	        dataType: 'json',
	        async: false,
	        cache: false,
	        success: function(data) {
			window.location=pathsettingMobileLtrSpec;
			},
			error : function() {
						showMsgError('ข้อมูลผิดพลาด');
						HideWaiting() ;
			}
			});  
	
}

function getDataForSave(){
	var data = {};
	data['productId']=$('#ddlProduct').val();
	data['ltrSpecId']=$('#ltrSpecId').val();
	data['dspenser']=$('#dispenser').val();
	data['sn']=$('#sn').val();
	data['slotNumber']=$('#slotNumber').val();
	data['meterTotal']=$('#meterTotal').val();
	data['feature']=$('#feature').val();
	data['color']=$('#color').val();
	data['apiMin']=$('#apiMin').val();
	data['apiMax']=$('#apiMax').val();
	data['tempMin']=$('#tempmin').val();
	data['tempMax']=$('#tempmax').val();
	data['api60min']=$('#api60Min').val();
	data['api60Max']=$('#api60Max').val();
	data['distillMin']=$('#distillmin').val();
	data['distillMax']=$('#distillmax').val();
	data['evaporation10Min']=$('#evaporation10min').val();
	data['evaporation10Max']=$('#evaporation10max').val();
	data['evaporation50Min']=$('#evaporation50min').val();
	data['evaporation50Max']=$('#evaporation50max').val();
	data['evaporation90Min']=$('#evaporation90min').val();
	data['evaporation90Max']=$('#evaporation90max').val();
	data['boilMin']=$('#boilmin').val();
	data['boilMax']=$('#boilmax').val();
	data['wasteMin']=$('#wastemin').val();
	data['wasteMax']=$('#wastemax').val();
	data['ethanolMin']=$('#ethanolmin').val();
	data['ethanolMax']=$('#ethanolmax').val();
	data['flashpointMin']=$('#flashpointmin').val();
	data['flashpointMax']=$('#flashpointmax').val();
	data['bioDieselMin']=$('#biodieselmin').val();
	data['bioDieselMax']=$('#biodieselmax').val();
	data['cetaneMin']=$('#cetanemin').val();
	data['cetaneMax']=$('#cetanemax').val();
	data['ronMin']=$('#ronmin').val();
	data['ronMax']=$('#ronmax').val();
	data['monMin']=$('#monmin').val();
	data['monMax']=$('#monmax').val(); 
	return data;
}
