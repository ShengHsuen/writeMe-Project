'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngStorage',
  'myApp.home',
  'myApp.legalEstablishment',
  'myApp.acceptLegalEstablishment',
  'myApp.createWritting',
  'myApp.writting',
  'myApp.writtingInvitation',
  'myApp.showWrittings',
  'myApp.invitation',
  'myApp.viewWritting',
  'ui.grid'
])

.config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
	$routeProvider.otherwise({redirectTo: '/home'});
}])

.controller('mainCtrl', ['$scope','$http', '$localStorage',function($scope,$http,$localStorage) {
	$scope.load = function(){
		$scope.user = $localStorage.data;
		$scope.hoster = $localStorage.hoster;
		$scope.writting = $localStorage.writting;
		console.log($scope.user);
	}
	$scope.load();
	
	$scope.findInvitations = function(){
		  $scope.invitation = {"pageNumber": 0,
			        "pageSize": 0,
			        "direction": "",
			        "sortBy": [""],
			        "searchColumn": "string",
			        "searchTerm": $scope.user.author,
			        "user": {},
			        "owner": {},
			        "writting": {} 
			        };
		     $http.post('rest/protected/invitation/getInvitationByUser', $scope.invitation).success(function(response) {
		    	   console.log("Invitation Success");
			  	   $scope.writting = response.writting;
			 	   $scope.hoster = response.owner;
			 	   $scope.cantInvitations = $scope.writting.length;
			  	   console.log($scope.writting);
			  	   console.log($scope.hoster);
		     });
	}
	$scope.findInvitations();
	
	$scope.accept = function(writting){
		  console.log(writting.writtingId);
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
					      "statusColor": false,
					      "user_has_writtingId": 0,
					      "linkInvitation": writting.writtingId,
					      "banned": false,
					      "invitationStatus": true,
					      "owner": false
					}	
			};
		  $http.post('rest/protected/invitation/acceptInvitation', $scope.userHasWritting).success(function(response) {
			  console.log("Success");
		  });
	}
	
	$scope.refuse = function(writting){
		console.log("Success " + writting.name);
		  $scope.invitation = {"pageNumber": 0,
			        "pageSize": 0,
			        "direction": "",
			        "sortBy": [""],
			        "searchColumn": "string",
			        "searchTerm": $scope.user.author,
			        "user": $scope.user,
			        "owner": {},
			        "writting": writting 
			        };
		  $http.post('rest/protected/invitation/refuseInvitation', $scope.invitation).success(function(response) {
			  console.log("Success");
		  });
	}
	
	if($scope.user == null && $localStorage.data == null ){
		var path = "/writeMe/#/signin";
		window.location.href = path;
	}
	
	
}]);

