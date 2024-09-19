package it.epicode.libreria.repository;

import it.epicode.libreria.entities.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo, String> {
}
