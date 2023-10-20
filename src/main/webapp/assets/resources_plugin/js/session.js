function setPreviousSession(programId){
    if(!previousSessionIsNull()){
        var jsonArray = jQuery.parseJSON(sessionStorage.jsonArray);
        restoreData(jsonArray,programId);
    }
}

function clearSession(){
    //sessionStorage.setItem("jsonArray", "");
    sessionStorage.clear();
}

function previousSessionIsNull(){
    if(sessionStorage.jsonArray != undefined){
        return false;
    }else{
        return true;
    }
}

function restoreData(jsonArray, programId){
    if(programId == jsonArray[0].value){// ������� ����繵�����ǡѹ�Ѻ�������������
        $.each(jsonArray, function (i, item) {
            if(item.name != "div_code"){
               $("#"+item.name).val(item.value); 
            }else{
                $("#"+item.name).val(item.value);
                reFillList();
            }
        });
    }
    
}
