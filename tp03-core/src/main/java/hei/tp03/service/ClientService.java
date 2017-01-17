package hei.tp03.service;

import hei.tp03.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientService{

    List<Client> findByNom(String nom);

    void saveClient(Client client);

    List<Client> findAll();


}
