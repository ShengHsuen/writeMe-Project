'use strict';

	angular.module('myApp.writting', ['ngRoute', 'ngStorage'])

	.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/writting', {
	    templateUrl: 'resources/writting/writting/writting.html',
	    controller: 'WrittingCtrl'
	  });
	}])
	
	.controller('WrittingCtrl', ['$scope','$http', '$localStorage',function($scope,$http,$localStorage) {
		
		var publish = false;
		
		$scope.psuccess = false;
		
		$('#myModal').on('show', function() {
		    var id = $(this).data('id'),
		        removeBtn = $(this).find('.danger');
		})

		$('.confirm-delete').on('click', function(e) {
		    e.preventDefault();

		    var id = $(this).data('id');
		    $('#myModal').data('id', id).modal('show');
		});

		$('#btnYes').click(function() {
		    // handle deletion here
		  	var id = $('#myModal').data('id');
		  	$('[data-id='+id+']').remove();
		  	$('#myModal').modal('hide');
		});
		
		$scope.send = function(){
			$('html, body').animate( {scrollTop : 0}, 800 );
			
			$scope.date = new Date();
			var year = $scope.date.getFullYear();
			var month = $scope.date.getMonth() + 1;
			var day = $scope.date.getDate();
			var hour = $scope.date.getHours();
			var minute = $scope.date.getMinutes();
			var second = $scope.date.getSeconds();
			$scope.fecha = year.toString() + "-" + month.toString() + "-" + day.toString();
			$scope.modified = $scope.fecha + " " + hour.toString() + ":" + minute.toString() + ":" + second.toString();
			
			$scope.modifiedDate = true;
			$scope.notModified = true;
			
			$scope.content = $('#edit').val();
			console.log($scope.content);
			update();
		}

		var update = function(){
			$scope.writting={
					"pageNumber": 0,
					"pageSize": 0,
					"direction": "",
					"sortBy": [""],
					"searchColumn": "string",
					"searchTerm": $scope.name,
					"writting": {
						"name" : $scope.name,
						"description" : "a",
						"cantUsers": 0,
						"date": $scope.fecha,
						"likes": 0,
						"limit time": "2100-01-01",
						"numMaxCharacters": 10000,
						"numMinCharacters": 30,
						"published": publish,
						"content": $scope.content
					}
			};
			$http.post('rest/protected/writting/editContent',$scope.writting).success(function(response) {
				if($scope.writting.getTypeWritting.equals("Personal")){
					console.log("NO CREA UN USERHASWRITTING");
				}else{
					console.log("SI CREA EL USERHASWRITTING");
					createUserHasWritting();
				}
				
			});
		}
		
		var createUserHasWritting = function(){
			$scope.userHasWritting={
					  "pageNumber": 0,
					  "pageSize": 0,
					  "direction": "string",
					  "sortBy": [
					    "string"
					  ],
					  "searchColumn": "string",
					  "searchTerm": "string",
					  "userHasWritting": {
						  "dateModifie": $scope.fecha,
					      "statusColor": false,
					      "user_has_writtingId": 0,
					      "linkInvitation": "string",
					      "banned": false,
					      "dateCreate": fecha,
					      "invitationStatus": false
					}
					
			};
			$http.post('rest/protected/writting/createUserHasWritting',$scope.userHasWritting).success(function(response) {
				
			});
		}
		
		$scope.publish = function(){
			$scope.writting={
					"pageNumber": 0,
					"pageSize": 0,
					"direction": "",
					"sortBy": [""],
					"searchColumn": "string",
					"searchTerm": $scope.name,
					"writting": {
						"name" : $scope.name,
						"description" : "a",
						"cantUsers": 0, // Pasarle cantUsers por parametro tambien porque sino le cae encima
						"date": fecha,
						"likes": 0,
						"limit time": "2100-01-01",
						"numMaxCharacters": 10000,
						"numMinCharacters": 30,
						"published": publish,
						"content": $scope.content
					}
			};
			$scope.psuccess = true;
			publish = true;
			$scope.content = $('#edit').val();
			console.log("Published: " + publish + "Fecha: " + fecha);
			$http.post('rest/protected/writting/publish',$scope.writting).success(function(response) {
				console.log("writting/publish");
			})
		}
		
		$scope.loadData = function(){
			$scope.content = $localStorage.showContent;
			$scope.name = $localStorage.nameWritting;
			$scope.content= $scope.content.replace(/(<\?[a-z]*(\s[^>]*)?\?(>|$)|<!\[[a-z]*\[|\]\]>|<!DOCTYPE[^>]*?(>|$)|<!--[\s\S]*?(-->|$)|<[a-z?!\/]([a-z0-9_:.])*(\s[^>]*)?(>|$))/gi, '');
			$scope.content= $scope.content.replace(/&nbsp;/g,'');
		}
		$scope.loadData();
		
		
	}]);