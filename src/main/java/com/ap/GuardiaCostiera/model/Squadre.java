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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Marco
 */

@Entity
@Table(name = "squadre")
public class Squadre implements Serializable {
    
    public String codice_sq;
    public String tipo;
    public Integer numComp;
    
    protected Capitanerie capitanerie;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codice_cap")
    public Capitanerie getCapitanerie() {
        return capitanerie;
    }
    
    public void setCapitanerie(Capitanerie capitanerie) {
        this.capitanerie = capitanerie;
    }

    public Set<Componenti> componenti;
    @OneToMany(mappedBy = "squadre", cascade = CascadeType.ALL, orphanRemoval = false)
    /**
     * @return the componenti
     */
    public Set<Componenti> getComponenti() {
        return componenti;
    }

    /**
     * @param componenti the squadre to set
     */
    public void setComponenti(Set<Componenti> componenti) {
        this.componenti = componenti;
    }
    
    public Set<Interventi> interventi;
    @OneToMany(mappedBy = "squadre", cascade = CascadeType.ALL, orphanRemoval = false)
    /**
     * @return the interventi
     */
    public Set<Interventi> getInterventi() {
        return interventi;
    }

    /**
     * @param interventi the squadre to set
     */
    public void setInterventi(Set<Interventi> interventi) {
        this.interventi = interventi;
    }
    
    
    /**
     * @return the codice_sq
     */
    @Id
    public String getCodice_sq() {
        return codice_sq;
    }

    /**
     * @param codice_sq the codice_sq to set
     */
    public void setCodice_sq(String codice_sq) {
        if(codice_sq.length()>100){
            throw new IllegalArgumentException("Codice Squadra può avere max 100 caratteri.");
        }
        this.codice_sq = codice_sq;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        if(tipo.length()>100){
            throw new IllegalArgumentException("Tipo può avere max 100 caratteri.");
        }
        this.tipo = tipo;
    }

    /**
     * @return the numComp
     */
    public Integer getNumComp() {
        return numComp;
    }

    /**
     * @param numComp the numComp to set
     */
    public void setNumComp(Integer numComp) {
        if(numComp < 0 || numComp > 3000) {
            throw new IllegalArgumentException("Numero Componenti deve essere compreso fra 0 e 3000.");
        }
        this.numComp = numComp;
    }
    
    
    
    
}
