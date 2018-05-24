var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request9 = [];
    var idRoom= 11;

    $http.get('http://localhost:8080/request/request9?idRoom='+idRoom).then(function (response){
        $scope.request9=response.data;
        console.log(response);
        document.getElementById("Room").value=idRoom;
    });

    this.update_request = function add() {
        idRoom= document.getElementById("Room").value;
        $http.get('http://localhost:8080/request/request9?idRoom='+idRoom).then(function (response){
            $scope.request9=response.data;
            console.log(response);
        });
    };
});