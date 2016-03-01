'use strict';

angular.module('myApp.home', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/home', {
    templateUrl: 'resources/home/home.html'
    //controller: 'SignInCtrl'
  });
}])

.controller('HomeCtrl', ['$scope','$http',function($scope,$http) {

}]);