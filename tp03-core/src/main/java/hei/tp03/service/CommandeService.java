package hei.tp03.service;

import hei.tp03.entity.Commande;

import java.util.List;

public interface CommandeService {

    List<Commande> findAll();

    void saveCommande(Commande commande);

    List<Commande> findByClientId(int id);
}
