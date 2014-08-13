'use strict';

describe('Directive: bikeDirective', function () {

  // load the directive's module
  beforeEach(module('bikespaApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<bike-directive></bike-directive>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the bikeDirective directive');
  }));
});
