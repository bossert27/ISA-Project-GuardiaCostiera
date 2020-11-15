/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Comandanti;
import com.ap.GuardiaCostiera.repository.ComandantiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("comandantiService")
public class ComandantiServiceImpl implements ComandantiService {

    //questo servizio si appoggia sul repository
    //non mi preoccuperò di chi implementerà questa interfaccia - autowired, serve per cercare chi implementa l'interfaccia di questo repository e associa la classe che implementa
    @Autowired
    private ComandantiRepository comandantiRepository;
    
    
    @Override
    public void saveComandanti(Comandanti c) {
        comandantiRepository.save(c);
    }

    @Override
    public List<Comandanti> getAll() {
        return comandantiRepository.findAll();
    }

    @Override
    public Optional<Comandanti> findById(String comandantiId) {
        return comandantiRepository.findById(comandantiId);
    }

    @Override
    public void deleteComandanti(String cf) {
        //chiedo al repository di cancellare
        comandantiRepository.deleteById(cf);
    }
    
}
