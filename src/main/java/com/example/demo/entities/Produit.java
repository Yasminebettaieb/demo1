package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name = "produit")
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom_Produit;
    private int quantite_Produit;
    private Boolean disponible;

    private Timestamp date_Creation;

    private Timestamp date_Modification;
    @ManyToOne
    @JoinColumn(name = "idCategorie", insertable = true, updatable = true)
    @JsonIgnore
    private Categorie categorie;


}