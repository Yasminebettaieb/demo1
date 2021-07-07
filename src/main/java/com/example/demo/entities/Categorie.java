package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "categorie")
@Entity
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomCategorie;
    private int quantiteCategorie;

    private Timestamp date_Creation;
    private Timestamp date_Modification;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Categorie", referencedColumnName = "id") // we need to duplicate the physical information
    private List<Produit> produits;

    public Categorie(String nomCategorie, int quantiteCategorie) {
        this.nomCategorie = nomCategorie;
        this.quantiteCategorie = quantiteCategorie;
    }

    public Categorie() {

    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public int getQuantiteCategorie() {
        return quantiteCategorie;
    }

    public void setQuantiteCategorie(int quantiteCategorie) {
        this.quantiteCategorie = quantiteCategorie;
    }

    public Timestamp getDate_Creation() {
        return date_Creation;
    }

    public void setDate_Creation(Timestamp date_Creation) {
        this.date_Creation = date_Creation;
    }

    public Timestamp getDate_Modification() {
        return date_Modification;
    }

    public void setDate_Modification(Timestamp date_Modification) {
        this.date_Modification = date_Modification;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}