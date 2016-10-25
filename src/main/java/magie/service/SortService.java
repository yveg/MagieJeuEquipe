/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.service;

import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.List;
import magie.DAO.IngredientDAO;
import magie.DAO.JoueurDAO;
import magie.entity.Ingredient;
import magie.entity.Joueur;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
public class SortService {

    @Autowired
    JoueurDAO crudJoueur;
    @Autowired
    IngredientDAO crudIngredients;

    private JoueurDAO crudSort;
    private IngredientDAO crudIng;

    public void invisibilitie(long joueurlance) {

        // Verifie qu'on possède bien : bave de crapaud + corne licorne
        List<Ingredient> bavesCrapaud = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.BAVE_CRAPAUD);
        List<Ingredient> cornesLicorne = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.CORNE_LICORNE);
        if (bavesCrapaud.size() == 0 || cornesLicorne.size() == 0) {
            throw new RuntimeException("Pas de cartes pour lancer ce sort");
        }

        // Déduit ma bave de crapaud et ma corne de licorne de mes ingredients
        crudIngredients.delete(bavesCrapaud.get(0));
        crudIngredients.delete(cornesLicorne.get(0));

        // Recupere ts joueurs
        List<Joueur> joueurs = (List) crudJoueur.findAll();

        // Récupère joueur destination
        Joueur moi = crudJoueur.findOne(joueurlance);

        // Récupérer une carte chez chaque joueur
        for (Joueur joueur : joueurs) {

            if (joueur.getId() != moi.getId() && joueur.getIngredients().size() >= 1) {

                Ingredient ingredientARecuperer = joueur.getIngredients().get(0);

                joueur.getIngredients().remove(ingredientARecuperer);
                moi.getIngredients().add(ingredientARecuperer);
                ingredientARecuperer.setJoueur(moi);

                crudIngredients.save(ingredientARecuperer);
            }
        }

    }

    public void filtreDamour(long joueurlance, long joueurvectime) {

        // Verifie qu'on possède bien : sang de vierge + corne licorne
        List<Ingredient> sangVierge = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.SANG_VIERGE);
        List<Ingredient> cornesLicorne = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.CORNE_LICORNE);
        if (sangVierge.size() == 0 || cornesLicorne.size() == 0) {
            throw new RuntimeException("Pas de cartes pour lancer ce sort");
        }

        // Déduit ma sang de vierge et ma corne de licorne de mes ingredients
        crudIngredients.delete(cornesLicorne.get(0));
        crudIngredients.delete(sangVierge.get(0));

        // Récupère joueur destination
        Joueur moi = crudJoueur.findOne(joueurlance);

        // Recupere  joueur vectime
        Joueur vect = crudJoueur.findOne(joueurvectime);

        // Récupérer les cartes de joueurvectim
        List<Ingredient> ingredvect = crudIngredients.findAllByJoueurId(joueurvectime);

        if (ingredvect.size() > 1) {

            for (int i = 0; i < Math.floor(ingredvect.size()) / 2; i++) {

                Ingredient ingredientARecuperer = vect.getIngredients().get(0);

                vect.getIngredients().remove(ingredientARecuperer);
                moi.getIngredients().add(ingredientARecuperer);
                ingredientARecuperer.setJoueur(moi);

                crudIngredients.save(ingredientARecuperer);
            }
        }

    }

    public void hypnose(long cartechoisir, long joueurvectime) {
        
           // Récupère carte choisi
        Ingredient cartchoisir = crudIngredients.findOne(cartechoisir);

        // Récupère joueur destination
        Joueur joueurlance = cartchoisir.getJoueur();

        // Verifie qu'on possède bien : bave de crapaud + + lapis-lazuli
        List<Ingredient> bavesCrapaud = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.BAVE_CRAPAUD);
        List<Ingredient> lapisLazuli = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.LAPIS_LAZULI);
        if (bavesCrapaud.size() == 0 || lapisLazuli.size() == 0) {
            throw new RuntimeException("Pas de cartes pour lancer ce sort");
        }
        // Déduit ma bave de crapaud et ma lapis-lazuli de mes ingredients
        crudIngredients.delete(bavesCrapaud.get(0));
        crudIngredients.delete(lapisLazuli.get(0));

        
        // Recupere  joueur vectime
        Joueur vect = crudJoueur.findOne(joueurvectime);

        // Récupérer les cartes de joueurvectim
        List<Ingredient> ingredvect = crudIngredients.findAllByJoueurId(joueurvectime);

        if (ingredvect.size() > 2) {

            for (int i = 0; i < 3; i++) {
                Ingredient ingredientARecuperer = vect.getIngredients().get(0);

                vect.getIngredients().remove(vect.getIngredients().get(0));
                joueurlance.getIngredients().add(vect.getIngredients().get(0));
                vect.getIngredients().get(0).setJoueur(joueurlance);

                crudIngredients.save(vect.getIngredients().get(0));
            }
        }

        //ajouter la carte choisi au joueur vectim
        joueurlance.getIngredients().remove(cartchoisir);
        vect.getIngredients().add(cartchoisir);
        cartchoisir.setJoueur(vect);

        crudIngredients.save(cartchoisir);

    }

    public void divination(long joueurlance) {
        // Verifie qu'on possède bien :  lapis-lazuli  aile-de chauve-souris
        List<Ingredient> lapisLazuli = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.LAPIS_LAZULI);
        List<Ingredient> aileDechaveSouris = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.AILE_CHAUVE_SOURIS);
        if (lapisLazuli.size() == 0 || aileDechaveSouris.size() == 0) {
            throw new RuntimeException("Pas de cartes pour lancer ce sort");
        }

        // Déduit ma sang de vierge et ma lapis-lazuli  aile-de chauve-souris
        crudIngredients.delete(lapisLazuli.get(0));
        crudIngredients.delete(aileDechaveSouris.get(0));

        // Récupère joueur destination
        Joueur moi = crudJoueur.findOne(joueurlance);
        // Recupere ts joueurs
        List<Joueur> joueurs = (List) crudJoueur.findAll();

    }

    public void sommeilProfond(long joueurlance, long joueurvectime) {

        // Verifie qu'on possède bien : sang de vierge + bave de crapaud
        List<Ingredient> sangVierge = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.SANG_VIERGE);
        List<Ingredient> baveDeCrapaud = crudIngredients.findAllByJoueurIdAndTypeIngredient(joueurlance, Ingredient.TypeIngredient.BAVE_CRAPAUD);
        if (sangVierge.size() == 0 || baveDeCrapaud.size() == 0) {
            throw new RuntimeException("Pas de cartes pour lancer ce sort");
        }

        // Déduit ma sang de vierge et ma bave de crapaud de mes ingredients
        crudIngredients.delete(baveDeCrapaud.get(0));
        crudIngredients.delete(sangVierge.get(0));

        // Récupère joueur destination
        Joueur moi = crudJoueur.findOne(joueurlance);

        // Recupere  joueur vectime
        Joueur vect = crudJoueur.findOne(joueurvectime);
    }
}
