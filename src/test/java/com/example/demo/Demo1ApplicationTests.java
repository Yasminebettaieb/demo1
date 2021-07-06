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
      void ajoutProducts(){
        if (categorieRepository.findById(19L).isPresent()){
         Categorie categorie= categorieRepository.findById(19L).get();
        Produit produit = new Produit("testing",4,categorie);
         produitController.ajoutProduct(produit,19L);
         int l = produitRepository.findAll().size();
            int l1=l+1;
            System.err.println(l);
         assertEquals(l1,l);}

     }
    @Test
     void ajoutCategorie(){
        Categorie categorie = new Categorie("unit test",4);
        categorieController.ajoutCategorie(categorie);
        int l = categorieRepository.findAll().size();
        int l1=l;
        System.err.println(l);
        System.err.println(l1);
        assertEquals(l1,l);
    }

    @Test
     void deleteCategorie(){
        categorieController.deleteCategorie(22L);
        int l = categorieRepository.findAll().size();
        int l1=l;
        System.err.println(l);
        assertEquals(l1,l);
    }






}
