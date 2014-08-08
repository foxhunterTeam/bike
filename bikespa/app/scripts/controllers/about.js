'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
