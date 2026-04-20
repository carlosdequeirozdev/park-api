package com.queirozdec.park_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Column(name = "role", nullable = false)
    private Role role = Role.ROLE_CLIENTE;

    @Column(name = "dataCriacao")
    private LocalDateTime dataCriacao;
    @Column(name =  "dataModificacao")
    private LocalDateTime dataModificacao;
    @Column(name = "criadoPor")
    private LocalDateTime criadoPor;
    @Column(name = "modificadoPor")
    private LocalDateTime modificadoPor;

    public enum Role{
        ROLE_ADMIN, ROLE_CLIENTE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }
}
