'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
<<<<<<< HEAD
  'myApp.signin',
  'myApp.signup',
=======
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
  'myApp.home',
  'myApp.legalEstablishment',
  'myApp.acceptLegalEstablishment',
  'ui.grid'
])
<<<<<<< HEAD
.config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
	$routeProvider.otherwise({redirectTo: '/home'});
}]);
=======
 .config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
  	$routeProvider.otherwise({redirectTo: '/home'});
  	
  }]);
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
