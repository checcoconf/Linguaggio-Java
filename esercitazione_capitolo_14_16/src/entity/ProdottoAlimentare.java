package entity;

/**
 * La classe ProdottoAlimentare estende la classe astratta Prodotto e rappresenta
 * un prodotto alimentare con attributi aggiuntivi come energia e tempo di conservazione.
 */
public class ProdottoAlimentare extends Prodotto {

    private int energia;
    private int tempoConservazione;

    /**
     * Costruttore per la classe ProdottoAlimentare.
     *
     * @param nome              Il nome del prodotto alimentare.
     * @param costo             Il costo del prodotto alimentare.
     * @param codiceProdotto    Il codice univoco del prodotto alimentare.
     * @param energia           L'energia del prodotto alimentare.
     * @param tempoConservazione Il tempo di conservazione del prodotto alimentare.
     * @throws ProdottiException Eccezione generata se il nome è nullo o ha lunghezza inferiore a 4,
     *                           o se il costo è inferiore al prezzo minimo definito in Requisito,
     *                           o se l'energia è inferiore all'energia minima definita in Requisito,
     *                           o se il tempo di conservazione è inferiore al tempo minimo definito in Requisito.
     */
    public ProdottoAlimentare(String nome, double costo, int codiceProdotto,
                              int energia, int tempoConservazione) throws ProdottiException {
        super(nome, costo, codiceProdotto);

        if (isEnergiaValido(energia)) {
            this.energia = energia;
        } else {
            ProdottiException.energiaNegativo();
        }

        if (isTempoConservazioneValido(tempoConservazione)) {
            this.tempoConservazione = tempoConservazione;
        } else {
            this.tempoConservazione = Requisito.MINTEMPCONSERVAZIONE;
        }
    }

    /**
     * Verifica se il tempo di conservazione del prodotto alimentare è valido.
     *
     * @param tempConservazione Il tempo di conservazione da verificare.
     * @return true se il tempo di conservazione è valido, altrimenti false.
     */
    private static final boolean isTempoConservazioneValido(int tempConservazione) {
        boolean tempConservaz = false;
        if (tempConservazione >= Requisito.MINTEMPCONSERVAZIONE)
            tempConservaz = true;
        return tempConservaz;
    }

    /**
     * Verifica se l'energia del prodotto alimentare è valida.
     *
     * @param energia L'energia da verificare.
     * @return true se l'energia è valida, altrimenti false.
     */
    private static final boolean isEnergiaValido(int energia) {
        boolean energiaOk = false;
        if (energia > Requisito.ENERGIAMINIMO)
            energiaOk = true;
        return energiaOk;
    }

    /**
     * Calcola il costo del prodotto alimentare, considerando uno sconto se il tempo
     * di conservazione è inferiore o uguale a 2.
     *
     * @return Il costo calcolato del prodotto alimentare.
     */
    @Override
    public double calcolaCosto() {
        double prezzo = getCosto();

        if (tempoConservazione <= 2) {
            prezzo /= 2;
        }
        return prezzo;
    }

    /**
     * Restituisce una rappresentazione in formato stringa del prodotto alimentare.
     *
     * @return Una stringa che rappresenta il prodotto alimentare.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProdottoAlimentare  [nome=");
        builder.append(getNome());
        builder.append(", costo=");
        builder.append(getCosto());
        builder.append("€, codiceProdotto=");
        builder.append(getCodiceProdotto());
        builder.append(", energia=");
        builder.append(energia);
        builder.append(", tempoConservazione=");
        builder.append(tempoConservazione);
        builder.append("]");
        return builder.toString();
    }
}
