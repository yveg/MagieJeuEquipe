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

    @Autowired
    JoueurDAO crudJoueur;
    @Autowired
    IngredientDAO crudIngredients;

    private JoueurDAO crudSort;
    private IngredientDAO crudIng;

    public void invisibilitie(long joueurlance) {

        // Verifie qu'on possède bien : bave de crapaud + corne licorne
        List<Ingredient> bavesCrapaud = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.BAVE_CRAPAUD);
        List<Ingredient> cornesLicorne = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.CORNE_LICORNE);
        if( bavesCrapaud.size()==0 || cornesLicorne.size()==0 ){
            throw new RuntimeException("Pas de cartes pour lancer ce sort");
        }
        
        // Déduit ma bave de crapaud et ma corne de licorne de mes ingredients
        crudIngredients.delete(bavesCrapaud.get(0));
        crudIngredients.delete(cornesLicorne.get(0));
        
        // Recupere ts joueurs
        List<Joueur> joueurs = (List) crudJoueur.findAll();

        // Récupère joueur destination
        Joueur moi = crudJoueur.findOne(joueurlance);

        // Récupérer une carte chez chaque joueur
        for(Joueur joueur : joueurs){
            
            if(joueur.getId()!=moi.getId() && joueur.getIngredients().size()>=1){
                
                Ingredient ingredientARecuperer = joueur.getIngredients().get(0);
                
                joueur.getIngredients().remove(ingredientARecuperer);
                moi.getIngredients().add(ingredientARecuperer);
                ingredientARecuperer.setJoueur(moi);
                
                crudIngredients.save(ingredientARecuperer);
            }
        }
        
        
       

    }

}
