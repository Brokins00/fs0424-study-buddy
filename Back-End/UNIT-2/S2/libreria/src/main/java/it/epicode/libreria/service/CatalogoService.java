package it.epicode.libreria.service;

import it.epicode.libreria.dto.CatalogoDto;
import it.epicode.libreria.entities.Catalogo;
import it.epicode.libreria.entities.Libro;
import it.epicode.libreria.entities.Rivista;
import it.epicode.libreria.exception.ParametriErratiException;
import it.epicode.libreria.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogoService {
    @Autowired
    private CatalogoRepository catalogoRepository;

    public String inserisciCatalogo(CatalogoDto catalogo) {
        Optional<Catalogo> catalogoOptional = getCatalogoById(catalogo.getCodiceISBN());
        if (catalogoOptional.isPresent()) {
            throw new ParametriErratiException("Prodotto esistente");
        }else {
            if (catalogo.getPeriodicita() != null) {
                Rivista rivista = new Rivista();
                rivista.setTitolo(catalogo.getTitolo());
                rivista.setPeriodicita(catalogo.getPeriodicita());
                rivista.setAnnoPubblicazione(catalogo.getAnnoPubblicazione());
                rivista.setCodiceISBN(catalogo.getCodiceISBN());
                rivista.setNumeroPagine(catalogo.getNumeroPagine());
                return catalogoRepository.save(rivista).getCodiceISBN();
            } else {
                Libro libro = new Libro();
                libro.setTitolo(catalogo.getTitolo());
                libro.setAnnoPubblicazione(catalogo.getAnnoPubblicazione());
                libro.setCodiceISBN(catalogo.getCodiceISBN());
                libro.setNumeroPagine(catalogo.getNumeroPagine());
                libro.setAutore(catalogo.getAutore());
                libro.setGenere(catalogo.getGenere());
                return catalogoRepository.save(libro).getCodiceISBN();
            }
        }
    }

    public Page<Catalogo> getAllCataloghi(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return catalogoRepository.findAll(pageable);
    }

    public Optional<Catalogo> getCatalogoById(String codiceISBN) {
        return catalogoRepository.findById(codiceISBN);
    }

    public void eliminaCatalogo(String codiceISBN) {
        Optional<Catalogo> catalogo = getCatalogoById(codiceISBN);
        if (catalogo.isPresent()) {
            catalogoRepository.delete(catalogo.get());
            System.out.println("Catalogo eliminato con successo");
        } else {
            System.err.println("Il catalogo non è esistente in database");
        }
    }
}
