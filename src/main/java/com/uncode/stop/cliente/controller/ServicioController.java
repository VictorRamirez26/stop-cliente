package com.uncode.stop.cliente.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uncode.stop.cliente.dtos.ServicioDTO;
import com.uncode.stop.cliente.services.ServicioService;

@Controller
@RequestMapping("/servicio")
public class ServicioController {
	
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping("/listarServicios")
	public String iniciarServicios(ModelMap model) {
		List<ServicioDTO> servicios = servicioService.listar();
		model.put("servicios", servicios);
		return "/servicio/servicio.html";
	}
	
	@GetMapping("/editar-servicio")
	public String editServicio(@RequestParam(value = "id", required = false) UUID id ,
			@RequestParam(value = "accion") String accion , ModelMap model) {
		
		ServicioDTO servicio = null;
		if (id == null) {
			servicio = new ServicioDTO();
		}else {
			servicio = servicioService.buscar(id);
		}
		model.put("servicio", servicio);
		model.put("accion", accion);
		return "/servicio/editServicio.html";
	}
	
    @PostMapping("/actualizar-servicio")
    public String actualizarServicio(@RequestParam(value = "id", required = false) UUID id,
    		@RequestParam("nombre") String nombre,
    		@RequestParam(value = "accion" , defaultValue = "Crear") String accion, 
    		ModelMap model) {
    	
    	
		if (id == null) {
			servicioService.crear(id, nombre);
		} else {
			servicioService.modificar(id, nombre);
		}

        
        return "redirect:/servicio/listarServicios";
    }

    @PostMapping("/eliminar-servicio")
    public String eliminarServicio(@RequestParam("id") UUID id) {
    	servicioService.eliminar(id);
        return "redirect:/servicio/listarServicios";
    }
}
