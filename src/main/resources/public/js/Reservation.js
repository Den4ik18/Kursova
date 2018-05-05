var App = angular.module('App', []);

App.controller('Reservation', function ($http, $scope) {
    var time = performance.now();
    $http.get('/reservation/get').then(function (response) {
        time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");
        $scope.reservation = response.data;
        //console.log(response);
    });


    this.startInsertReservation = function startUpdate() {
        $http.get('/building/get').then(function (response) {
            var building = response.data;
            var selector = document.getElementById("NumberOfHotel");
            $(selector).empty();
            for (var i = 0; i < building.length; i++) {
                var option = document.createElement("option");
                option.text = building[i].areaOfNumber;
                option.value = building[i].idBuilding;
                selector.add(option);

            }
        });

        $http.get('/room/get').then(function (response) {
            var room = response.data;
            var selector = document.getElementById("NumberOfRoom");
            $(selector).empty();
            for (var i = 0; i < room.length; i++) {
                var option = document.createElement("option");
                option.text = room[i].numberOfRoom;
                option.value = room[i].idRoom;
                selector.add(option);
            }
        });
        $http.get('/customer/get').then(function (response) {
            var customer = response.data;
            var selector = document.getElementById("NameOfCustomer");
            $(selector).empty();
            for (var i = 0; i < customer.length; i++) {
                var option = document.createElement("option");
                option.text = customer[i].nameOfCustomer;
                option.value = customer[i].idCustomer;
                selector.add(option);
            }
        });
    };

    this.insertToReservation = function add() {
        var indexNumberOfRoom = document.getElementById("NumberOfRoom").selectedIndex;
        var room_id = document.getElementById("NumberOfRoom").options[indexNumberOfRoom].value;

        var bookingDate = document.getElementById("BookingDate").value;
        var dateOfSettlement = document.getElementById("DateOfSettlement").value;
        var dataOfEviction = document.getElementById("DateOfEviction").value;

        var indexNameOfCustomer = document.getElementById("NameOfCustomer").selectedIndex;
        var customer_id = document.getElementById("NameOfCustomer").options[indexNameOfCustomer].value;

        var indexNumberOfHotel = document.getElementById("NumberOfHotel").selectedIndex;
        var building_id = document.getElementById("NumberOfHotel").options[indexNumberOfHotel].value;


        var req = {
            method: 'POST',
            url: '/reservation/insert',
            data: {
                room_id: room_id,
                bookingData: bookingDate,
                dataOfSettlement: dateOfSettlement,
                dataOfEviction: dataOfEviction,
                customer_id: customer_id,
                building_id: building_id
            }
        };
        var time = performance.now();
        $http(req).then(function (resp) {
            time = performance.now() - time;
            console.log('Додавання новго запису = ', time);
            alert("-----");
            window.location.reload();
        })
    };

    this.startUpdateReservation = function startUpdate(idReservation,room,bookingData,dataOfSettlement,dataOfEviction,customer,building) {

        $http.get('/building/get').then(function (response) {
            var buildings = response.data;
            var selector = document.getElementById("NumberOfHotelUPD");
            $(selector).empty();
            for (var i = 0; i < buildings.length; i++) {
                var option = document.createElement("option");
                if (buildings[i].idBuilding == building){
                    option.selected = 'selected';
                }
                option.text = buildings[i].areaOfNumber;
                option.value = buildings[i].idBuilding;
                selector.add(option);

            }
        });

        $http.get('/room/get').then(function (response) {
            var rooms = response.data;
            var selector = document.getElementById("NumberOfRoomUPD");
            $(selector).empty();
            for (var i = 0; i < rooms.length; i++) {
                var option = document.createElement("option");
                if (rooms[i].idRoom == room){
                    option.selected = 'selected';
                }
                option.text = rooms[i].numberOfRoom;
                option.value = rooms[i].idRoom;
                selector.add(option);
            }
        });

        $http.get('/customer/get').then(function (response) {
            var customers = response.data;
            var selector = document.getElementById("NameOfCustomerUPD");
            $(selector).empty();
            for (var i = 0; i < customers.length; i++) {
                var option = document.createElement("option");
                if (customers[i].idCustomer == customer){
                    option.selected = 'selected';
                }
                option.text = customers[i].nameOfCustomer;
                option.value = customers[i].idCustomer;
                selector.add(option);
            }
        });

        document.getElementById("IdReservationUPD").innerText = idReservation;
        document.getElementById("BookingDateUPD").value = bookingData;
        document.getElementById("DateOfSettlementUPD").value = dataOfSettlement;
        document.getElementById("DateOfEvictionUPD").value = dataOfEviction;

    };

    this.updateReservation = function update() {
        var id = document.getElementById("IdReservationUPD").innerText;
        var indexNumberOfRoom = document.getElementById("NumberOfRoomUPD").selectedIndex;
        var room_id = document.getElementById("NumberOfRoomUPD").options[indexNumberOfRoom].value;

        var bookingDate = document.getElementById("BookingDateUPD").value;
        var dateOfSettlement = document.getElementById("DateOfSettlementUPD").value;
        var dataOfEviction = document.getElementById("DateOfEvictionUPD").value;

        var indexNameOfCustomer = document.getElementById("NameOfCustomerUPD").selectedIndex;
        var customer_id = document.getElementById("NameOfCustomerUPD").options[indexNameOfCustomer].value;

        var indexNumberOfHotel = document.getElementById("NumberOfHotelUPD").selectedIndex;
        var building_id = document.getElementById("NumberOfHotelUPD").options[indexNumberOfHotel].value;


        var req = {
            method: 'POST',
            url: '/reservation/update?id='+id,
            data: {
                room_id: room_id,
                bookingData: bookingDate,
                dataOfSettlement: dateOfSettlement,
                dataOfEviction: dataOfEviction,
                customer_id: customer_id,
                building_id: building_id
            }
        };
        var time = performance.now();
        $http(req).then(function (resp) {
            time = performance.now() - time;
            console.log('Оновлення = ', time);
            alert("--------");
            window.location.reload();
        })
    };

    this.delFromReservation = function del(id) {
        var time = performance.now();
        $http.get('/reservation/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

