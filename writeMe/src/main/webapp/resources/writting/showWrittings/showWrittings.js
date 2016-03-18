'use strict';
angular.module('myApp.showWrittings', [ 'ngRoute' , 'ngStorage'])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/showWrittings', {
		templateUrl : 'resources/writting/showWrittings/showWrittings.html',
		controller : 'showWrittingsCtrl'
	});
} ]).controller('showWrittingsCtrl',['$scope','$http', '$localStorage',function($scope, $http, $localStorage) {
	
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
	
	// Mostrar
	$scope.init = function() {
		$http.post('users/getWrittings',$scope.writting).success(function(response) {
					$scope.writting = response.writtings;
				});
	}
	$scope.init();
	
	
	/*$scope.showWritting = function(wrid){
		params: {writtingId: wrid}
	    console.log("el id es "+wrid); // agarra el id 
	}
	*/
	$scope.saveData = function(wrid){
		params: {content : wrid}
	    $localStorage.content = wrid;
	    window.location.href = "app#/writting"
	}



} ]);