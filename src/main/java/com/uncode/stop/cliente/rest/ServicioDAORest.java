package com.uncode.stop.cliente.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.uncode.stop.cliente.dtos.ServicioDTO;
import com.uncode.stop.cliente.entities.ResponseWrapper;

@Service
public class ServicioDAORest {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String baseUri = "http://localhost:9000/servicio";
	
	public void crear(ServicioDTO servicio) {
		
		String uri = baseUri + "/crear";
		restTemplate.postForEntity(uri, servicio, ServicioDTO.class);
	
	}
	
	public void modificar(ServicioDTO servicio){
		
		 String uri = baseUri + servicio.getId();
		 restTemplate.put(uri, servicio);
	
	}
		
	public void eliminar(UUID id){
			
		String uri = baseUri + id;
		restTemplate.delete(uri);
	}
		
	public ServicioDTO buscar(UUID id) {
			
		String uri = baseUri + id;
		
		ResponseEntity<ServicioDTO> response = restTemplate.getForEntity(uri,ServicioDTO.class);
		ServicioDTO servicio = response.getBody();
		
		return  servicio;
	}
	
	public List<ServicioDTO> listar(){
	    String uri = baseUri;
	    
	    // Deserializa la respuesta en el formato esperado (ResponseWrapper<PaisDTO>)
	    ResponseEntity<ResponseWrapper<ServicioDTO>> response = restTemplate.exchange(
	        uri,
	        HttpMethod.GET,
	        null,
	        new ParameterizedTypeReference<ResponseWrapper<ServicioDTO>>() {}
	    );
	    
	    // Obtén la lista de países desde el "content" del ResponseWrapper
	    List<ServicioDTO> listaServicios = response.getBody().getContent();
	    return listaServicios;
	}
}
