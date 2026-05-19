# DeepWallet

> [!NOTE]
Este programa ayuda a organizar ingresos y gastos de una persona agrupandolos en categorías (ej. Comida, Transporte, Suscripciones, etc.) para llevar un mejor registro de tu flujo de dinero, realizando peticiones HTTP a través de Postman para agregar, modificar, listar o eliminar los datos. También, tiene la función de organizar automáticamente tablas dentro de una base de datos MySQL.

**Requisitos:**

- IDE: Visual Studio Code
- Librerías instaladas: Extension Pack for Java
- MySQL (XAMPP / Laragon / HeidiSQL): localhost:3306 + root
- Tener Java instalado (JDK 21+)
- Postman
- Maven

**Autores:**

- Bastian Huenchullan (ba.huenchullan@duocuc.cl)
- Matías Cabezas (mat.cabezasc@duocucuc.cl)
- Daniel Escalante (da.escalante@duocuc.cl)

## ¿Cómo ejecutar el proyecto? (Getstarted)

1. git clone
2. Abrir el proyecto
3. Iniciar algo como XAMPP o Laragon con el puerto 3306 para MySQL (si no funciona cambiarlo al puerto ej. 3307)
4. En caso de cambiar el puerto también cambiarlo en src/main/resources/application.properties (spring.datasource.url=jdbc:mysql://localhost:3307/deepwallet?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC)
5. Hacerle Run Java a DeepwalletApplication.java
6. Abrir HeidiSQL y conectarse con el usuario root y el puerto establecido, para sucesivamente poder ver todas las tablas creadas automáticamente, con sus tipos de datos y sus relaciones
7. Abrir Postman
8. Importar deepwallet.postman_collection.json desde el directorio de postman dentro del repositorio clonado de Deepwallet
9. Realizar peticiones HTTP para hacer CRUD de Usuarios, Ingresos, Gastos, Categorías de Ingresos, Categorías de Gastos. Adicionalmente, se pueden hacer peticiones HTTP tipo GET a un Usuario (DTO) para ver datos básicos de el Usuario como el id, nombre, saldo, así evitando exponer información privada importante. También puedes hacer una petición HTTP tipo GET a una API con un filtro DTO para poder ver el precio del Dolar a CLP actual. (Puedes modificar los datos desde el Body en Postman, ya sea para crear con un POST o actualizar información ya existente con un PUT). Puedes cambiar el ID modificando el último valor del URL de la petición HTTP en Postman.
