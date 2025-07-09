package com.iadsn.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface MovimentacaoFinanceira {
    LocalDate getData();
    String getNome();
    BigDecimal getValor();
}
