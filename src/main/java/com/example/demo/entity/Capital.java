package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Capital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer population;

    @OneToOne(mappedBy = "capital")
    @JsonIgnore
    private Country country;

    @OneToMany(mappedBy = "capital")
    private List<Street> streets  = new ArrayList<>();;
}
