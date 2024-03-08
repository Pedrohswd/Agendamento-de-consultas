package com.eep.suasaudego.entities;

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
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String crm;

    @JsonIgnore
    @ManyToMany
    private List<Unidade> unidade = new ArrayList<>();

    public Medico(){

    }

    public Medico(Integer id, String nome, String email, String crm) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.crm = crm;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

}
