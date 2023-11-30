package entity;

/**
 * La classe ProdottoElettronico estende la classe astratta Prodotto e rappresenta
 * un prodotto elettronico con un attributo aggiuntivo per la durata della garanzia.
 */
public class ProdottoElettronico extends Prodotto {

    private int garanzia;

    /**
     * Costruttore per la classe ProdottoElettronico.
     *
     * @param nome           Il nome del prodotto elettronico.
     * @param costo          Il costo del prodotto elettronico.
     * @param codiceProdotto Il codice univoco del prodotto elettronico.
     * @param garanzia       La durata della garanzia del prodotto elettronico.
     * @throws ProdottiException Eccezione generata se il nome è nullo o ha lunghezza inferiore a 4,
     *                           o se il costo è inferiore al prezzo minimo definito in Requisito,
     *                           o se la durata della garanzia non è compresa tra MINTEMPGARANZIA e MAXTEMPGARANZIA.
     */
    public ProdottoElettronico(String nome, double costo, int codiceProdotto, int garanzia) throws ProdottiException {
        super(nome, costo, codiceProdotto);
        if (isGaranziaValido(garanzia)) {
            this.garanzia = garanzia;
        } else {
            this.garanzia = Requisito.DEFAULTGARANZIA;
        }
    }

    /**
     * Verifica se la durata della garanzia del prodotto elettronico è valida.
     *
     * @param garanzia La durata della garanzia da verificare.
     * @return true se la durata della garanzia è valida, altrimenti false.
     */
    private static final boolean isGaranziaValido(int garanzia) {
        boolean garanziaOk = false;
        if (garanzia >= Requisito.MINTEMPGARANZIA && garanzia <= Requisito.MAXTEMPGARANZIA)
            garanziaOk = true;
        return garanziaOk;
    }

    /**
     * Calcola il costo del prodotto elettronico, applicando uno sconto del 10%
     * se la durata della garanzia è superiore alla metà della durata massima definita in Requisito.
     *
     * @return Il costo calcolato del prodotto elettronico.
     */
    @Override
    public double calcolaCosto() {
        double prezzo = getCosto();
        if (garanzia > Requisito.MAXTEMPGARANZIA / 2) {
            prezzo *= 0.9; // 10% di sconto
        }
        return prezzo;
    }

    /**
     * Restituisce una rappresentazione in formato stringa del prodotto elettronico.
     *
     * @return Una stringa che rappresenta il prodotto elettronico.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProdottoElettronico [nome=");
        builder.append(getNome());
        builder.append(", costo=");
        builder.append(getCosto());
        builder.append("€, codiceProdotto=");
        builder.append(getCodiceProdotto());
        builder.append(", garanzia=");
        builder.append(garanzia);
        builder.append("]");
        return builder.toString();
    }
}
