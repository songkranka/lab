"use strict";
app
		.controller(
				'AuditPlanEditDetailController',
				[
						'$scope',
						'$rootScope',
						'$compile',
						'$location',
						'BaseService',
						function($scope, $rootScope, $compile, $location,
								BaseService, HomeService, gantt) {

							
							
							$scope.data = [];

							$scope.tableMember = [];
							$scope.tableHistory = [];

							// Popup Filter
							$scope.pickerParam = {
								"BRCODE" : '',
								"BRNAME" : ''
							};
							$scope.popupDataBranch = [];
							$scope.selectedBranch = {};

							// Popup Combo
							$scope.pickerCmbDistinct = [];
							$scope.selectedCmbDistinct = {
								VALUE : "0",
								CAPTION : 'ทั้งหมด'
							};
							$scope.pickerCmbZone = [];
							$scope.selectedCmbZone = {
								VALUE : "0",
								CAPTION : 'ทั้งหมด'
							};
							$scope.pickerCmbProvince = [];
							$scope.selectedCmbProvince = {
								VALUE : "0",
								CAPTION : 'ทั้งหมด'
							};
							$scope.pickerCmbBusiness = [];
							$scope.selectedCmbBusiness = {
								VALUE : "0",
								CAPTION : 'ทั้งหมด'
							};

							$scope.header = {
								"YEAR" : '',
								"MONTHSTR" : '',
								"MONTH" : '',
								"PERIOD_DATE" : '',
								"PLNREFCODE" : '',
								"TMNAME" : '',
								"TMCODE" : '',
								"TMHEAD" : '',
								"BRCODE" : '',
								"BRNAME" : '',
								"BUSS" : '',
								"PATTERN" : '',
								"NUMBER" : '',
								"PLN_REMARK" : '',
								"SAVE_REMARK" : '',
								"PT_F" : '',
								"PT_C" : ''

							};

							$scope.plan = {
								"PLNREFCODE" : '',
								"TARGET_DATE" : '',
								"BR_CODE" : '',
								"BR_NAME" : '',
								"YEAR" : '',
								"MONTH" : '',
								"BUSINESS" : '',
								"PATTERN" : '',
								"ROUND_NO" : '',
								"TMCODE" : '',
								"CREATEBY" : '',
								"CREATEDATE" : '',
								"DAYTYPE" : ''
							};

							$scope.cmbStatus = [
								{"VALUE":'0',"CAPTION":'วางแผน'},
								{"VALUE":'1',"CAPTION":'เข้าตรวจสอบปกติ'},
								{"VALUE":'2',"CAPTION":'ยกเลิก'},
								{"VALUE":'3',"CAPTION":'ไปแล้วไม่ได้เข้าตรวจ'},
								{"VALUE":'4',"CAPTION":'เปลี่ยนแปลงสาขา'}
								
							];
							$scope.selectedStatus = {
								VALUE : "0",
								CAPTION : ''
							};

							$scope.cmbRemarkType = [];
							$scope.selectedRemarkType = {
								VALUE : "0",
								CAPTION : ''
							};

							$scope.dataTMem = [];
							
							//POPUP USER
							$scope.pickerParamUser = {
									enable: 'Y'
								};
							$scope.popupDataUser = [];
							$scope.selectedUser = {};
								
							$scope.team = {
									"TMCODE": '',
									"TMNAME": '',
									"TMLEVEL": '2',
									"TMSUP_ID": '',
									"TMSUP_NAME": '',
									"TMPAR_CODE": '',
									"SET_APPRV": '',
									"USRUPDATE": ''
								};
							

							angular
									.element(document)
									.ready(
											function() {

												var PLNREFCODE = BaseService
														.getParameterByName('PLNREFCODE');

												var filterp = {
													"plnrefcode" : PLNREFCODE
												};
												BaseService.getExtra(filterp,	"/get-plan")
														.then(
																function(
																		response) {
																	console.log(response)
																	$scope.data = response.data;

																	console.log($scope.data);

																	if ($scope.data.length > 0) {
																		$scope.header.MONTHSTR = getMonthStr($scope.data[0].MONTH);              

																		$scope.header.PLNREFCODE = $scope.data[0].PLNREFCODE;
																		$scope.header.PERIOD_DATE = $scope.data[0].TARGET_DATE;
																		$scope.header.BRCODE = $scope.data[0].BR_CODE;
																		$scope.header.BRNAME = $scope.data[0].BR_NAME;
																		$scope.header.YEAR = $scope.data[0].YEAR;
																		$scope.header.MONTH = $scope.data[0].MONTH;
																		$scope.header.BUSS = $scope.data[0].BUSINESS;
																		$scope.header.PATTERN = $scope.data[0].PATTERN;
																		$scope.header.NUMBER = $scope.data[0].ROUND_NO;
																		$scope.header.TMCODE = $scope.data[0].TMCODE;
																		$scope.header.CREATEBY = $scope.data[0].CREATEBY;
																		$scope.header.CREATEDATE = $scope.data[0].CREATEDATE;
																	}
																	console.log("header");
																	console.log($scope.header);
																},
																function(
																		response) {
																	console
																			.log('error');
																});

												BaseService
														.getExtra("",
																"/get-audit-team-member")
														.then(
																function(
																		response) {
																	console
																			.log(response)
																	$scope
																			.renderTableTMem(response.data);
																},
																function(
																		response) {
																	console
																			.log('error');
																});

											});

							var currentDate = new Date();
							var day = currentDate.getDate();
							var month = currentDate.getMonth() + 1;
							var year = currentDate.getFullYear();
							var currentDateStr = day + "/" + month + "/" + year;

							var weekday = new Array(7);
							weekday[0] = "อาทิตย์";
							weekday[1] = "จันทร์";
							weekday[2] = "อังคาร";
							weekday[3] = "พุธ";
							weekday[4] = "พฤหัส";
							weekday[5] = "ศุกร์";
							weekday[6] = "เสาร์";

							var weekdaycolor = new Array(7);
							weekdaycolor[0] = "red";
							weekdaycolor[1] = "#aa9b10";
							weekdaycolor[2] = "#ff748c";
							weekdaycolor[3] = "green";
							weekdaycolor[4] = "orange";
							weekdaycolor[5] = "blue";
							weekdaycolor[6] = "purple";

							function getHoliday(daytype) {
								if (daytype == "H") {
									return 'Holiday'
								} else {
									return ""
								}
							}

							function getMonthStr(month) {
								if (month == 1) {
									return 'มกราคม'
								} else if (month == 2) {
									return 'กุมภาพันธ์'
								} else if (month == 3) {
									return 'มีนาคม'
								} else if (month == 4) {
									return 'เมษายน'
								} else if (month == 5) {
									return 'พฤษภาคม'
								} else if (month == 6) {
									return 'มิถุนายน'
								} else if (month == 7) {
									return 'กรกฎาคม'
								} else if (month == 8) {
									return 'สิงหาคม'
								} else if (month == 9) {
									return 'กันยายน'
								} else if (month == 10) {
									return 'ตุลาคม'
								} else if (month == 11) {
									return 'พฤศจิกายน'
								} else if (month == 12) {
									return 'ธันวาคม'
								} else {
									return 'none'
								}
							}
							function getAuditStatus(status) {
								if (status == 1) {
									return 'เข้าตรวจสอบปกติ'
								} else if (status == 2) {
									return 'ยกเลิก'
								} else if (status == 3) {
									return 'ไปแล้วไม่ได้เข้าตรวจ'
								} else if (status == 4) {
									return 'เปลี่ยนแปลงสาขา'
								} else if (status == 0) {
									return 'วางแผน'
								} else {
									return 'none'
								}
							}

							$scope.openPopupBranch = function() {

								/*
								 * if ($scope.team.TMSUP_ID) {
								 * $scope.pickerParam.usr_id = angular
								 * .copy($scope.team.TMSUP_ID); } else {
								 * $scope.pickerParam.usr_id = "";
								 * $scope.pickerParam.usr_name = ""; }
								 */

								if ($scope.branch_popup_table != null) {
									$scope.branch_popup_table.fnClearTable();
									$scope.branch_popup_table.fnDestroy();
								}

								$('#popup_branch').modal('show');
							}

							$scope.inquiryClick = function() {

								var filter = {
									branch_code : $scope.pickerParam.BRCODE,
									branch_name : $scope.pickerParam.BRNAME,
									distinct : $scope.selectedCmbDistinct.VALUE,
									province : $scope.selectedCmbProvince.VALUE,
									zone : $scope.selectedCmbZone.VALUE,
									business_type : $scope.selectedCmbBusiness.VALUE
								}

								BaseService
										.getExtra(filter, "/get-audit-branch")
										.then(
												function(response) {

													console.log(response.data);
													$scope
															.renderTableBranchPopup(response.data);

												}, function(response) {
													console.log('error');
												});
							}
							$scope.renderTableBranchPopup = function(dataSource) {
								if (dataSource != null) {
									$scope.popupDataBranch = dataSource;
									$scope.branch_popup_table = $(
											'#tb_popup_branch')
											.dataTable(
													{
														"data" : dataSource,
														"columns" : [
																{
																	"render" : function(
																			data,
																			type,
																			row) {
																		var url = 'select';
																		return '<button ng-click="popupSelectBranch(\''
																				+ row.BRANCH_CODE
																				+ '\')"><i class="fa fa-check-circle"></i></button>';
																	}

																},
																{
																	"data" : "BUSINESS_TYPE",

																},
																{
																	"data" : "BRANCH_CODE",

																},
																{
																	"data" : "BRANCH_NAME",

																},
																{
																	"data" : "REF_CODE",

																},
																{
																	"data" : "REF_CODE",

																},
																{
																	"data" : "REF_CODE",

																},
																{
																	"data" : "DISTRICT",

																},
																{
																	"data" : "ZONE",

																},
																{
																	"data" : "PROVINCE",

																} ],
														"columnDefs" : [ {
															"data" : null,
															"defaultContent" : "",
															"targets" : -1
														} ],
														"createdRow" : function(
																row, data,
																index) {
															$compile(row)(
																	$scope);
														},
														"bDestroy" : true,
														"bSort" : false,
														"paging" : true,
														"filter" : false,
														"info" : false,
														"dom" : 'Zlfrtip',
														"colResize" : {
															"tableWidthFixed" : false
														}
													});

								}
							}

							$scope.renderTableTMem = function(dataSource) {
								if (dataSource != null) {
									$scope.dataTMem = dataSource;

									console.log("render Tmem");
									$scope.dataTMem = $('#tableMember')
											.dataTable(
													{
														"data" : dataSource,
														"columns" : [

																{
																	"data" : "USR_ID",
																},
																{
																	"data" : "USR_NAME",
																},
																{
																	"data" : "LEAVE_DESC",
																},
																{
																	"data" : "REMARK",
																},
																{
																	"data" : "LASTUPDATE",
																} ],
														"columnDefs" : [ {
															"data" : null,
															"defaultContent" : "",
															"targets" : -1
														} ],
														"createdRow" : function(
																row, data,
																index) {
															$compile(row)(
																	$scope);
														},
														"bDestroy" : true,
														"bSort" : false,
														"paging" : true,
														"filter" : false,
														"info" : false,
														"dom" : 'Zlfrtip',
														"colResize" : {
															"tableWidthFixed" : false
														}
													});

								}
							}
							$scope.popupSelectBranch = function(data) {

								console.log("in popupSelectBranch : " + data)
								var row = _.find($scope.popupDataBranch,
										'BRANCH_CODE', data);
								$scope.selectedBranch = row;

								console.log($scope.selectedBranch)

								$scope.header.BRCODE = $scope.selectedBranch.BRANCH_CODE;
								$scope.header.BRNAME = $scope.selectedBranch.BRANCH_NAME;
								$scope.header.BUSS = $scope.selectedBranch.BUSINESS_TYPE;
								// $scope.header.PATTERN = '0';
								// $scope.header.NUMBER = '1';
								// $scope.header.PLN_REMARK = '';

								$('#popup_branch').modal('hide');
							}

							$scope.savePlan = function() {
								// if (BaseService.validateForm('#form1')) {

								$scope.plan.PLNREFCODE = $scope.header.PLNREFCODE;
								$scope.plan.TARGET_DATE = $scope.header.PERIOD_DATE;
								$scope.plan.BR_CODE = $scope.header.BRCODE;
								$scope.plan.BR_NAME = $scope.header.BRNAM;
								$scope.plan.YEAR = $scope.header.YEAR;
								$scope.plan.MONTH = $scope.header.MONTH;
								$scope.plan.BUSINESS = $scope.header.BUSS;
								$scope.plan.PATTERN = $scope.header.PATTERN;
								$scope.plan.ROUND_NO = $scope.header.NUMBER;
								$scope.plan.TMCODE = $scope.header.TMCODE;
								$scope.plan.CREATEBY = '1';
								$scope.plan.CREATEDATE = currentDateStr;
								$scope.plan.DAYTYPE = '';

								console.log($scope.plan);

								BaseService.save($scope.plan, "/save-plan")
										.then(function(response) {
											console.log(response)
											$scope.data = response.data;

											// BaseService.openNewTab('user/manage',null);
										}, function(response) {
											console.log('error');
										});
								// }
							}
							
							
							//POPUP USER
							$scope.inquiryClickUser = function () {
								BaseService.getExtra($scope.pickerParam, "/popup-get-user").then(
									function (response) {
										$scope.renderTableUserPopup(response.data.data);
									},
									function (response) {
										console.log('error');
									}
								);
							}
							$scope.renderTableUserPopup = function (dataSource) {
								if (dataSource != null) {
									$scope.popupDataUser = dataSource;
									$scope.user_popup_table = $('#tb_popup_user').dataTable({
										"data": dataSource,
										"columns": [{
											"render": function (data, type, row) {
												var url = 'select';
												return '<button ng-click="popupSelect(\'' + row.USR_ID + '\')"><i class="fa fa-check-circle"></i></button>';
											}

										}, {
											"data": "USR_ID",

										}, {
											"data": "USR_NAME",

										}, {
											"data": "POST_NAME",

										}, {
											"data": "ORG_NAME",

										}],
										"columnDefs": [{
											"data": null,
											"defaultContent": "",
											"targets": -1
										}],
										"createdRow": function (row, data, index) {
											$compile(row)($scope);
										},
										"bDestroy": true,
										"bSort": false,
										"paging": true,
										"filter": false,
										"info": false,
										"dom": 'Zlfrtip',
										"colResize": {
											"tableWidthFixed": false
										}
									});

								}
							}

							$scope.popupSelect = function (data) {
								var row = _.find($scope.popupDataUser, 'USR_ID', data);
								$scope.selectedUser = row;
								console.log($scope.selectedUser);
								//$scope.team.TMSUP_ID = $scope.selectedUser.USR_ID;
								//$scope.team.TMSUP_NAME = $scope.selectedUser.USR_NAME;
								
								
								
								$('#popup_user').modal('hide');
							}

							$scope.openPopupUser = function () {
								if ($scope.team.TMSUP_ID) {
									$scope.pickerParamUser.usr_id = angular.copy($scope.team.TMSUP_ID);
								} else {
									$scope.pickerParamUser.usr_id = "";
									$scope.pickerParamUser.usr_name = "";
								}

								if ($scope.user_popup_table != null) {
									$scope.user_popup_table.fnClearTable();
									$scope.user_popup_table.fnDestroy();
								}

								$('#popup_user').modal('show');
							}
							
							
							$scope.Back = function() {
								  window.history.back();
								};

						}

				]);