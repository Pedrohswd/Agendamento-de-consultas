package com.eep.suasaudego.services;

import com.eep.suasaudego.entities.Pessoa;
import com.eep.suasaudego.entities.Usuario;
import com.eep.suasaudego.entities.dtos.UsuarioDTO;
import com.eep.suasaudego.repositories.PessoaRepository;
import com.eep.suasaudego.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaService pessoaService;


    public Usuario create(UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(null);
        Usuario usuario = new Usuario(usuarioDTO);
        Pessoa pessoa = new Pessoa(usuarioDTO.getPessoa());
        usuario.setPessoa(pessoaService.findByCpf(pessoa.getCpf()));
        usuario = repository.save(usuario);
        return usuario;
    }

    public Usuario findByID(Integer id) {
        Optional<Usuario> user = repository.findById(id);
        return user.orElseThrow();
    }

    public Usuario update(Integer id,UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(id);
        Usuario old = findByID(id);
        old = new Usuario(usuarioDTO);
        Pessoa pessoa = new Pessoa(usuarioDTO.getPessoa());
        old.setPessoa(pessoaService.findByCpf(pessoa.getCpf()));
        old = repository.save(old);
        return old;
    }
}
