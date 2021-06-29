package com.example.demo;

import com.example.demo.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {
    @Autowired
    private ProduitRepository produitRepository;




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

    produitRepository.deleteById(29L);
    assertEquals(2,produitRepository.findAll().size());

    }

    @Test
    public void testFindAllProduits()
    {


    }


}
