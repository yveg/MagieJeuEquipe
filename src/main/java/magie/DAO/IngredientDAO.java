/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.DAO;

import magie.entity.Ingredient;
import magie.entity.Joueur;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface IngredientDAO extends CrudRepository<Ingredient, Long>{
    
}
