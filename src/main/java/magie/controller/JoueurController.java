package magie.controller;

import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import magie.entity.Joueur;
import magie.service.JoueurServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 *  @author yves ngambali
 */
@Controller
public class JoueurController {

    @Autowired
    private JoueurServiceCrud serv; // composition uml
/*
    @RequestMapping(value = "/", method = RequestMethod.POST)
   public String home() {
        serv.findAll();

    public String cookitjPOST(Joueur j, HttpSession couqui) {
        //Joueur j = (Joueur)request.getSession().setAttribute("j",valeur);
        serv.save(j);
       couqui.setAttribute("nomjj", j.getNomj()); 
        return "home.jsp";
    }
     */
    @RequestMapping(value = {"/creerjoueur"}, method = RequestMethod.POST)
    public String cookitpPOST(Joueur j, HttpSession couqui) {
        serv.save(j);
        couqui.setAttribute("nomjj", j.getId());
        return "redirect:/lister_parties";
    }
    
      @RequestMapping(value = {"/creerjoueur"}, method = RequestMethod.GET)
    public String cookitpGET(Joueur j, HttpSession couqui) {
        serv.save(j);
        couqui.setAttribute("nomjj", j.getId());
        return "redirect:/lister_parties";
    }

    @RequestMapping(value = {"/attentejoueur"}, method = RequestMethod.GET)
    public String listerattentejoueurGET(Model m,HttpSession couqui) {
       // m.addAttribute("nomjoueur", serv.findAllByOrderByIdAsc());
         m.addAttribute("nomjoueur", serv.findAll());
        couqui.getAttribute("nomjj");
        return "attenteJoueur.jsp";
        
        
    }
    
}
