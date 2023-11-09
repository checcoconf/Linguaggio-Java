package prog2.negozio;

/**
 * Classe che rappresenta una fattura
 * Implementa l'interfaccia Pagamento
 * @author pasqualeardimento
 *
 */
public class Fattura implements Pagamento{
	private int quantita;
	private double prezzoPerArticolo;
	
	/**
	 * 
	 * @param quantita Quantita
	 * @param prezzoPerArticolo Prezzo per singolo articolo
	 */
	public Fattura(int quantita, double prezzoPerArticolo) {
		super();
		this.quantita = quantita;
		this.prezzoPerArticolo = prezzoPerArticolo;
	}
	
	@Override
	public double calcolaImporto() {
		return quantita* prezzoPerArticolo;
	}

}