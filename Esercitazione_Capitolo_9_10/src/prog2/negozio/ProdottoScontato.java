package prog2.negozio;

/**
 * Rappresenta un prodotto scontato
 * @author pasqualeardimento
 *
 */
public class ProdottoScontato extends Prodotto {
	private double percentualeSconto;

	/**
	 * @see Prodotto#Prodotto costruttore Prodotto()
	 * @param codice Codice
	 * @param descrizione Descrizione
	 * @param prezzo Prezzo
	 * @param percentualeSconto Percentuale di sconto
	 */
	public ProdottoScontato(int codice, String descrizione, 
			double prezzo, double percentualeSconto) {
		super(codice, descrizione, prezzo);
		if (percentualeSconto>=Requisito.MINSCONTO
				&& percentualeSconto <= Requisito.MAXSCONTO)
			this.percentualeSconto= percentualeSconto;
		else
			this.percentualeSconto= Requisito.MINSCONTO;
	}

	/**
	 * Calcola il prezzo in base alla percentuale di sconto
	 */
	@Override
	public double calcolaPrezzo() {
		return super.getPrezzo()*percentualeSconto;
	}

	@Override
	public String toString() {
		return "Scontato: percentualeSconto=" + percentualeSconto +
				" " +super.toString();
	}

}