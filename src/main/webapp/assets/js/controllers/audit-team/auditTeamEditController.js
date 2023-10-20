"use strict";
app.controller('AuditTeamEditController', ['$scope', '$rootScope', '$compile', '$location', 'BaseService',
    function ($scope, $rootScope, $compile, $location, BaseService, HomeService, gantt) {
		
	$scope.team = {"TMCODE":'', "TMNAME":'', "TMLEVEL":'', "TMSUP_ID":'', "TMSUP_NAME":'', "TMPAR_CODE":'', "SET_APPRV":'', "USRUPDATE":''};
	
	$scope.user_team = {
			"TMCODE": '',
			"USR_ID": '',
			"IA_RECORDABLE": 'Y',
			"USRUPDATE": 'System',
		}
	
	$scope.selectedUserMember = {};
	
	$scope.user_team_list = [];
//	

	angular.element(document).ready(function() {
		var tmpar_code = BaseService.getParameterByName('tmpar_code');
		var tm_code = BaseService.getParameterByName('tm_code');
		//console.log("tm_code: ",tm_code);
			if(tm_code){
				var filter = {
						selected_line: tmpar_code
						,selected_team: tm_code
					};
				BaseService.getExtra(filter, "/get-team").then(
						function (response){
//							console.log("response: ", response)
							$scope.data = response.data.data;
							//console.log("data: ", $scope.data.data.length);
							if($scope.data && $scope.data.length > 0){
//								var data = $scope.data;
								var tmcode = "";
								var tmname = "";
								var tmpar_code = "";
								var tmpar_name = "";
								for(var i = 0; i < $scope.data.length; i++){
									var data = $scope.data[i];
//									console.log("data: ", data);									
									if(data.TMLEVEL == 1){
										tmcode = data.TMCODE;
										tmname = data.TMNAME;
									}else if(data.TMLEVEL == 2){
										tmpar_code = data.TMCODE
										tmpar_name = data.TMNAME;;
									}
								}
								$scope.team.TMCODE = tmcode;
								$scope.team.TMNAME = tmpar_name + "/" +tmname;
								$scope.team.TMPAR_CODE = tmpar_code;
								
								/*$scope.team.TMCODE = data.TMCODE;
								$scope.team.TMNAME = data.TMNAME;
								$scope.team.TMSUP_ID = data.TMSUP_ID;
								$scope.team.TMSUP_NAME = data.TMSUP_NAME;*/	
							}
							
						},
						function (response){
							console.log('error');
						}
					);
			}
//			setTimeout(() => {
//				$scope.selectedPostName = { value: "เจ้าหน้าที่ตรวจสอบสาขา", caption: 'เจ้าหน้าที่ตรวจสอบสาขา' };
//			}, 50);
			
	    });
		
		$scope.save = function(){
			console.log($scope.team);
			

			BaseService.save($scope.team, "/update-team").then(
				function (response){
					console.log(response)
					$scope.data = response.data;
//					$scope.renderTable($scope.data);
					BaseService.openNewTab('audit/team', null);
				},
				function (response){
					console.log('error');
				}
			);
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
		
	}
]);