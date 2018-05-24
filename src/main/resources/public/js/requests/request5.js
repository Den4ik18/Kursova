var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request5 = [];
    var idRoom= 69;

    $http.get('http://localhost:8080/request/request5?idRoom='+idRoom).then(function (response){
        $scope.request5=response.data;
        console.log(response);
        document.getElementById("Room").value=idRoom;
    });

    this.update_request = function add() {
        idRoom= document.getElementById("Room").value;
        $http.get('http://localhost:8080/request/request5?idRoom='+idRoom).then(function (response){
            $scope.request5=response.data;
            console.log(response);
        });
    };
});