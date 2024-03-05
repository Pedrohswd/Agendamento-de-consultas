package com.eep.suasaudego.controllers;

import com.eep.suasaudego.entities.Pessoa;
import com.eep.suasaudego.entities.dtos.PessoaDTO;
import com.eep.suasaudego.services.PessoaService;
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
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll(){
        List<Pessoa> list = service.findAll();
        List<PessoaDTO> listDTO = list.stream().map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO){
        Pessoa newPessoa = service.create(pessoaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newPessoa.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Integer id, @RequestBody PessoaDTO pessoaDTO){
        Pessoa updatePessoa = service.update(id,pessoaDTO);
        return ResponseEntity.ok().body(new PessoaDTO(updatePessoa));
    }

}
