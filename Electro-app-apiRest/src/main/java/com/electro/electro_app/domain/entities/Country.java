package com.electro.electro_app.domain.entities;

import java.util.HashSet;
import java.util.Set;

import com.electro.electro_app.infraestructure.util.Validation.ExistsByCountryName;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"regions"})
@ToString(exclude = {"regions"})
@Table(name = "countries")
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ExistsByCountryName
    @Column(length = 50, nullable = false)
    private String name;

    @Embedded
    Audit audit = new Audit();

    @OneToMany(mappedBy = "country",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference("country-region")
    private Set<Region> regions = new HashSet<>();
}
