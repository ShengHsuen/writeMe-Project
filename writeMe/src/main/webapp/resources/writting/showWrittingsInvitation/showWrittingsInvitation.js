'use strict';
angular.module('myApp.showWrittingsInvitation', [ 'ngRoute' , 'ngStorage'])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/showWrittingsInvitation', {
		templateUrl : 'resources/writting/showWrittingsInvitation/showWrittingsInvitation.html',
		controller : 'showWrittingsInvitationCtrl'
	});
} ])

.controller('showWrittingsInvitationCtrl',['$scope','$http', '$localStorage','$rootScope',function($scope, $http, $localStorage,$rootScope) {
	
	// Mostrar
	$scope.init = function(){
		$scope.loadData = function(){
			$scope.sessionUser = $localStorage.data;
		}
		$scope.loadData();
	$scope.writting = [];
	$scope.writting = {
			"pageNumber" : 0,
			"pageSize" : 0,
			"direction" : "",
			"sortBy" : [ "" ],
			"searchColumn" : "string",
			"searchTerm" : " ",
			"writting" : {}
	};
	$http.post('users/getWrittings',$scope.writting).success(function(response) {
		$scope.writting = response.writtings;
		$scope.getIsOwnerList();
	}).catch(function(error){
		   $scope.serverDown = function()
			{
			   $rootScope.$broadcast('serverDown');
			}
		   $scope.serverDown();
	   });
	}
	$scope.init();
	
	$scope.getIsOwnerList = function(){
		$scope.getOwnerList = {
				"pageNumber" : 0,
				"pageSize" : 0,
				"direction" : "",
				"sortBy" : [ "" ],
				"searchColumn" : "string",
				"searchTerm" : $scope.sessionUser.author,
				"writting" : {}
		};
		$http.post('rest/protected/writting/getOwnerList',$scope.getOwnerList).success(function(response) {
			$scope.isOwnerList = response.isOwnerList;
			$scope.isOwnerList.reverse();
			console.log($scope.isOwnerList);
		})
	};
	
	$scope.saveData = function(mainWr, name, cantUsers, writtingId, writting){
		params: {mainWritting : mainWr};
	    params: {name : name};
		params: {cantUsers : cantUsers};
		params: {writtingId : writtingId};
		params: {writting : writting};
	    $localStorage.mainWritting = mainWr;
	    $localStorage.nameWritting = name;
	    $localStorage.cantUsers = cantUsers;
	    $localStorage.writtingId = writtingId;
	    $localStorage.writting = writting;
	    window.location.href = "app#/writtingInvitation"
	};
	
	$scope.navInvitation = function(mainWr, name, cantUsers, writtingId, writting){
		params: {mainWritting : mainWr};
	    params: {name : name};
		params: {cantUsers : cantUsers};
		params: {writtingId : writtingId};
		params: {writting : writting};
	    $localStorage.mainWritting = mainWr;
	    $localStorage.nameWritting = name;
	    $localStorage.cantUsers = cantUsers;
	    $localStorage.writtingId = writtingId;
	    $localStorage.writting = writting;
	    window.location.href = "app#/invitation";
    }
	
	  $scope.$on('invitation-started', function(event, args) {
		  $scope.init();
	  });

		    $scope.valOwner = function(writting){
		        $scope.getOwner = {
		                "pageNumber": 0,
		                "pageSize": 0,
		                "direction": "",
		                "sortBy": [""],
		                "searchColumn": "string",
		                "searchTerm": $scope.user.author,
		                "writting": writting
		            };
		    	$http.post('rest/protected/writting/getOwner',$scope.getOwner).success(function(response) {
		    		$scope.isOwner = response.isOwner;
		    		console.log("isOwner>>> " + $scope.isOwner);
		    	})
		    };
		    
		    
		    /*
			 * @author Mildred Guerra
		     *callback for ng-click 'deleteWritting':
		     */
		    $scope.deleteWritting = function (writtingId) {
		    	console.log("esta vara es el id del wriiting "+ writtingId)
		    			  $http({ url: 'rest/protected/writting/delete', 
		    	                method: 'DELETE', 
		    	                params: {writtingId: writtingId}
		    			  }).success(function() {
		    					$scope.init();
		    			    }).catch(function(error){
		    					   $scope.serverDown = function()
		    						{
		    						   $rootScope.$broadcast('serverDown');
		    						}
		    					   $scope.serverDown();
		    				   });
		   }
		    $scope.$on('invitation-send', function(event, args) {
		        $scope.init();
		       });
		    

} ]);