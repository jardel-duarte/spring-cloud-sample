package com.atlantico.desafio.users.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "seq_users", sequenceName = "seq_users", allocationSize = 1)
    @GeneratedValue(generator = "seq_users", strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @Email
    private String email;

    @Column(length = 200)
    private String password;
}
