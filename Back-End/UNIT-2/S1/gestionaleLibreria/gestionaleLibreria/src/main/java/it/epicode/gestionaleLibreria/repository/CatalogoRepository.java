package it.epicode.gestionaleLibreria.repository;

import it.epicode.gestionaleLibreria.entities.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo, String> {
}
