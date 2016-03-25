'use strict';

angular.module('myApp.invitation', ['ngRoute', 'ngStorage'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/invitation', {
        templateUrl: 'resources/invitation/invitation.html',
        controller: 'InvitationCtrl'
    });
 }])
 
 .controller('InvitationCtrl', ['$scope','$http', '$localStorage','$rootScope', function($scope,$http,$localStorage,$rootScope) {
	 
 }]);