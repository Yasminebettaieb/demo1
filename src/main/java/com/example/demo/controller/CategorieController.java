package com.example.demo.controller;

import com.example.demo.entities.Categorie;
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
    private final CategorieServiceImpl categorieService;

    @Autowired
    public CategorieController(CategorieRepository categorieRepository,   CategorieServiceImpl categorieService) {
        this.categorieRepository = categorieRepository;
        this.categorieService = categorieService;
    }


    @GetMapping("/categories")
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @PostMapping("/categorieajout")
    public Categorie ajoutCategorie(@Validated @RequestBody Categorie c) {

        c.setDate_Creation(new Timestamp(System.currentTimeMillis()));
        return categorieRepository.save(c);
    }




    @GetMapping("/categories/{id}")
    public Categorie getCategoryById(@PathVariable(value = "id") long categoryId) {
        return categorieService.getCat(categoryId);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategorie(@PathVariable(value = "id") long cat) {
        if (categorieRepository.findById(cat).isPresent()) {
            var c = categorieRepository.findById(cat).get();
            categorieRepository.delete(c);
        }

    }

    @PutMapping("/categories/{id}")
    public Categorie updateCategorie(@RequestBody Categorie cat1, @PathVariable long id) {
        if (categorieRepository.findById(id).isPresent()) {
            Categorie c = categorieRepository.findById(id).get();
            if (cat1.getNomCategorie() != null)
                c.setNomCategorie(cat1.getNomCategorie());
            if (cat1.getQuantiteCategorie() != 0)
                c.setQuantiteCategorie(cat1.getQuantiteCategorie());
            c.setDate_Modification(new Timestamp(System.currentTimeMillis()));
            return categorieRepository.save(c);

        } else return null;
    }
}