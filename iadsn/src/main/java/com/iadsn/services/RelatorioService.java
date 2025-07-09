package com.iadsn.services;

import com.iadsn.domain.MovimentacaoFinanceira;
import com.iadsn.dto.MovimentacaoFinanceiraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    @Autowired
    DizimoService dizimoService;
    @Autowired
    OfertaService ofertaService;
    @Autowired
    GastoService gastoService;

    /**
     * Metodo privado que agrega todas as movimentações financeiras (dízimos, ofertas e gastos) em uma lista.
     * Ordena as movimentações por data.
     *
     * @return Lista de movimentações financeiras ordenadas pela data.
     */
    private List<MovimentacaoFinanceira> getMovimentacoes() {
        List<MovimentacaoFinanceira> movimentacoes = new ArrayList<>();
        movimentacoes.addAll(dizimoService.getDizimosList());
        movimentacoes.addAll(ofertaService.getOfertasList());
        movimentacoes.addAll(gastoService.getGastoList());
        movimentacoes.sort(Comparator.comparing(MovimentacaoFinanceira::getData));

        return movimentacoes;
    }

    /**
     * Metodo público que converte a lista de movimentações financeiras para DTOs.
     * A conversão inclui a formatação da data e retorna apenas os dados necessários para exibição.
     *
     * @return Lista de DTOs de movimentações financeiras
     */
    public List<MovimentacaoFinanceiraDTO> getMovimentacoesDTO(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getMovimentacoes().stream()
                .map(mov -> new MovimentacaoFinanceiraDTO(mov.getNome(), mov.getData().format(formatter), mov.getValor()))
                .collect(Collectors.toList());
    }


    /**
     * Metodo privado que calcula o valor total de todas as movimentações financeiras.
     *
     * @return Valor total de todas as movimentações.
     */
    // Método Será depreciado quando o sistema estiver emitindo relatórios mensais.
    // Por hora ele só emite um único relátorio.
    private BigDecimal getValorTotalRalatorio(){
        return getMovimentacoesDTO().stream()
                .map(MovimentacaoFinanceiraDTO::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Metodo público que formata o valor total do relatório como moeda BRL (Real Brasileiro).
     *
     * @return Valor total formatado como moeda brasileira (R$).
     */
    // Formatador de valores para BRL
    public String getValoresEmBrl(){
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = formatador.format(getValorTotalRalatorio());
        return valorFormatado;
    }
}