var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request1_3 = [];
    var countRoom_id= 1;
    var date1= '2017-03-20';
    var date2= '2017-06-04';

    $http.get('http://localhost:8080/request/request1_3?countRoom_id='+countRoom_id+'&firstDate='+date1+'&secondDate='+
        date2).then(function (response){
        $scope.request1_3=response.data;
        console.log(response);
        document.getElementById("Amount").value=countRoom_id;
        document.getElementById("FirstDate").value=date1;
        document.getElementById("SecondDate").value=date2;
    });

    this.update_request = function add() {
        countRoom_id= document.getElementById("Amount").value;
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        $http.get('http://localhost:8080/request/request1_3?countRoom_id='+countRoom_id+'&firstDate='+date1+'&secondDate='+date2).then(function (response){
            $scope.request1_3=response.data;
            console.log(response);
        });
    };
});