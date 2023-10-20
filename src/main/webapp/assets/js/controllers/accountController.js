var oTablePage01;
var msgAlert;
//msgAlert =document.getElementById("msgAlert").msGetInputContext();
$(document)
    .ready(
        function() {
//-------------Get Start from MSG_Code
            var i1 = document.getElementById('msgAlert');
            //var i2 = document.getElementById('i2');
            var __i = {'msgAlert' : document.getElementsByName("msgAlert")[0] };
            if(i1  && __i.user)
            {
                if(  __i.user.value.length >= 1 ) { i1.value = 'I0001'; } else { i1.value = 'E0001'; }

                //if(  __i.pass.value.length >= 1 ) { i2.value = ''; } else { i2.value = 'E0001'; }
            }
            msgAlert = i1;
            //---------------------

            oTablePage01= $("#tb_example");
           //("#msgAlert").val(); //document.formHidden.msg.value;//
            if(msgAlert!=null){
                alert("หน้าทดสอบ JS ที่ปลด angularJS แล้ว ให้เหลือแต่ Jquery 2.1.2 .min.js  by Garf danuphon. แลพ MsgCode I0001 = " +I0001 );
            }else if(msgAlert!=null && msgAlert==""){
                alert("หน้าทดสอบ JS ที่ปลด angularJS แล้ว ให้เหลือแต่ Jquery 2.1.2 .min.js  by Garf danuphon. แลพ MsgCode I0001 ( ยังไม่ถูกใช้งานเพราะเข้าหน้า login ครั้งแรก) = " + I0001);
            }else{
                alert("หน้าทดสอบ JS ที่ปลด angularJS แล้ว ให้เหลือแต่ Jquery 2.1.2 .min.js  by Garf danuphon.  = " + "( กรุณา กรอก Id , Password สำหรับ login ให้ถูกต้อง)");
               // alert("หน้าทดสอบ JS ที่ปลด angularJS แล้ว ให้เหลือแต่ Jquery 2.1.2 .min.js  by Garf danuphon. แลพ MsgCode E0001 Or Invalid your Id / Pssword = " + E0001);
            }
            // $("#form1").preparePage();


            $("#bottomform2B1").click(function(){//กำหนดผู้รับผิดชอบ
                $("#overlay ,#popup").show();
                bootbox.confirm("นี่เป็นหน้าต่าง Modal สำหรับทดสอบ ท่านต้องการเปิดหน้าต่างดูใช่หรือไม่", function(ret2) {
                    // $('#approveModal').modal('show');

                    setTimeout($("#form1").ChkAjax(), 30000)
                    $("#overlay ,#popup").hide();
                    // $.ajax({
                    //     url:   "http://localhost:8080/lab/AjaxInfo",
                    //     data : $("#form1").serialize()+"&mode=AjaxInfo",
                    //     dataType: "json",
                    //     type: "POST",
                    //     async : true,
                    //     success: function(json) {
                    //       alert("Ajax complete and A0001 = "+A0001)
                    //
                    //
                    //     },error : function (req, status, error) {
                    //       alert("error Ajax +"+E0001)
                    //     }
                    // });
                });

            });

            $("#bottomform2B2").click(function(){//กำหนดผู้รับผิดชอบ
                // bootbox.confirm("นี่เป็นหน้าต่าง Modal สำหรับทดสอบ ท่านต้องการเปิดหน้าต่างดูใช่หรือไม่", function(ret2) {
                    $('#approveModal').modal('show');
                // });

            });
            $("#loginbotttomB1").click(function(){//กำหนดผู้รับผิดชอบ
                //         //document.getElementById("form1").target = "";
        //  document.getElementById("form1").target = "_self";
        // document.form1.action = "http://localhost:8080/lab/loginPage";
        //
        // document.form1.submit();
                alert("login");
                $("#form1").submit();
        });

});
$.fn.ChkAjax = function(){


}
// $.fn.setTimeout = function(){
// setTimeout(function (){
// setTimeout (function(row){
//
//     // Something you want delayed.
//
// }, 5000);