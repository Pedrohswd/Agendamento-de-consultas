package com.eep.suasaudego.entities.dtos;

import com.eep.suasaudego.entities.Medico;

public class MedicoDTO {

    private Integer id;
    private String nome;
    private String crm;

    public MedicoDTO(){

    }

    public MedicoDTO(Integer id, String nome, String crm) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
    }

    public MedicoDTO(Medico medico){
        this.id = medico.getId();
        this.nome = medico.getNome();
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

}
