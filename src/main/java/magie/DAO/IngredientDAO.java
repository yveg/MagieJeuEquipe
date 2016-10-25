/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.DAO;

import java.util.List;
import magie.entity.Ingredient;
import magie.entity.Joueur;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface IngredientDAO extends CrudRepository<Ingredient, Long>{
    public List<Ingredient> findOneByJoueurId(Long id);
    public List<Ingredient> findAllByJoueurId(Long id);

    public List<Ingredient> findAllByJoueurIdAndTypeIngredient(long joueurlance, Ingredient.TypeIngredient typeIngredient);

    public List<Ingredient> findAllByJoueurId(long joueurvectime);

    public List<Ingredient> findAllByJoueurIdAndTypeIngredient(Joueur joueurlance, Ingredient.TypeIngredient typeIngredient);
        
    
            
    
}
