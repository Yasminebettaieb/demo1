package com.example.demo;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import org.apache.catalina.Store;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;



    @Test
    public void testFindProduit(){
        Produit p = produitRepository.findById(1L).get();
        System.out.println(p);

    }
    @Test
    public void testUpdateProduit()
    {
        Produit p =produitRepository.findById(1L).get();
        p.setNom_Produit("pc");
        produitRepository.save(p);
    }
    @Test
    public void testDeleteProduit()
    {
    produitRepository.deleteById(1L);
    }
    @Test
    public void testFindAllProduits()
    {
        List<Produit> prods =produitRepository.findAll();
        for(Produit p: prods)
            System.out.println(p);
    }


}
