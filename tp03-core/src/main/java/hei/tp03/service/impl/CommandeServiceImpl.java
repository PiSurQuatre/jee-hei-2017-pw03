package hei.tp03.service.impl;

import hei.tp03.dao.CommandeDAO;
import hei.tp03.entity.Commande;
import hei.tp03.service.CommandeService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class CommandeServiceImpl implements CommandeService{

    @Inject
    private CommandeDAO commandeDAO;

    @Override
    public List<Commande> findAll() {
        return commandeDAO.findAll();
    }

    @Override
    public void saveCommande(Commande commande) { commandeDAO.save(commande); }

    @Override
    public List<Commande> findByClientId(int id) {
        return commandeDAO.findByClientId(id);
    }
}
