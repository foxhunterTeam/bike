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

        /**
         *  init gallery click function
         *
         */
        $scope.clickToGallery = function () {

            var links=[
                'images/gallery/p1.jpg',
                'images/gallery/p2.jpg',
                'images/gallery/p3.jpg',
                'images/gallery/p4.jpg',
                'images/gallery/p5.jpg',
                'images/gallery/p6.jpg'

            ];
            var linksThumb=[
                {
                    title: 'Banana',
                    href: 'http://example.org/images/banana.jpg',
                    type: 'image/jpeg',
                    thumbnail: 'http://example.org/thumbnails/banana.jpg'
                },
                {
                    title: 'Apple',
                    href: 'http://example.org/images/apple.jpg',
                    type: 'image/jpeg',
                    thumbnail: 'http://example.org/thumbnails/apple.jpg'
                }
            ];
            blueimp.Gallery($(links), $('#blueimp-gallery').data());

        };

    });

