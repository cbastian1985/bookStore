BooksStore
Aplicación de consola para la gestión y búsqueda de libros, conectada a la API de Gutenberg (gutedex) para acceder a una vasta biblioteca de libros de dominio público.

📖 Funcionalidades
BooksStore te permite interactuar con la biblioteca de Gutenberg a través de un menú intuitivo. Puedes realizar las siguientes operaciones:

Agregar Libro por Nombre: Busca y añade un libro a tu colección.

Libros Buscados: Muestra el listado de todos los libros que has buscado previamente.

Buscar Libro por Nombre: Realiza una búsqueda específica de un libro por su título.

Buscar Autores de libros buscados: Obtiene un listado de todos los autores de los libros que has consultado.

Buscar Autores por Año: Filtra y muestra autores que estuvieron activos en un año específico.

Buscar Libros por Idioma: Encuentra libros disponibles en un idioma determinado.

Top 10 Libros más Descargados: Muestra los 10 libros más populares y descargados de la base de datos.

Buscar Autor por Nombre: Realiza una búsqueda específica de un autor.

Salir: Finaliza la aplicación.

🛠️ Tecnologías Utilizadas
Java: Lenguaje de programación principal.

Maven: Para la gestión de dependencias del proyecto.

Gutedex API: API pública que provee el acceso a la biblioteca de libros de Gutenberg.

🚀 Instalación y Uso
Requisitos
JDK 17 o superior instalado.

Maven instalado.

Pasos para ejecutar la aplicación
Clona este repositorio en tu máquina local:
git clone [URL_DE_TU_REPOSITORIO]

Navega al directorio del proyecto:
cd BooksStore

Compila y empaqueta la aplicación con Maven:
mvn clean install

Ejecuta la aplicación desde la línea de comandos:
java -jar target/nombre-del-jar-file.jar
