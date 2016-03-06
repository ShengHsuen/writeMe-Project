'use strict';

angular.module('myApp.createWritting', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createWritting', {
    templateUrl: 'resources/writting/createWritting/createWritting.html',
    controller: 'Create_WrittingCtrl'
  });
}])

.controller('Create_WrittingCtrl', ['$scope','$http',function($scope,$http) {
		$scope.navCreate_Writting = function(){
  		var path = "/writeMe/app#/createWritting";
		window.location.href = path;
  	}
}]);
