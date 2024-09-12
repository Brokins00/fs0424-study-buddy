package it.epicode.gestionaleLibreria.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="cataloghi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Catalogo {
    @Id
    private String codiceISBN;
    private String titolo;
    private Integer annoPubblicazione;
    private Integer numeroPagine;
}
