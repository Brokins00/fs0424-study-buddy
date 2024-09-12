package it.epicode.gestionaleLibreria.service;

import it.epicode.gestionaleLibreria.entities.Catalogo;
import it.epicode.gestionaleLibreria.repository.CatalogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogoService {
    @Autowired
    private CatalogoRepository catalogoRepository;

    public String inserisciCatalogo(Catalogo catalogo) {
        Optional<Catalogo> catalogoOptional = getCatalogoById(catalogo.getCodiceISBN());
        if (catalogoOptional.isPresent()) {
            throw new RuntimeException("Prodotto esistente");
        }else {
            Catalogo catalogo1 = catalogoRepository.save(catalogo);
            return catalogo1.getCodiceISBN();
        }
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
