package com.iadsn.entities; // Pacote onde a classe está localizada

import com.fasterxml.jackson.annotation.JsonFormat; // Importação para formatação de data ao serializar para JSON
import com.fasterxml.jackson.annotation.JsonInclude; // Importação para incluir ou excluir atributos ao serializar para JSON
import com.iadsn.entities.enums.Cargo; // Enum para cargos de membros
import com.iadsn.entities.enums.Sexo; // Enum para sexo dos membros
import com.iadsn.entities.enums.StatusCivil; // Enum para status civil dos membros
import jakarta.persistence.*; // Importações para o mapeamento JPA
import jakarta.validation.constraints.Email; // Importação para validação de e-mail
import jakarta.validation.constraints.NotBlank; // Importação para validação de campos obrigatórios
import jakarta.validation.constraints.NotNull; // Importação para validação de campos não nulos
import lombok.Data; // Lombok para gerar getters, setters, equals, hashCode e toString automaticamente
import lombok.ToString; // Lombok para personalizar a representação de objetos em string
import org.hibernate.validator.constraints.br.CPF; // Validação para o CPF
import org.springframework.web.multipart.MultipartFile; // Para manipular arquivos enviados via formulário (como foto)

import java.util.ArrayList; // Para inicializar a lista de dízimos
import java.util.List; // Para armazenar uma lista de dízimos

/**
 * Entidade que representa um membro da igreja no sistema.
 * A classe mapeia a tabela "membros" no banco de dados e contém informações pessoais e profissionais do membro.
 * Utiliza Lombok para redução de código repetitivo e Jackson para formatação JSON.
 */
@Data
@Entity
@Table(name = "membros") // Define que a entidade será mapeada para a tabela "membros" no banco de dados
public class MembroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estratégia de geração automática do ID
    private Long id; // Identificador único do membro

    @NotBlank(message = "Campo não pode ser nulo") // Valida que o nome não pode ser em branco
    private String nome; // Nome do membro

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Formato de data ao serializar para JSON
    private String nascimento; // Data de nascimento do membro

    @Email(message = "insira um E-Mail válido") // Validação de formato de e-mail
    private String email; // E-mail do membro

    @CPF(message = "Insira um CPF válido") // Validação do CPF
    @NotBlank(message = "Campo não pode ser nulo") // Valida que o CPF não pode ser em branco
    private String cpf; // CPF do membro

    @NotNull(message = "Escolha o 'Sexo'") // Validação para garantir que o sexo seja escolhido
    @Enumerated(EnumType.STRING) // Mapeamento do valor de sexo como string
    private Sexo sexo; // Sexo do membro

    @Column(name = "status_civil") // Define que a coluna no banco será "status_civil"
    @NotNull(message = "Escolha o 'Status Civil'") // Validação para garantir que o status civil seja escolhido
    @Enumerated(EnumType.STRING) // Mapeamento do valor de status civil como string
    private StatusCivil statusCivil; // Status civil do membro (ex: solteiro, casado)

    @Enumerated(EnumType.STRING) // Mapeamento do valor de cargo como string
    private Cargo cargo; // Cargo do membro na igreja

    @NotBlank(message = "Preencha o campo Endereço") // Valida que o endereço não pode ser em branco
    private String endereco; // Endereço do membro

    private String telefone; // Telefone do membro

    private boolean arquivado = false; // Indicador se o membro está arquivado (inativo)

    @Transient // Indica que este campo não será persistido no banco de dados
    private MultipartFile multipartFile; // Arquivo (geralmente foto) que será enviado via formulário

    @Lob // Indica que o campo será mapeado como um grande objeto binário (foto)
    private byte[] foto; // Foto do membro

    @ToString.Exclude // Exclui a lista de dízimos da representação em string do objeto
    @JsonInclude(JsonInclude.Include.NON_NULL) // Inclui a lista de dízimos apenas se ela não for nula
    @OneToMany(mappedBy = "membro", fetch = FetchType.EAGER) // Relacionamento um-para-muitos com a entidade DizimoEntity
    private List<DizimoEntity> dizimos = new ArrayList<>(); // Lista de dízimos associados ao membro
}