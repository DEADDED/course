angular.module('app.controllers', []).controller('MaschineListController', function($scope, $state, popupService, $window, Maschine) {
  $scope.maschines = Maschine.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks
  $scope.deleteMaschine = function(maschine) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Really delete this?')) {
    	maschine.$delete(function() {
        $scope.maschines = Maschine.query(); 
        $state.go('maschines');
      });
    }
  };
}).controller('MaschineViewController', function($scope, $stateParams, Maschine) {
  $scope.maschine = Maschine.get({ id: $stateParams.id}); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
}).controller('MaschineCreateController', function($scope, $state, $stateParams, Maschine) {
  $scope.maschine = new Maschine();  //create new shipwreck instance. Properties will be set via ng-model on UI

  $scope.addMaschine = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
    $scope.maschine.$save(function() {
      $state.go('maschines'); // on success go back to the list i.e. shipwrecks state.
    });
  };
}).controller('MaschineEditController', function($scope, $state, $stateParams, Maschine) {
  $scope.updateMaschine = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $scope.maschine.$update(function() {
      $state.go('maschines'); // on success go back to the list i.e. shipwrecks state.
    });
  };

  $scope.loadMaschine = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
    $scope.maschine = Maschine.get({ id: $stateParams.id });
  };

  $scope.loadMaschine(); // Load a shipwreck which can be edited on UI
});
