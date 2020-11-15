/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Capitanerie;
import java.util.List;
import java.util.Optional;

/**
 * Strumento che serve per recuperare i dati necessari
 * @author Marco
 */
public interface CapitanerieService {
    public void saveCapitanerie(Capitanerie n);
    public List<Capitanerie> getAllCap();

    public Optional<Capitanerie> findByIdCap(String CapitanerieId);

    public void deleteCapitanerie(String codice_cap);
    
}
