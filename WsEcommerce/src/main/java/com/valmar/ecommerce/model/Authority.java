package com.valmar.ecommerce.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.valmar.ecommerce.enums.AuthorityName;

import java.util.List;

@Entity
@Table(name = "autoridad")
public class Authority {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}