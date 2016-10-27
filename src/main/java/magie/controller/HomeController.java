/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import javax.servlet.http.HttpSession;
import magie.entity.Joueur;
import magie.entity.Partie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import magie.DAO.JoueurDAO;
import magie.DAO.PartieDAO;
import magie.service.PartieService;

/**
 *
 * @author yves ngambali
 */
@Controller
public class HomeController {
    
    @Autowired
    private JoueurDAO serv;
    @Autowired
    private PartieDAO crudPartie;
    @Autowired
    private PartieService partieService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String maison (Model m) {
        m.addAttribute("titre", "Jeu de Magie entre Sorciers");
        m.addAttribute("joueur",new Joueur());
        m.addAttribute("joueurs",serv.findAll());
        return "home.jsp"; 
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST) 
    public String maison (@ModelAttribute("joueur") Joueur joueur,HttpSession session, Model model) {
            boolean test = partieService.testPseudoValide(joueur.getPseudo());
            // Teste si pseudo valide
            if(test == false){
                model.addAttribute("msgErreur", "Pseudo déjà existant ou non valide!");
                return maison(model);
            }
        
            // Pseudo non valide
            
            // Persiste le joueur
            joueur.setRevelation(false);
            serv.save(joueur);
            session.setAttribute("idJoueur", joueur.getId());
            
            return "redirect:/lister_parties";
    }
}

