var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request11 = [];
    $http.get('/request/request11').then(function (response){
        $scope.request11=response.data;
        console.log(response);
    });
});