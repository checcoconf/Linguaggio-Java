package entity;

import java.util.Comparator;
import java.util.Map.Entry;

/**
 * Questo comparatore è utilizzato per confrontare le voci di una mappa di prodotti
 * in base al nome del prodotto e, in caso di nomi uguali, in base al codice del prodotto.
 */
class NomeProdottoComparator implements Comparator<Entry<Integer, Prodotto>> {

    /**
     * Confronta due voci della mappa in base al nome del prodotto e, in caso di nomi uguali,
     * in base al codice del prodotto.
     *
     * @param o1 La prima voce da confrontare.
     * @param o2 La seconda voce da confrontare.
     * @return Un valore negativo se il nome di o1 precede il nome di o2,
     *         un valore positivo se il nome di o1 segue il nome di o2,
     *         zero se i nomi sono uguali e il codice prodotto di o1 è uguale al codice prodotto di o2.
     */
    @Override
    public int compare(Entry<Integer, Prodotto> o1, Entry<Integer, Prodotto> o2) {
        Prodotto prodotto1 = o1.getValue();
        Prodotto prodotto2 = o2.getValue();

        // Confronto per nome
        int confrontoNome = prodotto1.getNome().compareTo(prodotto2.getNome());

        // Se i nomi sono uguali, confronto per codice prodotto
        if (confrontoNome == 0) {
            return Integer.compare(prodotto1.getCodiceProdotto(), prodotto2.getCodiceProdotto());
        }
        return confrontoNome;
    }
}
