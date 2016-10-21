/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import javax.servlet.http.HttpSession;
import magie.entity.Joueur;
import magie.entity.Partie;
import magie.service.JoueurServiceCrud;
import magie.service.PartieServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author yves ngambali
 */
@Controller
public class HomeController {
    
    @Autowired
    private JoueurServiceCrud serv;
    @Autowired
    private PartieServiceCrud crudPartie;
    
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String maison (Model m) {
        m.addAttribute("titre", "Jeu de Magie entre Sorciers");
        m.addAttribute("joueur",new Joueur());
        if(crudPartie.count() == 0){
            Partie partie = new Partie();
            partie.setNom("Parite magiemagie");
            crudPartie.save(partie);
        }
        return "home.jsp"; 
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST) 
    public String maison (@ModelAttribute("newjoueur") Joueur j,HttpSession session) {
        j.setRevelation(false);
        j.setTour((int)serv.count()+1);
        serv.save(j);
        session.setAttribute("nomjj", j.getId());
        return "redirect:/lister_parties"; 
    }
}

