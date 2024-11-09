package com.uncode.stop.cliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uncode.stop.cliente.dtos.PersonaDTO;
import com.uncode.stop.cliente.enums.TipoContacto;
import com.uncode.stop.cliente.enums.TipoEmpleado;
import com.uncode.stop.cliente.enums.TipoTelefono;
import com.uncode.stop.cliente.rest.PersonaDAORest;

@Service
public class PersonaService {

	@Autowired
	private PersonaDAORest dao;
	
	public void crear(String nombre, String apellido, String legajo, TipoEmpleado tipoEmpleado,
			TipoContacto tipoContacto, String observacion, String telefono, TipoTelefono tipoTelefono, String email) {
		
		PersonaDTO persona = PersonaDTO.builder().nombre(nombre).apellido(apellido).legajo(legajo).tipoContacto(tipoContacto)
				.tipoEmpleado(tipoEmpleado).observacion(observacion).telefono(telefono).tipoTelefono(tipoTelefono).email(email).build();
		
		dao.crear(persona);
	}
}
