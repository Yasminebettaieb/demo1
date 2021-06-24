package com.example.demo.Controller;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.services.CategorieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class CategorieController {
    private final CategorieRepository categorieRepository;
    private final ProduitController produitController;
    private final CategorieServiceImpl categorieService;

    @Autowired
    public CategorieController(CategorieRepository categorieRepository, ProduitController produitController, CategorieServiceImpl categorieService) {
        this.categorieRepository = categorieRepository;
        this.produitController = produitController;
        this.categorieService = categorieService;
    }


    @GetMapping("/categories")
    public List<Categorie> getAllcategories() {
        return categorieRepository.findAll();
    }

    @PostMapping("/categorieajout")
    public Categorie CategorieAjoutCat(@Validated @RequestBody Categorie c) {
        c.setDate_Creation(new Timestamp(System.currentTimeMillis()));
        return categorieRepository.save(c);
    }




    @GetMapping("/categories/{id}")
    public Categorie getCategoryById(@PathVariable(value = "id") long categoryId) {
        return categorieService.getCategorie(categoryId);
    }

    @DeleteMapping("/categories/{id}")
    public void DeleteCategorie(@PathVariable(value = "id") long CategoryId) {
          Categorie categorie = categorieRepository.findById(CategoryId).get();
          categorieRepository.delete(categorie);

    }

    @PutMapping("/categories/{id}")
    public Categorie updateCategorie(@RequestBody Categorie cat1, @PathVariable long id) {
        Categorie c = categorieRepository.findById(id).get();
        if (cat1.getNom_Categorie() != null)
            c.setNom_Categorie(cat1.getNom_Categorie());
        if (cat1.getQuantite_Categorie() != 0)
            c.setQuantite_Categorie(cat1.getQuantite_Categorie());
        c.setDate_Modification(new Timestamp(System.currentTimeMillis()));
        return categorieRepository.save(c);

    }
}