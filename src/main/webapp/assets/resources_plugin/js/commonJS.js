//function noRightClick(e) {
//    var message="�������ö���ꡢ����"; // Message for the alert box
//    if (document.all) {
//        if (event.button == 2) {
//            alert(message);
//            return false;
//        }
//    }
//    if (document.layers) {
//        if (e.which == 3) {
//            alert(message);
//            return false;
//        }
//    }
//}
//if (document.layers) {
//    document.captureEvents(Event.MOUSEDOWN);
//}
//document.onmousedown=noRightClick;

servDate = new Date();   
// ���� 26/09/2557 : ����㹡�õ��ʵ�ԧ ������� ,��
//var deliCol     = "C#^$";
//var deliRow     = "R#^$";
var deliCol     = "|";
var deliRow     = "^";
var deliMrow    = "M#^$"; 

// ��૵�յ͹ onmouseover //
var tr0 = "#EEEEEE";    // ����
var tr1 = "#FFFFFF";    // �բ��
var over = "#FFFF99";   // ������ͧ


// �ѧ���蹹�� ������Ѻ ��ǹ�ͧ��� Disable Backspace �� JavaScript ��ҹ��ҧ��� ������ onkeydown='cancelBackSpace()' � Tag Body 
 
 function cancelBackSpace() {
            if ((event.keyCode == 8 ||
           (event.keyCode == 37 && event.altKey) ||
           (event.keyCode == 39 && event.altKey))
            &&
           (event.srcElement.form == null || event.srcElement.isTextEdit == false)
          ) {
                event.cancelBubble = true;
                event.returnValue = false;
            }
    }   

// �ѧ���蹹�� ������Ѻ����¹������բ��
function changeBg(el) {
    el.style.background = event.type == "activate" ? "white " : " #FFFFD9";
}

// �ѧ���蹹�� ������Ѻ����¹�����������ͧ
function  changeBg1(el) {
    if(el.value=="") {
        el.style.background = event.type == "deactivate" ? "#FFFFD9 " : "white";
    }
}

// �ѧ���蹹�� ������Ѻ����¹������տ��
function  changeBg2(el) {
    if(el.value=="") {
        el.style.background = event.type == "deactivate" ? "#CCFFFF " : "white";
    }
}


// �ѧ���蹹�� ������Ѻ����¹������ժ��� 
function changeBgError(el) {
    el.style.background="#FFD2D2";
}

// �ѧ���蹹�� ������Ѻ����¹������բ��
function changeBgWhite(el) {
    el.style.background="#FFFFFF";
}

// �ѧ���蹹�� ������Ѻ����¹�����������ͧ
function changeBgYellow(el) {
    el.style.background="#FFFFD9";
}

// �ѧ���蹹�� ������Ѻ����¹������բ��
function changeBgCommon(obj) {
    obj.style.background="#FFFFFF";
}

// �ѧ���蹹�� ������Ѻ����¹�����������ͧ
function changeBgMandatory(obj) {
    obj.style.background="#FFFFD9";
}

// �ѧ���蹹�� ������Ѻ����¹���������
function changeBgGray(el) {
    el.style.background="#F0F0F0";
}

// �ѧ���蹹�� ������Ѻ����¹������տ��
function changeBgBlue(el) {
    el.style.background="#CCFFFF";
}

// �ѧ���蹹�� ������Ѻ Disabled �������¹���������
function disabledText(obj) {
    obj.disabled = true;
    changeBgGray(obj);
}

// �ѧ���蹹�� ������Ѻ Enabled �������¹����繢��
function enabledText(obj) {
    obj.disabled = false;
    changeBgCommon(obj);
}

// �ѧ���蹹�� ������Ѻ Enabled �������¹���������ͧ
function mandatoryText(obj) {
    obj.disabled = false;
    changeBgMandatory(obj);
}
//////////////////////       Trim.js      //////////////////////////////////
/**
 * This function is called to Trim the leading and trailing spaces for a text field
 * value.It accepts the field object as input and removes the spaces in that field.
 * @param : objField
 * @return : none (internally the field value's spaces are Trimmed)
 */
function Trim(objField) {
    var strFieldValue = objField.value;
    var leadChar = "";
    for (var i=0;i<strFieldValue.length;) {
        leadChar = strFieldValue.charAt(i);
        if (' ' == leadChar  )
            strFieldValue = strFieldValue.substring(1);
        else
            break;
    } 
    
    var trailChar = "";
    for (var i=strFieldValue.length-1;i>=0;) {
        trailChar = strFieldValue.charAt(i);
        if (' ' == trailChar ) {
            strFieldValue = strFieldValue.substring(0,i);
            i = strFieldValue.length-1;
    	} else
             break;
    } 
    objField.value = strFieldValue;
}

/**
 * This function is called to Trim the leading and trailing spaces for a String
 * value.It accepts the String as input and removes the spaces in that field.
 * @param : objField
 * @return : String The Trimmed String
 */

function TrimValue(fieldValue) {
    if (fieldValue===undefined) fieldValue = "";
    var strFieldValue = fieldValue;
    var leadChar = "";
    for (var i=0;i<strFieldValue.length;) {
        leadChar = strFieldValue.charAt(i);
        if (' ' == leadChar  )
            strFieldValue = strFieldValue.substring(1);
    	else
            break;
    } 
    
    var trailChar = "";
    for (var i=strFieldValue.length-1;i>=0;) {
        trailChar = strFieldValue.charAt(i);
        if (' ' == trailChar ) {
            strFieldValue = strFieldValue.substring(0,i);
            i = strFieldValue.length-1;
        } else
            break;
    } 
    return(strFieldValue);
}

///////////////////////////////       TABPANE.js      ///////////////////////
/**
  ����� Function Tab ���ء������� tabPane.js
**/
/////////////////////////////////////////////////////////////////////////////

/////////////////////////////      KeyLib.js      ///////////////////////////
/* BEGIN ����Ѻ Set �ǡ���� Key ��ҧ */
document.onkeydown = CheckMyKeys;
function CheckMyKeys()    {
    var key = event.keyCode;
    //alert("keyCode = "+ key);
/*	
    if (key==112){			//F1 key
        if (window.event.shiftKey){     // �� Shift + F1
            shiftKeyF1(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F1
            ctrlKeyF1(event);
        }else{															// �� F1
            keyF1(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==113){			//F2 key
        if (window.event.shiftKey){     // �� Shift + F2
            shiftKeyF2(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F2
            ctrlKeyF2(event);
        }else{															// �� F2
            keyF2(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==114){			//F3 key
        if (window.event.shiftKey){     // �� Shift + F3
            shiftKeyF3(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F3
            ctrlKeyF3(event);
        }else{															// �� F3
            keyF3(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==115){			//F4 key
        if (window.event.shiftKey){     // �� Shift + F4
            shiftKeyF4(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F4
            ctrlKeyF4(event);
        }else{															// �� F4
            keyF4(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==116){			//F5 key
        if (window.event.shiftKey){     // �� Shift + F5
            shiftKeyF5(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F5
            ctrlKeyF5(event);
        }else{															// �� F5
            keyF5(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==117){			//F6 key
        if (window.event.shiftKey){     // �� Shift + F6
            shiftKeyF6(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F6
            ctrlKeyF6(event);
        }else{															// �� F6
            keyF6(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==118){			//F7 key
        if (window.event.shiftKey){     // �� Shift + F7
            shiftKeyF7(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F7
            ctrlKeyF7(event);
        }else{															// �� F7
            keyF7(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==119){			//F8 key
        if (window.event.shiftKey){     // �� Shift + F8
            shiftKeyF8(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F8
            ctrlKeyF8(event);
        }else{															// �� F8
            keyF8(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==120){			//F9 key
        if (window.event.shiftKey){     // �� Shift + F9
            shiftKeyF9(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F9
            ctrlKeyF9(event);
        }else{															// �� F9
            keyF9(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==121){			//F10 key
        if (window.event.shiftKey){     // �� Shift + F10
            shiftKeyF10(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F10
            ctrlKeyF10(event);
        }else{															// �� F10
            keyF10(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==122){			//F11 key
        if (window.event.shiftKey){     // �� Shift + F11
            shiftKeyF11(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F11
            ctrlKeyF11(event);
        }else{															// �� F11
            keyF11(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==123){			//F12 key
        if (window.event.shiftKey){     // �� Shift + F12
            shiftKeyF12(event);
        }else if (window.event.ctrlKey){        // �� Ctrl + F12
            ctrlKeyF12(event);
        }else{															// �� F12
            keyF12(event);
        }
        event.keyCode = 0;
        return false;
    }
    if (key==27){			//Esc key
        event.keyCode = 0;
        return false;
    }
    if (key==32){			//SpaceBar key
        //event.keyCode = 0;
        //return false;
    }
*/	
    if (key==33){			//PageUp key
        keyPageUp(event);
        //tabPageUp(event)
        //event.keyCode = 0;
        //return false;
    }
    if (key==34){			//PageDown key
        keyPageDown(event);
        //tabPageDown(event)
        //event.keyCode = 0;
        //return false;
    }
    if (key==40){			//ArrowDown key
        ArrowDown(event);
    }
    if (key==38){			//ArrowUp key
        ArrowUp(event);
    }
    if (key==13){
        pressEnter(event);
    }
}


function ArrowDown(){}

function ArrowUp(){}

// function ����Ѻ��÷� Overide �ͧ Java Script ��� �ѧ���� Key ��ҧ �
// ����Ѻ�ѧ���蹢ͧ���� F1
function keyF1(event){
    return true;
}
function shiftKeyF1(event){
    return true;
}
function ctrlKeyF1(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F2
function shiftKeyF2(event){
    return true;
}
function ctrlKeyF2(event){
    return true;
}
function keyF2(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F3
function shiftKeyF3(event){
    return true;
}
function ctrlKeyF3(event){
    return true;
}
function keyF3(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F4
function shiftKeyF4(event){
    return true;
}
function ctrlKeyF4(event){
    return true;
}
function keyF4(event) 
{
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F5
function shiftKeyF5(event){
    return true;
}
function ctrlKeyF5(event){
    return true;
}
function keyF5(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F6
function shiftKeyF6(event){
    return true;
}
function ctrlKeyF6(event){
    return true;
}
function keyF6(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F7
function shiftKeyF7(event){
    return true;
}
function ctrlKeyF7(event){
    return true;
}
function keyF7(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F8
function shiftKeyF8(event){
    return true;
}
function ctrlKeyF8(event){
    return true;
}
function keyF8(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F9
function shiftKeyF9(event){
    return true;
}
function ctrlKeyF9(event){
    return true;
}

function keyF9(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F10
function shiftKeyF10(event){
    return true;
}
function ctrlKeyF10(event){
    return true;
}
function keyF10(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F11
function shiftKeyF11(event){
    return true;
}
function ctrlKeyF11(event){
    return true;
}
function keyF11(event){
    return true;
}

// ����Ѻ�ѧ���蹢ͧ���� F12
function shiftKeyF12(event){
    return true;
}
function ctrlKeyF12(event){
    return true;
}
function keyF12(event){
    return true;
}
function keyPageUp(event){
    return true;
}
function keyPageDown(event){
    return true;
}
function pressEnter(event){
    return true;
}
/* END ����Ѻ Set �ǡ���� Key ��ҧ */

/*
    function 㹡�����١�â�� Arrow Up �繡�â�Ѻ Cursor 仢�ҧ�� 1 ���� ����͹�Ѻ�� Shift+Tab
    ������ҧ����觤��
    onkeydown="up(this.form,this)"
*/
function up(form,field){
    var next=0, found=false ;
    var f=form;
    if(event.keyCode==38){
        for(var i = f.length-1; i > 0; i--){
            if(field.name==f.item(i).name){
                next=i-1;
                found=true
                break;
            }
        }
        while(found){  //Infinite loop 
            if( f.item(next).disabled==false &&  f.item(next).type!='hidden'){
                f.item(next).focus();
                if(f.item(next).type != 'select-one')
                    f.item(next).select();
                break;
            }else{
                if(next<f.length-1)
                    next=next-1;
                else
                    break;
            }
        }
    }
}

/*
    function 㹡�á� Enter �繡�â�Ѻ Cursor ŧ� 1 ���� ����͹�Ѻ�� Tab
    ������ҧ����觤��
    onkeydown="down(this.form,this)"
*/
function down(form,field){
    var next=0, found=false;
    var f=form;
    if((event.keyCode==13) ){
        var fSize=f.length;
        //for(var i=0;i<f.length;i++){
        for(var i=0;i<fSize;i++){
            if(field.name==f.item(i).name){
                next=i+1;	
                found=true
                break;
            }
        }
        while(found){  //Infinite loop 
            if( f.item(next).disabled==false &&  f.item(next).type!='hidden'){
                f.item(next).focus();
                //alert(f.item(next).type);
                if(f.item(next).type != 'select-one')
                    f.item(next).select();
                event.returnValue = false;
                break;
            }else{
                if(next<(fSize-1))
                    next=next+1;
                else
                    break;
            }
        }
    }
}

/*
    function 㹡�á� �١��ŧ 1 ���� �繡�â�Ѻ Cursor ŧ� 1 ���� ����͹�Ѻ�� Enter ���� Tab
    ������ҧ����觤��
    onkeydown="keyArrowDown(this.form,this)"
*/
function keyArrowDown(form,field){
    var next=0, found=false;
    var f=form;
    if((event.keyCode==40) ){
        for(var i=0;i<f.length;i++){
            if(field.name==f.item(i).name){
                next=i+1;	
                found=true
                break;
            }
        }
        while(found){  //Infinite loop 
            if( f.item(next).disabled==false &&  f.item(next).type!='hidden'){
                f.item(next).focus();
                f.item(next).select();
                break;
            }else{
                if(next<f.length-1)
                    next=next+1;
                else
                    break;
            }
        }
    }
}

function right(form,field){
    var next=0, found=false
    var f=form
    if((event.keyCode==39) ){
        for(var i=0;i<f.length;i++){
            if(field.name==f.item(i).name){
                next=i+1;	
                found=true
                break;
            }
        }
        while(found){  //Infinite loop 
            if( f.item(next).disabled==false &&  f.item(next).type!='hidden'){
                f.item(next).focus();
                f.item(next).select();
                break;
            }else{
                if(next<f.length-1)
                    next=next+1;
                else
                    break;
            }
        }
    }
}

/*
    function 㹡�á� �١��价ҧ��� 1 ���� �繡�â�Ѻ Cursor ŧ� 1 ���� ����͹�Ѻ�� Tab
    ������ҧ����觤��
    onkeydown="keyArrowRight(this.form,this)"
*/
function keyArrowRight(form,field){
    var next=0, found=false
    var f=form
    if((event.keyCode==39) ){
        for(var i=0;i<f.length-1;i++){
            if(field.name==f.item(i).name){
                next=i+1;	
                found=true
                break;
            }
        }
        while(found){  //Infinite loop 
            if( f.item(next).disabled==false &&  f.item(next).type!='hidden'){
                f.item(next).focus();
                f.item(next).select();
                break;
            }else{
                if(next<f.length-1)
                    next=next+1;
                else
                    break;
            }
        }
    }
}

/*
    function 㹡�á� �١��价ҧ���� 1 ���� �繡�â�Ѻ Cursor ŧ� 1 ���� ����͹�Ѻ��  Shift+Tab
    ������ҧ����觤��
    onkeydown="keyArrowLeft(this.form,this)"
*/
function keyArrowLeft(form,field){
    var next=0, found=false
    var f=form
    if((event.keyCode==37) ){
        for(var i=0;i<f.length;i++){
            if(field.name==f.item(i).name){
                next=i-1;	
                found=true
                break;
            }
        }
        while(found){  //Infinite loop 
            if( f.item(next).disabled==false &&  f.item(next).type!='hidden'){
                f.item(next).focus();
                f.item(next).select();
                break;
            }else{
                if(next<f.length-1)
                    next=next-1;
                else
                    break;
            }
        }
    }
}

function getNextElement(field) {
    var fieldFound = false;
    var form = field.form;
    for (var e = 0; e < form.elements.length; e++) {
        if (fieldFound && form.elements[e].type != 'hidden')
            break;
        if (field == form.elements[e])
            fieldFound = true;
    }
    return form.elements[e % form.elements.length];
}

function tabOnEnter(field, evt) {
    var keyCode = document.layers ? evt.which : document.all ? 
    evt.keyCode : evt.keyCode;
    if (keyCode != 13)
        return true;
    else {
        getNextElement(field).focus();
        getNextElement(field).select();
        return false;
    }
}

 function tabPageUp(event){
     var key = event.keyCode;
     if (key==33){      // ����Ѻ�� PageUp
        var tabarr = new Array(3);
        tabarr[0]= "main";

        tabarr[1]="usage";
        tabarr[2]="api";

        var i = tabPane.getSelectedIndex( )+1;
        if(i>2){
            i=2;
        }

        var val=tabarr[i];
        showArticleTab( val);
    }else{
        return false;
    }
}

function tabPageDown(event){
    var key = event.keyCode;
    if (key==34){      // ����Ѻ�� PageDown
        var tabarr = new Array(3);
        tabarr[0]= "main";
        tabarr[1]="usage";
        tabarr[2]="api";
        var i = tabPane.getSelectedIndex( )-1;
        if(i<0)
            i=0;
        var val=tabarr[i];
        showArticleTab( val);
    }else{
        return false;
    }
}

function showArticleTab( sName ) {
    if (typeof tabPane != "undefined" ) {
        switch ( sName ) {
            case "main":
                tabPane.setSelectedIndex( 0 );
                break;

            case "usage":
                tabPane.setSelectedIndex( 1 );
                break;

            case "api":
                tabPane.setSelectedIndex( 2 );
                break;
        }	
    }
}

function nexttab(){
    var tabarr = new Array(4);
    tabarr[0]= "main";
    tabarr[1]="usage";
    tabarr[2]="api";
    var i = tabPane.getSelectedIndex( )+1;
    if(i>2){
        i=2;
    }
    var val=tabarr[i];
    showArticleTab( val);
}

/*
    function 㹡�����١�â�� Arrow Up �繡�â�Ѻ Cursor 仢�ҧ�� 2 ���� ����͹�Ѻ�� Shift+Tab
    ������ҧ����觤��
    onkeydown="up(this.form,this)"
*/
function updis_read(form,field){
    var next=0, found=false ;
    var f=form;
    //if(event.keyCode==38){
        for(var i = f.length-1; i > 0; i--){
            if(field.name==f.item(i).name){
                next=i-1;
                found=true
                break;
            }
        }
        while(found){  //Infinite loop 
            if( f.item(next).disabled==false &&  f.item(next).type!='hidden' && f.item(next).readOnly==false){
                f.item(next).focus();
                f.item(next).select();
                break;
            }else{
                if(next<f.length-1)
                    next=next-1;
                else
                    break;
            }
        }
    //}
}

/*
    function 㹡�á� Enter �繡�â�Ѻ Cursor ŧ� 2 ���� ����͹�Ѻ�� Tab
    ������ҧ����觤��
    onkeydown="down(this.form,this)"
*/
function downdis_read(form,field){
    var next=0, found=false;
    var f=form;
    //if((event.keyCode==13) ){
        var fSize=f.length;
        for(var i=0;i<fSize;i++){
            if(field.name==f.item(i).name){
                next=i+1;	
                found=true
                break;
            }
        }
        while(found){  //Infinite loop 
            if( f.item(next).disabled==false &&  f.item(next).type!='hidden' && f.item(next).readOnly==false){
                event.returnValue=false;
                f.item(next).focus();
                f.item(next).select();
                break;
            }else{
                if(next<(fSize-1))
                    next=next+1;
                else
                    break;
            }
        }
    //}
}

/* 
    ���Ǩ�ͺ event ��ҡ� enter || tab || up ������� 
    ����� �� return true 
*/
function chkKeyCodeEnterTabUp(){
    if(event.keyCode==13||event.keyCode==9 || event.keyCode==38)
        return true;
    else
        return false;
}

/* 
    ���Ǩ�ͺ event ��ҡ� enter || tab ������� 
    ����� �� return true 
*/
function chkKeyCodeEnterTab(){
    if(event.keyCode==13||event.keyCode==9 )
        return true;
    else
        return false;
}

/*
    function 㹡�á��ѧ�Ѻ��� Mandatory Field ����������ö�դ����ҧ��
    ������ҧ�����ҹ�������令�ͺ�ѧ������������ҹ��������� �ѧ������ҧ
    onkeydown="if(chkMandatory(this)){ �ѧ�������� }"
    presented by Sumate @ 3/11/2547
*/
function chkMandatory(obj, fldnam) {
    //alert(event.keyCode);
    if (fldnam==undefined)
        fldnam='���������ú��ǹ';
    if ((TrimValue(obj.value)=="") && ((event.keyCode==13) || (event.keyCode==38) || (event.keyCode==9))) 
    {
        event.returnValue = false;
//		alert ("��ͤ�������ʸ\n\nE0000:�ô�ѹ�֡������"+obj.name);
        alert (showMessage(E0011)+fldnam);
        obj.focus();
        return false;
    } 
    else 
    {
        return true;
    }
}

/////////////////////////      Number.js      ///////////////////////////
/*
   �� Function compare Field Money 
*/
function compareNumltZero(obj,message){
    if(parseFloat(obj.value)<=0){
        alert(showMsg(E0011)+message);
        obj.focus();
        return false;
    }else{
        return true;
    }
}
/* �� function ������Ǩ�ͺ��ҵ���Ţ 
�� return ������Ţ�ȹ��� 2 ���˹�
��觨��ա�ûѴ��ɴ���
*/
function ValidateFloatNum( obj ){
    var  intPat = /^[0-9]+$/;
    var  realPat = /^[0-9]+\.[0-9]{1,2}$/;
    var  realPat2 = /^\.[0-9]{1,2}$/;
    var  realPat3 = /^[0-9]+\.$/;
    
    if (obj.value == "")
        return true;
    if ( realPat3.test( obj.value ) == true ){
        obj.value = obj.value + "00";
    }
    /*if ( realPat2.test( obj.value ) == true )
    {
        obj.value = "0" + obj.value;
    }*/
    if ( realPat.test( obj.value ) == false ){
        if ( intPat.test( obj.value ) == false ){	
            if( obj.value == ".")
                obj.value = "";
            else {
                obj.value = "0" + obj.value;
                obj.value = RoundUp(obj.value);
            }
        }else{
            obj.value += ".00";
        }
    }
    return true;
}

/****
    Function ��͹������㹪�ͧ�ӹǹ�Թ ����ö��͹�� 16 ��ѡ
    ����ش�ȹ���
****/
function chkDecimal152( money ) 
{
    var temp_money = money.value.split(".");
    if(temp_money[0].length > 15){
        alert("�ӹǹ�Թ���ѹ�֡��ͧ�բ�Ҵ����Թ 15 ��ѡ ������ش�ȹ���");
        //alert(showMessage(E0017));
        money.value = "";
        money.focus();
        return false;
    }else{
        return true;
    }
}

/* ������¹ format �Թ����� comma ����繪�ͧ��ҧ  
    ������ҧ
    onFocus="PreEditNum(this);"
*/
function PreEditNum( obj ){
    obj.value = obj.value.replace( /,/g, "" );
    obj.select();
}

/* ������¹ format �Թ����� #,###.00  */
function PostEditFloatNum( obj ){
    if( obj.value == "" ) return  ; 
    if ( obj.value  < 0.00001){
        obj.value = "0.00";
        return false;
    }
    if ( parseFloat( obj.value ) == 0 && obj.value.length > 1 ) {
        obj.value = "0.00";
        return false;
    }
    var  extPat = /^([0-9]+)\.(.*)/;
    /* find bug with more value */
    if (extPat.test(obj.value))	{
        extPat.exec( obj.value );
        var str = new String(RegExp.$2);
        if (str.length > 2){
            str = str.substring(0,3);
            str = "0."+str;
            var decSum = 0.005 + parseFloat(str);
            tmp = "" + decSum;
            tmp = tmp.substring(0,4);
            var newStr = new String(RegExp.$1);
            obj.value = parseFloat(newStr) + parseFloat(tmp);
        }
    }

    if ( ValidateFloatNum( obj ) == false ) return;

    extPat.exec( obj.value );
    intPart = new String( RegExp.$1 );
    decPart = new String( RegExp.$2 );
    if ( decPart.length == 1 ){
        decPart += "0";
    }

    intPart = "" + parseFloat(intPart);
    intPartLen = intPart.length;

    if ( ( prefix = intPartLen % 3 ) == 0 )
        prefix = 3;
    newValue = intPart.substring( 0, prefix );
    for ( intPartLen -= prefix; intPartLen > 0; intPartLen -= 3 ){
        newValue += "," + intPart.substring( prefix, prefix + 3 );
        prefix += 3;
    }
    obj.value = newValue + "." + decPart;
}

/* ���Ǩ�ͺ�ٻẺ�ӹǹ�Թ  
    ������ҧ 
    onblur="ProcessResult(this);"
*/
function ProcessResult( obj ){
    obj.value=obj.value.replace(/,/g, "");	//Sumate@18/7/48
    if(chkDecimal152(obj)){//Sumate@3/6/48
        if( obj.value == "" ){
                return true;
        }else{
            if (!ValidateFloatNum(obj))	{
                //alert( "�ٻẺ�ӹǹ�Թ���١��ͧ ���ͧ�ҡ:\n\n1. ��Сͺ���µ���ѡ����蹹͡�ҡ����Ţ  0-9 ��Шش�ȹ���\n2. ������ͧ���� -/+��˹��\n3. ���ȹ����Թ 2 ��ѡ" );
                obj.value="";
                obj.focus();
                event.returnValue = false;
                return false;
            }
            PostEditFloatNum(obj);
            return true;
        }
    }
}

/* ��Ѵ��ɨش�ȹ���  */
function RoundUp(value) {
    var scale = 2;
    var nine="";
    for (var i=1; i<=scale; i++)
        nine += "9";
    var ten="1";
    for (var i=1; i<=scale; i++)
        ten += "0";

    var  extPat = /^([0-9]+)\.(.*)/;
    extPat.exec(value);
    var str = new String(RegExp.$2);
    var newStr = new String(RegExp.$1);

    if (str.length > scale) {	//�óըӹǹ�ȹ������ѹ�֡�ҡ���ҷ���˹�
        var str1 = str.substring(scale, scale+1);

        if (str1 >= "5") {	//�óշȹ�����ѡ����Թ����á�դ���ҡ���� 5 �зӡ�ûѴ��ɢ��
            var str2 = str.substring(0,scale);
            var decSum = parseInt(str2, 10) + 1;

            if (decSum > parseInt(nine, 10)) {	//�ó�����ͻѴ������� ��ͧ����Ң����繨ӹǹ���
                newStr = "" + (parseInt(newStr, 10) + 1);
                decSum = decSum - parseInt(ten, 10);
            }
            var decSum1 = ""+decSum;
            var zeroNum = scale-decSum1.length;
            str1 = "0.";
            for (var i=1; i<=zeroNum; i++)
                str1 += "0";
            str1 += decSum1;
        } else {	//�óշȹ�����ѡ����Թ����á�դ�ҹ��¡��� 5 �зӡ�ûѴ��ɷ��
            str1 = "0." + str.substring(0, scale);
        }
        var tmp = str1.substring(1);

        return newStr+tmp;
    } else {
        return value;
    }
}

/* ��㹡���ʴ���ҵ���Ţ������ٻ format �ͧ����Թ 9,999.99  --> by pichai 08/11/2547 */
function showFormatCurrency(curr){
    curr = curr.toString().replace(/\$|\,/g,'');
    if (isNaN(curr))
        curr = "0";
    sign = (curr == (curr = Math.abs(curr)));
    curr = Math.floor(curr*100+0.50000000001);
    cents = curr%100;
    curr = Math.floor(curr/100).toString();
    if (cents < 10)
        cents = "0" + cents;
    for (var intNub = 0; intNub < Math.floor((curr.length-(1+intNub))/3); intNub++)
        curr = curr.substring(0,curr.length-(4 * intNub + 3))+','+ curr.substring(curr.length-(4 * intNub + 3));
    return (((sign)?'':'-') + curr + '.' + cents);
}

/* function ����Ѻ�������� key �Թ�ӹǹ����˹�  */
function textCounter(field,maxlimit){
    if (field.value.length > maxlimit){
        //return false;
        field.value = field.value.substring(0, maxlimit);
    }
}

/*	
    function ����Ѻ����繵���ѡ����е���Ţ��ҹ��
    ������ҧ����觤�� 
    onKeypress="AlphaNumericValue(event)"
*/
function AlphaNumericValue(event){
    if((event.keyCode >= 48 &&  event.keyCode <= 57) // 0-9
        || (event.keyCode >= 65 && event.keyCode <= 90) // A-Z
        || (event.keyCode >= 97 && event.keyCode <= 122) // a-z
        || (event.keyCode >= 3585 && event.keyCode <= 3630) // �-�
        || (event.keyCode >= 3632 && event.keyCode <= 3642) // ���
        || (event.keyCode >= 3648 && event.keyCode <= 3662) // ���
        || (event.keyCode >= 240 && event.keyCode <= 249) // �-�
        || (event.keyCode == 32) // Blank
        || (event.keyCode == 8)) // Tab      
    {
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

function AlphaNumericCodeValue_Special(event){
    if((event.keyCode >= 35 &&  event.keyCode <= 38) // 0-9
        || (event.keyCode >= 40 && event.keyCode <= 91) // A-Z
        || (event.keyCode >= 93 && event.keyCode <= 96) // �ѡ���
        || (event.keyCode >= 97 && event.keyCode <= 122) // a-z
        || (event.keyCode >= 3585 && event.keyCode <= 3630) // �-�
        || (event.keyCode >= 3632 && event.keyCode <= 3642) // ���
        || (event.keyCode >= 3648 && event.keyCode <= 3662) // ���
        || (event.keyCode >= 240 && event.keyCode <= 249) // �-�
        || (event.keyCode == 32) // Blank
        || (event.keyCode == 8)) // Tab      
    {
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

/*	
    function ����Ѻ����繵���ѡ�������ѧ��ɵ���˭���е���Ţ��ҹ��
    ������ҧ����觤�� 
    onKeypress="AlphaNumericCodeValue(event)"
*/
function AlphaNumericCodeValue(event){
    if((event.keyCode >= 48 && event.keyCode <= 57) // 0-9
        || (event.keyCode >= 65 && event.keyCode <= 90) // A-Z
        || (event.keyCode >= 97 && event.keyCode <= 122)) // a-z
        // || (event.keyCode == 8)) // Tab
    {
        if (event.keyCode >= 97 && event.keyCode <= 122)
            event.keyCode -= 32;
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

/*	
    function ����Ѻ����繵���ѡ�������ѧ��ɵ���˭���е���Ţ��ҹ��
    ������ҧ����觤�� 
    onKeypress="AlphaNumericCodeValue(event)"
*/
function AlphaNumericCodeValue_tab(event){
    if((event.keyCode >= 48 && event.keyCode <= 57) // 0-9
        || (event.keyCode >= 65 && event.keyCode <= 90) // A-Z
        || (event.keyCode >= 97 && event.keyCode <= 122) // a-z
        || (event.keyCode == 8)) // Tab
    {
        if (event.keyCode >= 97 && event.keyCode <= 122)
            event.keyCode -= 32;
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

/*	
    function ����Ѻ����繵���ѡ�������ѧ���
    ������ҧ����觤�� 
    onKeypress="NoneEngAlphaValue(event)"
*/
function NoneEngAlphaValue(event){
    if((event.keyCode >= 65 && event.keyCode <= 90) // A-Z
        || (event.keyCode >= 97 && event.keyCode <= 122)) // a-z
    {
        event.returnValue = false; 
    }else{
        event.returnValue = true;
    }
}

function NoneThaiAlphaValue_Special(event){
    if((event.keyCode >= 35 &&  event.keyCode <= 38) // 0-9
        || (event.keyCode >= 40 && event.keyCode <= 91) // A-Z        
        || (event.keyCode >= 93 && event.keyCode <= 122)// a-z
        || (event.keyCode == 32)) // Blank
    {
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}
/*	
    function ����Ѻ����繵���ѡ��������
    ������ҧ����觤�� 
    onKeypress="NoneThaiAlphaValue(event)"
*/
function NoneThaiAlphaValue(event){
    if((event.keyCode >= 3585 && event.keyCode <= 3630) // �-�
        || (event.keyCode >= 3632 && event.keyCode <= 3642) // ���
        || (event.keyCode >= 3648 && event.keyCode <= 3662) // ���
        || (event.keyCode >= 3664 && event.keyCode <= 3670)) // �-�
    {
        event.returnValue = false; 
    }else{
        event.returnValue = true;
    }
}
/*	
    function ����Ѻ����繵���Ţ��ҹ�� 1-9 ������ 0
    ������ҧ����觤�� 
    onKeypress="NumericValueNonZero(event)"
*/
function NumericValueNonZero(event){
    if((event.keyCode >= 49 && event.keyCode <= 57) // 1-9
        || (event.keyCode == 8)) // Tab
      //  || (event.keyCode == 46)) // .
    {
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

/*	
    function ����Ѻ����繵���Ţ��ҹ��
    ������ҧ����觤�� 
    onKeypress="NumericValue(event)"
*/
function NumericValue(event){
    if((event.keyCode >= 48 && event.keyCode <= 57) // 0-9
        || (event.keyCode == 8)) // Tab
      //  || (event.keyCode == 46)) // .
    {
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}
/*	
    function ����Ѻ����繵���Ţ��ҹ��
    ������ҧ����觤�� 
    onKeypress="NumericValue09(event)"
*/
function NumericValue09(event){
    if((event.keyCode >= 48 && (event.keyCode <= 57) // 0-9
        || (event.keyCode == 8)) // Tab
        || (event.keyCode == 46)) // .
    {
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

/*	
    function ����Ѻ����繵���Ţ��ҹ��
    ������ش�ȹ�������§��ش����
    ������ҧ����觤�� 
    onKeypress="NumericValue1(event, obj)"
*/
function NumericValue1(event,obj){
    if((event.keyCode > 47 &&  event.keyCode < 58)|| (event.keyCode == 8)  || (event.keyCode == 46)){
        if (event.keyCode == 46) {
            if (obj.value.indexOf('.') == -1)
                event.returnValue = true;
            else
                event.returnValue = false;
        } 
    }else{
        event.returnValue = false;
    }
}
/*�Ҩش�ȹ���㹤�ҷ������*/
function CheckPoint(obj){
    var count = 0;
    for(var i = 0 ; i < obj.value.length;i++){
        if((obj.value.charAt(i))=='.'){
        count++;
        }  
      }
      if(count < 2){
      return true ;
      }else{
      alert('�ըش�ȹ����ҡ���� 1 �ش ��سҵ�Ǩ�ͺ������');
      return false ;
      }
}

/*	
    function ����Ѻ����繵���Ţ��ҹ�� ����ըش ������Ѻ���������������ɳ���
    ������ҧ����觤�� 
    onKeypress="NumOnlyValue(event)"
*/
function NumOnlyValue(event){
    //alert(event.keyCode);
    if((event.keyCode > 47 && event.keyCode < 58) || (event.keyCode == 8)){
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

/*	
    function ����Ѻ����繵���Ţ 1 ��ҹ��
    ������ҧ����觤�� 
    onKeypress="NumericValueOne(event)"
*/
function NumericValueOne(event){
    if(event.keyCode == 49){
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

/* ������¹��� �� float  �Ѻ����� object */
function parseFloatObj(obj) {
    var value = obj.value.replace(/,/g, "");
    value = TrimValue(value);

    return (value == "")?0:parseFloat(value);
}

/* ������¹��� �� float  �Ѻ����� value */
function parseFloatVal(value) {
    value = value.replace(/,/g, "");
    value = TrimValue(value);
    return (value == "")?0:parseFloat(value);
}

/* ������¹��� �� float  �Ѻ����� object */
function parseDoubleObj(obj) {
    var value = obj.value.replace(/,/g, "");
    value = TrimValue(value);

    return (value == "")?0.0:parseFloat(value);
}

/* ������¹��� �� float  �Ѻ����� value */
function parseDoubleVal(value) {
    value = value.replace(/,/g, "");
    value = TrimValue(value);
    return (value == "")?0.0:parseFloat(value);
}

/*
    ��㹡�õѴ Comma ������ӡ�� SetFocus OR Setselect
    Update By Prasert (���繨�ԧ�Ф�Ѻ) 07/09/2006
*/
function PreEditNumcomma( obj ){
    obj.value = obj.value.replace( /,/g, "" );
}

// Number Manage Function by Sumate
// 04/09/2549

function preEditNumObj(obj) {
    obj.value = preEditNumVal(obj.value);
    obj.select();
}

function preEditNumVal(value) {
    if(typeof value == "undefined" || value == ""){//add by inging change to this 29/06/2559 because get an error when undefined or empty
        return "0";
    }else{
        value = (value.toString()).replace( /,/g, "" );//add .toString fix case value is Number (Only String can user replace function) inging 01/07/2559
        return value;
    }
    
}

/**
 * ��Ǩ�ͺ�ٻẺ����Ţ�ӹǹ�����зȹ��� �����仵������ͧ���
 * @param : obj
 * @param : length	(�ӹǹ��ѡ�ͧ�Ţ������)
 * @param : scale	(�ӹǹ��ѡ�ͧ�Ţ�ȹ���)
 * @return : none
 * @sample : onBlur="validNumFormat(this, length, scale)"
 */
function validNumFormat(obj, length, scale) {
    obj.value=obj.value.replace(/,/g, "");

    if (obj.value=="" || obj.value=="." || isNaN(parseInt(obj.value))) { obj.value=""; return; }
    if (obj.value.split('.').length>2) { obj.value=""; return; }
    var intValue = ""+parseInt(obj.value, 10);
    if (length==undefined || scale==undefined) {
        alert("invalid INTEGER NUMBER or DECIMAL NUMBER, plz check your function again.");
        obj.value=""; return;
    }
    if (intValue.length > (length-scale)) { 
        alert("Integer Out of Length");
        obj.value=""; return;
    }

    if (scale>0) {
        postEditNumObj(obj, length, scale);
    } else {
        obj.value=parseInt(obj.value, 10);
        setFormatNumObj(obj, 0);
    }
    return;
}
/**
 * ��Ѵ�ȹ��� �����Ѵ���
 * @param :value (��� value)
 * @param :digit (�ӹǹ�ȹ�������ͧ���)
 * @sample :cutDecimal(2081.625,2) --> 2081.62
*/
function cutDecimal(value,digit){
var numValue=value+"";
 if (numValue.indexOf('.') == -1){
  return value+".00";
  }else{
  var c=numValue.indexOf('.');
    numValue=numValue.substr(0,c)+"."+numValue.substr((parseInt(c)+1),parseInt(digit));
    return numValue;
  }
}

/**
 * �Ѵ����ٻẺ����Ţ�ӹǹ�Թ���������ٻẺ����˹�
 * @param : object
 * @param : length	(�ӹǹ��ѡ�ͧ�Ţ������)
 * @param : scale	(�ӹǹ��ѡ�ͧ�Ţ�ȹ���)
 * @return : true
 * @sample : postEditNumObj(this, length, scale)
 */
function postEditNumObj(obj, length, scale) {
    obj.value = postEditNumVal(obj.value, length, scale);
    return true;
}
function postEditNumVal(value, length, scale){
//if(!isNaN(value)){
    var  intPat = /^[0-9]+$/;
    var  realPat = /^[0-9]+\.[0-9]{1,2}$/;
    var  realPat2 = /^\.[0-9]{1,2}$/;
    var  realPat3 = /^[0-9]+\.$/;

    switch (scale) {
        case 1 :
                realPat = /^[0-9]+\.[0-9]{1,1}$/;
                realPat2 = /^\.[0-9]{1,1}$/;	
                break;
        case 3 :
                realPat = /^[0-9]+\.[0-9]{1,3}$/;
                realPat2 = /^\.[0-9]{1,3}$/;	
                break;
        case 4 :
                realPat = /^[0-9]+\.[0-9]{1,4}$/;
                realPat2 = /^\.[0-9]{1,4}$/;	
                break;
    }

    if (value == "")
        return "";  //$umate Edit 31/10/49
    if ( realPat3.test( value ) == true ) {	        //����ٻẺ #.
        for (var i=1; i<=scale; i++)
            value += "0";
    } 
    if ( realPat2.test( value ) == true )	{	//����ٻẺ .#
        value = "0" + value;
    }
    if ( realPat.test( value ) == false ) {		//�������ٻẺ����ó� #.#
        if ( intPat.test( value ) == false ) {	//�������ٻẺ�ӹǹ��� #
            if( value == ".")
                value = "";
            else {
                value = "0" + value;
                value = roundUpNumVal(value, scale);
            }
        } else {						//����ٻẺ�ӹǹ��� #
            value += ".";
            for (var i=1; i<=scale; i++)
                value += "0";
        }
    }

    return setFormatNumVal(value, scale);
//    }else{
//    alert("��سҡ�͡੾�е���Ţ��ҹ��");
//    return "";
//    }
   
}

/**
 * ��Ѵ��ɷȹ���(�Ѵ��ɢ��)
 * @param : value
 * @param : scale	(�ӹǹ��ѡ�ͧ�Ţ�ȹ���)
 * @return : value
 * @sample : roundUpNumVal(obj.value, scale)
 */
function roundUpNumVal(value, scale) {
    value+="";
    var nine="";
    for (var i=1; i<=scale; i++)
        nine += "9";
    var ten="1";
    for (var i=1; i<=scale; i++)
        ten += "0";
            
    //$umate Edit 31/10/49
    if (value.indexOf('.')<0)
        return value;
    if (value.indexOf('.')==0)
        value = "0"+value;
    if (value.indexOf('.')==value.length-1)
        value = value+"0";                

    var  extPat = /^([0-9]+)\.(.*)/;
    extPat.exec(value);
    var str = new String(RegExp.$2);
    var newStr = new String(RegExp.$1);

    if (str.length > scale) {	//�óըӹǹ�ȹ������ѹ�֡�ҡ���ҷ���˹�
        var str1 = str.substring(scale, scale+1);

        if (str1 >= "5") {	//�óշȹ�����ѡ����Թ����á�դ���ҡ���� 5 �зӡ�ûѴ��ɢ��
            var str2 = str.substring(0,scale);
            var decSum = parseInt(str2, 10) + 1;

            if (decSum > parseInt(nine, 10)) {	//�ó�����ͻѴ������� ��ͧ����Ң����繨ӹǹ���
                    newStr = "" + (parseInt(newStr, 10) + 1);
                    decSum = decSum - parseInt(ten, 10);
            }
            var decSum1 = ""+decSum;
            var zeroNum = scale-decSum1.length;
            str1 = "0.";
            for (var i=1; i<=zeroNum; i++)
                    str1 += "0";
            str1 += decSum1;
        } else {	//�óշȹ�����ѡ����Թ����á�դ�ҹ��¡��� 5 �зӡ�ûѴ��ɷ��
            str1 = "0." + str.substring(0, scale);
        }
        var tmp = str1.substring(1);

        return newStr+tmp;
    } else {
        return value;
    }
}

/**
 * ��Ѵ��ɷȹ���(�Ѵ��ɷ��)
 * @param : value
 * @param : scale	(�ӹǹ��ѡ�ͧ�Ţ�ȹ���)
 * @return : value
 * @sample : roundUpNumVal(obj.value, scale)
 */
 //Add by Pat @20/01/2553
function roundDownNumVal(value, scale) {
    value+="";
    var nine="";
    for (var i=1; i<=scale; i++)
        nine += "9";
    var ten="1";
    for (var i=1; i<=scale; i++)
        ten += "0";
            
    if (value.indexOf('.')<0)
        return value;
    if (value.indexOf('.')==0)
        value = "0"+value;
    if (value.indexOf('.')==value.length-1)
        value = value+"0";                

    var  extPat = /^([0-9]+)\.(.*)/;
    extPat.exec(value);
    var str = new String(RegExp.$2);
    var newStr = new String(RegExp.$1);

    if (str.length > scale) {	//�óըӹǹ�ȹ������ѹ�֡�ҡ���ҷ���˹�
        var str1 = str.substring(scale, scale+1);
        
        str1 = "0." + str.substring(0, scale);
        var tmp = str1.substring(1);

        return newStr+tmp;
    } else {
        return value;
    }
}

function setFormatNumObj(obj, scale) {
    obj.value = setFormatNumVal(obj.value, scale);
    return;
}
function setFormatNumVal(value, scale) {
    if (value == '') { 
        value = value.replace( /,/g, "" );
        return value;
    }
    value = value.replace( /,/g, "" );

    if (value.indexOf('.')<0 && scale>0) {
        value += ".";
    }

    var  extPat = /^([0-9]+)\.(.*)/;
    extPat.exec( value );
    var intPart = new String( RegExp.$1 );
    var decPart = new String( RegExp.$2 );

    if (scale==0) {
        intPart = value;
        decPart = "";
    } else {
        while ( decPart.length < scale ) {
            decPart += "0";
        }
        decPart = "." + decPart;
    }

    intPart = "" + parseFloat(intPart);
    var intPartLen = intPart.length;

    if ( ( prefix = intPartLen % 3 ) == 0 )
        prefix = 3;
    var newValue = intPart.substring( 0, prefix );
    for ( intPartLen -= prefix; intPartLen > 0; intPartLen -= 3 ) {
        newValue += "," + intPart.substring( prefix, prefix + 3 );
        prefix += 3;
    }
    value = newValue + decPart;

    return value;
}

/**
 * �������Ţ�ӹǹ�Թ
 * @param : obj
 * @param : length	(�ӹǹ��ѡ�ͧ�Ţ������)
 * @param : scale		(�ӹǹ��ѡ�ͧ�Ţ�ȹ���)
 * @return : none
 * @sample : onKeypress="keyFloatNumber(this, length, scale)"
 */
function keyFloatNumber(obj, length, scale) {
    if ((event.keyCode > 47) && (event.keyCode < 58)|| (event.keyCode == 8)  || (event.keyCode == 46)) {
        if (event.keyCode == 46) {
            if (obj.value.indexOf('.') == -1)
                event.returnValue = true;
            else
                event.returnValue = false;
        } else {
            if (obj.value.length==(length-scale)) {
                if (obj.value.indexOf('.')<0) {
                    event.returnValue = false;
                } else {
                    event.returnValue = true;
                }
            } else
                event.returnValue = true;
        }
    } else {
        event.returnValue = false;
    }
}

/**
 * ������੾�е���Ţ��ҹ��
 * @return : none
 * @sample : onKeyPress="keyIntNumber();"
 */
function keyIntNumber(event){
    if((event.keyCode > 47) && (event.keyCode < 58) || (event.keyCode == 8)){
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

// Number Manage Function by Sumate
// 04/09/2549

///////////////////////////////////////////////       DateLib.js      /////////////////////////////////////////////////////////
/* ���Ǩ�ͺ field ����繤����͹ �ó����Ţ������� ������ 0 ��˹����͹���*/
function blurMonth(obj) {
    if (obj.value.length==1) {
        obj.value = "0"+obj.value;
    }
}
/*
    function ��Ǩ�ͺ��� ��͹���շ��ѹ�֡�դ�ҵ���� 01 �֧ 12 �������
    input ������ٻẺ mm (��͹����)
*/
function isValidTaxMonth(obj) {
    var msg = "";
    if (obj.value.length != 0) {	
        if (!(obj.value > 0 && obj.value < 13)) {
            msg = "��͹���ѹ�֡ �е�ͧ�դ�ҵ������͹ 1-12 ��ҹ��";
            obj.value = "";
            alert(msg);
            obj.focus();
            event.returnValue = false;
            return false;
        }
    }
    return true;
}

/* �礤����١��ͧ��͹ 
    ������ҧ
    onkeydown="checkTaxMon(this.form,this);"  
*/
function checkTaxMon(form, obj){
    if (event.keyCode == 13 || event.keyCode == 9 || event.keyCode==38){
        if (isValidTaxMonth(obj)){
            down(form,obj);
        }
    }
}
 
  /*
    function ��Ǩ�ͺ��� �繻է�����ҳ ᷹��������ѧ�ҡ�� �.�. 2500
	����Թ��͹�ѹ��¹ �������ö�ѹ�֡�նѴ���
    input ������ٻẺ yyyy (������)
*/
function isValidBudgetYear(obj) {
    var msg = "";
    var syear = "";
	var sMonth = "";
    var dates = new Date();
    dates = servDate;		//Sumate@28/3/48
    syear = dates.getFullYear() + 543; //�� getFullYear ᷹ getYear ����Ѻ IE11 09/06/2558 (Phatcharaphon)
//    syear = dates.getYear() + 543;
	sMonth = dates.getMonth();
    if (obj.value.length != 0) {	
        if (obj.value < 2500) {
            msg = "�շ��ѹ�֡ ��ͧ��ҡѺ�����ҡ���� �.�. 2500  �繵��";
            obj.value = "";
            alert(msg);
            obj.focus();
            event.returnValue = false;
            return false;
        }else if (obj.value > syear){
			if(sMonth >= 9){
				 if (obj.value > syear+1){
					 //msg = "������ ��ͧ�դ�ҹ��¡���������ҡѺ �ջѨ�غѹ";
					msg = "�շ��ѹ�֡ �е�ͧ���¡���������ҡѺ�է�����ҳ"; // Naja Edit
					obj.value = "";
					alert(msg);
					obj.focus();
					event.returnValue = false;
					return false;
				}
			}else{
				//msg = "������ ��ͧ�դ�ҹ��¡���������ҡѺ �ջѨ�غѹ";
				msg = "�շ��ѹ�֡ �е�ͧ���¡���������ҡѺ�ջѨ�غѹ"; // Oak Edit
				obj.value = "";
				alert(msg);
				obj.focus();
				event.returnValue = false;
				return false;
			}
		}
	}
    return true;
}

/*
    function ��Ǩ�ͺ��� �繻�������ѧ�ҡ�� �.�. 2500
    input ������ٻẺ yyyy (������)
*/
function isValidTaxYear(obj) {
    var msg = "";
    var syear = "";
    var dates = new Date();
    dates = servDate;		//Sumate@28/3/48
    syear = dates.getFullYear() + 543; //�� getFullYear ᷹ getYear ����Ѻ IE11 09/06/2558 (Phatcharaphon)
//    syear = dates.getYear() + 543;
    if (obj.value.length != 0) {	
        if (obj.value < 2500) {
            msg = "�շ��ѹ�֡ ��ͧ��ҡѺ�����ҡ���� �.�. 2500  �繵��";
            obj.value = "";
            alert(msg);
            obj.focus();
            event.returnValue = false;
            return false;
        }else if (obj.value > syear){
            //msg = "������ ��ͧ�դ�ҹ��¡���������ҡѺ �ջѨ�غѹ";
            msg = "�շ��ѹ�֡ �е�ͧ���¡���������ҡѺ�ջѨ�غѹ"; // Oak Edit
            obj.value = "";
            alert(msg);
            obj.focus();
            event.returnValue = false;
            return false;
        }
    }
    return true;
}

/*
    function ��Ǩ�ͺ��� ��͹/�����շ������Թ��͹/�����ջѨ�غѹ
    input ��Ƿ�� 1 ������ٻẺ mm (��͹����)
    input ��Ƿ�� 2 ������ٻẺ yyyy (������)
    ������ҧ
    onblur="isBeforeCurrentTaxYear(fldMon, fldYear);"
*/
function isBeforeCurrentTaxYear(obj1, obj2) {
    var msg = "";
    if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)){
        msg = "�ô�ѹ�֡ ��͹����";
        alert(msg);
        event.returnValue = false;
        obj1.focus();
        return false;
    }else if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)){
        msg = "�ô�ѹ�֡ ������";
        alert(msg);
        event.returnValue = false;
        obj2.focus();
        return false;
    }else{
        if (isValidTaxMonth(obj1) && isValidTaxYear(obj2)){
            var today = new Date();
            today = servDate;	//Sumate@28/3/48

            var dateEntry = new Date((obj2.value - 543), (obj1.value - 1), 1);
            if (dateEntry > today){
                    //msg = "��͹/������ ��ͧ����Թ��͹/�����ջѨ�غѹ";
                    obj1.value = "";
                    obj2.value = "";
                    alert("��͹/�����շ��ѹ�֡�е�ͧ���¡�����͹/������ � �ѹ���Ѩ�غѹ");
                    obj1.focus();
                    event.returnValue = false;
                    return false;
            }
        }else
            return false;
    }
    return true;
}

/*
    function ��Ǩ�ͺ��� ��͹/������ �Թ��͹/�ջѨ�غѹ��
    input ��Ƿ�� 1 ������ٻẺ mm (��͹����)
    input ��Ƿ�� 2 ������ٻẺ yyyy (������)
*/
function isCurrentTaxYear(obj1, obj2) {
    var msg = "";
    if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)){
        msg = "�ô�ѹ�֡ ��͹����";
        alert(msg);
        event.returnValue = false;
        obj1.focus();
        return false;
    }else if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)){
        msg = "�ô�ѹ�֡ ������";
        alert(msg);
        event.returnValue = false;
        obj2.focus();
        return false;
    }else{
        isValidTaxMonth(obj1);
        isValidTaxYear(obj2);
    }
    return true;
}

/*
    function ����ٻẺ���Ѻ�ѹ���ҡ "ddmmyyyy" �� "dd/mm/yyyy"
    input ������ٻẺ ddmmyyyy
*/
function dateFormat(obj) {
    if (obj.value.length == 8) {
        obj.value = obj.value.substring(0,2) + "/" + obj.value.substring(2,4) + "/" + obj.value.substring(4,8);
    }
}

/*
    function ��Ǩ�ͺ��� ���ѹ������ջ�ԷԹ
    input ������ٻẺ dd/mm/yyyy
*/
function isValidDateThai(obj) {
    var msg = "";
    if (obj.value.length == 10) {
        var strDate = obj.value.substring(0,2);
        var strMonth = obj.value.substring(3,5) - 1;
        var dateEntry = new Date((obj.value.substring(6,10) - 543), (obj.value.substring(3,5) - 1), obj.value.substring(0,2));
        if (strDate == dateEntry.getDate() && strMonth == dateEntry.getMonth()) {
            return true;
        } 
    }
    return false;
}
/*
    function ��Ǩ�ͺ��� ���ѹ�����ѧ�ѹ��� 01/01/2535
    input ������ٻẺ dd/mm/yyyy
*/
function isAfter2535(obj) {
    var msg = "";
    if (obj.value.length == 10) {
        var date = new Date("1907/01/01");
        var dateEntry = new Date((obj.value.substring(6,10) - 543), (obj.value.substring(3,5) - 1), obj.value.substring(0,2));
        if (date <= dateEntry) {
            return true;
        } 
    }
    return false;
}

/*
    function ��Ǩ�ͺ��� ���ѹ���������Թ�ѹ���Ѩ�غѹ
    input ������ٻẺ dd/mm/yyyy
*/
function isBeforeToday(obj) {
    var msg = "";
    if (obj.value.length == 10) {
        var today = new Date();
        today = servDate;	

        var dateEntry = new Date((obj.value.substring(6,10) - 543), (obj.value.substring(3,5) - 1), obj.value.substring(0,2));
        if (today >= dateEntry) {
            return true;
        } 
    }
    return false;
}

/*
    function ��Ǩ�ͺ�����١��ͧ����ǡѺ�ѹ���
    1. ��ͧ��͹�ú 8 ���
    2. ��ͧ�١��ͧ����ջ�ԷԹ
    3. ��ͧ������鹵�����ѹ��� 01/01/2535 �繵��
    4. ��ͧ����Թ�ѹ���Ѩ�غѹ
    input ������ٻẺ ddmmyyyy ���� dd/mm/yyyy
    ������ҧ
    onBlur="checkDate(this);"
*/
function checkDate(obj) {
    var msg = "";
    if (obj.value.length != 0) {	
        dateFormat(obj);
        if (obj.value.length != 10) {
//            msg = "�ô�ѹ�֡�繵���Ţ 8 ��ѡ"; ///E0024
            obj.value = "";
            alert(showMsg(E0024));
            obj.focus();
            return false;
        } else if (!isValidDateThai(obj)) {
//            msg = "����ѹ������١��ͧ �ô���������";//E0022
            obj.value = "";
            alert(showMsg(E0022));
            obj.focus();
            return false;
        } else if (!isValidYear(obj.value)) {
            obj.value = "";
            alert(showMsg(E0021));
            obj.focus();
            return false;
//        } else if (!isAfter2535(obj)) {
////                msg = "�դ���觡����þ���Ե ��ͧ�դ�ҵ����� 2535 �繵��";//E0021
//                obj.value = "";
//                alert(showMsg(E0021));
//                obj.focus();
//                return false;
        } else if (!isBeforeToday(obj)) {
//            msg = "�ѹ�����ѹ�֡��ͧ���¡���������ҡѺ�ѹ�����к�";//E0026
            obj.value = "";
            alert(showMsg(E0026));
            obj.focus();
            return false;
        }
    }
    return true;
}

/***************************  ��Ѻ �� �.�. *************************/
function isValidDateEng(obj){
    var msg = "";
    if (obj.value.length == 10) {
        var strDate = obj.value.substring(0,2);
        var strMonth = obj.value.substring(3,5) - 1;
        var dateEntry = new Date((obj.value.substring(6,10)), (obj.value.substring(3,5) - 1), obj.value.substring(0,2));
        if (strDate == dateEntry.getDate() && strMonth == dateEntry.getMonth()) {
            return true;
        } 
    }
    return false;
}
/*
    function ��Ǩ�ͺ��� ���ѹ���������Թ�ѹ���Ѩ�غѹ
    input ������ٻẺ dd/mm/yyyy
*/
function isBeforeTodayEng(obj) {
    var msg = "";
    if (obj.value.length == 10) {
        var today = new Date();
        today = servDate;	

        var dateEntry = new Date((obj.value.substring(6,10)), (obj.value.substring(3,5) - 1), obj.value.substring(0,2));
        if (today >= dateEntry) {
            return true;
        } 
    }
    return false;
}

/*
    function ��Ǩ�ͺ�����١��ͧ����ǡѺ�ѹ���
    1. ��ͧ��͹�ú 8 ���
    2. ��ͧ�١��ͧ����ջ�ԷԹ
    3. ��ͧ������鹵�����ѹ��� 01/01/2535 �繵��
    4. ��ͧ����Թ�ѹ���Ѩ�غѹ
    input ������ٻẺ ddmmyyyy ���� dd/mm/yyyy
    ������ҧ
    onBlur="checkDate(this);"
*/
function checkDateEng(obj) {
    var msg = "";
    if (obj.value.length != 0) {	
        dateFormat(obj);
        if (obj.value.length != 10) {
            msg = "�ô�ѹ�֡�繵���Ţ 8 ��ѡ"; 
//            msg = showMessage(E0006);
        } else if (!isValidDateEng(obj)) {
            msg = "����ѹ������١��ͧ �ô���������";
//            msg = showMessage(E0007);
        } else if (!isBeforeTodayEng(obj)) {
            msg = "�ѹ�����ѹ�֡��ͧ���¡���������ҡѺ�ѹ�����к�";
//            msg = showMessage(E0008);
        }
    }
    if (msg.length != 0) {
            obj.value = "";
            alert(msg);
            obj.focus();
            return false;
    }
    return true;
}

/*
    function ��Ǩ�ͺ�����١��ͧ����ǡѺ�ѹ���
    1. ��ͧ��͹�ú 8 ���
    2. ��ͧ�١��ͧ����ջ�ԷԹ
    3. �Թ�ѹ���Ѩ�غѹ��
    input ������ٻẺ ddmmyyyy ���� dd/mm/yyyy
*/
function checkDateW(obj) {
    var msg = "";
    if (obj.value.length != 0) {	
        dateFormat(obj);
        if (obj.value.length != 10) {
//            msg = "�ô�ѹ�֡�繵���Ţ 8 ��ѡ"; ///E0024
            obj.value = "";
            alert(showMsg(E0024));
            obj.focus();
            return false;
        } else if (!isValidDateThai(obj)) {
//            msg = "����ѹ������١��ͧ �ô���������";//E0022
            obj.value = "";
            alert(showMsg(E0022));
            obj.focus();
            return false;
        } else if (!isValidYear(obj.value)) {
            obj.value = "";
            alert(showMsg(E0021));
            obj.focus();
            return false;
        }
    }
    return true;
}

/*
	function ��Ǩ�ͺ����ѹ���������鹵�ͧ���¡����ѹ�������ش
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
*/
function compareDateNoWE(obj1, obj2) {
	var msg = "";
	if (obj2.value==""){
	}else{
		if (checkDateDigit(obj2)) {
			addDateFormat(obj2);
			var data1 = obj1.value.substring(6)+obj1.value.substring(3,5)+obj1.value.substring(0,2);
			var data2 = obj2.value.substring(6)+obj2.value.substring(3,5)+obj2.value.substring(0,2);
//			alert( 'data1 = ' + data1 + ' data2 = ' + data2 );
			if (data1> data2) 	{
				msg = "�ѹ�����ѹ�֡ ��ͧ�����¡����ѹ����������";
			}
			if (msg.length != 0) {
				obj2.value = "";
				alert(msg);
				obj2.focus();
				return false;
			}
		}else{
			obj2.value="";
			obj2.focus();
			return false;
		}
	}
}

/*
	function ��Ǩ�ͺ����ѹ���������鹵�ͧ���¡����ѹ�������ش	<< �Թ�ѹ���Ѩ�غѹ�� >>
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
	errMsg ��� errMsg ����ͧ����ʴ�
	������ҧ
	onBlur="compareDate3(obj1, obj2, errMsg)"
*/
function compareDate3(obj1, obj2, errMsg) {
    var msg = "";
    if ((TrimValue(obj1.value).length == 0) || (TrimValue(obj2.value).length == 0)) {
        return true;
    } else if (checkDateW(obj1) && checkDateW(obj2)) {
        var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
        var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
        if (beginDate > endDate) 	{
            if(errMsg == undefined) {
                msg = "";
                return false;
            } else {
                msg = showMsg(errMsg);
            }
        }
        if (msg.length != 0) {
            obj2.value = "";
            alert(msg);
            obj2.focus();
            return false;
        }
        return true;
    }
}

/*
	function ��Ǩ�ͺ����ѹ���������鹵�ͧ���¡����ѹ�������ش �ѹ����ͧ����Թ�ѹ���Ѩ�غѹ
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
	errMsg ��� message ����ͧ����ʴ�
	������ҧ
	onBlur="compareDate4(obj1, obj2, errMsg)"
*/
function compareDate4(obj1, obj2) {
    var msg = "";
    if(obj1.value != "" && obj2.value != ""){
        if (checkDate(obj1) && checkDate(obj2)) {
            var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
            var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
            if (beginDate > endDate) 	{
                obj2.value = "";
                alert(showMsg(E0002));
                obj2.focus();
                return false;
            }
            return true;
	}
    }	
}


/*
	function ��Ǩ�ͺ����ѹ���������鹵�ͧ���¡����ѹ�������ش �ѹ����ͧ����Թ�ѹ���Ѩ�غѹ
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
	errMsg ��� message ����ͧ����ʴ�
	������ҧ
	onBlur="compareDate(obj1, obj2, errMsg)"
*/
function compareDate(obj1, obj2, errMsg) {
	var msg = "";
	if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)) {
		msg = "�ô�ѹ�֡ �ѹ�������ش";
		alert(msg);
		obj2.focus();
		return false;
	} else if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)) {
		msg = "�ô�ѹ�֡ �ѹ����������";
		alert(msg);
		obj2.value = "";
		obj1.focus();
		return false;
	} else if (checkDate(obj1) && checkDate(obj2)) {
		var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
		var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
		if (beginDate >= endDate) 	{
			if( errMsg == undefined)
				msg = "2#undefined";
			else
				msg = errMsg;
		}               
		if (msg.length != 0) {
			obj2.value = "";
			alert(showMessage(msg));
			obj2.focus();
			return false;
		}
		return true;
	}
}

/*
	function ��Ǩ�ͺ����ѹ���������鹵�ͧ���¡����ѹ�������ش	<< �Թ�ѹ���Ѩ�غѹ�� >>
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
	errMsg ��� message ����ͧ����ʴ�
	������ҧ
	onBlur="compareDateW(obj1, obj2, errMsg)"
*/
function compareDateW(obj1, obj2, errMsg) {

	var msg = "";
	if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)) {
			msg = "�ô�ѹ�֡ �ѹ�������ش";
			alert(msg);
			obj2.focus();
			return false;
	} else if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)) {
			msg = "�ô�ѹ�֡ �ѹ����������";
			alert(msg);
			obj1.focus();
			return false;
	} else if (checkDateW(obj1) && checkDateW(obj2)) {
		var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
		var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
		if (beginDate >= endDate) 	{
			if( errMsg == undefined)
				msg = "�ѹ���������鹵�ͧ���¡����ѹ�������ش";
			else
				msg = errMsg;
		}
		if (msg.length != 0) {
			obj2.value = "";
			alert(msg);
			obj2.focus();
			return false;
		}
		return true;
	}
}

/*
	function ��Ǩ�ͺ����ѹ���������鹵�ͧ���¡���������ҡѺ�ѹ�������ش	<< �Թ�ѹ���Ѩ�غѹ�� >>
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
	errMsg ��� message ����ͧ����ʴ�
	������ҧ
	onBlur="compareDate2(obj1, obj2, errMsg)"
*/
function compareDate2(obj1, obj2, errMsg) {
	var msg = "";
	if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)) {
			msg = "�ô�ѹ�֡ �ѹ�������ش";
			alert(msg);
			obj2.focus();
			return false;
	} else if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)) {
			msg = "�ô�ѹ�֡ �ѹ����������";
			alert(msg);
			obj1.focus();
			return false;
	} else if (checkDateW(obj1) && checkDateW(obj2)) {
		var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
		var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
		if (beginDate > endDate) 	{
			if( errMsg == undefined)
				msg = "�ѹ���������鹵�ͧ���¡���������ҡѺ�ѹ�������ش";
			else
				msg = errMsg;
		}
		if (msg.length != 0) {
			obj1.value = "";
			alert(msg);
			obj1.focus();
			return false;
		}
		return true;
	}
}


/*
	function ��Ǩ�ͺ����ѹ���������鹵�ͧ���¡���������ҡѺ�ѹ�������ش �ѹ����ͧ����Թ�ѹ���Ѩ�غѹ
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
	errMsg ��� message ����ͧ����ʴ�
	������ҧ
	onBlur="compareDate(obj1, obj2, errMsg)"
*/
function compareDateE(obj1, obj2, errMsg) {
	var msg = "";
	if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)) {
		msg = "�ô�ѹ�֡ �ѹ�������ش";
		alert(msg);
		obj2.focus();
		return false;
	} else if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)) {
		msg = "�ô�ѹ�֡ �ѹ����������";
		alert(msg);
		obj2.value = "";
		obj1.focus();
		return false;
	} else if (checkDate(obj1) && checkDate(obj2)) {
		var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
		var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
		if (beginDate > endDate) 	{
			if( errMsg == undefined)
				msg = "�ѹ���������鹵�ͧ���¡���������ҡѺ�ѹ�������ش";
			else
				msg = errMsg;
		}
		if (msg.length != 0) {
			obj2.value = "";
			alert(msg);
			obj2.focus();
			return false;
		}
		return true;
	}
}

/*
	function ��Ǩ�ͺ����ѹ���������鹵�ͧ���¡���������ҡѺ�ѹ�������ش �ѹ����ͧ����Թ�ѹ���Ѩ�غѹ �µ�ͧ���ѹ���ú��� 2 ��Ҩ֧�е�Ǩ�ͺ
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
	errMsg ��� message ����ͧ����ʴ�
	������ҧ
	onBlur="compareDateE_2(obj1, obj2, errMsg)"
*/
function compareDateE_2(obj1, obj2, errMsg) {
	var msg = "";
        if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)) {
            checkDate(obj1);
	} else if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)) {
            checkDate(obj2);
	}else if((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length != 0)){
            if(checkDate(obj1) && checkDate(obj2)){
                var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
		var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
		if (beginDate > endDate){
                    if(errMsg == undefined){
                        msg = "�ѹ���������鹵�ͧ���¡���������ҡѺ�ѹ�������ش";
                    }else{
                        msg = errMsg;
                    }
		}
		if (msg.length != 0) {
                    obj2.value = "";
                    alert(msg);
                    obj2.focus();
                    return false;
		}
		return true;
            }
        }
}

/*
	function ��Ǩ�ͺ����ѹ���������鹵�ͧ���¡��������ҡѺ�ѹ�������ش	<< �Թ�ѹ���Ѩ�غѹ�� >>
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
	errMsg ��� message ����ͧ����ʴ�
	������ҧ
	onBlur="compareDateW(obj1, obj2, errMsg)"
*/
function compareDateWE(obj1, obj2, errMsg) {

	var msg = "";
	if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)) {
			msg = "�ô�ѹ�֡ �ѹ�������ش";
			alert(msg);
			obj2.focus();
			return false;
	} else if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)) {
			msg = "�ô�ѹ�֡ �ѹ����������";
			alert(msg);
			obj1.focus();
			return false;
	} else if (checkDateW(obj1) && checkDateW(obj2)) {
		var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
		var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
		if (beginDate > endDate) 	{
			if( errMsg == undefined)
				msg = "�ѹ���������鹵�ͧ���¡���������ҡѺ�ѹ�������ش";
			else
				msg = errMsg;
		}
		if (msg.length != 0) {
			obj2.value = "";
			alert(msg);
			obj2.focus();
			return false;
		}
		return true;
	}
}

/*
	function ��Ǩ�ͺ����ѹ��� ������ҧ�ѹ��ͧ�ҡ���� 30 �ѹ
	input ��Ƿ�� 1 ������ٻẺ dd/mm/yyyy
	input ��Ƿ�� 2 ������ٻẺ dd/mm/yyyy
	numDay ��� �ӹǹ�ѹ ����ͧ��äӹǳ
	������ҧ
	onBlur="compareDateW(obj1, obj2, numDay)"
*/
function compareDateNumDay(obj1, obj2, noDay) {
	var msg = "";
	if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)) {
			msg = "�ô�ѹ�֡ �ѹ�������ش";
			alert(msg);
			obj2.focus();
			return false;
	} else if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)) {
			msg = "�ô�ѹ�֡ �ѹ����������";
			alert(msg);
			obj2.value = "";
			obj1.focus();
			return false;
	} else if (checkDateW(obj1) && checkDateW(obj2)) {
		var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
		var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
		if (beginDate > endDate) 	{
			msg = "�ѹ���������鹵�ͧ���¡����ѹ�������ش";
			alert(msg);
			obj2.focus();
			return false;
		}
		var sum = parseInt(endDate)-parseInt(beginDate);
		if (sum!= parseInt(numDay)) {
			msg = "��ǧ���ҷ��ѹ�֡ ��ͧ����Թ "+numDay+" �ѹ �Ѻ������ѹ����������";
		}
		if (msg.length != 0) {
			obj2.value = "";
			alert(msg);
			obj2.focus();
			return false;
		}
		return true;
	}
}

/*
	function ��Ǩ�ͺ��� ��͹/������������� ��ͧ���¡�����͹/����������ش
	input ��Ƿ�� 1 ������ٻẺ mm (��͹�����������)
	input ��Ƿ�� 2 ������ٻẺ yyyy (�������������)
	input ��Ƿ�� 3 ������ٻẺ mm (��͹��������ش)
	input ��Ƿ�� 4 ������ٻẺ yyyy (����������ش)
*/
function compareTaxMonthYear(obj1, obj2, obj3, obj4) {
	var msg = "";
	if (isBeforeCurrentTaxYear(obj1, obj2) && isBeforeCurrentTaxYear(obj3, obj4))
	{
		var date1 = new Date((obj2.value - 543), (obj1.value - 1), 1);
		var date2 = new Date((obj4.value - 543), (obj3.value - 1), 1);
		if (date1 > date2) {
			msg = "��͹/�����շ��ѹ�֡ ��ͧ���¡�����͹/�������������";
			obj3.value = "";
			obj4.value = "";
			alert(msg);
			obj3.focus();
			return false;
		}else
			return true;
	}else
		return false;
}
///////////////////////////////////////////////       RADIO BOTTOM      /////////////////////////////////////////////////////////
// check field ����繷ҧ���͡   //
/* �繿ѧ��ѹ disabled ��������͡ 1 ���ҧ �ա˹�����ҧ ��ͧ disabled 
*/
function disableBoxAtLeast1(t,t1,t2){
	if (t.value=="" && t.value.length==0){
		t.focus();
	}else if(t.value == "1"){
		t1.value = "";
		t1.disabled=true
		t1.style.background='#F0F0F0'
		t2.focus();
	}

	if (event.keyCode == 8 || event.keyCode == 46){
		if(t.value!="1"){
			t1.disabled=false
			t1.style.background='white'
		}
	}
}

/*	 
	�ѧ��������Ѻ��� disable box ��������͡ t ������� disabled  t1 ��� t2  --> by pichai 
	(t2 �������Ѻ t1)
*/
function disableBoxBranch(t,t1,t2,t3,flagColor){
	if (t.value=="" && t.value.length==0){
		t.focus();
	}
	else if(t.value == "1"){
		t1.disabled=true
		t2.disabled=true
		t2.value="";
		t1.style.background='#F0F0F0'
		t2.style.background='#F0F0F0'
		t3.focus();
	}

	if (event.keyCode == 8 || event.keyCode == 46){
		if(t.value!="1")
		{
			t1.disabled=false
			t2.disabled=false
			if(flagColor == undefined){
				t1.style.background='#FFFFD9'
				t2.style.background='#FFFFD9'
			}else{
				t1.style.background='white'
				t2.style.background='white'
			}
		}
	}
}

/*  �繡�� �ʴ� error msg ��ͧ�к����ҧ����ҧ˹�� �� ͹��ѵ� / ���͹��ѵ� �繵�  */
function chooseAtLease1(t,field, m1, m2){
	if (field.value == "" && t.value == ""){
		alert ("�ô���͡ " + m1 + " ���� " + m2 + " ���ҧ���� 1 ��¡��");
		field.focus();
		event.returnValue = false;
		return false;
	}
	return true;
}

/* �繿ѧ��ѹ disabled ��������͡ 1 ���ҧ �ա 2 ���ҧ ��ͧ disabled */
function disableBoxRadio3(t,t1,t2,t3,flagColor){
	if (t.value=="" && t.value.length==0){
		t.focus();
	}
	else if(t.value == "1"){
		t1.value = "";
		t1.disabled=true;
		t1.style.background='#F0F0F0'
		t2.value = "";
		t2.disabled=true;
		t2.style.background='#F0F0F0'
		t3.focus();
	}

	if (event.keyCode == 8 || event.keyCode == 46){
		if(t.value!="1"){
			t1.disabled=false;
			t2.disabled=false;
			if(flagColor == undefined){
				t1.style.background='#FFFFD9'
				t2.style.background='#FFFFD9'
			}else{
				t1.style.background='white'
				t2.style.background='white'
			}
		}
	}
}

/*  �繡�� �ʴ� error sMsg ����� Field �á�ա�� ����� �� Filed 2 ������ */
function chooseMustFill(t,t1,sMsg){
	if (t.value != "" && t1.value == ""){
		alert (sMsg);
		t1.focus();
		//event.returnValue = false;
		return false;
	}
	return true;
}

///////////////////////////////////////////////       TinPinLib.js      /////////////////////////////////////////////////////////
/**
 * ����¹�ٻẺ�ͧ Tin ���������ٻẺ X-XXXX-XXXX-X
 * @param tin String
 * @return a String
 */
function tinFormat(tin){
	var rtnTin="";
	if( tin.length == 10){
		rtnTin = tin.substring(0, 1) + "-" + tin.substring(1, 5) + "-" + tin.substring(5, 9) + "-" + tin.substring(9);
	}else
		rtnTin = tin;
	return rtnTin;
}

/**
 * ����¹�ٻẺ�ͧ Pin ���������ٻẺ X-XXXX-XXXXX-XX-X
 * @param pin String
 * @return a String
 */
function pinFormat(pin) {
	var rtnPin="";
	if( pin.length == 13){
		rtnPin = pin.substring(0, 1) + "-" + pin.substring(1, 5) + "-" + pin.substring(5, 10) + "-" + 
						pin.substring(10, 12) + "-" + pin.substring(12, 13);
	}else
		rtnPin = pin;
	return rtnPin;
}

/*
	function �������¹ format ��ٻẺ�ͧ �Ţ��Шӵ�Ǽ���������� ��� �Ţ��Шӵ�ǻ�ЪҪ�
	������ҧ����觤��
	onKeypress="changeFormatTinPin(this,event)"
*/
function changeFormatTin(formField, e){
	var formTest = (window.Event) ? e.which : e.keyCode;
	if  (formTest == 8){
		formField.value = formField.value.substr(0, (formField.value.length-1))
	}
	if( (formTest > 47) &&  (formTest < 58)|| (event.keyCode > 95) &&  (event.keyCode < 105)){
		if((formField.value.length == 0) && (event.keyCode ==57 || event.keyCode == 48)){
				event.keyCode=0;
		}
		if(formField.value.length == 1){
			formField.value += '-';
		}
		if(formField.value.length == 6)
			formField.value += '-';	

		if(formField.value.length == 11)
			formField.value += '-';	
	}
}

/*
	function �������¹ format ��ٻẺ�ͧ �Ţ��Шӵ�Ǽ���������� ��� �Ţ��Шӵ�ǻ�ЪҪ�
	������ҧ����觤��
	onKeypress="changeFormatTinPin(this,event)"
*/
function changeFormatPin(formField, e){
	var formTest = (window.Event) ? e.which : e.keyCode;
	if  (formTest == 8){
		formField.value = formField.value.substr(0, (formField.value.length-1));
	}
	if( (formTest > 47) &&  (formTest < 58)|| (event.keyCode > 95) &&  (event.keyCode < 105)){
		if((formField.value.length == 0) && (event.keyCode ==57 || event.keyCode == 48)){
				event.keyCode=0;
		}
		if(formField.value.length == 1)
			formField.value += '-';
		if(formField.value.length == 6)
			formField.value += '-';	
		if(formField.value.length == 12)
			formField.value += '-';	
		if(formField.value.length == 15)
			formField.value += '-';	
	}
}

/* function �ӡ�õ�Ǩ�ͺ��Ҥ�ҷ�� key ����ҵ�ͧ�����¡�������
    ��觨л�Сͺ���� field tin, pin, office code, officer code ��� post code
*/
function lessThanDigits(obj,maxlength){
	var field = obj;
	var x = obj.value.length;
	var name = obj.name;
	var msg="";

	if ( checkIsNumber(obj)){
		if(maxlength=="13"){
			msg = "�Ţ��Шӵ�Ǽ�����������ҡèе�ͧ�ѹ�֡�繵���Ţ�ӹǹ 10 ��ѡ";
			//msg = showMessage(E0001);		//E0002
		}else if(maxlength=="17"){
			msg = "�Ţ��Шӵ�ǻ�ЪҪ� �е�ͧ�ѹ�֡�繵���Ţ�ӹǹ 13 ��ѡ";
			//msg = showMessage(E0005);		//E0004
		}else if(maxlength=="8"){
			msg = "�����ӹѡ�ҹ���ѹ�֡���١��ͧ";
			//msg = showMessage(E0013);			//E0048
		}else if(maxlength=="6"){
			msg = "���� �ʡ. �е�ͧ�ѹ�֡�繵���Ţ�ӹǹ 6 ��ѡ";
			//msg = showMessage(E0014);			//E0049
		}else if(maxlength=="5"){
			msg = "������ɳ��� �е�ͧ�ѹ�֡�繵���Ţ�ӹǹ 5 ��ѡ";
			//msg = showMessage(E0016);		//E0068

		}
		if (x < maxlength && x > 0) {
			//field.select();
			obj.value="";
			obj.focus();
			alert(msg ); 
			return false;
		}else{
			if(maxlength == 5){
				if((obj.value == "00000" || (parseInt(obj.value)+"").length<5) && (obj.value!="")){
					alert("�ѹ�֡������ɳ��� ���١��ͧ");
					obj.value="";
					obj.focus();
					return false;
				}
			}
		}
		return true;
	}else
		return false;
}

/* �ӡ���� digit �ͧ tin ��Ҷ١��ͧ��� format ���ͻ���  */
function checkTin(t){
	if (lessThanDigits(t,13)){
		var k = t.value.length;
		var r = 0;
                
                if (t.value == '1-1111-1111-1' || t.value == '2-2222-2222-2' || t.value == '3-3333-3333-3' || t.value == '4-4444-4444-4' || t.value == '5-5555-5555-5'
                    || t.value == '6-6666-6666-6' || t.value == '7-7777-7777-7' || t.value == '8-8888-8888-8' || t.value == '9-9999-9999-9')
                {
			alert("�Ţ��Шӵ�Ǽ�����������ҡ÷��ѹ�֡���١��ͧ") //check diii		--> E0001
			t.value="";
			t.focus();
			return false;                    
                }
                
		if (t.value.charAt(0) == '0' || t.value.charAt(0) == '9'){
			alert("�Ţ��Шӵ�Ǽ�����������ҡ÷��ѹ�֡���١��ͧ�����ѡࡳ��") //check diii		--> E0001
			t.value="";
			t.focus();
			return false;
		}

		if(k>0){
			for(i=0;i<=(k-3);i++){
				if(t.value.charAt(i) != '-')	{
					if((i==3) || (i==0) || (i==5) || (i==8) || (i==10)){
						r = parseInt(r)+parseInt(parseInt(t.value.charAt(i)) * 3);
					}else{
						r = parseInt(r)+parseInt(parseInt(t.value.charAt(i)) * 1);
					}
				}
			}
			var result =(parseInt(10)- parseInt(r%10))%10;
			if(result == t.value.charAt(k-1)){
				return true;
			}else{
				if(t.value.length==13){
					alert("�Ţ��Шӵ�Ǽ�����������ҡ÷��ѹ�֡���١��ͧ�����ѡࡳ��"); //check diii		--> E0001
					t.value="";

					t.focus();
					return false;
				}
			}
		}
	}else{
		return false;
	}
}

/*	 �ӡ���� digit �ͧ pin ��Ҷ١��ͧ��� format ���ͻ���  */
function checkPin(t){
	if (lessThanDigits(t,17)){
		var k = t.value.length;
		var r = 0;
		var j = 13;
		if(k>0){
			for(i=0;i<=(k-3);i++){
				if(t.value.charAt(i) != '-')	{
						r = parseInt(r)+parseInt(parseInt(t.value.charAt(i)) * j);
					--j;
				}
			}
			var result =(parseInt(11)- parseInt(r%11))%10;
			if(result == t.value.charAt(k-1)){
				return true;
			}else{
				if(t.value.length==17){
					alert("�Ţ��Шӵ�ǻ�ЪҪ����ѹ�֡���١��ͧ�����ѡࡳ��");	 //check diii		--> E0003
					t.value="";
					t.focus();
					return false;
				}
			}
		}
		return true;
	}else{
		return false;
	}
}

function isCharacter(s)
{
	var returnString = false;
	for(var i = 0; i < s.length; i++) {
	var c = s.charAt(i);
		if( c != '-'){
			if ((c < '0') || (c > '9')){
				returnString = true;
			}
		}
	}
	return returnString;
}

function checkIsNumber(obj){
	//alert(obj.value);
	if( isCharacter(obj.value) && obj.value!= ""){
		alert("�Ţ��Шӵ�Ǽ�����������ҡèе�ͧ�ѹ�֡�繵���Ţ�ӹǹ 10 ��ѡ");
		obj.value = "";
		obj.disabled = false;
		obj.focus();
		return false;
	}
	return true;
}

///////////////////////////////////////////////       LSKLib.js      /////////////////////////////////////////////////////////
/*
	function ��Ǩ�ͺ�����١��ͧ����ǡѺ�Ţ�ʡ.
	1. ��ͧ��͹�ú 6 ���
	2. ��ͧ�١��ͧ����ʡ.
	3. ��ͧ��˹���� MaxLength �ͧ TextBox �������դ��=6
	4. ������ҧ��õ�Ǩ�ͺ�����١��ͧ
	<input type="text" name="IDNO" id="IDNO" maxlength="6" size="6" 
	  onKeypress="NumericValue(event)" onblur="checkLSK(this)">
*/
function checkLSK(t){
	if (t.value=="")
		return true;
	if (t.value.length!=6){
		alert("���� �ʡ. ���ѹ�֡���١��ͧ�����ѡࡳ��");
		t.value="";
		t.focus();
		return false;
	}

	var p1Val = t.value.substring(0,5);
	var p2Val = t.value.substring(5);

	if(chkDigitLSK(p1Val,t)){
		if(p1Val.length>=5){
			p1Val = p1Val+" ";
			p1Val = p1Val.substring(0, 6);
		}else{
			t.focus();
			return false;
		}
	}else{
		return false;
	}

	var sum = ((parseInt(p1Val.charAt(4))*3)+(parseInt(p1Val.charAt(3))*1)+(parseInt(p1Val.charAt(2))*3)+(parseInt(p1Val.charAt(1))*1)+(parseInt(p1Val.charAt(0))*3));
	var d_7th = 10 - (sum%10);

	if(d_7th==parseInt(p2Val)){
		return true;
	}else{
		alert("���� �ʡ. ���ѹ�֡���١��ͧ�����ѡࡳ��"); //check diii
		t.value="";
		t.focus();
		return false;
	}	
}

function chkDigitLSK(input,t) {
	s = input;
	var i;
	var returnString = "";
	for (i = 0; i < s.length; i++) {  // Search through string and append to unfiltered values to returnString.
		var c = s.charAt(i);
		if( (c<'0') || (c>'9') ){
			alert("���� �ʡ. ���ѹ�֡���١��ͧ�����ѡࡳ��");
			returnString = "";
			t.value = returnString;
			t.focus();
			return false;
		}else{
			returnString += c;
		}
	}
	//t.value = returnString;
	return true;
}

// **********************************************  Time.js  **********************************************//
/*
	function �ٻẺ���� 10:50"
	input ������ٻẺ 1050
	input ������ٻẺ 750 �� 07:50
*/
function TimeFormat(obj) {
		if (obj.value.length == 4) {
			obj.value = obj.value.substring(0,2) + ":" + obj.value.substring(2,4);
		}
}

function delTimeFormat(obj){
		if (obj.value.length == 5) {
			obj.value = obj.value.substring(0,2)+obj.value.substring(3,5);
			obj.select();
		}
}

function checkTime(obj) {
		var msg = "";
		if (obj.value.length != 0) {	
			TimeFormat(obj);
			if (obj.value.length != 5) {
				msg = "�ô�ѹ�֡�繵���Ţ 4 ��ѡ"; 
			} else if (!isValidTime(obj)) {
				msg = "����������١��ͧ �ô���������"; 
			} 
		}
		if (msg.length != 0) {
			obj.value = "";
			alert(msg);
			obj.focus();
			return false;
		}
		return true;
	}

/*
	input ������ٻẺ HH:MM
*/
function isValidTime(obj) {
 	var msg = "";
	if (obj.value.length == 5) {
		var strHour = obj.value.substring(0,2);
		var strMinute = obj.value.substring(3,5);
		if (parseInt(strHour) < 24 && parseInt(strMinute) < 60 ) {
			return true;
		} 
	}
	return false;
}
function compareTime(obj1,obj2){
	var msg = "";
	if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)) {
		msg = "�ô�к���������ش";
		alert(msg);
		obj2.focus();
	} else if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)) {
		msg = "�ô�к������ѹ����������";
		alert(msg);
		obj2.value = "";
		obj1.focus();
	} else if (checkTime(obj1) && checkTime(obj2)) {
		var beginTime =0;
		beginTime = parseInt(obj1.value.substring(3,5)) + parseInt(obj1.value.substring(0,2))*60;
		var endTime = 0;
		endTime = parseInt(obj2.value.substring(3,5)) + parseInt(obj2.value.substring(0,2))*60;

		if (beginTime > endTime) 	{
			msg = "����������鹵�ͧ���¡�����������ش";
		}
		if (msg.length != 0) {
			obj2.value = "";
			alert(msg);
			obj2.focus();
			return false;
		}
		return true;
	}
}


function chkNum(input) {
	s = input.value;
	filteredValues = "1234567890";     // Characters stripped out
//	filteredValues = "~!@#$%^&*()_-=+.<>\\?|/";     // Characters stripped out
	var i;
	var returnString = "";
	for (i = 0; i < s.length; i++) {  // Search through string and append to unfiltered values to returnString.
	var c = s.charAt(i);
		if (filteredValues.indexOf(c) != -1) 
			returnString += c;
		else
			{
				alert('��͹��੾�е���Ţ��ҹ��');
				returnString = "";
				input.value = returnString;
				input.focus();
				return false;
			}
	}
	input.value = returnString;
	return true;
}

function showDoc(showhtml){
	document.formDocumentHelp.action = showhtml;
	document.formDocumentHelp.submit();
}

function toHex(input){
	return input.charCodeAt(0).toString(16);
}

function chgCodePageThai1(data){
	var i = 0;
	var temp="", output="";
	for (i = 0; i < test1.length; i++){
		temp = data.charAt(i);
		temp = toHex(temp);
		output += "%";
		if (temp.length == 3){
			if (temp.substring(0, 2) == "e0"){
				output += "A";
			}else if (temp.substring(0, 2) == "e1"){
				output += "B";
			}else if (temp.substring(0, 2) == "e2"){
				output += "C";
			}else if (temp.substring(0, 2) == "e3"){
				output += "D";
			}else if (temp.substring(0, 2) == "e4"){
				output += "E";
			}else if (temp.substring(0, 2) == "e5"){
				output += "F";
			}
			output += temp.substring(2);
		}else{
			output += temp;
		}
	}
	if (output != ""){
		data = output;
	}
}

function chgCodePageThai(data) {
	var temp="", output="";
	for(var i = 0; i < data.length; i++) {
		var c = data.charAt(i);
		if( c >= '�' && c <= '�') {
			temp = escape(c);
			if (temp.substring(0, 5) == "%u0E0"){
				output += "%A";
			}else if (temp.substring(0, 5) == "%u0E1"){
				output += "%B";
			}else if (temp.substring(0, 5) == "%u0E2"){
				output += "%C";
			}else if (temp.substring(0, 5) == "%u0E3"){
				output += "%D";
			}else if (temp.substring(0, 5) == "%u0E4"){
				output += "%E";
			}else if (temp.substring(0, 5) == "%u0E5"){
				output += "%F";
			}
			output += temp.substring(5);
		}else if (c >= '!' && c <= '&'){
			temp = escape(c);
			output += temp;
		}else{
			output += c;
		}
	}
	return output;
}

function validEmail(obj) {	
	var email = TrimValue(obj.value);		
	if (email) {
		if ( (email.charCodeAt(0) > 3630) || (email.indexOf(' ') != -1) || (email.indexOf('@') < 1) || (email.indexOf('@') != email.lastIndexOf('@')) || (email.indexOf('@.') != -1) || (email.lastIndexOf('.') <= email.indexOf('@')+1) || ((email.lastIndexOf('.')+1) == email.length) ) {
			err = '��سҵ�Ǩ�ͺ �������ʹ��� (E-mail Address) ���١��ͧ';
			alert(err);
			obj.select();
			return false;
		}else{
			return true;
		}
	}
	return true;
}

function addDateFormat(obj){
	if (obj.value == ''){
		return;
	} else if (checkDateDigit(obj)){
		obj.value = obj.value.substring(0,2)+'/'+obj.value.substring(2,4)+'/'+obj.value.substring(4);
	} else {
		obj.value = '';
		obj.focus();
	}
}

function delDateFormat(obj){
	var regExp = new RegExp("/",'g');
	obj.value = obj.value.replace( regExp, "" );
	obj.select();
}

function checkDateDigit(obj){
	var objFlag = false;
	if (isNumber(obj.value) && isSlashFound(obj.value)){ // without format with numerous input
		if (obj.value.length == 8){ // without any format
			if (isValidMonth(obj.value)){
				if (isValidDate(obj.value)){ // without format with right date input
					if (isValidYear(obj.value)){ // right format with year between 2450-2599
						objFlag = true;
						//alert(obj.value);
					} else {
						objFlag = false;
						alert(showMsg(E0021));
					}
				} else {
					objFlag = false;
					alert(showMsg(E0022));
				}
			} else {
				objFlag = false;
				alert(showMsg(E0023));
			}
		} else {
			objFlag = false;
			alert(showMsg(E0024));
		}
	} else {
		objFlag = false;
		alert(showMsg(E0025));
	}
	return objFlag;
}

function DaysInMonth(WhichMonth, WhichYear){ 
	var DaysInMonth = 31;
	if (WhichMonth == "04" || WhichMonth == "06" || WhichMonth == "09" || WhichMonth == "11") DaysInMonth = 30;
	if (WhichMonth == "02" && ((WhichYear-543)/4) != Math.floor((WhichYear-543)/4))	DaysInMonth = 28;
    if (WhichMonth == "02" && ((WhichYear-543)/4) == Math.floor((WhichYear-543)/4))	DaysInMonth = 29;
	return DaysInMonth;
} 

function isValidDate(date){
    if(date.length==8){
        var day = date.substring(0,2);
        var month = date.substring(2,4);
        var year = date.substring(4);
        if (day <= DaysInMonth(month, year)){
                return true;
        } else return false;
    }else if(date.length > 8){
        var day_g = date.substring(0,2);
        var month_g = date.substring(3,5);
        var year_g = date.substring(6);
        if (day_g <= DaysInMonth(month_g, year_g)){
                return true;
        } else return false;
    }
}

function isValidMonth(date){       
        if(date.length==8){
            var day = date.substring(0,2);
            var month = date.substring(2,4);
            var year = date.substring(4);
            if (month <= 12){
                    return true;
            } else return false;
        }else if(date.length > 8){
            var day1 = date.substring(0,2);
            var month1 = date.substring(3,5);
            var year1 = date.substring(6);
            if (month1 <= 12){
                    return true;
            } else return false;
        }
}

function isValidYear(date){
        if(date.length==8){
            var year = date.substring(4);            
            if ((year >= 2450) && (year <= 2599)){
                    return true;
            } else return false;
        }else if(date.length > 8){
            var year1 = date.substring(6);
            if ((year1 >= 2450) && (year1 <= 2599)){
                    return true;
            } else return false;

        }
}

function chkValidYear(syear){
        if(syear.value.length==4){
            if ((syear.value >= 2450) && (syear.value <= 2599)){
                    return true;
            }else{
                alert(showMsg(E0021));
                syear.value = '';
                syear.focus();
                return false;
            }
        }
}

function isNumber(num){
//	var numPat = /[0-9]/;
//	if (numPat.test(num) == true){
//		return true;
//	} else return false;
    return !isNaN(parseFloat(num)) && isFinite(num);//edit by inging change to this 29/06/2559 because have float number
}

function isSlashFound(num){
	var negSlash = /[\/]/;
	if (!negSlash.test(num) == true) {
		return true;
	} else return false;
}

function checkTimeDigit(obj){
	var objFlag = false;
	if (obj.value == ''){
		return;
	}else{
		if(isNumber(obj.value)){
			if (obj.value.length == 4){
				if(parseInt(obj.value.substring(0,2)) < 24){		
					if(parseInt(obj.value.substring(2)) < 60){
						objFlag = true;
					}else{
						alert("�кعҷ����١��ͧ ����к��� 00 - 59 ��ҹ��");
					}
				}else{
					alert("�кت���������١��ͧ ����к��� 00 - 23 ��ҹ��");
				}		
			}else{
				alert("�ٻẺ�ѹ������١��ͧ ���ͧ�ҡ:\n\n ��������ҡ���� ���͹��¡��� 4 ����ѡ��");
			}
		}else{
			alert("�ٻẺ�ѹ������١��ͧ ���ͧ�ҡ:\n\n1. ��Сͺ���µ���ѡ����蹹͡�ҡ����Ţ  0-9 \n2. ������ͧ���������Сͺ���������  : �繵�");
		}
	}
	return objFlag;
}

function addTimeFormat(obj){
	if (obj.value == ''){
		return;
	} else if (checkTimeDigit(obj)){
		obj.value = obj.value.substring(0,2)+':'+obj.value.substring(2,4);
	} else {
		obj.value = '';
		obj.focus();
	}
}

function dispTime(tValue){
	if(tValue != ""){
		tValue += ":00"
	}
	return tValue;
}

function dimTime(tValue){
	if(tValue != "" && tValue.length == 8){
		tValue = tValue.substring(0,5);
	}
	return tValue;
}

/*Count day form startDate to endDate
	input ������ٻẺ dd/mm/yyyy
	return �ŵ�ҧ�ͧ�ѹ (�� 01/01/2549 - 02/01/2549 = 1 �ѹ)
*/
function countDate(startD, endD){
	var sDate = new Array();
	sDate = startD.value.split("/");
	var eDate = new Array();
	eDate = endD.value.split("/");
	
	date1 = new Date(sDate[2], sDate[1] - 1, sDate[0], 0, 0, 0);				
	date2 = new Date(eDate[2], eDate[1] - 1, eDate[0], 0, 0, 0);
	
	var sTime = date1.getTime();
	var eTime = date2.getTime();
	
	return ((eTime - sTime)/(24*60*60*1000)) +1;
}


/*
	function �Ѻ�ӹǹ��͹
	input ������ٻẺ dd/mm/yyyy
	return �ӹǹ��͹ (�������ɢͧ�ѹ��� �зӡ�ûѴ��ɢ��������ա 1 ��͹
*/
function countMonth(start_date, end_date) {

	var startYear = start_date.value.substring(6,10);
	var startMonth = start_date.value.substring(3,5)-1;
	var startDay = start_date.value.substring(0,2);

	//alert("start_date = ["+start_date.value + "]startYear=["+startYear+"]startMonth=["+startMonth+"]startDay=["+startDay+"]");
	var startdate = new Date(start_date.value.substring(6,10),	start_date.value.substring(3,5)-1, start_date.value.substring(0,2));
	var enddate = new Date(end_date.value.substring(6,10),	end_date.value.substring(3,5)-1, end_date.value.substring(0,2));

    var yearStart = startdate.getFullYear(); //�� getFullYear ᷹ getYear ����Ѻ IE11 09/06/2558 (Phatcharaphon)
//    var yearStart = startdate.getYear();
    var monthStart = startdate.getMonth();
    var dateStart = startdate.getDate();

    var yearEnd = enddate.getFullYear(); //�� getFullYear ᷹ getYear ����Ѻ IE11 09/06/2558 (Phatcharaphon)
//    var yearEnd = enddate.getYear();
    var monthEnd = enddate.getMonth();
    var dateEnd = enddate.getDate();

    var yearAge = yearEnd - yearStart;

    if (monthEnd >= monthStart)
        var monthAge = monthEnd - monthStart;
    else {
        yearAge--;
        var monthAge = 12 + monthEnd -monthStart;
    }

    if (dateEnd >= dateStart)
        var dateAge = dateEnd - dateStart;
    else {
        monthAge--;
        var dateAge = 31 + dateEnd - dateStart;

        if (monthAge < 0) {
            monthAge = 11;
            yearAge--; 
        }
    }

	//alert(yearAge + ' years ' + monthAge + ' months ' + dateAge + ' days');
	if( dateAge > 0){
		monthAge++;
	}
	monthAge = monthAge+ (yearAge*12);
	return monthAge;
}

function addZeros(data, iSize){
	var dataTmp = "";
	for (var i=data.length; i< iSize; i++){
		dataTmp += "0";
	}
	return dataTmp + data;
}

function addDay(data, cDay){
	if( data != ""){
		var enddate = new Date(data.substring(6,10), data.substring(3,5)-1, data.substring(0,2));
		var tmpDay = new Date(data.substring(6,10), data.substring(3,5)-1, data.substring(0,2));
		tmpDay.setDate(enddate.getDate() + cDay);
		return (tmpDay.getDate()<10?"0"+tmpDay.getDate(): tmpDay.getDate()+"") + "/" + 
			(((tmpDay.getMonth()+1)<10? "0"+(tmpDay.getMonth()+1) : tmpDay.getMonth()+1)+"") + "/" +
			(tmpDay.getFullYear()) ; //�� getFullYear ᷹ getYear ����Ѻ IE11 09/06/2558 (Phatcharaphon)
	}
	return "";
}

function chkLengthRecinNo(obj){
	if( obj.value.length == 14)
		return true;
	else{
		alert("�Ţ������¹�Ѻ �е�ͧ�ѹ�֡�繵���Ţ�ӹǹ 14 ��ѡ");
		obj.value = "";
		obj.focus();
		return false;
	}
}
/*
	chkFormatRecinNo ������ત format �ͧ recin_no
	format "YY-OFFCOD-T-SEQNO"
	recin_no >> object
	offcode >> value
	return true/false
*/
function chkFormatRecinNo( recin_no, offcode){
	if( recin_no.value != ""){
		if( chkLengthRecinNo(recin_no)){		// chk length == 14
			var err = false;
			var msg = "";

			var dates = new Date();
			dates = servDate;
			smonth = dates.getMonth();
			syear = dates.getFullYear() + 543; //�� getFullYear ᷹ getYear ����Ѻ IE11 09/06/2558 (Phatcharaphon)
//			syear = dates.getYear() + 543;
			if( smonth >= 10)
				syear++;

			if( "48" >= recin_no.value.substring(0,2) >= (syear+"").substring(2)){	// chk year
				msg = "���ʻէ�����ҳ���١��ͧ";
				err = true;
			}
			if( !err && recin_no.value.substring(2,8) != offcode){		// chk offcode
				msg = "����˹��§ҹ��þ���Ե���١��ͧ";
				err = true;
			}
			if( !err && recin_no.value.substring(8, 9) != "3"){		// chk type = 3 (��ش�Ǻ���)
				msg = "���ʻ������Ţ����¹���١��ͧ";
				err = true;
			}
			if( err){
				alert(msg);
				//recin_no.value = "";
				//recin_no.focus();
				return false;
			}
			return true;
		}
	}
	return false;
}

/**
 * ����¹�ٻẺ�ͧ �µѴ "-"  �͡ �� XXXX-XXX-X, XXXX-XXXX-X  ���������ٻẺ XXXXXXXX, XXXXXXXXX
 *onFocus
 */
function delFormat(obj){
	var regExp = new RegExp("-",'g');
	obj.value = obj.value.replace( regExp, "" );
	obj.select();
}

/*	 �ӡ���� digit �ͧ nitiId ��Ҷ١��ͧ��� format ���ͻ���  */
function checkNitiId(t){
	if (lessThanDigits(t,17)){
		var k = t.value.length;
		var r = 0;
		var j = 13;
		if(k>0){
			for(i=0;i<=(k-3);i++){
				if(t.value.charAt(i) != '-')	{
						r = parseInt(r)+parseInt(parseInt(t.value.charAt(i)) * j);
					--j;
				}
			}
			var result =(parseInt(11)- parseInt(r%11))%10;
			if(result == t.value.charAt(k-1)){
				return true;
			}else{
				if(t.value.length==17){
					alert("�Ţ����¹�ԵԺؤ�ŷ��ѹ�֡���١��ͧ�����ѡࡳ��");	 //check diii		--> E0003
					t.value="";
					t.focus();
					return false;
				}
			}
		}
		return true;
	}else{
		return false;
	}
}

/* �ӡ���� digit �ͧ tin ��Ҷ١��ͧ��� format ���ͻ���  */
function checkTinPin(t){
        var x = t.value.length;
        if (x==13) { // �óշ���ҷ�������� 13 ����ѡ�� checkTin
                var k = t.value.length;
                var r = 0;
                
                if (t.value == '1-1111-1111-1' || t.value == '2-2222-2222-2' || t.value == '3-3333-3333-3' || t.value == '4-4444-4444-4' || t.value == '5-5555-5555-5'
                    || t.value == '6-6666-6666-6' || t.value == '7-7777-7777-7' || t.value == '8-8888-8888-8' || t.value == '9-9999-9999-9')
                {
                        alert("�Ţ��Шӵ�Ǽ�����������ҡ÷��ѹ�֡���١��ͧ") //check diii		--> E0001
                        t.value="";
                        t.focus();
                        return false;                    
                }
                
                if (t.value.charAt(0) == '0' || t.value.charAt(0) == '9'){
                        alert("�Ţ��Шӵ�Ǽ�����������ҡ÷��ѹ�֡���١��ͧ�����ѡࡳ��") //check diii		--> E0001
                        t.value="";
                        t.focus();
                        return false;
                }

                if(k>0){
                        for(i=0;i<=(k-3);i++){
                                if(t.value.charAt(i) != '-')	{
                                        if((i==3) || (i==0) || (i==5) || (i==8) || (i==10)){
                                                r = parseInt(r)+parseInt(parseInt(t.value.charAt(i)) * 3);
                                        }else{
                                                r = parseInt(r)+parseInt(parseInt(t.value.charAt(i)) * 1);
                                        }
                                }
                        }
                        var result =(parseInt(10)- parseInt(r%10))%10;
                        if(result == t.value.charAt(k-1)){
                                return true;
                        }else{
                                if(t.value.length==13){
                                        alert("�Ţ��Шӵ�Ǽ�����������ҡ÷��ѹ�֡���١��ͧ�����ѡࡳ��"); //check diii		--> E0001
                                        t.value="";

                                        t.focus();
                                        return false;
                                }
                        }
                }
        } else if (x==17) { // �óշ���ҷ�������� 17 ����ѡ�� ��� checkPin
                var k = t.value.length;
                var r = 0;
                var j = 13;
                if(k>0){
                        for(i=0;i<=(k-3);i++){
                                if(t.value.charAt(i) != '-')	{
                                                r = parseInt(r)+parseInt(parseInt(t.value.charAt(i)) * j);
                                        --j;
                                }
                        }
                        var result =(parseInt(11)- parseInt(r%11))%10;
                        if(result == t.value.charAt(k-1)){
                                return true;
                        }else{
                                if(t.value.length==17){
                                        alert("�Ţ��Шӵ�Ǽ�����������ҡ÷��ѹ�֡���١��ͧ�����ѡࡳ��");	 //check diii		--> E0003
                                        t.value="";
                                        t.focus();
                                        return false;
                                }
                        }
                }
                return true;
        } else{
		return false;
	}
}

function ProcessNgtResult(obj) {
	obj.value=obj.value.replace(/,/g, "");
	if (obj.value=='-' || obj.value=='-.' || obj.value=='.')	{
		obj.value="0.00";
		return false;
	}
	if (obj.value >= 0) {
		ProcessResult(obj);
		return true;
	} else {
		var val = obj.value;
		obj.value = val.substring(1,val.length);
		ProcessResult(obj);
		obj.value = '-' + obj.value;
		return true;
	}
}

/*
	function �������¹ format ��ٻẺ�ͧ�ӹǹ�Թ���������ͧ���¨���Ҥ(,)
	������ҧ����觤��
	onKeyUp="changeFormatNumber(this,event)"
*/
function changeFormatNumber(formField, e){
	var formTest = (window.Event) ? e.which : e.keyCode;
        if(formField.value.indexOf(".")==0){
            formField.value = "0"+formField.value;
        }
	if(formTest == 190||(event.keyCode == 46)){
		var sTmpPoint = formField.value.split(".");
		if(sTmpPoint.length >2){
			formField.value = formField.value.substring(0, (formField.value.length-1));
		}
	}
	
	if( (formTest > 47) &&  (formTest < 58)|| (event.keyCode > 95) &&  (event.keyCode < 105) || (event.keyCode == 8)|| (event.keyCode == 190) || (event.keyCode == 46)){
            if((formField.value.length == 0) && (event.keyCode ==57 || event.keyCode == 48)){
                event.keyCode=0;
            }
			if(formTest != 190 && event.keyCode != 46){
				formField.value = formField.value.replace( /,/g, "" );
				setFormatComma( formField );
			}
	}
}

/* ������¹ format �Թ����� #,###.00  */
function setFormatComma( obj ){
	var iPoint = obj.value.indexOf(".");
	var intPart = "";
	var decPart = "";
	var intPartLen = 0;
        var sNegative = "";
        if(obj.value.length > 0){
            if(obj.value.substr(0,1) == "-"){
                sNegative = "-"; 
                obj.value = obj.value.substr(1);
            }
        }
	if(iPoint> -1){
		intPart = obj.value.substr(0,iPoint);
		intPartLen = intPart.length;
		decPart = obj.value.substr(iPoint+1);
		decPart = "." +decPart;
	}else{
		intPart = obj.value;
		intPartLen = intPart.length;
	}

    if ( ( prefix = intPartLen % 3 ) == 0 )
        prefix = 3;
    newValue = obj.value.substring( 0, prefix );
    for ( intPartLen -= prefix; intPartLen > 0; intPartLen -= 3 ){
        newValue += "," + obj.value.substring( prefix, prefix + 3 );
        prefix += 3;
    }
    obj.value = sNegative+newValue + decPart;
}

function helpCalendar(contextPath,dateField){
    if(typeof dateField == 'undefined'){
            dateField = "date";
    }
    var w = 150;
    var h = 230;
    var x1 = (screen.width-w)/2;
    var y1= (screen.height-h)/2;
    var selectDate = showModalDialog(contextPath+"/jsp/lic/Calendar.jsp","MainPopup","toolbar:no;location:no;menubar:no;scroll:no;status:no;dialogWidth:"+w+"px;dialogheight:"+h+"px;dialogLeft:"+x1+"px;dialogTop:"+y1+"px;");
    if(typeof selectDate != 'undefined'){
            document.getElementById(dateField).value = selectDate;
            checkDateW(document.getElementById(dateField));
    }
}

/*
    function ��Ǩ�ͺ�����١��ͧ����ǡѺ�ѹ���
    1. ��ͧ��͹�ú 8 ���
    2. ��ͧ�١��ͧ����ջ�ԷԹ
    3. ��ͧ�����¡����ѹ���Ѩ�غѹ��
    input ������ٻẺ ddmmyyyy ���� dd/mm/yyyy
*/
function checkDateB(obj, errMsg) {
    var msg = "";
    if (obj.value.length != 0) {	
        dateFormat(obj);
        if (obj.value.length != 10) {
//            msg = "�ô�ѹ�֡�繵���Ţ 8 ��ѡ"; ///E0024
            obj.value = "";
            alert(showMsg(E0024));
            obj.focus();
            return false;
        } else if (!isValidDateThai(obj)) {
//            msg = "����ѹ������١��ͧ �ô���������";//E0022
            obj.value = "";
            alert(showMsg(E0022));
            obj.focus();
            return false;
        } else if (!isValidYear(obj.value)) {
            obj.value = "";
            alert(showMsg(E0021));
            obj.focus();
            return false;
        } else {
            var dateEntry = new Date((obj.value.substring(6,10) - 543), (obj.value.substring(3,5) - 1), obj.value.substring(0,2));
            var daysDiff = Math.floor((servDate.getTime() - dateEntry.getTime()) / (1000*60*60*24));
            if (daysDiff > 0) {
//                msg = "�ѹ�����ѹ�֡��ͧ�ҡ����������ҡѺ�ѹ�����к�";//E0030
                if (errMsg == undefined) {
                    msg = showMsg(E0030);
                } else {
                    msg = showMsg(errMsg);
                }
                obj.value = "";
                alert(msg);
                obj.focus();
                return false;
            }
        }
    }
    return true;
}

function setUpperCase(obj){
    if(obj.value != ""){
        obj.value = obj.value.toUpperCase();
    }
}

/*	
    function ����Ѻ����繵���ѡ�� Eng �˭� ��е���Ţ ��� - ��ҹ��
    ������ҧ����觤�� 
    onKeypress="AlphaNumericDatValue(event)"
*/
function AlphaNumericDatValue(event){
    if((event.keyCode >= 48 &&  event.keyCode <= 57) // 0-9
        || (event.keyCode >= 65 && event.keyCode < 90) // A-Z
      //  || (event.keyCode == 45)// -
        || (event.keyCode == 8))// Tab
    {
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

/*
	function �������¹ format ��ٻẺ�ͧ �Ţ��Шӵ�Ǽ���������� ��� �Ţ��Шӵ�ǻ�ЪҪ�
	������ҧ����觤��
	onKeypress="changeFormatMacAddr(this,event)"
*/
function changeFormatMacAddr(formField, e){
	var formTest = (window.Event) ? e.which : e.keyCode;
	if  (formTest == 8){
		formField.value = formField.value.substr(0, (formField.value.length-1))
	}
	if( (formTest > 47 && formTest < 58) || (event.keyCode >= 65) &&  (event.keyCode < 90)){
		//if((formField.value.length == 0) && (event.keyCode ==57 || event.keyCode == 48)){
		//		event.keyCode=0;
		//}
		if(formField.value.length == 2){
			formField.value += '-';
		}
		if(formField.value.length == 5)
			formField.value += '-';	

		if(formField.value.length == 8)
			formField.value += '-';	

		if(formField.value.length == 11)
			formField.value += '-';	
                        
                if(formField.value.length == 14)
			formField.value += '-';	
	}
}

/*
    function �Ǩ�ͺ��á�͡����Ţ ����ö ��͡��੾�� 0-9 / ��� - ��ҹ��
    ������ҧ����觤��
    onKeypress="NumericValueApprove(event)"
*/
function NumericValueApprove(event){
    if( (event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode == 45) || (event.keyCode == 47) ){
        event.returnValue = true; 
    }else{
        event.returnValue = false;
    }
}

/*
    function ��úǡ�Ţ ��ٻẺ  xx,xxx.xx
    ������ҧ����觤��
    onBlur="summary(obj1,obj2,objResult)";
*/
function summary(obj1,obj2,result){
    // ��� Object �繤����ҧ����դ���� 0
    obj1.value =  isEmpty(obj1)?0:obj1.value.replace( /,/g, "" );
    obj2.value =  isEmpty(obj2)?0:obj2.value.replace( /,/g, "" );
    result.value = parseFloat(obj1.value) + parseFloat(obj2.value);
    
    PostEditFloatNum(obj1);
    PostEditFloatNum(obj2);
    PostEditFloatNum(result);
    
    obj1.value =  obj1.value <= 0?"":obj1.value;
    obj2.value =  obj2.value <= 0?"":obj2.value;
    result.value =  result.value <= 0?"":result.value;

}

/*
    function ��õ�Ǩ�ͺ�����ҧ ����դ����ҧ return true
    ������ҧ����觤��
    isEmpty(object);
*/
function isEmpty(object){
    if(object.value == '' || object.value == ""){
        return true;
    }else{
        return false;
    }
}

/*
    function �ӹǳ��Ҥ�����ҧ -1 �֧ 1 
    ������ҧ����觤��
    differentvalue_1(obj1,obj2,inputMsg);
*/
function differentvalue_1(obj1,obj2,inputMsg){
    PreEditNumcomma(obj1);
    PreEditNumcomma(obj2);
    obj1.value = obj1.value == ""?0:obj1.value;
    obj2.value = obj2.value == ""?0:obj2.value;
    var different = obj1.value - obj2.value; 
    different = different.toFixed(2);
    if((different < -1) || (different > 1)){
        alert(showMsg(W8003));
        obj1.value = obj2.value;
    }
}


/*
    function �ӹǳ�Ťٳ 
    ������ҧ����觤�� ( Parameter �Ѻ����� Object )
    multiple(inputObj1,inputObj2,outputObj);
*/
function multiple(input1,input2,output){
    convertEmptyToZero(input1);
    convertEmptyToZero(input2);
    PreEditNumcomma(input1);
    PreEditNumcomma(input2);
    output.value = parseFloat(input1.value) * parseFloat(input2.value); 
    output.value = output.value.toFixed(2);
    PostEditFloatNum(output);
}

/*
    function �ŧ�����ҧ���ͪ�ͧ��ҧ����դ���� 0 
    ������ҧ����觤�� ( Parameter �Ѻ����� Object )
    convertEmptyToZero(inputObj1,inputObj2,outputObj);
*/
function convertEmptyToZero(input){
    input.value = input.value == ""?0:input.value;
    input.value = input.value == " "?0:input.value;
}

// �ѧ���蹹�� ������Ѻ�ӹǹ����ѡ��
function checkLengthOfCharacter(object,lgth) {
    object.value = object.value.replace(/^s+/g,'').replace(/s+$/g,'');
    if(object.value.length > lgth){
        if(confirm( showMsg(E6020) + " " +lgth+' ����ѡ�� ��ͧ��õѴ�͡�������')==true){
            object.value = object.value.substring(0,lgth);
        }else{
            object.focus();
        }
    }
}
// ������ત �Ţ��� ��. �����ժ�ͧ��ҧ����ҹ�ѡ��
function keyApproveNo(approve_no){  
    approve_no.value = approve_no.value.replace(/ /g, "");
}
// ������ત �Ţ��� ��. ��ͧ������鹴��µ���Ţ ��������ժ�ͧ��ҧ�����ҧ�ѡ��
function keyApproveNoFirst(approve_no){
    if( approve_no.value.length > 0){
        var s1 = approve_no.value.substring(0,1);
        var arr1 = new Array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        var pass = false;
        
        for(var i = 0; i < arr1.length; i++){
            if( s1 == arr1[i]){
                pass = true;
                break;
            }
        }
        if( !pass ){
            alert(showMsg(E8047));
            approve_no.value = "";
            approve_no.focus();
        }else{
            approve_no.value = approve_no.value.replace(/ /g, "");
        }
    }
}
// ������ ��š������ �� ���
// 28/02/2557 �����顴 F5 ��
document.onkeydown=function(e) {
    var event = window.event || e;
    if (event.keyCode == 116) {
        event.keyCode = 0;
        alert("���͹حҵ��顴���� F5 ��");
        return false;
    }
}
//���� 26/09/2557 �ŧ�ѡ��о������ HTML NUMBER
function replaceSymbols(str){
    return str.replace(/'/g,'&#039;').replace(/"/g,"&#34;");
}

//��� ������ (,) ������Ţ ������кص��˹觷ȹ���
function setNumberWithCommas( urNumber, decimal ){
    var float = parseFloat( urNumber != "" ? urNumber : "0" ).toFixed( decimal );   
    var n= float.toString().split(".");
    n[0] = n[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    return n.join(".");
}

//Set blank ("") when zero (0)
function setBlankWhenZero( urNumber ){    
    return urNumber == 0 ? "" : setNumberWithCommas( urNumber, 2 );
}

// preEditNumObj Ẻ return "" ����������ö�ŧ�����
function focusNum(obj) {
    var trimValue = $.trim($(obj).val());
    var cutCommaValue = trimValue.replace(/,/g, "");
    if (trimValue != "") {
        if (isNaN(parseFloat(cutCommaValue))) {
            $(obj).val("");
            obj.select();
        }
        else preEditNumObj(obj);
    }
}

/**
 * ��Ǩ�ͺ�ٻẺ����Ţ�ӹǹ�����зȹ��� �����仵������ͧ���
 * @param : obj
 * @param : beforeCommaCount	(�ӹǹ��ѡ�ͧ�Ţ������)
 * @param : afterCommaCount	(�ӹǹ��ѡ�ͧ�Ţ�ȹ���)
 * @return : none
 * @sample : onBlur="focusoutNum(this, length, scale)"
 */
function focusoutNum(obj, beforeCommaCount, afterCommaCount) {
    var trimValue = $.trim($(obj).val());
    var cutCommaValue = trimValue.replace(/,/g, "");
    
    var isNaNValue = false;
    if (afterCommaCount > 0) isNaNValue = isNaN(parseFloat(cutCommaValue));
    else isNaNValue = isNaN(parseInt(cutCommaValue));
    
    if (trimValue == "") $(obj).val("");
    else if (isNaNValue) $(obj).val("");
    else if (cutCommaValue.split('.').length > 2) $(obj).val(""); 
    else if (typeof beforeCommaCount == "undefined" || typeof afterCommaCount == "undefined") $(obj).val("");
    else {
        var value = "", values = "";
        var commaIndex = cutCommaValue.indexOf(".");
        
        if (commaIndex != -1) {
            if (commaIndex > beforeCommaCount) {
                cutCommaValue = cutCommaValue.toString().split(".");
                cutCommaValue[0] = cutCommaValue[0].substring(0, beforeCommaCount);
                cutCommaValue = cutCommaValue.join(".");
            }
        }
        else {
            if (cutCommaValue.length > beforeCommaCount) {
                cutCommaValue = cutCommaValue.substring(0, beforeCommaCount);
            }
        }
        
        value = parseFloat(cutCommaValue).toFixed(afterCommaCount);   
        values = value.toString().split(".");
        values[0] = values[0].replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $(obj).val(values.join(".")); 
    }
}

/*
    function ��Ǩ�ͺ�����١��ͧ����ǡѺ�ѹ���
    1. ��ͧ��͹�ú 8 ���
    2. ��ͧ�١��ͧ����ջ�ԷԹ
    3. �Թ�ѹ���Ѩ�غѹ��
    input ������ٻẺ ddmmyyyy ���� dd/mm/yyyy
    ����¹ Alert Ẻ���� 
*/
function checkDateAlert(obj) {
    var msg = "";
    if (obj.value.length != 0) {
        dateFormat(obj);
        if (obj.value.length != 10) {
            //            msg = "�ô�ѹ�֡�繵���Ţ 8 ��ѡ"; ///E0024
            obj.value = "";
            $.alertMsg(showMsg(E0024));
//            obj.focus();
            return false;
        }
        else if (!isValidDateThai(obj)) {
            //            msg = "����ѹ������١��ͧ �ô���������";//E0022
            obj.value = "";
            $.alertMsg(showMsg(E0022));
//            obj.focus();
            return false;
        }
        else if (!isValidYear(obj.value)) {
            obj.value = "";
            $.alertMsg(showMsg(E0021));
//            obj.focus();
            return false;
        }
//        else if (!isBeforeToday(obj)) {
//            //msg = "�ѹ�����ѹ�֡��ͧ���¡���������ҡѺ�ѹ�����к�";//E0026
//            obj.value = "";
//            $("#startDate").val("");
//            $("#endDate").val("");
//            $.alert("E", E0026);
//            obj.focus();
//            return false;
//        }
    }
    return true;
}

function compareDateAlert(obj1, obj2, errMsg) {
	var msg = "";
	if ((TrimValue(obj1.value).length != 0) && (TrimValue(obj2.value).length == 0)) {
			msg = "�ô�ѹ�֡ �ѹ�������ش";
			$.alertMsg(showMsg(E0002));
//			obj2.focus();
			return false;
	} else if ((TrimValue(obj1.value).length == 0) && (TrimValue(obj2.value).length != 0)) {
			msg = "�ô�ѹ�֡ �ѹ����������";
//			$.alert("E", E0002);
                        $.alertMsg(showMsg(E0002));
//			obj1.focus();
			return false;
	} else if (checkDateW(obj1) && checkDateW(obj2)) {
		var beginDate = obj1.value.substring(6) + obj1.value.substring(3,5) + obj1.value.substring(0,2);
		var endDate = obj2.value.substring(6) + obj2.value.substring(3,5) + obj2.value.substring(0,2);
		if (beginDate > endDate) 	{
			if( errMsg == undefined)
				msg = "�ѹ���������鹵�ͧ���¡���������ҡѺ�ѹ�������ش";
			else
				msg = errMsg;
		}
		if (msg.length != 0) {
			obj1.value = "";
//			$.alert("E", E0002);
                        $.alertMsg(showMsg(E0002));
//			obj1.focus();
			return false;
		}
		return true;
	}
}