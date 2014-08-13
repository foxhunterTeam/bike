'use strict';

/**
 * @ngdoc function
 * @name bikespaApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the bikespaApp
 */
angular.module('bikespaApp.home', ['bikespaApp.grandfather'])
    .config(function ($stateProvider) {
        $stateProvider
            .state('app.home', {
                url: '/',
                templateUrl: 'views/home.html',
                controller: 'HomeController'
            });
    })
    .controller('HomeController', function ($scope) {
        $scope.users = angular.fromJson(localStorage.getItem('userStorage'));
    });
