package magie.controller;

import javax.servlet.http.HttpSession;
import magie.entity.Joueur;
import magie.service.JoueurServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author yves ngambali
 */
@Controller
public class JoueurController {

    @Autowired
    private JoueurServiceCrud serv; 

  
  
    @RequestMapping(value = "/creerjoueur", method = RequestMethod.POST)
    public String cookitpPOST(String nomdujoueur, HttpSession couqui) {
        Joueur j= new Joueur();
        j.setPseudo(nomdujoueur);
        serv.save(j);
        couqui.setAttribute("nomjj", j.getId());
        return "redirect:/lister_parties";
    }

    @RequestMapping(value = "/creerjoueur", method = RequestMethod.GET)
    public String cookitpGET(Joueur j, HttpSession couqui) {
        serv.save(j);
        couqui.setAttribute("nomjj", j.getId());
        return "redirect:/lister_parties";
    }

    @RequestMapping(value = "/attentejoueur", method = RequestMethod.GET)
    public String listerattentejoueurGET(Model m, HttpSession couqui) {
        // m.addAttribute("nomjoueur", serv.findAllByOrderByIdAsc());
        m.addAttribute("nomjoueur", serv.findAll());
        couqui.getAttribute("nomjj");
        return "attenteJoueur.jsp";

    }

}
