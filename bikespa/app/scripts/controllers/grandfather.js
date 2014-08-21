'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:GrandfatherCtrl
 * @description
 * # GrandfatherCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp.grandfather', ['ui.router'])
    .config(function ($stateProvider) {
        $stateProvider
            .state('app', {
                url: '/',
                views:{
                    'menucontainer':{
                        templateUrl: 'views/homepage.html'
                    }
                },
                resolve: {
                    'login': function (loginService, $q, $http) {
                        var roleDefined = $q.defer();

                        /**
                         * In case there is a pendingStateChange means the user requested a $state,
                         * but we don't know yet user's userRole.
                         *
                         * Calling resolvePendingState makes the loginService retrieve his userRole remotely.
                         */
                        if (loginService.pendingStateChange) {
                            return loginService.resolvePendingState($http.get('/user'));
                        } else {
                            roleDefined.resolve();
                        }
                        return roleDefined.promise;
                    }
                }
            });
    });
