package hei.tp03.service.impl;

import hei.tp03.dao.ProduitDAO;
import hei.tp03.entity.Produit;
import hei.tp03.service.ProduitService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class ProduitServiceImpl implements ProduitService{

    @Inject
    private ProduitDAO produitDAO;

    @Override
    public List<Produit> findAll() {
        return produitDAO.findAll();
    }

    @Override
    public void saveProduit(Produit produit) { produitDAO.save(produit); }

    @Override
    public List<Produit> findByCommandeId(int id) {
        return produitDAO.findByCommandeId(id);
    }
}
