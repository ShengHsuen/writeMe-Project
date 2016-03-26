/**
 * 
 */
'use strict';
angular.module('myApp.viewWritting', [ 'ngRoute' , 'ngStorage'])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/viewWritting', {
		templateUrl : 'resources/writting/viewWritting/viewWritting.html',
		controller : 'viewWrittingCtrl'
	});
} ]).controller('viewWrittingCtrl',['$scope','$http', '$localStorage','$rootScope', function($scope,$http,$localStorage,$rootScope) {

		$scope.loadData = function(){
			$scope.contentWithoutTags = $localStorage.showContent;
			$scope.name = $localStorage.nameWritting;
			$scope.category=$localStorage.categoryWritting;
			$scope.img=$localStorage.imgWritting;
		      $('#preview').html($scope.contentWithoutTags);
		}
		$scope.loadData();
		
	// Mostrar
var init = function(){
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
	
	$http.post('users/getWrittings',$scope.writting).success(function(response) {
		$scope.writting = response.writtings;
	});
	init();
}
} ]);