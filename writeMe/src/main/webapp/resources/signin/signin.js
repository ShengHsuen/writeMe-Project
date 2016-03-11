'use strict';

angular.module('myApp.signin', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signin', {
    templateUrl: 'resources/signin/signin.html',
    controller: 'SignInCtrl'
  });
}])

.controller('SignInCtrl', ['$scope','$http',function($scope,$http) {

	$scope.navSignup = function(){
		  var path = "/writeMe/#/signup";
		  window.location.href = path;
		 }
	
	$scope.user = {email:"cheng2094@gmail.com",password:"12345"};
	$scope.login = function(){
		
		$http.post('rest/signin/checkuser',$scope.user).success(function (loginResponse) {
    		if(loginResponse.code == 200){
    			var user = {"userId":loginResponse.idUser,"name":loginResponse.name,"lastName":loginResponse.lastName, "admin":loginResponse.admin};
    			console.log(user);
    			if(loginResponse.admin == false){
    				var path = "/writeMe/app#/home";
        			window.location.href = path;
    			}else{
    				var path = "/writeMe/appAdmin#/homeAdmin";
        			window.location.href = path;
    			}
    			
    		}else{
    			alert("invalido");
    		}
    	});
	}
}]);