'use strict';

angular.module('myApp.signup', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/signup', {
    templateUrl: 'resources/signup/signup.html',
    controller: 'SignUpCtrl'
  });
}])

.controller('SignUpCtrl', ['$scope','$http',function($scope,$http) {
	var canCreate = false; // Verificar si se puede crear
	$scope.navSignin = function(){
		var path = "/writeMe/#/signin";
		window.location.href = path;
	}
	$scope.createAccount = function(){
		$scope.requestObject={
				"pageNumber": 0,
				"pageSize": 0,
				"direction": "",
				"sortBy": [""],
				"searchColumn": "string",
				"searchTerm": "",
				"user": {
					"name" : $scope.name,
					"lastName" : $scope.lastName,
					"author": $scope.nickName,
					"mail" : $scope.mail,
					"birthDay" : $scope.birthDay,
					"password" : $scope.password
				}
		};
		$scope.pConfirm();
		if(canCreate == true){
			$http.post('users/create',$scope.requestObject).success(function(response) {
<<<<<<< HEAD
=======
				console.log($scope.requestObject );
>>>>>>> 9de0b37c53a680e34a86b0a6acc5243a3d1e6f37
			});
		}else{
			
		}
		
	}
	$scope.pConfirm = function(){
		if($scope.password == $scope.passwordConfirm){
			canCreate = true;
			$scope.pconfirm = false;
		}else{
			$scope.pconfirm = true;
		}
	}

<<<<<<< HEAD
=======
	$scope.navAcceptLegal= function(){
		var path = "/writeMe/#/acceptLegalEstablishment";
		window.location.href = path;
	}
>>>>>>> 9de0b37c53a680e34a86b0a6acc5243a3d1e6f37
}]);