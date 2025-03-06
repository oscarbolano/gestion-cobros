package com.cobros.entity;

import com.cobros.dto.EstadoDocumento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documento_cobro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DocumentoCobroEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    private String cliente;
    private double monto;
    @Column(name = "fecha_emision")
    private String fechaEmision;
    @Column(name = "fecha_vencimiento")
    private String fechaVencimiento;
    @Enumerated(EnumType.STRING)
    private EstadoDocumento estado;

}
