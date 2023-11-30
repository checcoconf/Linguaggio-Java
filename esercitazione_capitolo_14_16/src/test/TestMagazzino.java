package test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import entity.Magazzino;
import entity.ProdottiException;
import entity.Prodotto;
import entity.ProdottoAlimentare;
import entity.ProdottoElettronico;
import util.Util;

/**
 * La classe TestMagazzino rappresenta un programma di test per la classe Magazzino
 * e le classi di prodotti associate come Prodotto, ProdottoAlimentare e ProdottoElettronico.
 * Vengono eseguite operazioni come l'aggiunta di prodotti al magazzino, la ricerca di prodotti per codice,
 * la cancellazione di prodotti in base al costo, e la stampa di elenchi di prodotti filtrati.
 */
public class TestMagazzino {

    public static void main(String[] args) throws ProdottiException {
    	
    	Util.printGrassetto("Errori di chiarazione prodotti, se presenti");
        ProdottoAlimentare P1 = new ProdottoAlimentare("Pasta", 2.5, 1, 150, 5);
        ProdottoElettronico P2 = new ProdottoElettronico("Laptop", 1200, 2, 24);
        ProdottoAlimentare P3 = new ProdottoAlimentare("Frutta", 3.0, 3, 120, 3);
        ProdottoElettronico P4 = new ProdottoElettronico("Smartphone", 800, 2, 12); 
        ProdottoElettronico P5 = new ProdottoElettronico("ab", 800, 4, 12);
        ProdottoAlimentare P6 = new ProdottoAlimentare("Pasta", 7.8, 8, 220, 6);

        Magazzino magazzino = new Magazzino();

        // Aggiunta prodotti
        Util.printGrassetto("Stampa se i prodotti sono stati inseriti o no");
        System.out.println(magazzino.aggiungiProdotto(P1));
        System.out.println(magazzino.aggiungiProdotto(P2));
        System.out.println(magazzino.aggiungiProdotto(P3));
        System.out.println(magazzino.aggiungiProdotto(P4));
        System.out.println(magazzino.aggiungiProdotto(P5));
        System.out.println(magazzino.aggiungiProdotto(P6));

        // Ricerca di un prodotto per codice
        Util.printGrassetto("\nStampa ricerca di un prodotto per codice");
        try {
        	System.out.println(magazzino.searchByCodice(1));
            System.out.println(magazzino.searchByCodice(7));
        } catch (ProdottiException e) {
            System.err.println(e.getMessage());
        }

        // Cancellazione prodotti per costo
        Util.printGrassetto("\nStampa cancellazione prodotti per costo\n" + magazzino.cancellaProdottiByCosto(2.0));
        System.out.println(magazzino.cancellaProdottiByCosto(1.5));

        // Elenco prodotti per costo superiore
        Util.printGrassetto("\nStampa prodotti per costo superiore");

        Set<Entry<Integer, Prodotto>> prodottiCostoSuperiore = new HashSet<>();
        prodottiCostoSuperiore = magazzino.getProdottiCostoSuperiore(1.0);
        magazzino.stampaElenco(prodottiCostoSuperiore);

        // Elenco prodotti per nome
        Util.printGrassetto("\nStampa prodotti in ordine per nome");

        Set<Entry<Integer, Prodotto>> prodottiByNome = new TreeSet();
        prodottiByNome = magazzino.getProdottiByNome("Pasta");
        magazzino.stampaElenco(prodottiByNome);

        // Elenco prodotti per costo decrescente
        Util.printGrassetto("\nStampa prodotti per costo decrescente");
        Set<Entry<Integer, Prodotto>> prodottiByCostoDecr = new TreeSet();
        prodottiByCostoDecr = magazzino.getProdottiByCostoDecr();
        magazzino.stampaElenco(prodottiByCostoDecr);

    }
}