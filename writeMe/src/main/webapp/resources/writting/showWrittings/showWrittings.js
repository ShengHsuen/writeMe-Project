'use strict';
angular.module('myApp.showWrittings', [ 'ngRoute' , 'ngStorage'])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/showWrittings', {
		templateUrl : 'resources/writting/showWrittings/showWrittings.html',
		controller : 'showWrittingsCtrl'
	});
} ]).controller('showWrittingsCtrl',['$scope','$http', '$localStorage',function($scope, $http, $localStorage) {
	
	// Mostrar
var init = function(){
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
	});
}
		
	$scope.saveData = function(wrid, name, cantUsers, writtingId){
		params: {content : wrid}
	    params: {name : name}
		params: {cantUsers : cantUsers}
		params: {writtingId : writtingId}
	    $localStorage.showContent = wrid;
	    $localStorage.nameWritting = name;
	    $localStorage.cantUsers = cantUsers;
	    $localStorage.writtingId = writtingId;
	    console.log("Aqui entra " + $localStorage.writtingId);
	    window.location.href = "app#/writting";
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
    					init();
    			    });
    	        }
    
    $scope.$on('show-writtings', function(event, args) {
      setTimeout(myFunction, 3000);
  	  init();
    });
    init();

} ]);