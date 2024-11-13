package com.uncode.stop.cliente.controller;

import com.uncode.stop.cliente.dtos.VisitanteDTO;
import com.uncode.stop.cliente.services.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/visitante")
public class VisitanteController {

    @Autowired
    private VisitanteService visitanteService;

    @GetMapping("/listarVisitantes")
    public String iniciarVisitantes(ModelMap model){
        List<VisitanteDTO> visitantes = visitanteService.listar();
        model.put("visitantes", visitantes);
        return "/visitante/visitante.html";
    }

    @GetMapping("/editar-visitante")
    public String editVisitante(@RequestParam(value = "id", required = false) UUID id,
                                @RequestParam(value = "accion") String accion, ModelMap model) {

        model.put("accion", accion);

        VisitanteDTO visitante = null;
        if (id == null) {
            visitante = new VisitanteDTO();
        } else {
            visitante = visitanteService.buscar(id);
        }
        model.put("visitante", visitante);
        return "/visitante/editVisitante.html";
    }


    @PostMapping("/actualizar-visitante")
    public String actualizarVisitante(@RequestParam(value = "id", required = false) UUID id,
                                      @RequestParam("nombre") String nombre, @RequestParam("apellido") String apellido,
                                      @RequestParam("numeroDeDocumento") String numeroDeDocumento, @RequestParam("accion") String accion,
                                      ModelMap model) {

        if(id == null) {
            visitanteService.crear(nombre, apellido, numeroDeDocumento);
        } else {
            visitanteService.modificar(id, nombre, apellido, numeroDeDocumento);
        }
        return "redirect:/visitante/listarVisitantes";

    }

    @PostMapping("/eliminar-visitante")
    public String eliminarVisitante(@RequestParam("id") UUID id) {
        visitanteService.eliminar(id);
        return "redirect:/visitante/listarVisitantes";
    }


}

/*
{
            "id": "b1cbbedf-7771-4b59-8d82-88856f081ae3",
            "tipoMovimiento": "SALIDA",
            "fechaMovimiento": "2024-11-10T15:30:00",
            "observacion": "Ingreso de visitante al edificio",
            "estadoMovimiento": "REALIZADO",
            "tipoMovilidad": "AUTOMOVIL",
            "descripcionMovilidad": "Ingreso en camioneta",
            "tipoVisita": "FAMILIAR",
            "visitante": {
                "id": "da6ef235-e51a-454d-89d2-1124ecc38c0c",
                "nombre": "Victor",
                "apellido": "Ramirez",
                "numeroDeDocumento": "40000000"
            },
            "inmueble": {
                "id": "51adb003-cc08-4827-94d4-7770650b0b77",
                "numeracion": "2",
                "piso": "2",
                "depto": "B",
                "estadoInmueble": "HABITADO",
                "unidadDeNegocio": {
                    "id": "f5e32e10-44b3-4708-b319-c75a4c7cb943",
                    "nombre": "UNCuyo"
                }
            }
        }
 */
