package com.eep.suasaudego.entities.dtos;

import com.eep.suasaudego.entities.Pessoa;
import com.eep.suasaudego.entities.Unidade;
import com.eep.suasaudego.entities.Usuario;
import com.eep.suasaudego.entities.enums.Perfil;


public class UsuarioDTO {

    private Integer id;

    private String email;
    private String senha;

    private Unidade unidade;

    private String cpf;

    private Integer perfil;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String email, String senha, String cnes,String cpf, Integer perfil) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.perfil = perfil;
    }

    public UsuarioDTO(Usuario usuario){
        this.id= usuario.getId();
        this.email = usuario.getEmail();
        this.senha= usuario.getSenha();
        this.perfil = usuario.getPerfis().getCodigo();
        this.cpf = usuario.getPessoa().getCpf();
        this.unidade = usuario.getUnidade();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getPessoa() {
        return cpf;
    }

    public void setPessoa(Pessoa pessoa) {
        this.cpf = pessoa.getCpf();
    }

    public Perfil getPerfil() {
        return Perfil.toEnum(perfil);
    }

    public void addPerfil(Perfil perfil) {
        this.perfil = perfil.getCodigo();
    }

}
