package com.uncode.stop.cliente.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uncode.stop.cliente.dtos.ServicioDTO;
import com.uncode.stop.cliente.rest.ServicioDAORest;

@Service
public class ServicioService {
	
	@Autowired
	private ServicioDAORest dao;
	
	public void crear(UUID id,String nombre) {
		
		ServicioDTO servicio = ServicioDTO.builder().id(id).nombre(nombre).build();
		dao.crear(servicio);
	}
	
	public void modificar(UUID id,String nombre) {
		
		ServicioDTO servicio = ServicioDTO.builder().id(id).nombre(nombre).build();
		dao.modificar(servicio);
	}

	public ServicioDTO buscar (UUID id){
		ServicioDTO servicio = dao.buscar(id);
		return servicio;
	}

	public void eliminar(UUID id) {
			dao.eliminar(id);
	}

	public List<ServicioDTO> listar() {
			return dao.listar();
	}
}