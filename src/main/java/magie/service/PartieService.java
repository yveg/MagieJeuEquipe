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

    public void rejoindrePartie(long idPartie, long idJoueur){
        
        Partie partie = crudPartie.findOne(idPartie);
        Joueur joueur = crudJoueur.findOne(idJoueur);
        joueur.setPartie(partie);
        partie.getJoueurs().add(joueur);
        
        crudPartie.save(partie);
        crudJoueur.save(joueur);
    }
    
    public void demarrerPartie(long partieId) {

        // Récup partie
        Partie partie = crudPartie.findOne(partieId);

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
            joueur.setTour( tourJoueur );
            tourJoueur++;
            
            crudJoueur.save(joueur);
        }
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
