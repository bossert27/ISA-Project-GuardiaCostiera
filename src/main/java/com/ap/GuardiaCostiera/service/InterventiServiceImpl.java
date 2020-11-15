/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.service;

import com.ap.GuardiaCostiera.model.Interventi;
import com.ap.GuardiaCostiera.repository.InterventiRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("interventiService")
public class InterventiServiceImpl implements InterventiService {

    @Autowired
    private InterventiRepository interventiRepository;
    
    
    @Override
    public void saveInterventi(Interventi c) {
        interventiRepository.save(c);
    }

    @Override
    public List<Interventi> getAllInt() {
        return interventiRepository.findAll();
    }

    @Override
    public Optional<Interventi> findByIdInt(String interventiId) {
        return interventiRepository.findById(interventiId);
    }

    @Override
    public void deleteInterventi(String codice_int) {
        interventiRepository.deleteById(codice_int);
    }
    
}
