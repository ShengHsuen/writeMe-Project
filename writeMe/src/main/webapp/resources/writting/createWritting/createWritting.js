'use strict';

angular.module('myApp.createWritting', ['ngRoute', 'angularFileUpload'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createWritting', {
    templateUrl: 'resources/writting/createWritting/createWritting.html',
    controller: 'Create_WrittingCtrl'
  });
}])

.controller('Create_WrittingCtrl', ['$scope','$http','$location','$upload', function($scope,$http,$location,$upload) {
	$scope.date = new Date();
	var anno = $scope.date.getFullYear();
	var mes = $scope.date.getMonth() + 1;
	var dia = $scope.date.getDate() + 1;
	var fecha = anno.toString() + "-" + mes.toString() + "-" + dia.toString();

	$scope.files = {
			"src":"http://localhost:8080/writeMe/resources/writtingImages/imageDefault.jpg"
	};
	$('#blah').attr('src', $scope.files.src);

	$scope.typeSelected = "Personal";
	$scope.cateSelected = "Antiguedades y Coleccionables";
		//Variables
		$scope.showCantUsers = false;
		$scope.category =[ "Antiguedades y Coleccionables", "Arquitectura", "Arte","Artes Escénicas", "Autoayuda","Biografía y Autobiografía",
		                   "Calendarios","Casa y Hogar", "Ciencia","Ciencias Políticas","Ciencias Sociales","Cocina, Comida y Vinos",
		                   "Colecciones Literarias","Comics y Novelas Gráficas","Computación e Internet","Crímenes Verdaderos",
		                   "Crítica Literaria","Cuerpo, Mente y Espíritu","Deportes y Recreación","Drama","Educación",
		                   "Estudio de Lenguas Extranjeras","Familia y Relaciones","Ficción","Ficción para Niños","Filosofía","Fotografía",
		                   "Guías de Ayuda","History & Geography","Humor","Jardinería","Juegos","Lengua y Literatura","Leyes",
		                   "Manualidades y Hobbies","Mascotas y Animales","Matemáticas","Medicina","Música","Naturaleza y Aire libre",
		                   "Negocios y Economia","Niños y Jóvenes","Novelties","Papeleria","Poesía","Psicología","Referencia",
		                   "Religión y Espiritualidad","Salud y Bienestar","Tecnología","Transporte","Tweens Fiction","Tweens Nonfiction",
		                   "Viajes","Video y DVD","Young Adult Fiction","Young Adult Nonfiction","Otros"
		                  ];
		$scope.types =["Personal","Por invitacion","Pública"];
		
		//Funciones
		$scope.chkIfPersonal = function(){
			if($scope.typeSelected != "Personal"){
				$scope.showCantUsers = true;
				console.log("true");
			}else{
				$scope.showCantUsers = false;
				$scope.cantUsers = 0;
				console.log($scope.cantUsers);
			}
		}
		$scope.navWritting = function(){
			createWritting();
			$scope.valInvitados();
		}
		
		
		$scope.valInvitados = function(){
			if($scope.cantUsers > 10){
				$scope.cantUsers = 10;
			}
		}
		
    	/*$scope.passName = function(){
    		$scope.$emit("passName_channel",$scope.name);
    	}*/
		
		var createWritting = function(){
			$scope.prepit = false;
			$scope.writting={
					"pageNumber": 0,
					"pageSize": 0,
					"direction": "",
					"sortBy": [""],
					"searchColumn": "string",
					"searchTerm": $scope.name,
					"writting": {
					      "date": fecha,
					      "participation": true,
					      "image": "",
					      "cantUsers": $scope.cantUsers,
					      "description": $scope.description,
					      "published": false,
					      "numMinCharacters": 10,
					      "content": "",
					      "category": $scope.cateSelected,
					      "typeWritting": $scope.typeSelected,
					      "limitTime": "2016-05-05",
					      "numMaxCharacters": 10000,
					      "writtingId": 0,
					      "name": $scope.name,
					      "likes": 0
					}
			};

		    

			$http.post('rest/protected/writting/create',$scope.writting).success(function(response) {
			    createUserHasWritting();
			    if($scope.prepit == false){
			     var path = "app#/showWrittings";
			     window.location.href = path;
			    }
			   }).catch(function(error){
			    console.log("Titulo no puede estar repetido");
			    $scope.prepit = true;
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
						  "dateModifie": "2016-02-02",
					      "statusColor": false,
					      "user_has_writtingId": 0,
					      "linkInvitation": "string",
					      "banned": false,
					      "dateCreate": "2016-02-02",
					      "invitationStatus": false
					}
					
			};

			
			$http.post('rest/protected/writting/createUserHasWritting',$scope.userHasWritting).success(function(response) {
				console.log("2");
			});
		}
		 $scope.onFileSelect = function($files) {
		    	$scope.files = $files;
				for ( var i = 0; i < $scope.files.length; i++) {
	    			var file = $scope.files[i];
	    			$scope.upload = $upload.upload({
	    				url : 'rest/protected/writting/addFiles',
	    				file : file,
	    			}).progress(
	    					function(evt) {
	    						console.log('percent: '+ parseInt(100.0 * evt.loaded / evt.total));
	    					}).success(function(data, status, headers, config) {
	    						// Rent is uploaded successfully
	    						console.log(data);
	    					});
	    	    			//.error(...)
	    	    			//.then(success, error, progress); 
	        		}
		    };
		    function readURL(input) {
		        if (input.files && input.files[0]) {
		            var reader = new FileReader();
		            
		            reader.onload = function (e) {
		                $('#blah').attr('src', e.target.result);
		            }
		            
		            reader.readAsDataURL(input.files[0]);
		        }
		    }
		    
		    $("#imgInp").change(function(){
		        readURL(this);
		    });
		    
}]);
