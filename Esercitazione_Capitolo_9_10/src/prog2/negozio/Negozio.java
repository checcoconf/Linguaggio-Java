package prog2.negozio;

import java.util.ArrayList;

/**
 * Questa classe rappresenta un negozio che gestisce una collezione di prodotti.
 * Fornisce metodi per aggiungere prodotti, calcolare il totale dei prezzi e stampare gli scontrini.
 * Il negozio accetta diversi tipi di prodotti, come Prodotti Alimentari, Prodotti Elettronici e Prodotti Scontati.
 * La classe Negozio è un aggregatore polimorfico dei Prodotti, 
 * consentendo la gestione omogenea di diverse tipologie di articoli.
 * 
 * @author pasqualeardimento
 *
 */
public class Negozio {
	ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();;

	/**
	 * Aggiunge un prodotto se non è già presente.
	 * Accetta valori nulli
	 * @param prodotto Il Prodotto da inserire
	 */
	public void addProdotto(Prodotto prodotto) {
		// subcasting implicito eseguito a run-time da Java
		if(!prodotti.contains(prodotto))
			prodotti.add(prodotto);
	}

	/**
	 * Calcola il totale dei prezzi dei prodotti presenti nel negozio
	 * @return Totale
	 */
	public double calcolaTotale() {
		double totale=0;

		for(Prodotto elemento: prodotti) {
			totale += elemento.getPrezzo();
		}

		return totale;
	}

	/**
	 * Stampa a video i dettagli dei prodotti presenti nel negozio.
	 */
	public void stampaScontrino() {
		for(Prodotto elemento: prodotti) {
			System.out.println(elemento.toString());
		}
	}
}