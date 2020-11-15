/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Squadre;
import java.util.List;
import java.util.Optional;

/**
 * Strumento che serve per recuperare i dati necessari
 * @author Marco
 */
public interface SquadreService {
    public void saveSquadre(Squadre n);
    public List<Squadre> getAllSq();

    public Optional<Squadre> findByIdSq(String SquadreId);

    public void deleteSquadre(String codice_sq);
}
