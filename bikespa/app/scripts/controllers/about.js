'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp.about',['bikespaApp.grandfather'])
    .config(function ($stateProvider) {
        $stateProvider
            .state('app.about', {
                url: '/about',
                views:{
                    'menucontainer@':{
                        templateUrl: 'views/about.html',
                        controller: 'AboutCtrl'
                    },
                    'menucontainer2@':{
                        template:"template  af  template "
                    }
                },

                accessLevel: accessLevels.anon
            });
    })
  .controller('AboutCtrl', function ($scope, $http, $timeout, $state) {

    });


