package com.eep.suasaudego.entities.dtos;

import com.eep.suasaudego.entities.Medico;

public class MedicoDTO {

    private Integer id;
    private String nome;
    private String crm;
    private String dataNascimento;

    public MedicoDTO(){

    }

    public MedicoDTO(Integer id, String nome, String crm, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.dataNascimento = dataNascimento;
    }

    public MedicoDTO(Medico medico){
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.crm = medico.getCrm();
        this.dataNascimento = medico.getDataNascimento();

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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dt_nascimento) {
        this.dataNascimento = dt_nascimento;
    }
}
