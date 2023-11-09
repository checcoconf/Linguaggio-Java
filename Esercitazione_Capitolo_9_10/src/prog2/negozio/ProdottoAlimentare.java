package prog2.negozio;

import java.time.LocalDate;

/**
 * Rappresenta un prodotto alimentare
 * @author pasqualeardimento
 *
 */
public class ProdottoAlimentare extends Prodotto {

	private String dataScadenza;
	private int tempConservazione = Requisito.MINTEMPCONSERVA;


	/**
	 * Crea un prodotto alimentare.
	 * Il passaggio di una data di scadenza non valida
	 * causerà la generazione di un'eccezione IllegalArgumentException.
	 * @see Prodotto#Prodotto costruttore Prodotto()
	 * @param codice Codice
	 * @param descrizione Descrizione
	 * @param prezzo Prezzo
	 * @param dataScadenza Data di scadenza
	 * @param tempConservazione Tempo di conservazione espresso in giorni
	 * 
	 */
	public ProdottoAlimentare(int codice, String descrizione, 
			double prezzo, String dataScadenza, int tempConservazione) {
		super(codice, descrizione, prezzo);
		if (isDataScadenzaValida(dataScadenza))
			this.dataScadenza= dataScadenza;
		else
			throw new IllegalArgumentException("ERROR: Data di scadenza"
					+ " non valida");
		if(isTempoConservValido(tempConservazione))
			this.tempConservazione= tempConservazione;
	}

	/**
	 * Dimezza il prezzo del prodotto se sconto applicabile.
	 * Incapsula (solo) il calcolo del prezzo al dettaglio
	 * @return {@inheritDoc}
	 */
	@Override
	public double calcolaPrezzo() {
		double prezzo= super.getPrezzo();

		return isScontoApplicabile(dataScadenza) 
				? prezzo : prezzo/2;
	}
	/**
	 * Incapsula i requisiti di applicabilità di uno sconto.
	 * Se la data di scadenza coincide con la data odierna 
	 * lo sconto è applicabile.
	 * @param dataScadenza Data di scadenza
	 * @return True se lo sconto è applicabile, false altrimenti
	 */
	private static final boolean isScontoApplicabile(String dataScadenza) {
		LocalDate dataScad = Time.getLocalDate(dataScadenza);
		LocalDate dataOdierna = LocalDate.now();
		
		return dataScad.equals(dataOdierna) ? true : false;
	}

	/**
	 * Verifica che il tempo di conservazione
	 * soddisfi i requisiti
	 * @param tempConservazione Tempo di conservazione
	 * @return True se valido, false altrimenti
	 */
	private static final boolean isTempoConservValido(int tempConservazione) {

		return tempConservazione>0;
	}


	private static final boolean isDataScadenzaValida(String dataScadenza) {

		LocalDate scadenza = Time.getLocalDate(dataScadenza);
		LocalDate oggi = LocalDate.now();

		return !scadenza.isBefore(oggi);
	}

	/**
	 * @return Il numero di mesi di conservazione del prodotto
	 */
	public int getTempConservazione() {
		return tempConservazione;
	}

	@Override
	public String toString() {
		return 
				"Alimentare: scadenza=" + dataScadenza + ", "
				+ "conservazione=" + tempConservazione +" mesi"
				+ " " +super.toString();
	}
}