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
    public Produit AjoutproduitCat( @RequestBody Produit produit ,@PathVariable(value = "id") long idcat) {
        {   Categorie categorie = categorieRepository.findById(idcat).get();
            produit.setDate_Creation(new Timestamp(System.currentTimeMillis()));
             List <Produit> p =categorie.getProduits();
             p.add(produit);
             produit.setCategorie(categorie);
            return produitRepository.save(produit);
        }
    }
    @GetMapping("/produits/{id}")
    public Produit getProduitbyId(@PathVariable(value = "id") long Produitid) {
        return produitService.getProduit(Produitid);
    }
    @DeleteMapping("/produits/{id}")
    public void DeleteProduit (@PathVariable (value = "id" ) long Produitid) {
        produitService.deleteProduitById(Produitid);
    }
    @PutMapping("/produits/{id}")
    public Produit updateProduit(@RequestBody  Produit p1, @PathVariable long id) {
        Produit p = produitRepository.findById(id).get();
        if (p1.getNom_Produit() != null)
            p.setNom_Produit(p1.getNom_Produit());

        if (p1.getQuantite_Produit() != 0)
            p.setQuantite_Produit(p1.getQuantite_Produit());
        if (p1.getDisponible() != null)
            p.setDisponible(p1.getDisponible());
        p.setDate_Modification(new Timestamp(System.currentTimeMillis()));
        return produitRepository.save(p);


    }
}
