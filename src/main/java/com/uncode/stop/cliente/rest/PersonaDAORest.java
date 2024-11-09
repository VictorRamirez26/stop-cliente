package com.uncode.stop.cliente.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uncode.stop.cliente.dtos.PersonaDTO;

@Service
public class PersonaDAORest {

	@Autowired
	private RestTemplate restTemplate;
	
	public void crear(PersonaDTO persona) {
		
		String uri = "http://localhost:9000/empleados";
		restTemplate.postForEntity(uri, persona, PersonaDTO.class);

	}
}
