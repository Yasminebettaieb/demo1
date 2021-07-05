package com.example.demo.services;
import com.example.demo.entities.Produit;

import java.util.List;

public interface ProduitService {
    Produit saveProduit(Produit p);

    Produit updateProduit(Produit p, long id);

    void deleteProduit(Produit p);

    void deleteProduitById(long id);

    Produit getProduit(long id);

    List<Produit> getAllProduits();

}
