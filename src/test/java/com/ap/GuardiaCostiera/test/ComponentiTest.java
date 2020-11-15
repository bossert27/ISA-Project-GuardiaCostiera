
package com.ap.GuardiaCostiera.test;
/**
 *
 * @author Marco
 */

import com.ap.GuardiaCostiera.model.Componenti;
import com.ap.generate.InvalidStringGenerator;
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
public class ComponentiTest {
    
    @BeforeClass
    public static void printName() {
        System.out.println("[Unit test] ComponentiTest");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("[Unit test] ComponentiTest-Fine");
    }
    
    /**
     * Viene testato l'inserimento di una stringa: 
     * @param valid  viene definita valida una stringa con max 50 caratteri
     * @param invalid stringa con un numero di caratteri superiore
     * tali stringhe vengono rispettivamente generate dalle classi "StringGenerator" ed
     * "InvalidStringGenerator".
     */
    @Property(trials = 50)
    public void testSetCodice_comp(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Componenti().setCodice_com(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Componenti().setCodice_com(valid);
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
            new Componenti().setCognome(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Componenti().setCognome(valid);
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
    public void testSetNome(@From(InvalidStringGenerator.class) String invalid, @From(StringGenerator.class) String valid) {
        IllegalArgumentException e1 = null;
        try {
            new Componenti().setNome(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Componenti().setNome(valid);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }
    
    
}
