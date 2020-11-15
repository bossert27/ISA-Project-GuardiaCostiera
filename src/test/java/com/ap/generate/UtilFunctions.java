package com.ap.generate;

public class UtilFunctions {

    /**
     * Restituisce true se la stringa passata come argomento è
     * un intero non negativo, effettuandone il parsing.
     * @param num La stringa che deve essere interpretata
     * @return Booleano
     */
    public static boolean isPositiveInteger(String num) {
        try {
            int integer = Integer.parseInt(num);
            return integer > 0;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Restituisce true se la stringa passata come argomento è
     * un intero maggiore o uguale di zero, effettuandone il parsing.
     * @param num La stringa che deve essere interpretata
     * @return Booleano
     */
    public static boolean isGeThanZero(String num) {
        try {
            int integer = Integer.parseInt(num);
            return integer >= 0;
        } catch (Exception e) {
            return false;
        }
    }

}
