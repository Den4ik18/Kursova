var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request6 = [];
    var date= '2017-06-01';

    $http.get('/request/request6?date='+date).then(function (response){
        $scope.request6=response.data;
        console.log(response);
        document.getElementById("FirstDate").value=date;
    });

    this.update_request = function add() {
        date= document.getElementById("FirstDate").value;
        $http.get('/request/request6?date='+date).then(function (response){
            $scope.request6=response.data;
            console.log(response);
        });
    };
});