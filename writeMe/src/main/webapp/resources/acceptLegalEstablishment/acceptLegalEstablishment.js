'use strict';
var i = 1;
angular.module('myApp.acceptLegalEstablishment', ['ngRoute'])

.config(['$routeProvider',function($routeProvider) {
	$routeProvider.when('/acceptLegalEstablishment',{
		templateUrl : 'resources/acceptLegalEstablishment/acceptLegalEstablishment.html',
		controller : 'acceptLegalCtrl'
	});
}])
.controller('acceptLegalCtrl',['$scope','$http',function($scope, $http) {

	$scope.navSignup = function(){
		var path = "/writeMe/#/signup";
		window.location.href = path;
	}
	// Mostarr
	$scope.legalList = {};
	$scope.requestObject = []
	$http.post('acceptLegalEstablishment/getAll',
			$scope.requestObject).success(
					function(response) {
						$scope.legalList = response.legalList;
					});
} ])
