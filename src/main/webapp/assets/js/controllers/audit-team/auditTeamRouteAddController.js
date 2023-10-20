"use strict";
app.controller('AuditTeamRouteAddController', ['$scope', '$rootScope', '$compile', '$location', 'BaseService',
	function ($scope, $rootScope, $compile, $location, BaseService, HomeService, gantt) {


		$scope.team = {
			"TMCODE": '',
			"TMNAME": '',
			"TMLEVEL": '1',
			"TMSUP_ID": '',
			"TMSUP_NAME": '',
			"TMPAR_CODE": '',
			"SET_APPRV": '',
			"USRUPDATE": ''
		};

		$scope.user_team = {
			"TMCODE": '',
			"USR_ID": '',
			"IA_RECORDABLE": 'Y',
			"USRUPDATE": 'System',
		}

		$scope.pickerParam = {
			enable: 'Y'
		};

		$scope.pickerUserMemberParam = {
			enable: 'Y'
		};

		$scope.popupData = [];
		$scope.popupUserMemberData = [];

		$scope.user_team_list = [];

		$scope.selectedUser = {};
		$scope.selectedUserMember = {};


		angular.element(document).ready(function () {

			var tm_code = BaseService.getParameterByName('tm_code');
			$scope.team.TMPAR_CODE = tm_code;

			var filter = {
				"tmpar_code": tm_code,
			}
			BaseService.getExtra(filter, "/get-max-route-tmcode").then(
				function (response) {
					var data = response.data.data;

					if (data) {
						var data = data;
						$scope.team.TMCODE = data.TMCODE;
					}

				},
				function (response) {
					console.log('error');
				}
			);


			$scope.$apply();

		});

		$scope.save = function () {
			console.log('save');

			if (BaseService.validateForm('#form1')) {
				BaseService.save($scope.team, "/save-team").then(
					function (response) {
						console.log(response)
						$scope.data = response.data;
					},
					function (response) {
						console.log('error');
					}
				);
			}
		}

		$scope.saveMember = function () {
			console.log('saveMember');

			BaseService.save($scope.user_team, "/save-user-team").then(
				function (response) {
					console.log('success');
					$scope.user_team_list.push($scope.selectedUserMember);
					$scope.renderTableUserMember($scope.user_team_list);
				},
				function (response) {
					console.log('error');
				}
			);
		}

		$scope.inquiryClick = function () {
			BaseService.getExtra($scope.pickerParam, "/popup-get-user").then(
				function (response) {
					$scope.renderTableUserPopup(response.data.data);
				},
				function (response) {
					console.log('error');
				}
			);
		}

		$scope.inquiryMemberClick = function () {
			BaseService.getExtra($scope.pickerUserMemberParam, "/popup-get-user").then(
				function (response) {
					$scope.renderTableUserMemberPopup(response.data.data);
				},
				function (response) {
					console.log('error');
				}
			);
		}

		$scope.renderTableUserPopup = function (dataSource) {
			if (dataSource != null) {
				$scope.popupData = dataSource;
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

		$scope.renderTableUserMemberPopup = function (dataSource) {
			if (dataSource != null) {
				$scope.popupUserMemberData = dataSource;
				$scope.user_member_popup_table = $('#tb_popup_user_member').dataTable({
					"data": dataSource,
					"columns": [{
						"render": function (data, type, row) {
							var url = 'select';
							return '<button ng-click="popupSelectMember(\'' + row.USR_ID + '\')"><i class="fa fa-check-circle"></i></button>';
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

		$scope.renderTableUserMember = function (dataSource) {
			if (dataSource != null) {
				$scope.table_user_member = $('#table_user_member').dataTable({
					"data": dataSource,
					"columns": [{
						"render": function (data, type, row) {
							var url = currentUrl + '/user/manage/edit?usr_id=' + row.USR_ID;
							return '<button "><i class="fa fa-minus-circle"></i></button>';
						}

					}, {
						"data": "USR_ID",

					}, {
						"data": "USR_NAME",

					}, {
						"data": "POST_NAME",

					}, {
						"data": "ORG_NAME",

					}, {
						"data": "EMAIL",

					}, {
						"render": function (data, type, row) {
							var result = 'ปัจจุบัน';
							
							return result;
						},

					}, {
						"data": "ENABLE",
						"render": function (data, type, row) {
							var result = '-';
							if (data && data == 'Y') {
								result = 'ใช้งาน';
							} else {
								result = 'ไม่ใช้งาน';
							}
							return result;
						},

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

				BaseService.generateRowNumber($scope.table, 0);
			}
		}

		$scope.popupSelect = function (data) {
			var row = _.find($scope.popupData, 'USR_ID', data);
			$scope.selectedUser = row;

			$scope.team.TMSUP_ID = $scope.selectedUser.USR_ID;
			$scope.team.TMSUP_NAME = $scope.selectedUser.USR_NAME;
			$('#popup_user').modal('hide');
		}

		$scope.popupSelectMember = function (data) {
			var row = _.find($scope.popupUserMemberData, 'USR_ID', data);
			$scope.selectedUserMember = row;

			// $scope.team.TMSUP_ID = $scope.selectedUser.USR_ID;
			// $scope.team.TMSUP_NAME = $scope.selectedUser.USR_NAME;

			$scope.user_team.USR_ID = row.USR_ID;
			$scope.user_team.TMCODE = $scope.team.TMCODE;
			$scope.user_team.IA_RECORDABLE = 'Y';

			$scope.saveMember();

			$('#popup_user_member').modal('hide');
		}

		$scope.openPopupUser = function () {
			if ($scope.team.TMSUP_ID) {
				$scope.pickerParam.usr_id = angular.copy($scope.team.TMSUP_ID);
			} else {
				$scope.pickerParam.usr_id = "";
				$scope.pickerParam.usr_name = "";
			}

			if ($scope.user_popup_table != null) {
				$scope.user_popup_table.fnClearTable();
				$scope.user_popup_table.fnDestroy();
			}

			$('#popup_user').modal('show');
		}

		$scope.openPopupUserMember = function () {
			// if ($scope.team.TMSUP_ID) {
			// 	$scope.pickerUserMemberParam.usr_id = angular.copy($scope.team.TMSUP_ID);
			// } else {
			// 	$scope.pickerUserMemberParam.usr_id = "";
			// 	$scope.pickerUserMemberParam.usr_name = "";
			// }

			if ($scope.user_member_popup_table != null) {
				$scope.user_member_popup_table.fnClearTable();
				$scope.user_member_popup_table.fnDestroy();
			}

			$('#popup_user_member').modal('show');
		}
	}
]);