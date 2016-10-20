/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import magie.service.PartieServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author admin
 */




@Controller
public class SortController {
    
    
    @Autowired 
     private PartieServiceCrud aaa;
    
    
    @RequestMapping(value = "/INVISIBILITE",method = RequestMethod.POST)
   public String invisibilitePOST(Long joueurlance ,Long joueurvectime){
       
       
   }
    
    
    
    
    
    
    
}
