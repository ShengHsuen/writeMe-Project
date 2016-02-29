'use strict';
var i = 1;
angular.module('myApp.legalEstablishment', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/legalEstablishment', {
    templateUrl: 'resources/legalEstablishment/legalEstablishment.html'
    	,    controller: 'legalEstablishmentCtrl'
  });
}])
.controller('legalEstablishmentCtrl', ['$scope', '$http', function($scope, $http) {
	//Mostrar menu crear regla   
	$scope.myVar = false;
	    $scope.toggle = function() {
	        $scope.myVar = !$scope.myVar;
	    };

		$scope.legalEsta={};
		$scope.onError = false;
		$scope.legalEstaList = [];
		$scope.requestObject = {};
		
		//OBTENER TODAS
	    $scope.init = function() {
	    	
	    	$http.get('/getAll')
			.success(function(response) {

				$scope.legalEstaList = response.legalEstaList
				$scope.requestObject.idLegalEstablishment = $scope.legalEstaList[0].idLegalEstablishment;
				
			});
	    	
	    };
	    
	   //Guardar regla
	    
	    $scope.saveRule = function() {
	    	  $http({
	    	         method: 'post',
	    	         url: 'legal/create',
	    	         data: {
	    	    	     "part": 1,	    	         
	    	           "name": $scope.name,
	    	     "description": $scope.description
	    	     }
	    }).success(function (data, status, headers, config) {
	        console.log("sirve");
	    }).error(function (data, status, headers, config) {
	    	 console.log("No sirve");
	    });
	    }
}]);