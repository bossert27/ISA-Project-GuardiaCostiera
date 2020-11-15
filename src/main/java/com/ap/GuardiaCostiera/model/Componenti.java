/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Marco
 */

@Entity
@Table(name = "componenti")
public class Componenti implements Serializable {
    
    public String codice_com;
    public String cognome;
    public String nome;
    public boolean responsabile;
    
    public Squadre squadre;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codice_sq")
    public Squadre getSquadre() {
        return squadre;
    }
    
    public void setSquadre(Squadre squadre) {
        this.squadre = squadre;
    }

    /**
     * @return the codice_comp
     */
    @Id
    public String getCodice_com() {
        return codice_com;
    }

    /**
     * @param codice_com the codice_comp to set
     */
    public void setCodice_com(String codice_com) {
        if(codice_com.length()>100){
            throw new IllegalArgumentException("Codice Componenti può avere max 100 caratteri.");
        }
        this.codice_com = codice_com;
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
        if(cognome.length()>100){
            throw new IllegalArgumentException("Cognome può avere max 100 caratteri.");
        }
        this.cognome = cognome;
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
        if(nome.length()>100){
            throw new IllegalArgumentException("Nome può avere max 100 caratteri.");
        }
        this.nome = nome;
    }

    /**
     * @return the responsabile
     */
    public boolean isResponsabile() {
        return responsabile;
    }

    /**
     * @param responsabile the responsabile to set
     */
    public void setResponsabile(boolean responsabile) {
        this.responsabile = responsabile;
    }

    
    
    
    
}
