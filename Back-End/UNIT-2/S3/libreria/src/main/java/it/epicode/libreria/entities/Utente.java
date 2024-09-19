package it.epicode.libreria.entities;

import it.epicode.libreria.enums.RuoloUtente;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name="utenti")
public class Utente implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private RuoloUtente ruoloUtente;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(ruoloUtente.name()));
    }

    @Override
    public String getUsername() {
        return String.valueOf(this.id);
    }
}
