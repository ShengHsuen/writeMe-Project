'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.signin',
  'myApp.signup',
  'ui.grid',
  'myApp.acceptLegalEstablishment',
  'myApp.resetPassword'
])
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/signin'});
}]);
