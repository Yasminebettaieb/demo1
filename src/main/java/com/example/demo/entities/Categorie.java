package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "categorie")
@Data
@Entity
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom_Categorie;
    private int quantite_Categorie;
    @Transient
    private Timestamp date_Creation;
    @Transient
    private Timestamp date_Modification;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Categorie", referencedColumnName = "id") // we need to duplicate the physical information
    private List<Produit> produits;
    public Categorie(String nom_Categorie, int quantite_Categorie) {
        this.nom_Categorie=nom_Categorie;
        this.quantite_Categorie=quantite_Categorie;

    }

    public Categorie() {

    }
}