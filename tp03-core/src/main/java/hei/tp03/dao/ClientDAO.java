package hei.tp03.dao;

import hei.tp03.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//Data Access Object Client
public interface ClientDAO extends JpaRepository<Client, Long>
{
    List<Client> findByNom(String nom);
    List<Client> findByPrenom(String prenom);
}
