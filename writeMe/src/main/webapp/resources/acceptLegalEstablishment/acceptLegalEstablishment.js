'use strict';
var i = 1;
angular.module('myApp.acceptLegalEstablishment', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/acceptLegalEstablishment', {
    templateUrl: 'resources/acceptLegalEstablishment/acceptLegalEstablishment.html'
    	,    controller: 'acceptLegalCtrl'
  });
}])
.controller('acceptLegalCtrl', ['$scope', '$http', function($scope, $http) {

		//OBTENER TODAS
	    $scope.init = function() {
	    	
	    	
	    };
	
	    //Mostarr
		$scope.legalList = {};
		 $scope.requestObject = []
		$http.post('rest/protected/legal/getAll',$scope.requestObject).success(function(response) {
			$scope.legalList = response.legalList;
		});
		 $scope.gridOptions = {
				   data:'legalList',
				   columnDefs:[
				               {field:'name',displayName:'Nombre'},
				               {field:'description',displayName:'Descripción'}]
				  };
	    }]);