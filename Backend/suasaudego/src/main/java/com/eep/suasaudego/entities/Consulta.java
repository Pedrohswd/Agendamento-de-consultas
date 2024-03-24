package com.eep.suasaudego.entities;

import com.eep.suasaudego.entities.dtos.ConsultaDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String date;

    private String especialidade;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @JsonIgnore
    @OneToMany(mappedBy = "consulta")
    private Set<Agendamento> agendamentos = new HashSet<>();

    public Consulta() {
    }

    public Consulta(Integer id, Unidade unidade, String date, String especialidade, String observacao, Medico medico) {
        this.id = id;
        this.unidade = unidade;
        this.date = date;
        this.especialidade = especialidade;
        this.observacao = observacao;
        this.medico = medico;
    }

    public Consulta(ConsultaDTO consulta){
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

    public void setMedico(Medico medico) {
        this.medico = medico;
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

    public Set<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Agendamento agendamento) {
        this.agendamentos.add(agendamento);
    }
}
