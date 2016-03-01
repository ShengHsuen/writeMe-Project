'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'myApp.signin',
  'myApp.signup',
  'myApp.home',
  'myApp.legalEstablishment',
  'myApp.acceptLegalEstablishment',
  'ui.grid'
])
.config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
<<<<<<< HEAD
	$routeProvider.otherwise({redirectTo: '/'});
=======
	$routeProvider.otherwise({redirectTo: '/home'});
>>>>>>> 8cadc2bcf83f59a201448c7f9e9797dc94aa3a2b
}]);