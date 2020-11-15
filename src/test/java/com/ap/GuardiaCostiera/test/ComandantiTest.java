
package com.ap.GuardiaCostiera.test;
/**
 *
 * @author Marco
 */

import com.ap.GuardiaCostiera.model.Comandanti;
import com.ap.generate.InvalidStringGenerator;
import com.ap.generate.StringGenerator;
import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;



@RunWith(JUnitQuickcheck.class)
public class ComandantiTest {
    
    @BeforeClass
    public static void printName() {
        System.out.println("[Unit test] ComandantiTest");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("[Unit test] ComandantiTest-Fine");
    }
    
    /**
     * Viene testato l'inserimento di una stringa: 
     * @param valid  viene definita valida una stringa con max 50 caratteri
     * @param invalid stringa con un numero di caratteri superiore
     * tali stringhe vengono rispettivamente generate dalle classi "StringGenerator" ed
     * "InvalidStringGenerator".
     */
    @Property(trials = 50)
    public void testSetNome(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Comandanti().setNome(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Comandanti().setNome(valid);
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
    public void testSetCognome(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Comandanti().setCognome(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Comandanti().setCognome(valid);
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
    public void testSetCf(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Comandanti().setCf(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Comandanti().setCf(valid);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }
    
    
}
