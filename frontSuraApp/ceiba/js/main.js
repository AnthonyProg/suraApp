var app = angular.module('makePolicy', []);
app.controller('myController',['$scope','$http','$q',function($scope, $http, $q) {

  	//Parameters
		$scope.customerName = null;
		$scope.customerID = null;
		$scope.buildingAddress = null;
		$scope.buildingType = null;
		$scope.selectedBuildingType = null;
		$scope.buildingPrice = null;
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

    // Preloaded data for the form
    $scope.getBuildingTypes();

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
