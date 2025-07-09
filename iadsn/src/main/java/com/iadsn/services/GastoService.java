package com.iadsn.services;

// Importações necessárias para o funcionamento do serviço
import com.iadsn.entities.GastoEntity;
import com.iadsn.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class GastoService {

    @Autowired
    GastoRepository gastoRepository;

    // Metodo retorna um gasto pelo 'ID'
    public GastoEntity getGastoId(Long id){
        return gastoRepository.findById(id).orElse(null);
    }

    // Metodo para atualizar gastos
    public GastoEntity atualizarGasto(Long id, GastoEntity gastoAtualizado){
        // Procura o gasto correto de acordo com o id
        GastoEntity gasto = getGastoId(id);

        // Atualiza gasto do banco de acordo com os dados da entidade do parâmetro
        gasto.setDescricao(gastoAtualizado.getDescricao());
        gasto.setValor(gastoAtualizado.getValor());
        gasto.setNotaFiscal(gastoAtualizado.getNotaFiscal());

        // retona
        return gastoRepository.save(gasto);
    }

    // Metodo retorna a lista completa de todos os gastos
    public List<GastoEntity> getGastoList(){
        return gastoRepository.findAll();
    }

    // Metodo para cria um gasto / saída de valores 'movimentações'
    public GastoEntity criarGasto(GastoEntity gasto){
        // Insere 'null' garantindo que não se trata de um gasto existente
        gasto.setId(null);

        // Verifica se o arquivo enviado (como parte do gasto) não é nulo e não está vazio
        if(gasto.getFile() != null && !gasto.getFile().isEmpty()){
            try{
                // Convertendo imagem para byte e inserindo ao atributo final
                gasto.setNotaFiscal(gasto.getFile().getBytes());
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("Não foi possível converter a imagem em bytes.");
            }
        }

        // Transformando o valor em negativo
        if (gasto.getValor() != null) {
            gasto.setValor(gasto.getValor().multiply(BigDecimal.valueOf(-1)));
        }

        return gastoRepository.save(gasto);
    }

    // Deleta um gasto de acordo com o seu 'ID'
    public void deletarGasto(Long id){
        GastoEntity gasto = getGastoId(id);
        gastoRepository.deleteById(gasto.getId());
    }
}
