var App = angular.module('App', []);

App.controller('Customer', function ($http, $scope) {
    var time = performance.now();
    $http.get('/customer/get').then(function (response) {
        time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");
        $scope.customer = response.data;
        console.log(response);
    });


    this.startInsertCustomer = function startUpdate() {
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
        $http.get('/service/get').then(function (response) {
            var service = response.data;
            var selector = document.getElementById("NameOfService");
            $(selector).empty();
            for (var i = 0; i < service.length; i++) {
                var option = document.createElement("option");
                option.text = service[i].nameOfService;
                option.value = service[i].idService;
                selector.add(option);
            }
        });
    };

    this.insertToCustomer = function add() {
        var name = document.getElementById("NameOfCustomer").value;
        var number = document.getElementById("NumberOfRoom").value;

        var bookingDate = document.getElementById("BookingDate").value;
        var dateOfSettlement = document.getElementById("DateOfSettlement").value;
        var dataOfEviction = document.getElementById("DateOfEviction").value;

        var indexNameOfService = document.getElementById("NameOfService").selectedIndex;
        var service_id = document.getElementById("NameOfService").options[indexNameOfService].value;

        var indexNumberOfHotel = document.getElementById("NumberOfHotel").selectedIndex;
        var building_id = document.getElementById("NumberOfHotel").options[indexNumberOfHotel].value;

        var isOrganization = document.getElementById("IsOrganization").checked;
        var indexNameOfOrganization = document.getElementById("NameOfOrganization").selectedIndex;
        var organization_id = document.getElementById("NameOfOrganization").options[indexNameOfOrganization].value;
        var feedback = document.getElementById("Feedback").value;


        var req = {
            method: 'POST',
            url: '/customer/insert',
            data: {
                nameOfCustomer: name ,
                room: number ,
                bookingData: bookingDate,
                dataOfSettlement: dateOfSettlement,
                dataOfEviction: dataOfEviction,
                service_id: service_id,
                building_id: building_id,
                isOrganization: isOrganization,
                organization_id: organization_id,
                feedbackAndSuggestion:feedback
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

    this.startUpdateCustomer = function startUpdate(idCustomer,nameOfCustomer,room,bookingDate,dataOfSettlement,dataOfEviction,service,building,isOrganization,organization,feedbackAndSuggestion) {

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
        $http.get('/service/get').then(function (response) {
            var services = response.data;
            var selector = document.getElementById("NameOfServiceUPD");
            $(selector).empty();
            for (var i = 0; i < services.length; i++) {
                var option = document.createElement("option");
                if (services[i].idService == service){
                    option.selected = 'selected';
                }
                option.text = services[i].nameOfService;
                option.value = services[i].idService;
                selector.add(option);
            }
        });

        document.getElementById("IdCustomerUPD").innerText = idCustomer;
        document.getElementById("NameOfCustomerUPD").value = nameOfCustomer;
        document.getElementById("NumberOfRoomUPD").value = room;
        document.getElementById("BookingDateUPD").value = bookingDate;
        document.getElementById("DateOfSettlementUPD").value = dataOfSettlement;
        document.getElementById("DateOfEvictionUPD").value = dataOfEviction;
        document.getElementById("IsOrganizationUPD").checked = isOrganization;
        document.getElementById("FeedbackUPD").value = feedbackAndSuggestion;

    };

    this.updateCustomer = function update() {
        var id = document.getElementById("IdCustomerUPD").innerText;
        var name = document.getElementById("NameOfCustomerUPD").value;
        var number = document.getElementById("NumberOfRoomUPD").value;

        var bookingDate = document.getElementById("BookingDateUPD").value;
        var dateOfSettlement = document.getElementById("DateOfSettlementUPD").value;
        var dataOfEviction = document.getElementById("DateOfEvictionUPD").value;

        var indexNameOfService = document.getElementById("NameOfServiceUPD").selectedIndex;
        var service_id = document.getElementById("NameOfServiceUPD").options[indexNameOfService].value;

        var indexNumberOfHotel = document.getElementById("NumberOfHotelUPD").selectedIndex;
        var building_id = document.getElementById("NumberOfHotelUPD").options[indexNumberOfHotel].value;

        var isOrganization = document.getElementById("IsOrganizationUPD").checked;
        var indexNameOfOrganization = document.getElementById("NameOfOrganizationUPD").selectedIndex;
        var organization_id = document.getElementById("NameOfOrganizationUPD").options[indexNameOfOrganization].value;
        var feedback = document.getElementById("FeedbackUPD").value;


        var req = {
            method: 'POST',
            url: '/customer/update?id='+id,
            data: {
                nameOfCustomer: name ,
                room: number ,
                bookingDate: bookingDate,
                dataOfSettlement: dateOfSettlement,
                dataOfEviction: dataOfEviction,
                service_id: service_id,
                building_id: building_id,
                isOrganization: isOrganization,
                organization_id: organization_id,
                feedbackAndSuggestion:feedback
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

    this.delFromCustomer = function del(id) {
        var time = performance.now();
        $http.get('/customer/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

