package entity;

import java.util.Objects;

/**
 * La classe astratta Prodotto rappresenta un prodotto generico con attributi come
 * nome, costo e codice prodotto. Fornisce anche metodi per verificare la validità
 * del nome e del costo.
 */
public abstract class Prodotto {

    private String nome;
    private double costo;
    private int codiceProdotto;

    /**
     * Costruttore per la classe Prodotto.
     *
     * @param nome           Il nome del prodotto.
     * @param costo          Il costo del prodotto.
     * @param codiceProdotto Il codice univoco del prodotto.
     * @throws ProdottiException Eccezione generata se il nome è nullo o ha lunghezza inferiore a 4,
     *                           o se il costo è inferiore al prezzo minimo definito in Requisito.
     */
    public Prodotto(String nome, double costo, int codiceProdotto) throws ProdottiException {
        if (isNomeOk(nome)) {
            this.nome = nome;
        } else {
            try {
                ProdottiException.isNomeValido();
            } catch (ProdottiException e) {
                System.err.println(e.getMessage() + " - nome inserito: " + nome + "\n");
            }
        }

        if (isPrezzoOk(costo)) {
            this.costo = costo;
        } else {
            ProdottiException.costoNegativo();
        }
        this.codiceProdotto = codiceProdotto;
    }

    /**
     * Metodo astratto per calcolare il costo del prodotto.
     *
     * @return Il costo del prodotto.
     */
    public abstract double calcolaCosto();

    /**
     * Restituisce il costo del prodotto.
     *
     * @return Il costo del prodotto.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Restituisce il codice univoco del prodotto.
     *
     * @return Il codice univoco del prodotto.
     */
    public int getCodiceProdotto() {
        return codiceProdotto;
    }

    /**
     * Restituisce il nome del prodotto.
     *
     * @return Il nome del prodotto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Verifica se il prezzo del prodotto è superiore al prezzo minimo definito in Requisito.
     *
     * @param prezzo Il prezzo da verificare.
     * @return true se il prezzo è valido, altrimenti false.
     */
    private static final boolean isPrezzoOk(double prezzo) {
        boolean prezzoOk = false;
        if (prezzo > Requisito.PREZZOMINIMO)
            prezzoOk = true;
        return prezzoOk;
    }

    /**
     * Verifica se il nome del prodotto è valido (non nullo e lunghezza maggiore o uguale a 4).
     *
     * @param nome Il nome da verificare.
     * @return true se il nome è valido, altrimenti false.
     */
    private static final boolean isNomeOk(String nome) {
        boolean nomeOk = false;
        if (nome != null && nome.length() >= 4)
            nomeOk = true;
        return nomeOk;
    }

    /**
     * Restituisce il codice hash del prodotto basato sul codice univoco.
     *
     * @return Il codice hash del prodotto.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(codiceProdotto);
    }

    /**
     * Verifica se il prodotto è uguale a un altro oggetto basato sul codice univoco.
     *
     * @param obj L'oggetto da confrontare con il prodotto.
     * @return true se i prodotti sono uguali, altrimenti false.
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Prodotto))
            return false;
        Prodotto other = (Prodotto) obj;
        return codiceProdotto == other.codiceProdotto;
    }
}
