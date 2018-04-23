var App = angular.module('App', []);

App.controller('Organization', function ($http, $scope) {
    $http.get('/organization/get').then(function (response) {
        $scope.organization = response.data;

    });


    this.startInsertOrganization = function startUpdate() {
        $http.get('/typeOfOrganization/get').then(function (response) {
            var type = response.data;
            var selector = document.getElementById("OrganizationCharacteristic");
            $(selector).empty();
            for (var i = 0; i < type.length; i++) {
                var option = document.createElement("option");
                option.text = type[i].organizationCharacteristic;
                option.value = type[i].idTypeOfOrganization;
                selector.add(option);

            }
        });

    };

    this.insertToOrganization = function add() {
        var name = document.getElementById("NameOfOrganization").value;
        var indexCharacteristic = document.getElementById("OrganizationCharacteristic").selectedIndex;
        var characteristic = document.getElementById("OrganizationCharacteristic").options[indexCharacteristic].value;



        var req = {
            method: 'POST',
            url: '/organization/insert',
            data: {
                nameOfOrganization: name,
                typeOfOrganization_id: characteristic
            }
        };
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.startUpdateOrganization = function startUpdate(idOrganization, nameOfOrganization, typeOfOrganization) {
        $http.get('/typeOfOrganization/get').then(function (response) {
            var type = response.data;
            var selector = document.getElementById("OrganizationCharacteristicUPD");
            $(selector).empty();
            for (var i = 0; i < type.length; i++) {
                var option = document.createElement("option");
                if(type[i].idTypeOfOrganization==typeOfOrganization)
                    option.selected = 'selected';
                option.text = type[i].organizationCharacteristic;
                option.value = type[i].idTypeOfOrganization;
                selector.add(option);

            }
        });
        document.getElementById("IdOrganizationUPD").innerText = idOrganization;
        document.getElementById("NameOfOrganizationUPD").value = nameOfOrganization;


    };

    this.updateOrganization = function update() {
        var id = document.getElementById("IdOrganizationUPD").innerText;
        var name = document.getElementById("NameOfOrganizationUPD").value;
        var indexCharacteristic = document.getElementById("OrganizationCharacteristicUPD").selectedIndex;
        var characteristic = document.getElementById("OrganizationCharacteristicUPD").options[indexCharacteristic].value;


        var req = {
            method: 'POST',
            url: '/organization/update?id=' + id,
            data: {
                nameOfOrganization: name,
                typeOfOrganization_id: characteristic

            }
        };
        $http(req).then(function (resp) {
            window.location.reload();
        })
    };

    this.delFromOrganization = function del(id) {
        $http.get('/organization/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

