package com.eep.suasaudego.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @OneToMany(mappedBy = "agendamento")
    private Set<Agendamento> agendamentos = new HashSet<>();

    public Consulta() {
    }

    public Consulta(Long id, Unidade unidade, Date date, Medico medico) {
        this.id = id;
        this.unidade = unidade;
        this.date = date;
        this.medico = medico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Set<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(Agendamento agendamento) {
        this.agendamentos.add(agendamento);
    }
}
