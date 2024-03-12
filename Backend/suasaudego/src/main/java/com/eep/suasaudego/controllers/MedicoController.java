package com.eep.suasaudego.controllers;

import com.eep.suasaudego.entities.Medico;
import com.eep.suasaudego.entities.dtos.MedicoDTO;
import com.eep.suasaudego.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/pessoa")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> findById(@PathVariable Integer id) {
        Medico obj = service.findByID(id);
        return ResponseEntity.ok().body(new MedicoDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<MedicoDTO>> findAll(){
        List<Medico> list = service.findAll();
        List<MedicoDTO> listDTO = list.stream().map(obj -> new MedicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<MedicoDTO> create(@RequestBody MedicoDTO medicoDTO){
        Medico newMedico = service.create(medicoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newMedico.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicoDTO> update(@PathVariable Integer id, @RequestBody MedicoDTO medicoDTO){
        Medico updateMedico = service.update(id,medicoDTO);
        return ResponseEntity.ok().body(new MedicoDTO(updateMedico));
    }
}
