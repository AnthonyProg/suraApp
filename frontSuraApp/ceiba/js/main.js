var app = angular.module('makePolicy', []);
app.controller('myController', ['$scope', '$http', '$q', function ($scope, $http, $q) {

        var baseUrl = "http://192.168.101.104:9982";
        var baseUr2 = "192.168.101.117:8080";


        //Definición de funciones
        $scope.consultarMoneda = consultarMoneda;
        $scope.consultarTiposPropiedad = consultarTiposPropiedad;
        $scope.validarEstracto = validarEstracto;

        //Definición Variables
        $scope.listaMoneda = [];
        $scope.listaTipoPropiedad = [];
        $scope.listaEstracto = [];
        $scope.selectMoneda;
        $scope.selectTipoPropiedad;
        $scope.selectEstracto;

        $scope.customerName = null;
        $scope.customerID = null;
        $scope.buildingAddress = null;
        $scope.buildingType = null;
        $scope.selectedBuildingType = null;
        $scope.buildingPrice = null;
        $scope.currencyType = null;
        $scope.selectedCurrencyType = null;
        $scope.buildingStratum = null;
        $scope.buildingExtension = null;

        $scope.cleanFields = function () {
            $scope.customerName = null;
            $scope.customerID = null;
            $scope.buildingAddress = null;
            $scope.buildingType = null;
            $scope.buildingPrice = null;
            $scope.buildingStratum = null;
            $scope.buildingExtension = null;
        }


        //Implementacion

        //---------------PARA COMBO MONEDA
        function consultarMoneda() {
            $http.get(baseUrl + '/GlobalUtil/currencies', {}
            ).success(function (data, status, headers, config) {
                
                $scope.listaMoneda = data;
                console.log("cosultarMoneda estatus"+status);
                
            }).error(function (data, status, headers, config) {
            });
        }
        $scope.consultarMoneda();


        //---------------PARA COMBO TIPO DE PROPIEDAD 
        function consultarTiposPropiedad() {
            $http.get(baseUrl + '/GlobalUtil/propertyTypes', {}
            ).success(function (data, status, headers, config) {
                $scope.listaTipoPropiedad = data;
                 console.log("cosultarMoneda tipos propiedad"+status);
            }).error(function (data, status, headers, config) {
            });
        }
        $scope.consultarTiposPropiedad();

        //-------------PARA VALIDAR ESTRACTO
        function validarEstracto() {
            var num = 5;
            $http.post(baseUr2 + '/validate', num)
                    .success(function (data, status, headers, config) {

                        alert("estatus=========>" + status);
                        $scope.listaEstracto = data;

                    }).error(function (data, status, headers, config) {
                alert('Error al consultar estractos');
            });
        }
        $scope.validarEstracto();

    }]);
