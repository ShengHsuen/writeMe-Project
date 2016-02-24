'use strict';

angular.module('myApp.signip', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signin', {
    templateUrl: 'signin/signin.html'
    controller: 'SignInCtrl'
  });
}])

.controller('SignInCtrl', ['$scope','$http',function($scope,$http) {
	
}]);