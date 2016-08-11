package com.valmar.ecommerce.viewcontroller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String getLogin(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		return "Login";
	}
	
	/*@RequestMapping(value="static/cerrar", method = RequestMethod.GET)
    public String getCerrar(HttpServletRequest request, ModelMap model) {
		String[] requestURL = request.getRequestURL().toString().split("/static/cerrar");
		String redirectUrl = requestURL[0];
	    return "redirect:" + redirectUrl;
    }*/
	
}

