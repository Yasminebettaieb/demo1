package com.example.demo;

import com.example.demo.controller.CategorieController;
import com.example.demo.controller.ProduitController;
import com.example.demo.entities.Categorie;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    void ajoutCategorie() {
        Categorie categorie = new Categorie("uniiiit", 4);
        categorieController.ajoutCategorie(categorie);
        assertTrue(categorieRepository.findById(categorie.getId()).isPresent());
    }


}
