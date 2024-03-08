package com.eep.suasaudego.controllers;

import com.eep.suasaudego.entities.Pessoa;
import com.eep.suasaudego.entities.Usuario;
import com.eep.suasaudego.entities.dtos.PessoaDTO;
import com.eep.suasaudego.entities.dtos.UsuarioDTO;
import com.eep.suasaudego.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
        Usuario obj = service.findByID(id);
        return ResponseEntity.ok().body(new UsuarioDTO(obj));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO){
        Usuario newUsuario = service.create(usuarioDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(newUsuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDTO){
        Usuario updatedUsuario = service.update(id,usuarioDTO);
        return ResponseEntity.ok().body(new UsuarioDTO(updatedUsuario));
    }
}
