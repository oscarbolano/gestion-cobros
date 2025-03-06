package com.cobros.controller;

import java.util.List;

import com.cobros.business.DocumentoCobroBusiness;
import com.cobros.entity.DocumentoCobroEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/documentos")
public class DocumentoCobroController {
    
    private DocumentoCobroBusiness business;

    public DocumentoCobroController(DocumentoCobroBusiness business) {
        this.business = business;
    }

    @GetMapping("/pendientes-vencidos")
    public List<DocumentoCobroEntity> obtenerPendientesOVencidos() {
        return business.obtenerPendientesOVencidos();
    }

    @PutMapping("/{id}/ceder")
    public DocumentoCobroEntity actualizarEstadoACedido(@PathVariable Long id) {
        return business.actualizarEstadoACedido(id);
    }

}
