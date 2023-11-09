package negozio;

import java.util.Objects;

/**
 * La classe astratta Prodotto rappresenta un prodotto generico all'interno di un negozio.
 * @author checcoconf
 */
abstract class Prodotto {
	
	private String codice;
	private double prezzoIniziale;

	/**
	 * Costruisce un nuovo oggetto Prodotto con il codice e il prezzo iniziale specificati.
	 * @param codice il codice del prodotto
	 * @param prezzoIniziale il prezzo iniziale del prodotto
	 */
	public Prodotto(String codice, double prezzoIniziale) {
		super();
		this.codice = codice;
		if (isPrezzoOk(prezzoIniziale)) {
			this.prezzoIniziale = prezzoIniziale;
		}
	}

	/**
	 * Calcola il costo del prodotto.
	 * @return il costo del prodotto
	 */
	abstract double calcolaCosto();
	
	/**
	 * Controlla se il prezzo specificato è maggiore del prezzo minimo e 
	 * restituisce true se è valido, altrimenti imposta il prezzo al minimo e 
	 * restituisce false.
	 * 
	 * @param prezzo il prezzo da controllare
	 * @return true se il prezzo è maggiore del prezzo minimo, altrimenti false
	 */
	private static final boolean isPrezzoOk(double prezzo) {
		boolean prezzoOk = false;
		if (prezzo > Requisito.PREZZOMINIMO) {
			prezzoOk = true;
		}	
		else {
			prezzo = Requisito.PREZZOMINIMO;
		}
		return prezzoOk;
	}

	/**
	 * Restituisce il prezzo iniziale del prodotto.
	 * @return il prezzo iniziale
	 */
	protected double getPrezzoIniziale() {
		return prezzoIniziale;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Prodotto))
			return false;
		Prodotto other = (Prodotto) obj;
		return Objects.equals(codice, other.codice);
	}
}
