package it.epicode.libreria.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="libri")
@Data
public class Libro extends Catalogo {
    private String autore;
    private String genere;
}
