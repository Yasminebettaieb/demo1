package com.example.demo.Controller;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.services.ProduitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/")
public class ProduitController {
    @Autowired
    public ProduitController(ProduitRepository produitRepository, CategorieRepository categorieRepository, ProduitServiceImpl produitService) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
        this.produitService = produitService;
    }

    private final  ProduitRepository produitRepository;
    private  final  CategorieRepository categorieRepository;
    private final ProduitServiceImpl produitService;

    @GetMapping("/produits")
    public List<Produit> getAllProducts(){
        return  produitRepository.findAll();
    }
    @PostMapping("/produits/{id}")
    public Produit ajoutProduit( @RequestBody Produit produit ,@PathVariable(value = "id") long idcat) {
         if (categorieRepository.findById(idcat).isPresent()) {
            Categorie var = categorieRepository.findById(idcat).get();
            produit.setDate_Creation(new Timestamp(System.currentTimeMillis()));
             List <Produit> p =var.getProduits();
             p.add(produit);
             produit.setCategorie(var);
            return produitRepository.save(produit);
        }
        else return null;
    }
    @GetMapping("/produits/{id}")
    public Produit getProduitbyId(@PathVariable(value = "id") long produitid) {
        return produitService.getProduit(produitid);
    }
    @DeleteMapping("/produits/{id}")
    public void deleteProduit (@PathVariable (value = "id" ) long produitid) {
        produitService.deleteProduitById(produitid);
    }
    @PutMapping("/produits/{id}")
    public Produit updateProduit(@RequestBody  Produit p1, @PathVariable long id) {
        if(produitRepository.findById(id).isPresent()){
        Produit p = produitRepository.findById(id).get();
        if (p1.getNom_Produit() != null)
            p.setNom_Produit(p1.getNom_Produit());

        if (p1.getQuantite_Produit() != 0)
            p.setQuantite_Produit(p1.getQuantite_Produit());
        if (p1.getDisponible() != null)
            p.setDisponible(p1.getDisponible());
        p.setDate_Modification(new Timestamp(System.currentTimeMillis()));
        return produitRepository.save(p);}
        else return  null;
    }
}
