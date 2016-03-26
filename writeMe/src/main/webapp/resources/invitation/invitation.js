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
	$scope.guests = [];
	$scope.user = [];
	$scope.required = false;
	$scope.addGuest = function(item){
		$scope.cantUsers --;
		$scope.user.splice($scope.functiontofindIndexByKeyValue($scope.user, 'author', item.author), 1);
	    $scope.guests.push({author:item.author});
	    console.log(item.author);
	}
	$scope.takeoutGuest = function(item){
		$scope.cantUsers ++;
		$scope.guests.splice($scope.functiontofindIndexByKeyValue($scope.guests, 'author', item.author), 1);
	      $scope.user.push({author:item.author});
	      console.log(item.author);
	}
	$scope.delSessionUser = function(){
		for (var i = 0; i < $scope.user.length; i++) {
			if($scope.user[i].author == $scope.sessionUser.author){
				$scope.user.splice(i,1);
			}
		}
	}
    $scope.functiontofindIndexByKeyValue = function (arraytosearch, key, valuetosearch) {
        for (var i = 0; i < arraytosearch.length; i++) {
          if (arraytosearch[i][key] == valuetosearch) {
            return i;
          }
        }
          return null;
      }
	$scope.loadData = function(){
			$scope.contentWithoutTags = $localStorage.showContent;
			$scope.name = $localStorage.nameWritting;
			$scope.cantUsers = $localStorage.cantUsers;
			$scope.sessionUser = $localStorage.data;
	}
	$scope.loadData();
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
    	 $scope.delSessionUser();
     });
 }]);