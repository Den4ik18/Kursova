var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request1_2 = [];
    var countRoom_id= 1;

    $http.get('http://localhost:8080/request/request1_2?countRoom_id='+countRoom_id).then(function (response){
        $scope.request1_2=response.data;
        console.log(response);
        document.getElementById("Amount").value=countRoom_id;
    });

    this.update_request = function add() {
        countRoom_id= document.getElementById("Amount").value;
        $http.get('http://localhost:8080/request/request1_2?countRoom_id='+countRoom_id).then(function (response){
            $scope.request1_2=response.data;
            console.log(response);
        });
    };
});