(function () {
  'use strict';

  angular.module('app').controller('UserController', UserController);

  UserController.$inject = ['$http'];

  function UserController($http) {
    var vm = this;

    vm.users = [];
    init();

    function init() {
      getAll();
    }

    function getAll() {
      var url = "/users/all";
      var users = $http.get(url);
      users.then(function (response) {
        vm.users = response.data;
      });
    }
  }
})();