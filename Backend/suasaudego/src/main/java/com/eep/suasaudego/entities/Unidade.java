package com.eep.suasaudego.entities;


import com.eep.suasaudego.entities.dtos.UnidadeDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true, nullable = true)
    private String cnpj;
    private String gestao;
    @Column(unique = true)
    private String CNES;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    @JsonIgnore
    @OneToMany(mappedBy = "unidade")
    private Set<Usuario> usuario = new HashSet<>();
    @JsonIgnore
    @ManyToMany
    private List<Medico> medico = new ArrayList<>();

    public Unidade() {

    }

    public Unidade(Integer id, String nome, String cnpj, String gestao, String CNES) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.gestao = gestao;
        this.CNES = CNES;
    }

    public Unidade(UnidadeDTO unidade){
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
