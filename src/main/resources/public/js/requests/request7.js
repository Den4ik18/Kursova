var app = angular.module("kursova", []);

app.controller("AppCtrl", function ($http, $scope){
    $scope.request7 = [];
    var date1= '2017-01-10';
    var date2= '2017-06-04';
    var organization_id = 2;
    $http.get('/request/request7?organization_id='+organization_id+'&firstDate='+date1+'&secondDate='+
        date2).then(function (response){
        $scope.request7=response.data;
        console.log(response);
        $http.get('/organization/get').then(function (response){
            var organization = response.data;
            var selector = document.getElementById("Organization");
            $(selector).empty();
            for (var i = 0; i < organization.length; i++) {
                var option = document.createElement("option");
                option.text = organization[i].nameOfOrganization;
                option.value = organization[i].idOrganization;
                selector.add(option);
            }
            //selector.selectedIndex=0;
            selector.selectedIndex=1;
        });
       
        document.getElementById("FirstDate").value=date1;
        document.getElementById("SecondDate").value=date2;
    });

    this.update_request = function add() {
        var index = document.getElementById("Organization").selectedIndex;
        organization_id= document.getElementById("Organization").options[index].value;
        date1= document.getElementById("FirstDate").value;
        date2= document.getElementById("SecondDate").value;
        $http.get('/request/request7?organization_id='+organization_id+'&firstDate='+date1+'&secondDate='+date2).then(function (response){
            $scope.request7=response.data;
            console.log(response);
        });
    };
});