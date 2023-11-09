package negozio;

/**
 * Enum che rappresenta i diversi tipi di principi nutritivi.
 * @author checcoconf
 */
public enum PrincipioNutritivo {

    /**
     * Rappresenta i carboidrati come tipo di principio nutritivo.
     */
    CARBOIDRATI ("carboidrati"),

    /**
     * Rappresenta i grassi come tipo di principio nutritivo.
     */
    GRASSI ("grassi"),

    /**
     * Rappresenta le proteine come tipo di principio nutritivo.
     */
    PROTEINE ("proteine"),

    /**
     * Rappresenta le vitamine come tipo di principio nutritivo.
     */
    VITAMINE("vitamine");

    private String value;

    /**
     * Costruttore per TipoDiPrincipioNutritivo.
     * @param value il valore del principio nutritivo.
     */
    PrincipioNutritivo(String value) {
        this.value = value;
    }
}
