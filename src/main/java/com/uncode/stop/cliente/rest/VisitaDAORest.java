package com.uncode.stop.cliente.rest;

import com.uncode.stop.cliente.dtos.VisitaDTO;
import com.uncode.stop.cliente.dtos.VisitanteDTO;
import com.uncode.stop.cliente.entities.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class VisitaDAORest {

    @Autowired
    private RestTemplate restTemplate;

    private final String baseUri = "http://localhost:9000/visita";

    public void crear(VisitaDTO visita) {
        String uri = baseUri;
        restTemplate.postForEntity(uri, visita, VisitaDTO.class);
    }

    public void modificar(VisitaDTO visita) {
        String uri = baseUri + "/" + visita.getId();
        restTemplate.put(uri, visita);
    }

    public void eliminar(UUID id) {
        String uri = baseUri + "/" + id;
        restTemplate.delete(uri);
    }

    public VisitaDTO buscar(UUID id) {
        String uri = baseUri + "/" + id;
        ResponseEntity<VisitaDTO> response = restTemplate.getForEntity(uri, VisitaDTO.class);
        VisitaDTO visita = response.getBody();
        return visita;
    }

    public List<VisitaDTO> listar() {
        String uri = baseUri;

        ResponseEntity<ResponseWrapper<VisitaDTO>> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<ResponseWrapper<VisitaDTO>>() {}
        );

        List<VisitaDTO> listaVisita = response.getBody().getContent();
        return listaVisita;
    }

}
