'use strict';

describe('Service: mockhttp', function () {

  // load the service's module
  beforeEach(module('bikespaApp'));

  // instantiate service
  var mockhttp;
  beforeEach(inject(function (_mockhttp_) {
    mockhttp = _mockhttp_;
  }));

  it('should do something', function () {
    expect(!!mockhttp).toBe(true);
  });

});
