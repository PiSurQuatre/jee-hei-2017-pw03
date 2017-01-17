package hei.tp03.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by pic on 17/01/2017.
 */
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Boolean validee;

    private Client client;

    private List<Produit> produits;

    public Commande() {}

    public Commande(Client client)
    {
        this.client = client;
    }

    public Boolean getValidee() {
        return validee;
    }

    public void setValidee(Boolean validee) {
        this.validee = validee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
