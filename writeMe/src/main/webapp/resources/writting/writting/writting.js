'use strict';

	angular.module('myApp.writting', ['ngRoute'])

	.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/writting', {
	    templateUrl: 'resources/writting/writting/writting.html',
	    controller: 'WrittingCtrl'
	  });
	}])
	
	
	
	.controller('WrittingCtrl', ['$scope','$http',function($scope,$http) {

		
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
					"name" : "fff",
					"description" : "a",
					"cantUsers": 0,
					"date": fecha,
					"likes": 0,
					"limit time": "2100-01-01",
					"numMaxCharacters": 10000,
					"numMinCharacters": 30,
					"published": publish,
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
<<<<<<< HEAD
				console.log('writting/editContent');
=======
				createUserHasWritting();
>>>>>>> 210298eff1e4124e541a95963734fccdf9122795
			});
		}
		
		$scope.publish = function(){
			publish = true;
			console.log("Published: " + publish + "Fecha: " + fecha);
			$http.post('writting/publish',$scope.writting).success(function(response) {
				console.log('writting/publish');
			});
			
			
			var createUserHasWritting = function(){
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
				$http.post('writting/createUserHasWritting',$scope.userHasWritting).success(function(response) {
					
				});
			}
		}
		
	}]);