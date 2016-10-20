/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import magie.service.JoueurServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author yves ngambali
 */
public class PlateauController {

    @Autowired
    private JoueurServiceCrud serv;

    @RequestMapping(value = "/plateauroute", method = RequestMethod.POST)
    //public String cookitpPOST(String nomdujoueur, HttpSession couqui) {
    public String jeuencoursPOST() {
       // Joueur j = new Joueur();
        // j.setPseudo(nomdujoueur);
        // serv.save(j);
        // couqui.setAttribute("nomjj", j.getPseudo());
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