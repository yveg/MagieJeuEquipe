/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import javax.servlet.http.HttpSession;
import magie.DAO.JoueurDAO;
import magie.entity.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author yves ngambali
 */
@Controller
public class PlateauController {

    @Autowired
    private JoueurDAO dao;
    
     @RequestMapping(value = "/ajax_zone_menuactionj", method = RequestMethod.GET)
    public String ajax_zone_menuactionjGET(Model model, HttpSession session){
        long idPartie = (long) session.getAttribute("idPartie");
        
        Joueur joueurAct = dao.findOne( (long) session.getAttribute("idJoueur") );
        //model.addAttribute("ingredientsJoueurAct", joueurAct.getIngredients() );
        model.addAttribute("joueurs", dao.findAllByPartieId(idPartie)); 
        model.addAttribute("joueuractuel", dao.findOne((Long) session.getAttribute("idJoueur")).getPseudo());

        return "ajax_zone_menuactionj.jsp";
    }
    

    @RequestMapping(value = "/ajax_zone_eventinfo", method = RequestMethod.GET)
    public String ajax_zone_eventinfoGET(Model model, HttpSession session){
        long idPartie = (long) session.getAttribute("idPartie");
        
        Joueur joueurAct = dao.findOne( (long) session.getAttribute("idJoueur") );
        //model.addAttribute("ingredientsJoueurAct", joueurAct.getIngredients() );
        model.addAttribute("joueurs", dao.findAllByPartieId(idPartie)); 
        model.addAttribute("joueuractuel", dao.findOne((Long) session.getAttribute("idJoueur")).getPseudo());

        return "ajax_zone_eventinfo.jsp";
    }

    @RequestMapping(value = "/ajax_zone_autrej", method = RequestMethod.GET)
    public String ajax_zone_autrejGET(Model model, HttpSession session){
        long idPartie = (long) session.getAttribute("idPartie");
        
        Joueur joueurAct = dao.findOne( (long) session.getAttribute("idJoueur") );
        //model.addAttribute("ingredientsJoueurAct", joueurAct.getIngredients() );
        model.addAttribute("joueurs", dao.findAllByPartieId(idPartie)); 
        model.addAttribute("joueuractuel", dao.findOne((Long) session.getAttribute("idJoueur")).getPseudo());

        return "ajax_zone_autrej.jsp";
    }
    
       @RequestMapping(value = "/ajax_zone_cartes_joueur_act", method = RequestMethod.GET)
    public String ajaxZoneCartesJoueurAct(Model model, HttpSession session){
        
        Joueur joueurAct = dao.findOne( (long) session.getAttribute("idJoueur") );
        model.addAttribute("ingredientsJoueurAct", joueurAct.getIngredients() );
        
        return "ajax_zone_cartes_joueur_act.jsp";
    }
    
    @RequestMapping(value = "/plateauroute", method = RequestMethod.POST)
    //public String cookitpPOST(String nomdujoueur, HttpSession couqui) {
    public String jeuencoursPOST() {
       // Joueur j = new Joueur();
        // j.setPseudo(nomdujoueur);
        // serv.save(j);
        // couqui.setAttribute("idJoueur", j.getPseudo());
        return "plateau.jsp";
    }

    @RequestMapping(value = "/plateauroute", method = RequestMethod.GET)
    public String jeuencoursGET() {
        //obtenir qui a la tour
        //obtenir qui a un sort
        //obtenir qui a une carte selectionnée
        //obtenir quel joueura a ete selectionne par joueurb
        //obtenir le nb de carte en fonction de chaque joueur
        return "plateau.jsp";
    }
}