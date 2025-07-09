package com.iadsn.services;

import com.iadsn.entities.OfertaEntity;
import com.iadsn.repository.OfertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfertaService {

    @Autowired
    OfertaRepository ofertaRepository;

    // Metodo para obter uma oferta pelo ID. Retorna 'null' se não encontrar a oferta.
    public OfertaEntity getOfertaId(Long id){
        return ofertaRepository.findById(id).orElse(null);
    }

    // Metodo para obter a lista de todas as ofertas
    public List<OfertaEntity> getOfertasList(){
        return ofertaRepository.findAll();
    }

    // Metodo para criar uma nova oferta
    public OfertaEntity criarOferta(OfertaEntity oferta){
        oferta.setId(null);
        return ofertaRepository.save(oferta);
    }

    // Metodo para deletar uma oferta
    public void deletarOferta(Long id){
        OfertaEntity oferta = getOfertaId(id);
        ofertaRepository.deleteById(oferta.getId());
    }
}
