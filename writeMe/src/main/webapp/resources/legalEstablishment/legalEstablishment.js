'use strict';

angular.module('myApp.legalEstablishment', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/legalEstablishment', {
    templateUrl: 'resources/legalEstablishment/legalEstablishment.html'
    	,    controller: 'legalEstablishmentCtrl'
  });
}])
.controller('legalEstablishmentCtrl', ['$scope', function($scope) {
	   $scope.myVar = false;
	    $scope.toggle = function() {
	        $scope.myVar = !$scope.myVar;
	    };
	    
}]);