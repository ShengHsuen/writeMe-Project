'use strict';

angular.module('myApp.legalEstablishment', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/legalEstablishment', {
    templateUrl: 'resources/legalEstablishment/legalEstablishment.html'
    	,    controller: 'legalEstablishmentCtrl'
  });
}])
.controller('legalEstablishmentCtrl', ['$scope', function($scope) {
    $scope.notBlackListed = function(value) {
      var blacklist = ['bad@domain.com','verybad@domain.com'];
      return blacklist.indexOf(value) === -1;
    }

    $scope.val = 15;
    var updateModel = function(val){
      $scope.$apply(function(){
        $scope.val = val;
      });
    };
    angular.element("#slider").on('slideStop', function(data){
      updateModel(data.value);
    });

    $scope.select2Number = [
      {text:'First',  value:'One'},
      {text:'Second', value:'Two'},
      {text:'Third',  value:'Three'}
    ];

    $scope.list_of_string = ['tag1', 'tag2']
    $scope.select2Options = {
        'multiple': true,
        'simple_tags': true,
        'tags': ['tag1', 'tag2', 'tag3', 'tag4']  // Can be empty list.
    };

    angular.element("#LinkInput").bind('click', function (event) {
      event.stopPropagation();
    });

    $scope.datePicker = function (start, end, label) {
      
    }
}]);


var thumbsUp = element(by.css('span.glyphicon-thumbs-up'));
var thumbsDown = element(by.css('span.glyphicon-thumbs-down'));

it('should check ng-show / ng-hide', function() {
  expect(thumbsUp.isDisplayed()).toBeFalsy();
  expect(thumbsDown.isDisplayed()).toBeTruthy();

  element(by.model('checked')).click();

  expect(thumbsUp.isDisplayed()).toBeTruthy();
  expect(thumbsDown.isDisplayed()).toBeFalsy();
});


