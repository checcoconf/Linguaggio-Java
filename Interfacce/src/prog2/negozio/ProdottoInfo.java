package prog2.negozio;

/**
 * L'interfaccia ProdottoInfo definisce
 * le operazioni per accedere alle informazioni
 * basiche di un prodotto ad esclusione
 * del codice identificativo
 * @author pasqualeardimento
 *
 */
public interface ProdottoInfo {
	/**
	 * Calcola il prezzo del prodotto al netto
	 * di sconti e promozioni, se previste
	 * @return Il prezzo del prodotto
	 */
	public double calcolaPrezzo();
	
	/**
	 * 
	 * @return Descrizione del prodotto
	 */
	public String getDescrizione();
}