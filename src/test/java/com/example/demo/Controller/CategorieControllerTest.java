package com.example.demo.Controller;

import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CategorieControllerTest {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;

    @Test
    void getAllcategories() {
    }

    @Test
    void categorieAjoutCat() {
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void deleteCategorie() {
    }

    @Test
    void updateCategorie() {
    }
}