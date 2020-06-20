package com.example.command.core.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "HOTEL")
@Getter
@EqualsAndHashCode(callSuper = false)
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 15, message = "")
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "name")
    private String name;

    public String getFullName() {
        return this.city + " " + this.name;
    }
}
