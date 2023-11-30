package util;

/**
 * La classe Util fornisce metodi di utilità generici.
 * Attualmente, include un metodo per stampare il testo in grassetto utilizzando il codice ASCII del grassetto.
 */
public final class Util {

    /**
     * Stampa il testo in grassetto utilizzando
     * il codice ASCII del grassetto.
     *
     * @param testo Testo da formattare in grassetto.
     */
    public static void printGrassetto(String testo) {
        System.out.printf("%s\n", "\u001B[1m" + testo + "\u001B[0m");
    }
}