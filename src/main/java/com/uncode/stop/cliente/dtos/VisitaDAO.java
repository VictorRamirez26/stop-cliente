package com.uncode.stop.cliente.dtos;

import com.uncode.stop.cliente.enums.EstadoMovimiento;
import com.uncode.stop.cliente.enums.TipoMovilidad;
import com.uncode.stop.cliente.enums.TipoMovimiento;
import com.uncode.stop.cliente.enums.TipoVisita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VisitaDAO {

    private UUID id;
    private TipoMovimiento tipoMovimiento;
    private LocalDateTime fechaMovimiento;
    private String observacion;
    private EstadoMovimiento estadoMovimiento;
    private TipoMovilidad tipoMovilidad;
    private String descripcionMovilidad;
    private TipoVisita tipoVisita;
    private VisitanteDTO visitante;


/*    {
        "tipoMovimiento": "SALIDA",
            "fechaMovimiento": "2024-11-10T15:30:00",
            "observacion": "Ingreso de visitante al edificio",
            "estadoMovimiento": "REALIZADO",
            "tipoMovilidad": "AUTOMOVIL",
            "descripcionMovilidad": "Ingreso en camioneta",
            "tipoVisita": "FAMILIAR",
            "visitante": {
        "id": "4ef855a6-a07d-4f5b-82e2-1c92f1239960"
    },
        "inmueble": {
        "id": "4c843579-b97a-4f9b-be16-98287f714bf7"
    }
    }
*/
}
