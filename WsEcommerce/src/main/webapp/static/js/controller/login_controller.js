'use strict';
 
App.controller('LoginController', ['$scope', 'LoginService', function($scope, LoginService) {
          var self = this;
          
          self.login = function(){
        	  console.log("login controller");       	  
        	  LoginService.login(self.username, self.password);
          };     
    
      }]);