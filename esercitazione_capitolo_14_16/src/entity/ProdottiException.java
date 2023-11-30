package entity;

/**
 * Eccezione personalizzata per gestire situazioni specifiche relative ai prodotti.
 */
public class ProdottiException extends Exception {

    private String message;

    /**
     * Costruttore che richiede un messaggio di errore.
     *
     * @param message Il messaggio di errore associato all'eccezione.
     */
    public ProdottiException(String message) {
        this.message = message;
    }

    /**
     * Genera un'eccezione per indicare che il costo del prodotto è negativo.
     *
     * @throws ProdottiException Un'eccezione con il messaggio "Il costo non può essere negativo".
     */
    public static void costoNegativo() throws ProdottiException {
        throw new ProdottiException("Il costo non può essere negativo");
    }

    /**
     * Genera un'eccezione per indicare che l'energia del prodotto è negativa.
     *
     * @throws ProdottiException Un'eccezione con il messaggio "L'energia non può essere negativa".
     */
    public static void energiaNegativo() throws ProdottiException {
        throw new ProdottiException("L'energia non può essere negativa");
    }

    /**
     * Genera un'eccezione per indicare che il nome del prodotto è nullo o ha una lunghezza inferiore a 3.
     *
     * @throws ProdottiException Un'eccezione con il messaggio "Il nome è null o ha lunghezza inferiore a 3".
     */
    public static void isNomeValido() throws ProdottiException {
        throw new ProdottiException("Il nome è null o ha lunghezza inferiore a 3");
    }

    /**
     * Restituisce il messaggio associato a questa eccezione.
     *
     * @return Il messaggio di errore.
     */
    public String getMessage() {
        return message;
    }
}