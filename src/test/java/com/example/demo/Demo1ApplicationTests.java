package com.example.demo;

import com.example.demo.controller.CategorieController;
import com.example.demo.controller.ProduitController;
import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.Timestamp;


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
    void addCategory()
    {
        Categorie category=new Categorie();
        category.setNom_Categorie("Phones");
        category.setQuantite_Categorie(214);
        categorieController.ajoutCategorie(category);
        assertTrue(categorieRepository.findById(category.getId()).isPresent());
    }

}
