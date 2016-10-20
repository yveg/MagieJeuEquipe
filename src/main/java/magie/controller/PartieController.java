/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import magie.entity.Ingredient;
import magie.entity.Joueur;
import magie.entity.Partie;
import magie.service.IngredientServiceCrud;
import magie.service.JoueurServiceCrud;
import magie.service.PartieServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */
@Controller
public class PartieController {
    @Autowired PartieServiceCrud crudParties;
    @Autowired JoueurServiceCrud crudJoueurs;
    @Autowired IngredientServiceCrud crudIngredients;
    
    @RequestMapping(value="/lister_parties", method = RequestMethod.GET)
    public String listerGET(Model model){
        List<Partie> parties = (List) crudParties.findAll();
        model.addAttribute("parties",parties);
        return "attentePartie.jsp";
    }
    
    @RequestMapping(value="/lancerpartie", method = RequestMethod.GET)
    public String commencerGET(Model model){
        List<Joueur> joueurs = (List) crudJoueurs.findAll();
        List<Ingredient> ingredients = new ArrayList<>();
        for(int indiceJoueur = 0; indiceJoueur < crudJoueurs.count(); indiceJoueur++){
            for(int indiceIngredient = 0; indiceIngredient < 7; indiceIngredient++){
                ingredients.add(new Ingredient());
                crudIngredients.save(ingredients.get(indiceIngredient));
            }
            joueurs.get(indiceJoueur).setIngredients(ingredients);
            crudJoueurs.save(joueurs.get(indiceJoueur));
        }   
    return "plateau.jsp";
    }
}
