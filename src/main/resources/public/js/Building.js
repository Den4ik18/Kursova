var App = angular.module('App',[]);

App.controller('Building',function ($http,$scope) {
    $http.get('/building/get').then(function (response){
        $scope.building=response.data;
        console.log(response);
    });
    this.insertToBuilding = function add() {
        var classH = document.getElementById("ClassHotel").value;
        var count = document.getElementById("CountOfFloors").value;
        var total = document.getElementById("TotalNumberOfRooms").value;
        var countRooms = document.getElementById("CountRoomsOnTheFloor").value;
        var area = document.getElementById("AreaOfNumbers").value;
        var address = document.getElementById("AddressOfHotel").value;

        var req = {
            method: 'POST',
            url: '/building/insert',
            data: {
                classHotel: classH,
                countOfFloor: count,
                totalCountOfRooms: total,
                countRoomsOnTheFloor: countRooms,
                areaOfNumber: area,
                addressOfHotelBuilding: address
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdateBuilding = function startUpdate(idBuilding,classHotel,countOfFloor,
                                                    totalCountOfRooms,countRoomsOnTheFloor,areaOfNumber,addressOfHotelBuilding) {
        document.getElementById("BuildingIdUPD").value = idBuilding;
        document.getElementById("ClassHotelUPD").value = classHotel;
        document.getElementById("CountOfFloorsUPD").value = countOfFloor;
        document.getElementById("TotalNumberOfRoomsUPD").value = totalCountOfRooms;
        document.getElementById("CountRoomsOnTheFloorUPD").value = countRoomsOnTheFloor;
        document.getElementById("AreaOfNumbersUPD").value = areaOfNumber;
        document.getElementById("AddressOfHotelUPD").value = addressOfHotelBuilding;
    };

    this.updateBuilding = function update() {
        var id = document.getElementById("BuildingIdUPD").value;
        var classH = document.getElementById("ClassHotelUPD").value;
        var count = document.getElementById("CountOfFloorsUPD").value;
        var total = document.getElementById("TotalNumberOfRoomsUPD").value;
        var countRooms = document.getElementById("CountRoomsOnTheFloorUPD").value;
        var area = document.getElementById("AreaOfNumbersUPD").value;
        var address = document.getElementById("AddressOfHotelUPD").value;
        var req = {
            method: 'POST',
            url: '/building/update?id=' + id,
            data: {
                classHotel: classH,
                countOfFloor: count,
                totalCountOfRooms: total,
                countRoomsOnTheFloor: countRooms,
                areaOfNumber: area,
                addressOfHotelBuilding: address
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.delFromBuilding = function del(id) {
        $http.get('/building/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

