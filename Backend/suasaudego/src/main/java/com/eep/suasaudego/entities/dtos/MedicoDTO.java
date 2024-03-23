package com.eep.suasaudego.entities.dtos;

import com.eep.suasaudego.entities.Medico;

public class MedicoDTO {

    private Integer id;
    private String nome;
    private String crm;
    private String dt_nascimento;

    public MedicoDTO(){

    }

    public MedicoDTO(Integer id, String nome, String crm, String dt_nascimento) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.dt_nascimento = dt_nascimento;
    }

    public MedicoDTO(Medico medico){
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

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }
}
