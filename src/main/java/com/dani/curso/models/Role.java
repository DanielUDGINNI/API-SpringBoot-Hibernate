package com.dani.curso.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="role")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity {
    @Column(name = "nombre")
    @Getter
    @Setter
    private String nombre;

    /**
     *Permisos
     */
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "role")
    @Getter @Setter
    private Set<Permiso> permisos;

}
