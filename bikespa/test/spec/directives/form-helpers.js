'use strict';

describe('Directive: formHelpers', function () {

  // load the directive's module
  beforeEach(module('bikespaApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<form-helpers></form-helpers>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the formHelpers directive');
  }));
});
