"use strict";
app.controller('AuditTeamController', ['$scope', '$rootScope', '$compile', '$location', 'BaseService',
	function ($scope, $rootScope, $compile, $location, BaseService, HomeService, gantt) {

		$scope.team = {
			"TMCODE": '',
			"TMNAME": '',
			"TMLEVEL": '',
			"TMSUP_ID": '',
			"TMSUP_NAME": '',
			"TMPAR_CODE": '',
			"SET_APPRV": '',
			"USRUPDATE": ''
		};

		$scope.items = [];

		$scope.defaultData = {
			"cmbLine": null,
			"cmbTeam": null
		};
	
		$scope.cmbLine = [];

		$scope.cmbTeam = [];
		
		$scope.cmbTeamTmp = [];

		$scope.selectedLine = null;

		$scope.selectedTeam = null;

		angular.element(document).ready(function () {

			$('.accordian-body').on('show.bs.collapse', function () {
				$(this).closest("table")
					.find(".collapse.in")
					.not(this)
					.collapse('toggle')
			});

			BaseService.getExtra(filter, "/get-team").then(
				function (response) {
					$scope.data = response.data.data;
					$scope.createDataGroup();
				},
				function (response) {
					console.log('error');
				}
			);

			BaseService.getExtra(filter, "/get-cmb-team").then(
				function (response) {
					var items = response.data.data.cmd_tm_team;

					for (var i = 0; i < response.data.data.cmb_tm_line.length; i++) {
						var item = {
							"value": response.data.data.cmb_tm_line[i].VALUE,
							"caption": response.data.data.cmb_tm_line[i].CAPTION
						}
						$scope.cmbLine.push(item);
					}

					$scope.defaultData.cmbLine = angular.copy($scope.cmbLine);

					for (var i = 0; i < response.data.data.cmb_tm_team.length; i++) {
						var item = {
							"value": response.data.data.cmb_tm_team[i].VALUE,
							"caption": response.data.data.cmb_tm_team[i].CAPTION,
							"line": response.data.data.cmb_tm_team[i].LINE
						}
						//$scope.cmbTeam.push(item);
						$scope.cmbTeamTmp.push(item);
					}

					// $scope.defaultData.cmbTeam = angular.copy($scope.cmbTeam);

				},
				function (response) {
					console.log('error');
				}
			);

			var filter = null;
			$scope.search(filter);

		});

		$scope.search = function (filter) {
			//			console.log($scope.cmbTeam);
			//			console.log("selectedLine: ",$scope.selectedLine.value);
			//			console.log("selectedTeam: ", $scope.selectedTeam.value);
			//			var item = {"selectedLine": $scope.selectedLine.value,
			//						"selectedTeam": $scope.selectedTeam.value};
			//			}
			//			filter.push(item);
			var teamValue = $scope.selectedTeam;
			if(teamValue) {
				teamValue = teamValue.value;
			} else {
				teamValue = null;
			}
			
			if ($scope.selectedLine) {
				var filter = {
					"selected_line": $scope.selectedLine.value,
					"selected_team": teamValue
				};
			}

			BaseService.getExtra(filter, "/get-team").then(
				function (response) {
					$scope.data = response.data.data;
					$scope.createDataGroup();
				},
				function (response) {
					console.log('error');
				}
			);
		}

		$scope.createDataGroup = function () {
			var dataGroup = [];

			var rs = $scope.data;

			for (var i = 0; i < rs.length; i++) {
				var item = {
					"group_label": '',
					"group_item": []
				}

				if (!rs[i].TMPAR_CODE) {
					item.group_label = rs[i].TMCODE + '(' + rs[i].TMSUP_NAME + ')';
					item.group_tmcode = rs[i].TMCODE;
					dataGroup.push(item);
				}

			}

			for (var i = 0; i < dataGroup.length; i++) {
				var group_item = _.filter(rs, {
					'TMPAR_CODE': dataGroup[i].group_tmcode
				});
				dataGroup[i].group_item = group_item;
			}

			$scope.items = dataGroup;

		}

		$scope.displayDetail = function (e) {
			if ($(e.currentTarget.parentElement.parentElement.parentElement).children('.ibox-content').css('display') == 'none') {
				$(e.currentTarget.parentElement.parentElement.parentElement).children('.ibox-content').css({
					"display": ""
				});
			} else {
				$(e.currentTarget.parentElement.parentElement.parentElement).children('.ibox-content').css({
					"display": "none"
				});
			}
		}

		$scope.editTeam = function (data) {
			console.log(data);
		}

		$scope.addTeam = function (data) {
			console.log(data);
			var params = {
				tm_code: data.group_tmcode
			};
			BaseService.openNewTab('audit/team/route/add?route=1', params);
		}

		$scope.cmbLineChange = function () {
			var selectedLine = $scope.selectedLine
			if(!selectedLine){ return; }
			var teams = _.filter($scope.cmbTeamTmp, {
				'line': selectedLine.value
			});
			// console.log("teams: ",teams);
			$scope.cmbTeam = angular.copy(teams);
			// $scope.selectedTeam = teams[0];
		}

	}
]);