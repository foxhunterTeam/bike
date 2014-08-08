'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
