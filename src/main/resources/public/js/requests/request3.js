var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request3 = [];
    var date1= '2017-11-01';

    $http.get('/request/request3?firstDate='+date1).then(function (response){
        $scope.request3=response.data;
        console.log(response);
        document.getElementById("Date").value=date1;
    });

    this.update_request = function add() {
        date1= document.getElementById("Date").value;
        $http.get('/request/request3?firstDate='+date1).then(function (response){
            $scope.request3=response.data;
            console.log(response);
        });
    };
});