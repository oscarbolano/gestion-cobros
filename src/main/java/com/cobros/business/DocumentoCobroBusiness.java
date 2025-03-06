package com.cobros.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cobros.dto.EstadoDocumento;
import com.cobros.entity.DocumentoCobroEntity;
import com.cobros.repository.DocumentoCobroRepository;

@Service
public class DocumentoCobroBusiness {

    private DocumentoCobroRepository repository;

    public DocumentoCobroBusiness(DocumentoCobroRepository repository) {
        this.repository = repository;
    }

    public List<DocumentoCobroEntity> obtenerPendientesOVencidos() {
        return repository.findByEstadoIn(List.of(EstadoDocumento.PENDIENTE, EstadoDocumento.VENCIDO));
    }

    public DocumentoCobroEntity actualizarEstadoACedido(Long id) {
        return repository.findById(id).map(doc -> {
            doc.setEstado(EstadoDocumento.CEDIDO);
            return repository.save(doc);
        }).orElseThrow(() -> new RuntimeException("Documento no encontrado"));
    }
}
