'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.signin',
<<<<<<< HEAD
  'myApp.signup'
=======
  'myApp.signup',
  'myApp.acceptLegalEstablishment'
>>>>>>> 9de0b37c53a680e34a86b0a6acc5243a3d1e6f37
])
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/signin'});
}]);
