'use strict';

describe('Controller: HomepageCtrl', function () {

  // load the controller's module
  beforeEach(module('bikespaApp'));

  var HomepageCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    HomepageCtrl = $controller('HomepageCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
