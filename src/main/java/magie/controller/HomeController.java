/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import magie.entity.Joueur;
import magie.service.JoueurServiceCrud;
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
    
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String maison (Model m) {
        m.addAttribute("titre", "Jeu de Magie entre Sorciers");
        m.addAttribute("joueur",new Joueur());
        return "home.jsp"; 
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST) 
    public String maison (@ModelAttribute("newjoueur") Joueur j) {
        serv.save(j);
        return "redirect:/lister_parties"; 
    }
}
