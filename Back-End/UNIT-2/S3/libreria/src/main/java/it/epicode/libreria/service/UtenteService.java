package it.epicode.libreria.service;

import it.epicode.libreria.dto.UtenteDto;
import it.epicode.libreria.entities.Utente;
import it.epicode.libreria.enums.RuoloUtente;
import it.epicode.libreria.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Utente> getUtenteById(Integer id) {
        return utenteRepository.findById(id);
    }

    public Optional<Utente> getUtenteByEmail(String email) {
        return utenteRepository.findByEmail(email);
    }

    public Page<Utente> getAllUtenti(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return utenteRepository.findAll(pageable);
    }

    public Integer saveUtente(UtenteDto utenteDto) {
        if (getUtenteByEmail(utenteDto.getEmail()).isEmpty()) {
            Utente utente = new Utente();
            utente.setEmail(utenteDto.getEmail());
            utente.setPassword(passwordEncoder.encode(utenteDto.getPassword()));
            utente.setRuoloUtente(RuoloUtente.USER);
            return utenteRepository.save(utente).getId();
        } else {
            throw new RuntimeException("L'email è già presente");
        }
    }
}
