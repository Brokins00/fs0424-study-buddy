package it.epicode.libreria.service;

import it.epicode.libreria.dto.UtenteLoginDto;
import it.epicode.libreria.entities.Utente;
import it.epicode.libreria.security.JwtTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private JwtTool jwtTool;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUtenteAndCreateToken(UtenteLoginDto utenteLoginDto) {
        Optional<Utente> utenteOptional = utenteService.getUtenteByEmail(utenteLoginDto.getEmail());

        if (utenteOptional.isPresent()) {
            Utente utente = utenteOptional.get();

            if (passwordEncoder.matches(utenteLoginDto.getPassword(), utente.getPassword())) {
                return jwtTool.createToken(utente);
            } else {
                throw new RuntimeException("Password errata. Fai di nuovo login!");
            }
        } else {
            throw new RuntimeException("Utente non presente. Fai di nuovo login!");
        }
    }
}
