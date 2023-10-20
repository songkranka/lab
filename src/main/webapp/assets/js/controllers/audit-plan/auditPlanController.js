"use strict";
app
		.controller(
				'AuditPlanController',
				[
						'$scope',
						'$rootScope',
						'$compile',
						'$location',
						'BaseService',
						function($scope, $rootScope, $compile, $location,
								BaseService, HomeService, gantt) {

							$scope.audit_plan = {
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
								"UPDATEBY" : '',
								"LASTUPDATE" : '',
								"AUDCF_BY" : '',
								"AUDDATE" : '',
								"AUD_STATUS" : '',
								"REMARK_BY_ADMIN" : '',
								"REMARK_BY_AUDIT" : '',
								"AUDITBY" : '',
								"AUD_LASTUPDATE" : '',
								"STDATE" : '',
								"LSDATE" : ''
							};

							$scope.audit_team = {
								"TMCODE" : '',
								"TMNAME" : '',
								"TMLEVEL" : '',
								"TMSUP_ID" : '',
								"TMSUP_NAME" : '',
								"TMPAR_CODE" : '',
								"SET_APPRV" : '',
								"USRUPDATE" : '',
								"LASTUPDATE" : ''
							};

							$scope.last_rounded = "-";
							//		
							/*
							 * $scope.cmbTeam = [ { value: "0", caption:
							 * 'ทั้งหมด' }, { value: "1", caption: 'ทีม1' }, {
							 * value: "2", caption: 'ทีม2' } ];
							 */
							$scope.data = [];
							$scope.cmbTeam = [];
							$scope.selectedTeam = {
								VALUE : "0",
								CAPTION : 'ทั้งหมด'
							};

							angular
									.element(document)
									.ready(
											function() {

												$('#data_5 .input-daterange')
														.datepicker(
																{
																	keyboardNavigation : false,
																	forceParse : false,
																	autoclose : true
																});
												// Get Combo
												BaseService
														.getExtra("",
																"/get-combo-audit-teams-lv1")
														.then(
																function(
																		response) {
																	console
																			.log(response)
																	$scope.cmbTeam = response.data;
																	console
																			.log(response.data);
																	var all = {
																		VALUE : "0",
																		CAPTION : 'ทั้งหมด'
																	};
																	$scope.cmbTeam
																			.splice(
																					0,
																					0,
																					all);
																},
																function(
																		response) {
																	console
																			.log('error');
																});

												// Get L
												BaseService.getExtra("","/get-audit-period").then(
																function(response) {
																	console.log(response)
																	$scope.data = response.data;
																	
																	if($scope.data.length > 0)
																		{
																		$scope.last_rounded = $scope.data[0].YEAR+'/'
																		+$scope.data[0].MONTH+' ('+$scope.data[0].STR_DATE+' '+$scope.data[0].END_DATE+')'
																		}
																	
																},function(response) {console.log('error');
														});

											});

							$scope.search = function() {
								var filter = {
									tmper_code : $scope.selectedTeam.VALUE
								}
								BaseService.getExtra(filter,
										"/get-audit-teams-all").then(
										function(response) {
											console.log(response)

											$scope.data = response.data;
											$scope.renderTable($scope.data);
										}, function(response) {
											console.log('error');
										});
							}

							$scope.renderTable = function(dataSource) {
								if (dataSource != null) {
									$scope.table = $('#table').dataTable(
													{
														"data" : dataSource,
														"columns" : [
																{
																	"render" : function(
																			data,
																			type,
																			row) {
																		var url = currentUrl
																				+ '/audit/plan/edit?TMCODE='
																				+ row.TMCODE;
																		return '<a href="'
																				+ url
																				+ '">  <i class="fa fa-pencil"></i></a>';
																	}

																},
																{
																	"data" : "TMCODENAME",

																},
																{
																	"data" : "TMSUP_NAME",

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

									// BaseService.generateRowNumber($scope.table,
									// 0);
								}
							}

						} ]);