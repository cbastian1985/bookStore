package com.bookStore.repository;

import com.bookStore.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface iAutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNombreContainsIgnoreCase(String nombre);
    List<Autor> findByCumpleaniosLessThanEqualAndFechaFallecimientoGreaterThanEqual(Integer anioBuscado, Integer anioBuscado2);
}