/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Componenti;
import com.ap.GuardiaCostiera.repository.ComponentiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("componentiService")
public class ComponentiServiceImpl implements ComponentiService {

    @Autowired
    private ComponentiRepository componentiRepository;
    
    
    @Override
    public void saveComponenti(Componenti c) {
        componentiRepository.save(c);
    }

    @Override
    public List<Componenti> getAllCom() {
        return componentiRepository.findAll();
    }

    @Override
    public Optional<Componenti> findByIdCom(String componentiId) {
        return componentiRepository.findById(componentiId);
    }

    @Override
    public void deleteComponenti(String codice_com) {
        componentiRepository.deleteById(codice_com);
    }
    
}
