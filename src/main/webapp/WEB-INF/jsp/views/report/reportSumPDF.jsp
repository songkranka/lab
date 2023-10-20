<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="../../assets/js/Chart.min.js" />"></script>
<script src="<c:url value="../../assets/js/html2canvas.js" />"></script>
<script src="<c:url value="../../assets/js/jspdf.min.js" />"></script>
<!--  --><script src="<c:url value="../../assets/js/jQuery.print.min.js" />"></script>


<style rel="stylesheet" type="text/css">
	@print{
	    @page :footer {color: #fff }
	    @page :header {color: #fff}
	}
</style>

<script type="text/javascript" >

	$(document).ready(function(){

		var monthStr = ['มกราคม','กุมภาพันธ์','มีนาคม','เมษายน','พฤษภาคม','มิถุนายน','กรกฎาคม','สิงหาคม','กันยายน','ตุลาคม','พฤศจิกายน','ธันวาคม'];
		var dt = new Date();
		var DateEditnow = "วันที่ "+dt.getDay()+" "+monthStr[dt.getMonth()-1]+" "+(dt.getFullYear()+543);
		var monthLook = "${MonthWatch}";

		$('.yearNow').html(dt.getFullYear()+543);
		$('.time').html(DateEditnow);

		if(monthLook=="1"){
			$('.proindate').html(monthStr[0]);
		}else{
			$('.proindate').html(monthStr[0]+" - "+monthStr[dt.getMonth()-1]);
		}

		var imgChart;
		var imgTable;
		var doc = new jsPDF('p', 'pt', 'a4', false);

		/* setTimeout(function(){

			html2canvas(document.querySelector(".reportbodyChart")).then(canvas => {
			    imgChart = canvas.toDataURL();
			    doc.addImage(canvas.toDataURL('image/png'), 'PNG', 0, 0,0,0);
			});

			html2canvas(document.querySelector(".reportbodyTable")).then(canvas => {
			    imgTable = canvas.toDataURL();
			    doc.addImage(canvas.toDataURL('image/png'), 'PNG', 0, 0,0,0);
			});

		},100); */

		/* console.log(imgChart);
		console.log(imgTable); */
		//doc.save('PTGReportSum.pdf');
		
	});

</script>

<div class="reportbody">

	<!-- Chart -->
	<table style="width:794px;height:1123px;margin-top:10px;" class="reportbodyChart">
		<tr style="height: 1%;font-size:16px;">
			<td colspan="2" style="text-align:center" ><strong> รายงานผลการปฏิบัติงานส่วนประกันคุณภาพประจำปี  <span class="yearNow"></span> </strong></td>
		</tr>
		<tr style="height: 1%;font-size:16px;">
			<td colspan="2" style="text-align:center" ><strong> กระบวนการ ตรวจสอบคุณภาพน้ำมันที่สถานีบริการ </strong></td>
		</tr>
		<tr style="height: 2.5%;font-size:16px;margin-bottom:10px;">
			<td style="text-align:center" > วันที่ปรับปรุงข้อมูล :     <span class="time"></span> </td>
			<td style="text-align:center" > ข้อมูลระหว่าง :  <span class="proindate"></span>  </td>
		</tr>
		<tr>
			<td colspan="2" style="height: 1%;text-indent:10px;font-size:10px;"> 
				<div style="margin-top: 10px;">1. จำนวนสถานีบริการที่ได้รับการตรวจสอบคุณภาพน้ำมัน </div> 
			</td> 
		</tr>
		<tr>
		
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_1"></canvas>
			</td>
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_2"></canvas>
			</td>
			
		</tr>
		<tr>
			<td style="height: 1%;text-indent:10px;font-size:10px;"> 2. ผลการตรวจสอบคุณภาพน้ำมัน สถานีบริการปิโตรเลียมไทยคอร์เปอเรชั่น (PTC)  </td> 
			<td style="height: 1%;text-indent:10px;font-size:10px;"> 2. ผลการตรวจคุณภาพน้ำมัน สถานีบริการเฟรนไชน์ (PTF)  </td> 
		</tr>
		<tr>
			
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_3"></canvas>
			</td>
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_4"></canvas>
			</td>
			
		</tr>
		<tr>
			<td style="height: 1%;text-indent:10px;font-size:10px;"> 3. ผลการรับน้ำมันของสถานีบริการเฟรนไชน์ (PTF)  </td> 
			<td style="height: 1%;text-indent:10px;font-size:10px;"> 4.ผลแสดงจำนวนสถานีบริการที่ผ่านการสอบคุณภาพเทียบกับข้อกำหนดกรมธุรกิจพลังงาน   </td> 
		</tr>
		<tr>
			
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_5"></canvas>
			</td>
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_6"></canvas>
			</td>
			
		</tr>
		<tr>
			<td style="height: 1%;text-indent:10px;font-size:10px;"> 5. เครื่องมือและอุปกรณ์ PTF  </td> 
			<td style="height: 1%;text-indent:10px;font-size:10px;"> 6. เครื่องมือและอุปกรณ์ PTF  </td> 
		</tr>
		<tr>
			
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_7"></canvas>
			</td>
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_8"></canvas>
			</td>
			
		</tr>
		<tr>
			<td style="height: 1%;text-indent:10px;font-size:10px;"> 7.การทดสอบ 5 ลิตร  </td> 
			<td style="height: 1%;text-indent:10px;font-size:10px;"> 8. ผลการฝึกอบรม  </td> 
		</tr>
		<tr>
			
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_9"></canvas>
			</td>
			<td style="width: 50%;height: 20%;" >
				<canvas id="Chart_10"></canvas>
			</td>
			
		</tr>
	</table>
	
	<!-- List -->
	<table style="width:794px;height:1123px;margin-top:10px;"  class="reportbodyTable">
	
		<tr style="height: 3%;">
			<td colspan="4" style="height: 1%;text-indent:10px;font-size:14px;"> 
				<div style="margin-top: 10px;margin-bottom: 10px;"><strong> รายชื่อสถานีบริการ PTF ที่ไม่รับน้ำมันจากบริษัท  </strong></div> 
			</td> 
		</tr>
		
		<tr style="text-align:center;height: 3%;">
		
			<td style="border: 1px solid;" > ชื่อสถานี </td>
			<td style="border: 1px solid;" > เขตการขาย </td>
			<td style="border: 1px solid;" > วันที่ตรวจสอบ </td>
			<td style="border: 1px solid;" > ผลิตภัณฑ์ที่ไม่รับ </td>
				
		</tr>
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="height: 3%;">
			<td colspan="4" style="height: 1%;text-indent:10px;font-size:14px;"> 
				<div style="margin-top: 10px;margin-bottom: 10px;"><strong> รายชื่อสถานีบริการที่ผลการทดสอบไม่ผ่านข้อกำหนด  </strong></div> 
			</td> 
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > ชื่อสถานี </td>
			<td style="border: 1px solid;" > เขตการขาย/เขตPTC	 </td>
			<td style="border: 1px solid;" > วันที่ตรวจสอบ	 </td>
			<td style="border: 1px solid;" > ผลิตภัณฑ์ที่ Off Spec	 </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
		<tr style="text-align:center;height: 2%;">
		
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
			<td style="border: 1px solid;" > - </td>
				
		</tr>
		
	</table>

</div>



<script>

$(document).ready(function(){
	
	perviewchat("Chart_1","horizontalBar",null);
	perviewchat("Chart_2","horizontalBar",null);
	perviewchat("Chart_3","bar",null);
	perviewchat("Chart_4","bar",null);
	perviewchat("Chart_5","bar",null);
	perviewchat("Chart_6","bar",null);
	perviewchat("Chart_7","bar",null);
	perviewchat("Chart_8","bar",null);
	perviewchat("Chart_9","bar",null);
	perviewchat("Chart_10","bar",null);
	
});

function perviewchat(IDcasvas,type,data){

	var ctx = document.getElementById(IDcasvas).getContext('2d');
	var myChart = new Chart(ctx, {
	    type: type,
	    data: {
	        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
	        datasets: [{
	            label: '# of Votes',
	            data: [12, 19, 3, 5, 2, 3],
	            backgroundColor: [
	                'rgba(255, 99, 132, 0.2)',
	                'rgba(54, 162, 235, 0.2)',
	                'rgba(255, 206, 86, 0.2)',
	                'rgba(75, 192, 192, 0.2)',
	                'rgba(153, 102, 255, 0.2)',
	                'rgba(255, 159, 64, 0.2)'
	            ],
	            borderColor: [
	                'rgba(255, 99, 132, 1)',
	                'rgba(54, 162, 235, 1)',
	                'rgba(255, 206, 86, 1)',
	                'rgba(75, 192, 192, 1)',
	                'rgba(153, 102, 255, 1)',
	                'rgba(255, 159, 64, 1)'
	            ],
	            borderWidth: 1
	        }]
	    },
	    options: {
	        scales: {
	            yAxes: [{
	                ticks: {
	                    beginAtZero: true
	                }
	            }]
	        }
	    }
	});
	
}

</script>