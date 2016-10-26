/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import magie.DAO.IngredientDAO;
import magie.DAO.JoueurDAO;
import magie.DAO.PartieDAO;
import magie.entity.Ingredient;
import magie.entity.Joueur;
import magie.entity.Partie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class PartieService {

    @Autowired
    PartieDAO crudPartie;

    @Autowired
    JoueurDAO crudJoueur;

    @Autowired
    IngredientDAO crudIngredient;

    
    public void definirTourSuivant(long idPartie){
        // récupere la partie en cours
        Partie partie = crudPartie.findOne(idPartie);
        // recupere le tour en cours et passe au suivant
        int tour = partie.getJoueurQuiALaMain().getTour() + 1;
        if(tour > partie.getJoueurs().size()) tour = 1;
        //recuere joueur de ce nouveau tour
        Joueur joueur = crudJoueur.fineOneByTour(tour);
        // test si le joueur n'est pas sous le sort de sommeil profond
        while(joueur.getSommeilProfond() != 0){
            // si oui, déduit les tours à passer et passe au joueur suivant
            joueur.setSommeilProfond(joueur.getSommeilProfond()-1);
            crudJoueur.save(joueur);
            tour++;
            if(tour > partie.getJoueurs().size()) tour = 1;
            joueur = crudJoueur.fineOneByTour(tour);    
        };
        // actualise dans la partie en cours le joueur qui a la main
        partie.setJoueurQuiALaMain(joueur);
        crudPartie.save(partie);
    }
    
    public void rejoindrePartie(long idPartie, long idJoueur) {

        Partie partie = crudPartie.findOne(idPartie);
        Joueur joueur = crudJoueur.findOne(idJoueur);
        joueur.setPartie(partie);
        partie.getJoueurs().add(joueur);

        crudPartie.save(partie);
        crudJoueur.save(joueur);
    }

    public void demarrerPartie(long partieId) {

        // Récup partie et mise en DEMARREE
        Partie partie = crudPartie.findOne(partieId);
        partie.setEtatPartie(Partie.EtatPartie.DEMARREE);
        crudPartie.save(partie);
        // Crée 7 cartes aléat par joueur et initialise tour des joueurs
        int tourJoueur = 1;
        for (Joueur joueur : partie.getJoueurs()) {

            // Crée 7 cartes ingredient
            for (int indiceJoueur = 0; indiceJoueur < crudJoueur.count(); indiceJoueur++) {
                for (int indiceIngredient = 0; indiceIngredient < 7; indiceIngredient++) {
                    Ingredient ingredient = new Ingredient();
                    joueur.getIngredients().add(ingredient);
                    ingredient.setJoueur(joueur);
                    crudIngredient.save(ingredient);
                }
            }

            // Initialise tour joueur
            joueur.setSommeilProfond(0);
            joueur.setTour(tourJoueur);
            tourJoueur++;

            crudJoueur.save(joueur);
        }
    }
    
    public boolean testPartieDemarree(long idPartie) {
        if(crudPartie.findOne(idPartie).getEtatPartie()==Partie.EtatPartie.DEMARREE){
            return true;
        }
            else {return false;}
        }
        

    @Scheduled(fixedDelay = 1000)
    public void creeNouvPartieSiExistePas() {

        if (crudPartie.countByEtatPartie(Partie.EtatPartie.EN_ATTENTE) < 1) {
            Partie partie = new Partie();
            partie.setEtatPartie(Partie.EtatPartie.EN_ATTENTE);
            partie.setNom("Partie magiemagie " + new Date());
            crudPartie.save(partie);
        }
    }
}
