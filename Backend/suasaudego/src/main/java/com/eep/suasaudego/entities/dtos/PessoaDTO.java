package com.eep.suasaudego.entities.dtos;

import com.eep.suasaudego.entities.Agendamento;
import com.eep.suasaudego.entities.Endereco;
import com.eep.suasaudego.entities.Usuario;
import com.eep.suasaudego.entities.enums.Perfil;
import com.eep.suasaudego.entities.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class PessoaDTO {

    protected Integer id;
    protected String nome;

    protected String cpf;

    protected Set<Integer> perfis = new HashSet<>();
    protected Integer sexo;

    protected Date dataNascimento;
    protected Endereco endereco;
    protected List<Usuario> usuarios;
    protected List<Agendamento> agendamentos = new ArrayList<>();

    public PessoaDTO() {
    }

    public PessoaDTO(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public void addSexo(Sexo sexo) {
        this.sexo = (sexo.getCodigo());
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
