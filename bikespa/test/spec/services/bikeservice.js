'use strict';

describe('Service: bikeService', function () {

  // load the service's module
  beforeEach(module('bikespaApp'));

  // instantiate service
  var bikeService;
  beforeEach(inject(function (_bikeService_) {
    bikeService = _bikeService_;
  }));

  it('should do something', function () {
    expect(!!bikeService).toBe(true);
  });

});
