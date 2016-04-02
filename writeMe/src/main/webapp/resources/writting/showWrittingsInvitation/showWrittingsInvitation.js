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
	//hay que agregar un catch() aca
	$http.post('users/getWrittings',$scope.writting).success(function(response) {
		$scope.writting = response.writtings;
	});
}
	$scope.init();
	
	
	$scope.saveData = function(mainWr, name, cantUsers, writtingId){
		params: {mainWritting : mainWr}
	    params: {name : name}
		params: {cantUsers : cantUsers}
		params: {writtingId : writtingId}
	    $localStorage.mainWritting = mainWr;
	    $localStorage.nameWritting = name;
	    $localStorage.cantUsers = cantUsers;
	    $localStorage.writtingId = writtingId;
	    window.location.href = "app#/writtingInvitation"
	}
	
	
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