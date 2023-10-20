(function( factory ) {
	if ( typeof define === "function" && define.amd ) {
		define( ["jquery", "../jquery.validate"], factory );
	} else {
		factory( jQuery );
	}
}(function( $ ) {

/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: TH (Thai; ไทย)
 */
$.extend($.validator.messages, {
	required: "โปรดระบุ",
	remote: "โปรดแก้ไขให้ถูกต้อง",
	email: "โปรดระบุที่อยู่อีเมล์ที่ถูกต้อง",
	url: "โปรดระบุ URL ที่ถูกต้อง",
	date: "โปรดระบุวันที่ ที่ถูกต้อง",
	dateISO: "โปรดระบุวันที่ ที่ถูกต้อง (ระบบ ISO).",
	number: "โปรดระบุทศนิยมที่ถูกต้อง",
	digits: "โปรดระบุจำนวนเต็มที่ถูกต้อง",
	creditcard: "โปรดระบุรหัสบัตรเครดิตที่ถูกต้อง",
	equalTo: "โปรดระบุค่าเดิมอีกครั้ง",
	extension: "โปรดระบุค่าที่มีส่วนขยายที่ถูกต้อง",
	maxlength: $.validator.format("โปรดอย่าระบุค่าที่ยาวกว่า {0} อักขระ"),
	minlength: $.validator.format("โปรดอย่าระบุค่าที่สั้นกว่า {0} อักขระ"),
	rangelength: $.validator.format("โปรดอย่าระบุค่าความยาวระหว่าง {0} ถึง {1} อักขระ"),
	range: $.validator.format("โปรดระบุค่าระหว่าง {0} และ {1}"),
	max: $.validator.format("โปรดระบุค่าน้อยกว่าหรือเท่ากับ {0}"),
	min: $.validator.format("โปรดระบุค่ามากกว่าหรือเท่ากับ {0}"),
        validDateThai: "รูปแบบวันที่ไม่ถูกต้อง",
        validDateEng: "รูปแบบวันที่ไม่ถูกต้อง",
        beforeTodayThai: "วันที่ที่บันทึกต้องน้อยกว่าหรือเท่ากับวันที่ปัจจุบัน",
        beforeTodayEng: "วันที่ที่บันทึกต้องน้อยกว่าหรือเท่ากับวันที่ในระบบ",
        afterTodayThai : "วันที่ที่บันทึกต้องมากกว่าวันที่ในปัจจุบัน",
        afterTodayEng : "วันที่ที่บันทึกต้องมากกว่าวันที่ในระบบ",
        validYearThai : "ปี พ.ศ. ที่ระบุต้องอยู่ระหว่าง ปี พ.ศ. 2450 - พ.ศ. 2599",
        validYearEng : "ปี ค.ศ. ที่ระบุต้องอยู่ระหว่าง ปี ค.ศ. 1907 - พ.ศ. 2056",
        gSDate : "วันที่สิ้นสุดต้องมากกว่าวันที่เริ่มต้น",
        geSDate : "วันที่สิ้นสุดต้องมากกว่าหรือเท่ากับวันที่เริ่มต้น",
        lEDate : "วันที่เริ่มต้นต้องน้อยกว่าวันที่สิ้นสุด",
        leEDate : "วันที่เริ่มต้นต้องน้อยกว่าหรือเท่ากับวันที่สิ้นสุด",
        afterETodayThai : "วันที่ที่บันทึกต้องมากกว่าหรือเท่ากับวันที่ในปัจจุบัน",
        afterETodayEng : "วันที่ที่บันทึกต้องมากกว่าหรือเท่ากับวันที่ในระบบ",
        yearThai: "ปี พ.ศ. ที่ระบุต้องอยู่ระหว่าง ปี พ.ศ. 2450 - พ.ศ. 2599",
        yearEng: "ปี ค.ศ. ที่ระบุต้องอยู่ระหว่าง ปี ค.ศ. 1907 - พ.ศ. 2056",
        minValue : $.validator.format("โปรดระบุค่ามากกว่า {0}"),
        maxValue : $.validator.format( "โปรดระบุค่าน้อยกว่า {0}" ),
        minValueE : $.validator.format( "โปรดระบุค่ามากกว่าหรือเท่ากับ {0}" ),
        maxValueE : $.validator.format( "โปรดระบุค่าน้อยกว่าหรือเท่ากับ {0}" )
});

}));