'use strict';
var i = 1;
angular.module('myApp.showWrittings', [ 'ngRoute' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/showWrittings', {
		templateUrl : 'resources/writting/showWrittings/showWrittings.html',
		controller : 'showWrittingsCtrl'
	});
} ]).controller('showWrittingsCtrl',['$scope','$http',function($scope, $http) {
	$scope.writtingList = {};
	$scope.requestObject = []
	$scope.requestObject = {
			"pageNumber" : 0,
			"pageSize" : 0,
			"direction" : "",
			"sortBy" : [ "" ],
			"searchColumn" : "string",
			"searchTerm" : "",
			"showWrittings" : {}
	};
	
	
	// Mostrar
	$scope.init = function() {
		$http.post('rest/protected/userHasWritting/getAll',
				$scope.requestObject).success(function(response) {
					$scope.writtingList = response.writtingList;
				});
	}
	$scope.init();

} ]);