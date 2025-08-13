package com.bookStore.models;
import com.bookStore.dtos.Genero;
import com.bookStore.models.records.DatosLibro;
import com.bookStore.models.records.Media;
import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long libroId;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @Enumerated(EnumType.STRING)
    private Genero genero;
    private String idioma;
    private String imagen;
    private Long cantidadDescargas;

    public Libro() {}

    public Libro(DatosLibro datosLibro) {
        this.libroId = datosLibro.libroId();
        this.titulo = datosLibro.titulo();
        this.genero =  generoModificado(datosLibro.genero());
        this.idioma = idiomaModificado(datosLibro.idiomas());
        this.imagen = imagenModificada(datosLibro.imagen());
        this.cantidadDescargas = datosLibro.cantidadDescargas();
    }

    private Genero generoModificado(List<String> generos) {
        if (generos == null || generos.isEmpty()) {
            return Genero.DESCONOCIDO;
        }
        Optional<String> firstGenero = generos.stream()
                .map(g -> {
                    int index = g.indexOf("--");
                    return index != -1 ? g.substring(index + 2).trim() : null;
                })
                .filter(Objects::nonNull)
                .findFirst();
        return firstGenero.map(Genero::fromString).orElse(Genero.DESCONOCIDO);
    }

    private String idiomaModificado(List<String> idiomas) {
        if (idiomas == null || idiomas.isEmpty()) {
            return "Desconocido";
        }
        return idiomas.get(0);
    }

    private String imagenModificada(Media media) {
        if (media == null || media.imagen() == null || media.imagen().isEmpty()) {
            return "Sin imagen";
        }
        return media.imagen();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getLibroId() { return libroId; }
    public void setLibroId(Long libroId) { this.libroId = libroId; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }
    public Genero getGenero() { return genero; }
    public void setGenero(Genero genero) { this.genero = genero; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }
    public Long getCantidadDescargas() { return cantidadDescargas; }
    public void setCantidadDescargas(Long cantidadDescargas) { this.cantidadDescargas = cantidadDescargas; }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", libroId=" + libroId +
                ", titulo='" + titulo + '\'' +
                ", autor=" + (autor != null ? autor.getNombre() : "N/A") +
                ", genero=" + genero +
                ", idioma='" + idioma + '\'' +
                ", imagen='" + imagen + '\'' +
                ", cantidadDescargas=" + cantidadDescargas +
                '}';
    }
}