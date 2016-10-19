/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author yves ngambali
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET) 
    public String maison (Model m) {
        m.addAttribute("titre", "Jeu de Magie entre Sorciers");
        return "home.jsp"; 
    }
}
