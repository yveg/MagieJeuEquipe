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
 * @author admin
 */
@Controller
public class JoueurController {

    @Autowired
    private JoueurServiceCrud serv; // composition uml

    @RequestMapping(value = "/", method = RequestMethod.POST)
    /*public String home() {
        serv.findAll();
*/
    public String cookitPOST(Joueur j, HttpSession couqui) {
        //Joueur j = (Joueur)request.getSession().setAttribute("j",valeur);
        serv.save(j);
       couqui.setAttribute("nomjj", j.getNomj());
        return "home.jsp";
    }

    @RequestMapping(value = {"/attentejoueur"}, method = RequestMethod.GET)
    public String listerattentejoueurGET(Model m) {
        m.addAttribute("nomjoueur", serv.findAllByOrderByIdAsc());
        return "attenteJoueur.jsp";
    }

    @RequestMapping(value = {"/attentejoueur"}, method = RequestMethod.GET)
    public String cookitGET(HttpSession couqui) {
        couqui.getAttribute("nomjj");
        return "home.jsp";
    }

}
