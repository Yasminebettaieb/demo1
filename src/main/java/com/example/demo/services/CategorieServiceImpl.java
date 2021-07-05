package com.example.demo.services;

import com.example.demo.entities.Categorie;
import com.example.demo.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategorieServiceImpl implements CategorieService {
    private CategorieRepository categorieRepository;

    public CategorieServiceImpl() {
    }

    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }


    @Override
    public Categorie getCategorie(long id) {
        if (categorieRepository.findById(id).isPresent())
            return categorieRepository.findById(id).get();
        else return null;
    }

}