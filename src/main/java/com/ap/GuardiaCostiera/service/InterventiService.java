/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Interventi;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Marco
 */
public interface InterventiService {
    public void saveInterventi(Interventi n);
    public List<Interventi> getAllInt();

    public Optional<Interventi> findByIdInt(String InterventiId);

    public void deleteInterventi(String codice_int);
}
