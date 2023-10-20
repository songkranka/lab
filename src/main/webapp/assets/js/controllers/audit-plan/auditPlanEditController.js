"use strict";
app
		.controller(
				'AuditPlanEditController',
				[
						'$scope',
						'$rootScope',
						'$compile',
						'$location',
						'BaseService',
						function($scope, $rootScope, $compile, $location,
								BaseService, HomeService, gantt) {

							$scope.data = [];

							$scope.header = {"YEAR" : '',"MONTHSTR" : '',"STDATE" : '',
								"LSDATE" : '',"TMNAME" : '',"TMCODE" : '',"TMHEAD" : '',
								"LNAME" : '',"LCODE" : '',"LHEAD" : ''
							};

							angular.element(document).ready(
											function() {
												
												
												
												$('#data_5.input-daterange').datepicker(
																{
																	keyboardNavigation : false,
																	forceParse : false,
																	autoclose : true
																});
												
												var TMCODE = BaseService.getParameterByName('TMCODE');
												
												
												
												
												BaseService.getExtra("","/get-audit-period").then(
																	function(response) {
																		console.log(response)
																		$scope.data = response.data;

																		if ($scope.data.length > 0) {
																			$scope.header.YEAR = $scope.data[0].YEAR;
																			$scope.header.MONTHSTR = getMonthStr($scope.data[0].MONTH);
																			$scope.header.STDATE = $scope.data[0].STR_DATE;
																			$scope.header.LSDATE = $scope.data[0].END_DATE;
																		}
																		console.log($scope.header);
																	},
																	function(
																			response) {console.log('error');
																	});
												
												
												if (TMCODE) {
													var filter = {
														"tmcode" : TMCODE,
														"tmlevel" : '1'
													};
													BaseService.getExtra(filter,"/get-audit-teams-all").then(
																	function(response) {	
																		console.log(response)
																		$scope.data = response.data;
																		if ($scope.data.length > 0) {
																			$scope.header.TMNAME = $scope.data[0].TMNAME;
																			$scope.header.TMCODE = $scope.data[0].TMCODE;
																			$scope.header.TMHEAD = $scope.data[0].TMSUP_NAME;
																		}
																		console.log($scope.header);
																	},
																	function(response) {
																		console.log('error');
																	});
												}
												
												if (TMCODE) {
													var filter = {
														"tmcode" : TMCODE.substring(0,5),
														"tmlevel" : '2'
													};
													BaseService.getExtra(filter,"/get-audit-teams-all").then(
																	function(response) {	
																		console.log(response)
																		$scope.data = response.data;
																		if ($scope.data.length > 0) {
																			$scope.header.LNAME = $scope.data[0].TMNAME;
																			$scope.header.LCODE = $scope.data[0].TMCODE;
																			$scope.header.LHEAD = $scope.data[0].TMSUP_NAME;
																		}
																		console.log($scope.header);
																	},
																	function(response) {
																		console.log('error');
																	});
												}
												
												if (TMCODE) {
													var filter = {
														"tmcode" : TMCODE
													};
													BaseService.getExtra(filter,"/get-plan").then(
																	function(
																			response) {
																		console.log(response);
																		$scope.data = response.data;
																		$scope.createDataGroup();
																	},
																	function(response) {	
																		console.log('error');
																	});
												}
												
											});

							$scope.save = function() {
								console.log($scope.user);

								$scope.user.POST_NAME = $scope.selectedPostName.value;
								$scope.user.ORG_NAME = $scope.selectedOrgName.value;

								BaseService
										.save($scope.user, "/update-user")
										.then(
												function(response) {
													console.log(response)
													$scope.data = response.data;
													// $scope.renderTable($scope.data);
													BaseService
															.openNewTab(
																	'user/manage',
																	null);
												}, function(response) {
													console.log('error');
												});
							}
							
							var weekday = new Array(7);
							weekday[0] =  "อาทิตย์";
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
							
							$scope.createDataGroup = function() {
								var dataGroup = [];

								var rs = $scope.data;

								for (var i = 0; i < rs.length; i++) {
									// console.log(rs[i]);
									var item = {
										"group_label" : '',
										"daycolor" : '',
										"group_tgdate" : '',
										"group_item" : []
									}

									if (!rs[i].TMPAR_CODE) {
										
										var dateParts = rs[i].TARGET_DATE.split("/");
										var d = new Date(dateParts[2], dateParts[1] - 1, dateParts[0]);
										var wd = d.getDay();
										
										item.group_label = "วันที่ "+ rs[i].TARGET_DATE + ' ('+ weekday[wd] + ')' +" "+ getHoliday(rs[i].DAYTYPE);
										item.daycolor = weekdaycolor[wd];
										item.group_tgdate = rs[i].TARGET_DATE;
										
										
										
										dataGroup.push(item);
									}

								}

								for (var i = 0; i < dataGroup.length; i++) {
									var group_item = _.filter(rs,{
										'TARGET_DATE' : dataGroup[i].group_tgdate});
									
									for (var gi = 0; gi < group_item.length; gi++) {
										var tmpst = group_item[gi].AUD_STATUS;
										var txstat = tmpst+" : "+getAuditStatus(tmpst);
										group_item[gi].AUD_STATUS = txstat;
									}
									
									dataGroup[i].group_item = group_item;
								}

								$scope.items = dataGroup;

							}
							$scope.displayDetail = function(e) {
								if ($(
										e.currentTarget.parentElement.parentElement.parentElement)
										.children('.ibox-content').css(
												'display') == 'none') {
									$(
											e.currentTarget.parentElement.parentElement.parentElement)
											.children('.ibox-content').css({
												"display" : ""
											});
								} else {
									$(
											e.currentTarget.parentElement.parentElement.parentElement)
											.children('.ibox-content').css({
												"display" : "none"
											});
								}
							}
							
							
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
							$scope.addPlan = function (data) {
								console.log(data);
								var params = {
										TMCODE: $scope.header.TMCODE,
										PERIOD_DATE: data,
										PLNREFCODE : Math.floor((Math.random() * 1000) + 1)
								};
								BaseService.openNewTab('audit/plan/add?', params);
							}
							$scope.editPlan = function (data) {
								console.log(data);
								var params = {
										PLNREFCODE : data
								};
								BaseService.openNewTab('audit/plan/edit/detail?', params);
							}

						}

				]);