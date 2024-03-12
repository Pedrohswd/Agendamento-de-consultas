package com.eep.suasaudego.services;

import com.eep.suasaudego.entities.Medico;
import com.eep.suasaudego.entities.dtos.MedicoDTO;
import com.eep.suasaudego.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repository;

    public Medico findByID(Integer id) {
        Optional<Medico> obj = repository.findById(id);
        return obj.orElseThrow();
    }

    public List<Medico> findAll() {
        List<Medico> list = repository.findAll();
        return list;
    }

    public Medico create(MedicoDTO medicoDTO) {
        medicoDTO.setId(null);
        Medico medico = new Medico(medicoDTO);
        medico = repository.save(medico);
        return medico;
    }

    public Medico update(Integer id, MedicoDTO medicoDTO) {
        medicoDTO.setId(id);
        Medico medicoOld = findByID(id);
        medicoOld = new Medico(medicoDTO);
        return repository.save(medicoOld);
    }
}
