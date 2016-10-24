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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import magie.DAO.IngredientDAO;
import magie.DAO.JoueurDAO;
import magie.DAO.PartieDAO;

/**
 *
 * @author admin
 */
@Controller
public class PartieController {
    @Autowired PartieDAO crudPartie;
    @Autowired JoueurDAO crudJoueur;
    @Autowired IngredientDAO crudIngredient;
    
    @RequestMapping(value="/lister_parties", method = RequestMethod.GET)
    public String listerGET(Model model, HttpSession cookie){
        if(crudPartie.count() == 0){
            Partie partie = new Partie();
            partie.setNom("Parite magiemagie");
            partie.setTourJoueur(0);
            crudPartie.save(partie);
        }
        List<Partie> parties = (List) crudPartie.findAll();
        Partie maPartie = new Partie();
        model.addAttribute("parties",parties);
        model.addAttribute("mapartie",maPartie);
        model.addAttribute("joueuractuel", crudJoueur.findOne((Long)cookie.getAttribute("nomjj")).getPseudo());
        return "attentePartie.jsp";
    }
    
    @RequestMapping(value="/lister_parties", method = RequestMethod.POST)
    public String listerPOST(@ModelAttribute("id") Long idPartie,Model model){
        crudIngredient.deleteAll();
        if(crudIngredient.count() == 0)
        {
            List<Joueur> joueurs = (List) crudJoueur.findAll();
            for(int indiceJoueur = 0; indiceJoueur < crudJoueur.count(); indiceJoueur++){
                List<Ingredient> ingredients = new ArrayList<>();
                for(int indiceIngredient = 0; indiceIngredient < 7; indiceIngredient++){
                    Ingredient ingredient = new Ingredient();
                    ingredients.add(ingredient);
                    ingredient.setJoueur(joueurs.get(indiceJoueur));            
                    crudIngredient.save(ingredient);
                }
               
                joueurs.get(indiceJoueur).setPartie(crudPartie.findOne(idPartie));
                crudJoueur.save(joueurs.get(indiceJoueur));
            }   
    }
        return "redirect:/attentejoueur";
    }
    
    @RequestMapping(value="/lancerpartie", method = RequestMethod.GET)
    public String commencerGET( Model model, HttpSession cookie){
            //List<Joueur> joueurs = (List) crudJoueur.findAll();
           /* List<Joueur> j;
            j.get(id);
*/
            model.addAttribute("joueurs", crudJoueur.findAll());
            model.addAttribute("ingredients", crudIngredient.findAll());
            model.addAttribute("un_ingredients_par_j", crudIngredient.findOneByJoueurId(Long.MIN_VALUE));
            model.addAttribute("tous_ingredients_par_j", crudIngredient.findAllByJoueurId(Long.MIN_VALUE));
            model.addAttribute("joueuractuel", crudJoueur.findOne((Long)cookie.getAttribute("nomjj")).getPseudo());
            model.addAttribute("tour", 0);
    return "plateau.jsp";    
    }
       
 
}
