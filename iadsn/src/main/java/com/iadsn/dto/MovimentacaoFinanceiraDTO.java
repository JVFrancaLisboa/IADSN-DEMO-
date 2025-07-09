package com.iadsn.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovimentacaoFinanceiraDTO {
    private String nome;
    private String data;
    private BigDecimal valor;

    public MovimentacaoFinanceiraDTO(String nome, String dataFormatada, BigDecimal valor) {
        this.nome = nome;
        this.data = dataFormatada;
        this.valor = valor;
    }
}
