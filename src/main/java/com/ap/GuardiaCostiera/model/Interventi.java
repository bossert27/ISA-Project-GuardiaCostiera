/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
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
@Table(name = "interventi")
public class Interventi implements Serializable {
    
    public String codice_int;
    public String tipoInt;
    public Date data;
    
    
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
     * @return the codice_int
     */
    @Id
    public String getCodice_int() {
        return codice_int;
    }

    /**
     * @param codice_int the codice_int to set
     */
    public void setCodice_int(String codice_int) {
        if(codice_int.length()>100){
            throw new IllegalArgumentException("Codice Intervento può avere max 100 caratteri.");
        }
        this.codice_int = codice_int;
    }

    /**
     * @return the tipoInt
     */
    public String getTipoInt() {
        return tipoInt;
    }

    /**
     * @param tipoInt the tipoInt to set
     */
    public void setTipoInt(String tipoInt) {
        if(tipoInt.length()>100){
            throw new IllegalArgumentException("Tipo Intervento può avere max 100 caratteri.");
        }
        this.tipoInt = tipoInt;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        if(data.after(java.util.Date.from(Instant.ofEpochMilli(1605089623000L))) || data.before(java.util.Date.from(Instant.ofEpochMilli(-2181822377000L)))){
            throw new IllegalArgumentException("Data non idonea");
        } 
        this.data = data;
    }
    
}
