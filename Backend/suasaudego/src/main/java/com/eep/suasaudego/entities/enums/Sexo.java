package com.eep.suasaudego.entities.enums;

public enum Sexo {
    MASCULINO(0, "ROLE_MASCULINO"), FEMININO(1, "ROLE_FEMININO"), NAO_INFORMADO(2, "ROLE_NAO_INFORMADO");

    private Integer codigo;
    private String descricao;

    Sexo(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Sexo toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (Sexo x : Sexo.values()) {
            if (cod.equals(x.codigo)) {
                return x;
            }
        }
        throw new IllegalArgumentException("Sexo inválido");
    }
}
