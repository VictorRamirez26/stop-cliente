package com.uncode.stop.cliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/visita")
public class VisitaController {
    @GetMapping("/listarVisitantes")
    public String iniciarVisitantes(){
        return "/visita/visitante.html";
    }

    @GetMapping("/editar-visitante")
    public String editVisitante(@RequestParam(value = "accion") String accion, ModelMap model) {
        model.put("accion", accion);
        return "/visita/editVisitante.html";
    }
}
