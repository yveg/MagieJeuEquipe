package magie.controller;

import javax.servlet.http.HttpSession;
import magie.entity.Joueur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import magie.DAO.JoueurDAO;

/**
 *
 * @author yves ngambali
 */
@Controller
public class JoueurController {

    @Autowired
    private JoueurDAO serv; 

  
  
    @RequestMapping(value = "/creerjoueur", method = RequestMethod.POST)
    //public String cookitpPOST(String nomdujoueur, HttpSession couqui) {
             public String cookitpPOST() {
        Joueur j= new Joueur();
       // j.setPseudo(nomdujoueur);
       // serv.save(j);
       // couqui.setAttribute("nomjj", j.getPseudo());
        return "redirect:/lister_parties";
    }

   /* @RequestMapping(value = "/creerjoueur", method = RequestMethod.GET)
    public String cookitpGET(Joueur j, HttpSession couqui) {
        serv.save(j);
        
        return "redirect:/lister_parties";
    }
*/
    @RequestMapping(value = "/attentejoueur", method = RequestMethod.GET)
    public String listerattentejoueurGET(Model m, HttpSession couqui) {
        // m.addAttribute("nomjoueur", serv.findAllByOrderByIdAsc());
        m.addAttribute("nomjoueur", serv.findAll());
        m.addAttribute("joueuractuel", serv.findOne((Long)couqui.getAttribute("nomjj")).getPseudo());
        return "attenteJoueur.jsp";

    }

}
