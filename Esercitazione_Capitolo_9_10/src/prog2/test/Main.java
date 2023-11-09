package prog2.test;

/* necessario indicare nel file module-info.java
    il nome del modulo richiesto */
import prog2.negozio.Negozio;
import prog2.negozio.ProdottoAlimentare;
import prog2.negozio.ProdottoElettronico;
import prog2.negozio.ProdottoScontato;

class Main {

	/**
	 * utilizza i metodi della libreria negoziprodotti.jar
	 * @param args Argomenti a linea di comando non richiesti
	 */
	public static void main(String[] args) {
		// un prodotto generico NON deve essere istanziabile
		// errore di compilazione
		//Prodotto prod = new Prodotto(5, "prodotto generico", 3.0);

		Negozio negozio = new Negozio();

		try {
			ProdottoAlimentare prodA = new 
					ProdottoAlimentare(1, "crackers", 3.0, "2023-11-02", 2);
			negozio.addProdotto(prodA);
		}
		catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
		ProdottoElettronico prodEl = 
				new ProdottoElettronico(2, "smartphone", 5.5, 14);
		ProdottoScontato prodS= 
				new ProdottoScontato(2, "prosciutto crudo", 3.55, 0.50);
		ProdottoScontato prodS2= 
				new ProdottoScontato(3, "prosciutto crudo", 3.55, 0.50);
		ProdottoAlimentare prodAl= 
				new ProdottoAlimentare(3, "prosciutto cotto", 2.80, 
						"2023-11-11", 7);
		ProdottoAlimentare prodAl2= 
				new ProdottoAlimentare(4, "prosciutto cotto", 2.80, 
						"2023-11-11", 7);
		try {
			ProdottoAlimentare prodAl3= 
					new ProdottoAlimentare(4, "salame ungherese", 2.50, 
							"2023-11-03", 7);
			negozio.addProdotto(prodAl3);
		}
		catch(IllegalArgumentException ex) {
			ex.getMessage();
		}


		negozio.addProdotto(prodEl);
		negozio.addProdotto(prodS);
		negozio.addProdotto(prodS2);
		negozio.addProdotto(prodAl);
		negozio.addProdotto(prodAl2);
		//negozio.addProdotto(prod);

		System.out.printf("%.2f%n",negozio.calcolaTotale());
		negozio.stampaScontrino();
	}

}