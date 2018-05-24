var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request14 = [];
    var name_id = 1;
    $http.get('http://localhost:8080/request/request14?name_id='+name_id).then(function (response){
        $scope.request14=response.data;
        console.log(response);
        $http.get('/customer/get').then(function (response){
            var customer = response.data;
            var selector = document.getElementById("Customer");
            $(selector).empty();
            for (var i = 0; i < customer.length; i++) {
                var option = document.createElement("option");
                option.text = customer[i].nameOfCustomer;
                option.value = customer[i].idCustomer;
                selector.add(option);
            }
            selector.selectedIndex=0;
            //selector.selectedIndex=1;
        });
    });

    this.update_request = function add() {
        var index = document.getElementById("Customer").selectedIndex;
        name_id= document.getElementById("Customer").options[index].value;
        $http.get('http://localhost:8080/request/request14?name_id='+name_id).then(function (response){
            $scope.request14=response.data;
            console.log(response);
        });
    };
});