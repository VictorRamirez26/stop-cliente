package com.uncode.stop.cliente.controller;

import com.uncode.stop.cliente.dtos.VisitaDTO;
import com.uncode.stop.cliente.dtos.VisitanteDTO;
import com.uncode.stop.cliente.enums.EstadoMovimiento;
import com.uncode.stop.cliente.enums.TipoMovilidad;
import com.uncode.stop.cliente.enums.TipoMovimiento;
import com.uncode.stop.cliente.enums.TipoVisita;
import com.uncode.stop.cliente.services.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/visita")
public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @GetMapping("/listarVisitas")
    public String iniciarVisitas(ModelMap model){
        List<VisitaDTO> visitas = visitaService.listar();
        model.put("visitas", visitas);
        return "/visita/visita.html";
    }

    @GetMapping("/editar-visita")
    public String editVisita(@RequestParam(value = "id", required = false) UUID id,
                             @RequestParam(value = "accion") String accion,
                             Model model) {

        VisitaDTO visita = (id == null) ? new VisitaDTO() : visitaService.buscar(id);

        model.addAttribute("visita", visita);
        model.addAttribute("accion", accion);
        model.addAttribute("tiposMovimiento", TipoMovimiento.values());
        model.addAttribute("estadosMovimiento", EstadoMovimiento.values());
        model.addAttribute("tiposMovilidad", TipoMovilidad.values());
        model.addAttribute("tiposVisita", TipoVisita.values());
        //model.addAttribute("inmuebles", inmuebleService.listarTodos());

        return "visita/editVisita";
    }

}
