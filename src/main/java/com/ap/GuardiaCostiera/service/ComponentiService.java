/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Componenti;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Marco
 */
public interface ComponentiService {
    public void saveComponenti(Componenti n);
    public List<Componenti> getAllCom();

    public Optional<Componenti> findByIdCom(String ComponentiId);

    public void deleteComponenti(String codice_com);
}
