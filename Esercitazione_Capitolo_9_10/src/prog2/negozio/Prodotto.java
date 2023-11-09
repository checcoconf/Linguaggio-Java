package prog2.negozio;

import java.util.Objects;

/**
 * Questa classe fornisce l'implementazione comune
 * a tutti i tipi di Prodotto
 * @author pasqualeardimento
 *
 */
public abstract class Prodotto {
	private int codice;
	private String descrizione;
	private double prezzo; // prezzo iniziale del Prodotto

	/**
	 * 
	 * @param codice Codice identificativo
	 * @param descrizione Descrizione
	 * @param prezzo Prezzo - valore minimo 0,0
	 */
	public Prodotto(int codice, String descrizione, double prezzo) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		if (isPrezzoOk(prezzo))
			this.prezzo= prezzo;
	}

	/**
	 * Calcola il prezzo del prodotto al netto
	 * di sconti e promozioni, se previste
	 * @return Il prezzo del prodotto
	 */
	public abstract double calcolaPrezzo();

	/**
	 * @return Il codice del prodotto
	 */
	public int getCodice() {
		return codice;
	}

	/**
	 * @return La descrizione del prodotto
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Controlla che il prezzo soddisfi i requisiti.
	 * Non lavora su variabili di istanze (statico).
	 * Non ridefinibile per cui la sua invocazione
	 * non può produrre effetti collaterali
	 * nei costruttori delle sottoclassi di Prodotto
	 * @param prezzo Prezzo
	 * @return true se il prezzo soddisfa i requisiti, false altrimenti
	 */
	private static final boolean isPrezzoOk(double prezzo) {
		boolean prezzoOk = false;
		if (prezzo > Requisito.PREZZOMINIMO)
			prezzoOk = true;
		return prezzoOk;
	}

	/**
	 * Il prezzo (iniziale) del prodotto senza l'applicazione di
	 * sconti e promozioni.
	 * Tale valore non deve essere esposto da Prodotto
	 * @return Restituisce il prezzo del prodotto
	 */
	protected final double getPrezzo() {
		return prezzo;
	}

	/**
	 * Metodo ridefinito in accordo a quanto chiesto dalla traccia
	 * void stampaScontrino(): stampa a video i dettagli dei prodotti presenti nel negozio.
	 */
	@Override
	public String toString() {
		return "codice=" + codice + ", descrizione=" + descrizione + ", prezzo=€" + prezzo;
	}

	/**
	 * in accordo all'implementazione di equals()
	 * il metodo non è ridefinibile nelle classi derivate
	 * al fine di evitare comportamenti inattesi
	 */
	@Override
	public final int hashCode() {
		return Objects.hash(codice);
	}

	/**
	 * Equivalenza calcolata sul campo codice
	 * Il controllo di equivalenza è eseguito solo
	 * tra oggetti che siano istanze di sottoclassi di Prodotto.
	 * Questo metodo non è ridefinibile nelle classi derivate
	 * al fine di evitare comportamenti inattesi
	 */
	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// verifica se obj è un sottotipo di Prodotto
		// true se e solo se obj NON è sottotipo di Prodotto
		if (! (obj instanceof Prodotto))
			return false;
		Prodotto other = (Prodotto) obj;
		return codice == other.codice;
	}

}