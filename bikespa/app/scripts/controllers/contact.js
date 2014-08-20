'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:ContactCtrl
 * @description
 * # ContactCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp.contact',['bikespaApp.grandfather'])
    .config(function ($stateProvider) {
        $stateProvider
            .state('app.contact', {
                url: '/contact',
                views:{
                    'menucontainer@':{
                        templateUrl: 'views/contact.html',
                        controller: 'ContactCtrl'
                    }
                },

                accessLevel: accessLevels.anon
            });
    })
    .controller('ContactCtrl', function ($scope, $http, $timeout, $state) {

    });
