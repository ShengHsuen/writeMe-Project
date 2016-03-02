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
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
])
.config(['$routeProvider', function($routeProvider) {
  $routeProvider.otherwise({redirectTo: '/signin'});
}]);
