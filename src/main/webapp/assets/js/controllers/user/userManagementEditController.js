"use strict";
app.controller('UserManagementEditController', ['$scope', '$rootScope', '$compile', '$location', 'BaseService',
    function ($scope, $rootScope, $compile, $location, BaseService, HomeService, gantt) {
		
		$scope.data = [];
		
		$scope.user = {"USR_ID":'', "USR_NAME":'', "CODEMPID":'', "ORG_NAME":'', "POST_NAME":'', "EMAIL":'', "HIRE_DATE":'', "EXPIRE_DATE":'', "USER_ID":''};
		
		$scope.cmbPostName = [
			{ value: "เจ้าหน้าที่ตรวจสอบสาขา", caption: 'เจ้าหน้าที่ตรวจสอบสาขา' },
            { value: "เจ้าหน้าที่ปฏิบัติการ", caption: 'เจ้าหน้าที่ปฏิบัติการ' }
		];
		$scope.selectedPostName = { value: "เจ้าหน้าที่ตรวจสอบสาขา", caption: 'เจ้าหน้าที่ตรวจสอบสาขา' };
		
		$scope.cmbOrgName = [
			{ value: "แผนกตรวจสอบสาขา", caption: 'แผนกตรวจสอบสาขา' }
		];
		$scope.selectedOrgName = { value: "แผนกตรวจสอบสาขา", caption: 'แผนกตรวจสอบสาขา' };
		
		$scope.user = {"USR_ID":'', "USR_NAME":'', "CODEMPID":'', "ORG_NAME":'', "POST_NAME":'', "EMAIL":'', "HIRE_DATE":'', "EXPIRE_DATE":'', "USER_ID":''};
		
		
		angular.element(document).ready(function() {
			
			
			BaseService.getExtra("","/get-group").then(
					function(response) {
						console.log(response)
						$scope.cmbGroup = response.data;
					},
					function(
							response) {
						console
								.log('error');
					});

			var $image = $(".image-crop > img")
			$($image).cropper({
				aspectRatio : 1.618,
				preview : ".img-preview",
				done : function(data) {
					// Output the result
					// data for cropping
					// image.
				}
			});
		
			var $inputImage = $("#inputImage");
			if (window.FileReader) {
				$inputImage.change(function() {
							var fileReader = new FileReader(), files = this.files, file;
							if (!files.length) {
								return;
							}
		
							file = files[0];
							if (/^image\/\w+$/.test(file.type)) {
								fileReader
										.readAsDataURL(file);
								fileReader.onload = function() {
									$inputImage
											.val("");
									$image
											.cropper(
													"reset",
													true)
											.cropper(
													"replace",
													this.result);
								};
							} else {
								showMessage("Please choose an image file.");
							}
						});
			} else {
				$inputImage
						.addClass("hide");
			}

			
			
			var usr_id = BaseService.getParameterByName('usr_id');
			
			$('#data_1 .input-group.date').datepicker({
                todayBtn: "linked",
                format: 'dd/mm/yyyy',
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true
            });
			
			$('#data_2 .input-group.date').datepicker({
                todayBtn: "linked",
                format: 'dd/mm/yyyy',
                keyboardNavigation: false,
                forceParse: false,
                calendarWeeks: true,
                autoclose: true
            });
			
			if(usr_id){
				var filter = {"usr_id": usr_id};
				BaseService.getExtra(filter, "/get-user").then(
						function (response){
							console.log(response)
							$scope.data = response.data;
							
							if($scope.data && ($scope.data && $scope.data.length > 0)){
								var data = $scope.data[0];
								
								$scope.user.USR_ID = data.USR_ID;
								$scope.user.USR_NAME = data.USR_NAME;
								$scope.user.CODEMPID = data.CODEMPID;
								$scope.user.ORG_NAME = data.ORG_NAME;
								$scope.user.POST_NAME = data.POST_NAME;
								$scope.user.EMAIL = data.EMAIL;
								$scope.user.HIRE_DATE = data.HIRE_DATE;
								$scope.user.EXPIRE_DATE = data.EXPIRE_DATE;
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
			console.log($scope.user);
			
			$scope.user.POST_NAME = $scope.selectedPostName.value;
			$scope.user.ORG_NAME = $scope.selectedOrgName.value;
			
			BaseService.save($scope.user, "/update-user").then(
				function (response){
					console.log(response)
					$scope.data = response.data;
//					$scope.renderTable($scope.data);
					BaseService.openNewTab('user/manage', null);
				},
				function (response){
					console.log('error');
				}
			);
		}
		
		
	}
]);