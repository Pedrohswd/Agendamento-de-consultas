package com.eep.suasaudego.entities;


import com.eep.suasaudego.entities.enums.Perfil;

import jakarta.persistence.*;

@Entity
public class Funcionario extends Pessoa {

    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;


    public Funcionario() {
        super();
        addPerfil(Perfil.PACIENTE);
    }

    public Funcionario(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.PACIENTE);
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
}