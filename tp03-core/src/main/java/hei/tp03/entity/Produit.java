package hei.tp03.entity;

import javax.persistence.*;

/**
 * Created by pic on 17/01/2017.
 */
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nom;

    @ManyToOne
    private Commande commande;

    public Produit() {}

    public Produit(String nom, Commande commande)
    {
        this.nom = nom;
        this.commande = commande;
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
