package com.example.demo;

import com.example.demo.controller.CategorieController;
import com.example.demo.controller.ProduitController;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private ProduitController produitController;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private CategorieController categorieController;

    @Test
    void ajoutProducts() {
        Produit produit = new Produit("testins unit", 4, true);
        produit.setDateCreation(new Timestamp(System.currentTimeMillis()));
        produitController.ajoutProduct(produit, 35);
        assertTrue(produitRepository.findById(produit.getId()).isPresent());
    }

    @Test
    void ajoutCategorie() {
        Categorie categorie = new Categorie("uniiiit", 4, new Timestamp(System.currentTimeMillis()));
        categorie.setDate_Creation(new Timestamp(System.currentTimeMillis()));
        categorieController.ajoutCategorie(categorie);
        assertTrue(categorieRepository.findById(categorie.getId()).isPresent());
    }


}
