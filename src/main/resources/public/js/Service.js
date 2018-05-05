var App = angular.module('App',[]);

App.controller('Service',function ($http,$scope) {
    var time = performance.now();
    $http.get('/service/get').then(function (response){
        time = performance.now() - time;
        console.log('Час виконанння = ', time);
        alert("-----");
        $scope.service=response.data;
        console.log(response);
    });
    this.insertToService = function add() {
        var name = document.getElementById("NameOfService").value;
        var cost = document.getElementById("CostOfService").value;


        var req = {
            method: 'POST',
            url: '/service/insert',
            data: {
                nameOfService: name,
                costOfService: cost
            }
        };
        console.log(req);
        var time = performance.now();
        $http(req).then(function (resp) {
            console.log(resp);
            time = performance.now() - time;
            console.log('Додавання новго запису = ', time);
            alert("-----");
            window.location.reload();
        })
    };

    this.startUpdateService = function startUpdate(idService,nameOfService,costOfService) {
        document.getElementById("ServiceIdUPD").value = idService;
        document.getElementById("NameOfServiceUPD").value = nameOfService;
        document.getElementById("CostOfServiceUPD").value = costOfService;

    };

    this.updateService = function update() {
        var id = document.getElementById("ServiceIdUPD").value;
        var name = document.getElementById("NameOfServiceUPD").value;
        var cost = document.getElementById("CostOfServiceUPD").value;

        var req = {
            method: 'POST',
            url: '/service/update?id=' + id,
            data: {
                nameOfService: name,
                costOfService: cost

            }
        };
        console.log(req);
        var time = performance.now();
        $http(req).then(function (resp) {
            console.log(resp);
            time = performance.now() - time;
            console.log('Оновлення = ', time);
            alert("--------");
            window.location.reload();
        })
    };

    this.delFromService = function del(id) {
        var time = performance.now();
        $http.get('/service/del?id=' + id).then(function () {
            time = performance.now() - time;
            console.log('Видалення = ', time);
            alert("--------");
            window.location.reload();
        });
    };
});

