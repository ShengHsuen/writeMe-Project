'use strict';

angular.module('myApp.resetPassword', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/resetPassword', {
    templateUrl: 'resources/resetPassword/resetPassword.html',
    controller: 'resetPasswordCtrl'
  });
}])
  .controller('resetPasswordCtrl', ['$scope','$http',function($scope,$http) {
		var canCreate = false; // Verificar si se puede crear
		$scope.navSignin = function(){
			var path = "/writeMe/#/signin";
			window.location.href = path;
		}
} ])