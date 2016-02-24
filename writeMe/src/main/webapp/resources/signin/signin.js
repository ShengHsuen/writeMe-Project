'use strict';

angular.module('myApp.signin', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signin', {
    templateUrl: 'resources/signin/signin.html'
    //controller: 'SignInCtrl'
  });
}])

.controller('SignInCtrl', ['$scope','$http',function($scope,$http) {
	
}]);