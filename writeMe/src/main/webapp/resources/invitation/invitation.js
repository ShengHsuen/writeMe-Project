'use strict';

angular.module('myApp.invitation', ['ngRoute', 'ngStorage'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/invitation', {
        templateUrl: 'resources/invitation/invitation.html',
        controller: 'InvitationCtrl'
    });
 }])
 
 .controller('InvitationCtrl', ['$scope','$http', '$localStorage','$rootScope', function($scope,$http,$localStorage,$rootScope) {
	$scope.fil = '';
	$scope.loadData = function(){
			$scope.contentWithoutTags = $localStorage.showContent;
			$scope.name = $localStorage.nameWritting;
	}
	$scope.loadData();
	 $scope.user = [];
	 $scope.users = {"pageNumber": 0,
		        "pageSize": 0,
		        "direction": "",
		        "sortBy": [""],
		        "searchColumn": "string",
		        "searchTerm": "",
		        "users": {}
	  }
     $http.post('rest/protected/invitation/getAll', $scope.users).success(function(response) {
    	 $scope.user = response.users;
    	 console.log($scope.user);
     });
 }]);