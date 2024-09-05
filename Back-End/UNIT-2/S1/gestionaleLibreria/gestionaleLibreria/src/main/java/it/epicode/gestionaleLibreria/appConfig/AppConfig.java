package it.epicode.gestionaleLibreria.appConfig;

import it.epicode.gestionaleLibreria.entities.Libro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    @Bean(name="harrypotter")
    @Scope("prototype")
    public Libro libro() {
        Libro libro = new Libro();
        libro.setTitolo("Harry Potter");
        libro.setAutore("J.K. Rowling");
        libro.setGenere("Fantasy");
        libro.setCodiceISBN("HP-097832");
        libro.setNumeroPagine(700);
        libro.setAnnoPubblicazione(2024);
        return libro;
    }
}
