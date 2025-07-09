package com.iadsn.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class CarteirinhaMinistroDTO extends Carteirinha{

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Formato de data ao serializar para JSON
    private String ordenacao;
    private String sede;
}
