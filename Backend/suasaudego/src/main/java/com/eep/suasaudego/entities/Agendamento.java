package com.eep.suasaudego.entities;

import jakarta.persistence.*;

import java.util.Date;
@Entity

public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataAgendada;
    @ManyToOne
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id_pessoa")
    private Pessoa pessoaAgendada;
    private String Observações;
    @ManyToOne
    @JoinColumn(name = "consulta_id", referencedColumnName = "id_consulta")
    private Consulta consulta;

    public Agendamento(Long id, Date dataAgendada, Pessoa pessoaAgendada, String observações, Consulta consulta) {
        this.id = id;
        this.dataAgendada = dataAgendada;
        this.pessoaAgendada = pessoaAgendada;
        Observações = observações;
        this.consulta = consulta;
    }

    public Agendamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(Date dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public Pessoa getPessoaAgendada() {
        return pessoaAgendada;
    }

    public void setPessoaAgendada(Pessoa pessoaAgendada) {
        this.pessoaAgendada = pessoaAgendada;
    }

    public String getObservações() {
        return Observações;
    }

    public void setObservações(String observações) {
        Observações = observações;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}
