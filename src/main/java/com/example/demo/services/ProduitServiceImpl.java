package com.example.demo.services;
import com.example.demo.entities.Produit;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService{

    private  final ProduitRepository produitRepository ;
   @Autowired
    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit saveProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public Produit updateProduit(Produit p, long id) {
      if(produitRepository.findById(id).isPresent()){
          Produit p1 =produitRepository.findById(id).get();
       if(p.getNom_Produit() != null)
           p1.setNom_Produit(p.getNom_Produit());
       if(p.getQuantite_Produit() != 0)
           p1.setQuantite_Produit(p.getQuantite_Produit());
       if(p.getDisponible() != null )
           p1.setDisponible(p.getDisponible());
           p1.setDate_Modification(new Timestamp(System.currentTimeMillis()));
            return produitRepository.save(p1);}
      else return  null;
        }


    @Override
    public void deleteProduit(Produit p) {
  produitRepository.delete(p);
    }


    public void deleteProduitById(long id) {
produitRepository.deleteById(id);
    }


    public Produit getProduit(long id) {
       if(produitRepository.findById(id).isPresent())
       return produitRepository.findById(id).get();
       else
           return null;
    }

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }
}
