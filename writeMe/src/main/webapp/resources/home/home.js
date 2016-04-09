'use strict';

angular.module('myApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'resources/home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl', ['$scope','$http','$rootScope', '$localStorage', function($scope,$http,$rootScope, $localStorage) {
	
	$scope.loadData = function(){
		$scope.sessionUser = $localStorage.data;
	}
	
	$scope.isPublic = [];
	
	$scope.filterForPublic = function(){
		  $scope.ffpbulic = {"pageNumber": 0,
			        "pageSize": 0,
			        "direction": "",
			        "sortBy": [""],
			        "searchColumn": "string",
			        "searchTerm": "",
			        "user": {},
			        "writting": {} 
			        };
			  $http.post('rest/protected/writting/getPublished',$scope.ffpbulic).success(function(response){
				  
			  })
	}
	
   $scope.init = function(){
	   $scope.loadData();
	   
	  $scope.writting = [];
	  $scope.user = [];
	  $scope.writting = {"pageNumber": 0,
	        "pageSize": 0,
	        "direction": "",
	        "sortBy": [""],
	        "searchColumn": "string",
	        "searchTerm": "",
	        "user": {},
	        "writting": {} 
	        };
	  $http.post('rest/protected/writting/getPublished',$scope.writting).success(function(response){
	   console.log("home.js");
	   $scope.writting = response.writting;
	   $scope.filterForPublic();
	  // $scope.user = response.user;
	  }).catch(function(error){
		   $scope.serverDown = function()
			{
			   $rootScope.$broadcast('serverDown');
			}
		   $scope.serverDown();
	   });
  }
  
  $scope.$on('home-started', function(event, args) {
	  $scope.init();
  });
  
  $scope.init();
	
	$scope.viewWritting = function(id){
		params: {idWritting : id}
	    $localStorage.idWritting=id;
	    window.location.href = "app#/viewWritting"
	};
	
    $scope.publicColaborate = function(wr){
    	console.log("public colaborate "+$scope.sessionUser.author);
		$scope.userHasWritting={
				  "pageNumber": 0,
				  "pageSize": 0,
				  "direction": "string",
				  "sortBy": [
				    "string"
				  ],
				  "searchColumn": "string",
				  "searchTerm": $scope.sessionUser.author,
				  "userHasWritting": {
				      "statusColor": false,
				      "user_has_writtingId": 0,
				      "linkInvitation": $scope.writtingId,
				      "banned": false,
				      "invitationStatus": false,
				      "owner": false,
				      "writting": wr,
				      "user": $scope.sessionUser
				}
		};
	   $http.post('rest/protected/public/createPublic', $scope.userHasWritting).success(function(response) {
	    	console.log("Success");
    	   /* $rootScope.$broadcast('invitation-send');
    	    var path = "app#/showWrittingsInvitation";
    	    window.location.href = path;*/
	    }).catch(function(error){
			   $scope.serverDown = function()
				{
				   $rootScope.$broadcast('serverDown');
				}
			   $scope.serverDown();
		   });
    }

}]);