'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:PagesCtrl
 * @description
 * # PagesCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp.pages', ['bikespaApp.grandfather'])
    .config(function ($stateProvider) {
        $stateProvider
            .state('app.admin', {
                url: '/admin',
                templateUrl: 'views/admin.html',
                accessLevel: accessLevels.admin
            })
            .state('app.user', {
                url: '/user',
                templateUrl: 'views/user.html',
                accessLevel: accessLevels.user
            });
    });
