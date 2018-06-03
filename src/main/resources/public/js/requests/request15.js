var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request15 = [];
    var room_id = 2;
    $http.get('/request/request15?room_id='+room_id).then(function (response){
        $scope.request15=response.data;
        console.log(response);
        $http.get('/room/get').then(function (response){
            var room = response.data;
            var selector = document.getElementById("Room");
            $(selector).empty();
            for (var i = 0; i < room.length; i++) {
                var option = document.createElement("option");
                option.text = room[i].numberOfRoom;
                option.value = room[i].idRoom;
                selector.add(option);
            }
            selector.selectedIndex=1;
            //selector.selectedIndex=1;
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("Room").selectedIndex;
        room_id= document.getElementById("Room").options[index].value;
        $http.get('/request/request15?room_id='+room_id).then(function (response){
            $scope.request15=response.data;
            console.log(response);
        });
    };
});