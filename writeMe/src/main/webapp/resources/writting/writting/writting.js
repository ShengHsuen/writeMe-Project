'use strict';

	angular.module('myApp.writting', ['ngRoute'])

	.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/writting', {
	    templateUrl: 'resources/writting/writting/writting.html',
	    controller: 'WrittingCtrl'
	  });
	}])
	
	.controller('WrittingCtrl', ['$scope','$http',function($scope,$http) {
		
		$scope.date = new Date();
		var anno = $scope.date.getFullYear();
		var mes = $scope.date.getMonth() + 1;
		var dia = $scope.date.getDate();
		var fecha = anno.toString() + "-" + mes.toString() + "-" + dia.toString();
		
		$scope.published = false;
		
		$scope.writting={
				"pageNumber": 0,
				"pageSize": 0,
				"direction": "",
				"sortBy": [""],
				"searchColumn": "string",
				"searchTerm": "fff",
				"writting": {
					"name" : "fff",
					"description" : "a",
					"cantUsers": 0,
					"date": fecha,
					"likes": 0,
					"limit time": "2100-01-01",
					"numMaxCharacters": 10000,
					"numMinCharacters": 30,
					"published": $scope.published,
					"content": $scope.content
				}
		};
		
		$scope.send = function(){
			$scope.content = $('#edit').val();
			console.log($scope.content);
			update();
		}

		var update = function(){
			$http.post('writting/editContent',$scope.writting).success(function(response) {
			/*$http.post('writting/getWrittingContent',$scope.writting).success(function(response) {
				console.log("3 : "+response);
			});*/
			});
		}
		
		$scope.publish = function(){
			console.log("Published: " + $scope.published + "Fecha: " + fecha);
			$http.post('writting/publish',$scope.writting).success(function(response) {

			});
		}
		
	}]);