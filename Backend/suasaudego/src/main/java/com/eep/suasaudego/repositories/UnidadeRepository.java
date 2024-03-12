package com.eep.suasaudego.repositories;

import com.eep.suasaudego.entities.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

    Unidade findByCNES(String CNES);
}
