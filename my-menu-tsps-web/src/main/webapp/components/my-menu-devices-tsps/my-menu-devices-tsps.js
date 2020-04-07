(function() {
  /**
   * <my-menu-devices-tsps> AngularJS component controller
   **/
  function dashboardMyMenuController($http) {
    var $ctrl = this;

    /**
     * $onInit
     **/
    $ctrl.$onInit = () => {
      $ctrl.deviceListPromise = $http.get("/tsws/10.0/api/my-menu/devices");

      $ctrl.deviceListPromise.then(response => {
        $ctrl.devices = response.data;
        $ctrl.deviceListFound = $ctrl.devices && $ctrl.devices.length > 0;
      });
    };
  }

  dashboardMyMenuController.$inject = ["$http"];

  angular.module("myMenuTspsApp").component("myMenuDevicesTsps", {
    controller: dashboardMyMenuController,
    templateUrl:
      "/my-menu-tsps-web/components/my-menu-devices-tsps/my-menu-devices-tsps.html",
    bindings: {}
  });
})();
