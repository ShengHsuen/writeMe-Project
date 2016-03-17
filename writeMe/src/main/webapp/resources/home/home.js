'use strict';

angular.module('myApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'resources/home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl', ['$scope','$http',function($scope,$http) {
	$scope.writting = [];
	$scope.user = [];
	$scope.updateHome = function(){
		$scope.writting = {"pageNumber": 0,
								"pageSize": 0,
								"direction": "",
								"sortBy": [""],
								"searchColumn": "string",
								"searchTerm": "",
								"user": {},
								"writting": {}	
								};
		$http.post('writting/getPublished',$scope.writting).success(function(response){
			console.log("home.js");
			$scope.writting = response.writting;
			$scope.user = response.user;
			//console.log("recibe usuario: " + $scope.user.author);
			//getUserPublished();
		});
		
		/*var getUserPublished = function(){
			$http.post('writting/getUserPublished',$scope.writting).success(function(response){
				console.log("user home.js");
				
				$scope.us = response.writting;
				getUserPublished();
			});
		}*/
	}
}]);