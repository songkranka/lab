(function( factory ) {
	if ( typeof define === "function" && define.amd ) {
		define( ["jquery", "../jquery.validate"], factory );
	} else {
		factory( jQuery );
	}
}(function( $ ) {

/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: TH (Thai; ��)
 */
$.extend($.validator.messages, {
	required: "�ô�к�",
	remote: "�ô������١��ͧ",
	email: "�ô�кط��������������١��ͧ",
	url: "�ô�к� URL ���١��ͧ",
	date: "�ô�к��ѹ��� ���١��ͧ",
	dateISO: "�ô�к��ѹ��� ���١��ͧ (�к� ISO).",
	number: "�ô�кطȹ������١��ͧ",
	digits: "�ô�кبӹǹ������١��ͧ",
	creditcard: "�ô�к����ʺѵ��ôԵ���١��ͧ",
	equalTo: "�ô�кؤ������ա����",
	extension: "�ô�кؤ�ҷ������ǹ���·��١��ͧ",
	maxlength: $.validator.format("�ô�����кؤ�ҷ����ǡ��� {0} �ѡ���"),
	minlength: $.validator.format("�ô�����кؤ�ҷ����鹡��� {0} �ѡ���"),
	rangelength: $.validator.format("�ô�����кؤ�Ҥ�����������ҧ {0} �֧ {1} �ѡ���"),
	range: $.validator.format("�ô�кؤ�������ҧ {0} ��� {1}"),
	max: $.validator.format("�ô�кؤ�ҹ��¡���������ҡѺ {0}"),
	min: $.validator.format("�ô�кؤ���ҡ����������ҡѺ {0}"),
        validDateThai: "�ٻẺ�ѹ������١��ͧ",
        validDateEng: "�ٻẺ�ѹ������١��ͧ",
        beforeTodayThai: "�ѹ�����ѹ�֡��ͧ���¡���������ҡѺ�ѹ���Ѩ�غѹ",
        beforeTodayEng: "�ѹ�����ѹ�֡��ͧ���¡���������ҡѺ�ѹ�����к�",
        afterTodayThai : "�ѹ�����ѹ�֡��ͧ�ҡ�����ѹ���㹻Ѩ�غѹ",
        afterTodayEng : "�ѹ�����ѹ�֡��ͧ�ҡ�����ѹ�����к�",
        validYearThai : "�� �.�. ����кص�ͧ���������ҧ �� �.�. 2450 - �.�. 2599",
        validYearEng : "�� �.�. ����кص�ͧ���������ҧ �� �.�. 1907 - �.�. 2056",
        gSDate : "�ѹ�������ش��ͧ�ҡ�����ѹ����������",
        geSDate : "�ѹ�������ش��ͧ�ҡ����������ҡѺ�ѹ����������",
        lEDate : "�ѹ���������鹵�ͧ���¡����ѹ�������ش",
        leEDate : "�ѹ���������鹵�ͧ���¡���������ҡѺ�ѹ�������ش",
        afterETodayThai : "�ѹ�����ѹ�֡��ͧ�ҡ����������ҡѺ�ѹ���㹻Ѩ�غѹ",
        afterETodayEng : "�ѹ�����ѹ�֡��ͧ�ҡ����������ҡѺ�ѹ�����к�",
        yearThai: "�� �.�. ����кص�ͧ���������ҧ �� �.�. 2450 - �.�. 2599",
        yearEng: "�� �.�. ����кص�ͧ���������ҧ �� �.�. 1907 - �.�. 2056",
        minValue : $.validator.format("�ô�кؤ���ҡ���� {0}"),
        maxValue : $.validator.format( "�ô�кؤ�ҹ��¡��� {0}" ),
        minValueE : $.validator.format( "�ô�кؤ���ҡ����������ҡѺ {0}" ),
        maxValueE : $.validator.format( "�ô�кؤ�ҹ��¡���������ҡѺ {0}" )
});

}));