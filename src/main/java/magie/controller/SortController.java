/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import magie.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import magie.entity.Joueur;

/**
 *
 * @author admin
 */
@Controller
public class SortController {

    @Autowired
    private SortService sortService;

    @RequestMapping(value = "invisroute", method = RequestMethod.GET)
    public String invisibilitie(Model model, HttpSession session) {
        Joueur j = new Joueur();
        session.getId();
        long okk = (Long) session.getAttribute("idJoueur");
        sortService.invisibilitie(okk);
        return "testSort.jsp";
    }

}
