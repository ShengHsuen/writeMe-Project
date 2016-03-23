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
	$scope.saveData = function(wrid, name){
		params: {content : wrid}
	    params: {name : name}
	    $localStorage.showContent = wrid;
	    $localStorage.nameWritting = name;

	    console.log("contendio " + wrid)
	    console.log("Para que cheng aprenda " + name)
	    window.location.href = "app#/writting"
	}

	/*
	 * @author Mildred Guerra
     *callback for ng-click 'deleteWritting':
     */
    $scope.deleteWritting = function (writtingId) {
    	console.log("esta vara es el id del wriiting "+ writtingId)
    			  $http({ url: 'rest/protected/writting/delete', 
    	                method: 'DELETE', 
    	                params: {writtingId: writtingId}
    			  }).success(function() {
    					$scope.init();
    			    });
    	        }
    var obtenerWrittings = function(){
    	$http.post('users/getWrittings',$scope.writting).success(function(response) {
			$scope.writting = response.writtings;
		});
    }

} ]);