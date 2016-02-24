'use strict';

angular.module('myApp.signup', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signup', {
    templateUrl: 'signup/signup.html'
    //controller: 'View1Ctrl'
  });
}])

.controller('SignUpCtrl', ['$scope','$http',function($scope,$http) {
	
}]);