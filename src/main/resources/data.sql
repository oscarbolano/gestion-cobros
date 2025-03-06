CREATE TABLE IF NOT EXISTS documento_cobro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_documento VARCHAR(15) NOT NULL,
    cliente VARCHAR(100) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha_emision DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    estado VARCHAR(20) NOT NULL
);

INSERT INTO documento_cobro (id, numero_documento, cliente, monto, fecha_emision, fecha_vencimiento, estado) 
VALUES (1, 'DOC-001', 'Cliente A', 1000.00, '2024-03-01', '2024-03-10', 'PENDIENTE');

INSERT INTO documento_cobro (id, numero_documento, cliente, monto, fecha_emision, fecha_vencimiento, estado) 
VALUES (2, 'DOC-002', 'Cliente B', 2000.00, '2024-02-15', '2024-02-25', 'VENCIDO');

INSERT INTO documento_cobro (id, numero_documento, cliente, monto, fecha_emision, fecha_vencimiento, estado) 
VALUES (3, 'DOC-003', 'Cliente C', 3000.00, '2024-03-15', '2025-03-30', 'CEDIDO');

INSERT INTO documento_cobro (id, numero_documento, cliente, monto, fecha_emision, fecha_vencimiento, estado) 
VALUES (4, 'DOC-004', 'Cliente D', 4000.00, '2024-04-15', '2025-04-30', 'PENDIENTE');

INSERT INTO documento_cobro (id, numero_documento, cliente, monto, fecha_emision, fecha_vencimiento, estado) 
VALUES (5, 'DOC-005', 'Cliente E', 5000.00, '2024-05-15', '2025-03-01', 'VENCIDO');