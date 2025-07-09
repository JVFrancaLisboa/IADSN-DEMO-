package com.iadsn.entities; // Pacote onde a classe está localizada

import com.iadsn.domain.MovimentacaoFinanceira; // Importa a interface que a classe implementa
import jakarta.persistence.*; // Importações para o mapeamento JPA
import jakarta.validation.constraints.NotBlank; // Importação para validação de campos obrigatórios
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero; // Importação para validação de valores numéricos
import lombok.Data; // Lombok para geração automática de métodos como getters, setters, equals e hashCode
import lombok.ToString; // Lombok para personalizar a representação de objetos em forma de string

import java.math.BigDecimal; // Importação para trabalhar com valores monetários de forma precisa
import java.time.LocalDate; // Importação para trabalhar com datas


/**
 * Entidade que representa um dízimo no sistema.
 * Esta classe mapeia a tabela "dizimos" no banco de dados e implementa a interface MovimentacaoFinanceira.
 * Utiliza Lombok para reduzir a necessidade de escrever código repetitivo.
 */
@Data
@Entity
@Table(name = "dizimos") // Define que a entidade será mapeada para a tabela "dizimos" no banco de dados
public class DizimoEntity implements MovimentacaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração automática do ID
    private Long id; // Identificador único do dízimo

    @ToString.Exclude // Exclui o membro de aparecer na representação string do objeto
    @ManyToOne // Relacionamento muitos-para-um com a entidade Membro
    @JoinColumn(name = "membro_id") // 'membro_id' definido como chave secundária no banco de dados
    private MembroEntity membro; // Representa o membro que está efetuando o dízimo

    //@NotNull(message = "Por favor preencha o campo 'Data'")
    private LocalDate data; // Data em que o dízimo foi realizado

    //@NotNull(message = "Por favor preencha o valor")
    @PositiveOrZero(message = "O valor deve ser positivo") // Valida que o valor seja positivo ou zero
    private BigDecimal valor; // Representa o valor do dízimo

    /**
     * Retorna o nome do membro que fez o dízimo. Se o membro for nulo, retorna "Anônimo".
     */
    @Override
    public String getNome() {
        return membro != null ? membro.getNome() : "Anônimo";
    }

    /**
     * Retorna o valor do dízimo.
     */
    @Override
    public BigDecimal getValor() {
        return valor;
    }
}