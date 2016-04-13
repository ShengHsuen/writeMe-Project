/**
 * @author Mildred Guerra
 * JS report writting
 */
'use strict';
//@author Mildred Guerra

angular.module('myApp.reportWritting', [ 'ngRoute' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/reportWritting', {
		templateUrl : 'resources/writting/reportWritting/reportWritting.html',
		controller : 'reportWrittingCtrl'
	});
} ]).controller('reportWrittingCtrl',['$scope','$http','$rootScope', '$localStorage', function($scope,$http,$rootScope, $localStorage) {
	
	$scope.loadData = function(){
		$scope.sessionUser = $localStorage.data;
		$scope.Writting = $localStorage.Writting;
		console.log("localS "+ $localStorage.Writting);
	}
	$scope.loadData();
	$scope.types =["Contenido Inapropiado","Imagen inapropiada","Violacón de Copyright"];
	$scope.typeSelected = "Contenido Inapropiado";
	$scope.reportWrittingList = {};
	$scope.requestObject = []
	$scope.requestObject = {
			"pageNumber" : 0,
			"pageSize" : 0,
			"direction" : "",
			"sortBy" : [ "" ],
			"searchColumn" : "string",
			"searchTerm" : "",
			"report" : {}
	};

	//Get all the reports of reportWritting establishment
	$scope.init = function() {
		$http.post('rest/protected/reportWritting/getAll',
				$scope.requestObject).success(function(response) {
					$scope.reportWrittingList = response.reportWrittingList;
				});
	}

	$scope.init();
	// Show and hide create report form
	$scope.myVar = false;
	$scope.toggle = function() {
		$scope.myVar = !$scope.myVar;

		$scope.clean();
	};

	$scope.onError = false;
	// Save report
	$scope.saveReport = function(event) {
		$scope.requestObject =
					{
					  "reportId": 0,
					  "comment": $scope.description,
					  "penalty": "",
					  "typeReport":  $scope.typeSelected,
					  "writting": $scope.Writting
					}

		$http.post('rest/protected/reportWritting/create',
				$scope.requestObject).success(
						function(response) {
							$scope.toggle();
							console.log("writting "+$scope.Writting+" type "+$scope.typeSelected)
							$scope.init();
							$scope.clean();
							  window.location.href = "app#/home"
						}).catch(function(error){
							   $scope.serverDown = function()
								{
								   $rootScope.$broadcast('serverDown');
								}
							   $scope.serverDown();
						   });
	};
	$scope.clean = function() {
		$scope.description="";
		$scope.typeSelected="";
	}
    // callback for ng-click 'deletereportWritting':
    $scope.deletereportWritting = function (reportWrittingId) {

		  $http({ url: 'rest/protected/reportWritting/delete', 
              method: 'DELETE', 
              params: {reportId: reportWrittingId}
		  }).success(function() {
			$scope.init();
	    });
    	        }

} ]);