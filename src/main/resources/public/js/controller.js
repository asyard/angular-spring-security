app.controller('usersController', function($scope, service) {
    $scope.headingTitle = "User List";
    $scope.showBusy = true;

    function onUserComplete(data) {
        $scope.users = data; //angular will automatically deserialize JSON object to javascript object
    };

    function onError(reason) {
        $scope.error = "Could not fetch value : " + reason;
        $scope.users = undefined;
    };

    service.getUsers().then(onUserComplete, onError);
});

app.controller('booksController', function($scope, service) {
    $scope.headingTitle = "Books List";
    $scope.showBusy = true;

    function onBookComplete(data) {
        $scope.books = data; //angular will automatically deserialize JSON object to javascript object
    };

    function onError(reason) {
        $scope.error = "Could not fetch value : " + reason;
        $scope.books = undefined;
    };

    service.getBooks().then(onBookComplete, onError);

});