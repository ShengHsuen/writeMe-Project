'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngStorage',
  'myApp.home',
  'myApp.legalEstablishment',
  'myApp.acceptLegalEstablishment',
  'myApp.createWritting',
  'myApp.writting',
  'myApp.showWrittings',
  'ui.grid'
])

.config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
	$routeProvider.otherwise({redirectTo: '/home'});
}])

.controller('mainCtrl', ['$scope','$http', '$localStorage',function($scope,$http,$localStorage) {
	$scope.load = function(){
		$scope.user = $localStorage.data;
		console.log($scope.user);
	}
	$scope.load();
	
	
	if($scope.user == null && $localStorage.data == null ){
		var path = "/writeMe/#/signin";
		  window.location.href = path;
	}
}]);

