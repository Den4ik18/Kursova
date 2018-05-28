var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request10 = [];
    var date1= '2017-01-01';
    var date2= '2017-06-01';
    $http.get('/request/request10?firstDate='+date1+'&secondDate='+
        date2).then(function (response){
        $scope.request10=response.data;
        console.log(response);

        document.getElementById("FirstDate").value=date1;
        document.getElementById("SecondDate").value=date2;


    });

    this.update_request = function add() {
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        $http.get('/request/request10?firstDate='+date1+'&secondDate='+date2).then(function (response){
            $scope.request10=response.data;
            console.log(response);
        });
    };
});