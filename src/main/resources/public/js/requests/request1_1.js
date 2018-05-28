var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request1_1 = [];
    var countRoom_id= 1;

    $http.get('http://request/request1_1?countRoom_id='+countRoom_id).then(function (response){
        $scope.request1_1=response.data;
        console.log(response);
        document.getElementById("Amount").value=countRoom_id;
    });

    this.update_request = function add() {
        countRoom_id= document.getElementById("Amount").value;
        $http.get('http://request/request1_1?countRoom_id='+countRoom_id).then(function (response){
            $scope.request1_1=response.data;
            console.log(response);
        });
    };
});