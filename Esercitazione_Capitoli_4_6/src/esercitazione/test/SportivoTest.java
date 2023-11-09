/**
 * La classe SportivoTest è progettata per testare le funzionalità della classe Sportivo
 * e stampare varie informazioni sugli oggetti Sportivo.
 * 
 * Per utilizzare correttamente questa classe, passare il numero di sportivi come argomento
 * sulla riga di comando quando si avvia il programma.
 *
 * @author Francesco Conforti
 * @version 1.0
 */

package esercitazione.test;

import java.util.Date;
import java.util.Scanner;
import esercitazioni.entity.Sportivo;

public class SportivoTest {

    /**
     * Numero di sportivi da gestire.
     */
    private final int nSportivo;

    /**
     * Array di oggetti Sportivo.
     */
    private Sportivo[] top30;

    /**
     * Oggetto Scanner per l'input da tastiera.
     */
    private static Scanner input = new Scanner(System.in);

    /**
     * Metodo principale che avvia il programma.
     * @param args Argomenti passati sulla riga di comando.
     */
    public static void main(String[] args) {
        if (args.length>0) {
            SportivoTest test = new SportivoTest(Integer.parseInt(args[0]));
            
            System.out.println("\nStampa degli sportivi utilizzando il for tradizionale");
            test.stampaSportivo1();
            
            System.out.println("\nStampa degli sportivi utilizzando il for ottimizzato");
            test.stampaSportivo2();
            
            System.out.println("\nStampa il cognome degli sportivi in ennesima posizione");
            test.stampaCognomeEnnesimaPosizione();
            
            System.out.println("\nStampa \"cognome CLASSIFICATO (rank)\"");
            test.stampaCognomeRank();
            
            System.out.println("\nStampa per tale sportivo il risultato del metodo getDataDiIscrizione()");
            test.nuovoSportivo();
            
            System.out.println("");
            test.stampaNumeroSportivoSenzaCognome();
        
        }else {
            System.err.print("|ERRORE|: impossibile inserire "+ Integer.parseInt(args[0])+" sportivi!");
        }   
    }

    /**
     * Costruttore per inizializzare la classe SportivoTest.
     * @param nSportivo Numero di sportivi da gestire.
     */
    public SportivoTest(int nSportivo) {
        
        this.nSportivo = nSportivo;
        top30 = new Sportivo[nSportivo];

        String cognome;
        int rank;
        Date data = new Date();
        for (int i = 0; i < nSportivo; ++i) {
            System.out.print("Inserisci il cognome: ");
            cognome = input.next();
            System.out.print("Inserisci il rank: ");
            rank = input.nextInt();
            top30[i] = new Sportivo(cognome,rank, data);
        }
    }
    
    /**
     * Stampa gli sportivi utilizzando un ciclo for tradizionale.
     */
    public void stampaSportivo1() {
        for (int i = 0; i < nSportivo; i++){
            char lettera = (char) ('a' + i);
            System.out.println(lettera+". "+top30[i].getCognome()+" "+top30[i].getRank()+" "+top30[i].getDataDiIscrizione());
        }
    }
    
    /**
     * Stampa gli sportivi utilizzando un ciclo for ottimizzato.
     */
    public void stampaSportivo2() {
        char lettera = 'a';
        for (Sportivo S : top30) {
            System.out.println(lettera+". "+S.getCognome()+" "+S.getRank()+" "+S.getDataDiIscrizione());
            lettera++;
        }
        
    }
    
    /**
     * Stampa il cognome degli sportivi in una specifica posizione.
     */
    public void stampaCognomeEnnesimaPosizione() {
        System.out.print("Inserisci un numero: ");
        int n = input.nextInt();
        
        String risultato = (n > 0 && n <= nSportivo) ? 
                top30[n-1].getCognome():
                    "Nessuno sportivo attualmente presente in " + n +" posizione";
        
        System.out.println("Stampa del cognome in ennesima posizione: "+risultato);

    }
    
    /**
     * Stampa il cognome e la classifica degli sportivi.
     */
    public void stampaCognomeRank() {
        char lettera = 'a';
        for (int i = 0; i < nSportivo; i++) {
            switch(top30[i].getLetterRanking(top30[i].getRank())) {
                case 'A':
                case 'B':
                case 'C':
                     System.out.println(lettera+". " + top30[i].getCognome() + " Classificato ("+top30[i].getLetterRanking(top30[i].getRank())+")");
                     break;
                default:
                    System.out.println(lettera+". " +top30[i].getCognome() + " NON Classificato ("+top30[i].getLetterRanking(top30[i].getRank())+")");
                     break;        
            }
            lettera++;
        }
    }
    
    /**
     * Aggiunge un nuovo oggetto Sportivo e stampa la sua data di iscrizione.
     */
    public void nuovoSportivo() {
        
        String cognome;
        int rank;
        System.out.print("Inserisci il cognome: ");
        cognome = input.next();
        System.out.print("Inserisci il rank: ");
        rank = input.nextInt();
        
        Date data = new Date();
        
        Sportivo S = new Sportivo(cognome,rank,data);
        
        System.out.println(S.getDataDiIscrizione());
        
    }
    
    /**
     * Stampa il numero di sportivi senza cognome specificato.
     */
    public void stampaNumeroSportivoSenzaCognome() {
        
        int cont = 0;
        
        for (int i = 0; i < nSportivo; i++) {
            if (top30[i].getCognome() == "") {
                cont++;
            }
        }
        System.out.println("Il numero di sportivi senza cognome specificato è: "+cont);
        
    }
}
