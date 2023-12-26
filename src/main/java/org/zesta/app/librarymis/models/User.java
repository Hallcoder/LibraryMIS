package org.zesta.app.librarymis.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
