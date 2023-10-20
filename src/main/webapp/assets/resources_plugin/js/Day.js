var fullMonth = [[ "���Ҥ�", "����Ҿѹ��", "�չҤ�", "����¹", "����Ҥ�", "�Զع�¹"
                 , "�á�Ҥ�", "�ԧ�Ҥ�", "�ѹ��¹", "���Ҥ�","��Ȩԡ�¹", "�ѹ�Ҥ�" ],
                 [ "January", "Febuary", "March", "April", "May", "June",
                   "July", "August", "September", "October", "November", "December" ]];

(function($){
    $.fn.delDateFormat = function(size) {
        $(this).focusout(function(e) {
            var regExp = new RegExp("/",'g');
            $(this).val( $(this).val().replace(regExp,"") );
            $(this).select();
        }); 
    }
}($));

/**
 * @get �ѹ��͹�ջѨ�غѹ �� 03/01/2512
 */
function getTodayTH(){
   var today = new Date(); 
   return (today.getUTCDate() < 10?'0':'') + today.getUTCDate() + "/" + ((today.getUTCMonth()+1) < 10?'0':'') + (today.getUTCMonth()+1) + "/" + (today.getUTCFullYear()+543); 
}
    
/**
 * ������Ѻ����¹�ٻẺ�ѹ���ҡ dd/mm/yyyy ���� yyyy-mm-dd
 * ����� dd/mm/yyyy
 * @param string �ٻẺ dd/mm/yyyy ���� yyyy-mm-dd
 * @return Thai brief date format �� 03/01/2512
 */
function thaiBriefDateFormat(string) {
    var returnValue = "";
    if (string == null || string=="null" || string == "" || string.length < 10) return returnValue;

    var index = parseInt(string.indexOf("-"));
    if (index != -1) {
        if (index < 4) {
            string = ("0000" + string).substring(index, string.length + 4 - index);
        }
        returnValue = string.substring(8, 10) + "/" + string.substring(5, 7) + "/" + (parseInt(string.substring(0, 4))+543);
    } else {
        returnValue = string.substring(0, 6) + string.substring(6, 10);
    }
    return returnValue;
}

/**
 * ������Ѻ����¹�ٻẺ�ѹ���ҡ dd/mm/yyyy hh24:mi:ss ���� yyyy-mm-dd hh24:mi:ss
 * ����� dd/mm/yyyy hh24:mi:ss
 * @param string �ٻẺ dd/mm/yyyy hh24:mi:ss ���� yyyy-mm-dd hh24:mi:ss
 * @return Thai brief date time format �� 03/01/2512 12:44:40
 */
function thaiBriefDateTimeFormat(string) {
    var returnValue = "";
    if (string == null || string=="null" || string == "") return returnValue;

    var index = parseInt(string.indexOf("-"));
    if (index != -1) {
        if (index < 4) {
            string = ("0000" + string).substring(index, string.length + 4 - index);
        }
        returnValue = string.substring(8, 10) + "/" + string.substring(5, 7) + "/"
                    + (parseInt(string.substring(0, 4))+543) + " " + string.substring(11, 20);
    } else {
        returnValue = string.substring(0, 6) + string.substring(6, 10) + " " + string.substring(11, 20);
    }
    return returnValue;
}

/**
 * @param string �ٻẺ dd/mm/yyyy hh:mm:ss ���� yyyy-mm-dd hh:mm:ss
 * @return Date thai format �� �ѹ��� : 29 ����¹ 2557 ���� : 15:19 
 */
function timeStampToDateThai(sTimeStamp) {
    if (sTimeStamp == null || sTimeStamp=="null" || sTimeStamp == "") return "";

    var sDayName = "", sYear = "", sMonth = "", sDay = "", sTime = "";
    var iMonth = 0;
    
    var index = parseInt(sTimeStamp.indexOf("-"));
    if (index != -1) {
        sYear = sTimeStamp.substring(0, 4);
        sYear = parseInt(sYear) + 543;
        sMonth = sTimeStamp.substring(5, 7);
        sDay = sTimeStamp.substring(8, 10);
        sTime = sTimeStamp.substring(11, 16);
    } else {
        sYear = sTimeStamp.substring(6, 10);
        sMonth = sTimeStamp.substring(3, 5);
        sDay = sTimeStamp.substring(0, 2);
        sTime = sTimeStamp.substring(11, 16);
    }

    iMonth = parseInt(sMonth);
    sDayName = "�ѹ��� : " + parseInt(sDay) + " " + fullMonth[0][iMonth - 1] + " " + sYear + "  ���� : " + sTime;
    return sDayName;
}

/**
 * ������Ѻ����¹�ٻẺ�ѹ���ҡ dd/mm/yyyy ���� yyyy-mm-dd
 * ����� yyyy-mm-dd
 * @param string �ٻẺ dd/mm/yyyy ���� yyyy-mm-dd
 * @return date format �� 2015-11-22
 */
function strTh2Date (string) {
    var returnValue = "";
    if (string == null || string=="null" || string == "") return returnValue;
    
    var index = parseInt(string.indexOf("-"));
    if (index != -1) {
        sYear = string.substring(0, 4);
        sYear = parseInt(sYear) + 543;
        sMonth = string.substring(5, 7);
        sDay = string.substring(8, 10);
    } else {
        sYear = string.substring(6, 10);
        sMonth = string.substring(3, 5);
        sDay = string.substring(0, 2);
    }
    return sYear + "-" + sMonth + "-" + sDay;
}

/**
 * ������Ѻ����¹�ٻẺ�ѹ���ҡ dd/mm/yyyy
 * ����� yyyy-mm-dd
 * @param string �ٻẺ dd/mm/yyyy
 * @return date format �� 2015-11-22
 */
function strTh2EngDate (string) {
    var returnValue = "";
    if (string == null || string=="null" || string == "") return returnValue;
    
    var index = parseInt(string.indexOf("/"));
    if (index != -1) {
        sYear = string.substring(6, 10);
        sYear = parseInt(sYear) - 543;
        sMonth = string.substring(3, 5);
        sDay = string.substring(0, 2);
    }
    return sYear + "-" + sMonth + "-" + sDay;
}

function compareDateStartWithEnd(objStartDate, objEndDate) {   
    if (objStartDate.val() != "" && objEndDate.val() != "") {
        var data1 = objStartDate.val().split("/");
        var data2 = objEndDate.val().split("/");       
        if (parseInt(data1[2] + data1[1] + data1[0]) > parseInt(data2[2] + data2[1] + data2[0])) return false;
        else return true;
    } else {
        return true;
    }      
}

function getCurrentMonthThai(){
    return (parseInt((new Date).getMonth())+1)<10?"0"+((new Date).getMonth()+1):(parseInt((new Date).getMonth())+1);
}

function getCurrentYearThai(){
    return parseInt((new Date).getFullYear())+543;
}