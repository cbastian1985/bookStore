package com.bookStore.config.iConfig;

public interface IConvierteDatos {
    <T> T convertirDatosJsonAJava(String json, Class<T> clase);
}