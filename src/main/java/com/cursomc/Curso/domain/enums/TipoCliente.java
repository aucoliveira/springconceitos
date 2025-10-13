package com.cursomc.Curso.domain.enums;

import java.util.stream.Stream;

public enum TipoCliente {

    PESSOAFISICA(1, "Pesso Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private int cod;
    private String descricao;

    private TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente findByCod(Integer cod) {
        // 1. Checa por nulo
        if (cod == null) {
            return null;
        }

        for (TipoCliente x : TipoCliente.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }

        throw  new IllegalArgumentException("ID inválido: " + cod);
    }

}
