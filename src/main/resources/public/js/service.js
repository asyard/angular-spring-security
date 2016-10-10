(function(){

    var service = function($http){
        var getUsers = function(){
            return $http.get("/users3")
                .then(function(response){
                    return response.data;
                });
        };

        var getBooks = function(){
            return $http.get("/books")
                .then(function(response){
                    return response.data;
                });
        };
        // revealing module design pattern
        return {
            getUsers: getUsers,
            getBooks: getBooks
        };

    };

    var module = angular.module("app"); // we didnt use []. asking for reference of specified module
    module.factory("service", service);   // register a service with angular

}());