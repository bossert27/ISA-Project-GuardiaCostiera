
package com.ap.GuardiaCostiera.test;
/**
 *
 * @author Marco
 */

import com.ap.GuardiaCostiera.model.Interventi;
import com.ap.generate.DateGenerator;
import com.ap.generate.DateGeneratorInvalid;
import com.ap.generate.InvalidStringGenerator;
import com.ap.generate.StringGenerator;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.sql.Date;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



@RunWith(JUnitQuickcheck.class)
public class InterventiTest {
    
    @BeforeClass
    public static void printName() {
        System.out.println("[Unit test] InterventiTest");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("[Unit test] InterventiTest-Fine");
    }
    
    /**
     * Viene testato l'inserimento di una stringa: 
     * @param valid  viene definita valida una stringa con max 50 caratteri
     * @param invalid stringa con un numero di caratteri superiore
     * tali stringhe vengono rispettivamente generate dalle classi "StringGenerator" ed
     * "InvalidStringGenerator".
     */
    @Property(trials = 50)
    public void testSetCodice_sq(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Interventi().setCodice_int(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Interventi().setCodice_int(valid);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }
    
    /**
     * Viene testato l'inserimento di una stringa: 
     * @param valid  viene definita valida una stringa con max 50 caratteri
     * @param invalid stringa con un numero di caratteri superiore
     * tali stringhe vengono rispettivamente generate dalle classi "StringGenerator" ed
     * "InvalidStringGenerator".
     */
    @Property(trials = 50)
    public void testSetTipo(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Interventi().setTipoInt(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Interventi().setTipoInt(valid);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }
    
    /**
     * Viene testato l'inserimento di una data:  
     * @param valid  viene definita valida una data in formato "gg/mm/aa" tra il 1940 e 2020
     * @param invalid viene definita invalida una data in formato "gg/mm/aa" superiore all'anno e 2020
     * tali stringhe vengono rispettivamente generate dalle classi "DateGenerator" ed
     * "DateGeneratorInvalid".
     */
    @Property(trials = 50)
    public void testSetData(@From(DateGenerator.class) Date valid, @From(DateGeneratorInvalid.class) Date invalid) {
        IllegalArgumentException e1 = null;
        try {
            new Interventi().setData(valid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNull(e1);

        
        IllegalArgumentException e2 = null;
        try {
            new Interventi().setData(invalid);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNotNull(e2);
    }
}

