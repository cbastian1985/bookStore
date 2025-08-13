package com.bookStore.Libreria;

import com.bookStore.config.ConsumoAPI;
import com.bookStore.config.ConvertirDatos;
import com.bookStore.models.Autor;
import com.bookStore.models.Libro;
import com.bookStore.models.LibrosRespuestaApi;
import com.bookStore.models.records.DatosAutor;
import com.bookStore.models.records.DatosLibro;
import com.bookStore.repository.iAutorRepository;
import com.bookStore.repository.iLibroRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Libreria {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvertirDatos convertir = new ConvertirDatos();
    private final String URL_BASE = "https://gutendex.com/books/";
    private iLibroRepository libroRepository;
    private iAutorRepository autorRepository;

    public Libreria(iLibroRepository libroRepository, iAutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public void consumo() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    -----------
                    1 - Agregar Libro por Nombre
                    2 - Libros buscados
                    3 - Buscar libro por Nombre
                    4 - Buscar todos los Autores de libros buscados
                    5 - Buscar Autores por año
                    6 - Buscar Libros por Idioma
                    7 - Top 10 Libros mas Descargados
                    8 - Buscar Autor por Nombre
                    0 - Salir
                    -----------
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorNombre();
                    break;
                case 2:
                    mostrarLibrosBuscados();
                    break;
                case 3:
                    buscarLibroPorTitulo();
                    break;
                case 4:
                    mostrarAutoresBuscados();
                    break;
                case 5:
                    buscarAutoresPorAnio();
                    break;
                case 6:
                    buscarLibrosPorIdioma();
                    break;
                case 7:
                    mostrarTop10Libros();
                    break;
                case 8:
                    buscarAutorPorNombre();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void buscarLibroPorNombre() {
        System.out.println("Escribe el nombre del libro que deseas buscar:");
        var nombreLibro = teclado.nextLine();
        String json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "%20"));
        LibrosRespuestaApi respuestaApi = convertir.convertirDatosJsonAJava(json, LibrosRespuestaApi.class);

        if (respuestaApi != null && respuestaApi.getResultadoLibros() != null && !respuestaApi.getResultadoLibros().isEmpty()) {
            DatosLibro datosLibro = respuestaApi.getResultadoLibros().get(0);

            Optional<Libro> libroExistente = libroRepository.findByTituloContainsIgnoreCase(datosLibro.titulo());
            if(libroExistente.isPresent()){
                System.out.println("El libro ya se encuentra guardado.");
            } else {
                Libro libro = new Libro(datosLibro);

                if (datosLibro.autor() != null && !datosLibro.autor().isEmpty()) {
                    DatosAutor autorApi = datosLibro.autor().get(0);
                    Optional<Autor> autorExistente = autorRepository.findByNombreContainsIgnoreCase(autorApi.nombre());

                    Autor autor;
                    if (autorExistente.isPresent()) {
                        autor = autorExistente.get();
                    } else {
                        autor = new Autor(autorApi);
                        autorRepository.save(autor);
                    }
                    libro.setAutor(autor);
                } else {
                    System.out.println("Autor no encontrado en la API.");
                }
                libroRepository.save(libro);
                System.out.println("Libro guardado: " + libro);
            }
        } else {
            System.out.println("Libro no encontrado en la API o no se pudo procesar la respuesta.");
        }
    }

    private void mostrarLibrosBuscados() {
        List<Libro> libros = libroRepository.findAll();
        libros.forEach(System.out::println);
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Escribe el título del libro que deseas buscar:");
        var titulo = teclado.nextLine();
        Optional<Libro> libro = libroRepository.findByTituloContainsIgnoreCase(titulo);
        libro.ifPresentOrElse(
                l -> System.out.println("Libro encontrado: " + l),
                () -> System.out.println("Libro no encontrado.")
        );
    }

    private void mostrarAutoresBuscados() {
        List<Autor> autores = autorRepository.findAll();
        autores.forEach(System.out::println);
    }

    private void buscarAutoresPorAnio() {
        System.out.println("Escribe el año en que deseas buscar autores (nacidos o fallecidos en este año):");
        var anio = teclado.nextInt();
        teclado.nextLine();
        List<Autor> autores = autorRepository.findByCumpleaniosLessThanEqualAndFechaFallecimientoGreaterThanEqual(anio, anio);
        autores.forEach(System.out::println);
    }

    private void buscarLibrosPorIdioma() {
        System.out.println("Escribe el idioma en el que deseas buscar los libros:");
        var idioma = teclado.nextLine();
        List<Libro> libros = libroRepository.findByIdioma(idioma);
        libros.forEach(System.out::println);
    }

    private void mostrarTop10Libros() {
        List<Libro> top10Libros = libroRepository.findTop10ByCantidadDescargas();
        top10Libros.forEach(System.out::println);
    }

    private void buscarAutorPorNombre() {
        System.out.println("Escribe el nombre del autor que deseas buscar:");
        var nombreAutor = teclado.nextLine();
        Optional<Autor> autor = autorRepository.findByNombreContainsIgnoreCase(nombreAutor);
        autor.ifPresentOrElse(
                a -> System.out.println("Autor encontrado: " + a),
                () -> System.out.println("Autor no encontrado.")
        );
    }
}