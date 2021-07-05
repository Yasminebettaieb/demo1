package com.example.demo.services;

import com.example.demo.entities.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie saveCategorie(Categorie c);

    void DeleteCategorie(long id);

    Categorie getCategorie(long id);

    List<Categorie> getAllCatergories();

}


