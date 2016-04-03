'use strict';

angular.module('myApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'resources/home/home.html',
    controller: 'HomeCtrl'
  });
}])

.controller('HomeCtrl', ['$scope','$http','$rootScope', '$localStorage', function($scope,$http,$rootScope, $localStorage) {
	
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
/*		params: {content : wrid}
	    params: {name : name}
	    params: {category : categ}
    	params: {imagen : img}
	    $localStorage.showContent = wrid;
	    $localStorage.nameWritting = name;
	    $localStorage.categoryWritting = categ;
	    $localStorage.imgWritting = img;*/
	    $localStorage.idWritting=id;
	    window.location.href = "app#/viewWritting"
	
	};

}]);