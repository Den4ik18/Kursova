var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request5 = [];
    var idRoom= 15;
    //69

    $http.get('/request/request5?idRoom='+idRoom).then(function (response){
        $scope.request5=response.data;
        console.log(response);
        document.getElementById("Room").value=idRoom;
    });

    this.update_request = function add() {
        idRoom= document.getElementById("Room").value;
        $http.get('/request/request5?idRoom='+idRoom).then(function (response){
            $scope.request5=response.data;
            console.log(response);
        });
    };
});