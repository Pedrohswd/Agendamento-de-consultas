package com.eep.suasaudego.entities.dtos;

import com.eep.suasaudego.entities.Medico;

public class MedicoDTO {

    private Integer id;
    private String nome;
    private String email;
    private String crm;

    public MedicoDTO(){

    }

    public MedicoDTO(Integer id, String nome, String email, String crm) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.crm = crm;
    }

    public MedicoDTO(Medico medico){
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.email = medico.getEmail();
        this.crm = medico.getCrm();
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
