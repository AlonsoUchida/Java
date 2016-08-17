package com.valmar.ecommerce.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/static")
public class ReporteController {
	
	 @RequestMapping(value="/reporte", method = RequestMethod.GET)
     public String getReporteManagement() {
         return "Reporte";
     }

}
