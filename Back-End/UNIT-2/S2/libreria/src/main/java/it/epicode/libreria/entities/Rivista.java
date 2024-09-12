package it.epicode.libreria.entities;

import it.epicode.libreria.enums.Periodicita;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="riviste")
@Data
@EqualsAndHashCode(callSuper = true)
public class Rivista extends Catalogo {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;
}
