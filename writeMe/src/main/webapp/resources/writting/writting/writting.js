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
				"searchTerm": $scope.name,
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
			$scope.writting={
					"pageNumber": 0,
					"pageSize": 0,
					"direction": "",
					"sortBy": [""],
					"searchColumn": "string",
					"searchTerm": $scope.name,
					"writting": {
						"name" : $scope.name,
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
			$http.post('rest/protected/writting/editContent',$scope.writting).success(function(response) {
				createUserHasWritting();
			});
		}
		
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
						  "dateModifie": fecha,
					      "statusColor": false,
					      "user_has_writtingId": 0,
					      "linkInvitation": "string",
					      "banned": false,
					      "dateCreate": fecha,
					      "invitationStatus": false
					}
					
			};
			$http.post('rest/protected/writting/createUserHasWritting',$scope.userHasWritting).success(function(response) {
				
			});
		}
		
		$scope.publish = function(){
			publish = true;
			console.log("Published: " + publish + "Fecha: " + fecha);
			$http.post('rest/protected/writting/publish',$scope.writting).success(function(response) {
				console.log("writting/publish");
			})
		}
		
		$scope.loadData = function(){
			$scope.content = $localStorage.showContent;
			$scope.name = $localStorage.nameWritting;
			$scope.content= $scope.content.replace(/(<\?[a-z]*(\s[^>]*)?\?(>|$)|<!\[[a-z]*\[|\]\]>|<!DOCTYPE[^>]*?(>|$)|<!--[\s\S]*?(-->|$)|<[a-z?!\/]([a-z0-9_:.])*(\s[^>]*)?(>|$))/gi, '');
			$scope.content= $scope.content.replace(/&nbsp;/g,'');
		}
		$scope.loadData();
		
		
	}]);