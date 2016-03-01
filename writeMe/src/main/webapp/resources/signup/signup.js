'use strict';

angular.module('myApp.signup', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signup', {
    templateUrl: 'resources/signup/signup.html',
    controller: 'SignUpCtrl'
  });
}])

.controller('SignUpCtrl', ['$scope','$http',function($scope,$http) {
	var canCreate = false;
	var user = {
		"birthDay": $scope.birthDay,
	      "lastName": $scope.lastName,
	      "password": $scope.password,
	      "mail": $scope.mail,
	      "author": $scope.nickName,
	      "accountType": false,
	      "name": $scope.name,
	      "admin": false,
	      "userId": 0
	}
	$scope.navSignin = function(){
		var path = "/writeMe/#/signin";
		window.location.href = path;
	}
	$scope.createAccount = function() {
		$scope.requestObject = {
				"pageNumber": 0,
				"pageSize": 0,
				"direction": "",
				"sortBy": [""],
				"searchColumn": "string",
				"searchTerm": "",
				"user": {
					"birthDay": $scope.birthDay,
				      "lastName": $scope.lastName,
				      "password": $scope.password,
				      "mail": $scope.mail,
				      "author": $scope.nickName,
				      "accountType": false,
				      "name": $scope.name,
				      "admin": false,
				      "userId": 0
				}
		};
		$scope.confirmPassword();
		$scope.isEmpty();
		if(canCreate == true){
			$http.post('users/create',$scope.requestObject).success(function(response) {
				console.log($scope.requestObject);
			})
		}else{
			
		}
		
	}
	$scope.confirmPassword = function(){
		if($scope.password == $scope.passwordConfirm){
			canCreate = true;
			$scope.pconfirm = false;
		}else{
			canCreate = false;
			$scope.pconfirm = true;
		}
	}
	$scope.isEmpty = function(){
		for(var i=0;i<user.length;i++){
			console.log(user.length);
		}
	}
}]);