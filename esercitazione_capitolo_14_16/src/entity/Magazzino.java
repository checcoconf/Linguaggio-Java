package entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/**
 * La classe Magazzino rappresenta un magazzino di prodotti con operazioni come
 * l'aggiunta, la cancellazione e la ricerca di prodotti.
 */
public class Magazzino {

    private HashMap<Integer, Prodotto> prodotti;

    /**
     * Costruttore predefinito per la classe Magazzino.
     */
    public Magazzino() {
        prodotti = new HashMap<Integer, Prodotto>();
    }

    /**
     * Aggiunge un prodotto al magazzino se il codice prodotto non è già presente
     * e se il nome del prodotto non è nullo.
     *
     * @param prodotto Il prodotto da aggiungere al magazzino.
     * @return true se il prodotto viene aggiunto con successo, altrimenti false.
     */
    public boolean aggiungiProdotto(Prodotto prodotto) {
        boolean stato = false;
        if ((!prodotti.containsKey(prodotto.getCodiceProdotto())) && prodotto.getNome() != null) {
            prodotti.put(prodotto.getCodiceProdotto(), prodotto);
            stato = true;
        }
        return stato;
    }

    /**
     * Cancella i prodotti con costo inferiore o uguale al costo fornito.
     *
     * @param costo Il costo massimo per la cancellazione dei prodotti.
     * @return true se almeno un prodotto viene cancellato, altrimenti false.
     */
    public boolean cancellaProdottiByCosto(double costo) {
        boolean stato = false;

        Iterator<Entry<Integer, Prodotto>> iterator = prodotti.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<Integer, Prodotto> prodotto = iterator.next();
            if (prodotto.getValue().getCosto() <= costo) {
                iterator.remove();
                stato = true;
            }
        }

        return stato;
    }

    /**
     * Restituisce un insieme di voci di prodotti con costo superiore al costo fornito.
     *
     * @param costo Il costo minimo per la selezione dei prodotti.
     * @return Un insieme di voci di prodotti con costo superiore al costo fornito.
     */
    public Set<Entry<Integer, Prodotto>> getProdottiCostoSuperiore(double costo) {
        Set<Entry<Integer, Prodotto>> prodottiCostoSuperiore = new HashSet<>();

        for (Entry<Integer, Prodotto> prodotto : prodotti.entrySet()) {
            if (prodotto.getValue().getCosto() > costo) {
                prodottiCostoSuperiore.add(prodotto);
            }
        }

        return Collections.unmodifiableSet(prodottiCostoSuperiore);
    }

    /**
     * Ricerca e restituisce un prodotto basato sul codice prodotto fornito.
     *
     * @param codiceProdotto Il codice del prodotto da cercare.
     * @return Il prodotto corrispondente al codice fornito.
     * @throws ProdottiException Se il prodotto non viene trovato.
     */
    public Prodotto searchByCodice(int codiceProdotto) throws ProdottiException {
        for (Entry<Integer, Prodotto> prodotto : prodotti.entrySet()) {
            if (prodotto.getKey() == codiceProdotto) {
                return prodotto.getValue(); // Prodotto trovato, restituisce il prodotto
            }
        }
        // Se il codiceProdotto non è stato trovato, lanciare una ProdottiException
        throw new ProdottiException("Prodotto non trovato con il codice: " + codiceProdotto);
    }

    /**
     * Restituisce un insieme ordinato di voci di prodotti con lo stesso nome.
     *
     * @param nomeProdotto Il nome del prodotto da cercare.
     * @return Un insieme ordinato di voci di prodotti con lo stesso nome.
     */
    public Set<Entry<Integer, Prodotto>> getProdottiByNome(String nomeProdotto) {
        Set<Entry<Integer, Prodotto>> prodottiByNome = new TreeSet(new NomeProdottoComparator());

        for (Entry<Integer, Prodotto> prodotto : prodotti.entrySet()) {
            if (prodotto.getValue().getNome().equals(nomeProdotto)) {
                prodottiByNome.add(prodotto);
            }
        }

        return Collections.unmodifiableSet(prodottiByNome);
    }

    /**
     * Restituisce un insieme ordinato di tutte le voci di prodotti in base al costo
     * in ordine decrescente.
     *
     * @return Un insieme ordinato di tutte le voci di prodotti in ordine decrescente
     *         in base al costo.
     */
    public Set<Entry<Integer, Prodotto>> getProdottiByCostoDecr() {
        Set<Entry<Integer, Prodotto>> ProdottiByCostoDecr = new TreeSet(new CostoDecrescenteComparator());

        for (Entry<Integer, Prodotto> prodotto : prodotti.entrySet()) {
            ProdottiByCostoDecr.add(prodotto);
        }
        return Collections.unmodifiableSet(ProdottiByCostoDecr);
    }

    /**
     * Stampa l'elenco di voci di prodotti fornito.
     *
     * @param elenco L'insieme di voci di prodotti da stampare.
     */
    public void stampaElenco(Set<Entry<Integer, Prodotto>> elenco) {
        for (Entry<Integer, Prodotto> lista : elenco) {
            Integer chiave = lista.getKey();
            Prodotto prodotto = lista.getValue();

            System.out.println("Chiave: " + chiave + ", Elemento: " + prodotto);
        }
    }
}