'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:GalleryCtrl
 * @description
 * # GalleryCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp.gallery',['bikespaApp.grandfather'])
    .config(function ($stateProvider) {
        $stateProvider
            .state('app.gallery', {
                url: '/gallery',
                views:{
                    'menucontainer@':{
                        templateUrl: 'views/gallery.html',
                        controller: 'GalleryCtrl'
                    }
                },

                accessLevel: accessLevels.anon
            });
    })
    .controller('GalleryCtrl', function ($scope, $http, $timeout, $state) {

    });

