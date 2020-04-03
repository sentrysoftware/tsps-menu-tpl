(function() {
  // Define our AngularJS module
  angular.module("myMenuTspsApp", []);

  // Setup the AngularJS routes
  angular.module("myMenuTspsApp").config([
    "$stateProvider",
    "$urlRouterProvider",
    function($stateProvider, $urlRouterProvider) {
      $stateProvider.state("/my-menu/devices", {
        url: "/my-menu/devices",
        template: "<my-menu-devices-tsps></my-menu-devices-tsps>",
        permissions: "allow_uadmin_ui_login"
      });
    }
  ]);
  /**
   * AngularJS constant: myMenuPermissions
   * By default, myMenuPermissions say we're allowed to access stuff
   * We ask our REST API what we're allowed to do
   **/
  angular
    .module("myMenuTspsApp")
    .constant("myMenuPermissions", { read: true, write: true });
})();
