'use strict';

angular.module('myApp.writting.directive', [])

.directive('passName', [function() {
	return {
        restrict: 'A',
        scope: {
            name: '='
        },
        templateUrl: 'resources/writting/createWritting/createWritting.html',

        link:function($scope){
        	$scope.passName = function(name){
        		$scope.$emit("NAME_CHANNEL",name);
        	}
        }
    }
}]);