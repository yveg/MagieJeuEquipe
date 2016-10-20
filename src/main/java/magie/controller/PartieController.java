/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import magie.entity.Partie;
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
    @Autowired PartieServiceCrud crud;
    @RequestMapping(value="/lister_parties", method = RequestMethod.GET)
    public String listerGET(Model model){
        List<Partie> parties = (List) crud.findAll();
        model.addAttribute("parties",parties);
        return "attentePartie.jsp";
    }
    
    @RequestMapping(value="/lancerpartie", method = RequestMethod.GET)
    public String commencerGET(Model model){
        
    return "Plateau.jsp";
    }
}
