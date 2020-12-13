package com.example.command.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "status")
    private String status;

    @Transient
    @JsonIgnore
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
