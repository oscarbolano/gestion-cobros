package com.cobros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cobros.dto.EstadoDocumento;
import com.cobros.entity.DocumentoCobroEntity;

@Repository
public interface DocumentoCobroRepository extends JpaRepository<DocumentoCobroEntity, Long> {
    List<DocumentoCobroEntity> findByEstadoIn(List<EstadoDocumento> estados);
}
