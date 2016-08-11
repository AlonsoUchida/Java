package com.valmar.ecommerce.viewcontroller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/static")
public class UsuarioController {
 
      @RequestMapping(value="/usuario", method = RequestMethod.GET)
        public String getUsuarioManagement() {
            return "Usuario";
        }
      
      @RequestMapping(value = "/home", method = RequestMethod.GET)
  	public String home(Locale locale, Model model) {

  		Date date = new Date();
  		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

  		String formattedDate = dateFormat.format(date);

  		model.addAttribute("serverTime", formattedDate);

  		return "home";
  	}

 
}