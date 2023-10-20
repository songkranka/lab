//status_falg ??? Tracking , indexTracking = ??????
function setTracking(status_falg, indexTracking){//status_falg[????????? tracking],indexTracking[??????? tracking]
    showProductInfo(status_falg);//??? rtni0001
    var done ;
    if(status_falg != ""){
        for(i=1;i<=indexTracking;i++){
            if(i == status_falg){
                $("#Col"+i).removeClass("done_1").addClass("active_1");
            }else{
                $("#Col"+i).removeClass("active_1").addClass("done_1");
            }
            
            $("#done"+i).text("");
            if(i < status_falg || status_falg == 4){
                $("#done"+i).text(" เรียบร้อยแล้ว");
            }
            done = $("#done"+i).text();
        }
    }
    setCurrentStatus(status_falg,done);
}

function setHeaderModal(cus_fullname, recin_no, recin_date){
    $("#headerModal").text(cus_fullname+" "+recin_no+" "+recin_date);
}

function showProductInfo(status_falg){
    if(status_falg == 4){
        $("#productInfo").show();
    }else{
        $("#productInfo").hide();
    }
}

function setCurrentStatus(status_flag,done){
    $("#current_status").text("");  
    
    if(status_flag == 1){
        $("#current_status").text($("#text1").text()+done);
    }else if(status_flag == 2){
        $("#current_status").text($("#text2").text()+done);
    }else if(status_flag == 3){
        $("#current_status").text($("#text3").text()+done);
    }else if(status_flag == 4){
        $("#current_status").text($("#text4").text()+done);
    }
}