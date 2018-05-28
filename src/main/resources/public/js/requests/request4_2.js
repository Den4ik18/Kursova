var app = angular.module("kursova", [])

app.controller("AppCtrl", function ($http, $scope){
    $scope.request4_2 = [];
    var building_id=2;
    $http.get('/request/request4_2?building_id='+building_id).then(function (response){
        $scope.request4_2=response.data;
        console.log(response);
        $http.get('/building/get').then(function (response){
            var building = response.data;
            var selector = document.getElementById("Building");
            $(selector).empty();
            for (var i = 0; i < building.length; i++) {
                var option = document.createElement("option");
                option.text = building[i].areaOfNumber;
                option.value = building[i].idBuilding;
                selector.add(option);
            }
            selector.selectedIndex=1;
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("Building").selectedIndex;
        building_id= document.getElementById("Building").options[index].value;
        $http.get('/request/request4_2?building_id='+building_id).then(function (response){
            $scope.request4_2=response.data;
            console.log(response);
        });
    };
});