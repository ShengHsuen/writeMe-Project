'use strict';

angular.module('myApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'resources/home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl', ['$scope','$http','$rootScope', function($scope,$http,$rootScope) {
	
   $scope.init = function(){
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
	  // $scope.user = response.user;
	  });
  };
  
  $scope.$on('home-started', function(event, args) {
	  $scope.init();
  });
  
  $scope.init();
  

}]);