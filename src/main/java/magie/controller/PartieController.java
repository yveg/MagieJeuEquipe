/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import magie.entity.Partie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import magie.DAO.IngredientDAO;
import magie.DAO.JoueurDAO;
import magie.DAO.PartieDAO;
import magie.controller.dto.PartieDemarreeDTO;
import magie.service.PartieService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author admin
 */
@Controller
public class PartieController {

    @Autowired
    private PartieService partieService;

    @Autowired
    PartieDAO crudPartie;

    @Autowired
    JoueurDAO crudJoueur;

    @Autowired
    IngredientDAO crudIngredient;

    @RequestMapping(value = "ajax_partie_demarree", method = RequestMethod.GET)
    @ResponseBody
    public PartieDemarreeDTO ajaxPartieDemarree(HttpSession session) {

        PartieDemarreeDTO dto = new PartieDemarreeDTO();

        // place dto.demarree à true si la partie est démarree
        long idPartie = (long) session.getAttribute("idPartie");
        dto.setDemarree(partieService.testPartieDemarree(idPartie));
        return dto;
    }
       
    @RequestMapping(value = "ajax_liste_joueurs_en_attente", method = RequestMethod.GET)
    public String ajaxListeJoueursEnAttente(Model model, HttpSession session) {
        long idPartie = (long) session.getAttribute("idPartie");

        model.addAttribute("joueurs", crudJoueur.findAllByPartieId(idPartie));
        //Partie p= crudPartie.findOne(idPartie);

        /*if (partieService.testPartieDemarree(idPartie)==false) {
         return "ajax_liste_joueurs_en_attente.jsp";
    }
    else {return "redirect:/plateau"; }
    }
         */
        return "ajax_liste_joueurs_en_attente.jsp";
    }

    @RequestMapping(value = "ajax_liste_parties_en_attente", method = RequestMethod.GET)
    public String ajaxListePariesEnAttente(Model model, HttpSession session) {

        List<Partie> parties = (List) crudPartie.findAllByEtatPartie(Partie.EtatPartie.EN_ATTENTE);
        Partie maPartie = new Partie();
        model.addAttribute("parties", parties);
        model.addAttribute("mapartie", maPartie);

        return "ajax_liste_parties_en_attente.jsp";
    }

    @RequestMapping(value = "/lister_parties", method = RequestMethod.GET)
    public String listerGET(Model model, HttpSession session) {

        //long idPartie = (long) session.getAttribute("idPartie");
//        List<Partie> parties = (List) crudPartie.findAllByEtatPartie(Partie.EtatPartie.EN_ATTENTE);
//        Partie maPartie = new Partie();
//        model.addAttribute("parties", parties);
//        model.addAttribute("mapartie", maPartie);
        //Partie p = crudPartie.findOne(idPartie);
        model.addAttribute("joueuractuel", crudJoueur.findOne((Long) session.getAttribute("idJoueur")).getPseudo());
        //model.addAttribute("etatPartie", p.getEtatPartie());
        //model.addAttribute("etatPartieATestee", Partie.EtatPartie.DEMARREE);
        //model.addAttribute("joueurs", crudJoueur.findAllByPartieId(idPartie));

        return "attentePartie.jsp";
    }

    @RequestMapping(value = "/rejoindre_partie", method = RequestMethod.POST)
    public String retjoindrePartiePOST(@ModelAttribute("id") Long idPartie, Model model, HttpSession session) {

        // Place idPartie en session
        session.setAttribute("idPartie", idPartie);

        // Associe joueur à la partie
        long idJoueur = (long) session.getAttribute("idJoueur");
        partieService.rejoindrePartie(idPartie, idJoueur);

        return "redirect:/attentejoueur";
    }

    @RequestMapping(value = "/plateau", method = RequestMethod.GET)
    public String plateau(Model model, HttpSession session) {
        long idPartie = (long) session.getAttribute("idPartie");

        // Renvoie vers vue
        model.addAttribute("joueuractuel", crudJoueur.findOne((Long) session.getAttribute("idJoueur")).getPseudo());
        model.addAttribute("joueurs", crudJoueur.findAllByPartieId(idPartie));
        //set la variable tour pour afficher qui a la main
        Partie p = crudPartie.findOne(idPartie);
        String a=p.getJoueurQuiALaMain().getPseudo();
        model.addAttribute("tour", a);
        return "plateau.jsp";
    }

    @RequestMapping(value = "/lancerpartie", method = RequestMethod.GET)
    public String lancerPartieGET(Model model, HttpSession session) {

        // Démarre partie
        long partieId = (long) session.getAttribute("idPartie");
        partieService.demarrerPartie(partieId);

        // model.addAttribute("tour", p.getJoueurQuiALaMain().getPseudo());
        return "redirect:/plateau";
    }

}
