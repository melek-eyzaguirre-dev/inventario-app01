# 📦 Inventario App

Aplicación web para administrar productos, precios y existencias. Está desarrollada con Angular, Spring Boot y MySQL.

## 🧰 Stack tecnológico

| Tecnología | Uso |
|---|---|
| 🅰️ Angular | Interfaz web |
| 🍃 Spring Boot | API REST y lógica del sistema |
| 🐬 MySQL | Base de datos |
| ☕ Java | Lenguaje del backend |
| 🛠️ Maven | Compilación del backend |
| 💻 Visual Studio Code | Editor recomendado |

## ✨ Funcionalidades

- ➕ Registrar productos
- 📋 Consultar productos
- ✏️ Actualizar productos
- 🗑️ Eliminar productos
- 💰 Administrar precios
- 📊 Controlar existencias
- 🗄️ Guardar información en MySQL
- 🌐 Utilizar la aplicación desde un navegador

---

## 📥 Formas de obtener el proyecto

### Opción 1: Descargar ZIP

1. Abra el repositorio:

   <https://github.com/melek-eyzaguirre-dev/inventario-app01>

2. Seleccione **Code**.
3. Seleccione **Download ZIP**.
4. Extraiga el archivo en una carpeta de su computador.
5. Abra la carpeta extraída con Visual Studio Code.

### Opción 2: Clonar el repositorio

Instale Git y ejecute:

```powershell
git clone https://github.com/melek-eyzaguirre-dev/inventario-app01.git
cd inventario-app01
```

### Opción 3: Crear un Fork

Un fork crea una copia del proyecto en su propia cuenta de GitHub.

1. Inicie sesión en GitHub.
2. Abra el repositorio original.
3. Pulse **Fork**.
4. Seleccione su cuenta personal.
5. Clone su copia:

```powershell
git clone https://github.com/SU_USUARIO/inventario-app01.git
cd inventario-app01
```

---

## 💻 Requisitos para instalarlo localmente

Instale los siguientes programas:

- 🐙 Git
- 🟢 Node.js 20 o superior
- ☕ Java 21
- 🛠️ Maven 3.9 o superior
- 🐬 MySQL 8 o superior
- 🧑‍💻 Visual Studio Code

Compruebe la instalación desde PowerShell:

```powershell
git --version
node --version
java --version
mvn --version
mysql --version
```

---

## 🗄️ Configurar MySQL

Inicie MySQL y conéctese utilizando el puerto `3307`.

Desde MySQL Workbench ejecute:

```sql
CREATE DATABASE IF NOT EXISTS inventarios_db;

CREATE USER IF NOT EXISTS 'inventario_user'@'localhost'
IDENTIFIED BY 'admin';

GRANT ALL PRIVILEGES ON inventarios_db.*
TO 'inventario_user'@'localhost';

FLUSH PRIVILEGES;
```

La configuración local es:

| Parámetro | Valor |
|---|---|
| Servidor | `localhost` |
| Puerto | `3307` |
| Base de datos | `inventarios_db` |
| Usuario | `inventario_user` |
| Contraseña | `admin` |

> 🔐 En producción debe utilizar una contraseña segura y no publicarla en GitHub.

Para comprobar la tabla:

```sql
USE inventarios_db;
SHOW TABLES;
SELECT * FROM producto;
```

---

## ▶️ Ejecutar el backend localmente

Abra una terminal en Visual Studio Code:

```powershell
cd backend
mvn spring-boot:run
```

El backend se ejecutará en:

```text
http://localhost:8082
```

La API de productos estará disponible en:

```text
http://localhost:8082/inventario-app/productos
```

Mantenga esta terminal abierta.

---

## 🖥️ Ejecutar el frontend localmente

Abra una segunda terminal:

```powershell
cd frontend
npm install
npm start
```

Abra el navegador en:

```text
http://localhost:4200
```

Pantalla de productos:

```text
http://localhost:4200/productos
```

### 🔄 Orden recomendado

1. Iniciar MySQL.
2. Ejecutar Spring Boot.
3. Ejecutar Angular.
4. Abrir el navegador.
5. Registrar y administrar productos.

---

## 🧪 Probar el CRUD

Desde la pantalla de productos:

1. ➕ Agregue un producto.
2. 📋 Verifique que aparezca en la lista.
3. ✏️ Edite sus datos.
4. 🗑️ Elimínelo.
5. 🔎 Compruebe los cambios en MySQL Workbench:

```sql
USE inventarios_db;
SELECT * FROM producto ORDER BY id_producto DESC;
```

### 🧪 Probar la API con Postman

**Crear producto**

- Método: `POST`
- URL: `http://localhost:8082/inventario-app/productos`
- Body → `raw` → `JSON`

```json
{
  "descripcion": "Mouse",
  "precio": 15.5,
  "existencia": 20
}
```

### 🔗 Endpoints disponibles

| Operación | Método | URL |
|---|---|---|
| Listar | `GET` | `/inventario-app/productos` |
| Consultar por ID | `GET` | `/inventario-app/productos/{id}` |
| Crear | `POST` | `/inventario-app/productos` |
| Actualizar | `PUT` | `/inventario-app/productos/{id}` |
| Eliminar | `DELETE` | `/inventario-app/productos/{id}` |

---

## 🎓 Guía rápida para estudiantes

### Crear un componente Angular

Desde la carpeta `frontend`:

```powershell
ng generate component nombre-componente
```

Forma abreviada:

```powershell
ng g c nombre-componente
```

Angular genera normalmente:

```text
nombre-componente/
├── nombre-componente.ts
├── nombre-componente.html
├── nombre-componente.css
└── nombre-componente.spec.ts
```

Un componente contiene:

- `.ts`: lógica y propiedades.
- `.html`: estructura visual.
- `.css`: estilos.
- `.spec.ts`: pruebas unitarias.

Ejemplo:

```powershell
ng g c producto-lista
ng g c agregar-producto
ng g c editar-producto
```

### Crear un servicio Angular

```powershell
ng generate service servicios/producto
```

Los servicios permiten comunicarse con el backend mediante `HttpClient`.

Ejemplo conceptual:

```typescript
listarProductos() {
  return this.http.get<Producto[]>(
    'http://localhost:8082/inventario-app/productos'
  );
}
```

---

## 🍃 Crear un proyecto Spring Boot

El backend puede generarse con **Spring Initializr**:

1. Abra <https://start.spring.io>.
2. Seleccione:

| Opción | Valor |
|---|---|
| Project | Maven |
| Language | Java |
| Spring Boot | Versión estable disponible |
| Packaging | Jar |
| Java | 21 |

3. Agregue estas dependencias:

- 🌐 Spring Web
- 🗄️ Spring Data JPA
- 🐬 MySQL Driver
- 🧪 Spring Boot DevTools
- ✅ Spring Boot Starter Test

4. Pulse **Generate**.
5. Extraiga el proyecto dentro de la carpeta `backend`.
6. Ábralo con Visual Studio Code.

### 🧱 Capas principales del backend

```text
backend/src/main/java/
└── ymdev/inventarios/
    ├── modelo/       # Entidades de la base de datos
    ├── repositorio/  # Acceso a MySQL
    ├── servicio/     # Reglas del negocio
    └── controlador/  # Endpoints REST
```

### Crear una entidad

```java
@Entity
@Table(name = "producto")
public class Producto {
}
```

### Crear un repositorio

```java
public interface ProductoRepositorio
        extends JpaRepository<Producto, Long> {
}
```

### Crear un servicio

```java
@Service
public class ProductoServicio {
}
```

### Crear un controlador

```java
@RestController
@RequestMapping("/inventario-app/productos")
public class ProductoControlador {
}
```

Estas capas permiten separar responsabilidades y mantener el proyecto organizado.

---

## 🏗️ Compilar para producción

### Frontend

```powershell
cd frontend
npm install
npm run build
```

Los archivos generados estarán dentro de:

```text
frontend\dist\
```

### Backend

```powershell
cd backend
mvn clean package
```

El archivo ejecutable estará dentro de:

```text
backend\target\
```

Para ejecutarlo:

```powershell
java -jar target\inventarios-0.0.1-SNAPSHOT.jar
```

---

## 🛠️ Solución de problemas

### ❌ No conecta con MySQL

Verifique que:

- MySQL esté iniciado.
- El puerto sea `3307`.
- Exista la base de datos `inventarios_db`.
- El usuario y la contraseña sean correctos.

### ❌ Error 404 en la API

Compruebe que Spring Boot esté ejecutándose y utilice:

```text
http://localhost:8082/inventario-app/productos
```

### ❌ Angular no muestra productos

Compruebe que:

- Spring Boot esté activo.
- Angular esté activo.
- El servicio Angular utilice el puerto `8082`.
- No existan errores en la consola del navegador.

### ❌ Error CORS

Verifique que el controlador permita solicitudes desde:

```text
http://localhost:4200
```

### ❌ El puerto está ocupado

Cierre el programa que utiliza el puerto o cambie el puerto en la configuración.

---

## 🔐 Seguridad

No publique en GitHub:

- Contraseñas reales.
- Claves privadas.
- Tokens.
- Archivos `.env`.
- Configuraciones de producción.

Utilice variables de entorno como:

```text
DB_URL
DB_USER
DB_PASS
SERVER_PORT
```

---

## 🤝 Contribuir al proyecto

1. Cree un fork.
2. Clone su repositorio.
3. Cree una rama:

```powershell
git checkout -b feature/nueva-funcionalidad
```

4. Realice los cambios.
5. Guarde y confirme:

```powershell
git add .
git commit -m "feat: agregar nueva funcionalidad"
git push origin feature/nueva-funcionalidad
```

6. Abra un Pull Request en GitHub.

---

## 📄 Licencia

Proyecto educativo y administrativo. Consulte al propietario antes de utilizarlo en un entorno comercial.

## 👩‍💻 Autora

**Melek Eyzaguirre**

Repositorio:

<https://github.com/melek-eyzaguirre-dev/inventario-app01>
