'use strict';

describe('Controller: GrandfatherCtrl', function () {

  // load the controller's module
  beforeEach(module('bikespaApp'));

  var GrandfatherCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    GrandfatherCtrl = $controller('GrandfatherCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
