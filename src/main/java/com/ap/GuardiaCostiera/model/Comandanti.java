/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Marco
 */

@Entity
@Table(name = "comandanti")
public class Comandanti implements Serializable {
    private String cf;
    
    private String nome;
    private String cognome;
    
    public Set<Capitanerie> capitanerie;
    @OneToMany(mappedBy = "comandanti", cascade = CascadeType.ALL, orphanRemoval = false)
    /**
     * @return the capitanerie
     */
    public Set<Capitanerie> getCapitanerie() {
        return capitanerie;
    }

    /**
     * @param capitanerie the capitanerie to set
     */
    public void setCapitanerie(Set<Capitanerie> capitanerie) {
        this.capitanerie = capitanerie;
    }
    
    

    /**
     * @return the cf
     */
    @Id
    public String getCf() {
        return cf;
    }

    /**
     * @param cf the cf to set
     */
    public void setCf(String cf) {
        if(cf.length() > 100) {
            throw new IllegalArgumentException("Cf deve avere max 100 caratteri.");
        }
        this.cf = cf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        if(nome.length() > 100) {
            throw new IllegalArgumentException("Il Nome può avere max 100 caratteri.");
        }
        this.nome = nome;
    }

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        if(cognome.length() > 100) {
            throw new IllegalArgumentException("Il Nome può avere max 100 caratteri.");
        }
        this.cognome = cognome;
    }

    
}
