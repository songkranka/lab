"use strict";
app.controller('AuditPlanSavePeriodController', [
		'$scope',
		'$rootScope',
		'$compile',
		'$location',
		'BaseService',
		function($scope, $rootScope, $compile, $location, BaseService,
				HomeService, gantt) {

			$scope.cmbMonth = [ {
				value : "0",
				caption : 'ทั้งหมด'
			}, {
				value : "1",
				caption : 'มกราคม'
			}, {
				value : "2",
				caption : 'กุมภาพันธ์'
			}, {
				value : "3",
				caption : 'มีนาคม'
			}, {
				value : "4",
				caption : 'เมษายน'
			}, {
				value : "5",
				caption : 'พฤษภาคม'
			}, {
				value : "6",
				caption : 'มิถุนายน'
			}, {
				value : "7",
				caption : 'กรกฎาคม'
			}, {
				value : "8",
				caption : 'สิงหาคม'
			}, {
				value : "9",
				caption : 'กันยายน'
			}, {
				value : "10",
				caption : 'ตุลาคม'
			}, {
				value : "11",
				caption : 'พฤศจิกายน'
			}, {
				value : "12",
				caption : 'ธันวาคม'
			} ];
			$scope.selectedMonth = {
				value : "0",
				caption : 'ทั้งหมด'
			};

			$scope.data = [];
			$scope.cmbTeam = [];
			$scope.selectedTeam = {
				VALUE : "0",
				CAPTION : 'ทั้งหมด'
			};
			
			$scope.period = {"YEAR":'',"MONTH":'',"STDATE":'',"LSDATE":'',"USRUPDATE":''};

			angular.element(document).ready(
					function() {

						
						BaseService.getExtra("", "/get-audit-period-log")
								.then(function(response) {
									console.log(response)
									$scope.data = response.data;
									$scope.renderTable($scope.data);
								}, function(response) {
									console.log('error');
								});
						
						// Get L
						BaseService.getExtra("","/get-audit-period").then(
										function(response) {
											console.log(response)
											$scope.data = response.data;
											
											if($scope.data.length > 0)
												{
													$scope.period.YEAR = $scope.data[0].YEAR;
													$scope.period.STDATE = $scope.data[0].STR_DATE;
													$scope.period.LSDATE = $scope.data[0].END_DATE;
													$scope.period.MONTH = $scope.data[0].MONTH;
													$scope.selectedMonth.value = $scope.data[0].MONTH;
													
													console.log($scope.period);
												}
											
										},function(response) {console.log('error');
								});
					
						
						$('#data_5 .input-daterange').datepicker({
							keyboardNavigation : false,
							forceParse : false,
							autoclose : true,
							format : 'dd/mm/yyyy',
							startDate :  $scope.period.STDATE,
							endDate :  $scope.period.LSDATE
						});
					});
			
			
			var currentDate = new Date();
			var day = currentDate.getDate();
			var month = currentDate.getMonth() + 1;
			var year = currentDate.getFullYear();
			var currentDateStr = day + "/" + month + "/" + year;

			$scope.update_period = function() {
				var filter = {
					year : $scope.period.YEAR,
					month : $scope.selectedMonth.value,
					stdate : $scope.period.STDATE,
					lsdate : $scope.period.LSDATE,
					status : '1',
					createby : '999',
					createdate : currentDateStr,
					confirmby : '999',
					confirmdate : '',
					usrupdate : '999',
					lastupdate : currentDateStr,
					usrupdate : '999'
				}
				BaseService.save(filter, "/update-period").then(
						function (response){
							console.log(response)
							// BaseService.openNewTab('user/manage', null);
						},
						function (response){
							console.log('error');
						}
					);
			}

			$scope.renderTable = function(dataSource) {
				if (dataSource != null) {
					$scope.table = $('#table').dataTable(

					{
						"data" : dataSource,
						"columns" : [

						{
							"data" : "YEAR",

						}, {
							"data" : "MONTH",

						}, {
							"data" : "STR_DATE",

						}, {
							"data" : "END_DATE",

						}, {
							"data" : "CONFIRMBY",

						}, {
							"data" : "CONFIRM_DATE",

						} ],
						"columnDefs" : [ {
							"data" : null,
							"defaultContent" : "",
							"targets" : -1
						} ],
						"createdRow" : function(row, data, index) {
							$compile(row)($scope);
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

					// BaseService.generateRowNumber($scope.table, 0);
				}
			}

		} ]);