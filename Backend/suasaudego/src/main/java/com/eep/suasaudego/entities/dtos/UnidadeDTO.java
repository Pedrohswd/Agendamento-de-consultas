package com.eep.suasaudego.entities.dtos;

import com.eep.suasaudego.entities.Endereco;
import com.eep.suasaudego.entities.Medico;
import com.eep.suasaudego.entities.Unidade;
import com.eep.suasaudego.entities.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnidadeDTO {


    private Integer id;
    private String nome;

    private String cnpj;

    private String gestao;

    private String CNES;

    private Endereco endereco;

    private Set<Usuario> usuario = new HashSet<>();

    private List<Medico> medico = new ArrayList<>();

    public UnidadeDTO() {

    }

    public UnidadeDTO(Integer id, String nome, String cnpj, String gestao, String CNES) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.gestao = gestao;
        this.CNES = CNES;
    }

    public UnidadeDTO(Unidade unidade){
        this.id = unidade.getId();
        this.nome = unidade.getNome();
        this.cnpj = unidade.getCnpj();
        this.gestao = unidade.getGestao();
        this.CNES = unidade.getCNES();
        this.endereco = unidade.getEndereco();
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getGestao() {
        return gestao;
    }

    public void setGestao(String gestao) {
        this.gestao = gestao;
    }

    public String getCNES() {
        return CNES;
    }

    public void setCNES(String CNES) {
        this.CNES = CNES;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}


