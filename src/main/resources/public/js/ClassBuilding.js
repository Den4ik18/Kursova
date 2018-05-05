var App = angular.module('App', []);

App.controller('ClassBuilding', function ($http, $scope) {
    var time = performance.now();
    $http.get('/class/get').then(function (response) {
        time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");
        $scope.class = response.data;

    });


    this.startInsertClassBuilding = function startUpdate() {
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

    };

    this.insertToClassBuilding = function add() {
        var classH = document.getElementById("ClassHotel").value;
        var indexNumberOfHotel = document.getElementById("NumberOfHotel").selectedIndex;
        var numberOfHotel = document.getElementById("NumberOfHotel").options[indexNumberOfHotel].value;



        var req = {
            method: 'POST',
            url: '/class/insert',
            data: {
                classHotel: classH,
                building_id: numberOfHotel
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

    this.startUpdateClassBuilding = function startUpdate(idClassHotel,classHotel,building) {
        $http.get('/building/get').then(function (response) {
            var buildings = response.data;
            var selector = document.getElementById("NumberOfHotelUPD");
            $(selector).empty();
            for (var i = 0; i < buildings.length; i++) {
                var option = document.createElement("option");
                if(buildings[i].idBuilding==building)
                    option.selected = 'selected';
                option.text = buildings[i].areaOfNumber;
                option.value = buildings[i].idBuilding;
                selector.add(option);

            }
        });
        document.getElementById("IdClassBuildingUPD").innerText = idClassHotel;
        document.getElementById("ClassHotelUPD").value = classHotel;


    };

    this.updateClassBuilding = function update() {
        var id = document.getElementById("IdClassBuildingUPD").innerText;
        var classH = document.getElementById("ClassHotelUPD").value;

        var indexNumberOfHotel = document.getElementById("NumberOfHotelUPD").selectedIndex;
        var numberOfHotel = document.getElementById("NumberOfHotelUPD").options[indexNumberOfHotel].value;


        var req = {
            method: 'POST',
            url: '/class/update?id=' + id,
            data: {
                classHotel: classH,
                building_id: numberOfHotel
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

    this.delFromClassBuilding = function del(id) {
        var time = performance.now();
        $http.get('/class/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

