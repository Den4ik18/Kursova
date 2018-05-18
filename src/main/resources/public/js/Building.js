var App = angular.module('App',[]);

App.controller('Building',function ($http,$scope) {
    //var time = performance.now();
    $http.get('/building/get').then(function (response){
        //time = performance.now() - time;
        //console.log('Час виконанння = ', time);
        //alert("-----");
        $scope.building=response.data;
        //console.log(response);
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
        //console.log(req);
        //var time = performance.now();
        $http(req).then(function (resp) {
            //console.log(resp);
            /*time = performance.now() - time;
            console.log('Додавання нового запису = ', time);
            alert("--------");*/
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
        //console.log(req);
        //var time = performance.now();
        $http(req).then(function (resp) {
            //console.log(resp);
            /*time = performance.now() - time;
            console.log('Оновлення = ', time);
            alert("--------");*/
            window.location.reload();
        })
    };

    this.delFromBuilding = function del(id) {
        //var time = performance.now();
        $http.get('/building/del?id=' + id).then(function () {
            /*time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");*/
            window.location.reload();
        });
    };
});

