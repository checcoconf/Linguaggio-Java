package prog2.negozio;

/**
 * Rappresenta un prodotto elettronico
 * @author pasqualeardimento
 *
 */
public class ProdottoElettronico extends Prodotto {
	private int garanzia= Requisito.DEFAULTMINGARANZIA;

	/**
	 * @see Prodotto#Prodotto costruttore Prodotto()
	 * @param codice Codice
	 * @param descrizione Descrizione
	 * @param prezzo Prezzo
	 * @param garanzia Garanzia
	 */
	public ProdottoElettronico(int codice, String descrizione, 
			double prezzo, int garanzia) {
		super(codice, descrizione, prezzo);
		if (garanzia>= Requisito.MINTEMPGARANZIA
				&& garanzia <= Requisito.MAXTEMPGARANZIA)
			this.garanzia= garanzia;
	}

	/**
	 * @return the garanzia
	 */
	public int getGaranzia() {
		return garanzia;
	}

	/**
	 * Calcolo del prezzo in dipendenza della garanzia.
	 * Se garanzia superiore ai 12 mesi il prezzo aumenta del 10%.
	 */
	@Override
	public double calcolaPrezzo() {
		double prezzo = super.getPrezzo();
		if (getGaranzia()> Requisito.SOGLIASOVRAPREZZO) {
			prezzo *= Requisito.SOVRAPREZZO;
		}
		return prezzo;
	}

	@Override
	public String toString() {
		return "Elettronico: garanzia=" + garanzia + " mesi" +
				" "+ super.toString();
	}

}