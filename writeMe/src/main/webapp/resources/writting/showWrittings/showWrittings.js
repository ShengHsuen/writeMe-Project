'use strict';
var i = 1;
angular.module('myApp.showWrittings', [ 'ngRoute' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/showWrittings', {
		templateUrl : 'resources/writting/showWrittings/showWrittings.html',
		controller : 'showWrittingsCtrl'
	});
} ]).controller('showWrittingsCtrl',['$scope','$http',function($scope, $http) {



} ]);