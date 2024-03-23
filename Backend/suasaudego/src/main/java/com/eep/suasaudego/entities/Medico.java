package com.eep.suasaudego.entities;

import com.eep.suasaudego.entities.dtos.MedicoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String dt_nascimento;
    @Column(unique = true)
    private String crm;

    @JsonIgnore
    @ManyToMany
    private List<Unidade> unidade = new ArrayList<>();

    public Medico(){

    }

    public Medico(Integer id, String nome, String crm, String dt_nascimento) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.dt_nascimento = dt_nascimento;
    }

    public Medico(MedicoDTO medico){
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.dt_nascimento = medico.getDt_nascimento();
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getDt_nascimento() {return dt_nascimento;}
    public void setDt_nascimento(String dt_nascimento) { this.dt_nascimento = dt_nascimento; }

}
