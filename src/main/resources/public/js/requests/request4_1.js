var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request4_1 = [];
    var date1= '2017-11-01';

    $http.get('/request/request4_1?firstDate='+date1).then(function (response){
        $scope.request4_1=response.data;
        console.log(response);
        document.getElementById("Date").value=date1;
    });

    this.update_request = function add() {
        date1= document.getElementById("Date").value;
        $http.get('/request/request4_1?firstDate='+date1).then(function (response){
            $scope.request4_1=response.data;
            console.log(response);
        });
    };
});