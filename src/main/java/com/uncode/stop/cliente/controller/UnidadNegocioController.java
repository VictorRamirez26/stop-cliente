package com.uncode.stop.cliente.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uncode.stop.cliente.dtos.DepartamentoDTO;
import com.uncode.stop.cliente.dtos.LocalidadDTO;
import com.uncode.stop.cliente.dtos.PaisDTO;
import com.uncode.stop.cliente.dtos.ProvinciaDTO;
import com.uncode.stop.cliente.dtos.UnidadNegocioDTO;
import com.uncode.stop.cliente.services.DepartamentoService;
import com.uncode.stop.cliente.services.LocalidadService;
import com.uncode.stop.cliente.services.PaisService;
import com.uncode.stop.cliente.services.ProvinciaService;
import com.uncode.stop.cliente.services.UnidadNegocioService;

@Controller
@RequestMapping("/unidadNegocio")
public class UnidadNegocioController {
	
	@Autowired
	private UnidadNegocioService unidadNegocioService;
	
	@Autowired
	private LocalidadService localidadService;

	@Autowired
	private DepartamentoService departamentoService;
	
	@Autowired
	private ProvinciaService provinciaService;
	
	@Autowired
	private PaisService paisService;
	
	
	@GetMapping("/listarUnidadNegocio")
	public String iniciarUnidades(ModelMap model) {
		List<UnidadNegocioDTO> unidades = unidadNegocioService.listar();
		model.put("unidades", unidades);
		return "/unidadNegocio/unidadNegocio.html";
	}
	
	@GetMapping("/editar-unidad")
	public String editUnidad(@RequestParam(value = "id", required = false) UUID id,
			@RequestParam(value = "accion" , required = false) String accion , 
			ModelMap model) {
		
		UnidadNegocioDTO unidad = null;
		List<PaisDTO> paises = paisService.listar();
		List<ProvinciaDTO> provincias;
		List<DepartamentoDTO> departamentos;
		List<LocalidadDTO> localidades;
		
		if (id == null) {
			unidad = new UnidadNegocioDTO();
			provincias = provinciaService.listar();
			departamentos = departamentoService.listar();
			localidades = localidadService.listar();
			
		}else {
			unidad = unidadNegocioService.buscar(id);
			provincias = provinciaService.listarProvinciasPorPais(unidad.getDireccion().getLocalidad().getDepartamento().
					getProvincia().getPais().getId());
			
			departamentos = departamentoService.listarDepartamentosPorProvincia(unidad.getDireccion().getLocalidad().
					getDepartamento().getProvincia().getId());
			
			localidades = localidadService.listarLocalidadesPorDepartamento(unidad.getDireccion().getLocalidad().getDepartamento().getId());
			
		}
		
		model.put("unidad", unidad);
		model.put("localidades", localidades);
		model.put("paises", paises);
		model.put("provincias", provincias);
		model.put("departamentos", departamentos);
		model.put("accion", accion);
		return "/unidadNegocio/editUnidadNegocio.html";
	}
	
	/*
    @PostMapping("/actualizar-localidad")
    public String actualizarLocalidad(@RequestParam(value = "id" , required = false) UUID id,
    		@RequestParam(value = "nombre") String nombre,
    		@RequestParam(value = "codigoPostal") String codigoPostal,
    		@RequestParam(value = "departamentoId") UUID departamentoId,
    		@RequestParam(value = "accion" , defaultValue = "Crear") String accion, 
    		ModelMap model) {
    	
        if (id == null) {
        	localidadService.crear(id, nombre, codigoPostal, departamentoId);
        } else {
        	localidadService.modificar(id, nombre, codigoPostal, departamentoId);
        }
        return "redirect:/localidad/listarLocalidades";
    }

    @PostMapping("/eliminar-localidad")
    public String eliminarLocalidad(@RequestParam("id") UUID id) {
    	localidadService.eliminar(id);
        return "redirect:/localidad/listarLocalidades";
    }
    */
}
