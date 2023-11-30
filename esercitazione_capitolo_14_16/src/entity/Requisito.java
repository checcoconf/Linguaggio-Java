package entity;

/**
 * La classe Requisito contiene costanti che rappresentano requisiti specifici per i vari tipi di prodotti.
 * Le costanti includono limiti minimi e massimi per il prezzo, il tempo di conservazione, l'energia,
 * e la durata della garanzia per i prodotti, prodotti alimentari e prodotti elettronici, rispettivamente.
 */
final class Requisito {

    // ********* PRODOTTO *********
    /**
     * Il prezzo minimo consentito per un prodotto.
     */
    static final double PREZZOMINIMO = 0.0;
    // ********* FINE *********

    // ********* PRODOTTO ALIMENTARE *********
    /**
     * Il tempo di conservazione minimo consentito per un prodotto alimentare.
     */
    static final int MINTEMPCONSERVAZIONE = 1;
    /**
     * L'energia minima consentita per un prodotto alimentare.
     */
    static final int ENERGIAMINIMO = 0;
    // ********* FINE *********

    // ********* PRODOTTO ELETTRONICO *********
    /**
     * La durata minima della garanzia consentita per un prodotto elettronico.
     */
    static final int MINTEMPGARANZIA = 2;
    /**
     * La durata massima della garanzia consentita per un prodotto elettronico.
     */
    static final int MAXTEMPGARANZIA = 24;
    /**
     * La durata predefinita della garanzia per un prodotto elettronico.
     */
    static final int DEFAULTGARANZIA = 2;
    // ********* FINE *********

}
