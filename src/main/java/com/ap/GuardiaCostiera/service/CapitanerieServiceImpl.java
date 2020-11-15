/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Capitanerie;
import com.ap.GuardiaCostiera.repository.CapitanerieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("capitanerieService")
public class CapitanerieServiceImpl implements CapitanerieService {

    //questo servizio si appoggia sul repository
    //non mi preoccuperò di chi implementerà questa interfaccia - autowired, serve per cercare chi implementa l'interfaccia di questo repository e associa la classe che implementa
    @Autowired
    private CapitanerieRepository capitanerieRepository;
    
    
    @Override
    public void saveCapitanerie(Capitanerie c) {
        capitanerieRepository.save(c);
    }

    @Override
    public List<Capitanerie> getAllCap() {
        return capitanerieRepository.findAll();
    }

    @Override
    public Optional<Capitanerie> findByIdCap(String capitanerieId) {
        return capitanerieRepository.findById(capitanerieId);
    }

    @Override
    public void deleteCapitanerie(String codice_cap) {
        capitanerieRepository.deleteById(codice_cap);
    }
    
}
