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
        /***
         *
         * init bikes
         *
         */
        $scope.bikes=[
            {
                title: 'Bike1',
                href: 'images/gallery/p1.jpg',
                type: 'image/jpeg',
                thumbnail: 'images/gallery/p1.jpg'
            },
            {
                title: 'Bike2',
                href: 'images/gallery/p2.jpg',
                type: 'image/jpeg',
                thumbnail: 'images/gallery/p2.jpg'
            },
            {
                title: 'Bike3',
                href: 'images/gallery/p3.jpg',
                type: 'image/jpeg',
                thumbnail: 'images/gallery/p3.jpg'
            },
            {
                title: 'Bike4',
                href: 'images/gallery/p4.jpg',
                type: 'image/jpeg',
                thumbnail: 'images/gallery/p4.jpg'
            },
            {
                title: 'Bike5',
                href: 'images/gallery/p5.jpg',
                type: 'image/jpeg',
                thumbnail: 'images/gallery/p5.jpg'
            },
            {
                title: 'Bike6',
                href: 'images/gallery/p6.jpg',
                type: 'image/jpeg',
                thumbnail: 'images/gallery/p6.jpg'
            },
            {
                title: 'Bike7',
                href: 'images/gallery/p7.jpg',
                type: 'image/jpeg',
                thumbnail: 'images/gallery/p7.jpg'
            },
            {
                title: 'Bike8',
                href: 'images/gallery/p8.jpg',
                type: 'image/jpeg',
                thumbnail: 'images/gallery/p8.jpg'
            },
            {
                title: 'Bike9',
                href: 'images/gallery/p9.jpg',
                type: 'image/jpeg',
                thumbnail: 'images/gallery/p9.jpg'
            },
            {
                title: 'Apple',
                href: 'http://example.org/images/apple.jpg',
                type: 'image/jpeg',
                thumbnail: 'http://example.org/thumbnails/apple.jpg'
            }

        ]


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

