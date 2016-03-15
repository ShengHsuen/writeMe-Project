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
		
		$scope.enviar = function(){
			console.log($scope.name);
			$scope.content = $('#edit').val();
			console.log($scope.content);
			update();
		}

		var update = function(){
			$scope.writting={
					"pageNumber": 0,
					"pageSize": 0,
					"direction": "",
					"sortBy": [""],
					"searchColumn": "string",
					"searchTerm": "aaa",
					"writting": {
						"name" : "aaa",
						"description" : " a ",
						"cantUsers": 0,
						"date": "2016-02-02",
						"likes": 0,
						"limit time": "2100-01-01",
						"numMaxCharacters": 10000,
						"numMinCharacters": 30,
						"published": false,
						"content": $scope.content
					}
			};
			$http.post('writting/editContent',$scope.writting).success(function(response) {
			/*$http.post('writting/getWrittingContent',$scope.writting).success(function(response) {
				console.log("3 : "+response);
			});*/
				createUserHasWritting();
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