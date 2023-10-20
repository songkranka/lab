"use strict";
app.controller('BranchManagementController', ['$scope', '$rootScope', '$compile', '$location', 'BaseService',
    function ($scope, $rootScope, $compile, $location, BaseService, HomeService, gantt) {
		
		$scope.gridList = null;
		
//		
		$scope.data = [];
		$scope.cmbAreaType = [];
		$scope.cmbModel = [];
		$scope.cmbArea = [];
		$scope.cmbDistrict = [];
		$scope.cmbSector = [];
		$scope.cmbProvince = [];
		$scope.cmbBranch = [];
		$scope.cmbSupervision = [];
		
		$scope.selectedAreaType = null;
		
		angular.element(document).ready(function() {
	    	
			console.log('hello');
			//$('.search-link').click()
			//$scope.renderGrid($scope.data);
			
			BaseService.getExtra(null, "/get-branch").then(
				function (response){
					console.log(response)
					$scope.data = response.data;
					$scope.renderTable($scope.data);
				},
				function (response){
					console.log('error');
				}
			);
			
//			$scope.alert();
	    });
		
		$scope.alert = function(){
			alert("say hi");
		}
		
		$scope.renderTable = function(dataSource) {
			if(dataSource != null){
				$scope.table = $('#table').dataTable({
                    "data": dataSource,
                    "columns": [{
                        "class": "no text-center",
                        "render": function(row, type, data){
                            return '';
                        }
                    }, {
                        "data": "BRANCH_CODE",
                        
                    }, {
                        "data": "BRANCH_NAME",
                        
                    }, {
                        "data": "BRANCH_MODEL",
                        
                    }, {
                        "data": "BRANCH_TYPE",
                        
                    }, {
                        "data": "BRANCH_OWNER",
                        
                    }, {
                        "data": "BRANCH_ADDR1",
                        
                    }, {
                        "data": "BRANCH_ADDR2",
                        
                    }, {
                        "data": "BRANCH_ADDR3",
                        
                    }, {
                        "data": "BRANCH_ADDR4",
                        
                    }],
                    "columnDefs": [{
                        "data": null,
                        "defaultContent": "",
                        "targets": -1
                    }],
                    "createdRow": function( row, data, index ) {
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