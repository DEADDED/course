angular.module('app.controllers', []).controller('MaschineListController', function($scope, $state, popupService, $window, Maschine) {
  $scope.maschines = Maschine.query(); 
  $scope.deleteMaschine = function(maschine) { 
    if (popupService.showPopup('Really delete this?')) {
    	maschine.$delete(function() {
        $scope.maschines = Maschine.query(); 
        $state.go('maschines');
      });
    }
  };
}).controller('MaschineViewController', function($scope, $stateParams, Maschine) {
  $scope.maschine = Maschine.get({ id: $stateParams.id}); 
}).controller('MaschineCreateController', function($scope, $state, $stateParams, Maschine) {
  $scope.maschine = new Maschine();  

  $scope.addMaschine = function() { 
    $scope.maschine.$save(function() {
      $state.go('maschines'); 
    });
  };
}).controller('MaschineEditController', function($scope, $state, $stateParams, Maschine) {
  $scope.updateMaschine = function() { 
    $scope.maschine.$update(function() {
      $state.go('maschines');
    });
  };

  $scope.loadMaschine = function() { 
    $scope.maschine = Maschine.get({ id: $stateParams.id });
  };

  $scope.loadMaschine(); 
});
