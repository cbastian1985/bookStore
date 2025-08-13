package com.bookStore;

import com.bookStore.Libreria.Libreria;
import com.bookStore.repository.iAutorRepository;
import com.bookStore.repository.iLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

    @Autowired
    private iLibroRepository libroRepository;
    @Autowired
    private iAutorRepository autorRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Libreria libreria = new Libreria(libroRepository, autorRepository);
        libreria.consumo();
    }
}