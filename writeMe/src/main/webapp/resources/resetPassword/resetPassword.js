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
			$scope.user = {email: $scope.email,password:"12345"};
			$http.post('rest/signin/checkuser',$scope.user).success(function (loginResponse) {
	    		if(loginResponse.code == 200){
	    			$http.post('rest/resetPassword/email',$scope.user).success(function () {

	    	    		
	    	    	});
	    			$scope.navSignin();
	    		}else{
	    			alert("invalido");
	    		}
	    	});
			/*$http.post('rest/resetPassword/email',$scope.user).success(function () {

	    		
	    	});
			$scope.navSignin();*/
		}
} ])