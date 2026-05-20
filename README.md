# DeepWallet

> [!NOTE]
Este programa ayuda a organizar ingresos y gastos de una persona agrupandolos en categorías (ej. Comida, Transporte, Suscripciones, etc.) para llevar un mejor registro de tu flujo de dinero, realizando peticiones HTTP a través de Postman para agregar, modificar, listar o eliminar los datos. También, tiene la función de organizar automáticamente tablas dentro de una base de datos MySQL.

**Requisitos:**

- **IDE Recomendada**: Visual Studio Code (con la extensión *Extension Pack for Java* instalada)
- **Entorno de Java: JDK 21+**
- **Base de Datos:** MySQL (Se puede utilizar XAMPP, Laragon, etc.) y un cliente como HeidiSQL
- **Herramienta para peticiones HTTP:** Postman
- **Gestor de dependencias**: Maven

## ¿Cómo ejecutar el proyecto? (Get Started)

### 1. Clonar y abrir el repositorio
Abre la terminal y clona este repositorio en tu máquina local. Luego, abre la carpeta con Visual Studio Code.

> git clone [https://github.com/BastianHuenchullan/DeepWallet.git](https://github.com/BastianHuenchullan/DeepWallet.git)

### 2. Configurar la Base de Datos

Inicia el servicio de MySQL (usando XAMPP, Laragon, etc.) con en el puerto por defecto 3306.

En caso de algún error o querer utilizar otro puerto como por ejemplo el 3307, debes ir a src/main/resources/application.properties y actualizar esta línea:

> spring.datasource.url=jdbc:mysql://localhost:3307/deepwallet?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC

### 3. Ejecutar la aplicación

- En Visual Studio Code, busca el archivo principal DeepwalletApplication.java y ejecútalo con "Run Java".
- Spring Boot va a crear la base de datos DeepWallet automáticamente con todas sus tablas, relaciones y tipos de datos.
- (Opcional) Puedes abrir HeidiSQL para conectarte con el usuario root y el puerto establecido anteriormente para verificar que las tablas se hayan creado correctamente.

### 4. Configurar Postman

- Para interactuar con la aplicación, abriremos Postman.
- Pon "Import" y selecciona el archivo deepwallet.postman_collection.json que se encuentra dentro de la carpeta /postman de este repositorio.

### 5. Realizar peticiones HTTP y usar API

- CRUD: Puedes obtener (GET), crear (POST), actualizar (PUT) y eliminar (DELETE) los Usuarios, Ingresos, Gastos, Categorías de Ingresos y Categorías de Gastos.
- DTO: Se pueden realizar peticiones tipo GET a un Usuario mediante un DTO (Data Transfer Object), para ver datos básicos como el id, nombre y saldo, evitando exponer información privada e importante.
- API Dólar: También existe un Endpoint con un filtro DTO para consultar el precio actual del Dólar a CLP.

Puedes modificar los datos a enviar desde el "Body" en Postman, ya sea para la creación (POST) o actualización (PUT) sobre un registro en específico. Debes cambiar el ID en la URL de la petición (ej. /api/usuarios/1).

## Autores:

- Bastian Huenchullan (ba.huenchullan@duocuc.cl)
- Matías Cabezas (mat.cabezasc@duocucuc.cl)
- Daniel Escalante (da.escalante@duocuc.cl)
