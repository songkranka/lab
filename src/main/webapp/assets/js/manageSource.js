var basePath = '/Lab/api/';
var backloc = "/Lab/assignment";
var backmanageSource = "/Lab/manageSource";
var pathImgSignuture = '';

$(document).ready(function () {

	getSourceDetail();

});

function getSourceDetail() {

	let datalist = '';
	try {
		$('#usertable').DataTable().destroy();
		$('#usertabledtail').html("");
		ShowWaiting();
		jQuery.ajax({
			url: 'util-getsourcedetail',
			type: "Get",
			contentType: "application/json",
			dataType: 'json',
			async: false,
			cache: false,
			success: function (data) {
				datalist = data.sourcelist;
				var det = "";
				var index = 0;
				for (var i = 0; i < datalist.length; i++) {
					index = index + 1;

					det += '<tr  class="TBODY">';
					det += '<td class="text-center">' + index + '</td>'
					det += '<td class="text-center"><input type="checkbox" id="check" name="check" value="' + datalist[i].SOURCE_ID + '" /></td>'
					det += '<td class="text-center">' + datalist[i].SOURCE_ID + '</td>'
					det += '<td class="text-center">' + datalist[i].SOURCE_NAME + '</td>'
					det += '<td class="text-center">' + datalist[i].CODCOMP + '</td>'
					det += '<td class="text-center"><button class="btn btn-warning" value="'
						+ datalist[i].SOURCE_ID + '|' + datalist[i].SOURCE_NAME + '|' + datalist[i].CODCOMP
						+ '" onclick="editModal(this.value)">แก้ไข</button></td>'

					det += '</tr>';
				}
				$('#usertabledtail').html(det);

				table = $('#usertable').DataTable({
					searching: true,
					responsive: true,
					"pageLength": 25,
					"paging": true
				});
				HideWaiting();
			},
			error: function () {
				showMsgError('ข้อมูลผิดพลาด');
				HideWaiting();
			}
		});
	} catch (ex) {
		showMsgError(ex);
		HideWaiting();
	}
}

function btnAddClick() {

	document.getElementById('submit_source').style.display = 'block';
	document.getElementById('editSource').style.display = 'none';
	document.getElementById('source_id').readOnly = false;
	document.getElementById('headertext4').innerHTML = 'เพิ่ม แหล่งที่มา';
	$('#modalAdd').modal({
		backdrop: 'static',
		keyboard: false
	});
}

function editModal(data) {

	let arr_txt = data.split('|');

	$("#source_id").val(arr_txt[0]);
	$("#source_name").val(arr_txt[1]);
	$("#codecomp").val(arr_txt[2]);

	document.getElementById('editSource').style.display = "block";
	document.getElementById('submit_source').style.display = 'none';
	document.getElementById('source_id').readOnly = true;
	document.getElementById('headertext4').innerHTML = 'แก้ไข แหล่งที่มา';
	$('#modalAdd').modal({
		backdrop: 'static',
		keyboard: false
	});
	showTextError('', '');
}
function saveSource(subpath) {

	var sourceId = $("#source_id").val();
	var sourceName = $("#source_name").val();
	var codcomp = $("#codecomp").val();

	var fd = new FormData($('#add_source')[0]);

	if (sourceId != '' && sourceName != '') {
		$.ajax({
			url: 'util-savesource/' + subpath,
			type: 'post',
			data: fd,
			contentType: false,
			processData: false,
			success: function (response) {
				$('#modalAddUser').modal('toggle');
				emptyModal();
				//alert(response.status);
				window.location = backmanageSource;
			}
		});
	} else {
		//alert('กรุณากรอกรหัสและชื่อของแหล่งที่มา !!!');
		var txterr1 = '';
		var txterr2 = '';

		if (sourceId == '') {
			txterr1 = 'Source Id is required';
		}
		if (sourceName == '') {
			txterr2 = 'Source Name is required';
		}
		showTextError(txterr1, txterr2);
	}
}

function onlyNumberKey(evt) {

	// Only ASCII character in that range allowed 
	var ASCIICode = (evt.which) ? evt.which : evt.keyCode
	if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
		return false;
	return true;
}

function showTextError(text1, text2) {

	if (text1 != '') {
		document.getElementById('text_error').style.display = "block";
		document.getElementById('text_error').innerHTML = text1;
	} else {
		document.getElementById('text_error').style.display = "none";
		document.getElementById('text_error').innerHTML = '';
	}
	if (text2 != '') {
		document.getElementById('text_error2').style.display = "block";
		document.getElementById('text_error2').innerHTML = text2;
	} else {
		document.getElementById('text_error2').style.display = "none";
		document.getElementById('text_error2').innerHTML = '';
	}
}

function deletesource() {
	var result = confirm("Want to delete?");
	if (result) {
		//Logic to delete the item

		let data = {};
		var itemmp_id = "";
		$("input[name='check']").each(function () {

			if ($(this).prop('checked')) {
				itemmp_id += "" + $(this).val() + ",";;

			}
		});
		itemmp_id = itemmp_id.substring(0, itemmp_id.length - 1);
		ShowWaiting();
		console.log(itemmp_id);
		data['source_id'] = itemmp_id;
		try {
			jQuery.ajax({
				url: 'util-deleteSource',
				type: "Post",
				contentType: "application/json",
				data: JSON.stringify(data),
				dataType: 'json',
				async: false,
				cache: false,
				success: function (data) {
					console.log(data);

					HideWaiting();
					window.location = backmanageSource;
				},
				error: function () {
					showMsgError('เกิดข้อผิดพลาด');
					HideWaiting();
				}
			});

		} catch (ex) {
			showMsgError(ex);
			HideWaiting();

		}
	}
}

function emptyModal() {

	$("#source_id").val('');
	$('#source_name').val('');
	$('#codecomp').val('');
}