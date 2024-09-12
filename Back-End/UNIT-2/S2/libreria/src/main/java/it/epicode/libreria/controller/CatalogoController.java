package it.epicode.libreria.controller;

import it.epicode.libreria.dto.CatalogoDto;
import it.epicode.libreria.entities.Catalogo;
import it.epicode.libreria.exception.ParametriErratiException;
import it.epicode.libreria.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cataloghi")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;

    @GetMapping
    public Page<Catalogo> getAllCataloghi(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "15") int size, @RequestParam(defaultValue = "codiceISBN") String sortBy) {
        return catalogoService.getAllCataloghi(page, size, sortBy);
    }

    @PostMapping
    public ResponseEntity<String> aggiungiCatalogo(@RequestBody @Validated CatalogoDto catalogoDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ParametriErratiException(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).reduce("", ((s, s2) -> s+s2)));
        }

        return new ResponseEntity<>(catalogoService.inserisciCatalogo(catalogoDto), HttpStatus.CREATED);
    }
}
