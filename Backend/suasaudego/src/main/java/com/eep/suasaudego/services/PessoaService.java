package com.eep.suasaudego.services;

import com.eep.suasaudego.entities.Endereco;
import com.eep.suasaudego.entities.Pessoa;
import com.eep.suasaudego.entities.dtos.PessoaDTO;
import com.eep.suasaudego.repositories.EnderecoRepository;
import com.eep.suasaudego.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Pessoa> findAll() {
        List<Pessoa> list = pessoaRepository.findAll();
        return list;
    }

    public Pessoa create(PessoaDTO pessoaDTO) {
        pessoaDTO.setId(null);
        pessoaDTO.getEndereco().setId(null);
        Pessoa pessoa = new Pessoa(pessoaDTO);
        pessoa = pessoaRepository.save(pessoa);
        enderecoRepository.save(pessoa.getEndereco());
        return pessoa;
    }

    public Pessoa update(Integer id, PessoaDTO pessoaDTO) {
        pessoaDTO.setId(id);
        Pessoa pessoaOld = findByID(id);
        pessoaDTO.getEndereco().setId(pessoaOld.getEndereco().getId());
        pessoaOld = new Pessoa(pessoaDTO);
        pessoaRepository.save(pessoaOld);
        enderecoRepository.save(pessoaOld.getEndereco());
        return pessoaOld;
    }


    public Pessoa findByID(Integer id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.orElseThrow();
    }

    public Pessoa findByCpf(String cpf){
        Pessoa obj = pessoaRepository.findByCpf(cpf);
        return obj;
    }
}
