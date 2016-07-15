package com.valmar.ecommerce.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/static/Login")
public class LoginController {
 
      @RequestMapping(method = RequestMethod.GET)
        public String getLogin() {
            return "Login";
        }
 
}