package com.eep.suasaudego.services;


import com.eep.suasaudego.entities.Unidade;
import com.eep.suasaudego.entities.dtos.UnidadeDTO;
import com.eep.suasaudego.repositories.EnderecoRepository;
import com.eep.suasaudego.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {
    @Autowired
    private UnidadeRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Unidade> findAll(){
        List<Unidade> list = repository.findAll();
        return list;
    }

    public Unidade create(UnidadeDTO unidadeDTO) {
        unidadeDTO.setId(null);
        unidadeDTO.getEndereco().setId(null);
        Unidade unidade = new Unidade(unidadeDTO);
        unidade = repository.save(unidade);
        enderecoRepository.save(unidade.getEndereco());
        return unidade;
    }

    public Unidade update(Integer id, UnidadeDTO unidadeDTO) {
        unidadeDTO.setId(id);
        Unidade unidadeOld = findByID(id);
        unidadeDTO.getEndereco().setId(unidadeOld.getEndereco().getId());
        unidadeOld = new Unidade(unidadeDTO);
        repository.save(unidadeOld);
        enderecoRepository.save(unidadeOld.getEndereco());
        return unidadeOld;
    }


    public Unidade findByID(Integer id) {
        Optional<Unidade> obj = repository.findById(id);
        return obj.orElseThrow();
    }
}
