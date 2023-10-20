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
    if(programId == jsonArray[0].value){// เช็คโปรแกรม ว่าเป็นตัวเดียวกันกับที่เคยเก็บไว้ไหม
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
