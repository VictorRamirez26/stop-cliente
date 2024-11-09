package com.uncode.stop.cliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/direccion")
public class DireccionController {

	@GetMapping("/listarPaises")
	public String iniciarPaises() {
		return "/pais/pais.html";
	}
	
	@GetMapping("/editar-pais")
	public String editPais(@RequestParam(value = "accion") String accion , ModelMap model) {
		model.put("accion", accion);
		return "/pais/editPais.html";
	}
	
	
	
}
