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
    
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String maison (Model m) {
        m.addAttribute("titre", "Jeu de Magie entre Sorciers");
        m.addAttribute("joueur",new Joueur());
        return "home.jsp"; 
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST) 
    public String maison (@ModelAttribute("joueur") Joueur j,HttpSession session) {
        j.setRevelation(false);
        j.setTour((int)serv.count()+1);
        serv.save(j);
        session.setAttribute("nomjj", j.getId());
        return "redirect:/lister_parties"; 
    }
}

