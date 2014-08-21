'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:HomepageCtrl
 * @description
 * # HomepageCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp.homepage',['bikespaApp.grandfather'])
    .config(function ($stateProvider) {
        $stateProvider
            .state('app.homepage', {
                url: '/homepage',
                views:{
                    'menucontainer@':{
                        templateUrl: 'views/homepage.html',
                        controller: 'HomepageCtrl'
                    }
                },

                accessLevel: accessLevels.anon
            });
    })
    .controller('HomepageCtrl', function ($scope, $http, $timeout, $state) {


        $scope.EMAIL_REGEXP = /^[a-z0-9!#$%&'*+/=?^_`{|}~.-]+@[a-z0-9-]+(\.[a-z0-9-]+)*$/i;
    });

