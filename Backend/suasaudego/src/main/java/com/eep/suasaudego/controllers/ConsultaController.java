package com.eep.suasaudego.controllers;

import com.eep.suasaudego.entities.Consulta;
import com.eep.suasaudego.entities.dtos.ConsultaDTO;
import com.eep.suasaudego.services.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller

@RequestMapping(value = "/consulta")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultaController {
    @Autowired
    private ConsultaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ConsultaDTO> findById(@PathVariable Integer id) {
        Consulta obj = service.findByID(id);
        return ResponseEntity.ok().body(new ConsultaDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaDTO>> findAll() {
        List<Consulta> list = service.findAll();
        List<ConsultaDTO> listDTO = list.stream().map(obj -> new ConsultaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<ConsultaDTO> create(@RequestBody ConsultaDTO consultaDTO) {
        Consulta newConsulta = service.create(consultaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newConsulta.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ConsultaDTO> update(@PathVariable Integer id, @RequestBody ConsultaDTO consultaDTO) {
        Consulta updateConsulta = service.update(id, consultaDTO);
        return ResponseEntity.ok().body(new ConsultaDTO(updateConsulta));
    }
}
