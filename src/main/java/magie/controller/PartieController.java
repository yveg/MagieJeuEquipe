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
    @Autowired PartieServiceCrud crudPartie;
    @Autowired JoueurServiceCrud crudJoueur;
    @Autowired IngredientServiceCrud crudIngredient;
    
    @RequestMapping(value="/lister_parties", method = RequestMethod.GET)
    public String listerGET(Model model){
        List<Partie> parties = (List) crudPartie.findAll();
        model.addAttribute("parties",parties);
        return "attentePartie.jsp";
    }
    
    @RequestMapping(value="/lancerpartie", method = RequestMethod.GET)
    public String commencerGET(Model model, HttpSession cookie){
        List<Joueur> joueurs = (List) crudJoueur.findAll();
        List<Ingredient> ingredients = new ArrayList<>();
        for(int indiceJoueur = 0; indiceJoueur < crudJoueur.count(); indiceJoueur++){
            for(int indiceIngredient = 0; indiceIngredient < 7; indiceIngredient++){
                ingredients.add(new Ingredient());
                
            }
            joueurs.get(indiceJoueur).setIngredients(ingredients);
            //crudIngredients.save(ingredients.get(indiceIngredient));
            crudJoueur.save(joueurs.get(indiceJoueur));
            
        
        }   
        model.addAttribute("joueurs", crudJoueur.findAll());
        model.addAttribute("joueuractuel", crudJoueur.findOne((Long)cookie.getAttribute("nomjj")).getPseudo());
        return "plateau.jsp";
    }
}
