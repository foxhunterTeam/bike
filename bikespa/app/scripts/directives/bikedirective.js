'use strict';

/**
 * @ngdoc directive
 * @name bikespaApp.directive:bikeDirective
 * @description
 * # bikeDirective
 */
angular.module('bikespaApp')
  .directive('bikeDirective', function () {
    return {
      template: '<div></div>',
      restrict: 'E',
      link: function postLink(scope, element, attrs) {
        element.text('this is the bikeDirective directive');
      }
    };
  });
