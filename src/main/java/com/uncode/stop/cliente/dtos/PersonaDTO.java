package com.uncode.stop.cliente.dtos;

import com.uncode.stop.cliente.enums.TipoContacto;
import com.uncode.stop.cliente.enums.TipoEmpleado;
import com.uncode.stop.cliente.enums.TipoTelefono;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonaDTO {

    // Persona
    private String nombre;
    private String apellido;
    private UsuarioDTO usuario;
    // Empleado
    private String legajo;
    private TipoEmpleado tipoEmpleado;

    // Contacto
    private TipoContacto tipoContacto;
    private String observacion;

    // ContactoTelefonico
    private String telefono;
    private TipoTelefono tipoTelefono;

    // ContactoCorreoElectronico
    private String email;
}
