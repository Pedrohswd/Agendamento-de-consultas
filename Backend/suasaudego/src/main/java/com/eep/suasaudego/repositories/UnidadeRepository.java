package com.eep.suasaudego.repositories;

import com.eep.suasaudego.entities.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

    Optional<Unidade> findByCNES(String CNES);
}
