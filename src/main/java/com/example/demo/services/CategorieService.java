package com.example.demo.services;

import com.example.demo.entities.Produit;

import java.util.List;
import com.example.demo.entities.Categorie;
import com.example.demo.repository.CategorieRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieService  {

        Categorie saveCategorie(Categorie c);
        void DeleteCategorie(long id);
        Categorie getCategorie(long id);
        List<Categorie> getAllCatergories();

    }


