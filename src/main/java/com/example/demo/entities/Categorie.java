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
    private String nomCategorie;
    private int quantiteCategorie;
    @Transient
    private Timestamp date_Creation;
    @Transient
    private Timestamp date_Modification;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Categorie", referencedColumnName = "id") // we need to duplicate the physical information
    private List<Produit> produits;

    public Categorie(String nomCategorie, int quantiteCategorie, Timestamp date_Creation) {
        this.nomCategorie = nomCategorie;
        this.quantiteCategorie = quantiteCategorie;
        this.date_Creation = date_Creation;
    }

    public Categorie() {

    }

}