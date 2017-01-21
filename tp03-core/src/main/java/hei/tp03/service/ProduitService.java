package hei.tp03.service;

import hei.tp03.entity.Produit;

import java.util.List;

public interface ProduitService {

    List<Produit> findAll();

    void saveProduit(Produit produit);

    List<Produit> findByCommandeId(int id);
}
