
package com.ap.GuardiaCostiera.test;
/**
 *
 * @author Marco
 */

import com.ap.GuardiaCostiera.model.Squadre;
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
public class SquadreTest {
    
    @BeforeClass
    public static void printName() {
        System.out.println("[Unit test] SquadreTest");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("[Unit test] SquadreTest-Fine");
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
            new Squadre().setCodice_sq(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Squadre().setCodice_sq(valid);
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
            new Squadre().setTipo(invalid);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Squadre().setTipo(valid);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNull(e2);
    }
    
    /**
     * Viene testato l'inserimento di un numero che dovrà essere:
     * @param valid ritenuto valido unicamente se rientra tra 0 e 3000.
     * @param lower parametro non valido
     * @param upper parametro non valido
     * 
     */
    @Property(trials = 33)
    public void testSetNumComp(@InRange(maxInt = -1) int lower, @InRange(minInt = 3001) int upper, @InRange(minInt = 0, maxInt = 3000) int valid) {
        IllegalArgumentException e1 = null;
        try {
            new Squadre().setNumComp(lower);
        } catch (IllegalArgumentException ex) {
            e1 = ex;
        }
        assertNotNull(e1);

        IllegalArgumentException e2 = null;
        try {
            new Squadre().setNumComp(upper);
        } catch (IllegalArgumentException ex) {
            e2 = ex;
        }
        assertNotNull(e2);

        IllegalArgumentException e3 = null;
        try {
            new Squadre().setNumComp(valid);
        } catch (IllegalArgumentException ex) {
            e3 = ex;
        }
        assertNull(e3);
    }
}
