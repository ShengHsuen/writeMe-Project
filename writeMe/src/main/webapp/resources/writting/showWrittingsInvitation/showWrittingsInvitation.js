'use strict';
angular.module('myApp.showWrittingsInvitation', [ 'ngRoute' , 'ngStorage'])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/showWrittingsInvitation', {
		templateUrl : 'resources/writting/showWrittingsInvitation/showWrittingsInvitation.html',
		controller : 'showWrittingsInvitationCtrl'
	});
} ]).controller('showWrittingsInvitationCtrl',['$scope','$http', '$localStorage','$rootScope',function($scope, $http, $localStorage,$rootScope) {
	
	// Mostrar
	$scope.init = function(){
	$scope.writting = [];
	$scope.writting = {
			"pageNumber" : 0,
			"pageSize" : 0,
			"direction" : "",
			"sortBy" : [ "" ],
			"searchColumn" : "string",
			"searchTerm" : "",
			"writting" : {}
	};
	$http.post('users/getWrittings',$scope.writting).success(function(response) {
		$scope.writting = response.writtings;
	}).catch(function(error){
		   $scope.serverDown = function()
			{
			   $rootScope.$broadcast('serverDown');
			}
		   $scope.serverDown();
	   });
	}
	$scope.init();
	
	$scope.saveData = function(mainWr, name, cantUsers, writtingId, writting){
		params: {mainWritting : mainWr};
	    params: {name : name};
		params: {cantUsers : cantUsers};
		params: {writtingId : writtingId};
		params: {writting : writting};
	    $localStorage.mainWritting = mainWr;
	    $localStorage.nameWritting = name;
	    $localStorage.cantUsers = cantUsers;
	    $localStorage.writtingId = writtingId;
	    $localStorage.writting = writting;
	    window.location.href = "app#/writtingInvitation"
	};
	
	  $scope.$on('invitation-started', function(event, args) {
		  $scope.init();
	  });
	  
	   $scope.checkParticipation = function(mainWr){
				  $http({ url:'rest/protected/writting/getContentLastWrittingByMain', 
					  method: 'POST' ,
					  params: {mainWritting : mainWr}
				  }).success(function(response) {
					  $scope.textAvailable = response.participation;
					  console.log($scope.textAvailable);
				    });
		    };
	
		  //  $scope.checkParticipation();

} ]);