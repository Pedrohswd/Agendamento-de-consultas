package com.eep.suasaudego.services;

import com.eep.suasaudego.entities.Pessoa;
import com.eep.suasaudego.entities.dtos.PessoaDTO;
import com.eep.suasaudego.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        List<Pessoa> list = pessoaRepository.findAll();
        return list;
    }

    public Pessoa create(PessoaDTO pessoaDTO) {
        pessoaDTO.setId(null);
        Pessoa pessoa = new Pessoa(pessoaDTO);
        return pessoaRepository.save(pessoa);
    }
}
