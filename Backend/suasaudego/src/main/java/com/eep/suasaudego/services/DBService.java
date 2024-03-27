package com.eep.suasaudego.services;

import com.eep.suasaudego.entities.*;
import com.eep.suasaudego.entities.enums.Perfil;
import com.eep.suasaudego.entities.enums.Sexo;
import com.eep.suasaudego.repositories.*;
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

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

  
    public void instanciaDB() {
        Pessoa p1 = new Pessoa(null, "Pedro Henrique", "040.198.751-54", "19/12/2003", 0);
        p1.addSexo(Sexo.MASCULINO);

        Endereco ed1 = new Endereco(null, "Rua timbiras q2 l8", "Nerópolis", "GO", "75460000", "SN", "");
        ed1.setPessoa(p1);
        p1.setEndereco(ed1);

        Pessoa p2 = new Pessoa(null, "Emilly", "779.711.540-03", "31/2/2003", 1);
        p2.addSexo(Sexo.FEMININO);
        Endereco ed3 = new Endereco(null, "Rua timbiras q2 l8", "Goiânia", "GO", "75460020", "SN", "");
        ed3.setPessoa(p2);
        p2.setEndereco(ed3);

        Unidade uni1 = new Unidade(null,"São Judas",null,"Pública", "012345");
        Endereco ed2 = new Endereco(null, "Rua botafogo q2 l8", "Nerópolis", "GO", "75463000", "SN", "");
        uni1.setEndereco(ed2);
        ed2.setUnidade(uni1);

        Usuario u1 = new Usuario(null, "pedrohsfwd@gmail.com", "123");
        u1.setPessoa(p1);
        u1.addPerfil(Perfil.PACIENTE);
        Usuario u2 = new Usuario(null, "pedro.ferreira@gmail.com", "123");
        u2.setPessoa(p1);
        u2.addPerfil(Perfil.ADMIN);

        Usuario u3 = new Usuario(null, "emilly.santos@gmail.com", "123");
        u3.setPessoa(p2);
        u3.addPerfil(Perfil.FUNCIONARIO);
        Usuario u4 = new Usuario(null, "emillyduarte@gmail.com", "123");
        u4.setPessoa(p2);
        u4.addPerfil(Perfil.PACIENTE);

        Medico md1 = new Medico(null, "Eduardo","88821","2001-08-03");

        Consulta c1 = new Consulta(null, uni1, "11/04/2024","Cardiologia", "13h", md1);

        medicoRepository.save(md1);
        pessoaRepository.save(p1);
        pessoaRepository.save(p2);

        unidadeRepository.save(uni1);


        enderecoRepository.save(ed1);
        enderecoRepository.save(ed2);
        enderecoRepository.save(ed3);

        usuarioRepository.save(u1);
        usuarioRepository.save(u2);
        usuarioRepository.save(u3);
        usuarioRepository.save(u4);

        consultaRepository.save(c1);
    }
}
