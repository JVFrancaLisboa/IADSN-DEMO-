package com.iadsn.entities; // Pacote onde a classe está localizada

import com.iadsn.domain.MovimentacaoFinanceira; // Importa a interface que a classe implementa
import jakarta.persistence.*; // Importações para o mapeamento JPA
import jakarta.validation.constraints.PositiveOrZero; // Importação para validação de valores numéricos
import lombok.Data; // Lombok para geração automática de métodos como getters, setters, equals e hashCode

import java.math.BigDecimal; // Importação para trabalhar com valores monetários de forma precisa
import java.time.LocalDate; // Importação para trabalhar com datas

/**
 * Entidade que representa uma oferta no sistema.
 * Esta classe mapeia a tabela "ofertas" no banco de dados e implementa a interface MovimentacaoFinanceira.
 * Utiliza Lombok para reduzir a necessidade de escrever código repetitivo.
 */
@Data
@Entity
@Table(name = "ofertas") // Define que a entidade será mapeada para a tabela "ofertas" no banco de dados
public class OfertaEntity implements MovimentacaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração automática do ID
    private Long id; // Identificador único da oferta

    //@NotBlank(message = "Por favor preencha o campo 'Data'")
    private LocalDate data; // Data em que a oferta foi realizada

    @PositiveOrZero(message = "O valor deve ser positivo") // Valida que o valor seja positivo ou zero
    private BigDecimal valor; // Representa o valor monetário da oferta

    /**
     * Retorna o nome da movimentação financeira.
     */
    @Override
    public String getNome() {
        return "OFERTAS";
    }

    /**
     * Retorna o valor da movimentação financeira.
     */
    @Override
    public BigDecimal getValor() {
        return valor;
    }
}