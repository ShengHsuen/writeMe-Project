'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'myApp.home',
  'myApp.legalEstablishment',
  'myApp.acceptLegalEstablishment',
  'myApp.createWritting',
  'myApp.writting',
  'ui.grid'
])
<<<<<<< HEAD
 .config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
  	$routeProvider.otherwise({redirectTo: '/home'});
	/*$scope.navCreate_Writting = function(){
  		var path = "/writeMe/app#/create_writting";
		window.location.href = path;
  	}*/
  }])

=======
.config(['$routeProvider','$provide','$httpProvider', function($routeProvider,$provide,$httpProvider) {
	$routeProvider.otherwise({redirectTo: '/home'});
}]);
>>>>>>> d4826a6b013102cd75ab02efe1bd7f8c1852bd30
