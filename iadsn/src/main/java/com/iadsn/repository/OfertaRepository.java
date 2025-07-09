package com.iadsn.repository;

import com.iadsn.entities.OfertaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository referente a entidade 'OfertaEntity'
 */
@Repository
public interface OfertaRepository extends JpaRepository<OfertaEntity, Long> {
}