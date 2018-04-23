var App = angular.module('App',[]);

App.controller('TypeOfOrganization',function ($http,$scope) {
    $http.get('/typeOfOrganization/get').then(function (response){
        $scope.typeOfOrganization=response.data;
        console.log(response);
    });
    this.insertToTypeOfOrganization = function add() {
        var characteristic = document.getElementById("OrganizationCharacteristic").value;


        var req = {
            method: 'POST',
            url: '/typeOfOrganization/insert',
            data: {
                organizationCharacteristic: characteristic

            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.startUpdateTypeOfOrganization = function startUpdate(idTypeOfOrganization,organizationCharacteristic) {
        document.getElementById("TypeOfOrganizationIdUPD").value = idTypeOfOrganization;
        document.getElementById("OrganizationCharacteristicUPD").value = organizationCharacteristic;

    };

    this.updateTypeOfOrganization = function update() {
        var id = document.getElementById("TypeOfOrganizationIdUPD").value;
        var characteristic = document.getElementById("OrganizationCharacteristicUPD").value;

        var req = {
            method: 'POST',
            url: '/typeOfOrganization/update?id=' + id,
            data: {
                organizationCharacteristic: characteristic
            }
        };
        console.log(req);
        $http(req).then(function (resp) {
            console.log(resp);
            window.location.reload();
        })
    };

    this.delFromTypeOfOrganization = function del(id) {
        $http.get('/typeOfOrganization/del?id=' + id).then(function () {
            window.location.reload();
        });
    };
});

