package com.uncode.stop.cliente.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class VisitanteDTO {

    private UUID id;
    private String nombre;
    private String apellido;
    private String numeroDeDocumento;
}
