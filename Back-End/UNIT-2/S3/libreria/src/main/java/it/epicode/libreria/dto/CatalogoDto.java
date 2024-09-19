package it.epicode.libreria.dto;

import it.epicode.libreria.enums.Periodicita;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CatalogoDto {
    @NotNull
    private String codiceISBN;
    @NotNull
    private String titolo;
    @NotNull
    private Integer annoPubblicazione;
    @NotNull
    private Integer numeroPagine;
    private String autore;
    private String genere;
    private Periodicita periodicita;
}
