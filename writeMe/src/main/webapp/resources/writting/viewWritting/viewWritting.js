/**
 * @author Mildred Guerra
 * js to view writting
 */
'use strict';
angular.module('myApp.viewWritting', [ 'ngRoute' , 'ngStorage'])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/viewWritting', {
		templateUrl : 'resources/writting/viewWritting/viewWritting.html',
		controller : 'viewWrittingCtrl'
	});
} ]).controller('viewWrittingCtrl',['$scope','$http', '$localStorage','$rootScope', function($scope,$http,$localStorage,$rootScope) {

	/*
	 * @author Mildred Guerra
	 *'getwrittingByMain':
	 */
	var init = function () {
		$scope.writting = [];
		$scope.writting = {
				"pageNumber" : 0,
				"pageSize" : 0,
				"direction" : "",
				"sortBy" : [ "" ],
				"searchColumn" : "string",
				"searchTerm" : "",
				"writting" : {}
		};
				  $http({ url: 'rest/protected/writting/getByMain', 
		                method: 'POST', 
		                params: {writtingId: $scope.idWritting}
				  }).success(function(response) {
					  $scope.writting = response.writting;
					  length=$scope.writting.length;
					  $scope.name =  $scope.writting[0].name;
					  $scope.img=$scope.writting[0].image;
					  $scope.category=$scope.writting[0].category;
					  for (i = 0; i < length; i++) {
						  $('#preview').html($scope.writting[i].content);
					  }
				    });
		        }
	
		$scope.loadData = function(){
		/*	$scope.contentWithoutTags = $localStorage.showContent;
			$scope.name = $localStorage.nameWritting;
			$scope.category=$localStorage.categoryWritting;
			$scope.img=$localStorage.imgWritting;
		      $('#preview').html($scope.contentWithoutTags);*/
			$scope.idWritting = $localStorage.idWritting;
			init();
		}
		$scope.loadData();
}
 ]);