package com.bookStore.dtos;

public enum Genero {
    FICCION("Fiction"),
    FILOSOFIA("Philosophy"),
    CIENCIA_FICCION("Science Fiction"),
    FANTASIA("Fantasy"),
    AVENTURA("Adventure"),
    DRAMA("Drama"),
    ROMANCE("Romance"),
    DESCONOCIDO("Desconocido");

    private String categoria;

    Genero(String categoria) {
        this.categoria = categoria;
    }

    public static Genero fromString(String text) {
        for (Genero genero : Genero.values()) {
            if (genero.categoria.equalsIgnoreCase(text)) {
                return genero;
            }
        }
        return DESCONOCIDO;
    }
}