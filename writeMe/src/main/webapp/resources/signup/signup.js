'use strict';

angular.module('myApp.signup', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signup', {
    templateUrl: 'resources/signup/signup.html',
    controller: 'SignUpCtrl'
  });
}])

.controller('SignUpCtrl', ['$scope','$http',function($scope,$http) {
	$scope.navSignin = function(){
		var path = "/writeMe/#/signin";
		window.location.href = path;
	}
	$scope.createAccount = function() {
		var users = {
				"name": $scope.name,
				"lastName": $scope.lastName,
				"author": $scope.nickName,
				"mail": $scope.mail,
				"password": $scope.password
		}
		$http.post('users/create', users).success(function(response) {
			//users = response;
		})
	}
}]);