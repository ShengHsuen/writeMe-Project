'use strict';
var i = 1;
angular.module('myApp.legalEstablishment', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/legalEstablishment', {
    templateUrl: 'resources/legalEstablishment/legalEstablishment.html'
    	,    controller: 'legalEstablishmentCtrl'
  });
}])
.controller('legalEstablishmentCtrl', ['$scope', '$http', function($scope, $http) {
	//Mostrar menu crear regla   
	$scope.myVar = false;
	    $scope.toggle = function() {
	        $scope.myVar = !$scope.myVar;
	    };

		$scope.onError = false;
		
	
	   //Guardar regla
  $scope.saveRule = function(event) {
		$scope.requestObject={
				    		      "legal_establishmentId": 0,
				    		      "description": $scope.description,
				    		      "part": 6,
				    		      "name": $scope.name
				    		    }
				    		

  		console.log("$scope.requestObject",$scope.requestObject );
		  $http.post('rest/protected/legal/create',$scope.requestObject).success(function(response) {
		  		console.log($scope.requestObject );
	  	  });
	  };

	    
	    //Mostarr
		$scope.legalList = {};
		 $scope.requestObject = []
		$scope.requestObject = {"pageNumber": 0,"pageSize": 0,"direction": "","sortBy": [""],"searchColumn": "string","searchTerm": "","legalEstablishment": {}};
		$http.post('rest/protected/legal/getAll',$scope.requestObject).success(function(response) {
			$scope.legalList = response.legalList;
		});
		 $scope.gridOptions = {
				   data:'legalList',
				   showGroupPanel: true,
				   enableSorting:true,
				   enableFiltering:true,
				   columnDefs:[
				               {field:'part',displayName:'Parte #'},
				               {field:'name',displayName:'Nombre'},
				               {field:'description',displayName:'Descripción'}]
				  };
	    }]);