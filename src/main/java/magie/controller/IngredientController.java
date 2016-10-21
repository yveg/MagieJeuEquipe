/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import magie.DAO.PartieDAO;

/**
 *
 * @author admin
 */




@Controller
public class IngredientController {
    
    
    @Autowired 
     private PartieDAO aaa;
    
    
    @RequestMapping(value = "/invisibilitie",method = RequestMethod.POST)
   public String invisibilitePOST(Long joueurlance ,Long joueurvectime){
       
     return "ds";
   }
    
    
    
    
    
    
    
}
