package negozio;

import java.util.ArrayList;

/**
 * La classe Negozio rappresenta un negozio che gestisce una collezione di prodotti.
 * @author checcoconf
 */
public class Negozio {
	
	// ArrayList contenente i prodotti presenti nel negozio
	private ArrayList<Prodotto> prodotti = new ArrayList<Prodotto>();
	
	/**
	 * Aggiunge un prodotto alla collezione di prodotti del negozio.
	 * @param prodotto il prodotto da aggiungere
	 */
	public void addProdotto(Prodotto prodotto) {
		if(!prodotti.contains(prodotto)) {
			prodotti.add(prodotto);
		}
	}
	
	/**
	 * Calcola il totale dei costi di tutti i prodotti presenti nel negozio.
	 * @return il totale dei costi
	 */
	public double calcolaTotale() {
		double totale = 0.00;

		for(Prodotto elemento: prodotti) {
			totale += elemento.calcolaCosto();
		}
		return totale;
	}
}