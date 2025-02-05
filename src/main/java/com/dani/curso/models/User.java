package com.dani.curso.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "user")
@ToString
@EqualsAndHashCode
//@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "role_id")
    @Getter  @Setter
    private Role role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    @Getter  @Setter
    private String password;

    @Column(name = "nombre")
    @Getter  @Setter
    private String nombre;

    @Column(name = "apellido")
    @Getter  @Setter
    private String apellido;

    @Column(name = "email")
    @Getter  @Setter
    private String email;

    @Column(name = "telefono")
    @Getter  @Setter
    private String telefono;

    @Column(name = "fecha_nacimiento")
    @Getter  @Setter
    private Date fecha;

    public User(){

    }
    public User(long id, String nombre, Date fecha, String telefono, String email, String apellido) {
        setId(id);
        this.nombre = nombre;
        this.fecha = fecha;
        this.telefono = telefono;
        this.email = email;
        this.apellido = apellido;
    }


}
