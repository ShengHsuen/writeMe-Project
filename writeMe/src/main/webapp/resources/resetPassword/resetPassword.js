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

	$scope.sendEmail = function(){
		$scope.user = {email: $scope.email};
		
		$http.post('rest/email/resetPassword',$scope.user).success(function (userResponse) {
			if(userResponse.code == 200){
				alert("valido");
				
			}else{
				alert("invalido");
			}
		});
	}
} ])