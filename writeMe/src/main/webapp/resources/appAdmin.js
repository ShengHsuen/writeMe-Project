'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'myApp.homeAdmin',
  'myApp.legalEstablishment'
])

.config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
	$routeProvider.otherwise({redirectTo: '/homeAdmin'});
}]);