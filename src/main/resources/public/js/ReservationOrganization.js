var App = angular.module('App', []);

App.controller('ReservationOrganization', function ($http, $scope) {
    //var time = performance.now();
    $http.get('/reservationByOrganization/get').then(function (response) {
        /*time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");*/
        $scope.reservationByOrganization = response.data;
        console.log(response);
    });


    this.startInsertReservationOrganization = function startUpdate() {
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

        $http.get('/organization/get').then(function (response) {
            var organization = response.data;
            var selector = document.getElementById("NameOfOrganization");
            $(selector).empty();
            for (var i = 0; i < organization.length; i++) {
                var option = document.createElement("option");
                option.text = organization[i].nameOfOrganization;
                option.value = organization[i].idOrganization;
                selector.add(option);
            }
        });

        $http.get('/class/get').then(function (response) {
            var classH = response.data;
            var selector = document.getElementById("ClassOfHotel");
            $(selector).empty();
            for (var i = 0; i < classH.length; i++) {
                var option = document.createElement("option");
                option.text = classH[i].classHotel;
                option.value = classH[i].idClassHotel;
                selector.add(option);
            }
        });
    };

    this.insertToReservationOrganization = function add() {
        var floor = document.getElementById("Floor").value;
        var countOfReservationRooms = document.getElementById("СountOfReservationRooms").value;
        var totalCountOfPeople = document.getElementById("TotalCountOfPeople").value;

        var indexClassOfHotel = document.getElementById("ClassOfHotel").selectedIndex;
        var classOfHotel_id = document.getElementById("ClassOfHotel").options[indexClassOfHotel].value;
        var listOfReservationRooms = document.getElementById("ListOfReservationRooms").value;

        var bookingDate = document.getElementById("BookingDate").value;
        var dateOfSettlement = document.getElementById("DateOfSettlement").value;
        var dataOfEviction = document.getElementById("DateOfEviction").value;

        var indexNumberOfHotel = document.getElementById("NumberOfHotel").selectedIndex;
        var numberOfHotel_id = document.getElementById("NumberOfHotel").options[indexNumberOfHotel].value;

        var indexNameOfOrganization = document.getElementById("NameOfOrganization").selectedIndex;
        var nameOfOrganization_id = document.getElementById("NameOfOrganization").options[indexNameOfOrganization].value;


        var req = {
            method: 'POST',
            url: '/reservationByOrganization/insert',
            data: {
                floor:floor,
                countOfReservationRooms:countOfReservationRooms,
                totalCountOfPeople:totalCountOfPeople,
                class_id:classOfHotel_id,
                listOfReservationRooms:listOfReservationRooms,
                bookingDate: bookingDate,
                dataOfSettlement: dateOfSettlement,
                dataOfEviction: dataOfEviction,
                building_id: numberOfHotel_id,
                organization_id:nameOfOrganization_id
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

    this.startUpdateReservationOrganization = function startUpdate(idReservationOrganization,floor,countOfReservationRooms,totalCountOfPeople,classBuilding,listOfReservationRooms,bookingDate,dataOfSettlement,dataOfEviction,building,organization) {

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

        $http.get('/organization/get').then(function (response) {
            var organizations = response.data;
            var selector = document.getElementById("NameOfOrganizationUPD");
            $(selector).empty();
            for (var i = 0; i < organizations.length; i++) {
                var option = document.createElement("option");
                if (organizations[i].idOrganization == organization){
                    option.selected = 'selected';
                }
                option.text = organizations[i].nameOfOrganization;
                option.value = organizations[i].idOrganization;
                selector.add(option);
            }
        });
        $http.get('/class/get').then(function (response) {
            var classHotel = response.data;
            var selector = document.getElementById("ClassOfHotelUPD");
            $(selector).empty();
            for (var i = 0; i < classHotel.length; i++) {
                var option = document.createElement("option");
                if (classHotel[i].idClassHotel == classBuilding){
                    option.selected = 'selected';
                }
                option.text = classHotel[i].classHotel;
                option.value = classHotel[i].idClassHotel;
                selector.add(option);
            }
        });

        document.getElementById("IdReservationOrganizationUPD").innerText = idReservationOrganization;
        document.getElementById("FloorUPD").value = floor;
        document.getElementById("СountOfReservationRoomsUPD").value = countOfReservationRooms;
        document.getElementById("TotalCountOfPeopleUPD").value = totalCountOfPeople;
        document.getElementById("ListOfReservationRoomsUPD").value = listOfReservationRooms ;
        document.getElementById("BookingDateUPD").value = bookingDate;
        document.getElementById("DateOfSettlementUPD").value = dataOfSettlement;
        document.getElementById("DateOfEvictionUPD").value = dataOfEviction;

    };

    this.updateReservationOrganization = function update() {
        var id = document.getElementById("IdReservationOrganizationUPD").innerText;
        var floor = document.getElementById("FloorUPD").value;
        var countOfReservationRooms = document.getElementById("СountOfReservationRoomsUPD").value;
        var totalCountOfPeople = document.getElementById("TotalCountOfPeopleUPD").value;

        var indexClassOfHotel = document.getElementById("ClassOfHotelUPD").selectedIndex;
        var classOfHotel_id = document.getElementById("ClassOfHotelUPD").options[indexClassOfHotel].value;

        var listOfReservationRooms = document.getElementById("ListOfReservationRoomsUPD").value;

        var bookingDate = document.getElementById("BookingDateUPD").value;
        var dateOfSettlement = document.getElementById("DateOfSettlementUPD").value;
        var dataOfEviction = document.getElementById("DateOfEvictionUPD").value;

        var indexNumberOfHotel = document.getElementById("NumberOfHotelUPD").selectedIndex;
        var numberOfHotel_id = document.getElementById("NumberOfHotelUPD").options[indexNumberOfHotel].value;

        var indexNameOfOrganization = document.getElementById("NameOfOrganizationUPD").selectedIndex;
        var nameOfOrganization_id = document.getElementById("NameOfOrganizationUPD").options[indexNameOfOrganization].value;




        var req = {
            method: 'POST',
            url: '/reservationByOrganization/update?id='+id,
            data: {
                floor:floor,
                countOfReservationRooms:countOfReservationRooms,
                totalCountOfPeople:totalCountOfPeople,
                class_id:classOfHotel_id,
                listOfReservationRooms:listOfReservationRooms,
                bookingDate: bookingDate,
                dataOfSettlement: dateOfSettlement,
                dataOfEviction: dataOfEviction,
                building_id: numberOfHotel_id,
                organization_id:nameOfOrganization_id
            }
        };
        //var time = performance.now();
        $http(req).then(function (resp) {
           /* time = performance.now() - time;
            console.log('Оновлення = ', time);
            alert("--------");*/
            window.location.reload();
        })
    };

    this.delFromReservationOrganization = function del(id) {
        //var time = performance.now();
        $http.get('/reservationByOrganization/del?id=' + id).then(function () {
            /*time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");*/
            window.location.reload();
        });
    };
});

