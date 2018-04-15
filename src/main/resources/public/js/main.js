var app = angular.module("demo", []);

app.controller("AppCtrl", function($scope, $http){


    $scope.building = [];
    $http.get('/api/building').then(function (response){
        $scope.building=response.data;
        console.log(response);
    });

$scope.class = [];
    $http.get('/api/class').then(function (response){
        $scope.class=response.data;
        console.log(response);
    });



    $scope.organization = [];
    $http.get('/api/organization').then(function (response){
        $scope.organization=response.data;
        console.log(response);
    });

    $scope.type = [];
    $http.get('/api/type').then(function (response){
        $scope.type=response.data;
        console.log(response);
    });

    $scope.service = [];
    $http.get('/api/service').then(function (response){
        $scope.service=response.data;
        console.log(response);
    });
    $scope.room = [];
    $http.get('/api/room').then(function (response){
        $scope.room=response.data;
        console.log(response);
    });
    $scope.customer = [];
    $http.get('/api/customer').then(function (response){
        $scope.customer=response.data;
        console.log(response);
    });

    $scope.reservation = [];
    $http.get('/api/reservation').then(function (response){
        $scope.reservation=response.data;
        console.log(response);
    });
    $scope.reservationOrganization = [];
    $http.get('/api/reservationOrganization').then(function (response){
        $scope.reservationOrganization=response.data;
        console.log(response);
    });
});
/*
var app = angular.module("demo", []);

app.controller("AppCtrl", function ($scope, $http) {

    $scope.chairs = [];
    $http.get('/api/chairs').then(function (response) {
        $scope.chairs = response.data;
        //   console.log(response);
    });
    $scope.students = [];
    $http.get('/api/students').then(function (response) {
        //  $http.get('http://localhost:8080/api/students').then(function (response){
        $scope.students = response.data;
        //  console.log(response);
    });
    // this.delstud = function del(id) {
    //     $http.get('/api/student/del?id='+id).then(function (response){
    //         //  $http.get('http://localhost:8080/api/students').then(function (response){
    //         // $scope.students=response.data;
    //         window.alert('Student ' + response.data.lastName + ' ' + response.data.firstName + ' has been succesfully deleted!');
    //         window.location.reload();9
    //     });
    // }
    //
    // $scope.groups = [];
    // $http.get('/api/groups').then(function (response){
    //     //  $http.get('http://localhost:8080/api/students').then(function (response){
    //     $scope.groups=response.data;
    //     console.log(response);
    // });
    //
    //!*
    this.delchair = function del(id) {
        $http.get('/api/chair/del?id=' + id).then(function (response) {
            window.alert('Chair ' + ' ' + response.data.name + ' ' + response.data.id + ' ' + response.data.abr + ' ' + ' has been succesfully deleted!');
            window.location.reload();
        });
    };


    this.insertchair = function () {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var abr = document.getElementById("abr").value;
        var req = {
            method: 'POST',
            url: '/api/chair/insert',
            data: {
                id: id,
                name: name,
                abr: abr
            }
        };
        console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        })
    };
    $scope.showInsert = true;
    $scope.showUpdate = false;
    $scope.disabledId = false;
    var chair;
    this.hideInsertButton = function (item) {
        document.getElementById("id").value = item.id;
        document.getElementById("name").value = item.name;
        document.getElementById("abr").value = item.abr;
        $scope.disabledId = true;
        chair = item;
        $scope.showInsert = false;
        $scope.showUpdate = true;
    };

    this.cancelUpdate = function () {
        $scope.showInsert = true;
        $scope.showUpdate = false;
        window.location.reload();
    };

    this.updatechair = function () {
        var id = document.getElementById("id").value;
        var name = document.getElementById("name").value;
        var abr = document.getElementById("abr").value;
        var req = {
            method: 'POST',
            url: '/api/chair/update',
            data: {
                id: id,
                name: name,
                abr: abr
            }
        };
        // console.log(req);
        $http(req).then(function (resp) {

            window.location.reload();
        });

    };
    $scope.showInsert = true;
    $scope.showUpdate = false;
    $scope.disabledId = false;


});
*/

