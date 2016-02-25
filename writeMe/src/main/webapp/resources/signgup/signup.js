'use strict';

angular.module('myApp.signup', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signup', {
    templateUrl: 'resources/signup/signup.html'
    //controller: 'SignUpCtrl'
  });
}])

.controller('SignUpCtrl', ['$scope','$http',function($scope,$http) {
	
}]);