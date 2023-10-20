"use strict";
app.controller('UserManagementController', ['$scope', '$rootScope', '$compile', '$location', 'BaseService',
    function ($scope, $rootScope, $compile, $location, BaseService, HomeService, gantt) {
		
	$scope.user = {"USR_ID":'', "USR_NAME":'', "CODEMPID":'', "ORG_NAME":'', "POST_NAME":'', "EMAIL":'', "HIRE_DATE":'', "EXPIRE_DATE":'', "USER_ID":''};
//		
		$scope.cmbStatus = [
			{ value: "Y", caption: 'ใช้งาน' },
            { value: "N", caption: 'ไม่ใช้งาน' }
		];
		$scope.selectedStatus = { value: "Y", caption: 'ใช้งาน' };
		
		$scope.selectedGroup = { GROUPID: "0", DESCRIPTION: 'ทั้งหมด' };
		
		
		angular.element(document).ready(function() {
	    	
			console.log('hello');
			
			BaseService.getExtra("", "/get-group").then(
					function (response){
						console.log(response)
						$scope.cmbGroup = response.data;
						
						var all = {  GROUPID: "0", DESCRIPTION: 'ทั้งหมด' };
						
						 $scope.cmbGroup.splice(0,0,all);
					},
					function (response){
						console.log('error');
					}
				);
			//$('.search-link').click()
			//$scope.renderGrid($scope.data);
			
//			BaseService.getExtra(null, "/get-branch").then(
//				function (response){
//					console.log(response)
//					$scope.data = response.data;
//					$scope.renderTable($scope.data);
//				},
//				function (response){
//					console.log('error');
//				}
//			);
			
//			$scope.alert();
	    });
		
		$scope.search = function(){
			var filter = {
					usr_id:$scope.user.USR_ID,
					enable:$scope.selectedStatus.value,
					group_id:$scope.selectedGroup.GROUPID
			}
			BaseService.getExtra(filter, "/get-user").then(
				function (response){
					console.log(response)
					$scope.data = response.data;
					$scope.renderTable($scope.data);
				},
				function (response){
					console.log('error');
				}
			);
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
                        "render": function(data, type, row){
                        	var url = currentUrl+'/user/manage/edit?usr_id='+row.USR_ID;
                        	return '<a href="'+url+'">  <i class="fa fa-pencil"></i></a>';
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
                        "data": "ENABLE",
                        "render": function(data, type, row){
                        	var result = '-';
                        	if(data && data == 'Y'){
                        		result = 'ใช้งาน';
                        	}else{
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