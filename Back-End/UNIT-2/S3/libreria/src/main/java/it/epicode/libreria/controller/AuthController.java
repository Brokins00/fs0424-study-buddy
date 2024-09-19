package it.epicode.libreria.controller;

import it.epicode.libreria.dto.UtenteDto;
import it.epicode.libreria.dto.UtenteLoginDto;
import it.epicode.libreria.service.AuthService;
import it.epicode.libreria.service.UtenteService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Integer register(@RequestBody @Validated UtenteDto utenteDto, BindingResult bindingResult) throws BadRequestException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).reduce("", (s, s2)->s+s2));
        }

        return utenteService.saveUtente(utenteDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Validated UtenteLoginDto utenteLoginDto, BindingResult bindingResult) throws BadRequestException {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException(bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).reduce("", (s, s2)->s+s2));
        }

        return authService.authenticateUtenteAndCreateToken(utenteLoginDto);
    }
}
