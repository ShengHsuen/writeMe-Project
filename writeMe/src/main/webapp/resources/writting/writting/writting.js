'use strict';

	angular.module('myApp.writting', ['ngRoute'])

	.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/writting', {
	    templateUrl: 'resources/writting/writting/writting.html',
	    controller: 'WrittingCtrl'
	  });
	}])
	
	.controller('WrittingCtrl', ['$scope','$http',function($scope,$http) {
		$scope.name = "poi";
		$scope.sh = function(){
			console.log("I'm getting in"+$scope.written);
			$scope.getContent();
		}
		var getContent = function(){
			$scope.writting={
					"pageNumber": 0,
					"pageSize": 0,
					"direction": "",
					"sortBy": [""],
					"searchColumn": "string",
					"searchTerm": $scope.name,
					"writting": {
						"name" : "e",
						"description" : " a ",
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
			$http.post('writting/getWrittingContent',$scope.writting).success(function(response) {
				console.log("3 : "+response);
			});
		}
		
	}]);