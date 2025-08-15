<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>README - BooksStore</title>
</head>
<body>

    <h1 align="center">BooksStore</h1>

    <p align="center">
        <img src="https://placehold.co/800x200/png?text=BooksStore" alt="BooksStore Logo">
    </p>

    <p>Aplicación de consola para la gestión y búsqueda de libros, conectada a la API de <strong>Gutenberg</strong> (gutedex) para acceder a una vasta biblioteca de libros de dominio público.</p>

    <h2>📖 Funcionalidades</h2>

    <p><code>BooksStore</code> te permite interactuar con la biblioteca de Gutenberg a través de un menú intuitivo. Puedes realizar las siguientes operaciones:</p>

    <ol>
        <li><strong>Agregar Libro por Nombre:</strong> Busca y añade un libro a tu colección.</li>
        <li><strong>Libros Buscados:</strong> Muestra el listado de todos los libros que has buscado previamente.</li>
        <li><strong>Buscar Libro por Nombre:</strong> Realiza una búsqueda específica de un libro por su título.</li>
        <li><strong>Buscar Autores de libros buscados:</strong> Obtiene un listado de todos los autores de los libros que has consultado.</li>
        <li><strong>Buscar Autores por Año:</strong> Filtra y muestra autores que estuvieron activos en un año específico.</li>
        <li><strong>Buscar Libros por Idioma:</strong> Encuentra libros disponibles en un idioma determinado.</li>
        <li><strong>Top 10 Libros más Descargados:</strong> Muestra los 10 libros más populares y descargados de la base de datos.</li>
        <li><strong>Buscar Autor por Nombre:</strong> Realiza una búsqueda específica de un autor.</li>
        <li><strong>Salir:</strong> Finaliza la aplicación.</li>
    </ol>

    <h2>🛠️ Tecnologías Utilizadas</h2>

    <ul>
        <li><strong>Java:</strong> Lenguaje de programación principal.</li>
        <li><strong>Maven:</strong> Para la gestión de dependencias del proyecto.</li>
        <li><strong>Gutedex API:</strong> API pública que provee el acceso a la biblioteca de libros de Gutenberg.</li>
    </ul>

    <h2>🚀 Instalación y Uso</h2>

    <h3>Requisitos</h3>
    <ul>
        <li><strong>JDK 17</strong> o superior instalado.</li>
        <li><strong>Maven</strong> instalado.</li>
    </ul>

    <h3>Pasos para ejecutar la aplicación</h3>
    <ol>
        <li>Clona este repositorio en tu máquina local:<br><code>git clone [URL_DE_TU_REPOSITORIO]</code></li>
        <li>Navega al directorio del proyecto:<br><code>cd BooksStore</code></li>
        <li>Compila y empaqueta la aplicación con Maven:<br><code>mvn clean install</code></li>
        <li>Ejecuta la aplicación desde la línea de comandos:<br><code>java -jar target/nombre-del-jar-file.jar</code></li>
    </ol>

    <hr>

</body>
</html>
