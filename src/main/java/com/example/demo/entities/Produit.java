package com.example.demo.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Table(name = "produit")
@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom_Produit;
    private int quantite_Produit;
    private Boolean disponible;

    @Transient
    private Timestamp date_Creation;

    @Transient
    private Timestamp date_Modification;
    @ManyToOne
    @JoinColumn(name = "id_Categorie")
    @JsonIgnore
    private Categorie categorie;


}