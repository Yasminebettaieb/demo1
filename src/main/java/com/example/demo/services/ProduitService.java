package com.example.demo.services;
import com.example.demo.entities.Produit;


public interface ProduitService {
    Produit updateProduit(Produit p, long id);
    void deleteProduitById(long id);
    Produit getProduit(long id);

}
