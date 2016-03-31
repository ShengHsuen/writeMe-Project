'use strict';
angular.module('myApp.showWrittingsInvitation', [ 'ngRoute' , 'ngStorage'])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/showWrittingsInvitation', {
		templateUrl : 'resources/writting/showWrittingsInvitation/showWrittingsInvitation.html',
		controller : 'showWrittingsInvitationCtrl'
	});
} ]).controller('showWrittingsInvitationCtrl',['$scope','$http', '$localStorage','$rootScope',function($scope, $http, $localStorage,$rootScope) {
	
    var lastAuthor = $localStorage.lastUser;
	var actualAuthor = $localStorage.data;

	var availability = $localStorage.availability;
	console.log("Ava "+availability)
	var available="";

	if(availability == null){
	   available = 'Disponible';
	}else if(availability == true){
		available = 'Disponible';
	}else{
		available = 'Ocupado';
	}

	$scope.textAvailable = available;

	$scope.lastAuthor =  $localStorage.lastUser;


	
	
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
	
	
	$scope.enter = function(wrid, name){
		 window.location.href = "app#/writtingInvitation"
	}
	

	
	
	
	
} ]);