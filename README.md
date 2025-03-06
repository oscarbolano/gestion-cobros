# gestion-cobros
Proyecto para gestionar cobros de documentos

# Instrucciones de ejecución
 1. Clonar proyecto "git clone https://github.com/oscarbolano/gestion-cobros.git".
 2. Ejecutar iniciar proyecto "mvn spring-boot:run" o desde su ide.
 3. Abrir la consola de la base de datos "http://localhost:9081/api/cobros/h2-console".
        host: jdbc:h2:mem:gestioncobro
        user: admin
        pass:
 4. Insertar los datos de prueba que estan en /resources/data.sql dentro del del proyecto. 
 5. Probar endpoint "http://localhost:9081/api/cobros/documentos/pendientes-vencidos".
 6. probar endpoint "http://localhost:9081/api/cobros/documentos/{id_documento}/ceder".


Nota: Dentro del proyecto se encuentra el archivo TESTS_RESULTADO.txt con el resultado de las pruebas unitarias.


# Justificación del diseño:
 1. Se usa Spring Boot para facilitar la configuración y desarrollo rápido de APIs REST.
 2. Se usa JPA con H2 para manejar la persistencia de datos sin necesidad de configurar una base de datos externa.
 3. La entidad DocumentoCobro usa @Enumerated(EnumType.STRING) para almacenar estados como cadenas, haciéndolos legibles y evitando problemas con cambios.
 4. Se implementa un patrón de repositorio para desacoplar la lógica de acceso a datos.
 5. Se incluyen pruebas con Mockito y JUnit para garantizar la fiabilidad del código y la lógica de negocio.

 