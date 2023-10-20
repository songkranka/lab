<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="<c:url value="/assets/css/settingTestScroll.css" />" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@8"></script>


<div class="modal progressModel" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      
      <div class="modal-body modal-bodycus">
      
      	โปรดรอ......
      
      </div>
      
    </div>
  </div>
</div>

<div class="modal addTestScrollModel" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title modal-titlecus">เพิ่มคะแนนสอบ</h5>
        <button type="button" class="close closecus" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <div class="clear"></div>
      </div>
      <div class="modal-body modal-bodycus">
      
      
      <div class="col-xs-12 col-md-12 boxGroupCus">
      	<div class="col-xs-12 col-md-3 text-right titleInputModel">บริษัท </div>
      	<div class="col-xs-12 col-md-9 text-left">
			<div class="form-group"> 
			    <label></label>
			    <input type="text" class="form-control inputCus" name="nameComp" placeholder="ชื่อบริษัท" >
		  	</div>
      	</div>
      </div>
      
      <div class="col-xs-12 col-md-12 boxGroupCus">
      	<div class="col-xs-12 col-md-3 text-right titleInputModel">ความรู้ทั่วไป (%) </div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group"> 
		    <label>Min&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="minGK" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group">
		    <label>Max&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="maxGK" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      </div>
      
      <div class="col-xs-12 col-md-12 boxGroupCus">
      	<div class="col-xs-12 col-md-3 text-right titleInputModel">เอพีไอ (%) </div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group"> 
		    <label>Min&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="minAPI" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group">
		    <label>Max&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="maxAPI" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      </div>
      
      <div class="col-xs-12 col-md-12 boxGroupCus">
      	<div class="col-xs-12 col-md-3 text-right titleInputModel">เอทานอล </div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group"> 
		    <label>Min&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="minATN" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group">
		    <label>Max&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="maxATN" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      </div>
      
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary savescore">Save</button>
        <button type="button" class="btn btn-secondary cancelModal" data-dismiss="modal">Cancel</button>
      </div>
    </div>
  </div>
</div>

<div class="modal updateTestScrollModel" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title modal-titlecus">แก้ไขคะแนนสอบ</h5>
        <button type="button" class="close closecus" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <div class="clear"></div>
      </div>
      <div class="modal-body modal-bodycus">
      
      
      <div class="col-xs-12 col-md-12 boxGroupCus">
      	<div class="col-xs-12 col-md-12 text-center titleInputModel">บริษัท : <label name="updatenameComp"></label> </div>
      	
      </div>
      
      <div class="col-xs-12 col-md-12 boxGroupCus">
      	<div class="col-xs-12 col-md-3 text-right titleInputModel">ความรู้ทั่วไป (%) </div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group"> 
		    <label>Min&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="updateminGK" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group">
		    <label>Max&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="updatemaxGK" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      </div>
      
      <div class="col-xs-12 col-md-12 boxGroupCus">
      	<div class="col-xs-12 col-md-3 text-right titleInputModel">เอพีไอ (%) </div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group"> 
		    <label>Min&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="updateminAPI" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group">
		    <label>Max&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="updatemaxAPI" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      </div>
      
      <div class="col-xs-12 col-md-12 boxGroupCus">
      	<div class="col-xs-12 col-md-3 text-right titleInputModel">เอทานอล </div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group"> 
		    <label>Min&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="updateminATN" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      	<div class="col-xs-12 col-md-4 text-left form-inline">
		  <div class="form-group">
		    <label>Max&nbsp;</label>
		    <input type="text" class="form-control inputCus" name="updatemaxATN" placeholder="0" min="0" maxlength="10" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" >
		  </div>
      	</div>
      </div>
      
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary updatescore">Update</button>
        <button type="button" class="btn btn-secondary cancelModal" data-dismiss="modal">Cancel</button>
      </div>
    </div>
  </div>
</div>

<div class="row wrapper border-bottom white-bg page-heading">
	<div class="col-lg-10">
	    <h2>ตั้งค่าคะแนนสอบ</h2>
	</div>
	<div class="col-lg-2"></div>
</div>

<div class="zoneBody">

	<div class="wrapper wrapper-btn text-right">
		<div class="row">
			<div class="col-xs-12 col-md-12 boxGroupCus">
		      	<div class="col-xs-5 col-md-5 text-right titleSelct"><strong> บริษัท : </strong></div>
		      	<div class="col-xs-3 col-md-3 text-left">
					<select class="form-control select5Inp" name="namecomp"> 
					  <option value="all">ทั้งหมด</option>
					</select>
		      	</div>
		      	<div class="col-xs-3 col-md-3 text-left">
		      		<button type="button" class="btn btn-primary seatchTypeComp">Search</button>
		      	</div>
		      </div>
		</div>
	</div>

	<div class="wrapper wrapper-btn text-right">
		<div class="row">
			<div class="col-xs-12">
				<button type="button" class="btn btn-primary addTestscroll">Create company</button>
			</div>
		</div>
	</div>
	
	
	<div class="wrapper wrapper-content animated fadeInRight"> 
		<div class="row">
			<div class="col-xs-12">
				<div class="table-responsive">
					<table   id="myTablePlaning" class="table table-striped table-bordered" style="width: 100%;" role="grid" aria-describedby="tableApproverTask_info" >
					 
						<thead>
							<tr class="tbHeader">
								<th class="text-center vertical_align_inherit">ลำดับ</th>
								<th class="text-center vertical_align_inherit">บริษัท</th>
								<th class="text-center multiheaderTable"> 
									<table class="table tableCus"> 
										<tr>
											<td class="text-center" colspan="2" style="border-top: 0px solid;" >ความรู้ทีั่วไป (%)</td>
										</tr>
										<tr>
											<td class="text-center" style="border-right: 1px solid #ffffff;" >MIN</td>
											<td class="text-center" >MAX</td>
										</tr>
									</table>
								</th>
								<th class="text-center multiheaderTable ">
									<table class="table tableCus"> 
										<tr>
											<td class="text-center" colspan="2" style="border-top: 0px solid;" >เอพีไอ (%)</td>
										</tr>
										<tr>
											<td class="text-center" style="border-right: 1px solid #ffffff;" >MIN</td>
											<td class="text-center" >MAX</td>
										</tr>
									</table>
								</th>
								<th class="text-center multiheaderTable ">
									<table class="table tableCus"> 
										<tr>
											<td class="text-center" colspan="2" style="border-top: 0px solid;" >เอทานอล</td>
										</tr>
										<tr>
											<td class="text-center" style="border-right: 1px solid #ffffff;" >MIN</td>
											<td class="text-center" >MAX</td>
										</tr>
									</table>
								</th>
								<th class="text-center vertical_align_inherit"></th>
							</tr>
						</thead>
						<tbody id=dteId>
						
						</tbody>
					
					</table> 
				</div>
			</div>
		</div>
	</div>

</div>

<script src="<c:url value="/assets/js/settingTestscore.js" />" type="text/javascript"></script>