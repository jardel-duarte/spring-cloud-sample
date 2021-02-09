package com.atlantico.desafio.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(unique = true)
    private String email;

    @Column(length = 200)
    private String password;

    @Column(name = "is_admin", columnDefinition = "boolean default false")
    private boolean admin;
}
