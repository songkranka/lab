var table = "";
var reqno = "";
$(document).ready(function () {
    inquiryPlaning();
});

function inquiryPlaning() {
    try {
        $('#dteId').html("");
        $('#myTablePlaning').DataTable().destroy();
        var data = {update_flg:"1"};
        setTimeout(function () {
            $.ajax({
                url: 'inquiryPlaning',
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(data),
                dataType: 'json',
                success: function (data) {
                    // alert(data.success);
                    if (data.success == 1) {
                        genTeble(data);
                    } else {
                        showMsgError(data.message);
                    }
                },
                error: function (e) {
                    showMsgError('เกิดข้อผิดพลาด');
                }
            });
        }, 1000);
    } catch (ex) {
        showMsgError(ex);
    }

}

function createPlaning() {
    window.location = "initPlaningDetail";
}

function genTeble(data) {
    var det = "";
    for (var i = 0; i < data.list.length; i++) {
        det += '<tr >';
        det += '<td class="text-left" >' + (i + 1) + '</td>';
        det += '<td class="text-center" ><a href="initPlaningDetail?tripId=' + (data.list[i].TRIP_ID == null ? "" : data.list[i].TRIP_ID) + '">' + (data.list[i].TRIP_ID == null ? "" : data.list[i].TRIP_ID) + '</a></td>';

        det += '<td class="text-left" >' + (data.list[i].TRIP_NAME == null ? "" : data.list[i].TRIP_NAME) + '</td>';
        det += '<td class="text-center" >' + (data.list[i].STATUS_DESC == null ? "" : data.list[i].STATUS_DESC) + '</td>';
        det += '<td class="text-center" >' + (data.list[i].CNT_STATION == null ? "" : data.list[i].CNT_STATION) + '</td>';
        det += '<td class="text-left" >' + (data.list[i].CREATE_BY == null ? "" : data.list[i].CREATE_BY) + '</td>';
        det += '<td class="text-center" >' + (data.list[i].STRCREATE_DATE == null ? "" : data.list[i].STRCREATE_DATE) + '</td>';
        det += '</tr>';
    }
    // alert(det);
    if (det == '') {
        det += '<tr> ';
        det += '<th colspan="7" class="text-center">--- ไม่พบข้อมูล ---</th> ';
        det += '</tr> ';
        $('#dteId').html(det);

    } else {
        $('#dteId').html(det);
        table = $('#myTablePlaning').DataTable({
            searching: true,
            responsive: true
        });
    }
}

