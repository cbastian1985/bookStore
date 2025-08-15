# 📚 BooksStore

Aplicación de **consola** para la gestión y búsqueda de libros, conectada a la **API de Gutedex** para acceder a una vasta biblioteca de libros de dominio público.

---

## ✨ Funcionalidades

BooksStore te permite interactuar con la biblioteca de Gutedex a través de un menú intuitivo.  
Entre las principales funciones encontrarás:

- 🔍 **Agregar Libro por Nombre**: Busca y añade un libro a tu colección.
- 📜 **Libros Buscados**: Muestra todos los libros que has buscado previamente.
- 🎯 **Buscar Libro por Nombre**: Realiza una búsqueda específica por título.
- ✍️ **Buscar Autores de Libros Buscados**: Lista los autores de los libros que consultaste.
- 📅 **Buscar Autores por Año**: Filtra autores activos en un año específico.
- 🌍 **Buscar Libros por Idioma**: Encuentra libros en un idioma determinado.
- 📈 **Top 10 Libros Más Descargados**: Muestra los títulos más populares.
- 🖊️ **Buscar Autor por Nombre**: Encuentra un autor específico.
- 🚪 **Salir**: Finaliza la aplicación.

---

## 🛠️ Tecnologías Utilizadas

- ☕ **Java** – Lenguaje principal.
- 📦 **Maven** – Gestión de dependencias.
- 🌐 **Gutedex API (gutedex)** – Fuente de datos de libros.

---

## 🚀 Instalación y Uso

### 📋 Requisitos Previos

- **JDK 17** o superior instalado.
- **Maven** instalado.

### 🖥️ Pasos para Ejecutar

1. **Clona este repositorio:**
      ```bash
   git clone [https://github.com/cbastian1985/bookStore]
2. **Navega al directorio del proyecto:**
   cd
   BooksStore
3. **Compila la aplicación:**
   mvn clean install
4. **Cambiar contraseña y usuario en application.properties**
   spring.datasource.username=*******
    spring.datasource.password=******
5. **Ejecuta la aplicación:**
   java -jar target/nombre-del-jar-file.jar

   




