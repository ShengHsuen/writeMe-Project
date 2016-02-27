'use strict';

angular.module('myApp.legalEstablishment', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/legalEstablishment', {
    templateUrl: 'resources/legalEstablishment/legalEstablishment.html'
    	//,    controller: 'legalEstablishmentCtrl'
  });
}])

/*.controller('legalEstablishmentInCtrl', ['$scope','$http',function($scope,$http) {
	
}]);*/