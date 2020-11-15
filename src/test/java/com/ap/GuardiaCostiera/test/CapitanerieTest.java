
package com.ap.GuardiaCostiera.test;
/**
 *
 * @author Marco
 */

import com.ap.GuardiaCostiera.model.Capitanerie;
import com.ap.generate.InvalidNumberGenerator;
import com.ap.generate.InvalidStringGenerator;
import com.ap.generate.NumberGenerator;
import com.ap.generate.StringGenerator;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



@RunWith(JUnitQuickcheck.class)
public class CapitanerieTest {
    
    @BeforeClass
    public static void printName() {
        System.out.println("[Unit test] CapitanerieTest");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("[Unit test] CapitanerieTest-Fine");
    }
    
    /**
     * Viene testato l'inserimento di una stringa: 
     * @param valid  viene definita valida una stringa con max 50 caratteri
     * @param invalid stringa con un numero di caratteri superiore
     * tali stringhe vengono rispettivamente generate dalle classi "StringGenerator" ed
     * "InvalidStringGenerator".
     */
    @Property(trials = 50)
    public void testSetCodice_cap(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Capitanerie().setCodice_cap(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Capitanerie().setCodice_cap(valid);
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
    public void testSetNome_cap(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Capitanerie().setNome_cap(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Capitanerie().setNome_cap(valid);
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
    public void testSetComune(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Capitanerie().setComune(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Capitanerie().setComune(valid);
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
    public void testSetIndirizzo(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Capitanerie().setIndirizzo(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Capitanerie().setIndirizzo(valid);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }
    
    /**
     * Viene testato l'inserimento di un numero:
     * @param negativeId  se si tratta di un numero negativo
     * @param positiveId  se si tratta di un numero positivo
     * tali stringhe vengono rispettivamente generate dalle classi "NumberGenerator" ed
     * "InvalidNumberGenerator".
     */
    @Property(trials = 50)
    public void testSetTelefono(@InRange(maxInt = 0) int negativeId, @InRange(minInt = 1) int positiveId) {
        IllegalArgumentException e1 = null;
        try {
            new Capitanerie().setTelefono(negativeId);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Capitanerie().setTelefono(positiveId);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }
}