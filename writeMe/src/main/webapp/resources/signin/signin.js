'use strict';

angular.module('myApp.signin', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signin', {
    templateUrl: 'resources/signin/signin.html',
    controller: 'SignInCtrl'
  });
}])

.controller('SignInCtrl', ['$scope','$http',function($scope,$http) {
<<<<<<< HEAD
	$scope.user = {email:"cheng2094@gmail.com",password:"12345"};
	$scope.login = function(){
		
		$http.post('rest/signin/checkuser/',$scope.user).success(function (loginResponse) {
=======

	$scope.navSignup = function(){
		var path = "/writeMe/#/signup";
		window.location.href = path;
	}
	$scope.user = {email:"cheng2094@gmail.com",password:"12345"};
	$scope.login = function(){
		
		$http.post('rest/signin/checkuser',$scope.user).success(function (loginResponse) {
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
    		if(loginResponse.code == 200){
    			var usuario = {"userId":loginResponse.idUsuario,"name":loginResponse.firstName,"lastName":loginResponse.lastName};
    			var path = "/writeMe/app#/home";
    			window.location.href = path;
    		}else{
    			alert("invalido");
    		}
    	});
<<<<<<< HEAD
=======

>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d
	}
}]);