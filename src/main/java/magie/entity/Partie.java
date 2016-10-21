/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magie.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Partie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private int tourJoueur;
    
    @OneToMany(mappedBy = "partie")
    private Collection<Joueur> joueurs = new ArrayList<>();

    public int getTourJoueur() {
        return tourJoueur;
    }

    public void setTourJoueur(int tourJoueur) {
        this.tourJoueur = tourJoueur;
    }

    public Collection<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(Collection<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        if (!(object instanceof Partie)) {
            return false;
        }
        Partie other = (Partie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "magie.entity.Partie[ id=" + id + " ]";
    }
    
}
