"use strict";
app.controller('AuditTeamAddController', ['$scope', '$rootScope', '$compile', '$location', 'BaseService',
	function ($scope, $rootScope, $compile, $location, BaseService, HomeService, gantt) {

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

		$scope.pickerParam = {
			enable: 'Y'
		};
		$scope.popupData = [];
		$scope.selectedUser = {};


		angular.element(document).ready(function () {

			BaseService.getExtraNoParam("/get-maxtmcode").then(
				function (response) {
					console.log(response)
					$scope.data = response.data.data

					if ($scope.data) {
						var data = $scope.data;
						$scope.team.TMCODE = data.TMCODE;
					}
					console.log($scope.team.TMCODE);

				},
				function (response) {
					console.log('error');
				}
			);

		});

		$scope.save = function () {
			console.log('save');

			if (BaseService.validateForm('#form1')) {
				BaseService.save($scope.team, "/save-team").then(
					function (response) {
						console.log(response)
						$scope.data = response.data;
						BaseService.openNewTab('audit/team', null);
					},
					function (response) {
						console.log('error');
					}
				);
			}

			//			if ($scope.team.TMNAME.trim() != "" && $scope.team.TMSUP_ID.trim() != "" && $scope.team.TMSUP_NAME.trim() != "") {
			//				console.log($scope.team);
			//				BaseService.save($scope.team, "/save-team").then(
			//					function (response) {
			//						console.log(response)
			//						$scope.data = response.data;
			//						//					$scope.renderTable($scope.data);
			//						BaseService.openNewTab('audit/team', null);
			//					},
			//					function (response) {
			//						console.log('error');
			//					}
			//				);
			//			} else {
			//				$('#btnCheck').click()
			//			}
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

		$scope.popupSelect = function (data) {
			var row = _.find($scope.popupData, 'USR_ID', data);
			$scope.selectedUser = row;

			$scope.team.TMSUP_ID = $scope.selectedUser.USR_ID;
			$scope.team.TMSUP_NAME = $scope.selectedUser.USR_NAME;
			$('#popup_user').modal('hide');
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
	}
]);