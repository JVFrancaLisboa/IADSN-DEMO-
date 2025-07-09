package com.iadsn.repository;

import com.iadsn.entities.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository referente a entidade 'MembroEntity'
 */
@Repository
public interface MembroRepository extends JpaRepository<MembroEntity, Long> {

    // Retorno de membros arquivados
    @Query("SELECT m FROM MembroEntity m WHERE m.arquivado = true")
    List<MembroEntity> findMembrosArquivados();

    // Retorno de membros desarquivados
    @Query("SELECT m FROM MembroEntity m WHERE m.arquivado = false")
    List<MembroEntity> findMembrosDesarquivados();
}
