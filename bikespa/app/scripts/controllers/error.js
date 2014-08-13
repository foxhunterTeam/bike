'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:ErrorCtrl
 * @description
 * # ErrorCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp.error', ['bikespaApp.grandfather'])
    .config(function ($stateProvider) {
        $stateProvider
            .state('app.error', {
                url: '/error/:error',
                templateUrl: 'views/error.html',
                accessLevel: accessLevels.public
            });
    });

