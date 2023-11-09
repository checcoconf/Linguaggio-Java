package prog2.negozio;

/**
 * L'interfaccia Pagamento definisce
 * tutte le operazioni di pagamento
 * all'interno di un Negozio
 * Possibili future azioni da aggiungere potrebbero essere:
 * generazione ricevuta; notifica pagamento; 
 * registrazione pagamento; ...
 * @author pasqualeardimento
 *
 */
public interface Pagamento {
	/**
	 * Calcola l'importo da pagare
	 * @return Importo da pagare
	 */
	public double calcolaImporto();
}