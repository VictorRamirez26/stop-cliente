package com.uncode.stop.cliente.dtos;

import com.uncode.stop.cliente.enums.Rol;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {

	private String cuenta;
	private String clave;
	private Rol rol;
}
