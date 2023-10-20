var setltrUrl = "/Lab/setltrspec";
var setltdetailrUrl = "/Lab/setltrspecdetail";

$(document).ready(function() {


	getData();

});

function getData() {

	SetDropDownFeature()
	SetDropDownColor();
}

function btnSaveClick() {

	var fd = new FormData($('#frmltrspec')[0]);

	if (true) {

		$.ajax({
			url: 'util-updateLTRSpec',
			type: 'post',
			data: fd,
			contentType: false,
			processData: false,
			success: function(response) {

				window.location = setltrUrl;
			}
		});
	}
}

function btnBackClick() {

	window.location.href = setltrUrl;

}

function SetDropDownFeature() {

	var selectedValue = document.getElementById('txtFeature').value;

	var select = document.getElementById("ddlFeature");
	var options = [
		{ value: "ใส / ไม่มี ตะกอน", text: "ใส / ไม่มี ตะกอน" },
		{ value: "ใส / มี ตะกอน", text: "ใส / มี ตะกอน" },
		{ value: "ขุ่น / ไม่มี ตะกอน", text: "ขุ่น / ไม่มี ตะกอน" },
		{ value: "ขุ่น / มี ตะกอน", text: "ขุ่น / มี ตะกอน" }
	];

	for (var i = 0; i < options.length; i++) {
		var newOption = document.createElement("option");
		newOption.value = options[i].value;
		newOption.text = options[i].text;

		if (options[i].value === selectedValue) {
			newOption.selected = true;
		}

		select.appendChild(newOption);
	}
}

function SetDropDownColor() {
	var data = {}
	var selectedValue = document.getElementById('txtColor').value;
	jQuery.ajax({
		url: 'util-getDropDownSetupColor',
		type: "Post",
		contentType: "application/json",
		data: JSON.stringify(data),
		dataType: 'json',
		async: false,
		cache: false,
		success: function(data) {

			$('#ddlColor').find('option').remove().end();
			var select = document.getElementById('ddlColor');
			var opt = document.createElement('option');
			/*opt.value = "";
			opt.style = '';
			opt.innerHTML = "==เลือก==";
			select.appendChild(opt);*/

			var opt = "";
			// alert(data.length);
			for (var i = 0; i < data.length; i++) {
				var opt = document.createElement('option');
				opt.value = data[i].COLOR_NAME;
				opt.innerHTML = data[i].COLOR_NAME;

				if (data[i].COLOR_NAME === selectedValue) {
					opt.selected = true;
				}

				select.appendChild(opt);
			}
		},
	});

}

function validateInput(event) {
	var ASCIICode = (event.which) ? event.which : event.keyCode;
	if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57) && ASCIICode != 46) {
		event.preventDefault();
	}
	var value = event.target.value + String.fromCharCode(event.charCode);
	var regex = /^\d+(\.\d{0,2})?$/;
	if (!regex.test(value)) {
		event.preventDefault();
	}
}

