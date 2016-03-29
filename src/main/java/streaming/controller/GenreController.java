/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import streaming.entity.Genre;
import streaming.service.GenreCrudService;

/**
 *
 * @author tom
 */
@Controller
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreCrudService genreCrudService;
    
    @RequestMapping(value="ajouter", method = RequestMethod.GET)
    public String ajouter(Model m){
        
        m.addAttribute("genre", new Genre());
        
        return "genre/ajouter";
    }
    
    @RequestMapping(value = "lister", method = RequestMethod.GET)
    public String lister(Model m){
        
        m.addAttribute("genres", genreCrudService.findAll());
        
        return "genre/lister";
    }
}
