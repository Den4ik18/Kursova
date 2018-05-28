var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request12 = [];
    var building_id = 6;
    $http.get('/request/request12?building_id='+building_id).then(function (response){
        $scope.request12=response.data;
        console.log(response);
        $http.get('/building/get').then(function (response){
            var building = response.data;
            var selector = document.getElementById("Hotel");
            $(selector).empty();
            for (var i = 0; i < building.length; i++) {
                var option = document.createElement("option");
                option.text = building[i].idBuilding;
                option.value = building[i].idBuilding;
                selector.add(option);
            }
            selector.selectedIndex=5;

        });


    });

    this.update_request = function add() {
        var index = document.getElementById("Hotel").selectedIndex;
        building_id= document.getElementById("Hotel").options[index].value;
        $http.get('/request/request12?building_id='+building_id).then(function (response){
            $scope.request12=response.data;
            console.log(response);
        });
    };
});