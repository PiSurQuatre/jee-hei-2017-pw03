package hei.tp03.service.impl;

import hei.tp03.dao.ClientDAO;
import hei.tp03.entity.Client;
import hei.tp03.service.ClientService;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Transactional
public class ClientServiceImpl implements ClientService {

    @Inject
    private ClientDAO clientDAO;

    @Override
    public List<Client> findByNom(String nom) {
        return clientDAO.findByNom(nom);
    }

    @Override
    public void saveClient(Client client) {
        clientDAO.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientDAO.findAll();
    }


}
