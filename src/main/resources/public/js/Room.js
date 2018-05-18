var App = angular.module('App', []);

App.controller('Room', function ($http, $scope) {
    //var time = performance.now();
    $http.get('/room/get').then(function (response) {
        /*time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");*/
        $scope.room = response.data;
        //console.log(response);
    });


    this.startInsertRoom = function startUpdate() {
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

    this.insertToRoom = function add() {
        var numberOfRoom = document.getElementById("NumberOfRoom").value;

        var dateOfSettlement = document.getElementById("DateOfSettlement").value;
        var dataOfEviction = document.getElementById("DateOfEviction").value;
        var bookingDate = document.getElementById("BookingDate").value;

        var indexNumberOfHotel = document.getElementById("NumberOfHotel").selectedIndex;
        var building_id = document.getElementById("NumberOfHotel").options[indexNumberOfHotel].value;

        var indexNameOfCustomer = document.getElementById("NameOfCustomer").selectedIndex;
        var customer_id = document.getElementById("NameOfCustomer").options[indexNameOfCustomer].value;




        var req = {
            method: 'POST',
            url: '/room/insert',
            data: {
                numberOfRoom: numberOfRoom,
                dataOfSettlement: dateOfSettlement,
                dataOfEviction: dataOfEviction,
                bookingDate: bookingDate,
                building_id: building_id,
                customer_id: customer_id
            }
        };
        //var time = performance.now();
        $http(req).then(function (resp) {
            /*time = performance.now() - time;
            console.log('Додавання новго запису = ', time);
            alert("-----");*/
            window.location.reload();
        })
    };

    this.startUpdateRoom = function startUpdate(idRoom,numberOfRoom,dataOfSettlement,dataOfEviction,bookingDate,building,customer) {

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

        document.getElementById("IdRoomUPD").innerText = idRoom;
        document.getElementById("NumberOfRoomUPD").value = numberOfRoom;
        document.getElementById("DateOfSettlementUPD").value = dataOfSettlement;
        document.getElementById("DateOfEvictionUPD").value = dataOfEviction;
        document.getElementById("BookingDateUPD").value = bookingDate;

    };

    this.updateRoom = function update() {
        var id = document.getElementById("IdRoomUPD").innerText;
        var numberOfRoom = document.getElementById("NumberOfRoomUPD").value;

        var dateOfSettlement = document.getElementById("DateOfSettlementUPD").value;
        var dataOfEviction = document.getElementById("DateOfEvictionUPD").value;
        var bookingDate = document.getElementById("BookingDateUPD").value;

        var indexNumberOfHotel = document.getElementById("NumberOfHotelUPD").selectedIndex;
        var building_id = document.getElementById("NumberOfHotelUPD").options[indexNumberOfHotel].value;

        var indexNameOfCustomer = document.getElementById("NameOfCustomerUPD").selectedIndex;
        var customer_id = document.getElementById("NameOfCustomerUPD").options[indexNameOfCustomer].value;


        var req = {
            method: 'POST',
            url: '/room/update?id='+id,
            data: {
                numberOfRoom: numberOfRoom,
                dataOfSettlement: dateOfSettlement,
                dataOfEviction: dataOfEviction,
                bookingDate: bookingDate,
                building_id: building_id,
                customer_id: customer_id
            }
        };
        //var time = performance.now();
        $http(req).then(function (resp) {
            /*time = performance.now() - time;
            console.log('Оновлення = ', time);
            alert("--------");*/
            window.location.reload();
        })
    };

    this.delFromRoom = function del(id) {
        //var time = performance.now();
        $http.get('/room/del?id=' + id).then(function () {
           /* time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");*/
            window.location.reload();
        });
    };
});

