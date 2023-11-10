package test;

import negozio.Negozio;
import negozio.PrincipioNutritivo;
import negozio.ProdottoAlimentare;
import negozio.ProdottoElettronico;

/**
 * La classe TestNegozio è utilizzata per testare il funzionamento della classe Negozio 
 * e delle sue classi associate.
 */
class TestNegozio {

	/**
	 * Il metodo main esegue una serie di test per la classe Negozio 
	 * e le sue classi associate.
	 * @param args gli argomenti della riga di comando
	 */
	public static void main(String[] args) {

		ProdottoAlimentare P1 = new ProdottoAlimentare("1", 10, PrincipioNutritivo.GRASSI, 1);
		
		ProdottoAlimentare P2 = new ProdottoAlimentare("2",8, PrincipioNutritivo.VITAMINE, -2);
		
		ProdottoElettronico P3 = new ProdottoElettronico("1",1.80,4);
		
		ProdottoElettronico P4 = new ProdottoElettronico("3",10,20);
		
		
		Negozio negozio = new Negozio();
		
		negozio.addProdotto(P1);
		negozio.addProdotto(P2);
		negozio.addProdotto(P3);
		negozio.addProdotto(P4);
		
		System.out.println("Il totale dei prodotti è: "+negozio.calcolaTotale()+ " €");	
	}
}
