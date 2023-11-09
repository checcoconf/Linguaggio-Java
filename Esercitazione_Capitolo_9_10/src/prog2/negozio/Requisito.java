package prog2.negozio;

/**
 * Raccoglie i requisiti informativi delle classi Prodotto
 * e, eventualmente, di Negozio
 * @author pasqualeardimento
 *
 */
final class Requisito {

	// *********	PRODOTTO	********* 
	static final double PREZZOMINIMO=0.0;
	// *********	FINE	********* 

	// *********	PRODOTTO SCONTATO	********* 
	static final double MINSCONTO=0.01;
	static final double MAXSCONTO=0.75;
	static final double DEFAULTSCONTO=0.01;
	// *********	FINE	********* 
	
	// *********	PRODOTTO ALIMENTARE	********* 
	static final int MINTEMPCONSERVA=1;
	// *********	FINE	********* 
	
	// *********	PRODOTTO ELETTRONICO	********* 
	static final int MINTEMPGARANZIA=2;
	static final int MAXTEMPGARANZIA=24;
	static final int DEFAULTMINGARANZIA=2;
	static final double SOVRAPREZZO=1.2;
	static final int SOGLIASOVRAPREZZO=12;
	// *********	FINE	********* 

}