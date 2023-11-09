package negozio;

/**
 * La classe ProdottoElettronico rappresenta 
 * un tipo di prodotto elettronico all'interno di un negozio.
 * @author checcoconf
 */
public class ProdottoElettronico extends Prodotto {
	
	private int garanzia;

	/**
	 * Costruisce un nuovo oggetto ProdottoElettronico con il codice, il prezzo iniziale 
	 * e la garanzia specificati.
	 * @param codice il codice del prodotto elettronico
	 * @param prezzoIniziale il prezzo iniziale del prodotto elettronico
	 * @param garanzia la durata della garanzia del prodotto elettronico
	 */
	public ProdottoElettronico(String codice, double prezzoIniziale, int garanzia) {
		super(codice, prezzoIniziale);
		if(isGaranziaOk(garanzia)) {
			this.garanzia = garanzia;
		}
	}

	@Override
	/**
	 * Calcola il costo del prodotto elettronico considerando un aumento del prezzo 
	 * se la garanzia è maggiore della metà del massimo tempo di garanzia consentito.
	 * @return il costo del prodotto elettronico
	 */
	double calcolaCosto() {
		double prezzo = getPrezzoIniziale();
		
		if (garanzia > Requisito.MAXTEMPGARANZIA/2) {
			prezzo *=  1.1; // 10% in più
		}
		return prezzo;
	}
	
	/**
	 * Controlla se la durata della garanzia specificata è compresa 
	 * nell'intervallo consentito e imposta la garanzia al valore predefinito se non lo è.
	 * @param garanzia la durata della garanzia da controllare
	 * @return true se la garanzia è nell'intervallo consentito, altrimenti false
	 */
	private static final boolean isGaranziaOk(double garanzia) {
		boolean garanziaOk = false;
		if (garanzia >= Requisito.MINTEMPGARANZIA && garanzia <= Requisito.MAXTEMPGARANZIA) {
			garanziaOk = true;
		}	
		else {
			garanzia = Requisito.DEFAULTMINGARANZIA;
		}
		return garanziaOk;
	}
}
