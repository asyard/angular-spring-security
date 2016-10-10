var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
        .when('/users',{
            templateUrl: '/views/users.html',
            controller: 'usersController'
        })
        .when('/books',{
            templateUrl: '/views/books.html',
            controller: 'booksController'
        })
        .otherwise(
            { redirectTo: '/'}
        );
});