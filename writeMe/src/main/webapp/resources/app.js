'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'myApp.signin',
  'myApp.signup'
])
.config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
	$routeProvider.otherwise({redirectTo: '/'});
}]);