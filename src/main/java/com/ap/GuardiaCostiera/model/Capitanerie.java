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
@Table(name = "capitanerie")
public class Capitanerie implements Serializable {
    
    private String codice_cap;
    private String nome_cap;
    private String comune;
    private String indirizzo;
    private Integer telefono;
    
    protected Comandanti comandanti;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cf_com")
    public Comandanti getComandanti() {
        return comandanti;
    }
    
    public void setComandanti(Comandanti comandanti) {
        this.comandanti = comandanti;
    }
    
    public Set<Squadre> squadre;
    @OneToMany(mappedBy = "capitanerie", cascade = CascadeType.ALL, orphanRemoval = false)
    /**
     * @return the squadre
     */
    public Set<Squadre> getSquadre() {
        return squadre;
    }

    /**
     * @param squadre the squadre to set
     */
    public void setSquadre(Set<Squadre> squadre) {
        this.squadre = squadre;
    }
    
    /**
     * @return the codice_cap
     */
    @Id
    public String getCodice_cap() {
        return codice_cap;
    }

    /**
     * @param codice_cap the codice_cap to set
     */
    public void setCodice_cap(String codice_cap) {
        if(codice_cap.length()>100){
            throw new IllegalArgumentException("Codice Capitaneria può avere max 100 caratteri.");
        }
        this.codice_cap = codice_cap;
    }

    /**
     * @return the nome_cap
     */
    public String getNome_cap() {
        return nome_cap;
    }

    /**
     * @param nome_cap the nome_cap to set
     */
    public void setNome_cap(String nome_cap) {
        if(nome_cap.length()>100){
            throw new IllegalArgumentException("Nome capitaneria può avere max 100 caratteri.");
        }
        this.nome_cap = nome_cap;
    }

    /**
     * @return the comune
     */
    public String getComune() {
        return comune;
    }

    /**
     * @param comune the comune to set
     */
    public void setComune(String comune) {
        if(comune.length()>100){
            throw new IllegalArgumentException("Comune può avere max 100 caratteri.");
        }
        this.comune = comune;
    }

    /**
     * @return the indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * @param indirizzo the indirizzo to set
     */
    public void setIndirizzo(String indirizzo) {
        if(indirizzo.length()>100){
            throw new IllegalArgumentException("L'indirizzo può avere max 100 caratteri.");
        }
        this.indirizzo = indirizzo;
    }

    /**
     * @return the telefono
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Integer telefono) {
        if(telefono <=0){
            throw new IllegalArgumentException("Telefono deve essere > 0.");
        }
        this.telefono = telefono;
    }
    
    
}
