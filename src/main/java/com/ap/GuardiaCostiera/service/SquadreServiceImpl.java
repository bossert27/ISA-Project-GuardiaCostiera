/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Squadre;
import com.ap.GuardiaCostiera.repository.SquadreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("squadreService")
public class SquadreServiceImpl implements SquadreService {

    @Autowired
    private SquadreRepository squadreRepository;
    
    
    @Override
    public void saveSquadre(Squadre c) {
        squadreRepository.save(c);
    }

    @Override
    public List<Squadre> getAllSq() {
        return squadreRepository.findAll();
    }

    @Override
    public Optional<Squadre> findByIdSq(String squadreId) {
        return squadreRepository.findById(squadreId);
    }

    @Override
    public void deleteSquadre(String codice_sq) {
        squadreRepository.deleteById(codice_sq);
    }
    
}
