<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="<c:url value="/assets/css/settingTestScroll.css" />" rel="stylesheet">

<style>
.tbHeader {
	font-size:  9px;
	background: #3c8dbc;
	color: white;
}
.TBODY{
	font-size:  10px; 
}
.dtr-details{
	font-size:  10px; 
}
</style>
<!-- <div class="box box-success box-solid"> -->
<script type='text/javascript'>
var data_lab='';
var table = "";
var  reqno  = "",namestore="";
var flag="";
var array0='',array1='',array2='',array3='',array4='',array5='',array6='',array7='',array8='',array9='',array10='',item_name=[];
$(document).ready(function () {

	
	initTable();
	getValueWaitWork();
});
    function initTable(){
		table =  $('#producttb').DataTable( {
			"pageLength": 20,
			"columnDefs": [
			    { "orderable": false, "targets": 1 }
			  ]
		});
    }

function getValueWaitWork(){
	ShowWaiting() ;
	  var valueProduct="100000001,100000002,100000003,100000005,100000006,100000007,100000008,100000009,100000031,100000032,100000041";
	  var arr_valueProduct=valueProduct.split(',');
	  var jsondata={};
	  for(var i=0;i<arr_valueProduct.length;i++){
		  jsondata={};  
		  jsondata['productID']=arr_valueProduct[i];
	  
	  jQuery.ajax({
			url : 'util-getWaitwork',
			type : "Post", 
			contentType : "application/json",
			data : JSON.stringify(jsondata), 
			dataType : 'json',
			  async: false,
			   cache: false,
			success : function(data) {
				console.log(data);
				
				for(var k = 0;k<data.length;k++){
					var oldtxt='';
					var newtxr='';
					if(item_name.length!=23){
						item_name.push(data[k].ITEM_NAME);
					}
					oldtxt=$('#arr'+i).val();
					oldtxt+=data[k].count_item+',';
					$('#arr'+i).val(oldtxt);
	
				}
		
			},
			error : function() {
				 showMsgError('ข้อมูลผิดพลาด');
				
			
			}
		});
	  }
	  
	  inquiryWriteTable()
}
function inquiryWriteTable(){
	var det='';
	var sum=0;
	var txt_value0=$('#arr0').val();
	var txt_value1=$('#arr1').val();
	var txt_value2=$('#arr2').val();
	var txt_value3=$('#arr3').val();
	var txt_value4=$('#arr4').val();
	var txt_value5=$('#arr5').val();
	var txt_value6=$('#arr6').val();
	var txt_value7=$('#arr7').val();
	var txt_value8=$('#arr8').val();
	var txt_value9=$('#arr9').val();
	var txt_value10=$('#arr10').val();
	
	txt_value0=txt_value0.substring(0,txt_value0.length-1);
	txt_value1=txt_value1.substring(0,txt_value1.length-1);
	txt_value2=txt_value2.substring(0,txt_value2.length-1);
	txt_value3=txt_value3.substring(0,txt_value3.length-1);
	txt_value4=txt_value4.substring(0,txt_value4.length-1);
	txt_value5=txt_value5.substring(0,txt_value5.length-1);
	txt_value6=txt_value6.substring(0,txt_value6.length-1);
	txt_value7=txt_value7.substring(0,txt_value7.length-1);
	txt_value8=txt_value8.substring(0,txt_value8.length-1);
	txt_value9=txt_value9.substring(0,txt_value9.length-1);
	txt_value10=txt_value10.substring(0,txt_value10.length-1);
	
	var arr_value0=txt_value0.split(',');
	var arr_value1=txt_value1.split(',');
	var arr_value2=txt_value2.split(',');
	var arr_value3=txt_value3.split(',');
	var arr_value4=txt_value4.split(',');
	var arr_value5=txt_value5.split(',');
	var arr_value6=txt_value6.split(',');
	var arr_value7=txt_value7.split(',');
	var arr_value8=txt_value8.split(',');
	var arr_value9=txt_value9.split(',');
	var arr_value10=txt_value10.split(',');
  	  	try {
     		       $('#productdt').html("");
    		       $('#producttb').DataTable().destroy();
						
    		       for(var i=0;i<arr_value0.length;i++){
    		    	   sum=0;
    		    	   sum=parseInt(arr_value0[i])+parseInt(arr_value1[i])+parseInt(arr_value2[i])+parseInt(arr_value3[i])+parseInt(arr_value4[i])+parseInt(arr_value5[i])+parseInt(arr_value6[i])+parseInt(arr_value7[i])
    		    	   +parseInt(arr_value8[i])+parseInt(arr_value9[i])+parseInt(arr_value10[i]);
    		    	   det +='<tr  class="TBODY">';
    		    	   det +='<td class="text-center" >'+item_name[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value0[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value1[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value2[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value3[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value4[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value5[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value6[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value7[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value8[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value9[i]+'</td>'
    		    	   det +='<td class="text-center" >'+arr_value10[i]+'</td>'
    		    	   det +='<td class="text-center" >'+sum+'</td>'
    		    	   det +='</tr>';
    		       }
    		       $('#productdt').html(det);

				table =  $('#producttb').DataTable( {
						"pageLength": 25,
						searching: true,
						responsive : false,
						"ordering": false
					});
    		       HideWaiting() ;  
 		} catch (ex) {
 			//swal(ex);
 			 showMsgError(ex);
 			HideWaiting() ;
 		}
     	 
     } 
 
    function gotoMain(){
    	window.location="home"; 
    } 



 
</script>
<input type="hidden" id="arr0"/>
<input type="hidden" id="arr1"/>
<input type="hidden" id="arr2"/>
<input type="hidden" id="arr3"/>
<input type="hidden" id="arr4"/>
<input type="hidden" id="arr5"/>
<input type="hidden" id="arr6"/>
<input type="hidden" id="arr7"/>
<input type="hidden" id="arr8"/>
<input type="hidden" id="arr9"/>
<input type="hidden" id="arr10"/>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>ทบทวนปริมาณงาน</h2>
       
    </div>
    <div class="col-lg-2"></div>
</div>


<div class="wrapper wrapper-content animated fadeInRight"> 
     
    
    <div class="row"> 
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">				    
	                       <div class="row">
		                        <div class="col-xs-12" >

		                             <div class="table-responsive"   >
								         <table   id="producttb" class="table table-striped table-bordered" style="padding: 0px;width:100%;">
											<thead  class="tbHeader">
											 
																		<tr>
																		
																		    <th  class="text-center">เครื่องมือ</th>
																		    <th  class="text-center">PT Max Diesel BASE</th>
																		    <th class="text-center">PT Max ULG 95</th>
																		    <th class="text-center">PT Max Gasohol 95</th>
																		    
																		     <th class="text-center">PT Max Gasohol 91</th>
									                                        <th class="text-center">PT Max Diesel B7</th>
									                                     <th class="text-center">PT Max Diesel B20</th>
									                                          <th class="text-center">PT Max Gasohol E20</th>
																		    
																	        <th class="text-center">PT Max Diesel B10</th> 
																	         <th class="text-center">สารเติมแต่งสำหรับ<br>กลุ่มน้ำมันดีเซล</th>
																	         <th class="text-center">สารเติมแต่งสำหรับ<br>กลุ่มน้ำมันเบนซิน</th>
																	        <th class="text-center">ไบโอดีเซล</th> 
																	         <th class="text-center">รวม</th> 
																		</tr>
											 </thead>
											<tbody id="productdt" > 
											</tbody>
										</table> 
									 </div>
		                        </div>
		                    </div>
               </div>
            </div> 
        </div>
    </div> 
	  <div class="form-group">
	      
	        <div class="col-sm-12">
	            <div class="col-sm-12">
		            <button type="button"
		                    class="btn btn-danger center-block"  style="width: 150px;" onclick="gotoMain()" 
		            >กลับไปหน้าหลัก&nbsp;
		                <i class="fa fa-reply" style="font-size:22px;color:orange"></i>
		            </button>
		       </div>
	        </div>
	        <!-- /.col -->
	 </div>

  </div>
 
 
  
 
