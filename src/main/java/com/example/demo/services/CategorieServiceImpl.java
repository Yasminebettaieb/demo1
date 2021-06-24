package com.example.demo.services;

import com.example.demo.entities.Categorie;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieServiceImpl implements CategorieService {
    private CategorieRepository categorieRepository;
    private ProduitRepository produitRepository;
@Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository,ProduitRepository produitRepository) {
        this.categorieRepository = categorieRepository;
        this.produitRepository=produitRepository;
    }


    @Override
    public Categorie saveCategorie(Categorie c) {
        return  categorieRepository.save(c);
    }





    public void DeleteCategorie(long id) {
        categorieRepository.deleteById(id);

    }

    @Override
    public Categorie getCategorie(long id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public List<Categorie> getAllCatergories() {
        return categorieRepository.findAll();
    }
}