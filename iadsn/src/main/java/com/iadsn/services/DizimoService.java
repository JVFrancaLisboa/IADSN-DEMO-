package com.iadsn.services;

// Importações necessárias para o funcionamento do serviço
import com.iadsn.entities.DizimoEntity;
import com.iadsn.repository.DizimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DizimoService {
    @Autowired
    DizimoRepository dizimoRepository;

    // Metodo para buscar um dízimo pelo ID. Se não encontrar, retorna null.
    public DizimoEntity getDizimoId(Long id){
        return dizimoRepository.findById(id).orElse(null);
    }

    // metodo para retornar uma lista de todos os dízimos
    public List<DizimoEntity> getDizimosList(){
        return dizimoRepository.findAll();
    }

    // metodo para atualizar um dízimo existente
    public DizimoEntity atualizarDizimo(Long id, DizimoEntity dizimoAtualizado){
        // Procura dizimo pelo 'id'
        if(id == null){
            throw new IllegalArgumentException("O ID não pode ser nulo");
        }

        DizimoEntity dizimo = getDizimoId(id);

        // Atualiza dizimo encontrado com as infomaçoes da entidade do parâmetro
        dizimo.setMembro(dizimoAtualizado.getMembro());
        dizimo.setData(dizimoAtualizado.getData());
        dizimo.setValor(dizimoAtualizado.getValor());

        // retorna
        return dizimoRepository.save(dizimo);
    }

    // metodo para criar um novo dízimo
    public DizimoEntity criarDizimo(DizimoEntity dizimo){
        dizimo.setId(null);
        return dizimoRepository.save(dizimo);
    }

    // metodo para deletar um dízimo pelo ID
    public void deletarDizimo(Long id){
        // Procura dizimo pelo 'id'
        DizimoEntity dizimo = getDizimoId(id);

        // Deleta dízimo encotrado no banco
        dizimoRepository.deleteById(dizimo.getId());
    }
}