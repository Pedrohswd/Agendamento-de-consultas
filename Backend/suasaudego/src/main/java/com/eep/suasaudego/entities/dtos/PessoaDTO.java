package com.eep.suasaudego.entities.dtos;

import com.eep.suasaudego.entities.Agendamento;
import com.eep.suasaudego.entities.Endereco;
import com.eep.suasaudego.entities.Pessoa;
import com.eep.suasaudego.entities.Usuario;
import com.eep.suasaudego.entities.enums.Sexo;

import java.util.*;

public class PessoaDTO {

    protected Integer id;
    protected String nome;

    protected String cpf;

    protected Integer sexo;

    protected String dataNascimento;
    protected EnderecoDTO endereco;
    protected List<Usuario> usuarios;
    protected List<Agendamento> agendamentos = new ArrayList<>();

    public PessoaDTO() {
    }

    public PessoaDTO(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.dataNascimento = pessoa.getDataNascimento();
        this.sexo = pessoa.getSexo();
        EnderecoDTO enderecoDTO = new EnderecoDTO(pessoa.getEndereco());
        this.endereco= enderecoDTO;
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

    public void addSexo(Sexo sexo) {
        this.sexo = (sexo.getCodigo());
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
