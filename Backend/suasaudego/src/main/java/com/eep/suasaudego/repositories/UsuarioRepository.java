package com.eep.suasaudego.repositories;

import com.eep.suasaudego.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);
    @Query(value = "select * from Usuario where perfil = 0 or perfil = 2", nativeQuery = true)
    List<Usuario> findEmployees();
}
