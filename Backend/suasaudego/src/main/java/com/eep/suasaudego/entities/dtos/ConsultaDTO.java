package com.eep.suasaudego.entities.dtos;

import com.eep.suasaudego.entities.Agendamento;
import com.eep.suasaudego.entities.Consulta;
import com.eep.suasaudego.entities.Medico;
import com.eep.suasaudego.entities.Unidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ConsultaDTO {

    private Integer id;
    private Unidade unidade;
    private String date;
    private String especialidade;
    private String observacao;
    private Medico medico;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Integer id, Unidade unidade, String date, String especialidade, String observacao,Medico medico) {
        this.id = id;
        this.unidade = unidade;
        this.date = date;
        this.especialidade = especialidade;
        this.observacao = observacao;
        this.medico = medico;
    }

    public ConsultaDTO(Consulta consulta){
        this.id = consulta.getId();
        this.unidade = consulta.getUnidade();
        this.date = consulta.getDate();
        this.especialidade= consulta.getEspecialidade();
        this.observacao = consulta.getObservacao();
        this.medico= consulta.getMedico();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
