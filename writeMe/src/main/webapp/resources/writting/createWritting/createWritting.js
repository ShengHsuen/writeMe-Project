'use strict';

angular.module('myApp.createWritting', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createWritting', {
    templateUrl: 'resources/writting/createWritting/createWritting.html',
    controller: 'Create_WrittingCtrl'
  });
}])

.controller('Create_WrittingCtrl', ['$scope','$http',function($scope,$http) {
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
		                   "Viajes","Video y DVD","Young Adult Fiction","Young Adult Nonfiction"
		                  ];
		$scope.types =["Personal","Por invitacion","Publica"];
		
		//Funciones
		$scope.chkIfPersonal = function(){
			if($scope.type != "Personal"){
				$scope.showCantUsers = true;
			}else{
				$scope.showCantUsers = false;
			}
		}
		$scope.navWritting = function(){
			var path = "/writeMe/app#/writting";
			window.location.href = path;
			createWritting();
		}
		
    	/*$scope.passName = function(){
    		$scope.$emit("passName_channel",$scope.name);
    	}*/
		
		var createWritting = function(){
			$scope.writting={
					"pageNumber": 0,
					"pageSize": 0,
					"direction": "",
					"sortBy": [""],
					"searchColumn": "string",
					"searchTerm": $scope.name,
					"writting": {
						"name" : $scope.name,
						"description" : $scope.description,
						"cantUsers": $scope.cantUsers,
						"date": "2016-02-02",
						"likes": 0,
						"limit time": "2100-01-01",
						"numMaxCharacters": 10000,
						"numMinCharacters": 30,
						"published": false,
						"content": ""
					}
			};
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
			$http.post('writting/create',$scope.writting).success(function(response) {
				console.log("1");
			});
			$http.post('writting/createUserHasWritting',$scope.userHasWritting).success(function(response) {
				console.log("2");
			});
			
		}
	
}]);
