package com.example.demo;

import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private CategorieRepository categorieRepository;



    @Test
    public void testFindProduit(){



    }
    @Test
    public void testUpdateProduit()
    {

    }
    @Test
    public void testDeleteProduit()
    {

    produitRepository.deleteById(1L);

    }

    @Test
    public void testFindAllProduits()
    {


    }


}
