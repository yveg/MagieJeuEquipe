/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.service;

import java.io.Serializable;
import java.util.List;
import magie.entity.Joueur;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author yves ngambali
 */
public interface JoueurServiceCrud extends CrudRepository<Joueur, Long>{
     public List<Joueur> findAllByOrderByIdAsc();
}
