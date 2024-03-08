package com.eep.suasaudego.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Column(unique = true)
    private String cnpj;
    @Column(unique = true)
    private String gestao;
    @Column(unique = true)
    private String CNES;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;
    @JsonIgnore
    @OneToMany(mappedBy = "unidade")
    private Set<Usuario> usuario = new HashSet<>();
    @JsonIgnore
    @ManyToMany
    private List<Medico> medico = new ArrayList<>();



}
