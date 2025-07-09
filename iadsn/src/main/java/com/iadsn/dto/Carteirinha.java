package com.iadsn.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iadsn.dto.enums.TipoCarteirinha;
import com.iadsn.entities.MembroEntity;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public abstract class Carteirinha {
    private MembroEntity membro;
    private int rg;
    private String emissao;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Formato de data ao serializar para JSON
    private String BatismoAguas;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Formato de data ao serializar para JSON
    private String BatismoEspiritoSanto;
    private String nacionalidade;
    private String naturalidade;
    private TipoCarteirinha tipo;

    public Carteirinha() {
        gerarEmissao();
    }

    private void gerarEmissao(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate dataAtual = LocalDate.now();
        String emissaoFormatada = dataAtual.format(dtf);

        this.emissao = emissaoFormatada;
    }

    public String formatarData(String data){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        String[] toData = data.split("-");
        LocalDate nascimentoDate = LocalDate.of(Integer.valueOf(toData[0]),
                Integer.valueOf(toData[1]), Integer.valueOf(toData[2]));
        String formatado = nascimentoDate.format(dtf);

        return formatado;
    }
}
