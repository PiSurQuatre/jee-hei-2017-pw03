package hei.tp03.dao;

import hei.tp03.entity.Commande;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Data Access Object Commande
public interface CommandeDAO extends JpaRepository<Commande, Long>
{
    List<Commande> findAll();
    List<Commande> findByClientId(int id);
}
