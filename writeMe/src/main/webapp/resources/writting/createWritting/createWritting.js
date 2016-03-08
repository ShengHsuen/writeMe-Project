'use strict';

angular.module('myApp.createWritting', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createWritting', {
    templateUrl: 'resources/writting/createWritting/createWritting.html',
    controller: 'Create_WrittingCtrl'
  });
}])

.controller('Create_WrittingCtrl', ['$scope','$http',function($scope,$http,$upload) {
		$scope.navWritting = function(){
			var path = "/writeMe/app#/writting";
			window.location.href = path;
			createWritting();
			add();
		}
		
	    $scope.onFileSelect = function($files) {
	    	$scope.files = $files;
	    };
	    
		var createWritting = function(){
			for ( var i = 0; i < $scope.files.length; i++){
				var file = $scope.files[i];
				$scope.upload = $upload.upload({
					url : 'rest/protected/createWritting/create',
				})
			}
			$scope.writting={
					"pageNumber": 0,
					"pageSize": 0,
					"direction": "",
					"sortBy": [""],
					"searchColumn": "string",
					"searchTerm": $scope.name,
					"writting": {
						"name" : $scope.name,
						"description" : $scope.description,
						"cantUsers": $scope.cantUsers,
						"date": "2016-02-02",
						"likes": 0,
						"limit time": "2100-01-01",
						"numMaxCharacters": 10000,
						"numMinCharacters": 30,
						"published": false,
						"content": ""
						
					
					}
			};
			
			
			$scope.userHasWritting={
						  "pageNumber": 0,
						  "pageSize": 0,
						  "direction": "string",
						  "sortBy": [
						    "string"
						  ],
						  "searchColumn": "string",
						  "searchTerm": "string",
						  "userHasWritting": {
							  "dateModifie": "2016-02-02",
						      "statusColor": false,
						      "user_has_writtingId": 0,
						      "linkInvitation": "string",
						      "banned": false,
						      "dateCreate": "2016-02-02",
						      "invitationStatus": false
						}
						
			};
			$http.post('writting/create',$scope.writting).success(function(response) {
				console.log("1");
			});
			$http.post('writting/createUserHasWritting',$scope.userHasWritting).success(function(response) {
				console.log("2");
			});
			
		}
		

	
}]);
