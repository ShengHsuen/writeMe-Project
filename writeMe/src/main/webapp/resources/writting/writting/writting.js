'use strict';

	angular.module('myApp.writting', ['ngRoute', 'ngStorage'])

	.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/writting', {
	    templateUrl: 'resources/writting/writting/writting.html',
	    controller: 'WrittingCtrl'
	  });
	}])
	
	
	
	.controller('WrittingCtrl', ['$scope','$http', '$localStorage',function($scope,$http,$localStorage) {

		
//		$scope.$on("NAME_CHANNEL",function(event,name){
//			$scope.name = name;
//		});

		
		$scope.date = new Date();
		var anno = $scope.date.getFullYear();
		var mes = $scope.date.getMonth() + 1;
		var dia = $scope.date.getDate();
		var fecha = anno.toString() + "-" + mes.toString() + "-" + dia.toString();
		
		var publish = false;
		
		$scope.writting={
				"pageNumber": 0,
				"pageSize": 0,
				"direction": "",
				"sortBy": [""],
				"searchColumn": "string",
				"searchTerm": "fff",
				"writting": {
					"published": publish,
					"date": fecha,
					"content": $scope.content
				}
		};
		
		$scope.send = function(){
			$scope.content = $('#edit').val();
			console.log($scope.content);
			update();
		}

		var update = function(){
			$http.post('rest/protected/writting/editContent',$scope.writting).success(function(response) {
			});
		}
		
		$scope.publish = function(){
			publish = true;
			console.log("Published: " + publish + "Fecha: " + fecha);
			$http.post('rest/protected/writting/publish',$scope.writting).success(function(response) {
				console.log("writting/publish");
			});
		}
		
		$scope.loadData = function(){
		
			$scope.content = $localStorage.showContent;
			console.log("Pa que dani vea" +$localStorage.showContent);
			
		}
	
		$scope.loadData();
		
		
	}]);