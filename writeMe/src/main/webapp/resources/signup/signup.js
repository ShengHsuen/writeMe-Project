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
		$scope.prepit = false;
		if(canCreate == true){
			$http.post('users/create',$scope.requestObject).success(function(response) {
				$scope.user = {email: $scope.mail};
				
				$http.post('rest/email/confCuenta',$scope.user).success(function (userResponse) {
					if(userResponse.code == 200){
						$scope.navSignin();
					}else{
						alert("invalido");
					}
				});
			    if($scope.prepit == false){
			        $scope.navSignin();
			       }
			      }).catch(function(error){
			       console.log("Correo o Nick invalido");
			       $scope.prepit = true;
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
	$scope.navAcceptLegal= function(){
		var path = "/writeMe/#/acceptLegalEstablishment";
		window.location.href = path;
	}
}]);