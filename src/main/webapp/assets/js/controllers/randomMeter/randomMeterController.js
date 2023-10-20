/**
 * 
 */
function initSetOption(elename, element, source, current ) {
	for( var i = 0 ; i < source.length ; i++ )$("<option>").html(source[i].display).attr({"value" : source[i].value}).appendTo(element);
	element.attr("id",elename).addClass("form-control select2").val(current);
	return element;
}
var GLOBAL_PLANT_ID = [];
function initPlant(elename, element) {
	element.id = elename;
	element.attr("id",elename).addClass("form-control select2");
	$("<option>").val("ALL").html("====  เลือกคลัง  ====").appendTo(element);
	jQuery.ajax({
		url : 'util-getDropdownPlant',
		type : "Post", 
		contentType : "application/json",
		dataType : 'json',
		cache: false,
		success : function(data) {
			$.each(data, function (i, item) {
				$("<option>").val(item.PID).html(item.PID + " - " + item.PNAMET).appendTo(element);
				GLOBAL_PLANT_ID.push(item.PID);
		    });
		},
		error : function() {
			showMsgError('เกิดข้อผิดพลาด!');
		}
	});

	return element;
}
