'use strict';

/* Controllers */
angular.module('CarmenSanDiegoApp').controller('CarmenSanDiegoController', ['$scope','$http',
                                                                            
	function ($scope, $http) {
		/* scope */
		
		$scope.caso;
		$scope.paisActual;
		$scope.conexiones;
		$scope.villanos = [];
		$scope.villanoSeleccionado;
		$scope.destinosFallidos = [];                      
		$scope.juego;
		$scope.casoSeleccionado;
		$scope.pista;
		$scope.descripcion;
		$scope.recorridoCriminal = [];		
		
	
		$scope.generarCaso = function(){
			
			$http.get('/getCaso').success(function(data){
				$scope.caso= data.descripcion;
				$scope.villanos = data.nombresDeVillanos;
				$scope.paisActual = data.paisActual;
				$scope.conexiones = data.nombresDePaises;
			});
			
		};
		
		$scope.visitarBanco = function(){
		    var obtenerPistaJson = {
		    	pais : $scope.paisActual,
		    	lugar : "Banco"
		    };
			$http.post('/visitarLugar',obtenerPistaJson).success(function(data){
				$scope.pista = data.descripcion;
				$scope.destinosFallidos = data.paisesFallidos;
			});
		}
		
		$scope.visitarBiblioteca = function(){
			var obtenerPistaJson = {
					pais : $scope.paisActual,
					lugar : "Biblioteca"
			};
			
			$http.post('/visitarLugar', obtenerPistaJson).success(function(data){
				$scope.pista = data.descripcion;
				$scope.destinosFallidos = data.paisesFallidos;
			});
		}
		
		$scope.visitarClub = function(){
			var obtenerPistaJson = {
					pais : $scope.paisActual,
					lugar : "Club"
			};
			$http.post('/visitarLugar',obtenerPistaJson).success(function(data){
				$scope.pista = data.descripcion;
				$scope.destinosFallidos = data.paisesFallidos
			});
		}
		
		
		$scope.viajar = function(){
			var viajarJson = {
					destino : $scope.conexionSeleccionada
			};
			$http.post('/viajar',viajarJson).success(function(data){
				$scope.recorridoCriminal.push($scope.paisActual);
				$scope.paisActual = data.paisActual;
				$scope.conexiones = data.nombresDePaises;
			});
		}
		
		// LA DESCRIPCION ES EL TEXTO QUE TE DEVUELVE, SE DEBE MOSTRAR UN POP-UP QUE MUESTRE EL TEXTO
		// EN UN POP - UP
		$scope.emitirOrdenPara = function(){
			$http.get('/emitirOrdenPara/' + $scope.miVillano).success(function(data){
				$scope.descripcion = data;
				$scope.villanoSeleccionado = $scope.miVillano;
			});
		}
		
}
]);


