package com.eep.suasaudego.repositories;

import com.eep.suasaudego.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Medico findByCrm(String crm);
}
