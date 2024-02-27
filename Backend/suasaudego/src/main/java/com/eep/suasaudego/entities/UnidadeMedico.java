package com.eep.suasaudego.entities;

import jakarta.persistence.*;


@Entity
public class UnidadeMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    private boolean status;

    public UnidadeMedico() {

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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean isAtivo() {
        return status;
    }

    public void setAtivo(boolean status) {
        this.status = status;
    }
}
