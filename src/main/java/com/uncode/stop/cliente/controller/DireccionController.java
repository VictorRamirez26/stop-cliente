package com.uncode.stop.cliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/direccion")
public class DireccionController {

	@GetMapping("/listarPaises")
	public String iniciarPaises() {
		return "pais.html";
	}
	
	
}
