/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author admin
 */
@Entity
public class Ingredient implements Serializable {

    public enum TypeIngredient{
        BAVE_CRAPAUD,
        CORNE_LICORNE,
        SANG_VIERGE,
        LAPIS_LAZULI,
        AILE_CHAUVE_SOURIS;

        public static TypeIngredient getBAVE_CRAPAUD() {
            return BAVE_CRAPAUD;
        }

        public static TypeIngredient getCORNE_LICORNE() {
            return CORNE_LICORNE;
        }

        public static TypeIngredient getSANG_VIERGE() {
            return SANG_VIERGE;
        }

        public static TypeIngredient getLAPIS_LAZULI() {
            return LAPIS_LAZULI;
        }

        public static TypeIngredient getAILE_CHAUVE_SOURIS() {
            return AILE_CHAUVE_SOURIS;
        }
    }
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Long id;
    private String nom;
    
    @Enumerated(EnumType.STRING)
    private TypeIngredient typeIngredient;
    private String image;
    
    @ManyToOne
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    public Ingredient() {
        int nombreAleatoire = (int)Math.floor(Math.random()*5);
        switch (nombreAleatoire) {
            case 0:  
                this.setTypeIngredient(TypeIngredient.CORNE_LICORNE);
                this.nom = "Corne de licorne";
                this.image = "Images/ingredient/unicorn.jpg";
                break;
            case 1:  
                this.setTypeIngredient(TypeIngredient.BAVE_CRAPAUD);
                this.nom = "Bave de crapaud";
                this.image = "Images/ingredient/crapaud.jpg";
                break;
            case 2:  
                this.setTypeIngredient(typeIngredient.SANG_VIERGE);
                this.nom = "Sang de vierge";
                this.image = "Images/ingredient/sand2vierge.jpg";
                break;
            case 3:  
                this.setTypeIngredient(typeIngredient.LAPIS_LAZULI);
                this.nom = "Lapis-lazuli";
                this.image = "Images/ingredient/lapiz.jpg";
                break;
            case 4:  
                this.setTypeIngredient(typeIngredient.AILE_CHAUVE_SOURIS);
                this.nom = "Aile de chauve-souris";
                this.image = "Images/ingredient/aile.png";
                break;
        } 
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }


    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredient)) {
            return false;
        }
        Ingredient other = (Ingredient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "magie.entity.Ingredient[ id=" + id + " ]";
    }
    
}
