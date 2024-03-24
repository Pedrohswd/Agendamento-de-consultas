package com.eep.suasaudego.services;

import com.eep.suasaudego.entities.Consulta;
import com.eep.suasaudego.entities.Medico;
import com.eep.suasaudego.entities.dtos.ConsultaDTO;
import com.eep.suasaudego.repositories.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository repository;

    public Consulta findByID(Integer id) {
        Optional<Consulta> obj = repository.findById(id);
        return obj.orElseThrow();
    }

    public List<Consulta> findAll() {
        List<Consulta> list = repository.findAll();
        return list;
    }

    public Consulta create(ConsultaDTO consultaDTO) {
        consultaDTO.setId(null);
        Consulta consulta = new Consulta(consultaDTO);
        consulta = repository.save(consulta);
        return consulta;
    }

    public Consulta update(Integer id, ConsultaDTO consultaDTO) {
        consultaDTO.setId(id);
        Consulta consultaOld = findByID(id);
        consultaOld = new Consulta(consultaDTO);
        return repository.save(consultaOld);
    }
}
