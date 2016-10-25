/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.DAO;

import magie.entity.Partie;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface PartieDAO extends CrudRepository<Partie, Long>{

    public int countByEtatPartie(Partie.EtatPartie etatPartie);
    
}
