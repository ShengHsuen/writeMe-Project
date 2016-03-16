'use strict';
angular.module('myApp.showWrittings', [ 'ngRoute' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/showWrittings', {
		templateUrl : 'resources/writting/showWrittings/showWrittings.html',
		controller : 'showWrittingsCtrl'
	});
} ]).controller('showWrittingsCtrl',['$scope','$http',function($scope, $http) {
	
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
					console.log("aqui entra");
				});
	}
	$scope.init();
} ]);