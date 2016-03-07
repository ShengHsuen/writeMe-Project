'use strict';

angular.module('myApp.create_writting', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/create_writting', {
    templateUrl: 'resources/create_writting/create_writting.html',
    controller: 'CreateWritting'
  });
}])

.controller('CreateWritting', ['$scope','$http',function($scope,$http) {
	
}]);