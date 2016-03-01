'use strict';

angular.module('myApp.signin', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signin', {
    templateUrl: 'resources/signin/signin.html',
    controller: 'SignInCtrl'
  });
}])

.controller('SignInCtrl', ['$scope','$http',function($scope,$http) {
	$scope.user = {email:"cheng2094@gmail.com",password:"12345"};
	$scope.login = function(){
		
		$http.post('rest/signin/checkuser/',$scope.user).success(function (loginResponse) {
    		if(loginResponse.code == 200){
    			var usuario = {"userId":loginResponse.idUsuario,"name":loginResponse.firstName,"lastName":loginResponse.lastName};
    			var path = "/writeMe/app#/home";
    			window.location.href = path;
    		}else{
    			alert("invalido");
    		}
    	});
	}
}]);