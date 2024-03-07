package com.eep.suasaudego.services;

import com.eep.suasaudego.entities.Endereco;
import com.eep.suasaudego.entities.Pessoa;
import com.eep.suasaudego.entities.Usuario;
import com.eep.suasaudego.entities.enums.Perfil;
import com.eep.suasaudego.entities.enums.Sexo;
import com.eep.suasaudego.repositories.EnderecoRepository;
import com.eep.suasaudego.repositories.PessoaRepository;
import com.eep.suasaudego.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DBService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void instanciaDB() {
        Pessoa p1 = new Pessoa(null, "Pedro Henrique", "040.198.751-54", "19/12/2003", 0);
        p1.addSexo(Sexo.MASCULINO);

        Endereco ed1 = new Endereco(null, "Rua timbiras q2 l8", "Nerópolis", "GO", "75460000", "SN", "");
        ed1.setPessoa(p1);
        p1.setEndereco(ed1);


        Usuario u1 = new Usuario(null, "pedrohsfwd@gmail.com", "123");
        u1.setPessoa(p1);
        u1.addPerfil(Perfil.PACIENTE);
        Usuario u2 = new Usuario(null, "pedro.ferreira@gmail.com", "123");
        u2.setPessoa(p1);
        u2.addPerfil(Perfil.ADMIN);


        pessoaRepository.save(p1);

        enderecoRepository.save(ed1);

        usuarioRepository.save(u1);
        usuarioRepository.save(u2);
    }
}
