package com.valmar.ecommerce.viewcontroller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

	@RequestMapping(value="/index", params = {"tkn", "idUsuario"}, method = RequestMethod.GET)
	public String getIndex(@RequestParam String tkn, @RequestParam Integer idUsuario, Locale locale, Model model) {

		model.addAttribute("tkn", tkn);
		model.addAttribute("idUsuario", idUsuario);
		return "Index";
	}

}
