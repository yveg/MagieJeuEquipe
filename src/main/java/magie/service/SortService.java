/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.service;

import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.List;
import magie.DAO.IngredientDAO;
import magie.DAO.JoueurDAO;
import magie.entity.Ingredient;
import magie.entity.Joueur;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
public class SortService {
    
    
  @Autowired JoueurDAO crudJoueur;
  @Autowired IngredientDAO crudIngredients; 
  
private JoueurDAO crudSort;
  
  
    
  public void invisibilitie(Long joueurlance, Long vectime ){
      
   List<Joueur> joueurs = (List) crudJoueur.findAll();
   
      List<Ingredient> ingredients =(List) joueurs.get(0).getIngredients() ;
     Math.floor(Math.random()*7);
     
      //ingredients.add(floor(Math.random()*7));
      
      
      
      
          ingredients.addAll(ingredients);
                  crudJoueur.findOne(1L).getIngredients();
           
      
       
       
         
          
         
     
  }
    
    
    
    
    
    
    
    
    
    
    
}
