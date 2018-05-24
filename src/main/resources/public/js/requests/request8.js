var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request8 = [];
    $http.get('http://localhost:8080/request/request8').then(function (response){
        $scope.request8=response.data;
        console.log(response);
    });
});