var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request2_1 = [];
    var date1= '2017-01-01';
    var date2= '2017-05-01';
    //var building_id=1;
    var building_id=2;
    $http.get('/request/request2_1?building_id='+building_id+'&firstDate='+date1+'&secondDate='+
        date2).then(function (response){
        $scope.request2_1=response.data;
        console.log(response);
       $http.get('/building/get').then(function (response){
            var building = response.data;
            var selector = document.getElementById("Area");
            $(selector).empty();
            for (var i = 0; i < building.length; i++) {
                var option = document.createElement("option");
                option.text = building[i].areaOfNumber;
                option.value = building[i].idBuilding;
                selector.add(option);
            }
           //selector.selectedIndex=0;
           selector.selectedIndex=1;
        });
        document.getElementById("FirstDate").value=date1;
        document.getElementById("SecondDate").value=date2;


    });

    this.update_request = function add() {
        var index = document.getElementById("Area").selectedIndex;
        building_id= document.getElementById("Area").options[index].value;
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        $http.get('/request/request2_1?building_id='+building_id+'&firstDate='+date1+'&secondDate='+date2).then(function (response){
            $scope.request2_1=response.data;
            console.log(response);
        });
    };
});