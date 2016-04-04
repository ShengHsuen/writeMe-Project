'use strict';

angular.module('myApp.writtingInvitation', ['ngRoute', 'ngStorage'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/writtingInvitation', {
        templateUrl: 'resources/writting/writtingInvitation/writtingInvitation.html',
        controller: 'WrittingInvitationCtrl'
    });
 }]).controller('WrittingInvitationCtrl', ['$scope','$http', '$localStorage','$rootScope', function($scope,$http,$localStorage,$rootScope) {

	 	$scope.disableButtons = function() {
	    	$rootScope.$broadcast('disableButtons');
	    };
	 	$scope.disableButtons();
	 
		$scope.loadData = function(){
			$scope.name = $localStorage.nameWritting;
		}
		$scope.loadData();	

		$scope.date = new Date();
		var anno = $scope.date.getFullYear();
		var mes = $scope.date.getMonth() + 1;
		var dia = $scope.date.getDate();
		var fecha = anno.toString() + "-" + mes.toString() + "-" + dia.toString();
		
		var publish = false;
		
	    $scope.ppublish = false;
		
		$scope.finish = function(){
			$scope.content = $('#edit').val();
			updateFinish();
			$rootScope.$broadcast('disableButtonsTrue');
			
			var path = "/writeMe/app#/showWrittingsInvitation";
			  window.location.href = path;
		}

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
			console.log("ENTRA TODOS LOS DATOS?" + $scope.writting);
			update();
		}

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
			$('[data-id=' + id + ']').remove();
			$('#myModal').modal('hide');
		});

    $scope.navHome = function() {
    	$rootScope.$broadcast('home-started');
        var path = "app#/home";
        window.location.href = path;
    };
    
    $scope.navInvitation = function(){
    	var path = "app#/invitation";
        window.location.href = path;
    }
    
    var createWritting = function() {
        $scope.writting = {
            "pageNumber": 0,
            "pageSize": 0,
            "direction": "",
            "sortBy": [""],
            "searchColumn": "string",
            "searchTerm": $scope.name,
            "writting": {
                "name": $scope.name,
                "description": "a",
                "cantUsers": 0,
                "date": fecha,
                "likes": 0,
                "limit time": "2100-01-01",
                "numMaxCharacters": 10000,
                "numMinCharacters": 30,
                "published": publish,
                "content": $scope.content
            }
        };
        $http.post('rest/protected/writting/createWrittingInvitation', $scope.writting).success(function(response) {
				createUserHasWritting();
        }).catch(function(error){
 		   $scope.serverDown = function()
			{
			   $rootScope.$broadcast('serverDown');
			}
		   $scope.serverDown();
	   });
    }
    
    var updateFinish = function() {
        $scope.writting = {
            "pageNumber": 0,
            "pageSize": 0,
            "direction": "",
            "sortBy": [""],
            "searchColumn": "string",
            "searchTerm": $scope.name,
            "writting": {
                "name": $scope.name,
                "description": "a",
                "cantUsers": 0,
                "date": fecha,
                "likes": 0,
                "limit time": "2100-01-01",
                "numMaxCharacters": 10000,
                "numMinCharacters": 30,
                "published": publish,
                "content": $scope.content
            }
        };
        $http.post('rest/protected/writting/editContentFinish', $scope.writting).success(function(response) {
				
        }).catch(function(error){
 		   $scope.serverDown = function()
			{
			   $rootScope.$broadcast('serverDown');
			}
		   $scope.serverDown();
	   });
    }
    
    var update = function() {
        $scope.writting = {
            "pageNumber": 0,
            "pageSize": 0,
            "direction": "",
            "sortBy": [""],
            "searchColumn": "string",
            "searchTerm": $scope.name,
            "writting": {
                "name": $scope.name,
                "description": "a",
                "cantUsers": 0,
                "date": fecha,
                "likes": 0,
                "limit time": "2100-01-01",
                "numMaxCharacters": 10000,
                "numMinCharacters": 30,
                "published": publish,
                "content": $scope.content
            }
        };
        $http.post('rest/protected/writting/editContent', $scope.writting).success(function(response) {
				
        }).catch(function(error){
 		   $scope.serverDown = function()
			{
			   $rootScope.$broadcast('serverDown');
			}
		   $scope.serverDown();
	   });
    }

    var createUserHasWritting = function() {
        $scope.userHasWritting = {
            "pageNumber": 0,
            "pageSize": 0,
            "direction": "string",
            "sortBy": [
                "string"
            ],
            "searchColumn": "string",
            "searchTerm": "string",
            "userHasWritting": {
                "dateModifie": fecha,
                "statusColor": false,
                "user_has_writtingId": 0,
                "linkInvitation": 1,
                "banned": false,
                "dateCreate": fecha,
                "invitationStatus": true
            }
        };
        
        $http.post('rest/protected/writting/createUserHasWritting', $scope.userHasWritting).success(function(response) {

        }).catch(function(error){
 		   $scope.serverDown = function()
			{
			   $rootScope.$broadcast('serverDown');
			}
		   $scope.serverDown();
	   });
    }

    $scope.showPublish = function(){
    	$('html, body').animate( {scrollTop : 0}, 800 );
    	if($scope.ppublish == false){
    		$scope.ppublish = true;
    	}else{
    		$scope.ppublish = false;
    	}	
    };
    
    $scope.publish = function() {
        $scope.writting = {
            "pageNumber": 0,
            "pageSize": 0,
            "direction": "",
            "sortBy": [""],
            "searchColumn": "string",
            "searchTerm": $scope.name,
            "writting": {
                "name": $scope.name,
                "description": "a",
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
        
        publish = true;
        $scope.content = $('#edit').val();
        console.log("Published: " + publish + "Fecha: " + fecha);
        $scope.navHome();
        $http.post('rest/protected/writting/publish', $scope.writting).success(function(response) {
            console.log("writting/publish");
        }).catch(function(error){
 		   $scope.serverDown = function()
			{
			   $rootScope.$broadcast('serverDown');
			}
		   $scope.serverDown();
	   });
    }
    
    

    /* Mandar el habilitado, el actor actual, y revisar si hay un actor adentro
     * cuando se le da salir, se guarda y se vuelve a setear el campo de actor adentro en blanco 
     * 
     * */
    
    
    var content = "";
    $scope.participation;
    var name= "";
    
	$scope.loadData = function(){
		name = $localStorage.nameWritting;
	}
	$scope.loadData();

    $scope.contentLastWritting = function(){
    	$scope.writting = {
    			"pageNumber" : 0,
    			"pageSize" : 0,
    			"direction" : "",
    			"sortBy" : [ "" ],
    			"searchColumn" : "string",
    			"searchTerm" : name,
    			"writting" : {}
    	};
    	$http.post('rest/protected/writting/getContentLastWrittingByMain',$scope.writting
		  ).success(function(response) {
		     content = response.content;
		     $scope.participation = response.participation;
		     
		     $('#preview').html(content);
		     
		     if($scope.participation == true){
		    	 $scope.divShow = false;
		    	 
		     }else{
		    	 $scope.divShow = true;
		    	 createWritting();
		     }
		    })
		   
    };

    $scope.contentLastWritting();

   

}]);
