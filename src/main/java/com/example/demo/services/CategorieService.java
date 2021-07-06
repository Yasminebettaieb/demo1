package com.example.demo.services;

import com.example.demo.entities.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie saveCategorie(Categorie c);

    void deleteCategorie(long id);


    List<Categorie> getAllCatergories();

}


