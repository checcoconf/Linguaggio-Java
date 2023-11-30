package entity;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 * Questa classe implementa un comparatore per ordinare le voci di una mappa
 * in base al costo del prodotto in ordine decrescente.
 */
public class CostoDecrescenteComparator implements Comparator<Entry<Integer, Prodotto>> {

    /**
     * Confronta due voci della mappa in base al costo del prodotto.
     *
     * @param o1 La prima voce da confrontare.
     * @param o2 La seconda voce da confrontare.
     * @return Un valore negativo se il costo di o1 è maggiore di quello di o2,
     *         un valore positivo se il costo di o1 è minore di quello di o2,
     *         zero se i costi sono uguali.
     */
    @Override
    public int compare(Entry<Integer, Prodotto> o1, Entry<Integer, Prodotto> o2) {
        Prodotto prodotto1 = o1.getValue();
        Prodotto prodotto2 = o2.getValue();

        // Confronto per costo in ordine decrescente
        return Double.compare(prodotto2.getCosto(), prodotto1.getCosto());
    }
}