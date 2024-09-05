package it.epicode.gestionaleLibreria;

import it.epicode.gestionaleLibreria.entities.Libro;
import it.epicode.gestionaleLibreria.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {
    @Autowired
    private CatalogoService catalogoService;
    @Autowired
    private ApplicationContext ctx;
    @Override
    public void run(String... args) throws Exception {
        Libro libro = (Libro) ctx.getBean("harrypotter");
        String id = catalogoService.inserisciCatalogo(libro);
        System.out.println("Libro con id "+id+" creato con successo");
    }
}
