package com.eep.suasaudego.controllers;

import com.eep.suasaudego.entities.Pessoa;
import com.eep.suasaudego.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>>findAll(){

        return null;
    }


}
