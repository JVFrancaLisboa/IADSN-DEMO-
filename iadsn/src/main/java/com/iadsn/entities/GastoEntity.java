package com.iadsn.entities;

import com.iadsn.domain.MovimentacaoFinanceira;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Entidade que representa um gasto no sistema.
 * Esta classe mapeia a tabela "gastos" no banco de dados e implementa a interface MovimentacaoFinanceira.
 * Utiliza Lombok para geração automática de getters, setters, equals, hashCode e toString.
 */
@Data
@Entity
@Table(name = "gastos")
public class GastoEntity implements MovimentacaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração automática de IDs pelo banco
    private Long id;

    @NotBlank(message = "Justifique o gasto") // Garante que a descrição não seja vazia ou apenas espaços em branco
    private String descricao;

    private BigDecimal valor; // Representa o valor do gasto, deve ser positivo ou zero

    //@NotBlank(message = "Por favor preencha o campo 'Data'") // Comentado porque LocalDate não suporta @NotBlank
    private LocalDate data; // Representa a data do gasto

    @Transient // Indica que esse campo não será armazenado no banco de dados
    private MultipartFile file; // Usado para upload de arquivos temporários, geralmente tratado em DTOs

    @Lob // Define que o campo pode armazenar grandes quantidades de dados binários
    @Column(name = "nota_fiscal", columnDefinition = "LONGBLOB") // Armazena a nota fiscal como um blob no banco
    private byte[] notaFiscal;

    /**
     * Retorna o nome da movimentação financeira com um prefixo "SAÍDA".
     * Isso pode ser útil para distinguir tipos de movimentação, mas uma enumeração poderia ser uma abordagem mais escalável.
     */
    @Override
    public String getNome() {
        return "SAÍDA: " + descricao;
    }

    /**
     * Retorna o valor da movimentação financeira.
     */
    @Override
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * Retorna a data da movimentação financeira.
     */
    @Override
    public LocalDate getData(){
        return data;
    }
}