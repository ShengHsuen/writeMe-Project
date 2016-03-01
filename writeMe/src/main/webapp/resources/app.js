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
  	$routeProvider.otherwise({redirectTo: '/home'});
  	
  }]);