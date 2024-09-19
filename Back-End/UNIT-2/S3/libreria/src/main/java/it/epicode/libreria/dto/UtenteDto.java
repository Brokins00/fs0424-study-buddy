package it.epicode.libreria.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UtenteDto {
    @Email
    private String email;
    @NotNull
    private String password;
}
