package com.uncode.stop.cliente.controller;

import com.uncode.stop.cliente.dtos.VisitanteDTO;
import com.uncode.stop.cliente.services.VisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    public String editVisitante(@RequestParam(value = "accion") String accion, ModelMap model) {
        model.put("accion", accion);



        return "/visitante/editVisitante.html";
    }


}
