/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Comandanti;
import java.util.List;
import java.util.Optional;

/**
 * Strumento che serve per recuperare i dati necessari
 * @author Marco
 */
public interface ComandantiService {
    public void saveComandanti(Comandanti n);
    public List<Comandanti> getAll();

    public Optional<Comandanti> findById(String comandantiId);

    public void deleteComandanti(String cf);
}
