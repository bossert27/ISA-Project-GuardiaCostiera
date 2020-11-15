/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ap.GuardiaCostiera.repository;

import com.ap.GuardiaCostiera.model.Interventi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Marco
 */
@Repository("interventiRepository")
public interface InterventiRepository extends JpaRepository<Interventi, String>{
    
}
