package hei.tp03.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

// Création d'un id pour chaque entité héritant de cette classe
// Chaque entité = un nouvel id
@MappedSuperclass
public class Identite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }
}
