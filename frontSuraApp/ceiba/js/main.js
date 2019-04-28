var app = angular.module('makePolicy', []);
app.controller('myController',['$scope','$http','$q',function($scope, $http, $q) {

  	//Parameters
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



		//Function to get buildingTypes data from back
		$scope.getBuildingTypes = function() {
      //Temporal, mientras se dispone del API con datos reales
					$scope.buildingType = [{typeID: 1,name:"apartamento"},
				                         {typeID: 2,name:"casa"},
				                         {typeID: 2,name:"local"}];
          $scope.selectedBuildingType = angular.copy($scope.buildingType[0]);
		};

		//Function to get currencyTypes data from back
		$scope.getCurrencyTypes = function() {
      //Temporal, mientras se dispone del API con datos reales
					$scope.currencyType = [{currencyID: 1,name:"COP"},
				                         {currencyID: 2,name:"DOLLAR"},
				                         {currencyID: 3,name:"EURO"}];
          $scope.selectedCurrencyType = angular.copy($scope.currencyType[0]);

					$http({
									method : "GET",
									url : "http://localhost:9982/GlobalUtil/currencies",
									// data : JSON.stringify($scope.formData),
									headers : {
										'Content-Type' : 'application/json',
										'Access-Control-Allow-Headers': '*',
										'Accept' : 'application/json'
									}
								}).then(function(response) {
													$scope.response = JSON.parse(JSON.stringify(response.data));
													console.log("Success");
												},
								function(response) {
												console.log("Fail");
												});
		}

    // Preloaded data for the form
    $scope.getBuildingTypes();
		$scope.getCurrencyTypes();


		//Function to reset form
		$scope.cleanFields = function() {
			$scope.customerName = null;
			$scope.customerID = null;
			$scope.buildingAddress = null;
			$scope.buildingType = null;
			$scope.buildingPrice = null;
			$scope.buildingStratum = null;
			$scope.buildingExtension = null;
		}

}]);
