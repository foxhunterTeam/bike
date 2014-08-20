'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:ServiceCtrl
 * @description
 * # ServiceCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp.service' ,['bikespaApp.grandfather'])
    .config(function ($stateProvider) {
        $stateProvider
            .state('app.service', {
                url: '/service',
                views:{
                    'menucontainer@':{
                        templateUrl: 'views/service.html',
                        controller: 'ServiceCtrl'
                    }
                },

                accessLevel: accessLevels.anon
            });
    })
    .controller('ServiceCtrl', function ($scope, $http, $timeout, $state) {

    });


