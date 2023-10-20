function changeBgMoi(el) {
    el.style.background = "#CCFFCC";
}

function changeBgReg(el) {
    el.style.background = "#FFFFCC";
}

function delRegIdFormat(obj) {
    var regExp = new RegExp("-", 'g');
    obj.value = obj.value.replace(regExp, "");
}

/* ทำการเช็ค digit ของ RegId ตาม format "254900001x" */
function checkRegID(t) {
    var k = t.value.length;
    var regExp = new RegExp("-", 'g');
    var val = t.value;
    //ถ้าตัวแรกของเลขทะเบียนสรรพสามิต มีค่าน้อยกว่า 2  แสดงว่าเป็นเลขสรรพสามิตเก่าไม่ต้องผ่านการตรวจสอบ format
    var firstDigit = parseInt(val.charAt(0));
    if (firstDigit < 2) {
        //alert(" เป็นเลขสรรพสามิตเดิม  ไม่ต้องผ่านการ checkdigit ");
        return true;
    }

    if (k == 12) {
        // กรณีที่ส่งมาเป็น 2549-00001-x
        val = t.value.replace(regExp, "");
        k = val.length;
    }

    if (k == 10) {
        var r = 0;
        if (val.charAt(0) == '0') {
            return true;
        }
        for (i = 0;i <= (k - 2);i++) {
            if ((i == 0) || (i == 3) || (i == 5) || (i == 7) || (i == 8)) {
                r = parseInt(r) + parseInt(parseInt(val.charAt(i)) * 3);
            }
            else {
                r = parseInt(r) + parseInt(parseInt(val.charAt(i)) * 2);
            }
        }
        var result = (parseInt(10) - parseInt(r % 10)) % 10;
        if (result == val.charAt(k - 1)) {
            return true;
        }
        else {
            //alert("เลขทะเบียนสรรพสามิตที่บันทึกไม่ถูกต้องตามหลักเกณฑ์"); 
            alert(showMsg(E4015));
            t.value = "";
            t.focus();
            return false;
        }
    }
    else {
        if (k == 0) {
            return false;
        }
        else {
            alert(showMsg(E4015));
            t.value = "";
            t.focus();
            return false;
        }
    }
}
//============================================
/* ทำการเช็ค digit ของ RegId ตาม format "254900001x" */
function checkRegID2(t) {
    var k = t.value.length;
    var regExp = new RegExp("-", 'g');
    var val = t.value;
    //ถ้าตัวแรกของเลขทะเบียนสรรพสามิต มีค่าน้อยกว่า 2  แสดงว่าเป็นเลขสรรพสามิตเก่าไม่ต้องผ่านการตรวจสอบ format
    var firstDigit = parseInt(val.charAt(0));
    if (firstDigit < 2) {
        //alert(" เป็นเลขสรรพสามิตเดิม  ไม่ต้องผ่านการ checkdigit ");
        return true;
    }

    if (k == 12) {
        // กรณีที่ส่งมาเป็น 2549-00001-x
        val = t.value.replace(regExp, "");
        k = val.length;
    }

    if (k == 10) {
        var r = 0;
        var yyyy = "";
        if (val.charAt(0) == '0') {
            return true;
        }
        for (i = 0;i <= (k - 2);i++) {
            if ((i == 0) || (i == 1) || (i == 2) || (i == 3)) {
                yyyy += val.charAt(i);
            }
        }
        var result = parseInt(yyyy);
        if (result >= 2000) {
            return true;
        }
        else {
            //alert("เลขทะเบียนสรรพสามิตที่บันทึกไม่ถูกต้องตามหลักเกณฑ์"); 
            alert(showMsg(E4015));
            t.value = "";
            t.focus();
            return false;
        }
    }
    else {
        if (k == 0) {
            return false;
        }
        else {
            alert(showMsg(E4015));
            t.value = "";
            t.focus();
            return false;
        }
    }
}

//============================================
/* ทำการเช็ค digit ของ LicId ตาม format "25490001x" 9 หลัก  */
function checkLicID9(t) {
    //alert("obj.name="+t.name+" obj.value="+t.value);
    var k = t.value.length;

    var k = t.value.length;
    var regExp = new RegExp("-", 'g');
    var val = t.value;

    if (k == 11) {
        // กรณีที่ส่งมาเป็น 2549-0001-x
        val = t.value.replace(regExp, "");
        k = val.length;
    }

    if (k == 9) {
        var r = 0;
        if (val.charAt(0) == '0') {
            return true;
        }
        for (i = 0;i <= (k - 2);i++) {
            if ((i == 0) || (i == 3) || (i == 5) || (i == 6) || (i == 7)) {
                r = parseInt(r) + parseInt(parseInt(val.charAt(i)) * 3);
            }
            else {
                r = parseInt(r) + parseInt(parseInt(val.charAt(i)) * 2);
            }
        }
        var result = (parseInt(10) - (parseInt(r) % 10)) % 10;
        if (result == val.charAt(k - 1)) {
            return true;
        }
        else {
            alert(showMsg(E4014));
            t.value = "";
            t.focus();
            return false;
        }
    }
    else {
        if (k == 0) {
            return false;
        }
        else {
            alert(showMsg(E4014));
            t.value = "";
            t.focus();
            return false;
        }
    }
}

/* ทำการเช็ค digit ของ LicId ตาม format "2549001x" 8 หลัก */
function checkLicID8(t) {
    var k = t.value.length;
    var regExp = new RegExp("-", 'g');
    var val = t.value;

    if (k == 10) {
        // กรณีที่ส่งมาเป็น 2549-001-x
        val = t.value.replace(regExp, "");
        k = val.length;
    }

    if (k == 8) {
        var r = 0;
        if (val.charAt(0) == '0') {
            return true;
        }
        for (i = 0;i <= (k - 2);i++) {
            if ((i == 0) || (i == 3) || (i == 5) || (i == 6)) {
                r = parseInt(r) + parseInt(parseInt(val.charAt(i)) * 3);
            }
            else {
                r = parseInt(r) + parseInt(parseInt(val.charAt(i)) * 2);
            }
        }
        var result = (parseInt(10) - parseInt(r % 10)) % 10;

        if (result == val.charAt(k - 1)) {
            return true;
        }
        else {
            alert(showMsg(E4013));
            t.value = "";
            t.focus();
            return false;
        }
    }
    else {
        if (k == 0) {
            return false;
        }
        else {
            alert(showMsg(E4013));
            t.value = "";
            t.focus();
            return false;
        }
    }
}

/*
 function การเปลี่ยนวันที่ให้เป็นค่าต้วเลขที่สามารถนำไป เปรียบเทียบได้
 para ที่ส่งมา  format เป็น dd/mm/yyyy  เช่น 01/10/2549 หรือ 01-10-2549
 return เป็น 25491001
*/
function changeDate2Int(arg_date) {
    if (arg_date == "")
        return 0;
    var dd = arg_date.substring(0, 2);
    var mm = arg_date.substring(3, 5);
    var yyyy = arg_date.substring(6);
    var i_date = parseInt(yyyy + mm + dd);
    return i_date;
}

/*
	function การเปลี่ยน format ในรูปแบบของ เลขทะเบียนสรรพสามิต
	ตัวอย่างการส่งคือ
	onKeypress="changeFormatRegId(this,event)"
*/
function changeFormatRegId(formField, e) {
    var formTest = (window.Event) ? e.which : e.keyCode;
    if (formTest == 8) {
        formField.value = formField.value.substr(0, (formField.value.length - 1))
    }
    if ((formTest > 47) && (formTest < 58) || (event.keyCode > 95) && (event.keyCode < 105)) {
        if ((formField.value.length == 0) && (event.keyCode == 57 || event.keyCode == 48)) {
            event.keyCode = 0;
        }
        if (formField.value.length == 4) {
            formField.value += '-';
        }
        if (formField.value.length == 10)
            formField.value += '-';
    }
}

/*
	function การเปลี่ยน format ในรูปแบบของ ขอตั้งสถานแสดงรถยนต์เพื่อขาย
	ตัวอย่างการส่งคือ
	onKeypress="changeFormatLicId9(this,event)"
*/
function changeFormatLicId9(formField, e) {
    var formTest = (window.Event) ? e.which : e.keyCode;
    if (formTest == 8) {
        formField.value = formField.value.substr(0, (formField.value.length - 1))
    }
    if ((formTest > 47) && (formTest < 58) || (event.keyCode > 95) && (event.keyCode < 105)) {
        if ((formField.value.length == 0) && (event.keyCode == 57 || event.keyCode == 48)) {
            event.keyCode = 0;
        }
        if (formField.value.length == 4) {
            formField.value += '-';
        }
        if (formField.value.length == 9)
            formField.value += '-';
    }
}

/*
	function การเปลี่ยน format ในรูปแบบของ ขอตั้งคลังสินค้าทัณฑ์บน
	ตัวอย่างการส่งคือ
	onKeypress="changeFormatLicId8(this,event)"
*/
function changeFormatLicId8(formField, e) {
    var formTest = (window.Event) ? e.which : e.keyCode;
    if (formTest == 8) {
        formField.value = formField.value.substr(0, (formField.value.length - 1))
    }
    if ((formTest > 47) && (formTest < 58) || (event.keyCode > 95) && (event.keyCode < 105)) {
        if ((formField.value.length == 0) && (event.keyCode == 57 || event.keyCode == 48)) {
            event.keyCode = 0;
        }
        if (formField.value.length == 4) {
            formField.value += '-';
        }
        if (formField.value.length == 8)
            formField.value += '-';
    }
}

/**
 * เปลี่ยนรูปแบบของ regId ให้อยู่ในรูปแบบ XXXX-XXXXX-X
 *onblur
 */
function addRegIdFormat(obj) {
    if (obj.value == '') {
        return;
    }
    else if (obj.value.length == 10) {
        if (obj.value.substring(0, 1) < 2) {
            obj.value = obj.value.substring(0, 2) + "-" + obj.value.substring(2, 4) + "-" + obj.value.substring(4, 6) + "-" + obj.value.substring(6);
        }
        else {
            obj.value = obj.value.substring(0, 4) + "-" + obj.value.substring(4, 9) + "-" + obj.value.substring(9);
        }
    }
    else {
        obj.value = '';
        obj.focus();
    }
}

/**
 * เปลี่ยนรูปแบบของ licId ให้อยู่ในรูปแบบ XXXX-XXX-X, XXXX-XXXX-X
 *onblur
 */
function addLicIdFormat(obj) {
    if (obj.value == '') {
        return;
    }
    else if (obj.value.length == 8) {
        obj.value = obj.value.substring(0, 4) + "-" + obj.value.substring(4, 7) + "-" + obj.value.substring(7);
    }
    else if (obj.value.length == 9) {
        obj.value = obj.value.substring(0, 4) + "-" + obj.value.substring(4, 8) + "-" + obj.value.substring(8);
    }
    else {
        obj.value = '';
        obj.focus();
    }
}

/**
 * เปลี่ยนรูปแบบของ licId ให้อยู่ในรูปแบบ XXXX-XXX-X, XXXX-XXXX-X
 *onblur
 */
function addTinFormat(obj) {
    if (obj.value == '') {
        return;
    }
    else if (obj.value.length == 10) {
        obj.value = obj.value.substring(0, 1) + "-" + obj.value.substring(1, 5) + "-" + obj.value.substring(5, 9) + "-" + obj.value.substring(9);
    }
    else {
        obj.value = '';
        obj.focus();
    }
}

/**
 * เปลี่ยนรูปแบบของ licId ให้อยู่ในรูปแบบ XXXX-XXX-X, XXXX-XXXX-X
 *onblur
 */
function addPinFormat(obj) {
    if (obj.value == '') {
        return;
    }
    else if (obj.value.length == 13) {
        obj.value = obj.value.substring(0, 1) + "-" + obj.value.substring(1, 5) + "-" + obj.value.substring(5, 10) + "-" + obj.value.substring(10, 12) + "-" + obj.value.substring(12, 13);
    }
    else {
        obj.value = '';
        obj.focus();
    }
}

/*
	function ตรวจสอบว่า เป็นวันที่ที่ไม่เกินวันที่ปัจจุบัน
	input อยู่ในรูปแบบ dd/mm/yyyy
*/
function isBeforeTodayReg(obj) {
    var msg = "";
    if (obj.value.length == 10) {
        var today = new Date();
        today = servDate;

        var dateEntry = new Date((obj.value.substring(6, 10) - 543), (obj.value.substring(3, 5) - 1), obj.value.substring(0, 2));
        if (today < dateEntry) {
            obj.value = "";
            alert(showMsg(E0029));
            obj.focus();
        }
    }
}

function compareOffcode(offcode, facOffcode) {
    if (facOffcode == "xxxxxx") {
        return true;
    }
    else if (offcode.substring(4) == "00") {
        if (offcode.substring(0, 4) != facOffcode.substring(0, 4))
            return false;
        else 
            return true;
    }
    else {
        if (offcode != facOffcode)
            return false;
        else 
            return true;
    }
}

function regAddZeros(obj) {
    var dataTmp = "";
    for (var i = obj.value.length;i < 4;i++) {
        dataTmp += "0";
    }
    if (obj.value.length > 0)
        obj.value = dataTmp + obj.value;
    else 
        obj.value = "";
}

function checkRegIDOld(t) {
    var k = t.value.length;
    if (k == 10) {
        return true
    }
    else {
        if (k == 0) {
            return false;
        }
        else {
            //alert(showMsg(E4015)); 
            alert(showMsg(E0011) + "เลขทะเบียนสรรพสามิต(เก่า) ให้ครบ 10 หลัก");
            t.value = "";
            t.focus();
            return false;
        }
    }
}

/**
 * เปลี่ยนรูปแบบของ regId ให้อยู่ในรูปแบบ XXXX-XXXXX-X
 *onblur
 */
function addRegIdFormat1(val) {
    if (val == '') {
        return "";
    }
    else if (val.length == 10) {
        if (val.substring(0, 1) < 2) {
            return val.substring(0, 2) + "-" + val.substring(2, 4) + "-" + val.substring(4, 6) + "-" + val.substring(6);
        }
        else {
            return val.substring(0, 4) + "-" + val.substring(4, 9) + "-" + val.substring(9);
        }
    }
    else {
        return val
    }
}

function delRegIdFormat1(val) {
    var regExp = new RegExp("-", 'g');
    return val = val.replace(regExp, "");
}

function regAddZeros1(value) {
    var dataTmp = "";
    for (var i = value.length;i < 4;i++) {
        dataTmp += "0";
    }
    if (value.length > 0)
        value = dataTmp + value;
    else 
        value = "";
        
    return value;
}

/**
 * เปลี่ยนรูปแบบของ licId ให้อยู่ในรูปแบบ XXXX-XXX-X, XXXX-XXXX-X
 *onblur
 */
function addPinFormat(val) {
    if (val == '') {
        return;
    }
    else if (val.length == 13) {
        val = val.substring(0, 1) + "-" + val.substring(1, 5) + "-" + val.substring(5, 10) + "-" + val.substring(10, 12) + "-" + val.substring(12, 13);
    }else if(val.length == 17){
        val = val.substring(0, 1) +  val.substring(2, 6) +  val.substring(7, 12) +  val.substring(13, 15) +  val.substring(16, 17);
    }
    else {
        val = '';
    }
    return val;
}