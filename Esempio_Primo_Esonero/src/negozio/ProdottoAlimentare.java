package negozio;

/**
 * La classe ProdottoAlimentare rappresenta un tipo di prodotto alimentare 
 * all'interno di un negozio.
 * @author checcoconf
 */
public class ProdottoAlimentare extends Prodotto {
	
	private PrincipioNutritivo principioNutritivo;
	private int tempoConservazione;

	/**
	 * Costruisce un nuovo oggetto ProdottoAlimentare con il codice, 
	 * il prezzo iniziale, il principio nutritivo e il tempo di conservazione specificati.
	 * @param codice il codice del prodotto alimentare
	 * @param prezzoIniziale il prezzo iniziale del prodotto alimentare
	 * @param principioNutritivo il principio nutritivo del prodotto alimentare
	 * @param tempoConservazione il tempo di conservazione del prodotto alimentare
	 */
	public ProdottoAlimentare(String codice, double prezzoIniziale, PrincipioNutritivo principioNutritivo,
			int tempoConservazione) {
		super(codice, prezzoIniziale);
		this.principioNutritivo = principioNutritivo;
		if (isTempoConservazioneOk(tempoConservazione)) {
			this.tempoConservazione = tempoConservazione;
		}
	}


	@Override
	/**
	 * Calcola il costo del prodotto alimentare considerando 
	 * la riduzione del prezzo se il tempo di conservazione 
	 * è uguale al minimo tempo di conservazione richiesto.
	 * @return il costo del prodotto alimentare
	 */
	double calcolaCosto() {
		double prezzo = getPrezzoIniziale();
		if (tempoConservazione == Requisito.MINTEMPCONSERVAZIONE) {
			prezzo/=2;
		}	
		return prezzo;
	}
	
	/**
	 * Verifica se il tempo di conservazione specificato è accettabile.
	 *
	 * @param tempoConservazione Il tempo di conservazione da verificare.
	 * @return {@code true} se il tempo di conservazione è maggiore o uguale al valore predefinito,
	 *         {@code false} altrimenti. Se il tempo di conservazione è inferiore al valore predefinito,
	 *         viene impostato al valore predefinito.
	 */
	private static final boolean isTempoConservazioneOk(int tempoConservazione) {
	    boolean tempoConservazioneOk = false;

	    if (tempoConservazione >= Requisito.DEFAULTEMPCONSERVAZIONE) {
	        tempoConservazioneOk = true;
	    } else {
	        tempoConservazione = Requisito.DEFAULTEMPCONSERVAZIONE;
	    }

	    return tempoConservazioneOk;
	}
}
