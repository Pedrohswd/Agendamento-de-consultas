package com.eep.suasaudego.controllers;

import com.eep.suasaudego.entities.Unidade;
import com.eep.suasaudego.entities.dtos.UnidadeDTO;
import com.eep.suasaudego.services.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/unidade")
@CrossOrigin(origins = "http://localhost:4200")
public class UnidadeController {
    @Autowired
    private UnidadeService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UnidadeDTO> findById(@PathVariable Integer id) {
        Unidade obj = service.findByID(id);
        return ResponseEntity.ok().body(new UnidadeDTO(obj));
    }

    @GetMapping(value = "/cnes/{cnes}")
    public ResponseEntity<UnidadeDTO> findById(@PathVariable String cnes) {
        Unidade obj = service.findByCNES(cnes);
        return ResponseEntity.ok().body(new UnidadeDTO(obj));
    }

    @GetMapping
    public ResponseEntity<List<UnidadeDTO>> findAll() {
        List<Unidade> list = service.findAll();
        List<UnidadeDTO> listDTO = list.stream().map(obj -> new UnidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<UnidadeDTO> create(@RequestBody UnidadeDTO unidadeDTO){
        Unidade newUnidade = service.create(unidadeDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newUnidade.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UnidadeDTO> update(@PathVariable Integer id, @RequestBody UnidadeDTO unidadeDTO){
        Unidade updateUnidade = service.update(id,unidadeDTO);
        return ResponseEntity.ok().body(new UnidadeDTO(updateUnidade));
    }

}
