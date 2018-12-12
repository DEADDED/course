angular.module('app.services', []).factory('Maschine', function($resource) {
  return $resource('/api/v1/maschines/:id', { id: '@id' }, {
    update: {
      method: 'PUT',
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
