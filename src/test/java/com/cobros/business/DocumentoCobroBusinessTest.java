package com.cobros.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cobros.dto.EstadoDocumento;
import com.cobros.entity.DocumentoCobroEntity;
import com.cobros.repository.DocumentoCobroRepository;

@ExtendWith(MockitoExtension.class)
class DocumentoCobroBusinessTest {

    @Mock
    private DocumentoCobroRepository repository;

    @InjectMocks
    private DocumentoCobroBusiness business;

    private DocumentoCobroEntity documentoPendiente;
    private DocumentoCobroEntity documentoVencido;
    private DocumentoCobroEntity documentoCedido;

    @BeforeEach
    void setUp() {
        documentoPendiente = new DocumentoCobroEntity();
        documentoPendiente.setId(1L);
        documentoPendiente.setEstado(EstadoDocumento.PENDIENTE);

        documentoVencido = new DocumentoCobroEntity();
        documentoVencido.setId(2L);
        documentoVencido.setEstado(EstadoDocumento.VENCIDO);

        documentoCedido = new DocumentoCobroEntity();
        documentoCedido.setId(3L);
        documentoCedido.setEstado(EstadoDocumento.CEDIDO);
    }

    @Test
    void testObtenerPendientesOVencidos() {
        // Arrange
        when(repository.findByEstadoIn(Arrays.asList(EstadoDocumento.PENDIENTE, EstadoDocumento.VENCIDO)))
                .thenReturn(Arrays.asList(documentoPendiente, documentoVencido));

        // Act
        List<DocumentoCobroEntity> resultado = business.obtenerPendientesOVencidos();

        // Assert
        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(documentoPendiente));
        assertTrue(resultado.contains(documentoVencido));
        verify(repository, times(1)).findByEstadoIn(Arrays.asList(EstadoDocumento.PENDIENTE, EstadoDocumento.VENCIDO));
    }

    @Test
    void testActualizarEstadoACedido_DocumentoExiste() {
        // Arrange
        when(repository.findById(1L)).thenReturn(Optional.of(documentoPendiente));
        when(repository.save(documentoPendiente)).thenReturn(documentoCedido);

        // Act
        DocumentoCobroEntity resultado = business.actualizarEstadoACedido(1L);

        // Assert
        assertNotNull(resultado);
        assertEquals(EstadoDocumento.CEDIDO, resultado.getEstado());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(documentoPendiente);
    }

    @Test
    void testActualizarEstadoACedido_DocumentoNoExiste() {
        // Arrange
        when(repository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            business.actualizarEstadoACedido(99L);
        });

        assertEquals("Documento no encontrado", exception.getMessage());
        verify(repository, times(1)).findById(99L);
        verify(repository, never()).save(any());
    }

}
